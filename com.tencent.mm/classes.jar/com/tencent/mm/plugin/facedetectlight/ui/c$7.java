package com.tencent.mm.plugin.facedetectlight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.e.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class c$7
  implements a.b
{
  c$7(c paramc) {}
  
  public final void Ns(String paramString)
  {
    AppMethodBeat.i(798);
    ab.i("MicroMsg.FaceReflectLogic", "video release done. using: %d ms. file path: %s", new Object[] { Long.valueOf(bo.av(bo.yB())), paramString });
    if (bo.isNullOrNil(paramString))
    {
      ab.i("MicroMsg.FaceReflectLogic", " video is null");
      h.qsU.idkeyStat(917L, 20L, 1L, false);
      AppMethodBeat.o(798);
      return;
    }
    h.qsU.idkeyStat(917L, 19L, 1L, false);
    ab.i("MicroMsg.FaceReflectLogic", " begin upload video ");
    ab.i("MicroMsg.FaceReflectLogic", "filePath is : ".concat(String.valueOf(paramString)));
    ab.i("MicroMsg.FaceReflectLogic", "BioID is : " + this.msb.mrJ);
    ab.i("MicroMsg.FaceReflectLogic", "AppId is : " + this.msb.mAppId);
    AppMethodBeat.o(798);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.c.7
 * JD-Core Version:    0.7.0.1
 */