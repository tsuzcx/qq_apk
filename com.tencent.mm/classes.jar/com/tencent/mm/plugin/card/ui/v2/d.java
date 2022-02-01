package com.tencent.mm.plugin.card.ui.v2;

import android.graphics.Matrix;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/card/ui/v2/CardTicketVH;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "viewType", "", "(Landroid/view/View;I)V", "bgIv", "Lcom/tencent/mm/plugin/card/widget/MemberCardTopCropImageView;", "getBgIv", "()Lcom/tencent/mm/plugin/card/widget/MemberCardTopCropImageView;", "setBgIv", "(Lcom/tencent/mm/plugin/card/widget/MemberCardTopCropImageView;)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "logoIv", "Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "getLogoIv", "()Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "setLogoIv", "(Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;)V", "rightLabelLayout", "Landroid/widget/LinearLayout;", "getRightLabelLayout", "()Landroid/widget/LinearLayout;", "setRightLabelLayout", "(Landroid/widget/LinearLayout;)V", "shadowIv", "Landroid/widget/ImageView;", "getShadowIv", "()Landroid/widget/ImageView;", "setShadowIv", "(Landroid/widget/ImageView;)V", "titleTv", "getTitleTv", "setTitleTv", "setCardBg", "", "imageView", "url", "", "radius", "", "setModel", "model", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "labelLayout", "plugin-card_release"})
public final class d
  extends RecyclerView.v
{
  public TextView lEA;
  public CdnImageView nGe;
  public MemberCardTopCropImageView nGf;
  public LinearLayout nGg;
  public ImageView nGh;
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
      k.g(paramView, "itemView.findViewById(R.id.card_list_header_text)");
      this.titleTv = ((TextView)paramView);
      AppMethodBeat.o(112556);
      return;
      View localView = paramView.findViewById(2131298358);
      k.g(localView, "itemView.findViewById(R.id.clni_icon_iv)");
      this.nGe = ((CdnImageView)localView);
      localView = paramView.findViewById(2131298359);
      k.g(localView, "itemView.findViewById(R.id.clni_title_tv)");
      this.titleTv = ((TextView)localView);
      paramView = paramView.findViewById(2131298357);
      k.g(paramView, "itemView.findViewById(R.id.clni_desc_tv)");
      this.lEA = ((TextView)paramView);
      paramView = this.nGe;
      if (paramView == null) {
        k.aPZ("logoIv");
      }
      paramView.setUseSdcardCache(true);
      AppMethodBeat.o(112556);
      return;
      localView = paramView.findViewById(2131298890);
      k.g(localView, "itemView.findViewById(R.id.ctci_logo_iv)");
      this.nGe = ((CdnImageView)localView);
      localView = paramView.findViewById(2131298892);
      k.g(localView, "itemView.findViewById(R.id.ctci_title_tv)");
      this.titleTv = ((TextView)localView);
      localView = paramView.findViewById(2131298889);
      k.g(localView, "itemView.findViewById(R.id.ctci_desc_tv)");
      this.lEA = ((TextView)localView);
      localView = paramView.findViewById(2131298887);
      k.g(localView, "itemView.findViewById(R.id.ctci_bg_iv)");
      this.nGf = ((MemberCardTopCropImageView)localView);
      localView = paramView.findViewById(2131298888);
      k.g(localView, "itemView.findViewById(R.id.ctci_bg_shadow_iv)");
      this.nGh = ((ImageView)localView);
      paramView = paramView.findViewById(2131298891);
      k.g(paramView, "itemView.findViewById(R.….ctci_right_label_layout)");
      this.nGg = ((LinearLayout)paramView);
      paramView = this.nGe;
      if (paramView == null) {
        k.aPZ("logoIv");
      }
      paramView.setUseSdcardCache(true);
    }
  }
  
  public static void b(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(112555);
    k.h(paramImageView, "imageView");
    k.h(paramString, "url");
    Object localObject = new c.a();
    ((c.a)localObject).yw(b.aih());
    ((c.a)localObject).a(o.ayK());
    ((c.a)localObject).yv(m.Qy(paramString));
    ((c.a)localObject).ayY();
    ((c.a)localObject).azb();
    ((c.a)localObject).ayX();
    ((c.a)localObject).oq(2131231461);
    ((c.a)localObject).op(com.tencent.mm.cd.a.fromDPToPix(paramImageView.getContext(), 84));
    ((c.a)localObject).oo(com.tencent.mm.cd.a.hV(paramImageView.getContext()));
    localObject = ((c.a)localObject).azc();
    o.ayJ().a(paramString, paramImageView, (c)localObject);
    paramImageView.setImageMatrix(new Matrix());
    AppMethodBeat.o(112555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.d
 * JD-Core Version:    0.7.0.1
 */