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
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 13}, fNZ={""}, fOa={"Lcom/tencent/magicbrush/internal/EventDispatcher;", "", "magicbrush", "Lcom/tencent/magicbrush/MagicBrush;", "(Lcom/tencent/magicbrush/MagicBrush;)V", "getMagicbrush", "()Lcom/tencent/magicbrush/MagicBrush;", "dispatchTryCatch", "", "T", "R", "l", "Lcom/tencent/magicbrush/utils/ListenerList;", "block", "Lkotlin/Function1;", "getRenderingContextListener", "Lcom/tencent/magicbrush/ui/MagicBrushView$RenderingContextListener;", "virtualElementId", "", "onConsole", "output", "", "onFirstFrameRendered", "onJSError", "exception", "stack", "contextId", "onScreenCanvasRenderingContextCreated", "type", "lib-magicbrush-nano_release"})
public final class EventDispatcher
{
  private final d bXV;
  
  public EventDispatcher(d paramd)
  {
    AppMethodBeat.i(140198);
    this.bXV = paramd;
    AppMethodBeat.o(140198);
  }
  
  private static <T, R> void a(c<T> paramc, b<? super T, ? extends R> paramb)
  {
    AppMethodBeat.i(140197);
    try
    {
      paramc.a(paramb);
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
    k.h(paramString, "output");
    a(this.bXV.cmi, (b)new a(paramString));
    AppMethodBeat.o(140194);
  }
  
  @Keep
  public final void onFirstFrameRendered()
  {
    AppMethodBeat.i(140195);
    a(this.bXV.cmj, (b)b.coL);
    AppMethodBeat.o(140195);
  }
  
  @Keep
  public final void onJSError(String paramString1, final String paramString2, final int paramInt)
  {
    AppMethodBeat.i(140193);
    k.h(paramString1, "exception");
    k.h(paramString2, "stack");
    a(this.bXV.cmi, (b)new c(paramString1, paramString2, paramInt));
    AppMethodBeat.o(140193);
  }
  
  @Keep
  public final void onScreenCanvasRenderingContextCreated(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140196);
    this.bXV.cmk.find(paramInt1).getRenderingContextListeners().a((b)new d(paramInt2));
    AppMethodBeat.o(140196);
  }
  
  @d.l(fNY={1, 1, 13}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/magicbrush/MagicBrush$JSStuffListener;", "invoke"})
  static final class a
    extends d.g.b.l
    implements b<d.d, y>
  {
    a(String paramString)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 13}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/magicbrush/MagicBrush$FirstFrameListener;", "invoke"})
  static final class b
    extends d.g.b.l
    implements b<d.b, y>
  {
    public static final b coL;
    
    static
    {
      AppMethodBeat.i(140190);
      coL = new b();
      AppMethodBeat.o(140190);
    }
    
    b()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 13}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/magicbrush/MagicBrush$JSStuffListener;", "invoke"})
  static final class c
    extends d.g.b.l
    implements b<d.d, y>
  {
    c(String paramString1, String paramString2, int paramInt)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 13}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/magicbrush/ui/MagicBrushView$RenderingContextListener;", "invoke"})
  static final class d
    extends d.g.b.l
    implements b<MagicBrushView.g, y>
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