package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "mFeedFlowCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowCallback;", "mFeedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FeedMonitor;", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mListener$1;", "mSmoothListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mSmoothListener$1;", "convertState", "", "scrollState", "free", "", "report", "startMonitor", "stopMonitor", "Companion", "plugin-expt_release"})
public final class f
  implements o
{
  public static final f.a wjm;
  private WeakReference<Activity> mActivityRef;
  private final a wiZ;
  private com.tencent.mm.plugin.expt.hellhound.a.a.a wja;
  private final b wjk;
  private final c wjl;
  
  static
  {
    AppMethodBeat.i(258240);
    wjm = new f.a((byte)0);
    AppMethodBeat.o(258240);
  }
  
  public f(Activity paramActivity)
  {
    AppMethodBeat.i(258239);
    this.wiZ = new a();
    this.wja = new com.tencent.mm.plugin.expt.hellhound.a.a.a(10, "18260", "1010");
    this.mActivityRef = new WeakReference(paramActivity);
    this.wjk = new b(this);
    this.wjl = new c(this);
    AppMethodBeat.o(258239);
  }
  
  public final void free()
  {
    AppMethodBeat.i(258238);
    WeakReference localWeakReference = this.mActivityRef;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.mActivityRef = null;
    AppMethodBeat.o(258238);
  }
  
  public final void report() {}
  
  public final void startMonitor()
  {
    AppMethodBeat.i(258236);
    Log.d("HABBYGE-MALI.FinderFollowMonitor", "startMonitor");
    this.wiZ.a((com.tencent.mm.plugin.expt.hellhound.a.a.f)this.wjk, (p)this.wjl);
    com.tencent.mm.plugin.expt.hellhound.a.a.a locala;
    if (this.mActivityRef != null)
    {
      locala = this.wja;
      localObject = this.mActivityRef;
      if (localObject == null) {
        break label74;
      }
    }
    label74:
    for (Object localObject = (Activity)((WeakReference)localObject).get();; localObject = null)
    {
      locala.a(4, (Activity)localObject);
      AppMethodBeat.o(258236);
      return;
    }
  }
  
  public final void stopMonitor()
  {
    AppMethodBeat.i(258237);
    Log.d("HABBYGE-MALI.FinderFollowMonitor", "stopMonitor");
    this.wja.a(5, null);
    this.wiZ.stopMonitor();
    AppMethodBeat.o(258237);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/IFeedOnScrollListener;", "onScroll", "", "listView", "Landroid/view/ViewGroup;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "dx", "dy", "onScrollStateChanged", "scrollState", "plugin-expt_release"})
  public static final class b
    implements com.tencent.mm.plugin.expt.hellhound.a.a.f
  {
    public final void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(254486);
      Object localObject = f.b(this.wjn);
      StringBuilder localStringBuilder;
      if (localObject != null)
      {
        localObject = (Activity)((WeakReference)localObject).get();
        if ((localObject != null) && (!((Activity)localObject).isFinishing()) && (!((Activity)localObject).isDestroyed())) {
          break label116;
        }
        localStringBuilder = new StringBuilder("onScroll, is NULL or finishing: ");
        if (localObject == null) {
          break label111;
        }
        paramViewGroup = localObject.getClass();
        if (paramViewGroup == null) {
          break label111;
        }
      }
      label111:
      for (paramViewGroup = paramViewGroup.getName();; paramViewGroup = null)
      {
        Log.printInfoStack("HABBYGE-MALI.FinderFollowMonitor", paramViewGroup, new Object[0]);
        AppMethodBeat.o(254486);
        return;
        localObject = null;
        break;
      }
      label116:
      f.a(this.wjn).a((Activity)localObject, paramViewGroup, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(254486);
    }
    
    public final void k(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(254483);
      f.a(this.wjn).g(paramViewGroup, f.KL(paramInt));
      AppMethodBeat.o(254483);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFinderSmoothListener;", "scrollToPosition", "", "postion2Zero", "", "smoothScrollToPosition", "position", "", "plugin-expt_release"})
  public static final class c
    implements p
  {
    public final void np(boolean paramBoolean)
    {
      AppMethodBeat.i(253820);
      Log.d("HABBYGE-MALI.FinderFollowMonitor", "scrollToPosition: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      f.a(this.wjn).no(paramBoolean);
      AppMethodBeat.o(253820);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.f
 * JD-Core Version:    0.7.0.1
 */