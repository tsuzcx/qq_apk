package com.tencent.mm.plugin.facedetectaction.b;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class d$2$1
  implements e.a
{
  d$2$1(d.2 param2) {}
  
  public final void M(String paramString1, String paramString2, String paramString3)
  {
    y.i("MicroMsg.FaceCheckActionMgr", "onUploadFinish, fileName: %s, fileId: %s, aesKey: %s", new Object[] { paramString1, paramString1, paramString2, paramString3 });
    h.nFQ.a(917L, 50L, 1L, false);
    d.a(this.jWt.jWr, paramString1, paramString2, paramString3);
  }
  
  public final void onError()
  {
    y.i("MicroMsg.FaceCheckActionMgr", "on record error");
    if (d.f(this.jWt.jWr) != null)
    {
      d.f(this.jWt.jWr).a(2, -1, "", 1);
      h.nFQ.a(917L, 47L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.d.2.1
 * JD-Core Version:    0.7.0.1
 */