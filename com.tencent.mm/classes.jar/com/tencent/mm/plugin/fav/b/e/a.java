package com.tencent.mm.plugin.fav.b.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.f;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.network.p.a;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class a
  implements com.tencent.mm.plugin.fav.a.p
{
  private Queue<com.tencent.mm.plugin.fav.a.c> ftp;
  private Map<String, f.a> ftr;
  private boolean ftt;
  public int ftu;
  private long ftv;
  public MTimerHandler fty;
  public com.tencent.mm.network.p lHL;
  private g.a lPx;
  private boolean running;
  private Map<String, a> wIi;
  private Set<String> wIj;
  private boolean wIk;
  private int wIl;
  private boolean wIm;
  private Runnable wIn;
  
  public a()
  {
    AppMethodBeat.i(101592);
    this.running = false;
    this.ftu = 0;
    this.ftv = 0L;
    this.ftt = false;
    this.ftp = new LinkedList();
    this.ftr = new HashMap();
    this.wIi = new HashMap();
    this.wIj = new HashSet();
    this.wIl = 0;
    this.wIm = true;
    this.lHL = new p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(101584);
        boolean bool;
        com.tencent.mm.plugin.fav.a.c localc;
        try
        {
          bool = NetStatusUtil.isWifi(MMApplicationContext.getContext());
          Log.i("MicroMsg.Fav.FavCdnService", "onNetworkChange st:%d isWifi:%B, lastIsWifi:%B", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(bool), Boolean.valueOf(a.a(a.this)) });
          if ((paramAnonymousInt != 4) && (paramAnonymousInt != 6))
          {
            a.a(a.this, bool);
            AppMethodBeat.o(101584);
            return;
          }
          if ((!a.a(a.this)) || (bool)) {
            break label472;
          }
          a locala1 = a.this;
          Log.i("MicroMsg.Fav.FavCdnService", "pauseAll");
          localCursor = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().djR();
          if ((localCursor != null) && (localCursor.moveToFirst()))
          {
            while (localCursor.moveToNext())
            {
              localc = new com.tencent.mm.plugin.fav.a.c();
              localc.convertFrom(localCursor);
              Log.i("MicroMsg.Fav.FavCdnService", "pauseAll, pauseUpload dataId:%s", new Object[] { localc.field_dataId });
              localc.field_status = 4;
              ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
              f.bkg().Vy(localc.field_dataId);
              a.h(((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().aAb(localc.field_dataId));
              locala1.aAf(localc.field_dataId);
            }
            localCursor.close();
          }
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.Fav.FavCdnService", localException, "", new Object[0]);
          AppMethodBeat.o(101584);
          return;
        }
        Cursor localCursor = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().djS();
        if ((localCursor != null) && (localCursor.moveToFirst())) {
          while (localCursor.moveToNext())
          {
            localc = new com.tencent.mm.plugin.fav.a.c();
            localc.convertFrom(localCursor);
            Log.i("MicroMsg.Fav.FavCdnService", "pauseAll, pauseDownload dataId:%s", new Object[] { localc.field_dataId });
            localc.field_status = 4;
            ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
            f.bkg().Vz(localc.field_dataId);
            a.h(((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().aAb(localc.field_dataId));
            localException.aAf(localc.field_dataId);
          }
        }
        if (localCursor != null) {
          localCursor.close();
        }
        label472:
        if ((!a.a(a.this)) && (bool))
        {
          a locala2 = a.this;
          Log.i("MicroMsg.Fav.FavCdnService", "startAll");
          ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().startAll();
          locala2.run();
        }
        a.a(a.this, bool);
        AppMethodBeat.o(101584);
      }
    };
    this.wIn = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101587);
        long l = System.currentTimeMillis() - a.d(a.this);
        if (a.e(a.this))
        {
          if (l < 300000L)
          {
            AppMethodBeat.o(101587);
            return;
          }
          Log.e("MicroMsg.Fav.FavCdnService", "klem ERR: Try Run service runningFlag:" + a.e(a.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + a.e(a.this));
        }
        Log.i("MicroMsg.Fav.FavCdnService", "do run cdn job, wait time %d", new Object[] { Long.valueOf(l) });
        a.f(a.this);
        a.g(a.this);
        a.b(a.this);
        a.h(a.this);
        a.i(a.this).startTimer(100L);
        AppMethodBeat.o(101587);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(101588);
        String str = super.toString() + "|run";
        AppMethodBeat.o(101588);
        return str;
      }
    };
    this.fty = new MTimerHandler(com.tencent.mm.kernel.h.aHJ().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(101589);
        try
        {
          a.j(a.this);
          AppMethodBeat.o(101589);
          return false;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.Fav.FavCdnService", localException, "", new Object[0]);
          }
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(101590);
        String str = super.toString() + "|scenePusher";
        AppMethodBeat.o(101590);
        return str;
      }
    }, false);
    this.lPx = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(101591);
        if (paramAnonymousc != null) {
          Log.i("MicroMsg.Fav.FavCdnService", "cdn transfer callback, mediaid=%s, totallen=%d, offset=%d", new Object[] { paramAnonymousc.mediaId, Long.valueOf(paramAnonymousc.field_toltalLength), Long.valueOf(paramAnonymousc.field_finishedLength) });
        }
        Object localObject1 = "";
        if (paramAnonymousc != null) {
          localObject1 = paramAnonymousc.mediaId;
        }
        while ((paramAnonymousInt == -21006) || (paramAnonymousInt == -21005))
        {
          a.a(a.this, (String)localObject1);
          AppMethodBeat.o(101591);
          return 0;
          if (paramAnonymousd != null) {
            localObject1 = paramAnonymousd.mediaId;
          }
        }
        if (Util.isNullOrNil((String)localObject1)) {}
        for (;;)
        {
          localObject1 = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().aAb(paramAnonymousString);
          if (localObject1 == null)
          {
            Log.e("MicroMsg.Fav.FavCdnService", "klem onCdnCallback info null");
            a.a(a.this, paramAnonymousString);
            AppMethodBeat.o(101591);
            return 0;
          }
          if (paramAnonymousInt != 0)
          {
            Log.w("MicroMsg.Fav.FavCdnService", "cdn transfer callback, startRet=%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            com.tencent.mm.plugin.report.service.h.IzE.a(10660, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_type), Integer.valueOf(paramAnonymousInt) });
            ((com.tencent.mm.plugin.fav.a.c)localObject1).field_status = 4;
            ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().a((com.tencent.mm.plugin.fav.a.c)localObject1, new String[0]);
            a.i((com.tencent.mm.plugin.fav.a.c)localObject1);
            a.a(a.this, paramAnonymousString);
          }
          do
          {
            for (;;)
            {
              AppMethodBeat.o(101591);
              return 0;
              if (paramAnonymousc == null) {
                break;
              }
              ((com.tencent.mm.plugin.fav.a.c)localObject1).field_offset = ((int)paramAnonymousc.field_finishedLength);
              ((com.tencent.mm.plugin.fav.a.c)localObject1).field_totalLen = ((int)paramAnonymousc.field_toltalLength);
              ((com.tencent.mm.plugin.fav.a.c)localObject1).field_status = 1;
              ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().a((com.tencent.mm.plugin.fav.a.c)localObject1, new String[0]);
            }
          } while (paramAnonymousd == null);
          Object localObject2;
          if (paramAnonymousd.field_retCode >= 0)
          {
            ((com.tencent.mm.plugin.fav.a.c)localObject1).field_status = 3;
            Object localObject3;
            if (1 == ((com.tencent.mm.plugin.fav.a.c)localObject1).field_type)
            {
              paramAnonymousc = ((com.tencent.mm.plugin.fav.a.c)localObject1).field_path + ".temp";
              localObject3 = ((com.tencent.mm.plugin.fav.a.c)localObject1).field_path;
              paramAnonymousInt = ((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataType;
              if ((paramAnonymousc != null) && (localObject3 != null)) {}
            }
            for (;;)
            {
              ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().a((com.tencent.mm.plugin.fav.a.c)localObject1, new String[0]);
              a.a((com.tencent.mm.plugin.fav.a.c)localObject1, paramAnonymousd);
              ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().b((com.tencent.mm.plugin.fav.a.c)localObject1, new String[] { "dataId" });
              a.k(a.this).remove(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId);
              Log.i("MicroMsg.Fav.FavCdnService", "transfer done, mediaid=%s, md5=%s aeskey=%s completeInfo=%s", new Object[] { paramAnonymousd.mediaId, paramAnonymousString, paramAnonymousd.field_aesKey, paramAnonymousd.toString() });
              a.a(a.this, paramAnonymousString);
              com.tencent.mm.plugin.report.service.h.IzE.a(10625, new Object[] { Integer.valueOf(1), paramAnonymousd.field_fileId, "", paramAnonymousd.field_transInfo });
              break;
              if ((paramAnonymousInt == -2) && (!a.atA(paramAnonymousc)) && (a.fW(paramAnonymousc, (String)localObject3)))
              {
                Log.i("MicroMsg.Fav.FavCdnService", "renameAndCopyFile write amr head ok!");
              }
              else
              {
                localObject2 = new q(paramAnonymousc);
                localObject3 = new q((String)localObject3);
                if (((q)localObject2).ifE())
                {
                  Log.i("MicroMsg.Fav.FavCdnService", "rename file suc:%b, old:%s, new:%s", new Object[] { Boolean.valueOf(((q)localObject2).aj((q)localObject3)), paramAnonymousc, localObject3 });
                  continue;
                  ((com.tencent.mm.plugin.fav.a.c)localObject1).field_cdnKey = paramAnonymousd.field_aesKey;
                  ((com.tencent.mm.plugin.fav.a.c)localObject1).field_cdnUrl = paramAnonymousd.field_fileId;
                }
              }
            }
          }
          Log.e("MicroMsg.Fav.FavCdnService", "transfer error, mediaid=%s, retCode:%d", new Object[] { paramAnonymousd.mediaId, Integer.valueOf(paramAnonymousd.field_retCode) });
          paramAnonymousc = (a.a)a.k(a.this).get(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId);
          if (paramAnonymousc != null) {
            paramAnonymousc.errCode = paramAnonymousd.field_retCode;
          }
          if (-6101 == paramAnonymousd.field_retCode)
          {
            ((com.tencent.mm.plugin.fav.a.c)localObject1).field_extFlag |= 0x1;
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(141L, 1L, 1L, true);
            localObject2 = paramAnonymousd.mediaId;
            if (paramAnonymousc != null)
            {
              paramAnonymousInt = paramAnonymousc.mED;
              label804:
              Log.e("MicroMsg.Fav.FavCdnService", "transfer error, mediaid=%s, retCode:-6101,try time = %d,info.field_type: %d , info.field_dataType: %d", new Object[] { localObject2, Integer.valueOf(paramAnonymousInt), Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_type), Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataType) });
            }
          }
          for (;;)
          {
            ((com.tencent.mm.plugin.fav.a.c)localObject1).field_status = 4;
            com.tencent.mm.plugin.report.service.h.IzE.a(10660, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_type), Integer.valueOf(paramAnonymousd.field_retCode) });
            ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().a((com.tencent.mm.plugin.fav.a.c)localObject1, new String[0]);
            a.i((com.tencent.mm.plugin.fav.a.c)localObject1);
            break;
            paramAnonymousInt = 1;
            break label804;
            switch (paramAnonymousd.field_retCode)
            {
            default: 
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(141L, 0L, 1L, true);
              break;
            case -10003: 
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(141L, 2L, 1L, true);
              break;
            case -10005: 
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(141L, 3L, 1L, true);
              break;
            case -21000: 
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(141L, 4L, 1L, true);
              break;
            case -21009: 
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(141L, 5L, 1L, true);
              break;
            case -21014: 
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(141L, 6L, 1L, true);
              break;
            case -21020: 
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(141L, 7L, 1L, true);
              break;
            case -5103015: 
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(141L, 8L, 1L, true);
            }
          }
          paramAnonymousString = (String)localObject1;
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.wIk = NetStatusUtil.isWifi(MMApplicationContext.getContext());
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().a(this.lHL);
    AppMethodBeat.o(101592);
  }
  
  private static int a(com.tencent.mm.plugin.fav.a.c paramc, int paramInt)
  {
    AppMethodBeat.i(101601);
    if (paramc.field_totalLen > 26214400)
    {
      paramInt = com.tencent.mm.i.a.iTZ;
      AppMethodBeat.o(101601);
      return paramInt;
    }
    if ((paramc.field_extFlag & 0x1) == 0)
    {
      AppMethodBeat.o(101601);
      return paramInt;
    }
    Log.w("MicroMsg.Fav.FavCdnService", "NEED To Exchange Type, defType %d", new Object[] { Integer.valueOf(paramInt) });
    if (com.tencent.mm.i.a.MediaType_FAVORITE_VIDEO == paramInt)
    {
      paramInt = com.tencent.mm.i.a.MediaType_FAVORITE_FILE;
      AppMethodBeat.o(101601);
      return paramInt;
    }
    paramInt = com.tencent.mm.i.a.MediaType_FAVORITE_VIDEO;
    AppMethodBeat.o(101601);
    return paramInt;
  }
  
  static boolean atA(String paramString)
  {
    AppMethodBeat.i(101603);
    localObject1 = null;
    String str = null;
    try
    {
      paramString = u.dO(paramString, false);
      str = paramString;
      localObject1 = paramString;
      Object localObject2 = new byte[6];
      str = paramString;
      localObject1 = paramString;
      int i = paramString.read((byte[])localObject2, 0, 6);
      if (i == -1)
      {
        if (paramString != null) {}
        try
        {
          paramString.close();
          AppMethodBeat.o(101603);
          return false;
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.Fav.FavCdnService", paramString, "", new Object[0]);
          }
        }
      }
      str = paramString;
      localObject1 = paramString;
      localObject2 = new String((byte[])localObject2);
      str = paramString;
      localObject1 = paramString;
      Log.i("MicroMsg.Fav.FavCdnService", "head " + (String)localObject2 + "   AmrFileOperator.AMR_NB_HEAD #!AMR\n");
      str = paramString;
      localObject1 = paramString;
      boolean bool = ((String)localObject2).endsWith("#!AMR\n");
      if (paramString != null) {}
      try
      {
        paramString.close();
        AppMethodBeat.o(101603);
        return bool;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.Fav.FavCdnService", paramString, "", new Object[0]);
        }
      }
      try
      {
        ((RandomAccessFile)localObject1).close();
        AppMethodBeat.o(101603);
        throw paramString;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.Fav.FavCdnService", localIOException, "", new Object[0]);
        }
      }
    }
    catch (Exception paramString)
    {
      localObject1 = str;
      Log.printErrStackTrace("MicroMsg.Fav.FavCdnService", paramString, "", new Object[0]);
      if (str != null) {}
      try
      {
        str.close();
        AppMethodBeat.o(101603);
        return false;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.Fav.FavCdnService", paramString, "", new Object[0]);
        }
      }
    }
    finally
    {
      if (localObject1 == null) {}
    }
  }
  
  private void blz()
  {
    AppMethodBeat.i(101596);
    this.ftv = System.currentTimeMillis();
    if ((!this.ftt) && (this.ftp.size() == 0))
    {
      if (e.avA()) {
        break label88;
      }
      Log.e("MicroMsg.Fav.FavCdnService", "klem getNeedRunInfo sdcard not available");
      afk();
    }
    label88:
    Object localObject1;
    Object localObject2;
    while ((!this.ftt) && (this.ftp.size() <= 0))
    {
      afk();
      Log.i("MicroMsg.Fav.FavCdnService", "klem No Data Any More , Stop Service");
      AppMethodBeat.o(101596);
      return;
      if (((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage() != null)
      {
        localObject1 = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().djQ();
        if ((localObject1 != null) && (((List)localObject1).size() != 0))
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (com.tencent.mm.plugin.fav.a.c)((Iterator)localObject1).next();
            if (this.ftr.containsKey(((com.tencent.mm.plugin.fav.a.c)localObject2).field_dataId))
            {
              Log.d("MicroMsg.Fav.FavCdnService", "File is Already running:" + ((com.tencent.mm.plugin.fav.a.c)localObject2).field_dataId);
            }
            else
            {
              this.ftp.add(localObject2);
              this.ftr.put(((com.tencent.mm.plugin.fav.a.c)localObject2).field_dataId, null);
            }
          }
          Log.i("MicroMsg.Fav.FavCdnService", "klem GetNeedRun procing:" + this.ftr.size() + ",send:" + this.ftp.size() + "]");
          this.ftp.size();
        }
      }
    }
    if ((!this.ftt) && (this.ftp.size() > 0)) {
      try
      {
        localObject1 = (com.tencent.mm.plugin.fav.a.c)this.ftp.poll();
        if ((localObject1 != null) && (!Util.isNullOrNil(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId)))
        {
          localObject2 = (a)this.wIi.get(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId);
          if (localObject2 == null)
          {
            localObject2 = new a((byte)0);
            ((a)localObject2).mED = 1;
            ((a)localObject2).wIr = Util.nowMilliSecond();
            this.wIi.put(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId, localObject2);
            if (((com.tencent.mm.plugin.fav.a.c)localObject1).field_type != 0) {
              break label866;
            }
            Log.i("MicroMsg.Fav.FavCdnService", "check favCDN:force job[can upload], localid %d, dataid %s, type %d, dataType %d", new Object[] { Long.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_favLocalId), ((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId, Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_type), Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataType) });
            i = 1;
            if (i == 0) {
              break label1427;
            }
            this.ftt = true;
            if (localObject1 == null) {
              break label1406;
            }
            Log.i("MicroMsg.Fav.FavCdnService", "doTransfer, md5:%s", new Object[] { ((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId });
            localObject2 = new g();
            ((g)localObject2).taskName = "task_FavCdnService";
            ((g)localObject2).iUG = this.lPx;
            ((g)localObject2).field_mediaId = ((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId;
            if (((com.tencent.mm.plugin.fav.a.c)localObject1).field_type != 0) {
              break label1282;
            }
            ((g)localObject2).gbt = true;
            ((g)localObject2).field_priority = com.tencent.mm.i.a.iTT;
            ((g)localObject2).field_needStorage = true;
            ((g)localObject2).field_totalLen = ((com.tencent.mm.plugin.fav.a.c)localObject1).field_totalLen;
            ((g)localObject2).field_aesKey = ((com.tencent.mm.plugin.fav.a.c)localObject1).field_cdnKey;
            ((g)localObject2).field_fileId = ((com.tencent.mm.plugin.fav.a.c)localObject1).field_cdnUrl;
            ((g)localObject2).field_isStreamMedia = ((com.tencent.mm.plugin.fav.a.c)localObject1).djx();
            ((g)localObject2).field_fullpath = u.n(((com.tencent.mm.plugin.fav.a.c)localObject1).field_path, false);
            ((g)localObject2).field_use_multithread = false;
            if (!u.agG(((com.tencent.mm.plugin.fav.a.c)localObject1).field_path)) {
              Log.e("MicroMsg.Fav.FavCdnService", "favcdnservice upload, but file not exsit,filePath = %s, fakePath:%s", new Object[] { ((g)localObject2).field_fullpath, ((com.tencent.mm.plugin.fav.a.c)localObject1).field_path });
            }
            if (!((com.tencent.mm.plugin.fav.a.c)localObject1).djx()) {
              break label1268;
            }
            ((g)localObject2).field_fileType = a((com.tencent.mm.plugin.fav.a.c)localObject1, com.tencent.mm.i.a.MediaType_FAVORITE_VIDEO);
            ((g)localObject2).field_force_aeskeycdn = true;
            ((g)localObject2).field_trysafecdn = false;
            Log.i("MicroMsg.Fav.FavCdnService", "summersafecdn send force_aeskeycdn[%b] trysafecdn[%b]", new Object[] { Boolean.valueOf(((g)localObject2).field_force_aeskeycdn), Boolean.valueOf(((g)localObject2).field_trysafecdn) });
            f.bkg().f((g)localObject2);
            AppMethodBeat.o(101596);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        com.tencent.mm.plugin.fav.a.c localc;
        for (;;)
        {
          int i;
          localc = null;
          continue;
          if ((Util.nowMilliSecond() - ((a)localObject2).wIr > 180000L) && (((a)localObject2).errCode != -6101))
          {
            ((a)localObject2).mED = 1;
            ((a)localObject2).wIr = Util.nowMilliSecond();
            this.wIi.put(localc.field_dataId, localObject2);
          }
          else if (((a)localObject2).mED <= 3)
          {
            ((a)localObject2).mED += 1;
            this.wIi.put(localc.field_dataId, localObject2);
          }
          else
          {
            Log.e("MicroMsg.Fav.FavCdnService", "check favCDN:match transfer limit 3times , localid %d, dataid %s, type %d, dataType %d", new Object[] { Long.valueOf(localc.field_favLocalId), localc.field_dataId, Integer.valueOf(localc.field_type), Integer.valueOf(localc.field_dataType) });
            g(localc);
            i = 0;
            continue;
            label866:
            if ((this.wIj.contains(localc.field_dataId)) || (com.tencent.mm.plugin.fav.a.b.azK(localc.field_dataId)))
            {
              Log.i("MicroMsg.Fav.FavCdnService", "check favCDN:force job[normal], localid %d, dataid %s, type %d, dataType %d", new Object[] { Long.valueOf(localc.field_favLocalId), localc.field_dataId, Integer.valueOf(localc.field_type), Integer.valueOf(localc.field_dataType) });
            }
            else if (!NetStatusUtil.isWifi(MMApplicationContext.getContext()))
            {
              Log.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, NOT WIFI, pause it, localid %d, dataid %s, type %d, dataType %d", new Object[] { Long.valueOf(localc.field_favLocalId), localc.field_dataId, Integer.valueOf(localc.field_type), Integer.valueOf(localc.field_dataType) });
              g(localc);
              i = 0;
            }
            else if (localc.field_type == 0)
            {
              Log.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI & SENDING, not auto limit, localid %d, dataid %s, type %d, dataType %d", new Object[] { Long.valueOf(localc.field_favLocalId), localc.field_dataId, Integer.valueOf(localc.field_type), Integer.valueOf(localc.field_dataType) });
            }
            else if (!this.wIm)
            {
              Log.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI, not auto limit, localid %d, dataid %s, type %d, dataType %d", new Object[] { Long.valueOf(localc.field_favLocalId), localc.field_dataId, Integer.valueOf(localc.field_type), Integer.valueOf(localc.field_dataType) });
              this.wIl = 0;
            }
            else if (this.wIl < 10)
            {
              Log.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI, auto limit %d, current index %d, retryTimes %dlocalid %d, dataid %s, type %d, dataType %d", new Object[] { Integer.valueOf(10), Integer.valueOf(this.wIl), Integer.valueOf(((a)localObject2).mED), Long.valueOf(localc.field_favLocalId), localc.field_dataId, Integer.valueOf(localc.field_type), Integer.valueOf(localc.field_dataType) });
              if (((a)localObject2).mED == 1) {
                this.wIl += 1;
              }
            }
            else
            {
              Log.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI, match auto limit %d", new Object[] { Integer.valueOf(10) });
              i = 0;
              continue;
              label1268:
              ((g)localObject2).field_fileType = a(localc, com.tencent.mm.i.a.MediaType_FAVORITE_FILE);
            }
          }
        }
        label1282:
        ((g)localObject2).gbt = false;
        ((g)localObject2).field_totalLen = localc.field_totalLen;
        ((g)localObject2).field_aesKey = localc.field_cdnKey;
        ((g)localObject2).field_fileId = localc.field_cdnUrl;
        ((g)localObject2).field_priority = com.tencent.mm.i.a.iTU;
        ((g)localObject2).iUG = this.lPx;
        ((g)localObject2).field_fullpath = (u.n(localc.field_path, false) + ".temp");
        ((g)localObject2).field_needStorage = true;
        ((g)localObject2).field_isStreamMedia = localc.djx();
        ((g)localObject2).field_use_multithread = false;
        if (localc.djx()) {}
        for (((g)localObject2).field_fileType = a(localc, com.tencent.mm.i.a.MediaType_FAVORITE_VIDEO);; ((g)localObject2).field_fileType = a(localc, com.tencent.mm.i.a.MediaType_FAVORITE_FILE))
        {
          f.bkg().b((g)localObject2, -1);
          h(localc);
          label1406:
          AppMethodBeat.o(101596);
          return;
        }
        label1427:
        if (this.wIl >= 10)
        {
          afk();
          AppMethodBeat.o(101596);
          return;
        }
        this.fty.startTimer(500L);
      }
    }
    AppMethodBeat.o(101596);
  }
  
  /* Error */
  static boolean fW(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 629
    //   3: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 633	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   10: astore_0
    //   11: aload_1
    //   12: invokestatic 637	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   15: astore_1
    //   16: aload_1
    //   17: astore 6
    //   19: aload_0
    //   20: astore 5
    //   22: sipush 16384
    //   25: newarray byte
    //   27: astore 7
    //   29: aload_1
    //   30: astore 6
    //   32: aload_0
    //   33: astore 5
    //   35: aload_1
    //   36: ldc_w 382
    //   39: invokevirtual 641	java/lang/String:getBytes	()[B
    //   42: invokevirtual 646	java/io/OutputStream:write	([B)V
    //   45: aload_1
    //   46: astore 6
    //   48: aload_0
    //   49: astore 5
    //   51: aload_0
    //   52: aload 7
    //   54: invokevirtual 651	java/io/InputStream:read	([B)I
    //   57: istore_2
    //   58: iload_2
    //   59: iconst_m1
    //   60: if_icmpeq +68 -> 128
    //   63: aload_1
    //   64: astore 6
    //   66: aload_0
    //   67: astore 5
    //   69: aload_1
    //   70: aload 7
    //   72: iconst_0
    //   73: iload_2
    //   74: invokevirtual 654	java/io/OutputStream:write	([BII)V
    //   77: goto -32 -> 45
    //   80: astore 7
    //   82: aload_1
    //   83: astore 6
    //   85: aload_0
    //   86: astore 5
    //   88: ldc 170
    //   90: aload 7
    //   92: ldc_w 355
    //   95: iconst_0
    //   96: anewarray 4	java/lang/Object
    //   99: invokestatic 359	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   102: aload_0
    //   103: ifnull +7 -> 110
    //   106: aload_0
    //   107: invokevirtual 655	java/io/InputStream:close	()V
    //   110: aload_1
    //   111: ifnull +221 -> 332
    //   114: aload_1
    //   115: invokevirtual 656	java/io/OutputStream:close	()V
    //   118: iconst_0
    //   119: istore_3
    //   120: ldc_w 629
    //   123: invokestatic 151	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: iload_3
    //   127: ireturn
    //   128: iconst_1
    //   129: istore_3
    //   130: iload_3
    //   131: istore 4
    //   133: aload_0
    //   134: ifnull +10 -> 144
    //   137: aload_0
    //   138: invokevirtual 655	java/io/InputStream:close	()V
    //   141: iload_3
    //   142: istore 4
    //   144: iload 4
    //   146: istore_3
    //   147: aload_1
    //   148: ifnull -28 -> 120
    //   151: aload_1
    //   152: invokevirtual 656	java/io/OutputStream:close	()V
    //   155: iload 4
    //   157: istore_3
    //   158: goto -38 -> 120
    //   161: astore_0
    //   162: ldc 170
    //   164: aload_0
    //   165: ldc_w 355
    //   168: iconst_0
    //   169: anewarray 4	java/lang/Object
    //   172: invokestatic 359	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   175: iconst_0
    //   176: istore_3
    //   177: goto -57 -> 120
    //   180: astore_0
    //   181: ldc 170
    //   183: aload_0
    //   184: ldc_w 355
    //   187: iconst_0
    //   188: anewarray 4	java/lang/Object
    //   191: invokestatic 359	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   194: iconst_0
    //   195: istore 4
    //   197: goto -53 -> 144
    //   200: astore_0
    //   201: ldc 170
    //   203: aload_0
    //   204: ldc_w 355
    //   207: iconst_0
    //   208: anewarray 4	java/lang/Object
    //   211: invokestatic 359	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   214: goto -104 -> 110
    //   217: astore_0
    //   218: ldc 170
    //   220: aload_0
    //   221: ldc_w 355
    //   224: iconst_0
    //   225: anewarray 4	java/lang/Object
    //   228: invokestatic 359	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   231: iconst_0
    //   232: istore_3
    //   233: goto -113 -> 120
    //   236: astore_1
    //   237: aconst_null
    //   238: astore 6
    //   240: aconst_null
    //   241: astore_0
    //   242: aload_0
    //   243: ifnull +7 -> 250
    //   246: aload_0
    //   247: invokevirtual 655	java/io/InputStream:close	()V
    //   250: aload 6
    //   252: ifnull +8 -> 260
    //   255: aload 6
    //   257: invokevirtual 656	java/io/OutputStream:close	()V
    //   260: ldc_w 629
    //   263: invokestatic 151	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   266: aload_1
    //   267: athrow
    //   268: astore_0
    //   269: ldc 170
    //   271: aload_0
    //   272: ldc_w 355
    //   275: iconst_0
    //   276: anewarray 4	java/lang/Object
    //   279: invokestatic 359	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   282: goto -32 -> 250
    //   285: astore_0
    //   286: ldc 170
    //   288: aload_0
    //   289: ldc_w 355
    //   292: iconst_0
    //   293: anewarray 4	java/lang/Object
    //   296: invokestatic 359	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   299: goto -39 -> 260
    //   302: astore_1
    //   303: aconst_null
    //   304: astore 6
    //   306: goto -64 -> 242
    //   309: astore_1
    //   310: aload 5
    //   312: astore_0
    //   313: goto -71 -> 242
    //   316: astore 7
    //   318: aconst_null
    //   319: astore_1
    //   320: aconst_null
    //   321: astore_0
    //   322: goto -240 -> 82
    //   325: astore 7
    //   327: aconst_null
    //   328: astore_1
    //   329: goto -247 -> 82
    //   332: iconst_0
    //   333: istore_3
    //   334: goto -214 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	337	0	paramString1	String
    //   0	337	1	paramString2	String
    //   57	17	2	i	int
    //   119	215	3	bool1	boolean
    //   131	65	4	bool2	boolean
    //   20	291	5	str1	String
    //   17	288	6	str2	String
    //   27	44	7	arrayOfByte	byte[]
    //   80	11	7	localException1	Exception
    //   316	1	7	localException2	Exception
    //   325	1	7	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   22	29	80	java/lang/Exception
    //   35	45	80	java/lang/Exception
    //   51	58	80	java/lang/Exception
    //   69	77	80	java/lang/Exception
    //   151	155	161	java/io/IOException
    //   137	141	180	java/io/IOException
    //   106	110	200	java/io/IOException
    //   114	118	217	java/io/IOException
    //   6	11	236	finally
    //   246	250	268	java/io/IOException
    //   255	260	285	java/io/IOException
    //   11	16	302	finally
    //   22	29	309	finally
    //   35	45	309	finally
    //   51	58	309	finally
    //   69	77	309	finally
    //   88	102	309	finally
    //   6	11	316	java/lang/Exception
    //   11	16	325	java/lang/Exception
  }
  
  private static void g(com.tencent.mm.plugin.fav.a.c paramc)
  {
    AppMethodBeat.i(101597);
    if (1 == paramc.field_type) {}
    for (paramc.field_status = 2;; paramc.field_status = 4)
    {
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().a(paramc, new String[] { "dataId" });
      h(paramc);
      AppMethodBeat.o(101597);
      return;
    }
  }
  
  static void h(com.tencent.mm.plugin.fav.a.c paramc)
  {
    AppMethodBeat.i(101605);
    if (paramc.field_type == 0)
    {
      com.tencent.mm.plugin.fav.a.b.b(paramc);
      AppMethodBeat.o(101605);
      return;
    }
    if (paramc.field_type == 1)
    {
      com.tencent.mm.plugin.fav.a.b.c(paramc);
      AppMethodBeat.o(101605);
      return;
    }
    AppMethodBeat.o(101605);
  }
  
  public final void aAa(String paramString)
  {
    AppMethodBeat.i(101599);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(101599);
      return;
    }
    f.bkg().Vy(paramString);
    Log.i("MicroMsg.Fav.FavCdnService", "pause upload md5%s", new Object[] { paramString });
    h(((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().aAb(paramString));
    aAf(paramString);
    AppMethodBeat.o(101599);
  }
  
  final void aAf(String paramString)
  {
    AppMethodBeat.i(101604);
    this.ftt = false;
    this.ftr.remove(paramString);
    pauseDownload(paramString);
    if (this.ftu > 0)
    {
      blz();
      AppMethodBeat.o(101604);
      return;
    }
    Log.i("MicroMsg.Fav.FavCdnService", "klem stopFlag <= 0 , Stop Service");
    afk();
    AppMethodBeat.o(101604);
  }
  
  public final void afk()
  {
    AppMethodBeat.i(101600);
    this.ftp.clear();
    this.ftr.clear();
    this.running = false;
    this.ftt = false;
    AppMethodBeat.o(101600);
  }
  
  public final void azZ(final String paramString)
  {
    AppMethodBeat.i(101594);
    Log.i("MicroMsg.Fav.FavCdnService", "add force job %s", new Object[] { paramString });
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101586);
        a.c(a.this).add(paramString);
        AppMethodBeat.o(101586);
      }
    });
    AppMethodBeat.o(101594);
  }
  
  public final void d(com.tencent.mm.plugin.fav.a.c paramc)
  {
    AppMethodBeat.i(101606);
    if (paramc != null) {
      this.ftp.add(paramc);
    }
    AppMethodBeat.o(101606);
  }
  
  public final void nK(final boolean paramBoolean)
  {
    AppMethodBeat.i(101593);
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101585);
        a.b(a.this, paramBoolean);
        a.b(a.this);
        AppMethodBeat.o(101585);
      }
    });
    AppMethodBeat.o(101593);
  }
  
  public final void pauseDownload(String paramString)
  {
    AppMethodBeat.i(101598);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(101598);
      return;
    }
    if (this.ftr.containsKey(paramString))
    {
      f.bkg().Vz(paramString);
      Log.i("MicroMsg.Fav.FavCdnService", "pause download md5%s", new Object[] { paramString });
      h(((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().aAb(paramString));
      aAf(paramString);
    }
    AppMethodBeat.o(101598);
  }
  
  public final void run()
  {
    AppMethodBeat.i(101595);
    Log.i("MicroMsg.Fav.FavCdnService", "run fav cdn server");
    com.tencent.mm.kernel.h.aHJ().getWorkerHandler().removeCallbacks(this.wIn);
    com.tencent.mm.kernel.h.aHJ().postToWorker(this.wIn);
    AppMethodBeat.o(101595);
  }
  
  final class a
  {
    int errCode = 0;
    int mED;
    long wIr;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.a
 * JD-Core Version:    0.7.0.1
 */