package com.tencent.gpudetector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.g.b.ad;
import d.g.b.p;
import d.l;
import d.o;
import d.u;
import java.util.Arrays;
import java.util.HashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/gpudetector/JniGPUDetector;", "", "()V", "gpuArchInfo", "", "getGpuArchInfo", "()Ljava/lang/String;", "gpuCodeInfo", "", "getGpuCodeInfo", "()I", "gpuCoreSumInfo", "getGpuCoreSumInfo", "gpuInfo", "", "getGpuInfo", "()[I", "gpuPerfScoreInfo", "getGpuPerfScoreInfo", "GetGPUDeviceModel", "", "deviceModel", "Lcom/tencent/gpudetector/JniGPUDetector$GpuDeviceModel;", "Companion", "GpuDeviceModel", "gpudetector_release"})
public final class JniGPUDetector
{
  public static final Companion Companion;
  private static final HashMap<Integer, String> gpuDetailList;
  
  static
  {
    AppMethodBeat.i(199580);
    Companion = new Companion(null);
    gpuDetailList = ae.c(new o[] { u.R(Integer.valueOf(-1), "GpuDeviceArchUnknown"), u.R(Integer.valueOf(0), "GpuDeviceArchAMDGeneric"), u.R(Integer.valueOf(1), "GpuDeviceArchAppleGeneric"), u.R(Integer.valueOf(2), "GpuDeviceArchAppleA"), u.R(Integer.valueOf(3), "GpuDeviceArchARMGeneric"), u.R(Integer.valueOf(4), "GpuDeviceArchMaliMidgardT"), u.R(Integer.valueOf(5), "GpuDeviceArchMaliBifrostG"), u.R(Integer.valueOf(6), "GpuDeviceArchMaliValhallG"), u.R(Integer.valueOf(7), "GpuDeviceArchImaginationGeneric"), u.R(Integer.valueOf(8), "GpuDeviceArchPowerVRSGX"), u.R(Integer.valueOf(9), "GpuDeviceArchPowerVRRogueGeneric"), u.R(Integer.valueOf(10), "GpuDeviceArchPowerVRRogueG"), u.R(Integer.valueOf(11), "GpuDeviceArchPowerVRRogueGX"), u.R(Integer.valueOf(12), "GpuDeviceArchPowerVRRogueGT"), u.R(Integer.valueOf(13), "GpuDeviceArchPowerVRRogueGE"), u.R(Integer.valueOf(14), "GpuDeviceArchPowerVRRogueGM"), u.R(Integer.valueOf(15), "GpuDeviceArchPowerVRFurianBegin"), u.R(Integer.valueOf(16), "GpuDeviceArchPowerVRFurianGT"), u.R(Integer.valueOf(17), "GpuDeviceArchImgAlbiorixGeneric"), u.R(Integer.valueOf(18), "GpuDeviceArchImgAlbiorixAXE"), u.R(Integer.valueOf(19), "GpuDeviceArchImgAlbiorixAXM"), u.R(Integer.valueOf(20), "GpuDeviceArchImgAlbiorixAXT"), u.R(Integer.valueOf(21), "GpuDeviceArchIntelGeneric"), u.R(Integer.valueOf(22), "GpuDeviceArchNVIDIAGeneric"), u.R(Integer.valueOf(23), "GpuDeviceArchQualcommGeneric"), u.R(Integer.valueOf(24), "GpuDeviceArchAdreno3XX"), u.R(Integer.valueOf(25), "GpuDeviceArchAdreno4XX"), u.R(Integer.valueOf(26), "GpuDeviceArchAdreno5XX"), u.R(Integer.valueOf(27), "GpuDeviceArchAdreno6XX") });
    System.loadLibrary("GPUDetector");
    AppMethodBeat.o(199580);
  }
  
  public final native boolean GetGPUDeviceModel(GpuDeviceModel paramGpuDeviceModel);
  
  public final String getGpuArchInfo()
  {
    AppMethodBeat.i(199575);
    Object localObject = new GpuDeviceModel();
    if (new JniGPUDetector().GetGPUDeviceModel((GpuDeviceModel)localObject))
    {
      localObject = Companion.getArchNameDetail(((GpuDeviceModel)localObject).getArch());
      AppMethodBeat.o(199575);
      return localObject;
    }
    localObject = Companion.getArchNameDetail(-1);
    AppMethodBeat.o(199575);
    return localObject;
  }
  
  public final int getGpuCodeInfo()
  {
    AppMethodBeat.i(199576);
    GpuDeviceModel localGpuDeviceModel = new GpuDeviceModel();
    if (new JniGPUDetector().GetGPUDeviceModel(localGpuDeviceModel))
    {
      int i = localGpuDeviceModel.getCode();
      AppMethodBeat.o(199576);
      return i;
    }
    AppMethodBeat.o(199576);
    return -1;
  }
  
  public final int getGpuCoreSumInfo()
  {
    AppMethodBeat.i(199577);
    GpuDeviceModel localGpuDeviceModel = new GpuDeviceModel();
    if (new JniGPUDetector().GetGPUDeviceModel(localGpuDeviceModel))
    {
      int i = localGpuDeviceModel.getNumCores();
      AppMethodBeat.o(199577);
      return i;
    }
    AppMethodBeat.o(199577);
    return -1;
  }
  
  public final int[] getGpuInfo()
  {
    AppMethodBeat.i(199579);
    GpuDeviceModel localGpuDeviceModel = new GpuDeviceModel();
    if (new JniGPUDetector().GetGPUDeviceModel(localGpuDeviceModel))
    {
      localGpuDeviceModel.getArch();
      localGpuDeviceModel.getCode();
      localGpuDeviceModel.getNumCores();
    }
    AppMethodBeat.o(199579);
    return null;
  }
  
  public final int getGpuPerfScoreInfo()
  {
    AppMethodBeat.i(199578);
    GpuDeviceModel localGpuDeviceModel = new GpuDeviceModel();
    if (new JniGPUDetector().GetGPUDeviceModel(localGpuDeviceModel))
    {
      int i = localGpuDeviceModel.getPerfScore();
      AppMethodBeat.o(199578);
      return i;
    }
    AppMethodBeat.o(199578);
    return -1;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/gpudetector/JniGPUDetector$Companion;", "", "()V", "gpuDetailList", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getGpuDetailList", "()Ljava/util/HashMap;", "getArchNameDetail", "arch", "showGpuDeviceModel", "gpudetector_release"})
  public static final class Companion
  {
    public final String getArchNameDetail(int paramInt)
    {
      AppMethodBeat.i(199571);
      String str = paramInt + '(' + (String)((Companion)this).getGpuDetailList().get(Integer.valueOf(paramInt)) + ')';
      AppMethodBeat.o(199571);
      return str;
    }
    
    public final HashMap<Integer, String> getGpuDetailList()
    {
      AppMethodBeat.i(199569);
      HashMap localHashMap = JniGPUDetector.access$getGpuDetailList$cp();
      AppMethodBeat.o(199569);
      return localHashMap;
    }
    
    public final String showGpuDeviceModel()
    {
      AppMethodBeat.i(199570);
      Object localObject = new JniGPUDetector.GpuDeviceModel();
      if (new JniGPUDetector().GetGPUDeviceModel((JniGPUDetector.GpuDeviceModel)localObject))
      {
        ad localad = ad.Njc;
        localObject = String.format("GPU arch: %s\n, code: %d, numCores: %d, perfScore: %d\nvendor: %s\nname: %s\nversion: %s\n", Arrays.copyOf(new Object[] { ((Companion)this).getArchNameDetail(((JniGPUDetector.GpuDeviceModel)localObject).getArch()), Integer.valueOf(((JniGPUDetector.GpuDeviceModel)localObject).getCode()), Integer.valueOf(((JniGPUDetector.GpuDeviceModel)localObject).getNumCores()), Integer.valueOf(((JniGPUDetector.GpuDeviceModel)localObject).getPerfScore()), ((JniGPUDetector.GpuDeviceModel)localObject).getVendor(), ((JniGPUDetector.GpuDeviceModel)localObject).getName(), ((JniGPUDetector.GpuDeviceModel)localObject).getVersion() }, 7));
        p.g(localObject, "java.lang.String.format(format, *args)");
        AppMethodBeat.o(199570);
        return localObject;
      }
      AppMethodBeat.o(199570);
      return "Failed to detect GPU";
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/gpudetector/JniGPUDetector$GpuDeviceModel;", "", "()V", "arch", "", "getArch", "()I", "setArch", "(I)V", "code", "getCode", "setCode", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "numCores", "getNumCores", "setNumCores", "perfScore", "getPerfScore", "setPerfScore", "vendor", "getVendor", "setVendor", "version", "getVersion", "setVersion", "gpudetector_release"})
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
      AppMethodBeat.i(199573);
      p.h(paramString, "<set-?>");
      this.name = paramString;
      AppMethodBeat.o(199573);
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
      AppMethodBeat.i(199572);
      p.h(paramString, "<set-?>");
      this.vendor = paramString;
      AppMethodBeat.o(199572);
    }
    
    public final void setVersion(String paramString)
    {
      AppMethodBeat.i(199574);
      p.h(paramString, "<set-?>");
      this.version = paramString;
      AppMethodBeat.o(199574);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.gpudetector.JniGPUDetector
 * JD-Core Version:    0.7.0.1
 */