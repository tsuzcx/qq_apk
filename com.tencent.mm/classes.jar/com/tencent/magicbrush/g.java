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
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/MagicBrushConfig;", "", "()V", "abortIfBuildingError", "", "getAbortIfBuildingError", "()Z", "setAbortIfBuildingError", "(Z)V", "<set-?>", "adjustThreadPriority", "getAdjustThreadPriority", "setAdjustThreadPriority", "adjustThreadPriority$delegate", "Lcom/tencent/magicbrush/MagicBrushConfig$A;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "animationFrameHandlerStrategy", "getAnimationFrameHandlerStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "setAnimationFrameHandlerStrategy", "(Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;)V", "animationFrameHandlerStrategy$delegate", "", "appBrandRuntime", "getAppBrandRuntime", "()J", "setAppBrandRuntime", "(J)V", "appBrandRuntime$delegate", "Landroid/content/res/AssetManager;", "assetManager", "getAssetManager", "()Landroid/content/res/AssetManager;", "setAssetManager", "(Landroid/content/res/AssetManager;)V", "assetManager$delegate", "", "canvasHeight", "getCanvasHeight", "()I", "setCanvasHeight", "(I)V", "canvasHeight$delegate", "canvasWidth", "getCanvasWidth", "setCanvasWidth", "canvasWidth$delegate", "cmdPoolType", "getCmdPoolType", "setCmdPoolType", "cmdPoolType$delegate", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "", "devicePixelRatio", "getDevicePixelRatio", "()F", "setDevicePixelRatio", "(F)V", "devicePixelRatio$delegate", "disableWebGL2", "getDisableWebGL2", "setDisableWebGL2", "disableWebGL2$delegate", "enable2d", "getEnable2d", "setEnable2d", "enable2d$delegate", "enableAntialias", "getEnableAntialias", "setEnableAntialias", "enableAntialias$delegate", "enableCommandBuffer", "getEnableCommandBuffer", "setEnableCommandBuffer", "enableCommandBuffer$delegate", "enableFontBatch", "getEnableFontBatch", "setEnableFontBatch", "enableFontBatch$delegate", "enableGfx", "getEnableGfx", "setEnableGfx", "enableGfx$delegate", "enableOpenGL3", "getEnableOpenGL3", "setEnableOpenGL3", "enableOpenGL3$delegate", "enableRequestAnimationFrame", "getEnableRequestAnimationFrame", "setEnableRequestAnimationFrame", "enableRequestAnimationFrame$delegate", "enableVerboseInBuilding", "getEnableVerboseInBuilding", "setEnableVerboseInBuilding", "enableWindowAttributesAlpha", "getEnableWindowAttributesAlpha", "setEnableWindowAttributesAlpha", "enableWindowAttributesAlpha$delegate", "enableWindowCheck", "getEnableWindowCheck", "setEnableWindowCheck", "enableWindowCheck$delegate", "enableWxBindCanvasTexture", "getEnableWxBindCanvasTexture", "setEnableWxBindCanvasTexture", "enableWxBindCanvasTexture$delegate", "Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;", "fileSystem", "getFileSystem", "()Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;", "setFileSystem", "(Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;)V", "fileSystem$delegate", "fontHandler", "Lcom/tencent/magicbrush/handler/glfont/IMBFontHandler;", "getFontHandler", "()Lcom/tencent/magicbrush/handler/glfont/IMBFontHandler;", "setFontHandler", "(Lcom/tencent/magicbrush/handler/glfont/IMBFontHandler;)V", "forceRunV8MicroTasks", "getForceRunV8MicroTasks", "setForceRunV8MicroTasks", "forceRunV8MicroTasks$delegate", "gcFactor", "getGcFactor", "setGcFactor", "gcFactor$delegate", "imageHandler", "Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;", "getImageHandlerConfig", "()Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;", "isGame", "setGame", "isGame$delegate", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "getJsThreadHandler", "()Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "setJsThreadHandler", "(Lcom/tencent/magicbrush/handler/IJsThreadHandler;)V", "params", "Lcom/tencent/magicbrush/MBRuntime$MBParams;", "getParams$lib_magicbrush_nano_release", "()Lcom/tencent/magicbrush/MBRuntime$MBParams;", "", "renderThreadName", "getRenderThreadName", "()Ljava/lang/String;", "setRenderThreadName", "(Ljava/lang/String;)V", "renderThreadName$delegate", "revertCpuOptimizerTest", "getRevertCpuOptimizerTest", "setRevertCpuOptimizerTest", "revertCpuOptimizerTest$delegate", "screenCanvasDelegate", "Lcom/tencent/magicbrush/MagicBrush$ScreenCanvasDelegate;", "getScreenCanvasDelegate", "()Lcom/tencent/magicbrush/MagicBrush$ScreenCanvasDelegate;", "setScreenCanvasDelegate", "(Lcom/tencent/magicbrush/MagicBrush$ScreenCanvasDelegate;)V", "sdcardPath", "getSdcardPath", "setSdcardPath", "sdcardPath$delegate", "supportClientVertexBuffer", "getSupportClientVertexBuffer", "setSupportClientVertexBuffer", "supportClientVertexBuffer$delegate", "supportETC2nASTC", "getSupportETC2nASTC", "setSupportETC2nASTC", "supportETC2nASTC$delegate", "supportGfxImageShareTexture", "getSupportGfxImageShareTexture", "setSupportGfxImageShareTexture", "supportGfxImageShareTexture$delegate", "supportHardDecode", "getSupportHardDecode", "setSupportHardDecode", "supportHardDecode$delegate", "supportHardEncode", "getSupportHardEncode", "setSupportHardEncode", "supportHardEncode$delegate", "syncSurfaceDestroy", "getSyncSurfaceDestroy", "setSyncSurfaceDestroy", "syncSurfaceDestroy$delegate", "v8RawPointer", "Lkotlin/Function0;", "Lcom/tencent/magicbrush/V8RawPointer;", "getV8RawPointer", "()Lkotlin/jvm/functions/Function0;", "setV8RawPointer", "(Lkotlin/jvm/functions/Function0;)V", "getImageHandler", "Lcom/github/henryye/nativeiv/BaseImageDecodeService;", "", "dls", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "A", "ImageHandlerConfig", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 16})
public class g
{
  public Context context;
  public e.e eHF;
  public com.tencent.magicbrush.handler.a eHN;
  public kotlin.g.a.a<an> eHO;
  private final g.a eHP;
  public final g.a eHQ;
  public final g.a eHR;
  public final g.a eHS;
  public final g.a eHT;
  public final b eHU;
  public IMBFontHandler eHV;
  private final g.a eHW;
  public final g.a eHX;
  public final g.a eHY;
  private final g.a eHZ;
  public final g.a eIa;
  private final g.a eIb;
  private final g.a eIc;
  private final g.a eId;
  private final g.a eIe;
  private final g.a eIf;
  public final g.a eIg;
  public boolean eIh;
  public boolean eIi;
  public final g.a eIj;
  public final g.a eIk;
  public final g.a eIl;
  private final g.a eIm;
  private final g.a eIn;
  private final g.a eIo;
  private final g.a eIp;
  private final g.a eIq;
  public final g.a eIr;
  private final g.a eIs;
  private final g.a eIt;
  private final g.a eIu;
  private final g.a eIv;
  private final g.a eIw;
  public final g.a eIx;
  private final g.a eIy;
  final MBRuntime.MBParams eIz;
  
