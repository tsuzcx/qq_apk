package com.tencent.magicbrush;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.magicbrush.handler.glfont.IMBFontHandler;
import com.tencent.magicbrush.ui.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/magicbrush/MagicBrushConfig;", "", "()V", "abortIfBuildingError", "", "getAbortIfBuildingError", "()Z", "setAbortIfBuildingError", "(Z)V", "<set-?>", "adjustThreadPriority", "getAdjustThreadPriority", "setAdjustThreadPriority", "adjustThreadPriority$delegate", "Lcom/tencent/magicbrush/MagicBrushConfig$A;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "animationFrameHandlerStrategy", "getAnimationFrameHandlerStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "setAnimationFrameHandlerStrategy", "(Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;)V", "animationFrameHandlerStrategy$delegate", "", "appBrandRuntime", "getAppBrandRuntime", "()J", "setAppBrandRuntime", "(J)V", "appBrandRuntime$delegate", "Landroid/content/res/AssetManager;", "assetManager", "getAssetManager", "()Landroid/content/res/AssetManager;", "setAssetManager", "(Landroid/content/res/AssetManager;)V", "assetManager$delegate", "", "canvasHeight", "getCanvasHeight", "()I", "setCanvasHeight", "(I)V", "canvasHeight$delegate", "canvasWidth", "getCanvasWidth", "setCanvasWidth", "canvasWidth$delegate", "cmdPoolType", "getCmdPoolType", "setCmdPoolType", "cmdPoolType$delegate", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "", "devicePixelRatio", "getDevicePixelRatio", "()F", "setDevicePixelRatio", "(F)V", "devicePixelRatio$delegate", "enable2d", "getEnable2d", "setEnable2d", "enable2d$delegate", "enableAntialias", "getEnableAntialias", "setEnableAntialias", "enableAntialias$delegate", "enableCommandBuffer", "getEnableCommandBuffer", "setEnableCommandBuffer", "enableCommandBuffer$delegate", "enableFontBatch", "getEnableFontBatch", "setEnableFontBatch", "enableFontBatch$delegate", "enableGfx", "getEnableGfx", "setEnableGfx", "enableGfx$delegate", "enableOpenGL3", "getEnableOpenGL3", "setEnableOpenGL3", "enableOpenGL3$delegate", "enableRequestAnimationFrame", "getEnableRequestAnimationFrame", "setEnableRequestAnimationFrame", "enableRequestAnimationFrame$delegate", "enableVerboseInBuilding", "getEnableVerboseInBuilding", "setEnableVerboseInBuilding", "enableWindowAttributesAlpha", "getEnableWindowAttributesAlpha", "setEnableWindowAttributesAlpha", "enableWindowAttributesAlpha$delegate", "enableWxBindCanvasTexture", "getEnableWxBindCanvasTexture", "setEnableWxBindCanvasTexture", "enableWxBindCanvasTexture$delegate", "Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;", "fileSystem", "getFileSystem", "()Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;", "setFileSystem", "(Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;)V", "fileSystem$delegate", "fontHandler", "Lcom/tencent/magicbrush/handler/glfont/IMBFontHandler;", "getFontHandler", "()Lcom/tencent/magicbrush/handler/glfont/IMBFontHandler;", "setFontHandler", "(Lcom/tencent/magicbrush/handler/glfont/IMBFontHandler;)V", "forceRunV8MicroTasks", "getForceRunV8MicroTasks", "setForceRunV8MicroTasks", "forceRunV8MicroTasks$delegate", "gcFactor", "getGcFactor", "setGcFactor", "gcFactor$delegate", "imageHandler", "Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;", "getImageHandlerConfig", "()Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;", "isGame", "setGame", "isGame$delegate", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "getJsThreadHandler", "()Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "setJsThreadHandler", "(Lcom/tencent/magicbrush/handler/IJsThreadHandler;)V", "params", "Lcom/tencent/magicbrush/MBRuntime$MBParams;", "getParams$lib_magicbrush_nano_release", "()Lcom/tencent/magicbrush/MBRuntime$MBParams;", "", "renderThreadName", "getRenderThreadName", "()Ljava/lang/String;", "setRenderThreadName", "(Ljava/lang/String;)V", "renderThreadName$delegate", "revertCpuOptimizerTest", "getRevertCpuOptimizerTest", "setRevertCpuOptimizerTest", "revertCpuOptimizerTest$delegate", "screenCanvasDelegate", "Lcom/tencent/magicbrush/MagicBrush$ScreenCanvasDelegate;", "getScreenCanvasDelegate", "()Lcom/tencent/magicbrush/MagicBrush$ScreenCanvasDelegate;", "setScreenCanvasDelegate", "(Lcom/tencent/magicbrush/MagicBrush$ScreenCanvasDelegate;)V", "sdcardPath", "getSdcardPath", "setSdcardPath", "sdcardPath$delegate", "supportClientVertexBuffer", "getSupportClientVertexBuffer", "setSupportClientVertexBuffer", "supportClientVertexBuffer$delegate", "supportETC2nASTC", "getSupportETC2nASTC", "setSupportETC2nASTC", "supportETC2nASTC$delegate", "supportGfxImageShareTexture", "getSupportGfxImageShareTexture", "setSupportGfxImageShareTexture", "supportGfxImageShareTexture$delegate", "supportHardDecode", "getSupportHardDecode", "setSupportHardDecode", "supportHardDecode$delegate", "supportHardEncode", "getSupportHardEncode", "setSupportHardEncode", "supportHardEncode$delegate", "syncSurfaceDestroy", "getSyncSurfaceDestroy", "setSyncSurfaceDestroy", "syncSurfaceDestroy$delegate", "v8RawPointer", "Lkotlin/Function0;", "Lcom/tencent/magicbrush/V8RawPointer;", "getV8RawPointer", "()Lkotlin/jvm/functions/Function0;", "setV8RawPointer", "(Lkotlin/jvm/functions/Function0;)V", "getImageHandler", "Lcom/github/henryye/nativeiv/BaseImageDecodeService;", "", "dls", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "A", "ImageHandlerConfig", "lib-magicbrush-nano_release"})
public class g
{
  public final a cMA;
  public final g.b cMB;
  public IMBFontHandler cMC;
  private final a cMD;
  public final a cME;
  public final a cMF;
  private final a cMG;
  public final a cMH;
  private final a cMI;
  private final a cMJ;
  private final a cMK;
  private final a cML;
  private final a cMM;
  public final a cMN;
  public boolean cMO;
  public boolean cMP;
  public final a cMQ;
  public final a cMR;
  public final a cMS;
  private final a cMT;
  private final a cMU;
  private final a cMV;
  private final a cMW;
  private final a cMX;
  private final a cMY;
  private final a cMZ;
  public e.e cMl;
  public com.tencent.magicbrush.handler.a cMu;
  public kotlin.g.a.a<al> cMv;
  private final a cMw;
  public final a cMx;
  public final a cMy;
  public final a cMz;
  private final a cNa;
  private final a cNb;
  public final a cNc;
  private final a cNd;
  final MBRuntime.MBParams cNe;
  public Context context;
  
