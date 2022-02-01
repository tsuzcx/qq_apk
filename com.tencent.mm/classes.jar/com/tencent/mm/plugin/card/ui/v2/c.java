package com.tencent.mm.plugin.card.ui.v2;

import android.graphics.Paint;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.dib;
import com.tencent.mm.ui.ar;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/ui/v2/CardTicketVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "viewType", "", "(Landroid/view/View;I)V", "bgIv", "Lcom/tencent/mm/plugin/card/widget/MemberCardTopCropImageView;", "getBgIv", "()Lcom/tencent/mm/plugin/card/widget/MemberCardTopCropImageView;", "setBgIv", "(Lcom/tencent/mm/plugin/card/widget/MemberCardTopCropImageView;)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "logoIv", "Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "getLogoIv", "()Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "setLogoIv", "(Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;)V", "mViewHeight", "mViewWidth", "rightLabelLayout", "Landroid/widget/LinearLayout;", "getRightLabelLayout", "()Landroid/widget/LinearLayout;", "setRightLabelLayout", "(Landroid/widget/LinearLayout;)V", "shadowIv", "Landroid/widget/ImageView;", "getShadowIv", "()Landroid/widget/ImageView;", "setShadowIv", "(Landroid/widget/ImageView;)V", "titleTv", "getTitleTv", "setTitleTv", "setCardBg", "", "imageView", "url", "", "radius", "", "setModel", "model", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "labelLayout", "plugin-card_release"})
public final class c
  extends RecyclerView.v
{
  int aIj;
  int aIk;
  public TextView kEs;
  public CdnImageView tCM;
  public MemberCardTopCropImageView tCN;
  public LinearLayout tCO;
  public ImageView tCP;
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
      paramView = paramView.findViewById(a.d.tcF);
      p.j(paramView, "itemView.findViewById(R.id.card_list_header_text)");
      this.titleTv = ((TextView)paramView);
      AppMethodBeat.o(112556);
      return;
      Object localObject = paramView.findViewById(a.d.teX);
      p.j(localObject, "itemView.findViewById(R.id.clni_icon_iv)");
      this.tCM = ((CdnImageView)localObject);
      localObject = paramView.findViewById(a.d.teY);
      p.j(localObject, "itemView.findViewById(R.id.clni_title_tv)");
      this.titleTv = ((TextView)localObject);
      localObject = this.titleTv;
      if (localObject == null) {
        p.bGy("titleTv");
      }
      ar.a((Paint)((TextView)localObject).getPaint(), 0.8F);
      paramView = paramView.findViewById(a.d.teW);
      p.j(paramView, "itemView.findViewById(R.id.clni_desc_tv)");
      this.kEs = ((TextView)paramView);
      paramView = this.tCM;
      if (paramView == null) {
        p.bGy("logoIv");
      }
      paramView.setUseSdcardCache(true);
      AppMethodBeat.o(112556);
      return;
      localObject = paramView.findViewById(a.d.tfu);
      p.j(localObject, "itemView.findViewById(R.id.ctci_logo_iv)");
      this.tCM = ((CdnImageView)localObject);
      localObject = paramView.findViewById(a.d.tfw);
      p.j(localObject, "itemView.findViewById(R.id.ctci_title_tv)");
      this.titleTv = ((TextView)localObject);
      localObject = this.titleTv;
      if (localObject == null) {
        p.bGy("titleTv");
      }
      ar.a((Paint)((TextView)localObject).getPaint(), 0.8F);
      localObject = paramView.findViewById(a.d.tft);
      p.j(localObject, "itemView.findViewById(R.id.ctci_desc_tv)");
      this.kEs = ((TextView)localObject);
      localObject = paramView.findViewById(a.d.tfr);
      p.j(localObject, "itemView.findViewById(R.id.ctci_bg_iv)");
      this.tCN = ((MemberCardTopCropImageView)localObject);
      localObject = paramView.findViewById(a.d.tfs);
      p.j(localObject, "itemView.findViewById(R.id.ctci_bg_shadow_iv)");
      this.tCP = ((ImageView)localObject);
      paramView = paramView.findViewById(a.d.tfv);
      p.j(paramView, "itemView.findViewById(R.….ctci_right_label_layout)");
      this.tCO = ((LinearLayout)paramView);
      paramView = this.tCM;
      if (paramView == null) {
        p.bGy("logoIv");
      }
      paramView.setUseSdcardCache(true);
      AppMethodBeat.o(112556);
      return;
      localObject = paramView.findViewById(a.d.teY);
      p.j(localObject, "itemView.findViewById(R.id.clni_title_tv)");
      this.titleTv = ((TextView)localObject);
      localObject = this.titleTv;
      if (localObject == null) {
        p.bGy("titleTv");
      }
      ar.a((Paint)((TextView)localObject).getPaint(), 0.8F);
      paramView = paramView.findViewById(a.d.teW);
      p.j(paramView, "itemView.findViewById(R.id.clni_desc_tv)");
      this.kEs = ((TextView)paramView);
    }
  }
  
  public final MemberCardTopCropImageView cKM()
  {
    AppMethodBeat.i(247589);
    MemberCardTopCropImageView localMemberCardTopCropImageView = this.tCN;
    if (localMemberCardTopCropImageView == null) {
      p.bGy("bgIv");
    }
    AppMethodBeat.o(247589);
    return localMemberCardTopCropImageView;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/card/ui/v2/CardTicketVH$setModel$1$2$func$1", "com/tencent/mm/plugin/card/ui/v2/CardTicketVH$$special$$inlined$apply$lambda$1"})
  static final class a
    extends q
    implements a<x>
  {
    a(dib paramdib, c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/card/ui/v2/CardTicketVH$setModel$1$2$1", "com/tencent/mm/plugin/card/ui/v2/CardTicketVH$$special$$inlined$apply$lambda$2"})
  static final class b
    implements Runnable
  {
    b(a parama, c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(246695);
      c localc = this.tCR;
      View localView = this.tCR.amk;
      p.j(localView, "itemView");
      c.a(localc, localView.getHeight());
      localc = this.tCR;
      localView = this.tCR.amk;
      p.j(localView, "itemView");
      c.b(localc, localView.getWidth());
      this.tCS.invoke();
      AppMethodBeat.o(246695);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.c
 * JD-Core Version:    0.7.0.1
 */