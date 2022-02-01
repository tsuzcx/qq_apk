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
import d.ac;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 13}, gfy={""}, gfz={"Lcom/tencent/magicbrush/MagicBrush;", "Lcom/tencent/magicbrush/MBRuntime;", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "(Lcom/tencent/magicbrush/MagicBrushBuilder;)V", "canvasHandler", "Lcom/tencent/magicbrush/MBCanvasHandler;", "getCanvasHandler", "()Lcom/tencent/magicbrush/MBCanvasHandler;", "config", "Lcom/tencent/magicbrush/MagicBrushConfig;", "getConfig", "()Lcom/tencent/magicbrush/MagicBrushConfig;", "firstFrameListeners", "Lcom/tencent/magicbrush/utils/ListenerList;", "Lcom/tencent/magicbrush/MagicBrush$FirstFrameListener;", "getFirstFrameListeners", "()Lcom/tencent/magicbrush/utils/ListenerList;", "jsStuffListeners", "Lcom/tencent/magicbrush/MagicBrush$JSStuffListener;", "getJSStuffListeners", "viewManager", "Lcom/tencent/magicbrush/ui/MBViewManager;", "getViewManager", "()Lcom/tencent/magicbrush/ui/MBViewManager;", "bindTo", "", "fn", "Lkotlin/Function0;", "Lcom/tencent/magicbrush/V8RawPointer;", "isolatePtr", "", "contextPtr", "uvLoopPtr", "destroy", "setAnimationFrameHandler", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "Companion", "FirstFrameListener", "ImageDecodeListener", "JSStuffListener", "lib-magicbrush-nano_release"})
public final class d
  extends MBRuntime
{
  public static final a cwO;
  public final f cwJ;
  public final com.tencent.magicbrush.utils.c<d.d> cwK;
  public final com.tencent.magicbrush.utils.c<d.b> cwL;
  public final MBViewManager cwM;
  public final b cwN;
  
  static
  {
    AppMethodBeat.i(140097);
    cwO = new a((byte)0);
    AppMethodBeat.o(140097);
  }
  
  private d(e parame)
  {
    AppMethodBeat.i(140096);
    this.cwJ = ((f)parame);
    this.cwp = parame.cxD;
    this.mNativeInst = nativeCreate(this.cwp);
    nativeSetEventListener(this.mNativeInst, new EventDispatcher(this));
    Object localObject = parame.cwW;
    if (localObject == null) {
      p.gfZ();
    }
    a((com.tencent.magicbrush.handler.a)localObject);
    localObject = parame.cxd.cxJ;
    if (localObject != null) {
      ((BaseImageDecodeService)localObject).addDecodeEventListener((IImageDecodeService.b)new c());
    }
    a((BaseImageDecodeService)localObject);
    a(parame.cxe);
    Hc();
    parame = parame.cwX;
    if (parame == null) {
      p.gfZ();
    }
    c(parame);
    this.cwK = new com.tencent.magicbrush.utils.c();
    this.cwL = new com.tencent.magicbrush.utils.c();
    this.cwM = new MBViewManager();
    this.cwN = new b(this);
    AppMethodBeat.o(140096);
  }
  
  protected final b Hk()
  {
    return this.cwN;
  }
  
  protected final MBViewManager Hl()
  {
    return this.cwM;
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(140095);
    p.h(paramb, "strategy");
    if (this.cww != null) {}
    for (int i = 1; (ac.MKp) && (i == 0); i = 0)
    {
      paramb = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(140095);
      throw paramb;
    }
    if (this.cww.HE() == paramb)
    {
      AppMethodBeat.o(140095);
      return;
    }
    c.c.i("MagicBrush", "MagicBrush is changing AnimationFrameHandler strategy from " + this.cww.HE() + ' ' + "to " + paramb, new Object[0]);
    Object localObject = com.tencent.magicbrush.ui.a.czK;
    localObject = (MBRuntime)this;
    com.tencent.magicbrush.handler.c localc = Hn();
    p.g(localc, "jsThreadHandler");
    m((Runnable)new g(this, a.a.a((MBRuntime)localObject, localc, paramb)));
    AppMethodBeat.o(140095);
  }
  
  public final void c(d.g.a.a<ah> parama)
  {
    AppMethodBeat.i(140093);
    p.h(parama, "fn");
    m((Runnable)new d.e(this, parama));
    AppMethodBeat.o(140093);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(140094);
    c.c.i("MagicBrush", "MagicBrush is destroying...", new Object[0]);
    super.destroy();
    this.cwM.clear$lib_magicbrush_nano_release();
    this.cwK.clear();
    this.cwL.clear();
    c.c.i("MagicBrush", "MagicBrush is destroying...[done]", new Object[0]);
    AppMethodBeat.o(140094);
  }
  
  @l(gfx={1, 1, 13}, gfy={""}, gfz={"Lcom/tencent/magicbrush/MagicBrush$Companion;", "", "()V", "DEFAULT_WINDOW_ID", "", "TAG", "", "create", "Lcom/tencent/magicbrush/MagicBrush;", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "dls", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "lib-magicbrush-nano_release"})
  public static final class a
  {
    public static d b(e parame)
    {
      AppMethodBeat.i(215086);
      p.h(parame, "builder");
      if (!com.tencent.magicbrush.internal.a.d(parame))
      {
        AppMethodBeat.o(215086);
        return null;
      }
      parame = new d(parame, (byte)0);
      AppMethodBeat.o(215086);
      return parame;
    }
  }
  
  @l(gfx={1, 1, 13}, gfy={""}, gfz={"Lcom/tencent/magicbrush/MagicBrush$ImageDecodeListener;", "Lcom/github/henryye/nativeiv/api/IImageDecodeService$IDecodeEventListener;", "(Lcom/tencent/magicbrush/MagicBrush;)V", "onDecodeEvent", "", "path", "", "event", "Lcom/github/henryye/nativeiv/api/IImageDecodeService$IDecodeEventListener$Event;", "decodeInfo", "Lcom/github/henryye/nativeiv/api/DecodeInfo;", "onDecodeResult", "image", "", "recycleHandler", "Lcom/github/henryye/nativeiv/api/IImageDecodeService$IRecycleHandler;", "config", "Lcom/github/henryye/nativeiv/ImageDecodeConfig;", "lib-magicbrush-nano_release"})
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
      this.cwP.b(paramString, paramObject, paramc, paramImageDecodeConfig);
      AppMethodBeat.o(140089);
    }
  }
  
  @l(gfx={1, 1, 13}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(d paramd, com.tencent.magicbrush.ui.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(140092);
      com.tencent.magicbrush.ui.a locala = this.cwP.cww;
      this.cwP.cww.pause();
      this.cwP.cww = this.cwU;
      this.cwP.cww.resume();
      locala.destroy();
      AppMethodBeat.o(140092);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.d
 * JD-Core Version:    0.7.0.1
 */