  static
  {
    AppMethodBeat.i(140174);
    cMt = new kotlin.l.n[] { (kotlin.l.n)kotlin.g.b.ab.a(new kotlin.g.b.v(kotlin.g.b.ab.bO(g.class), "devicePixelRatio", "getDevicePixelRatio()F")), (kotlin.l.n)kotlin.g.b.ab.a(new kotlin.g.b.v(kotlin.g.b.ab.bO(g.class), "canvasWidth", "getCanvasWidth()I")), (kotlin.l.n)kotlin.g.b.ab.a(new kotlin.g.b.v(kotlin.g.b.ab.bO(g.class), "canvasHeight", "getCanvasHeight()I")), (kotlin.l.n)kotlin.g.b.ab.a(new kotlin.g.b.v(kotlin.g.b.ab.bO(g.class), "fileSystem", "getFileSystem()Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;")), (kotlin.l.n)kotlin.g.b.ab.a(new kotlin.g.b.v(kotlin.g.b.ab.bO(g.class), "assetManager", "getAssetManager()Landroid/content/res/AssetManager;")), (kotlin.l.n)kotlin.g.b.ab.a(new kotlin.g.b.v(kotlin.g.b.ab.bO(g.class), "animationFrameHandlerStrategy", "getAnimationFrameHandlerStrategy()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;")), (kotlin.l.n)kotlin.g.b.ab.a(new kotlin.g.b.v(kotlin.g.b.ab.bO(g.class), "enableAntialias", "getEnableAntialias()Z")), (kotlin.l.n)kotlin.g.b.ab.a(new kotlin.g.b.v(kotlin.g.b.ab.bO(g.class), "enableOpenGL3", "getEnableOpenGL3()Z")), (kotlin.l.n)kotlin.g.b.ab.a(new kotlin.g.b.v(kotlin.g.b.ab.bO(g.class), "enableCommandBuffer", "getEnableCommandBuffer()Z")), (kotlin.l.n)kotlin.g.b.ab.a(new kotlin.g.b.v(kotlin.g.b.ab.bO(g.class), "enableGfx", "getEnableGfx()Z")), (kotlin.l.n)kotlin.g.b.ab.a(new kotlin.g.b.v(kotlin.g.b.ab.bO(g.class), "gcFactor", "getGcFactor()F")), (kotlin.l.n)kotlin.g.b.ab.a(new kotlin.g.b.v(kotlin.g.b.ab.bO(g.class), "enableRequestAnimationFrame", "getEnableRequestAnimationFrame()Z")), (kotlin.l.n)kotlin.g.b.ab.a(new kotlin.g.b.v(kotlin.g.b.ab.bO(g.class), "enableWxBindCanvasTexture", "getEnableWxBindCanvasTexture()Z")), (kotlin.l.n)kotlin.g.b.ab.a(new kotlin.g.b.v(kotlin.g.b.ab.bO(g.class), "enable2d", "getEnable2d()Z")), (kotlin.l.n)kotlin.g.b.ab.a(new kotlin.g.b.v(kotlin.g.b.ab.bO(g.class), "enableWindowAttributesAlpha", "getEnableWindowAttributesAlpha()Z")), (kotlin.l.n)kotlin.g.b.ab.a(new kotlin.g.b.v(kotlin.g.b.ab.bO(g.class), "adjustThreadPriority", "getAdjustThreadPriority()Z")), (kotlin.l.n)kotlin.g.b.ab.a(new kotlin.g.b.v(kotlin.g.b.ab.bO(g.class), "cmdPoolType", "getCmdPoolType()I")), (kotlin.l.n)kotlin.g.b.ab.a(new kotlin.g.b.v(kotlin.g.b.ab.bO(g.class), "revertCpuOptimizerTest", "getRevertCpuOptimizerTest()Z")), (kotlin.l.n)kotlin.g.b.ab.a(new kotlin.g.b.v(kotlin.g.b.ab.bO(g.class), "isGame", "isGame()Z")), (kotlin.l.n)kotlin.g.b.ab.a(new kotlin.g.b.v(kotlin.g.b.ab.bO(g.class), "enableFontBatch", "getEnableFontBatch()Z")), (kotlin.l.n)kotlin.g.b.ab.a(new kotlin.g.b.v(kotlin.g.b.ab.bO(g.class), "sdcardPath", "getSdcardPath()Ljava/lang/String;")), (kotlin.l.n)kotlin.g.b.ab.a(new kotlin.g.b.v(kotlin.g.b.ab.bO(g.class), "syncSurfaceDestroy", "getSyncSurfaceDestroy()Z")), (kotlin.l.n)kotlin.g.b.ab.a(new kotlin.g.b.v(kotlin.g.b.ab.bO(g.class), "supportGfxImageShareTexture", "getSupportGfxImageShareTexture()I")), (kotlin.l.n)kotlin.g.b.ab.a(new kotlin.g.b.v(kotlin.g.b.ab.bO(g.class), "supportClientVertexBuffer", "getSupportClientVertexBuffer()Z")), (kotlin.l.n)kotlin.g.b.ab.a(new kotlin.g.b.v(kotlin.g.b.ab.bO(g.class), "supportHardEncode", "getSupportHardEncode()Z")), (kotlin.l.n)kotlin.g.b.ab.a(new kotlin.g.b.v(kotlin.g.b.ab.bO(g.class), "supportHardDecode", "getSupportHardDecode()Z")), (kotlin.l.n)kotlin.g.b.ab.a(new kotlin.g.b.v(kotlin.g.b.ab.bO(g.class), "supportETC2nASTC", "getSupportETC2nASTC()Z")), (kotlin.l.n)kotlin.g.b.ab.a(new kotlin.g.b.v(kotlin.g.b.ab.bO(g.class), "forceRunV8MicroTasks", "getForceRunV8MicroTasks()Z")), (kotlin.l.n)kotlin.g.b.ab.a(new kotlin.g.b.v(kotlin.g.b.ab.bO(g.class), "renderThreadName", "getRenderThreadName()Ljava/lang/String;")), (kotlin.l.n)kotlin.g.b.ab.a(new kotlin.g.b.v(kotlin.g.b.ab.bO(g.class), "appBrandRuntime", "getAppBrandRuntime()J")) };
    AppMethodBeat.o(140174);
  }
  
