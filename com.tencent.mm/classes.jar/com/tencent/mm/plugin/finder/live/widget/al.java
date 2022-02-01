package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.l.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.live.model.an;
import com.tencent.mm.plugin.finder.live.plugin.cl;
import com.tencent.mm.plugin.finder.live.plugin.cl.p;
import com.tencent.mm.plugin.finder.live.view.adapter.w;
import com.tencent.mm.plugin.finder.live.view.convert.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingEditWidget;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/ViewGroup;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "shoppingPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "bottomArea", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getBottomArea", "()Landroid/view/View;", "cancelTv", "Landroid/widget/TextView;", "getCancelTv", "()Landroid/widget/TextView;", "checkAll", "Landroid/widget/CheckBox;", "getCheckAll", "()Landroid/widget/CheckBox;", "checkAllTv", "getCheckAllTv", "deleteSelect", "getDeleteSelect", "editAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingEditAdapter;", "getEditAdapter", "()Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingEditAdapter;", "editRv", "Landroidx/recyclerview/widget/RecyclerView;", "getEditRv", "()Landroidx/recyclerview/widget/RecyclerView;", "finishTv", "getFinishTv", "itemTouchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "itemTouchHelperCallback", "com/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingEditWidget$itemTouchHelperCallback$1", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingEditWidget$itemTouchHelperCallback$1;", "getRoot", "()Landroid/view/ViewGroup;", "titleTv", "getTitleTv", "onClick", "", "v", "setDeleteTxtState", "select", "", "setVisible", "visible", "withAnim", "showEditView", "plugin-finder_release"})
public final class al
  implements View.OnClickListener
{
  final String TAG;
  final ViewGroup kiF;
  private final TextView titleTv;
  private final TextView xPY;
  private final TextView xPZ;
  private final com.tencent.mm.plugin.finder.live.model.context.a xYp;
  private final View zlM;
  final CheckBox zlN;
  private final TextView zlO;
  private final androidx.recyclerview.widget.l zlR;
  private final RecyclerView zrj;
  private final TextView zrk;
  final w zrl;
  private final b zrm;
  private final cl zrn;
  
  public al(ViewGroup paramViewGroup, com.tencent.mm.plugin.finder.live.model.context.a parama, cl paramcl)
  {
    AppMethodBeat.i(269243);
    this.kiF = paramViewGroup;
    this.xYp = parama;
    this.zrn = paramcl;
    this.TAG = "FinderLiveShoppingEditWidget";
    this.titleTv = ((TextView)this.kiF.findViewById(b.f.shopping_edit_title_tv));
    this.xPY = ((TextView)this.kiF.findViewById(b.f.shopping_edit_cancel_tv));
    this.xPZ = ((TextView)this.kiF.findViewById(b.f.shopping_edit_finish_tv));
    this.zrj = ((RecyclerView)this.kiF.findViewById(b.f.shopping_edit_list_content));
    this.zlM = this.kiF.findViewById(b.f.shopping_edit_bottom_area);
    this.zlN = ((CheckBox)this.kiF.findViewById(b.f.shopping_edit_check_all));
    this.zrk = ((TextView)this.kiF.findViewById(b.f.shopping_edit_check_all_tv));
    this.zlO = ((TextView)this.kiF.findViewById(b.f.shopping_edit_delete_select));
    this.zrl = new w();
    this.zrm = new b(this);
    this.zlR = new androidx.recyclerview.widget.l((l.a)this.zrm);
    this.zlM.setOnClickListener((View.OnClickListener)this);
    this.xPY.setOnClickListener((View.OnClickListener)this);
    this.xPZ.setOnClickListener((View.OnClickListener)this);
    this.zlN.setOnClickListener((View.OnClickListener)this);
    this.zrk.setOnClickListener((View.OnClickListener)this);
    this.zlO.setOnClickListener((View.OnClickListener)this);
    paramViewGroup = this.zrl;
    paramViewGroup.yWa = ((kotlin.g.a.q)new a(paramViewGroup, this));
    paramViewGroup = this.zrj;
    p.j(paramViewGroup, "this");
    paramViewGroup.setAdapter((RecyclerView.a)this.zrl);
    paramViewGroup.getContext();
    paramViewGroup.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    this.zlR.a(paramViewGroup);
    paramViewGroup = this.titleTv;
    p.j(paramViewGroup, "titleTv");
    ar.a((Paint)paramViewGroup.getPaint(), 0.8F);
    paramViewGroup = this.kiF.getLayoutParams();
    if (paramViewGroup == null)
    {
      paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(269243);
      throw paramViewGroup;
    }
    paramViewGroup = (ViewGroup.MarginLayoutParams)paramViewGroup;
    paramViewGroup.bottomMargin += ax.aB(this.kiF.getContext());
    AppMethodBeat.o(269243);
  }
  
  private final void pG(boolean paramBoolean)
  {
    AppMethodBeat.i(269239);
    if (paramBoolean)
    {
      localTextView = this.zlO;
      localContext = MMApplicationContext.getContext();
      p.j(localContext, "MMApplicationContext.getContext()");
      localTextView.setTextColor(localContext.getResources().getColor(b.c.finder_live_black_Alpha_80));
      AppMethodBeat.o(269239);
      return;
    }
    TextView localTextView = this.zlO;
    Context localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    localTextView.setTextColor(localContext.getResources().getColor(b.c.UN_BW_0_Alpha_0_3));
    AppMethodBeat.o(269239);
  }
  
  private void pL(boolean paramBoolean)
  {
    AppMethodBeat.i(269240);
    if (paramBoolean)
    {
      this.kiF.setVisibility(0);
      Object localObject1 = this.zlN;
      p.j(localObject1, "checkAll");
      ((CheckBox)localObject1).setChecked(false);
      pG(false);
      localObject1 = this.zrl;
      Object localObject3 = this.zrn.yxl.yZv;
      p.k(localObject3, "dataList");
      Object localObject4 = (Iterable)localObject3;
      Object localObject2 = (Collection)new ArrayList();
      localObject4 = ((Iterable)localObject4).iterator();
      Object localObject5;
      label145:
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = ((Iterator)localObject4).next();
        if (!((bu)localObject5 instanceof f)) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label145;
          }
          ((Collection)localObject2).add(localObject5);
          break;
        }
      }
      ((w)localObject1).yZj = ((List)localObject2);
      localObject2 = ((w)localObject1).yZj;
      if (localObject2 != null) {
        w.j((List)localObject2, "updateProductList otherItem");
      }
      ((w)localObject1).mXB.clear();
      localObject2 = ((w)localObject1).mXB;
      localObject4 = (Iterable)localObject3;
      localObject3 = (Collection)new ArrayList();
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = ((Iterator)localObject4).next();
        if ((localObject5 instanceof f)) {
          ((Collection)localObject3).add(localObject5);
        }
      }
      localObject4 = (Iterable)localObject3;
      localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((Collection)localObject3).add(new com.tencent.mm.plugin.finder.live.view.adapter.a((f)((Iterator)localObject4).next(), (byte)0));
      }
      ((ArrayList)localObject2).addAll((Collection)localObject3);
      w.d(((w)localObject1).mXB, "updateProductList dataList");
      this.zrl.notifyDataSetChanged();
      AppMethodBeat.o(269240);
      return;
    }
    this.zrl.dFH();
    this.kiF.setVisibility(8);
    AppMethodBeat.o(269240);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(269238);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingEditWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
    int i;
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      i = b.f.shopping_edit_cancel_tv;
      if (paramView != null) {
        break label122;
      }
      label62:
      i = b.f.shopping_edit_finish_tv;
      if (paramView != null) {
        break label138;
      }
      label70:
      i = b.f.shopping_edit_check_all_tv;
      if (paramView != null) {
        break label402;
      }
      label78:
      i = b.f.shopping_edit_check_all;
      if (paramView != null) {
        break label421;
      }
      label86:
      i = b.f.shopping_edit_delete_select;
      if (paramView != null) {
        break label485;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingEditWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(269238);
      return;
      paramView = null;
      break;
      label122:
      if (paramView.intValue() != i) {
        break label62;
      }
      pL(false);
      continue;
      label138:
      if (paramView.intValue() != i) {
        break label70;
      }
      paramView = this.zrn;
      if (paramView != null)
      {
        Object localObject2 = (Iterable)this.zrl.mXB;
        localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add(Long.valueOf(((com.tencent.mm.plugin.finder.live.view.adapter.a)((Iterator)localObject2).next()).yVL.zaO));
        }
        localObject1 = (List)localObject1;
        p.k(localObject1, "allList");
        localObject2 = cl.getFinderLiveAssistant();
        if (localObject2 != null)
        {
          Object localObject3 = paramView.kiF.getContext();
          if (localObject3 == null)
          {
            paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(269238);
            throw paramView;
          }
          localObject3 = (MMActivity)localObject3;
          long l1 = ((c)paramView.business(c.class)).liveInfo.liveId;
          long l2 = ((c)paramView.business(c.class)).xbk;
          String str = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramView.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig;
          com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.yRm;
          ((an)localObject2).a((MMActivity)localObject3, l1, l2, str, com.tencent.mm.plugin.finder.live.utils.a.b(101, new LinkedList((Collection)localObject1)), (m)new cl.p(paramView));
        }
      }
      a(this, false);
      continue;
      label402:
      if (paramView.intValue() != i) {
        break label78;
      }
      this.zlN.performClick();
      continue;
      label421:
      if (paramView.intValue() != i) {
        break label86;
      }
      paramView = this.zlN;
      p.j(paramView, "checkAll");
      if (paramView.isChecked())
      {
        this.zrl.dFG();
        pG(true);
      }
      for (;;)
      {
        this.zrl.notifyDataSetChanged();
        break;
        this.zrl.dFH();
        pG(false);
      }
      label485:
      if (paramView.intValue() == i)
      {
        this.zrl.dFJ();
        this.zrl.notifyDataSetChanged();
        pG(false);
        paramView = this.zlN;
        p.j(paramView, "checkAll");
        paramView.setChecked(this.zrl.dFF());
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingEditWidget$1$1"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.q<View, Integer, bu, kotlin.x>
  {
    a(w paramw, al paramal)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingEditWidget$itemTouchHelperCallback$1", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "getMovementFlags", "", "p0", "Landroidx/recyclerview/widget/RecyclerView;", "p1", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "isItemViewSwipeEnabled", "", "onMove", "recyclerView", "source", "target", "onSwiped", "", "plugin-finder_release"})
  public static final class b
    extends l.a
  {
    public final int a(RecyclerView paramRecyclerView, RecyclerView.v paramv)
    {
      AppMethodBeat.i(290760);
      p.k(paramRecyclerView, "p0");
      p.k(paramv, "p1");
      int i = l.a.cA(3);
      AppMethodBeat.o(290760);
      return i;
    }
    
    public final boolean a(RecyclerView paramRecyclerView, RecyclerView.v paramv1, RecyclerView.v paramv2)
    {
      AppMethodBeat.i(290761);
      p.k(paramRecyclerView, "recyclerView");
      p.k(paramv1, "source");
      p.k(paramv2, "target");
      int i = paramv1.md();
      int j = paramv2.md();
      paramRecyclerView = this.zrp.zrl;
      try
      {
        Collections.swap((List)paramRecyclerView.mXB, i, j);
        this.zrp.zrl.aF(i, j);
        paramRecyclerView = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        com.tencent.mm.plugin.finder.live.utils.a.ha(this.zrp.TAG, "onMove from:" + i + " - to:" + j);
        this.zrp.zrl.dFI();
        AppMethodBeat.o(290761);
        return true;
      }
      catch (Exception paramRecyclerView)
      {
        for (;;)
        {
          paramv1 = aj.AGc;
          aj.a(paramRecyclerView, "FinderLiveShoppingEditAdapter,moveProductItem:");
        }
      }
    }
    
    public final void g(RecyclerView.v paramv)
    {
      AppMethodBeat.i(290762);
      p.k(paramv, "p0");
      AppMethodBeat.o(290762);
    }
    
    public final boolean kA()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.al
 * JD-Core Version:    0.7.0.1
 */