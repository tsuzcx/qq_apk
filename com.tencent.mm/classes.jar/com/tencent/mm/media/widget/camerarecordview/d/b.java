package com.tencent.mm.media.widget.camerarecordview.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer;", "", "getRecordScene", "", "getResolutionLimit", "initCameraConfig", "", "initFpsStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FpsConfigItem;", "CameraDeviceConfig", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface b
{
  public static final b nKO = b.nLc;
  
  public abstract int getRecordScene();
  
  public abstract int getResolutionLimit();
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig;", "", "sizeConfigStrategy", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$SizeConfigItem;", "Lkotlin/collections/HashMap;", "focusModeStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FocusConfigItem;", "fpsConfigStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FpsConfigItem;", "formatConfigStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$PreviewFormatItem;", "previewConfigStrategy", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "scene", "(Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashSet;I)V", "getFocusModeStrategy", "()Ljava/util/HashMap;", "setFocusModeStrategy", "(Ljava/util/HashMap;)V", "getFormatConfigStrategy", "setFormatConfigStrategy", "getFpsConfigStrategy", "setFpsConfigStrategy", "getPreviewConfigStrategy", "()Ljava/util/HashSet;", "setPreviewConfigStrategy", "(Ljava/util/HashSet;)V", "getScene", "()I", "setScene", "(I)V", "getSizeConfigStrategy", "setSizeConfigStrategy", "Builder", "FocusConfigItem", "FpsConfigItem", "PreviewFormatItem", "SizeConfigItem", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public HashMap<Integer, b.a.e> nKP;
    public HashMap<Integer, b.a.b> nKQ;
    public HashMap<Integer, b.a.c> nKR;
    public HashMap<Integer, b.a.d> nKS;
    public HashSet<String> nKT;
    private int scene;
    
    public a(HashMap<Integer, b.a.e> paramHashMap, HashMap<Integer, b.a.b> paramHashMap1, HashMap<Integer, b.a.c> paramHashMap2, HashMap<Integer, b.a.d> paramHashMap3, HashSet<String> paramHashSet, int paramInt)
    {
      AppMethodBeat.i(237661);
      this.nKP = paramHashMap;
      this.nKQ = paramHashMap1;
      this.nKR = paramHashMap2;
      this.nKS = paramHashMap3;
      this.nKT = paramHashSet;
      this.scene = paramInt;
      AppMethodBeat.o(237661);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$Builder;", "", "()V", "focusModeStrategy", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FocusConfigItem;", "Lkotlin/collections/HashMap;", "getFocusModeStrategy", "()Ljava/util/HashMap;", "setFocusModeStrategy", "(Ljava/util/HashMap;)V", "formatConfigStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$PreviewFormatItem;", "getFormatConfigStrategy", "setFormatConfigStrategy", "fpsConfigStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FpsConfigItem;", "getFpsConfigStrategy", "setFpsConfigStrategy", "previewConfigStrategy", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getPreviewConfigStrategy", "()Ljava/util/HashSet;", "setPreviewConfigStrategy", "(Ljava/util/HashSet;)V", "scene", "getScene", "()I", "setScene", "(I)V", "sizeConfigStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$SizeConfigItem;", "getSizeConfigStrategy", "setSizeConfigStrategy", "addFocusStrategy", "configs", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$Builder;", "addFpsConfigStrategy", "addPreviewCallbackConfigStrategy", "([Ljava/lang/String;)Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$Builder;", "addPreviewFormatConfigStrategy", "addSizeConfigStrategy", "build", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig;", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      private HashMap<Integer, b.a.e> nKP;
      private HashMap<Integer, b.a.b> nKQ;
      private HashMap<Integer, b.a.c> nKR;
      private HashMap<Integer, b.a.d> nKS;
      private HashSet<String> nKT;
      public int scene;
      
      public a()
      {
        AppMethodBeat.i(237669);
        this.nKQ = new HashMap();
        this.nKR = new HashMap();
        this.nKP = new HashMap();
        this.nKS = new HashMap();
        this.nKT = new HashSet();
        this.scene = -1;
        AppMethodBeat.o(237669);
      }
      
      public final a a(r<Integer, b.a.b>... paramVarArgs)
      {
        AppMethodBeat.i(237675);
        s.u(paramVarArgs, "configs");
        int i = 0;
        while (i <= 0)
        {
          r<Integer, b.a.b> localr = paramVarArgs[0];
          ((Map)this.nKQ).put(localr.bsC, localr.bsD);
          i += 1;
        }
        AppMethodBeat.o(237675);
        return this;
      }
      
      public final a b(r<Integer, b.a.c>... paramVarArgs)
      {
        AppMethodBeat.i(237679);
        s.u(paramVarArgs, "configs");
        int i = 0;
        while (i <= 0)
        {
          r<Integer, b.a.c> localr = paramVarArgs[0];
          ((Map)this.nKR).put(localr.bsC, localr.bsD);
          i += 1;
        }
        AppMethodBeat.o(237679);
        return this;
      }
      
      public final b.a buq()
      {
        AppMethodBeat.i(237701);
        b.a locala = new b.a(this.nKP, this.nKQ, this.nKR, this.nKS, this.nKT, this.scene);
        AppMethodBeat.o(237701);
        return locala;
      }
      
      public final a c(r<Integer, b.a.e>... paramVarArgs)
      {
        AppMethodBeat.i(237685);
        s.u(paramVarArgs, "configs");
        int i = 0;
        while (i <= 0)
        {
          r<Integer, b.a.e> localr = paramVarArgs[0];
          ((Map)this.nKP).put(localr.bsC, localr.bsD);
          i += 1;
        }
        AppMethodBeat.o(237685);
        return this;
      }
      
      public final a d(r<Integer, b.a.d>... paramVarArgs)
      {
        AppMethodBeat.i(237692);
        s.u(paramVarArgs, "configs");
        int i = 0;
        while (i <= 0)
        {
          r<Integer, b.a.d> localr = paramVarArgs[0];
          ((Map)this.nKS).put(localr.bsC, localr.bsD);
          i += 1;
        }
        AppMethodBeat.o(237692);
        return this;
      }
      
      public final a h(String... paramVarArgs)
      {
        AppMethodBeat.i(237699);
        s.u(paramVarArgs, "configs");
        int i = 0;
        while (i <= 0)
        {
          String str = paramVarArgs[0];
          i += 1;
          this.nKT.add(str);
        }
        AppMethodBeat.o(237699);
        return this;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$Companion;", "", "()V", "CAMERA_FOCUS_AUTO", "", "getCAMERA_FOCUS_AUTO", "()Ljava/lang/String;", "CAMERA_FOCUS_CONTINUS_PICUTRE", "getCAMERA_FOCUS_CONTINUS_PICUTRE", "CAMERA_FOCUS_CONTINUS_VIDEO", "getCAMERA_FOCUS_CONTINUS_VIDEO", "FOCUS_FACE_LOC_DIFF_THREASHOLD", "", "getFOCUS_FACE_LOC_DIFF_THREASHOLD", "()I", "METER_FACE_LOC_DIFF_THRESHOLD", "getMETER_FACE_LOC_DIFF_THRESHOLD", "PREVIEW_CALLBACK_FRONT_CAMERA_MIRROR", "getPREVIEW_CALLBACK_FRONT_CAMERA_MIRROR", "PREVIEW_CALLBACK_REMOVE", "getPREVIEW_CALLBACK_REMOVE", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    private static final String nLd;
    private static final String nLe;
    private static final String nLf;
    private static final int nLg;
    private static final int nLh;
    private static final String nLi;
    private static final String nLj;
    
    static
    {
      AppMethodBeat.i(237673);
      nLc = new b();
      nLd = "continue-video";
      nLe = "continue-picture";
      nLf = "auto";
      nLg = 20;
      nLh = 70;
      nLi = "preview_callback_remove";
      nLj = "preview_callback_front_camera_mirror";
      AppMethodBeat.o(237673);
    }
    
    public static String bur()
    {
      return nLd;
    }
    
    public static String bus()
    {
      return nLe;
    }
    
    public static String but()
    {
      return nLf;
    }
    
    public static String buu()
    {
      return nLi;
    }
    
    public static String buv()
    {
      return nLj;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.d.b
 * JD-Core Version:    0.7.0.1
 */