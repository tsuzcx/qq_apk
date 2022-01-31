package com.tencent.mm.plugin.card.ui.v2;

import a.f.b.j;
import a.v;
import a.y;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView.v;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.ok;
import com.tencent.mm.protocal.protobuf.ol;
import com.tencent.mm.protocal.protobuf.om;
import com.tencent.mm.protocal.protobuf.on;
import com.tencent.mm.protocal.protobuf.oq;
import com.tencent.mm.protocal.protobuf.pc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "viewType", "", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;Landroid/view/View;I)V", "chpiCouponLayout", "Landroid/widget/LinearLayout;", "getChpiCouponLayout", "()Landroid/widget/LinearLayout;", "setChpiCouponLayout", "(Landroid/widget/LinearLayout;)V", "chpiDescTv", "Landroid/widget/TextView;", "getChpiDescTv", "()Landroid/widget/TextView;", "setChpiDescTv", "(Landroid/widget/TextView;)V", "chpiExpandIv", "Landroid/widget/ImageView;", "getChpiExpandIv", "()Landroid/widget/ImageView;", "setChpiExpandIv", "(Landroid/widget/ImageView;)V", "chpiExpandLayout", "getChpiExpandLayout", "setChpiExpandLayout", "chpiExpandTv", "getChpiExpandTv", "setChpiExpandTv", "chpiHeaderLayout", "getChpiHeaderLayout", "setChpiHeaderLayout", "chpiLabelLayout", "getChpiLabelLayout", "setChpiLabelLayout", "chpiLogoIv", "Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "getChpiLogoIv", "()Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "setChpiLogoIv", "(Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;)V", "chpiMchLabelTv", "Lcom/tencent/mm/plugin/card/ui/v2/CardLabelTextView;", "getChpiMchLabelTv", "()Lcom/tencent/mm/plugin/card/ui/v2/CardLabelTextView;", "setChpiMchLabelTv", "(Lcom/tencent/mm/plugin/card/ui/v2/CardLabelTextView;)V", "chpiNameTv", "getChpiNameTv", "setChpiNameTv", "chtiDescTv", "getChtiDescTv", "setChtiDescTv", "chtiDivider", "getChtiDivider", "()Landroid/view/View;", "setChtiDivider", "(Landroid/view/View;)V", "chtiIconIv", "getChtiIconIv", "setChtiIconIv", "chtiNewTv", "getChtiNewTv", "setChtiNewTv", "chtiRedDotIv", "getChtiRedDotIv", "setChtiRedDotIv", "chtiRightIv", "getChtiRightIv", "setChtiRightIv", "chtiTitleTv", "getChtiTitleTv", "setChtiTitleTv", "model", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;", "getModel", "()Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "setModel", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;)V", "sectionTitleTv", "getSectionTitleTv", "setSectionTitleTv", "addCouponView", "", "view", "appendCouponView", "offset", "len", "position", "collapseCouponLayout", "expandCouponLayout", "gotoCardDetailUI", "cardId", "", "setCardBg", "imageView", "url", "radius", "", "defaultRes", "setIcon", "useBackendExpandState", "", "showCollapseLayout", "showExpandLayout", "showMiniAppLayout", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "labelLayout", "labelList", "Lcom/tencent/mm/protocal/protobuf/CardElementMchLabel;", "updateExpandLayout", "isExpended", "plugin-card_release"})
public final class CardHomePageNewUI$e
  extends RecyclerView.v
{
  public LinearLayout kzA;
  public TextView kzB;
  public ImageView kzC;
  public CardLabelTextView kzD;
  public ImageView kzE;
  public TextView kzF;
  public TextView kzG;
  public ImageView kzH;
  public ImageView kzI;
  public TextView kzJ;
  public View kzK;
  CardHomePageNewUI.a kzL;
  public TextView kzt;
  public CdnImageView kzu;
  public TextView kzv;
  public TextView kzw;
  public LinearLayout kzx;
  public LinearLayout kzy;
  public LinearLayout kzz;
  
  public CardHomePageNewUI$e(View paramView, int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(89210);
    int i;
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(89210);
      return;
      paramView = paramInt.findViewById(2131822204);
      j.p(paramView, "itemView.findViewById(R.id.chpi_logo_iv)");
      this.kzu = ((CdnImageView)paramView);
      paramView = paramInt.findViewById(2131822206);
      j.p(paramView, "itemView.findViewById(R.id.chpi_username_tv)");
      this.kzv = ((TextView)paramView);
      paramView = paramInt.findViewById(2131822208);
      j.p(paramView, "itemView.findViewById(R.id.chpi_desc_tv)");
      this.kzw = ((TextView)paramView);
      paramView = paramInt.findViewById(2131822223);
      j.p(paramView, "itemView.findViewById(R.id.chpi_label_layout)");
      this.kzy = ((LinearLayout)paramView);
      paramView = paramInt.findViewById(2131822224);
      j.p(paramView, "itemView.findViewById(R.id.chpi_coupon_layout)");
      this.kzz = ((LinearLayout)paramView);
      paramView = paramInt.findViewById(2131822225);
      j.p(paramView, "itemView.findViewById(R.id.chpi_expand_layout)");
      this.kzA = ((LinearLayout)paramView);
      paramView = paramInt.findViewById(2131822227);
      j.p(paramView, "itemView.findViewById(R.id.chpi_expand_iv)");
      this.kzC = ((ImageView)paramView);
      paramView = paramInt.findViewById(2131822226);
      j.p(paramView, "itemView.findViewById(R.id.chpi_expand_tv)");
      this.kzB = ((TextView)paramView);
      paramView = paramInt.findViewById(2131822207);
      j.p(paramView, "itemView.findViewById(R.id.chpi_mch_label_tv)");
      this.kzD = ((CardLabelTextView)paramView);
      paramView = paramInt.findViewById(2131822222);
      j.p(paramView, "itemView.findViewById(R.id.chpi_header_layout)");
      this.kzx = ((LinearLayout)paramView);
      AppMethodBeat.o(89210);
      return;
      paramView = paramInt.findViewById(2131822229);
      j.p(paramView, "itemView.findViewById(R.id.chpi_section_title)");
      this.kzt = ((TextView)paramView);
      AppMethodBeat.o(89210);
      return;
      paramView = paramInt.findViewById(2131822204);
      j.p(paramView, "itemView.findViewById(R.id.chpi_logo_iv)");
      this.kzu = ((CdnImageView)paramView);
      paramView = paramInt.findViewById(2131822206);
      j.p(paramView, "itemView.findViewById(R.id.chpi_username_tv)");
      this.kzv = ((TextView)paramView);
      paramView = paramInt.findViewById(2131822208);
      j.p(paramView, "itemView.findViewById(R.id.chpi_desc_tv)");
      this.kzw = ((TextView)paramView);
      paramView = paramInt.findViewById(2131822207);
      j.p(paramView, "itemView.findViewById(R.id.chpi_mch_label_tv)");
      this.kzD = ((CardLabelTextView)paramView);
      AppMethodBeat.o(89210);
      return;
      paramView = paramInt.findViewById(2131822204);
      j.p(paramView, "itemView.findViewById(R.id.chpi_logo_iv)");
      this.kzu = ((CdnImageView)paramView);
      paramView = paramInt.findViewById(2131822206);
      j.p(paramView, "itemView.findViewById(R.id.chpi_username_tv)");
      this.kzv = ((TextView)paramView);
      paramView = paramInt.findViewById(2131822208);
      j.p(paramView, "itemView.findViewById(R.id.chpi_desc_tv)");
      this.kzw = ((TextView)paramView);
      AppMethodBeat.o(89210);
      return;
      paramView = paramInt.findViewById(2131822209);
      j.p(paramView, "itemView.findViewById(R.id.chti_icon_iv)");
      this.kzE = ((ImageView)paramView);
      paramView = paramInt.findViewById(2131822210);
      j.p(paramView, "itemView.findViewById(R.id.chti_title_tv)");
      this.kzF = ((TextView)paramView);
      paramView = paramInt.findViewById(2131822211);
      j.p(paramView, "itemView.findViewById(R.id.chti_desc_tv)");
      this.kzG = ((TextView)paramView);
      paramView = paramInt.findViewById(2131822212);
      j.p(paramView, "itemView.findViewById(R.id.chti_right_iv)");
      this.kzH = ((ImageView)paramView);
      AppMethodBeat.o(89210);
      return;
      paramView = paramInt.findViewById(2131822209);
      j.p(paramView, "itemView.findViewById(R.id.chti_icon_iv)");
      this.kzE = ((ImageView)paramView);
      paramView = paramInt.findViewById(2131822210);
      j.p(paramView, "itemView.findViewById(R.id.chti_title_tv)");
      this.kzF = ((TextView)paramView);
      paramView = paramInt.findViewById(2131822211);
      j.p(paramView, "itemView.findViewById(R.id.chti_desc_tv)");
      this.kzG = ((TextView)paramView);
      paramView = paramInt.findViewById(2131822212);
      j.p(paramView, "itemView.findViewById(R.id.chti_right_iv)");
      this.kzH = ((ImageView)paramView);
      AppMethodBeat.o(89210);
      return;
      paramView = paramInt.findViewById(2131822209);
      j.p(paramView, "itemView.findViewById(R.id.chti_icon_iv)");
      this.kzE = ((ImageView)paramView);
      paramView = paramInt.findViewById(2131822210);
      j.p(paramView, "itemView.findViewById(R.id.chti_title_tv)");
      this.kzF = ((TextView)paramView);
      paramView = paramInt.findViewById(2131822211);
      j.p(paramView, "itemView.findViewById(R.id.chti_desc_tv)");
      this.kzG = ((TextView)paramView);
      paramView = paramInt.findViewById(2131822212);
      j.p(paramView, "itemView.findViewById(R.id.chti_right_iv)");
      this.kzH = ((ImageView)paramView);
      paramView = paramInt.findViewById(2131822230);
      j.p(paramView, "itemView.findViewById(R.id.chti_reddot_iv)");
      this.kzI = ((ImageView)paramView);
      paramView = paramInt.findViewById(2131822231);
      j.p(paramView, "itemView.findViewById(R.id.chti_new_tv)");
      this.kzJ = ((TextView)paramView);
      paramView = paramInt.findViewById(2131822232);
      j.p(paramView, "itemView.findViewById(R.id.chti_divider)");
      this.kzK = paramView;
    }
  }
  
  private final void O(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89201);
    Object localObject1 = this.kzL;
    if (localObject1 == null) {
      j.ebi();
    }
    localObject1 = ((CardHomePageNewUI.a)localObject1).kzm;
    if (localObject1 == null) {
      j.ebi();
    }
    Object localObject2 = ((on)localObject1).wES;
    j.p(localObject2, "el!!.card_element_coupon_list");
    localObject2 = ((Iterable)localObject2).iterator();
    int k = 0;
    int i = 0;
    if (((Iterator)localObject2).hasNext())
    {
      ol localol = (ol)((Iterator)localObject2).next();
      int j = i;
      if (k >= paramInt1)
      {
        if (localol.wEw != 1) {
          break label487;
        }
        localObject3 = this.kzz;
        if (localObject3 == null) {
          j.ays("chpiCouponLayout");
        }
        localObject3 = LayoutInflater.from(((LinearLayout)localObject3).getContext());
        localLinearLayout = this.kzz;
        if (localLinearLayout == null) {
          j.ays("chpiCouponLayout");
        }
        localObject3 = ((LayoutInflater)localObject3).inflate(2130968947, (ViewGroup)localLinearLayout, false);
        if (localObject3 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(89201);
          throw ((Throwable)localObject1);
        }
        localObject3 = (ViewGroup)localObject3;
        localObject4 = (TextView)((ViewGroup)localObject3).findViewById(2131822215);
        localObject5 = (CdnImageView)((ViewGroup)localObject3).findViewById(2131822218);
        localObject6 = (TextView)((ViewGroup)localObject3).findViewById(2131822216);
        localLinearLayout = (LinearLayout)((ViewGroup)localObject3).findViewById(2131822217);
        if (!bo.isNullOrNil(localol.wEz)) {
          ((TextView)localObject4).setTextColor(com.tencent.mm.plugin.card.d.l.bT(localol.wEz, localol.wEA));
        }
        j.p(localObject4, "titleTv");
        ((TextView)localObject4).setText((CharSequence)localol.wEq);
        ((CdnImageView)localObject5).setUrl(localol.wEx);
        if (!bo.isNullOrNil(localol.wEB)) {
          ((TextView)localObject6).setTextColor(com.tencent.mm.plugin.card.d.l.bT(localol.wEB, localol.wEC));
        }
        j.p(localObject6, "descTv");
        ((TextView)localObject6).setText((CharSequence)localol.wEr);
        localObject4 = localol.wEv;
        j.p(localObject4, "coupon.coupon_label");
        localObject4 = (List)localObject4;
        j.p(localLinearLayout, "labelLayout");
        a((List)localObject4, localLinearLayout);
        localLinearLayout = this.kzz;
        if (localLinearLayout == null) {
          j.ays("chpiCouponLayout");
        }
        ((ViewGroup)localObject3).setOnClickListener((View.OnClickListener)new CardHomePageNewUI.e.a(this, (on)localObject1, localol, localLinearLayout.getChildCount(), paramInt3));
        df((View)localObject3);
      }
      label487:
      while (localol.wEw != 2)
      {
        j = i;
        if (paramInt2 > 0)
        {
          j = i + 1;
          if (j >= paramInt2) {
            break label1081;
          }
        }
        k += 1;
        i = j;
        break;
      }
      Object localObject3 = this.kzz;
      if (localObject3 == null) {
        j.ays("chpiCouponLayout");
      }
      localObject3 = LayoutInflater.from(((LinearLayout)localObject3).getContext());
      LinearLayout localLinearLayout = this.kzz;
      if (localLinearLayout == null) {
        j.ays("chpiCouponLayout");
      }
      localObject3 = ((LayoutInflater)localObject3).inflate(2130968946, (ViewGroup)localLinearLayout, false);
      if (localObject3 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(89201);
        throw ((Throwable)localObject1);
      }
      localObject3 = (ViewGroup)localObject3;
      Object localObject5 = (TextView)((ViewGroup)localObject3).findViewById(2131822215);
      Object localObject6 = (TextView)((ViewGroup)localObject3).findViewById(2131822216);
      localLinearLayout = (LinearLayout)((ViewGroup)localObject3).findViewById(2131822217);
      Object localObject7 = (MemberCardTopCropImageView)((ViewGroup)localObject3).findViewById(2131822213);
      Object localObject4 = (ImageView)((ViewGroup)localObject3).findViewById(2131822214);
      if (!bo.isNullOrNil(localol.wEz)) {
        ((TextView)localObject5).setTextColor(com.tencent.mm.plugin.card.d.l.bT(localol.wEz, localol.wEA));
      }
      j.p(localObject5, "titleTv");
      ((TextView)localObject5).setText((CharSequence)localol.wEq);
      j.p(localObject6, "descTv");
      ((TextView)localObject6).setText((CharSequence)localol.wEr);
      j.p(localObject7, "bgIv");
      ((MemberCardTopCropImageView)localObject7).setRadius(com.tencent.mm.cb.a.fromDPToPix(((MemberCardTopCropImageView)localObject7).getContext(), 2));
      if (!bo.isNullOrNil(localol.wEu))
      {
        localObject5 = (ImageView)localObject7;
        localObject6 = localol.wEu;
        j.p(localObject6, "coupon.coupon_back_url");
        j.q(localObject5, "imageView");
        j.q(localObject6, "url");
        localObject7 = new c.a();
        ((c.a)localObject7).tz(e.eQz);
        ((c.a)localObject7).a(o.ahH());
        ((c.a)localObject7).ty(com.tencent.mm.plugin.card.model.m.HO((String)localObject6));
        ((c.a)localObject7).ahU();
        ((c.a)localObject7).ahX();
        ((c.a)localObject7).ahT();
        ((c.a)localObject7).lH(2130838133);
        ((c.a)localObject7).lG(com.tencent.mm.cb.a.fromDPToPix(((ImageView)localObject5).getContext(), 84));
        ((c.a)localObject7).lF(com.tencent.mm.cb.a.gw(((ImageView)localObject5).getContext()));
        localObject7 = ((c.a)localObject7).ahY();
        o.ahG().a((String)localObject6, (ImageView)localObject5, (c)localObject7);
        ((ImageView)localObject5).setImageMatrix(new Matrix());
        j.p(localObject4, "shadowBgIv");
        ((ImageView)localObject4).setVisibility(0);
      }
      for (;;)
      {
        localObject4 = localol.wEv;
        j.p(localObject4, "coupon.coupon_label");
        localObject4 = (List)localObject4;
        j.p(localLinearLayout, "labelLayout");
        a((List)localObject4, localLinearLayout);
        localLinearLayout = this.kzz;
        if (localLinearLayout == null) {
          j.ays("chpiCouponLayout");
        }
        ((ViewGroup)localObject3).setOnClickListener((View.OnClickListener)new CardHomePageNewUI.e.b(this, (on)localObject1, localol, localLinearLayout.getChildCount(), paramInt3));
        df((View)localObject3);
        break;
        if (!bo.isNullOrNil(localol.wEt))
        {
          ((MemberCardTopCropImageView)localObject7).setImageDrawable((Drawable)new ColorDrawable(Color.parseColor(localol.wEt)));
          j.p(localObject4, "shadowBgIv");
          ((ImageView)localObject4).setVisibility(0);
        }
      }
    }
    label1081:
    AppMethodBeat.o(89201);
  }
  
  private static void a(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(152208);
    j.q(paramImageView, "imageView");
    j.q(paramString, "url");
    Object localObject = new c.a();
    ((c.a)localObject).tz(e.eQz);
    ((c.a)localObject).a(o.ahH());
    ((c.a)localObject).ty(com.tencent.mm.plugin.card.model.m.HO(paramString));
    ((c.a)localObject).ahU();
    ((c.a)localObject).ahW();
    ((c.a)localObject).ahX();
    ((c.a)localObject).ahT();
    ((c.a)localObject).lH(2131231074);
    localObject = ((c.a)localObject).ahY();
    o.ahG().a(paramString, paramImageView, (c)localObject);
    AppMethodBeat.o(152208);
  }
  
  private void a(List<? extends ok> paramList, LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(89205);
    j.q(paramList, "couponLabelList");
    j.q(paramLinearLayout, "labelLayout");
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      ok localok = (ok)paramList.next();
      Object localObject1 = this.kzz;
      if (localObject1 == null) {
        j.ays("chpiCouponLayout");
      }
      localObject1 = new CardTagTextView(((LinearLayout)localObject1).getContext());
      Object localObject2 = this.kzz;
      if (localObject2 == null) {
        j.ays("chpiCouponLayout");
      }
      localObject2 = ((LinearLayout)localObject2).getContext();
      ((CardTagTextView)localObject1).setMinHeight(com.tencent.mm.cb.a.fromDPToPix((Context)localObject2, 18));
      ((CardTagTextView)localObject1).setMinWidth(com.tencent.mm.cb.a.fromDPToPix((Context)localObject2, 56));
      int i = com.tencent.mm.cb.a.fromDPToPix((Context)localObject2, 8);
      int j = com.tencent.mm.cb.a.fromDPToPix((Context)localObject2, 4);
      ((CardTagTextView)localObject1).setPadding(i, j, i, j);
      ((CardTagTextView)localObject1).setText((CharSequence)localok.wEk);
      ((CardTagTextView)localObject1).setTextSize(1, 10.0F);
      if (!bo.isNullOrNil(localok.wEl))
      {
        ((CardTagTextView)localObject1).setTextColor(Color.parseColor(localok.wEl));
        label199:
        if (bo.isNullOrNil(localok.wEm)) {
          break label249;
        }
        ((CardTagTextView)localObject1).setFillColor(com.tencent.mm.plugin.card.d.l.bT(localok.wEm, localok.wEp));
      }
      for (;;)
      {
        paramLinearLayout.addView((View)localObject1);
        break;
        ((CardTagTextView)localObject1).setTextColor(-1);
        break label199;
        label249:
        ((CardTagTextView)localObject1).setFillColor(com.tencent.mm.plugin.card.d.l.dS(-16777216, 26));
      }
    }
    AppMethodBeat.o(89205);
  }
  
  private void bf(List<? extends om> paramList)
  {
    AppMethodBeat.i(89204);
    j.q(paramList, "labelList");
    Object localObject1 = this.kzy;
    if (localObject1 == null) {
      j.ays("chpiLabelLayout");
    }
    ((LinearLayout)localObject1).removeAllViews();
    if (paramList.isEmpty())
    {
      paramList = this.kzy;
      if (paramList == null) {
        j.ays("chpiLabelLayout");
      }
      paramList.setVisibility(8);
      AppMethodBeat.o(89204);
      return;
    }
    paramList = ((Iterable)paramList).iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      Object localObject2 = (om)paramList.next();
      localObject1 = this.kzy;
      if (localObject1 == null) {
        j.ays("chpiLabelLayout");
      }
      localObject1 = ((LinearLayout)localObject1).getContext();
      j.p(localObject1, "chpiLabelLayout.context");
      localObject1 = new CardLabelTextView((Context)localObject1);
      Object localObject3 = this.kzy;
      if (localObject3 == null) {
        j.ays("chpiLabelLayout");
      }
      localObject3 = ((LinearLayout)localObject3).getContext();
      ((CardLabelTextView)localObject1).setTextSize(1, 12.0F);
      ((CardLabelTextView)localObject1).setText((CharSequence)((om)localObject2).wED);
      int j = com.tencent.mm.cb.a.fromDPToPix((Context)localObject3, 4);
      ((CardLabelTextView)localObject1).setPadding(j, 0, j, 0);
      ((CardLabelTextView)localObject1).setGravity(16);
      if (!bo.isNullOrNil(((om)localObject2).wEE))
      {
        ((CardLabelTextView)localObject1).setTextColor(Color.parseColor(((om)localObject2).wEE));
        label240:
        if (bo.isNullOrNil(((om)localObject2).wEF)) {
          break label359;
        }
        ((CardLabelTextView)localObject1).setFillColor(com.tencent.mm.plugin.card.d.l.bT(((om)localObject2).wEF, ((om)localObject2).wEI));
        label269:
        if (i <= 0) {
          break label368;
        }
        localObject2 = new ViewGroup.MarginLayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = com.tencent.mm.cb.a.fromDPToPix((Context)localObject3, 4);
        localObject2 = (ViewGroup.MarginLayoutParams)new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject2);
        localObject3 = this.kzy;
        if (localObject3 == null) {
          j.ays("chpiLabelLayout");
        }
        ((LinearLayout)localObject3).addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      }
      for (;;)
      {
        i += 1;
        break;
        ((CardLabelTextView)localObject1).setTextColor(-1);
        break label240;
        label359:
        ((CardLabelTextView)localObject1).setFillColor(0);
        break label269;
        label368:
        localObject2 = this.kzy;
        if (localObject2 == null) {
          j.ays("chpiLabelLayout");
        }
        ((LinearLayout)localObject2).addView((View)localObject1);
      }
    }
    paramList = this.kzy;
    if (paramList == null) {
      j.ays("chpiLabelLayout");
    }
    paramList.setVisibility(0);
    AppMethodBeat.o(89204);
  }
  
  private void df(View paramView)
  {
    AppMethodBeat.i(89203);
    j.q(paramView, "view");
    Object localObject = this.kzz;
    if (localObject == null) {
      j.ays("chpiCouponLayout");
    }
    if (((LinearLayout)localObject).getChildCount() == 0)
    {
      localObject = this.kzz;
      if (localObject == null) {
        j.ays("chpiCouponLayout");
      }
      ((LinearLayout)localObject).addView(paramView);
      AppMethodBeat.o(89203);
      return;
    }
    localObject = this.kzz;
    if (localObject == null) {
      j.ays("chpiCouponLayout");
    }
    localObject = new ViewGroup.MarginLayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(((LinearLayout)localObject).getContext(), 84));
    LinearLayout localLinearLayout = this.kzz;
    if (localLinearLayout == null) {
      j.ays("chpiCouponLayout");
    }
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = com.tencent.mm.cb.a.fromDPToPix(localLinearLayout.getContext(), 8);
    localObject = (ViewGroup.MarginLayoutParams)new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject);
    localLinearLayout = this.kzz;
    if (localLinearLayout == null) {
      j.ays("chpiCouponLayout");
    }
    localLinearLayout.addView(paramView, (ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(89203);
  }
  
  private final void r(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(89209);
    Object localObject = this.kzL;
    if (localObject == null) {
      j.ebi();
    }
    localObject = ((CardHomePageNewUI.a)localObject).kzm;
    if (paramBoolean)
    {
      if (localObject != null) {}
      for (localObject = ((on)localObject).wET; !bo.isNullOrNil((String)localObject); localObject = null)
      {
        tp(paramInt);
        AppMethodBeat.o(89209);
        return;
      }
      tr(paramInt);
      AppMethodBeat.o(89209);
      return;
    }
    tq(paramInt);
    AppMethodBeat.o(89209);
  }
  
  private final void tp(int paramInt)
  {
    AppMethodBeat.i(89206);
    Object localObject1 = this.kzL;
    if (localObject1 == null) {
      j.ebi();
    }
    localObject1 = ((CardHomePageNewUI.a)localObject1).kzm;
    if (localObject1 == null) {
      j.ebi();
    }
    if (!bo.isNullOrNil(((on)localObject1).wET))
    {
      if (!bo.isNullOrNil(((on)localObject1).wEU))
      {
        localObject2 = this.kzB;
        if (localObject2 == null) {
          j.ays("chpiExpandTv");
        }
        ((TextView)localObject2).setTextColor(Color.parseColor(((on)localObject1).wEU));
      }
      Object localObject2 = this.kzB;
      if (localObject2 == null) {
        j.ays("chpiExpandTv");
      }
      ((TextView)localObject2).setText((CharSequence)((on)localObject1).wET);
      localObject2 = this.kzC;
      if (localObject2 == null) {
        j.ays("chpiExpandIv");
      }
      ((ImageView)localObject2).setImageResource(2130838108);
      localObject2 = this.kzA;
      if (localObject2 == null) {
        j.ays("chpiExpandLayout");
      }
      ((LinearLayout)localObject2).setOnClickListener((View.OnClickListener)new CardHomePageNewUI.e.i((on)localObject1, this, paramInt));
    }
    AppMethodBeat.o(89206);
  }
  
  private final void tq(int paramInt)
  {
    AppMethodBeat.i(89207);
    Object localObject1 = this.kzL;
    if (localObject1 == null) {
      j.ebi();
    }
    localObject1 = ((CardHomePageNewUI.a)localObject1).kzm;
    Object localObject2 = this.kzB;
    if (localObject2 == null) {
      j.ays("chpiExpandTv");
    }
    Resources localResources = ah.getResources();
    if (localObject1 == null) {
      j.ebi();
    }
    ((TextView)localObject2).setText((CharSequence)localResources.getString(2131297944, new Object[] { Integer.valueOf(((on)localObject1).wEY - ((on)localObject1).wEZ) }));
    localObject2 = this.kzA;
    if (localObject2 == null) {
      j.ays("chpiExpandLayout");
    }
    ((LinearLayout)localObject2).setOnClickListener((View.OnClickListener)new CardHomePageNewUI.e.h(this, paramInt, (on)localObject1));
    localObject1 = this.kzC;
    if (localObject1 == null) {
      j.ays("chpiExpandIv");
    }
    ((ImageView)localObject1).setImageResource(2130838166);
    localObject1 = this.kzC;
    if (localObject1 == null) {
      j.ays("chpiExpandIv");
    }
    ((ImageView)localObject1).setVisibility(0);
    AppMethodBeat.o(89207);
  }
  
  private final void tr(final int paramInt)
  {
    AppMethodBeat.i(89208);
    Object localObject1 = this.kzL;
    if (localObject1 == null) {
      j.ebi();
    }
    localObject1 = ((CardHomePageNewUI.a)localObject1).kzm;
    Object localObject2 = this.kzB;
    if (localObject2 == null) {
      j.ays("chpiExpandTv");
    }
    ((TextView)localObject2).setText((CharSequence)ah.getResources().getString(2131297942));
    localObject2 = this.kzA;
    if (localObject2 == null) {
      j.ays("chpiExpandLayout");
    }
    ((LinearLayout)localObject2).setOnClickListener((View.OnClickListener)new g(this, paramInt, (on)localObject1));
    localObject1 = this.kzC;
    if (localObject1 == null) {
      j.ays("chpiExpandIv");
    }
    ((ImageView)localObject1).setImageResource(2130838167);
    localObject1 = this.kzC;
    if (localObject1 == null) {
      j.ays("chpiExpandIv");
    }
    ((ImageView)localObject1).setVisibility(0);
    AppMethodBeat.o(89208);
  }
  
  public final void Im(String paramString)
  {
    AppMethodBeat.i(89202);
    j.q(paramString, "cardId");
    ab.i("MicroMsg.CardHomePageNewUI", "go to card detail: %s", new Object[] { paramString });
    Object localObject = this.aku;
    j.p(localObject, "itemView");
    localObject = new Intent(((View)localObject).getContext(), CardDetailUI.class);
    ((Intent)localObject).putExtra("key_card_id", paramString);
    ((Intent)localObject).addFlags(131072);
    ((Intent)localObject).putExtra("key_from_scene", 3);
    paramString = this.aku;
    j.p(paramString, "itemView");
    paramString.getContext().startActivity((Intent)localObject);
    AppMethodBeat.o(89202);
  }
  
  public final void a(CardHomePageNewUI.a parama, int paramInt)
  {
    AppMethodBeat.i(89199);
    j.q(parama, "model");
    this.kzL = parama;
    Object localObject1 = parama.kzm;
    switch (parama.type)
    {
    }
    for (;;)
    {
      parama.kzo = true;
      AppMethodBeat.o(89199);
      return;
      if (localObject1 == null) {
        j.ebi();
      }
      Object localObject2 = this.kzu;
      if (localObject2 == null) {
        j.ays("chpiLogoIv");
      }
      ((CdnImageView)localObject2).setRoundCorner(true);
      Object localObject3;
      label172:
      label481:
      label638:
      boolean bool;
      label583:
      int i;
      if (!bo.isNullOrNil(((on)localObject1).wEK))
      {
        localObject2 = this.kzu;
        if (localObject2 == null) {
          j.ays("chpiLogoIv");
        }
        localObject2 = (ImageView)localObject2;
        localObject3 = ((on)localObject1).wEK;
        j.p(localObject3, "card_element_mch_icon");
        a((ImageView)localObject2, (String)localObject3);
        localObject2 = (View.OnClickListener)new CardHomePageNewUI.e.c((on)localObject1, this, (on)localObject1, paramInt, parama);
        localObject3 = this.kzu;
        if (localObject3 == null) {
          j.ays("chpiLogoIv");
        }
        ((CdnImageView)localObject3).setOnClickListener((View.OnClickListener)localObject2);
        localObject3 = this.kzs;
        Object localObject4 = this.kzs.getContext();
        j.p(localObject4, "context");
        localObject4 = new CardHomePageNewUI.b((CardHomePageNewUI)localObject3, ((AppCompatActivity)localObject4).getResources().getColor(2131690488), (com.tencent.mm.pluginsdk.ui.d.h)new CardHomePageNewUI.e.d((View.OnClickListener)localObject2));
        localObject3 = new SpannableString((CharSequence)((on)localObject1).wEL);
        ((SpannableString)localObject3).setSpan(localObject4, 0, ((SpannableString)localObject3).length(), 18);
        localObject4 = this.kzv;
        if (localObject4 == null) {
          j.ays("chpiNameTv");
        }
        ((TextView)localObject4).setClickable(true);
        localObject4 = this.kzv;
        if (localObject4 == null) {
          j.ays("chpiNameTv");
        }
        ((TextView)localObject4).setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.d.m((Context)this.kzs));
        localObject4 = this.kzv;
        if (localObject4 == null) {
          j.ays("chpiNameTv");
        }
        ((TextView)localObject4).setText((CharSequence)localObject3);
        if (bo.isNullOrNil(((on)localObject1).wEM)) {
          break label882;
        }
        localObject3 = this.kzw;
        if (localObject3 == null) {
          j.ays("chpiDescTv");
        }
        ((TextView)localObject3).setText((CharSequence)((on)localObject1).wEM);
        localObject3 = this.kzw;
        if (localObject3 == null) {
          j.ays("chpiDescTv");
        }
        ((TextView)localObject3).setVisibility(0);
        localObject3 = this.kzw;
        if (localObject3 == null) {
          j.ays("chpiDescTv");
        }
        ((TextView)localObject3).setOnClickListener((View.OnClickListener)localObject2);
        if (((on)localObject1).wEW == null) {
          break label988;
        }
        if (bo.isNullOrNil(((on)localObject1).wEW.wED)) {
          break label961;
        }
        localObject2 = this.kzD;
        if (localObject2 == null) {
          j.ays("chpiMchLabelTv");
        }
        ((CardLabelTextView)localObject2).setText((CharSequence)((on)localObject1).wEW.wED);
        if (bo.isNullOrNil(((on)localObject1).wEW.wEE)) {
          break label909;
        }
        localObject2 = this.kzD;
        if (localObject2 == null) {
          j.ays("chpiMchLabelTv");
        }
        ((CardLabelTextView)localObject2).setTextColor(Color.parseColor(((on)localObject1).wEW.wEE));
        if (bo.isNullOrNil(((on)localObject1).wEW.wEF)) {
          break label935;
        }
        localObject2 = this.kzD;
        if (localObject2 == null) {
          j.ays("chpiMchLabelTv");
        }
        ((CardLabelTextView)localObject2).setFillColor(com.tencent.mm.plugin.card.d.l.bT(((on)localObject1).wEW.wEF, ((on)localObject1).wEW.wEI));
        localObject2 = this.kzD;
        if (localObject2 == null) {
          j.ays("chpiMchLabelTv");
        }
        ((CardLabelTextView)localObject2).setVisibility(0);
        label661:
        localObject2 = this.kzz;
        if (localObject2 == null) {
          j.ays("chpiCouponLayout");
        }
        ((LinearLayout)localObject2).removeAllViews();
        if (parama.kzo) {
          break label1049;
        }
        if (((on)localObject1).wEX != 1) {
          break label1043;
        }
        bool = true;
        label702:
        if (!bool) {
          break label1141;
        }
        localObject2 = ((on)localObject1).wES;
        j.p(localObject2, "card_element_coupon_list");
        if (((Collection)localObject2).isEmpty()) {
          break label1058;
        }
        i = 1;
        label737:
        if (i == 0) {
          break label1063;
        }
        O(-1, ((on)localObject1).wES.size(), paramInt);
        localObject2 = this.kzz;
        if (localObject2 == null) {
          j.ays("chpiCouponLayout");
        }
        ((LinearLayout)localObject2).setVisibility(0);
        parama.kzp = true;
        label783:
        if (bo.isNullOrNil(((on)localObject1).wET)) {
          break label1090;
        }
        tp(paramInt);
        localObject2 = this.kzA;
        if (localObject2 == null) {
          j.ays("chpiExpandLayout");
        }
        ((LinearLayout)localObject2).setVisibility(0);
      }
      label909:
      label1043:
      label1171:
      for (;;)
      {
        localObject1 = ((on)localObject1).wEN;
        j.p(localObject1, "card_element_mch_label");
        bf((List)localObject1);
        localObject1 = y.BMg;
        break;
        localObject2 = this.kzu;
        if (localObject2 == null) {
          j.ays("chpiLogoIv");
        }
        ((CdnImageView)localObject2).setImageResource(2131231074);
        break label172;
        label882:
        localObject2 = this.kzw;
        if (localObject2 == null) {
          j.ays("chpiDescTv");
        }
        ((TextView)localObject2).setVisibility(8);
        break label481;
        localObject2 = this.kzD;
        if (localObject2 == null) {
          j.ays("chpiMchLabelTv");
        }
        ((CardLabelTextView)localObject2).setTextColor(-1);
        break label583;
        label935:
        localObject2 = this.kzD;
        if (localObject2 == null) {
          j.ays("chpiMchLabelTv");
        }
        ((CardLabelTextView)localObject2).setFillColor(0);
        break label638;
        label961:
        localObject2 = this.kzD;
        if (localObject2 == null) {
          j.ays("chpiMchLabelTv");
        }
        ((CardLabelTextView)localObject2).setVisibility(8);
        break label661;
        label988:
        localObject2 = this.kzD;
        if (localObject2 == null) {
          j.ays("chpiMchLabelTv");
        }
        ((CardLabelTextView)localObject2).setText((CharSequence)"");
        localObject2 = this.kzD;
        if (localObject2 == null) {
          j.ays("chpiMchLabelTv");
        }
        ((CardLabelTextView)localObject2).setVisibility(8);
        break label661;
        bool = false;
        break label702;
        label1049:
        bool = parama.kzp;
        break label702;
        label1058:
        i = 0;
        break label737;
        label1063:
        localObject2 = this.kzz;
        if (localObject2 == null) {
          j.ays("chpiCouponLayout");
        }
        ((LinearLayout)localObject2).setVisibility(8);
        break label783;
        label1090:
        if (((on)localObject1).wEZ < ((on)localObject1).wES.size())
        {
          tr(paramInt);
        }
        else
        {
          localObject2 = this.kzA;
          if (localObject2 == null) {
            j.ays("chpiExpandLayout");
          }
          ((LinearLayout)localObject2).setVisibility(8);
          continue;
          label1141:
          localObject2 = ((on)localObject1).wES;
          j.p(localObject2, "card_element_coupon_list");
          if (!((Collection)localObject2).isEmpty())
          {
            i = 1;
            if (i == 0) {
              break label1277;
            }
            O(-1, ((on)localObject1).wEZ, paramInt);
            localObject2 = this.kzz;
            if (localObject2 == null) {
              j.ays("chpiCouponLayout");
            }
            ((LinearLayout)localObject2).setVisibility(0);
            parama.kzp = false;
          }
          for (;;)
          {
            if (((on)localObject1).wEZ >= ((on)localObject1).wES.size())
            {
              if (!bo.isNullOrNil(((on)localObject1).wET))
              {
                tp(paramInt);
                localObject2 = this.kzA;
                if (localObject2 == null) {
                  j.ays("chpiExpandLayout");
                }
                ((LinearLayout)localObject2).setVisibility(0);
                break;
                i = 0;
                break label1171;
                label1277:
                localObject2 = this.kzz;
                if (localObject2 == null) {
                  j.ays("chpiCouponLayout");
                }
                ((LinearLayout)localObject2).setVisibility(8);
                continue;
              }
              localObject2 = this.kzA;
              if (localObject2 == null) {
                j.ays("chpiExpandLayout");
              }
              ((LinearLayout)localObject2).setVisibility(8);
              break;
            }
          }
          tq(paramInt);
          localObject2 = this.kzA;
          if (localObject2 == null) {
            j.ays("chpiExpandLayout");
          }
          ((LinearLayout)localObject2).setVisibility(0);
        }
      }
      localObject1 = this.kzt;
      if (localObject1 == null) {
        j.ays("sectionTitleTv");
      }
      ((TextView)localObject1).setText((CharSequence)parama.bfi());
      continue;
      if (localObject1 == null) {
        j.ebi();
      }
      localObject2 = this.kzu;
      if (localObject2 == null) {
        j.ays("chpiLogoIv");
      }
      ((CdnImageView)localObject2).setRoundCorner(true);
      localObject2 = this.kzu;
      if (localObject2 == null) {
        j.ays("chpiLogoIv");
      }
      ((CdnImageView)localObject2).setUrl(((on)localObject1).wEK);
      localObject2 = this.kzv;
      if (localObject2 == null) {
        j.ays("chpiNameTv");
      }
      ((TextView)localObject2).setText((CharSequence)((on)localObject1).wEL);
      if (!bo.isNullOrNil(((on)localObject1).wEM))
      {
        localObject2 = this.kzw;
        if (localObject2 == null) {
          j.ays("chpiDescTv");
        }
        ((TextView)localObject2).setText((CharSequence)((on)localObject1).wEM);
        localObject2 = this.kzw;
        if (localObject2 == null) {
          j.ays("chpiDescTv");
        }
        ((TextView)localObject2).setVisibility(0);
        label1546:
        if (((on)localObject1).wEW == null) {
          break label1840;
        }
        if (bo.isNullOrNil(((on)localObject1).wEW.wED)) {
          break label1813;
        }
        localObject2 = this.kzD;
        if (localObject2 == null) {
          j.ays("chpiMchLabelTv");
        }
        ((CardLabelTextView)localObject2).setText((CharSequence)((on)localObject1).wEW.wED);
        if (bo.isNullOrNil(((on)localObject1).wEW.wEE)) {
          break label1761;
        }
        localObject2 = this.kzD;
        if (localObject2 == null) {
          j.ays("chpiMchLabelTv");
        }
        ((CardLabelTextView)localObject2).setTextColor(Color.parseColor(((on)localObject1).wEW.wEE));
        label1648:
        if (bo.isNullOrNil(((on)localObject1).wEW.wEF)) {
          break label1787;
        }
        localObject2 = this.kzD;
        if (localObject2 == null) {
          j.ays("chpiMchLabelTv");
        }
        ((CardLabelTextView)localObject2).setFillColor(com.tencent.mm.plugin.card.d.l.bT(((on)localObject1).wEW.wEF, ((on)localObject1).wEW.wEI));
        label1703:
        localObject1 = this.kzD;
        if (localObject1 == null) {
          j.ays("chpiMchLabelTv");
        }
        ((CardLabelTextView)localObject1).setVisibility(0);
      }
      for (;;)
      {
        localObject1 = y.BMg;
        break;
        localObject2 = this.kzw;
        if (localObject2 == null) {
          j.ays("chpiDescTv");
        }
        ((TextView)localObject2).setVisibility(8);
        break label1546;
        label1761:
        localObject2 = this.kzD;
        if (localObject2 == null) {
          j.ays("chpiMchLabelTv");
        }
        ((CardLabelTextView)localObject2).setTextColor(-1);
        break label1648;
        label1787:
        localObject1 = this.kzD;
        if (localObject1 == null) {
          j.ays("chpiMchLabelTv");
        }
        ((CardLabelTextView)localObject1).setFillColor(0);
        break label1703;
        label1813:
        localObject1 = this.kzD;
        if (localObject1 == null) {
          j.ays("chpiMchLabelTv");
        }
        ((CardLabelTextView)localObject1).setVisibility(8);
        continue;
        label1840:
        localObject1 = this.kzD;
        if (localObject1 == null) {
          j.ays("chpiMchLabelTv");
        }
        ((CardLabelTextView)localObject1).setText((CharSequence)"");
        localObject1 = this.kzD;
        if (localObject1 == null) {
          j.ays("chpiMchLabelTv");
        }
        ((CardLabelTextView)localObject1).setVisibility(8);
      }
      localObject1 = this.kzu;
      if (localObject1 == null) {
        j.ays("chpiLogoIv");
      }
      ((CdnImageView)localObject1).setRoundCorner(true);
      localObject1 = this.kzu;
      if (localObject1 == null) {
        j.ays("chpiLogoIv");
      }
      ((CdnImageView)localObject1).setImageResource(2131231074);
      localObject1 = this.kzv;
      if (localObject1 == null) {
        j.ays("chpiNameTv");
      }
      ((TextView)localObject1).setText((CharSequence)ah.getResources().getString(2131297945));
      localObject1 = this.kzw;
      if (localObject1 == null) {
        j.ays("chpiDescTv");
      }
      ((TextView)localObject1).setVisibility(8);
      continue;
      localObject1 = this.kzF;
      if (localObject1 == null) {
        j.ays("chtiTitleTv");
      }
      ((TextView)localObject1).setText(2131304289);
      if (CardHomePageNewUI.m(this.kzs) != null)
      {
        localObject1 = this.kzG;
        if (localObject1 == null) {
          j.ays("chtiDescTv");
        }
        ((TextView)localObject1).setText((CharSequence)CardHomePageNewUI.m(this.kzs));
        localObject1 = y.BMg;
        continue;
        localObject1 = this.kzF;
        if (localObject1 == null) {
          j.ays("chtiTitleTv");
        }
        ((TextView)localObject1).setText(2131298006);
        if (CardHomePageNewUI.n(this.kzs) == 1)
        {
          localObject1 = this.kzG;
          if (localObject1 == null) {
            j.ays("chtiDescTv");
          }
          ((TextView)localObject1).setVisibility(0);
          localObject1 = this.kzH;
          if (localObject1 == null) {
            j.ays("chtiRightIv");
          }
          ((ImageView)localObject1).setVisibility(0);
          localObject1 = this.kzs.bfe();
          if (localObject1 == null)
          {
            localObject1 = this.kzG;
            if (localObject1 == null) {
              j.ays("chtiDescTv");
            }
            ((TextView)localObject1).setText((CharSequence)"");
          }
          for (;;)
          {
            localObject1 = this.kzG;
            if (localObject1 == null) {
              j.ays("chtiDescTv");
            }
            ((TextView)localObject1).setOnClickListener((View.OnClickListener)new CardHomePageNewUI.e.e(this));
            localObject1 = this.kzH;
            if (localObject1 == null) {
              j.ays("chtiRightIv");
            }
            ((ImageView)localObject1).setOnClickListener((View.OnClickListener)new CardHomePageNewUI.e.f(this));
            localObject1 = this.kzH;
            if (localObject1 == null) {
              j.ays("chtiRightIv");
            }
            bo.n((View)localObject1, 50, 50, 50, 50);
            break;
            localObject2 = this.kzG;
            if (localObject2 == null) {
              j.ays("chtiDescTv");
            }
            ((TextView)localObject2).setText((CharSequence)((pc)localObject1).wFO);
          }
        }
        localObject1 = this.kzG;
        if (localObject1 == null) {
          j.ays("chtiDescTv");
        }
        ((TextView)localObject1).setVisibility(8);
        localObject1 = this.kzH;
        if (localObject1 == null) {
          j.ays("chtiRightIv");
        }
        ((ImageView)localObject1).setVisibility(8);
        continue;
        localObject1 = parama.kzq;
        if (localObject1 != null)
        {
          localObject2 = this.kzF;
          if (localObject2 == null) {
            j.ays("chtiTitleTv");
          }
          ((TextView)localObject2).setText((CharSequence)((oq)localObject1).wFh);
          localObject2 = this.kzG;
          if (localObject2 == null) {
            j.ays("chtiDescTv");
          }
          ((TextView)localObject2).setText((CharSequence)((oq)localObject1).wFi);
          localObject2 = this.kzE;
          if (localObject2 == null) {
            j.ays("chtiIconIv");
          }
          localObject3 = ((oq)localObject1).wFg;
          j.p(localObject3, "card_top_cell_icon");
          a((ImageView)localObject2, (String)localObject3);
          localObject2 = this.kzJ;
          if (localObject2 == null) {
            j.ays("chtiNewTv");
          }
          if (((oq)localObject1).wFo != 1) {
            break label2605;
          }
          paramInt = 0;
          label2527:
          ((TextView)localObject2).setVisibility(paramInt);
          localObject2 = this.kzI;
          if (localObject2 == null) {
            j.ays("chtiRedDotIv");
          }
          if (((oq)localObject1).wFn != 1) {
            break label2611;
          }
        }
        label2605:
        label2611:
        for (paramInt = 0;; paramInt = 8)
        {
          ((ImageView)localObject2).setVisibility(paramInt);
          localObject1 = y.BMg;
          if (!parama.kzr) {
            break label2617;
          }
          localObject1 = this.kzK;
          if (localObject1 == null) {
            j.ays("chtiDivider");
          }
          ((View)localObject1).setVisibility(0);
          break;
          paramInt = 8;
          break label2527;
        }
        label2617:
        localObject1 = this.kzK;
        if (localObject1 == null) {
          j.ays("chtiDivider");
        }
        ((View)localObject1).setVisibility(8);
      }
    }
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(CardHomePageNewUI.e parame, int paramInt, on paramon) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(89196);
      ab.d("MicroMsg.CardHomePageNewUI", "do collapse coupon layout");
      CardHomePageNewUI.e.b(this.kzM, paramInt);
      paramView = this.kzM.kzL;
      if (paramView != null) {
        paramView.kzp = false;
      }
      paramView = com.tencent.mm.plugin.report.service.h.qsU;
      on localon = this.kzN;
      if (localon == null) {
        j.ebi();
      }
      paramView.e(16324, new Object[] { Integer.valueOf(1), localon.wEJ, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(5), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.l(this.kzM.kzs)) });
      AppMethodBeat.o(89196);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI.e
 * JD-Core Version:    0.7.0.1
 */