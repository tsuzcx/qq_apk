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
import com.tencent.magicbrush.utils.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.BufferURLManager;
import d.ac;
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gjZ={1, 1, 13}, gka={""}, gkb={"Lcom/tencent/magicbrush/MagicBrush;", "Lcom/tencent/magicbrush/MBRuntime;", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "(Lcom/tencent/magicbrush/MagicBrushBuilder;)V", "bufferURLManager", "Lcom/tencent/mm/appbrand/v8/BufferURLManager;", "getBufferURLManager", "()Lcom/tencent/mm/appbrand/v8/BufferURLManager;", "canvasHandler", "Lcom/tencent/magicbrush/MBCanvasHandler;", "getCanvasHandler", "()Lcom/tencent/magicbrush/MBCanvasHandler;", "config", "Lcom/tencent/magicbrush/MagicBrushConfig;", "getConfig", "()Lcom/tencent/magicbrush/MagicBrushConfig;", "firstFrameListeners", "Lcom/tencent/magicbrush/utils/ListenerList;", "Lcom/tencent/magicbrush/MagicBrush$FirstFrameListener;", "getFirstFrameListeners", "()Lcom/tencent/magicbrush/utils/ListenerList;", "jsStuffListeners", "Lcom/tencent/magicbrush/MagicBrush$JSStuffListener;", "getJSStuffListeners", "viewManager", "Lcom/tencent/magicbrush/ui/MBViewManager;", "getViewManager", "()Lcom/tencent/magicbrush/ui/MBViewManager;", "bindTo", "", "fn", "Lkotlin/Function0;", "Lcom/tencent/magicbrush/V8RawPointer;", "isolatePtr", "", "contextPtr", "uvLoopPtr", "destroy", "lazyLoadBox2D", "setAnimationFrameHandler", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "Companion", "FirstFrameListener", "ImageDecodeListener", "JSStuffListener", "lib-magicbrush-nano_release"})
public final class d
  extends MBRuntime
{
  public static final a cxt;
  public final f cxn;
  public final BufferURLManager cxo;
  public final com.tencent.magicbrush.utils.c<d> cxp;
  public final com.tencent.magicbrush.utils.c<b> cxq;
  public final MBViewManager cxr;
  public final b cxs;
  
  static
  {
    AppMethodBeat.i(140097);
    cxt = new a((byte)0);
    AppMethodBeat.o(140097);
  }
  
  private d(e parame)
  {
    AppMethodBeat.i(140096);
    this.cxn = ((f)parame);
    this.cxo = new BufferURLManager();
    this.cxp = new com.tencent.magicbrush.utils.c();
    this.cxq = new com.tencent.magicbrush.utils.c();
    this.cxr = new MBViewManager();
    this.cxs = new b(this);
    this.cwT = parame.cyk;
    this.mNativeInst = nativeCreate(this.cwT);
    nativeSetEventListener(this.mNativeInst, new EventDispatcher(this));
    Object localObject = parame.cxB;
    if (localObject == null) {
      p.gkB();
    }
    a((com.tencent.magicbrush.handler.a)localObject);
    localObject = parame.cxI.cyq;
    if (localObject != null) {
      ((BaseImageDecodeService)localObject).addDecodeEventListener((IImageDecodeService.b)new c());
    }
    a((BaseImageDecodeService)localObject);
    a(parame.cxJ);
    Hi();
    parame = parame.cxC;
    if (parame == null) {
      p.gkB();
    }
    d(parame);
    parame = (CharSequence)this.cxn.cyi;
    if ((parame == null) || (parame.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        m((Runnable)new g(this));
      }
      AppMethodBeat.o(140096);
      return;
    }
  }
  
  protected final b Hq()
  {
    return this.cxs;
  }
  
  protected final MBViewManager Hr()
  {
    return this.cxr;
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(140095);
    p.h(paramb, "strategy");
    if (this.cxa != null) {}
    for (int i = 1; (ac.Nhs) && (i == 0); i = 0)
    {
      paramb = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(140095);
      throw paramb;
    }
    if (this.cxa.HM() == paramb)
    {
      AppMethodBeat.o(140095);
      return;
    }
    c.c.i("MagicBrush", "MagicBrush is changing AnimationFrameHandler strategy from " + this.cxa.HM() + ' ' + "to " + paramb, new Object[0]);
    Object localObject = com.tencent.magicbrush.ui.a.cAr;
    localObject = (MBRuntime)this;
    com.tencent.magicbrush.handler.c localc = Ht();
    p.g(localc, "jsThreadHandler");
    m((Runnable)new h(this, a.a.a((MBRuntime)localObject, localc, paramb)));
    AppMethodBeat.o(140095);
  }
  
  public final void d(final d.g.a.a<ai> parama)
  {
    AppMethodBeat.i(140093);
    p.h(parama, "fn");
    m((Runnable)new e(this, parama));
    AppMethodBeat.o(140093);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(140094);
    c.c.i("MagicBrush", "MagicBrush is destroying...", new Object[0]);
    super.destroy();
    this.cxr.clear$lib_magicbrush_nano_release();
    this.cxp.clear();
    this.cxq.clear();
    this.cxo.destroy();
    c.c.i("MagicBrush", "MagicBrush is destroying...[done]", new Object[0]);
    AppMethodBeat.o(140094);
  }
  
  @l(gjZ={1, 1, 13}, gka={""}, gkb={"Lcom/tencent/magicbrush/MagicBrush$Companion;", "", "()V", "DEFAULT_WINDOW_ID", "", "TAG", "", "create", "Lcom/tencent/magicbrush/MagicBrush;", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "dls", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "lib-magicbrush-nano_release"})
  public static final class a
  {
    public static d b(e parame)
    {
      AppMethodBeat.i(213323);
      p.h(parame, "builder");
      if (!com.tencent.magicbrush.internal.a.d(parame))
      {
        AppMethodBeat.o(213323);
        return null;
      }
      parame = new d(parame, (byte)0);
      AppMethodBeat.o(213323);
      return parame;
    }
  }
  
  @l(gjZ={1, 1, 13}, gka={""}, gkb={"Lcom/tencent/magicbrush/MagicBrush$FirstFrameListener;", "", "onFirstFrame", "", "lib-magicbrush-nano_release"})
  public static abstract interface b
  {
    public abstract void onFirstFrame();
  }
  
  @l(gjZ={1, 1, 13}, gka={""}, gkb={"Lcom/tencent/magicbrush/MagicBrush$ImageDecodeListener;", "Lcom/github/henryye/nativeiv/api/IImageDecodeService$IDecodeEventListener;", "(Lcom/tencent/magicbrush/MagicBrush;)V", "onDecodeEvent", "", "path", "", "event", "Lcom/github/henryye/nativeiv/api/IImageDecodeService$IDecodeEventListener$Event;", "decodeInfo", "Lcom/github/henryye/nativeiv/api/DecodeInfo;", "onDecodeResult", "image", "", "recycleHandler", "Lcom/github/henryye/nativeiv/api/IImageDecodeService$IRecycleHandler;", "config", "Lcom/github/henryye/nativeiv/ImageDecodeConfig;", "lib-magicbrush-nano_release"})
  final class c
    implements IImageDecodeService.b
  {
    public final void a(String paramString, IImageDecodeService.b.a parama, com.github.henryye.nativeiv.api.a parama1)
    {
      AppMethodBeat.i(140088);
      p.h(paramString, "path");
      p.h(parama, "event");
      p.h(parama1, "decodeInfo");
      AppMethodBeat.o(140088);
    }
    
    public final void a(String paramString, Object paramObject, IImageDecodeService.c paramc, ImageDecodeConfig paramImageDecodeConfig)
    {
      AppMethodBeat.i(140089);
      p.h(paramString, "path");
      p.h(paramc, "recycleHandler");
      p.h(paramImageDecodeConfig, "config");
      this.cxu.b(paramString, paramObject, paramc, paramImageDecodeConfig);
      AppMethodBeat.o(140089);
    }
  }
  
  @l(gjZ={1, 1, 13}, gka={""}, gkb={"Lcom/tencent/magicbrush/MagicBrush$JSStuffListener;", "", "onConsole", "", "output", "", "onJSError", "exception", "stack", "contextId", "", "lib-magicbrush-nano_release"})
  public static abstract interface d
  {
    public abstract void onConsole(String paramString);
    
    public abstract void onJSError(String paramString1, String paramString2, int paramInt);
  }
  
  @l(gjZ={1, 1, 13}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(d paramd, d.g.a.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(140090);
      ai localai = (ai)parama.invoke();
      this.cxu.nativeBindTo(this.cxu.mNativeInst, localai.cys, localai.cyt, localai.cyu);
      this.cxu.cxo.bindTo(localai.cys, localai.cyt);
      AppMethodBeat.o(140090);
    }
  }
  
  @l(gjZ={1, 1, 13}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/magicbrush/V8RawPointer;", "invoke"})
  public static final class f
    extends q
    implements d.g.a.a<ai>
  {
    public f(long paramLong1, long paramLong2, long paramLong3)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 13}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(213324);
      long l1 = h.HQ();
      com.tencent.magicbrush.a.b.loadLibrary("mmbox2d");
      long l2 = h.HQ();
      this.cxu.nativeLazyLoadBox2D(this.cxu.mNativeInst, this.cxu.cxn.cyi);
      c.c.i("MagicBrush", "lazy load box2d loadCost: %d bindCost: %d", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(h.aO(l2)) });
      AppMethodBeat.o(213324);
    }
  }
  
  @l(gjZ={1, 1, 13}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(d paramd, com.tencent.magicbrush.ui.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(140092);
      com.tencent.magicbrush.ui.a locala = this.cxu.cxa;
      this.cxu.cxa.pause();
      this.cxu.cxa = this.cxz;
      this.cxu.cxa.resume();
      locala.destroy();
      AppMethodBeat.o(140092);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.d
 * JD-Core Version:    0.7.0.1
 */