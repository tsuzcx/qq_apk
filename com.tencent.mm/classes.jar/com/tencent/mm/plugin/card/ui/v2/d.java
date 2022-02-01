package com.tencent.mm.plugin.card.ui.v2;

import android.graphics.Matrix;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.q;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/ui/v2/CardTicketVH;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "viewType", "", "(Landroid/view/View;I)V", "bgIv", "Lcom/tencent/mm/plugin/card/widget/MemberCardTopCropImageView;", "getBgIv", "()Lcom/tencent/mm/plugin/card/widget/MemberCardTopCropImageView;", "setBgIv", "(Lcom/tencent/mm/plugin/card/widget/MemberCardTopCropImageView;)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "logoIv", "Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "getLogoIv", "()Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "setLogoIv", "(Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;)V", "rightLabelLayout", "Landroid/widget/LinearLayout;", "getRightLabelLayout", "()Landroid/widget/LinearLayout;", "setRightLabelLayout", "(Landroid/widget/LinearLayout;)V", "shadowIv", "Landroid/widget/ImageView;", "getShadowIv", "()Landroid/widget/ImageView;", "setShadowIv", "(Landroid/widget/ImageView;)V", "titleTv", "getTitleTv", "setTitleTv", "setCardBg", "", "imageView", "url", "", "radius", "", "setModel", "model", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "labelLayout", "plugin-card_release"})
public final class d
  extends RecyclerView.w
{
  public TextView gUs;
  public CdnImageView oMB;
  public MemberCardTopCropImageView oMC;
  public LinearLayout oMD;
  public ImageView oME;
  public TextView titleTv;
  
  public d(View paramView, int paramInt)
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
      paramView = paramView.findViewById(2131297843);
      p.g(paramView, "itemView.findViewById(R.id.card_list_header_text)");
      this.titleTv = ((TextView)paramView);
      AppMethodBeat.o(112556);
      return;
      View localView = paramView.findViewById(2131298358);
      p.g(localView, "itemView.findViewById(R.id.clni_icon_iv)");
      this.oMB = ((CdnImageView)localView);
      localView = paramView.findViewById(2131298359);
      p.g(localView, "itemView.findViewById(R.id.clni_title_tv)");
      this.titleTv = ((TextView)localView);
      paramView = paramView.findViewById(2131298357);
      p.g(paramView, "itemView.findViewById(R.id.clni_desc_tv)");
      this.gUs = ((TextView)paramView);
      paramView = this.oMB;
      if (paramView == null) {
        p.bcb("logoIv");
      }
      paramView.setUseSdcardCache(true);
      AppMethodBeat.o(112556);
      return;
      localView = paramView.findViewById(2131298890);
      p.g(localView, "itemView.findViewById(R.id.ctci_logo_iv)");
      this.oMB = ((CdnImageView)localView);
      localView = paramView.findViewById(2131298892);
      p.g(localView, "itemView.findViewById(R.id.ctci_title_tv)");
      this.titleTv = ((TextView)localView);
      localView = paramView.findViewById(2131298889);
      p.g(localView, "itemView.findViewById(R.id.ctci_desc_tv)");
      this.gUs = ((TextView)localView);
      localView = paramView.findViewById(2131298887);
      p.g(localView, "itemView.findViewById(R.id.ctci_bg_iv)");
      this.oMC = ((MemberCardTopCropImageView)localView);
      localView = paramView.findViewById(2131298888);
      p.g(localView, "itemView.findViewById(R.id.ctci_bg_shadow_iv)");
      this.oME = ((ImageView)localView);
      paramView = paramView.findViewById(2131298891);
      p.g(paramView, "itemView.findViewById(R.….ctci_right_label_layout)");
      this.oMD = ((LinearLayout)paramView);
      paramView = this.oMB;
      if (paramView == null) {
        p.bcb("logoIv");
      }
      paramView.setUseSdcardCache(true);
    }
  }
  
  public static void b(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(112555);
    p.h(paramImageView, "imageView");
    p.h(paramString, "url");
    Object localObject = new c.a();
    ((c.a)localObject).FF(b.arU());
    ((c.a)localObject).a(q.aIK());
    ((c.a)localObject).FE(m.Yt(paramString));
    ((c.a)localObject).aIY();
    ((c.a)localObject).aJb();
    ((c.a)localObject).aIX();
    ((c.a)localObject).pH(2131231461);
    ((c.a)localObject).pG(com.tencent.mm.cc.a.fromDPToPix(paramImageView.getContext(), 84));
    ((c.a)localObject).pF(com.tencent.mm.cc.a.ip(paramImageView.getContext()));
    localObject = ((c.a)localObject).aJc();
    q.aIJ().a(paramString, paramImageView, (c)localObject);
    paramImageView.setImageMatrix(new Matrix());
    AppMethodBeat.o(112555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.d
 * JD-Core Version:    0.7.0.1
 */