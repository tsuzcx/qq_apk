package com.tencent.magicbrush;

import com.github.henryye.nativeiv.BaseImageDecodeService;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.api.IImageDecodeService.b;
import com.github.henryye.nativeiv.api.IImageDecodeService.b.a;
import com.github.henryye.nativeiv.api.IImageDecodeService.c;
import com.tencent.magicbrush.a.c.c;
import com.tencent.magicbrush.internal.EventDispatcher;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.a.a;
import com.tencent.magicbrush.ui.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.aa;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/magicbrush/MagicBrush;", "Lcom/tencent/magicbrush/MBRuntime;", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "(Lcom/tencent/magicbrush/MagicBrushBuilder;)V", "canvasHandler", "Lcom/tencent/magicbrush/MBCanvasHandler;", "getCanvasHandler", "()Lcom/tencent/magicbrush/MBCanvasHandler;", "config", "Lcom/tencent/magicbrush/MagicBrushConfig;", "getConfig", "()Lcom/tencent/magicbrush/MagicBrushConfig;", "firstFrameListeners", "Lcom/tencent/magicbrush/utils/ListenerList;", "Lcom/tencent/magicbrush/MagicBrush$FirstFrameListener;", "getFirstFrameListeners", "()Lcom/tencent/magicbrush/utils/ListenerList;", "jsStuffListeners", "Lcom/tencent/magicbrush/MagicBrush$JSStuffListener;", "getJSStuffListeners", "viewManager", "Lcom/tencent/magicbrush/ui/MBViewManager;", "getViewManager", "()Lcom/tencent/magicbrush/ui/MBViewManager;", "bindTo", "", "fn", "Lkotlin/Function0;", "Lcom/tencent/magicbrush/V8RawPointer;", "isolatePtr", "", "contextPtr", "uvLoopPtr", "destroy", "setAnimationFrameHandler", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "Companion", "FirstFrameListener", "ImageDecodeListener", "JSStuffListener", "lib-magicbrush-nano_release"})
public final class d
  extends MBRuntime
{
  public static final d.a cph;
  public final f cpc;
  public final com.tencent.magicbrush.utils.c<d> cpd;
  public final com.tencent.magicbrush.utils.c<b> cpe;
  public final MBViewManager cpf;
  public final b cpg;
  
  static
  {
    AppMethodBeat.i(140097);
    cph = new d.a((byte)0);
    AppMethodBeat.o(140097);
  }
  
  private d(e parame)
  {
    AppMethodBeat.i(140096);
    this.cpc = ((f)parame);
    this.coI = parame.cpR;
    this.mNativeInst = nativeCreate(this.coI);
    nativeSetEventListener(this.mNativeInst, new EventDispatcher(this));
    Object localObject = parame.cpo;
    if (localObject == null) {
      k.fvU();
    }
    a((com.tencent.magicbrush.handler.a)localObject);
    localObject = parame.cpv.cpX;
    if (localObject != null) {
      ((BaseImageDecodeService)localObject).addDecodeEventListener((IImageDecodeService.b)new c());
    }
    a((BaseImageDecodeService)localObject);
    a(parame.cpw);
    FY();
    parame = parame.cpp;
    if (parame == null) {
      k.fvU();
    }
    c(parame);
    this.cpd = new com.tencent.magicbrush.utils.c();
    this.cpe = new com.tencent.magicbrush.utils.c();
    this.cpf = new MBViewManager();
    this.cpg = new b(this);
    AppMethodBeat.o(140096);
  }
  
  protected final b Ge()
  {
    return this.cpg;
  }
  
  protected final MBViewManager Gf()
  {
    return this.cpf;
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(140095);
    k.h(paramb, "strategy");
    if (this.coP != null) {}
    for (int i = 1; (aa.JfW) && (i == 0); i = 0)
    {
      paramb = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(140095);
      throw paramb;
    }
    if (this.coP.Gx() == paramb)
    {
      AppMethodBeat.o(140095);
      return;
    }
    c.c.i("MagicBrush", "MagicBrush is changing AnimationFrameHandler strategy from " + this.coP.Gx() + ' ' + "to " + paramb, new Object[0]);
    Object localObject = com.tencent.magicbrush.ui.a.crN;
    localObject = (MBRuntime)this;
    com.tencent.magicbrush.handler.c localc = Gh();
    k.g(localc, "jsThreadHandler");
    l((Runnable)new g(this, a.a.a((MBRuntime)localObject, localc, paramb)));
    AppMethodBeat.o(140095);
  }
  
  public final void c(d.g.a.a<ad> parama)
  {
    AppMethodBeat.i(140093);
    k.h(parama, "fn");
    l((Runnable)new d.e(this, parama));
    AppMethodBeat.o(140093);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(140094);
    c.c.i("MagicBrush", "MagicBrush is destroying...", new Object[0]);
    super.destroy();
    this.cpf.clear$lib_magicbrush_nano_release();
    this.cpd.clear();
    this.cpe.clear();
    c.c.i("MagicBrush", "MagicBrush is destroying...[done]", new Object[0]);
    AppMethodBeat.o(140094);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/magicbrush/MagicBrush$FirstFrameListener;", "", "onFirstFrame", "", "lib-magicbrush-nano_release"})
  public static abstract interface b
  {
    public abstract void onFirstFrame();
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/magicbrush/MagicBrush$ImageDecodeListener;", "Lcom/github/henryye/nativeiv/api/IImageDecodeService$IDecodeEventListener;", "(Lcom/tencent/magicbrush/MagicBrush;)V", "onDecodeEvent", "", "path", "", "event", "Lcom/github/henryye/nativeiv/api/IImageDecodeService$IDecodeEventListener$Event;", "decodeInfo", "Lcom/github/henryye/nativeiv/api/DecodeInfo;", "onDecodeResult", "image", "", "recycleHandler", "Lcom/github/henryye/nativeiv/api/IImageDecodeService$IRecycleHandler;", "config", "Lcom/github/henryye/nativeiv/ImageDecodeConfig;", "lib-magicbrush-nano_release"})
  final class c
    implements IImageDecodeService.b
  {
    public final void a(String paramString, IImageDecodeService.b.a parama, com.github.henryye.nativeiv.api.a parama1)
    {
      AppMethodBeat.i(140088);
      k.h(paramString, "path");
      k.h(parama, "event");
      k.h(parama1, "decodeInfo");
      AppMethodBeat.o(140088);
    }
    
    public final void a(String paramString, Object paramObject, IImageDecodeService.c paramc, ImageDecodeConfig paramImageDecodeConfig)
    {
      AppMethodBeat.i(140089);
      k.h(paramString, "path");
      k.h(paramc, "recycleHandler");
      k.h(paramImageDecodeConfig, "config");
      this.cpi.b(paramString, paramObject, paramc, paramImageDecodeConfig);
      AppMethodBeat.o(140089);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/magicbrush/MagicBrush$JSStuffListener;", "", "onConsole", "", "output", "", "onJSError", "exception", "stack", "contextId", "", "lib-magicbrush-nano_release"})
  public static abstract interface d
  {
    public abstract void onConsole(String paramString);
    
    public abstract void onJSError(String paramString1, String paramString2, int paramInt);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(d paramd, com.tencent.magicbrush.ui.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(140092);
      com.tencent.magicbrush.ui.a locala = this.cpi.coP;
      this.cpi.coP.pause();
      this.cpi.coP = this.cpn;
      this.cpi.coP.resume();
      locala.destroy();
      AppMethodBeat.o(140092);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.d
 * JD-Core Version:    0.7.0.1
 */