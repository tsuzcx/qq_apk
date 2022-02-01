package com.tencent.mm.plugin.card.ui.v2;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.cyp;
import com.tencent.mm.ui.ao;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/ui/v2/CardTicketVH;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "viewType", "", "(Landroid/view/View;I)V", "bgIv", "Lcom/tencent/mm/plugin/card/widget/MemberCardTopCropImageView;", "getBgIv", "()Lcom/tencent/mm/plugin/card/widget/MemberCardTopCropImageView;", "setBgIv", "(Lcom/tencent/mm/plugin/card/widget/MemberCardTopCropImageView;)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "logoIv", "Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "getLogoIv", "()Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "setLogoIv", "(Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;)V", "mViewHeight", "mViewWidth", "rightLabelLayout", "Landroid/widget/LinearLayout;", "getRightLabelLayout", "()Landroid/widget/LinearLayout;", "setRightLabelLayout", "(Landroid/widget/LinearLayout;)V", "shadowIv", "Landroid/widget/ImageView;", "getShadowIv", "()Landroid/widget/ImageView;", "setShadowIv", "(Landroid/widget/ImageView;)V", "titleTv", "getTitleTv", "setTitleTv", "setCardBg", "", "imageView", "url", "", "radius", "", "setModel", "model", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "labelLayout", "plugin-card_release"})
public final class c
  extends RecyclerView.v
{
  int aYN;
  int aYO;
  public TextView hPW;
  public CdnImageView qgQ;
  public MemberCardTopCropImageView qgR;
  public LinearLayout qgS;
  public ImageView qgT;
  public TextView titleTv;
  
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
      paramView = paramView.findViewById(2131298159);
      p.g(paramView, "itemView.findViewById(R.id.card_list_header_text)");
      this.titleTv = ((TextView)paramView);
      AppMethodBeat.o(112556);
      return;
      Object localObject = paramView.findViewById(2131298761);
      p.g(localObject, "itemView.findViewById(R.id.clni_icon_iv)");
      this.qgQ = ((CdnImageView)localObject);
      localObject = paramView.findViewById(2131298762);
      p.g(localObject, "itemView.findViewById(R.id.clni_title_tv)");
      this.titleTv = ((TextView)localObject);
      localObject = this.titleTv;
      if (localObject == null) {
        p.btv("titleTv");
      }
      ao.a((Paint)((TextView)localObject).getPaint(), 0.8F);
      paramView = paramView.findViewById(2131298760);
      p.g(paramView, "itemView.findViewById(R.id.clni_desc_tv)");
      this.hPW = ((TextView)paramView);
      paramView = this.qgQ;
      if (paramView == null) {
        p.btv("logoIv");
      }
      paramView.setUseSdcardCache(true);
      AppMethodBeat.o(112556);
      return;
      localObject = paramView.findViewById(2131299365);
      p.g(localObject, "itemView.findViewById(R.id.ctci_logo_iv)");
      this.qgQ = ((CdnImageView)localObject);
      localObject = paramView.findViewById(2131299367);
      p.g(localObject, "itemView.findViewById(R.id.ctci_title_tv)");
      this.titleTv = ((TextView)localObject);
      localObject = this.titleTv;
      if (localObject == null) {
        p.btv("titleTv");
      }
      ao.a((Paint)((TextView)localObject).getPaint(), 0.8F);
      localObject = paramView.findViewById(2131299364);
      p.g(localObject, "itemView.findViewById(R.id.ctci_desc_tv)");
      this.hPW = ((TextView)localObject);
      localObject = paramView.findViewById(2131299362);
      p.g(localObject, "itemView.findViewById(R.id.ctci_bg_iv)");
      this.qgR = ((MemberCardTopCropImageView)localObject);
      localObject = paramView.findViewById(2131299363);
      p.g(localObject, "itemView.findViewById(R.id.ctci_bg_shadow_iv)");
      this.qgT = ((ImageView)localObject);
      paramView = paramView.findViewById(2131299366);
      p.g(paramView, "itemView.findViewById(R.….ctci_right_label_layout)");
      this.qgS = ((LinearLayout)paramView);
      paramView = this.qgQ;
      if (paramView == null) {
        p.btv("logoIv");
      }
      paramView.setUseSdcardCache(true);
      AppMethodBeat.o(112556);
      return;
      localObject = paramView.findViewById(2131298762);
      p.g(localObject, "itemView.findViewById(R.id.clni_title_tv)");
      this.titleTv = ((TextView)localObject);
      localObject = this.titleTv;
      if (localObject == null) {
        p.btv("titleTv");
      }
      ao.a((Paint)((TextView)localObject).getPaint(), 0.8F);
      paramView = paramView.findViewById(2131298760);
      p.g(paramView, "itemView.findViewById(R.id.clni_desc_tv)");
      this.hPW = ((TextView)paramView);
    }
  }
  
  public final MemberCardTopCropImageView cxj()
  {
    AppMethodBeat.i(201427);
    MemberCardTopCropImageView localMemberCardTopCropImageView = this.qgR;
    if (localMemberCardTopCropImageView == null) {
      p.btv("bgIv");
    }
    AppMethodBeat.o(201427);
    return localMemberCardTopCropImageView;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/card/ui/v2/CardTicketVH$setModel$1$2$func$1", "com/tencent/mm/plugin/card/ui/v2/CardTicketVH$$special$$inlined$apply$lambda$1"})
  static final class a
    extends q
    implements a<x>
  {
    a(cyp paramcyp, c paramc)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/card/ui/v2/CardTicketVH$setModel$1$2$1", "com/tencent/mm/plugin/card/ui/v2/CardTicketVH$$special$$inlined$apply$lambda$2"})
  static final class b
    implements Runnable
  {
    b(a parama, c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(201426);
      c localc = this.qgV;
      View localView = this.qgV.aus;
      p.g(localView, "itemView");
      c.a(localc, localView.getHeight());
      localc = this.qgV;
      localView = this.qgV.aus;
      p.g(localView, "itemView");
      c.b(localc, localView.getWidth());
      this.qgW.invoke();
      AppMethodBeat.o(201426);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.c
 * JD-Core Version:    0.7.0.1
 */