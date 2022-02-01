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

@d.l(fNY={1, 1, 13}, fNZ={""}, fOa={"Lcom/tencent/magicbrush/MagicBrushConfig;", "", "()V", "abortIfBuildingError", "", "getAbortIfBuildingError", "()Z", "setAbortIfBuildingError", "(Z)V", "<set-?>", "adjustThreadPriority", "getAdjustThreadPriority", "setAdjustThreadPriority", "adjustThreadPriority$delegate", "Lcom/tencent/magicbrush/MagicBrushConfig$A;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "animationFrameHandlerStrategy", "getAnimationFrameHandlerStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "setAnimationFrameHandlerStrategy", "(Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;)V", "animationFrameHandlerStrategy$delegate", "Landroid/content/res/AssetManager;", "assetManager", "getAssetManager", "()Landroid/content/res/AssetManager;", "setAssetManager", "(Landroid/content/res/AssetManager;)V", "assetManager$delegate", "", "canvasHeight", "getCanvasHeight", "()I", "setCanvasHeight", "(I)V", "canvasHeight$delegate", "canvasWidth", "getCanvasWidth", "setCanvasWidth", "canvasWidth$delegate", "cmdPoolType", "getCmdPoolType", "setCmdPoolType", "cmdPoolType$delegate", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "", "devicePixelRatio", "getDevicePixelRatio", "()F", "setDevicePixelRatio", "(F)V", "devicePixelRatio$delegate", "enable2d", "getEnable2d", "setEnable2d", "enable2d$delegate", "enableAntialias", "getEnableAntialias", "setEnableAntialias", "enableAntialias$delegate", "enableCommandBuffer", "getEnableCommandBuffer", "setEnableCommandBuffer", "enableCommandBuffer$delegate", "enableFontBatch", "getEnableFontBatch", "setEnableFontBatch", "enableFontBatch$delegate", "enableGfx", "getEnableGfx", "setEnableGfx", "enableGfx$delegate", "enableOpenGL3", "getEnableOpenGL3", "setEnableOpenGL3", "enableOpenGL3$delegate", "enableRequestAnimationFrame", "getEnableRequestAnimationFrame", "setEnableRequestAnimationFrame", "enableRequestAnimationFrame$delegate", "enableSwitchThreadNativeForAsyncJsApis", "getEnableSwitchThreadNativeForAsyncJsApis", "setEnableSwitchThreadNativeForAsyncJsApis", "enableSwitchThreadNativeForAsyncJsApis$delegate", "enableVerboseInBuilding", "getEnableVerboseInBuilding", "setEnableVerboseInBuilding", "enableWindowAttributesAlpha", "getEnableWindowAttributesAlpha", "setEnableWindowAttributesAlpha", "enableWindowAttributesAlpha$delegate", "enableWxBindCanvasTexture", "getEnableWxBindCanvasTexture", "setEnableWxBindCanvasTexture", "enableWxBindCanvasTexture$delegate", "Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;", "fileSystem", "getFileSystem", "()Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;", "setFileSystem", "(Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;)V", "fileSystem$delegate", "fontHandler", "Lcom/tencent/magicbrush/handler/glfont/IMBFontHandler;", "getFontHandler", "()Lcom/tencent/magicbrush/handler/glfont/IMBFontHandler;", "setFontHandler", "(Lcom/tencent/magicbrush/handler/glfont/IMBFontHandler;)V", "gcFactor", "getGcFactor", "setGcFactor", "gcFactor$delegate", "imageHandler", "Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;", "getImageHandlerConfig", "()Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;", "isGame", "setGame", "isGame$delegate", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "getJsThreadHandler", "()Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "setJsThreadHandler", "(Lcom/tencent/magicbrush/handler/IJsThreadHandler;)V", "params", "Lcom/tencent/magicbrush/MBRuntime$MBParams;", "getParams$lib_magicbrush_nano_release", "()Lcom/tencent/magicbrush/MBRuntime$MBParams;", "revertCpuOptimizerTest", "getRevertCpuOptimizerTest", "setRevertCpuOptimizerTest", "revertCpuOptimizerTest$delegate", "", "sdcardPath", "getSdcardPath", "()Ljava/lang/String;", "setSdcardPath", "(Ljava/lang/String;)V", "sdcardPath$delegate", "supportClientVertexBuffer", "getSupportClientVertexBuffer", "setSupportClientVertexBuffer", "supportClientVertexBuffer$delegate", "supportGfxImageShareTexture", "getSupportGfxImageShareTexture", "setSupportGfxImageShareTexture", "supportGfxImageShareTexture$delegate", "syncSurfaceDestroy", "getSyncSurfaceDestroy", "setSyncSurfaceDestroy", "syncSurfaceDestroy$delegate", "v8RawPointer", "Lkotlin/Function0;", "Lcom/tencent/magicbrush/V8RawPointer;", "getV8RawPointer", "()Lkotlin/jvm/functions/Function0;", "setV8RawPointer", "(Lkotlin/jvm/functions/Function0;)V", "getImageHandler", "Lcom/github/henryye/nativeiv/BaseImageDecodeService;", "", "dls", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "A", "ImageHandlerConfig", "lib-magicbrush-nano_release"})
public class f
{
  public final b cmA;
  public IMBFontHandler cmB;
  private final a cmC;
  public final a cmD;
  public final a cmE;
  private final a cmF;
  public final a cmG;
  private final a cmH;
  private final a cmI;
  private final a cmJ;
  public final a cmK;
  private final a cmL;
  public final a cmM;
  public boolean cmN;
  public boolean cmO;
  public final a cmP;
  public final a cmQ;
  public final a cmR;
  public final a cmS;
  public final a cmT;
  private final a cmU;
  private final a cmV;
  public final a cmW;
  public final a cmX;
  final MBRuntime.MBParams cmY;
  public com.tencent.magicbrush.handler.a cmt;
  public d.g.a.a<af> cmu;
  private final a cmv;
  public final a cmw;
  public final a cmx;
  public final a cmy;
  public final a cmz;
  public Context context;
  
  static
  {
    AppMethodBeat.i(140174);
    $$delegatedProperties = new d.l.k[] { (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bn(f.class), "devicePixelRatio", "getDevicePixelRatio()F")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bn(f.class), "canvasWidth", "getCanvasWidth()I")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bn(f.class), "canvasHeight", "getCanvasHeight()I")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bn(f.class), "fileSystem", "getFileSystem()Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bn(f.class), "assetManager", "getAssetManager()Landroid/content/res/AssetManager;")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bn(f.class), "animationFrameHandlerStrategy", "getAnimationFrameHandlerStrategy()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bn(f.class), "enableAntialias", "getEnableAntialias()Z")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bn(f.class), "enableOpenGL3", "getEnableOpenGL3()Z")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bn(f.class), "enableCommandBuffer", "getEnableCommandBuffer()Z")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bn(f.class), "enableGfx", "getEnableGfx()Z")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bn(f.class), "gcFactor", "getGcFactor()F")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bn(f.class), "enableRequestAnimationFrame", "getEnableRequestAnimationFrame()Z")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bn(f.class), "enableWxBindCanvasTexture", "getEnableWxBindCanvasTexture()Z")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bn(f.class), "enable2d", "getEnable2d()Z")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bn(f.class), "enableWindowAttributesAlpha", "getEnableWindowAttributesAlpha()Z")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bn(f.class), "adjustThreadPriority", "getAdjustThreadPriority()Z")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bn(f.class), "cmdPoolType", "getCmdPoolType()I")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bn(f.class), "revertCpuOptimizerTest", "getRevertCpuOptimizerTest()Z")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bn(f.class), "isGame", "isGame()Z")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bn(f.class), "enableFontBatch", "getEnableFontBatch()Z")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bn(f.class), "sdcardPath", "getSdcardPath()Ljava/lang/String;")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bn(f.class), "enableSwitchThreadNativeForAsyncJsApis", "getEnableSwitchThreadNativeForAsyncJsApis()Z")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bn(f.class), "syncSurfaceDestroy", "getSyncSurfaceDestroy()Z")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bn(f.class), "supportGfxImageShareTexture", "getSupportGfxImageShareTexture()Z")), (d.l.k)d.g.b.w.a(new d.g.b.o(d.g.b.w.bn(f.class), "supportClientVertexBuffer", "getSupportClientVertexBuffer()Z")) };
    AppMethodBeat.o(140174);
  }
  
  public f()
  {
    AppMethodBeat.i(140186);
    this.cmv = new a(m.cnf);
    this.cmw = new a(k.cnf);
    this.cmx = new a(j.cnf);
    this.cmy = new a(x.cnf);
    this.cmz = new a(i.cnf);
    this.cmA = new b();
    this.cmC = new a(h.cnf);
    this.cmD = new a(o.cnf);
    this.cmE = new a(s.cnf);
    this.cmF = new a(p.cnf);
    this.cmG = new a(r.cnf);
    this.cmH = new a(y.cnf);
    this.cmI = new a(t.cnf);
    this.cmJ = new a(w.cnf);
    this.cmK = new a(n.cnf);
    this.cmL = new a(v.cnf);
    this.cmM = new a(g.cnf);
    this.cmN = true;
    this.cmO = true;
    this.cmP = new a(l.cnf);
    this.cmQ = new a(aa.cnf);
    this.cmR = new a(z.cnf);
    this.cmS = new a(q.cnf);
    this.cmT = new a(ab.cnf);
    this.cmU = new a(u.cnf);
    this.cmV = new a(ae.cnf);
    this.cmW = new a(ad.cnf);
    this.cmX = new a(ac.cnf);
    this.cmY = new MBRuntime.MBParams();
    AppMethodBeat.o(140186);
  }
  
  public final int FU()
  {
    AppMethodBeat.i(140177);
    int i = ((Number)this.cmw.a($$delegatedProperties[1])).intValue();
    AppMethodBeat.o(140177);
    return i;
  }
  
  public final int FV()
  {
    AppMethodBeat.i(140178);
    int i = ((Number)this.cmx.a($$delegatedProperties[2])).intValue();
    AppMethodBeat.o(140178);
    return i;
  }
  
  public final AssetManager FW()
  {
    AppMethodBeat.i(140179);
    AssetManager localAssetManager = (AssetManager)this.cmz.a($$delegatedProperties[4]);
    AppMethodBeat.o(140179);
    return localAssetManager;
  }
  
  public final a.b FX()
  {
    AppMethodBeat.i(140180);
    a.b localb = (a.b)this.cmC.a($$delegatedProperties[5]);
    AppMethodBeat.o(140180);
    return localb;
  }
  
  public final float FY()
  {
    AppMethodBeat.i(140182);
    float f = ((Number)this.cmH.a($$delegatedProperties[10])).floatValue();
    AppMethodBeat.o(140182);
    return f;
  }
  
  public final void ab(float paramFloat)
  {
    AppMethodBeat.i(140176);
    this.cmv.a($$delegatedProperties[0], Float.valueOf(paramFloat));
    AppMethodBeat.o(140176);
  }
  
  public final void ac(float paramFloat)
  {
    AppMethodBeat.i(140183);
    this.cmH.a($$delegatedProperties[10], Float.valueOf(paramFloat));
    AppMethodBeat.o(140183);
  }
  
  public final void b(a.b paramb)
  {
    AppMethodBeat.i(140181);
    d.g.b.k.h(paramb, "<set-?>");
    this.cmC.a($$delegatedProperties[5], paramb);
    AppMethodBeat.o(140181);
  }
  
  public final void bO(boolean paramBoolean)
  {
    AppMethodBeat.i(190931);
    this.cmF.a($$delegatedProperties[8], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(190931);
  }
  
  public final void bP(boolean paramBoolean)
  {
    AppMethodBeat.i(140184);
    this.cmJ.a($$delegatedProperties[12], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(140184);
  }
  
  public final void bQ(boolean paramBoolean)
  {
    AppMethodBeat.i(140185);
    this.cmL.a($$delegatedProperties[14], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(140185);
  }
  
  public final void bR(boolean paramBoolean)
  {
    AppMethodBeat.i(182578);
    this.cmU.a($$delegatedProperties[21], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(182578);
  }
  
  public final void bS(boolean paramBoolean)
  {
    AppMethodBeat.i(190932);
    this.cmV.a($$delegatedProperties[22], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(190932);
  }
  
  public final float getDevicePixelRatio()
  {
    AppMethodBeat.i(140175);
    float f = ((Number)this.cmv.a($$delegatedProperties[0])).floatValue();
    AppMethodBeat.o(140175);
    return f;
  }
  
  @d.l(fNY={1, 1, 13}, fNZ={""}, fOa={"Lcom/tencent/magicbrush/MagicBrushConfig$A;", "T", "Lcom/tencent/magicbrush/utils/Alias;", "Lcom/tencent/magicbrush/MBRuntime$MBParams;", "k", "Lkotlin/reflect/KMutableProperty1;", "(Lcom/tencent/magicbrush/MagicBrushConfig;Lkotlin/reflect/KMutableProperty1;)V", "lib-magicbrush-nano_release"})
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
  
  @d.l(fNY={1, 1, 13}, fNZ={""}, fOa={"Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;", "", "()V", "decodeSlaveForDefault", "Lcom/github/henryye/nativeiv/api/IImageDecodeService$BitmapDecodeSlave;", "getDecodeSlaveForDefault", "()Lcom/github/henryye/nativeiv/api/IImageDecodeService$BitmapDecodeSlave;", "setDecodeSlaveForDefault", "(Lcom/github/henryye/nativeiv/api/IImageDecodeService$BitmapDecodeSlave;)V", "enableDefaultImageHandler", "", "getEnableDefaultImageHandler", "()Z", "setEnableDefaultImageHandler", "(Z)V", "imageDecoderForDefault", "", "Lcom/github/henryye/nativeiv/stream/IImageStreamFetcher;", "getImageDecoderForDefault", "()Ljava/util/List;", "setImageDecoderForDefault", "(Ljava/util/List;)V", "imageHandler", "Lcom/github/henryye/nativeiv/BaseImageDecodeService;", "getImageHandler", "()Lcom/github/henryye/nativeiv/BaseImageDecodeService;", "setImageHandler", "(Lcom/github/henryye/nativeiv/BaseImageDecodeService;)V", "reporterForDefault", "Lcom/github/henryye/nativeiv/delegate/ReportDelegate$IKvReport;", "getReporterForDefault", "()Lcom/github/henryye/nativeiv/delegate/ReportDelegate$IKvReport;", "setReporterForDefault", "(Lcom/github/henryye/nativeiv/delegate/ReportDelegate$IKvReport;)V", "lib-magicbrush-nano_release"})
  public static final class b
  {
    public boolean cna;
    public List<b> cnb;
    public c.b cnc;
    public IImageDecodeService.a cnd;
    public BaseImageDecodeService cne;
    
    public b()
    {
      AppMethodBeat.i(140099);
      this.cna = true;
      this.cnb = ((List)new ArrayList());
      AppMethodBeat.o(140099);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.f
 * JD-Core Version:    0.7.0.1
 */