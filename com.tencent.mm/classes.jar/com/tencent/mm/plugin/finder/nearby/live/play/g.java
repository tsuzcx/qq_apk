package com.tencent.mm.plugin.finder.nearby.live.play;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.component.n;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLivePlayerViewRecycler;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "activityCount", "", "aliveActivitySet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "createdViews", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLivePreviewView;", "isReleased", "", "preInflateCount", "recycledViews", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "attach", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "createView", "getOrCreate", "onCleared", "preInflateViews", "recycleView", "view", "release", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends n<PluginFinder>
{
  public static final a ELb;
  private final HashSet<NearbyLivePreviewView> EKc;
  private final ConcurrentLinkedQueue<WeakReference<NearbyLivePreviewView>> EKd;
  private int EKe;
  private int EKf;
  private final HashSet<Integer> EKg;
  private boolean isReleased;
  private final MMHandler mRi;
  
  static
  {
    AppMethodBeat.i(340999);
    ELb = new a((byte)0);
    AppMethodBeat.o(340999);
  }
  
  public g()
  {
    AppMethodBeat.i(340927);
    this.EKc = new HashSet();
    this.EKd = new ConcurrentLinkedQueue();
    this.mRi = new MMHandler(Looper.getMainLooper());
    this.EKg = new HashSet();
    AppMethodBeat.o(340927);
  }
  
  private static final boolean a(g paramg)
  {
    AppMethodBeat.i(340956);
    s.u(paramg, "this$0");
    if ((paramg.EKc.size() < 2) && (!paramg.isReleased))
    {
      paramg.EKc.add(paramg.eFi());
      paramg.EKe += 1;
      AppMethodBeat.o(340956);
      return true;
    }
    Log.i("NearbyLivePlayerViewRecycler", "[preInflateVideoView] completed! preInflateCount=" + paramg.EKe + " isReleased=" + paramg.isReleased);
    AppMethodBeat.o(340956);
    return false;
  }
  
  private static final void b(g paramg)
  {
    AppMethodBeat.i(340968);
    s.u(paramg, "this$0");
    Object localObject2 = (Iterable)paramg.EKd;
    Object localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(Integer.valueOf(((WeakReference)((Iterator)localObject2).next()).hashCode()));
    }
    Log.i("NearbyLivePlayerViewRecycler", s.X("onFinish createdViews ", (List)localObject1));
    localObject1 = ((Iterable)paramg.EKd).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (NearbyLivePreviewView)((WeakReference)((Iterator)localObject1).next()).get();
      if (localObject2 != null)
      {
        ((NearbyLivePreviewView)localObject2).stop();
        ((NearbyLivePreviewView)localObject2).release();
      }
    }
    paramg.EKd.clear();
    paramg.EKc.clear();
    paramg.mRi.removeCallbacksAndMessages(null);
    AppMethodBeat.o(340968);
  }
  
  private final void eFg()
  {
    AppMethodBeat.i(340934);
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.EKe = this.EKc.size();
      Looper.getMainLooper().getQueue().addIdleHandler(new g..ExternalSyntheticLambda0(this));
    }
    AppMethodBeat.o(340934);
  }
  
  private final NearbyLivePreviewView eFi()
  {
    AppMethodBeat.i(340945);
    Object localObject = MMApplicationContext.getContext();
    s.s(localObject, "getContext()");
    localObject = new NearbyLivePreviewView((Context)localObject);
    this.EKd.add(new WeakReference(localObject));
    Log.i("NearbyLivePlayerViewRecycler", s.X("createView view:", localObject));
    AppMethodBeat.o(340945);
    return localObject;
  }
  
  public final void a(AppCompatActivity paramAppCompatActivity)
  {
    AppMethodBeat.i(341036);
    s.u(paramAppCompatActivity, "activity");
    if (this.EKf == 0)
    {
      this.isReleased = false;
      eFg();
    }
    if (this.EKg.add(Integer.valueOf(paramAppCompatActivity.hashCode())))
    {
      this.EKf += 1;
      paramAppCompatActivity.getLifecycle().addObserver((androidx.lifecycle.p)new NearbyLivePlayerViewRecycler.attach.1(this, paramAppCompatActivity));
    }
    AppMethodBeat.o(341036);
  }
  
  public final void b(NearbyLivePreviewView paramNearbyLivePreviewView)
  {
    AppMethodBeat.i(341063);
    s.u(paramNearbyLivePreviewView, "view");
    if (paramNearbyLivePreviewView.getParent() != null)
    {
      ViewParent localViewParent = paramNearbyLivePreviewView.getParent();
      if (localViewParent == null)
      {
        paramNearbyLivePreviewView = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(341063);
        throw paramNearbyLivePreviewView;
      }
      ((ViewGroup)localViewParent).removeView((View)paramNearbyLivePreviewView);
    }
    if (paramNearbyLivePreviewView.getPlayer() == null)
    {
      Log.w("NearbyLivePlayerViewRecycler", "recycleView view:" + paramNearbyLivePreviewView + " return for player:" + paramNearbyLivePreviewView.getPlayer());
      AppMethodBeat.o(341063);
      return;
    }
    if (paramNearbyLivePreviewView.isPlaying())
    {
      paramNearbyLivePreviewView.stop();
      paramNearbyLivePreviewView.release();
    }
    this.EKc.add(paramNearbyLivePreviewView);
    Log.i("NearbyLivePlayerViewRecycler", "recycleView view:" + paramNearbyLivePreviewView + " isPlaying:" + paramNearbyLivePreviewView.isPlaying() + " size:" + this.EKc.size());
    AppMethodBeat.o(341063);
  }
  
  public final NearbyLivePreviewView eFh()
  {
    AppMethodBeat.i(341053);
    NearbyLivePreviewView localNearbyLivePreviewView = (NearbyLivePreviewView)d.a(this.EKc, (b)b.ELd);
    if (localNearbyLivePreviewView == null) {
      localNearbyLivePreviewView = null;
    }
    while (localNearbyLivePreviewView == null)
    {
      localNearbyLivePreviewView = ((g)this).eFi();
      AppMethodBeat.o(341053);
      return localNearbyLivePreviewView;
      Log.i("NearbyLivePlayerViewRecycler", "getOrCreate: get view success, view.hashcode = " + localNearbyLivePreviewView.hashCode() + " recycledViews.size = " + this.EKc.size());
    }
    AppMethodBeat.o(341053);
    return localNearbyLivePreviewView;
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(341081);
    super.onCleared();
    release();
    AppMethodBeat.o(341081);
  }
  
  public final void release()
  {
    AppMethodBeat.i(341075);
    this.EKg.clear();
    this.isReleased = true;
    this.mRi.post(new g..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(341075);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLivePlayerViewRecycler$Companion;", "", "()V", "MAX_PRE_INFLATE_COUNT", "", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLivePreviewView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<NearbyLivePreviewView, Boolean>
  {
    public static final b ELd;
    
    static
    {
      AppMethodBeat.i(340970);
      ELd = new b();
      AppMethodBeat.o(340970);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.play.g
 * JD-Core Version:    0.7.0.1
 */