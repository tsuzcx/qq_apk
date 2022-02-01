package com.tencent.gpudetector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.a.ae;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.s;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/gpudetector/JniGPUDetector;", "", "()V", "gpuArchInfo", "", "getGpuArchInfo", "()Ljava/lang/String;", "gpuCodeInfo", "", "getGpuCodeInfo", "()I", "gpuCoreSumInfo", "getGpuCoreSumInfo", "gpuInfo", "", "getGpuInfo", "()[I", "gpuPerfScoreInfo", "getGpuPerfScoreInfo", "GetGPUDeviceModel", "", "deviceModel", "Lcom/tencent/gpudetector/JniGPUDetector$GpuDeviceModel;", "Companion", "GpuDeviceModel", "gpudetector_release"})
public final class JniGPUDetector
{
  public static final Companion Companion;
  private static final HashMap<Integer, String> gpuDetailList;
  
  static
  {
    AppMethodBeat.i(218368);
    Companion = new Companion(null);
    gpuDetailList = ae.g(new o[] { s.M(Integer.valueOf(-1), "GpuDeviceArchUnknown"), s.M(Integer.valueOf(0), "GpuDeviceArchAMDGeneric"), s.M(Integer.valueOf(1), "GpuDeviceArchAppleGeneric"), s.M(Integer.valueOf(2), "GpuDeviceArchAppleA"), s.M(Integer.valueOf(3), "GpuDeviceArchARMGeneric"), s.M(Integer.valueOf(4), "GpuDeviceArchMaliMidgardT"), s.M(Integer.valueOf(5), "GpuDeviceArchMaliBifrostG"), s.M(Integer.valueOf(6), "GpuDeviceArchMaliValhallG"), s.M(Integer.valueOf(7), "GpuDeviceArchImaginationGeneric"), s.M(Integer.valueOf(8), "GpuDeviceArchPowerVRSGX"), s.M(Integer.valueOf(9), "GpuDeviceArchPowerVRRogueGeneric"), s.M(Integer.valueOf(10), "GpuDeviceArchPowerVRRogueG"), s.M(Integer.valueOf(11), "GpuDeviceArchPowerVRRogueGX"), s.M(Integer.valueOf(12), "GpuDeviceArchPowerVRRogueGT"), s.M(Integer.valueOf(13), "GpuDeviceArchPowerVRRogueGE"), s.M(Integer.valueOf(14), "GpuDeviceArchPowerVRRogueGM"), s.M(Integer.valueOf(15), "GpuDeviceArchPowerVRFurianBegin"), s.M(Integer.valueOf(16), "GpuDeviceArchPowerVRFurianGT"), s.M(Integer.valueOf(17), "GpuDeviceArchImgAlbiorixGeneric"), s.M(Integer.valueOf(18), "GpuDeviceArchImgAlbiorixAXE"), s.M(Integer.valueOf(19), "GpuDeviceArchImgAlbiorixAXM"), s.M(Integer.valueOf(20), "GpuDeviceArchImgAlbiorixAXT"), s.M(Integer.valueOf(21), "GpuDeviceArchIntelGeneric"), s.M(Integer.valueOf(22), "GpuDeviceArchNVIDIAGeneric"), s.M(Integer.valueOf(23), "GpuDeviceArchQualcommGeneric"), s.M(Integer.valueOf(24), "GpuDeviceArchAdreno3XX"), s.M(Integer.valueOf(25), "GpuDeviceArchAdreno4XX"), s.M(Integer.valueOf(26), "GpuDeviceArchAdreno5XX"), s.M(Integer.valueOf(27), "GpuDeviceArchAdreno6XX") });
    System.loadLibrary("GPUDetector");
    AppMethodBeat.o(218368);
  }
  
  public final native boolean GetGPUDeviceModel(GpuDeviceModel paramGpuDeviceModel);
  
  public final String getGpuArchInfo()
  {
    AppMethodBeat.i(218355);
    Object localObject = new GpuDeviceModel();
    if (new JniGPUDetector().GetGPUDeviceModel((GpuDeviceModel)localObject))
    {
      localObject = Companion.getArchNameDetail(((GpuDeviceModel)localObject).getArch());
      AppMethodBeat.o(218355);
      return localObject;
    }
    localObject = Companion.getArchNameDetail(-1);
    AppMethodBeat.o(218355);
    return localObject;
  }
  
  public final int getGpuCodeInfo()
  {
    AppMethodBeat.i(218356);
    GpuDeviceModel localGpuDeviceModel = new GpuDeviceModel();
    if (new JniGPUDetector().GetGPUDeviceModel(localGpuDeviceModel))
    {
      int i = localGpuDeviceModel.getCode();
      AppMethodBeat.o(218356);
      return i;
    }
    AppMethodBeat.o(218356);
    return -1;
  }
  
  public final int getGpuCoreSumInfo()
  {
    AppMethodBeat.i(218360);
    GpuDeviceModel localGpuDeviceModel = new GpuDeviceModel();
    if (new JniGPUDetector().GetGPUDeviceModel(localGpuDeviceModel))
    {
      int i = localGpuDeviceModel.getNumCores();
      AppMethodBeat.o(218360);
      return i;
    }
    AppMethodBeat.o(218360);
    return -1;
  }
  
  public final int[] getGpuInfo()
  {
    AppMethodBeat.i(218365);
    GpuDeviceModel localGpuDeviceModel = new GpuDeviceModel();
    if (new JniGPUDetector().GetGPUDeviceModel(localGpuDeviceModel))
    {
      localGpuDeviceModel.getArch();
      localGpuDeviceModel.getCode();
      localGpuDeviceModel.getNumCores();
    }
    AppMethodBeat.o(218365);
    return null;
  }
  
  public final int getGpuPerfScoreInfo()
  {
    AppMethodBeat.i(218363);
    GpuDeviceModel localGpuDeviceModel = new GpuDeviceModel();
    if (new JniGPUDetector().GetGPUDeviceModel(localGpuDeviceModel))
    {
      int i = localGpuDeviceModel.getPerfScore();
      AppMethodBeat.o(218363);
      return i;
    }
    AppMethodBeat.o(218363);
    return -1;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/gpudetector/JniGPUDetector$Companion;", "", "()V", "gpuDetailList", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getGpuDetailList", "()Ljava/util/HashMap;", "getArchNameDetail", "arch", "getVersion", "showGpuDeviceModel", "gpudetector_release"})
  public static final class Companion
  {
    public final String getArchNameDetail(int paramInt)
    {
      AppMethodBeat.i(218326);
      String str = paramInt + '(' + (String)((Companion)this).getGpuDetailList().get(Integer.valueOf(paramInt)) + ')';
      AppMethodBeat.o(218326);
      return str;
    }
    
    public final HashMap<Integer, String> getGpuDetailList()
    {
      AppMethodBeat.i(218322);
      HashMap localHashMap = JniGPUDetector.access$getGpuDetailList$cp();
      AppMethodBeat.o(218322);
      return localHashMap;
    }
    
    public final String getVersion()
    {
      return "1.0.0-23";
    }
    
    public final String showGpuDeviceModel()
    {
      AppMethodBeat.i(218325);
      Object localObject = new JniGPUDetector.GpuDeviceModel();
      if (new JniGPUDetector().GetGPUDeviceModel((JniGPUDetector.GpuDeviceModel)localObject))
      {
        af localaf = af.aaBG;
        localObject = String.format("GPU arch: %s\n, code: %d, numCores: %d, perfScore: %d\nvendor: %s\nname: %s\nversion: %s\n", Arrays.copyOf(new Object[] { ((Companion)this).getArchNameDetail(((JniGPUDetector.GpuDeviceModel)localObject).getArch()), Integer.valueOf(((JniGPUDetector.GpuDeviceModel)localObject).getCode()), Integer.valueOf(((JniGPUDetector.GpuDeviceModel)localObject).getNumCores()), Integer.valueOf(((JniGPUDetector.GpuDeviceModel)localObject).getPerfScore()), ((JniGPUDetector.GpuDeviceModel)localObject).getVendor(), ((JniGPUDetector.GpuDeviceModel)localObject).getName(), ((JniGPUDetector.GpuDeviceModel)localObject).getVersion() }, 7));
        p.j(localObject, "java.lang.String.format(format, *args)");
        AppMethodBeat.o(218325);
        return localObject;
      }
      AppMethodBeat.o(218325);
      return "Failed to detect GPU";
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/gpudetector/JniGPUDetector$GpuDeviceModel;", "", "()V", "arch", "", "getArch", "()I", "setArch", "(I)V", "code", "getCode", "setCode", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "numCores", "getNumCores", "setNumCores", "perfScore", "getPerfScore", "setPerfScore", "vendor", "getVendor", "setVendor", "version", "getVersion", "setVersion", "gpudetector_release"})
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
      AppMethodBeat.i(218347);
      p.k(paramString, "<set-?>");
      this.name = paramString;
      AppMethodBeat.o(218347);
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
      AppMethodBeat.i(218344);
      p.k(paramString, "<set-?>");
      this.vendor = paramString;
      AppMethodBeat.o(218344);
    }
    
    public final void setVersion(String paramString)
    {
      AppMethodBeat.i(218349);
      p.k(paramString, "<set-?>");
      this.version = paramString;
      AppMethodBeat.o(218349);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.gpudetector.JniGPUDetector
 * JD-Core Version:    0.7.0.1
 */