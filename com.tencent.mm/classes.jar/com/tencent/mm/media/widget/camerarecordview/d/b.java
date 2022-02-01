package com.tencent.mm.media.widget.camerarecordview.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer;", "", "getRecordScene", "", "getResolutionLimit", "initCameraConfig", "", "initFpsStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FpsConfigItem;", "CameraDeviceConfig", "Companion", "plugin-mediaeditor_release"})
public abstract interface b
{
  public static final b iqZ = b.irv;
  
  public abstract int getRecordScene();
  
  public abstract int getResolutionLimit();
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$Companion;", "", "()V", "CAMERA_FOCUS_AUTO", "", "getCAMERA_FOCUS_AUTO", "()Ljava/lang/String;", "CAMERA_FOCUS_CONTINUS_PICUTRE", "getCAMERA_FOCUS_CONTINUS_PICUTRE", "CAMERA_FOCUS_CONTINUS_VIDEO", "getCAMERA_FOCUS_CONTINUS_VIDEO", "FOCUS_FACE_LOC_DIFF_THREASHOLD", "", "getFOCUS_FACE_LOC_DIFF_THREASHOLD", "()I", "METER_FACE_LOC_DIFF_THRESHOLD", "getMETER_FACE_LOC_DIFF_THRESHOLD", "PREVIEW_CALLBACK_FRONT_CAMERA_MIRROR", "getPREVIEW_CALLBACK_FRONT_CAMERA_MIRROR", "PREVIEW_CALLBACK_REMOVE", "getPREVIEW_CALLBACK_REMOVE", "plugin-mediaeditor_release"})
  public static final class b
  {
    private static final String irn = "continue-video";
    private static final String iro = "continue-picture";
    private static final String irp = "auto";
    private static final int irq = 20;
    private static final int irs = 70;
    private static final String irt = "preview_callback_remove";
    private static final String iru = "preview_callback_front_camera_mirror";
    
    static
    {
      AppMethodBeat.i(218909);
      irv = new b();
      irn = "continue-video";
      iro = "continue-picture";
      irp = "auto";
      irq = 20;
      irs = 70;
      irt = "preview_callback_remove";
      iru = "preview_callback_front_camera_mirror";
      AppMethodBeat.o(218909);
    }
    
    public static String aQA()
    {
      return irn;
    }
    
    public static String aQB()
    {
      return iro;
    }
    
    public static String aQC()
    {
      return irp;
    }
    
    public static String aQD()
    {
      return irt;
    }
    
    public static String aQE()
    {
      return iru;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.d.b
 * JD-Core Version:    0.7.0.1
 */