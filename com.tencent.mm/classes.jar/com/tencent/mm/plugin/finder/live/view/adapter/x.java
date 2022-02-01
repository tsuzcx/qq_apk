package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.model.cgi.af;
import com.tencent.mm.plugin.finder.live.model.cgi.af.a;
import com.tencent.mm.plugin.finder.live.plugin.cl;
import com.tencent.mm.plugin.finder.live.r;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.o;
import com.tencent.mm.plugin.finder.live.report.s;
import com.tencent.mm.plugin.finder.live.report.s.a;
import com.tencent.mm.plugin.finder.live.report.s.ah;
import com.tencent.mm.plugin.finder.live.report.s.bi;
import com.tencent.mm.plugin.finder.live.report.s.c;
import com.tencent.mm.plugin.finder.live.report.u;
import com.tencent.mm.plugin.finder.live.view.convert.f;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.protocal.protobuf.ahj;
import com.tencent.mm.protocal.protobuf.aqt;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bbc;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.ch;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.q.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$ShoppingViewHolder;", "context", "Landroid/content/Context;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "plugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Landroid/content/Context;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "adPosList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getAdPosList", "()Ljava/util/ArrayList;", "setAdPosList", "(Ljava/util/ArrayList;)V", "allDataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getAllDataList", "()Ljava/util/LinkedList;", "setAllDataList", "(Ljava/util/LinkedList;)V", "gotoHalfScreenMiniProgram", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "Lkotlin/ParameterName;", "name", "bunde", "", "getGotoHalfScreenMiniProgram", "()Lkotlin/jvm/functions/Function1;", "setGotoHalfScreenMiniProgram", "(Lkotlin/jvm/functions/Function1;)V", "onBuyClickCallback", "", "productId", "getOnBuyClickCallback", "setOnBuyClickCallback", "onItemLongClickCallback", "Lkotlin/Function3;", "holder", "Landroid/view/View;", "itemView", "pos", "getOnItemLongClickCallback", "()Lkotlin/jvm/functions/Function3;", "setOnItemLongClickCallback", "(Lkotlin/jvm/functions/Function3;)V", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "promotingProductCallback", "", "promting", "getPromotingProductCallback", "setPromotingProductCallback", "updateProductCallback", "empty", "getUpdateProductCallback", "setUpdateProductCallback", "bindAdItem", "item", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowAdItem;", "position", "bindProductItem", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowShelfProductItem;", "clearProductDataList", "findProductPos", "result", "Lkotlin/Function2;", "getItemCount", "getPositionText", "", "getProductNum", "getPromotingData", "getShoppingData", "goAd", "action", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorCommerceAction;", "handleModifyShelfResp", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "success", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModShopShelfResponse;", "haveProductData", "isAd", "modifyShelfProduct", "moveProductToFirst", "data", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "i", "promoteProduct", "scene", "reportGoodsItemShow", "reportStartTalk", "reportStopTalk", "setAdOnClickListener", "setAdUserActionText", "anchor", "promoting", "buttonText", "setProductOnClickListener", "setProductUserActionText", "sellOut", "setPromotingAnim", "showPopupMenu", "anchorPosX", "anchorPosY", "updatePromotingProduct", "promotingProduct", "updateShoppingList", "productList", "userProductAction", "Companion", "ShoppingViewHolder", "plugin-finder_release"})
public final class x
  extends RecyclerView.a<b>
{
  public static final a yZD;
  private final Context context;
  public final com.tencent.mm.live.c.b kCL;
  public com.tencent.mm.ui.widget.b.a szq;
  private final com.tencent.mm.plugin.finder.live.model.context.a xYp;
  public kotlin.g.a.q<? super b, ? super View, ? super Integer, kotlin.x> yZA;
  public kotlin.g.a.b<? super Long, kotlin.x> yZB;
  private final cl yZC;
  public LinkedList<bu> yZv;
  public ArrayList<Integer> yZw;
  public kotlin.g.a.b<? super g, kotlin.x> yZx;
  public kotlin.g.a.b<? super Boolean, kotlin.x> yZy;
  public kotlin.g.a.b<? super Boolean, kotlin.x> yZz;
  
  static
  {
    AppMethodBeat.i(224021);
    yZD = new a((byte)0);
    AppMethodBeat.o(224021);
  }
  
  public x(Context paramContext, com.tencent.mm.live.c.b paramb, cl paramcl, com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(224018);
    this.context = paramContext;
    this.kCL = paramb;
    this.yZC = paramcl;
    this.xYp = parama;
    this.yZv = new LinkedList();
    this.yZw = new ArrayList();
    this.szq = new com.tencent.mm.ui.widget.b.a(this.context);
    AppMethodBeat.o(224018);
  }
  
  private final String NP(int paramInt)
  {
    AppMethodBeat.i(223945);
    if (this.yZw.size() > 0)
    {
      if (NQ(paramInt))
      {
        AppMethodBeat.o(223945);
        return "";
      }
      i = this.yZv.size();
      AppMethodBeat.o(223945);
      return String.valueOf(i - paramInt);
    }
    int i = this.yZv.size();
    AppMethodBeat.o(223945);
    return String.valueOf(i - paramInt);
  }
  
  private final boolean NQ(int paramInt)
  {
    AppMethodBeat.i(223942);
    boolean bool = this.yZw.contains(Integer.valueOf(paramInt));
    AppMethodBeat.o(223942);
    return bool;
  }
  
  private final void NS(int paramInt)
  {
    AppMethodBeat.i(224015);
    for (;;)
    {
      try
      {
        Object localObject3 = NR(paramInt);
        if (this.kCL.getLiveRole() == 0)
        {
          if ((localObject3 instanceof f))
          {
            com.tencent.mm.plugin.finder.live.report.m.a(com.tencent.mm.plugin.finder.live.report.m.yCt, s.bi.yLU, null, String.valueOf(((f)localObject3).zaO));
            AppMethodBeat.o(224015);
            return;
          }
          if ((localObject3 instanceof com.tencent.mm.plugin.finder.live.view.convert.e))
          {
            com.tencent.mm.plugin.finder.live.report.m localm = com.tencent.mm.plugin.finder.live.report.m.yCt;
            s.bi localbi = s.bi.yLU;
            long l1 = ((com.tencent.mm.plugin.finder.live.view.convert.e)localObject3).zaI;
            Object localObject1 = ((com.tencent.mm.plugin.finder.live.view.convert.e)localObject3).zaJ;
            if (localObject1 == null) {
              break label193;
            }
            Object localObject2 = ((ch)localObject1).RHW;
            localObject1 = localObject2;
            if (localObject2 == null) {
              break label193;
            }
            long l2 = ((com.tencent.mm.plugin.finder.live.view.convert.e)localObject3).zaI;
            localObject3 = ((com.tencent.mm.plugin.finder.live.view.convert.e)localObject3).jDL;
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            localm.a(localbi, null, String.valueOf(l1), (String)localObject1, String.valueOf(l2), (String)localObject2);
          }
          AppMethodBeat.o(224015);
        }
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(224015);
        return;
      }
      label193:
      String str = "";
    }
  }
  
  private void a(b paramb, int paramInt)
  {
    AppMethodBeat.i(223918);
    p.k(paramb, "holder");
    Object localObject = this.yZv.get(paramInt);
    p.j(localObject, "allDataList[position]");
    localObject = (bu)localObject;
    if ((localObject instanceof f))
    {
      a((f)localObject, paramb, paramInt);
      AppMethodBeat.o(223918);
      return;
    }
    if ((localObject instanceof com.tencent.mm.plugin.finder.live.view.convert.e)) {
      a((com.tencent.mm.plugin.finder.live.view.convert.e)localObject, paramb, paramInt);
    }
    AppMethodBeat.o(223918);
  }
  
  private final void a(final b paramb, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(224009);
    final aa.f localf = new aa.f();
    localf.aaBC = NR(paramInt1);
    Object localObject;
    final long l1;
    long l2;
    if ((((bu)localf.aaBC instanceof f)) || (((bu)localf.aaBC instanceof com.tencent.mm.plugin.finder.live.view.convert.e)))
    {
      bu localbu = (bu)localf.aaBC;
      localObject = localbu;
      if (!(localbu instanceof f)) {
        localObject = null;
      }
      localObject = (f)localObject;
      if (localObject == null) {
        break label319;
      }
      l1 = ((f)localObject).zaO;
      localbu = (bu)localf.aaBC;
      localObject = localbu;
      if (!(localbu instanceof com.tencent.mm.plugin.finder.live.view.convert.e)) {
        localObject = null;
      }
      localObject = (com.tencent.mm.plugin.finder.live.view.convert.e)localObject;
      if (localObject == null) {
        break label325;
      }
      l2 = ((com.tencent.mm.plugin.finder.live.view.convert.e)localObject).zaI;
      label141:
      if (!((bu)localf.aaBC instanceof com.tencent.mm.plugin.finder.live.view.convert.e)) {
        break label331;
      }
    }
    label319:
    label325:
    label331:
    for (int i = 1;; i = 0)
    {
      Log.i("Finder.LiveShoppingListAdapter", "promoteProduct id:" + l1 + ",adId:" + l2 + " scene:" + paramInt2 + ", promoteType:" + i);
      long l3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId;
      long l4 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk;
      localObject = z.bdh();
      p.j(localObject, "ConfigStorageLogic.getMyFinderUsername()");
      new af(l3, l4, (String)localObject, l1, i, l2, paramInt2, (af.a)new f(this, l1, l2, paramInt2, i, localf, paramb, paramInt1)).bhW();
      AppMethodBeat.o(224009);
      return;
      l1 = 0L;
      break;
      l2 = 0L;
      break label141;
    }
  }
  
  private final void a(com.tencent.mm.plugin.finder.live.view.convert.e parame, b paramb, int paramInt)
  {
    AppMethodBeat.i(223939);
    Object localObject1 = paramb.yZG;
    p.j(localObject1, "holder.realDesc");
    ((TextView)localObject1).setVisibility(0);
    localObject1 = paramb.yZo;
    p.j(localObject1, "holder.productPrice");
    ((TextView)localObject1).setVisibility(8);
    localObject1 = paramb.yZm;
    p.j(localObject1, "holder.productSeq");
    ((TextView)localObject1).setVisibility(8);
    localObject1 = paramb.yZH;
    p.j(localObject1, "holder.productSrc");
    ((TextView)localObject1).setVisibility(8);
    Log.i("Finder.LiveShoppingListAdapter", "bindAdItem " + parame.zaM + ", " + parame.title + ", " + parame.zaL);
    localObject1 = t.ztT;
    localObject1 = t.dJi();
    Object localObject2 = new com.tencent.mm.plugin.finder.loader.e(parame.zaK);
    Object localObject3 = paramb.yZl;
    p.j(localObject3, "holder.productImg");
    Object localObject4 = t.ztT;
    ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, t.a(t.a.zug));
    localObject1 = paramb.yZm;
    p.j(localObject1, "holder.productSeq");
    ((TextView)localObject1).setText((CharSequence)"");
    localObject1 = paramb.yZG;
    if (localObject1 != null) {
      ((TextView)localObject1).setText((CharSequence)parame.desc);
    }
    localObject4 = paramb.yZn;
    p.j(localObject4, "holder.productDesc");
    localObject2 = parame.zaM;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject3 = parame.title;
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = "";
    }
    a.a((TextView)localObject4, (String)localObject1, (String)localObject2);
    localObject1 = paramb.yZF;
    p.j(localObject1, "holder.userAction");
    ((TextView)localObject1).setVisibility(0);
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId == 0L)
    {
      localObject1 = paramb.yZF;
      p.j(localObject1, "holder.userAction");
      ((TextView)localObject1).setVisibility(8);
      if (parame.promoting != 1) {
        break label516;
      }
      a(true, paramb);
    }
    for (;;)
    {
      c(paramb, paramInt);
      AppMethodBeat.o(223939);
      return;
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      if (com.tencent.mm.plugin.finder.live.utils.a.dEy())
      {
        if (parame.promoting == 1)
        {
          localObject2 = parame.zaL;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          a(true, true, (String)localObject1, paramb, paramInt);
          break;
        }
        localObject2 = parame.zaL;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        a(true, false, (String)localObject1, paramb, paramInt);
        break;
      }
      localObject2 = parame.zaL;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      a(false, false, (String)localObject1, paramb, paramInt);
      break;
      label516:
      a(false, paramb);
    }
  }
  
  private final void a(f paramf, b paramb, int paramInt)
  {
    AppMethodBeat.i(223928);
    Log.i("Finder.LiveShoppingListAdapter", "bindProductItem " + paramf.zaO + ", " + paramf.zaM + ", " + paramf.title + ", " + paramf.zaV);
    Object localObject1 = paramb.yZG;
    p.j(localObject1, "holder.realDesc");
    ((TextView)localObject1).setVisibility(8);
    localObject1 = paramb.yZo;
    p.j(localObject1, "holder.productPrice");
    ((TextView)localObject1).setVisibility(0);
    localObject1 = paramb.yZm;
    p.j(localObject1, "holder.productSeq");
    ((TextView)localObject1).setVisibility(0);
    localObject1 = paramb.yZH;
    p.j(localObject1, "holder.productSrc");
    ((TextView)localObject1).setVisibility(0);
    localObject1 = t.ztT;
    localObject1 = t.dJi();
    Object localObject2 = paramf.zaP;
    p.j(localObject2, "item.img_urls");
    localObject2 = new com.tencent.mm.plugin.finder.loader.e((String)kotlin.a.j.lp((List)localObject2));
    Object localObject3 = paramb.yZl;
    p.j(localObject3, "holder.productImg");
    Object localObject4 = t.ztT;
    ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, t.a(t.a.zug));
    localObject1 = paramb.yZm;
    p.j(localObject1, "holder.productSeq");
    ((TextView)localObject1).setText((CharSequence)NP(paramInt));
    localObject4 = paramb.yZn;
    p.j(localObject4, "holder.productDesc");
    localObject2 = paramf.zaM;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject3 = paramf.title;
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = "";
    }
    a.a((TextView)localObject4, (String)localObject1, (String)localObject2);
    localObject3 = paramb.yZp;
    p.j(localObject3, "holder.productStock");
    localObject4 = paramb.yZr;
    p.j(localObject4, "holder.sourceDivider");
    TextView localTextView = paramb.yZH;
    p.j(localTextView, "holder.productSrc");
    int i = paramf.zaQ;
    localObject2 = paramf.zaM;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    a.a((TextView)localObject3, (View)localObject4, localTextView, i, (String)localObject1, paramf.yiH);
    localObject1 = paramb.yZo;
    p.j(localObject1, "holder.productPrice");
    a.a((TextView)localObject1, paramf.zaS, paramf.zaR);
    localObject1 = paramb.yZF;
    p.j(localObject1, "holder.userAction");
    ((TextView)localObject1).setVisibility(0);
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId == 0L)
    {
      localObject1 = paramb.yZF;
      p.j(localObject1, "holder.userAction");
      ((TextView)localObject1).setVisibility(8);
      if (paramf.zaV != 1) {
        break label609;
      }
      a(true, paramb);
    }
    for (;;)
    {
      b(paramb, paramInt);
      AppMethodBeat.o(223928);
      return;
      if (paramf.zaQ <= 0)
      {
        localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        if (com.tencent.mm.plugin.finder.live.utils.a.NK(paramf.yiH)) {}
      }
      else
      {
        localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        if (com.tencent.mm.plugin.finder.live.utils.a.dEy())
        {
          if (paramf.zaV == 1)
          {
            a(true, true, false, paramb, paramInt);
            break;
          }
          a(true, false, false, paramb, paramInt);
          break;
        }
        a(false, false, false, paramb, paramInt);
        break;
      }
      a(false, false, true, paramb, paramInt);
      break;
      label609:
      a(false, paramb);
    }
  }
  
  private final void a(boolean paramBoolean, b paramb)
  {
    AppMethodBeat.i(223987);
    Object localObject;
    TextView localTextView;
    if (paramBoolean)
    {
      localObject = paramb.yZE;
      p.j(localObject, "holder.promoting");
      if (((FinderLiveOnliveWidget)localObject).getVisibility() != 0)
      {
        localObject = paramb.yZE;
        p.j(localObject, "holder.promoting");
        ((FinderLiveOnliveWidget)localObject).setVisibility(0);
        paramb.yZE.eiV();
        if (this.kCL.getLiveRole() == 1)
        {
          localObject = k.yBj;
          k.dDm().yDA = true;
        }
        localObject = new StringBuilder("showPromotingProduct,desc:");
        localTextView = paramb.yZn;
        p.j(localTextView, "holder.productDesc");
        localObject = ((StringBuilder)localObject).append(localTextView.getText()).append(",id:");
        localTextView = paramb.yZm;
        p.j(localTextView, "holder.productSeq");
        localObject = ((StringBuilder)localObject).append(localTextView.getText()).append(",platformId:");
        paramb = paramb.yZH;
        p.j(paramb, "holder.productSrc");
        Log.i("Finder.LiveShoppingListAdapter", paramb.getText());
        AppMethodBeat.o(223987);
      }
    }
    else
    {
      localObject = paramb.yZE;
      p.j(localObject, "holder.promoting");
      if (((FinderLiveOnliveWidget)localObject).getVisibility() == 0)
      {
        localObject = paramb.yZE;
        p.j(localObject, "holder.promoting");
        ((FinderLiveOnliveWidget)localObject).setVisibility(8);
        paramb.yZE.cTg();
        localObject = new StringBuilder("hidePromotingProduct,desc:");
        localTextView = paramb.yZn;
        p.j(localTextView, "holder.productDesc");
        localObject = ((StringBuilder)localObject).append(localTextView.getText()).append(",id:");
        localTextView = paramb.yZm;
        p.j(localTextView, "holder.productSeq");
        localObject = ((StringBuilder)localObject).append(localTextView.getText()).append(",platformId:");
        paramb = paramb.yZH;
        p.j(paramb, "holder.productSrc");
        Log.i("Finder.LiveShoppingListAdapter", paramb.getText());
      }
    }
    AppMethodBeat.o(223987);
  }
  
  private static void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, b paramb, int paramInt)
  {
    AppMethodBeat.i(223976);
    Log.i("Finder.LiveShoppingListAdapter", "setAnchorPromoteText,anchor:" + paramBoolean1 + ",promoting:" + paramBoolean2 + ",pos:" + paramInt);
    Object localObject;
    if (paramBoolean1 == true) {
      if (paramBoolean2)
      {
        paramString = paramb.yZF;
        p.j(paramString, "holder.userAction");
        localObject = paramb.yZF;
        p.j(localObject, "holder.userAction");
        localObject = ((TextView)localObject).getContext();
        p.j(localObject, "holder.userAction.context");
        paramString.setText((CharSequence)((Context)localObject).getResources().getString(b.j.finder_live_shopping_talking_end));
        paramString = paramb.yZF;
        localObject = paramb.yZF;
        p.j(localObject, "holder.userAction");
        localObject = ((TextView)localObject).getContext();
        p.j(localObject, "holder.userAction.context");
        paramString.setTextColor(((Context)localObject).getResources().getColor(b.c.finder_live_logo_color));
        paramb.yZF.setBackgroundResource(b.e.finder_live_shopping_sell_out_bg);
      }
    }
    for (;;)
    {
      paramString = paramb.yZF;
      p.j(paramString, "holder.userAction");
      paramString.setEnabled(true);
      AppMethodBeat.o(223976);
      return;
      paramString = paramb.yZF;
      p.j(paramString, "holder.userAction");
      localObject = paramb.yZF;
      p.j(localObject, "holder.userAction");
      localObject = ((TextView)localObject).getContext();
      p.j(localObject, "holder.userAction.context");
      paramString.setText((CharSequence)((Context)localObject).getResources().getString(b.j.finder_live_shopping_talking_btn));
      paramString = paramb.yZF;
      localObject = paramb.yZF;
      p.j(localObject, "holder.userAction");
      localObject = ((TextView)localObject).getContext();
      p.j(localObject, "holder.userAction.context");
      paramString.setTextColor(((Context)localObject).getResources().getColor(b.c.White));
      paramb.yZF.setBackgroundResource(b.e.finder_live_btn_bg);
      continue;
      if (!paramBoolean1)
      {
        localObject = paramb.yZF;
        p.j(localObject, "holder.userAction");
        ((TextView)localObject).setText((CharSequence)paramString);
        paramString = paramb.yZF;
        localObject = paramb.yZF;
        p.j(localObject, "holder.userAction");
        localObject = ((TextView)localObject).getContext();
        p.j(localObject, "holder.userAction.context");
        paramString.setTextColor(((Context)localObject).getResources().getColor(b.c.White));
        paramb.yZF.setBackgroundResource(b.e.finder_live_btn_bg);
      }
    }
  }
  
  private static void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, b paramb, int paramInt)
  {
    AppMethodBeat.i(223962);
    Log.i("Finder.LiveShoppingListAdapter", "setAnchorPromoteText,anchor:" + paramBoolean1 + ",promoting:" + paramBoolean2 + ",pos:" + paramInt);
    TextView localTextView;
    Object localObject;
    if (paramBoolean3)
    {
      localTextView = paramb.yZF;
      p.j(localTextView, "holder.userAction");
      localObject = paramb.yZF;
      p.j(localObject, "holder.userAction");
      localObject = ((TextView)localObject).getContext();
      p.j(localObject, "holder.userAction.context");
      localTextView.setText((CharSequence)((Context)localObject).getResources().getString(b.j.finder_live_shopping_sell_out));
      localTextView = paramb.yZF;
      localObject = paramb.yZF;
      p.j(localObject, "holder.userAction");
      localObject = ((TextView)localObject).getContext();
      p.j(localObject, "holder.userAction.context");
      localTextView.setTextColor(((Context)localObject).getResources().getColor(b.c.UN_BW_0_Alpha_0_1));
      paramb.yZF.setBackgroundResource(b.e.finder_live_shopping_sell_out_bg);
      paramb = paramb.yZF;
      p.j(paramb, "holder.userAction");
      paramb.setEnabled(false);
      AppMethodBeat.o(223962);
      return;
    }
    if (paramBoolean1) {
      if (paramBoolean2)
      {
        localTextView = paramb.yZF;
        p.j(localTextView, "holder.userAction");
        localObject = paramb.yZF;
        p.j(localObject, "holder.userAction");
        localObject = ((TextView)localObject).getContext();
        p.j(localObject, "holder.userAction.context");
        localTextView.setText((CharSequence)((Context)localObject).getResources().getString(b.j.finder_live_shopping_talking_end));
        localTextView = paramb.yZF;
        localObject = paramb.yZF;
        p.j(localObject, "holder.userAction");
        localObject = ((TextView)localObject).getContext();
        p.j(localObject, "holder.userAction.context");
        localTextView.setTextColor(((Context)localObject).getResources().getColor(b.c.finder_live_logo_color));
        paramb.yZF.setBackgroundResource(b.e.finder_live_shopping_sell_out_bg);
      }
    }
    for (;;)
    {
      paramb = paramb.yZF;
      p.j(paramb, "holder.userAction");
      paramb.setEnabled(true);
      AppMethodBeat.o(223962);
      return;
      localTextView = paramb.yZF;
      p.j(localTextView, "holder.userAction");
      localObject = paramb.yZF;
      p.j(localObject, "holder.userAction");
      localObject = ((TextView)localObject).getContext();
      p.j(localObject, "holder.userAction.context");
      localTextView.setText((CharSequence)((Context)localObject).getResources().getString(b.j.finder_live_shopping_talking_btn));
      localTextView = paramb.yZF;
      localObject = paramb.yZF;
      p.j(localObject, "holder.userAction");
      localObject = ((TextView)localObject).getContext();
      p.j(localObject, "holder.userAction.context");
      localTextView.setTextColor(((Context)localObject).getResources().getColor(b.c.White));
      paramb.yZF.setBackgroundResource(b.e.finder_live_btn_bg);
      continue;
      localTextView = paramb.yZF;
      p.j(localTextView, "holder.userAction");
      localObject = paramb.yZF;
      p.j(localObject, "holder.userAction");
      localObject = ((TextView)localObject).getContext();
      p.j(localObject, "holder.userAction.context");
      localTextView.setText((CharSequence)((Context)localObject).getResources().getString(b.j.finder_live_shopping_buy_btn));
      localTextView = paramb.yZF;
      localObject = paramb.yZF;
      p.j(localObject, "holder.userAction");
      localObject = ((TextView)localObject).getContext();
      p.j(localObject, "holder.userAction.context");
      localTextView.setTextColor(((Context)localObject).getResources().getColor(b.c.White));
      paramb.yZF.setBackgroundResource(b.e.finder_live_btn_bg);
    }
  }
  
  private final void b(final b paramb, final int paramInt)
  {
    AppMethodBeat.i(223994);
    paramb.amk.setOnClickListener((View.OnClickListener)new j(this, paramInt));
    paramb.yZF.setOnClickListener((View.OnClickListener)new k(this, paramb, paramInt));
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    if (com.tencent.mm.plugin.finder.live.utils.a.dEy()) {
      paramb.amk.setOnLongClickListener((View.OnLongClickListener)new l(this, paramb, paramInt));
    }
    NS(paramInt);
    AppMethodBeat.o(223994);
  }
  
  private final void c(final b paramb, final int paramInt)
  {
    AppMethodBeat.i(224001);
    paramb.amk.setOnClickListener((View.OnClickListener)new g(this, paramInt, paramb));
    paramb.yZF.setOnClickListener((View.OnClickListener)new h(this, paramb, paramInt));
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    if (com.tencent.mm.plugin.finder.live.utils.a.dEy()) {
      paramb.amk.setOnLongClickListener((View.OnLongClickListener)x.i.yZR);
    }
    NS(paramInt);
    AppMethodBeat.o(224001);
  }
  
  public final bu NR(int paramInt)
  {
    AppMethodBeat.i(224010);
    int i = this.yZv.size();
    if (paramInt < 0) {}
    while (i <= paramInt)
    {
      AppMethodBeat.o(224010);
      return null;
    }
    bu localbu = (bu)this.yZv.get(paramInt);
    AppMethodBeat.o(224010);
    return localbu;
  }
  
  public final void c(bu parambu)
  {
    int j = 3;
    int k = 0;
    int i = 0;
    AppMethodBeat.i(223903);
    Object localObject;
    if ((parambu instanceof f))
    {
      localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.ha("Finder.LiveShoppingListAdapter", "updatePromotingProduct,desc:" + ((f)parambu).title + ",id:" + ((f)parambu).zaO + ",platformId:" + ((f)parambu).yiH);
      j = getItemCount();
      while (i < j)
      {
        localObject = this.yZv.get(i);
        p.j(localObject, "allDataList[i]");
        localObject = (bu)localObject;
        if (((localObject instanceof f)) && (((f)localObject).zaO == ((f)parambu).zaO))
        {
          if (((f)parambu).zaV == 1) {}
          for (j = 3;; j = 4)
          {
            d(i, Integer.valueOf(j));
            AppMethodBeat.o(223903);
            return;
          }
        }
        i += 1;
      }
    }
    if ((parambu instanceof com.tencent.mm.plugin.finder.live.view.convert.e))
    {
      Log.i("Finder.LiveShoppingListAdapter", "updatePromotingProduct,desc:" + ((com.tencent.mm.plugin.finder.live.view.convert.e)parambu).title + ",id:" + ((com.tencent.mm.plugin.finder.live.view.convert.e)parambu).zaI + ",platformId:" + ((com.tencent.mm.plugin.finder.live.view.convert.e)parambu).zaM);
      int m = getItemCount();
      i = k;
      while (i < m)
      {
        localObject = this.yZv.get(i);
        p.j(localObject, "allDataList[i]");
        localObject = (bu)localObject;
        if (((localObject instanceof com.tencent.mm.plugin.finder.live.view.convert.e)) && (((com.tencent.mm.plugin.finder.live.view.convert.e)localObject).zaI == ((com.tencent.mm.plugin.finder.live.view.convert.e)parambu).zaI))
        {
          if (((com.tencent.mm.plugin.finder.live.view.convert.e)parambu).promoting == 1) {}
          for (;;)
          {
            d(i, Integer.valueOf(j));
            AppMethodBeat.o(223903);
            return;
            j = 4;
          }
        }
        i += 1;
      }
    }
    AppMethodBeat.o(223903);
  }
  
  public final int dFK()
  {
    AppMethodBeat.i(223887);
    Object localObject1 = (Iterable)this.yZv;
    Collection localCollection = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if ((localObject2 instanceof f)) {
        localCollection.add(localObject2);
      }
    }
    int i = ((List)localCollection).size();
    AppMethodBeat.o(223887);
    return i;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(223907);
    int i = this.yZv.size();
    AppMethodBeat.o(223907);
    return i;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$Companion;", "", "()V", "MENU_ID_ITEM_DELETE", "", "MENU_ID_ITEM_MOVE_TO_FIRST", "TAG", "", "payloadDelete", "payloadMove", "payloadPromteFinish", "payloadPromting", "setProductDesc", "", "productDescTv", "Landroid/widget/TextView;", "shopName", "goodsDesc", "setProductPrice", "priceTv", "maxPrice", "minPrice", "setProductSource", "stockTv", "divider", "Landroid/view/View;", "sourceTv", "stock", "platformId", "plugin-finder_release"})
  public static final class a
  {
    public static void a(TextView paramTextView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(263633);
      p.k(paramTextView, "priceTv");
      Object localObject = MMApplicationContext.getContext();
      p.j(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources();
      int i = b.j.finder_live_shopping_price;
      aj localaj = aj.AGc;
      paramTextView.setText((CharSequence)((Resources)localObject).getString(i, new Object[] { aj.Rf(paramInt2) }));
      if ((paramInt2 > paramInt1) || (paramInt2 < 0)) {
        Log.i("Finder.LiveShoppingListAdapter", "invalid price,min:" + paramInt2 + ",max:" + paramInt1);
      }
      AppMethodBeat.o(263633);
    }
    
    public static void a(TextView paramTextView1, View paramView, TextView paramTextView2, int paramInt1, String paramString, int paramInt2)
    {
      AppMethodBeat.i(263632);
      p.k(paramTextView1, "stockTv");
      p.k(paramView, "divider");
      p.k(paramTextView2, "sourceTv");
      p.k(paramString, "shopName");
      com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      if (com.tencent.mm.plugin.finder.live.utils.a.dEy())
      {
        locala = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        if (com.tencent.mm.plugin.finder.live.utils.a.NK(paramInt2))
        {
          paramTextView1.setVisibility(0);
          paramView.setVisibility(0);
          paramTextView2.setVisibility(0);
          paramView = MMApplicationContext.getContext();
          p.j(paramView, "MMApplicationContext.getContext()");
          paramTextView1.setText((CharSequence)paramView.getResources().getString(b.j.finder_live_shopping_stock_tips, new Object[] { Integer.valueOf(paramInt1) }));
          paramTextView2.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)paramString));
          AppMethodBeat.o(263632);
          return;
        }
      }
      paramTextView1.setVisibility(8);
      paramView.setVisibility(8);
      paramTextView2.setVisibility(0);
      paramTextView2.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)paramString));
      AppMethodBeat.o(263632);
    }
    
    public static void a(TextView paramTextView, String paramString1, String paramString2)
    {
      AppMethodBeat.i(263631);
      p.k(paramTextView, "productDescTv");
      p.k(paramString1, "shopName");
      p.k(paramString2, "goodsDesc");
      paramTextView.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)paramString2));
      AppMethodBeat.o(263631);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$ShoppingViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter;Landroid/view/View;)V", "productDesc", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getProductDesc", "()Landroid/widget/TextView;", "setProductDesc", "(Landroid/widget/TextView;)V", "productImg", "Landroid/widget/ImageView;", "getProductImg", "()Landroid/widget/ImageView;", "setProductImg", "(Landroid/widget/ImageView;)V", "productPrice", "getProductPrice", "setProductPrice", "productSeq", "getProductSeq", "setProductSeq", "productSrc", "getProductSrc", "setProductSrc", "productStock", "getProductStock", "setProductStock", "promoting", "Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "getPromoting", "()Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "setPromoting", "(Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;)V", "realDesc", "getRealDesc", "setRealDesc", "sourceDivider", "getSourceDivider", "()Landroid/view/View;", "setSourceDivider", "(Landroid/view/View;)V", "userAction", "getUserAction", "setUserAction", "plugin-finder_release"})
  public final class b
    extends RecyclerView.v
  {
    FinderLiveOnliveWidget yZE;
    TextView yZF;
    TextView yZG;
    TextView yZH;
    ImageView yZl;
    TextView yZm;
    public TextView yZn;
    TextView yZo;
    TextView yZp;
    View yZr;
    
    public b()
    {
      super();
      AppMethodBeat.i(275394);
      this.yZl = ((ImageView)localObject.findViewById(b.f.product_img));
      this.yZm = ((TextView)localObject.findViewById(b.f.product_seq));
      this.yZE = ((FinderLiveOnliveWidget)localObject.findViewById(b.f.promoting));
      this.yZn = ((TextView)localObject.findViewById(b.f.product_desc));
      this.yZo = ((TextView)localObject.findViewById(b.f.product_price));
      this.yZF = ((TextView)localObject.findViewById(b.f.product_action));
      this.yZG = ((TextView)localObject.findViewById(b.f.product_real_desc));
      this.yZp = ((TextView)localObject.findViewById(b.f.product_stock));
      this.yZH = ((TextView)localObject.findViewById(b.f.product_source));
      this.yZr = localObject.findViewById(b.f.product_src_divider);
      this$1 = aj.AGc;
      this$1 = this.yZo;
      p.j(x.this, "productPrice");
      aj.u(x.this);
      this$1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      this$1 = this.yZF;
      p.j(x.this, "userAction");
      com.tencent.mm.plugin.finder.live.utils.a.eB((View)x.this);
      AppMethodBeat.o(275394);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "pos", "", "<anonymous parameter 1>", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowShelfProductItem;", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.m<Integer, f, kotlin.x>
  {
    d(x paramx)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModShopShelfResponse;", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.m<Boolean, bbc, kotlin.x>
  {
    e(x paramx, aqt paramaqt)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$promoteProduct$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePromoteProduct$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLivePromoteProductResponse;", "plugin-finder_release"})
  public static final class f
    implements af.a
  {
    f(long paramLong1, long paramLong2, int paramInt1, int paramInt2, aa.f paramf, x.b paramb, int paramInt3) {}
    
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final bbn parambbn)
    {
      AppMethodBeat.i(290747);
      p.k(parambbn, "resp");
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this, parambbn, paramInt1, paramInt2, paramString));
      AppMethodBeat.o(290747);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<kotlin.x>
    {
      a(x.f paramf, bbn parambbn, int paramInt1, int paramInt2, String paramString)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(x paramx, int paramInt, x.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(222794);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$setAdOnClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      x.a(this.yZI, paramInt, paramb, s.bi.yLS);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$setAdOnClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(222794);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(x paramx, x.b paramb, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(265143);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$setAdOnClickListener$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      if (com.tencent.mm.plugin.finder.live.utils.a.dEy()) {
        x.a(this.yZI, paramb, paramInt);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$setAdOnClickListener$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(265143);
        return;
        x.a(this.yZI, paramInt, paramb, s.bi.yLT);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(x paramx, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      Object localObject1 = null;
      AppMethodBeat.i(224475);
      Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$setProductOnClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aFi());
      localObject2 = x.a(this.yZI, paramInt);
      StringBuilder localStringBuilder;
      if ((localObject2 instanceof f))
      {
        localStringBuilder = new StringBuilder("on product item click appId:");
        paramView = ((f)localObject2).zaU;
        if (paramView == null) {
          break label180;
        }
      }
      label180:
      for (paramView = paramView.appid;; paramView = null)
      {
        localStringBuilder = localStringBuilder.append(paramView).append(",path:");
        ahj localahj = ((f)localObject2).zaU;
        paramView = localObject1;
        if (localahj != null) {
          paramView = localahj.path;
        }
        Log.i("Finder.LiveShoppingListAdapter", paramView);
        paramView = r.xWC;
        r.a(x.a(this.yZI), (f)localObject2, (kotlin.g.a.m)new kotlin.g.b.q((bu)localObject2) {});
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$setProductOnClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(224475);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(x paramx, x.b paramb, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(241176);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$setProductOnClickListener$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      x.a(this.yZI, paramb, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$setProductOnClickListener$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(241176);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class l
    implements View.OnLongClickListener
  {
    l(x paramx, x.b paramb, int paramInt) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(288189);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$setProductOnClickListener$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = this.yZI.yZA;
      if (localObject != null)
      {
        x.b localb = paramb;
        p.j(paramView, "it");
        ((kotlin.g.a.q)localObject).c(localb, paramView, Integer.valueOf(paramInt));
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$setProductOnClickListener$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(288189);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
  public static final class m
    implements View.OnCreateContextMenuListener
  {
    public m(x paramx) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(284183);
      paramContextMenu.add(0, 100, 0, (CharSequence)x.c(this.yZI).getResources().getString(b.j.finder_live_shopping_up));
      paramContextMenu.add(0, 101, 1, (CharSequence)x.c(this.yZI).getResources().getString(b.j.finder_live_shopping_delete));
      AppMethodBeat.o(284183);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  public static final class n
    implements q.g
  {
    public n(x paramx, bu parambu) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(279378);
      p.j(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      Object localObject;
      long l;
      label381:
      do
      {
        do
        {
          do
          {
            AppMethodBeat.o(279378);
            return;
            x.d(this.yZI).cFD();
            paramMenuItem = new LinkedList();
            paramMenuItem.add(Long.valueOf(((f)this.yZT).zaO));
            localObject = this.yZI;
            locala = com.tencent.mm.plugin.finder.live.utils.a.yRm;
            x.a((x)localObject, com.tencent.mm.plugin.finder.live.utils.a.b(103, paramMenuItem));
          } while (x.b(this.yZI).getLiveRole() != 1);
          localObject = new JSONObject();
          ((JSONObject)localObject).put("type", s.ah.yIA.action);
          paramMenuItem = k.yBj;
          ((JSONObject)localObject).put("sessionid", k.dDm().yCW);
          ((JSONObject)localObject).put("shopwindowid", "");
          paramMenuItem = (f)this.yZT;
          if (paramMenuItem != null) {}
          for (paramMenuItem = Long.valueOf(paramMenuItem.zaO);; paramMenuItem = null)
          {
            ((JSONObject)localObject).put("productid", paramMenuItem.longValue());
            paramMenuItem = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
            paramMenuItem = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
            if (paramMenuItem == null) {
              break;
            }
            paramMenuItem = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramMenuItem.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
            if ((paramMenuItem == null) || (paramMenuItem.dGM() != true)) {
              break;
            }
            paramMenuItem = k.yBj;
            k.t(s.a.yDO.jWO, ((JSONObject)localObject).toString());
            AppMethodBeat.o(279378);
            return;
          }
          paramMenuItem = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
          paramMenuItem = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
          if (paramMenuItem != null)
          {
            paramMenuItem = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramMenuItem.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
            if (paramMenuItem != null) {
              if (paramMenuItem.isLiveStarted() == true)
              {
                paramMenuItem = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
                paramMenuItem = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
                if (paramMenuItem == null) {
                  break label502;
                }
                paramMenuItem = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramMenuItem.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
                if (paramMenuItem == null) {
                  break label502;
                }
                paramMenuItem = paramMenuItem.ziN;
                ((JSONObject)localObject).put("appid", paramMenuItem);
                paramMenuItem = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
                paramMenuItem = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
                if (paramMenuItem == null) {
                  break label507;
                }
                paramMenuItem = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)paramMenuItem.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
                if (paramMenuItem == null) {
                  break label507;
                }
                paramMenuItem = paramMenuItem.liveInfo;
                if (paramMenuItem == null) {
                  break label507;
                }
                l = paramMenuItem.liveId;
                if (l >= 0L) {
                  break label514;
                }
                ((JSONObject)localObject).put("liveid", "");
                paramMenuItem = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
                ((JSONObject)localObject).put("clickid", com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddF());
                paramMenuItem = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
                c.a.axD("");
                paramMenuItem = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
                paramMenuItem = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
                if (paramMenuItem == null) {
                  break label529;
                }
                paramMenuItem = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramMenuItem.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
                if (paramMenuItem == null) {
                  break label529;
                }
                paramMenuItem = paramMenuItem.ziK;
                if (paramMenuItem == null) {
                  break label529;
                }
              }
            }
          }
          for (paramMenuItem = Long.valueOf(paramMenuItem.mf());; paramMenuItem = "")
          {
            ((JSONObject)localObject).put("productid", paramMenuItem);
            paramMenuItem = k.yBj;
            k.a(s.c.yEp, ((JSONObject)localObject).toString());
            AppMethodBeat.o(279378);
            return;
            AppMethodBeat.o(279378);
            return;
            paramMenuItem = null;
            break;
            l = -1L;
            break label381;
            ((JSONObject)localObject).put("liveid", com.tencent.mm.plugin.expt.hellhound.core.b.Fw(l));
            break label397;
          }
          x.d(this.yZI).cFD();
          paramMenuItem = new LinkedList();
          paramMenuItem.add(Long.valueOf(((f)this.yZT).zaO));
          localObject = this.yZI;
          com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.yRm;
          x.a((x)localObject, com.tencent.mm.plugin.finder.live.utils.a.b(102, paramMenuItem));
        } while (x.b(this.yZI).getLiveRole() != 1);
        paramMenuItem = (f)this.yZT;
        if ((paramMenuItem != null) && (paramMenuItem.zaV == 1))
        {
          paramMenuItem = k.yBj;
          paramMenuItem = k.dDm();
          l = ((f)this.yZT).zaO;
          paramMenuItem = paramMenuItem.yDw.yNH;
          if (!paramMenuItem.isEmpty())
          {
            paramMenuItem = (LinkedList)paramMenuItem.get(Long.valueOf(l));
            if ((paramMenuItem != null) && (!paramMenuItem.isEmpty())) {
              break label828;
            }
          }
        }
        localObject = new JSONObject();
        ((JSONObject)localObject).put("type", s.ah.yIz.action);
        paramMenuItem = k.yBj;
        ((JSONObject)localObject).put("sessionid", k.dDm().yCW);
        ((JSONObject)localObject).put("shopwindowid", "");
        paramMenuItem = (f)this.yZT;
        if (paramMenuItem != null) {}
        for (paramMenuItem = Long.valueOf(paramMenuItem.zaO);; paramMenuItem = null)
        {
          ((JSONObject)localObject).put("productid", paramMenuItem.longValue());
          paramMenuItem = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
          paramMenuItem = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
          if (paramMenuItem == null) {
            break label901;
          }
          paramMenuItem = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramMenuItem.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
          if ((paramMenuItem == null) || (paramMenuItem.dGM() != true)) {
            break label901;
          }
          paramMenuItem = k.yBj;
          k.t(s.a.yDO.jWO, ((JSONObject)localObject).toString());
          AppMethodBeat.o(279378);
          return;
          if (((o)paramMenuItem.getLast()).yCw) {
            break;
          }
          l = System.currentTimeMillis() - ((o)paramMenuItem.getLast()).time;
          localObject = (o)paramMenuItem.getLast();
          if (l > 0L) {}
          for (;;)
          {
            ((o)localObject).time = l;
            ((o)paramMenuItem.getLast()).yCw = true;
            break;
            l = 0L;
          }
        }
        paramMenuItem = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
        paramMenuItem = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
        if (paramMenuItem == null) {
          break;
        }
        paramMenuItem = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramMenuItem.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
        if (paramMenuItem == null) {
          break;
        }
      } while (paramMenuItem.isLiveStarted() != true);
      label397:
      label502:
      label507:
      paramMenuItem = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
      label514:
      label529:
      label828:
      paramMenuItem = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
      label901:
      if (paramMenuItem != null)
      {
        paramMenuItem = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramMenuItem.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.ziN;
          label966:
          ((JSONObject)localObject).put("appid", paramMenuItem);
          paramMenuItem = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
          paramMenuItem = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
          if (paramMenuItem == null) {
            break label1138;
          }
          paramMenuItem = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)paramMenuItem.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
          if (paramMenuItem == null) {
            break label1138;
          }
          paramMenuItem = paramMenuItem.liveInfo;
          if (paramMenuItem == null) {
            break label1138;
          }
          l = paramMenuItem.liveId;
          label1015:
          if (l >= 0L) {
            break label1145;
          }
          ((JSONObject)localObject).put("liveid", "");
          label1031:
          paramMenuItem = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
          ((JSONObject)localObject).put("clickid", com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddF());
          paramMenuItem = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
          c.a.axD("");
          paramMenuItem = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
          paramMenuItem = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
          if (paramMenuItem == null) {
            break label1160;
          }
          paramMenuItem = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramMenuItem.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
          if (paramMenuItem == null) {
            break label1160;
          }
          paramMenuItem = paramMenuItem.ziK;
          if (paramMenuItem == null) {
            break label1160;
          }
        }
      }
      label1160:
      for (paramMenuItem = Long.valueOf(paramMenuItem.mf());; paramMenuItem = "")
      {
        ((JSONObject)localObject).put("productid", paramMenuItem);
        paramMenuItem = k.yBj;
        k.a(s.c.yEp, ((JSONObject)localObject).toString());
        break;
        AppMethodBeat.o(279378);
        return;
        paramMenuItem = null;
        break label966;
        label1138:
        l = -1L;
        break label1015;
        label1145:
        ((JSONObject)localObject).put("liveid", com.tencent.mm.plugin.expt.hellhound.core.b.Fw(l));
        break label1031;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "invoke", "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$userProductAction$1$1$1", "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$$special$$inlined$let$lambda$1"})
  static final class o
    extends kotlin.g.b.q
    implements kotlin.g.a.m<Boolean, g, kotlin.x>
  {
    o(x paramx, int paramInt, bu parambu, x.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.x
 * JD-Core Version:    0.7.0.1
 */