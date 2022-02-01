package com.tencent.gpudetector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.r;
import kotlin.v;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gpudetector/JniGPUDetector;", "", "()V", "gpuArchInfo", "", "getGpuArchInfo", "()Ljava/lang/String;", "gpuCodeInfo", "", "getGpuCodeInfo", "()I", "gpuCoreSumInfo", "getGpuCoreSumInfo", "gpuInfo", "", "getGpuInfo", "()[I", "gpuPerfScoreInfo", "getGpuPerfScoreInfo", "GetGPUDeviceModel", "", "deviceModel", "Lcom/tencent/gpudetector/JniGPUDetector$GpuDeviceModel;", "Companion", "GpuDeviceModel", "gpudetector_release"}, k=1, mv={1, 1, 16})
public final class JniGPUDetector
{
  public static final Companion Companion;
  private static final HashMap<Integer, String> gpuDetailList;
  private byte _hellAccFlag_;
  
  static
  {
    AppMethodBeat.i(210389);
    Companion = new Companion(null);
    gpuDetailList = ak.g(new r[] { v.Y(Integer.valueOf(-1), "GpuDeviceArchUnknown"), v.Y(Integer.valueOf(0), "GpuDeviceArchAMDGeneric"), v.Y(Integer.valueOf(1), "GpuDeviceArchAppleGeneric"), v.Y(Integer.valueOf(2), "GpuDeviceArchAppleA"), v.Y(Integer.valueOf(3), "GpuDeviceArchARMGeneric"), v.Y(Integer.valueOf(4), "GpuDeviceArchMaliMidgardT"), v.Y(Integer.valueOf(5), "GpuDeviceArchMaliBifrostG"), v.Y(Integer.valueOf(6), "GpuDeviceArchMaliValhallG"), v.Y(Integer.valueOf(7), "GpuDeviceArchImaginationGeneric"), v.Y(Integer.valueOf(8), "GpuDeviceArchPowerVRSGX"), v.Y(Integer.valueOf(9), "GpuDeviceArchPowerVRRogueGeneric"), v.Y(Integer.valueOf(10), "GpuDeviceArchPowerVRRogueG"), v.Y(Integer.valueOf(11), "GpuDeviceArchPowerVRRogueGX"), v.Y(Integer.valueOf(12), "GpuDeviceArchPowerVRRogueGT"), v.Y(Integer.valueOf(13), "GpuDeviceArchPowerVRRogueGE"), v.Y(Integer.valueOf(14), "GpuDeviceArchPowerVRRogueGM"), v.Y(Integer.valueOf(15), "GpuDeviceArchPowerVRFurianBegin"), v.Y(Integer.valueOf(16), "GpuDeviceArchPowerVRFurianGT"), v.Y(Integer.valueOf(17), "GpuDeviceArchImgAlbiorixGeneric"), v.Y(Integer.valueOf(18), "GpuDeviceArchImgAlbiorixAXE"), v.Y(Integer.valueOf(19), "GpuDeviceArchImgAlbiorixAXM"), v.Y(Integer.valueOf(20), "GpuDeviceArchImgAlbiorixAXT"), v.Y(Integer.valueOf(21), "GpuDeviceArchIntelGeneric"), v.Y(Integer.valueOf(22), "GpuDeviceArchNVIDIAGeneric"), v.Y(Integer.valueOf(23), "GpuDeviceArchQualcommGeneric"), v.Y(Integer.valueOf(24), "GpuDeviceArchAdreno3XX"), v.Y(Integer.valueOf(25), "GpuDeviceArchAdreno4XX"), v.Y(Integer.valueOf(26), "GpuDeviceArchAdreno5XX"), v.Y(Integer.valueOf(27), "GpuDeviceArchAdreno6XX") });
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG("GPUDetector");
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/gpudetector/JniGPUDetector", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/gpudetector/JniGPUDetector", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    AppMethodBeat.o(210389);
  }
  
  public final native boolean GetGPUDeviceModel(GpuDeviceModel paramGpuDeviceModel);
  
  public final String getGpuArchInfo()
  {
    AppMethodBeat.i(210393);
    Object localObject = new GpuDeviceModel();
    if (new JniGPUDetector().GetGPUDeviceModel((GpuDeviceModel)localObject))
    {
      localObject = Companion.getArchNameDetail(((GpuDeviceModel)localObject).getArch());
      AppMethodBeat.o(210393);
      return localObject;
    }
    localObject = Companion.getArchNameDetail(-1);
    AppMethodBeat.o(210393);
    return localObject;
  }
  
  public final int getGpuCodeInfo()
  {
    AppMethodBeat.i(210395);
    GpuDeviceModel localGpuDeviceModel = new GpuDeviceModel();
    if (new JniGPUDetector().GetGPUDeviceModel(localGpuDeviceModel))
    {
      int i = localGpuDeviceModel.getCode();
      AppMethodBeat.o(210395);
      return i;
    }
    AppMethodBeat.o(210395);
    return -1;
  }
  
  public final int getGpuCoreSumInfo()
  {
    AppMethodBeat.i(210397);
    GpuDeviceModel localGpuDeviceModel = new GpuDeviceModel();
    if (new JniGPUDetector().GetGPUDeviceModel(localGpuDeviceModel))
    {
      int i = localGpuDeviceModel.getNumCores();
      AppMethodBeat.o(210397);
      return i;
    }
    AppMethodBeat.o(210397);
    return -1;
  }
  
  public final int[] getGpuInfo()
  {
    AppMethodBeat.i(210400);
    GpuDeviceModel localGpuDeviceModel = new GpuDeviceModel();
    if (new JniGPUDetector().GetGPUDeviceModel(localGpuDeviceModel))
    {
      localGpuDeviceModel.getArch();
      localGpuDeviceModel.getCode();
      localGpuDeviceModel.getNumCores();
    }
    AppMethodBeat.o(210400);
    return null;
  }
  
  public final int getGpuPerfScoreInfo()
  {
    AppMethodBeat.i(210398);
    GpuDeviceModel localGpuDeviceModel = new GpuDeviceModel();
    if (new JniGPUDetector().GetGPUDeviceModel(localGpuDeviceModel))
    {
      int i = localGpuDeviceModel.getPerfScore();
      AppMethodBeat.o(210398);
      return i;
    }
    AppMethodBeat.o(210398);
    return -1;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gpudetector/JniGPUDetector$Companion;", "", "()V", "gpuDetailList", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getGpuDetailList", "()Ljava/util/HashMap;", "getArchNameDetail", "arch", "getVersion", "showGpuDeviceModel", "gpudetector_release"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    public final String getArchNameDetail(int paramInt)
    {
      AppMethodBeat.i(210391);
      String str = paramInt + '(' + (String)((Companion)this).getGpuDetailList().get(Integer.valueOf(paramInt)) + ')';
      AppMethodBeat.o(210391);
      return str;
    }
    
    public final HashMap<Integer, String> getGpuDetailList()
    {
      AppMethodBeat.i(210388);
      HashMap localHashMap = JniGPUDetector.access$getGpuDetailList$cp();
      AppMethodBeat.o(210388);
      return localHashMap;
    }
    
    public final String getVersion()
    {
      return "1.0.0-26";
    }
    
    public final String showGpuDeviceModel()
    {
      AppMethodBeat.i(210390);
      Object localObject = new JniGPUDetector.GpuDeviceModel();
      if (new JniGPUDetector().GetGPUDeviceModel((JniGPUDetector.GpuDeviceModel)localObject))
      {
        am localam = am.aixg;
        localObject = String.format("GPU arch: %s\n, code: %d, numCores: %d, perfScore: %d\nvendor: %s\nname: %s\nversion: %s\n", Arrays.copyOf(new Object[] { ((Companion)this).getArchNameDetail(((JniGPUDetector.GpuDeviceModel)localObject).getArch()), Integer.valueOf(((JniGPUDetector.GpuDeviceModel)localObject).getCode()), Integer.valueOf(((JniGPUDetector.GpuDeviceModel)localObject).getNumCores()), Integer.valueOf(((JniGPUDetector.GpuDeviceModel)localObject).getPerfScore()), ((JniGPUDetector.GpuDeviceModel)localObject).getVendor(), ((JniGPUDetector.GpuDeviceModel)localObject).getName(), ((JniGPUDetector.GpuDeviceModel)localObject).getVersion() }, 7));
        s.r(localObject, "java.lang.String.format(format, *args)");
        AppMethodBeat.o(210390);
        return localObject;
      }
      AppMethodBeat.o(210390);
      return "Failed to detect GPU";
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gpudetector/JniGPUDetector$GpuDeviceModel;", "", "()V", "arch", "", "getArch", "()I", "setArch", "(I)V", "code", "getCode", "setCode", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "numCores", "getNumCores", "setNumCores", "perfScore", "getPerfScore", "setPerfScore", "vendor", "getVendor", "setVendor", "version", "getVersion", "setVersion", "gpudetector_release"}, k=1, mv={1, 1, 16})
  public static final class GpuDeviceModel
  {
    private int arch;
    private int code;
    private String name = "Unknown";
    private int numCores;
    private int perfScore;
    private String vendor = "Unknown";
    private String version = "Unknown";
    
    public final int getArch()
    {
      return this.arch;
    }
    
    public final int getCode()
    {
      return this.code;
    }
    
    public final String getName()
    {
      return this.name;
    }
    
    public final int getNumCores()
    {
      return this.numCores;
    }
    
    public final int getPerfScore()
    {
      return this.perfScore;
    }
    
    public final String getVendor()
    {
      return this.vendor;
    }
    
    public final String getVersion()
    {
      return this.version;
    }
    
    public final void setArch(int paramInt)
    {
      this.arch = paramInt;
    }
    
    public final void setCode(int paramInt)
    {
      this.code = paramInt;
    }
    
    public final void setName(String paramString)
    {
      AppMethodBeat.i(210418);
      s.t(paramString, "<set-?>");
      this.name = paramString;
      AppMethodBeat.o(210418);
    }
    
    public final void setNumCores(int paramInt)
    {
      this.numCores = paramInt;
    }
    
    public final void setPerfScore(int paramInt)
    {
      this.perfScore = paramInt;
    }
    
    public final void setVendor(String paramString)
    {
      AppMethodBeat.i(210411);
      s.t(paramString, "<set-?>");
      this.vendor = paramString;
      AppMethodBeat.o(210411);
    }
    
    public final void setVersion(String paramString)
    {
      AppMethodBeat.i(210427);
      s.t(paramString, "<set-?>");
      this.version = paramString;
      AppMethodBeat.o(210427);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.gpudetector.JniGPUDetector
 * JD-Core Version:    0.7.0.1
 */