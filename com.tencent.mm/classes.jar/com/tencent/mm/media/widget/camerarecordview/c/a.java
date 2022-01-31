package com.tencent.mm.media.widget.camerarecordview.c;

import a.l;
import android.content.Context;
import com.tencent.mm.media.widget.b.b;
import com.tencent.mm.media.widget.camerarecordview.preview.c;
import com.tencent.mm.modelcontrol.VideoTransPara;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "", "enableCameraOrientationFit", "", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getContext", "Landroid/content/Context;", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getPreviewRenderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRecordRenderer", "getRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "getResolutionLimit", "", "getVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "isMute", "useCpuCrop", "plugin-mediaeditor_release"})
public abstract interface a
{
  public abstract boolean DP();
  
  public abstract boolean Xn();
  
  public abstract boolean Xo();
  
  public abstract c getCameraPreviewView();
  
  public abstract Context getContext();
  
  public abstract com.tencent.mm.media.widget.camerarecordview.a.a getEncodeConfig();
  
  public abstract com.tencent.mm.media.h.a getPreviewRenderer();
  
  public abstract com.tencent.mm.media.h.a getRecordRenderer();
  
  public abstract b getRecorder();
  
  public abstract int getResolutionLimit();
  
  public abstract VideoTransPara getVideoTransPara();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.c.a
 * JD-Core Version:    0.7.0.1
 */