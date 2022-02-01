package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.e;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import java.lang.ref.WeakReference;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "mFeedFlowCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowCallback;", "mFeedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FeedMonitor;", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mListener$1;", "mSmoothListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mSmoothListener$1;", "convertState", "", "scrollState", "free", "", "report", "startMonitor", "stopMonitor", "Companion", "plugin-expt_release"})
public final class f
  implements o
{
  public static final f.a qUN;
  private WeakReference<Activity> mActivityRef;
  private final a qUA;
  private com.tencent.mm.plugin.expt.hellhound.a.a.a qUB;
  private final b qUL;
  private final c qUM;
  
  static
  {
    AppMethodBeat.i(210729);
    qUN = new f.a((byte)0);
    AppMethodBeat.o(210729);
  }
  
  public f(Activity paramActivity)
  {
    AppMethodBeat.i(210728);
    this.qUA = new a();
    this.qUB = new com.tencent.mm.plugin.expt.hellhound.a.a.a(10, "18260", "1010");
    this.mActivityRef = new WeakReference(paramActivity);
    this.qUL = new b(this);
    this.qUM = new c(this);
    AppMethodBeat.o(210728);
  }
  
  public final void coC()
  {
    AppMethodBeat.i(210726);
    ad.d("HABBYGE-MALI.FinderFollowMonitor", "stopMonitor");
    this.qUB.a(5, null);
    this.qUA.coC();
    AppMethodBeat.o(210726);
  }
  
  public final void coL()
  {
    AppMethodBeat.i(210725);
    ad.d("HABBYGE-MALI.FinderFollowMonitor", "startMonitor");
    this.qUA.a((e)this.qUL, (p)this.qUM);
    com.tencent.mm.plugin.expt.hellhound.a.a.a locala;
    if (this.mActivityRef != null)
    {
      locala = this.qUB;
      localObject = this.mActivityRef;
      if (localObject == null) {
        break label74;
      }
    }
    label74:
    for (Object localObject = (Activity)((WeakReference)localObject).get();; localObject = null)
    {
      locala.a(4, (Activity)localObject);
      AppMethodBeat.o(210725);
      return;
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(210727);
    WeakReference localWeakReference = this.mActivityRef;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.mActivityRef = null;
    AppMethodBeat.o(210727);
  }
  
  public final void report() {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/IFeedOnScrollListener;", "onScroll", "", "listView", "Landroid/view/ViewGroup;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "dx", "dy", "onScrollStateChanged", "scrollState", "plugin-expt_release"})
  public static final class b
    implements e
  {
    public final void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(210723);
      Object localObject = f.b(this.qUO);
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
        ad.m("HABBYGE-MALI.FinderFollowMonitor", paramViewGroup, new Object[0]);
        AppMethodBeat.o(210723);
        return;
        localObject = null;
        break;
      }
      label116:
      f.a(this.qUO).a((Activity)localObject, paramViewGroup, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(210723);
    }
    
    public final void l(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(210722);
      f.a(this.qUO).h(paramViewGroup, f.Dd(paramInt));
      AppMethodBeat.o(210722);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFinderSmoothListener;", "scrollToPosition", "", "postion2Zero", "", "smoothScrollToPosition", "position", "", "plugin-expt_release"})
  public static final class c
    implements p
  {
    public final void kZ(boolean paramBoolean)
    {
      AppMethodBeat.i(210724);
      ad.d("HABBYGE-MALI.FinderFollowMonitor", "scrollToPosition: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      f.a(this.qUO).kY(paramBoolean);
      AppMethodBeat.o(210724);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.f
 * JD-Core Version:    0.7.0.1
 */