package com.tencent.mm.live.ui.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.live.b.f;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/ui/dialog/LiveVisitorGuideView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionBtn", "Landroid/widget/Button;", "actionGroup", "Landroid/view/View;", "actionIcon", "Landroid/widget/ImageView;", "actionTv", "Landroid/widget/TextView;", "contentGroup", "isAcceptAgreement", "", "maskView", "onHideListener", "Lkotlin/Function0;", "", "getOnHideListener", "()Lkotlin/jvm/functions/Function0;", "setOnHideListener", "(Lkotlin/jvm/functions/Function0;)V", "onOkListener", "getOnOkListener", "setOnOkListener", "titleIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "webView", "Lcom/tencent/mm/ui/widget/MMWebView;", "setupAction", "setupContentView", "setupMask", "setupTitle", "plugin-logic_release"})
public final class LiveVisitorGuideView
  extends RelativeLayout
{
  private final MMWebView hcA;
  private final ImageView hcB;
  private final TextView hcC;
  private final Button hcD;
  private final WeImageView hcE;
  private final View hcF;
  private final View hcG;
  private final View hcH;
  private boolean hcI;
  private d.g.a.a<d.z> hcJ;
  private d.g.a.a<d.z> hcK;
  
  public LiveVisitorGuideView(Context paramContext)
  {
    this(paramContext, null, 0);
    AppMethodBeat.i(216523);
    AppMethodBeat.o(216523);
  }
  
  public LiveVisitorGuideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(216524);
    AppMethodBeat.o(216524);
  }
  
  public LiveVisitorGuideView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(216522);
    View.inflate(paramContext, 2131496352, (ViewGroup)this);
    paramAttributeSet = MMWebView.a.a(paramContext, (View)this, 2131307844);
    p.g(paramAttributeSet, "MMWebView.Factory.findVi…ve_visitor_guide_content)");
    this.hcA = paramAttributeSet;
    paramAttributeSet = findViewById(2131307842);
    p.g(paramAttributeSet, "findViewById(R.id.live_visitor_guide_action_icon)");
    this.hcB = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131307843);
    p.g(paramAttributeSet, "findViewById(R.id.live_visitor_guide_action_tv)");
    this.hcC = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131307839);
    p.g(paramAttributeSet, "findViewById(R.id.live_visitor_guide_action_btn)");
    this.hcD = ((Button)paramAttributeSet);
    paramAttributeSet = findViewById(2131307848);
    p.g(paramAttributeSet, "findViewById(R.id.live_visitor_guide_title_icon)");
    this.hcE = ((WeImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131307840);
    p.g(paramAttributeSet, "findViewById(R.id.live_v…_guide_action_desc_group)");
    this.hcF = paramAttributeSet;
    paramAttributeSet = findViewById(2131307845);
    p.g(paramAttributeSet, "findViewById(R.id.live_v…itor_guide_content_group)");
    this.hcG = paramAttributeSet;
    paramAttributeSet = findViewById(2131307846);
    p.g(paramAttributeSet, "findViewById(R.id.live_visitor_guide_mask)");
    this.hcH = paramAttributeSet;
    this.hcG.getLayoutParams().height = (ar.ck(paramContext).y * 3 / 4);
    paramContext = this.hcA.getSettings();
    p.g(paramContext, "webView.getSettings()");
    paramContext.setJavaScriptEnabled(true);
    paramContext = this.hcA;
    paramAttributeSet = f.gPE;
    paramContext.loadUrl(f.anj());
    this.hcE.setOnClickListener((View.OnClickListener)new c(this));
    this.hcB.setImageResource(2131231750);
    this.hcF.setOnClickListener((View.OnClickListener)new a(this));
    this.hcD.setEnabled(false);
    this.hcD.setOnClickListener((View.OnClickListener)new b(this));
    if (al.isDarkMode())
    {
      paramContext = this.hcH;
      paramAttributeSet = getContext();
      p.g(paramAttributeSet, "context");
      paramContext.setBackground(paramAttributeSet.getResources().getDrawable(2131691548));
      AppMethodBeat.o(216522);
      return;
    }
    paramContext = this.hcH;
    paramAttributeSet = getContext();
    p.g(paramAttributeSet, "context");
    paramContext.setBackground(paramAttributeSet.getResources().getDrawable(2131691549));
    AppMethodBeat.o(216522);
  }
  
  public final d.g.a.a<d.z> getOnHideListener()
  {
    return this.hcJ;
  }
  
  public final d.g.a.a<d.z> getOnOkListener()
  {
    return this.hcK;
  }
  
  public final void setOnHideListener(d.g.a.a<d.z> parama)
  {
    this.hcJ = parama;
  }
  
  public final void setOnOkListener(d.g.a.a<d.z> parama)
  {
    this.hcK = parama;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(LiveVisitorGuideView paramLiveVisitorGuideView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216519);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/dialog/LiveVisitorGuideView$setupAction$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = this.hcL;
      boolean bool;
      if (!LiveVisitorGuideView.a(this.hcL))
      {
        bool = true;
        LiveVisitorGuideView.a(paramView, bool);
        if (!LiveVisitorGuideView.a(this.hcL)) {
          break label112;
        }
        LiveVisitorGuideView.b(this.hcL).setImageResource(2131689936);
        LiveVisitorGuideView.c(this.hcL).setEnabled(true);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveVisitorGuideView$setupAction$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(216519);
        return;
        bool = false;
        break;
        label112:
        LiveVisitorGuideView.b(this.hcL).setImageResource(2131231750);
        LiveVisitorGuideView.c(this.hcL).setEnabled(false);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(LiveVisitorGuideView paramLiveVisitorGuideView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216520);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/dialog/LiveVisitorGuideView$setupAction$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = this.hcL.getOnOkListener();
      if (paramView != null) {
        paramView.invoke();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveVisitorGuideView$setupAction$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216520);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(LiveVisitorGuideView paramLiveVisitorGuideView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216521);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/dialog/LiveVisitorGuideView$setupTitle$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = this.hcL.getOnHideListener();
      if (paramView != null) {
        paramView.invoke();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveVisitorGuideView$setupTitle$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216521);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.ui.dialog.LiveVisitorGuideView
 * JD-Core Version:    0.7.0.1
 */