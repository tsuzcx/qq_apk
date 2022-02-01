package com.tencent.mm.plugin.card.ui.v2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.dnd;
import com.tencent.mm.protocal.protobuf.eal;
import com.tencent.mm.protocal.protobuf.eam;
import com.tencent.mm.protocal.protobuf.vs;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v2/CardTicketVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "viewType", "", "(Landroid/view/View;I)V", "bgIv", "Lcom/tencent/mm/plugin/card/widget/MemberCardTopCropImageView;", "getBgIv", "()Lcom/tencent/mm/plugin/card/widget/MemberCardTopCropImageView;", "setBgIv", "(Lcom/tencent/mm/plugin/card/widget/MemberCardTopCropImageView;)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "logoIv", "Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "getLogoIv", "()Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "setLogoIv", "(Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;)V", "mViewHeight", "mViewWidth", "rightLabelLayout", "Landroid/widget/LinearLayout;", "getRightLabelLayout", "()Landroid/widget/LinearLayout;", "setRightLabelLayout", "(Landroid/widget/LinearLayout;)V", "shadowIv", "Landroid/widget/ImageView;", "getShadowIv", "()Landroid/widget/ImageView;", "setShadowIv", "(Landroid/widget/ImageView;)V", "titleTv", "getTitleTv", "setTitleTv", "setCardBg", "", "imageView", "url", "", "radius", "", "setModel", "model", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "labelLayout", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends RecyclerView.v
{
  public TextView descTv;
  private int mViewHeight;
  private int mViewWidth;
  public TextView titleTv;
  public CdnImageView wGP;
  public MemberCardTopCropImageView wGQ;
  public LinearLayout wGR;
  public ImageView wGS;
  
  public c(View paramView, int paramInt)
  {
    super(paramView);
    AppMethodBeat.i(112556);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(112556);
      return;
      paramView = paramView.findViewById(a.d.wgT);
      s.s(paramView, "itemView.findViewById(R.id.card_list_header_text)");
      setTitleTv((TextView)paramView);
      AppMethodBeat.o(112556);
      return;
      Object localObject = paramView.findViewById(a.d.wjn);
      s.s(localObject, "itemView.findViewById(R.id.clni_icon_iv)");
      b((CdnImageView)localObject);
      localObject = paramView.findViewById(a.d.wjp);
      s.s(localObject, "itemView.findViewById(R.id.clni_title_tv)");
      setTitleTv((TextView)localObject);
      aw.a((Paint)getTitleTv().getPaint(), 0.8F);
      paramView = paramView.findViewById(a.d.wjm);
      s.s(paramView, "itemView.findViewById(R.id.clni_desc_tv)");
      setDescTv((TextView)paramView);
      dop().setUseSdcardCache(true);
      AppMethodBeat.o(112556);
      return;
      localObject = paramView.findViewById(a.d.wjP);
      s.s(localObject, "itemView.findViewById(R.id.ctci_logo_iv)");
      b((CdnImageView)localObject);
      localObject = paramView.findViewById(a.d.wjR);
      s.s(localObject, "itemView.findViewById(R.id.ctci_title_tv)");
      setTitleTv((TextView)localObject);
      aw.a((Paint)getTitleTv().getPaint(), 0.8F);
      localObject = paramView.findViewById(a.d.wjO);
      s.s(localObject, "itemView.findViewById(R.id.ctci_desc_tv)");
      setDescTv((TextView)localObject);
      localObject = paramView.findViewById(a.d.wjM);
      s.s(localObject, "itemView.findViewById(R.id.ctci_bg_iv)");
      localObject = (MemberCardTopCropImageView)localObject;
      s.u(localObject, "<set-?>");
      this.wGQ = ((MemberCardTopCropImageView)localObject);
      localObject = paramView.findViewById(a.d.wjN);
      s.s(localObject, "itemView.findViewById(R.id.ctci_bg_shadow_iv)");
      localObject = (ImageView)localObject;
      s.u(localObject, "<set-?>");
      this.wGS = ((ImageView)localObject);
      paramView = paramView.findViewById(a.d.wjQ);
      s.s(paramView, "itemView.findViewById(R.….ctci_right_label_layout)");
      paramView = (LinearLayout)paramView;
      s.u(paramView, "<set-?>");
      this.wGR = paramView;
      dop().setUseSdcardCache(true);
      AppMethodBeat.o(112556);
      return;
      localObject = paramView.findViewById(a.d.wjp);
      s.s(localObject, "itemView.findViewById(R.id.clni_title_tv)");
      setTitleTv((TextView)localObject);
      aw.a((Paint)getTitleTv().getPaint(), 0.8F);
      paramView = paramView.findViewById(a.d.wjm);
      s.s(paramView, "itemView.findViewById(R.id.clni_desc_tv)");
      setDescTv((TextView)paramView);
    }
  }
  
  private static final void a(c paramc, kotlin.g.a.a parama)
  {
    AppMethodBeat.i(294206);
    s.u(paramc, "this$0");
    s.u(parama, "$func");
    paramc.mViewHeight = paramc.caK.getHeight();
    paramc.mViewWidth = paramc.caK.getWidth();
    parama.invoke();
    AppMethodBeat.o(294206);
  }
  
  private void b(CdnImageView paramCdnImageView)
  {
    AppMethodBeat.i(294159);
    s.u(paramCdnImageView, "<set-?>");
    this.wGP = paramCdnImageView;
    AppMethodBeat.o(294159);
  }
  
  private CdnImageView dop()
  {
    AppMethodBeat.i(294151);
    CdnImageView localCdnImageView = this.wGP;
    if (localCdnImageView != null)
    {
      AppMethodBeat.o(294151);
      return localCdnImageView;
    }
    s.bIx("logoIv");
    AppMethodBeat.o(294151);
    return null;
  }
  
  private LinearLayout dor()
  {
    AppMethodBeat.i(294198);
    LinearLayout localLinearLayout = this.wGR;
    if (localLinearLayout != null)
    {
      AppMethodBeat.o(294198);
      return localLinearLayout;
    }
    s.bIx("rightLabelLayout");
    AppMethodBeat.o(294198);
    return null;
  }
  
  private TextView getDescTv()
  {
    AppMethodBeat.i(294179);
    TextView localTextView = this.descTv;
    if (localTextView != null)
    {
      AppMethodBeat.o(294179);
      return localTextView;
    }
    s.bIx("descTv");
    AppMethodBeat.o(294179);
    return null;
  }
  
  private TextView getTitleTv()
  {
    AppMethodBeat.i(294168);
    TextView localTextView = this.titleTv;
    if (localTextView != null)
    {
      AppMethodBeat.o(294168);
      return localTextView;
    }
    s.bIx("titleTv");
    AppMethodBeat.o(294168);
    return null;
  }
  
  private void setDescTv(TextView paramTextView)
  {
    AppMethodBeat.i(294189);
    s.u(paramTextView, "<set-?>");
    this.descTv = paramTextView;
    AppMethodBeat.o(294189);
  }
  
  private void setTitleTv(TextView paramTextView)
  {
    AppMethodBeat.i(294172);
    s.u(paramTextView, "<set-?>");
    this.titleTv = paramTextView;
    AppMethodBeat.o(294172);
  }
  
  public final void a(final b paramb)
  {
    AppMethodBeat.i(294238);
    s.u(paramb, "model");
    switch (paramb.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(294238);
      return;
      getTitleTv().setText((CharSequence)paramb.title);
      AppMethodBeat.o(294238);
      return;
      paramb = paramb.wGD;
      if (paramb != null)
      {
        if (!Util.isNullOrNil(paramb.abfK)) {
          dop().iz(paramb.abfK, a.f.card_default_merchant_icon);
        }
        for (;;)
        {
          getTitleTv().setText((CharSequence)paramb.abfJ);
          getDescTv().setText((CharSequence)paramb.abfL);
          AppMethodBeat.o(294238);
          return;
          dop().setImageResource(a.f.card_default_merchant_icon);
        }
        paramb = paramb.wGE;
        if (paramb != null)
        {
          Object localObject1 = doq().getTag();
          Object localObject2 = paramb.YBH;
          if (((localObject1 instanceof String)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (localObject1.equals(localObject2)))
          {
            AppMethodBeat.o(294238);
            return;
          }
          doq().setTag(localObject2);
          dop().setRoundCorner(true);
          if (!Util.isNullOrNil(paramb.abfE)) {
            dop().iz(paramb.abfE, a.f.card_default_merchant_icon);
          }
          for (;;)
          {
            getTitleTv().setText((CharSequence)paramb.abfC);
            getDescTv().setText((CharSequence)paramb.abfD);
            if ((paramb.abfF != 1) && (paramb.abfF != 3) && (paramb.abfF != 4)) {
              break;
            }
            doq().setVisibility(4);
            dos().setVisibility(4);
            this.caK.setBackground(this.caK.getContext().getResources().getDrawable(a.c.wep));
            getTitleTv().setTextColor(Color.parseColor("#555555"));
            getTitleTv().setShadowLayer(0.0F, 0.0F, 0.0F, com.tencent.mm.cd.a.w(this.caK.getContext(), a.a.transparent));
            getDescTv().setTextColor(Color.parseColor("#555555"));
            getDescTv().setShadowLayer(0.0F, 0.0F, 0.0F, com.tencent.mm.cd.a.w(this.caK.getContext(), a.a.transparent));
            AppMethodBeat.o(294238);
            return;
            dop().setImageResource(a.f.card_default_merchant_icon);
          }
          getTitleTv().setTextColor(-1);
          getDescTv().setTextColor(com.tencent.mm.cd.a.w(doq().getContext(), a.a.BW_100_Alpha_0_8));
          localObject1 = paramb.abfG;
          s.s(localObject1, "ticket_label");
          localObject2 = (List)localObject1;
          localObject1 = dor();
          s.u(localObject2, "couponLabelList");
          s.u(localObject1, "labelLayout");
          ((LinearLayout)localObject1).removeAllViews();
          label635:
          int i;
          if (((List)localObject2).isEmpty())
          {
            ((LinearLayout)localObject1).setVisibility(4);
            paramb = (kotlin.g.a.a)new a(this, paramb);
            if ((this.mViewHeight <= 0) || (this.mViewWidth <= 0))
            {
              this.mViewHeight = this.caK.getHeight();
              this.mViewWidth = this.caK.getWidth();
              if ((this.mViewHeight <= 0) || (this.mViewWidth <= 0))
              {
                this.caK.post(new c..ExternalSyntheticLambda0(this, paramb));
                AppMethodBeat.o(294238);
              }
            }
          }
          else
          {
            ((LinearLayout)localObject1).setVisibility(0);
            localObject2 = ((List)localObject2).iterator();
            CardTagTextView localCardTagTextView;
            while (((Iterator)localObject2).hasNext())
            {
              vs localvs = (vs)((Iterator)localObject2).next();
              if (!Util.isNullOrNil(localvs.ZbR))
              {
                localCardTagTextView = new CardTagTextView(dor().getContext());
                Context localContext = ((LinearLayout)localObject1).getContext();
                localCardTagTextView.setMinHeight(com.tencent.mm.cd.a.fromDPToPix(localContext, 18));
                i = com.tencent.mm.cd.a.fromDPToPix(localContext, 8);
                int j = com.tencent.mm.cd.a.fromDPToPix(localContext, 4);
                localCardTagTextView.setPadding(i, j, i, j);
                localCardTagTextView.setText((CharSequence)localvs.ZbR);
                localCardTagTextView.setTextSize(1, 10.0F);
                if (Util.isNullOrNil(localvs.ZbS)) {
                  break label815;
                }
                localCardTagTextView.setTextColor(Color.parseColor(localvs.ZbS));
                label773:
                if (Util.isNullOrNil(localvs.ZbT)) {
                  break label824;
                }
                localCardTagTextView.setFillColor(l.dO(localvs.ZbT, localvs.ZbW));
              }
            }
            for (;;)
            {
              ((LinearLayout)localObject1).addView((View)localCardTagTextView);
              break label635;
              break;
              label815:
              localCardTagTextView.setTextColor(-1);
              break label773;
              label824:
              localCardTagTextView.setFillColor(l.gy(-16777216, 26));
            }
          }
          paramb.invoke();
          AppMethodBeat.o(294238);
          return;
          paramb = paramb.wGF;
          if (paramb != null)
          {
            getTitleTv().setText((CharSequence)paramb.aaUm);
            localObject1 = (CharSequence)paramb.aaUo;
            if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
            for (i = 1; i == 0; i = 0)
            {
              getDescTv().setText((CharSequence)paramb.aaUo);
              getDescTv().setVisibility(0);
              AppMethodBeat.o(294238);
              return;
            }
            getDescTv().setVisibility(8);
          }
        }
      }
    }
  }
  
  public final MemberCardTopCropImageView doq()
  {
    AppMethodBeat.i(294225);
    MemberCardTopCropImageView localMemberCardTopCropImageView = this.wGQ;
    if (localMemberCardTopCropImageView != null)
    {
      AppMethodBeat.o(294225);
      return localMemberCardTopCropImageView;
    }
    s.bIx("bgIv");
    AppMethodBeat.o(294225);
    return null;
  }
  
  public final ImageView dos()
  {
    AppMethodBeat.i(294229);
    ImageView localImageView = this.wGS;
    if (localImageView != null)
    {
      AppMethodBeat.o(294229);
      return localImageView;
    }
    s.bIx("shadowIv");
    AppMethodBeat.o(294229);
    return null;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(c paramc, eal parameal)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.c
 * JD-Core Version:    0.7.0.1
 */