package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.a;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.model.cgi.an;
import com.tencent.mm.plugin.finder.live.model.cgi.an.a;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.plugin.bz;
import com.tencent.mm.plugin.finder.live.report.q.a;
import com.tencent.mm.plugin.finder.live.report.q.as;
import com.tencent.mm.plugin.finder.live.report.q.bx;
import com.tencent.mm.plugin.finder.live.report.q.c;
import com.tencent.mm.plugin.finder.live.report.r;
import com.tencent.mm.plugin.finder.live.view.FinderLiveProductRecordView;
import com.tencent.mm.plugin.finder.live.view.FinderLiveShoppingPriceView;
import com.tencent.mm.plugin.finder.live.view.FinderLiveShoppingPriceView.a;
import com.tencent.mm.plugin.finder.live.view.FinderLiveShoppingPriceView.b;
import com.tencent.mm.plugin.finder.live.view.adapter.holder.b.a;
import com.tencent.mm.plugin.finder.live.view.adapter.holder.b.b;
import com.tencent.mm.plugin.finder.live.view.convert.i;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.live.widget.FinderLiveShoppingCouponView;
import com.tencent.mm.plugin.finder.live.widget.FinderLiveShoppingCouponView.a;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.protocal.protobuf.aka;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bkd;
import com.tencent.mm.protocal.protobuf.blc;
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.protocal.protobuf.buh;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bzc;
import com.tencent.mm.protocal.protobuf.cr;
import com.tencent.mm.protocal.protobuf.ehg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.am;
import kotlin.g.b.u;
import kotlinx.coroutines.cb;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "isAnchor", "", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Landroid/content/Context;ZLcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "actionButtonClickCallback", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingCouponView$Callback;", "getActionButtonClickCallback", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingCouponView$Callback;", "setActionButtonClickCallback", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingCouponView$Callback;)V", "adPosList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getAdPosList", "()Ljava/util/ArrayList;", "setAdPosList", "(Ljava/util/ArrayList;)V", "canUseCouponGoodsList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowShelfProductItem;", "getCanUseCouponGoodsList", "()Ljava/util/LinkedList;", "couponList", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getCouponList", "setCouponList", "(Ljava/util/LinkedList;)V", "goodsAndAdList", "getGoodsAndAdList", "setGoodsAndAdList", "gotoHalfScreenMiniProgram", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "sourceClick", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "bunde", "", "getGotoHalfScreenMiniProgram", "()Lkotlin/jvm/functions/Function2;", "setGotoHalfScreenMiniProgram", "(Lkotlin/jvm/functions/Function2;)V", "headerViewCallback", "Lcom/tencent/mm/plugin/finder/live/view/adapter/holder/FinderLiveShoppingHeaderViewHolder$ShoppingHeaderViewCallback;", "getHeaderViewCallback", "()Lcom/tencent/mm/plugin/finder/live/view/adapter/holder/FinderLiveShoppingHeaderViewHolder$ShoppingHeaderViewCallback;", "setHeaderViewCallback", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/holder/FinderLiveShoppingHeaderViewHolder$ShoppingHeaderViewCallback;)V", "()Z", "setAnchor", "(Z)V", "isShowingCanUseCouponGoodsList", "onBuyClickCallback", "Lkotlin/Function1;", "", "productId", "getOnBuyClickCallback", "()Lkotlin/jvm/functions/Function1;", "setOnBuyClickCallback", "(Lkotlin/jvm/functions/Function1;)V", "onItemLongClickCallback", "Lkotlin/Function3;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/holder/FinderLiveShoppingViewHolder;", "holder", "Landroid/view/View;", "itemView", "dataPos", "getOnItemLongClickCallback", "()Lkotlin/jvm/functions/Function3;", "setOnItemLongClickCallback", "(Lkotlin/jvm/functions/Function3;)V", "plugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin;", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "priceViewConfig", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShoppingPriceView$Config;", "getPriceViewConfig", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShoppingPriceView$Config;", "setPriceViewConfig", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShoppingPriceView$Config;)V", "promotingProductCallback", "promting", "getPromotingProductCallback", "setPromotingProductCallback", "updateProductCallback", "empty", "getUpdateProductCallback", "setUpdateProductCallback", "viewTypeArray", "getViewTypeArray", "addToReport", "it", "bindAdItem", "item", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowAdItem;", "bindCouponItem", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowCouponItem;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/holder/FinderLiveShoppingCouponViewHolder;", "position", "bindProductItem", "hideProductSeq", "bindProductReplayView", "bindRecordPlayView", "calculatePriceConfig", "dataPosConvertToRealPos", "pos", "itemType", "findProductPos", "result", "getItemCount", "getItemViewType", "getPositionText", "", "getProductNum", "getPromotingData", "getShoppingData", "getSortedGoodsDataForService", "", "goAd", "action", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorCommerceAction;", "handleModifyShelfResp", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "success", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModShopShelfResponse;", "haveProductData", "isAd", "modifyShelfProduct", "moveProductToFirst", "data", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "i", "onMount", "onUnmount", "onViewRecycled", "promoteProduct", "scene", "realPosConvertToDataPos", "realPos", "reportGoodsItemShow", "reportStartTalk", "reportStopTalk", "setAdOnClickListener", "setAdUserActionText", "anchor", "promoting", "buttonText", "setProductOnClickListener", "setProductUserActionText", "sellOut", "setPromotingAnim", "showPopupMenu", "anchorPosX", "anchorPosY", "updateCanUseCouponGoodsList", "productList", "updateShoppingList", "updateViewTypeArray", "userProductAction", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ae
  extends RecyclerView.a<RecyclerView.v>
{
  public static final a DTf;
  private final com.tencent.mm.plugin.finder.live.model.context.a CvU;
  public final ArrayList<Integer> DSF;
  public bz DSJ;
  public FinderLiveShoppingCouponView.a DSK;
  public FinderLiveShoppingPriceView.b DSR;
  public final LinkedList<com.tencent.mm.plugin.finder.live.view.convert.k> DTg;
  public LinkedList<cc> DTh;
  private ArrayList<Integer> DTi;
  private LinkedList<cc> DTj;
  public kotlin.g.a.m<? super Integer, ? super g, ah> DTk;
  public kotlin.g.a.b<? super Boolean, ah> DTl;
  public kotlin.g.a.b<? super Boolean, ah> DTm;
  public kotlin.g.a.q<? super com.tencent.mm.plugin.finder.live.view.adapter.holder.d, ? super View, ? super Integer, ah> DTn;
  public kotlin.g.a.b<? super Long, ah> DTo;
  public b.b DTp;
  private final Context context;
  boolean hKC;
  private com.tencent.mm.ui.widget.b.a vEV;
  
  static
  {
    AppMethodBeat.i(359258);
    DTf = new a((byte)0);
    AppMethodBeat.o(359258);
  }
  
  public ae(Context paramContext, boolean paramBoolean, com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(358894);
    this.context = paramContext;
    this.hKC = paramBoolean;
    this.CvU = parama;
    this.DTg = new LinkedList();
    this.DTh = new LinkedList();
    this.DTi = new ArrayList();
    this.DTj = new LinkedList();
    this.DSF = new ArrayList();
    paramContext = FinderLiveShoppingPriceView.DPr;
    this.DSR = FinderLiveShoppingPriceView.evI();
    this.vEV = new com.tencent.mm.ui.widget.b.a(this.context);
    AppMethodBeat.o(358894);
  }
  
  private final boolean PB(int paramInt)
  {
    AppMethodBeat.i(358971);
    boolean bool = this.DTi.contains(Integer.valueOf(paramInt));
    AppMethodBeat.o(358971);
    return bool;
  }
  
  private final void PD(int paramInt)
  {
    AppMethodBeat.i(359084);
    try
    {
      Object localObject3 = PC(paramInt);
      if (!this.hKC)
      {
        if ((localObject3 instanceof com.tencent.mm.plugin.finder.live.view.convert.k))
        {
          com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, q.bx.DDL, null, String.valueOf(((com.tencent.mm.plugin.finder.live.view.convert.k)localObject3).DVk));
          AppMethodBeat.o(359084);
          return;
        }
        if ((localObject3 instanceof i))
        {
          com.tencent.mm.plugin.finder.live.report.k localk = com.tencent.mm.plugin.finder.live.report.k.Doi;
          q.bx localbx = q.bx.DDL;
          long l1 = ((i)localObject3).DUP;
          Object localObject1 = ((i)localObject3).DUQ;
          if (localObject1 == null) {
            localObject1 = "";
          }
          for (;;)
          {
            long l2 = ((i)localObject3).DUP;
            localObject3 = ((i)localObject3).mdG;
            Object localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            localk.a(localbx, null, String.valueOf(l1), (String)localObject1, String.valueOf(l2), (String)localObject2);
            AppMethodBeat.o(359084);
            return;
            localObject2 = ((cr)localObject1).YEY;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(359084);
    }
  }
  
  private final String Pz(int paramInt)
  {
    AppMethodBeat.i(358978);
    if (this.DTi.size() > 0)
    {
      if (PB(paramInt))
      {
        AppMethodBeat.o(358978);
        return "";
      }
      i = this.DTh.size();
      AppMethodBeat.o(358978);
      return String.valueOf(i - paramInt);
    }
    int i = this.DTh.size();
    AppMethodBeat.o(358978);
    return String.valueOf(i - paramInt);
  }
  
  private final void a(int paramInt, com.tencent.mm.plugin.finder.live.view.adapter.holder.d paramd, q.bx parambx)
  {
    AppMethodBeat.i(359048);
    cc localcc = PC(paramInt);
    cr localcr;
    Object localObject1;
    label90:
    Object localObject2;
    if ((localcc instanceof i))
    {
      localcr = ((i)localcc).DUQ;
      if (localcr != null)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Boolean)com.tencent.mm.plugin.finder.storage.d.eWS().bmg()).booleanValue())
        {
          localObject1 = this.CvU;
          if (localObject1 != null) {
            break label333;
          }
          localObject1 = null;
          ((e)localObject1).EeF = null;
          localObject1 = this.CvU;
          if (localObject1 != null) {
            break label349;
          }
          localObject1 = null;
          ((e)localObject1).EeG.clear();
        }
        if (!this.hKC)
        {
          com.tencent.mm.plugin.finder.live.report.k localk = com.tencent.mm.plugin.finder.live.report.k.Doi;
          long l1 = ((i)localcc).DUP;
          localObject1 = ((i)localcc).DUQ;
          if (localObject1 != null) {
            break label365;
          }
          localObject1 = "";
          label140:
          long l2 = ((i)localcc).DUP;
          String str = ((i)localcc).mdG;
          localObject2 = str;
          if (str == null) {
            localObject2 = "";
          }
          localk.a(parambx, null, String.valueOf(l1), (String)localObject1, String.valueOf(l2), (String)localObject2);
        }
        parambx = ((e)this.CvU.business(e.class)).EeF;
        if (parambx == null) {
          break label394;
        }
        if (((CharSequence)parambx).length() <= 0) {
          break label389;
        }
        paramInt = 1;
        label230:
        if (paramInt != 1) {
          break label394;
        }
        paramInt = 1;
        label237:
        if (paramInt == 0) {
          break label399;
        }
        Log.i("Finder.LiveShoppingListAdapter", kotlin.g.b.s.X("get uxInfo from outsize:", ((e)this.CvU.business(e.class)).EeF));
        parambx = ((e)this.CvU.business(e.class)).EeF;
      }
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      localObject1 = paramd.caK.getContext();
      kotlin.g.b.s.s(localObject1, "holder.itemView.context");
      paramd = parambx;
      if (parambx == null) {
        paramd = "";
      }
      com.tencent.mm.plugin.finder.live.utils.a.a((Context)localObject1, localcr, paramd);
      AppMethodBeat.o(359048);
      return;
      label333:
      localObject1 = (e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(e.class);
      break;
      label349:
      localObject1 = (e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(e.class);
      break label90;
      label365:
      localObject2 = ((cr)localObject1).YEY;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label140;
      }
      localObject1 = "";
      break label140;
      label389:
      paramInt = 0;
      break label230;
      label394:
      paramInt = 0;
      break label237;
      label399:
      if (((e)this.CvU.business(e.class)).EeG.containsKey(Long.valueOf(((i)localcc).DUP)))
      {
        parambx = (String)((e)this.CvU.business(e.class)).EeG.get(Long.valueOf(((i)localcc).DUP));
        if (parambx != null) {
          if (((CharSequence)parambx).length() > 0)
          {
            paramInt = 1;
            label484:
            if (paramInt != 1) {
              break label584;
            }
          }
        }
        label584:
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label589;
          }
          Log.i("Finder.LiveShoppingListAdapter", "get uxInfo from cgi-getShowShopSelf,adid:" + ((i)localcc).DUP + ",uxinfo:" + ((i)localcc).mdG);
          parambx = (String)((e)this.CvU.business(e.class)).EeG.get(Long.valueOf(((i)localcc).DUP));
          break;
          paramInt = 0;
          break label484;
        }
      }
      label589:
      localObject2 = new StringBuilder("get uxInfo from promotingProduct,adid:").append(((i)localcc).DUP).append(",uxinfo:");
      localObject1 = ((i)localcc).mdG;
      parambx = (q.bx)localObject1;
      if (localObject1 == null) {
        parambx = "";
      }
      Log.i("Finder.LiveShoppingListAdapter", parambx);
      localObject1 = ((i)localcc).mdG;
      parambx = (q.bx)localObject1;
      if (localObject1 == null) {
        parambx = "";
      }
    }
  }
  
  private static final void a(ae paramae, final int paramInt, View paramView)
  {
    Object localObject1 = null;
    AppMethodBeat.i(359103);
    Object localObject2 = new Object();
    Object localObject3 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject3).cH(paramae);
    ((com.tencent.mm.hellhoundlib.b.b)localObject3).sc(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject3).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject2, ((com.tencent.mm.hellhoundlib.b.b)localObject3).aYj());
    kotlin.g.b.s.u(paramae, "this$0");
    paramView = aw.Gjk;
    if (aw.isFastClick())
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(359103);
      return;
    }
    localObject2 = paramae.PC(paramInt);
    if ((localObject2 instanceof com.tencent.mm.plugin.finder.live.view.convert.k))
    {
      localObject3 = new StringBuilder("on product item click appId:");
      paramView = ((com.tencent.mm.plugin.finder.live.view.convert.k)localObject2).DVq;
      if (paramView != null) {
        break label257;
      }
      paramView = null;
      localObject3 = ((StringBuilder)localObject3).append(paramView).append(",path:");
      paramView = ((com.tencent.mm.plugin.finder.live.view.convert.k)localObject2).DVq;
      if (paramView != null) {
        break label265;
      }
    }
    label257:
    label265:
    for (paramView = localObject1;; paramView = paramView.path)
    {
      Log.i("Finder.LiveShoppingListAdapter", paramView);
      paramView = com.tencent.mm.plugin.finder.live.k.Bxu;
      com.tencent.mm.plugin.finder.live.k.a(paramae.CvU, (com.tencent.mm.plugin.finder.live.view.convert.k)localObject2, (kotlin.g.a.m)new g(paramae, (cc)localObject2, paramInt));
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(359103);
      return;
      paramView = paramView.appid;
      break;
    }
  }
  
  private static final void a(ae paramae, int paramInt, com.tencent.mm.plugin.finder.live.view.adapter.holder.d paramd, View paramView)
  {
    AppMethodBeat.i(359112);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramae);
    localb.sc(paramInt);
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramae, "this$0");
    kotlin.g.b.s.u(paramd, "$holder");
    paramView = aw.Gjk;
    if (aw.isFastClick())
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(359112);
      return;
    }
    int i;
    if ((paramae.PC(paramInt) instanceof com.tencent.mm.plugin.finder.live.view.convert.k))
    {
      paramView = aj.CGT;
      paramView = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class);
      if (paramView == null) {
        break label246;
      }
      paramView = paramView.Ein;
      if ((paramView == null) || (paramView.ZTm != 0)) {
        break label246;
      }
      i = 1;
      if (i != 0)
      {
        paramView = com.tencent.mm.plugin.finder.live.report.j.Dob;
        localObject = aj.CGT;
        localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class);
        if (localObject != null) {
          break label252;
        }
        i = 0;
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.finder.live.report.j.a(paramView, 4, i);
      paramae.c(paramd, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(359112);
      return;
      label246:
      i = 0;
      break;
      label252:
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject).Ein;
      if (localObject == null) {
        i = 0;
      } else {
        i = ((buh)localObject).ZTm;
      }
    }
  }
  
  private static final void a(ae paramae, ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(359144);
    kotlin.g.b.s.u(paramae, "this$0");
    paramContextMenu.add(0, 100, 0, (CharSequence)paramae.context.getResources().getString(p.h.CsT));
    paramContextMenu.add(0, 101, 1, (CharSequence)paramae.context.getResources().getString(p.h.CsA));
    AppMethodBeat.o(359144);
  }
  
  private static final void a(ae paramae, com.tencent.mm.plugin.finder.live.view.convert.k paramk, View paramView)
  {
    AppMethodBeat.i(359091);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramae);
    localb.cH(paramk);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramae, "this$0");
    kotlin.g.b.s.u(paramk, "$item");
    paramView = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    paramView = paramae.context;
    paramae = paramae.CvU;
    localObject = paramk.DVj.aaij;
    if (localObject == null) {}
    for (long l = 0L;; l = ((ehg)localObject).ZRl)
    {
      com.tencent.mm.plugin.finder.live.utils.a.a(paramView, paramae, l, paramk.DVj, 1, "", paramk.DUN);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(359091);
      return;
    }
  }
  
  private static final void a(ae paramae, cc paramcc, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(359172);
    kotlin.g.b.s.u(paramae, "this$0");
    switch (paramMenuItem.getItemId())
    {
    }
    label249:
    label254:
    long l;
    label309:
    label335:
    label353:
    label505:
    do
    {
      do
      {
        do
        {
          AppMethodBeat.o(359172);
          return;
          paramae.vEV.diW();
          paramMenuItem = new LinkedList();
          paramMenuItem.add(Long.valueOf(((com.tencent.mm.plugin.finder.live.view.convert.k)paramcc).DVk));
          locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          paramae.o(com.tencent.mm.plugin.finder.live.utils.a.b(103, paramMenuItem));
        } while (!paramae.hKC);
        paramMenuItem = new JSONObject();
        paramMenuItem.put("type", q.as.Dzq.action);
        paramae = com.tencent.mm.plugin.finder.live.report.j.Dob;
        paramMenuItem.put("sessionid", com.tencent.mm.plugin.finder.live.report.j.Doc.DpP);
        paramMenuItem.put("shopwindowid", "");
        paramae = (com.tencent.mm.plugin.finder.live.view.convert.k)paramcc;
        if (paramae == null)
        {
          paramae = null;
          paramMenuItem.put("productid", paramae.longValue());
          paramae = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
          paramae = com.tencent.mm.plugin.finder.live.model.context.a.emY();
          if (paramae == null) {
            break label249;
          }
          paramae = (e)paramae.business(e.class);
          if ((paramae == null) || (paramae.eyz() != true)) {
            break label249;
          }
        }
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label254;
          }
          com.tencent.mm.plugin.finder.live.report.j.Dob.C(q.a.DqI.mwI, paramMenuItem.toString());
          AppMethodBeat.o(359172);
          return;
          paramae = Long.valueOf(paramae.DVk);
          break;
        }
        paramae = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
        paramae = com.tencent.mm.plugin.finder.live.model.context.a.emY();
        if (paramae == null) {
          break;
        }
        paramae = (e)paramae.business(e.class);
        if ((paramae == null) || (paramae.isLiveStarted() != true)) {
          break;
        }
        paramInt = 1;
      } while (paramInt == 0);
      paramae = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
      paramae = com.tencent.mm.plugin.finder.live.model.context.a.emY();
      if (paramae == null)
      {
        paramae = null;
        paramMenuItem.put("appid", paramae);
        paramae = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
        paramae = com.tencent.mm.plugin.finder.live.model.context.a.emY();
        if (paramae != null) {
          break label456;
        }
        l = -1L;
        if (l >= 0L) {
          break label505;
        }
        paramMenuItem.put("liveid", "");
        paramae = c.zGj;
        paramMenuItem.put("clickid", c.dKp());
        paramae = c.zGj;
        c.a.arH("");
        paramae = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
        paramae = com.tencent.mm.plugin.finder.live.model.context.a.emY();
        if (paramae != null) {
          break label521;
        }
        paramae = "";
      }
      for (;;)
      {
        paramMenuItem.put("productid", paramae);
        com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.c.Drn, paramMenuItem.toString());
        AppMethodBeat.o(359172);
        return;
        paramInt = 0;
        break;
        paramae = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)paramae.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class);
        if (paramae == null)
        {
          paramae = null;
          break label309;
        }
        paramae = paramae.Eii;
        break label309;
        paramae = (f)paramae.business(f.class);
        if (paramae == null)
        {
          l = -1L;
          break label335;
        }
        paramae = paramae.liveInfo;
        if (paramae == null)
        {
          l = -1L;
          break label335;
        }
        l = paramae.liveId;
        break label335;
        paramMenuItem.put("liveid", com.tencent.mm.plugin.expt.hellhound.core.b.hF(l));
        break label353;
        paramae = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)paramae.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class);
        if (paramae == null)
        {
          paramae = "";
        }
        else
        {
          paramae = paramae.Eie;
          if (paramae == null) {
            paramae = "";
          } else {
            paramae = Long.valueOf(paramae.bZA());
          }
        }
      }
      paramae.vEV.diW();
      paramMenuItem = new LinkedList();
      paramMenuItem.add(Long.valueOf(((com.tencent.mm.plugin.finder.live.view.convert.k)paramcc).DVk));
      com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      paramae.o(com.tencent.mm.plugin.finder.live.utils.a.b(102, paramMenuItem));
    } while (!paramae.hKC);
    label456:
    paramae = (com.tencent.mm.plugin.finder.live.view.convert.k)paramcc;
    label521:
    if ((paramae != null) && (paramae.DVr == 1))
    {
      paramInt = 1;
      if (paramInt != 0)
      {
        paramae = com.tencent.mm.plugin.finder.live.report.j.Dob;
        paramae = com.tencent.mm.plugin.finder.live.report.j.Doc;
        l = ((com.tencent.mm.plugin.finder.live.view.convert.k)paramcc).DVk;
        paramae = paramae.Dqq.DGi;
        if (!paramae.isEmpty())
        {
          paramae = (LinkedList)paramae.get(Long.valueOf(l));
          if ((paramae != null) && (!paramae.isEmpty())) {
            break label846;
          }
        }
      }
      label704:
      paramMenuItem = new JSONObject();
      paramMenuItem.put("type", q.as.Dzp.action);
      paramae = com.tencent.mm.plugin.finder.live.report.j.Dob;
      paramMenuItem.put("sessionid", com.tencent.mm.plugin.finder.live.report.j.Doc.DpP);
      paramMenuItem.put("shopwindowid", "");
      paramae = (com.tencent.mm.plugin.finder.live.view.convert.k)paramcc;
      if (paramae != null) {
        break label916;
      }
      l = 0L;
      label767:
      paramMenuItem.put("productid", l);
      paramae = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
      paramae = com.tencent.mm.plugin.finder.live.model.context.a.emY();
      if (paramae == null) {
        break label925;
      }
      paramae = (e)paramae.business(e.class);
      if ((paramae == null) || (paramae.eyz() != true)) {
        break label925;
      }
    }
    label916:
    label925:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        break label930;
      }
      com.tencent.mm.plugin.finder.live.report.j.Dob.C(q.a.DqI.mwI, paramMenuItem.toString());
      AppMethodBeat.o(359172);
      return;
      paramInt = 0;
      break;
      label846:
      if (((com.tencent.mm.plugin.finder.live.report.m)paramae.getLast()).Dpq) {
        break label704;
      }
      l = System.currentTimeMillis() - ((com.tencent.mm.plugin.finder.live.report.m)paramae.getLast()).time;
      paramMenuItem = (com.tencent.mm.plugin.finder.live.report.m)paramae.getLast();
      if (l > 0L) {}
      for (;;)
      {
        paramMenuItem.time = l;
        ((com.tencent.mm.plugin.finder.live.report.m)paramae.getLast()).Dpq = true;
        break;
        l = 0L;
      }
      l = paramae.DVk;
      break label767;
    }
    label930:
    paramae = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
    paramae = com.tencent.mm.plugin.finder.live.model.context.a.emY();
    if (paramae != null)
    {
      paramae = (e)paramae.business(e.class);
      if ((paramae != null) && (paramae.isLiveStarted() == true))
      {
        paramInt = 1;
        label967:
        if (paramInt == 0) {
          break label1098;
        }
        paramae = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
        paramae = com.tencent.mm.plugin.finder.live.model.context.a.emY();
        if (paramae != null) {
          break label1100;
        }
        paramae = null;
        label985:
        paramMenuItem.put("appid", paramae);
        paramae = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
        paramae = com.tencent.mm.plugin.finder.live.model.context.a.emY();
        if (paramae != null) {
          break label1128;
        }
        l = -1L;
        label1011:
        if (l >= 0L) {
          break label1177;
        }
        paramMenuItem.put("liveid", "");
        label1029:
        paramae = c.zGj;
        paramMenuItem.put("clickid", c.dKp());
        paramae = c.zGj;
        c.a.arH("");
        paramae = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
        paramae = com.tencent.mm.plugin.finder.live.model.context.a.emY();
        if (paramae != null) {
          break label1193;
        }
        paramae = "";
      }
    }
    for (;;)
    {
      paramMenuItem.put("productid", paramae);
      com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.c.Drn, paramMenuItem.toString());
      break;
      paramInt = 0;
      break label967;
      label1098:
      break;
      label1100:
      paramae = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)paramae.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class);
      if (paramae == null)
      {
        paramae = null;
        break label985;
      }
      paramae = paramae.Eii;
      break label985;
      label1128:
      paramae = (f)paramae.business(f.class);
      if (paramae == null)
      {
        l = -1L;
        break label1011;
      }
      paramae = paramae.liveInfo;
      if (paramae == null)
      {
        l = -1L;
        break label1011;
      }
      l = paramae.liveId;
      break label1011;
      label1177:
      paramMenuItem.put("liveid", com.tencent.mm.plugin.expt.hellhound.core.b.hF(l));
      break label1029;
      label1193:
      paramae = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)paramae.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class);
      if (paramae == null)
      {
        paramae = "";
      }
      else
      {
        paramae = paramae.Eie;
        if (paramae == null) {
          paramae = "";
        } else {
          paramae = Long.valueOf(paramae.bZA());
        }
      }
    }
  }
  
  private final void a(com.tencent.mm.plugin.finder.live.view.adapter.holder.d paramd, int paramInt)
  {
    AppMethodBeat.i(359020);
    paramd.caK.setOnClickListener(new ae..ExternalSyntheticLambda0(this, paramInt));
    paramd.DUs.setOnClickListener(new ae..ExternalSyntheticLambda1(this, paramInt, paramd));
    if (a.eqc()) {
      paramd.caK.setOnLongClickListener(new ae..ExternalSyntheticLambda7(this, paramd, paramInt));
    }
    PD(paramInt);
    AppMethodBeat.o(359020);
  }
  
  private final void a(final com.tencent.mm.plugin.finder.live.view.adapter.holder.d paramd, final int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(359068);
    final ah.f localf = new ah.f();
    localf.aqH = PC(paramInt1);
    Object localObject;
    long l1;
    label77:
    label99:
    long l2;
    if (((localf.aqH instanceof com.tencent.mm.plugin.finder.live.view.convert.k)) || ((localf.aqH instanceof i)))
    {
      localObject = localf.aqH;
      if (!(localObject instanceof com.tencent.mm.plugin.finder.live.view.convert.k)) {
        break label312;
      }
      localObject = (com.tencent.mm.plugin.finder.live.view.convert.k)localObject;
      if (localObject != null) {
        break label318;
      }
      l1 = 0L;
      localObject = localf.aqH;
      if (!(localObject instanceof i)) {
        break label328;
      }
      localObject = (i)localObject;
      if (localObject != null) {
        break label334;
      }
      l2 = 0L;
      label107:
      if (!(localf.aqH instanceof i)) {
        break label344;
      }
    }
    label312:
    label318:
    label328:
    label334:
    label344:
    for (final int i = 1;; i = 0)
    {
      Log.i("Finder.LiveShoppingListAdapter", "promoteProduct id:" + l1 + ",adId:" + l2 + " scene:" + paramInt2 + ", promoteType:" + i);
      localObject = com.tencent.mm.ui.component.k.aeZF;
      localObject = ((bn)com.tencent.mm.ui.component.k.nq(this.context).cq(bn.class)).fou();
      long l3 = ((f)this.CvU.business(f.class)).liveInfo.liveId;
      long l4 = ((f)this.CvU.business(f.class)).hKN;
      String str = z.bAW();
      kotlin.g.b.s.s(str, "getMyFinderUsername()");
      new an(l3, l4, str, l1, i, l2, paramInt2, (bui)localObject, (an.a)new f(l1, l2, localf, paramInt2, i, this, paramd, paramInt1)).bFJ();
      AppMethodBeat.o(359068);
      return;
      localObject = null;
      break;
      l1 = ((com.tencent.mm.plugin.finder.live.view.convert.k)localObject).DVk;
      break label77;
      localObject = null;
      break label99;
      l2 = ((i)localObject).DUP;
      break label107;
    }
  }
  
  private final void a(com.tencent.mm.plugin.finder.live.view.convert.k paramk, com.tencent.mm.plugin.finder.live.view.adapter.holder.d paramd)
  {
    AppMethodBeat.i(358955);
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.a(this.CvU, paramk.DVj);
    localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (!com.tencent.mm.plugin.finder.live.utils.a.bUx())
    {
      localObject = paramk.DVj.aaij;
      if ((localObject != null) && (((ehg)localObject).replay_status == 2)) {}
      for (int i = 1; (i != 0) && (paramk.DVr == 0); i = 0)
      {
        paramd.DUz.setVisibility(0);
        paramd.DUA.setVisibility(0);
        paramd.DUz.setOnClickListener(new ae..ExternalSyntheticLambda4(this, paramk));
        AppMethodBeat.o(358955);
        return;
      }
    }
    paramd.DUz.setVisibility(8);
    paramd.DUA.setVisibility(paramd.DUr.getVisibility());
    AppMethodBeat.o(358955);
  }
  
  private final void a(com.tencent.mm.plugin.finder.live.view.convert.k paramk, com.tencent.mm.plugin.finder.live.view.adapter.holder.d paramd, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(358942);
    paramd.a(paramk, this.DSR);
    if (paramBoolean)
    {
      paramd.DSU.setVisibility(8);
      paramd.caK.setTag(p.e.BEL, "");
      if (((f)this.CvU.business(f.class)).liveInfo.liveId != 0L) {
        break label157;
      }
      paramd.DUs.setVisibility(8);
      label75:
      if (paramk.DVr != 1) {
        break label241;
      }
      a(true, paramd);
    }
    for (;;)
    {
      a(paramd, paramInt);
      b(paramk, paramd);
      a(paramk, paramd);
      AppMethodBeat.o(358942);
      return;
      paramd.DSU.setVisibility(0);
      paramd.DSU.setText((CharSequence)Pz(paramInt));
      paramd.caK.setTag(p.e.BEL, paramd.DSU.getText());
      break;
      label157:
      if (paramk.DVm <= 0)
      {
        com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if (com.tencent.mm.plugin.finder.live.utils.a.Ps(paramk.DVs)) {}
      }
      else
      {
        if (a.eqc())
        {
          if (paramk.DVr == 1)
          {
            a(true, true, false, paramd, paramInt, paramk);
            break label75;
          }
          a(true, false, false, paramd, paramInt, paramk);
          break label75;
        }
        a(false, false, false, paramd, paramInt, paramk);
        break label75;
      }
      a(false, false, true, paramd, paramInt, paramk);
      break label75;
      label241:
      a(false, paramd);
    }
  }
  
  private final void a(boolean paramBoolean, com.tencent.mm.plugin.finder.live.view.adapter.holder.d paramd)
  {
    AppMethodBeat.i(359010);
    if (paramBoolean)
    {
      if (paramd.DUr.getVisibility() != 0)
      {
        paramd.DUr.setVisibility(0);
        paramd.DUA.setVisibility(0);
        paramd.DUr.fkY();
        if (this.hKC)
        {
          com.tencent.mm.plugin.finder.live.report.j localj = com.tencent.mm.plugin.finder.live.report.j.Dob;
          com.tencent.mm.plugin.finder.live.report.j.Doc.Dqu = true;
        }
        Log.i("Finder.LiveShoppingListAdapter", "showPromotingProduct,desc:" + paramd.DSV.getText() + ",id:" + paramd.DSU.getText() + ",platformId:" + paramd.DUu.getText());
        AppMethodBeat.o(359010);
      }
    }
    else if (paramd.DUr.getVisibility() == 0)
    {
      paramd.DUr.setVisibility(8);
      paramd.DUA.setVisibility(paramd.DUz.getVisibility());
      paramd.DUr.dxz();
      Log.i("Finder.LiveShoppingListAdapter", "hidePromotingProduct,desc:" + paramd.DSV.getText() + ",id:" + paramd.DSU.getText() + ",platformId:" + paramd.DUu.getText());
    }
    AppMethodBeat.o(359010);
  }
  
  private static void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, com.tencent.mm.plugin.finder.live.view.adapter.holder.d paramd, int paramInt)
  {
    AppMethodBeat.i(359000);
    Log.i("Finder.LiveShoppingListAdapter", "setAnchorPromoteText,anchor:" + paramBoolean1 + ",promoting:" + paramBoolean2 + ",pos:" + paramInt);
    if (paramBoolean1 == true) {
      if (paramBoolean2)
      {
        paramd.DUs.setText((CharSequence)paramd.DUs.getContext().getResources().getString(p.h.CsR));
        paramd.DUs.setTextColor(paramd.DUs.getContext().getResources().getColor(p.b.finder_live_logo_color));
        paramd.DUs.setBackgroundResource(p.d.BAO);
      }
    }
    for (;;)
    {
      paramd.DUs.setEnabled(true);
      AppMethodBeat.o(359000);
      return;
      paramd.DUs.setText((CharSequence)paramd.DUs.getContext().getResources().getString(p.h.CsQ));
      paramd.DUs.setTextColor(paramd.DUs.getContext().getResources().getColor(p.b.White));
      paramd.DUs.setBackgroundResource(p.d.BzN);
      continue;
      if (!paramBoolean1)
      {
        paramd.DUs.setText((CharSequence)paramString);
        paramd.DUs.setTextColor(paramd.DUs.getContext().getResources().getColor(p.b.White));
        paramd.DUs.setBackgroundResource(p.d.BzN);
      }
    }
  }
  
  private static void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, com.tencent.mm.plugin.finder.live.view.adapter.holder.d paramd, int paramInt, com.tencent.mm.plugin.finder.live.view.convert.k paramk)
  {
    AppMethodBeat.i(358989);
    StringBuilder localStringBuilder = new StringBuilder("setAnchorPromoteText,anchor:").append(paramBoolean1).append(",promoting:").append(paramBoolean2).append(",pos:").append(paramInt).append(",button_wording:");
    if (paramk == null) {}
    for (Object localObject = null;; localObject = paramk.wul)
    {
      Log.i("Finder.LiveShoppingListAdapter", localObject);
      if (!paramBoolean3) {
        break;
      }
      paramd.DUs.setText((CharSequence)paramd.DUs.getContext().getResources().getString(p.h.CsK));
      paramd.DUs.setTextColor(paramd.DUs.getContext().getResources().getColor(p.b.UN_BW_0_Alpha_0_1));
      paramd.DUs.setBackgroundResource(p.d.BAO);
      paramd.DUs.setEnabled(false);
      AppMethodBeat.o(358989);
      return;
    }
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        paramd.DUs.setText((CharSequence)paramd.DUs.getContext().getResources().getString(p.h.CsR));
        paramd.DUs.setTextColor(paramd.DUs.getContext().getResources().getColor(p.b.finder_live_logo_color));
        paramd.DUs.setBackgroundResource(p.d.BAO);
        paramd.DUs.setEnabled(true);
        AppMethodBeat.o(358989);
        return;
      }
      localObject = paramd.DUs;
      paramk = (CharSequence)paramd.DUs.getContext().getResources().getString(p.h.CsQ);
    }
    for (;;)
    {
      ((TextView)localObject).setText(paramk);
      paramd.DUs.setTextColor(paramd.DUs.getContext().getResources().getColor(p.b.White));
      paramd.DUs.setBackgroundResource(p.d.BzN);
      break;
      localObject = paramd.DUs;
      if (paramk == null) {}
      for (paramk = null;; paramk = paramk.wul)
      {
        if (paramk != null) {
          break label366;
        }
        paramk = (CharSequence)paramd.DUs.getContext().getResources().getString(p.h.Cso);
        break;
      }
      label366:
      paramk = (CharSequence)paramk;
    }
  }
  
  private static final boolean a(ae paramae, com.tencent.mm.plugin.finder.live.view.adapter.holder.d paramd, int paramInt, View paramView)
  {
    AppMethodBeat.i(359119);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramae);
    localb.cH(paramd);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    kotlin.g.b.s.u(paramae, "this$0");
    kotlin.g.b.s.u(paramd, "$holder");
    paramae = paramae.DTn;
    if (paramae != null)
    {
      kotlin.g.b.s.s(paramView, "it");
      paramae.invoke(paramd, paramView, Integer.valueOf(paramInt));
    }
    com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(359119);
    return true;
  }
  
  private static void ay(LinkedList<cc> paramLinkedList)
  {
    AppMethodBeat.i(358917);
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    int i = 0;
    while (paramLinkedList.hasNext())
    {
      Object localObject = paramLinkedList.next();
      int j = i + 1;
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      localObject = (cc)localObject;
      com.tencent.mm.plugin.finder.live.report.j localj;
      if ((localObject instanceof com.tencent.mm.plugin.finder.live.view.convert.k))
      {
        localj = com.tencent.mm.plugin.finder.live.report.j.Dob;
        com.tencent.mm.plugin.finder.live.report.j.Doc.Dqw.add(Long.valueOf(((com.tencent.mm.plugin.finder.live.view.convert.k)localObject).DVk));
        i = j;
      }
      else
      {
        if ((localObject instanceof i))
        {
          localj = com.tencent.mm.plugin.finder.live.report.j.Dob;
          com.tencent.mm.plugin.finder.live.report.j.Doc.Dqw.add(Long.valueOf(((i)localObject).DUP));
        }
        i = j;
      }
    }
    AppMethodBeat.o(358917);
  }
  
  private static final void b(ae paramae, int paramInt, com.tencent.mm.plugin.finder.live.view.adapter.holder.d paramd, View paramView)
  {
    AppMethodBeat.i(359127);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramae);
    localb.sc(paramInt);
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramae, "this$0");
    kotlin.g.b.s.u(paramd, "$holder");
    paramae.a(paramInt, paramd, q.bx.DDJ);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(359127);
  }
  
  private static final void b(ae paramae, com.tencent.mm.plugin.finder.live.view.adapter.holder.d paramd, int paramInt, View paramView)
  {
    AppMethodBeat.i(359132);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramae);
    localb.cH(paramd);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramae, "this$0");
    kotlin.g.b.s.u(paramd, "$holder");
    paramView = aw.Gjk;
    if (aw.isFastClick())
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(359132);
      return;
    }
    if (a.eqc()) {
      paramae.c(paramd, paramInt);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(359132);
      return;
      paramae.a(paramInt, paramd, q.bx.DDK);
    }
  }
  
  private final void b(com.tencent.mm.plugin.finder.live.view.adapter.holder.d paramd, int paramInt)
  {
    AppMethodBeat.i(359032);
    paramd.caK.setOnClickListener(new ae..ExternalSyntheticLambda2(this, paramInt, paramd));
    paramd.DUs.setOnClickListener(new ae..ExternalSyntheticLambda3(this, paramd, paramInt));
    if (a.eqc()) {
      paramd.caK.setOnLongClickListener(ae..ExternalSyntheticLambda8.INSTANCE);
    }
    PD(paramInt);
    AppMethodBeat.o(359032);
  }
  
  private final void b(com.tencent.mm.plugin.finder.live.view.convert.k paramk, com.tencent.mm.plugin.finder.live.view.adapter.holder.d paramd)
  {
    AppMethodBeat.i(358965);
    FinderLiveProductRecordView localFinderLiveProductRecordView = paramd.DUy;
    if (!com.tencent.mm.ae.d.ee((int)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).Eio, 1))
    {
      localFinderLiveProductRecordView.setVisibility(8);
      AppMethodBeat.o(358965);
      return;
    }
    paramd = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if ((com.tencent.mm.plugin.finder.live.utils.a.bUx()) && (((e)this.CvU.business(e.class)).EcA))
    {
      paramd = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).Ein;
      int i;
      if ((paramd != null) && (paramd.ZTl == 1))
      {
        i = 1;
        if (i == 0) {
          break label355;
        }
        paramd = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).Ein;
        if ((paramd == null) || (paramd.ZTm != 1)) {
          break label213;
        }
        i = 1;
        label145:
        if (i == 0) {
          break label218;
        }
        localFinderLiveProductRecordView.setVisibility(0);
        localFinderLiveProductRecordView.setOnClickListener(null);
      }
      for (;;)
      {
        paramd = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        com.tencent.mm.plugin.finder.live.utils.a.a(this.CvU, paramk.DVj);
        localFinderLiveProductRecordView.a(paramk.DVj);
        localFinderLiveProductRecordView.setNotifyRecordBtnCallBack((kotlin.g.a.b)new b(this));
        AppMethodBeat.o(358965);
        return;
        i = 0;
        break;
        label213:
        i = 0;
        break label145;
        label218:
        paramd = paramk.DVj.aaij;
        if (paramd == null)
        {
          paramd = null;
          label232:
          if (paramd != null) {
            break label286;
          }
          label236:
          if (paramd != null) {
            break label298;
          }
          if (paramd != null) {
            break label310;
          }
          label244:
          if (paramd != null) {
            break label321;
          }
          label248:
          if (paramd != null) {
            break label334;
          }
          label252:
          i = 0;
          label254:
          if (i == 0) {
            break label345;
          }
          localFinderLiveProductRecordView.setVisibility(0);
        }
        for (;;)
        {
          localFinderLiveProductRecordView.setOnClickListener(ae..ExternalSyntheticLambda5.INSTANCE);
          break;
          paramd = Integer.valueOf(paramd.replay_status);
          break label232;
          label286:
          if (paramd.intValue() != 0) {
            break label236;
          }
          for (;;)
          {
            i = 1;
            break label254;
            label298:
            if (paramd.intValue() != 100)
            {
              break;
              label310:
              if (paramd.intValue() != 2)
              {
                break label244;
                label321:
                if (paramd.intValue() != 1000)
                {
                  break label248;
                  label334:
                  if (paramd.intValue() != 1) {
                    break label252;
                  }
                }
              }
            }
          }
          label345:
          localFinderLiveProductRecordView.setVisibility(8);
        }
        label355:
        localFinderLiveProductRecordView.setVisibility(8);
      }
    }
    localFinderLiveProductRecordView.setVisibility(8);
    AppMethodBeat.o(358965);
  }
  
  private final void c(com.tencent.mm.plugin.finder.live.view.adapter.holder.d paramd, int paramInt)
  {
    AppMethodBeat.i(359060);
    cc localcc = PC(paramInt);
    if (localcc == null)
    {
      AppMethodBeat.o(359060);
      return;
    }
    Object localObject2 = paramd.DUs;
    if (localObject2 == null)
    {
      paramd = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(359060);
      throw paramd;
    }
    Object localObject3;
    Object localObject1;
    label181:
    label191:
    label336:
    cr localcr;
    if (a.eqc())
    {
      localObject3 = new StringBuilder().append(((TextView)localObject2).getText()).append(" pos:").append(paramInt).append(",appId:");
      if ((localcc instanceof com.tencent.mm.plugin.finder.live.view.convert.k))
      {
        localObject1 = (com.tencent.mm.plugin.finder.live.view.convert.k)localcc;
        if (localObject1 != null) {
          break label181;
        }
      }
      for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.finder.live.view.convert.k)localObject1).title)
      {
        Log.i("Finder.LiveShoppingListAdapter", localObject1);
        if (!kotlin.g.b.s.p(((TextView)localObject2).getText().toString(), ((TextView)localObject2).getContext().getResources().getString(p.h.CsQ))) {
          break label191;
        }
        a(paramd, paramInt, 1);
        AppMethodBeat.o(359060);
        return;
        localObject1 = null;
        break;
      }
      if (kotlin.g.b.s.p(((TextView)localObject2).getText().toString(), ((TextView)localObject2).getContext().getResources().getString(p.h.CsR)))
      {
        a(paramd, paramInt, 2);
        AppMethodBeat.o(359060);
      }
    }
    else
    {
      if ((localcc instanceof com.tencent.mm.plugin.finder.live.view.convert.k))
      {
        localObject1 = new StringBuilder("buy pos:").append(paramInt).append(",buy appId:");
        paramd = ((com.tencent.mm.plugin.finder.live.view.convert.k)localcc).DVq;
        if (paramd == null)
        {
          paramd = null;
          localObject1 = ((StringBuilder)localObject1).append(paramd).append(",buy path:");
          paramd = ((com.tencent.mm.plugin.finder.live.view.convert.k)localcc).DVq;
          if (paramd != null) {
            break label424;
          }
          paramd = null;
          label307:
          localObject1 = ((StringBuilder)localObject1).append(paramd).append(",detail appId:");
          paramd = ((com.tencent.mm.plugin.finder.live.view.convert.k)localcc).DVp;
          if (paramd != null) {
            break label432;
          }
          paramd = null;
          localObject1 = ((StringBuilder)localObject1).append(paramd).append(", detail path:");
          paramd = ((com.tencent.mm.plugin.finder.live.view.convert.k)localcc).DVp;
          if (paramd != null) {
            break label440;
          }
        }
        label424:
        label432:
        label440:
        for (paramd = null;; paramd = paramd.path)
        {
          Log.i("Finder.LiveShoppingListAdapter", paramd);
          paramd = com.tencent.mm.plugin.finder.live.k.Bxu;
          com.tencent.mm.plugin.finder.live.k.b(this.CvU, (com.tencent.mm.plugin.finder.live.view.convert.k)localcc, (kotlin.g.a.m)new h(localcc, this));
          AppMethodBeat.o(359060);
          return;
          paramd = paramd.appid;
          break;
          paramd = paramd.path;
          break label307;
          paramd = paramd.appid;
          break label336;
        }
      }
      if ((localcc instanceof i))
      {
        localcr = ((i)localcc).DUQ;
        if (localcr != null)
        {
          if (!this.hKC)
          {
            com.tencent.mm.plugin.finder.live.report.k localk = com.tencent.mm.plugin.finder.live.report.k.Doi;
            q.bx localbx = q.bx.DDK;
            long l1 = ((i)localcc).DUP;
            localObject1 = ((i)localcc).DUQ;
            if (localObject1 != null) {
              break label778;
            }
            localObject1 = "";
            long l2 = ((i)localcc).DUP;
            localObject3 = ((i)localcc).mdG;
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            localk.a(localbx, null, String.valueOf(l1), (String)localObject1, String.valueOf(l2), (String)localObject2);
          }
          localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (((Boolean)com.tencent.mm.plugin.finder.storage.d.eWS().bmg()).booleanValue())
          {
            localObject1 = this.CvU;
            if (localObject1 != null) {
              break label802;
            }
            localObject1 = null;
            label606:
            ((e)localObject1).EeF = null;
            localObject1 = this.CvU;
            if (localObject1 != null) {
              break label818;
            }
            localObject1 = null;
            label626:
            ((e)localObject1).EeG.clear();
          }
          localObject1 = ((e)this.CvU.business(e.class)).EeF;
          if (localObject1 == null) {
            break label839;
          }
          if (((CharSequence)localObject1).length() <= 0) {
            break label834;
          }
          paramInt = 1;
          label672:
          if (paramInt != 1) {
            break label839;
          }
          paramInt = 1;
          label679:
          if (paramInt == 0) {
            break label844;
          }
          Log.i("Finder.LiveShoppingListAdapter", kotlin.g.b.s.X("get uxInfo from outsize:", ((e)this.CvU.business(e.class)).EeF));
          localObject1 = ((e)this.CvU.business(e.class)).EeF;
        }
      }
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      localObject2 = paramd.caK.getContext();
      kotlin.g.b.s.s(localObject2, "holder.itemView.context");
      paramd = (com.tencent.mm.plugin.finder.live.view.adapter.holder.d)localObject1;
      if (localObject1 == null) {
        paramd = "";
      }
      com.tencent.mm.plugin.finder.live.utils.a.a((Context)localObject2, localcr, paramd);
      AppMethodBeat.o(359060);
      return;
      label778:
      localObject2 = ((cr)localObject1).YEY;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      label802:
      localObject1 = (e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(e.class);
      break label606;
      label818:
      localObject1 = (e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(e.class);
      break label626;
      label834:
      paramInt = 0;
      break label672;
      label839:
      paramInt = 0;
      break label679;
      label844:
      if (((e)this.CvU.business(e.class)).EeG.containsKey(Long.valueOf(((i)localcc).DUP)))
      {
        localObject1 = (String)((e)this.CvU.business(e.class)).EeG.get(Long.valueOf(((i)localcc).DUP));
        if (localObject1 != null) {
          if (((CharSequence)localObject1).length() > 0)
          {
            paramInt = 1;
            if (paramInt != 1) {
              break label1033;
            }
          }
        }
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label1038;
          }
          Log.i("Finder.LiveShoppingListAdapter", "get uxInfo from cgi-getShowShopSelf,adid:" + ((i)localcc).DUP + ",uxinfo:" + ((i)localcc).mdG);
          localObject1 = (String)((e)this.CvU.business(e.class)).EeG.get(Long.valueOf(((i)localcc).DUP));
          break;
          paramInt = 0;
          break label932;
        }
      }
      label932:
      localObject3 = new StringBuilder("get uxInfo from promotingProduct,adid:").append(((i)localcc).DUP).append(",uxinfo:");
      label1033:
      label1038:
      localObject2 = ((i)localcc).mdG;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      Log.i("Finder.LiveShoppingListAdapter", (String)localObject1);
      localObject2 = ((i)localcc).mdG;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
  }
  
  private boolean evX()
  {
    AppMethodBeat.i(358900);
    if (this.DTg.size() > 0)
    {
      AppMethodBeat.o(358900);
      return true;
    }
    AppMethodBeat.o(358900);
    return false;
  }
  
  private final void evY()
  {
    AppMethodBeat.i(358912);
    int i = -1;
    Object localObject2 = (Iterable)this.DTh;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if ((localObject3 instanceof com.tencent.mm.plugin.finder.live.view.convert.k)) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    Iterator localIterator = ((Iterable)localObject1).iterator();
    localObject1 = null;
    int k;
    label182:
    int j;
    if (localIterator.hasNext())
    {
      localObject3 = (com.tencent.mm.plugin.finder.live.view.convert.k)localIterator.next();
      localObject2 = FinderLiveShoppingPriceView.DPr;
      kotlin.g.b.s.u(localObject3, "item");
      StringBuilder localStringBuilder = new StringBuilder(MMApplicationContext.getContext().getString(p.h.CsC));
      localObject2 = ((com.tencent.mm.plugin.finder.live.view.convert.k)localObject3).ewd();
      Resources localResources = MMApplicationContext.getContext().getResources();
      k = p.h.finder_live_shopping_price;
      aw localaw = aw.Gjk;
      if (localObject2 == null)
      {
        localObject2 = null;
        if (localObject2 != null) {
          break label250;
        }
        j = ((com.tencent.mm.plugin.finder.live.view.convert.k)localObject3).DVo;
        label193:
        localStringBuilder.append(localResources.getString(k, new Object[] { aw.Uu(j) }));
        j = localStringBuilder.length();
        if (j <= i) {
          break label460;
        }
        i = j;
        localObject1 = localObject3;
      }
    }
    label433:
    label438:
    label450:
    label455:
    label460:
    for (;;)
    {
      break;
      localObject2 = Integer.valueOf(((aoj)localObject2).MRD);
      break label182;
      label250:
      j = ((Integer)localObject2).intValue();
      break label193;
      int m;
      int n;
      float f;
      if (localObject1 != null)
      {
        j = com.tencent.mm.cd.a.bs(this.context, p.c.Bzt);
        k = com.tencent.mm.cd.a.bs(this.context, p.c.Bzs);
        m = com.tencent.mm.cd.a.bs(this.context, p.c.Bzr);
        n = com.tencent.mm.cd.a.bs(this.context, p.c.Bzq);
        localObject2 = this.DSJ;
        if ((localObject2 == null) || (((bz)localObject2).isLandscape() != true)) {
          break label433;
        }
        i = 1;
        if (i == 0) {
          break label438;
        }
        f = bf.bf(this.context).y;
        label349:
        localObject2 = FinderLiveShoppingPriceView.DPr;
        localObject2 = this.context;
        localObject3 = this.DSJ;
        if ((localObject3 == null) || (((bz)localObject3).isLandscape() != true)) {
          break label450;
        }
        i = 1;
        label382:
        if (i == 0) {
          break label455;
        }
      }
      for (i = 4;; i = 2)
      {
        localObject1 = FinderLiveShoppingPriceView.a.a((Context)localObject2, (com.tencent.mm.plugin.finder.live.view.convert.k)localObject1, f - (i * j + m + k + n));
        kotlin.g.b.s.u(localObject1, "<set-?>");
        this.DSR = ((FinderLiveShoppingPriceView.b)localObject1);
        AppMethodBeat.o(358912);
        return;
        i = 0;
        break;
        f = com.tencent.mm.cd.a.ms(this.context);
        break label349;
        i = 0;
        break label382;
      }
    }
  }
  
  private final void evZ()
  {
    AppMethodBeat.i(358932);
    this.DSF.clear();
    if (!((Collection)this.DTj).isEmpty()) {
      i = 1;
    }
    ArrayList localArrayList;
    Object localObject;
    Collection localCollection;
    while (i != 0)
    {
      this.DSF.add(Integer.valueOf(0));
      localArrayList = this.DSF;
      localObject = (Iterable)this.DTj;
      localCollection = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          ((Iterator)localObject).next();
          localCollection.add(Integer.valueOf(3));
          continue;
          i = 0;
          break;
        }
      }
      localArrayList.addAll((Collection)localCollection);
    }
    if (!((Collection)this.DTj).isEmpty())
    {
      i = 1;
      if (i == 0) {
        if (((Collection)this.DTh).isEmpty()) {
          break label268;
        }
      }
    }
    label268:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.DSF.add(Integer.valueOf(1));
      }
      localArrayList = this.DSF;
      localObject = (Iterable)this.DTh;
      localCollection = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ((Iterator)localObject).next();
        localCollection.add(Integer.valueOf(2));
      }
      i = 0;
      break;
    }
    localArrayList.addAll((Collection)localCollection);
    AppMethodBeat.o(358932);
  }
  
  private static final void gh(View paramView)
  {
    AppMethodBeat.i(359097);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(359097);
  }
  
  private static final boolean gi(View paramView)
  {
    AppMethodBeat.i(359138);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(359138);
    return true;
  }
  
  private final void o(final auw paramauw)
  {
    AppMethodBeat.i(359076);
    Log.i("Finder.LiveShoppingListAdapter", kotlin.g.b.s.X("modifyShelfProduct :scene:", Integer.valueOf(paramauw.cmdId)));
    if (this.DSJ != null)
    {
      ap localap = bz.getFinderLiveAssistant();
      if (localap != null) {
        localap.a((MMActivity)this.context, ((f)this.CvU.business(f.class)).liveInfo.liveId, ((f)this.CvU.business(f.class)).hKN, ((e)this.CvU.business(e.class)).mIC, paramauw, (kotlin.g.a.q)new e(this, paramauw));
      }
    }
    AppMethodBeat.o(359076);
  }
  
  public final int PA(int paramInt)
  {
    AppMethodBeat.i(359357);
    int i = this.DSF.indexOf(Integer.valueOf(2));
    AppMethodBeat.o(359357);
    return i + paramInt;
  }
  
  public final cc PC(int paramInt)
  {
    AppMethodBeat.i(359418);
    int i;
    if (!((Collection)this.DTg).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label83;
      }
      if (paramInt < 0) {
        break label78;
      }
      if (paramInt >= this.DTg.size()) {
        break label73;
      }
      i = 1;
    }
    cc localcc;
    for (;;)
    {
      if (i == 0) {
        break label83;
      }
      localcc = (cc)this.DTg.get(paramInt);
      AppMethodBeat.o(359418);
      return localcc;
      i = 0;
      break;
      label73:
      i = 0;
      continue;
      label78:
      i = 0;
    }
    label83:
    if (paramInt >= 0) {
      if (paramInt < this.DTh.size()) {
        i = 1;
      }
    }
    while (i != 0)
    {
      localcc = (cc)this.DTh.get(paramInt);
      AppMethodBeat.o(359418);
      return localcc;
      i = 0;
      continue;
      i = 0;
    }
    AppMethodBeat.o(359418);
    return null;
  }
  
  public final void a(RecyclerView.v paramv, int paramInt, List<Object> paramList)
  {
    AppMethodBeat.i(359393);
    kotlin.g.b.s.u(paramv, "holder");
    kotlin.g.b.s.u(paramList, "payloads");
    Log.i("Finder.LiveShoppingListAdapter", "onBindViewHolder payload, pos:" + paramInt + ",payloads:" + paramList);
    if (evX())
    {
      d(paramv, paramInt);
      AppMethodBeat.o(359393);
      return;
    }
    if ((getItemViewType(paramInt) == 2) && ((paramv instanceof com.tencent.mm.plugin.finder.live.view.adapter.holder.d)))
    {
      int j = hN(paramInt, 2);
      boolean bool2 = PC(j) instanceof i;
      int i;
      if (((Collection)paramList).isEmpty())
      {
        i = 1;
        if (i == 0) {
          paramList = ((Iterable)paramList).iterator();
        }
      }
      else
      {
        for (;;)
        {
          label138:
          if (!paramList.hasNext()) {
            break label321;
          }
          Object localObject = paramList.next();
          if ((localObject instanceof Integer))
          {
            boolean bool1;
            if (kotlin.g.b.s.p(localObject, Integer.valueOf(1))) {
              bool1 = true;
            }
            for (;;)
            {
              if (bool1)
              {
                ((com.tencent.mm.plugin.finder.live.view.adapter.holder.d)paramv).DSU.setText((CharSequence)Pz(j));
                paramv.caK.setTag(p.e.BEL, ((com.tencent.mm.plugin.finder.live.view.adapter.holder.d)paramv).DSU.getText());
                if (!bool2)
                {
                  a((com.tencent.mm.plugin.finder.live.view.adapter.holder.d)paramv, j);
                  break label138;
                  i = 0;
                  break;
                  bool1 = kotlin.g.b.s.p(localObject, Integer.valueOf(2));
                  continue;
                }
                b((com.tencent.mm.plugin.finder.live.view.adapter.holder.d)paramv, j);
                break label138;
              }
            }
            if (kotlin.g.b.s.p(localObject, Integer.valueOf(3))) {
              a(true, (com.tencent.mm.plugin.finder.live.view.adapter.holder.d)paramv);
            } else if (kotlin.g.b.s.p(localObject, Integer.valueOf(4))) {
              a(false, (com.tencent.mm.plugin.finder.live.view.adapter.holder.d)paramv);
            }
          }
        }
        label321:
        AppMethodBeat.o(359393);
        return;
      }
      d(paramv, paramInt);
      AppMethodBeat.o(359393);
      return;
    }
    d(paramv, paramInt);
    AppMethodBeat.o(359393);
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.view.adapter.holder.d paramd, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(359434);
    kotlin.g.b.s.u(paramd, "holder");
    kotlin.g.b.s.u(paramView, "itemView");
    cc localcc = PC(paramInt1);
    if (!(localcc instanceof com.tencent.mm.plugin.finder.live.view.convert.k))
    {
      AppMethodBeat.o(359434);
      return;
    }
    Log.i("Finder.LiveShoppingListAdapter", "show popup menu,pos:" + paramInt1 + ",desc:" + paramd.DSV.getText() + ",anchorPosX:" + paramInt2 + ",anchorPosY:" + paramInt3);
    this.vEV.diW();
    this.vEV.a(paramView, new ae..ExternalSyntheticLambda6(this), new ae..ExternalSyntheticLambda9(this, localcc), paramInt2, paramInt3);
    AppMethodBeat.o(359434);
  }
  
  public final void ax(LinkedList<cc> paramLinkedList)
  {
    AppMethodBeat.i(359336);
    Object localObject2 = new StringBuilder("before updateShoppingList,ori size:").append(this.DTh.size()).append(",new size:");
    Object localObject1;
    Object localObject3;
    label108:
    int i;
    if (paramLinkedList == null)
    {
      localObject1 = null;
      Log.i("Finder.LiveShoppingListAdapter", localObject1);
      if (paramLinkedList != null)
      {
        this.DTg.clear();
        this.DTh.clear();
        localObject1 = this.DTh;
        localObject3 = (Iterable)paramLinkedList;
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
      }
    }
    else
    {
      label184:
      for (;;)
      {
        if (!((Iterator)localObject3).hasNext()) {
          break label186;
        }
        localObject4 = ((Iterator)localObject3).next();
        cc localcc = (cc)localObject4;
        if (((localcc instanceof com.tencent.mm.plugin.finder.live.view.convert.k)) || ((localcc instanceof i))) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label184;
          }
          ((Collection)localObject2).add(localObject4);
          break label108;
          localObject1 = Integer.valueOf(paramLinkedList.size());
          break;
        }
      }
      label186:
      ((LinkedList)localObject1).addAll((Collection)localObject2);
      this.DTi.clear();
      localObject2 = this.DTi;
      localObject1 = (Iterable)this.DTh;
      localObject3 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
      Object localObject4 = ((Iterable)localObject1).iterator();
      i = 0;
      if (((Iterator)localObject4).hasNext())
      {
        localObject1 = ((Iterator)localObject4).next();
        if (i < 0) {
          kotlin.a.p.kkW();
        }
        if (((cc)localObject1 instanceof i)) {}
        for (localObject1 = Integer.valueOf(i);; localObject1 = null)
        {
          ((Collection)localObject3).add(localObject1);
          i += 1;
          break;
        }
      }
      ((ArrayList)localObject2).addAll((Collection)kotlin.a.p.l((Iterable)localObject3));
      this.DTj.clear();
      localObject2 = (List)paramLinkedList;
      localObject3 = ((Iterable)paramLinkedList).iterator();
      if (!((Iterator)localObject3).hasNext()) {
        break label593;
      }
      localObject1 = ((Iterator)localObject3).next();
      localObject4 = (cc)localObject1;
      if ((!(localObject4 instanceof com.tencent.mm.plugin.finder.live.view.convert.j)) || (!((com.tencent.mm.plugin.finder.live.view.convert.j)localObject4).DVc)) {
        break label588;
      }
      i = 1;
      label409:
      if (i == 0) {
        break label591;
      }
      label413:
      int j = kotlin.a.p.a((List)localObject2, localObject1);
      i = j;
      if (j < 0)
      {
        localObject2 = (List)paramLinkedList;
        localObject3 = ((Iterable)paramLinkedList).iterator();
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject1 = ((Iterator)localObject3).next();
        } while (!((cc)localObject1 instanceof com.tencent.mm.plugin.finder.live.view.convert.j));
      }
    }
    for (;;)
    {
      i = kotlin.a.p.a((List)localObject2, localObject1);
      if (i >= 0) {
        this.DTj.add(paramLinkedList.get(i));
      }
      evZ();
      if (this.hKC)
      {
        localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        com.tencent.mm.plugin.finder.live.report.j.Doc.Dqw.clear();
        ay(paramLinkedList);
      }
      evY();
      this.bZE.notifyChanged();
      Log.i("Finder.LiveShoppingListAdapter", "after updateShoppingList,data size:" + this.DTh.size() + ",ad list:" + this.DTi);
      AppMethodBeat.o(359336);
      return;
      label588:
      i = 0;
      break label409;
      label591:
      break;
      label593:
      localObject1 = null;
      break label413;
      localObject1 = null;
    }
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(359374);
    kotlin.g.b.s.u(paramViewGroup, "parent");
    switch (paramInt)
    {
    default: 
      paramViewGroup = (RecyclerView.v)new com.tencent.mm.plugin.finder.live.view.adapter.holder.b((View)new FrameLayout(this.context), a.eqc());
      AppMethodBeat.o(359374);
      return paramViewGroup;
    case 0: 
    case 1: 
      paramViewGroup = LayoutInflater.from(this.context).inflate(p.f.CfF, paramViewGroup, false);
      kotlin.g.b.s.s(paramViewGroup, "from(context).inflate(la…ader_item, parent, false)");
      paramViewGroup = new com.tencent.mm.plugin.finder.live.view.adapter.holder.b(paramViewGroup, a.eqc());
      paramViewGroup.DUf = this.DTp;
      paramViewGroup = (RecyclerView.v)paramViewGroup;
      AppMethodBeat.o(359374);
      return paramViewGroup;
    case 2: 
      paramViewGroup = View.inflate(paramViewGroup.getContext(), p.f.CfE, null);
      kotlin.g.b.s.s(paramViewGroup, "inflate(parent.context, …ng_list_goods_item, null)");
      paramViewGroup = (RecyclerView.v)new com.tencent.mm.plugin.finder.live.view.adapter.holder.d(paramViewGroup);
      AppMethodBeat.o(359374);
      return paramViewGroup;
    }
    paramViewGroup = LayoutInflater.from(this.context).inflate(p.f.CfD, paramViewGroup, false);
    kotlin.g.b.s.s(paramViewGroup, "from(context).inflate(la…upon_item, parent, false)");
    paramViewGroup = new com.tencent.mm.plugin.finder.live.view.adapter.holder.a(paramViewGroup);
    paramViewGroup.DUd.setCallback(this.DSK);
    paramViewGroup = (RecyclerView.v)paramViewGroup;
    AppMethodBeat.o(359374);
    return paramViewGroup;
  }
  
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(359415);
    kotlin.g.b.s.u(paramv, "holder");
    Object localObject1;
    Object localObject2;
    if (evX())
    {
      if (getItemViewType(paramInt) == 1)
      {
        localObject1 = am.aixg;
        localObject1 = Locale.getDefault();
        localObject2 = com.tencent.mm.cd.a.bt(this.context, p.h.Csp);
        kotlin.g.b.s.s(localObject2, "getString(context, R.str…ing_can_use_coupon_title)");
        localObject1 = String.format((Locale)localObject1, (String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(this.DTg.size()) }, 1));
        kotlin.g.b.s.s(localObject1, "java.lang.String.format(locale, format, *args)");
        ((com.tencent.mm.plugin.finder.live.view.adapter.holder.b)paramv).a((String)localObject1, b.a.DUm, false, ewa(), false);
        AppMethodBeat.o(359415);
        return;
      }
      localObject1 = this.DTg.get(paramInt - 1);
      kotlin.g.b.s.s(localObject1, "canUseCouponGoodsList[position - 1]");
      a((com.tencent.mm.plugin.finder.live.view.convert.k)localObject1, (com.tencent.mm.plugin.finder.live.view.adapter.holder.d)paramv, paramInt - 1, true);
      AppMethodBeat.o(359415);
      return;
    }
    Object localObject3;
    Object localObject4;
    Object localObject5;
    if ((getItemViewType(paramInt) == 2) && ((paramv instanceof com.tencent.mm.plugin.finder.live.view.adapter.holder.d)))
    {
      paramInt = hN(paramInt, 2);
      localObject1 = this.DTh.get(paramInt);
      kotlin.g.b.s.s(localObject1, "goodsAndAdList[goodsPos]");
      localObject1 = (cc)localObject1;
      if ((localObject1 instanceof com.tencent.mm.plugin.finder.live.view.convert.k))
      {
        a((com.tencent.mm.plugin.finder.live.view.convert.k)localObject1, (com.tencent.mm.plugin.finder.live.view.adapter.holder.d)paramv, paramInt, false);
        AppMethodBeat.o(359415);
        return;
      }
      if ((localObject1 instanceof i))
      {
        localObject3 = (i)localObject1;
        localObject4 = (com.tencent.mm.plugin.finder.live.view.adapter.holder.d)paramv;
        ((com.tencent.mm.plugin.finder.live.view.adapter.holder.d)localObject4).DUt.setVisibility(0);
        ((com.tencent.mm.plugin.finder.live.view.adapter.holder.d)localObject4).DTa.setVisibility(8);
        ((com.tencent.mm.plugin.finder.live.view.adapter.holder.d)localObject4).DSU.setVisibility(8);
        ((com.tencent.mm.plugin.finder.live.view.adapter.holder.d)localObject4).DUu.setVisibility(8);
        Log.i("Finder.LiveShoppingListAdapter", "bindAdItem " + ((i)localObject3).DUT + ", " + ((i)localObject3).title + ", " + ((i)localObject3).DUS);
        paramv = com.tencent.mm.plugin.finder.loader.p.ExI;
        paramv = com.tencent.mm.plugin.finder.loader.p.eCn();
        localObject1 = new com.tencent.mm.plugin.finder.loader.s(((i)localObject3).DUR, v.FKZ);
        localObject2 = ((com.tencent.mm.plugin.finder.live.view.adapter.holder.d)localObject4).DST;
        kotlin.g.b.s.s(localObject2, "holder.productImg");
        localObject5 = com.tencent.mm.plugin.finder.loader.p.ExI;
        paramv.a(localObject1, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExV));
        ((com.tencent.mm.plugin.finder.live.view.adapter.holder.d)localObject4).DSU.setText((CharSequence)"");
        paramv = ((com.tencent.mm.plugin.finder.live.view.adapter.holder.d)localObject4).DUt;
        if (paramv != null) {
          paramv.setText((CharSequence)((i)localObject3).desc);
        }
        localObject5 = ((com.tencent.mm.plugin.finder.live.view.adapter.holder.d)localObject4).DSV;
        kotlin.g.b.s.s(localObject5, "holder.productDesc");
        localObject1 = ((i)localObject3).DUT;
        paramv = (RecyclerView.v)localObject1;
        if (localObject1 == null) {
          paramv = "";
        }
        localObject2 = ((i)localObject3).title;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        a.a((TextView)localObject5, paramv, (String)localObject1);
        ((com.tencent.mm.plugin.finder.live.view.adapter.holder.d)localObject4).DUs.setVisibility(0);
        if (((f)this.CvU.business(f.class)).liveInfo.liveId == 0L)
        {
          ((com.tencent.mm.plugin.finder.live.view.adapter.holder.d)localObject4).DUs.setVisibility(8);
          if (((i)localObject3).Caa != 1) {
            break label698;
          }
          a(true, (com.tencent.mm.plugin.finder.live.view.adapter.holder.d)localObject4);
        }
        for (;;)
        {
          b((com.tencent.mm.plugin.finder.live.view.adapter.holder.d)localObject4, paramInt);
          AppMethodBeat.o(359415);
          return;
          if (a.eqc())
          {
            if (((i)localObject3).Caa == 1)
            {
              localObject1 = ((i)localObject3).DUS;
              paramv = (RecyclerView.v)localObject1;
              if (localObject1 == null) {
                paramv = "";
              }
              a(true, true, paramv, (com.tencent.mm.plugin.finder.live.view.adapter.holder.d)localObject4, paramInt);
              break;
            }
            localObject1 = ((i)localObject3).DUS;
            paramv = (RecyclerView.v)localObject1;
            if (localObject1 == null) {
              paramv = "";
            }
            a(true, false, paramv, (com.tencent.mm.plugin.finder.live.view.adapter.holder.d)localObject4, paramInt);
            break;
          }
          localObject1 = ((i)localObject3).DUS;
          paramv = (RecyclerView.v)localObject1;
          if (localObject1 == null) {
            paramv = "";
          }
          a(false, false, paramv, (com.tencent.mm.plugin.finder.live.view.adapter.holder.d)localObject4, paramInt);
          break;
          label698:
          a(false, (com.tencent.mm.plugin.finder.live.view.adapter.holder.d)localObject4);
        }
      }
    }
    else
    {
      boolean bool2;
      if ((getItemViewType(paramInt) == 3) && ((paramv instanceof com.tencent.mm.plugin.finder.live.view.adapter.holder.a)))
      {
        localObject1 = (com.tencent.mm.plugin.finder.live.view.convert.j)this.DTj.get(hN(paramInt, 3));
        paramv = (com.tencent.mm.plugin.finder.live.view.adapter.holder.a)paramv;
        localObject2 = paramv.DUd;
        bool2 = a.eqc();
        if (((f)this.CvU.business(f.class)).liveInfo.liveId == 0L)
        {
          bool1 = true;
          ((FinderLiveShoppingCouponView)localObject2).a((com.tencent.mm.plugin.finder.live.view.convert.j)localObject1, bool2, bool1);
          paramv = paramv.caK.getLayoutParams();
          localObject1 = this.context;
          if (!a.eqc()) {
            break label840;
          }
        }
        label840:
        for (paramInt = p.c.Bzu;; paramInt = p.c.Bzv)
        {
          paramv.height = com.tencent.mm.cd.a.bs((Context)localObject1, paramInt);
          AppMethodBeat.o(359415);
          return;
          bool1 = false;
          break;
        }
      }
      if ((getItemViewType(paramInt) == 1) && ((paramv instanceof com.tencent.mm.plugin.finder.live.view.adapter.holder.b)))
      {
        paramInt = this.DTh.size();
        if (paramInt == 0)
        {
          localObject1 = com.tencent.mm.cd.a.bt(this.context, p.h.finder_live_shopping_title);
          paramv = (com.tencent.mm.plugin.finder.live.view.adapter.holder.b)paramv;
          kotlin.g.b.s.s(localObject1, "title");
          localObject2 = b.a.DUm;
          if (((Collection)this.DTj).isEmpty()) {
            break label1063;
          }
        }
        boolean bool3;
        label1063:
        for (bool1 = true;; bool1 = false)
        {
          bool3 = ewa();
          localObject4 = (Iterable)this.DTh;
          localObject3 = (Collection)new ArrayList();
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = ((Iterator)localObject4).next();
            if ((localObject5 instanceof i)) {
              ((Collection)localObject3).add(localObject5);
            }
          }
          localObject1 = am.aixg;
          localObject1 = Locale.getDefault();
          localObject2 = com.tencent.mm.cd.a.bt(this.context, p.h.CsS);
          kotlin.g.b.s.s(localObject2, "getString(context, R.str…_shopping_title_with_num)");
          localObject1 = String.format((Locale)localObject1, (String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(paramInt) }, 1));
          kotlin.g.b.s.s(localObject1, "java.lang.String.format(locale, format, *args)");
          break;
        }
        if (!((Collection)localObject3).isEmpty()) {}
        for (bool2 = true;; bool2 = false)
        {
          paramv.a((String)localObject1, (b.a)localObject2, bool1, bool3, bool2);
          AppMethodBeat.o(359415);
          return;
        }
      }
      if ((getItemViewType(paramInt) == 0) && ((paramv instanceof com.tencent.mm.plugin.finder.live.view.adapter.holder.b)))
      {
        paramInt = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).Eid;
        if (paramInt != 0) {
          break label1217;
        }
        localObject1 = com.tencent.mm.cd.a.bt(this.context, p.h.Csy);
        paramv = (com.tencent.mm.plugin.finder.live.view.adapter.holder.b)paramv;
        kotlin.g.b.s.s(localObject1, "title");
        localObject2 = b.a.DUl;
        if (((Collection)this.DTj).isEmpty()) {
          break label1282;
        }
      }
    }
    label1282:
    for (boolean bool1 = true;; bool1 = false)
    {
      paramv.a((String)localObject1, (b.a)localObject2, bool1, ewa(), false);
      AppMethodBeat.o(359415);
      return;
      label1217:
      localObject1 = am.aixg;
      localObject1 = Locale.getDefault();
      localObject2 = com.tencent.mm.cd.a.bt(this.context, p.h.Csz);
      kotlin.g.b.s.s(localObject2, "getString(context, R.str…ng_coupon_title_with_num)");
      localObject1 = String.format((Locale)localObject1, (String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(paramInt) }, 1));
      kotlin.g.b.s.s(localObject1, "java.lang.String.format(locale, format, *args)");
      break;
    }
  }
  
  public final boolean ewa()
  {
    AppMethodBeat.i(359344);
    Object localObject1 = (Iterable)this.DTh;
    Collection localCollection = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if ((localObject2 instanceof com.tencent.mm.plugin.finder.live.view.convert.k)) {
        localCollection.add(localObject2);
      }
    }
    if (!((Collection)localCollection).isEmpty())
    {
      AppMethodBeat.o(359344);
      return true;
    }
    AppMethodBeat.o(359344);
    return false;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(359381);
    if (evX())
    {
      i = this.DTg.size();
      AppMethodBeat.o(359381);
      return i + 1;
    }
    int i = this.DSF.size();
    AppMethodBeat.o(359381);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(359366);
    if (evX())
    {
      if (paramInt == 0)
      {
        AppMethodBeat.o(359366);
        return 1;
      }
      AppMethodBeat.o(359366);
      return 2;
    }
    Object localObject = this.DSF.get(paramInt);
    kotlin.g.b.s.s(localObject, "viewTypeArray[position]");
    paramInt = ((Number)localObject).intValue();
    AppMethodBeat.o(359366);
    return paramInt;
  }
  
  public final int hN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(359350);
    paramInt2 = this.DSF.indexOf(Integer.valueOf(paramInt2));
    AppMethodBeat.o(359350);
    return paramInt1 - paramInt2;
  }
  
  public final void n(RecyclerView.v paramv)
  {
    AppMethodBeat.i(359440);
    kotlin.g.b.s.u(paramv, "holder");
    super.n(paramv);
    if ((paramv instanceof com.tencent.mm.plugin.finder.live.view.adapter.holder.d)) {}
    for (RecyclerView.v localv = paramv;; localv = null)
    {
      if (localv != null)
      {
        paramv = ((com.tencent.mm.plugin.finder.live.view.adapter.holder.d)paramv).DUy.DOU;
        if (paramv != null) {
          paramv.a(null);
        }
      }
      AppMethodBeat.o(359440);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$Companion;", "", "()V", "ITEM_TYPE_COUPON", "", "ITEM_TYPE_GOODS_OR_ADS", "ITEM_TYPE_HEADER_COUPON", "ITEM_TYPE_HEADER_GOODS_OR_ADS", "MENU_ID_ITEM_DELETE", "MENU_ID_ITEM_MOVE_TO_FIRST", "SOURCE_BUY", "SOURCE_DETAIL", "TAG", "", "payloadDelete", "payloadMove", "payloadPromteFinish", "payloadPromting", "isAnchorOrAssistant", "", "isAssistant", "setProductDesc", "", "productDescTv", "Landroid/widget/TextView;", "shopName", "goodsDesc", "setProductSource", "stockTv", "divider", "Landroid/view/View;", "sourceTv", "stock", "isExclusiveStock", "platformId", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void a(TextView paramTextView1, View paramView, TextView paramTextView2, int paramInt1, boolean paramBoolean, String paramString, int paramInt2)
    {
      AppMethodBeat.i(359081);
      kotlin.g.b.s.u(paramTextView1, "stockTv");
      kotlin.g.b.s.u(paramView, "divider");
      kotlin.g.b.s.u(paramTextView2, "sourceTv");
      kotlin.g.b.s.u(paramString, "shopName");
      if (eqc())
      {
        com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if ((com.tencent.mm.plugin.finder.live.utils.a.Ps(paramInt2)) || (paramBoolean))
        {
          paramTextView1.setVisibility(0);
          paramView.setVisibility(0);
          paramTextView2.setVisibility(0);
          paramView = MMApplicationContext.getContext().getResources();
          if (paramBoolean) {}
          for (paramInt2 = p.h.CsD;; paramInt2 = p.h.CsP)
          {
            paramTextView1.setText((CharSequence)paramView.getString(paramInt2, new Object[] { Integer.valueOf(paramInt1) }));
            paramTextView2.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(MMApplicationContext.getContext(), (CharSequence)paramString));
            AppMethodBeat.o(359081);
            return;
          }
        }
      }
      paramTextView1.setVisibility(8);
      paramView.setVisibility(8);
      paramTextView2.setVisibility(0);
      paramTextView2.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(MMApplicationContext.getContext(), (CharSequence)paramString));
      AppMethodBeat.o(359081);
    }
    
    public static void a(TextView paramTextView, String paramString1, String paramString2)
    {
      AppMethodBeat.i(359070);
      kotlin.g.b.s.u(paramTextView, "productDescTv");
      kotlin.g.b.s.u(paramString1, "shopName");
      kotlin.g.b.s.u(paramString2, "goodsDesc");
      paramTextView.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(MMApplicationContext.getContext(), (CharSequence)paramString2));
      AppMethodBeat.o(359070);
    }
    
    static boolean eqc()
    {
      AppMethodBeat.i(359066);
      Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      boolean bool;
      if (!com.tencent.mm.plugin.finder.live.utils.a.bUx())
      {
        localObject = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
        localObject = com.tencent.mm.plugin.finder.live.model.context.a.emY();
        if (localObject != null) {
          break label40;
        }
        bool = false;
      }
      while (bool)
      {
        AppMethodBeat.o(359066);
        return true;
        label40:
        localObject = (e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(e.class);
        if (localObject == null) {
          bool = false;
        } else {
          bool = ((e)localObject).DUe;
        }
      }
      AppMethodBeat.o(359066);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "productInfo", "Lcom/tencent/mm/protocal/protobuf/FinderWindowProductInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<bzc, ah>
  {
    b(ae paramae)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "dataPos", "", "<anonymous parameter 1>", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowShelfProductItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.m<Integer, com.tencent.mm.plugin.finder.live.view.convert.k, ah>
  {
    d(ae paramae)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "errmsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModShopShelfResponse;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.q<Boolean, String, bkd, ah>
  {
    e(ae paramae, auw paramauw)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$promoteProduct$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePromoteProduct$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLivePromoteProductResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements an.a
  {
    f(long paramLong1, long paramLong2, ah.f<cc> paramf, int paramInt1, int paramInt2, ae paramae, com.tencent.mm.plugin.finder.live.view.adapter.holder.d paramd, int paramInt3) {}
    
    public final void a(final int paramInt1, int paramInt2, final String paramString, blc paramblc)
    {
      AppMethodBeat.i(359069);
      kotlin.g.b.s.u(paramblc, "resp");
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this.DPe, paramblc, localf, paramInt1, paramInt2, i, jdField_this, paramd, paramInt1, this.DTv, this.DTw, paramString));
      AppMethodBeat.o(359069);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(long paramLong1, blc paramblc, long paramLong2, int paramInt1, int paramInt2, ah.f<cc> paramf, int paramInt3, int paramInt4, ae paramae, com.tencent.mm.plugin.finder.live.view.adapter.holder.d paramd, int paramInt5, String paramString)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.m<Boolean, g, ah>
  {
    g(ae paramae, cc paramcc, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.m<Boolean, g, ah>
  {
    h(cc paramcc, ae paramae)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveReceiveCouponResponse;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.m<Boolean, blp, ah>
    {
      a(ae paramae, g paramg, cc paramcc)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.ae
 * JD-Core Version:    0.7.0.1
 */