  static
  {
    AppMethodBeat.i(140174);
    aYe = new kotlin.l.o[] { (kotlin.l.o)kotlin.g.b.ai.a(new kotlin.g.b.aa(kotlin.g.b.ai.cz(g.class), "devicePixelRatio", "getDevicePixelRatio()F")), (kotlin.l.o)kotlin.g.b.ai.a(new kotlin.g.b.aa(kotlin.g.b.ai.cz(g.class), "canvasWidth", "getCanvasWidth()I")), (kotlin.l.o)kotlin.g.b.ai.a(new kotlin.g.b.aa(kotlin.g.b.ai.cz(g.class), "canvasHeight", "getCanvasHeight()I")), (kotlin.l.o)kotlin.g.b.ai.a(new kotlin.g.b.aa(kotlin.g.b.ai.cz(g.class), "fileSystem", "getFileSystem()Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;")), (kotlin.l.o)kotlin.g.b.ai.a(new kotlin.g.b.aa(kotlin.g.b.ai.cz(g.class), "assetManager", "getAssetManager()Landroid/content/res/AssetManager;")), (kotlin.l.o)kotlin.g.b.ai.a(new kotlin.g.b.aa(kotlin.g.b.ai.cz(g.class), "animationFrameHandlerStrategy", "getAnimationFrameHandlerStrategy()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;")), (kotlin.l.o)kotlin.g.b.ai.a(new kotlin.g.b.aa(kotlin.g.b.ai.cz(g.class), "enableAntialias", "getEnableAntialias()Z")), (kotlin.l.o)kotlin.g.b.ai.a(new kotlin.g.b.aa(kotlin.g.b.ai.cz(g.class), "enableOpenGL3", "getEnableOpenGL3()Z")), (kotlin.l.o)kotlin.g.b.ai.a(new kotlin.g.b.aa(kotlin.g.b.ai.cz(g.class), "enableCommandBuffer", "getEnableCommandBuffer()Z")), (kotlin.l.o)kotlin.g.b.ai.a(new kotlin.g.b.aa(kotlin.g.b.ai.cz(g.class), "enableGfx", "getEnableGfx()Z")), (kotlin.l.o)kotlin.g.b.ai.a(new kotlin.g.b.aa(kotlin.g.b.ai.cz(g.class), "gcFactor", "getGcFactor()F")), (kotlin.l.o)kotlin.g.b.ai.a(new kotlin.g.b.aa(kotlin.g.b.ai.cz(g.class), "enableRequestAnimationFrame", "getEnableRequestAnimationFrame()Z")), (kotlin.l.o)kotlin.g.b.ai.a(new kotlin.g.b.aa(kotlin.g.b.ai.cz(g.class), "enableWxBindCanvasTexture", "getEnableWxBindCanvasTexture()Z")), (kotlin.l.o)kotlin.g.b.ai.a(new kotlin.g.b.aa(kotlin.g.b.ai.cz(g.class), "enable2d", "getEnable2d()Z")), (kotlin.l.o)kotlin.g.b.ai.a(new kotlin.g.b.aa(kotlin.g.b.ai.cz(g.class), "enableWindowAttributesAlpha", "getEnableWindowAttributesAlpha()Z")), (kotlin.l.o)kotlin.g.b.ai.a(new kotlin.g.b.aa(kotlin.g.b.ai.cz(g.class), "adjustThreadPriority", "getAdjustThreadPriority()Z")), (kotlin.l.o)kotlin.g.b.ai.a(new kotlin.g.b.aa(kotlin.g.b.ai.cz(g.class), "cmdPoolType", "getCmdPoolType()I")), (kotlin.l.o)kotlin.g.b.ai.a(new kotlin.g.b.aa(kotlin.g.b.ai.cz(g.class), "revertCpuOptimizerTest", "getRevertCpuOptimizerTest()Z")), (kotlin.l.o)kotlin.g.b.ai.a(new kotlin.g.b.aa(kotlin.g.b.ai.cz(g.class), "isGame", "isGame()Z")), (kotlin.l.o)kotlin.g.b.ai.a(new kotlin.g.b.aa(kotlin.g.b.ai.cz(g.class), "enableFontBatch", "getEnableFontBatch()Z")), (kotlin.l.o)kotlin.g.b.ai.a(new kotlin.g.b.aa(kotlin.g.b.ai.cz(g.class), "sdcardPath", "getSdcardPath()Ljava/lang/String;")), (kotlin.l.o)kotlin.g.b.ai.a(new kotlin.g.b.aa(kotlin.g.b.ai.cz(g.class), "syncSurfaceDestroy", "getSyncSurfaceDestroy()Z")), (kotlin.l.o)kotlin.g.b.ai.a(new kotlin.g.b.aa(kotlin.g.b.ai.cz(g.class), "supportGfxImageShareTexture", "getSupportGfxImageShareTexture()I")), (kotlin.l.o)kotlin.g.b.ai.a(new kotlin.g.b.aa(kotlin.g.b.ai.cz(g.class), "supportClientVertexBuffer", "getSupportClientVertexBuffer()Z")), (kotlin.l.o)kotlin.g.b.ai.a(new kotlin.g.b.aa(kotlin.g.b.ai.cz(g.class), "enableWindowCheck", "getEnableWindowCheck()Z")), (kotlin.l.o)kotlin.g.b.ai.a(new kotlin.g.b.aa(kotlin.g.b.ai.cz(g.class), "disableWebGL2", "getDisableWebGL2()Z")), (kotlin.l.o)kotlin.g.b.ai.a(new kotlin.g.b.aa(kotlin.g.b.ai.cz(g.class), "supportHardEncode", "getSupportHardEncode()Z")), (kotlin.l.o)kotlin.g.b.ai.a(new kotlin.g.b.aa(kotlin.g.b.ai.cz(g.class), "supportHardDecode", "getSupportHardDecode()Z")), (kotlin.l.o)kotlin.g.b.ai.a(new kotlin.g.b.aa(kotlin.g.b.ai.cz(g.class), "supportETC2nASTC", "getSupportETC2nASTC()Z")), (kotlin.l.o)kotlin.g.b.ai.a(new kotlin.g.b.aa(kotlin.g.b.ai.cz(g.class), "forceRunV8MicroTasks", "getForceRunV8MicroTasks()Z")), (kotlin.l.o)kotlin.g.b.ai.a(new kotlin.g.b.aa(kotlin.g.b.ai.cz(g.class), "renderThreadName", "getRenderThreadName()Ljava/lang/String;")), (kotlin.l.o)kotlin.g.b.ai.a(new kotlin.g.b.aa(kotlin.g.b.ai.cz(g.class), "appBrandRuntime", "getAppBrandRuntime()J")) };
    AppMethodBeat.o(140174);
  }
  
