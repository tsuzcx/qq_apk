package com.tencent.mm.media.widget.camerarecordview.preview.a;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.preview.d;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onFrameData"})
final class b$a
  implements f
{
  b$a(b paramb) {}
  
  public final boolean N(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(13310);
    b localb = this.fbX;
    if (paramArrayOfByte != null)
    {
      com.tencent.mm.media.h.a locala = localb.eWh;
      if (locala != null) {
        com.tencent.mm.media.h.a.a(locala, paramArrayOfByte);
      }
      localb.fbQ.requestRender();
    }
    for (;;)
    {
      AppMethodBeat.o(13310);
      return false;
      ab.v("MicroMsg.CameraPreviewGLSurfaceView", "passing draw");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.preview.a.b.a
 * JD-Core Version:    0.7.0.1
 */