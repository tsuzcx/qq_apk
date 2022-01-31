package com.tencent.mm.plugin.card.ui.v2;

import a.f.b.j;
import a.l;
import android.graphics.Matrix;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/card/ui/v2/CardTicketVH;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "viewType", "", "(Landroid/view/View;I)V", "bgIv", "Lcom/tencent/mm/plugin/card/widget/MemberCardTopCropImageView;", "getBgIv", "()Lcom/tencent/mm/plugin/card/widget/MemberCardTopCropImageView;", "setBgIv", "(Lcom/tencent/mm/plugin/card/widget/MemberCardTopCropImageView;)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "logoIv", "Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "getLogoIv", "()Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "setLogoIv", "(Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;)V", "rightLabelLayout", "Landroid/widget/LinearLayout;", "getRightLabelLayout", "()Landroid/widget/LinearLayout;", "setRightLabelLayout", "(Landroid/widget/LinearLayout;)V", "shadowIv", "Landroid/widget/ImageView;", "getShadowIv", "()Landroid/widget/ImageView;", "setShadowIv", "(Landroid/widget/ImageView;)V", "titleTv", "getTitleTv", "setTitleTv", "setCardBg", "", "imageView", "url", "", "radius", "", "setModel", "model", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "labelLayout", "plugin-card_release"})
public final class f
  extends RecyclerView.v
{
  public TextView hsI;
  public CdnImageView kAK;
  public MemberCardTopCropImageView kAL;
  public LinearLayout kAM;
  public ImageView kAN;
  public TextView titleTv;
  
  public f(View paramView, int paramInt)
  {
    super(paramView);
    AppMethodBeat.i(89330);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(89330);
      return;
      paramView = paramView.findViewById(2131822271);
      j.p(paramView, "itemView.findViewById(R.id.card_list_header_text)");
      this.titleTv = ((TextView)paramView);
      AppMethodBeat.o(89330);
      return;
      View localView = paramView.findViewById(2131822261);
      j.p(localView, "itemView.findViewById(R.id.clni_icon_iv)");
      this.kAK = ((CdnImageView)localView);
      localView = paramView.findViewById(2131822262);
      j.p(localView, "itemView.findViewById(R.id.clni_title_tv)");
      this.titleTv = ((TextView)localView);
      paramView = paramView.findViewById(2131822263);
      j.p(paramView, "itemView.findViewById(R.id.clni_desc_tv)");
      this.hsI = ((TextView)paramView);
      paramView = this.kAK;
      if (paramView == null) {
        j.ays("logoIv");
      }
      paramView.setUseSdcardCache(true);
      AppMethodBeat.o(89330);
      return;
      localView = paramView.findViewById(2131822387);
      j.p(localView, "itemView.findViewById(R.id.ctci_logo_iv)");
      this.kAK = ((CdnImageView)localView);
      localView = paramView.findViewById(2131822388);
      j.p(localView, "itemView.findViewById(R.id.ctci_title_tv)");
      this.titleTv = ((TextView)localView);
      localView = paramView.findViewById(2131822389);
      j.p(localView, "itemView.findViewById(R.id.ctci_desc_tv)");
      this.hsI = ((TextView)localView);
      localView = paramView.findViewById(2131822385);
      j.p(localView, "itemView.findViewById(R.id.ctci_bg_iv)");
      this.kAL = ((MemberCardTopCropImageView)localView);
      localView = paramView.findViewById(2131822386);
      j.p(localView, "itemView.findViewById(R.id.ctci_bg_shadow_iv)");
      this.kAN = ((ImageView)localView);
      paramView = paramView.findViewById(2131822390);
      j.p(paramView, "itemView.findViewById(R.….ctci_right_label_layout)");
      this.kAM = ((LinearLayout)paramView);
      paramView = this.kAK;
      if (paramView == null) {
        j.ays("logoIv");
      }
      paramView.setUseSdcardCache(true);
    }
  }
  
  public static void b(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(89329);
    j.q(paramImageView, "imageView");
    j.q(paramString, "url");
    Object localObject = new c.a();
    ((c.a)localObject).tz(e.eQz);
    ((c.a)localObject).a(o.ahH());
    ((c.a)localObject).ty(m.HO(paramString));
    ((c.a)localObject).ahU();
    ((c.a)localObject).ahX();
    ((c.a)localObject).ahT();
    ((c.a)localObject).lH(2130838133);
    ((c.a)localObject).lG(com.tencent.mm.cb.a.fromDPToPix(paramImageView.getContext(), 84));
    ((c.a)localObject).lF(com.tencent.mm.cb.a.gw(paramImageView.getContext()));
    localObject = ((c.a)localObject).ahY();
    o.ahG().a(paramString, paramImageView, (c)localObject);
    paramImageView.setImageMatrix(new Matrix());
    AppMethodBeat.o(89329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.f
 * JD-Core Version:    0.7.0.1
 */