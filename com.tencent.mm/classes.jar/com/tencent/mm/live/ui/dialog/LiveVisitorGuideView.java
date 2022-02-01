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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/ui/dialog/LiveVisitorGuideView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionBtn", "Landroid/widget/Button;", "actionGroup", "Landroid/view/View;", "actionIcon", "Landroid/widget/ImageView;", "actionTv", "Landroid/widget/TextView;", "contentGroup", "isAcceptAgreement", "", "maskView", "onHideListener", "Lkotlin/Function0;", "", "getOnHideListener", "()Lkotlin/jvm/functions/Function0;", "setOnHideListener", "(Lkotlin/jvm/functions/Function0;)V", "onOkListener", "getOnOkListener", "setOnOkListener", "titleIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "webView", "Lcom/tencent/mm/ui/widget/MMWebView;", "setupAction", "setupContentView", "setupMask", "setupTitle", "plugin-logic_release"})
public final class LiveVisitorGuideView
  extends RelativeLayout
{
  private final MMWebView gZN;
  private final ImageView gZO;
  private final TextView gZP;
  private final Button gZQ;
  private final WeImageView gZR;
  private final View gZS;
  private final View gZT;
  private final View gZU;
  private boolean gZV;
  private d.g.a.a<d.z> gZW;
  private d.g.a.a<d.z> gZX;
  
  public LiveVisitorGuideView(Context paramContext)
  {
    this(paramContext, null, 0);
    AppMethodBeat.i(212895);
    AppMethodBeat.o(212895);
  }
  
  public LiveVisitorGuideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(212896);
    AppMethodBeat.o(212896);
  }
  
  public LiveVisitorGuideView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(212894);
    View.inflate(paramContext, 2131496352, (ViewGroup)this);
    paramAttributeSet = MMWebView.a.a(paramContext, (View)this, 2131307844);
    p.g(paramAttributeSet, "MMWebView.Factory.findVi…ve_visitor_guide_content)");
    this.gZN = paramAttributeSet;
    paramAttributeSet = findViewById(2131307842);
    p.g(paramAttributeSet, "findViewById(R.id.live_visitor_guide_action_icon)");
    this.gZO = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131307843);
    p.g(paramAttributeSet, "findViewById(R.id.live_visitor_guide_action_tv)");
    this.gZP = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131307839);
    p.g(paramAttributeSet, "findViewById(R.id.live_visitor_guide_action_btn)");
    this.gZQ = ((Button)paramAttributeSet);
    paramAttributeSet = findViewById(2131307848);
    p.g(paramAttributeSet, "findViewById(R.id.live_visitor_guide_title_icon)");
    this.gZR = ((WeImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131307840);
    p.g(paramAttributeSet, "findViewById(R.id.live_v…_guide_action_desc_group)");
    this.gZS = paramAttributeSet;
    paramAttributeSet = findViewById(2131307845);
    p.g(paramAttributeSet, "findViewById(R.id.live_v…itor_guide_content_group)");
    this.gZT = paramAttributeSet;
    paramAttributeSet = findViewById(2131307846);
    p.g(paramAttributeSet, "findViewById(R.id.live_visitor_guide_mask)");
    this.gZU = paramAttributeSet;
    this.gZT.getLayoutParams().height = (ar.ci(paramContext).y * 3 / 4);
    paramContext = this.gZN.getSettings();
    p.g(paramContext, "webView.getSettings()");
    paramContext.setJavaScriptEnabled(true);
    paramContext = this.gZN;
    paramAttributeSet = f.gMV;
    paramContext.loadUrl(f.amU());
    this.gZR.setOnClickListener((View.OnClickListener)new c(this));
    this.gZO.setImageResource(2131231750);
    this.gZS.setOnClickListener((View.OnClickListener)new a(this));
    this.gZQ.setEnabled(false);
    this.gZQ.setOnClickListener((View.OnClickListener)new b(this));
    if (al.isDarkMode())
    {
      paramContext = this.gZU;
      paramAttributeSet = getContext();
      p.g(paramAttributeSet, "context");
      paramContext.setBackground(paramAttributeSet.getResources().getDrawable(2131691548));
      AppMethodBeat.o(212894);
      return;
    }
    paramContext = this.gZU;
    paramAttributeSet = getContext();
    p.g(paramAttributeSet, "context");
    paramContext.setBackground(paramAttributeSet.getResources().getDrawable(2131691549));
    AppMethodBeat.o(212894);
  }
  
  public final d.g.a.a<d.z> getOnHideListener()
  {
    return this.gZW;
  }
  
  public final d.g.a.a<d.z> getOnOkListener()
  {
    return this.gZX;
  }
  
  public final void setOnHideListener(d.g.a.a<d.z> parama)
  {
    this.gZW = parama;
  }
  
  public final void setOnOkListener(d.g.a.a<d.z> parama)
  {
    this.gZX = parama;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(LiveVisitorGuideView paramLiveVisitorGuideView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212891);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/dialog/LiveVisitorGuideView$setupAction$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = this.gZY;
      boolean bool;
      if (!LiveVisitorGuideView.a(this.gZY))
      {
        bool = true;
        LiveVisitorGuideView.a(paramView, bool);
        if (!LiveVisitorGuideView.a(this.gZY)) {
          break label112;
        }
        LiveVisitorGuideView.b(this.gZY).setImageResource(2131689936);
        LiveVisitorGuideView.c(this.gZY).setEnabled(true);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveVisitorGuideView$setupAction$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(212891);
        return;
        bool = false;
        break;
        label112:
        LiveVisitorGuideView.b(this.gZY).setImageResource(2131231750);
        LiveVisitorGuideView.c(this.gZY).setEnabled(false);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(LiveVisitorGuideView paramLiveVisitorGuideView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212892);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/dialog/LiveVisitorGuideView$setupAction$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = this.gZY.getOnOkListener();
      if (paramView != null) {
        paramView.invoke();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveVisitorGuideView$setupAction$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212892);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(LiveVisitorGuideView paramLiveVisitorGuideView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212893);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/dialog/LiveVisitorGuideView$setupTitle$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = this.gZY.getOnHideListener();
      if (paramView != null) {
        paramView.invoke();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveVisitorGuideView$setupTitle$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212893);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.ui.dialog.LiveVisitorGuideView
 * JD-Core Version:    0.7.0.1
 */