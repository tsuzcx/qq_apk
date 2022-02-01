package com.tencent.magicbrush;

import android.content.Context;
import android.content.res.AssetManager;
import com.github.henryye.nativeiv.BaseImageDecodeService;
import com.github.henryye.nativeiv.a.c.b;
import com.github.henryye.nativeiv.api.IImageDecodeService.a;
import com.github.henryye.nativeiv.b.b;
import com.tencent.magicbrush.handler.glfont.IMBFontHandler;
import com.tencent.magicbrush.ui.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/magicbrush/MagicBrushConfig;", "", "()V", "abortIfBuildingError", "", "getAbortIfBuildingError", "()Z", "setAbortIfBuildingError", "(Z)V", "<set-?>", "adjustThreadPriority", "getAdjustThreadPriority", "setAdjustThreadPriority", "adjustThreadPriority$delegate", "Lcom/tencent/magicbrush/MagicBrushConfig$A;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "animationFrameHandlerStrategy", "getAnimationFrameHandlerStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "setAnimationFrameHandlerStrategy", "(Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;)V", "animationFrameHandlerStrategy$delegate", "Landroid/content/res/AssetManager;", "assetManager", "getAssetManager", "()Landroid/content/res/AssetManager;", "setAssetManager", "(Landroid/content/res/AssetManager;)V", "assetManager$delegate", "", "canvasHeight", "getCanvasHeight", "()I", "setCanvasHeight", "(I)V", "canvasHeight$delegate", "canvasWidth", "getCanvasWidth", "setCanvasWidth", "canvasWidth$delegate", "cmdPoolType", "getCmdPoolType", "setCmdPoolType", "cmdPoolType$delegate", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "", "devicePixelRatio", "getDevicePixelRatio", "()F", "setDevicePixelRatio", "(F)V", "devicePixelRatio$delegate", "enable2d", "getEnable2d", "setEnable2d", "enable2d$delegate", "enableAntialias", "getEnableAntialias", "setEnableAntialias", "enableAntialias$delegate", "enableCommandBuffer", "getEnableCommandBuffer", "setEnableCommandBuffer", "enableCommandBuffer$delegate", "enableFontBatch", "getEnableFontBatch", "setEnableFontBatch", "enableFontBatch$delegate", "enableGfx", "getEnableGfx", "setEnableGfx", "enableGfx$delegate", "enableOpenGL3", "getEnableOpenGL3", "setEnableOpenGL3", "enableOpenGL3$delegate", "enableRequestAnimationFrame", "getEnableRequestAnimationFrame", "setEnableRequestAnimationFrame", "enableRequestAnimationFrame$delegate", "enableSwitchThreadNativeForAsyncJsApis", "getEnableSwitchThreadNativeForAsyncJsApis", "setEnableSwitchThreadNativeForAsyncJsApis", "enableSwitchThreadNativeForAsyncJsApis$delegate", "enableVerboseInBuilding", "getEnableVerboseInBuilding", "setEnableVerboseInBuilding", "enableWindowAttributesAlpha", "getEnableWindowAttributesAlpha", "setEnableWindowAttributesAlpha", "enableWindowAttributesAlpha$delegate", "enableWxBindCanvasTexture", "getEnableWxBindCanvasTexture", "setEnableWxBindCanvasTexture", "enableWxBindCanvasTexture$delegate", "Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;", "fileSystem", "getFileSystem", "()Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;", "setFileSystem", "(Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;)V", "fileSystem$delegate", "fontHandler", "Lcom/tencent/magicbrush/handler/glfont/IMBFontHandler;", "getFontHandler", "()Lcom/tencent/magicbrush/handler/glfont/IMBFontHandler;", "setFontHandler", "(Lcom/tencent/magicbrush/handler/glfont/IMBFontHandler;)V", "gcFactor", "getGcFactor", "setGcFactor", "gcFactor$delegate", "imageHandler", "Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;", "getImageHandlerConfig", "()Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;", "isGame", "setGame", "isGame$delegate", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "getJsThreadHandler", "()Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "setJsThreadHandler", "(Lcom/tencent/magicbrush/handler/IJsThreadHandler;)V", "params", "Lcom/tencent/magicbrush/MBRuntime$MBParams;", "getParams$lib_magicbrush_nano_release", "()Lcom/tencent/magicbrush/MBRuntime$MBParams;", "revertCpuOptimizerTest", "getRevertCpuOptimizerTest", "setRevertCpuOptimizerTest", "revertCpuOptimizerTest$delegate", "", "sdcardPath", "getSdcardPath", "()Ljava/lang/String;", "setSdcardPath", "(Ljava/lang/String;)V", "sdcardPath$delegate", "syncSurfaceDestroy", "getSyncSurfaceDestroy", "setSyncSurfaceDestroy", "syncSurfaceDestroy$delegate", "v8RawPointer", "Lkotlin/Function0;", "Lcom/tencent/magicbrush/V8RawPointer;", "getV8RawPointer", "()Lkotlin/jvm/functions/Function0;", "setV8RawPointer", "(Lkotlin/jvm/functions/Function0;)V", "getImageHandler", "Lcom/github/henryye/nativeiv/BaseImageDecodeService;", "", "dls", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "A", "ImageHandlerConfig", "lib-magicbrush-nano_release"})
public class f
{
  public Context context;
  private final a cpA;
  public final a cpB;
  private final a cpC;
  private final a cpD;
  private final a cpE;
  public final a cpF;
  private final a cpG;
  public final a cpH;
  public boolean cpI;
  public boolean cpJ;
  public final a cpK;
  public final a cpL;
  public final a cpM;
  public final a cpN;
  public final a cpO;
  private final a cpP;
  private final a cpQ;
  final MBRuntime.MBParams cpR;
  public com.tencent.magicbrush.handler.a cpo;
  public d.g.a.a<ad> cpp;
  private final a cpq;
  public final a cpr;
  public final a cps;
  public final a cpt;
  public final a cpu;
  public final b cpv;
  public IMBFontHandler cpw;
  private final a cpx;
  public final a cpy;
  public final a cpz;
  
