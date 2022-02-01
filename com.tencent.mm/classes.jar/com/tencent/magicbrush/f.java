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

@d.l(gfx={1, 1, 13}, gfy={""}, gfz={"Lcom/tencent/magicbrush/MagicBrushConfig;", "", "()V", "abortIfBuildingError", "", "getAbortIfBuildingError", "()Z", "setAbortIfBuildingError", "(Z)V", "<set-?>", "adjustThreadPriority", "getAdjustThreadPriority", "setAdjustThreadPriority", "adjustThreadPriority$delegate", "Lcom/tencent/magicbrush/MagicBrushConfig$A;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "animationFrameHandlerStrategy", "getAnimationFrameHandlerStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "setAnimationFrameHandlerStrategy", "(Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;)V", "animationFrameHandlerStrategy$delegate", "Landroid/content/res/AssetManager;", "assetManager", "getAssetManager", "()Landroid/content/res/AssetManager;", "setAssetManager", "(Landroid/content/res/AssetManager;)V", "assetManager$delegate", "", "canvasHeight", "getCanvasHeight", "()I", "setCanvasHeight", "(I)V", "canvasHeight$delegate", "canvasWidth", "getCanvasWidth", "setCanvasWidth", "canvasWidth$delegate", "cmdPoolType", "getCmdPoolType", "setCmdPoolType", "cmdPoolType$delegate", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "", "devicePixelRatio", "getDevicePixelRatio", "()F", "setDevicePixelRatio", "(F)V", "devicePixelRatio$delegate", "enable2d", "getEnable2d", "setEnable2d", "enable2d$delegate", "enableAntialias", "getEnableAntialias", "setEnableAntialias", "enableAntialias$delegate", "enableCommandBuffer", "getEnableCommandBuffer", "setEnableCommandBuffer", "enableCommandBuffer$delegate", "enableFontBatch", "getEnableFontBatch", "setEnableFontBatch", "enableFontBatch$delegate", "enableGfx", "getEnableGfx", "setEnableGfx", "enableGfx$delegate", "enableOpenGL3", "getEnableOpenGL3", "setEnableOpenGL3", "enableOpenGL3$delegate", "enableRequestAnimationFrame", "getEnableRequestAnimationFrame", "setEnableRequestAnimationFrame", "enableRequestAnimationFrame$delegate", "enableSwitchThreadNativeForAsyncJsApis", "getEnableSwitchThreadNativeForAsyncJsApis", "setEnableSwitchThreadNativeForAsyncJsApis", "enableSwitchThreadNativeForAsyncJsApis$delegate", "enableVerboseInBuilding", "getEnableVerboseInBuilding", "setEnableVerboseInBuilding", "enableWindowAttributesAlpha", "getEnableWindowAttributesAlpha", "setEnableWindowAttributesAlpha", "enableWindowAttributesAlpha$delegate", "enableWxBindCanvasTexture", "getEnableWxBindCanvasTexture", "setEnableWxBindCanvasTexture", "enableWxBindCanvasTexture$delegate", "Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;", "fileSystem", "getFileSystem", "()Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;", "setFileSystem", "(Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;)V", "fileSystem$delegate", "fontHandler", "Lcom/tencent/magicbrush/handler/glfont/IMBFontHandler;", "getFontHandler", "()Lcom/tencent/magicbrush/handler/glfont/IMBFontHandler;", "setFontHandler", "(Lcom/tencent/magicbrush/handler/glfont/IMBFontHandler;)V", "gcFactor", "getGcFactor", "setGcFactor", "gcFactor$delegate", "imageHandler", "Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;", "getImageHandlerConfig", "()Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;", "isGame", "setGame", "isGame$delegate", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "getJsThreadHandler", "()Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "setJsThreadHandler", "(Lcom/tencent/magicbrush/handler/IJsThreadHandler;)V", "params", "Lcom/tencent/magicbrush/MBRuntime$MBParams;", "getParams$lib_magicbrush_nano_release", "()Lcom/tencent/magicbrush/MBRuntime$MBParams;", "revertCpuOptimizerTest", "getRevertCpuOptimizerTest", "setRevertCpuOptimizerTest", "revertCpuOptimizerTest$delegate", "", "sdcardPath", "getSdcardPath", "()Ljava/lang/String;", "setSdcardPath", "(Ljava/lang/String;)V", "sdcardPath$delegate", "supportClientVertexBuffer", "getSupportClientVertexBuffer", "setSupportClientVertexBuffer", "supportClientVertexBuffer$delegate", "supportGfxImageShareTexture", "getSupportGfxImageShareTexture", "setSupportGfxImageShareTexture", "supportGfxImageShareTexture$delegate", "supportHardDecode", "getSupportHardDecode", "setSupportHardDecode", "supportHardDecode$delegate", "supportHardEncode", "getSupportHardEncode", "setSupportHardEncode", "supportHardEncode$delegate", "syncSurfaceDestroy", "getSyncSurfaceDestroy", "setSyncSurfaceDestroy", "syncSurfaceDestroy$delegate", "v8RawPointer", "Lkotlin/Function0;", "Lcom/tencent/magicbrush/V8RawPointer;", "getV8RawPointer", "()Lkotlin/jvm/functions/Function0;", "setV8RawPointer", "(Lkotlin/jvm/functions/Function0;)V", "getImageHandler", "Lcom/github/henryye/nativeiv/BaseImageDecodeService;", "", "dls", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "A", "ImageHandlerConfig", "lib-magicbrush-nano_release"})
public class f
{
  public Context context;
  public com.tencent.magicbrush.handler.a cwW;
  public d.g.a.a<ah> cwX;
  private final f.a cwY;
  public final f.a cwZ;
  public final f.a cxA;
  private final f.a cxB;
  private final f.a cxC;
  final MBRuntime.MBParams cxD;
  public final f.a cxa;
  public final f.a cxb;
  public final f.a cxc;
  public final b cxd;
  public IMBFontHandler cxe;
  private final f.a cxf;
  public final f.a cxg;
  public final f.a cxh;
  private final f.a cxi;
  public final f.a cxj;
  private final f.a cxk;
  private final f.a cxl;
  private final f.a cxm;
  public final f.a cxn;
  private final f.a cxo;
  public final f.a cxp;
  public boolean cxq;
  public boolean cxr;
  public final f.a cxs;
  public final f.a cxt;
  public final f.a cxu;
  public final f.a cxv;
  private final f.a cxw;
  private final f.a cxx;
  private final f.a cxy;
  public final f.a cxz;
  
  static
  {
    AppMethodBeat.i(140174);
    cwV = new d.l.k[] { (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "devicePixelRatio", "getDevicePixelRatio()F")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "canvasWidth", "getCanvasWidth()I")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "canvasHeight", "getCanvasHeight()I")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "fileSystem", "getFileSystem()Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "assetManager", "getAssetManager()Landroid/content/res/AssetManager;")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "animationFrameHandlerStrategy", "getAnimationFrameHandlerStrategy()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "enableAntialias", "getEnableAntialias()Z")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "enableOpenGL3", "getEnableOpenGL3()Z")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "enableCommandBuffer", "getEnableCommandBuffer()Z")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "enableGfx", "getEnableGfx()Z")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "gcFactor", "getGcFactor()F")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "enableRequestAnimationFrame", "getEnableRequestAnimationFrame()Z")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "enableWxBindCanvasTexture", "getEnableWxBindCanvasTexture()Z")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "enable2d", "getEnable2d()Z")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "enableWindowAttributesAlpha", "getEnableWindowAttributesAlpha()Z")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "adjustThreadPriority", "getAdjustThreadPriority()Z")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "cmdPoolType", "getCmdPoolType()I")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "revertCpuOptimizerTest", "getRevertCpuOptimizerTest()Z")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "isGame", "isGame()Z")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "enableFontBatch", "getEnableFontBatch()Z")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "sdcardPath", "getSdcardPath()Ljava/lang/String;")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "enableSwitchThreadNativeForAsyncJsApis", "getEnableSwitchThreadNativeForAsyncJsApis()Z")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "syncSurfaceDestroy", "getSyncSurfaceDestroy()Z")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "supportGfxImageShareTexture", "getSupportGfxImageShareTexture()Z")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "supportClientVertexBuffer", "getSupportClientVertexBuffer()Z")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "supportHardEncode", "getSupportHardEncode()Z")), (d.l.k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(f.class), "supportHardDecode", "getSupportHardDecode()Z")) };
    AppMethodBeat.o(140174);
  }
  
  public f()
  {
    AppMethodBeat.i(140186);
    this.cwY = new f.a(this, m.cxK);
    this.cwZ = new f.a(this, k.cxK);
    this.cxa = new f.a(this, j.cxK);
    this.cxb = new f.a(this, x.cxK);
    this.cxc = new f.a(this, i.cxK);
    this.cxd = new b();
    this.cxf = new f.a(this, h.cxK);
    this.cxg = new f.a(this, o.cxK);
    this.cxh = new f.a(this, s.cxK);
    this.cxi = new f.a(this, p.cxK);
    this.cxj = new f.a(this, r.cxK);
    this.cxk = new f.a(this, y.cxK);
    this.cxl = new f.a(this, t.cxK);
    this.cxm = new f.a(this, w.cxK);
    this.cxn = new f.a(this, n.cxK);
    this.cxo = new f.a(this, v.cxK);
    this.cxp = new f.a(this, g.cxK);
    this.cxq = true;
    this.cxr = true;
    this.cxs = new f.a(this, l.cxK);
    this.cxt = new f.a(this, aa.cxK);
    this.cxu = new f.a(this, z.cxK);
    this.cxv = new f.a(this, q.cxK);
    this.cxw = new f.a(this, ab.cxK);
    this.cxx = new f.a(this, u.cxK);
    this.cxy = new f.a(this, ag.cxK);
    this.cxz = new f.a(this, ad.cxK);
    this.cxA = new f.a(this, ac.cxK);
    this.cxB = new f.a(this, af.cxK);
    this.cxC = new f.a(this, ae.cxK);
    this.cxD = new MBRuntime.MBParams();
    AppMethodBeat.o(140186);
  }
  
  public final int Hp()
  {
    AppMethodBeat.i(140177);
    int i = ((Number)this.cwZ.a(cwV[1])).intValue();
    AppMethodBeat.o(140177);
    return i;
  }
  
  public final int Hq()
  {
    AppMethodBeat.i(140178);
    int i = ((Number)this.cxa.a(cwV[2])).intValue();
    AppMethodBeat.o(140178);
    return i;
  }
  
  public final AssetManager Hr()
  {
    AppMethodBeat.i(140179);
    AssetManager localAssetManager = (AssetManager)this.cxc.a(cwV[4]);
    AppMethodBeat.o(140179);
    return localAssetManager;
  }
  
  public final a.b Hs()
  {
    AppMethodBeat.i(140180);
    a.b localb = (a.b)this.cxf.a(cwV[5]);
    AppMethodBeat.o(140180);
    return localb;
  }
  
  public final float Ht()
  {
    AppMethodBeat.i(140182);
    float f = ((Number)this.cxk.a(cwV[10])).floatValue();
    AppMethodBeat.o(140182);
    return f;
  }
  
  public final void a(d.g.a.b<? super b, d.z> paramb)
  {
    AppMethodBeat.i(215112);
    d.g.b.p.h(paramb, "dls");
    paramb.invoke(this.cxd);
    AppMethodBeat.o(215112);
  }
  
  public final void ad(float paramFloat)
  {
    AppMethodBeat.i(140176);
    this.cwY.a(cwV[0], Float.valueOf(paramFloat));
    AppMethodBeat.o(140176);
  }
  
  public final void ae(float paramFloat)
  {
    AppMethodBeat.i(140183);
    this.cxk.a(cwV[10], Float.valueOf(paramFloat));
    AppMethodBeat.o(140183);
  }
  
  public final void b(a.b paramb)
  {
    AppMethodBeat.i(140181);
    d.g.b.p.h(paramb, "<set-?>");
    this.cxf.a(cwV[5], paramb);
    AppMethodBeat.o(140181);
  }
  
  public final void bO(boolean paramBoolean)
  {
    AppMethodBeat.i(215113);
    this.cxi.a(cwV[8], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(215113);
  }
  
  public final void bP(boolean paramBoolean)
  {
    AppMethodBeat.i(140184);
    this.cxm.a(cwV[12], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(140184);
  }
  
  public final void bQ(boolean paramBoolean)
  {
    AppMethodBeat.i(140185);
    this.cxo.a(cwV[14], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(140185);
  }
  
  public final void bR(boolean paramBoolean)
  {
    AppMethodBeat.i(182578);
    this.cxx.a(cwV[21], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(182578);
  }
  
  public final void bS(boolean paramBoolean)
  {
    AppMethodBeat.i(215115);
    this.cxy.a(cwV[22], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(215115);
  }
  
  public final void bT(boolean paramBoolean)
  {
    AppMethodBeat.i(215116);
    this.cxB.a(cwV[25], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(215116);
  }
  
  public final void bU(boolean paramBoolean)
  {
    AppMethodBeat.i(215117);
    this.cxC.a(cwV[26], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(215117);
  }
  
  public final void dB(String paramString)
  {
    AppMethodBeat.i(215114);
    d.g.b.p.h(paramString, "<set-?>");
    this.cxw.a(cwV[20], paramString);
    AppMethodBeat.o(215114);
  }
  
  public final float getDevicePixelRatio()
  {
    AppMethodBeat.i(140175);
    float f = ((Number)this.cwY.a(cwV[0])).floatValue();
    AppMethodBeat.o(140175);
    return f;
  }
  
  @d.l(gfx={1, 1, 13}, gfy={""}, gfz={"Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;", "", "()V", "decodeSlaveForDefault", "Lcom/github/henryye/nativeiv/api/IImageDecodeService$BitmapDecodeSlave;", "getDecodeSlaveForDefault", "()Lcom/github/henryye/nativeiv/api/IImageDecodeService$BitmapDecodeSlave;", "setDecodeSlaveForDefault", "(Lcom/github/henryye/nativeiv/api/IImageDecodeService$BitmapDecodeSlave;)V", "enableDefaultImageHandler", "", "getEnableDefaultImageHandler", "()Z", "setEnableDefaultImageHandler", "(Z)V", "imageDecoderForDefault", "", "Lcom/github/henryye/nativeiv/stream/IImageStreamFetcher;", "getImageDecoderForDefault", "()Ljava/util/List;", "setImageDecoderForDefault", "(Ljava/util/List;)V", "imageHandler", "Lcom/github/henryye/nativeiv/BaseImageDecodeService;", "getImageHandler", "()Lcom/github/henryye/nativeiv/BaseImageDecodeService;", "setImageHandler", "(Lcom/github/henryye/nativeiv/BaseImageDecodeService;)V", "reporterForDefault", "Lcom/github/henryye/nativeiv/delegate/ReportDelegate$IKvReport;", "getReporterForDefault", "()Lcom/github/henryye/nativeiv/delegate/ReportDelegate$IKvReport;", "setReporterForDefault", "(Lcom/github/henryye/nativeiv/delegate/ReportDelegate$IKvReport;)V", "lib-magicbrush-nano_release"})
  public static final class b
  {
    public boolean cxF;
    public List<com.github.henryye.nativeiv.b.b> cxG;
    public c.b cxH;
    public IImageDecodeService.a cxI;
    public BaseImageDecodeService cxJ;
    
    public b()
    {
      AppMethodBeat.i(140099);
      this.cxF = true;
      this.cxG = ((List)new ArrayList());
      AppMethodBeat.o(140099);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.f
 * JD-Core Version:    0.7.0.1
 */