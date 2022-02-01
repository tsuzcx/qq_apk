package com.tencent.magicbrush.internal;

import com.tencent.magicbrush.a.c.c;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.e.b;
import com.tencent.magicbrush.e.d;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.MagicBrushView.g;
import com.tencent.magicbrush.utils.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/internal/EventDispatcher;", "", "magicbrush", "Lcom/tencent/magicbrush/MagicBrush;", "(Lcom/tencent/magicbrush/MagicBrush;)V", "getMagicbrush", "()Lcom/tencent/magicbrush/MagicBrush;", "dispatchTryCatch", "", "T", "R", "l", "Lcom/tencent/magicbrush/utils/ListenerList;", "block", "Lkotlin/Function1;", "getRenderingContextListener", "Lcom/tencent/magicbrush/ui/MagicBrushView$RenderingContextListener;", "virtualElementId", "", "onConsole", "output", "", "onFirstFrameRendered", "onJSError", "exception", "stack", "contextId", "onScreenCanvasRenderingContextCreated", "type", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 16})
public final class EventDispatcher
{
  private final e ekk;
  
  public EventDispatcher(e parame)
  {
    AppMethodBeat.i(140198);
    this.ekk = parame;
    AppMethodBeat.o(140198);
  }
  
  private static <T, R> void a(c<T> paramc, b<? super T, ? extends R> paramb)
  {
    AppMethodBeat.i(140197);
    try
    {
      paramc.r(paramb);
      AppMethodBeat.o(140197);
      return;
    }
    catch (Exception paramc)
    {
      c.c.printStackTrace("MagicBrush", (Throwable)paramc, "dispatch event failed", new Object[0]);
      AppMethodBeat.o(140197);
    }
  }
  
  public final void onConsole(String paramString)
  {
    AppMethodBeat.i(140194);
    s.t(paramString, "output");
    a(this.ekk.eHB, (b)new a(paramString));
    AppMethodBeat.o(140194);
  }
  
  public final void onFirstFrameRendered()
  {
    AppMethodBeat.i(140195);
    a(this.ekk.eHC, (b)b.eKj);
    AppMethodBeat.o(140195);
  }
  
  public final void onJSError(String paramString1, final String paramString2, final int paramInt)
  {
    AppMethodBeat.i(140193);
    s.t(paramString1, "exception");
    s.t(paramString2, "stack");
    a(this.ekk.eHB, (b)new c(paramString1, paramString2, paramInt));
    AppMethodBeat.o(140193);
  }
  
  public final void onScreenCanvasRenderingContextCreated(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140196);
    try
    {
      this.ekk.eHD.find(paramInt1).getRenderingContextListeners().s((b)new d(paramInt2));
      AppMethodBeat.o(140196);
      return;
    }
    catch (Exception localException)
    {
      c.c.e("MagicBrush", "onScreenCanvasRenderingContextCreated error: ".concat(String.valueOf(localException)), new Object[0]);
      AppMethodBeat.o(140196);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/magicbrush/MagicBrush$JSStuffListener;", "invoke"}, k=3, mv={1, 1, 16})
  static final class a
    extends u
    implements b<e.d, ah>
  {
    a(String paramString)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/magicbrush/MagicBrush$FirstFrameListener;", "invoke"}, k=3, mv={1, 1, 16})
  static final class b
    extends u
    implements b<e.b, ah>
  {
    public static final b eKj;
    
    static
    {
      AppMethodBeat.i(140190);
      eKj = new b();
      AppMethodBeat.o(140190);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/magicbrush/MagicBrush$JSStuffListener;", "invoke"}, k=3, mv={1, 1, 16})
  static final class c
    extends u
    implements b<e.d, ah>
  {
    c(String paramString1, String paramString2, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/magicbrush/ui/MagicBrushView$RenderingContextListener;", "invoke"}, k=3, mv={1, 1, 16})
  static final class d
    extends u
    implements b<MagicBrushView.g, ah>
  {
    d(int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.magicbrush.internal.EventDispatcher
 * JD-Core Version:    0.7.0.1
 */