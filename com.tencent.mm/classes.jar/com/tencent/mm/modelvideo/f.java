package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.b;
import com.tencent.mm.g.b.a.dc;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.model.q;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bn;
import com.tencent.mm.vfs.i;
import java.io.ByteArrayOutputStream;
import java.util.Map;

public final class f
{
  public String ddB;
  private g.b frs;
  String fru;
  private g.a hIz;
  private com.tencent.mm.i.h hYP;
  boolean hZa;
  String hZb;
  private long hZc;
  long hZd;
  long hZe;
  int hZf;
  private String hZg;
  public long hZh;
  public boolean hZi;
  public a hZj;
  private String mediaId;
  long msgId;
  
  public f(long paramLong)
  {
    AppMethodBeat.i(126843);
    this.hZa = false;
    this.hIz = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(126841);
        if (paramAnonymousInt != 0)
        {
          ac.w("MicroMsg.NetScenePreloadVideoFake", "%d preload video error startRet[%d]", new Object[] { Integer.valueOf(f.this.hashCode()), Integer.valueOf(paramAnonymousInt) });
          if (f.this.hZj != null) {
            f.this.hZj.a(f.this, false, 0, 0);
          }
        }
        if (paramAnonymousc != null) {
          ac.d("MicroMsg.NetScenePreloadVideoFake", "%d preload video[%d %d] mediaId[%s]", new Object[] { Integer.valueOf(f.this.hashCode()), Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength), paramAnonymousString });
        }
        if (paramAnonymousd != null)
        {
          ac.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video error [%d]", new Object[] { Integer.valueOf(f.this.hashCode()), Integer.valueOf(paramAnonymousd.field_retCode) });
          if (paramAnonymousd.field_retCode == 0) {
            break label205;
          }
          if (f.this.hZj != null) {
            f.this.hZj.a(f.this, false, 0, 0);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(126841);
          return 0;
          label205:
          ac.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video download all video file", new Object[] { Integer.valueOf(f.this.hashCode()) });
          f.this.h(f.this.hZb, (int)paramAnonymousd.field_fileLength, f.this.fru);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    this.frs = new g.b()
    {
      public final void b(String paramAnonymousString, com.tencent.mm.i.d paramAnonymousd)
      {
        AppMethodBeat.i(126842);
        if (paramAnonymousd == null)
        {
          ac.w("MicroMsg.NetScenePreloadVideoFake", "%s onPreload completed but sceneResult is null", new Object[] { Integer.valueOf(f.this.hashCode()) });
          if (f.this.hZj != null) {
            f.this.hZj.a(f.this, false, 0, 0);
          }
          AppMethodBeat.o(126842);
          return;
        }
        int i = (int)paramAnonymousd.field_recvedBytes;
        int j = (int)paramAnonymousd.field_fileLength;
        ac.i("MicroMsg.NetScenePreloadVideoFake", "%d onPreload Completed [%s] videoInfoName[%s] [%d, %d] videoFormat[%d]", new Object[] { Integer.valueOf(f.this.hashCode()), paramAnonymousString, f.this.hZb, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramAnonymousd.field_videoFormat) });
        if ((i > 0) && (j > 0)) {
          f.this.hZe = f.d(f.this.hZb, i, true);
        }
        boolean bool;
        if (f.this.hZj != null)
        {
          paramAnonymousString = f.this.hZj;
          f localf = f.this;
          if ((i > 0) && (j > 0))
          {
            bool = true;
            paramAnonymousString.a(localf, bool, i, j);
          }
        }
        else
        {
          f.this.hZd = bs.aNx();
          f.this.DK(paramAnonymousd.Vy());
          if (!f.this.hZa) {
            break label342;
          }
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 142L, 1L, false);
          if (f.this.hZf != 1) {
            break label325;
          }
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 123L, 1L, false);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, paramAnonymousd.field_videoFormat + 240, 1L, false);
          AppMethodBeat.o(126842);
          return;
          bool = false;
          break;
          label325:
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 124L, 1L, false);
        }
        label342:
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 143L, 1L, false);
        AppMethodBeat.o(126842);
      }
    };
    this.msgId = paramLong;
    this.hZa = true;
    AppMethodBeat.o(126843);
  }
  
  public f(com.tencent.mm.i.h paramh, String paramString)
  {
    AppMethodBeat.i(126844);
    this.hZa = false;
    this.hIz = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(126841);
        if (paramAnonymousInt != 0)
        {
          ac.w("MicroMsg.NetScenePreloadVideoFake", "%d preload video error startRet[%d]", new Object[] { Integer.valueOf(f.this.hashCode()), Integer.valueOf(paramAnonymousInt) });
          if (f.this.hZj != null) {
            f.this.hZj.a(f.this, false, 0, 0);
          }
        }
        if (paramAnonymousc != null) {
          ac.d("MicroMsg.NetScenePreloadVideoFake", "%d preload video[%d %d] mediaId[%s]", new Object[] { Integer.valueOf(f.this.hashCode()), Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength), paramAnonymousString });
        }
        if (paramAnonymousd != null)
        {
          ac.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video error [%d]", new Object[] { Integer.valueOf(f.this.hashCode()), Integer.valueOf(paramAnonymousd.field_retCode) });
          if (paramAnonymousd.field_retCode == 0) {
            break label205;
          }
          if (f.this.hZj != null) {
            f.this.hZj.a(f.this, false, 0, 0);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(126841);
          return 0;
          label205:
          ac.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video download all video file", new Object[] { Integer.valueOf(f.this.hashCode()) });
          f.this.h(f.this.hZb, (int)paramAnonymousd.field_fileLength, f.this.fru);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    this.frs = new g.b()
    {
      public final void b(String paramAnonymousString, com.tencent.mm.i.d paramAnonymousd)
      {
        AppMethodBeat.i(126842);
        if (paramAnonymousd == null)
        {
          ac.w("MicroMsg.NetScenePreloadVideoFake", "%s onPreload completed but sceneResult is null", new Object[] { Integer.valueOf(f.this.hashCode()) });
          if (f.this.hZj != null) {
            f.this.hZj.a(f.this, false, 0, 0);
          }
          AppMethodBeat.o(126842);
          return;
        }
        int i = (int)paramAnonymousd.field_recvedBytes;
        int j = (int)paramAnonymousd.field_fileLength;
        ac.i("MicroMsg.NetScenePreloadVideoFake", "%d onPreload Completed [%s] videoInfoName[%s] [%d, %d] videoFormat[%d]", new Object[] { Integer.valueOf(f.this.hashCode()), paramAnonymousString, f.this.hZb, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramAnonymousd.field_videoFormat) });
        if ((i > 0) && (j > 0)) {
          f.this.hZe = f.d(f.this.hZb, i, true);
        }
        boolean bool;
        if (f.this.hZj != null)
        {
          paramAnonymousString = f.this.hZj;
          f localf = f.this;
          if ((i > 0) && (j > 0))
          {
            bool = true;
            paramAnonymousString.a(localf, bool, i, j);
          }
        }
        else
        {
          f.this.hZd = bs.aNx();
          f.this.DK(paramAnonymousd.Vy());
          if (!f.this.hZa) {
            break label342;
          }
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 142L, 1L, false);
          if (f.this.hZf != 1) {
            break label325;
          }
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 123L, 1L, false);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, paramAnonymousd.field_videoFormat + 240, 1L, false);
          AppMethodBeat.o(126842);
          return;
          bool = false;
          break;
          label325:
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 124L, 1L, false);
        }
        label342:
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 143L, 1L, false);
        AppMethodBeat.o(126842);
      }
    };
    this.hYP = paramh;
    this.ddB = paramString;
    this.hZa = false;
    AppMethodBeat.o(126844);
  }
  
  static int d(String paramString, int paramInt, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(126848);
    s locals = u.Ej(paramString);
    int j;
    if (locals != null)
    {
      j = locals.dnl;
      if (paramBoolean)
      {
        locals.dnl = paramInt;
        ac.i("MicroMsg.NetScenePreloadVideoFake", "update video info[%s] preload[%d %d %d] isFinish[%b] ", new Object[] { paramString, Integer.valueOf(j), Integer.valueOf(paramInt), Integer.valueOf(locals.dnl), Boolean.valueOf(paramBoolean) });
        locals.iaH = bs.aNx();
        locals.drx = 1025;
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
      locals.dnl = (j + paramInt);
      break;
      break label114;
      AppMethodBeat.o(126848);
      return paramInt;
    }
  }
  
  private static boolean i(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(126850);
    if (bs.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(126850);
      return false;
    }
    o.aJy();
    paramString2 = t.DV(paramString2);
    if ((bs.isNullOrNil(paramString1)) || (paramInt <= 0) || (bs.isNullOrNil(paramString2)) || (!i.eA(paramString2)))
    {
      ac.w("MicroMsg.NetScenePreloadVideoFake", "insert media duplication but args is error.[%d, %s, %s]", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
      AppMethodBeat.o(126850);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).awI().D(paramString1, paramInt, paramString2);
    AppMethodBeat.o(126850);
    return bool;
  }
  
  final void DK(String paramString)
  {
    AppMethodBeat.i(126851);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.hZc).append(",");
    localStringBuffer.append(this.hZd).append(",");
    localStringBuffer.append(this.hZe).append(",");
    localStringBuffer.append(this.hZg).append(",");
    localStringBuffer.append(this.hZf).append(",");
    try
    {
      long l = this.hZe / 1024L / (this.hZd - this.hZc);
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
    localStringBuffer.append(this.hYP.dng).append(",");
    localStringBuffer.append(this.hYP.frx).append(",");
    localStringBuffer.append(this.hYP.dni).append(",");
    localStringBuffer.append(this.hYP.field_fileId).append(",");
    localStringBuffer.append(this.hYP.url).append(",");
    localStringBuffer.append(com.tencent.mm.plugin.video.c.ayd(this.hYP.dnn));
    paramString = localStringBuffer.toString();
    ac.d("MicroMsg.NetScenePreloadVideoFake", "%d rpt content[%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    new dc(paramString).aHZ();
    AppMethodBeat.o(126851);
  }
  
  public final int a(a parama)
  {
    AppMethodBeat.i(126847);
    this.hZj = parama;
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
        ac.i("MicroMsg.NetScenePreloadVideoFake", "%d preload begin msgId[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.msgId) });
        if (this.hZa)
        {
          parama = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().vP(this.msgId);
          localObject = bi.yr(parama.eul);
          if ((localObject == null) || (((bi.b)localObject).hoM <= 0))
          {
            ac.w("MicroMsg.NetScenePreloadVideoFake", "%d msgsource is null", new Object[] { Integer.valueOf(hashCode()) });
            parama = null;
            if (parama != null)
            {
              if (!w.sQ(parama.frx)) {
                break label1007;
              }
              i = 2;
              this.hZf = i;
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 140L, 1L, false);
              if (this.hZf == 1) {
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 121L, 1L, false);
              }
            }
            else
            {
              if (this.hYP != null) {
                break label994;
              }
              this.hYP = parama;
              if (parama != null) {
                break;
              }
              ac.w("MicroMsg.NetScenePreloadVideoFake", "%d preload task is null", new Object[] { Integer.valueOf(hashCode()) });
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
            s locals = u.Ej(str1);
            if (locals == null)
            {
              parama = null;
              continue;
            }
            parama = bv.L(locals.aJK(), "msg");
            if (parama == null)
            {
              ac.w("MicroMsg.NetScenePreloadVideoFake", "cdntra parse video recv xml failed");
              parama = null;
              continue;
            }
            String str2 = (String)parama.get(".msg.videomsg.$cdnvideourl");
            if (bs.isNullOrNil(str2))
            {
              ac.w("MicroMsg.NetScenePreloadVideoFake", "cdntra parse video recv xml failed");
              parama = null;
              continue;
            }
            j = bs.getInt((String)parama.get(".msg.videomsg.$length"), 0);
            String str3 = (String)parama.get(".msg.videomsg.$md5");
            String str4 = (String)parama.get(".msg.videomsg.$newmd5");
            String str5 = (String)parama.get(".msg.videomsg.$aeskey");
            String str6 = (String)parama.get(".msg.videomsg.$fileparam");
            String str7 = com.tencent.mm.an.c.a("downvideo", locals.createTime, locals.getUser(), locals.getFileName());
            if (bs.isNullOrNil(str7))
            {
              ac.w("MicroMsg.NetScenePreloadVideoFake", "cdntra genClientId failed not use cdn file:%s", new Object[] { locals.getFileName() });
              parama = null;
              continue;
            }
            o.aJy();
            String str8 = t.DV(str1);
            parama = new com.tencent.mm.i.h();
            parama.filename = str1;
            parama.fru = str3;
            parama.frv = j;
            parama.frw = 2;
            parama.dng = locals.aJH();
            parama.frx = locals.getUser();
            if (!w.sQ(locals.getUser())) {
              break label997;
            }
            i = q.wb(locals.getUser());
            label521:
            parama.dni = i;
            parama.field_mediaId = str7;
            parama.field_fullpath = str8;
            parama.field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
            parama.field_totalLen = j;
            parama.field_aesKey = str5;
            parama.field_fileId = str2;
            parama.field_priority = com.tencent.mm.i.a.fqp;
            parama.field_wxmsgparam = str6;
            if (!w.sQ(locals.getUser())) {
              break label1002;
            }
            i = 1;
            label588:
            parama.field_chattype = i;
            parama.field_autostart = false;
            parama.field_requestVideoFormat = com.tencent.mm.modelcontrol.d.a(2, locals);
            parama.field_preloadRatio = ((bi.b)localObject).hoM;
            parama.cHq = str4;
            continue;
          }
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 122L, 1L, false);
          continue;
        }
        if (!this.hZi) {
          break label1012;
        }
      }
      catch (Exception parama)
      {
        ac.printErrStackTrace("MicroMsg.NetScenePreloadVideoFake", parama, "", new Object[0]);
        this.hZj = null;
        AppMethodBeat.o(126847);
        return -1;
      }
      i = 4;
      label678:
      this.hZf = i;
      parama = this.hYP;
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 141L, 1L, false);
    }
    if (((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GJM, Integer.valueOf(-1))).intValue() == 2) {
      ac.i("MicroMsg.NetScenePreloadVideoFake", "command set do not check media duplication.");
    }
    for (;;)
    {
      if (i != 0)
      {
        ac.i("MicroMsg.NetScenePreloadVideoFake", "%d it already had video file", new Object[] { Integer.valueOf(hashCode()) });
        i = 0;
        break label215;
        if (parama.VD()) {
          break label1017;
        }
        localObject = parama.fru;
        i = parama.frv;
        str1 = ((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).awI().fT((String)localObject, i);
        j = i - (int)i.aSp(str1);
        if ((bs.isNullOrNil(str1)) || (j < 0) || (j > 16)) {
          break label1017;
        }
        ac.i("MicroMsg.NetScenePreloadVideoFake", "it had download this video[%d, %s, %s].", new Object[] { Integer.valueOf(i), localObject, str1 });
        i.lZ(str1, parama.field_fullpath);
        h(parama.filename, i, (String)localObject);
        i = 1;
        continue;
      }
      parama.frs = this.frs;
      parama.frb = this.hIz;
      parama.frq = 2;
      this.fru = parama.fru;
      this.mediaId = parama.field_mediaId;
      this.hZb = parama.filename;
      this.hZc = bs.aNx();
      this.hZg = parama.cHq;
      ac.i("MicroMsg.NetScenePreloadVideoFake", "%d send to cdn service task[%s]", new Object[] { Integer.valueOf(hashCode()), parama });
      com.tencent.mm.an.f.aDD().b(parama, -1);
      i = 1;
      break label215;
      label994:
      break label187;
      label997:
      i = 0;
      break label521;
      label1002:
      i = 0;
      break label588;
      label1007:
      i = 1;
      break;
      label1012:
      i = 3;
      break label678;
      label1017:
      i = 0;
    }
  }
  
  public final String aJq()
  {
    AppMethodBeat.i(126845);
    if (this.hZa)
    {
      str = this.msgId;
      AppMethodBeat.o(126845);
      return str;
    }
    String str = this.ddB;
    AppMethodBeat.o(126845);
    return str;
  }
  
  final void h(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(126849);
    ac.i("MicroMsg.NetScenePreloadVideoFake", "%d update finish video [%s] [%d] [%s]", new Object[] { Integer.valueOf(hashCode()), paramString1, Integer.valueOf(paramInt), paramString2 });
    if (u.Ej(paramString1) != null)
    {
      u.ar(paramString1, paramInt);
      i(paramInt, paramString2, paramString1);
    }
    AppMethodBeat.o(126849);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(126846);
    ac.i("MicroMsg.NetScenePreloadVideoFake", "%d stop preload video[%s]", new Object[] { Integer.valueOf(hashCode()), this.mediaId });
    if (!bs.isNullOrNil(this.mediaId))
    {
      com.tencent.mm.i.d locald = new com.tencent.mm.i.d();
      b localb = com.tencent.mm.an.f.aDD();
      String str = this.mediaId;
      int i = 0;
      com.tencent.mm.i.g localg = (com.tencent.mm.i.g)localb.hBl.remove(str);
      if (localg != null)
      {
        com.tencent.mm.an.f.aDE();
        i = com.tencent.mm.an.a.c(str, locald);
        com.tencent.mm.plugin.report.service.h.wUl.f(10769, new Object[] { Integer.valueOf(com.tencent.mm.an.c.hBF), Integer.valueOf(localg.field_fileType), Long.valueOf(bs.eWj() - localg.field_startTime) });
      }
      localb.hBk.remove(str);
      localb.hBm.remove(str);
      ac.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { str, localg, Integer.valueOf(i) });
      this.hZd = bs.aNx();
      this.hZe = d(this.hZb, (int)locald.field_recvedBytes, false);
      DK(locald.Vy());
    }
    this.hZj = null;
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