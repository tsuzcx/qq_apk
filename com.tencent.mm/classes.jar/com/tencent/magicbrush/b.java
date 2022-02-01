package com.tencent.magicbrush;

import android.graphics.Bitmap;
import com.tencent.magicbrush.a.c.c;
import com.tencent.magicbrush.handler.c;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.utils.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/MBCanvasHandler;", "", "magicbrush", "Lcom/tencent/magicbrush/MagicBrush;", "(Lcom/tencent/magicbrush/MagicBrush;)V", "getMagicbrush", "()Lcom/tencent/magicbrush/MagicBrush;", "captureCanvas", "Landroid/graphics/Bitmap;", "windowId", "", "canvasId", "isWindow", "", "timeout", "", "captureCanvasOnJsThread", "captureCanvasOnOtherThread", "captureCanvasOnOtherThreadWaitingSwapDone", "captureDefaultWindow", "cache", "captureScreenCanvas", "virtualElementId", "width", "height", "bitmap", "captureWindow", "findViewOrNull", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "Companion", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 16})
public final class b
{
  private static final String TAG = "MagicBrush.MBCanvasHandler";
  private static final long eGD = 2500L;
  public static final b.a eGE;
  final e ekk;
  
  static
  {
    AppMethodBeat.i(161144);
    eGE = new b.a((byte)0);
    TAG = "MagicBrush.MBCanvasHandler";
    eGD = 2500L;
    AppMethodBeat.o(161144);
  }
  
  public b(e parame)
  {
    AppMethodBeat.i(140087);
    this.ekk = parame;
    AppMethodBeat.o(140087);
  }
  
  private final Bitmap k(final int paramInt1, final int paramInt2, final boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(161141);
    c.c.i("MagicBrush", "captureCanvasOnOtherThread", new Object[0]);
    Bitmap localBitmap = (Bitmap)this.ekk.avw().c((Callable)new b(this, paramInt1, paramInt2, paramBoolean));
    if (localBitmap == null) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      c.c.i("MagicBrush", "ca done %b", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(161141);
      return localBitmap;
    }
  }
  
  private final Bitmap l(final int paramInt1, final int paramInt2, final boolean paramBoolean)
  {
    AppMethodBeat.i(228819);
    c.c.i("MagicBrush", "hy: captureCanvasOnOtherThreadWaitingSwapDone", new Object[0]);
    Bitmap localBitmap = (Bitmap)new c(this, paramInt1, paramInt2, paramBoolean, eGD).b((com.tencent.magicbrush.handler.a)this.ekk.avw());
    String str = TAG;
    if (localBitmap == null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      c.c.i(str, "hy: is ret bitmap is null? %b", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(228819);
      return localBitmap;
    }
  }
  
  private final Bitmap m(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(161143);
    Bitmap localBitmap = this.ekk.n(paramInt1, paramInt2, paramBoolean);
    AppMethodBeat.o(161143);
    return localBitmap;
  }
  
  public final Bitmap j(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(228854);
    if ((paramInt2 <= 0) && (!paramBoolean))
    {
      AppMethodBeat.o(228854);
      return null;
    }
    Object localObject = this.ekk.avw();
    s.r(localObject, "magicbrush.jsThreadHandler");
    if (((c)localObject).aoN())
    {
      localObject = m(paramInt1, paramInt2, paramBoolean);
      AppMethodBeat.o(228854);
      return localObject;
    }
    if (!paramBoolean)
    {
      localObject = k(paramInt1, paramInt2, paramBoolean);
      AppMethodBeat.o(228854);
      return localObject;
    }
    localObject = l(paramInt1, paramInt2, paramBoolean);
    AppMethodBeat.o(228854);
    return localObject;
  }
  
  final MagicBrushView mN(int paramInt)
  {
    AppMethodBeat.i(140086);
    MagicBrushView localMagicBrushView = this.ekk.eHD.findOrNull(paramInt);
    if (localMagicBrushView == null)
    {
      com.github.henryye.nativeiv.a.b.e("MagicBrush", "findView [%d] but can not find. thread = [%s]", new Object[] { Integer.valueOf(paramInt), Thread.currentThread() });
      AppMethodBeat.o(140086);
      return null;
    }
    AppMethodBeat.o(140086);
    return localMagicBrushView;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroid/graphics/Bitmap;", "call"}, k=3, mv={1, 1, 16})
  static final class b<V>
    implements Callable<Bitmap>
  {
    b(b paramb, int paramInt1, int paramInt2, boolean paramBoolean) {}
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/magicbrush/MBCanvasHandler$captureCanvasOnOtherThreadWaitingSwapDone$ret$1", "Lcom/tencent/magicbrush/utils/ManualFinishableSyncTask;", "Landroid/graphics/Bitmap;", "run", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 16})
  public static final class c
    extends d<Bitmap>
  {
    c(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong)
    {
      super();
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "beforeSwap"}, k=3, mv={1, 1, 16})
    static final class a
      implements MBRuntime.a
    {
      a(b.c paramc) {}
      
      public final void beforeSwap(boolean paramBoolean)
      {
        AppMethodBeat.i(161138);
        Object localObject = b.eGE;
        c.c.i(b.access$getTAG$cp(), "hy: is swap all window: ".concat(String.valueOf(paramBoolean)), new Object[0]);
        localObject = b.a(this.eGJ.eGF, this.eGJ.eGG, this.eGJ.eGH, this.eGJ.eGI);
        this.eGJ.setResultFinish(localObject);
        AppMethodBeat.o(161138);
      }
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroid/graphics/Bitmap;", "invoke"}, k=3, mv={1, 1, 16})
  static final class d
    extends u
    implements kotlin.g.a.a<Bitmap>
  {
    d(MagicBrushView paramMagicBrushView, int paramInt1, int paramInt2, Bitmap paramBitmap)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.b
 * JD-Core Version:    0.7.0.1
 */