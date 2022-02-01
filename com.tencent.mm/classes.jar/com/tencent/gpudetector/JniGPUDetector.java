package com.tencent.gpudetector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.s;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/gpudetector/JniGPUDetector;", "", "()V", "gpuArchInfo", "", "getGpuArchInfo", "()Ljava/lang/String;", "gpuCodeInfo", "", "getGpuCodeInfo", "()I", "gpuCoreSumInfo", "getGpuCoreSumInfo", "gpuInfo", "", "getGpuInfo", "()[I", "gpuPerfScoreInfo", "getGpuPerfScoreInfo", "GetGPUDeviceModel", "", "deviceModel", "Lcom/tencent/gpudetector/JniGPUDetector$GpuDeviceModel;", "Companion", "GpuDeviceModel", "gpudetector_release"})
public final class JniGPUDetector
{
  public static final Companion Companion;
  private static final HashMap<Integer, String> gpuDetailList;
  
  static
  {
    AppMethodBeat.i(194415);
    Companion = new Companion(null);
    gpuDetailList = kotlin.a.ae.g(new o[] { s.U(Integer.valueOf(-1), "GpuDeviceArchUnknown"), s.U(Integer.valueOf(0), "GpuDeviceArchAMDGeneric"), s.U(Integer.valueOf(1), "GpuDeviceArchAppleGeneric"), s.U(Integer.valueOf(2), "GpuDeviceArchAppleA"), s.U(Integer.valueOf(3), "GpuDeviceArchARMGeneric"), s.U(Integer.valueOf(4), "GpuDeviceArchMaliMidgardT"), s.U(Integer.valueOf(5), "GpuDeviceArchMaliBifrostG"), s.U(Integer.valueOf(6), "GpuDeviceArchMaliValhallG"), s.U(Integer.valueOf(7), "GpuDeviceArchImaginationGeneric"), s.U(Integer.valueOf(8), "GpuDeviceArchPowerVRSGX"), s.U(Integer.valueOf(9), "GpuDeviceArchPowerVRRogueGeneric"), s.U(Integer.valueOf(10), "GpuDeviceArchPowerVRRogueG"), s.U(Integer.valueOf(11), "GpuDeviceArchPowerVRRogueGX"), s.U(Integer.valueOf(12), "GpuDeviceArchPowerVRRogueGT"), s.U(Integer.valueOf(13), "GpuDeviceArchPowerVRRogueGE"), s.U(Integer.valueOf(14), "GpuDeviceArchPowerVRRogueGM"), s.U(Integer.valueOf(15), "GpuDeviceArchPowerVRFurianBegin"), s.U(Integer.valueOf(16), "GpuDeviceArchPowerVRFurianGT"), s.U(Integer.valueOf(17), "GpuDeviceArchImgAlbiorixGeneric"), s.U(Integer.valueOf(18), "GpuDeviceArchImgAlbiorixAXE"), s.U(Integer.valueOf(19), "GpuDeviceArchImgAlbiorixAXM"), s.U(Integer.valueOf(20), "GpuDeviceArchImgAlbiorixAXT"), s.U(Integer.valueOf(21), "GpuDeviceArchIntelGeneric"), s.U(Integer.valueOf(22), "GpuDeviceArchNVIDIAGeneric"), s.U(Integer.valueOf(23), "GpuDeviceArchQualcommGeneric"), s.U(Integer.valueOf(24), "GpuDeviceArchAdreno3XX"), s.U(Integer.valueOf(25), "GpuDeviceArchAdreno4XX"), s.U(Integer.valueOf(26), "GpuDeviceArchAdreno5XX"), s.U(Integer.valueOf(27), "GpuDeviceArchAdreno6XX") });
    System.loadLibrary("GPUDetector");
    AppMethodBeat.o(194415);
  }
  
  public final native boolean GetGPUDeviceModel(GpuDeviceModel paramGpuDeviceModel);
  
  public final String getGpuArchInfo()
  {
    AppMethodBeat.i(194410);
    Object localObject = new GpuDeviceModel();
    if (new JniGPUDetector().GetGPUDeviceModel((GpuDeviceModel)localObject))
    {
      localObject = Companion.getArchNameDetail(((GpuDeviceModel)localObject).getArch());
      AppMethodBeat.o(194410);
      return localObject;
    }
    localObject = Companion.getArchNameDetail(-1);
    AppMethodBeat.o(194410);
    return localObject;
  }
  
  public final int getGpuCodeInfo()
  {
    AppMethodBeat.i(194411);
    GpuDeviceModel localGpuDeviceModel = new GpuDeviceModel();
    if (new JniGPUDetector().GetGPUDeviceModel(localGpuDeviceModel))
    {
      int i = localGpuDeviceModel.getCode();
      AppMethodBeat.o(194411);
      return i;
    }
    AppMethodBeat.o(194411);
    return -1;
  }
  
  public final int getGpuCoreSumInfo()
  {
    AppMethodBeat.i(194412);
    GpuDeviceModel localGpuDeviceModel = new GpuDeviceModel();
    if (new JniGPUDetector().GetGPUDeviceModel(localGpuDeviceModel))
    {
      int i = localGpuDeviceModel.getNumCores();
      AppMethodBeat.o(194412);
      return i;
    }
    AppMethodBeat.o(194412);
    return -1;
  }
  
  public final int[] getGpuInfo()
  {
    AppMethodBeat.i(194414);
    GpuDeviceModel localGpuDeviceModel = new GpuDeviceModel();
    if (new JniGPUDetector().GetGPUDeviceModel(localGpuDeviceModel))
    {
      localGpuDeviceModel.getArch();
      localGpuDeviceModel.getCode();
      localGpuDeviceModel.getNumCores();
    }
    AppMethodBeat.o(194414);
    return null;
  }
  
  public final int getGpuPerfScoreInfo()
  {
    AppMethodBeat.i(194413);
    GpuDeviceModel localGpuDeviceModel = new GpuDeviceModel();
    if (new JniGPUDetector().GetGPUDeviceModel(localGpuDeviceModel))
    {
      int i = localGpuDeviceModel.getPerfScore();
      AppMethodBeat.o(194413);
      return i;
    }
    AppMethodBeat.o(194413);
    return -1;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/gpudetector/JniGPUDetector$Companion;", "", "()V", "gpuDetailList", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getGpuDetailList", "()Ljava/util/HashMap;", "getArchNameDetail", "arch", "getVersion", "showGpuDeviceModel", "gpudetector_release"})
  public static final class Companion
  {
    public final String getArchNameDetail(int paramInt)
    {
      AppMethodBeat.i(194406);
      String str = paramInt + '(' + (String)((Companion)this).getGpuDetailList().get(Integer.valueOf(paramInt)) + ')';
      AppMethodBeat.o(194406);
      return str;
    }
    
    public final HashMap<Integer, String> getGpuDetailList()
    {
      AppMethodBeat.i(194404);
      HashMap localHashMap = JniGPUDetector.access$getGpuDetailList$cp();
      AppMethodBeat.o(194404);
      return localHashMap;
    }
    
    public final String getVersion()
    {
      return "1.0.0-23";
    }
    
    public final String showGpuDeviceModel()
    {
      AppMethodBeat.i(194405);
      Object localObject = new JniGPUDetector.GpuDeviceModel();
      if (new JniGPUDetector().GetGPUDeviceModel((JniGPUDetector.GpuDeviceModel)localObject))
      {
        kotlin.g.b.ae localae = kotlin.g.b.ae.SYK;
        localObject = String.format("GPU arch: %s\n, code: %d, numCores: %d, perfScore: %d\nvendor: %s\nname: %s\nversion: %s\n", Arrays.copyOf(new Object[] { ((Companion)this).getArchNameDetail(((JniGPUDetector.GpuDeviceModel)localObject).getArch()), Integer.valueOf(((JniGPUDetector.GpuDeviceModel)localObject).getCode()), Integer.valueOf(((JniGPUDetector.GpuDeviceModel)localObject).getNumCores()), Integer.valueOf(((JniGPUDetector.GpuDeviceModel)localObject).getPerfScore()), ((JniGPUDetector.GpuDeviceModel)localObject).getVendor(), ((JniGPUDetector.GpuDeviceModel)localObject).getName(), ((JniGPUDetector.GpuDeviceModel)localObject).getVersion() }, 7));
        p.g(localObject, "java.lang.String.format(format, *args)");
        AppMethodBeat.o(194405);
        return localObject;
      }
      AppMethodBeat.o(194405);
      return "Failed to detect GPU";
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/gpudetector/JniGPUDetector$GpuDeviceModel;", "", "()V", "arch", "", "getArch", "()I", "setArch", "(I)V", "code", "getCode", "setCode", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "numCores", "getNumCores", "setNumCores", "perfScore", "getPerfScore", "setPerfScore", "vendor", "getVendor", "setVendor", "version", "getVersion", "setVersion", "gpudetector_release"})
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
      AppMethodBeat.i(194408);
      p.h(paramString, "<set-?>");
      this.name = paramString;
      AppMethodBeat.o(194408);
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
      AppMethodBeat.i(194407);
      p.h(paramString, "<set-?>");
      this.vendor = paramString;
      AppMethodBeat.o(194407);
    }
    
    public final void setVersion(String paramString)
    {
      AppMethodBeat.i(194409);
      p.h(paramString, "<set-?>");
      this.version = paramString;
      AppMethodBeat.o(194409);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.gpudetector.JniGPUDetector
 * JD-Core Version:    0.7.0.1
 */