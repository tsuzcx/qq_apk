package com.tencent.mm.plugin.finder.feed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.ui.FinderPoiRelateListUI;
import com.tencent.mm.plugin.finder.model.br;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import com.tencent.mm.plugin.finder.view.u;
import com.tencent.mm.plugin.report.service.l;
import com.tencent.mm.protocal.protobuf.eee;
import com.tencent.mm.protocal.protobuf.eel;
import com.tencent.mm.protocal.protobuf.epd;
import com.tencent.mm.protocal.protobuf.fes;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderPoiRelateUIContract$PoiRelateViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiRelateListUI;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiRelateListUI;IIZ)V", "checkCount", "isBottomInit", "mPopupWindow", "Lcom/tencent/mm/plugin/finder/view/FinderTipsBubbleWindow;", "", "poiRelateHeader", "Landroid/view/View;", "poiRelateTips", "selectAll", "Landroid/widget/TextView;", "selectComplete", "checkGotoPoiSearch", "", "getActivity", "Lcom/tencent/mm/ui/MMActivity;", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "getHeaderView", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getPoiRelateTips", "getTitleStringId", "gotoPoiSearch", "handleComplete", "handleSelectAll", "initBottomView", "isEmpty", "initHeader", "onGridItemClick", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "onRetryShow", "isVisible", "onViewPrepared", "refreshBottomView", "showHeaderOnDataEmpty", "showPopWindow", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ak$c
  extends c.b
{
  private View AXL;
  private View AXM;
  private TextView AXN;
  private TextView AXO;
  private u<String> AXP;
  private boolean AXQ;
  private int AXR;
  
  private ak$c(FinderPoiRelateListUI paramFinderPoiRelateListUI, int paramInt)
  {
    super((MMActivity)paramFinderPoiRelateListUI, 2, paramInt, false);
    AppMethodBeat.i(362586);
    AppMethodBeat.o(362586);
  }
  
  private static final void a(c paramc)
  {
    AppMethodBeat.i(362669);
    s.u(paramc, "this$0");
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((Iterable)paramc.ebL().ALH.getDataListJustForAdapter()).iterator();
    label138:
    while (localIterator.hasNext())
    {
      Object localObject = (cc)localIterator.next();
      if (((localObject instanceof br)) && (((br)localObject).tGP))
      {
        localObject = ((br)localObject).EDy.ZEH;
        if (localObject == null) {
          localObject = null;
        }
        for (;;)
        {
          if (localObject == null) {
            break label138;
          }
          localArrayList.add(localObject);
          break;
          localObject = ((fes)localObject).abEh;
          if (localObject == null)
          {
            localObject = null;
          }
          else
          {
            localObject = ((eel)localObject).abjy;
            if (localObject == null) {
              localObject = null;
            } else {
              localObject = ((eee)localObject).UID;
            }
          }
        }
      }
    }
    Log.i("Finder.FinderPoiRelateUIContract", s.X("[handleComplete], ", localArrayList));
    h.ahAA.bk(new ak.c..ExternalSyntheticLambda6(localArrayList, paramc));
    AppMethodBeat.o(362669);
  }
  
  private static final void a(c paramc, View paramView)
  {
    AppMethodBeat.i(362631);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderPoiRelateUIContract$PoiRelateViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramc, "this$0");
    paramc.ect();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/FinderPoiRelateUIContract$PoiRelateViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(362631);
  }
  
  private static final void a(ArrayList paramArrayList, c paramc)
  {
    AppMethodBeat.i(362662);
    s.u(paramArrayList, "$poiList");
    s.u(paramc, "this$0");
    Intent localIntent = new Intent();
    localIntent.putExtra("extra_poi_list", (Serializable)paramArrayList);
    paramc.lzt.setResult(-1, localIntent);
    paramc.lzt.finish();
    AppMethodBeat.o(362662);
  }
  
  private static final void b(c paramc, View paramView)
  {
    AppMethodBeat.i(362640);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderPoiRelateUIContract$PoiRelateViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramc, "this$0");
    s.s(paramView, "it");
    int i = com.tencent.mm.cd.a.fromDPToPix((Context)paramc.lzt, 60);
    localObject = paramc.AXP;
    if (localObject == null)
    {
      s.bIx("mPopupWindow");
      localObject = null;
    }
    for (;;)
    {
      ((u)localObject).dismiss();
      paramc.AXM = View.inflate((Context)paramc.lzt, e.f.finder_poi_relative_tips_view, null);
      ((u)localObject).setContentView(paramc.AXM);
      ((u)localObject).bmu = i;
      ((u)localObject).gY(paramView);
      ((u)localObject).dUX();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/FinderPoiRelateUIContract$PoiRelateViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(362640);
      return;
    }
  }
  
  private static final void c(c paramc, View paramView)
  {
    AppMethodBeat.i(362646);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderPoiRelateUIContract$PoiRelateViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramc, "this$0");
    paramc.ecv();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/FinderPoiRelateUIContract$PoiRelateViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(362646);
  }
  
  private static final void d(c paramc, View paramView)
  {
    AppMethodBeat.i(362654);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderPoiRelateUIContract$PoiRelateViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramc, "this$0");
    if (paramc.AXR > 0) {
      h.ahAA.bm(new ak.c..ExternalSyntheticLambda5(paramc));
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/FinderPoiRelateUIContract$PoiRelateViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(362654);
  }
  
  private final void ecv()
  {
    AppMethodBeat.i(362602);
    int i = ebL().ALH.getSize();
    if (i <= 0)
    {
      AppMethodBeat.o(362602);
      return;
    }
    cc localcc;
    if (this.AXR == i)
    {
      localIterator = ((Iterable)ebL().ALH.getDataListJustForAdapter()).iterator();
      while (localIterator.hasNext())
      {
        localcc = (cc)localIterator.next();
        if ((localcc instanceof br)) {
          ((br)localcc).tGP = false;
        }
      }
      getAdapter().bZE.notifyChanged();
      this.AXR = 0;
      ecw();
      AppMethodBeat.o(362602);
      return;
    }
    Iterator localIterator = ((Iterable)ebL().ALH.getDataListJustForAdapter()).iterator();
    while (localIterator.hasNext())
    {
      localcc = (cc)localIterator.next();
      if ((localcc instanceof br)) {
        ((br)localcc).tGP = true;
      }
    }
    getAdapter().bZE.notifyChanged();
    this.AXR = i;
    ecw();
    AppMethodBeat.o(362602);
  }
  
  private final void ecw()
  {
    AppMethodBeat.i(362610);
    TextView localTextView;
    if (this.AXR > 0)
    {
      localTextView = this.AXO;
      if (localTextView != null)
      {
        localTextView.setBackgroundResource(e.d.finder_poi_btn_complete_shape);
        localTextView.setTextColor(localTextView.getContext().getResources().getColor(e.b.white_color));
        AppMethodBeat.o(362610);
      }
    }
    else
    {
      localTextView = this.AXO;
      if (localTextView != null)
      {
        localTextView.setBackgroundResource(e.d.finder_poi_btn_complete_shape_bw5);
        localTextView.setTextColor(localTextView.getContext().getResources().getColor(e.b.BW_0_Alpha_0_2));
      }
    }
    AppMethodBeat.o(362610);
  }
  
  private static final void l(View paramView1, View paramView2)
  {
    AppMethodBeat.i(362622);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView1);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderPoiRelateUIContract$PoiRelateViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramView1, "$root");
    paramView1 = paramView1.findViewById(e.e.retry_tip);
    if (paramView1 != null) {
      paramView1.callOnClick();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/FinderPoiRelateUIContract$PoiRelateViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(362622);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(362744);
    s.u(parama, "adapter");
    s.u(paramView, "view");
    parama = (CheckBox)paramView.findViewById(e.e.cb_poi_relative_check);
    int i = ebL().ALH.getSize();
    int j = paramInt - 1;
    if (parama != null)
    {
      if ((i > 0) && (j < i))
      {
        paramView = (cc)ebL().ALH.getDataListJustForAdapter().get(j);
        if ((paramView instanceof br))
        {
          br localbr = (br)paramView;
          if (parama.isChecked()) {
            break label226;
          }
          bool1 = true;
          localbr.tGP = bool1;
          if (!((br)paramView).tGP) {
            break label232;
          }
          this.AXR += 1;
          label136:
          Log.i("Finder.FinderPoiRelateUIContract", "[onGridItemClick], " + paramInt + ", " + j + ", " + this.AXR + ", " + ((br)paramView).tGP);
        }
      }
      if (parama.isChecked()) {
        break label245;
      }
    }
    label226:
    label232:
    label245:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      parama.setChecked(bool1);
      ecw();
      AppMethodBeat.o(362744);
      return;
      bool1 = false;
      break;
      this.AXR -= 1;
      break label136;
    }
  }
  
  public final String b(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(362779);
    s.u(paramd, "reason");
    AppMethodBeat.o(362779);
    return null;
  }
  
  public final String c(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(362787);
    s.u(paramd, "reason");
    AppMethodBeat.o(362787);
    return null;
  }
  
  public final void dUO() {}
  
  public final boolean ebN()
  {
    return true;
  }
  
  public final void ebi()
  {
    AppMethodBeat.i(362726);
    this.AXP = new u((Context)this.lzt, (byte)0);
    Object localObject = this.AXL;
    if (localObject != null)
    {
      LinearLayout localLinearLayout = (LinearLayout)((View)localObject).findViewById(e.e.ll_poi_search_container);
      if (localLinearLayout != null) {
        localLinearLayout.setOnClickListener(new ak.c..ExternalSyntheticLambda1(this));
      }
      localObject = (WeImageView)((View)localObject).findViewById(e.e.wiv_poi_relative);
      if (localObject != null) {
        ((WeImageView)localObject).setOnClickListener(new ak.c..ExternalSyntheticLambda2(this));
      }
    }
    super.ebi();
    AppMethodBeat.o(362726);
  }
  
  public final void ect()
  {
    AppMethodBeat.i(362796);
    if (com.tencent.mm.pluginsdk.permission.b.a((Activity)this.lzt, new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 64, null)) {
      ecu();
    }
    AppMethodBeat.o(362796);
  }
  
  public final void ecu()
  {
    AppMethodBeat.i(362801);
    Intent localIntent = new Intent();
    localIntent.putExtra("map_view_type", 8);
    localIntent.putExtra("type_tag", -1);
    localIntent.putExtra("type_pick_location_btn", 2);
    c.b((Context)this.lzt, "location", ".ui.RedirectUI", localIntent, 16666);
    l.kK(5, 10);
    AppMethodBeat.o(362801);
  }
  
  public final RecyclerView.LayoutManager fT(Context paramContext)
  {
    AppMethodBeat.i(362750);
    s.u(paramContext, "context");
    paramContext = new FinderStaggeredGridLayoutManager(1, 1);
    paramContext.setItemPrefetchEnabled(true);
    paramContext = (RecyclerView.LayoutManager)paramContext;
    AppMethodBeat.o(362750);
    return paramContext;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(362760);
    View localView = this.lzt.findViewById(e.e.empty_view);
    AppMethodBeat.o(362760);
    return localView;
  }
  
  public final View getHeaderView()
  {
    AppMethodBeat.i(362768);
    this.AXL = View.inflate((Context)this.lzt, e.f.finder_poi_relative_search_item, null);
    View localView = this.AXL;
    AppMethodBeat.o(362768);
    return localView;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(362754);
    RecyclerView.h localh = (RecyclerView.h)new a();
    AppMethodBeat.o(362754);
    return localh;
  }
  
  public final void pQ(boolean paramBoolean)
  {
    AppMethodBeat.i(362792);
    View localView = getEmptyView();
    if (localView != null)
    {
      WeImageView localWeImageView = (WeImageView)localView.findViewById(e.e.retry_icon);
      if (paramBoolean)
      {
        if (localWeImageView != null)
        {
          localWeImageView.setVisibility(0);
          localWeImageView.setOnClickListener(new ak.c..ExternalSyntheticLambda0(localView));
          AppMethodBeat.o(362792);
        }
      }
      else if (localWeImageView != null) {
        localWeImageView.setVisibility(8);
      }
    }
    AppMethodBeat.o(362792);
  }
  
  public final void pW(boolean paramBoolean)
  {
    AppMethodBeat.i(362811);
    if ((!paramBoolean) && (!this.AXQ))
    {
      this.AXQ = true;
      Object localObject = (FrameLayout)findViewById(e.e.fl_bottom_action);
      if (localObject != null) {
        ((FrameLayout)localObject).setVisibility(0);
      }
      this.AXN = ((TextView)findViewById(e.e.tv_poi_select_all));
      this.AXO = ((TextView)findViewById(e.e.tv_poi_select_complete));
      localObject = this.AXN;
      if (localObject != null) {
        ((TextView)localObject).setOnClickListener(new ak.c..ExternalSyntheticLambda4(this));
      }
      localObject = this.AXO;
      if (localObject != null) {
        ((TextView)localObject).setOnClickListener(new ak.c..ExternalSyntheticLambda3(this));
      }
    }
    AppMethodBeat.o(362811);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderPoiRelateUIContract$PoiRelateViewCallback$getItemDecoration$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends RecyclerView.h
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ak.c
 * JD-Core Version:    0.7.0.1
 */