  static
  {
    AppMethodBeat.i(140174);
    $$delegatedProperties = new d.l.k[] { (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bk(f.class), "devicePixelRatio", "getDevicePixelRatio()F")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bk(f.class), "canvasWidth", "getCanvasWidth()I")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bk(f.class), "canvasHeight", "getCanvasHeight()I")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bk(f.class), "fileSystem", "getFileSystem()Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bk(f.class), "assetManager", "getAssetManager()Landroid/content/res/AssetManager;")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bk(f.class), "animationFrameHandlerStrategy", "getAnimationFrameHandlerStrategy()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bk(f.class), "enableAntialias", "getEnableAntialias()Z")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bk(f.class), "enableOpenGL3", "getEnableOpenGL3()Z")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bk(f.class), "enableCommandBuffer", "getEnableCommandBuffer()Z")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bk(f.class), "enableGfx", "getEnableGfx()Z")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bk(f.class), "gcFactor", "getGcFactor()F")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bk(f.class), "enableRequestAnimationFrame", "getEnableRequestAnimationFrame()Z")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bk(f.class), "enableWxBindCanvasTexture", "getEnableWxBindCanvasTexture()Z")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bk(f.class), "enable2d", "getEnable2d()Z")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bk(f.class), "enableWindowAttributesAlpha", "getEnableWindowAttributesAlpha()Z")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bk(f.class), "adjustThreadPriority", "getAdjustThreadPriority()Z")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bk(f.class), "cmdPoolType", "getCmdPoolType()I")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bk(f.class), "revertCpuOptimizerTest", "getRevertCpuOptimizerTest()Z")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bk(f.class), "isGame", "isGame()Z")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bk(f.class), "enableFontBatch", "getEnableFontBatch()Z")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bk(f.class), "sdcardPath", "getSdcardPath()Ljava/lang/String;")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bk(f.class), "enableSwitchThreadNativeForAsyncJsApis", "getEnableSwitchThreadNativeForAsyncJsApis()Z")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bk(f.class), "syncSurfaceDestroy", "getSyncSurfaceDestroy()Z")) };
    AppMethodBeat.o(140174);
  }
  
  public f()
  {
    AppMethodBeat.i(140186);
    this.cpq = new a(m.cpY);
    this.cpr = new a(k.cpY);
    this.cps = new a(j.cpY);
    this.cpt = new a(x.cpY);
    this.cpu = new a(i.cpY);
    this.cpv = new b();
    this.cpx = new a(h.cpY);
    this.cpy = new a(o.cpY);
    this.cpz = new a(s.cpY);
    this.cpA = new a(p.cpY);
    this.cpB = new a(r.cpY);
    this.cpC = new a(y.cpY);
    this.cpD = new a(t.cpY);
    this.cpE = new a(w.cpY);
    this.cpF = new a(n.cpY);
    this.cpG = new a(v.cpY);
    this.cpH = new a(g.cpY);
    this.cpI = true;
    this.cpJ = true;
    this.cpK = new a(l.cpY);
    this.cpL = new a(aa.cpY);
    this.cpM = new a(z.cpY);
    this.cpN = new a(q.cpY);
    this.cpO = new a(ab.cpY);
    this.cpP = new a(u.cpY);
    this.cpQ = new a(ac.cpY);
    this.cpR = new MBRuntime.MBParams();
    AppMethodBeat.o(140186);
  }
  
  public final int Gi()
  {
    AppMethodBeat.i(140177);
    int i = ((Number)this.cpr.a($$delegatedProperties[1])).intValue();
    AppMethodBeat.o(140177);
    return i;
  }
  
  public final int Gj()
  {
    AppMethodBeat.i(140178);
    int i = ((Number)this.cps.a($$delegatedProperties[2])).intValue();
    AppMethodBeat.o(140178);
    return i;
  }
  
  public final AssetManager Gk()
  {
    AppMethodBeat.i(140179);
    AssetManager localAssetManager = (AssetManager)this.cpu.a($$delegatedProperties[4]);
    AppMethodBeat.o(140179);
    return localAssetManager;
  }
  
  public final a.b Gl()
  {
    AppMethodBeat.i(140180);
    a.b localb = (a.b)this.cpx.a($$delegatedProperties[5]);
    AppMethodBeat.o(140180);
    return localb;
  }
  
  public final float Gm()
  {
    AppMethodBeat.i(140182);
    float f = ((Number)this.cpC.a($$delegatedProperties[10])).floatValue();
    AppMethodBeat.o(140182);
    return f;
  }
  
  public final void X(float paramFloat)
  {
    AppMethodBeat.i(140176);
    this.cpq.a($$delegatedProperties[0], Float.valueOf(paramFloat));
    AppMethodBeat.o(140176);
  }
  
  public final void Y(float paramFloat)
  {
    AppMethodBeat.i(140183);
    this.cpC.a($$delegatedProperties[10], Float.valueOf(paramFloat));
    AppMethodBeat.o(140183);
  }
  
  public final void b(a.b paramb)
  {
    AppMethodBeat.i(140181);
    d.g.b.k.h(paramb, "<set-?>");
    this.cpx.a($$delegatedProperties[5], paramb);
    AppMethodBeat.o(140181);
  }
  
  public final void bN(boolean paramBoolean)
  {
    AppMethodBeat.i(193571);
    this.cpA.a($$delegatedProperties[8], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(193571);
  }
  
  public final void bO(boolean paramBoolean)
  {
    AppMethodBeat.i(140184);
    this.cpE.a($$delegatedProperties[12], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(140184);
  }
  
  public final void bP(boolean paramBoolean)
  {
    AppMethodBeat.i(140185);
    this.cpG.a($$delegatedProperties[14], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(140185);
  }
  
  public final void bQ(boolean paramBoolean)
  {
    AppMethodBeat.i(182578);
    this.cpP.a($$delegatedProperties[21], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(182578);
  }
  
  public final void bR(boolean paramBoolean)
  {
    AppMethodBeat.i(193572);
    this.cpQ.a($$delegatedProperties[22], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(193572);
  }
  
  public final float getDevicePixelRatio()
  {
    AppMethodBeat.i(140175);
    float f = ((Number)this.cpq.a($$delegatedProperties[0])).floatValue();
    AppMethodBeat.o(140175);
    return f;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/magicbrush/MagicBrushConfig$A;", "T", "Lcom/tencent/magicbrush/utils/Alias;", "Lcom/tencent/magicbrush/MBRuntime$MBParams;", "k", "Lkotlin/reflect/KMutableProperty1;", "(Lcom/tencent/magicbrush/MagicBrushConfig;Lkotlin/reflect/KMutableProperty1;)V", "lib-magicbrush-nano_release"})
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;", "", "()V", "decodeSlaveForDefault", "Lcom/github/henryye/nativeiv/api/IImageDecodeService$BitmapDecodeSlave;", "getDecodeSlaveForDefault", "()Lcom/github/henryye/nativeiv/api/IImageDecodeService$BitmapDecodeSlave;", "setDecodeSlaveForDefault", "(Lcom/github/henryye/nativeiv/api/IImageDecodeService$BitmapDecodeSlave;)V", "enableDefaultImageHandler", "", "getEnableDefaultImageHandler", "()Z", "setEnableDefaultImageHandler", "(Z)V", "imageDecoderForDefault", "", "Lcom/github/henryye/nativeiv/stream/IImageStreamFetcher;", "getImageDecoderForDefault", "()Ljava/util/List;", "setImageDecoderForDefault", "(Ljava/util/List;)V", "imageHandler", "Lcom/github/henryye/nativeiv/BaseImageDecodeService;", "getImageHandler", "()Lcom/github/henryye/nativeiv/BaseImageDecodeService;", "setImageHandler", "(Lcom/github/henryye/nativeiv/BaseImageDecodeService;)V", "reporterForDefault", "Lcom/github/henryye/nativeiv/delegate/ReportDelegate$IKvReport;", "getReporterForDefault", "()Lcom/github/henryye/nativeiv/delegate/ReportDelegate$IKvReport;", "setReporterForDefault", "(Lcom/github/henryye/nativeiv/delegate/ReportDelegate$IKvReport;)V", "lib-magicbrush-nano_release"})
  public static final class b
  {
    public boolean cpT;
    public List<b> cpU;
    public c.b cpV;
    public IImageDecodeService.a cpW;
    public BaseImageDecodeService cpX;
    
    public b()
    {
      AppMethodBeat.i(140099);
      this.cpT = true;
      this.cpU = ((List)new ArrayList());
      AppMethodBeat.o(140099);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.f
 * JD-Core Version:    0.7.0.1
 */