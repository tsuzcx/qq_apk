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

@d.l(gjZ={1, 1, 13}, gka={""}, gkb={"Lcom/tencent/magicbrush/MagicBrushConfig;", "", "()V", "abortIfBuildingError", "", "getAbortIfBuildingError", "()Z", "setAbortIfBuildingError", "(Z)V", "<set-?>", "adjustThreadPriority", "getAdjustThreadPriority", "setAdjustThreadPriority", "adjustThreadPriority$delegate", "Lcom/tencent/magicbrush/MagicBrushConfig$A;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "animationFrameHandlerStrategy", "getAnimationFrameHandlerStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "setAnimationFrameHandlerStrategy", "(Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;)V", "animationFrameHandlerStrategy$delegate", "Landroid/content/res/AssetManager;", "assetManager", "getAssetManager", "()Landroid/content/res/AssetManager;", "setAssetManager", "(Landroid/content/res/AssetManager;)V", "assetManager$delegate", "box2dSoPath", "", "getBox2dSoPath", "()Ljava/lang/String;", "setBox2dSoPath", "(Ljava/lang/String;)V", "", "canvasHeight", "getCanvasHeight", "()I", "setCanvasHeight", "(I)V", "canvasHeight$delegate", "canvasWidth", "getCanvasWidth", "setCanvasWidth", "canvasWidth$delegate", "cmdPoolType", "getCmdPoolType", "setCmdPoolType", "cmdPoolType$delegate", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "", "devicePixelRatio", "getDevicePixelRatio", "()F", "setDevicePixelRatio", "(F)V", "devicePixelRatio$delegate", "enable2d", "getEnable2d", "setEnable2d", "enable2d$delegate", "enableAntialias", "getEnableAntialias", "setEnableAntialias", "enableAntialias$delegate", "enableCommandBuffer", "getEnableCommandBuffer", "setEnableCommandBuffer", "enableCommandBuffer$delegate", "enableFontBatch", "getEnableFontBatch", "setEnableFontBatch", "enableFontBatch$delegate", "enableGfx", "getEnableGfx", "setEnableGfx", "enableGfx$delegate", "enableOpenGL3", "getEnableOpenGL3", "setEnableOpenGL3", "enableOpenGL3$delegate", "enableRequestAnimationFrame", "getEnableRequestAnimationFrame", "setEnableRequestAnimationFrame", "enableRequestAnimationFrame$delegate", "enableSwitchThreadNativeForAsyncJsApis", "getEnableSwitchThreadNativeForAsyncJsApis", "setEnableSwitchThreadNativeForAsyncJsApis", "enableSwitchThreadNativeForAsyncJsApis$delegate", "enableVerboseInBuilding", "getEnableVerboseInBuilding", "setEnableVerboseInBuilding", "enableWindowAttributesAlpha", "getEnableWindowAttributesAlpha", "setEnableWindowAttributesAlpha", "enableWindowAttributesAlpha$delegate", "enableWxBindCanvasTexture", "getEnableWxBindCanvasTexture", "setEnableWxBindCanvasTexture", "enableWxBindCanvasTexture$delegate", "Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;", "fileSystem", "getFileSystem", "()Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;", "setFileSystem", "(Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;)V", "fileSystem$delegate", "fontHandler", "Lcom/tencent/magicbrush/handler/glfont/IMBFontHandler;", "getFontHandler", "()Lcom/tencent/magicbrush/handler/glfont/IMBFontHandler;", "setFontHandler", "(Lcom/tencent/magicbrush/handler/glfont/IMBFontHandler;)V", "gcFactor", "getGcFactor", "setGcFactor", "gcFactor$delegate", "imageHandler", "Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;", "getImageHandlerConfig", "()Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;", "isGame", "setGame", "isGame$delegate", "isLogicOnly", "setLogicOnly", "isLogicOnly$delegate", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "getJsThreadHandler", "()Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "setJsThreadHandler", "(Lcom/tencent/magicbrush/handler/IJsThreadHandler;)V", "params", "Lcom/tencent/magicbrush/MBRuntime$MBParams;", "getParams$lib_magicbrush_nano_release", "()Lcom/tencent/magicbrush/MBRuntime$MBParams;", "revertCpuOptimizerTest", "getRevertCpuOptimizerTest", "setRevertCpuOptimizerTest", "revertCpuOptimizerTest$delegate", "sdcardPath", "getSdcardPath", "setSdcardPath", "sdcardPath$delegate", "supportClientVertexBuffer", "getSupportClientVertexBuffer", "setSupportClientVertexBuffer", "supportClientVertexBuffer$delegate", "supportGfxImageShareTexture", "getSupportGfxImageShareTexture", "setSupportGfxImageShareTexture", "supportGfxImageShareTexture$delegate", "supportHardDecode", "getSupportHardDecode", "setSupportHardDecode", "supportHardDecode$delegate", "supportHardEncode", "getSupportHardEncode", "setSupportHardEncode", "supportHardEncode$delegate", "syncSurfaceDestroy", "getSyncSurfaceDestroy", "setSyncSurfaceDestroy", "syncSurfaceDestroy$delegate", "v8RawPointer", "Lkotlin/Function0;", "Lcom/tencent/magicbrush/V8RawPointer;", "getV8RawPointer", "()Lkotlin/jvm/functions/Function0;", "setV8RawPointer", "(Lkotlin/jvm/functions/Function0;)V", "getImageHandler", "Lcom/github/henryye/nativeiv/BaseImageDecodeService;", "", "dls", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "A", "ImageHandlerConfig", "lib-magicbrush-nano_release"})
public class f
{
  public Context context;
  public com.tencent.magicbrush.handler.a cxB;
  public d.g.a.a<ai> cxC;
  private final a cxD;
  public final a cxE;
  public final a cxF;
  public final a cxG;
  public final a cxH;
  public final b cxI;
  public IMBFontHandler cxJ;
  private final a cxK;
  public final a cxL;
  public final a cxM;
  private final a cxN;
  public final a cxO;
  private final a cxP;
  private final a cxQ;
  private final a cxR;
  private final a cxS;
  private final a cxT;
  private final a cxU;
  public boolean cxV;
  public boolean cxW;
  public final a cxX;
  public final a cxY;
  public final a cxZ;
  public final a cya;
  private final a cyb;
  private final a cyc;
  private final a cyd;
  public final a cye;
  public final a cyf;
  private final a cyg;
  private final a cyh;
  public String cyi;
  public final a cyj;
  final MBRuntime.MBParams cyk;
  
  static
  {
    AppMethodBeat.i(140174);
    cxA = new d.l.k[] { (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "devicePixelRatio", "getDevicePixelRatio()F")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "canvasWidth", "getCanvasWidth()I")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "canvasHeight", "getCanvasHeight()I")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "fileSystem", "getFileSystem()Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "assetManager", "getAssetManager()Landroid/content/res/AssetManager;")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "animationFrameHandlerStrategy", "getAnimationFrameHandlerStrategy()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "enableAntialias", "getEnableAntialias()Z")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "enableOpenGL3", "getEnableOpenGL3()Z")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "enableCommandBuffer", "getEnableCommandBuffer()Z")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "enableGfx", "getEnableGfx()Z")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "gcFactor", "getGcFactor()F")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "enableRequestAnimationFrame", "getEnableRequestAnimationFrame()Z")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "enableWxBindCanvasTexture", "getEnableWxBindCanvasTexture()Z")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "enable2d", "getEnable2d()Z")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "enableWindowAttributesAlpha", "getEnableWindowAttributesAlpha()Z")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "adjustThreadPriority", "getAdjustThreadPriority()Z")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "cmdPoolType", "getCmdPoolType()I")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "revertCpuOptimizerTest", "getRevertCpuOptimizerTest()Z")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "isGame", "isGame()Z")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "enableFontBatch", "getEnableFontBatch()Z")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "sdcardPath", "getSdcardPath()Ljava/lang/String;")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "enableSwitchThreadNativeForAsyncJsApis", "getEnableSwitchThreadNativeForAsyncJsApis()Z")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "syncSurfaceDestroy", "getSyncSurfaceDestroy()Z")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "supportGfxImageShareTexture", "getSupportGfxImageShareTexture()Z")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "supportClientVertexBuffer", "getSupportClientVertexBuffer()Z")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "supportHardEncode", "getSupportHardEncode()Z")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "supportHardDecode", "getSupportHardDecode()Z")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "isLogicOnly", "isLogicOnly()Z")) };
    AppMethodBeat.o(140174);
  }
  
  public f()
  {
    AppMethodBeat.i(140186);
    this.cxD = new a(m.cyr);
    this.cxE = new a(k.cyr);
    this.cxF = new a(j.cyr);
    this.cxG = new a(x.cyr);
    this.cxH = new a(i.cyr);
    this.cxI = new b();
    this.cxK = new a(h.cyr);
    this.cxL = new a(o.cyr);
    this.cxM = new a(s.cyr);
    this.cxN = new a(p.cyr);
    this.cxO = new a(r.cyr);
    this.cxP = new a(y.cyr);
    this.cxQ = new a(t.cyr);
    this.cxR = new a(w.cyr);
    this.cxS = new a(n.cyr);
    this.cxT = new a(v.cyr);
    this.cxU = new a(g.cyr);
    this.cxV = true;
    this.cxW = true;
    this.cxX = new a(l.cyr);
    this.cxY = new a(ab.cyr);
    this.cxZ = new a(z.cyr);
    this.cya = new a(q.cyr);
    this.cyb = new a(ac.cyr);
    this.cyc = new a(u.cyr);
    this.cyd = new a(ah.cyr);
    this.cye = new a(ae.cyr);
    this.cyf = new a(ad.cyr);
    this.cyg = new a(ag.cyr);
    this.cyh = new a(af.cyr);
    this.cyj = new a(aa.cyr);
    this.cyk = new MBRuntime.MBParams();
    AppMethodBeat.o(140186);
  }
  
  public final void HA()
  {
    AppMethodBeat.i(213356);
    this.cxS.a(cxA[13], Boolean.FALSE);
    AppMethodBeat.o(213356);
  }
  
  public final void HB()
  {
    AppMethodBeat.i(213357);
    this.cxU.a(cxA[15], Boolean.FALSE);
    AppMethodBeat.o(213357);
  }
  
  public final int Hv()
  {
    AppMethodBeat.i(140177);
    int i = ((Number)this.cxE.a(cxA[1])).intValue();
    AppMethodBeat.o(140177);
    return i;
  }
  
  public final int Hw()
  {
    AppMethodBeat.i(140178);
    int i = ((Number)this.cxF.a(cxA[2])).intValue();
    AppMethodBeat.o(140178);
    return i;
  }
  
  public final AssetManager Hx()
  {
    AppMethodBeat.i(140179);
    AssetManager localAssetManager = (AssetManager)this.cxH.a(cxA[4]);
    AppMethodBeat.o(140179);
    return localAssetManager;
  }
  
  public final a.b Hy()
  {
    AppMethodBeat.i(140180);
    a.b localb = (a.b)this.cxK.a(cxA[5]);
    AppMethodBeat.o(140180);
    return localb;
  }
  
  public final float Hz()
  {
    AppMethodBeat.i(140182);
    float f = ((Number)this.cxP.a(cxA[10])).floatValue();
    AppMethodBeat.o(140182);
    return f;
  }
  
  public final void a(d.g.a.b<? super b, d.z> paramb)
  {
    AppMethodBeat.i(213354);
    d.g.b.p.h(paramb, "dls");
    paramb.invoke(this.cxI);
    AppMethodBeat.o(213354);
  }
  
  public final void ad(float paramFloat)
  {
    AppMethodBeat.i(140176);
    this.cxD.a(cxA[0], Float.valueOf(paramFloat));
    AppMethodBeat.o(140176);
  }
  
  public final void ae(float paramFloat)
  {
    AppMethodBeat.i(140183);
    this.cxP.a(cxA[10], Float.valueOf(paramFloat));
    AppMethodBeat.o(140183);
  }
  
  public final void b(a.b paramb)
  {
    AppMethodBeat.i(140181);
    d.g.b.p.h(paramb, "<set-?>");
    this.cxK.a(cxA[5], paramb);
    AppMethodBeat.o(140181);
  }
  
  public final void bO(boolean paramBoolean)
  {
    AppMethodBeat.i(213355);
    this.cxN.a(cxA[8], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(213355);
  }
  
  public final void bP(boolean paramBoolean)
  {
    AppMethodBeat.i(140184);
    this.cxR.a(cxA[12], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(140184);
  }
  
  public final void bQ(boolean paramBoolean)
  {
    AppMethodBeat.i(140185);
    this.cxT.a(cxA[14], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(140185);
  }
  
  public final void bR(boolean paramBoolean)
  {
    AppMethodBeat.i(182578);
    this.cyc.a(cxA[21], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(182578);
  }
  
  public final void bS(boolean paramBoolean)
  {
    AppMethodBeat.i(213359);
    this.cyd.a(cxA[22], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(213359);
  }
  
  public final void bT(boolean paramBoolean)
  {
    AppMethodBeat.i(213360);
    this.cyg.a(cxA[25], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(213360);
  }
  
  public final void bU(boolean paramBoolean)
  {
    AppMethodBeat.i(213361);
    this.cyh.a(cxA[26], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(213361);
  }
  
  public final void dE(String paramString)
  {
    AppMethodBeat.i(213358);
    d.g.b.p.h(paramString, "<set-?>");
    this.cyb.a(cxA[20], paramString);
    AppMethodBeat.o(213358);
  }
  
  public final float getDevicePixelRatio()
  {
    AppMethodBeat.i(140175);
    float f = ((Number)this.cxD.a(cxA[0])).floatValue();
    AppMethodBeat.o(140175);
    return f;
  }
  
  @d.l(gjZ={1, 1, 13}, gka={""}, gkb={"Lcom/tencent/magicbrush/MagicBrushConfig$A;", "T", "Lcom/tencent/magicbrush/utils/Alias;", "Lcom/tencent/magicbrush/MBRuntime$MBParams;", "k", "Lkotlin/reflect/KMutableProperty1;", "(Lcom/tencent/magicbrush/MagicBrushConfig;Lkotlin/reflect/KMutableProperty1;)V", "lib-magicbrush-nano_release"})
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
  
  @d.l(gjZ={1, 1, 13}, gka={""}, gkb={"Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;", "", "()V", "decodeSlaveForDefault", "Lcom/github/henryye/nativeiv/api/IImageDecodeService$BitmapDecodeSlave;", "getDecodeSlaveForDefault", "()Lcom/github/henryye/nativeiv/api/IImageDecodeService$BitmapDecodeSlave;", "setDecodeSlaveForDefault", "(Lcom/github/henryye/nativeiv/api/IImageDecodeService$BitmapDecodeSlave;)V", "enableDefaultImageHandler", "", "getEnableDefaultImageHandler", "()Z", "setEnableDefaultImageHandler", "(Z)V", "imageDecoderForDefault", "", "Lcom/github/henryye/nativeiv/stream/IImageStreamFetcher;", "getImageDecoderForDefault", "()Ljava/util/List;", "setImageDecoderForDefault", "(Ljava/util/List;)V", "imageHandler", "Lcom/github/henryye/nativeiv/BaseImageDecodeService;", "getImageHandler", "()Lcom/github/henryye/nativeiv/BaseImageDecodeService;", "setImageHandler", "(Lcom/github/henryye/nativeiv/BaseImageDecodeService;)V", "reporterForDefault", "Lcom/github/henryye/nativeiv/delegate/ReportDelegate$IKvReport;", "getReporterForDefault", "()Lcom/github/henryye/nativeiv/delegate/ReportDelegate$IKvReport;", "setReporterForDefault", "(Lcom/github/henryye/nativeiv/delegate/ReportDelegate$IKvReport;)V", "lib-magicbrush-nano_release"})
  public static final class b
  {
    public boolean cym;
    public List<com.github.henryye.nativeiv.b.b> cyn;
    public c.b cyo;
    public IImageDecodeService.a cyp;
    public BaseImageDecodeService cyq;
    
    public b()
    {
      AppMethodBeat.i(140099);
      this.cym = true;
      this.cyn = ((List)new ArrayList());
      AppMethodBeat.o(140099);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.f
 * JD-Core Version:    0.7.0.1
 */