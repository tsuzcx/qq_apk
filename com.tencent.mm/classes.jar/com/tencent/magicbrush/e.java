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
import kotlin.g.b.p;
import kotlin.l;
import kotlin.z;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/magicbrush/MagicBrush;", "Lcom/tencent/magicbrush/MBRuntime;", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "(Lcom/tencent/magicbrush/MagicBrushBuilder;)V", "canvasHandler", "Lcom/tencent/magicbrush/MBCanvasHandler;", "getCanvasHandler", "()Lcom/tencent/magicbrush/MBCanvasHandler;", "config", "Lcom/tencent/magicbrush/MagicBrushConfig;", "getConfig", "()Lcom/tencent/magicbrush/MagicBrushConfig;", "firstFrameListeners", "Lcom/tencent/magicbrush/utils/ListenerList;", "Lcom/tencent/magicbrush/MagicBrush$FirstFrameListener;", "getFirstFrameListeners", "()Lcom/tencent/magicbrush/utils/ListenerList;", "jsStuffListeners", "Lcom/tencent/magicbrush/MagicBrush$JSStuffListener;", "getJSStuffListeners", "screenCanvasDelegate", "Lcom/tencent/magicbrush/MagicBrush$ScreenCanvasDelegate;", "getScreenCanvasDelegate", "()Lcom/tencent/magicbrush/MagicBrush$ScreenCanvasDelegate;", "viewManager", "Lcom/tencent/magicbrush/ui/MBViewManager;", "getViewManager", "()Lcom/tencent/magicbrush/ui/MBViewManager;", "bindTo", "", "fn", "Lkotlin/Function0;", "Lcom/tencent/magicbrush/V8RawPointer;", "isolatePtr", "", "contextPtr", "uvLoopPtr", "destroy", "lazyLoadSync", "name", "", "setAnimationFrameHandler", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "updateParams", "useCommandBuffer", "", "Companion", "FirstFrameListener", "ImageDecodeListener", "JSStuffListener", "ScreenCanvasDelegate", "lib-magicbrush-nano_release"})
public final class e
  extends MBRuntime
{
  public static final e.a cMm;
  public final g cMg;
  public final com.tencent.magicbrush.utils.c<d> cMh;
  public final com.tencent.magicbrush.utils.c<b> cMi;
  public final MBViewManager cMj;
  public final b cMk;
  private final e.e cMl;
  
  static
  {
    AppMethodBeat.i(140097);
    cMm = new e.a((byte)0);
    AppMethodBeat.o(140097);
  }
  
  private e(f paramf)
  {
    AppMethodBeat.i(140096);
    this.cMg = ((g)paramf);
    this.cMh = new com.tencent.magicbrush.utils.c();
    this.cMi = new com.tencent.magicbrush.utils.c();
    this.cMj = new MBViewManager();
    this.cMk = new b(this);
    this.cLM = paramf.cNe;
    this.mNativeInst = nativeCreate(this.cLM);
    nativeSetEventListener(this.mNativeInst, new EventDispatcher(this));
    Object localObject = paramf.cMu;
    if (localObject == null) {
      p.iCn();
    }
    a((com.tencent.magicbrush.handler.a)localObject);
    localObject = paramf.cMB.cNk;
    if (localObject != null) {
      ((BaseImageDecodeService)localObject).addDecodeEventListener((IImageDecodeService.b)new c());
    }
    a((BaseImageDecodeService)localObject);
    a(paramf.cMC);
    this.cMl = paramf.cMl;
    UH();
    paramf = paramf.cMv;
    if (paramf == null) {
      p.iCn();
    }
    d(paramf);
    AppMethodBeat.o(140096);
  }
  
  protected final b UP()
  {
    return this.cMk;
  }
  
  protected final MBViewManager UQ()
  {
    return this.cMj;
  }
  
  protected final e.e UR()
  {
    return this.cMl;
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(140095);
    p.k(paramb, "strategy");
    if (this.cLT != null) {}
    for (int i = 1; (z.aazO) && (i == 0); i = 0)
    {
      paramb = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(140095);
      throw paramb;
    }
    if (this.cLT.Vo() == paramb)
    {
      AppMethodBeat.o(140095);
      return;
    }
    c.c.i("MagicBrush", "MagicBrush is changing AnimationFrameHandler strategy from " + this.cLT.Vo() + ' ' + "to " + paramb, new Object[0]);
    Object localObject = com.tencent.magicbrush.ui.a.cPm;
    localObject = (MBRuntime)this;
    com.tencent.magicbrush.handler.c localc = UT();
    p.j(localc, "jsThreadHandler");
    m((Runnable)new h(this, a.a.a((MBRuntime)localObject, localc, paramb)));
    AppMethodBeat.o(140095);
  }
  
  public final void cB(boolean paramBoolean)
  {
    AppMethodBeat.i(204013);
    this.cLM.use_command_buffer = paramBoolean;
    nativeUpdateParams(this.mNativeInst, paramBoolean);
    AppMethodBeat.o(204013);
  }
  
  public final void d(kotlin.g.a.a<al> parama)
  {
    AppMethodBeat.i(140093);
    p.k(parama, "fn");
    m((Runnable)new e.f(this, parama));
    AppMethodBeat.o(140093);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(140094);
    c.c.i("MagicBrush", "MagicBrush is destroying...", new Object[0]);
    super.destroy();
    this.cMj.clear$lib_magicbrush_nano_release();
    this.cMh.clear();
    this.cMi.clear();
    c.c.i("MagicBrush", "MagicBrush is destroying...[done]", new Object[0]);
    AppMethodBeat.o(140094);
  }
  
  public final void ey(String paramString)
  {
    AppMethodBeat.i(204014);
    p.k(paramString, "name");
    c.c.i("MagicBrush", "hy: trigger load ".concat(String.valueOf(paramString)), new Object[0]);
    com.tencent.magicbrush.a.b.loadLibrary(paramString);
    String str = com.tencent.magicbrush.a.b.eA(paramString);
    if (str != null) {
      if (((CharSequence)str).length() != 0) {
        break label104;
      }
    }
    label104:
    for (int i = 1; i != 0; i = 0)
    {
      c.c.e("MagicBrush", "hy: can not find " + paramString + " path", new Object[0]);
      AppMethodBeat.o(204014);
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
        AppMethodBeat.o(204014);
        return;
      } while (!paramString.equals("mmphysx"));
      nativeLazyLoadPhysx(this.mNativeInst, str);
      AppMethodBeat.o(204014);
      return;
    } while (!paramString.equals("mmbox2d"));
    nativeLazyLoadBox2D(this.mNativeInst, str);
    AppMethodBeat.o(204014);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/magicbrush/MagicBrush$FirstFrameListener;", "", "onFirstFrame", "", "lib-magicbrush-nano_release"})
  public static abstract interface b
  {
    public abstract void onFirstFrame();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/magicbrush/MagicBrush$ImageDecodeListener;", "Lcom/github/henryye/nativeiv/api/IImageDecodeService$IDecodeEventListener;", "(Lcom/tencent/magicbrush/MagicBrush;)V", "onDecodeEvent", "", "path", "", "event", "Lcom/github/henryye/nativeiv/api/IImageDecodeService$IDecodeEventListener$Event;", "decodeInfo", "Lcom/github/henryye/nativeiv/api/DecodeInfo;", "onDecodeResult", "image", "", "recycleHandler", "Lcom/github/henryye/nativeiv/api/IImageDecodeService$IRecycleHandler;", "config", "Lcom/github/henryye/nativeiv/ImageDecodeConfig;", "lib-magicbrush-nano_release"})
  final class c
    implements IImageDecodeService.b
  {
    public final void a(String paramString, IImageDecodeService.b.a parama, com.github.henryye.nativeiv.api.a parama1)
    {
      AppMethodBeat.i(140088);
      p.k(paramString, "path");
      p.k(parama, "event");
      p.k(parama1, "decodeInfo");
      AppMethodBeat.o(140088);
    }
    
    public final void a(String paramString, Object paramObject, IImageDecodeService.c paramc, ImageDecodeConfig paramImageDecodeConfig)
    {
      AppMethodBeat.i(140089);
      p.k(paramString, "path");
      p.k(paramc, "recycleHandler");
      p.k(paramImageDecodeConfig, "config");
      this.cMn.b(paramString, paramObject, paramc, paramImageDecodeConfig);
      AppMethodBeat.o(140089);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/magicbrush/MagicBrush$JSStuffListener;", "", "onConsole", "", "output", "", "onJSError", "exception", "stack", "contextId", "", "lib-magicbrush-nano_release"})
  public static abstract interface d
  {
    public abstract void onConsole(String paramString);
    
    public abstract void onJSError(String paramString1, String paramString2, int paramInt);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(e parame, com.tencent.magicbrush.ui.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(140092);
      com.tencent.magicbrush.ui.a locala = this.cMn.cLT;
      this.cMn.cLT.pause();
      this.cMn.cLT = this.cMs;
      this.cMn.cLT.resume();
      locala.destroy();
      AppMethodBeat.o(140092);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.e
 * JD-Core Version:    0.7.0.1
 */