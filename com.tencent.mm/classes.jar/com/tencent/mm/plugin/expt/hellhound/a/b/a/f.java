package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.d;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import java.lang.ref.WeakReference;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "mFeedFlowCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowCallback;", "mFeedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FeedMonitor;", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mListener$1;", "mSmoothListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mSmoothListener$1;", "convertState", "", "scrollState", "free", "", "report", "startMonitor", "stopMonitor", "Companion", "plugin-expt_release"})
public final class f
  implements o
{
  public static final a KFC;
  private final b KFA;
  private final c KFB;
  private final a KFq;
  private WeakReference<Activity> mActivityRef;
  private com.tencent.mm.plugin.expt.hellhound.a.a.a pGv;
  
  static
  {
    AppMethodBeat.i(205123);
    KFC = new a((byte)0);
    AppMethodBeat.o(205123);
  }
  
  public f(Activity paramActivity)
  {
    AppMethodBeat.i(205122);
    this.KFq = new a();
    this.pGv = new com.tencent.mm.plugin.expt.hellhound.a.a.a(10, "18260", "1010");
    this.mActivityRef = new WeakReference(paramActivity);
    this.KFA = new b(this);
    this.KFB = new c(this);
    AppMethodBeat.o(205122);
  }
  
  public final void ccd()
  {
    AppMethodBeat.i(205120);
    ad.d("HABBYGE-MALI.FinderFollowMonitor", "stopMonitor");
    this.pGv.a(5, null);
    this.KFq.ccd();
    AppMethodBeat.o(205120);
  }
  
  public final void cdL()
  {
    AppMethodBeat.i(205119);
    ad.d("HABBYGE-MALI.FinderFollowMonitor", "startMonitor");
    this.KFq.a((d)this.KFA, (p)this.KFB);
    com.tencent.mm.plugin.expt.hellhound.a.a.a locala;
    if (this.mActivityRef != null)
    {
      locala = this.pGv;
      localObject = this.mActivityRef;
      if (localObject == null) {
        break label74;
      }
    }
    label74:
    for (Object localObject = (Activity)((WeakReference)localObject).get();; localObject = null)
    {
      locala.a(4, (Activity)localObject);
      AppMethodBeat.o(205119);
      return;
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(205121);
    WeakReference localWeakReference = this.mActivityRef;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.mActivityRef = null;
    AppMethodBeat.o(205121);
  }
  
  public final void report() {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$Companion;", "", "()V", "TAG", "", "plugin-expt_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/IFeedOnScrollListener;", "onScroll", "", "listView", "Landroid/view/ViewGroup;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "dx", "dy", "onScrollStateChanged", "scrollState", "plugin-expt_release"})
  public static final class b
    implements d
  {
    public final void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(205117);
      Object localObject = f.b(this.KFD);
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
        AppMethodBeat.o(205117);
        return;
        localObject = null;
        break;
      }
      label116:
      f.a(this.KFD).a((Activity)localObject, paramViewGroup, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(205117);
    }
    
    public final void k(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(205116);
      f.a(this.KFD).g(paramViewGroup, f.agV(paramInt));
      AppMethodBeat.o(205116);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFinderSmoothListener;", "scrollToPosition", "", "postion2Zero", "", "smoothScrollToPosition", "position", "", "plugin-expt_release"})
  public static final class c
    implements p
  {
    public final void yx(boolean paramBoolean)
    {
      AppMethodBeat.i(205118);
      ad.d("HABBYGE-MALI.FinderFollowMonitor", "scrollToPosition: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      f.a(this.KFD).kc(paramBoolean);
      AppMethodBeat.o(205118);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.f
 * JD-Core Version:    0.7.0.1
 */