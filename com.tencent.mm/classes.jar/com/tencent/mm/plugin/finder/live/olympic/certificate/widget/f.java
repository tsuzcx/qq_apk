package com.tencent.mm.plugin.finder.live.olympic.certificate.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.q;
import com.tencent.d.a.a.a.b.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.ui.aw;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/certificate/widget/CertificateNegativeWidget;", "Lcom/tencent/mm/plugin/finder/live/olympic/certificate/widget/BaseCertificateWidget;", "Lcom/tencent/mm/plugin/finder/live/olympic/data/OlympicDeliveyData;", "root", "Landroid/view/ViewGroup;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "(Landroid/view/ViewGroup;Landroidx/lifecycle/LifecycleOwner;)V", "certificateAcceptTorchLayout", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "certificateDeliverTorchLayout", "certificateLayoutNegative", "certificateLogo", "Landroid/widget/ImageView;", "certificateLogoSmall", "deliverNumber", "Landroid/widget/TextView;", "userHead", "userName", "adjustLayout", "", "getLayoutView", "Landroid/view/View;", "onChanged", "t", "reset", "showAcceptTorchLayout", "showDeliverTorchLayout", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends a<com.tencent.mm.plugin.finder.live.olympic.data.a>
{
  private RelativeLayout CQD;
  private RelativeLayout CQE;
  private ImageView CQF;
  private RelativeLayout CQG;
  private ImageView CQH;
  private ImageView CQI;
  private TextView CQJ;
  private TextView vgb;
  
  public f(ViewGroup paramViewGroup, q paramq)
  {
    super(paramViewGroup, paramq);
    AppMethodBeat.i(360920);
    this.CQD = ((RelativeLayout)paramViewGroup.findViewById(p.e.BQc));
    this.CQE = ((RelativeLayout)paramViewGroup.findViewById(p.e.BJH));
    this.CQF = ((ImageView)paramViewGroup.findViewById(p.e.BJz));
    this.CQG = ((RelativeLayout)paramViewGroup.findViewById(p.e.BJG));
    this.CQH = ((ImageView)paramViewGroup.findViewById(p.e.BJA));
    this.CQI = ((ImageView)paramViewGroup.findViewById(p.e.BJD));
    this.vgb = ((TextView)paramViewGroup.findViewById(p.e.BJE));
    this.CQJ = ((TextView)paramViewGroup.findViewById(p.e.BJC));
    paramq = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
    paramq = this.CQH;
    s.s(paramq, "certificateLogoSmall");
    com.tencent.mm.plugin.finder.live.olympic.util.a.a(paramq, b.j.ahph, p.d.BzC);
    paramq = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
    paramq = paramViewGroup.findViewById(p.e.BQd);
    s.s(paramq, "root.findViewById<ImageV…icate_layout_negative_bg)");
    com.tencent.mm.plugin.finder.live.olympic.util.a.a((ImageView)paramq, b.j.ahpe, p.d.Bzx);
    paramq = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
    paramq = paramViewGroup.findViewById(p.e.BQh);
    s.s(paramq, "root.findViewById<ImageV…ertificate_light_block_1)");
    com.tencent.mm.plugin.finder.live.olympic.util.a.a((ImageView)paramq, b.j.ahpl, p.d.BzB);
    paramq = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
    paramq = paramViewGroup.findViewById(p.e.BQi);
    s.s(paramq, "root.findViewById<ImageV…ertificate_light_block_2)");
    com.tencent.mm.plugin.finder.live.olympic.util.a.a((ImageView)paramq, b.j.ahpl, p.d.BzB);
    int i = OT(40);
    int j = getScreenWidth() - i * 2;
    int k = (int)(j / 0.6385282F);
    if ((aw.ato()) || (aw.jkP()))
    {
      int m = OT(295);
      i = OT(462);
      if (j > m) {
        j = m;
      }
    }
    for (;;)
    {
      paramq = this.CQD.getLayoutParams();
      if (paramq == null)
      {
        paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(360920);
        throw paramViewGroup;
      }
      paramq = (ViewGroup.MarginLayoutParams)paramq;
      paramq.width = j;
      paramq.height = i;
      paramq = this.CQF.getLayoutParams();
      if (paramq == null)
      {
        paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(360920);
        throw paramViewGroup;
      }
      paramq = (ViewGroup.MarginLayoutParams)paramq;
      paramq.width = ((int)(j / 2.731482F));
      paramq.height = ((int)(paramq.width / 0.8571429F));
      paramq.topMargin = ((int)(paramq.width / 1.058824F));
      paramq = this.CQH.getLayoutParams();
      if (paramq == null)
      {
        paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(360920);
        throw paramViewGroup;
      }
      paramq = (ViewGroup.MarginLayoutParams)paramq;
      paramq.width = ((int)(j / 4.402985F));
      paramq.height = ((int)(paramq.width / 0.8375F));
      paramq.topMargin = ((int)(paramq.width / 2.454546F));
      paramq = this.CQI.getLayoutParams();
      if (paramq == null)
      {
        paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(360920);
        throw paramViewGroup;
      }
      paramq = (ViewGroup.MarginLayoutParams)paramq;
      paramq.width = ((int)(j / 5.267857F));
      paramq.height = paramq.width;
      paramq.topMargin = paramq.width;
      enV();
      getLayoutView().setCameraDistance(paramViewGroup.getContext().getResources().getDisplayMetrics().density * 5000.0F);
      AppMethodBeat.o(360920);
      return;
      i = k;
    }
  }
  
  final void enV()
  {
    AppMethodBeat.i(360938);
    this.CQE.setVisibility(0);
    this.CQG.setVisibility(8);
    AppMethodBeat.o(360938);
  }
  
  public final View getLayoutView()
  {
    AppMethodBeat.i(360945);
    Object localObject = this.CQD;
    s.s(localObject, "certificateLayoutNegative");
    localObject = (View)localObject;
    AppMethodBeat.o(360945);
    return localObject;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(371589);
    enV();
    AppMethodBeat.o(371589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.certificate.widget.f
 * JD-Core Version:    0.7.0.1
 */