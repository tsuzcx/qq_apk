package com.tencent.mm.media.widget.camerarecordview.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer;", "enableCameraOrientationFit", "", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getContext", "Landroid/content/Context;", "getDaemonVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getPreviewRenderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRecordRenderer", "getRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "getVideoTransPara", "isMute", "useCpuCrop", "useDaemonRecorder", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
  extends b
{
  public abstract boolean aGe();
  
  public abstract boolean bun();
  
  public abstract boolean buo();
  
  public abstract boolean bup();
  
  public abstract com.tencent.mm.media.widget.camerarecordview.preview.b getCameraPreviewView();
  
  public abstract Context getContext();
  
  public abstract VideoTransPara getDaemonVideoTransPara();
  
  public abstract com.tencent.mm.media.widget.camerarecordview.b.a getEncodeConfig();
  
  public abstract com.tencent.mm.media.j.a getPreviewRenderer();
  
  public abstract com.tencent.mm.media.j.a getRecordRenderer();
  
  public abstract com.tencent.mm.media.widget.c.b getRecorder();
  
  public abstract VideoTransPara getVideoTransPara();
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static VideoTransPara a(a parama)
    {
      AppMethodBeat.i(237662);
      s.u(parama, "this");
      parama = parama.getVideoTransPara();
      AppMethodBeat.o(237662);
      return parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.d.a
 * JD-Core Version:    0.7.0.1
 */