package com.tencent.mm.media.widget.camerarecordview.d;

import android.content.Context;
import com.tencent.mm.media.widget.c.b;
import com.tencent.mm.media.widget.camerarecordview.preview.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "", "enableCameraOrientationFit", "", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getContext", "Landroid/content/Context;", "getDaemonVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getPreviewRenderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRecordRenderer", "getRecordScene", "", "getRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "getResolutionLimit", "getVideoTransPara", "isMute", "useCpuCrop", "useDaemonRecorder", "plugin-mediaeditor_release"})
public abstract interface a
{
  public abstract boolean Pd();
  
  public abstract boolean axY();
  
  public abstract boolean axZ();
  
  public abstract boolean aya();
  
  public abstract e getCameraPreviewView();
  
  public abstract Context getContext();
  
  public abstract VideoTransPara getDaemonVideoTransPara();
  
  public abstract com.tencent.mm.media.widget.camerarecordview.b.a getEncodeConfig();
  
  public abstract com.tencent.mm.media.j.a getPreviewRenderer();
  
  public abstract com.tencent.mm.media.j.a getRecordRenderer();
  
  public abstract int getRecordScene();
  
  public abstract b getRecorder();
  
  public abstract int getResolutionLimit();
  
  public abstract VideoTransPara getVideoTransPara();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.d.a
 * JD-Core Version:    0.7.0.1
 */