  public g()
  {
    AppMethodBeat.i(140186);
    this.cMw = new a(o.cNl);
    this.cMx = new a(m.cNl);
    this.cMy = new a(l.cNl);
    this.cMz = new a(y.cNl);
    this.cMA = new a(k.cNl);
    this.cMB = new g.b();
    this.cMD = new a(i.cNl);
    this.cME = new a(q.cNl);
    this.cMF = new a(u.cNl);
    this.cMG = new a(r.cNl);
    this.cMH = new a(t.cNl);
    this.cMI = new a(aa.cNl);
    this.cMJ = new a(v.cNl);
    this.cMK = new a(x.cNl);
    this.cML = new a(p.cNl);
    this.cMM = new a(w.cNl);
    this.cMN = new a(h.cNl);
    this.cMO = true;
    this.cMP = true;
    this.cMQ = new a(n.cNl);
    this.cMR = new a(ad.cNl);
    this.cMS = new a(ab.cNl);
    this.cMT = new a(s.cNl);
    this.cMU = new a(ae.cNl);
    this.cMV = new a(ak.cNl);
    this.cMW = new a(ah.cNl);
    this.cMX = new a(af.cNl);
    this.cMY = new a(aj.cNl);
    this.cMZ = new a(ai.cNl);
    this.cNa = new a(ag.cNl);
    this.cNb = new a(z.cNl);
    this.cNc = new a(ac.cNl);
    this.cNd = new a(j.cNl);
    this.cNe = new MBRuntime.MBParams();
    AppMethodBeat.o(140186);
  }
  
