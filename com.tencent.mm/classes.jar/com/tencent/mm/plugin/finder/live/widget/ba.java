package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.k;
import androidx.recyclerview.widget.k.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.view.FinderLiveShoppingPriceView.b;
import com.tencent.mm.plugin.finder.live.view.adapter.ad;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingEditWidget;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/View;", "shoppingListData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "config", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShoppingPriceView$Config;", "editCallback", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingEditWidget$EditCallback;", "(Landroid/view/View;Ljava/util/LinkedList;Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShoppingPriceView$Config;Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingEditWidget$EditCallback;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "backIV", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "getBackIV", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "bottomArea", "getBottomArea", "()Landroid/view/View;", "getConfig", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShoppingPriceView$Config;", "setConfig", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShoppingPriceView$Config;)V", "deleteSelectTv", "Landroid/widget/TextView;", "getDeleteSelectTv", "()Landroid/widget/TextView;", "editAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingEditAdapter;", "getEditAdapter", "()Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingEditAdapter;", "editRv", "Landroidx/recyclerview/widget/RecyclerView;", "getEditRv", "()Landroidx/recyclerview/widget/RecyclerView;", "itemTouchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "itemTouchHelperCallback", "com/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingEditWidget$itemTouchHelperCallback$1", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingEditWidget$itemTouchHelperCallback$1;", "menuItem", "getMenuItem", "moveItemTv", "getMoveItemTv", "getRoot", "selectCountTv", "getSelectCountTv", "titleSpiltLine", "getTitleSpiltLine", "titleTv", "getTitleTv", "onClick", "", "v", "setActionTxtState", "select", "", "setSelectCount", "setVisible", "visible", "withAnim", "showEditView", "updateProductRecommendWording", "productId", "", "wording", "EditCallback", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ba
  implements View.OnClickListener
{
  private final View Emj;
  private final k Emo;
  private final LinkedList<cc> Euj;
  private FinderLiveShoppingPriceView.b Euk;
  private final b Eul;
  private final WeImageView Eum;
  private final TextView Eun;
  private final View Euo;
  private final RecyclerView Eup;
  private final TextView Euq;
  private final TextView Eur;
  private final TextView Eus;
  public final ad Eut;
  private final c Euu;
  final String TAG;
  final View lBX;
  private final TextView titleTv;
  
  public ba(final View paramView, LinkedList<cc> paramLinkedList, FinderLiveShoppingPriceView.b paramb, b paramb1)
  {
    AppMethodBeat.i(361371);
    this.lBX = paramView;
    this.Euj = paramLinkedList;
    this.Euk = paramb;
    this.Eul = paramb1;
    this.TAG = "FinderLiveShoppingEditWidget";
    this.titleTv = ((TextView)this.lBX.findViewById(p.e.CaZ));
    this.Eum = ((WeImageView)this.lBX.findViewById(p.e.CaX));
    this.Eun = ((TextView)this.lBX.findViewById(p.e.CaY));
    this.Euo = this.lBX.findViewById(p.e.CbD);
    this.Eup = ((RecyclerView)this.lBX.findViewById(p.e.CaT));
    this.Emj = this.lBX.findViewById(p.e.CaQ);
    this.Euq = ((TextView)this.lBX.findViewById(p.e.CaV));
    this.Eur = ((TextView)this.lBX.findViewById(p.e.CaU));
    this.Eus = ((TextView)this.lBX.findViewById(p.e.CaS));
    this.Eut = new ad((byte)0);
    this.Euu = new c(this);
    this.Emo = new k((k.a)this.Euu);
    this.Emj.setOnClickListener((View.OnClickListener)this);
    this.Eum.setOnClickListener((View.OnClickListener)this);
    paramView = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    paramView = this.Eum;
    s.s(paramView, "backIV");
    com.tencent.mm.plugin.finder.live.utils.a.gf((View)paramView);
    this.Eun.setOnClickListener((View.OnClickListener)this);
    this.Eur.setOnClickListener((View.OnClickListener)this);
    this.Eus.setOnClickListener((View.OnClickListener)this);
    paramView = this.Eut;
    paramView.DPR = ((q)new a(this, paramView));
    paramView = this.Eup;
    paramView.setAdapter((RecyclerView.a)this.Eut);
    paramView.getContext();
    paramView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    this.Emo.a(paramView);
    com.tencent.mm.ui.aw.a((Paint)this.titleTv.getPaint(), 0.8F);
    AppMethodBeat.o(361371);
  }
  
  private final void eBA()
  {
    AppMethodBeat.i(361388);
    int i = this.Eut.evS();
    if (i > 0)
    {
      this.Euq.setText((CharSequence)this.Euq.getContext().getString(p.h.CsB, new Object[] { Integer.valueOf(i) }));
      this.Euq.setVisibility(0);
      AppMethodBeat.o(361388);
      return;
    }
    this.Euq.setText((CharSequence)"");
    this.Euq.setVisibility(8);
    AppMethodBeat.o(361388);
  }
  
  private final void sF(boolean paramBoolean)
  {
    AppMethodBeat.i(361378);
    if (paramBoolean)
    {
      this.Eus.setTextColor(MMApplicationContext.getContext().getResources().getColor(p.b.ByS));
      this.Eus.setEnabled(true);
      this.Eur.setTextColor(MMApplicationContext.getContext().getResources().getColor(p.b.ByS));
      this.Eur.setEnabled(true);
      AppMethodBeat.o(361378);
      return;
    }
    this.Eus.setTextColor(MMApplicationContext.getContext().getResources().getColor(p.b.UN_BW_0_Alpha_0_3));
    this.Eus.setEnabled(false);
    this.Eur.setTextColor(MMApplicationContext.getContext().getResources().getColor(p.b.UN_BW_0_Alpha_0_3));
    this.Eur.setEnabled(false);
    AppMethodBeat.o(361378);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(361433);
    Object localObject1 = new b();
    ((b)localObject1).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingEditWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = p.e.CaX;
      if (paramView != null) {
        break label111;
      }
      label53:
      i = p.e.CaY;
      if (paramView != null) {
        break label189;
      }
      label61:
      i = p.e.CaU;
      if (paramView != null) {
        break label215;
      }
      label69:
      i = p.e.CaS;
      if (paramView != null) {
        break label470;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingEditWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361433);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label111:
      if (paramView.intValue() != i) {
        break label53;
      }
      if (this.Eut.evR().isEmpty())
      {
        paramView = this.Eul;
        if (paramView != null) {
          paramView.m((List)this.Eut.DSP, true);
        }
      }
      else
      {
        paramView = this.Eul;
        if (paramView != null)
        {
          paramView.m(this.Eut.evR(), false);
          continue;
          label189:
          if (paramView.intValue() != i) {
            break label61;
          }
          paramView = this.Eul;
          if (paramView != null)
          {
            paramView.eBB();
            continue;
            label215:
            if (paramView.intValue() != i) {
              break label69;
            }
            paramView = this.Eut;
            Object localObject2;
            Object localObject3;
            try
            {
              localObject2 = (Iterable)paramView.pUj;
              localObject1 = (Collection)new ArrayList();
              localObject2 = ((Iterable)localObject2).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = ((Iterator)localObject2).next();
                if (((com.tencent.mm.plugin.finder.live.view.adapter.a)localObject3).CIw)
                {
                  ((Collection)localObject1).add(localObject3);
                  continue;
                  this.Eut.bZE.notifyChanged();
                }
              }
            }
            catch (Exception paramView)
            {
              localObject1 = com.tencent.mm.plugin.finder.utils.aw.Gjk;
              com.tencent.mm.plugin.finder.utils.aw.a(paramView, "FinderLiveShoppingEditAdapter,moveSelectItem:");
            }
            for (;;)
            {
              this.Eut.evT();
              sF(false);
              eBA();
              break;
              localObject1 = (List)localObject1;
              localObject3 = (Iterable)paramView.pUj;
              localObject2 = (Collection)new ArrayList();
              localObject3 = ((Iterable)localObject3).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                Object localObject4 = ((Iterator)localObject3).next();
                if (!((com.tencent.mm.plugin.finder.live.view.adapter.a)localObject4).CIw) {
                  ((Collection)localObject2).add(localObject4);
                }
              }
              localObject2 = (List)localObject2;
              paramView.pUj.clear();
              paramView.pUj.addAll((Collection)localObject1);
              paramView.pUj.addAll((Collection)localObject2);
              ad.e(paramView.pUj, "after moveSelectItem");
            }
            label470:
            if (paramView.intValue() == i)
            {
              this.Eut.evV();
              this.Eut.bZE.notifyChanged();
              sF(false);
              eBA();
            }
          }
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "<anonymous parameter 1>", "", "productInfo", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements q<View, Integer, cc, ah>
  {
    a(ba paramba, ad paramad)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingEditWidget$EditCallback;", "", "cancel", "", "menuItemClick", "modifyShoppingContent", "allList", "", "", "delete", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void eBB();
    
    public abstract void m(List<Long> paramList, boolean paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingEditWidget$itemTouchHelperCallback$1", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "getMovementFlags", "", "p0", "Landroidx/recyclerview/widget/RecyclerView;", "p1", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "isItemViewSwipeEnabled", "", "onMove", "recyclerView", "source", "target", "onSwiped", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends k.a
  {
    c(ba paramba) {}
    
    public final boolean Jj()
    {
      return false;
    }
    
    public final int a(RecyclerView paramRecyclerView, RecyclerView.v paramv)
    {
      AppMethodBeat.i(361783);
      s.u(paramRecyclerView, "p0");
      s.u(paramv, "p1");
      int i = k.a.bk(3, 0);
      AppMethodBeat.o(361783);
      return i;
    }
    
    public final boolean a(RecyclerView paramRecyclerView, RecyclerView.v paramv1, RecyclerView.v paramv2)
    {
      AppMethodBeat.i(361792);
      s.u(paramRecyclerView, "recyclerView");
      s.u(paramv1, "source");
      s.u(paramv2, "target");
      int i = paramv1.KJ();
      int j = paramv2.KJ();
      paramRecyclerView = this.Euv.Eut;
      try
      {
        Collections.swap((List)paramRecyclerView.pUj, i, j);
        this.Euv.Eut.bz(i, j);
        paramRecyclerView = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        com.tencent.mm.plugin.finder.live.utils.a.hQ(this.Euv.TAG, "onMove from:" + i + " - to:" + j);
        this.Euv.Eut.evU();
        AppMethodBeat.o(361792);
        return true;
      }
      catch (Exception paramRecyclerView)
      {
        for (;;)
        {
          paramv1 = com.tencent.mm.plugin.finder.utils.aw.Gjk;
          com.tencent.mm.plugin.finder.utils.aw.a(paramRecyclerView, "FinderLiveShoppingEditAdapter,moveProductItem:");
        }
      }
    }
    
    public final void h(RecyclerView.v paramv)
    {
      AppMethodBeat.i(361800);
      s.u(paramv, "p0");
      AppMethodBeat.o(361800);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.ba
 * JD-Core Version:    0.7.0.1
 */