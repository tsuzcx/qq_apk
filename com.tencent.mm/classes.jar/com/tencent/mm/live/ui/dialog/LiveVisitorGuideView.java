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
import com.tencent.mm.live.b.o;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.xweb.z;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/ui/dialog/LiveVisitorGuideView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionBtn", "Landroid/widget/Button;", "actionGroup", "Landroid/view/View;", "actionIcon", "Landroid/widget/ImageView;", "actionTv", "Landroid/widget/TextView;", "contentGroup", "isAcceptAgreement", "", "maskView", "onHideListener", "Lkotlin/Function0;", "", "getOnHideListener", "()Lkotlin/jvm/functions/Function0;", "setOnHideListener", "(Lkotlin/jvm/functions/Function0;)V", "onOkListener", "getOnOkListener", "setOnOkListener", "titleIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "webView", "Lcom/tencent/mm/ui/widget/MMWebView;", "setupAction", "setupContentView", "setupMask", "setupTitle", "plugin-logic_release"})
public final class LiveVisitorGuideView
  extends RelativeLayout
{
  private boolean hVA;
  private kotlin.g.a.a<x> hVB;
  private kotlin.g.a.a<x> hVC;
  private final ImageView hVu;
  private final TextView hVv;
  private final Button hVw;
  private final WeImageView hVx;
  private final View hVy;
  private final View hVz;
  private final View maskView;
  private final MMWebView webView;
  
  public LiveVisitorGuideView(Context paramContext)
  {
    this(paramContext, null, 0);
    AppMethodBeat.i(208484);
    AppMethodBeat.o(208484);
  }
  
  public LiveVisitorGuideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(208485);
    AppMethodBeat.o(208485);
  }
  
  public LiveVisitorGuideView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(208483);
    View.inflate(paramContext, 2131495292, (ViewGroup)this);
    paramAttributeSet = MMWebView.a.a(paramContext, (View)this, 2131303632);
    p.g(paramAttributeSet, "MMWebView.Factory.findVi…ve_visitor_guide_content)");
    this.webView = paramAttributeSet;
    paramAttributeSet = findViewById(2131303630);
    p.g(paramAttributeSet, "findViewById(R.id.live_visitor_guide_action_icon)");
    this.hVu = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131303631);
    p.g(paramAttributeSet, "findViewById(R.id.live_visitor_guide_action_tv)");
    this.hVv = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131303627);
    p.g(paramAttributeSet, "findViewById(R.id.live_visitor_guide_action_btn)");
    this.hVw = ((Button)paramAttributeSet);
    paramAttributeSet = findViewById(2131303636);
    p.g(paramAttributeSet, "findViewById(R.id.live_visitor_guide_title_icon)");
    this.hVx = ((WeImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131303628);
    p.g(paramAttributeSet, "findViewById(R.id.live_v…_guide_action_desc_group)");
    this.hVy = paramAttributeSet;
    paramAttributeSet = findViewById(2131303633);
    p.g(paramAttributeSet, "findViewById(R.id.live_v…itor_guide_content_group)");
    this.hVz = paramAttributeSet;
    paramAttributeSet = findViewById(2131303634);
    p.g(paramAttributeSet, "findViewById(R.id.live_visitor_guide_mask)");
    this.maskView = paramAttributeSet;
    this.hVz.getLayoutParams().height = (au.az(paramContext).y * 3 / 4);
    paramContext = this.webView.getSettings();
    p.g(paramContext, "webView.getSettings()");
    paramContext.setJavaScriptEnabled(true);
    paramContext = this.webView;
    paramAttributeSet = o.hGl;
    paramContext.loadUrl(o.aFj());
    this.hVx.setOnClickListener((View.OnClickListener)new c(this));
    this.hVu.setImageResource(2131231825);
    this.hVy.setOnClickListener((View.OnClickListener)new a(this));
    this.hVw.setEnabled(false);
    this.hVw.setOnClickListener((View.OnClickListener)new b(this));
    if (ao.isDarkMode())
    {
      paramContext = this.maskView;
      paramAttributeSet = getContext();
      p.g(paramAttributeSet, "context");
      paramContext.setBackground(paramAttributeSet.getResources().getDrawable(2131691016));
      AppMethodBeat.o(208483);
      return;
    }
    paramContext = this.maskView;
    paramAttributeSet = getContext();
    p.g(paramAttributeSet, "context");
    paramContext.setBackground(paramAttributeSet.getResources().getDrawable(2131691017));
    AppMethodBeat.o(208483);
  }
  
  public final kotlin.g.a.a<x> getOnHideListener()
  {
    return this.hVB;
  }
  
  public final kotlin.g.a.a<x> getOnOkListener()
  {
    return this.hVC;
  }
  
  public final void setOnHideListener(kotlin.g.a.a<x> parama)
  {
    this.hVB = parama;
  }
  
  public final void setOnOkListener(kotlin.g.a.a<x> parama)
  {
    this.hVC = parama;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(LiveVisitorGuideView paramLiveVisitorGuideView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(208480);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/dialog/LiveVisitorGuideView$setupAction$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.hVD;
      boolean bool;
      if (!LiveVisitorGuideView.a(this.hVD))
      {
        bool = true;
        LiveVisitorGuideView.a(paramView, bool);
        if (!LiveVisitorGuideView.a(this.hVD)) {
          break label112;
        }
        LiveVisitorGuideView.b(this.hVD).setImageResource(2131689951);
        LiveVisitorGuideView.c(this.hVD).setEnabled(true);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveVisitorGuideView$setupAction$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(208480);
        return;
        bool = false;
        break;
        label112:
        LiveVisitorGuideView.b(this.hVD).setImageResource(2131231825);
        LiveVisitorGuideView.c(this.hVD).setEnabled(false);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(LiveVisitorGuideView paramLiveVisitorGuideView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(208481);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/dialog/LiveVisitorGuideView$setupAction$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.hVD.getOnOkListener();
      if (paramView != null) {
        paramView.invoke();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveVisitorGuideView$setupAction$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(208481);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(LiveVisitorGuideView paramLiveVisitorGuideView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(208482);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/dialog/LiveVisitorGuideView$setupTitle$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.hVD.getOnHideListener();
      if (paramView != null) {
        paramView.invoke();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveVisitorGuideView$setupTitle$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(208482);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.ui.dialog.LiveVisitorGuideView
 * JD-Core Version:    0.7.0.1
 */