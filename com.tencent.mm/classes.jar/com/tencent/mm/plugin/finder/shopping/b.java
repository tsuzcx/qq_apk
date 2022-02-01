package com.tencent.mm.plugin.finder.shopping;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.widget.ba;
import com.tencent.mm.plugin.finder.live.widget.ba.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/shopping/FinderLiveShoppingManagerViewCallback;", "", "activity", "Landroid/app/Activity;", "presenter", "Lcom/tencent/mm/plugin/finder/shopping/FinderLiveShoppingManagerPresenter;", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/finder/shopping/FinderLiveShoppingManagerPresenter;)V", "getActivity", "()Landroid/app/Activity;", "managerWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingEditWidget;", "getManagerWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingEditWidget;", "setManagerWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingEditWidget;)V", "getPresenter", "()Lcom/tencent/mm/plugin/finder/shopping/FinderLiveShoppingManagerPresenter;", "initView", "", "refreshManagerRV", "updatePromotingView", "productId", "", "wording", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public final a FAj;
  public ba FAk;
  public final Activity activity;
  
  public b(Activity paramActivity, a parama)
  {
    AppMethodBeat.i(330508);
    this.activity = paramActivity;
    this.FAj = parama;
    AppMethodBeat.o(330508);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/shopping/FinderLiveShoppingManagerViewCallback$initView$1", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingEditWidget$EditCallback;", "cancel", "", "menuItemClick", "modifyShoppingContent", "allList", "", "", "delete", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements ba.b
  {
    public a(b paramb) {}
    
    public final void eBB()
    {
      AppMethodBeat.i(330536);
      this.FAl.FAj.esk();
      AppMethodBeat.o(330536);
    }
    
    public final void m(List<Long> paramList, boolean paramBoolean)
    {
      AppMethodBeat.i(330545);
      s.u(paramList, "allList");
      this.FAl.FAj.m(paramList, paramBoolean);
      this.FAl.activity.finish();
      AppMethodBeat.o(330545);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "productId", "", "wording", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    extends u
    implements m<Long, String, ah>
  {
    public b(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(b paramb, long paramLong, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.shopping.b
 * JD-Core Version:    0.7.0.1
 */