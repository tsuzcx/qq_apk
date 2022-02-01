package com.tencent.mm.plugin.facedetectlight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.e.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

final class c$7
  implements a.b
{
  c$7(c paramc) {}
  
  public final void acj(String paramString)
  {
    AppMethodBeat.i(104318);
    ac.i("MicroMsg.FaceReflectLogic", "video release done. using: %d ms. file path: %s", new Object[] { Long.valueOf(bs.aO(bs.Gn())), paramString });
    if (bs.isNullOrNil(paramString))
    {
      ac.i("MicroMsg.FaceReflectLogic", " video is null");
      h.wUl.idkeyStat(917L, 20L, 1L, false);
      AppMethodBeat.o(104318);
      return;
    }
    h.wUl.idkeyStat(917L, 19L, 1L, false);
    ac.i("MicroMsg.FaceReflectLogic", " begin upload video ");
    ac.i("MicroMsg.FaceReflectLogic", "filePath is : ".concat(String.valueOf(paramString)));
    ac.i("MicroMsg.FaceReflectLogic", "BioID is : " + this.qHn.qGS);
    ac.i("MicroMsg.FaceReflectLogic", "AppId is : " + this.qHn.mAppId);
    AppMethodBeat.o(104318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.c.7
 * JD-Core Version:    0.7.0.1
 */