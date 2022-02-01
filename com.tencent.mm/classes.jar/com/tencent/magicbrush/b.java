package com.tencent.magicbrush;

import android.graphics.Bitmap;
import com.tencent.magicbrush.a.c.c;
import com.tencent.magicbrush.handler.c;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.g.b.q;
import d.l;
import java.util.concurrent.Callable;

@l(gjZ={1, 1, 13}, gka={""}, gkb={"Lcom/tencent/magicbrush/MBCanvasHandler;", "", "magicbrush", "Lcom/tencent/magicbrush/MagicBrush;", "(Lcom/tencent/magicbrush/MagicBrush;)V", "getMagicbrush", "()Lcom/tencent/magicbrush/MagicBrush;", "captureCanvas", "Landroid/graphics/Bitmap;", "windowId", "", "canvasId", "isWindow", "", "captureCanvasOnJsThread", "captureCanvasOnOtherThread", "captureCanvasOnOtherThreadWaitingSwapDone", "captureDefaultWindow", "cache", "captureScreenCanvas", "virtualElementId", "width", "height", "bitmap", "captureWindow", "findViewOrNull", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "Companion", "lib-magicbrush-nano_release"})
public final class b
{
  private static final String TAG = "MagicBrush.MBCanvasHandler";
  private static final long cwr = 2500L;
  public static final a cws;
  final d cip;
  
  static
  {
    AppMethodBeat.i(161144);
    cws = new a((byte)0);
    TAG = "MagicBrush.MBCanvasHandler";
    cwr = 2500L;
    AppMethodBeat.o(161144);
  }
  
  public b(d paramd)
  {
    AppMethodBeat.i(140087);
    this.cip = paramd;
    AppMethodBeat.o(140087);
  }
  
  private final Bitmap i(final int paramInt1, final int paramInt2, final boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(161141);
    c.c.i("MagicBrush", "captureCanvasOnOtherThread", new Object[0]);
    Bitmap localBitmap = (Bitmap)this.cip.Ht().b((Callable)new b(this, paramInt1, paramInt2, paramBoolean));
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
    AppMethodBeat.i(161142);
    c.c.i("MagicBrush", "hy: captureCanvasOnOtherThreadWaitingSwapDone", new Object[0]);
    Bitmap localBitmap = (Bitmap)new c(this, paramInt1, paramInt2, paramBoolean, cwr).b((com.tencent.magicbrush.handler.a)this.cip.Ht());
    String str = TAG;
    if (localBitmap == null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      c.c.i(str, "hy: is ret bitmap is null? %b", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(161142);
      return localBitmap;
    }
  }
  
  private final Bitmap k(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(161143);
    Bitmap localBitmap = this.cip.h(paramInt1, paramInt2, paramBoolean);
    AppMethodBeat.o(161143);
    return localBitmap;
  }
  
  final MagicBrushView gQ(int paramInt)
  {
    AppMethodBeat.i(140086);
    MagicBrushView localMagicBrushView = this.cip.cxr.findOrNull(paramInt);
    if (localMagicBrushView == null)
    {
      com.github.henryye.nativeiv.a.b.e("MagicBrush", "findView [%d] but can not find. thread = [%s]", new Object[] { Integer.valueOf(paramInt), Thread.currentThread() });
      AppMethodBeat.o(140086);
      return null;
    }
    AppMethodBeat.o(140086);
    return localMagicBrushView;
  }
  
  public final Bitmap h(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(161140);
    if ((paramInt2 <= 0) && (!paramBoolean))
    {
      AppMethodBeat.o(161140);
      return null;
    }
    Object localObject = this.cip.Ht();
    p.g(localObject, "magicbrush.jsThreadHandler");
    if (((c)localObject).Cw())
    {
      localObject = k(paramInt1, paramInt2, paramBoolean);
      AppMethodBeat.o(161140);
      return localObject;
    }
    if (!paramBoolean)
    {
      localObject = i(paramInt1, paramInt2, paramBoolean);
      AppMethodBeat.o(161140);
      return localObject;
    }
    localObject = j(paramInt1, paramInt2, paramBoolean);
    AppMethodBeat.o(161140);
    return localObject;
  }
  
  @l(gjZ={1, 1, 13}, gka={""}, gkb={"Lcom/tencent/magicbrush/MBCanvasHandler$Companion;", "", "()V", "CAPTURE_TIMEOUT", "", "getCAPTURE_TIMEOUT", "()J", "TAG", "", "getTAG", "()Ljava/lang/String;", "lib-magicbrush-nano_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 13}, gka={""}, gkb={"<anonymous>", "Landroid/graphics/Bitmap;", "call"})
  static final class b<V>
    implements Callable<Bitmap>
  {
    b(b paramb, int paramInt1, int paramInt2, boolean paramBoolean) {}
  }
  
  @l(gjZ={1, 1, 13}, gka={""}, gkb={"com/tencent/magicbrush/MBCanvasHandler$captureCanvasOnOtherThreadWaitingSwapDone$ret$1", "Lcom/tencent/magicbrush/utils/ManualFinishableSyncTask;", "Landroid/graphics/Bitmap;", "run", "lib-magicbrush-nano_release"})
  public static final class c
    extends com.tencent.magicbrush.utils.d<Bitmap>
  {
    c(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong, Object paramObject)
    {
      super();
    }
    
    @l(gjZ={1, 1, 13}, gka={""}, gkb={"<anonymous>", "", "it", "", "beforeSwap"})
    static final class a
      implements MBRuntime.a
    {
      a(b.c paramc) {}
      
      public final void beforeSwap(boolean paramBoolean)
      {
        AppMethodBeat.i(161138);
        Object localObject = b.cws;
        c.c.i(b.access$getTAG$cp(), "hy: is swap all window: ".concat(String.valueOf(paramBoolean)), new Object[0]);
        localObject = b.a(this.cwx.cwt, this.cwx.cwu, this.cwx.cwv, this.cwx.cww);
        this.cwx.aG(localObject);
        AppMethodBeat.o(161138);
      }
    }
  }
  
  @l(gjZ={1, 1, 13}, gka={""}, gkb={"<anonymous>", "Landroid/graphics/Bitmap;", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<Bitmap>
  {
    d(MagicBrushView paramMagicBrushView, int paramInt1, int paramInt2, Bitmap paramBitmap)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.b
 * JD-Core Version:    0.7.0.1
 */