package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.b;
import com.tencent.mm.g.b.a.dv;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.i.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bj.b;
import com.tencent.mm.model.q;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.io.ByteArrayOutputStream;
import java.util.Map;

public final class f
{
  public String doX;
  private g.b fJB;
  String fJD;
  private g.a ibn;
  long isA;
  int isB;
  private String isC;
  public long isD;
  public boolean isE;
  public a isF;
  private h isl;
  boolean isw;
  String isx;
  private long isy;
  long isz;
  private String mediaId;
  long msgId;
  
  public f(long paramLong)
  {
    AppMethodBeat.i(126843);
    this.isw = false;
    this.ibn = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(126841);
        if (paramAnonymousInt != 0)
        {
          ad.w("MicroMsg.NetScenePreloadVideoFake", "%d preload video error startRet[%d]", new Object[] { Integer.valueOf(f.this.hashCode()), Integer.valueOf(paramAnonymousInt) });
          if (f.this.isF != null) {
            f.this.isF.a(f.this, false, 0, 0);
          }
        }
        if (paramAnonymousc != null) {
          ad.d("MicroMsg.NetScenePreloadVideoFake", "%d preload video[%d %d] mediaId[%s]", new Object[] { Integer.valueOf(f.this.hashCode()), Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength), paramAnonymousString });
        }
        if (paramAnonymousd != null)
        {
          ad.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video error [%d]", new Object[] { Integer.valueOf(f.this.hashCode()), Integer.valueOf(paramAnonymousd.field_retCode) });
          if (paramAnonymousd.field_retCode == 0) {
            break label205;
          }
          if (f.this.isF != null) {
            f.this.isF.a(f.this, false, 0, 0);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(126841);
          return 0;
          label205:
          ad.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video download all video file", new Object[] { Integer.valueOf(f.this.hashCode()) });
          f.this.j(f.this.isx, (int)paramAnonymousd.field_fileLength, f.this.fJD);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    this.fJB = new g.b()
    {
      public final void b(String paramAnonymousString, com.tencent.mm.i.d paramAnonymousd)
      {
        AppMethodBeat.i(126842);
        if (paramAnonymousd == null)
        {
          ad.w("MicroMsg.NetScenePreloadVideoFake", "%s onPreload completed but sceneResult is null", new Object[] { Integer.valueOf(f.this.hashCode()) });
          if (f.this.isF != null) {
            f.this.isF.a(f.this, false, 0, 0);
          }
          AppMethodBeat.o(126842);
          return;
        }
        int i = (int)paramAnonymousd.field_recvedBytes;
        int j = (int)paramAnonymousd.field_fileLength;
        ad.i("MicroMsg.NetScenePreloadVideoFake", "%d onPreload Completed [%s] videoInfoName[%s] [%d, %d] videoFormat[%d]", new Object[] { Integer.valueOf(f.this.hashCode()), paramAnonymousString, f.this.isx, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramAnonymousd.field_videoFormat) });
        if ((i > 0) && (j > 0)) {
          f.this.isA = f.d(f.this.isx, i, true);
        }
        boolean bool;
        if (f.this.isF != null)
        {
          paramAnonymousString = f.this.isF;
          f localf = f.this;
          if ((i > 0) && (j > 0))
          {
            bool = true;
            paramAnonymousString.a(localf, bool, i, j);
          }
        }
        else
        {
          f.this.isz = com.tencent.mm.sdk.platformtools.bt.aQJ();
          f.this.GP(paramAnonymousd.XP());
          if (!f.this.isw) {
            break label342;
          }
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 142L, 1L, false);
          if (f.this.isB != 1) {
            break label325;
          }
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 123L, 1L, false);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, paramAnonymousd.field_videoFormat + 240, 1L, false);
          AppMethodBeat.o(126842);
          return;
          bool = false;
          break;
          label325:
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 124L, 1L, false);
        }
        label342:
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 143L, 1L, false);
        AppMethodBeat.o(126842);
      }
    };
    this.msgId = paramLong;
    this.isw = true;
    AppMethodBeat.o(126843);
  }
  
  public f(h paramh, String paramString)
  {
    AppMethodBeat.i(126844);
    this.isw = false;
    this.ibn = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(126841);
        if (paramAnonymousInt != 0)
        {
          ad.w("MicroMsg.NetScenePreloadVideoFake", "%d preload video error startRet[%d]", new Object[] { Integer.valueOf(f.this.hashCode()), Integer.valueOf(paramAnonymousInt) });
          if (f.this.isF != null) {
            f.this.isF.a(f.this, false, 0, 0);
          }
        }
        if (paramAnonymousc != null) {
          ad.d("MicroMsg.NetScenePreloadVideoFake", "%d preload video[%d %d] mediaId[%s]", new Object[] { Integer.valueOf(f.this.hashCode()), Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength), paramAnonymousString });
        }
        if (paramAnonymousd != null)
        {
          ad.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video error [%d]", new Object[] { Integer.valueOf(f.this.hashCode()), Integer.valueOf(paramAnonymousd.field_retCode) });
          if (paramAnonymousd.field_retCode == 0) {
            break label205;
          }
          if (f.this.isF != null) {
            f.this.isF.a(f.this, false, 0, 0);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(126841);
          return 0;
          label205:
          ad.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video download all video file", new Object[] { Integer.valueOf(f.this.hashCode()) });
          f.this.j(f.this.isx, (int)paramAnonymousd.field_fileLength, f.this.fJD);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    this.fJB = new g.b()
    {
      public final void b(String paramAnonymousString, com.tencent.mm.i.d paramAnonymousd)
      {
        AppMethodBeat.i(126842);
        if (paramAnonymousd == null)
        {
          ad.w("MicroMsg.NetScenePreloadVideoFake", "%s onPreload completed but sceneResult is null", new Object[] { Integer.valueOf(f.this.hashCode()) });
          if (f.this.isF != null) {
            f.this.isF.a(f.this, false, 0, 0);
          }
          AppMethodBeat.o(126842);
          return;
        }
        int i = (int)paramAnonymousd.field_recvedBytes;
        int j = (int)paramAnonymousd.field_fileLength;
        ad.i("MicroMsg.NetScenePreloadVideoFake", "%d onPreload Completed [%s] videoInfoName[%s] [%d, %d] videoFormat[%d]", new Object[] { Integer.valueOf(f.this.hashCode()), paramAnonymousString, f.this.isx, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramAnonymousd.field_videoFormat) });
        if ((i > 0) && (j > 0)) {
          f.this.isA = f.d(f.this.isx, i, true);
        }
        boolean bool;
        if (f.this.isF != null)
        {
          paramAnonymousString = f.this.isF;
          f localf = f.this;
          if ((i > 0) && (j > 0))
          {
            bool = true;
            paramAnonymousString.a(localf, bool, i, j);
          }
        }
        else
        {
          f.this.isz = com.tencent.mm.sdk.platformtools.bt.aQJ();
          f.this.GP(paramAnonymousd.XP());
          if (!f.this.isw) {
            break label342;
          }
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 142L, 1L, false);
          if (f.this.isB != 1) {
            break label325;
          }
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 123L, 1L, false);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, paramAnonymousd.field_videoFormat + 240, 1L, false);
          AppMethodBeat.o(126842);
          return;
          bool = false;
          break;
          label325:
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 124L, 1L, false);
        }
        label342:
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 143L, 1L, false);
        AppMethodBeat.o(126842);
      }
    };
    this.isl = paramh;
    this.doX = paramString;
    this.isw = false;
    AppMethodBeat.o(126844);
  }
  
  static int d(String paramString, int paramInt, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(126848);
    s locals = u.Hy(paramString);
    int j;
    if (locals != null)
    {
      j = locals.dyZ;
      if (paramBoolean)
      {
        locals.dyZ = paramInt;
        ad.i("MicroMsg.NetScenePreloadVideoFake", "update video info[%s] preload[%d %d %d] isFinish[%b] ", new Object[] { paramString, Integer.valueOf(j), Integer.valueOf(paramInt), Integer.valueOf(locals.dyZ), Boolean.valueOf(paramBoolean) });
        locals.iud = com.tencent.mm.sdk.platformtools.bt.aQJ();
        locals.dDp = 1025;
        u.f(locals);
        if (!paramBoolean) {
          break label139;
        }
        paramInt -= j;
        label114:
        if (paramInt >= 0) {
          break label149;
        }
        paramInt = i;
      }
    }
    label139:
    label149:
    for (;;)
    {
      AppMethodBeat.o(126848);
      return paramInt;
      locals.dyZ = (j + paramInt);
      break;
      break label114;
      AppMethodBeat.o(126848);
      return paramInt;
    }
  }
  
  private static boolean i(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(126850);
    if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(126850);
      return false;
    }
    o.aMJ();
    paramString2 = t.Hh(paramString2);
    if ((com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramString1)) || (paramInt <= 0) || (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramString2)) || (!com.tencent.mm.vfs.i.fv(paramString2)))
    {
      ad.w("MicroMsg.NetScenePreloadVideoFake", "insert media duplication but args is error.[%d, %s, %s]", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
      AppMethodBeat.o(126850);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).azx().E(paramString1, paramInt, paramString2);
    AppMethodBeat.o(126850);
    return bool;
  }
  
  final void GP(String paramString)
  {
    AppMethodBeat.i(126851);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.isy).append(",");
    localStringBuffer.append(this.isz).append(",");
    localStringBuffer.append(this.isA).append(",");
    localStringBuffer.append(this.isC).append(",");
    localStringBuffer.append(this.isB).append(",");
    try
    {
      long l = this.isA / 1024L / (this.isz - this.isy);
      i = (int)l;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 0;
      }
    }
    localStringBuffer.append(i).append(",");
    localStringBuffer.append(0).append(",");
    localStringBuffer.append(paramString).append(",");
    localStringBuffer.append(this.isl.dyU).append(",");
    localStringBuffer.append(this.isl.fJG).append(",");
    localStringBuffer.append(this.isl.dyW).append(",");
    localStringBuffer.append(this.isl.field_fileId).append(",");
    localStringBuffer.append(this.isl.url).append(",");
    localStringBuffer.append(com.tencent.mm.plugin.video.c.aDi(this.isl.dzb));
    paramString = localStringBuffer.toString();
    ad.d("MicroMsg.NetScenePreloadVideoFake", "%d rpt content[%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    new dv(paramString).aLk();
    AppMethodBeat.o(126851);
  }
  
  public final int a(a parama)
  {
    AppMethodBeat.i(126847);
    this.isF = parama;
    Object localObject;
    int i;
    label187:
    label215:
    String str1;
    int j;
    for (;;)
    {
      try
      {
        ad.i("MicroMsg.NetScenePreloadVideoFake", "%d preload begin msgId[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.msgId) });
        if (this.isw)
        {
          parama = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(this.msgId);
          localObject = bj.Bq(parama.eLs);
          if ((localObject == null) || (((bj.b)localObject).hHe <= 0))
          {
            ad.w("MicroMsg.NetScenePreloadVideoFake", "%d msgsource is null", new Object[] { Integer.valueOf(hashCode()) });
            parama = null;
            if (parama != null)
            {
              if (!w.vF(parama.fJG)) {
                break label1014;
              }
              i = 2;
              this.isB = i;
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 140L, 1L, false);
              if (this.isB == 1) {
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 121L, 1L, false);
              }
            }
            else
            {
              if (this.isl != null) {
                break label1001;
              }
              this.isl = parama;
              if (parama != null) {
                break;
              }
              ad.w("MicroMsg.NetScenePreloadVideoFake", "%d preload task is null", new Object[] { Integer.valueOf(hashCode()) });
              i = 0;
              if (i == 0) {
                continue;
              }
              AppMethodBeat.o(126847);
              return 0;
            }
          }
          else
          {
            str1 = parama.field_imgPath;
            s locals = u.Hy(str1);
            if (locals == null)
            {
              parama = null;
              continue;
            }
            parama = bw.M(locals.aMV(), "msg");
            if (parama == null)
            {
              ad.w("MicroMsg.NetScenePreloadVideoFake", "cdntra parse video recv xml failed");
              parama = null;
              continue;
            }
            String str2 = (String)parama.get(".msg.videomsg.$cdnvideourl");
            if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(str2))
            {
              ad.w("MicroMsg.NetScenePreloadVideoFake", "cdntra parse video recv xml failed");
              parama = null;
              continue;
            }
            j = com.tencent.mm.sdk.platformtools.bt.getInt((String)parama.get(".msg.videomsg.$length"), 0);
            String str3 = (String)parama.get(".msg.videomsg.$md5");
            String str4 = (String)parama.get(".msg.videomsg.$newmd5");
            String str5 = (String)parama.get(".msg.videomsg.$aeskey");
            String str6 = (String)parama.get(".msg.videomsg.$fileparam");
            String str7 = com.tencent.mm.ao.c.a("downvideo", locals.createTime, locals.getUser(), locals.getFileName());
            if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(str7))
            {
              ad.w("MicroMsg.NetScenePreloadVideoFake", "cdntra genClientId failed not use cdn file:%s", new Object[] { locals.getFileName() });
              parama = null;
              continue;
            }
            o.aMJ();
            String str8 = t.Hh(str1);
            parama = new h();
            parama.fJi = "task_NetScenePreloadVideoFake";
            parama.filename = str1;
            parama.fJD = str3;
            parama.fJE = j;
            parama.fJF = 2;
            parama.dyU = locals.aMS();
            parama.fJG = locals.getUser();
            if (!w.vF(locals.getUser())) {
              break label1004;
            }
            i = q.yS(locals.getUser());
            label528:
            parama.dyW = i;
            parama.field_mediaId = str7;
            parama.field_fullpath = str8;
            parama.field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
            parama.field_totalLen = j;
            parama.field_aesKey = str5;
            parama.field_fileId = str2;
            parama.field_priority = com.tencent.mm.i.a.fIw;
            parama.field_wxmsgparam = str6;
            if (!w.vF(locals.getUser())) {
              break label1009;
            }
            i = 1;
            label595:
            parama.field_chattype = i;
            parama.field_autostart = false;
            parama.field_requestVideoFormat = com.tencent.mm.modelcontrol.d.a(2, locals);
            parama.field_preloadRatio = ((bj.b)localObject).hHe;
            parama.cSu = str4;
            continue;
          }
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 122L, 1L, false);
          continue;
        }
        if (!this.isE) {
          break label1019;
        }
      }
      catch (Exception parama)
      {
        ad.printErrStackTrace("MicroMsg.NetScenePreloadVideoFake", parama, "", new Object[0]);
        this.isF = null;
        AppMethodBeat.o(126847);
        return -1;
      }
      i = 4;
      label685:
      this.isB = i;
      parama = this.isl;
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 141L, 1L, false);
    }
    if (((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Iwe, Integer.valueOf(-1))).intValue() == 2) {
      ad.i("MicroMsg.NetScenePreloadVideoFake", "command set do not check media duplication.");
    }
    for (;;)
    {
      if (i != 0)
      {
        ad.i("MicroMsg.NetScenePreloadVideoFake", "%d it already had video file", new Object[] { Integer.valueOf(hashCode()) });
        i = 0;
        break label215;
        if (parama.XU()) {
          break label1024;
        }
        localObject = parama.fJD;
        i = parama.fJE;
        str1 = ((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).azx().gq((String)localObject, i);
        j = i - (int)com.tencent.mm.vfs.i.aYo(str1);
        if ((com.tencent.mm.sdk.platformtools.bt.isNullOrNil(str1)) || (j < 0) || (j > 16)) {
          break label1024;
        }
        ad.i("MicroMsg.NetScenePreloadVideoFake", "it had download this video[%d, %s, %s].", new Object[] { Integer.valueOf(i), localObject, str1 });
        com.tencent.mm.vfs.i.mz(str1, parama.field_fullpath);
        j(parama.filename, i, (String)localObject);
        i = 1;
        continue;
      }
      parama.fJB = this.fJB;
      parama.fJj = this.ibn;
      parama.fJz = 2;
      this.fJD = parama.fJD;
      this.mediaId = parama.field_mediaId;
      this.isx = parama.filename;
      this.isy = com.tencent.mm.sdk.platformtools.bt.aQJ();
      this.isC = parama.cSu;
      ad.i("MicroMsg.NetScenePreloadVideoFake", "%d send to cdn service task[%s]", new Object[] { Integer.valueOf(hashCode()), parama });
      com.tencent.mm.ao.f.aGI().b(parama, -1);
      i = 1;
      break label215;
      label1001:
      break label187;
      label1004:
      i = 0;
      break label528;
      label1009:
      i = 0;
      break label595;
      label1014:
      i = 1;
      break;
      label1019:
      i = 3;
      break label685;
      label1024:
      i = 0;
    }
  }
  
  public final String aMA()
  {
    AppMethodBeat.i(126845);
    if (this.isw)
    {
      str = this.msgId;
      AppMethodBeat.o(126845);
      return str;
    }
    String str = this.doX;
    AppMethodBeat.o(126845);
    return str;
  }
  
  final void j(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(126849);
    ad.i("MicroMsg.NetScenePreloadVideoFake", "%d update finish video [%s] [%d] [%s]", new Object[] { Integer.valueOf(hashCode()), paramString1, Integer.valueOf(paramInt), paramString2 });
    if (u.Hy(paramString1) != null)
    {
      u.at(paramString1, paramInt);
      i(paramInt, paramString2, paramString1);
    }
    AppMethodBeat.o(126849);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(126846);
    ad.i("MicroMsg.NetScenePreloadVideoFake", "%d stop preload video[%s]", new Object[] { Integer.valueOf(hashCode()), this.mediaId });
    if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(this.mediaId))
    {
      com.tencent.mm.i.d locald = new com.tencent.mm.i.d();
      b localb = com.tencent.mm.ao.f.aGI();
      String str = this.mediaId;
      int i = 0;
      com.tencent.mm.i.g localg = (com.tencent.mm.i.g)localb.hTK.remove(str);
      if (localg != null)
      {
        com.tencent.mm.ao.f.aGJ();
        i = com.tencent.mm.ao.a.c(str, locald);
        com.tencent.mm.plugin.report.service.g.yhR.f(10769, new Object[] { Integer.valueOf(com.tencent.mm.ao.c.hUl), Integer.valueOf(localg.field_fileType), Long.valueOf(com.tencent.mm.sdk.platformtools.bt.flT() - localg.field_startTime) });
      }
      localb.hTJ.remove(str);
      localb.hTL.remove(str);
      ad.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { str, localg, Integer.valueOf(i) });
      this.isz = com.tencent.mm.sdk.platformtools.bt.aQJ();
      this.isA = d(this.isx, (int)locald.field_recvedBytes, false);
      GP(locald.XP());
    }
    this.isF = null;
    AppMethodBeat.o(126846);
  }
  
  public static abstract interface a
  {
    public abstract void a(f paramf, boolean paramBoolean, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.f
 * JD-Core Version:    0.7.0.1
 */