package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.b;
import com.tencent.mm.f.b.a.jg;
import com.tencent.mm.f.c.et;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.b;
import com.tencent.mm.model.v;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bz;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import java.util.Map;

public final class j
{
  public String fAg;
  private g.b iUY;
  String iVb;
  private g.a lPx;
  private String mediaId;
  private com.tencent.mm.i.h mfS;
  boolean mgd;
  String mge;
  private long mgf;
  long mgg;
  long mgh;
  int mgi;
  private String mgj;
  public long mgk;
  public boolean mgl;
  public a mgm;
  long msgId;
  
  public j(long paramLong)
  {
    AppMethodBeat.i(126843);
    this.mgd = false;
    this.lPx = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(126841);
        if (paramAnonymousInt != 0)
        {
          Log.w("MicroMsg.NetScenePreloadVideoFake", "%d preload video error startRet[%d]", new Object[] { Integer.valueOf(j.this.hashCode()), Integer.valueOf(paramAnonymousInt) });
          if (j.this.mgm != null) {
            j.this.mgm.a(j.this, false, 0, 0);
          }
        }
        if (paramAnonymousc != null) {
          Log.d("MicroMsg.NetScenePreloadVideoFake", "%d preload video[%d %d] mediaId[%s]", new Object[] { Integer.valueOf(j.this.hashCode()), Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength), paramAnonymousString });
        }
        if (paramAnonymousd != null)
        {
          Log.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video error [%d]", new Object[] { Integer.valueOf(j.this.hashCode()), Integer.valueOf(paramAnonymousd.field_retCode) });
          if (paramAnonymousd.field_retCode == 0) {
            break label205;
          }
          if (j.this.mgm != null) {
            j.this.mgm.a(j.this, false, 0, 0);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(126841);
          return 0;
          label205:
          Log.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video download all video file", new Object[] { Integer.valueOf(j.this.hashCode()) });
          j.this.k(j.this.mge, (int)paramAnonymousd.field_fileLength, j.this.iVb);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    this.iUY = new g.b()
    {
      public final void b(String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(126842);
        if (paramAnonymousd == null)
        {
          Log.w("MicroMsg.NetScenePreloadVideoFake", "%s onPreload completed but sceneResult is null", new Object[] { Integer.valueOf(j.this.hashCode()) });
          if (j.this.mgm != null) {
            j.this.mgm.a(j.this, false, 0, 0);
          }
          AppMethodBeat.o(126842);
          return;
        }
        int i = (int)paramAnonymousd.field_recvedBytes;
        int j = (int)paramAnonymousd.field_fileLength;
        Log.i("MicroMsg.NetScenePreloadVideoFake", "%d onPreload Completed [%s] videoInfoName[%s] [%d, %d] videoFormat[%d]", new Object[] { Integer.valueOf(j.this.hashCode()), paramAnonymousString, j.this.mge, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramAnonymousd.field_videoFormat) });
        if ((i > 0) && (j > 0)) {
          j.this.mgh = j.i(j.this.mge, i, true);
        }
        boolean bool;
        if (j.this.mgm != null)
        {
          paramAnonymousString = j.this.mgm;
          j localj = j.this;
          if ((i > 0) && (j > 0))
          {
            bool = true;
            paramAnonymousString.a(localj, bool, i, j);
          }
        }
        else
        {
          j.this.mgg = Util.nowSecond();
          j.this.XB(paramAnonymousd.arL());
          if (!j.this.mgd) {
            break label342;
          }
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 142L, 1L, false);
          if (j.this.mgi != 1) {
            break label325;
          }
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 123L, 1L, false);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, paramAnonymousd.field_videoFormat + 240, 1L, false);
          AppMethodBeat.o(126842);
          return;
          bool = false;
          break;
          label325:
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 124L, 1L, false);
        }
        label342:
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 143L, 1L, false);
        AppMethodBeat.o(126842);
      }
    };
    this.msgId = paramLong;
    this.mgd = true;
    AppMethodBeat.o(126843);
  }
  
  public j(com.tencent.mm.i.h paramh, String paramString)
  {
    AppMethodBeat.i(126844);
    this.mgd = false;
    this.lPx = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(126841);
        if (paramAnonymousInt != 0)
        {
          Log.w("MicroMsg.NetScenePreloadVideoFake", "%d preload video error startRet[%d]", new Object[] { Integer.valueOf(j.this.hashCode()), Integer.valueOf(paramAnonymousInt) });
          if (j.this.mgm != null) {
            j.this.mgm.a(j.this, false, 0, 0);
          }
        }
        if (paramAnonymousc != null) {
          Log.d("MicroMsg.NetScenePreloadVideoFake", "%d preload video[%d %d] mediaId[%s]", new Object[] { Integer.valueOf(j.this.hashCode()), Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength), paramAnonymousString });
        }
        if (paramAnonymousd != null)
        {
          Log.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video error [%d]", new Object[] { Integer.valueOf(j.this.hashCode()), Integer.valueOf(paramAnonymousd.field_retCode) });
          if (paramAnonymousd.field_retCode == 0) {
            break label205;
          }
          if (j.this.mgm != null) {
            j.this.mgm.a(j.this, false, 0, 0);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(126841);
          return 0;
          label205:
          Log.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video download all video file", new Object[] { Integer.valueOf(j.this.hashCode()) });
          j.this.k(j.this.mge, (int)paramAnonymousd.field_fileLength, j.this.iVb);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    this.iUY = new g.b()
    {
      public final void b(String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(126842);
        if (paramAnonymousd == null)
        {
          Log.w("MicroMsg.NetScenePreloadVideoFake", "%s onPreload completed but sceneResult is null", new Object[] { Integer.valueOf(j.this.hashCode()) });
          if (j.this.mgm != null) {
            j.this.mgm.a(j.this, false, 0, 0);
          }
          AppMethodBeat.o(126842);
          return;
        }
        int i = (int)paramAnonymousd.field_recvedBytes;
        int j = (int)paramAnonymousd.field_fileLength;
        Log.i("MicroMsg.NetScenePreloadVideoFake", "%d onPreload Completed [%s] videoInfoName[%s] [%d, %d] videoFormat[%d]", new Object[] { Integer.valueOf(j.this.hashCode()), paramAnonymousString, j.this.mge, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramAnonymousd.field_videoFormat) });
        if ((i > 0) && (j > 0)) {
          j.this.mgh = j.i(j.this.mge, i, true);
        }
        boolean bool;
        if (j.this.mgm != null)
        {
          paramAnonymousString = j.this.mgm;
          j localj = j.this;
          if ((i > 0) && (j > 0))
          {
            bool = true;
            paramAnonymousString.a(localj, bool, i, j);
          }
        }
        else
        {
          j.this.mgg = Util.nowSecond();
          j.this.XB(paramAnonymousd.arL());
          if (!j.this.mgd) {
            break label342;
          }
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 142L, 1L, false);
          if (j.this.mgi != 1) {
            break label325;
          }
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 123L, 1L, false);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, paramAnonymousd.field_videoFormat + 240, 1L, false);
          AppMethodBeat.o(126842);
          return;
          bool = false;
          break;
          label325:
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 124L, 1L, false);
        }
        label342:
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 143L, 1L, false);
        AppMethodBeat.o(126842);
      }
    };
    this.mfS = paramh;
    this.fAg = paramString;
    this.mgd = false;
    AppMethodBeat.o(126844);
  }
  
  static int i(String paramString, int paramInt, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(126848);
    w localw = y.Yk(paramString);
    int j;
    if (localw != null)
    {
      j = localw.fLn;
      if (paramBoolean)
      {
        localw.fLn = paramInt;
        Log.i("MicroMsg.NetScenePreloadVideoFake", "update video info[%s] preload[%d %d %d] isFinish[%b] ", new Object[] { paramString, Integer.valueOf(j), Integer.valueOf(paramInt), Integer.valueOf(localw.fLn), Boolean.valueOf(paramBoolean) });
        localw.mhP = Util.nowSecond();
        localw.cUP = 1025;
        y.f(localw);
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
      localw.fLn = (j + paramInt);
      break;
      break label114;
      AppMethodBeat.o(126848);
      return paramInt;
    }
  }
  
  private static boolean i(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(126850);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(126850);
      return false;
    }
    s.bqB();
    paramString2 = x.XT(paramString2);
    if ((Util.isNullOrNil(paramString1)) || (paramInt <= 0) || (Util.isNullOrNil(paramString2)) || (!u.agG(paramString2)))
    {
      Log.w("MicroMsg.NetScenePreloadVideoFake", "insert media duplication but args is error.[%d, %s, %s]", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
      AppMethodBeat.o(126850);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.s.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.s.a.a.class)).bbT().U(paramString1, paramInt, paramString2);
    AppMethodBeat.o(126850);
    return bool;
  }
  
  final void XB(String paramString)
  {
    AppMethodBeat.i(126851);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.mgf).append(",");
    localStringBuffer.append(this.mgg).append(",");
    localStringBuffer.append(this.mgh).append(",");
    localStringBuffer.append(this.mgj).append(",");
    localStringBuffer.append(this.mgi).append(",");
    try
    {
      long l = this.mgh / 1024L / (this.mgg - this.mgf);
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
    localStringBuffer.append(this.mfS.fLi).append(",");
    localStringBuffer.append(this.mfS.iVe).append(",");
    localStringBuffer.append(this.mfS.fLk).append(",");
    localStringBuffer.append(this.mfS.field_fileId).append(",");
    localStringBuffer.append(this.mfS.url).append(",");
    localStringBuffer.append(com.tencent.mm.plugin.video.c.bfp(this.mfS.fLp));
    paramString = localStringBuffer.toString();
    Log.d("MicroMsg.NetScenePreloadVideoFake", "%d rpt content[%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    new jg(paramString).bpa();
    AppMethodBeat.o(126851);
  }
  
  public final int a(a parama)
  {
    AppMethodBeat.i(126847);
    this.mgm = parama;
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
        Log.i("MicroMsg.NetScenePreloadVideoFake", "%d preload begin msgId[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.msgId) });
        if (this.mgd)
        {
          parama = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(this.msgId);
          localObject = bq.RR(parama.hxy);
          if ((localObject == null) || (((bq.b)localObject).luI <= 0))
          {
            Log.w("MicroMsg.NetScenePreloadVideoFake", "%d msgsource is null", new Object[] { Integer.valueOf(hashCode()) });
            parama = null;
            if (parama != null)
            {
              if (!ab.Lj(parama.iVe)) {
                break label1015;
              }
              i = 2;
              this.mgi = i;
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 140L, 1L, false);
              if (this.mgi == 1) {
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 121L, 1L, false);
              }
            }
            else
            {
              if (this.mfS != null) {
                break label1002;
              }
              this.mfS = parama;
              if (parama != null) {
                break;
              }
              Log.w("MicroMsg.NetScenePreloadVideoFake", "%d preload task is null", new Object[] { Integer.valueOf(hashCode()) });
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
            w localw = y.Yk(str1);
            if (localw == null)
            {
              parama = null;
              continue;
            }
            parama = XmlParser.parseXml(localw.bqO(), "msg", null);
            if (parama == null)
            {
              Log.w("MicroMsg.NetScenePreloadVideoFake", "cdntra parse video recv xml failed");
              parama = null;
              continue;
            }
            String str2 = (String)parama.get(".msg.videomsg.$cdnvideourl");
            if (Util.isNullOrNil(str2))
            {
              Log.w("MicroMsg.NetScenePreloadVideoFake", "cdntra parse video recv xml failed");
              parama = null;
              continue;
            }
            j = Util.getInt((String)parama.get(".msg.videomsg.$length"), 0);
            String str3 = (String)parama.get(".msg.videomsg.$md5");
            String str4 = (String)parama.get(".msg.videomsg.$newmd5");
            String str5 = (String)parama.get(".msg.videomsg.$aeskey");
            String str6 = (String)parama.get(".msg.videomsg.$fileparam");
            String str7 = com.tencent.mm.aq.c.a("downvideo", localw.createTime, localw.bqM(), localw.getFileName());
            if (Util.isNullOrNil(str7))
            {
              Log.w("MicroMsg.NetScenePreloadVideoFake", "cdntra genClientId failed not use cdn file:%s", new Object[] { localw.getFileName() });
              parama = null;
              continue;
            }
            s.bqB();
            String str8 = x.XT(str1);
            parama = new com.tencent.mm.i.h();
            parama.taskName = "task_NetScenePreloadVideoFake";
            parama.filename = str1;
            parama.iVb = str3;
            parama.iVc = j;
            parama.iVd = 2;
            parama.fLi = localw.bqK();
            parama.iVe = localw.bqM();
            if (!ab.Lj(localw.bqM())) {
              break label1005;
            }
            i = v.Pu(localw.bqM());
            label529:
            parama.fLk = i;
            parama.field_mediaId = str7;
            parama.field_fullpath = str8;
            parama.field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
            parama.field_totalLen = j;
            parama.field_aesKey = str5;
            parama.field_fileId = str2;
            parama.field_priority = com.tencent.mm.i.a.iTU;
            parama.field_wxmsgparam = str6;
            if (!ab.Lj(localw.bqM())) {
              break label1010;
            }
            i = 1;
            label596:
            parama.field_chattype = i;
            parama.field_autostart = false;
            parama.field_requestVideoFormat = e.a(2, localw);
            parama.field_preloadRatio = ((bq.b)localObject).luI;
            parama.fbd = str4;
            continue;
          }
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 122L, 1L, false);
          continue;
        }
        if (!this.mgl) {
          break label1020;
        }
      }
      catch (Exception parama)
      {
        Log.printErrStackTrace("MicroMsg.NetScenePreloadVideoFake", parama, "", new Object[0]);
        this.mgm = null;
        AppMethodBeat.o(126847);
        return -1;
      }
      i = 4;
      label686:
      this.mgi = i;
      parama = this.mfS;
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 141L, 1L, false);
    }
    if (((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VmD, Integer.valueOf(-1))).intValue() == 2) {
      Log.i("MicroMsg.NetScenePreloadVideoFake", "command set do not check media duplication.");
    }
    for (;;)
    {
      if (i != 0)
      {
        Log.i("MicroMsg.NetScenePreloadVideoFake", "%d it already had video file", new Object[] { Integer.valueOf(hashCode()) });
        i = 0;
        break label215;
        if (parama.arQ()) {
          break label1025;
        }
        localObject = parama.iVb;
        i = parama.iVc;
        str1 = ((com.tencent.mm.plugin.s.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.s.a.a.class)).bbT().hA((String)localObject, i);
        j = i - (int)u.bBQ(str1);
        if ((Util.isNullOrNil(str1)) || (j < 0) || (j > 16)) {
          break label1025;
        }
        Log.i("MicroMsg.NetScenePreloadVideoFake", "it had download this video[%d, %s, %s].", new Object[] { Integer.valueOf(i), localObject, str1 });
        u.on(str1, parama.field_fullpath);
        k(parama.filename, i, (String)localObject);
        i = 1;
        continue;
      }
      parama.iUY = this.iUY;
      parama.iUG = this.lPx;
      parama.iUW = 2;
      this.iVb = parama.iVb;
      this.mediaId = parama.field_mediaId;
      this.mge = parama.filename;
      this.mgf = Util.nowSecond();
      this.mgj = parama.fbd;
      Log.i("MicroMsg.NetScenePreloadVideoFake", "%d send to cdn service task[%s]", new Object[] { Integer.valueOf(hashCode()), parama });
      com.tencent.mm.aq.f.bkg().b(parama, -1);
      i = 1;
      break label215;
      label1002:
      break label187;
      label1005:
      i = 0;
      break label529;
      label1010:
      i = 0;
      break label596;
      label1015:
      i = 1;
      break;
      label1020:
      i = 3;
      break label686;
      label1025:
      i = 0;
    }
  }
  
  public final String bqs()
  {
    AppMethodBeat.i(126845);
    if (this.mgd)
    {
      str = this.msgId;
      AppMethodBeat.o(126845);
      return str;
    }
    String str = this.fAg;
    AppMethodBeat.o(126845);
    return str;
  }
  
  final void k(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(126849);
    Log.i("MicroMsg.NetScenePreloadVideoFake", "%d update finish video [%s] [%d] [%s]", new Object[] { Integer.valueOf(hashCode()), paramString1, Integer.valueOf(paramInt), paramString2 });
    if (y.Yk(paramString1) != null)
    {
      y.aQ(paramString1, paramInt);
      i(paramInt, paramString2, paramString1);
    }
    AppMethodBeat.o(126849);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(126846);
    Log.i("MicroMsg.NetScenePreloadVideoFake", "%d stop preload video[%s]", new Object[] { Integer.valueOf(hashCode()), this.mediaId });
    if (!Util.isNullOrNil(this.mediaId))
    {
      d locald = new d();
      b localb = com.tencent.mm.aq.f.bkg();
      String str = this.mediaId;
      int i = 0;
      g localg = (g)localb.lHS.remove(str);
      if (localg != null)
      {
        com.tencent.mm.aq.f.bkh();
        i = com.tencent.mm.aq.a.c(str, locald);
        com.tencent.mm.plugin.report.service.h.IzE.a(10769, new Object[] { Integer.valueOf(com.tencent.mm.aq.c.lIt), Integer.valueOf(localg.field_fileType), Long.valueOf(Util.nowMilliSecond() - localg.field_startTime) });
      }
      localb.lHR.remove(str);
      localb.lHT.remove(str);
      Log.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { str, localg, Integer.valueOf(i) });
      this.mgg = Util.nowSecond();
      this.mgh = i(this.mge, (int)locald.field_recvedBytes, false);
      XB(locald.arL());
    }
    this.mgm = null;
    AppMethodBeat.o(126846);
  }
  
  public static abstract interface a
  {
    public abstract void a(j paramj, boolean paramBoolean, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.j
 * JD-Core Version:    0.7.0.1
 */