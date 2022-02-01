package com.tencent.mm.media.widget.camerarecordview.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer;", "", "getRecordScene", "", "getResolutionLimit", "initCameraConfig", "", "initFpsStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FpsConfigItem;", "CameraDeviceConfig", "Companion", "plugin-mediaeditor_release"})
public abstract interface b
{
  public static final b lge = b.lgz;
  
  public abstract int getRecordScene();
  
  public abstract int getResolutionLimit();
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$Companion;", "", "()V", "CAMERA_FOCUS_AUTO", "", "getCAMERA_FOCUS_AUTO", "()Ljava/lang/String;", "CAMERA_FOCUS_CONTINUS_PICUTRE", "getCAMERA_FOCUS_CONTINUS_PICUTRE", "CAMERA_FOCUS_CONTINUS_VIDEO", "getCAMERA_FOCUS_CONTINUS_VIDEO", "FOCUS_FACE_LOC_DIFF_THREASHOLD", "", "getFOCUS_FACE_LOC_DIFF_THREASHOLD", "()I", "METER_FACE_LOC_DIFF_THRESHOLD", "getMETER_FACE_LOC_DIFF_THRESHOLD", "PREVIEW_CALLBACK_FRONT_CAMERA_MIRROR", "getPREVIEW_CALLBACK_FRONT_CAMERA_MIRROR", "PREVIEW_CALLBACK_REMOVE", "getPREVIEW_CALLBACK_REMOVE", "plugin-mediaeditor_release"})
  public static final class b
  {
    private static final String lgs = "continue-video";
    private static final String lgt = "continue-picture";
    private static final String lgu = "auto";
    private static final int lgv = 20;
    private static final int lgw = 70;
    private static final String lgx = "preview_callback_remove";
    private static final String lgy = "preview_callback_front_camera_mirror";
    
    static
    {
      AppMethodBeat.i(258290);
      lgz = new b();
      lgs = "continue-video";
      lgt = "continue-picture";
      lgu = "auto";
      lgv = 20;
      lgw = 70;
      lgx = "preview_callback_remove";
      lgy = "preview_callback_front_camera_mirror";
      AppMethodBeat.o(258290);
    }
    
    public static String aZs()
    {
      return lgs;
    }
    
    public static String aZt()
    {
      return lgt;
    }
    
    public static String aZu()
    {
      return lgu;
    }
    
    public static String aZv()
    {
      return lgx;
    }
    
    public static String aZw()
    {
      return lgy;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.d.b
 * JD-Core Version:    0.7.0.1
 */