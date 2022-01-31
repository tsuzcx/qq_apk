package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bf.b;
import com.tencent.mm.model.n;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bh;
import java.util.Map;

public final class f
{
  private String cBO;
  long cpO;
  public String crk;
  private g.b edF;
  String edH;
  private g.a fFy;
  private com.tencent.mm.i.h fVE;
  boolean fVP;
  String fVQ;
  private long fVR;
  long fVS;
  long fVT;
  int fVU;
  private String fVV;
  public f.a fVW;
  
  public f(long paramLong)
  {
    AppMethodBeat.i(50684);
    this.fVP = false;
    this.fFy = new f.1(this);
    this.edF = new f.2(this);
    this.cpO = paramLong;
    this.fVP = true;
    AppMethodBeat.o(50684);
  }
  
  public f(com.tencent.mm.i.h paramh, String paramString)
  {
    AppMethodBeat.i(50685);
    this.fVP = false;
    this.fFy = new f.1(this);
    this.edF = new f.2(this);
    this.fVE = paramh;
    this.crk = paramString;
    this.fVP = false;
    AppMethodBeat.o(50685);
  }
  
  static int e(String paramString, int paramInt, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(50689);
    s locals = u.vr(paramString);
    int j;
    if (locals != null)
    {
      j = locals.czu;
      if (paramBoolean)
      {
        locals.czu = paramInt;
        ab.i("MicroMsg.NetScenePreloadVideoFake", "update video info[%s] preload[%d %d %d] isFinish[%b] ", new Object[] { paramString, Integer.valueOf(j), Integer.valueOf(paramInt), Integer.valueOf(locals.czu), Boolean.valueOf(paramBoolean) });
        locals.fXv = bo.aox();
        locals.bsY = 1025;
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
      AppMethodBeat.o(50689);
      return paramInt;
      locals.czu = (j + paramInt);
      break;
      break label114;
      AppMethodBeat.o(50689);
      return paramInt;
    }
  }
  
  private static boolean i(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(50691);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(50691);
      return false;
    }
    o.alE();
    paramString2 = t.vf(paramString2);
    if ((bo.isNullOrNil(paramString1)) || (paramInt <= 0) || (bo.isNullOrNil(paramString2)) || (!com.tencent.mm.vfs.e.cN(paramString2)))
    {
      ab.w("MicroMsg.NetScenePreloadVideoFake", "insert media duplication but args is error.[%d, %s, %s]", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
      AppMethodBeat.o(50691);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.m.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.m.a.a.class)).YH().y(paramString1, paramInt, paramString2);
    AppMethodBeat.o(50691);
    return bool;
  }
  
