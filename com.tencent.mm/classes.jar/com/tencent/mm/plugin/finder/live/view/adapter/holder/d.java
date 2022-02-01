package com.tencent.mm.plugin.finder.live.view.adapter.holder;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MapExpandKt;
import com.tencent.mm.ae.f;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.view.FinderLiveProductRecordView;
import com.tencent.mm.plugin.finder.live.view.FinderLiveShoppingPriceView;
import com.tencent.mm.plugin.finder.live.view.FinderLiveShoppingPriceView.b;
import com.tencent.mm.plugin.finder.live.view.adapter.ae;
import com.tencent.mm.plugin.finder.live.view.adapter.ae.a;
import com.tencent.mm.plugin.finder.live.view.convert.k;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.protocal.protobuf.agn;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.protocal.protobuf.bzc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/holder/FinderLiveShoppingViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "couponLabelContainer", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getCouponLabelContainer", "()Landroid/widget/LinearLayout;", "setCouponLabelContainer", "(Landroid/widget/LinearLayout;)V", "priceView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShoppingPriceView;", "getPriceView", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShoppingPriceView;", "setPriceView", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShoppingPriceView;)V", "productDesc", "Landroid/widget/TextView;", "getProductDesc", "()Landroid/widget/TextView;", "setProductDesc", "(Landroid/widget/TextView;)V", "productIconView", "Landroid/widget/ImageView;", "getProductIconView", "()Landroid/widget/ImageView;", "setProductIconView", "(Landroid/widget/ImageView;)V", "productImg", "getProductImg", "setProductImg", "productRecordPlayView", "getProductRecordPlayView", "()Landroid/view/View;", "setProductRecordPlayView", "productReplayView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveProductRecordView;", "getProductReplayView", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveProductRecordView;", "setProductReplayView", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveProductRecordView;)V", "productSeq", "getProductSeq", "setProductSeq", "productSrc", "getProductSrc", "setProductSrc", "productStock", "getProductStock", "setProductStock", "promoting", "Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "getPromoting", "()Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "setPromoting", "(Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;)V", "promotingContainer", "getPromotingContainer", "setPromotingContainer", "realDesc", "getRealDesc", "setRealDesc", "recomendView", "getRecomendView", "setRecomendView", "sourceDivider", "getSourceDivider", "setSourceDivider", "userAction", "getUserAction", "setUserAction", "addCouponLabel", "", "wording", "", "setupProductItem", "item", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowShelfProductItem;", "priceViewConfig", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShoppingPriceView$Config;", "updateCoupon", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends RecyclerView.v
{
  public static final a DUq;
  public ImageView DST;
  public TextView DSU;
  public TextView DSV;
  private TextView DSX;
  private View DSZ;
  public FinderLiveShoppingPriceView DTa;
  public View DUA;
  public FinderLiveOnliveWidget DUr;
  public TextView DUs;
  public TextView DUt;
  public TextView DUu;
  private LinearLayout DUv;
  private TextView DUw;
  private ImageView DUx;
  public FinderLiveProductRecordView DUy;
  public View DUz;
  
  static
  {
    AppMethodBeat.i(359184);
    DUq = new a((byte)0);
    AppMethodBeat.o(359184);
  }
  
  public d(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(359156);
    this.DST = ((ImageView)paramView.findViewById(p.e.BZP));
    this.DSU = ((TextView)paramView.findViewById(p.e.BZV));
    this.DUr = ((FinderLiveOnliveWidget)paramView.findViewById(p.e.Caa));
    this.DSV = ((TextView)paramView.findViewById(p.e.BZN));
    this.DTa = ((FinderLiveShoppingPriceView)paramView.findViewById(p.e.BZK));
    this.DUs = ((TextView)paramView.findViewById(p.e.BZM));
    this.DUt = ((TextView)paramView.findViewById(p.e.BZS));
    this.DSX = ((TextView)paramView.findViewById(p.e.BZY));
    this.DUu = ((TextView)paramView.findViewById(p.e.BZW));
    this.DSZ = paramView.findViewById(p.e.BZX);
    this.DUv = ((LinearLayout)paramView.findViewById(p.e.BCy));
    this.DUw = ((TextView)paramView.findViewById(p.e.Cah));
    this.DUx = ((ImageView)paramView.findViewById(p.e.BZO));
    this.DUy = ((FinderLiveProductRecordView)paramView.findViewById(p.e.BZU));
    this.DUz = paramView.findViewById(p.e.BZT);
    this.DUA = paramView.findViewById(p.e.Cab);
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    localObject = this.DUs;
    kotlin.g.b.s.s(localObject, "userAction");
    com.tencent.mm.plugin.finder.live.utils.a.gf((View)localObject);
    MapExpandKt.visitChild(paramView, (kotlin.g.a.b)1.DUB);
    AppMethodBeat.o(359156);
  }
  
  private final void ayb(String paramString)
  {
    AppMethodBeat.i(359179);
    Log.i("MicroMsg.FinderLiveShoppingViewHolder", kotlin.g.b.s.X("addCouponLabel ", paramString));
    TextView localTextView = new TextView(this.caK.getContext());
    localTextView.setTextColor(com.tencent.mm.cd.a.w(this.caK.getContext(), p.b.biz_finder_live_logo_color));
    localTextView.setBackgroundResource(p.d.BAM);
    localTextView.setText((CharSequence)paramString);
    localTextView.setTextSize(1, 12.0F);
    localTextView.setGravity(17);
    localTextView.setPadding(com.tencent.mm.cd.a.bs(this.caK.getContext(), p.c.finder_0_75_A), com.tencent.mm.cd.a.bs(this.caK.getContext(), p.c.finder_0_25_A), com.tencent.mm.cd.a.bs(this.caK.getContext(), p.c.finder_0_75_A), com.tencent.mm.cd.a.bs(this.caK.getContext(), p.c.finder_0_25_A));
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.setMargins(0, 0, com.tencent.mm.cd.a.bs(this.caK.getContext(), p.c.Edge_A), 0);
    this.DUv.addView((View)localTextView, (ViewGroup.LayoutParams)paramString);
    AppMethodBeat.o(359179);
  }
  
  private final void b(k paramk)
  {
    AppMethodBeat.i(359166);
    this.DUv.removeAllViews();
    Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    localObject1 = new StringBuilder("updateCoupon associated_coupons:");
    Object localObject2 = paramk.DVj.aaig;
    kotlin.g.b.s.s(localObject2, "item.data.associated_coupons");
    com.tencent.mm.plugin.finder.live.utils.a.hQ("MicroMsg.FinderLiveShoppingViewHolder", f.dg(localObject2) + ",product_recommend_wording:" + paramk.DVj.ZVe);
    localObject1 = paramk.DVj.aaig;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = (Collection)localObject1;
      if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
        break label203;
      }
    }
    label203:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label208;
      }
      AppMethodBeat.o(359166);
      return;
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = ((agn)((Iterator)localObject2).next()).ZbX;
        if (str != null) {
          ((Collection)localObject1).add(str);
        }
      }
      localObject1 = (List)localObject1;
      break;
    }
    label208:
    paramk = (CharSequence)paramk.DVj.ZVe;
    if ((paramk == null) || (paramk.length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label276;
      }
    }
    label276:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label281;
      }
      paramk = kotlin.a.p.oK((List)localObject1);
      kotlin.g.b.s.s(paramk, "coupinInfo.first()");
      ayb((String)paramk);
      AppMethodBeat.o(359166);
      return;
      i = 0;
      break;
    }
    label281:
    paramk = ((Iterable)localObject1).iterator();
    while (paramk.hasNext())
    {
      localObject1 = (String)paramk.next();
      kotlin.g.b.s.s(localObject1, "it");
      ayb((String)localObject1);
    }
    AppMethodBeat.o(359166);
  }
  
  public final void a(k paramk, FinderLiveShoppingPriceView.b paramb)
  {
    int j = 1;
    AppMethodBeat.i(359206);
    kotlin.g.b.s.u(paramk, "item");
    kotlin.g.b.s.u(paramb, "priceViewConfig");
    Log.i("MicroMsg.FinderLiveShoppingViewHolder", "bindProductItem " + paramk.DVk + ", " + paramk.DUT + ", " + paramk.title + ", " + paramk.DVr);
    this.DUt.setVisibility(8);
    this.DTa.setVisibility(0);
    this.DSU.setVisibility(0);
    this.DUu.setVisibility(0);
    Object localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
    localObject1 = com.tencent.mm.plugin.finder.loader.p.eCn();
    Object localObject2 = paramk.DVl;
    kotlin.g.b.s.s(localObject2, "item.img_urls");
    localObject2 = new com.tencent.mm.plugin.finder.loader.b((String)kotlin.a.p.oL((List)localObject2));
    Object localObject3 = this.DST;
    kotlin.g.b.s.s(localObject3, "productImg");
    Object localObject4 = com.tencent.mm.plugin.finder.loader.p.ExI;
    ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExV));
    localObject1 = ae.DTf;
    localObject4 = this.DSV;
    kotlin.g.b.s.s(localObject4, "productDesc");
    localObject2 = paramk.DUT;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject3 = paramk.title;
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = "";
    }
    ae.a.a((TextView)localObject4, (String)localObject1, (String)localObject2);
    localObject2 = paramk.ewd();
    localObject1 = ae.DTf;
    localObject3 = this.DSX;
    kotlin.g.b.s.s(localObject3, "productStock");
    localObject4 = this.DSZ;
    kotlin.g.b.s.s(localObject4, "sourceDivider");
    TextView localTextView = this.DUu;
    kotlin.g.b.s.s(localTextView, "productSrc");
    int i;
    label338:
    boolean bool;
    if (localObject2 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label584;
      }
      i = paramk.DVm;
      if (localObject2 == null) {
        break label593;
      }
      bool = true;
      label346:
      localObject2 = paramk.DUT;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ae.a.a((TextView)localObject3, (View)localObject4, localTextView, i, bool, (String)localObject1, paramk.DVs);
      localObject1 = this.DTa;
      kotlin.g.b.s.s(localObject1, "priceView");
      FinderLiveShoppingPriceView.a((FinderLiveShoppingPriceView)localObject1, paramk, paramb);
      this.DUs.setVisibility(0);
      paramb = (CharSequence)paramk.DVj.ZVe;
      if ((paramb != null) && (paramb.length() != 0)) {
        break label599;
      }
      i = 1;
      label439:
      if (i == 0) {
        break label604;
      }
      this.DUw.setText((CharSequence)"");
      this.DUw.setVisibility(8);
      label465:
      b(paramk);
      paramb = (CharSequence)paramk.DVx;
      i = j;
      if (paramb != null)
      {
        if (paramb.length() != 0) {
          break label632;
        }
        i = j;
      }
      label497:
      if (i == 0) {
        break label637;
      }
      this.DUx.setVisibility(8);
    }
    for (;;)
    {
      this.caK.setTag(p.e.BEJ, this.DSV.getText());
      this.caK.setTag(p.e.BEM, this.DUu.getText());
      this.caK.setTag(p.e.BEK, this.DTa.getPrice().getText());
      AppMethodBeat.o(359206);
      return;
      localObject1 = Integer.valueOf(((aoj)localObject2).DVm);
      break;
      label584:
      i = ((Integer)localObject1).intValue();
      break label338;
      label593:
      bool = false;
      break label346;
      label599:
      i = 0;
      break label439;
      label604:
      this.DUw.setText((CharSequence)paramk.DVj.ZVe);
      this.DUw.setVisibility(0);
      break label465;
      label632:
      i = 0;
      break label497;
      label637:
      this.DUx.setVisibility(0);
      paramb = com.tencent.mm.plugin.finder.loader.p.ExI;
      paramb = com.tencent.mm.plugin.finder.loader.p.eCl();
      paramk = new com.tencent.mm.plugin.finder.loader.s(paramk.DVx, v.FKY);
      localObject1 = this.DUx;
      kotlin.g.b.s.s(localObject1, "productIconView");
      localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
      paramb.a(paramk, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExS));
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/holder/FinderLiveShoppingViewHolder$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.holder.d
 * JD-Core Version:    0.7.0.1
 */