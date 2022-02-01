package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.m;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.d.a.a.a.b.a.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.order.OrderTabFragment;
import com.tencent.mm.plugin.finder.order.cgi.a.a;
import com.tencent.mm.plugin.finder.order.ui.OrderTabView;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.view.FinderViewPager;
import com.tencent.mm.protocal.protobuf.alo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.ar;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI25;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "fragments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/order/OrderTabFragment;", "Lkotlin/collections/ArrayList;", "getFragments", "()Ljava/util/ArrayList;", "fromScene", "", "getFromScene", "()I", "setFromScene", "(I)V", "tabList", "Lcom/tencent/mm/plugin/finder/order/data/OrderTabFeed;", "getTabList", "tabView", "Lcom/tencent/mm/plugin/finder/order/ui/OrderTabView;", "viewPager", "Lcom/tencent/mm/plugin/finder/view/FinderViewPager;", "getActiveIndex", "getLayoutId", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initConfigData", "", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class OccupyFinderUI25
  extends MMFinderUI
{
  FinderViewPager BsX;
  private OrderTabView BsY;
  final ArrayList<com.tencent.mm.plugin.finder.order.data.d> BsZ;
  private final String TAG;
  final ArrayList<OrderTabFragment> fragments;
  private int fromScene;
  
  public OccupyFinderUI25()
  {
    AppMethodBeat.i(365802);
    this.TAG = "Finder.OccupyFinderUI25";
    this.BsZ = new ArrayList();
    this.fragments = new ArrayList();
    AppMethodBeat.o(365802);
  }
  
  private static final void a(b paramb)
  {
    AppMethodBeat.i(365818);
    s.u(paramb, "$pageListener");
    paramb.onPageSelected(0);
    AppMethodBeat.o(365818);
  }
  
  private static final boolean a(OccupyFinderUI25 paramOccupyFinderUI25, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(365810);
    s.u(paramOccupyFinderUI25, "this$0");
    paramOccupyFinderUI25.finish();
    AppMethodBeat.o(365810);
    return true;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return p.f.Cfe;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(365851);
    Set localSet = ar.setOf(com.tencent.mm.plugin.finder.order.report.a.class);
    AppMethodBeat.o(365851);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(365872);
    super.onCreate(paramBundle);
    setMMTitle(p.h.CpM);
    setBackBtn(new OccupyFinderUI25..ExternalSyntheticLambda0(this));
    paramBundle = com.tencent.mm.plugin.finder.order.cgi.a.ESh;
    paramBundle = com.tencent.d.a.a.a.b.a.e.ahmT;
    int i = a.e.a.jVd();
    paramBundle = com.tencent.d.a.a.a.b.a.e.ahmT;
    int j = a.e.a.jVe();
    paramBundle = com.tencent.d.a.a.a.b.a.e.ahmT;
    int k = a.e.a.jVf();
    paramBundle = com.tencent.d.a.a.a.b.a.e.ahmT;
    paramBundle = a.a.hi(p.listOf(new Integer[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(a.e.a.jVg()) }));
    Log.i(this.TAG, s.X("tab count:", paramBundle));
    Object localObject2 = this.BsZ;
    Object localObject3 = com.tencent.d.a.a.a.b.a.e.ahmT;
    i = a.e.a.jVd();
    localObject3 = getResources().getString(p.h.CpL);
    s.s(localObject3, "resources.getString(R.st…ng.finder_live_order_all)");
    ((ArrayList)localObject2).add(new com.tencent.mm.plugin.finder.order.data.d(i, (String)localObject3, ((Number)paramBundle.get(0)).intValue()));
    localObject3 = com.tencent.d.a.a.a.b.a.e.ahmT;
    i = a.e.a.jVe();
    localObject3 = getResources().getString(p.h.Cqm);
    s.s(localObject3, "resources.getString(R.st…nder_live_order_wait_pay)");
    ((ArrayList)localObject2).add(new com.tencent.mm.plugin.finder.order.data.d(i, (String)localObject3, ((Number)paramBundle.get(1)).intValue()));
    localObject3 = com.tencent.d.a.a.a.b.a.e.ahmT;
    i = a.e.a.jVf();
    localObject3 = getResources().getString(p.h.Cqn);
    s.s(localObject3, "resources.getString(R.st…der_live_order_wait_recv)");
    ((ArrayList)localObject2).add(new com.tencent.mm.plugin.finder.order.data.d(i, (String)localObject3, ((Number)paramBundle.get(2)).intValue()));
    localObject3 = com.tencent.d.a.a.a.b.a.e.ahmT;
    i = a.e.a.jVg();
    localObject3 = getResources().getString(p.h.CpK);
    s.s(localObject3, "resources.getString(R.st…er_live_order_after_sale)");
    ((ArrayList)localObject2).add(new com.tencent.mm.plugin.finder.order.data.d(i, (String)localObject3, ((Number)paramBundle.get(3)).intValue()));
    paramBundle = ((Iterable)this.BsZ).iterator();
    while (paramBundle.hasNext())
    {
      localObject2 = (com.tencent.mm.plugin.finder.order.data.d)paramBundle.next();
      this.fragments.add(new OrderTabFragment(((com.tencent.mm.plugin.finder.order.data.d)localObject2).idY));
    }
    paramBundle = findViewById(p.e.viewPager);
    s.s(paramBundle, "findViewById(R.id.viewPager)");
    this.BsX = ((FinderViewPager)paramBundle);
    paramBundle = findViewById(p.e.BZc);
    s.s(paramBundle, "findViewById(R.id.order_tabview)");
    this.BsY = ((OrderTabView)paramBundle);
    paramBundle = this.BsY;
    if (paramBundle == null)
    {
      s.bIx("tabView");
      paramBundle = null;
      paramBundle.a((Activity)this, (com.tencent.mm.plugin.finder.order.ui.b)new a(this));
      localObject2 = this.BsX;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        s.bIx("viewPager");
        paramBundle = null;
      }
      paramBundle.setEnableViewPagerScroll(true);
      paramBundle = this.BsX;
      if (paramBundle != null) {
        break label729;
      }
      s.bIx("viewPager");
      paramBundle = (Bundle)localObject1;
      label540:
      localObject1 = new c(this, getSupportFragmentManager());
      localObject2 = new b(this);
      paramBundle.setAdapter((androidx.viewpager.widget.a)localObject1);
      paramBundle.setOffscreenPageLimit(this.BsZ.size() + 1);
      paramBundle.addOnPageChangeListener((ViewPager.OnPageChangeListener)localObject2);
      paramBundle.setCurrentItem(0, false);
      paramBundle.post(new OccupyFinderUI25..ExternalSyntheticLambda1((b)localObject2));
      paramBundle = getIntent();
      localObject1 = com.tencent.mm.plugin.findersdk.a.e.HbQ;
      this.fromScene = paramBundle.getIntExtra(com.tencent.mm.plugin.findersdk.a.e.frp(), 1);
      paramBundle = k.aeZF;
      localObject1 = (com.tencent.mm.plugin.finder.order.report.a)k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.order.report.a.class);
      if (this.fromScene != 1) {
        break label732;
      }
    }
    label729:
    label732:
    for (paramBundle = "my_finder_profile";; paramBundle = "live_room")
    {
      ((com.tencent.mm.plugin.finder.order.report.a)localObject1).w("enter_order_list", ak.l(new r("current_page", paramBundle)));
      com.tencent.mm.ae.d.b((c)new com.tencent.mm.plugin.finder.order.cgi.a().bFJ(), (kotlin.g.a.b)new d(this));
      AppMethodBeat.o(365872);
      return;
      break;
      break label540;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI25$initViews$1", "Lcom/tencent/mm/plugin/finder/order/ui/OrderTabController;", "getTabList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/order/data/OrderTabFeed;", "Lkotlin/collections/ArrayList;", "onSelectTab", "", "tab", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.plugin.finder.order.ui.b
  {
    a(OccupyFinderUI25 paramOccupyFinderUI25) {}
    
    public final void a(com.tencent.mm.plugin.finder.order.data.d paramd)
    {
      Object localObject1 = null;
      AppMethodBeat.i(364753);
      s.u(paramd, "tab");
      Object localObject2 = ((List)this.Bta.BsZ).iterator();
      int i = 0;
      int j;
      if (((Iterator)localObject2).hasNext()) {
        if (((com.tencent.mm.plugin.finder.order.data.d)((Iterator)localObject2).next()).idY == paramd.idY)
        {
          j = 1;
          label65:
          if (j == 0) {
            break label188;
          }
          label69:
          Log.i(OccupyFinderUI25.b(this.Bta), "onSelectTab title:" + paramd.Bvb + ", index:" + i + ", count:" + paramd.count);
          localObject2 = this.Bta.BsX;
          paramd = (com.tencent.mm.plugin.finder.order.data.d)localObject2;
          if (localObject2 == null)
          {
            s.bIx("viewPager");
            paramd = null;
          }
          if (paramd.getCurrentItem() != i)
          {
            paramd = OccupyFinderUI25.c(this.Bta);
            if (paramd != null) {
              break label200;
            }
            s.bIx("viewPager");
            paramd = localObject1;
          }
        }
      }
      label188:
      label200:
      for (;;)
      {
        paramd.setCurrentItem(i, false);
        AppMethodBeat.o(364753);
        return;
        j = 0;
        break label65;
        i += 1;
        break;
        i = -1;
        break label69;
      }
    }
    
    public final ArrayList<com.tencent.mm.plugin.finder.order.data.d> egb()
    {
      return this.Bta.BsZ;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI25$initViews$2$pageListener$1", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements ViewPager.OnPageChangeListener
  {
    b(OccupyFinderUI25 paramOccupyFinderUI25) {}
    
    public final void onPageScrollStateChanged(int paramInt) {}
    
    public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
    
    public final void onPageSelected(int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(364767);
      Object localObject1 = OccupyFinderUI25.a(this.Bta);
      if (localObject1 == null)
      {
        s.bIx("tabView");
        localObject1 = null;
      }
      for (;;)
      {
        localObject3 = ((OrderTabView)localObject1).ESO;
        if (localObject3 == null) {
          break label215;
        }
        localObject4 = ((com.tencent.mm.plugin.finder.order.ui.b)localObject3).egb();
        if ((localObject4 == null) || (((ArrayList)localObject4).size() <= paramInt) || (paramInt < 0)) {
          break label215;
        }
        localObject3 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((com.tencent.mm.plugin.finder.order.data.d)((Iterator)localObject3).next()).Bvd = false;
        }
      }
      Object localObject3 = (com.tencent.mm.plugin.finder.order.data.d)p.ae((List)localObject4, paramInt);
      if (localObject3 != null) {
        ((com.tencent.mm.plugin.finder.order.data.d)localObject3).Bvd = true;
      }
      localObject3 = ((OrderTabView)localObject1).TAG;
      StringBuilder localStringBuilder = new StringBuilder("select ").append(paramInt).append(", title:");
      Object localObject4 = (com.tencent.mm.plugin.finder.order.data.d)p.ae((List)localObject4, paramInt);
      if (localObject4 == null) {}
      for (;;)
      {
        Log.i((String)localObject3, localObject2);
        localObject1 = ((OrderTabView)localObject1).getRecyclerView();
        if (localObject1 != null)
        {
          localObject1 = ((WxRecyclerView)localObject1).getAdapter();
          if (localObject1 != null) {
            ((RecyclerView.a)localObject1).bZE.notifyChanged();
          }
        }
        label215:
        localObject1 = (OrderTabFragment)p.ae((List)this.Bta.fragments, paramInt);
        if (localObject1 != null) {
          ((OrderTabFragment)localObject1).onUserVisibleFocused();
        }
        if (localObject1 == null) {
          Log.e(OccupyFinderUI25.b(this.Bta), "onPageSelected position:" + paramInt + ", size:" + this.Bta.fragments.size());
        }
        AppMethodBeat.o(364767);
        return;
        localObject2 = ((com.tencent.mm.plugin.finder.order.data.d)localObject4).Bvb;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI25$initViews$2$viewPagerAdapter$1", "Landroidx/fragment/app/FragmentPagerAdapter;", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", "position", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends m
  {
    c(OccupyFinderUI25 paramOccupyFinderUI25, FragmentManager paramFragmentManager)
    {
      super();
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(364719);
      int i = this.Bta.fragments.size();
      AppMethodBeat.o(364719);
      return i;
    }
    
    public final Fragment getItem(int paramInt)
    {
      AppMethodBeat.i(364725);
      Object localObject = this.Bta.fragments.get(paramInt);
      s.s(localObject, "fragments[position]");
      localObject = (Fragment)localObject;
      AppMethodBeat.o(364725);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/EcCustomerGetAllTabOrderCntResp;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<b.a<alo>, ah>
  {
    d(OccupyFinderUI25 paramOccupyFinderUI25)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI25
 * JD-Core Version:    0.7.0.1
 */