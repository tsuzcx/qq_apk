package com.tencent.magicbrush;

import android.graphics.Bitmap;
import com.tencent.magicbrush.a.c.c;
import com.tencent.magicbrush.handler.c;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.utils.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/magicbrush/MBCanvasHandler;", "", "magicbrush", "Lcom/tencent/magicbrush/MagicBrush;", "(Lcom/tencent/magicbrush/MagicBrush;)V", "getMagicbrush", "()Lcom/tencent/magicbrush/MagicBrush;", "captureCanvas", "Landroid/graphics/Bitmap;", "windowId", "", "canvasId", "isWindow", "", "timeout", "", "captureCanvasOnJsThread", "captureCanvasOnOtherThread", "captureCanvasOnOtherThreadWaitingSwapDone", "captureDefaultWindow", "cache", "captureScreenCanvas", "virtualElementId", "width", "height", "bitmap", "captureWindow", "findViewOrNull", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "Companion", "lib-magicbrush-nano_release"})
public final class b
{
  private static final String TAG = "MagicBrush.MBCanvasHandler";
  private static final long cKw = 2500L;
  public static final a cKx;
  final e cui;
  
  static
  {
    AppMethodBeat.i(161144);
    cKx = new a((byte)0);
    TAG = "MagicBrush.MBCanvasHandler";
    cKw = 2500L;
    AppMethodBeat.o(161144);
  }
  
  public b(e parame)
  {
    AppMethodBeat.i(140087);
    this.cui = parame;
    AppMethodBeat.o(140087);
  }
  
  private final Bitmap i(final int paramInt1, final int paramInt2, final boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(161141);
    c.c.i("MagicBrush", "captureCanvasOnOtherThread", new Object[0]);
    Bitmap localBitmap = (Bitmap)this.cui.Rl().c((Callable)new b(this, paramInt1, paramInt2, paramBoolean));
    if (localBitmap == null) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      c.c.i("MagicBrush", "ca done %b", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(161141);
      return localBitmap;
    }
  }
  
  private final Bitmap j(final int paramInt1, final int paramInt2, final boolean paramBoolean)
  {
    AppMethodBeat.i(206816);
    c.c.i("MagicBrush", "hy: captureCanvasOnOtherThreadWaitingSwapDone", new Object[0]);
    Bitmap localBitmap = (Bitmap)new c(this, paramInt1, paramInt2, paramBoolean, cKw).b((com.tencent.magicbrush.handler.a)this.cui.Rl());
    String str = TAG;
    if (localBitmap == null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      c.c.i(str, "hy: is ret bitmap is null? %b", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(206816);
      return localBitmap;
    }
  }
  
  private final Bitmap k(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(161143);
    Bitmap localBitmap = this.cui.l(paramInt1, paramInt2, paramBoolean);
    AppMethodBeat.o(161143);
    return localBitmap;
  }
  
  public final Bitmap h(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(206815);
    if ((paramInt2 <= 0) && (!paramBoolean))
    {
      AppMethodBeat.o(206815);
      return null;
    }
    Object localObject = this.cui.Rl();
    p.g(localObject, "magicbrush.jsThreadHandler");
    if (((c)localObject).LO())
    {
      localObject = k(paramInt1, paramInt2, paramBoolean);
      AppMethodBeat.o(206815);
      return localObject;
    }
    if (!paramBoolean)
    {
      localObject = i(paramInt1, paramInt2, paramBoolean);
      AppMethodBeat.o(206815);
      return localObject;
    }
    localObject = j(paramInt1, paramInt2, paramBoolean);
    AppMethodBeat.o(206815);
    return localObject;
  }
  
  final MagicBrushView ih(int paramInt)
  {
    AppMethodBeat.i(140086);
    MagicBrushView localMagicBrushView = this.cui.cLz.findOrNull(paramInt);
    if (localMagicBrushView == null)
    {
      com.github.henryye.nativeiv.a.b.e("MagicBrush", "findView [%d] but can not find. thread = [%s]", new Object[] { Integer.valueOf(paramInt), Thread.currentThread() });
      AppMethodBeat.o(140086);
      return null;
    }
    AppMethodBeat.o(140086);
    return localMagicBrushView;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/magicbrush/MBCanvasHandler$Companion;", "", "()V", "CAPTURE_TIMEOUT", "", "getCAPTURE_TIMEOUT", "()J", "TAG", "", "getTAG", "()Ljava/lang/String;", "lib-magicbrush-nano_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/graphics/Bitmap;", "call"})
  static final class b<V>
    implements Callable<Bitmap>
  {
    b(b paramb, int paramInt1, int paramInt2, boolean paramBoolean) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/magicbrush/MBCanvasHandler$captureCanvasOnOtherThreadWaitingSwapDone$ret$1", "Lcom/tencent/magicbrush/utils/ManualFinishableSyncTask;", "Landroid/graphics/Bitmap;", "run", "lib-magicbrush-nano_release"})
  public static final class c
    extends d<Bitmap>
  {
    c(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong, Object paramObject)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "beforeSwap"})
    static final class a
      implements MBRuntime.a
    {
      a(b.c paramc) {}
      
      public final void beforeSwap(boolean paramBoolean)
      {
        AppMethodBeat.i(161138);
        Object localObject = b.cKx;
        c.c.i(b.access$getTAG$cp(), "hy: is swap all window: ".concat(String.valueOf(paramBoolean)), new Object[0]);
        localObject = b.a(this.cKC.cKy, this.cKC.cKz, this.cKC.cKA, this.cKC.cKB);
        this.cKC.setResultFinish(localObject);
        AppMethodBeat.o(161138);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/graphics/Bitmap;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<Bitmap>
  {
    d(MagicBrushView paramMagicBrushView, int paramInt1, int paramInt2, Bitmap paramBitmap)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.magicbrush.b
 * JD-Core Version:    0.7.0.1
 */