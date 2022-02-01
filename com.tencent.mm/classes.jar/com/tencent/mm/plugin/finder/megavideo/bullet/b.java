package com.tencent.mm.plugin.finder.megavideo.bullet;

import android.content.Context;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/bullet/MegaVideoBulletThreadManager;", "", "()V", "attachContextSet", "Ljava/util/HashSet;", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "Lkotlin/collections/HashSet;", "megaVideoBulletDrawThread", "Landroid/os/HandlerThread;", "getMegaVideoBulletDrawThread", "()Landroid/os/HandlerThread;", "setMegaVideoBulletDrawThread", "(Landroid/os/HandlerThread;)V", "megaVideoBulletMeasureThread", "getMegaVideoBulletMeasureThread", "setMegaVideoBulletMeasureThread", "attach", "", "context", "detach", "initThreads", "isInitial", "", "releaseThreads", "Companion", "plugin-finder_release"})
public final class b
{
  private static final f uJY;
  public static final b.a uJZ;
  public HandlerThread uJW;
  private final HashSet<WeakReference<Context>> uJX;
  
  static
  {
    AppMethodBeat.i(248263);
    uJZ = new b.a((byte)0);
    uJY = g.ah((a)b.uKa);
    AppMethodBeat.o(248263);
  }
  
  public b()
  {
    AppMethodBeat.i(248262);
    this.uJX = new HashSet();
    AppMethodBeat.o(248262);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/megavideo/bullet/MegaVideoBulletThreadManager;", "invoke"})
  static final class b
    extends q
    implements a<b>
  {
    public static final b uKa;
    
    static
    {
      AppMethodBeat.i(248261);
      uKa = new b();
      AppMethodBeat.o(248261);
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