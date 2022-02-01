package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "mFeedFlowCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowCallback;", "mFeedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FeedMonitor;", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mListener$1;", "mSmoothListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mSmoothListener$1;", "convertState", "", "scrollState", "free", "", "report", "startMonitor", "stopMonitor", "Companion", "plugin-expt_release"})
public final class f
  implements o
{
  public static final f.a sDs;
  private WeakReference<Activity> mActivityRef;
  private final a sDf;
  private com.tencent.mm.plugin.expt.hellhound.a.a.a sDg;
  private final b sDq;
  private final c sDr;
  
  static
  {
    AppMethodBeat.i(220861);
    sDs = new f.a((byte)0);
    AppMethodBeat.o(220861);
  }
  
  public f(Activity paramActivity)
  {
    AppMethodBeat.i(220860);
    this.sDf = new a();
    this.sDg = new com.tencent.mm.plugin.expt.hellhound.a.a.a(10, "18260", "1010");
    this.mActivityRef = new WeakReference(paramActivity);
    this.sDq = new b(this);
    this.sDr = new c(this);
    AppMethodBeat.o(220860);
  }
  
  public final void free()
  {
    AppMethodBeat.i(220859);
    WeakReference localWeakReference = this.mActivityRef;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.mActivityRef = null;
    AppMethodBeat.o(220859);
  }
  
  public final void report() {}
  
  public final void startMonitor()
  {
    AppMethodBeat.i(220857);
    Log.d("HABBYGE-MALI.FinderFollowMonitor", "startMonitor");
    this.sDf.a((com.tencent.mm.plugin.expt.hellhound.a.a.f)this.sDq, (p)this.sDr);
    com.tencent.mm.plugin.expt.hellhound.a.a.a locala;
    if (this.mActivityRef != null)
    {
      locala = this.sDg;
      localObject = this.mActivityRef;
      if (localObject == null) {
        break label74;
      }
    }
    label74:
    for (Object localObject = (Activity)((WeakReference)localObject).get();; localObject = null)
    {
      locala.a(4, (Activity)localObject);
      AppMethodBeat.o(220857);
      return;
    }
  }
  
  public final void stopMonitor()
  {
    AppMethodBeat.i(220858);
    Log.d("HABBYGE-MALI.FinderFollowMonitor", "stopMonitor");
    this.sDg.a(5, null);
    this.sDf.stopMonitor();
    AppMethodBeat.o(220858);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/IFeedOnScrollListener;", "onScroll", "", "listView", "Landroid/view/ViewGroup;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "dx", "dy", "onScrollStateChanged", "scrollState", "plugin-expt_release"})
  public static final class b
    implements com.tencent.mm.plugin.expt.hellhound.a.a.f
  {
    public final void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(220855);
      Object localObject = f.b(this.sDt);
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
        AppMethodBeat.o(220855);
        return;
        localObject = null;
        break;
      }
      label116:
      f.a(this.sDt).a((Activity)localObject, paramViewGroup, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(220855);
    }
    
    public final void k(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(220854);
      f.a(this.sDt).g(paramViewGroup, f.Hb(paramInt));
      AppMethodBeat.o(220854);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFinderSmoothListener;", "scrollToPosition", "", "postion2Zero", "", "smoothScrollToPosition", "position", "", "plugin-expt_release"})
  public static final class c
    implements p
  {
    public final void md(boolean paramBoolean)
    {
      AppMethodBeat.i(220856);
      Log.d("HABBYGE-MALI.FinderFollowMonitor", "scrollToPosition: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      f.a(this.sDt).mc(paramBoolean);
      AppMethodBeat.o(220856);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.f
 * JD-Core Version:    0.7.0.1
 */