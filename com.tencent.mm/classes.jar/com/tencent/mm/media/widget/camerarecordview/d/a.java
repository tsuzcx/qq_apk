package com.tencent.mm.media.widget.camerarecordview.d;

import android.content.Context;
import com.tencent.mm.media.widget.camerarecordview.preview.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer;", "enableCameraOrientationFit", "", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getContext", "Landroid/content/Context;", "getDaemonVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getPreviewRenderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRecordRenderer", "getRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "getVideoTransPara", "isMute", "useCpuCrop", "useDaemonRecorder", "plugin-mediaeditor_release"})
public abstract interface a
  extends b
{
  public abstract boolean Zx();
  
  public abstract boolean aQw();
  
  public abstract boolean aQx();
  
  public abstract boolean aQy();
  
  public abstract e getCameraPreviewView();
  
  public abstract Context getContext();
  
  public abstract VideoTransPara getDaemonVideoTransPara();
  
  public abstract com.tencent.mm.media.widget.camerarecordview.b.a getEncodeConfig();
  
  public abstract com.tencent.mm.media.j.a getPreviewRenderer();
  
  public abstract com.tencent.mm.media.j.a getRecordRenderer();
  
  public abstract com.tencent.mm.media.widget.c.b getRecorder();
  
  public abstract VideoTransPara getVideoTransPara();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.d.a
 * JD-Core Version:    0.7.0.1
 */