  public final int UX()
  {
    AppMethodBeat.i(140177);
    int i = ((Number)this.cMx.a(cMt[1])).intValue();
    AppMethodBeat.o(140177);
    return i;
  }
  
  public final int UY()
  {
    AppMethodBeat.i(140178);
    int i = ((Number)this.cMy.a(cMt[2])).intValue();
    AppMethodBeat.o(140178);
    return i;
  }
  
  public final AssetManager UZ()
  {
    AppMethodBeat.i(140179);
    AssetManager localAssetManager = (AssetManager)this.cMA.a(cMt[4]);
    AppMethodBeat.o(140179);
    return localAssetManager;
  }
  
  public final a.b Va()
  {
    AppMethodBeat.i(140180);
    a.b localb = (a.b)this.cMD.a(cMt[5]);
    AppMethodBeat.o(140180);
    return localb;
  }
  
  public final float Vb()
  {
    AppMethodBeat.i(140182);
    float f = ((Number)this.cMI.a(cMt[10])).floatValue();
    AppMethodBeat.o(140182);
    return f;
  }
  
  public final void a(b<? super g.b, kotlin.x> paramb)
  {
    AppMethodBeat.i(204573);
    kotlin.g.b.p.k(paramb, "dls");
    paramb.invoke(this.cMB);
    AppMethodBeat.o(204573);
  }
  
