package com.tencent.mm.media.widget.camerarecordview.preview.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.preview.e;
import com.tencent.mm.media.widget.camerarecordview.preview.f;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/CPUPreviewController;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;)V", "frameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "drawFrame", "", "data", "", "getFrameDataCallback", "plugin-mediaeditor_release"})
public final class b
  extends a
{
  private final g gCb;
  
  public b(e parame)
  {
    super((f)parame);
    AppMethodBeat.i(94363);
    this.gCb = ((g)new a(this));
    AppMethodBeat.o(94363);
  }
  
  public final g getFrameDataCallback()
  {
    return this.gCb;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onFrameData"})
  static final class a
    implements g
  {
    a(b paramb) {}
    
    public final boolean W(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(94362);
      b localb = this.gCc;
      if (paramArrayOfByte != null)
      {
        com.tencent.mm.media.i.a locala = localb.gsB;
        if (locala != null) {
          com.tencent.mm.media.i.a.a(locala, paramArrayOfByte);
        }
        localb.gBV.requestRender();
      }
      for (;;)
      {
        AppMethodBeat.o(94362);
        return false;
        ad.v("MicroMsg.CameraPreviewGLSurfaceView", "passing draw");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.preview.a.b
 * JD-Core Version:    0.7.0.1
 */