  public final int a(f.a parama)
  {
    AppMethodBeat.i(50688);
    this.fVW = parama;
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
        ab.i("MicroMsg.NetScenePreloadVideoFake", "%d preload begin msgId[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.cpO) });
        if (this.fVP)
        {
          parama = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().kB(this.cpO);
          localObject = bf.pA(parama.dns);
          if ((localObject == null) || (((bf.b)localObject).fmU <= 0))
          {
            ab.w("MicroMsg.NetScenePreloadVideoFake", "%d msgsource is null", new Object[] { Integer.valueOf(hashCode()) });
            parama = null;
            if (parama != null)
            {
              if (!com.tencent.mm.model.t.lA(parama.edK)) {
                break label996;
              }
              i = 2;
              this.fVU = i;
              com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 140L, 1L, false);
              if (this.fVU == 1) {
                com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 121L, 1L, false);
              }
            }
            else
            {
              if (this.fVE != null) {
                break label983;
              }
              this.fVE = parama;
              if (parama != null) {
                break;
              }
              ab.w("MicroMsg.NetScenePreloadVideoFake", "%d preload task is null", new Object[] { Integer.valueOf(hashCode()) });
              i = 0;
              if (i == 0) {
                continue;
              }
              AppMethodBeat.o(50688);
              return 0;
            }
          }
          else
          {
            str1 = parama.field_imgPath;
            s locals = u.vr(str1);
            if (locals == null)
            {
              parama = null;
              continue;
            }
            parama = br.F(locals.alP(), "msg");
            if (parama == null)
            {
              ab.w("MicroMsg.NetScenePreloadVideoFake", "cdntra parse video recv xml failed");
              parama = null;
              continue;
            }
            String str2 = (String)parama.get(".msg.videomsg.$cdnvideourl");
            if (bo.isNullOrNil(str2))
            {
              ab.w("MicroMsg.NetScenePreloadVideoFake", "cdntra parse video recv xml failed");
              parama = null;
              continue;
            }
            j = Integer.valueOf((String)parama.get(".msg.videomsg.$length")).intValue();
            String str3 = (String)parama.get(".msg.videomsg.$md5");
            String str4 = (String)parama.get(".msg.videomsg.$newmd5");
            String str5 = (String)parama.get(".msg.videomsg.$aeskey");
            String str6 = (String)parama.get(".msg.videomsg.$fileparam");
            String str7 = com.tencent.mm.al.c.a("downvideo", locals.createTime, locals.getUser(), locals.getFileName());
            if (bo.isNullOrNil(str7))
            {
              ab.w("MicroMsg.NetScenePreloadVideoFake", "cdntra genClientId failed not use cdn file:%s", new Object[] { locals.getFileName() });
              parama = null;
              continue;
            }
            o.alE();
            String str8 = t.vf(str1);
            parama = new com.tencent.mm.i.h();
            parama.filename = str1;
            parama.edH = str3;
            parama.edI = j;
            parama.edJ = 2;
            parama.czp = locals.alM();
            parama.edK = locals.getUser();
            if (!com.tencent.mm.model.t.lA(locals.getUser())) {
              break label986;
            }
            i = n.nv(locals.getUser());
            label519:
            parama.czr = i;
            parama.field_mediaId = str7;
            parama.field_fullpath = str8;
            parama.field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
            parama.field_totalLen = j;
            parama.field_aesKey = str5;
            parama.field_fileId = str2;
            parama.field_priority = com.tencent.mm.i.a.ecF;
            parama.field_wxmsgparam = str6;
            if (!com.tencent.mm.model.t.lA(locals.getUser())) {
              break label991;
            }
            i = 1;
            label586:
            parama.field_chattype = i;
            parama.field_autostart = false;
            parama.field_requestVideoFormat = com.tencent.mm.modelcontrol.d.a(2, locals);
            parama.field_preloadRatio = ((bf.b)localObject).fmU;
            parama.bWM = str4;
            continue;
          }
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 122L, 1L, false);
          continue;
        }
        this.fVU = 3;
      }
      catch (Exception parama)
      {
        ab.printErrStackTrace("MicroMsg.NetScenePreloadVideoFake", parama, "", new Object[0]);
        this.fVW = null;
        AppMethodBeat.o(50688);
        return -1;
      }
      parama = this.fVE;
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 141L, 1L, false);
    }
    if (((Integer)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yDz, Integer.valueOf(-1))).intValue() == 2) {
      ab.i("MicroMsg.NetScenePreloadVideoFake", "command set do not check media duplication.");
    }
    for (;;)
    {
      if (i != 0)
      {
        ab.i("MicroMsg.NetScenePreloadVideoFake", "%d it already had video file", new Object[] { Integer.valueOf(hashCode()) });
        i = 0;
        break label212;
        if (parama.Js()) {
          break label1001;
        }
        localObject = parama.edH;
        i = parama.edI;
        str1 = ((com.tencent.mm.plugin.m.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.m.a.a.class)).YH().eG((String)localObject, i);
        j = i - (int)com.tencent.mm.vfs.e.avI(str1);
        if ((bo.isNullOrNil(str1)) || (j < 0) || (j > 16)) {
          break label1001;
        }
        ab.i("MicroMsg.NetScenePreloadVideoFake", "it had download this video[%d, %s, %s].", new Object[] { Integer.valueOf(i), localObject, str1 });
        com.tencent.mm.vfs.e.C(str1, parama.field_fullpath);
        e(parama.filename, i, (String)localObject);
        i = 1;
        continue;
      }
      parama.edF = this.edF;
      parama.edp = this.fFy;
      parama.edD = 2;
      this.edH = parama.edH;
      this.cBO = parama.field_mediaId;
      this.fVQ = parama.filename;
      this.fVR = bo.aox();
      this.fVV = parama.bWM;
      ab.i("MicroMsg.NetScenePreloadVideoFake", "%d send to cdn service task[%s]", new Object[] { Integer.valueOf(hashCode()), parama });
      com.tencent.mm.al.f.afO().b(parama, -1);
      i = 1;
      break label212;
      label983:
      break label185;
      label986:
      i = 0;
      break label519;
      label991:
      i = 0;
      break label586;
      label996:
      i = 1;
      break;
      label1001:
      i = 0;
    }
  }
  
  public final String alv()
  {
    AppMethodBeat.i(50686);
    if (this.fVP)
    {
      str = this.cpO;
      AppMethodBeat.o(50686);
      return str;
    }
    String str = this.crk;
    AppMethodBeat.o(50686);
    return str;
  }
  
  final void e(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(50690);
    ab.i("MicroMsg.NetScenePreloadVideoFake", "%d update finish video [%s] [%d] [%s]", new Object[] { Integer.valueOf(hashCode()), paramString1, Integer.valueOf(paramInt), paramString2 });
    if (u.vr(paramString1) != null)
    {
      u.ae(paramString1, paramInt);
      i(paramInt, paramString2, paramString1);
    }
    AppMethodBeat.o(50690);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(50687);
    ab.i("MicroMsg.NetScenePreloadVideoFake", "%d stop preload video[%s]", new Object[] { Integer.valueOf(hashCode()), this.cBO });
    if (!bo.isNullOrNil(this.cBO))
    {
      com.tencent.mm.i.d locald = new com.tencent.mm.i.d();
      b localb = com.tencent.mm.al.f.afO();
      String str = this.cBO;
      int i = 0;
      com.tencent.mm.i.g localg = (com.tencent.mm.i.g)localb.fyM.remove(str);
      if (localg != null)
      {
        com.tencent.mm.al.f.afP();
        i = com.tencent.mm.al.a.b(str, locald);
        com.tencent.mm.plugin.report.service.h.qsU.e(10769, new Object[] { Integer.valueOf(com.tencent.mm.al.c.fzg), Integer.valueOf(localg.field_fileType), Long.valueOf(bo.aoy() - localg.field_startTime) });
      }
      localb.fyL.remove(str);
      localb.fyN.remove(str);
      ab.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { str, localg, Integer.valueOf(i) });
      this.fVS = bo.aox();
      this.fVT = e(this.fVQ, locald.field_recvedBytes, false);
      uT(locald.Jn());
    }
    this.fVW = null;
    AppMethodBeat.o(50687);
  }
  
  final void uT(String paramString)
  {
    AppMethodBeat.i(50692);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.fVR).append(",");
    localStringBuffer.append(this.fVS).append(",");
    localStringBuffer.append(this.fVT).append(",");
    localStringBuffer.append(this.fVV).append(",");
    localStringBuffer.append(this.fVU).append(",");
    try
    {
      long l = this.fVT / 1024L / (this.fVS - this.fVR);
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
    localStringBuffer.append(this.fVE.czp).append(",");
    localStringBuffer.append(this.fVE.edK).append(",");
    localStringBuffer.append(this.fVE.czr).append(",");
    localStringBuffer.append(this.fVE.field_fileId).append(",");
    localStringBuffer.append(this.fVE.url).append(",");
    localStringBuffer.append(com.tencent.mm.plugin.video.c.aeA(this.fVE.czw));
    paramString = localStringBuffer.toString();
    ab.d("MicroMsg.NetScenePreloadVideoFake", "%d rpt content[%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    new com.tencent.mm.g.b.a.z(paramString).ake();
    AppMethodBeat.o(50692);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvideo.f
 * JD-Core Version:    0.7.0.1
 */