  public final void ad(float paramFloat)
  {
    AppMethodBeat.i(140176);
    this.cMw.a(cMt[0], Float.valueOf(paramFloat));
    AppMethodBeat.o(140176);
  }
  
  public final void ae(float paramFloat)
  {
    AppMethodBeat.i(140183);
    this.cMI.a(cMt[10], Float.valueOf(paramFloat));
    AppMethodBeat.o(140183);
  }
  
  public final void b(a.b paramb)
  {
    AppMethodBeat.i(140181);
    kotlin.g.b.p.k(paramb, "<set-?>");
    this.cMD.a(cMt[5], paramb);
    AppMethodBeat.o(140181);
  }
  
  public final void bg(long paramLong)
  {
    AppMethodBeat.i(204585);
    this.cNd.a(cMt[29], Long.valueOf(paramLong));
    AppMethodBeat.o(204585);
  }
  
  public final void cC(boolean paramBoolean)
  {
    AppMethodBeat.i(204574);
    this.cMG.a(cMt[8], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(204574);
  }
  
  public final void cD(boolean paramBoolean)
  {
    AppMethodBeat.i(140184);
    this.cMK.a(cMt[12], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(140184);
  }
  
  public final void cE(boolean paramBoolean)
  {
    AppMethodBeat.i(204576);
    this.cML.a(cMt[13], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(204576);
  }
  
  public final void cF(boolean paramBoolean)
  {
    AppMethodBeat.i(140185);
    this.cMM.a(cMt[14], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(140185);
  }
  
  public final void cG(boolean paramBoolean)
  {
    AppMethodBeat.i(204577);
    this.cMT.a(cMt[19], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(204577);
  }
  
  public final void cH(boolean paramBoolean)
  {
    AppMethodBeat.i(204579);
    this.cMV.a(cMt[21], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(204579);
  }
  
  public final void cI(boolean paramBoolean)
  {
    AppMethodBeat.i(204580);
    this.cMX.a(cMt[23], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(204580);
  }
  
  public final void cJ(boolean paramBoolean)
  {
    AppMethodBeat.i(204581);
    this.cMY.a(cMt[24], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(204581);
  }
  
  public final void cK(boolean paramBoolean)
  {
    AppMethodBeat.i(204582);
    this.cMZ.a(cMt[25], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(204582);
  }
  
  public final void cL(boolean paramBoolean)
  {
    AppMethodBeat.i(204583);
    this.cNa.a(cMt[26], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(204583);
  }
  
  public final void cM(boolean paramBoolean)
  {
    AppMethodBeat.i(204584);
    this.cNb.a(cMt[27], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(204584);
  }
  
  public final void ez(String paramString)
  {
    AppMethodBeat.i(204578);
    kotlin.g.b.p.k(paramString, "<set-?>");
    this.cMU.a(cMt[20], paramString);
    AppMethodBeat.o(204578);
  }
  
  public final float getDevicePixelRatio()
  {
    AppMethodBeat.i(140175);
    float f = ((Number)this.cMw.a(cMt[0])).floatValue();
    AppMethodBeat.o(140175);
    return f;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/magicbrush/MagicBrushConfig$A;", "T", "Lcom/tencent/magicbrush/utils/Alias;", "Lcom/tencent/magicbrush/MBRuntime$MBParams;", "k", "Lkotlin/reflect/KMutableProperty1;", "(Lcom/tencent/magicbrush/MagicBrushConfig;Lkotlin/reflect/KMutableProperty1;)V", "lib-magicbrush-nano_release"})
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.g
 * JD-Core Version:    0.7.0.1
 */