  public g()
  {
    AppMethodBeat.i(140186);
    this.eHP = new g.a(this, o.eIG);
    this.eHQ = new g.a(this, m.eIG);
    this.eHR = new g.a(this, l.eIG);
    this.eHS = new g.a(this, aa.eIG);
    this.eHT = new g.a(this, k.eIG);
    this.eHU = new b();
    this.eHW = new g.a(this, i.eIG);
    this.eHX = new g.a(this, r.eIG);
    this.eHY = new g.a(this, v.eIG);
    this.eHZ = new g.a(this, s.eIG);
    this.eIa = new g.a(this, u.eIG);
    this.eIb = new g.a(this, ac.eIG);
    this.eIc = new g.a(this, w.eIG);
    this.eId = new g.a(this, z.eIG);
    this.eIe = new g.a(this, q.eIG);
    this.eIf = new g.a(this, x.eIG);
    this.eIg = new g.a(this, h.eIG);
    this.eIh = true;
    this.eIi = true;
    this.eIj = new g.a(this, n.eIG);
    this.eIk = new g.a(this, af.eIG);
    this.eIl = new g.a(this, ad.eIG);
    this.eIm = new g.a(this, t.eIG);
    this.eIn = new g.a(this, ag.eIG);
    this.eIo = new g.a(this, am.eIG);
    this.eIp = new g.a(this, aj.eIG);
    this.eIq = new g.a(this, ah.eIG);
    this.eIr = new g.a(this, y.eIG);
    this.eIs = new g.a(this, p.eIG);
    this.eIt = new g.a(this, al.eIG);
    this.eIu = new g.a(this, ak.eIG);
    this.eIv = new g.a(this, ai.eIG);
    this.eIw = new g.a(this, ab.eIG);
    this.eIx = new g.a(this, ae.eIG);
    this.eIy = new g.a(this, j.eIG);
    this.eIz = new MBRuntime.MBParams();
    AppMethodBeat.o(140186);
  }
  
