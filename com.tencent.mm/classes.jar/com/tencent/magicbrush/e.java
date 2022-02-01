package com.tencent.magicbrush;

import com.github.henryye.nativeiv.BaseImageDecodeService;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.api.IImageDecodeService.b;
import com.github.henryye.nativeiv.api.IImageDecodeService.b.a;
import com.github.henryye.nativeiv.api.IImageDecodeService.c;
import com.tencent.magicbrush.a.c.c;
import com.tencent.magicbrush.internal.EventDispatcher;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.a.a;
import com.tencent.magicbrush.ui.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ak;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/MagicBrush;", "Lcom/tencent/magicbrush/MBRuntime;", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "(Lcom/tencent/magicbrush/MagicBrushBuilder;)V", "canvasHandler", "Lcom/tencent/magicbrush/MBCanvasHandler;", "getCanvasHandler", "()Lcom/tencent/magicbrush/MBCanvasHandler;", "config", "Lcom/tencent/magicbrush/MagicBrushConfig;", "getConfig", "()Lcom/tencent/magicbrush/MagicBrushConfig;", "firstFrameListeners", "Lcom/tencent/magicbrush/utils/ListenerList;", "Lcom/tencent/magicbrush/MagicBrush$FirstFrameListener;", "getFirstFrameListeners", "()Lcom/tencent/magicbrush/utils/ListenerList;", "jsStuffListeners", "Lcom/tencent/magicbrush/MagicBrush$JSStuffListener;", "getJSStuffListeners", "screenCanvasDelegate", "Lcom/tencent/magicbrush/MagicBrush$ScreenCanvasDelegate;", "getScreenCanvasDelegate", "()Lcom/tencent/magicbrush/MagicBrush$ScreenCanvasDelegate;", "viewManager", "Lcom/tencent/magicbrush/ui/MBViewManager;", "getViewManager", "()Lcom/tencent/magicbrush/ui/MBViewManager;", "bindTo", "", "fn", "Lkotlin/Function0;", "Lcom/tencent/magicbrush/V8RawPointer;", "isolatePtr", "", "contextPtr", "uvLoopPtr", "destroy", "lazyLoadSync", "name", "", "setAnimationFrameHandler", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "updateParams", "useCommandBuffer", "", "Companion", "FirstFrameListener", "ImageDecodeListener", "JSStuffListener", "ScreenCanvasDelegate", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 16})
public final class e
  extends MBRuntime
{
  public static final e.a eHG;
  public final g eHA;
  public final com.tencent.magicbrush.utils.c<e.d> eHB;
  public final com.tencent.magicbrush.utils.c<e.b> eHC;
  public final MBViewManager eHD;
  public final b eHE;
  private final e eHF;
  
  static
  {
    AppMethodBeat.i(140097);
    eHG = new e.a((byte)0);
    AppMethodBeat.o(140097);
  }
  
  private e(f paramf)
  {
    AppMethodBeat.i(140096);
    this.eHA = ((g)paramf);
    this.eHB = new com.tencent.magicbrush.utils.c();
    this.eHC = new com.tencent.magicbrush.utils.c();
    this.eHD = new MBViewManager();
    this.eHE = new b(this);
    this.eHg = paramf.eIz;
    this.mNativeInst = nativeCreate(this.eHg);
    nativeSetEventListener(this.mNativeInst, new EventDispatcher(this));
    Object localObject = paramf.eHN;
    if (localObject == null) {
      s.klw();
    }
    a((com.tencent.magicbrush.handler.a)localObject);
    localObject = paramf.eHU.eIF;
    if (localObject != null) {
      ((BaseImageDecodeService)localObject).addDecodeEventListener((IImageDecodeService.b)new c());
    }
    a((BaseImageDecodeService)localObject);
    a(paramf.eHV);
    this.eHF = paramf.eHF;
    avk();
    paramf = paramf.eHO;
    if (paramf == null) {
      s.klw();
    }
    v(paramf);
    AppMethodBeat.o(140096);
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(140095);
    s.t(paramb, "strategy");
    if (this.eHn != null) {}
    for (int i = 1; (ak.aiuY) && (i == 0); i = 0)
    {
      paramb = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(140095);
      throw paramb;
    }
    if (this.eHn.avR() == paramb)
    {
      AppMethodBeat.o(140095);
      return;
    }
    c.c.i("MagicBrush", "MagicBrush is changing AnimationFrameHandler strategy from " + this.eHn.avR() + ' ' + "to " + paramb, new Object[0]);
    Object localObject = com.tencent.magicbrush.ui.a.eKr;
    localObject = (MBRuntime)this;
    com.tencent.magicbrush.handler.c localc = avw();
    s.r(localc, "jsThreadHandler");
    q((Runnable)new h(this, a.a.a((MBRuntime)localObject, localc, paramb)));
    AppMethodBeat.o(140095);
  }
  
  protected final b avs()
  {
    return this.eHE;
  }
  
  protected final MBViewManager avt()
  {
    return this.eHD;
  }
  
  protected final e avu()
  {
    return this.eHF;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(140094);
    c.c.i("MagicBrush", "MagicBrush is destroying...", new Object[0]);
    super.destroy();
    this.eHD.clear$lib_magicbrush_nano_release();
    this.eHB.clear();
    this.eHC.clear();
    c.c.i("MagicBrush", "MagicBrush is destroying...[done]", new Object[0]);
    AppMethodBeat.o(140094);
  }
  
  public final void dh(boolean paramBoolean)
  {
    AppMethodBeat.i(228881);
    this.eHg.use_command_buffer = paramBoolean;
    nativeUpdateParams(this.mNativeInst, paramBoolean);
    AppMethodBeat.o(228881);
  }
  
  public final void fV(String paramString)
  {
    AppMethodBeat.i(228888);
    s.t(paramString, "name");
    c.c.i("MagicBrush", "hy: trigger load ".concat(String.valueOf(paramString)), new Object[0]);
    com.tencent.magicbrush.a.b.loadLibrary(paramString);
    String str = com.tencent.magicbrush.a.b.fX(paramString);
    if (str != null) {
      if (((CharSequence)str).length() != 0) {
        break label102;
      }
    }
    label102:
    for (int i = 1; i != 0; i = 0)
    {
      c.c.e("MagicBrush", "hy: can not find " + paramString + " path", new Object[0]);
      AppMethodBeat.o(228888);
      return;
    }
    switch (paramString.hashCode())
    {
    }
    do
    {
      do
      {
        c.c.e("MagicBrush", "hy: not support", new Object[0]);
        AppMethodBeat.o(228888);
        return;
      } while (!paramString.equals("mmphysx"));
      nativeLazyLoadPhysx(this.mNativeInst, str);
      AppMethodBeat.o(228888);
      return;
    } while (!paramString.equals("mmbox2d"));
    nativeLazyLoadBox2D(this.mNativeInst, str);
    AppMethodBeat.o(228888);
  }
  
  public final void v(kotlin.g.a.a<an> parama)
  {
    AppMethodBeat.i(140093);
    s.t(parama, "fn");
    q((Runnable)new e.f(this, parama));
    AppMethodBeat.o(140093);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/MagicBrush$ImageDecodeListener;", "Lcom/github/henryye/nativeiv/api/IImageDecodeService$IDecodeEventListener;", "(Lcom/tencent/magicbrush/MagicBrush;)V", "onDecodeEvent", "", "path", "", "event", "Lcom/github/henryye/nativeiv/api/IImageDecodeService$IDecodeEventListener$Event;", "decodeInfo", "Lcom/github/henryye/nativeiv/api/DecodeInfo;", "onDecodeResult", "image", "", "recycleHandler", "Lcom/github/henryye/nativeiv/api/IImageDecodeService$IRecycleHandler;", "config", "Lcom/github/henryye/nativeiv/ImageDecodeConfig;", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 16})
  final class c
    implements IImageDecodeService.b
  {
    public final void a(String paramString, IImageDecodeService.b.a parama, com.github.henryye.nativeiv.api.a parama1)
    {
      AppMethodBeat.i(140088);
      s.t(paramString, "path");
      s.t(parama, "event");
      s.t(parama1, "decodeInfo");
      AppMethodBeat.o(140088);
    }
    
    public final void a(String paramString, Object paramObject, IImageDecodeService.c paramc, ImageDecodeConfig paramImageDecodeConfig)
    {
      AppMethodBeat.i(140089);
      s.t(paramString, "path");
      s.t(paramc, "recycleHandler");
      s.t(paramImageDecodeConfig, "config");
      this.eHH.b(paramString, paramObject, paramc, paramImageDecodeConfig);
      AppMethodBeat.o(140089);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/MagicBrush$ScreenCanvasDelegate;", "", "onCreateView", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "onInsertView", "", "view", "left", "", "top", "width", "height", "z_index", "onRemoveView", "onUpdateView", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 16})
  public static abstract interface e
  {
    public abstract void a(MagicBrushView paramMagicBrushView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
    
    public abstract MagicBrushView avy();
    
    public abstract void b(MagicBrushView paramMagicBrushView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
    
    public abstract void c(MagicBrushView paramMagicBrushView);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
  static final class h
    implements Runnable
  {
    h(e parame, com.tencent.magicbrush.ui.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(140092);
      com.tencent.magicbrush.ui.a locala = this.eHH.eHn;
      this.eHH.eHn.pause();
      this.eHH.eHn = this.eHM;
      this.eHH.eHn.resume();
      locala.destroy();
      AppMethodBeat.o(140092);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.e
 * JD-Core Version:    0.7.0.1
 */