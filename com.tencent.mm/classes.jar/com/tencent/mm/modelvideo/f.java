package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.b;
import com.tencent.mm.g.b.a.dx;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.i.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bl.b;
import com.tencent.mm.model.r;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.io.ByteArrayOutputStream;
import java.util.Map;

public final class f
{
  public String dqc;
  private g.b fLE;
  String fLG;
  private g.a ieg;
  private h ivf;
  boolean ivq;
  String ivr;
  private long ivs;
  long ivt;
  long ivu;
  int ivv;
  private String ivw;
  public long ivx;
  public boolean ivy;
  public a ivz;
  private String mediaId;
  long msgId;
  
  public f(long paramLong)
  {
    AppMethodBeat.i(126843);
    this.ivq = false;
    this.ieg = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(126841);
        if (paramAnonymousInt != 0)
        {
          ae.w("MicroMsg.NetScenePreloadVideoFake", "%d preload video error startRet[%d]", new Object[] { Integer.valueOf(f.this.hashCode()), Integer.valueOf(paramAnonymousInt) });
          if (f.this.ivz != null) {
            f.this.ivz.a(f.this, false, 0, 0);
          }
        }
        if (paramAnonymousc != null) {
          ae.d("MicroMsg.NetScenePreloadVideoFake", "%d preload video[%d %d] mediaId[%s]", new Object[] { Integer.valueOf(f.this.hashCode()), Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength), paramAnonymousString });
        }
        if (paramAnonymousd != null)
        {
          ae.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video error [%d]", new Object[] { Integer.valueOf(f.this.hashCode()), Integer.valueOf(paramAnonymousd.field_retCode) });
          if (paramAnonymousd.field_retCode == 0) {
            break label205;
          }
          if (f.this.ivz != null) {
            f.this.ivz.a(f.this, false, 0, 0);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(126841);
          return 0;
          label205:
          ae.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video download all video file", new Object[] { Integer.valueOf(f.this.hashCode()) });
          f.this.j(f.this.ivr, (int)paramAnonymousd.field_fileLength, f.this.fLG);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    this.fLE = new g.b()
    {
      public final void b(String paramAnonymousString, com.tencent.mm.i.d paramAnonymousd)
      {
        AppMethodBeat.i(126842);
        if (paramAnonymousd == null)
        {
          ae.w("MicroMsg.NetScenePreloadVideoFake", "%s onPreload completed but sceneResult is null", new Object[] { Integer.valueOf(f.this.hashCode()) });
          if (f.this.ivz != null) {
            f.this.ivz.a(f.this, false, 0, 0);
          }
          AppMethodBeat.o(126842);
          return;
        }
        int i = (int)paramAnonymousd.field_recvedBytes;
        int j = (int)paramAnonymousd.field_fileLength;
        ae.i("MicroMsg.NetScenePreloadVideoFake", "%d onPreload Completed [%s] videoInfoName[%s] [%d, %d] videoFormat[%d]", new Object[] { Integer.valueOf(f.this.hashCode()), paramAnonymousString, f.this.ivr, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramAnonymousd.field_videoFormat) });
        if ((i > 0) && (j > 0)) {
          f.this.ivu = f.d(f.this.ivr, i, true);
        }
        boolean bool;
        if (f.this.ivz != null)
        {
          paramAnonymousString = f.this.ivz;
          f localf = f.this;
          if ((i > 0) && (j > 0))
          {
            bool = true;
            paramAnonymousString.a(localf, bool, i, j);
          }
        }
        else
        {
          f.this.ivt = com.tencent.mm.sdk.platformtools.bu.aRi();
          f.this.Hr(paramAnonymousd.XZ());
          if (!f.this.ivq) {
            break label342;
          }
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 142L, 1L, false);
          if (f.this.ivv != 1) {
            break label325;
          }
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 123L, 1L, false);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, paramAnonymousd.field_videoFormat + 240, 1L, false);
          AppMethodBeat.o(126842);
          return;
          bool = false;
          break;
          label325:
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 124L, 1L, false);
        }
        label342:
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 143L, 1L, false);
        AppMethodBeat.o(126842);
      }
    };
    this.msgId = paramLong;
    this.ivq = true;
    AppMethodBeat.o(126843);
  }
  
  public f(h paramh, String paramString)
  {
    AppMethodBeat.i(126844);
    this.ivq = false;
    this.ieg = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(126841);
        if (paramAnonymousInt != 0)
        {
          ae.w("MicroMsg.NetScenePreloadVideoFake", "%d preload video error startRet[%d]", new Object[] { Integer.valueOf(f.this.hashCode()), Integer.valueOf(paramAnonymousInt) });
          if (f.this.ivz != null) {
            f.this.ivz.a(f.this, false, 0, 0);
          }
        }
        if (paramAnonymousc != null) {
          ae.d("MicroMsg.NetScenePreloadVideoFake", "%d preload video[%d %d] mediaId[%s]", new Object[] { Integer.valueOf(f.this.hashCode()), Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength), paramAnonymousString });
        }
        if (paramAnonymousd != null)
        {
          ae.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video error [%d]", new Object[] { Integer.valueOf(f.this.hashCode()), Integer.valueOf(paramAnonymousd.field_retCode) });
          if (paramAnonymousd.field_retCode == 0) {
            break label205;
          }
          if (f.this.ivz != null) {
            f.this.ivz.a(f.this, false, 0, 0);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(126841);
          return 0;
          label205:
          ae.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video download all video file", new Object[] { Integer.valueOf(f.this.hashCode()) });
          f.this.j(f.this.ivr, (int)paramAnonymousd.field_fileLength, f.this.fLG);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    this.fLE = new g.b()
    {
      public final void b(String paramAnonymousString, com.tencent.mm.i.d paramAnonymousd)
      {
        AppMethodBeat.i(126842);
        if (paramAnonymousd == null)
        {
          ae.w("MicroMsg.NetScenePreloadVideoFake", "%s onPreload completed but sceneResult is null", new Object[] { Integer.valueOf(f.this.hashCode()) });
          if (f.this.ivz != null) {
            f.this.ivz.a(f.this, false, 0, 0);
          }
          AppMethodBeat.o(126842);
          return;
        }
        int i = (int)paramAnonymousd.field_recvedBytes;
        int j = (int)paramAnonymousd.field_fileLength;
        ae.i("MicroMsg.NetScenePreloadVideoFake", "%d onPreload Completed [%s] videoInfoName[%s] [%d, %d] videoFormat[%d]", new Object[] { Integer.valueOf(f.this.hashCode()), paramAnonymousString, f.this.ivr, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramAnonymousd.field_videoFormat) });
        if ((i > 0) && (j > 0)) {
          f.this.ivu = f.d(f.this.ivr, i, true);
        }
        boolean bool;
        if (f.this.ivz != null)
        {
          paramAnonymousString = f.this.ivz;
          f localf = f.this;
          if ((i > 0) && (j > 0))
          {
            bool = true;
            paramAnonymousString.a(localf, bool, i, j);
          }
        }
        else
        {
          f.this.ivt = com.tencent.mm.sdk.platformtools.bu.aRi();
          f.this.Hr(paramAnonymousd.XZ());
          if (!f.this.ivq) {
            break label342;
          }
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 142L, 1L, false);
          if (f.this.ivv != 1) {
            break label325;
          }
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 123L, 1L, false);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, paramAnonymousd.field_videoFormat + 240, 1L, false);
          AppMethodBeat.o(126842);
          return;
          bool = false;
          break;
          label325:
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 124L, 1L, false);
        }
        label342:
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 143L, 1L, false);
        AppMethodBeat.o(126842);
      }
    };
    this.ivf = paramh;
    this.dqc = paramString;
    this.ivq = false;
    AppMethodBeat.o(126844);
  }
  
  static int d(String paramString, int paramInt, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(126848);
    s locals = u.Ia(paramString);
    int j;
    if (locals != null)
    {
      j = locals.dAe;
      if (paramBoolean)
      {
        locals.dAe = paramInt;
        ae.i("MicroMsg.NetScenePreloadVideoFake", "update video info[%s] preload[%d %d %d] isFinish[%b] ", new Object[] { paramString, Integer.valueOf(j), Integer.valueOf(paramInt), Integer.valueOf(locals.dAe), Boolean.valueOf(paramBoolean) });
        locals.iwX = com.tencent.mm.sdk.platformtools.bu.aRi();
        locals.dEu = 1025;
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
      locals.dAe = (j + paramInt);
      break;
      break label114;
      AppMethodBeat.o(126848);
      return paramInt;
    }
  }
  
  private static boolean i(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(126850);
    if (com.tencent.mm.sdk.platformtools.bu.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(126850);
      return false;
    }
    o.aNh();
    paramString2 = t.HJ(paramString2);
    if ((com.tencent.mm.sdk.platformtools.bu.isNullOrNil(paramString1)) || (paramInt <= 0) || (com.tencent.mm.sdk.platformtools.bu.isNullOrNil(paramString2)) || (!com.tencent.mm.vfs.o.fB(paramString2)))
    {
      ae.w("MicroMsg.NetScenePreloadVideoFake", "insert media duplication but args is error.[%d, %s, %s]", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
      AppMethodBeat.o(126850);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).azN().G(paramString1, paramInt, paramString2);
    AppMethodBeat.o(126850);
    return bool;
  }
  
  final void Hr(String paramString)
  {
    AppMethodBeat.i(126851);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.ivs).append(",");
    localStringBuffer.append(this.ivt).append(",");
    localStringBuffer.append(this.ivu).append(",");
    localStringBuffer.append(this.ivw).append(",");
    localStringBuffer.append(this.ivv).append(",");
    try
    {
      long l = this.ivu / 1024L / (this.ivt - this.ivs);
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
    localStringBuffer.append(this.ivf.dzZ).append(",");
    localStringBuffer.append(this.ivf.fLJ).append(",");
    localStringBuffer.append(this.ivf.dAb).append(",");
    localStringBuffer.append(this.ivf.field_fileId).append(",");
    localStringBuffer.append(this.ivf.url).append(",");
    localStringBuffer.append(com.tencent.mm.plugin.video.c.aEB(this.ivf.dAg));
    paramString = localStringBuffer.toString();
    ae.d("MicroMsg.NetScenePreloadVideoFake", "%d rpt content[%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    new dx(paramString).aLH();
    AppMethodBeat.o(126851);
  }
  
  public final int a(a parama)
  {
    AppMethodBeat.i(126847);
    this.ivz = parama;
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
        ae.i("MicroMsg.NetScenePreloadVideoFake", "%d preload begin msgId[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.msgId) });
        if (this.ivq)
        {
          parama = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(this.msgId);
          localObject = bl.BS(parama.eNd);
          if ((localObject == null) || (((bl.b)localObject).hJW <= 0))
          {
            ae.w("MicroMsg.NetScenePreloadVideoFake", "%d msgsource is null", new Object[] { Integer.valueOf(hashCode()) });
            parama = null;
            if (parama != null)
            {
              if (!x.wb(parama.fLJ)) {
                break label1014;
              }
              i = 2;
              this.ivv = i;
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 140L, 1L, false);
              if (this.ivv == 1) {
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 121L, 1L, false);
              }
            }
            else
            {
              if (this.ivf != null) {
                break label1001;
              }
              this.ivf = parama;
              if (parama != null) {
                break;
              }
              ae.w("MicroMsg.NetScenePreloadVideoFake", "%d preload task is null", new Object[] { Integer.valueOf(hashCode()) });
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
            s locals = u.Ia(str1);
            if (locals == null)
            {
              parama = null;
              continue;
            }
            parama = bx.M(locals.aNt(), "msg");
            if (parama == null)
            {
              ae.w("MicroMsg.NetScenePreloadVideoFake", "cdntra parse video recv xml failed");
              parama = null;
              continue;
            }
            String str2 = (String)parama.get(".msg.videomsg.$cdnvideourl");
            if (com.tencent.mm.sdk.platformtools.bu.isNullOrNil(str2))
            {
              ae.w("MicroMsg.NetScenePreloadVideoFake", "cdntra parse video recv xml failed");
              parama = null;
              continue;
            }
            j = com.tencent.mm.sdk.platformtools.bu.getInt((String)parama.get(".msg.videomsg.$length"), 0);
            String str3 = (String)parama.get(".msg.videomsg.$md5");
            String str4 = (String)parama.get(".msg.videomsg.$newmd5");
            String str5 = (String)parama.get(".msg.videomsg.$aeskey");
            String str6 = (String)parama.get(".msg.videomsg.$fileparam");
            String str7 = com.tencent.mm.an.c.a("downvideo", locals.createTime, locals.getUser(), locals.getFileName());
            if (com.tencent.mm.sdk.platformtools.bu.isNullOrNil(str7))
            {
              ae.w("MicroMsg.NetScenePreloadVideoFake", "cdntra genClientId failed not use cdn file:%s", new Object[] { locals.getFileName() });
              parama = null;
              continue;
            }
            o.aNh();
            String str8 = t.HJ(str1);
            parama = new h();
            parama.fLl = "task_NetScenePreloadVideoFake";
            parama.filename = str1;
            parama.fLG = str3;
            parama.fLH = j;
            parama.fLI = 2;
            parama.dzZ = locals.aNq();
            parama.fLJ = locals.getUser();
            if (!x.wb(locals.getUser())) {
              break label1004;
            }
            i = r.zC(locals.getUser());
            label528:
            parama.dAb = i;
            parama.field_mediaId = str7;
            parama.field_fullpath = str8;
            parama.field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
            parama.field_totalLen = j;
            parama.field_aesKey = str5;
            parama.field_fileId = str2;
            parama.field_priority = com.tencent.mm.i.a.fKA;
            parama.field_wxmsgparam = str6;
            if (!x.wb(locals.getUser())) {
              break label1009;
            }
            i = 1;
            label595:
            parama.field_chattype = i;
            parama.field_autostart = false;
            parama.field_requestVideoFormat = com.tencent.mm.modelcontrol.d.a(2, locals);
            parama.field_preloadRatio = ((bl.b)localObject).hJW;
            parama.cTe = str4;
            continue;
          }
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 122L, 1L, false);
          continue;
        }
        if (!this.ivy) {
          break label1019;
        }
      }
      catch (Exception parama)
      {
        ae.printErrStackTrace("MicroMsg.NetScenePreloadVideoFake", parama, "", new Object[0]);
        this.ivz = null;
        AppMethodBeat.o(126847);
        return -1;
      }
      i = 4;
      label685:
      this.ivv = i;
      parama = this.ivf;
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 141L, 1L, false);
    }
    if (((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IQC, Integer.valueOf(-1))).intValue() == 2) {
      ae.i("MicroMsg.NetScenePreloadVideoFake", "command set do not check media duplication.");
    }
    for (;;)
    {
      if (i != 0)
      {
        ae.i("MicroMsg.NetScenePreloadVideoFake", "%d it already had video file", new Object[] { Integer.valueOf(hashCode()) });
        i = 0;
        break label215;
        if (parama.Ye()) {
          break label1024;
        }
        localObject = parama.fLG;
        i = parama.fLH;
        str1 = ((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).azN().gz((String)localObject, i);
        j = i - (int)com.tencent.mm.vfs.o.aZR(str1);
        if ((com.tencent.mm.sdk.platformtools.bu.isNullOrNil(str1)) || (j < 0) || (j > 16)) {
          break label1024;
        }
        ae.i("MicroMsg.NetScenePreloadVideoFake", "it had download this video[%d, %s, %s].", new Object[] { Integer.valueOf(i), localObject, str1 });
        com.tencent.mm.vfs.o.mF(str1, parama.field_fullpath);
        j(parama.filename, i, (String)localObject);
        i = 1;
        continue;
      }
      parama.fLE = this.fLE;
      parama.fLm = this.ieg;
      parama.fLC = 2;
      this.fLG = parama.fLG;
      this.mediaId = parama.field_mediaId;
      this.ivr = parama.filename;
      this.ivs = com.tencent.mm.sdk.platformtools.bu.aRi();
      this.ivw = parama.cTe;
      ae.i("MicroMsg.NetScenePreloadVideoFake", "%d send to cdn service task[%s]", new Object[] { Integer.valueOf(hashCode()), parama });
      com.tencent.mm.an.f.aGZ().b(parama, -1);
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
  
  public final String aMY()
  {
    AppMethodBeat.i(126845);
    if (this.ivq)
    {
      str = this.msgId;
      AppMethodBeat.o(126845);
      return str;
    }
    String str = this.dqc;
    AppMethodBeat.o(126845);
    return str;
  }
  
  final void j(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(126849);
    ae.i("MicroMsg.NetScenePreloadVideoFake", "%d update finish video [%s] [%d] [%s]", new Object[] { Integer.valueOf(hashCode()), paramString1, Integer.valueOf(paramInt), paramString2 });
    if (u.Ia(paramString1) != null)
    {
      u.au(paramString1, paramInt);
      i(paramInt, paramString2, paramString1);
    }
    AppMethodBeat.o(126849);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(126846);
    ae.i("MicroMsg.NetScenePreloadVideoFake", "%d stop preload video[%s]", new Object[] { Integer.valueOf(hashCode()), this.mediaId });
    if (!com.tencent.mm.sdk.platformtools.bu.isNullOrNil(this.mediaId))
    {
      com.tencent.mm.i.d locald = new com.tencent.mm.i.d();
      b localb = com.tencent.mm.an.f.aGZ();
      String str = this.mediaId;
      int i = 0;
      com.tencent.mm.i.g localg = (com.tencent.mm.i.g)localb.hWC.remove(str);
      if (localg != null)
      {
        com.tencent.mm.an.f.aHa();
        i = com.tencent.mm.an.a.c(str, locald);
        com.tencent.mm.plugin.report.service.g.yxI.f(10769, new Object[] { Integer.valueOf(com.tencent.mm.an.c.hXd), Integer.valueOf(localg.field_fileType), Long.valueOf(com.tencent.mm.sdk.platformtools.bu.fpO() - localg.field_startTime) });
      }
      localb.hWB.remove(str);
      localb.hWD.remove(str);
      ae.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { str, localg, Integer.valueOf(i) });
      this.ivt = com.tencent.mm.sdk.platformtools.bu.aRi();
      this.ivu = d(this.ivr, (int)locald.field_recvedBytes, false);
      Hr(locald.XZ());
    }
    this.ivz = null;
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