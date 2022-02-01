package com.tencent.mm.plugin.facedetectlight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.e.a.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

final class c$7
  implements a.b
{
  c$7(c paramc) {}
  
  public final void afY(String paramString)
  {
    AppMethodBeat.i(104318);
    ad.i("MicroMsg.FaceReflectLogic", "video release done. using: %d ms. file path: %s", new Object[] { Long.valueOf(bt.aO(bt.HI())), paramString });
    if (bt.isNullOrNil(paramString))
    {
      ad.i("MicroMsg.FaceReflectLogic", " video is null");
      g.yhR.idkeyStat(917L, 20L, 1L, false);
      AppMethodBeat.o(104318);
      return;
    }
    g.yhR.idkeyStat(917L, 19L, 1L, false);
    ad.i("MicroMsg.FaceReflectLogic", " begin upload video ");
    ad.i("MicroMsg.FaceReflectLogic", "filePath is : ".concat(String.valueOf(paramString)));
    ad.i("MicroMsg.FaceReflectLogic", "BioID is : " + this.rrm.rqR);
    ad.i("MicroMsg.FaceReflectLogic", "AppId is : " + this.rrm.mAppId);
    AppMethodBeat.o(104318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.c.7
 * JD-Core Version:    0.7.0.1
 */