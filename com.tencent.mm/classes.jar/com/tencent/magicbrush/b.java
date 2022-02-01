package com.tencent.magicbrush;

import android.graphics.Bitmap;
import com.tencent.magicbrush.a.c.c;
import com.tencent.magicbrush.handler.c;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import java.util.concurrent.Callable;

@d.l(fNY={1, 1, 13}, fNZ={""}, fOa={"Lcom/tencent/magicbrush/MBCanvasHandler;", "", "magicbrush", "Lcom/tencent/magicbrush/MagicBrush;", "(Lcom/tencent/magicbrush/MagicBrush;)V", "getMagicbrush", "()Lcom/tencent/magicbrush/MagicBrush;", "captureCanvas", "Landroid/graphics/Bitmap;", "windowId", "", "canvasId", "isWindow", "", "captureCanvasOnJsThread", "captureCanvasOnOtherThread", "captureCanvasOnOtherThreadWaitingSwapDone", "captureDefaultWindow", "cache", "captureScreenCanvas", "virtualElementId", "width", "height", "bitmap", "captureWindow", "findViewOrNull", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "Companion", "lib-magicbrush-nano_release"})
public final class b
{
  private static final String TAG = "MagicBrush.MBCanvasHandler";
  private static final long cll = 2500L;
  public static final a clm;
  final d bXV;
  
  static
  {
    AppMethodBeat.i(161144);
    clm = new a((byte)0);
    TAG = "MagicBrush.MBCanvasHandler";
    cll = 2500L;
    AppMethodBeat.o(161144);
  }
  
  public b(d paramd)
  {
    AppMethodBeat.i(140087);
    this.bXV = paramd;
    AppMethodBeat.o(140087);
  }
  
  private final Bitmap i(final int paramInt1, final int paramInt2, final boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(161141);
    c.c.i("MagicBrush", "captureCanvasOnOtherThread", new Object[0]);
    Bitmap localBitmap = (Bitmap)this.bXV.FT().b((Callable)new b(this, paramInt1, paramInt2, paramBoolean));
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
    Bitmap localBitmap = (Bitmap)new c(this, paramInt1, paramInt2, paramBoolean, cll).b((com.tencent.magicbrush.handler.a)this.bXV.FT());
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
    Bitmap localBitmap = this.bXV.h(paramInt1, paramInt2, paramBoolean);
    AppMethodBeat.o(161143);
    return localBitmap;
  }
  
  final MagicBrushView gK(int paramInt)
  {
    AppMethodBeat.i(140086);
    MagicBrushView localMagicBrushView = this.bXV.cmk.findOrNull(paramInt);
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
    Object localObject = this.bXV.FT();
    k.g(localObject, "magicbrush.jsThreadHandler");
    if (((c)localObject).AU())
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
  
  @d.l(fNY={1, 1, 13}, fNZ={""}, fOa={"Lcom/tencent/magicbrush/MBCanvasHandler$Companion;", "", "()V", "CAPTURE_TIMEOUT", "", "getCAPTURE_TIMEOUT", "()J", "TAG", "", "getTAG", "()Ljava/lang/String;", "lib-magicbrush-nano_release"})
  public static final class a {}
  
  @d.l(fNY={1, 1, 13}, fNZ={""}, fOa={"<anonymous>", "Landroid/graphics/Bitmap;", "call"})
  static final class b<V>
    implements Callable<Bitmap>
  {
    b(b paramb, int paramInt1, int paramInt2, boolean paramBoolean) {}
  }
  
  @d.l(fNY={1, 1, 13}, fNZ={""}, fOa={"com/tencent/magicbrush/MBCanvasHandler$captureCanvasOnOtherThreadWaitingSwapDone$ret$1", "Lcom/tencent/magicbrush/utils/ManualFinishableSyncTask;", "Landroid/graphics/Bitmap;", "run", "lib-magicbrush-nano_release"})
  public static final class c
    extends com.tencent.magicbrush.utils.d<Bitmap>
  {
    c(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong, Object paramObject)
    {
      super();
    }
    
    @d.l(fNY={1, 1, 13}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "beforeSwap"})
    static final class a
      implements MBRuntime.a
    {
      a(b.c paramc) {}
      
      public final void beforeSwap(boolean paramBoolean)
      {
        AppMethodBeat.i(161138);
        Object localObject = b.clm;
        c.c.i(b.access$getTAG$cp(), "hy: is swap all window: ".concat(String.valueOf(paramBoolean)), new Object[0]);
        localObject = b.a(this.clr.cln, this.clr.clo, this.clr.clp, this.clr.clq);
        this.clr.aE(localObject);
        AppMethodBeat.o(161138);
      }
    }
  }
  
  @d.l(fNY={1, 1, 13}, fNZ={""}, fOa={"<anonymous>", "Landroid/graphics/Bitmap;", "invoke"})
  static final class d
    extends d.g.b.l
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