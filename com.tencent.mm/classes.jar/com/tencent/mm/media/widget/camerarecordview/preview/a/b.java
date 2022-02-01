package com.tencent.mm.media.widget.camerarecordview.preview.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.preview.c;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/CPUPreviewController;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;)V", "frameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "drawFrame", "", "data", "", "getFrameDataCallback", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a
{
  private final g nKM;
  
  public b(com.tencent.mm.media.widget.camerarecordview.preview.b paramb)
  {
    super((c)paramb);
    AppMethodBeat.i(94363);
    this.nKM = new b..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(94363);
  }
  
  private static final boolean a(b paramb, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(237713);
    s.u(paramb, "this$0");
    if (paramArrayOfByte != null)
    {
      com.tencent.mm.media.j.a locala = paramb.nBj;
      if (locala != null) {
        com.tencent.mm.media.j.a.a(locala, paramArrayOfByte);
      }
      paramb.nKz.requestRender();
    }
    for (;;)
    {
      AppMethodBeat.o(237713);
      return false;
      Log.v("MicroMsg.CameraPreviewGLSurfaceView", "passing draw");
    }
  }
  
  public final g getFrameDataCallback()
  {
    return this.nKM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.preview.a.b
 * JD-Core Version:    0.7.0.1
 */