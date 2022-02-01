package com.tencent.mm.plugin.finder.nearby.live.play;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.h;
import androidx.lifecycle.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.PluginFinder;
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
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLivePlayerViewRecycler;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "activityCount", "", "aliveActivitySet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "createdViews", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLivePreviewView;", "isReleased", "", "preInflateCount", "recycledViews", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "attach", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "createView", "getOrCreate", "onCleared", "preInflateViews", "recycleView", "view", "release", "Companion", "plugin-finder-nearby_release"})
public final class f
  extends i<PluginFinder>
{
  public static final a zFH;
  private boolean isReleased;
  private final MMHandler knk;
  final HashSet<NearbyLivePreviewView> xUV;
  private final ConcurrentLinkedQueue<WeakReference<NearbyLivePreviewView>> xUW;
  private int xUX;
  private int xUY;
  private final HashSet<Integer> xUZ;
  
  static
  {
    AppMethodBeat.i(202620);
    zFH = new a((byte)0);
    AppMethodBeat.o(202620);
  }
  
  public f()
  {
    AppMethodBeat.i(202619);
    this.xUV = new HashSet();
    this.xUW = new ConcurrentLinkedQueue();
    this.knk = new MMHandler(Looper.getMainLooper());
    this.xUZ = new HashSet();
    AppMethodBeat.o(202619);
  }
  
  private final void dLS()
  {
    AppMethodBeat.i(202607);
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.xUX = this.xUV.size();
      Looper localLooper = Looper.getMainLooper();
      p.j(localLooper, "Looper.getMainLooper()");
      localLooper.getQueue().addIdleHandler((MessageQueue.IdleHandler)new c(this));
    }
    AppMethodBeat.o(202607);
  }
  
  private final NearbyLivePreviewView dLU()
  {
    AppMethodBeat.i(202613);
    Log.i("NearbyLivePlayerViewRecycler", "createView:");
    Object localObject = MMApplicationContext.getContext();
    p.j(localObject, "MMApplicationContext.getContext()");
    localObject = new NearbyLivePreviewView((Context)localObject);
    this.xUW.add(new WeakReference(localObject));
    AppMethodBeat.o(202613);
    return localObject;
  }
  
  public final void a(AppCompatActivity paramAppCompatActivity)
  {
    AppMethodBeat.i(202606);
    p.k(paramAppCompatActivity, "activity");
    if (this.xUY == 0)
    {
      this.isReleased = false;
      dLS();
    }
    if (this.xUZ.add(Integer.valueOf(paramAppCompatActivity.hashCode())))
    {
      this.xUY += 1;
      paramAppCompatActivity.getLifecycle().a((k)new NearbyLivePlayerViewRecycler.attach.1(this, paramAppCompatActivity));
    }
    AppMethodBeat.o(202606);
  }
  
  public final NearbyLivePreviewView dLT()
  {
    AppMethodBeat.i(202611);
    NearbyLivePreviewView localNearbyLivePreviewView2 = (NearbyLivePreviewView)d.a(this.xUV, (b)b.zFJ);
    NearbyLivePreviewView localNearbyLivePreviewView1;
    if (localNearbyLivePreviewView2 != null)
    {
      Log.i("NearbyLivePlayerViewRecycler", "getOrCreate: get view success, view.hashcode = " + localNearbyLivePreviewView2.hashCode() + " recycledViews.size = " + this.xUV.size());
      localNearbyLivePreviewView1 = localNearbyLivePreviewView2;
      if (localNearbyLivePreviewView2 != null) {}
    }
    else
    {
      localNearbyLivePreviewView1 = ((f)this).dLU();
    }
    AppMethodBeat.o(202611);
    return localNearbyLivePreviewView1;
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(202617);
    super.onCleared();
    release();
    AppMethodBeat.o(202617);
  }
  
  public final void release()
  {
    AppMethodBeat.i(202616);
    this.xUZ.clear();
    this.isReleased = true;
    this.knk.post((Runnable)new d(this));
    AppMethodBeat.o(202616);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLivePlayerViewRecycler$Companion;", "", "()V", "MAX_PRE_INFLATE_COUNT", "", "TAG", "", "plugin-finder-nearby_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLivePreviewView;", "invoke"})
  static final class b
    extends q
    implements b<NearbyLivePreviewView, Boolean>
  {
    public static final b zFJ;
    
    static
    {
      AppMethodBeat.i(202678);
      zFJ = new b();
      AppMethodBeat.o(202678);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "queueIdle"})
  static final class c
    implements MessageQueue.IdleHandler
  {
    c(f paramf) {}
    
    public final boolean queueIdle()
    {
      AppMethodBeat.i(201507);
      if ((f.c(this.zFI).size() < 2) && (!f.d(this.zFI)))
      {
        f.c(this.zFI).add(f.e(this.zFI));
        f localf = this.zFI;
        f.b(localf, f.f(localf) + 1);
        AppMethodBeat.o(201507);
        return true;
      }
      Log.i("NearbyLivePlayerViewRecycler", "[preInflateVideoView] completed! preInflateCount=" + f.f(this.zFI) + " isReleased=" + f.d(this.zFI));
      AppMethodBeat.o(201507);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(200348);
      Object localObject1 = new StringBuilder("onFinish createdViews ");
      Object localObject3 = (Iterable)f.g(this.zFI);
      Object localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(Integer.valueOf(((WeakReference)((Iterator)localObject3).next()).hashCode()));
      }
      Log.i("NearbyLivePlayerViewRecycler", (List)localObject2);
      localObject1 = ((Iterable)f.g(this.zFI)).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (NearbyLivePreviewView)((WeakReference)((Iterator)localObject1).next()).get();
        if (localObject2 != null)
        {
          ((NearbyLivePreviewView)localObject2).stop();
          ((NearbyLivePreviewView)localObject2).release();
        }
      }
      f.g(this.zFI).clear();
      f.c(this.zFI).clear();
      f.h(this.zFI).removeCallbacksAndMessages(null);
      AppMethodBeat.o(200348);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.play.f
 * JD-Core Version:    0.7.0.1
 */