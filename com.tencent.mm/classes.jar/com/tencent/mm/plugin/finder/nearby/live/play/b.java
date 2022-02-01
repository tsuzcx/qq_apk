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
import com.tencent.mm.plugin.findersdk.a.al;
import com.tencent.mm.plugin.findersdk.a.am;
import com.tencent.mm.plugin.findersdk.a.cn;
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
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/play/FinderLiveCardPlayerViewRecycler;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/findersdk/api/IPluginFinder;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveCardPlayerViewRecycler;", "()V", "activityCount", "", "aliveActivitySet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "createdViews", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/finder/nearby/live/play/FinderLiveCardPreviewView;", "isReleased", "", "preInflateCount", "recycledViews", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "attach", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "createView", "getOrCreate", "onCleared", "preInflateViews", "recycleView", "view", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveCardPreviewView;", "release", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends n<cn>
  implements al
{
  public static final a EKb;
  final HashSet<FinderLiveCardPreviewView> EKc;
  private final ConcurrentLinkedQueue<WeakReference<FinderLiveCardPreviewView>> EKd;
  private int EKe;
  private int EKf;
  private final HashSet<Integer> EKg;
  private boolean isReleased;
  private final MMHandler mRi;
  
  static
  {
    AppMethodBeat.i(341033);
    EKb = new a((byte)0);
    AppMethodBeat.o(341033);
  }
  
  public b()
  {
    AppMethodBeat.i(340994);
    this.EKc = new HashSet();
    this.EKd = new ConcurrentLinkedQueue();
    this.mRi = new MMHandler(Looper.getMainLooper());
    this.EKg = new HashSet();
    AppMethodBeat.o(340994);
  }
  
  private static final boolean a(b paramb)
  {
    AppMethodBeat.i(341000);
    s.u(paramb, "this$0");
    if ((paramb.EKc.size() < 2) && (!paramb.isReleased))
    {
      paramb.EKc.add(paramb.eEV());
      paramb.EKe += 1;
      AppMethodBeat.o(341000);
      return true;
    }
    Log.i("FinderLiveCardPlayerViewRecycler", "[preInflateVideoView] completed! preInflateCount=" + paramb.EKe + " isReleased=" + paramb.isReleased);
    AppMethodBeat.o(341000);
    return false;
  }
  
  private static final void b(b paramb)
  {
    AppMethodBeat.i(341011);
    s.u(paramb, "this$0");
    Object localObject2 = (Iterable)paramb.EKd;
    Object localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(Integer.valueOf(((WeakReference)((Iterator)localObject2).next()).hashCode()));
    }
    Log.i("FinderLiveCardPlayerViewRecycler", s.X("onFinish createdViews ", (List)localObject1));
    localObject1 = ((Iterable)paramb.EKd).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FinderLiveCardPreviewView)((WeakReference)((Iterator)localObject1).next()).get();
      if (localObject2 != null)
      {
        ((FinderLiveCardPreviewView)localObject2).stop();
        ((FinderLiveCardPreviewView)localObject2).release();
      }
    }
    paramb.EKd.clear();
    paramb.EKc.clear();
    paramb.mRi.removeCallbacksAndMessages(null);
    AppMethodBeat.o(341011);
  }
  
  public final void a(AppCompatActivity paramAppCompatActivity)
  {
    AppMethodBeat.i(341056);
    s.u(paramAppCompatActivity, "activity");
    if (this.EKf == 0)
    {
      this.isReleased = false;
      if (Build.VERSION.SDK_INT >= 23)
      {
        this.EKe = this.EKc.size();
        Looper.getMainLooper().getQueue().addIdleHandler(new b..ExternalSyntheticLambda0(this));
      }
    }
    if (this.EKg.add(Integer.valueOf(paramAppCompatActivity.hashCode())))
    {
      this.EKf += 1;
      paramAppCompatActivity.getLifecycle().addObserver((androidx.lifecycle.p)new FinderLiveCardPlayerViewRecycler.attach.1(this, paramAppCompatActivity));
    }
    AppMethodBeat.o(341056);
  }
  
  public final void a(am paramam)
  {
    AppMethodBeat.i(341067);
    s.u(paramam, "view");
    if (paramam.eFa().getParent() != null)
    {
      ViewParent localViewParent = paramam.eFa().getParent();
      if (localViewParent == null)
      {
        paramam = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(341067);
        throw paramam;
      }
      ((ViewGroup)localViewParent).removeView(paramam.eFa());
    }
    if (paramam.isPlaying())
    {
      paramam.stop();
      paramam.release();
    }
    this.EKc.add((FinderLiveCardPreviewView)paramam);
    AppMethodBeat.o(341067);
  }
  
  final FinderLiveCardPreviewView eEV()
  {
    AppMethodBeat.i(341059);
    Log.i("FinderLiveCardPlayerViewRecycler", "createView:");
    Object localObject = MMApplicationContext.getContext();
    s.s(localObject, "getContext()");
    localObject = new FinderLiveCardPreviewView((Context)localObject);
    this.EKd.add(new WeakReference(localObject));
    AppMethodBeat.o(341059);
    return localObject;
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(341079);
    super.onCleared();
    release();
    AppMethodBeat.o(341079);
  }
  
  public final void release()
  {
    AppMethodBeat.i(341074);
    this.EKg.clear();
    this.isReleased = true;
    this.mRi.post(new b..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(341074);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/play/FinderLiveCardPlayerViewRecycler$Companion;", "", "()V", "MAX_PRE_INFLATE_COUNT", "", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.play.b
 * JD-Core Version:    0.7.0.1
 */