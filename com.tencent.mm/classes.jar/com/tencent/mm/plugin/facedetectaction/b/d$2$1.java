package com.tencent.mm.plugin.facedetectaction.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class d$2$1
  implements e.a
{
  d$2$1(d.2 param2) {}
  
  public final void R(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(690);
    ab.i("MicroMsg.FaceCheckActionMgr", "onUploadFinish, fileName: %s, fileId: %s, aesKey: %s", new Object[] { paramString1, paramString1, paramString2, paramString3 });
    h.qsU.idkeyStat(917L, 50L, 1L, false);
    d.a(this.mqK.mqI, paramString1, paramString2, paramString3);
    AppMethodBeat.o(690);
  }
  
  public final void onError()
  {
    AppMethodBeat.i(691);
    ab.i("MicroMsg.FaceCheckActionMgr", "on record error");
    if (d.f(this.mqK.mqI) != null)
    {
      d.f(this.mqK.mqI).a(2, -1, "", 1);
      h.qsU.idkeyStat(917L, 47L, 1L, false);
    }
    AppMethodBeat.o(691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.d.2.1
 * JD-Core Version:    0.7.0.1
 */