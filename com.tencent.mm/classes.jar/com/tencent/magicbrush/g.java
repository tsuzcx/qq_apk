package com.tencent.magicbrush;

import android.content.Context;
import android.content.res.AssetManager;
import com.github.henryye.nativeiv.BaseImageDecodeService;
import com.github.henryye.nativeiv.a.c.b;
import com.github.henryye.nativeiv.api.IImageDecodeService.a;
import com.tencent.magicbrush.handler.glfont.IMBFontHandler;
import com.tencent.magicbrush.ui.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/magicbrush/MagicBrushConfig;", "", "()V", "abortIfBuildingError", "", "getAbortIfBuildingError", "()Z", "setAbortIfBuildingError", "(Z)V", "<set-?>", "adjustThreadPriority", "getAdjustThreadPriority", "setAdjustThreadPriority", "adjustThreadPriority$delegate", "Lcom/tencent/magicbrush/MagicBrushConfig$A;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "animationFrameHandlerStrategy", "getAnimationFrameHandlerStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "setAnimationFrameHandlerStrategy", "(Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;)V", "animationFrameHandlerStrategy$delegate", "Landroid/content/res/AssetManager;", "assetManager", "getAssetManager", "()Landroid/content/res/AssetManager;", "setAssetManager", "(Landroid/content/res/AssetManager;)V", "assetManager$delegate", "", "canvasHeight", "getCanvasHeight", "()I", "setCanvasHeight", "(I)V", "canvasHeight$delegate", "canvasWidth", "getCanvasWidth", "setCanvasWidth", "canvasWidth$delegate", "cmdPoolType", "getCmdPoolType", "setCmdPoolType", "cmdPoolType$delegate", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "", "devicePixelRatio", "getDevicePixelRatio", "()F", "setDevicePixelRatio", "(F)V", "devicePixelRatio$delegate", "enable2d", "getEnable2d", "setEnable2d", "enable2d$delegate", "enableAntialias", "getEnableAntialias", "setEnableAntialias", "enableAntialias$delegate", "enableCommandBuffer", "getEnableCommandBuffer", "setEnableCommandBuffer", "enableCommandBuffer$delegate", "enableFontBatch", "getEnableFontBatch", "setEnableFontBatch", "enableFontBatch$delegate", "enableGfx", "getEnableGfx", "setEnableGfx", "enableGfx$delegate", "enableOpenGL3", "getEnableOpenGL3", "setEnableOpenGL3", "enableOpenGL3$delegate", "enableRequestAnimationFrame", "getEnableRequestAnimationFrame", "setEnableRequestAnimationFrame", "enableRequestAnimationFrame$delegate", "enableVerboseInBuilding", "getEnableVerboseInBuilding", "setEnableVerboseInBuilding", "enableWindowAttributesAlpha", "getEnableWindowAttributesAlpha", "setEnableWindowAttributesAlpha", "enableWindowAttributesAlpha$delegate", "enableWxBindCanvasTexture", "getEnableWxBindCanvasTexture", "setEnableWxBindCanvasTexture", "enableWxBindCanvasTexture$delegate", "Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;", "fileSystem", "getFileSystem", "()Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;", "setFileSystem", "(Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;)V", "fileSystem$delegate", "fontHandler", "Lcom/tencent/magicbrush/handler/glfont/IMBFontHandler;", "getFontHandler", "()Lcom/tencent/magicbrush/handler/glfont/IMBFontHandler;", "setFontHandler", "(Lcom/tencent/magicbrush/handler/glfont/IMBFontHandler;)V", "forceRunV8MicroTasks", "getForceRunV8MicroTasks", "setForceRunV8MicroTasks", "forceRunV8MicroTasks$delegate", "gcFactor", "getGcFactor", "setGcFactor", "gcFactor$delegate", "imageHandler", "Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;", "getImageHandlerConfig", "()Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;", "isGame", "setGame", "isGame$delegate", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "getJsThreadHandler", "()Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "setJsThreadHandler", "(Lcom/tencent/magicbrush/handler/IJsThreadHandler;)V", "params", "Lcom/tencent/magicbrush/MBRuntime$MBParams;", "getParams$lib_magicbrush_nano_release", "()Lcom/tencent/magicbrush/MBRuntime$MBParams;", "", "renderThreadName", "getRenderThreadName", "()Ljava/lang/String;", "setRenderThreadName", "(Ljava/lang/String;)V", "renderThreadName$delegate", "revertCpuOptimizerTest", "getRevertCpuOptimizerTest", "setRevertCpuOptimizerTest", "revertCpuOptimizerTest$delegate", "sdcardPath", "getSdcardPath", "setSdcardPath", "sdcardPath$delegate", "supportClientVertexBuffer", "getSupportClientVertexBuffer", "setSupportClientVertexBuffer", "supportClientVertexBuffer$delegate", "supportGfxImageShareTexture", "getSupportGfxImageShareTexture", "setSupportGfxImageShareTexture", "supportGfxImageShareTexture$delegate", "supportHardDecode", "getSupportHardDecode", "setSupportHardDecode", "supportHardDecode$delegate", "supportHardEncode", "getSupportHardEncode", "setSupportHardEncode", "supportHardEncode$delegate", "syncSurfaceDestroy", "getSyncSurfaceDestroy", "setSyncSurfaceDestroy", "syncSurfaceDestroy$delegate", "v8RawPointer", "Lkotlin/Function0;", "Lcom/tencent/magicbrush/V8RawPointer;", "getV8RawPointer", "()Lkotlin/jvm/functions/Function0;", "setV8RawPointer", "(Lkotlin/jvm/functions/Function0;)V", "getImageHandler", "Lcom/github/henryye/nativeiv/BaseImageDecodeService;", "", "dls", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "A", "ImageHandlerConfig", "lib-magicbrush-nano_release"})
public class g
{
  public com.tencent.magicbrush.handler.a cLJ;
  public kotlin.g.a.a<aj> cLK;
  private final a cLL;
  public final a cLM;
  public final a cLN;
  public final a cLO;
  public final a cLP;
  public final b cLQ;
  public IMBFontHandler cLR;
  private final a cLS;
  public final a cLT;
  public final a cLU;
  private final a cLV;
  public final a cLW;
  private final a cLX;
  private final a cLY;
  private final a cLZ;
  private final a cMa;
  private final a cMb;
  public final a cMc;
  public boolean cMd;
  public boolean cMe;
  public final a cMf;
  public final a cMg;
  public final a cMh;
  private final a cMi;
  private final a cMj;
  private final a cMk;
  private final a cMl;
  private final a cMm;
  private final a cMn;
  private final a cMo;
  private final a cMp;
  public final a cMq;
  final MBRuntime.MBParams cMr;
  public Context context;
  
