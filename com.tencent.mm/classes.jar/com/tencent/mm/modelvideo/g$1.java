package com.tencent.mm.modelvideo;

import com.tencent.mm.ah.p;
import com.tencent.mm.ak.b;
import com.tencent.mm.j.f.a;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.io.ByteArrayOutputStream;
import java.util.Map;

final class g$1
  implements f.a
{
  g$1(g paramg) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.j.c paramc, com.tencent.mm.j.d paramd, boolean paramBoolean)
  {
    y.d("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { g.a(this.eGq), g.b(this.eGq), Integer.valueOf(paramInt), paramc, paramd });
    if (paramInt == -21005)
    {
      y.d("MicroMsg.NetSceneUploadVideo", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { g.b(this.eGq) });
      return 0;
    }
    if (paramInt != 0)
    {
      u.nX(g.c(this.eGq));
      new com.tencent.mm.h.b.a.f(a.n(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1), Long.valueOf(g.d(this.eGq)), Long.valueOf(bk.UY()), Integer.valueOf(com.tencent.mm.ak.c.bx(ae.getContext())), Integer.valueOf(g.e(this.eGq)), Integer.valueOf(0), "" })).QX();
      g.f(this.eGq).onSceneEnd(3, paramInt, "", this.eGq);
      return 0;
    }
    g.a(this.eGq, u.oe(g.c(this.eGq)));
    if ((g.g(this.eGq) == null) || (g.g(this.eGq).status == 105))
    {
      if (g.g(this.eGq) == null) {}
      for (int i = -1;; i = g.g(this.eGq).status)
      {
        y.i("MicroMsg.NetSceneUploadVideo", "%s info is null or has paused, status:%d", new Object[] { g.a(this.eGq), Integer.valueOf(i) });
        com.tencent.mm.ak.f.Nd().lL(g.b(this.eGq));
        g.f(this.eGq).onSceneEnd(3, paramInt, "info is null or has paused, status" + i, this.eGq);
        return 0;
      }
    }
    if (paramc != null)
    {
      if (g.g(this.eGq).eGk > paramc.field_finishedLength)
      {
        y.w("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnEndProc error oldpos:%d newpos:%d", new Object[] { g.a(this.eGq), Integer.valueOf(g.g(this.eGq).eGk), Integer.valueOf(paramc.field_finishedLength) });
        return 0;
      }
      g.g(this.eGq).eHF = bk.UX();
      g.g(this.eGq).eGk = paramc.field_finishedLength;
      g.g(this.eGq).bcw = 1032;
      u.f(g.g(this.eGq));
      return 0;
    }
    if (paramd != null)
    {
      if (paramd.field_retCode != 0)
      {
        y.e("MicroMsg.NetSceneUploadVideo", "%s cdntra sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { g.a(this.eGq), Integer.valueOf(paramd.field_retCode), paramd.field_arg, paramd.field_transInfo });
        u.nX(g.c(this.eGq));
        paramString = a.n(new Object[] { Integer.valueOf(paramd.field_retCode), Integer.valueOf(1), Long.valueOf(g.d(this.eGq)), Long.valueOf(bk.UY()), Integer.valueOf(com.tencent.mm.ak.c.bx(ae.getContext())), Integer.valueOf(g.e(this.eGq)), Integer.valueOf(paramd.field_fileLength), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.dlG });
        new com.tencent.mm.h.b.a.f(paramString).QX();
        new com.tencent.mm.h.b.a.d(paramString).QX();
        g.f(this.eGq).onSceneEnd(3, paramd.field_retCode, "", this.eGq);
      }
    }
    else {
      return 0;
    }
    y.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn uploadvideo by cdn, videohash isHitCacheUpload: %d, enableHitcheck:%b", new Object[] { g.a(this.eGq), Integer.valueOf(paramd.field_UploadHitCacheType), Boolean.valueOf(g.h(this.eGq)) });
    paramString = com.tencent.mm.plugin.report.service.h.nFQ;
    if (g.i(this.eGq))
    {
      paramInt = 810;
      label813:
      paramString.f(12696, new Object[] { Integer.valueOf(paramInt + paramd.field_UploadHitCacheType), Integer.valueOf(g.g(this.eGq).ebK) });
      paramBoolean = paramd.field_isVideoReduced;
      y.i("MicroMsg.NetSceneUploadVideo", "%s it video was reduced by cdn %b %s", new Object[] { g.a(this.eGq), Boolean.valueOf(paramBoolean), g.c(this.eGq) });
      if (paramBoolean) {
        break label1573;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.a(106L, 205L, 1L, false);
      if ((g.k(this.eGq) > 0) && (paramd.field_thumbimgLength > 0))
      {
        y.i("MicroMsg.NetSceneUploadVideo", "%s send video thumb too big thumb length [%d, %d] ", new Object[] { g.a(this.eGq), Integer.valueOf(g.k(this.eGq)), Integer.valueOf(paramd.field_thumbimgLength) });
        if (g.k(this.eGq) * 2 <= paramd.field_thumbimgLength) {
          break label1539;
        }
        com.tencent.mm.plugin.report.service.h.nFQ.a(106L, 206L, 1L, false);
      }
      label1013:
      o.Sr();
      paramInt = (int)e.aeQ(t.nS(g.c(this.eGq)));
      y.i("MicroMsg.NetSceneUploadVideo", "%s send video too big thumb length [%d, %d] ", new Object[] { g.a(this.eGq), Integer.valueOf(g.g(this.eGq).ebK), Integer.valueOf(paramInt) });
      if (g.g(this.eGq).ebK == paramInt) {
        break label1556;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.a(106L, 208L, 1L, false);
      label1105:
      g.a(this.eGq, u.oe(g.c(this.eGq)));
      if (bk.bl(g.g(this.eGq).SD()))
      {
        paramString = "<msg><videomsg aeskey=\"" + paramd.field_aesKey + "\" cdnthumbaeskey=\"" + paramd.field_aesKey + "\" cdnvideourl=\"" + paramd.field_fileId + "\" ";
        paramString = paramString + "cdnthumburl=\"" + paramd.field_fileId + "\" ";
        paramString = paramString + "length=\"" + paramd.field_fileLength + "\" ";
        paramString = paramString + "cdnthumblength=\"" + paramd.field_thumbimgLength + "\"/></msg>";
        y.i("MicroMsg.NetSceneUploadVideo", "%s cdn callback new build cdnInfo:%s", new Object[] { g.a(this.eGq), paramString });
        g.g(this.eGq).eHN = paramString;
        u.f(g.g(this.eGq));
      }
      paramString = bn.s(g.g(this.eGq).SD(), "msg");
      if (paramString != null)
      {
        paramc = o.Sr();
        o.Sr();
        boolean bool = paramc.q(t.nS(g.c(this.eGq)), (String)paramString.get(".msg.videomsg.$cdnvideourl"), (String)paramString.get(".msg.videomsg.$aeskey"));
        paramString = com.tencent.mm.plugin.report.service.h.nFQ;
        if (!bool) {
          break label1590;
        }
        paramInt = 1;
        label1428:
        paramString.f(12696, new Object[] { Integer.valueOf(paramInt + 900), Integer.valueOf(g.g(this.eGq).ebK) });
      }
      paramString = com.tencent.mm.kernel.g.Dk();
      paramc = g.c(this.eGq);
      if (!paramBoolean) {
        break label1595;
      }
    }
    label1539:
    label1556:
    label1573:
    label1590:
    label1595:
    for (paramInt = 0;; paramInt = g.l(this.eGq))
    {
      paramString.a(new h(paramc, paramInt, paramd, new g.1.1(this, paramd)), 0);
      break;
      if (g.j(this.eGq))
      {
        paramInt = 820;
        break label813;
      }
      paramInt = 830;
      break label813;
      com.tencent.mm.plugin.report.service.h.nFQ.a(106L, 207L, 1L, false);
      break label1013;
      com.tencent.mm.plugin.report.service.h.nFQ.a(106L, 209L, 1L, false);
      break label1105;
      com.tencent.mm.plugin.report.service.h.nFQ.a(106L, 200L, 1L, false);
      break label1105;
      paramInt = 2;
      break label1428;
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvideo.g.1
 * JD-Core Version:    0.7.0.1
 */