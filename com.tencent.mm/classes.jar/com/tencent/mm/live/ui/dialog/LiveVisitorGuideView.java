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
import com.tencent.mm.live.b.d;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.b.g;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.xweb.aa;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/ui/dialog/LiveVisitorGuideView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionBtn", "Landroid/widget/Button;", "actionGroup", "Landroid/view/View;", "actionIcon", "Landroid/widget/ImageView;", "actionTv", "Landroid/widget/TextView;", "contentGroup", "isAcceptAgreement", "", "maskView", "onHideListener", "Lkotlin/Function0;", "", "getOnHideListener", "()Lkotlin/jvm/functions/Function0;", "setOnHideListener", "(Lkotlin/jvm/functions/Function0;)V", "onOkListener", "getOnOkListener", "setOnOkListener", "titleIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "webView", "Lcom/tencent/mm/ui/widget/MMWebView;", "setupAction", "setupContentView", "setupMask", "setupTitle", "plugin-logic_release"})
public final class LiveVisitorGuideView
  extends RelativeLayout
{
  private final ImageView kJV;
  private final TextView kJW;
  private final Button kJX;
  private final WeImageView kJY;
  private final View kJZ;
  private final View kKa;
  private boolean kKb;
  private kotlin.g.a.a<x> kKc;
  private kotlin.g.a.a<x> kKd;
  private final View maskView;
  private final MMWebView webView;
  
  public LiveVisitorGuideView(Context paramContext)
  {
    this(paramContext, null, 0);
    AppMethodBeat.i(188688);
    AppMethodBeat.o(188688);
  }
  
  public LiveVisitorGuideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(188690);
    AppMethodBeat.o(188690);
  }
  
  public LiveVisitorGuideView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(188686);
    View.inflate(paramContext, b.f.live_visitor_guide_view, (ViewGroup)this);
    paramAttributeSet = MMWebView.a.a(paramContext, (View)this, b.e.live_visitor_guide_content);
    p.j(paramAttributeSet, "MMWebView.Factory.findVi…ve_visitor_guide_content)");
    this.webView = paramAttributeSet;
    paramAttributeSet = findViewById(b.e.live_visitor_guide_action_icon);
    p.j(paramAttributeSet, "findViewById(R.id.live_visitor_guide_action_icon)");
    this.kJV = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(b.e.live_visitor_guide_action_tv);
    p.j(paramAttributeSet, "findViewById(R.id.live_visitor_guide_action_tv)");
    this.kJW = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(b.e.live_visitor_guide_action_btn);
    p.j(paramAttributeSet, "findViewById(R.id.live_visitor_guide_action_btn)");
    this.kJX = ((Button)paramAttributeSet);
    paramAttributeSet = findViewById(b.e.live_visitor_guide_title_icon);
    p.j(paramAttributeSet, "findViewById(R.id.live_visitor_guide_title_icon)");
    this.kJY = ((WeImageView)paramAttributeSet);
    paramAttributeSet = findViewById(b.e.live_visitor_guide_action_desc_group);
    p.j(paramAttributeSet, "findViewById(R.id.live_v…_guide_action_desc_group)");
    this.kJZ = paramAttributeSet;
    paramAttributeSet = findViewById(b.e.live_visitor_guide_content_group);
    p.j(paramAttributeSet, "findViewById(R.id.live_v…itor_guide_content_group)");
    this.kKa = paramAttributeSet;
    paramAttributeSet = findViewById(b.e.live_visitor_guide_mask);
    p.j(paramAttributeSet, "findViewById(R.id.live_visitor_guide_mask)");
    this.maskView = paramAttributeSet;
    this.kKa.getLayoutParams().height = (ax.au(paramContext).y * 3 / 4);
    paramContext = this.webView.getSettings();
    p.j(paramContext, "webView.getSettings()");
    paramContext.setJavaScriptEnabled(true);
    paramContext = this.webView;
    paramAttributeSet = com.tencent.mm.live.b.l.kuj;
    paramContext.loadUrl(com.tencent.mm.live.b.l.aNA());
    this.kJY.setOnClickListener((View.OnClickListener)new LiveVisitorGuideView.c(this));
    this.kJV.setImageResource(b.d.checkbox_unselected);
    this.kJZ.setOnClickListener((View.OnClickListener)new a(this));
    this.kJX.setEnabled(false);
    this.kJX.setOnClickListener((View.OnClickListener)new LiveVisitorGuideView.b(this));
    if (ar.isDarkMode())
    {
      paramContext = this.maskView;
      paramAttributeSet = getContext();
      p.j(paramAttributeSet, "context");
      paramContext.setBackground(paramAttributeSet.getResources().getDrawable(b.g.live_visitor_guide_mask_dark));
      AppMethodBeat.o(188686);
      return;
    }
    paramContext = this.maskView;
    paramAttributeSet = getContext();
    p.j(paramAttributeSet, "context");
    paramContext.setBackground(paramAttributeSet.getResources().getDrawable(b.g.live_visitor_guide_mask_normal));
    AppMethodBeat.o(188686);
  }
  
  public final kotlin.g.a.a<x> getOnHideListener()
  {
    return this.kKc;
  }
  
  public final kotlin.g.a.a<x> getOnOkListener()
  {
    return this.kKd;
  }
  
  public final void setOnHideListener(kotlin.g.a.a<x> parama)
  {
    this.kKc = parama;
  }
  
  public final void setOnOkListener(kotlin.g.a.a<x> parama)
  {
    this.kKd = parama;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(LiveVisitorGuideView paramLiveVisitorGuideView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(200653);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/ui/dialog/LiveVisitorGuideView$setupAction$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.kKe;
      boolean bool;
      if (!LiveVisitorGuideView.a(this.kKe))
      {
        bool = true;
        LiveVisitorGuideView.a(paramView, bool);
        if (!LiveVisitorGuideView.a(this.kKe)) {
          break label113;
        }
        LiveVisitorGuideView.b(this.kKe).setImageResource(b.g.checkbox_selected);
        LiveVisitorGuideView.c(this.kKe).setEnabled(true);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveVisitorGuideView$setupAction$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(200653);
        return;
        bool = false;
        break;
        label113:
        LiveVisitorGuideView.b(this.kKe).setImageResource(b.d.checkbox_unselected);
        LiveVisitorGuideView.c(this.kKe).setEnabled(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.ui.dialog.LiveVisitorGuideView
 * JD-Core Version:    0.7.0.1
 */