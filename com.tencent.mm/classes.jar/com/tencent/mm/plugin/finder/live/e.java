package com.tencent.mm.plugin.finder.live;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.live.utils.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.component.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/FinderLiveListPlayViewRecycler;", "Lcom/tencent/mm/plugin/finder/live/IFinderLiveListPlayViewRecycler;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "activityCount", "", "aliveActivitySet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "createdViews", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/finder/live/IFinderLivePlayView;", "isReleased", "", "preInflateCount", "recycledViews", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "attach", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "createView", "getOrCreateView", "onCleared", "preInflateViews", "recycleView", "view", "release", "Companion", "plugin-finder_release"})
public final class e
  extends i<PluginFinder>
{
  public static final a xVa;
  public boolean isReleased;
  private final MMHandler knk;
  public final HashSet<o> xUV;
  public final ConcurrentLinkedQueue<WeakReference<o>> xUW;
  public int xUX;
  public int xUY;
  public final HashSet<Integer> xUZ;
  
  static
  {
    AppMethodBeat.i(274964);
    xVa = new a((byte)0);
    AppMethodBeat.o(274964);
  }
  
  public e()
  {
    AppMethodBeat.i(274963);
    this.xUV = new HashSet();
    this.xUW = new ConcurrentLinkedQueue();
    this.knk = new MMHandler(Looper.getMainLooper());
    this.xUZ = new HashSet();
    AppMethodBeat.o(274963);
  }
  
  public final void a(o paramo)
  {
    AppMethodBeat.i(274959);
    p.k(paramo, "view");
    if (!(paramo instanceof FinderLivePlayView)) {}
    for (Object localObject = null;; localObject = paramo)
    {
      localObject = (FinderLivePlayView)localObject;
      if (localObject != null)
      {
        a locala = a.yRm;
        a.eC((View)localObject);
      }
      if (paramo.b(null))
      {
        paramo.stop();
        paramo.release();
      }
      this.xUV.add(paramo);
      AppMethodBeat.o(274959);
      return;
    }
  }
  
  public final o dwm()
  {
    AppMethodBeat.i(274960);
    Log.i("FinderLiveListPlayViewRecycler", "createView:");
    Object localObject = MMApplicationContext.getContext();
    p.j(localObject, "MMApplicationContext.getContext()");
    localObject = new FinderLivePlayView((Context)localObject);
    this.xUW.add(new WeakReference(localObject));
    localObject = (o)localObject;
    AppMethodBeat.o(274960);
    return localObject;
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(274962);
    super.onCleared();
    release();
    AppMethodBeat.o(274962);
  }
  
  public final void release()
  {
    AppMethodBeat.i(274961);
    this.xUZ.clear();
    this.isReleased = true;
    this.knk.post((Runnable)new d(this));
    AppMethodBeat.o(274961);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/FinderLiveListPlayViewRecycler$Companion;", "", "()V", "MAX_PRE_INFLATE_COUNT", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "queueIdle"})
  public static final class c
    implements MessageQueue.IdleHandler
  {
    public c(e parame) {}
    
    public final boolean queueIdle()
    {
      AppMethodBeat.i(276199);
      if ((e.c(this.xVb).size() < 2) && (!e.d(this.xVb)))
      {
        e.c(this.xVb).add(e.e(this.xVb));
        e locale = this.xVb;
        e.b(locale, e.f(locale) + 1);
        AppMethodBeat.o(276199);
        return true;
      }
      Log.i("FinderLiveListPlayViewRecycler", "[preInflateVideoView] completed! preInflateCount=" + e.f(this.xVb) + " isReleased=" + e.d(this.xVb));
      AppMethodBeat.o(276199);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(223701);
      Object localObject1 = new StringBuilder("onFinish createdViews ");
      Object localObject3 = (Iterable)e.g(this.xVb);
      Object localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(Integer.valueOf(((WeakReference)((Iterator)localObject3).next()).hashCode()));
      }
      Log.i("FinderLiveListPlayViewRecycler", (List)localObject2);
      localObject1 = ((Iterable)e.g(this.xVb)).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (o)((WeakReference)((Iterator)localObject1).next()).get();
        if (localObject2 != null)
        {
          ((o)localObject2).stop();
          ((o)localObject2).release();
        }
      }
      e.g(this.xVb).clear();
      e.c(this.xVb).clear();
      e.h(this.xVb).removeCallbacksAndMessages(null);
      AppMethodBeat.o(223701);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.e
 * JD-Core Version:    0.7.0.1
 */