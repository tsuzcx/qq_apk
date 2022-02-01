package com.tencent.magicbrush.internal;

import androidx.annotation.Keep;
import com.tencent.magicbrush.a.c.c;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.e.b;
import com.tencent.magicbrush.e.d;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.MagicBrushView.g;
import com.tencent.magicbrush.utils.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/magicbrush/internal/EventDispatcher;", "", "magicbrush", "Lcom/tencent/magicbrush/MagicBrush;", "(Lcom/tencent/magicbrush/MagicBrush;)V", "getMagicbrush", "()Lcom/tencent/magicbrush/MagicBrush;", "dispatchTryCatch", "", "T", "R", "l", "Lcom/tencent/magicbrush/utils/ListenerList;", "block", "Lkotlin/Function1;", "getRenderingContextListener", "Lcom/tencent/magicbrush/ui/MagicBrushView$RenderingContextListener;", "virtualElementId", "", "onConsole", "output", "", "onFirstFrameRendered", "onJSError", "exception", "stack", "contextId", "onScreenCanvasRenderingContextCreated", "type", "lib-magicbrush-nano_release"})
public final class EventDispatcher
{
  private final e csn;
  
  public EventDispatcher(e parame)
  {
    AppMethodBeat.i(140198);
    this.csn = parame;
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
    p.k(paramString, "output");
    a(this.csn.cMh, (b)new a(paramString));
    AppMethodBeat.o(140194);
  }
  
  @Keep
  public final void onFirstFrameRendered()
  {
    AppMethodBeat.i(140195);
    a(this.csn.cMi, (b)b.cPe);
    AppMethodBeat.o(140195);
  }
  
  @Keep
  public final void onJSError(String paramString1, final String paramString2, final int paramInt)
  {
    AppMethodBeat.i(140193);
    p.k(paramString1, "exception");
    p.k(paramString2, "stack");
    a(this.csn.cMh, (b)new c(paramString1, paramString2, paramInt));
    AppMethodBeat.o(140193);
  }
  
  @Keep
  public final void onScreenCanvasRenderingContextCreated(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140196);
    try
    {
      this.csn.cMj.find(paramInt1).getRenderingContextListeners().c((b)new d(paramInt2));
      AppMethodBeat.o(140196);
      return;
    }
    catch (Exception localException)
    {
      c.c.e("MagicBrush", "onScreenCanvasRenderingContextCreated error: ".concat(String.valueOf(localException)), new Object[0]);
      AppMethodBeat.o(140196);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/magicbrush/MagicBrush$JSStuffListener;", "invoke"})
  static final class a
    extends q
    implements b<e.d, x>
  {
    a(String paramString)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/magicbrush/MagicBrush$FirstFrameListener;", "invoke"})
  static final class b
    extends q
    implements b<e.b, x>
  {
    public static final b cPe;
    
    static
    {
      AppMethodBeat.i(140190);
      cPe = new b();
      AppMethodBeat.o(140190);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/magicbrush/MagicBrush$JSStuffListener;", "invoke"})
  static final class c
    extends q
    implements b<e.d, x>
  {
    c(String paramString1, String paramString2, int paramInt)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/magicbrush/ui/MagicBrushView$RenderingContextListener;", "invoke"})
  static final class d
    extends q
    implements b<MagicBrushView.g, x>
  {
    d(int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.internal.EventDispatcher
 * JD-Core Version:    0.7.0.1
 */