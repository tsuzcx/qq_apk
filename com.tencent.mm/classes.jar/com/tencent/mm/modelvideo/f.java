package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.b;
import com.tencent.mm.g.b.a.bo;
import com.tencent.mm.g.c.du;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.model.q;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.bk;
import com.tencent.mm.vfs.i;
import java.io.ByteArrayOutputStream;
import java.util.Map;

public final class f
{
  public String dgg;
  private g.b fnY;
  String foa;
  private g.a hhW;
  String hyA;
  private long hyB;
  long hyC;
  long hyD;
  int hyE;
  private String hyF;
  public long hyG;
  public boolean hyH;
  public a hyI;
  private com.tencent.mm.i.h hyo;
  boolean hyz;
  private String mediaId;
  long msgId;
  
  public f(long paramLong)
  {
    AppMethodBeat.i(126843);
    this.hyz = false;
    this.hhW = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(126841);
        if (paramAnonymousInt != 0)
        {
          ad.w("MicroMsg.NetScenePreloadVideoFake", "%d preload video error startRet[%d]", new Object[] { Integer.valueOf(f.this.hashCode()), Integer.valueOf(paramAnonymousInt) });
          if (f.this.hyI != null) {
            f.this.hyI.a(f.this, false, 0, 0);
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
          if (f.this.hyI != null) {
            f.this.hyI.a(f.this, false, 0, 0);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(126841);
          return 0;
          label205:
          ad.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video download all video file", new Object[] { Integer.valueOf(f.this.hashCode()) });
          f.this.h(f.this.hyA, (int)paramAnonymousd.field_fileLength, f.this.foa);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    this.fnY = new g.b()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.i.d paramAnonymousd)
      {
        AppMethodBeat.i(126842);
        if (paramAnonymousd == null)
        {
          ad.w("MicroMsg.NetScenePreloadVideoFake", "%s onPreload completed but sceneResult is null", new Object[] { Integer.valueOf(f.this.hashCode()) });
          if (f.this.hyI != null) {
            f.this.hyI.a(f.this, false, 0, 0);
          }
          AppMethodBeat.o(126842);
          return;
        }
        int i = (int)paramAnonymousd.field_recvedBytes;
        int j = (int)paramAnonymousd.field_fileLength;
        ad.i("MicroMsg.NetScenePreloadVideoFake", "%d onPreload Completed [%s] videoInfoName[%s] [%d, %d] videoFormat[%d]", new Object[] { Integer.valueOf(f.this.hashCode()), paramAnonymousString, f.this.hyA, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramAnonymousd.field_videoFormat) });
        if ((i > 0) && (j > 0)) {
          f.this.hyD = f.d(f.this.hyA, i, true);
        }
        boolean bool;
        if (f.this.hyI != null)
        {
          paramAnonymousString = f.this.hyI;
          f localf = f.this;
          if ((i > 0) && (j > 0))
          {
            bool = true;
            paramAnonymousString.a(localf, bool, i, j);
          }
        }
        else
        {
          f.this.hyC = bt.aGK();
          f.this.zF(paramAnonymousd.UD());
          if (!f.this.hyz) {
            break label342;
          }
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 142L, 1L, false);
          if (f.this.hyE != 1) {
            break label325;
          }
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 123L, 1L, false);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, paramAnonymousd.field_videoFormat + 240, 1L, false);
          AppMethodBeat.o(126842);
          return;
          bool = false;
          break;
          label325:
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 124L, 1L, false);
        }
        label342:
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 143L, 1L, false);
        AppMethodBeat.o(126842);
      }
    };
    this.msgId = paramLong;
    this.hyz = true;
    AppMethodBeat.o(126843);
  }
  
  public f(com.tencent.mm.i.h paramh, String paramString)
  {
    AppMethodBeat.i(126844);
    this.hyz = false;
    this.hhW = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(126841);
        if (paramAnonymousInt != 0)
        {
          ad.w("MicroMsg.NetScenePreloadVideoFake", "%d preload video error startRet[%d]", new Object[] { Integer.valueOf(f.this.hashCode()), Integer.valueOf(paramAnonymousInt) });
          if (f.this.hyI != null) {
            f.this.hyI.a(f.this, false, 0, 0);
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
          if (f.this.hyI != null) {
            f.this.hyI.a(f.this, false, 0, 0);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(126841);
          return 0;
          label205:
          ad.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video download all video file", new Object[] { Integer.valueOf(f.this.hashCode()) });
          f.this.h(f.this.hyA, (int)paramAnonymousd.field_fileLength, f.this.foa);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    this.fnY = new g.b()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.i.d paramAnonymousd)
      {
        AppMethodBeat.i(126842);
        if (paramAnonymousd == null)
        {
          ad.w("MicroMsg.NetScenePreloadVideoFake", "%s onPreload completed but sceneResult is null", new Object[] { Integer.valueOf(f.this.hashCode()) });
          if (f.this.hyI != null) {
            f.this.hyI.a(f.this, false, 0, 0);
          }
          AppMethodBeat.o(126842);
          return;
        }
        int i = (int)paramAnonymousd.field_recvedBytes;
        int j = (int)paramAnonymousd.field_fileLength;
        ad.i("MicroMsg.NetScenePreloadVideoFake", "%d onPreload Completed [%s] videoInfoName[%s] [%d, %d] videoFormat[%d]", new Object[] { Integer.valueOf(f.this.hashCode()), paramAnonymousString, f.this.hyA, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramAnonymousd.field_videoFormat) });
        if ((i > 0) && (j > 0)) {
          f.this.hyD = f.d(f.this.hyA, i, true);
        }
        boolean bool;
        if (f.this.hyI != null)
        {
          paramAnonymousString = f.this.hyI;
          f localf = f.this;
          if ((i > 0) && (j > 0))
          {
            bool = true;
            paramAnonymousString.a(localf, bool, i, j);
          }
        }
        else
        {
          f.this.hyC = bt.aGK();
          f.this.zF(paramAnonymousd.UD());
          if (!f.this.hyz) {
            break label342;
          }
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 142L, 1L, false);
          if (f.this.hyE != 1) {
            break label325;
          }
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 123L, 1L, false);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, paramAnonymousd.field_videoFormat + 240, 1L, false);
          AppMethodBeat.o(126842);
          return;
          bool = false;
          break;
          label325:
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 124L, 1L, false);
        }
        label342:
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 143L, 1L, false);
        AppMethodBeat.o(126842);
      }
    };
    this.hyo = paramh;
    this.dgg = paramString;
    this.hyz = false;
    AppMethodBeat.o(126844);
  }
  
  static int d(String paramString, int paramInt, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(126848);
    s locals = u.Ae(paramString);
    int j;
    if (locals != null)
    {
      j = locals.dpA;
      if (paramBoolean)
      {
        locals.dpA = paramInt;
        ad.i("MicroMsg.NetScenePreloadVideoFake", "update video info[%s] preload[%d %d %d] isFinish[%b] ", new Object[] { paramString, Integer.valueOf(j), Integer.valueOf(paramInt), Integer.valueOf(locals.dpA), Boolean.valueOf(paramBoolean) });
        locals.hAg = bt.aGK();
        locals.dtM = 1025;
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
      locals.dpA = (j + paramInt);
      break;
      break label114;
      AppMethodBeat.o(126848);
      return paramInt;
    }
  }
  
  private static boolean j(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(126850);
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(126850);
      return false;
    }
    o.aCI();
    paramString2 = t.zQ(paramString2);
    if ((bt.isNullOrNil(paramString1)) || (paramInt <= 0) || (bt.isNullOrNil(paramString2)) || (!i.eK(paramString2)))
    {
      ad.w("MicroMsg.NetScenePreloadVideoFake", "insert media duplication but args is error.[%d, %s, %s]", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
      AppMethodBeat.o(126850);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).apT().E(paramString1, paramInt, paramString2);
    AppMethodBeat.o(126850);
    return bool;
  }
  
  public final int a(a parama)
  {
    AppMethodBeat.i(126847);
    this.hyI = parama;
    Object localObject;
    int i;
    label185:
    label212:
    String str1;
    int j;
    for (;;)
    {
      try
      {
        ad.i("MicroMsg.NetScenePreloadVideoFake", "%d preload begin msgId[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.msgId) });
        if (this.hyz)
        {
          parama = ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().rm(this.msgId);
          localObject = bi.ul(parama.esh);
          if ((localObject == null) || (((bi.b)localObject).gOm <= 0))
          {
            ad.w("MicroMsg.NetScenePreloadVideoFake", "%d msgsource is null", new Object[] { Integer.valueOf(hashCode()) });
            parama = null;
            if (parama != null)
            {
              if (!w.pF(parama.fod)) {
                break label1003;
              }
              i = 2;
              this.hyE = i;
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 140L, 1L, false);
              if (this.hyE == 1) {
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 121L, 1L, false);
              }
            }
            else
            {
              if (this.hyo != null) {
                break label990;
              }
              this.hyo = parama;
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
            s locals = u.Ae(str1);
            if (locals == null)
            {
              parama = null;
              continue;
            }
            parama = bw.K(locals.aCT(), "msg");
            if (parama == null)
            {
              ad.w("MicroMsg.NetScenePreloadVideoFake", "cdntra parse video recv xml failed");
              parama = null;
              continue;
            }
            String str2 = (String)parama.get(".msg.videomsg.$cdnvideourl");
            if (bt.isNullOrNil(str2))
            {
              ad.w("MicroMsg.NetScenePreloadVideoFake", "cdntra parse video recv xml failed");
              parama = null;
              continue;
            }
            j = bt.getInt((String)parama.get(".msg.videomsg.$length"), 0);
            String str3 = (String)parama.get(".msg.videomsg.$md5");
            String str4 = (String)parama.get(".msg.videomsg.$newmd5");
            String str5 = (String)parama.get(".msg.videomsg.$aeskey");
            String str6 = (String)parama.get(".msg.videomsg.$fileparam");
            String str7 = com.tencent.mm.ao.c.a("downvideo", locals.createTime, locals.getUser(), locals.getFileName());
            if (bt.isNullOrNil(str7))
            {
              ad.w("MicroMsg.NetScenePreloadVideoFake", "cdntra genClientId failed not use cdn file:%s", new Object[] { locals.getFileName() });
              parama = null;
              continue;
            }
            o.aCI();
            String str8 = t.zQ(str1);
            parama = new com.tencent.mm.i.h();
            parama.filename = str1;
            parama.foa = str3;
            parama.fob = j;
            parama.foc = 2;
            parama.dpv = locals.aCQ();
            parama.fod = locals.getUser();
            if (!w.pF(locals.getUser())) {
              break label993;
            }
            i = q.rY(locals.getUser());
            label517:
            parama.dpx = i;
            parama.field_mediaId = str7;
            parama.field_fullpath = str8;
            parama.field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
            parama.field_totalLen = j;
            parama.field_aesKey = str5;
            parama.field_fileId = str2;
            parama.field_priority = com.tencent.mm.i.a.fmV;
            parama.field_wxmsgparam = str6;
            if (!w.pF(locals.getUser())) {
              break label998;
            }
            i = 1;
            label584:
            parama.field_chattype = i;
            parama.field_autostart = false;
            parama.field_requestVideoFormat = com.tencent.mm.modelcontrol.d.a(2, locals);
            parama.field_preloadRatio = ((bi.b)localObject).gOm;
            parama.cKi = str4;
            continue;
          }
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 122L, 1L, false);
          continue;
        }
        if (!this.hyH) {
          break label1008;
        }
      }
      catch (Exception parama)
      {
        ad.printErrStackTrace("MicroMsg.NetScenePreloadVideoFake", parama, "", new Object[0]);
        this.hyI = null;
        AppMethodBeat.o(126847);
        return -1;
      }
      i = 4;
      label674:
      this.hyE = i;
      parama = this.hyo;
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 141L, 1L, false);
    }
    if (((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FlX, Integer.valueOf(-1))).intValue() == 2) {
      ad.i("MicroMsg.NetScenePreloadVideoFake", "command set do not check media duplication.");
    }
    for (;;)
    {
      if (i != 0)
      {
        ad.i("MicroMsg.NetScenePreloadVideoFake", "%d it already had video file", new Object[] { Integer.valueOf(hashCode()) });
        i = 0;
        break label212;
        if (parama.UI()) {
          break label1013;
        }
        localObject = parama.foa;
        i = parama.fob;
        str1 = ((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).apT().fP((String)localObject, i);
        j = i - (int)i.aMN(str1);
        if ((bt.isNullOrNil(str1)) || (j < 0) || (j > 16)) {
          break label1013;
        }
        ad.i("MicroMsg.NetScenePreloadVideoFake", "it had download this video[%d, %s, %s].", new Object[] { Integer.valueOf(i), localObject, str1 });
        i.lC(str1, parama.field_fullpath);
        h(parama.filename, i, (String)localObject);
        i = 1;
        continue;
      }
      parama.fnY = this.fnY;
      parama.fnH = this.hhW;
      parama.fnW = 2;
      this.foa = parama.foa;
      this.mediaId = parama.field_mediaId;
      this.hyA = parama.filename;
      this.hyB = bt.aGK();
      this.hyF = parama.cKi;
      ad.i("MicroMsg.NetScenePreloadVideoFake", "%d send to cdn service task[%s]", new Object[] { Integer.valueOf(hashCode()), parama });
      com.tencent.mm.ao.f.awL().b(parama, -1);
      i = 1;
      break label212;
      label990:
      break label185;
      label993:
      i = 0;
      break label517;
      label998:
      i = 0;
      break label584;
      label1003:
      i = 1;
      break;
      label1008:
      i = 3;
      break label674;
      label1013:
      i = 0;
    }
  }
  
  public final String aCz()
  {
    AppMethodBeat.i(126845);
    if (this.hyz)
    {
      str = this.msgId;
      AppMethodBeat.o(126845);
      return str;
    }
    String str = this.dgg;
    AppMethodBeat.o(126845);
    return str;
  }
  
  final void h(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(126849);
    ad.i("MicroMsg.NetScenePreloadVideoFake", "%d update finish video [%s] [%d] [%s]", new Object[] { Integer.valueOf(hashCode()), paramString1, Integer.valueOf(paramInt), paramString2 });
    if (u.Ae(paramString1) != null)
    {
      u.an(paramString1, paramInt);
      j(paramInt, paramString2, paramString1);
    }
    AppMethodBeat.o(126849);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(126846);
    ad.i("MicroMsg.NetScenePreloadVideoFake", "%d stop preload video[%s]", new Object[] { Integer.valueOf(hashCode()), this.mediaId });
    if (!bt.isNullOrNil(this.mediaId))
    {
      com.tencent.mm.i.d locald = new com.tencent.mm.i.d();
      b localb = com.tencent.mm.ao.f.awL();
      String str = this.mediaId;
      int i = 0;
      com.tencent.mm.i.g localg = (com.tencent.mm.i.g)localb.haK.remove(str);
      if (localg != null)
      {
        com.tencent.mm.ao.f.awM();
        i = com.tencent.mm.ao.a.b(str, locald);
        com.tencent.mm.plugin.report.service.h.vKh.f(10769, new Object[] { Integer.valueOf(com.tencent.mm.ao.c.hbe), Integer.valueOf(localg.field_fileType), Long.valueOf(bt.eGO() - localg.field_startTime) });
      }
      localb.haJ.remove(str);
      localb.haL.remove(str);
      ad.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { str, localg, Integer.valueOf(i) });
      this.hyC = bt.aGK();
      this.hyD = d(this.hyA, (int)locald.field_recvedBytes, false);
      zF(locald.UD());
    }
    this.hyI = null;
    AppMethodBeat.o(126846);
  }
  
  final void zF(String paramString)
  {
    AppMethodBeat.i(126851);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.hyB).append(",");
    localStringBuffer.append(this.hyC).append(",");
    localStringBuffer.append(this.hyD).append(",");
    localStringBuffer.append(this.hyF).append(",");
    localStringBuffer.append(this.hyE).append(",");
    try
    {
      long l = this.hyD / 1024L / (this.hyC - this.hyB);
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
    localStringBuffer.append(this.hyo.dpv).append(",");
    localStringBuffer.append(this.hyo.fod).append(",");
    localStringBuffer.append(this.hyo.dpx).append(",");
    localStringBuffer.append(this.hyo.field_fileId).append(",");
    localStringBuffer.append(this.hyo.url).append(",");
    localStringBuffer.append(com.tencent.mm.plugin.video.c.asU(this.hyo.dpC));
    paramString = localStringBuffer.toString();
    ad.d("MicroMsg.NetScenePreloadVideoFake", "%d rpt content[%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    new bo(paramString).aBj();
    AppMethodBeat.o(126851);
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