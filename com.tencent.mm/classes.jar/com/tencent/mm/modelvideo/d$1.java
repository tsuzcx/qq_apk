package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;

final class d$1
  implements g.a
{
  d$1(d paramd) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(50665);
    if (paramInt == -21006)
    {
      ab.d("MicroMsg.NetSceneDownloadVideo", "%s cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { this.fVJ.alu(), this.fVJ.fFo });
      AppMethodBeat.o(50665);
      return 0;
    }
    if (paramInt != 0)
    {
      u.vk(this.fVJ.fileName);
      paramString = com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(2), Long.valueOf(this.fVJ.startTime), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(ah.getContext())), Integer.valueOf(this.fVJ.fVF), Integer.valueOf(this.fVJ.fsd), "" });
      new com.tencent.mm.g.b.a.f(paramString).ake();
      new com.tencent.mm.g.b.a.d(paramString).ake();
      this.fVJ.callback.onSceneEnd(3, paramInt, "", this.fVJ);
      AppMethodBeat.o(50665);
      return 0;
    }
    this.fVJ.fVD = u.vr(this.fVJ.fileName);
    if ((this.fVJ.fVD == null) || (this.fVJ.fVD.status == 113))
    {
      if (this.fVJ.fVD == null) {}
      for (int i = -1;; i = this.fVJ.fVD.status)
      {
        ab.i("MicroMsg.NetSceneDownloadVideo", "%s upload video info is null or has paused, status:%d", new Object[] { this.fVJ.alu(), Integer.valueOf(i) });
        this.fVJ.Ez();
        this.fVJ.callback.onSceneEnd(3, paramInt, "upload video info is null or has paused, status".concat(String.valueOf(i)), this.fVJ);
        AppMethodBeat.o(50665);
        return 0;
      }
    }
    if (paramc != null)
    {
      if (paramc.field_finishedLength == this.fVJ.fsd)
      {
        ab.d("MicroMsg.NetSceneDownloadVideo", "cdntra ignore progress 100%");
        AppMethodBeat.o(50665);
        return 0;
      }
      if ((this.fVJ.fVD.fXs > paramc.field_finishedLength) && (!this.fVJ.fVB))
      {
        ab.e("MicroMsg.NetSceneDownloadVideo", "%s cdnEndProc error oldpos:%d newpos:%d", new Object[] { this.fVJ.alu(), Integer.valueOf(this.fVJ.fVD.fXs), Integer.valueOf(paramc.field_finishedLength) });
        u.vk(this.fVJ.fileName);
        this.fVJ.callback.onSceneEnd(3, paramInt, "", this.fVJ);
        AppMethodBeat.o(50665);
        return 0;
      }
      paramInt = 1024;
      this.fVJ.fVD.fXv = bo.aox();
      if (this.fVJ.fVD.fXs < paramc.field_finishedLength)
      {
        this.fVJ.fVD.fXs = paramc.field_finishedLength;
        paramInt = 1040;
      }
      this.fVJ.fVD.bsY = paramInt;
      u.f(this.fVJ.fVD);
      ab.d("MicroMsg.NetSceneDownloadVideo", "%s cdntra progresscallback id:%s finish:%d total:%d", new Object[] { this.fVJ.alu(), this.fVJ.fFo, Integer.valueOf(paramc.field_finishedLength), Integer.valueOf(paramc.field_toltalLength) });
      AppMethodBeat.o(50665);
      return 0;
    }
    if (paramd != null)
    {
      ab.i("MicroMsg.NetSceneDownloadVideo", "%s cdntra sceneResult.retCode:%d useTime:%d ", new Object[] { this.fVJ.alu(), Integer.valueOf(paramd.field_retCode), Long.valueOf(bo.aoy() - this.fVJ.fVI) });
      paramString = this.fVJ;
      paramc = this.fVJ.fVE;
      if ((paramc != null) && (paramd != null)) {
        break label1148;
      }
      ab.w("MicroMsg.NetSceneDownloadVideo", "it had not task info or scene Result, don't report.");
      if (paramd.field_retCode == 0) {
        break label1242;
      }
      u.vk(this.fVJ.fileName);
      if (this.fVJ.fVB) {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 13L, 1L, false);
      }
      if (this.fVJ.fVC) {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 252L, 1L, false);
      }
      this.fVJ.callback.onSceneEnd(3, paramd.field_retCode, "", this.fVJ);
    }
    for (;;)
    {
      new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramd.field_retCode), Integer.valueOf(2), Long.valueOf(this.fVJ.startTime), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(ah.getContext())), Integer.valueOf(this.fVJ.fVF), Integer.valueOf(this.fVJ.fsd), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.edb })).ake();
      if (paramd.field_retCode != 0) {
        new com.tencent.mm.g.b.a.d(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramd.field_retCode), Integer.valueOf(2), Long.valueOf(this.fVJ.startTime), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(ah.getContext())), Integer.valueOf(this.fVJ.fVF), Integer.valueOf(this.fVJ.fsd), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.edb })).ake();
      }
      a.a(this.fVJ.fVD, 1);
      this.fVJ.fVE = null;
      AppMethodBeat.o(50665);
      return 0;
      label1148:
      if (paramc.field_smallVideoFlag == 1)
      {
        ab.i("MicroMsg.NetSceneDownloadVideo", "it download short video, don't report.");
        break;
      }
      if ((paramc == null) || (paramd == null)) {
        break;
      }
      ab.i("MicroMsg.NetSceneDownloadVideo", "%s sceneResult.field_recvedBytes %d, time [%d, %d]", new Object[] { paramString.alu(), Integer.valueOf(paramd.field_recvedBytes), Long.valueOf(paramd.field_startTime), Long.valueOf(paramd.field_endTime) });
      o.alF();
      e.a(null, paramd, paramc, true);
      break;
      label1242:
      if (this.fVJ.fVB) {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 12L, 1L, false);
      }
      if (this.fVJ.fVC) {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 137L, 1L, false);
      }
      this.fVJ.ml(paramd.field_fileLength);
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvideo.d.1
 * JD-Core Version:    0.7.0.1
 */