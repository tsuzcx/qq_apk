package com.tencent.mm.modelvideo;

import com.tencent.mm.j.f.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;

final class d$1
  implements f.a
{
  d$1(d paramd) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.j.c paramc, com.tencent.mm.j.d paramd, boolean paramBoolean)
  {
    if (paramInt == -21006)
    {
      y.d("MicroMsg.NetSceneDownloadVideo", "%s cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { this.eFS.Sj(), this.eFS.eoQ });
      return 0;
    }
    if (paramInt != 0)
    {
      u.nX(this.eFS.fileName);
      paramString = com.tencent.mm.plugin.report.a.n(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(2), Long.valueOf(this.eFS.startTime), Long.valueOf(bk.UY()), Integer.valueOf(com.tencent.mm.ak.c.bx(ae.getContext())), Integer.valueOf(this.eFS.eFO), Integer.valueOf(this.eFS.ebK), "" });
      new com.tencent.mm.h.b.a.f(paramString).QX();
      new com.tencent.mm.h.b.a.d(paramString).QX();
      this.eFS.dmL.onSceneEnd(3, paramInt, "", this.eFS);
      return 0;
    }
    this.eFS.eFM = u.oe(this.eFS.fileName);
    if ((this.eFS.eFM == null) || (this.eFS.eFM.status == 113))
    {
      if (this.eFS.eFM == null) {}
      for (int i = -1;; i = this.eFS.eFM.status)
      {
        y.i("MicroMsg.NetSceneDownloadVideo", "%s upload video info is null or has paused, status:%d", new Object[] { this.eFS.Sj(), Integer.valueOf(i) });
        this.eFS.un();
        this.eFS.dmL.onSceneEnd(3, paramInt, "upload video info is null or has paused, status" + i, this.eFS);
        return 0;
      }
    }
    if (paramc != null)
    {
      if (paramc.field_finishedLength == this.eFS.ebK)
      {
        y.d("MicroMsg.NetSceneDownloadVideo", "cdntra ignore progress 100%");
        return 0;
      }
      if ((this.eFS.eFM.eHC > paramc.field_finishedLength) && (!this.eFS.eFK))
      {
        y.e("MicroMsg.NetSceneDownloadVideo", "%s cdnEndProc error oldpos:%d newpos:%d", new Object[] { this.eFS.Sj(), Integer.valueOf(this.eFS.eFM.eHC), Integer.valueOf(paramc.field_finishedLength) });
        u.nX(this.eFS.fileName);
        this.eFS.dmL.onSceneEnd(3, paramInt, "", this.eFS);
        return 0;
      }
      paramInt = 1024;
      this.eFS.eFM.eHF = bk.UX();
      if (this.eFS.eFM.eHC < paramc.field_finishedLength)
      {
        this.eFS.eFM.eHC = paramc.field_finishedLength;
        paramInt = 1040;
      }
      this.eFS.eFM.bcw = paramInt;
      u.f(this.eFS.eFM);
      y.d("MicroMsg.NetSceneDownloadVideo", "%s cdntra progresscallback id:%s finish:%d total:%d", new Object[] { this.eFS.Sj(), this.eFS.eoQ, Integer.valueOf(paramc.field_finishedLength), Integer.valueOf(paramc.field_toltalLength) });
      return 0;
    }
    if (paramd != null)
    {
      y.i("MicroMsg.NetSceneDownloadVideo", "%s cdntra sceneResult.retCode:%d useTime:%d ", new Object[] { this.eFS.Sj(), Integer.valueOf(paramd.field_retCode), Long.valueOf(bk.UY() - this.eFS.eFR) });
      d.a(this.eFS, this.eFS.eFN, paramd);
      if (paramd.field_retCode == 0) {
        break label1102;
      }
      u.nX(this.eFS.fileName);
      if (this.eFS.eFK) {
        h.nFQ.a(354L, 13L, 1L, false);
      }
      if (this.eFS.eFL) {
        h.nFQ.a(354L, 252L, 1L, false);
      }
      this.eFS.dmL.onSceneEnd(3, paramd.field_retCode, "", this.eFS);
    }
    for (;;)
    {
      new com.tencent.mm.h.b.a.f(com.tencent.mm.plugin.report.a.n(new Object[] { Integer.valueOf(paramd.field_retCode), Integer.valueOf(2), Long.valueOf(this.eFS.startTime), Long.valueOf(bk.UY()), Integer.valueOf(com.tencent.mm.ak.c.bx(ae.getContext())), Integer.valueOf(this.eFS.eFO), Integer.valueOf(this.eFS.ebK), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.dlG })).QX();
      if (paramd.field_retCode != 0) {
        new com.tencent.mm.h.b.a.d(com.tencent.mm.plugin.report.a.n(new Object[] { Integer.valueOf(paramd.field_retCode), Integer.valueOf(2), Long.valueOf(this.eFS.startTime), Long.valueOf(bk.UY()), Integer.valueOf(com.tencent.mm.ak.c.bx(ae.getContext())), Integer.valueOf(this.eFS.eFO), Integer.valueOf(this.eFS.ebK), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.dlG })).QX();
      }
      a.a(this.eFS.eFM, 1);
      this.eFS.eFN = null;
      return 0;
      label1102:
      if (this.eFS.eFK) {
        h.nFQ.a(354L, 12L, 1L, false);
      }
      if (this.eFS.eFL) {
        h.nFQ.a(354L, 137L, 1L, false);
      }
      this.eFS.jt(paramd.field_fileLength);
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.d.1
 * JD-Core Version:    0.7.0.1
 */