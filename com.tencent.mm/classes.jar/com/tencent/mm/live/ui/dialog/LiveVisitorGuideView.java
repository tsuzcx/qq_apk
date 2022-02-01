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
import com.tencent.mm.live.b.f;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.xweb.z;
import d.g.a.a;
import d.g.b.k;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/ui/dialog/LiveVisitorGuideView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionBtn", "Landroid/widget/Button;", "actionGroup", "Landroid/view/View;", "actionIcon", "Landroid/widget/ImageView;", "actionTv", "Landroid/widget/TextView;", "contentGroup", "isAcceptAgreement", "", "maskView", "onHideListener", "Lkotlin/Function0;", "", "getOnHideListener", "()Lkotlin/jvm/functions/Function0;", "setOnHideListener", "(Lkotlin/jvm/functions/Function0;)V", "onOkListener", "getOnOkListener", "setOnOkListener", "titleIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "webView", "Lcom/tencent/mm/ui/widget/MMWebView;", "setupAction", "setupContentView", "setupMask", "setupTitle", "plugin-logic_release"})
public final class LiveVisitorGuideView
  extends RelativeLayout
{
  private final MMWebView gGd;
  private final ImageView gGe;
  private final TextView gGf;
  private final Button gGg;
  private final WeImageView gGh;
  private final View gGi;
  private final View gGj;
  private final View gGk;
  private boolean gGl;
  private a<y> gGm;
  private a<y> gGn;
  
  public LiveVisitorGuideView(Context paramContext)
  {
    this(paramContext, null, 0);
    AppMethodBeat.i(190605);
    AppMethodBeat.o(190605);
  }
  
  public LiveVisitorGuideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(190606);
    AppMethodBeat.o(190606);
  }
  
  public LiveVisitorGuideView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(190604);
    View.inflate(paramContext, 2131496352, (ViewGroup)this);
    paramAttributeSet = MMWebView.a.a(paramContext, (View)this, 2131307844);
    k.g(paramAttributeSet, "MMWebView.Factory.findVi…ve_visitor_guide_content)");
    this.gGd = paramAttributeSet;
    paramAttributeSet = findViewById(2131307842);
    k.g(paramAttributeSet, "findViewById(R.id.live_visitor_guide_action_icon)");
    this.gGe = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131307843);
    k.g(paramAttributeSet, "findViewById(R.id.live_visitor_guide_action_tv)");
    this.gGf = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131307839);
    k.g(paramAttributeSet, "findViewById(R.id.live_visitor_guide_action_btn)");
    this.gGg = ((Button)paramAttributeSet);
    paramAttributeSet = findViewById(2131307848);
    k.g(paramAttributeSet, "findViewById(R.id.live_visitor_guide_title_icon)");
    this.gGh = ((WeImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131307840);
    k.g(paramAttributeSet, "findViewById(R.id.live_v…_guide_action_desc_group)");
    this.gGi = paramAttributeSet;
    paramAttributeSet = findViewById(2131307845);
    k.g(paramAttributeSet, "findViewById(R.id.live_v…itor_guide_content_group)");
    this.gGj = paramAttributeSet;
    paramAttributeSet = findViewById(2131307846);
    k.g(paramAttributeSet, "findViewById(R.id.live_visitor_guide_mask)");
    this.gGk = paramAttributeSet;
    this.gGj.getLayoutParams().height = (ap.cl(paramContext).y * 3 / 4);
    paramContext = this.gGd.getSettings();
    k.g(paramContext, "webView.getSettings()");
    paramContext.setJavaScriptEnabled(true);
    paramContext = this.gGd;
    paramAttributeSet = f.gtk;
    paramContext.loadUrl(f.aki());
    this.gGh.setOnClickListener((View.OnClickListener)new c(this));
    this.gGe.setImageResource(2131231750);
    this.gGi.setOnClickListener((View.OnClickListener)new a(this));
    this.gGg.setEnabled(false);
    this.gGg.setOnClickListener((View.OnClickListener)new b(this));
    if (aj.DT())
    {
      paramContext = this.gGk;
      paramAttributeSet = getContext();
      k.g(paramAttributeSet, "context");
      paramContext.setBackground(paramAttributeSet.getResources().getDrawable(2131691548));
      AppMethodBeat.o(190604);
      return;
    }
    paramContext = this.gGk;
    paramAttributeSet = getContext();
    k.g(paramAttributeSet, "context");
    paramContext.setBackground(paramAttributeSet.getResources().getDrawable(2131691549));
    AppMethodBeat.o(190604);
  }
  
  public final a<y> getOnHideListener()
  {
    return this.gGm;
  }
  
  public final a<y> getOnOkListener()
  {
    return this.gGn;
  }
  
  public final void setOnHideListener(a<y> parama)
  {
    this.gGm = parama;
  }
  
  public final void setOnOkListener(a<y> parama)
  {
    this.gGn = parama;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(LiveVisitorGuideView paramLiveVisitorGuideView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(190601);
      paramView = this.gGo;
      if (!LiveVisitorGuideView.a(this.gGo)) {}
      for (boolean bool = true;; bool = false)
      {
        LiveVisitorGuideView.a(paramView, bool);
        if (!LiveVisitorGuideView.a(this.gGo)) {
          break;
        }
        LiveVisitorGuideView.b(this.gGo).setImageResource(2131689936);
        LiveVisitorGuideView.c(this.gGo).setEnabled(true);
        AppMethodBeat.o(190601);
        return;
      }
      LiveVisitorGuideView.b(this.gGo).setImageResource(2131231750);
      LiveVisitorGuideView.c(this.gGo).setEnabled(false);
      AppMethodBeat.o(190601);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(LiveVisitorGuideView paramLiveVisitorGuideView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(190602);
      paramView = this.gGo.getOnOkListener();
      if (paramView != null)
      {
        paramView.invoke();
        AppMethodBeat.o(190602);
        return;
      }
      AppMethodBeat.o(190602);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(LiveVisitorGuideView paramLiveVisitorGuideView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(190603);
      paramView = this.gGo.getOnHideListener();
      if (paramView != null)
      {
        paramView.invoke();
        AppMethodBeat.o(190603);
        return;
      }
      AppMethodBeat.o(190603);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.ui.dialog.LiveVisitorGuideView
 * JD-Core Version:    0.7.0.1
 */