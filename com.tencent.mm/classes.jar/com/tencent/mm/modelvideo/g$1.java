package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.al.b;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.vfs.e;
import java.io.ByteArrayOutputStream;
import java.util.Map;

final class g$1
  implements g.a
{
  g$1(g paramg) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(50695);
    ab.d("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { g.a(this.fWg), g.b(this.fWg), Integer.valueOf(paramInt), paramc, paramd });
    if (paramInt == -21005)
    {
      ab.d("MicroMsg.NetSceneUploadVideo", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { g.b(this.fWg) });
      AppMethodBeat.o(50695);
      return 0;
    }
    if (paramInt != 0)
    {
      u.vk(g.c(this.fWg));
      new com.tencent.mm.g.b.a.f(a.s(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1), Long.valueOf(g.d(this.fWg)), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(ah.getContext())), Integer.valueOf(g.e(this.fWg)), Integer.valueOf(0), "" })).ake();
      g.f(this.fWg).onSceneEnd(3, paramInt, "", this.fWg);
      AppMethodBeat.o(50695);
      return 0;
    }
    g.a(this.fWg, u.vr(g.c(this.fWg)));
    if ((g.g(this.fWg) == null) || (g.g(this.fWg).status == 105))
    {
      if (g.g(this.fWg) == null) {}
      for (int i = -1;; i = g.g(this.fWg).status)
      {
        ab.i("MicroMsg.NetSceneUploadVideo", "%s info is null or has paused, status:%d", new Object[] { g.a(this.fWg), Integer.valueOf(i) });
        com.tencent.mm.al.f.afO().sI(g.b(this.fWg));
        g.f(this.fWg).onSceneEnd(3, paramInt, "info is null or has paused, status".concat(String.valueOf(i)), this.fWg);
        AppMethodBeat.o(50695);
        return 0;
      }
    }
    if (paramc != null)
    {
      if (g.g(this.fWg).fWa > paramc.field_finishedLength)
      {
        ab.w("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnEndProc error oldpos:%d newpos:%d", new Object[] { g.a(this.fWg), Integer.valueOf(g.g(this.fWg).fWa), Integer.valueOf(paramc.field_finishedLength) });
        AppMethodBeat.o(50695);
        return 0;
      }
      g.g(this.fWg).fXv = bo.aox();
      g.g(this.fWg).fWa = paramc.field_finishedLength;
      g.g(this.fWg).bsY = 1032;
      u.f(g.g(this.fWg));
      AppMethodBeat.o(50695);
      return 0;
    }
    if (paramd != null)
    {
      if (paramd.field_retCode != 0)
      {
        ab.e("MicroMsg.NetSceneUploadVideo", "%s cdntra sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { g.a(this.fWg), Integer.valueOf(paramd.field_retCode), paramd.field_arg, paramd.field_transInfo });
        u.vk(g.c(this.fWg));
        paramString = a.s(new Object[] { Integer.valueOf(paramd.field_retCode), Integer.valueOf(1), Long.valueOf(g.d(this.fWg)), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(ah.getContext())), Integer.valueOf(g.e(this.fWg)), Integer.valueOf(paramd.field_fileLength), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.edb });
        new com.tencent.mm.g.b.a.f(paramString).ake();
        new com.tencent.mm.g.b.a.d(paramString).ake();
        g.f(this.fWg).onSceneEnd(3, paramd.field_retCode, "", this.fWg);
      }
    }
    else
    {
      AppMethodBeat.o(50695);
      return 0;
    }
    ab.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn uploadvideo by cdn, videohash isHitCacheUpload: %d, enableHitcheck:%b", new Object[] { g.a(this.fWg), Integer.valueOf(paramd.field_UploadHitCacheType), Boolean.valueOf(g.h(this.fWg)) });
    paramString = com.tencent.mm.plugin.report.service.h.qsU;
    if (g.i(this.fWg))
    {
      paramInt = 810;
      label841:
      paramString.e(12696, new Object[] { Integer.valueOf(paramInt + paramd.field_UploadHitCacheType), Integer.valueOf(g.g(this.fWg).fsd) });
      paramBoolean = paramd.field_isVideoReduced;
      ab.i("MicroMsg.NetSceneUploadVideo", "%s it video was reduced by cdn %b %s", new Object[] { g.a(this.fWg), Boolean.valueOf(paramBoolean), g.c(this.fWg) });
      if (paramBoolean) {
        break label1601;
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(106L, 205L, 1L, false);
      if ((g.k(this.fWg) > 0) && (paramd.field_thumbimgLength > 0))
      {
        ab.i("MicroMsg.NetSceneUploadVideo", "%s send video thumb too big thumb length [%d, %d] ", new Object[] { g.a(this.fWg), Integer.valueOf(g.k(this.fWg)), Integer.valueOf(paramd.field_thumbimgLength) });
        if (g.k(this.fWg) * 2 <= paramd.field_thumbimgLength) {
          break label1567;
        }
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(106L, 206L, 1L, false);
      }
      label1041:
      o.alE();
      paramInt = (int)e.avI(t.vf(g.c(this.fWg)));
      ab.i("MicroMsg.NetSceneUploadVideo", "%s send video too big thumb length [%d, %d] ", new Object[] { g.a(this.fWg), Integer.valueOf(g.g(this.fWg).fsd), Integer.valueOf(paramInt) });
      if (g.g(this.fWg).fsd == paramInt) {
        break label1584;
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(106L, 208L, 1L, false);
      label1133:
      g.a(this.fWg, u.vr(g.c(this.fWg)));
      if (bo.isNullOrNil(g.g(this.fWg).alP()))
      {
        paramString = "<msg><videomsg aeskey=\"" + paramd.field_aesKey + "\" cdnthumbaeskey=\"" + paramd.field_aesKey + "\" cdnvideourl=\"" + paramd.field_fileId + "\" ";
        paramString = paramString + "cdnthumburl=\"" + paramd.field_fileId + "\" ";
        paramString = paramString + "length=\"" + paramd.field_fileLength + "\" ";
        paramString = paramString + "cdnthumblength=\"" + paramd.field_thumbimgLength + "\"/></msg>";
        ab.i("MicroMsg.NetSceneUploadVideo", "%s cdn callback new build cdnInfo:%s", new Object[] { g.a(this.fWg), paramString });
        g.g(this.fWg).fXD = paramString;
        u.f(g.g(this.fWg));
      }
      paramString = br.F(g.g(this.fWg).alP(), "msg");
      if (paramString != null)
      {
        paramc = o.alE();
        o.alE();
        boolean bool = paramc.s(t.vf(g.c(this.fWg)), (String)paramString.get(".msg.videomsg.$cdnvideourl"), (String)paramString.get(".msg.videomsg.$aeskey"));
        paramString = com.tencent.mm.plugin.report.service.h.qsU;
        if (!bool) {
          break label1618;
        }
        paramInt = 1;
        label1456:
        paramString.e(12696, new Object[] { Integer.valueOf(paramInt + 900), Integer.valueOf(g.g(this.fWg).fsd) });
      }
      paramString = com.tencent.mm.kernel.g.Rc();
      paramc = g.c(this.fWg);
      if (!paramBoolean) {
        break label1623;
      }
    }
    label1567:
    label1584:
    label1601:
    label1618:
    label1623:
    for (paramInt = 0;; paramInt = g.l(this.fWg))
    {
      paramString.a(new h(paramc, paramInt, paramd, new g.1.1(this, paramd)), 0);
      break;
      if (g.j(this.fWg))
      {
        paramInt = 820;
        break label841;
      }
      paramInt = 830;
      break label841;
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(106L, 207L, 1L, false);
      break label1041;
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(106L, 209L, 1L, false);
      break label1133;
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(106L, 200L, 1L, false);
      break label1133;
      paramInt = 2;
      break label1456;
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvideo.g.1
 * JD-Core Version:    0.7.0.1
 */