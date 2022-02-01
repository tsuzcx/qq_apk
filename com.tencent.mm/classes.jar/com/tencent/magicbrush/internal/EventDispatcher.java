package com.tencent.magicbrush.internal;

import android.support.annotation.Keep;
import com.tencent.magicbrush.a.c.c;
import com.tencent.magicbrush.d;
import com.tencent.magicbrush.d.b;
import com.tencent.magicbrush.d.d;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.MagicBrushView.g;
import com.tencent.magicbrush.utils.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 13}, gka={""}, gkb={"Lcom/tencent/magicbrush/internal/EventDispatcher;", "", "magicbrush", "Lcom/tencent/magicbrush/MagicBrush;", "(Lcom/tencent/magicbrush/MagicBrush;)V", "getMagicbrush", "()Lcom/tencent/magicbrush/MagicBrush;", "dispatchTryCatch", "", "T", "R", "l", "Lcom/tencent/magicbrush/utils/ListenerList;", "block", "Lkotlin/Function1;", "getRenderingContextListener", "Lcom/tencent/magicbrush/ui/MagicBrushView$RenderingContextListener;", "virtualElementId", "", "onConsole", "output", "", "onFirstFrameRendered", "onJSError", "exception", "stack", "contextId", "onScreenCanvasRenderingContextCreated", "type", "lib-magicbrush-nano_release"})
public final class EventDispatcher
{
  private final d cip;
  
  public EventDispatcher(d paramd)
  {
    AppMethodBeat.i(140198);
    this.cip = paramd;
    AppMethodBeat.o(140198);
  }
  
  private static <T, R> void a(c<T> paramc, b<? super T, ? extends R> paramb)
  {
    AppMethodBeat.i(140197);
    try
    {
      paramc.b(paramb);
      AppMethodBeat.o(140197);
      return;
    }
    catch (Exception paramc)
    {
      c.c.printStackTrace("MagicBrush", (Throwable)paramc, "dispatch event failed", new Object[0]);
      AppMethodBeat.o(140197);
    }
  }
  
  @Keep
  public final void onConsole(String paramString)
  {
    AppMethodBeat.i(140194);
    p.h(paramString, "output");
    a(this.cip.cxp, (b)new a(paramString));
    AppMethodBeat.o(140194);
  }
  
  @Keep
  public final void onFirstFrameRendered()
  {
    AppMethodBeat.i(140195);
    a(this.cip.cxq, (b)b.cAj);
    AppMethodBeat.o(140195);
  }
  
  @Keep
  public final void onJSError(String paramString1, final String paramString2, final int paramInt)
  {
    AppMethodBeat.i(140193);
    p.h(paramString1, "exception");
    p.h(paramString2, "stack");
    a(this.cip.cxp, (b)new c(paramString1, paramString2, paramInt));
    AppMethodBeat.o(140193);
  }
  
  @Keep
  public final void onScreenCanvasRenderingContextCreated(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140196);
    try
    {
      this.cip.cxr.find(paramInt1).getRenderingContextListeners().c((b)new d(paramInt2));
      AppMethodBeat.o(140196);
      return;
    }
    catch (Exception localException)
    {
      c.c.e("MagicBrush", "onScreenCanvasRenderingContextCreated error: ".concat(String.valueOf(localException)), new Object[0]);
      AppMethodBeat.o(140196);
    }
  }
  
  @l(gjZ={1, 1, 13}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/magicbrush/MagicBrush$JSStuffListener;", "invoke"})
  static final class a
    extends q
    implements b<d.d, z>
  {
    a(String paramString)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 13}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/magicbrush/MagicBrush$FirstFrameListener;", "invoke"})
  static final class b
    extends q
    implements b<d.b, z>
  {
    public static final b cAj;
    
    static
    {
      AppMethodBeat.i(140190);
      cAj = new b();
      AppMethodBeat.o(140190);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 13}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/magicbrush/MagicBrush$JSStuffListener;", "invoke"})
  static final class c
    extends q
    implements b<d.d, z>
  {
    c(String paramString1, String paramString2, int paramInt)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 13}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/magicbrush/ui/MagicBrushView$RenderingContextListener;", "invoke"})
  static final class d
    extends q
    implements b<MagicBrushView.g, z>
  {
    d(int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.internal.EventDispatcher
 * JD-Core Version:    0.7.0.1
 */