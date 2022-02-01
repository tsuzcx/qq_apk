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
import com.tencent.mm.live.b.e;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.a.a;
import d.g.b.k;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/ui/dialog/LiveVisitorGuideView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionBtn", "Landroid/widget/Button;", "actionGroup", "Landroid/view/View;", "actionIcon", "Landroid/widget/ImageView;", "actionTv", "Landroid/widget/TextView;", "blankArea", "contentGroup", "isAcceptAgreement", "", "maskView", "onHideListener", "Lkotlin/Function0;", "", "getOnHideListener", "()Lkotlin/jvm/functions/Function0;", "setOnHideListener", "(Lkotlin/jvm/functions/Function0;)V", "onOkListener", "getOnOkListener", "setOnOkListener", "titleIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "webView", "Lcom/tencent/mm/ui/widget/MMWebView;", "setupAction", "setupContentView", "setupMask", "setupTitle", "plugin-logic_release"})
public final class LiveVisitorGuideView
  extends RelativeLayout
{
  private final ImageView KzJ;
  private final Button KzK;
  private final WeImageView KzL;
  private final View KzM;
  private boolean KzN;
  private a<y> KzO;
  private a<y> KzP;
  private final TextView hJc;
  private final View lRB;
  private final MMWebView uQx;
  private final View yqI;
  private final View yvY;
  
  public LiveVisitorGuideView(Context paramContext)
  {
    this(paramContext, null, 0);
    AppMethodBeat.i(203399);
    AppMethodBeat.o(203399);
  }
  
  public LiveVisitorGuideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(203400);
    AppMethodBeat.o(203400);
  }
  
  public LiveVisitorGuideView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(203398);
    View.inflate(paramContext, 2131496343, (ViewGroup)this);
    paramAttributeSet = MMWebView.a.a(paramContext, (View)this, 2131307764);
    k.g(paramAttributeSet, "MMWebView.Factory.findVi…ve_visitor_guide_content)");
    this.uQx = paramAttributeSet;
    paramAttributeSet = findViewById(2131307761);
    k.g(paramAttributeSet, "findViewById(R.id.live_visitor_guide_action_icon)");
    this.KzJ = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131307762);
    k.g(paramAttributeSet, "findViewById(R.id.live_visitor_guide_action_tv)");
    this.hJc = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131307758);
    k.g(paramAttributeSet, "findViewById(R.id.live_visitor_guide_action_btn)");
    this.KzK = ((Button)paramAttributeSet);
    paramAttributeSet = findViewById(2131307768);
    k.g(paramAttributeSet, "findViewById(R.id.live_visitor_guide_title_icon)");
    this.KzL = ((WeImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131307763);
    k.g(paramAttributeSet, "findViewById(R.id.live_visitor_guide_blank_area)");
    this.yqI = paramAttributeSet;
    paramAttributeSet = findViewById(2131307759);
    k.g(paramAttributeSet, "findViewById(R.id.live_v…_guide_action_desc_group)");
    this.KzM = paramAttributeSet;
    paramAttributeSet = findViewById(2131307765);
    k.g(paramAttributeSet, "findViewById(R.id.live_v…itor_guide_content_group)");
    this.yvY = paramAttributeSet;
    paramAttributeSet = findViewById(2131307766);
    k.g(paramAttributeSet, "findViewById(R.id.live_visitor_guide_mask)");
    this.lRB = paramAttributeSet;
    this.yvY.getLayoutParams().height = (ap.cf(paramContext).y * 3 / 4);
    paramContext = this.uQx;
    paramAttributeSet = e.qYm;
    paramContext.loadUrl(e.elY());
    this.yqI.setOnClickListener((View.OnClickListener)new c(this));
    this.KzL.setOnClickListener((View.OnClickListener)new d(this));
    this.KzJ.setImageResource(2131231750);
    this.KzM.setOnClickListener((View.OnClickListener)new a(this));
    this.KzK.setEnabled(false);
    this.KzK.setOnClickListener((View.OnClickListener)new b(this));
    if (ai.Eq())
    {
      paramContext = this.lRB;
      paramAttributeSet = getContext();
      k.g(paramAttributeSet, "context");
      paramContext.setBackground(paramAttributeSet.getResources().getDrawable(2131691533));
      AppMethodBeat.o(203398);
      return;
    }
    paramContext = this.lRB;
    paramAttributeSet = getContext();
    k.g(paramAttributeSet, "context");
    paramContext.setBackground(paramAttributeSet.getResources().getDrawable(2131691534));
    AppMethodBeat.o(203398);
  }
  
  public final a<y> getOnHideListener()
  {
    return this.KzO;
  }
  
  public final a<y> getOnOkListener()
  {
    return this.KzP;
  }
  
  public final void setOnHideListener(a<y> parama)
  {
    this.KzO = parama;
  }
  
  public final void setOnOkListener(a<y> parama)
  {
    this.KzP = parama;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(LiveVisitorGuideView paramLiveVisitorGuideView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203394);
      paramView = this.KzQ;
      if (!LiveVisitorGuideView.a(this.KzQ)) {}
      for (boolean bool = true;; bool = false)
      {
        LiveVisitorGuideView.a(paramView, bool);
        if (!LiveVisitorGuideView.a(this.KzQ)) {
          break;
        }
        LiveVisitorGuideView.b(this.KzQ).setImageResource(2131689936);
        LiveVisitorGuideView.c(this.KzQ).setEnabled(true);
        AppMethodBeat.o(203394);
        return;
      }
      LiveVisitorGuideView.b(this.KzQ).setImageResource(2131231750);
      LiveVisitorGuideView.c(this.KzQ).setEnabled(false);
      AppMethodBeat.o(203394);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(LiveVisitorGuideView paramLiveVisitorGuideView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203395);
      paramView = this.KzQ.getOnOkListener();
      if (paramView != null)
      {
        paramView.invoke();
        AppMethodBeat.o(203395);
        return;
      }
      AppMethodBeat.o(203395);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(LiveVisitorGuideView paramLiveVisitorGuideView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203396);
      paramView = this.KzQ.getOnHideListener();
      if (paramView != null)
      {
        paramView.invoke();
        AppMethodBeat.o(203396);
        return;
      }
      AppMethodBeat.o(203396);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(LiveVisitorGuideView paramLiveVisitorGuideView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203397);
      paramView = this.KzQ.getOnHideListener();
      if (paramView != null)
      {
        paramView.invoke();
        AppMethodBeat.o(203397);
        return;
      }
      AppMethodBeat.o(203397);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.ui.dialog.LiveVisitorGuideView
 * JD-Core Version:    0.7.0.1
 */