package com.tencent.gpudetector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.g.b.k;
import d.g.b.z;
import d.l;
import d.o;
import d.u;
import java.util.Arrays;
import java.util.HashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/gpudetector/JniGPUDetector;", "", "()V", "gpuArchInfo", "", "getGpuArchInfo", "()Ljava/lang/String;", "gpuCodeInfo", "", "getGpuCodeInfo", "()I", "gpuCoreSumInfo", "getGpuCoreSumInfo", "gpuInfo", "", "getGpuInfo", "()[I", "gpuPerfScoreInfo", "getGpuPerfScoreInfo", "GetGPUDeviceModel", "", "deviceModel", "Lcom/tencent/gpudetector/JniGPUDetector$GpuDeviceModel;", "Companion", "GpuDeviceModel", "gpudetector_release"})
public final class JniGPUDetector
{
  public static final Companion Companion;
  private static final HashMap<Integer, String> gpuDetailList;
  
  static
  {
    AppMethodBeat.i(207346);
    Companion = new Companion(null);
    gpuDetailList = ae.c(new o[] { u.Q(Integer.valueOf(-1), "GpuDeviceArchUnknown"), u.Q(Integer.valueOf(0), "GpuDeviceArchAMDGeneric"), u.Q(Integer.valueOf(1), "GpuDeviceArchAppleGeneric"), u.Q(Integer.valueOf(2), "GpuDeviceArchAppleA"), u.Q(Integer.valueOf(3), "GpuDeviceArchARMGeneric"), u.Q(Integer.valueOf(4), "GpuDeviceArchMaliMidgardT"), u.Q(Integer.valueOf(5), "GpuDeviceArchMaliBifrostG"), u.Q(Integer.valueOf(6), "GpuDeviceArchMaliValhallG"), u.Q(Integer.valueOf(7), "GpuDeviceArchImaginationGeneric"), u.Q(Integer.valueOf(8), "GpuDeviceArchPowerVRSGX"), u.Q(Integer.valueOf(9), "GpuDeviceArchPowerVRRogueGeneric"), u.Q(Integer.valueOf(10), "GpuDeviceArchPowerVRRogueG"), u.Q(Integer.valueOf(11), "GpuDeviceArchPowerVRRogueGX"), u.Q(Integer.valueOf(12), "GpuDeviceArchPowerVRRogueGT"), u.Q(Integer.valueOf(13), "GpuDeviceArchPowerVRRogueGE"), u.Q(Integer.valueOf(14), "GpuDeviceArchPowerVRRogueGM"), u.Q(Integer.valueOf(15), "GpuDeviceArchPowerVRFurianBegin"), u.Q(Integer.valueOf(16), "GpuDeviceArchPowerVRFurianGT"), u.Q(Integer.valueOf(17), "GpuDeviceArchImgAlbiorixGeneric"), u.Q(Integer.valueOf(18), "GpuDeviceArchImgAlbiorixAXE"), u.Q(Integer.valueOf(19), "GpuDeviceArchImgAlbiorixAXM"), u.Q(Integer.valueOf(20), "GpuDeviceArchImgAlbiorixAXT"), u.Q(Integer.valueOf(21), "GpuDeviceArchIntelGeneric"), u.Q(Integer.valueOf(22), "GpuDeviceArchNVIDIAGeneric"), u.Q(Integer.valueOf(23), "GpuDeviceArchQualcommGeneric"), u.Q(Integer.valueOf(24), "GpuDeviceArchAdreno3XX"), u.Q(Integer.valueOf(25), "GpuDeviceArchAdreno4XX"), u.Q(Integer.valueOf(26), "GpuDeviceArchAdreno5XX"), u.Q(Integer.valueOf(27), "GpuDeviceArchAdreno6XX") });
    System.loadLibrary("GPUDetector");
    AppMethodBeat.o(207346);
  }
  
  public final native boolean GetGPUDeviceModel(GpuDeviceModel paramGpuDeviceModel);
  
  public final String getGpuArchInfo()
  {
    AppMethodBeat.i(207341);
    Object localObject = new GpuDeviceModel();
    if (new JniGPUDetector().GetGPUDeviceModel((GpuDeviceModel)localObject))
    {
      localObject = Companion.getArchNameDetail(((GpuDeviceModel)localObject).getArch());
      AppMethodBeat.o(207341);
      return localObject;
    }
    localObject = Companion.getArchNameDetail(-1);
    AppMethodBeat.o(207341);
    return localObject;
  }
  
  public final int getGpuCodeInfo()
  {
    AppMethodBeat.i(207342);
    GpuDeviceModel localGpuDeviceModel = new GpuDeviceModel();
    if (new JniGPUDetector().GetGPUDeviceModel(localGpuDeviceModel))
    {
      int i = localGpuDeviceModel.getCode();
      AppMethodBeat.o(207342);
      return i;
    }
    AppMethodBeat.o(207342);
    return -1;
  }
  
  public final int getGpuCoreSumInfo()
  {
    AppMethodBeat.i(207343);
    GpuDeviceModel localGpuDeviceModel = new GpuDeviceModel();
    if (new JniGPUDetector().GetGPUDeviceModel(localGpuDeviceModel))
    {
      int i = localGpuDeviceModel.getNumCores();
      AppMethodBeat.o(207343);
      return i;
    }
    AppMethodBeat.o(207343);
    return -1;
  }
  
  public final int[] getGpuInfo()
  {
    AppMethodBeat.i(207345);
    GpuDeviceModel localGpuDeviceModel = new GpuDeviceModel();
    if (new JniGPUDetector().GetGPUDeviceModel(localGpuDeviceModel))
    {
      localGpuDeviceModel.getArch();
      localGpuDeviceModel.getCode();
      localGpuDeviceModel.getNumCores();
    }
    AppMethodBeat.o(207345);
    return null;
  }
  
  public final int getGpuPerfScoreInfo()
  {
    AppMethodBeat.i(207344);
    GpuDeviceModel localGpuDeviceModel = new GpuDeviceModel();
    if (new JniGPUDetector().GetGPUDeviceModel(localGpuDeviceModel))
    {
      int i = localGpuDeviceModel.getPerfScore();
      AppMethodBeat.o(207344);
      return i;
    }
    AppMethodBeat.o(207344);
    return -1;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/gpudetector/JniGPUDetector$Companion;", "", "()V", "gpuDetailList", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getGpuDetailList", "()Ljava/util/HashMap;", "getArchNameDetail", "arch", "showGpuDeviceModel", "gpudetector_release"})
  public static final class Companion
  {
    public final String getArchNameDetail(int paramInt)
    {
      AppMethodBeat.i(207337);
      String str = paramInt + '(' + (String)((Companion)this).getGpuDetailList().get(Integer.valueOf(paramInt)) + ')';
      AppMethodBeat.o(207337);
      return str;
    }
    
    public final HashMap<Integer, String> getGpuDetailList()
    {
      AppMethodBeat.i(207335);
      HashMap localHashMap = JniGPUDetector.access$getGpuDetailList$cp();
      AppMethodBeat.o(207335);
      return localHashMap;
    }
    
    public final String showGpuDeviceModel()
    {
      AppMethodBeat.i(207336);
      Object localObject = new JniGPUDetector.GpuDeviceModel();
      if (new JniGPUDetector().GetGPUDeviceModel((JniGPUDetector.GpuDeviceModel)localObject))
      {
        z localz = z.KUT;
        localObject = String.format("GPU arch: %s\n, code: %d, numCores: %d, perfScore: %d\nvendor: %s\nname: %s\nversion: %s\n", Arrays.copyOf(new Object[] { ((Companion)this).getArchNameDetail(((JniGPUDetector.GpuDeviceModel)localObject).getArch()), Integer.valueOf(((JniGPUDetector.GpuDeviceModel)localObject).getCode()), Integer.valueOf(((JniGPUDetector.GpuDeviceModel)localObject).getNumCores()), Integer.valueOf(((JniGPUDetector.GpuDeviceModel)localObject).getPerfScore()), ((JniGPUDetector.GpuDeviceModel)localObject).getVendor(), ((JniGPUDetector.GpuDeviceModel)localObject).getName(), ((JniGPUDetector.GpuDeviceModel)localObject).getVersion() }, 7));
        k.g(localObject, "java.lang.String.format(format, *args)");
        AppMethodBeat.o(207336);
        return localObject;
      }
      AppMethodBeat.o(207336);
      return "Failed to detect GPU";
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/gpudetector/JniGPUDetector$GpuDeviceModel;", "", "()V", "arch", "", "getArch", "()I", "setArch", "(I)V", "code", "getCode", "setCode", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "numCores", "getNumCores", "setNumCores", "perfScore", "getPerfScore", "setPerfScore", "vendor", "getVendor", "setVendor", "version", "getVersion", "setVersion", "gpudetector_release"})
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
      AppMethodBeat.i(207339);
      k.h(paramString, "<set-?>");
      this.name = paramString;
      AppMethodBeat.o(207339);
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
      AppMethodBeat.i(207338);
      k.h(paramString, "<set-?>");
      this.vendor = paramString;
      AppMethodBeat.o(207338);
    }
    
    public final void setVersion(String paramString)
    {
      AppMethodBeat.i(207340);
      k.h(paramString, "<set-?>");
      this.version = paramString;
      AppMethodBeat.o(207340);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.gpudetector.JniGPUDetector
 * JD-Core Version:    0.7.0.1
 */