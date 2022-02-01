package com.tencent.mm.plugin.expt.hellhound.ext.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "mFeedFlowCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowCallback;", "mFeedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FeedMonitor;", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mListener$1;", "mSmoothListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mSmoothListener$1;", "convertState", "", "scrollState", "free", "", "report", "startMonitor", "stopMonitor", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements o
{
  public static final f.a zFn;
  private WeakReference<Activity> mActivityRef;
  private final a zFc;
  private com.tencent.mm.plugin.expt.hellhound.ext.a.a zFd;
  private final b zFo;
  private final c zFp;
  
  static
  {
    AppMethodBeat.i(300441);
    zFn = new f.a((byte)0);
    AppMethodBeat.o(300441);
  }
  
  public f(Activity paramActivity)
  {
    AppMethodBeat.i(300417);
    this.zFc = new a();
    this.zFd = new com.tencent.mm.plugin.expt.hellhound.ext.a.a(10, "18260", "1010");
    this.mActivityRef = new WeakReference(paramActivity);
    this.zFo = new b(this);
    this.zFp = new c(this);
    AppMethodBeat.o(300417);
  }
  
  public final void free()
  {
    AppMethodBeat.i(300472);
    WeakReference localWeakReference = this.mActivityRef;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.mActivityRef = null;
    AppMethodBeat.o(300472);
  }
  
  public final void report() {}
  
  public final void startMonitor()
  {
    AppMethodBeat.i(300449);
    Log.d("HABBYGE-MALI.FinderFollowMonitor", "startMonitor");
    this.zFc.a((com.tencent.mm.plugin.expt.hellhound.ext.a.f)this.zFo, (p)this.zFp);
    com.tencent.mm.plugin.expt.hellhound.ext.a.a locala;
    if (this.mActivityRef != null)
    {
      locala = this.zFd;
      localObject = this.mActivityRef;
      if (localObject != null) {
        break label68;
      }
    }
    label68:
    for (Object localObject = null;; localObject = (Activity)((WeakReference)localObject).get())
    {
      locala.a(4, (Activity)localObject);
      AppMethodBeat.o(300449);
      return;
    }
  }
  
  public final void stopMonitor()
  {
    AppMethodBeat.i(300460);
    Log.d("HABBYGE-MALI.FinderFollowMonitor", "stopMonitor");
    this.zFd.a(5, null);
    this.zFc.stopMonitor();
    AppMethodBeat.o(300460);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/IFeedOnScrollListener;", "onScroll", "", "listView", "Landroid/view/ViewGroup;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "dx", "dy", "onScrollStateChanged", "scrollState", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.plugin.expt.hellhound.ext.a.f
  {
    b(f paramf) {}
    
    public final void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(300538);
      Object localObject = f.b(this.zFq);
      if (localObject == null)
      {
        localObject = null;
        if ((localObject != null) && (!((Activity)localObject).isFinishing()) && (!((Activity)localObject).isDestroyed())) {
          break label107;
        }
        if (localObject != null) {
          break label84;
        }
        paramViewGroup = null;
      }
      for (;;)
      {
        Log.printInfoStack("HABBYGE-MALI.FinderFollowMonitor", s.X("onScroll, is NULL or finishing: ", paramViewGroup), new Object[0]);
        AppMethodBeat.o(300538);
        return;
        localObject = (Activity)((WeakReference)localObject).get();
        break;
        label84:
        paramViewGroup = localObject.getClass();
        if (paramViewGroup == null) {
          paramViewGroup = null;
        } else {
          paramViewGroup = paramViewGroup.getName();
        }
      }
      label107:
      f.a(this.zFq).a((Activity)localObject, paramViewGroup, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(300538);
    }
    
    public final void k(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(300530);
      f.a(this.zFq).g(paramViewGroup, f.LK(paramInt));
      AppMethodBeat.o(300530);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFinderSmoothListener;", "scrollToPosition", "", "postion2Zero", "", "smoothScrollToPosition", "position", "", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements p
  {
    c(f paramf) {}
    
    public final void oP(boolean paramBoolean)
    {
      AppMethodBeat.i(300529);
      Log.d("HABBYGE-MALI.FinderFollowMonitor", "scrollToPosition: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      f.a(this.zFq).oO(paramBoolean);
      AppMethodBeat.o(300529);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.a.f
 * JD-Core Version:    0.7.0.1
 */