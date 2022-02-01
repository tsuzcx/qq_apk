package com.tencent.mm.plugin.facedetectlight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.e.a.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

final class c$7
  implements a.b
{
  c$7(c paramc) {}
  
  public final void agU(String paramString)
  {
    AppMethodBeat.i(104318);
    ae.i("MicroMsg.FaceReflectLogic", "video release done. using: %d ms. file path: %s", new Object[] { Long.valueOf(bu.aO(bu.HQ())), paramString });
    if (bu.isNullOrNil(paramString))
    {
      ae.i("MicroMsg.FaceReflectLogic", " video is null");
      g.yxI.idkeyStat(917L, 20L, 1L, false);
      AppMethodBeat.o(104318);
      return;
    }
    g.yxI.idkeyStat(917L, 19L, 1L, false);
    ae.i("MicroMsg.FaceReflectLogic", " begin upload video ");
    ae.i("MicroMsg.FaceReflectLogic", "filePath is : ".concat(String.valueOf(paramString)));
    ae.i("MicroMsg.FaceReflectLogic", "BioID is : " + this.rzB.rzg);
    ae.i("MicroMsg.FaceReflectLogic", "AppId is : " + this.rzB.mAppId);
    AppMethodBeat.o(104318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.c.7
 * JD-Core Version:    0.7.0.1
 */