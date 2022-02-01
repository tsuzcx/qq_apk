package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.e;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;
import java.lang.ref.WeakReference;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "mFeedFlowCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowCallback;", "mFeedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FeedMonitor;", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mListener$1;", "mSmoothListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mSmoothListener$1;", "convertState", "", "scrollState", "free", "", "report", "startMonitor", "stopMonitor", "Companion", "plugin-expt_release"})
public final class f
  implements o
{
  public static final f.a rcL;
  private WeakReference<Activity> mActivityRef;
  private final b rcJ;
  private final c rcK;
  private final a rcy;
  private com.tencent.mm.plugin.expt.hellhound.a.a.a rcz;
  
  static
  {
    AppMethodBeat.i(196396);
    rcL = new f.a((byte)0);
    AppMethodBeat.o(196396);
  }
  
  public f(Activity paramActivity)
  {
    AppMethodBeat.i(196395);
    this.rcy = new a();
    this.rcz = new com.tencent.mm.plugin.expt.hellhound.a.a.a(10, "18260", "1010");
    this.mActivityRef = new WeakReference(paramActivity);
    this.rcJ = new b(this);
    this.rcK = new c(this);
    AppMethodBeat.o(196395);
  }
  
  public final void cqe()
  {
    AppMethodBeat.i(196393);
    ae.d("HABBYGE-MALI.FinderFollowMonitor", "stopMonitor");
    this.rcz.a(5, null);
    this.rcy.cqe();
    AppMethodBeat.o(196393);
  }
  
  public final void cqn()
  {
    AppMethodBeat.i(196392);
    ae.d("HABBYGE-MALI.FinderFollowMonitor", "startMonitor");
    this.rcy.a((e)this.rcJ, (p)this.rcK);
    com.tencent.mm.plugin.expt.hellhound.a.a.a locala;
    if (this.mActivityRef != null)
    {
      locala = this.rcz;
      localObject = this.mActivityRef;
      if (localObject == null) {
        break label74;
      }
    }
    label74:
    for (Object localObject = (Activity)((WeakReference)localObject).get();; localObject = null)
    {
      locala.a(4, (Activity)localObject);
      AppMethodBeat.o(196392);
      return;
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(196394);
    WeakReference localWeakReference = this.mActivityRef;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.mActivityRef = null;
    AppMethodBeat.o(196394);
  }
  
  public final void report() {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/IFeedOnScrollListener;", "onScroll", "", "listView", "Landroid/view/ViewGroup;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "dx", "dy", "onScrollStateChanged", "scrollState", "plugin-expt_release"})
  public static final class b
    implements e
  {
    public final void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(196390);
      Object localObject = f.b(this.rcM);
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
        ae.m("HABBYGE-MALI.FinderFollowMonitor", paramViewGroup, new Object[0]);
        AppMethodBeat.o(196390);
        return;
        localObject = null;
        break;
      }
      label116:
      f.a(this.rcM).a((Activity)localObject, paramViewGroup, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(196390);
    }
    
    public final void l(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(196389);
      f.a(this.rcM).h(paramViewGroup, f.Dq(paramInt));
      AppMethodBeat.o(196389);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFinderSmoothListener;", "scrollToPosition", "", "postion2Zero", "", "smoothScrollToPosition", "position", "", "plugin-expt_release"})
  public static final class c
    implements p
  {
    public final void kZ(boolean paramBoolean)
    {
      AppMethodBeat.i(196391);
      ae.d("HABBYGE-MALI.FinderFollowMonitor", "scrollToPosition: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      f.a(this.rcM).kY(paramBoolean);
      AppMethodBeat.o(196391);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.f
 * JD-Core Version:    0.7.0.1
 */