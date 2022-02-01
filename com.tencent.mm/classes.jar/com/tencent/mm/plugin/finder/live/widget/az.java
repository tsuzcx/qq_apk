package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.model.af;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.model.ap.a;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.plugin.by;
import com.tencent.mm.plugin.finder.live.plugin.bz;
import com.tencent.mm.plugin.finder.live.plugin.bz.a;
import com.tencent.mm.plugin.finder.live.report.q.bx;
import com.tencent.mm.plugin.finder.live.view.FinderLiveShoppingPriceView;
import com.tencent.mm.plugin.finder.live.view.convert.i;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.q;
import com.tencent.mm.plugin.finder.model.aq;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bir;
import com.tencent.mm.protocal.protobuf.bla;
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bzc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingBubbleWidget;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "entranceRoot", "Landroid/view/ViewGroup;", "parent", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "plugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingBubblePlugin;", "(Landroid/content/Context;Landroid/view/ViewGroup;Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingBubblePlugin;)V", "ARROW_SIZE", "", "HORIZONTAL_TAKE_PLACE_HEIGHT", "MIN_ARROW_MARGIN_END", "TAG", "", "VERTICAL_TAKE_PLACE_HEIGHT", "WIDEGET_HEIGHT", "WIDEGET_PADDING", "actionBtn", "Landroid/widget/TextView;", "arrow", "Landroid/widget/ImageView;", "bubbleRoot", "Landroid/view/View;", "close", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "closeOnClickListener", "Landroid/view/View$OnClickListener;", "closeOut", "container", "<set-?>", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingCouponView;", "couponView", "getCouponView", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingCouponView;", "descContainer", "goodsContainer", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "setLiveData", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "getPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingBubblePlugin;", "preloadMiniProId", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "priceView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShoppingPriceView;", "productDesc", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "productImg", "productSeq", "productSrc", "promotingContainer", "promotingWidget", "Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "getReportObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "shoppingUIConfig", "Lcom/tencent/mm/plugin/finder/model/FinderLiveShoppingUIConfig;", "getShoppingUIConfig", "()Lcom/tencent/mm/plugin/finder/model/FinderLiveShoppingUIConfig;", "setShoppingUIConfig", "(Lcom/tencent/mm/plugin/finder/model/FinderLiveShoppingUIConfig;)V", "widgetRoot", "adjustBubbleLayout", "", "bubbleAttachToParent", "id", "handleCanUseCouponGoods", "buContext", "Lcom/tencent/mm/ui/MMActivity;", "item", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowCouponItem;", "view", "handleReceiveCoupon", "hideShoppingBubble", "isAnchorOrAssistant", "", "setProductDesc", "productDescTv", "shopName", "goodsDesc", "setVisibility", "visibility", "setupCouponView", "isCoupon", "showCouponBubble", "data", "showShoppingBubble", "Lcom/tencent/mm/protocal/protobuf/FinderWindowProductInfo;", "isUpdate", "forceShowBubble", "updateBubbleLayout", "updateShoppingBubble", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class az
  extends FrameLayout
{
  private ViewGroup CAj;
  private final ViewGroup CZa;
  public com.tencent.mm.plugin.finder.live.model.context.a CvU;
  private View CzL;
  private ImageView DST;
  private TextView DSU;
  private FinderLiveShoppingPriceView DTa;
  private View DUA;
  public FinderLiveShoppingCouponView DUd;
  private TextView DUu;
  private final int Eqr;
  private View Eqt;
  private final View Esf;
  private final by EtN;
  private final int EtO;
  private final int EtP;
  private final int EtQ;
  private final int EtR;
  private final int EtS;
  private ViewGroup EtT;
  private FinderLiveOnliveWidget EtU;
  private NeatTextView EtV;
  private WeImageView EtW;
  private WeImageView EtX;
  private TextView EtY;
  private ArrayList<Long> EtZ;
  private aq Eua;
  private final View.OnClickListener Eub;
  public final String TAG;
  public final com.tencent.mm.live.b.b nfT;
  public ImageView nnX;
  public final ViewGroup parent;
  private final bui reportObj;
  
  public az(final Context paramContext, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, com.tencent.mm.live.b.b paramb, bui parambui, by paramby)
  {
    super(paramContext);
    AppMethodBeat.i(361467);
    this.CZa = paramViewGroup1;
    this.parent = paramViewGroup2;
    this.nfT = paramb;
    this.reportObj = parambui;
    this.EtN = paramby;
    this.TAG = "Finder.LiveShoppingBubbleWidget";
    this.EtO = paramContext.getResources().getDimensionPixelOffset(p.c.Bzm);
    this.Eqr = paramContext.getResources().getDimensionPixelOffset(p.c.Edge_2A);
    this.EtP = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_0_5_A);
    this.EtQ = com.tencent.mm.view.d.e(paramContext, 2.0F);
    this.EtR = (this.EtO + com.tencent.mm.view.d.e(paramContext, 20.0F));
    this.EtS = com.tencent.mm.view.d.e(paramContext, 12.0F);
    this.EtZ = new ArrayList();
    this.Eua = new aq();
    this.Eub = new az..ExternalSyntheticLambda0(this);
    paramViewGroup1 = LayoutInflater.from(paramContext).inflate(p.f.CfL, (ViewGroup)this, true);
    s.s(paramViewGroup1, "from(context).inflate(R.…ng_widget_ui, this, true)");
    this.Eqt = paramViewGroup1;
    paramViewGroup1 = this.Eqt.findViewById(p.e.BSI);
    s.s(paramViewGroup1, "bubbleRoot.findViewById(…_shopping_widget_ui_root)");
    this.Esf = paramViewGroup1;
    this.EtT = ((ViewGroup)this.Eqt.findViewById(p.e.item_detail_container));
    paramViewGroup1 = this.Eqt.findViewById(p.e.BZP);
    s.s(paramViewGroup1, "bubbleRoot.findViewById(R.id.product_img)");
    this.DST = ((ImageView)paramViewGroup1);
    paramViewGroup1 = this.Eqt.findViewById(p.e.Cab);
    s.s(paramViewGroup1, "bubbleRoot.findViewById(R.id.promoting_container)");
    this.DUA = paramViewGroup1;
    paramViewGroup1 = this.Eqt.findViewById(p.e.Caa);
    s.s(paramViewGroup1, "bubbleRoot.findViewById(R.id.promoting)");
    this.EtU = ((FinderLiveOnliveWidget)paramViewGroup1);
    paramViewGroup1 = this.Eqt.findViewById(p.e.BCI);
    s.s(paramViewGroup1, "bubbleRoot.findViewById(R.id.desc_container)");
    this.CzL = paramViewGroup1;
    paramViewGroup1 = this.Eqt.findViewById(p.e.BZN);
    s.s(paramViewGroup1, "bubbleRoot.findViewById(R.id.product_desc)");
    this.EtV = ((NeatTextView)paramViewGroup1);
    paramViewGroup1 = this.Eqt.findViewById(p.e.BZW);
    s.s(paramViewGroup1, "bubbleRoot.findViewById(R.id.product_source)");
    this.DUu = ((TextView)paramViewGroup1);
    paramViewGroup1 = this.Eqt.findViewById(p.e.BZV);
    s.s(paramViewGroup1, "bubbleRoot.findViewById(R.id.product_seq)");
    this.DSU = ((TextView)paramViewGroup1);
    paramViewGroup1 = this.Eqt.findViewById(p.e.BZK);
    s.s(paramViewGroup1, "bubbleRoot.findViewById(R.id.price_view)");
    this.DTa = ((FinderLiveShoppingPriceView)paramViewGroup1);
    this.DUd = ((FinderLiveShoppingCouponView)this.Eqt.findViewById(p.e.BCz));
    paramViewGroup1 = this.Eqt.findViewById(p.e.close);
    s.s(paramViewGroup1, "bubbleRoot.findViewById(R.id.close)");
    this.EtW = ((WeImageView)paramViewGroup1);
    paramViewGroup1 = this.Eqt.findViewById(p.e.BCk);
    s.s(paramViewGroup1, "bubbleRoot.findViewById(R.id.close_out)");
    this.EtX = ((WeImageView)paramViewGroup1);
    paramViewGroup1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.gf((View)this.EtW);
    this.EtW.setOnClickListener(this.Eub);
    this.EtX.setOnClickListener(this.Eub);
    paramViewGroup1 = this.Eqt.findViewById(p.e.BZM);
    s.s(paramViewGroup1, "bubbleRoot.findViewById(R.id.product_action)");
    this.EtY = ((TextView)paramViewGroup1);
    paramViewGroup1 = this.DUd;
    if (paramViewGroup1 != null) {
      paramViewGroup1.setCallback((FinderLiveShoppingCouponView.a)new FinderLiveShoppingCouponView.a()
      {
        public final void a(com.tencent.mm.plugin.finder.live.view.convert.j paramAnonymousj, FinderLiveShoppingCouponView paramAnonymousFinderLiveShoppingCouponView)
        {
          AppMethodBeat.i(361902);
          s.u(paramAnonymousj, "item");
          s.u(paramAnonymousFinderLiveShoppingCouponView, "view");
          this.Euc.a(paramContext, paramAnonymousj);
          AppMethodBeat.o(361902);
        }
      });
    }
    AppMethodBeat.o(361467);
  }
  
  private static final int a(az paramaz, int paramInt)
  {
    AppMethodBeat.i(361541);
    Object localObject = paramaz.EtT;
    if (localObject == null) {}
    for (int i = 0; paramaz.parent.getMeasuredWidth() - i > 0; i = ((ViewGroup)localObject).getWidth())
    {
      paramInt = kotlin.k.k.qv(paramaz.parent.getMeasuredWidth() - i, paramInt);
      AppMethodBeat.o(361541);
      return paramInt;
    }
    int j = bf.bf(paramaz.getContext()).x;
    localObject = paramaz.parent.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      if (localObject != null) {
        break label203;
      }
      localObject = null;
      label105:
      if (localObject != null) {
        break label216;
      }
      paramaz.getContext().getResources().getDimensionPixelOffset(p.c.Edge_2A);
      label124:
      localObject = paramaz.parent.getLayoutParams();
      if (!(localObject instanceof ViewGroup.MarginLayoutParams)) {
        break label225;
      }
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      label148:
      if (localObject != null) {
        break label231;
      }
      localObject = null;
      label156:
      if (localObject != null) {
        break label244;
      }
      paramaz.getContext().getResources().getDimensionPixelOffset(p.c.Edge_6A);
    }
    for (;;)
    {
      if (j - i <= 0) {
        break label253;
      }
      paramInt = kotlin.k.k.qv(j - i, paramInt);
      AppMethodBeat.o(361541);
      return paramInt;
      localObject = null;
      break;
      label203:
      localObject = Integer.valueOf(((ViewGroup.MarginLayoutParams)localObject).getMarginStart());
      break label105;
      label216:
      ((Integer)localObject).intValue();
      break label124;
      label225:
      localObject = null;
      break label148;
      label231:
      localObject = Integer.valueOf(((ViewGroup.MarginLayoutParams)localObject).getMarginEnd());
      break label156;
      label244:
      ((Integer)localObject).intValue();
    }
    label253:
    AppMethodBeat.o(361541);
    return paramInt;
  }
  
  private static final void a(long paramLong, az paramaz)
  {
    AppMethodBeat.i(361535);
    s.u(paramaz, "this$0");
    Object localObject = paramaz.CAj;
    if (localObject != null)
    {
      localObject = ((ViewGroup)localObject).getTag();
      if ((localObject instanceof Long)) {
        break label82;
      }
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        break label100;
      }
      Log.i(paramaz.TAG, "bubbleAttachToParent id:" + paramLong + " view have attach!");
      AppMethodBeat.o(361535);
      return;
      label82:
      if (paramLong != ((Number)localObject).longValue()) {
        break;
      }
    }
    label100:
    paramaz.CAj = ((ViewGroup)paramaz.parent.findViewById(p.e.CaP));
    paramaz.nnX = ((ImageView)paramaz.parent.findViewById(p.e.CaO));
    paramaz.erX();
    localObject = paramaz.CAj;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label278;
      }
      label157:
      Log.i(paramaz.TAG, "bubbleAttachToParent, have contain child!");
    }
    for (;;)
    {
      localObject = paramaz.CAj;
      if (localObject != null) {
        ((ViewGroup)localObject).setVisibility(0);
      }
      localObject = paramaz.CAj;
      if (localObject != null) {
        ((ViewGroup)localObject).setTag(Long.valueOf(paramLong));
      }
      localObject = (com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
      bui localbui = paramaz.getReportObj();
      com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      ((com.tencent.mm.plugin.h)localObject).a(localbui, com.tencent.mm.plugin.finder.live.utils.a.a(((com.tencent.mm.plugin.finder.live.view.a)paramaz.nfT).getBuContext(), 31, String.valueOf(paramLong)));
      AppMethodBeat.o(361535);
      return;
      localObject = Integer.valueOf(((ViewGroup)localObject).indexOfChild((View)paramaz));
      break;
      label278:
      if (((Integer)localObject).intValue() != -1) {
        break label157;
      }
      localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.gg((View)paramaz);
      localObject = paramaz.CAj;
      if (localObject != null) {
        ((ViewGroup)localObject).addView((View)paramaz);
      }
    }
  }
  
  private static final void a(az paramaz, View paramView)
  {
    AppMethodBeat.i(361521);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramaz);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingBubbleWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramaz, "this$0");
    if (paramaz.nfT.getLiveRole() == 0)
    {
      paramView = paramaz.getLiveData();
      if (paramView != null) {
        break label239;
      }
      paramView = null;
      if (paramView != null)
      {
        paramView = paramaz.getLiveData();
        if (paramView != null) {
          break label267;
        }
        localObject1 = null;
        label97:
        if (!(localObject1 instanceof com.tencent.mm.plugin.finder.live.view.convert.k)) {
          break label342;
        }
        paramView = com.tencent.mm.plugin.finder.live.component.statecomponent.b.CCd;
        paramView = paramaz.getLiveData();
        s.checkNotNull(paramView);
        com.tencent.mm.plugin.finder.live.component.statecomponent.b.a(paramView, 2, 5);
        localObject2 = com.tencent.mm.plugin.finder.live.report.k.Doi;
        Object localObject3 = q.bx.DDM;
        paramView = paramaz.getLiveData();
        if (paramView != null) {
          break label295;
        }
        paramView = null;
        label143:
        com.tencent.mm.plugin.finder.live.report.k.a((com.tencent.mm.plugin.finder.live.report.k)localObject2, (q.bx)localObject3, null, String.valueOf(paramView));
        paramView = (com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
        localObject2 = paramaz.getReportObj();
        localObject3 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        paramView.a((bui)localObject2, com.tencent.mm.plugin.finder.live.utils.a.a(((com.tencent.mm.plugin.finder.live.view.a)paramaz.nfT).getBuContext(), 29, com.tencent.mm.ae.d.hF(((com.tencent.mm.plugin.finder.live.view.convert.k)localObject1).DVk)));
      }
    }
    for (;;)
    {
      paramaz.eBz();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingBubbleWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361521);
      return;
      label239:
      paramView = (q)paramView.business(q.class);
      if (paramView == null)
      {
        paramView = null;
        break;
      }
      paramView = paramView.Eie;
      break;
      label267:
      paramView = (q)paramView.business(q.class);
      if (paramView == null)
      {
        localObject1 = null;
        break label97;
      }
      localObject1 = paramView.Eie;
      break label97;
      label295:
      paramView = (q)paramView.business(q.class);
      if (paramView == null)
      {
        paramView = null;
        break label143;
      }
      paramView = paramView.Eie;
      if (paramView == null)
      {
        paramView = null;
        break label143;
      }
      paramView = Long.valueOf(paramView.bZA());
      break label143;
      label342:
      if ((localObject1 instanceof com.tencent.mm.plugin.finder.live.view.convert.j))
      {
        paramView = com.tencent.mm.plugin.finder.live.component.statecomponent.b.CCd;
        paramView = paramaz.getLiveData();
        s.checkNotNull(paramView);
        com.tencent.mm.plugin.finder.live.component.statecomponent.b.a(paramView, 2, 6);
      }
    }
  }
  
  private static final void a(az paramaz, final bzc parambzc, com.tencent.mm.loader.g.a.a parama, com.tencent.mm.loader.d.b.g paramg, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(361547);
    s.u(paramaz, "this$0");
    s.u(parambzc, "$data");
    if (paramBitmap != null) {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(paramaz, paramBitmap, parambzc));
    }
    AppMethodBeat.o(361547);
  }
  
  private final void eBz()
  {
    AppMethodBeat.i(361505);
    Object localObject1 = this.CAj;
    if (localObject1 != null) {
      ((ViewGroup)localObject1).setTag(null);
    }
    localObject1 = aj.CGT;
    Object localObject2 = aj.elk();
    Bundle localBundle;
    if (localObject2 != null)
    {
      b.c localc = b.c.ndQ;
      localBundle = new Bundle();
      localObject1 = getLiveData();
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          break label181;
        }
        localObject1 = null;
        if (localObject1 == null) {
          Log.i(this.TAG, "[hideShoppingBubble] but not promotting product");
        }
        localObject1 = ah.aiuX;
        ((com.tencent.mm.plugin.finder.live.view.a)localObject2).statusChange(localc, localBundle);
      }
    }
    else
    {
      localObject1 = this.EtN;
      ((by)localObject1).getBuContext().business(q.class);
      Log.i(((by)localObject1).TAG, s.X("stop syncCouponOrGoods ", ((by)localObject1).Djb));
      if (!(((by)localObject1).Djb instanceof com.tencent.mm.plugin.finder.live.view.convert.k)) {
        break label282;
      }
      localObject2 = aj.CGT;
      aj.elm().OQ(2);
    }
    for (;;)
    {
      ((by)localObject1).Djb = null;
      AppMethodBeat.o(361505);
      return;
      localObject1 = (q)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(q.class);
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((q)localObject1).Eie;
      break;
      label181:
      bla localbla = new bla();
      localbla.id = ((com.tencent.mm.plugin.j)localObject1).bUz();
      if ((localObject1 instanceof com.tencent.mm.plugin.finder.live.view.convert.k)) {
        localbla.type = 5;
      }
      for (;;)
      {
        localbla.ZTU = new com.tencent.mm.bx.b(((com.tencent.mm.plugin.j)localObject1).bUy().toByteArray());
        localObject1 = ah.aiuX;
        localBundle.putByteArray("PARAM_FINDER_LIVE_PROMOTE_DATA", localbla.toByteArray());
        localObject1 = ah.aiuX;
        break;
        if ((localObject1 instanceof com.tencent.mm.plugin.finder.live.view.convert.j)) {
          localbla.type = 6;
        }
      }
      label282:
      if ((((by)localObject1).Djb instanceof com.tencent.mm.plugin.finder.live.view.convert.j))
      {
        localObject2 = aj.CGT;
        aj.elm().OQ(1);
      }
    }
  }
  
  public final void a(Context paramContext, final com.tencent.mm.plugin.finder.live.view.convert.j paramj)
  {
    AppMethodBeat.i(361672);
    s.u(paramContext, "context");
    s.u(paramj, "item");
    Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.J(paramContext, true);
    Object localObject2;
    Object localObject3;
    MMActivity localMMActivity;
    long l1;
    long l2;
    String str1;
    byte[] arrayOfByte;
    String str2;
    if (eqc())
    {
      localObject1 = com.tencent.mm.plugin.finder.live.component.statecomponent.b.CCd;
      localObject1 = this.CvU;
      s.checkNotNull(localObject1);
      com.tencent.mm.plugin.finder.live.component.statecomponent.b.a((com.tencent.mm.plugin.finder.live.model.context.a)localObject1, 5, 6);
      localObject1 = bz.Djh;
      bz.a.rE(false);
      localObject2 = by.getFinderLiveAssistant();
      if (localObject2 != null)
      {
        localObject3 = (MMActivity)paramContext;
        localObject1 = paramj.mdN;
        if (localObject1 == null) {
          localObject1 = "";
        }
        for (;;)
        {
          ((ap)localObject2).a((MMActivity)localObject3, (String)localObject1, 2, (m)new b(paramContext, this, paramj));
          AppMethodBeat.o(361672);
          return;
        }
      }
    }
    else
    {
      localObject1 = com.tencent.mm.plugin.finder.live.component.statecomponent.b.CCd;
      localObject1 = this.CvU;
      s.checkNotNull(localObject1);
      com.tencent.mm.plugin.finder.live.component.statecomponent.b.a((com.tencent.mm.plugin.finder.live.model.context.a)localObject1, 5, 6);
      localObject2 = this.CvU;
      if (localObject2 != null)
      {
        getPlugin();
        localObject3 = by.getFinderLiveAssistant();
        if (localObject3 != null)
        {
          localMMActivity = (MMActivity)paramContext;
          l1 = ((f)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(f.class)).liveInfo.liveId;
          l2 = ((f)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(f.class)).hKN;
          str1 = ((e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(e.class)).mIC;
          arrayOfByte = ((f)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(f.class)).mZp;
          str2 = paramj.mdN;
          localObject1 = (e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(e.class);
          if (localObject1 != null) {
            break label327;
          }
        }
      }
    }
    label327:
    for (localObject1 = null;; localObject1 = ((e)localObject1).EeF)
    {
      ap.a.a((ap)localObject3, localMMActivity, l1, l2, str1, arrayOfByte, str2, (String)localObject1, (kotlin.g.a.b)new c(paramContext, this, (com.tencent.mm.plugin.finder.live.model.context.a)localObject2, paramj), 64);
      AppMethodBeat.o(361672);
      return;
    }
  }
  
  public final boolean eqc()
  {
    AppMethodBeat.i(361735);
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    boolean bool;
    if (!com.tencent.mm.plugin.finder.live.utils.a.bUx())
    {
      localObject = this.CvU;
      if (localObject != null) {
        break label39;
      }
      bool = false;
    }
    while (bool)
    {
      AppMethodBeat.o(361735);
      return true;
      label39:
      localObject = (e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(e.class);
      if (localObject == null) {
        bool = false;
      } else {
        bool = ((e)localObject).DUe;
      }
    }
    AppMethodBeat.o(361735);
    return false;
  }
  
  public final void erX()
  {
    AppMethodBeat.i(361708);
    Object localObject1 = aw.Gjk;
    ImageView localImageView = this.nnX;
    ViewGroup localViewGroup = this.CAj;
    Object localObject2;
    label144:
    float f2;
    int j;
    label208:
    float f1;
    label415:
    label456:
    label464:
    label489:
    label622:
    float f3;
    if ((localImageView != null) && (localViewGroup != null))
    {
      localObject1 = getLiveData();
      boolean bool;
      int k;
      if (localObject1 == null)
      {
        localObject1 = null;
        bool = localObject1 instanceof i;
        localObject2 = this.CZa.findViewById(p.e.BSl);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = (View)this.CZa;
        }
        localObject2 = new int[2];
        ((View)localObject1).getLocationInWindow((int[])localObject2);
        Object localObject3 = new int[2];
        localViewGroup.getLocationInWindow((int[])localObject3);
        int n = localObject3[0] + localViewGroup.getWidth();
        if (localViewGroup.getWidth() <= this.EtP) {
          break label573;
        }
        i = localViewGroup.getWidth() - this.EtP;
        k = com.tencent.mm.cd.a.bs(getContext(), p.c.Edge_2A);
        int m = n - localObject2[0] - k / 2 - ((View)localObject1).getWidth() / 2;
        f2 = kotlin.k.k.qv(kotlin.k.k.qu(m, this.EtP), i);
        if (-f2 != localImageView.getTranslationX()) {
          break label611;
        }
        j = 1;
        if (j == 0)
        {
          localObject3 = this.TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("updateBubbleLayout arrow:").append(this.nnX).append(",container:").append(this.CAj).append(", containerRight:").append(n).append(", container.width:").append(localViewGroup.getWidth()).append(", shoppingEntranceLoc:").append(localObject2[0]).append(", ").append(localObject2[1]).append(", arrow.width:").append(localImageView.getWidth()).append(", entranceRoot.width:").append(((View)localObject1).getWidth()).append(", MIN_ARROW_MARGIN_END:").append(this.EtP).append(", maxArrowMarginEnd:").append(i).append(", arrowMarginEnd:").append(f2).append(", expectedMarginEnd:");
          localStringBuilder.append(m);
          Log.i((String)localObject3, localStringBuilder.toString());
        }
        if (getContext().getResources().getConfiguration().orientation != 2) {
          break label617;
        }
        f1 = 85.0F;
        localImageView.setTranslationX(-(f1 + f2));
        if (!bool) {
          break label656;
        }
        if (this.nfT.getLiveRole() != 1)
        {
          localObject1 = getLiveData();
          if (localObject1 != null) {
            break label622;
          }
          bool = false;
          if (!bool) {
            break label656;
          }
        }
        i = 1;
        n = bf.bf(MMApplicationContext.getContext()).x;
        localObject1 = this.EtT;
        if (localObject1 != null) {
          break label662;
        }
        j = 0;
        if (m > n - j) {
          break label692;
        }
        localObject1 = this.CAj;
        if ((localObject1 == null) || (((ViewGroup)localObject1).getVisibility() != 0)) {
          break label672;
        }
      }
      label656:
      label662:
      label672:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label678;
        }
        localImageView.setVisibility(4);
        AppMethodBeat.o(361708);
        return;
        localObject1 = (q)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(q.class);
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject1 = ((q)localObject1).Eie;
        break;
        label573:
        i = (int)(bf.bf(MMApplicationContext.getContext()).x - MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.finder_live_last_option_margin) - this.EtP * 2);
        break label144;
        label611:
        j = 0;
        break label208;
        label617:
        f1 = 0.0F;
        break label415;
        localObject1 = (e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(e.class);
        if (localObject1 == null)
        {
          bool = false;
          break label456;
        }
        bool = ((e)localObject1).DUe;
        break label456;
        i = 0;
        break label464;
        j = ((ViewGroup)localObject1).getRight();
        break label489;
      }
      label678:
      localImageView.setVisibility(8);
      AppMethodBeat.o(361708);
      return;
      label692:
      localObject1 = this.CAj;
      if ((localObject1 == null) || (((ViewGroup)localObject1).getVisibility() != 0)) {
        break label889;
      }
      j = 1;
      if (j != 0)
      {
        if (i == 0) {
          break label921;
        }
        f1 = localViewGroup.getWidth() - k;
        f2 = localImageView.getTranslationX();
        f3 = k / 2;
        localObject1 = this.EtT;
        if (localObject1 != null) {
          break label895;
        }
        i = 0;
      }
    }
    label760:
    for (int i = (int)(f3 + (f1 + f2) - i / 2);; i = 0)
    {
      i = a(this, i);
      if (i >= 0)
      {
        localObject1 = this.EtT;
        if (localObject1 != null) {
          break label905;
        }
        localObject1 = null;
        if (!(localObject1 instanceof LinearLayout.LayoutParams)) {
          break label915;
        }
      }
      for (localObject1 = (LinearLayout.LayoutParams)localObject1;; localObject1 = null)
      {
        if (localObject1 != null)
        {
          ((LinearLayout.LayoutParams)localObject1).setMargins(i, ((LinearLayout.LayoutParams)localObject1).topMargin, com.tencent.mm.cd.a.br(getContext(), p.c.finder_live_last_option_margin), ((LinearLayout.LayoutParams)localObject1).bottomMargin);
          localObject2 = this.EtT;
          if (localObject2 != null) {
            ((ViewGroup)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
          this.parent.requestLayout();
        }
        localImageView.setVisibility(0);
        AppMethodBeat.o(361708);
        return;
        label889:
        j = 0;
        break;
        label895:
        i = ((ViewGroup)localObject1).getWidth();
        break label760;
        localObject1 = ((ViewGroup)localObject1).getLayoutParams();
        break label801;
      }
    }
  }
  
  public final FinderLiveShoppingCouponView getCouponView()
  {
    return this.DUd;
  }
  
  public final com.tencent.mm.plugin.finder.live.model.context.a getLiveData()
  {
    return this.CvU;
  }
  
  public final by getPlugin()
  {
    return this.EtN;
  }
  
  public final bui getReportObj()
  {
    return this.reportObj;
  }
  
  public final aq getShoppingUIConfig()
  {
    return this.Eua;
  }
  
  public final void pd(long paramLong)
  {
    AppMethodBeat.i(361687);
    this.parent.post(new az..ExternalSyntheticLambda2(paramLong, this));
    AppMethodBeat.o(361687);
  }
  
  public final void setLiveData(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    this.CvU = parama;
  }
  
  public final void setShoppingUIConfig(aq paramaq)
  {
    AppMethodBeat.i(361649);
    s.u(paramaq, "<set-?>");
    this.Eua = paramaq;
    AppMethodBeat.o(361649);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(361724);
    super.setVisibility(paramInt);
    Object localObject = this.CAj;
    if (localObject != null) {
      ((ViewGroup)localObject).setVisibility(paramInt);
    }
    localObject = this.nnX;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(paramInt);
    }
    AppMethodBeat.o(361724);
  }
  
  public final void setupCouponView(boolean paramBoolean)
  {
    AppMethodBeat.i(361682);
    Object localObject = this.EtT;
    int i;
    if (localObject != null)
    {
      if (paramBoolean)
      {
        i = 8;
        ((ViewGroup)localObject).setVisibility(i);
      }
    }
    else
    {
      localObject = this.DUd;
      if (localObject != null)
      {
        if (!paramBoolean) {
          break label118;
        }
        i = 0;
        label42:
        ((FinderLiveShoppingCouponView)localObject).setVisibility(i);
      }
      if ((paramBoolean) && (!eqc())) {
        break label124;
      }
      this.EtX.setVisibility(8);
    }
    for (;;)
    {
      if (!paramBoolean)
      {
        if ((!eqc()) && (getContext().getResources().getConfiguration().orientation == 2))
        {
          com.tencent.mm.cd.a.bs(getContext(), p.c.Edge_12A);
          AppMethodBeat.o(361682);
          return;
          i = 0;
          break;
          label118:
          i = 8;
          break label42;
          label124:
          this.EtX.setVisibility(0);
          continue;
        }
        com.tencent.mm.cd.a.bs(getContext(), p.c.finder_live_last_option_margin);
        AppMethodBeat.o(361682);
        return;
      }
    }
    com.tencent.mm.cd.a.bs(getContext(), p.c.Edge_2A);
    AppMethodBeat.o(361682);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveReceiveCouponResponse;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements m<Boolean, blp, ah>
  {
    a(MMActivity paramMMActivity, com.tencent.mm.plugin.finder.live.view.convert.j paramj, FinderLiveShoppingCouponView paramFinderLiveShoppingCouponView, az paramaz, LinkedList<com.tencent.mm.plugin.finder.live.view.convert.k> paramLinkedList)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveIssueCouponResponse;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<Boolean, bir, ah>
  {
    b(Context paramContext, az paramaz, com.tencent.mm.plugin.finder.live.view.convert.j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    c(Context paramContext, az paramaz, com.tencent.mm.plugin.finder.live.model.context.a parama, com.tencent.mm.plugin.finder.live.view.convert.j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(az paramaz, Bitmap paramBitmap, bzc parambzc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.az
 * JD-Core Version:    0.7.0.1
 */