  public final int avA()
  {
    AppMethodBeat.i(140177);
    int i = ((Number)this.eHQ.a(aYe[1])).intValue();
    AppMethodBeat.o(140177);
    return i;
  }
  
  public final int avB()
  {
    AppMethodBeat.i(140178);
    int i = ((Number)this.eHR.a(aYe[2])).intValue();
    AppMethodBeat.o(140178);
    return i;
  }
  
  public final AssetManager avC()
  {
    AppMethodBeat.i(140179);
    AssetManager localAssetManager = (AssetManager)this.eHT.a(aYe[4]);
    AppMethodBeat.o(140179);
    return localAssetManager;
  }
  
  public final a.b avD()
  {
    AppMethodBeat.i(140180);
    a.b localb = (a.b)this.eHW.a(aYe[5]);
    AppMethodBeat.o(140180);
    return localb;
  }
  
  public final float avE()
  {
    AppMethodBeat.i(140182);
    float f = ((Number)this.eIb.a(aYe[10])).floatValue();
    AppMethodBeat.o(140182);
    return f;
  }
  
  public final void b(a.b paramb)
  {
    AppMethodBeat.i(140181);
    kotlin.g.b.s.t(paramb, "<set-?>");
    this.eHW.a(aYe[5], paramb);
    AppMethodBeat.o(140181);
  }
  
  public final void bf(float paramFloat)
  {
    AppMethodBeat.i(140176);
    this.eHP.a(aYe[0], Float.valueOf(paramFloat));
    AppMethodBeat.o(140176);
  }
  
  public final void bg(float paramFloat)
  {
    AppMethodBeat.i(140183);
    this.eIb.a(aYe[10], Float.valueOf(paramFloat));
    AppMethodBeat.o(140183);
  }
  
