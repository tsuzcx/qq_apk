package com.tencent.mm.plugin.finder.order.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI23;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.order.data.d;
import com.tencent.mm.plugin.findersdk.a.e;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/order/ui/OrderTabView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "controller", "Lcom/tencent/mm/plugin/finder/order/ui/OrderTabController;", "getController", "()Lcom/tencent/mm/plugin/finder/order/ui/OrderTabController;", "setController", "(Lcom/tencent/mm/plugin/finder/order/ui/OrderTabController;)V", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initView", "", "activity", "Landroid/app/Activity;", "presenter", "refresh", "select", "index", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class OrderTabView
  extends FrameLayout
{
  public WxRecyclerView AZd;
  public b ESO;
  public final String TAG;
  
  public OrderTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(332417);
    this.TAG = "Finder.OrderTabView";
    AppMethodBeat.o(332417);
  }
  
  public OrderTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(332423);
    this.TAG = "Finder.OrderTabView";
    AppMethodBeat.o(332423);
  }
  
  private static final void a(OrderTabView paramOrderTabView, Activity paramActivity, View paramView)
  {
    AppMethodBeat.i(332433);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramOrderTabView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramActivity);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/order/ui/OrderTabView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramOrderTabView, "this$0");
    s.u(paramActivity, "$activity");
    paramView = new Intent();
    paramView.setClass(paramOrderTabView.getContext(), OccupyFinderUI23.class);
    paramOrderTabView = a.e.HbQ;
    paramOrderTabView = a.e.fro();
    localObject1 = paramActivity.getIntent();
    localObject2 = a.e.HbQ;
    paramView.putExtra(paramOrderTabView, ((Intent)localObject1).getByteArrayExtra(a.e.fro()));
    paramOrderTabView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
    com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramOrderTabView.aYi(), "com/tencent/mm/plugin/finder/order/ui/OrderTabView", "initView$lambda-0", "(Lcom/tencent/mm/plugin/finder/order/ui/OrderTabView;Landroid/app/Activity;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramOrderTabView.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/finder/order/ui/OrderTabView", "initView$lambda-0", "(Lcom/tencent/mm/plugin/finder/order/ui/OrderTabView;Landroid/app/Activity;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/order/ui/OrderTabView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(332433);
  }
  
  public final void a(Activity paramActivity, final b paramb)
  {
    AppMethodBeat.i(332470);
    s.u(paramActivity, "activity");
    s.u(paramb, "presenter");
    this.ESO = paramb;
    final ArrayList localArrayList = paramb.egb();
    LayoutInflater.from(getContext()).inflate(p.f.Cfd, (ViewGroup)this, true);
    findViewById(p.e.BYW).setOnClickListener(new OrderTabView..ExternalSyntheticLambda0(this, paramActivity));
    this.AZd = ((WxRecyclerView)findViewById(p.e.BYZ));
    getContext();
    paramActivity = new LinearLayoutManager(0, false);
    WxRecyclerView localWxRecyclerView = this.AZd;
    if (localWxRecyclerView != null) {
      localWxRecyclerView.setLayoutManager((RecyclerView.LayoutManager)paramActivity);
    }
    paramActivity = new WxRecyclerAdapter((g)new a(), localArrayList, false);
    paramActivity.agOe = ((i.c)new b(paramActivity, this, localArrayList, paramb));
    paramb = this.AZd;
    if (paramb != null) {
      paramb.setAdapter((RecyclerView.a)paramActivity);
    }
    AppMethodBeat.o(332470);
  }
  
  public final b getController()
  {
    return this.ESO;
  }
  
  public final WxRecyclerView getRecyclerView()
  {
    return this.AZd;
  }
  
  public final void setController(b paramb)
  {
    this.ESO = paramb;
  }
  
  public final void setRecyclerView(WxRecyclerView paramWxRecyclerView)
  {
    this.AZd = paramWxRecyclerView;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/order/ui/OrderTabView$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements g
  {
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(332408);
      if (paramInt == d.class.hashCode())
      {
        localObject = (com.tencent.mm.view.recyclerview.f)new c();
        AppMethodBeat.o(332408);
        return localObject;
      }
      s.checkNotNull(null);
      Object localObject = new kotlin.f();
      AppMethodBeat.o(332408);
      throw ((Throwable)localObject);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/order/ui/OrderTabView$initView$2$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements i.c<j>
  {
    b(WxRecyclerAdapter<d> paramWxRecyclerAdapter, OrderTabView paramOrderTabView, ArrayList<d> paramArrayList, b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.order.ui.OrderTabView
 * JD-Core Version:    0.7.0.1
 */