  static
  {
    AppMethodBeat.i(140174);
    cLI = new kotlin.l.k[] { (kotlin.l.k)kotlin.g.b.aa.a(new kotlin.g.b.v(kotlin.g.b.aa.bp(g.class), "devicePixelRatio", "getDevicePixelRatio()F")), (kotlin.l.k)kotlin.g.b.aa.a(new kotlin.g.b.v(kotlin.g.b.aa.bp(g.class), "canvasWidth", "getCanvasWidth()I")), (kotlin.l.k)kotlin.g.b.aa.a(new kotlin.g.b.v(kotlin.g.b.aa.bp(g.class), "canvasHeight", "getCanvasHeight()I")), (kotlin.l.k)kotlin.g.b.aa.a(new kotlin.g.b.v(kotlin.g.b.aa.bp(g.class), "fileSystem", "getFileSystem()Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;")), (kotlin.l.k)kotlin.g.b.aa.a(new kotlin.g.b.v(kotlin.g.b.aa.bp(g.class), "assetManager", "getAssetManager()Landroid/content/res/AssetManager;")), (kotlin.l.k)kotlin.g.b.aa.a(new kotlin.g.b.v(kotlin.g.b.aa.bp(g.class), "animationFrameHandlerStrategy", "getAnimationFrameHandlerStrategy()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;")), (kotlin.l.k)kotlin.g.b.aa.a(new kotlin.g.b.v(kotlin.g.b.aa.bp(g.class), "enableAntialias", "getEnableAntialias()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new kotlin.g.b.v(kotlin.g.b.aa.bp(g.class), "enableOpenGL3", "getEnableOpenGL3()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new kotlin.g.b.v(kotlin.g.b.aa.bp(g.class), "enableCommandBuffer", "getEnableCommandBuffer()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new kotlin.g.b.v(kotlin.g.b.aa.bp(g.class), "enableGfx", "getEnableGfx()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new kotlin.g.b.v(kotlin.g.b.aa.bp(g.class), "gcFactor", "getGcFactor()F")), (kotlin.l.k)kotlin.g.b.aa.a(new kotlin.g.b.v(kotlin.g.b.aa.bp(g.class), "enableRequestAnimationFrame", "getEnableRequestAnimationFrame()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new kotlin.g.b.v(kotlin.g.b.aa.bp(g.class), "enableWxBindCanvasTexture", "getEnableWxBindCanvasTexture()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new kotlin.g.b.v(kotlin.g.b.aa.bp(g.class), "enable2d", "getEnable2d()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new kotlin.g.b.v(kotlin.g.b.aa.bp(g.class), "enableWindowAttributesAlpha", "getEnableWindowAttributesAlpha()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new kotlin.g.b.v(kotlin.g.b.aa.bp(g.class), "adjustThreadPriority", "getAdjustThreadPriority()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new kotlin.g.b.v(kotlin.g.b.aa.bp(g.class), "cmdPoolType", "getCmdPoolType()I")), (kotlin.l.k)kotlin.g.b.aa.a(new kotlin.g.b.v(kotlin.g.b.aa.bp(g.class), "revertCpuOptimizerTest", "getRevertCpuOptimizerTest()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new kotlin.g.b.v(kotlin.g.b.aa.bp(g.class), "isGame", "isGame()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new kotlin.g.b.v(kotlin.g.b.aa.bp(g.class), "enableFontBatch", "getEnableFontBatch()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new kotlin.g.b.v(kotlin.g.b.aa.bp(g.class), "sdcardPath", "getSdcardPath()Ljava/lang/String;")), (kotlin.l.k)kotlin.g.b.aa.a(new kotlin.g.b.v(kotlin.g.b.aa.bp(g.class), "syncSurfaceDestroy", "getSyncSurfaceDestroy()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new kotlin.g.b.v(kotlin.g.b.aa.bp(g.class), "supportGfxImageShareTexture", "getSupportGfxImageShareTexture()I")), (kotlin.l.k)kotlin.g.b.aa.a(new kotlin.g.b.v(kotlin.g.b.aa.bp(g.class), "supportClientVertexBuffer", "getSupportClientVertexBuffer()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new kotlin.g.b.v(kotlin.g.b.aa.bp(g.class), "supportHardEncode", "getSupportHardEncode()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new kotlin.g.b.v(kotlin.g.b.aa.bp(g.class), "supportHardDecode", "getSupportHardDecode()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new kotlin.g.b.v(kotlin.g.b.aa.bp(g.class), "forceRunV8MicroTasks", "getForceRunV8MicroTasks()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new kotlin.g.b.v(kotlin.g.b.aa.bp(g.class), "renderThreadName", "getRenderThreadName()Ljava/lang/String;")) };
    AppMethodBeat.o(140174);
  }
  
  public g()
  {
    AppMethodBeat.i(140186);
    this.cLL = new a(n.cMy);
    this.cLM = new a(l.cMy);
    this.cLN = new a(k.cMy);
    this.cLO = new a(x.cMy);
    this.cLP = new a(j.cMy);
    this.cLQ = new b();
    this.cLS = new a(i.cMy);
    this.cLT = new a(p.cMy);
    this.cLU = new a(t.cMy);
    this.cLV = new a(q.cMy);
    this.cLW = new a(s.cMy);
    this.cLX = new a(z.cMy);
    this.cLY = new a(u.cMy);
    this.cLZ = new a(w.cMy);
    this.cMa = new a(o.cMy);
    this.cMb = new a(v.cMy);
    this.cMc = new a(h.cMy);
    this.cMd = true;
    this.cMe = true;
    this.cMf = new a(m.cMy);
    this.cMg = new a(ac.cMy);
    this.cMh = new a(aa.cMy);
    this.cMi = new a(r.cMy);
    this.cMj = new a(ad.cMy);
    this.cMk = new a(ai.cMy);
    this.cMl = new a(af.cMy);
    this.cMm = new a(ae.cMy);
    this.cMn = new a(ah.cMy);
    this.cMo = new a(ag.cMy);
    this.cMp = new a(y.cMy);
    this.cMq = new a(ab.cMy);
    this.cMr = new MBRuntime.MBParams();
    AppMethodBeat.o(140186);
  }
  
  public final int Rn()
  {
    AppMethodBeat.i(140177);
    int i = ((Number)this.cLM.a(cLI[1])).intValue();
    AppMethodBeat.o(140177);
    return i;
  }
  
  public final int Ro()
  {
    AppMethodBeat.i(140178);
    int i = ((Number)this.cLN.a(cLI[2])).intValue();
    AppMethodBeat.o(140178);
    return i;
  }
  
  public final AssetManager Rp()
  {
    AppMethodBeat.i(140179);
    AssetManager localAssetManager = (AssetManager)this.cLP.a(cLI[4]);
    AppMethodBeat.o(140179);
    return localAssetManager;
  }
  
  public final a.b Rq()
  {
    AppMethodBeat.i(140180);
    a.b localb = (a.b)this.cLS.a(cLI[5]);
    AppMethodBeat.o(140180);
    return localb;
  }
  
  public final float Rr()
  {
    AppMethodBeat.i(140182);
    float f = ((Number)this.cLX.a(cLI[10])).floatValue();
    AppMethodBeat.o(140182);
    return f;
  }
  
  public final void a(kotlin.g.a.b<? super b, kotlin.x> paramb)
  {
    AppMethodBeat.i(206853);
    kotlin.g.b.p.h(paramb, "dls");
    paramb.invoke(this.cLQ);
    AppMethodBeat.o(206853);
  }
  
  public final void ae(float paramFloat)
  {
    AppMethodBeat.i(140176);
    this.cLL.a(cLI[0], Float.valueOf(paramFloat));
    AppMethodBeat.o(140176);
  }
  
  public final void af(float paramFloat)
  {
    AppMethodBeat.i(140183);
    this.cLX.a(cLI[10], Float.valueOf(paramFloat));
    AppMethodBeat.o(140183);
  }
  
  public final void b(a.b paramb)
  {
    AppMethodBeat.i(140181);
    kotlin.g.b.p.h(paramb, "<set-?>");
    this.cLS.a(cLI[5], paramb);
    AppMethodBeat.o(140181);
  }
  
  public final void co(boolean paramBoolean)
  {
    AppMethodBeat.i(206854);
    this.cLV.a(cLI[8], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(206854);
  }
  
  public final void cp(boolean paramBoolean)
  {
    AppMethodBeat.i(140184);
    this.cLZ.a(cLI[12], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(140184);
  }
  
  public final void cq(boolean paramBoolean)
  {
    AppMethodBeat.i(206855);
    this.cMa.a(cLI[13], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(206855);
  }
  
  public final void cr(boolean paramBoolean)
  {
    AppMethodBeat.i(140185);
    this.cMb.a(cLI[14], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(140185);
  }
  
  public final void cs(boolean paramBoolean)
  {
    AppMethodBeat.i(206856);
    this.cMi.a(cLI[19], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(206856);
  }
  
  public final void ct(boolean paramBoolean)
  {
    AppMethodBeat.i(206858);
    this.cMk.a(cLI[21], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(206858);
  }
  
  public final void cu(boolean paramBoolean)
  {
    AppMethodBeat.i(206859);
    this.cMm.a(cLI[23], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(206859);
  }
  
  public final void cv(boolean paramBoolean)
  {
    AppMethodBeat.i(206860);
    this.cMn.a(cLI[24], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(206860);
  }
  
  public final void cw(boolean paramBoolean)
  {
    AppMethodBeat.i(206861);
    this.cMo.a(cLI[25], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(206861);
  }
  
  public final void cx(boolean paramBoolean)
  {
    AppMethodBeat.i(206862);
    this.cMp.a(cLI[26], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(206862);
  }
  
  public final void dY(String paramString)
  {
    AppMethodBeat.i(206857);
    kotlin.g.b.p.h(paramString, "<set-?>");
    this.cMj.a(cLI[20], paramString);
    AppMethodBeat.o(206857);
  }
  
  public final float getDevicePixelRatio()
  {
    AppMethodBeat.i(140175);
    float f = ((Number)this.cLL.a(cLI[0])).floatValue();
    AppMethodBeat.o(140175);
    return f;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/magicbrush/MagicBrushConfig$A;", "T", "Lcom/tencent/magicbrush/utils/Alias;", "Lcom/tencent/magicbrush/MBRuntime$MBParams;", "k", "Lkotlin/reflect/KMutableProperty1;", "(Lcom/tencent/magicbrush/MagicBrushConfig;Lkotlin/reflect/KMutableProperty1;)V", "lib-magicbrush-nano_release"})
  public final class a<T>
    extends com.tencent.magicbrush.utils.a<MBRuntime.MBParams, T>
  {
    public a()
    {
      super( {}, (byte)0);
      AppMethodBeat.i(140098);
      AppMethodBeat.o(140098);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;", "", "()V", "decodeSlaveForDefault", "Lcom/github/henryye/nativeiv/api/IImageDecodeService$BitmapDecodeSlave;", "getDecodeSlaveForDefault", "()Lcom/github/henryye/nativeiv/api/IImageDecodeService$BitmapDecodeSlave;", "setDecodeSlaveForDefault", "(Lcom/github/henryye/nativeiv/api/IImageDecodeService$BitmapDecodeSlave;)V", "enableDefaultImageHandler", "", "getEnableDefaultImageHandler", "()Z", "setEnableDefaultImageHandler", "(Z)V", "imageDecoderForDefault", "", "Lcom/github/henryye/nativeiv/stream/IImageStreamFetcher;", "getImageDecoderForDefault", "()Ljava/util/List;", "setImageDecoderForDefault", "(Ljava/util/List;)V", "imageHandler", "Lcom/github/henryye/nativeiv/BaseImageDecodeService;", "getImageHandler", "()Lcom/github/henryye/nativeiv/BaseImageDecodeService;", "setImageHandler", "(Lcom/github/henryye/nativeiv/BaseImageDecodeService;)V", "reporterForDefault", "Lcom/github/henryye/nativeiv/delegate/ReportDelegate$IKvReport;", "getReporterForDefault", "()Lcom/github/henryye/nativeiv/delegate/ReportDelegate$IKvReport;", "setReporterForDefault", "(Lcom/github/henryye/nativeiv/delegate/ReportDelegate$IKvReport;)V", "lib-magicbrush-nano_release"})
  public static final class b
  {
    public boolean cMt;
    public List<com.github.henryye.nativeiv.b.b> cMu;
    public c.b cMv;
    public IImageDecodeService.a cMw;
    public BaseImageDecodeService cMx;
    
    public b()
    {
      AppMethodBeat.i(140099);
      this.cMt = true;
      this.cMu = ((List)new ArrayList());
      AppMethodBeat.o(140099);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.magicbrush.g
 * JD-Core Version:    0.7.0.1
 */