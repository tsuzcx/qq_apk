package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class f$2
  implements g.b
{
  f$2(f paramf) {}
  
  public final void a(String paramString, d paramd)
  {
    AppMethodBeat.i(50683);
    if (paramd == null)
    {
      ab.w("MicroMsg.NetScenePreloadVideoFake", "%s onPreload completed but sceneResult is null", new Object[] { Integer.valueOf(this.fVX.hashCode()) });
      if (this.fVX.fVW != null) {
        this.fVX.fVW.a(this.fVX, false, 0, 0);
      }
      AppMethodBeat.o(50683);
      return;
    }
    int i = paramd.field_recvedBytes;
    int j = paramd.field_fileLength;
    ab.i("MicroMsg.NetScenePreloadVideoFake", "%d onPreload Completed [%s] videoInfoName[%s] [%d, %d] videoFormat[%d]", new Object[] { Integer.valueOf(this.fVX.hashCode()), paramString, this.fVX.fVQ, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramd.field_videoFormat) });
    if ((i > 0) && (j > 0)) {
      this.fVX.fVT = f.e(this.fVX.fVQ, i, true);
    }
    boolean bool;
    if (this.fVX.fVW != null)
    {
      paramString = this.fVX.fVW;
      f localf = this.fVX;
      if ((i > 0) && (j > 0))
      {
        bool = true;
        paramString.a(localf, bool, i, j);
      }
    }
    else
    {
      this.fVX.fVS = bo.aox();
      this.fVX.uT(paramd.Jn());
      if (!this.fVX.fVP) {
        break label340;
      }
      h.qsU.idkeyStat(354L, 142L, 1L, false);
      if (this.fVX.fVU != 1) {
        break label323;
      }
      h.qsU.idkeyStat(354L, 123L, 1L, false);
    }
    for (;;)
    {
      h.qsU.idkeyStat(354L, paramd.field_videoFormat + 240, 1L, false);
      AppMethodBeat.o(50683);
      return;
      bool = false;
      break;
      label323:
      h.qsU.idkeyStat(354L, 124L, 1L, false);
    }
    label340:
    h.qsU.idkeyStat(354L, 143L, 1L, false);
    AppMethodBeat.o(50683);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvideo.f.2
 * JD-Core Version:    0.7.0.1
 */