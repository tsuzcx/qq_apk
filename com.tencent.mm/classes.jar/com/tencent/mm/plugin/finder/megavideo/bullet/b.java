package com.tencent.mm.plugin.finder.megavideo.bullet;

import android.content.Context;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/bullet/MegaVideoBulletThreadManager;", "", "()V", "attachContextSet", "Ljava/util/HashSet;", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "Lkotlin/collections/HashSet;", "megaVideoBulletDrawThread", "Landroid/os/HandlerThread;", "getMegaVideoBulletDrawThread", "()Landroid/os/HandlerThread;", "setMegaVideoBulletDrawThread", "(Landroid/os/HandlerThread;)V", "megaVideoBulletMeasureThread", "getMegaVideoBulletMeasureThread", "setMegaVideoBulletMeasureThread", "attach", "", "context", "detach", "initThreads", "isInitial", "", "releaseThreads", "Companion", "plugin-finder_release"})
public final class b
{
  private static final f zvG;
  public static final b.a zvH;
  public HandlerThread zvD;
  public HandlerThread zvE;
  public final HashSet<WeakReference<Context>> zvF;
  
  static
  {
    AppMethodBeat.i(267716);
    zvH = new b.a((byte)0);
    zvG = g.ar((a)b.zvI);
    AppMethodBeat.o(267716);
  }
  
  public b()
  {
    AppMethodBeat.i(267715);
    this.zvF = new HashSet();
    AppMethodBeat.o(267715);
  }
  
  public final void dJy()
  {
    AppMethodBeat.i(267714);
    HandlerThread localHandlerThread = this.zvD;
    if (localHandlerThread != null) {
      localHandlerThread.quitSafely();
    }
    localHandlerThread = this.zvE;
    if (localHandlerThread != null) {
      localHandlerThread.quitSafely();
    }
    this.zvD = null;
    this.zvE = null;
    AppMethodBeat.o(267714);
  }
  
  public final void fB(Context paramContext)
  {
    AppMethodBeat.i(267712);
    p.k(paramContext, "context");
    if ((this.zvD != null) && (this.zvE != null)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        dJy();
        this.zvD = new HandlerThread("MegaVideoBulletDrawThread");
        HandlerThread localHandlerThread = this.zvD;
        if (localHandlerThread != null) {
          localHandlerThread.setUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)new com.tencent.mm.danmaku.e.b());
        }
        localHandlerThread = this.zvD;
        if (localHandlerThread != null) {
          localHandlerThread.start();
        }
        this.zvE = new HandlerThread("megaVideoBulletMeasureThread");
        localHandlerThread = this.zvE;
        if (localHandlerThread != null) {
          localHandlerThread.setUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)new com.tencent.mm.danmaku.e.b());
        }
        localHandlerThread = this.zvE;
        if (localHandlerThread != null) {
          localHandlerThread.start();
        }
      }
      Log.i("MegaVideoBulletThreadManager", "attach: context = ".concat(String.valueOf(paramContext)));
      this.zvF.add(new WeakReference(paramContext));
      AppMethodBeat.o(267712);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/megavideo/bullet/MegaVideoBulletThreadManager;", "invoke"})
  static final class b
    extends q
    implements a<b>
  {
    public static final b zvI;
    
    static
    {
      AppMethodBeat.i(272931);
      zvI = new b();
      AppMethodBeat.o(272931);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.bullet.b
 * JD-Core Version:    0.7.0.1
 */