  public final void di(boolean paramBoolean)
  {
    AppMethodBeat.i(228938);
    this.eHZ.a(aYe[8], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(228938);
  }
  
  public final void dj(boolean paramBoolean)
  {
    AppMethodBeat.i(140184);
    this.eId.a(aYe[12], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(140184);
  }
  
  public final void dk(boolean paramBoolean)
  {
    AppMethodBeat.i(228951);
    this.eIe.a(aYe[13], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(228951);
  }
  
  public final void dl(boolean paramBoolean)
  {
    AppMethodBeat.i(140185);
    this.eIf.a(aYe[14], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(140185);
  }
  
  public final void dm(boolean paramBoolean)
  {
    AppMethodBeat.i(228958);
    this.eIm.a(aYe[19], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(228958);
  }
  
  public final void dn(boolean paramBoolean)
  {
    AppMethodBeat.i(228963);
    this.eIo.a(aYe[21], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(228963);
  }
  
  public final void jdMethod_do(boolean paramBoolean)
  {
    AppMethodBeat.i(228968);
    this.eIq.a(aYe[23], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(228968);
  }
  
  public final void dp(boolean paramBoolean)
  {
    AppMethodBeat.i(228972);
    this.eIs.a(aYe[25], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(228972);
  }
  
  public final void dq(boolean paramBoolean)
  {
    AppMethodBeat.i(228974);
    this.eIt.a(aYe[26], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(228974);
  }
  
  public final void dr(boolean paramBoolean)
  {
    AppMethodBeat.i(228976);
    this.eIu.a(aYe[27], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(228976);
  }
  
  public final void ds(boolean paramBoolean)
  {
    AppMethodBeat.i(228979);
    this.eIv.a(aYe[28], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(228979);
  }
  
  public final void dt(boolean paramBoolean)
  {
    AppMethodBeat.i(228982);
    this.eIw.a(aYe[29], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(228982);
  }
  
  public final void dy(long paramLong)
  {
    AppMethodBeat.i(228984);
    this.eIy.a(aYe[31], Long.valueOf(paramLong));
    AppMethodBeat.o(228984);
  }
  
  public final void fW(String paramString)
  {
    AppMethodBeat.i(228961);
    kotlin.g.b.s.t(paramString, "<set-?>");
    this.eIn.a(aYe[20], paramString);
    AppMethodBeat.o(228961);
  }
  
  public final float getDevicePixelRatio()
  {
    AppMethodBeat.i(140175);
    float f = ((Number)this.eHP.a(aYe[0])).floatValue();
    AppMethodBeat.o(140175);
    return f;
  }
  
  public final void q(kotlin.g.a.b<? super b, kotlin.ah> paramb)
  {
    AppMethodBeat.i(228930);
    kotlin.g.b.s.t(paramb, "dls");
    paramb.invoke(this.eHU);
    AppMethodBeat.o(228930);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;", "", "()V", "decodeSlaveForDefault", "Lcom/github/henryye/nativeiv/api/IImageDecodeService$BitmapDecodeSlave;", "getDecodeSlaveForDefault", "()Lcom/github/henryye/nativeiv/api/IImageDecodeService$BitmapDecodeSlave;", "setDecodeSlaveForDefault", "(Lcom/github/henryye/nativeiv/api/IImageDecodeService$BitmapDecodeSlave;)V", "enableDefaultImageHandler", "", "getEnableDefaultImageHandler", "()Z", "setEnableDefaultImageHandler", "(Z)V", "imageDecoderForDefault", "", "Lcom/github/henryye/nativeiv/stream/IImageStreamFetcher;", "getImageDecoderForDefault", "()Ljava/util/List;", "setImageDecoderForDefault", "(Ljava/util/List;)V", "imageHandler", "Lcom/github/henryye/nativeiv/BaseImageDecodeService;", "getImageHandler", "()Lcom/github/henryye/nativeiv/BaseImageDecodeService;", "setImageHandler", "(Lcom/github/henryye/nativeiv/BaseImageDecodeService;)V", "reporterForDefault", "Lcom/github/henryye/nativeiv/delegate/ReportDelegate$IKvReport;", "getReporterForDefault", "()Lcom/github/henryye/nativeiv/delegate/ReportDelegate$IKvReport;", "setReporterForDefault", "(Lcom/github/henryye/nativeiv/delegate/ReportDelegate$IKvReport;)V", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 16})
  public static final class b
  {
    public boolean eIB;
    public List<com.github.henryye.nativeiv.b.b> eIC;
    public c.b eID;
    public IImageDecodeService.a eIE;
    public BaseImageDecodeService eIF;
    
    public b()
    {
      AppMethodBeat.i(140099);
      this.eIB = true;
      this.eIC = ((List)new ArrayList());
      AppMethodBeat.o(140099);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.g
 * JD-Core Version:    0.7.0.1
 */