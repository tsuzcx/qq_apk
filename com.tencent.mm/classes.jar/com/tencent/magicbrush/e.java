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
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/magicbrush/MagicBrush;", "Lcom/tencent/magicbrush/MBRuntime;", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "(Lcom/tencent/magicbrush/MagicBrushBuilder;)V", "canvasHandler", "Lcom/tencent/magicbrush/MBCanvasHandler;", "getCanvasHandler", "()Lcom/tencent/magicbrush/MBCanvasHandler;", "config", "Lcom/tencent/magicbrush/MagicBrushConfig;", "getConfig", "()Lcom/tencent/magicbrush/MagicBrushConfig;", "firstFrameListeners", "Lcom/tencent/magicbrush/utils/ListenerList;", "Lcom/tencent/magicbrush/MagicBrush$FirstFrameListener;", "getFirstFrameListeners", "()Lcom/tencent/magicbrush/utils/ListenerList;", "jsStuffListeners", "Lcom/tencent/magicbrush/MagicBrush$JSStuffListener;", "getJSStuffListeners", "viewManager", "Lcom/tencent/magicbrush/ui/MBViewManager;", "getViewManager", "()Lcom/tencent/magicbrush/ui/MBViewManager;", "bindTo", "", "fn", "Lkotlin/Function0;", "Lcom/tencent/magicbrush/V8RawPointer;", "isolatePtr", "", "contextPtr", "uvLoopPtr", "destroy", "lazyLoadSync", "name", "", "setAnimationFrameHandler", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "Companion", "FirstFrameListener", "ImageDecodeListener", "JSStuffListener", "lib-magicbrush-nano_release"})
public final class e
  extends MBRuntime
{
  public static final a cLB;
  public final b cLA;
  public final g cLw;
  public final com.tencent.magicbrush.utils.c<d> cLx;
  public final com.tencent.magicbrush.utils.c<b> cLy;
  public final MBViewManager cLz;
  
  static
  {
    AppMethodBeat.i(140097);
    cLB = new a((byte)0);
    AppMethodBeat.o(140097);
  }
  
  private e(f paramf)
  {
    AppMethodBeat.i(140096);
    this.cLw = ((g)paramf);
    this.cLx = new com.tencent.magicbrush.utils.c();
    this.cLy = new com.tencent.magicbrush.utils.c();
    this.cLz = new MBViewManager();
    this.cLA = new b(this);
    this.cLb = paramf.cMr;
    this.mNativeInst = nativeCreate(this.cLb);
    nativeSetEventListener(this.mNativeInst, new EventDispatcher(this));
    Object localObject = paramf.cLJ;
    if (localObject == null) {
      p.hyc();
    }
    a((com.tencent.magicbrush.handler.a)localObject);
    localObject = paramf.cLQ.cMx;
    if (localObject != null) {
      ((BaseImageDecodeService)localObject).addDecodeEventListener((IImageDecodeService.b)new c());
    }
    a((BaseImageDecodeService)localObject);
    a(paramf.cLR);
    Rb();
    paramf = paramf.cLK;
    if (paramf == null) {
      p.hyc();
    }
    d(paramf);
    AppMethodBeat.o(140096);
  }
  
  protected final b Ri()
  {
    return this.cLA;
  }
  
  protected final MBViewManager Rj()
  {
    return this.cLz;
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(140095);
    p.h(paramb, "strategy");
    if (this.cLj != null) {}
    for (int i = 1; (aa.SXc) && (i == 0); i = 0)
    {
      paramb = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(140095);
      throw paramb;
    }
    if (this.cLj.RB() == paramb)
    {
      AppMethodBeat.o(140095);
      return;
    }
    c.c.i("MagicBrush", "MagicBrush is changing AnimationFrameHandler strategy from " + this.cLj.RB() + ' ' + "to " + paramb, new Object[0]);
    Object localObject = com.tencent.magicbrush.ui.a.cOx;
    localObject = (MBRuntime)this;
    com.tencent.magicbrush.handler.c localc = Rl();
    p.g(localc, "jsThreadHandler");
    m((Runnable)new g(this, a.a.a((MBRuntime)localObject, localc, paramb)));
    AppMethodBeat.o(140095);
  }
  
  public final void d(final kotlin.g.a.a<aj> parama)
  {
    AppMethodBeat.i(140093);
    p.h(parama, "fn");
    m((Runnable)new e(this, parama));
    AppMethodBeat.o(140093);
  }
  
  public final void dX(String paramString)
  {
    AppMethodBeat.i(206821);
    p.h(paramString, "name");
    c.c.i("MagicBrush", "hy: trigger load ".concat(String.valueOf(paramString)), new Object[0]);
    com.tencent.magicbrush.a.b.loadLibrary(paramString);
    String str = com.tencent.magicbrush.a.b.dZ(paramString);
    if (str != null) {
      if (((CharSequence)str).length() != 0) {
        break label102;
      }
    }
    label102:
    for (int i = 1; i != 0; i = 0)
    {
      c.c.e("MagicBrush", "hy: can not find " + paramString + " path", new Object[0]);
      AppMethodBeat.o(206821);
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
        AppMethodBeat.o(206821);
        return;
      } while (!paramString.equals("mmphysx"));
      nativeLazyLoadPhysx(this.mNativeInst, str);
      AppMethodBeat.o(206821);
      return;
    } while (!paramString.equals("mmbox2d"));
    nativeLazyLoadBox2D(this.mNativeInst, str);
    AppMethodBeat.o(206821);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(140094);
    c.c.i("MagicBrush", "MagicBrush is destroying...", new Object[0]);
    super.destroy();
    this.cLz.clear$lib_magicbrush_nano_release();
    this.cLx.clear();
    this.cLy.clear();
    c.c.i("MagicBrush", "MagicBrush is destroying...[done]", new Object[0]);
    AppMethodBeat.o(140094);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/magicbrush/MagicBrush$Companion;", "", "()V", "DEFAULT_WINDOW_ID", "", "TAG", "", "create", "Lcom/tencent/magicbrush/MagicBrush;", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "dls", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "lib-magicbrush-nano_release"})
  public static final class a
  {
    public static e b(f paramf)
    {
      AppMethodBeat.i(206820);
      p.h(paramf, "builder");
      if (!com.tencent.magicbrush.internal.a.d(paramf))
      {
        AppMethodBeat.o(206820);
        return null;
      }
      paramf = new e(paramf, (byte)0);
      AppMethodBeat.o(206820);
      return paramf;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/magicbrush/MagicBrush$FirstFrameListener;", "", "onFirstFrame", "", "lib-magicbrush-nano_release"})
  public static abstract interface b
  {
    public abstract void onFirstFrame();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/magicbrush/MagicBrush$ImageDecodeListener;", "Lcom/github/henryye/nativeiv/api/IImageDecodeService$IDecodeEventListener;", "(Lcom/tencent/magicbrush/MagicBrush;)V", "onDecodeEvent", "", "path", "", "event", "Lcom/github/henryye/nativeiv/api/IImageDecodeService$IDecodeEventListener$Event;", "decodeInfo", "Lcom/github/henryye/nativeiv/api/DecodeInfo;", "onDecodeResult", "image", "", "recycleHandler", "Lcom/github/henryye/nativeiv/api/IImageDecodeService$IRecycleHandler;", "config", "Lcom/github/henryye/nativeiv/ImageDecodeConfig;", "lib-magicbrush-nano_release"})
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
      this.cLC.b(paramString, paramObject, paramc, paramImageDecodeConfig);
      AppMethodBeat.o(140089);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/magicbrush/MagicBrush$JSStuffListener;", "", "onConsole", "", "output", "", "onJSError", "exception", "stack", "contextId", "", "lib-magicbrush-nano_release"})
  public static abstract interface d
  {
    public abstract void onConsole(String paramString);
    
    public abstract void onJSError(String paramString1, String paramString2, int paramInt);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(e parame, kotlin.g.a.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(140090);
      aj localaj = (aj)parama.invoke();
      this.cLC.nativeBindTo(this.cLC.mNativeInst, localaj.cMz, localaj.cMA, localaj.cMB);
      AppMethodBeat.o(140090);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/magicbrush/V8RawPointer;", "invoke"})
  public static final class f
    extends q
    implements kotlin.g.a.a<aj>
  {
    public f(long paramLong1, long paramLong2, long paramLong3)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(e parame, com.tencent.magicbrush.ui.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(140092);
      com.tencent.magicbrush.ui.a locala = this.cLC.cLj;
      this.cLC.cLj.pause();
      this.cLC.cLj = this.cLH;
      this.cLC.cLj.resume();
      locala.destroy();
      AppMethodBeat.o(140092);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.magicbrush.e
 * JD-Core Version:    0.7.0.1
 */