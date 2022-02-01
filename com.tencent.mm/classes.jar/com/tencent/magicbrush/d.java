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

@d.l(fNY={1, 1, 13}, fNZ={""}, fOa={"Lcom/tencent/magicbrush/MagicBrush;", "Lcom/tencent/magicbrush/MBRuntime;", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "(Lcom/tencent/magicbrush/MagicBrushBuilder;)V", "canvasHandler", "Lcom/tencent/magicbrush/MBCanvasHandler;", "getCanvasHandler", "()Lcom/tencent/magicbrush/MBCanvasHandler;", "config", "Lcom/tencent/magicbrush/MagicBrushConfig;", "getConfig", "()Lcom/tencent/magicbrush/MagicBrushConfig;", "firstFrameListeners", "Lcom/tencent/magicbrush/utils/ListenerList;", "Lcom/tencent/magicbrush/MagicBrush$FirstFrameListener;", "getFirstFrameListeners", "()Lcom/tencent/magicbrush/utils/ListenerList;", "jsStuffListeners", "Lcom/tencent/magicbrush/MagicBrush$JSStuffListener;", "getJSStuffListeners", "viewManager", "Lcom/tencent/magicbrush/ui/MBViewManager;", "getViewManager", "()Lcom/tencent/magicbrush/ui/MBViewManager;", "bindTo", "", "fn", "Lkotlin/Function0;", "Lcom/tencent/magicbrush/V8RawPointer;", "isolatePtr", "", "contextPtr", "uvLoopPtr", "destroy", "setAnimationFrameHandler", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "Companion", "FirstFrameListener", "ImageDecodeListener", "JSStuffListener", "lib-magicbrush-nano_release"})
public final class d
  extends MBRuntime
{
  public static final a cmm;
  public final f cmh;
  public final com.tencent.magicbrush.utils.c<d> cmi;
  public final com.tencent.magicbrush.utils.c<b> cmj;
  public final MBViewManager cmk;
  public final b cml;
  
  static
  {
    AppMethodBeat.i(140097);
    cmm = new a((byte)0);
    AppMethodBeat.o(140097);
  }
  
  private d(e parame)
  {
    AppMethodBeat.i(140096);
    this.cmh = ((f)parame);
    this.clN = parame.cmY;
    this.mNativeInst = nativeCreate(this.clN);
    nativeSetEventListener(this.mNativeInst, new EventDispatcher(this));
    Object localObject = parame.cmt;
    if (localObject == null) {
      k.fOy();
    }
    a((com.tencent.magicbrush.handler.a)localObject);
    localObject = parame.cmA.cne;
    if (localObject != null) {
      ((BaseImageDecodeService)localObject).addDecodeEventListener((IImageDecodeService.b)new c());
    }
    a((BaseImageDecodeService)localObject);
    a(parame.cmB);
    FI();
    parame = parame.cmu;
    if (parame == null) {
      k.fOy();
    }
    c(parame);
    this.cmi = new com.tencent.magicbrush.utils.c();
    this.cmj = new com.tencent.magicbrush.utils.c();
    this.cmk = new MBViewManager();
    this.cml = new b(this);
    AppMethodBeat.o(140096);
  }
  
  protected final b FQ()
  {
    return this.cml;
  }
  
  protected final MBViewManager FR()
  {
    return this.cmk;
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(140095);
    k.h(paramb, "strategy");
    if (this.clU != null) {}
    for (int i = 1; (aa.KTq) && (i == 0); i = 0)
    {
      paramb = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(140095);
      throw paramb;
    }
    if (this.clU.Gj() == paramb)
    {
      AppMethodBeat.o(140095);
      return;
    }
    c.c.i("MagicBrush", "MagicBrush is changing AnimationFrameHandler strategy from " + this.clU.Gj() + ' ' + "to " + paramb, new Object[0]);
    Object localObject = com.tencent.magicbrush.ui.a.coT;
    localObject = (MBRuntime)this;
    com.tencent.magicbrush.handler.c localc = FT();
    k.g(localc, "jsThreadHandler");
    m((Runnable)new g(this, a.a.a((MBRuntime)localObject, localc, paramb)));
    AppMethodBeat.o(140095);
  }
  
  public final void c(final d.g.a.a<af> parama)
  {
    AppMethodBeat.i(140093);
    k.h(parama, "fn");
    m((Runnable)new e(this, parama));
    AppMethodBeat.o(140093);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(140094);
    c.c.i("MagicBrush", "MagicBrush is destroying...", new Object[0]);
    super.destroy();
    this.cmk.clear$lib_magicbrush_nano_release();
    this.cmi.clear();
    this.cmj.clear();
    c.c.i("MagicBrush", "MagicBrush is destroying...[done]", new Object[0]);
    AppMethodBeat.o(140094);
  }
  
  @d.l(fNY={1, 1, 13}, fNZ={""}, fOa={"Lcom/tencent/magicbrush/MagicBrush$Companion;", "", "()V", "DEFAULT_WINDOW_ID", "", "TAG", "", "create", "Lcom/tencent/magicbrush/MagicBrush;", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "dls", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "lib-magicbrush-nano_release"})
  public static final class a {}
  
  @d.l(fNY={1, 1, 13}, fNZ={""}, fOa={"Lcom/tencent/magicbrush/MagicBrush$FirstFrameListener;", "", "onFirstFrame", "", "lib-magicbrush-nano_release"})
  public static abstract interface b
  {
    public abstract void onFirstFrame();
  }
  
  @d.l(fNY={1, 1, 13}, fNZ={""}, fOa={"Lcom/tencent/magicbrush/MagicBrush$ImageDecodeListener;", "Lcom/github/henryye/nativeiv/api/IImageDecodeService$IDecodeEventListener;", "(Lcom/tencent/magicbrush/MagicBrush;)V", "onDecodeEvent", "", "path", "", "event", "Lcom/github/henryye/nativeiv/api/IImageDecodeService$IDecodeEventListener$Event;", "decodeInfo", "Lcom/github/henryye/nativeiv/api/DecodeInfo;", "onDecodeResult", "image", "", "recycleHandler", "Lcom/github/henryye/nativeiv/api/IImageDecodeService$IRecycleHandler;", "config", "Lcom/github/henryye/nativeiv/ImageDecodeConfig;", "lib-magicbrush-nano_release"})
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
      this.cmn.b(paramString, paramObject, paramc, paramImageDecodeConfig);
      AppMethodBeat.o(140089);
    }
  }
  
  @d.l(fNY={1, 1, 13}, fNZ={""}, fOa={"Lcom/tencent/magicbrush/MagicBrush$JSStuffListener;", "", "onConsole", "", "output", "", "onJSError", "exception", "stack", "contextId", "", "lib-magicbrush-nano_release"})
  public static abstract interface d
  {
    public abstract void onConsole(String paramString);
    
    public abstract void onJSError(String paramString1, String paramString2, int paramInt);
  }
  
  @d.l(fNY={1, 1, 13}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(d paramd, d.g.a.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(140090);
      af localaf = (af)parama.invoke();
      this.cmn.nativeBindTo(this.cmn.mNativeInst, localaf.cng, localaf.cnh, localaf.cni);
      AppMethodBeat.o(140090);
    }
  }
  
  @d.l(fNY={1, 1, 13}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/magicbrush/V8RawPointer;", "invoke"})
  public static final class f
    extends d.g.b.l
    implements d.g.a.a<af>
  {
    public f(long paramLong1, long paramLong2, long paramLong3)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 13}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(d paramd, com.tencent.magicbrush.ui.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(140092);
      com.tencent.magicbrush.ui.a locala = this.cmn.clU;
      this.cmn.clU.pause();
      this.cmn.clU = this.cms;
      this.cmn.clU.resume();
      locala.destroy();
      AppMethodBeat.o(140092);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.d
 * JD-Core Version:    0.7.0.1
 */