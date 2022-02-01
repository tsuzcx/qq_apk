package com.tencent.mm.live.ui.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
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
import com.tencent.mm.live.model.l;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.xweb.ad;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/ui/dialog/LiveVisitorGuideView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionBtn", "Landroid/widget/Button;", "actionGroup", "Landroid/view/View;", "actionIcon", "Landroid/widget/ImageView;", "actionTv", "Landroid/widget/TextView;", "contentGroup", "isAcceptAgreement", "", "maskView", "onHideListener", "Lkotlin/Function0;", "", "getOnHideListener", "()Lkotlin/jvm/functions/Function0;", "setOnHideListener", "(Lkotlin/jvm/functions/Function0;)V", "onOkListener", "getOnOkListener", "setOnOkListener", "titleIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "webView", "Lcom/tencent/mm/ui/widget/MMWebView;", "setupAction", "setupContentView", "setupMask", "setupTitle", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LiveVisitorGuideView
  extends RelativeLayout
{
  private final View maskView;
  private final ImageView nml;
  private final TextView nmm;
  private final Button nmn;
  private final WeImageView nmo;
  private final View nmp;
  private final View nmq;
  private boolean nmr;
  private kotlin.g.a.a<ah> nms;
  private kotlin.g.a.a<ah> nmt;
  private final MMWebView webView;
  
  public LiveVisitorGuideView(Context paramContext)
  {
    this(paramContext, null, 0);
    AppMethodBeat.i(246453);
    AppMethodBeat.o(246453);
  }
  
  public LiveVisitorGuideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(246459);
    AppMethodBeat.o(246459);
  }
  
  public LiveVisitorGuideView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(246447);
    View.inflate(paramContext, b.f.live_visitor_guide_view, (ViewGroup)this);
    paramAttributeSet = MMWebView.a.b(paramContext, (View)this, b.e.live_visitor_guide_content);
    s.s(paramAttributeSet, "findViewById(context, th…ve_visitor_guide_content)");
    this.webView = paramAttributeSet;
    paramAttributeSet = findViewById(b.e.live_visitor_guide_action_icon);
    s.s(paramAttributeSet, "findViewById(R.id.live_visitor_guide_action_icon)");
    this.nml = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(b.e.live_visitor_guide_action_tv);
    s.s(paramAttributeSet, "findViewById(R.id.live_visitor_guide_action_tv)");
    this.nmm = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(b.e.live_visitor_guide_action_btn);
    s.s(paramAttributeSet, "findViewById(R.id.live_visitor_guide_action_btn)");
    this.nmn = ((Button)paramAttributeSet);
    paramAttributeSet = findViewById(b.e.live_visitor_guide_title_icon);
    s.s(paramAttributeSet, "findViewById(R.id.live_visitor_guide_title_icon)");
    this.nmo = ((WeImageView)paramAttributeSet);
    paramAttributeSet = findViewById(b.e.live_visitor_guide_action_desc_group);
    s.s(paramAttributeSet, "findViewById(R.id.live_v…_guide_action_desc_group)");
    this.nmp = paramAttributeSet;
    paramAttributeSet = findViewById(b.e.live_visitor_guide_content_group);
    s.s(paramAttributeSet, "findViewById(R.id.live_v…itor_guide_content_group)");
    this.nmq = paramAttributeSet;
    paramAttributeSet = findViewById(b.e.live_visitor_guide_mask);
    s.s(paramAttributeSet, "findViewById(R.id.live_visitor_guide_mask)");
    this.maskView = paramAttributeSet;
    this.nmq.getLayoutParams().height = (bf.bf(paramContext).y * 3 / 4);
    paramContext = this.webView.getSettings();
    s.s(paramContext, "webView.getSettings()");
    paramContext.setJavaScriptEnabled(true);
    paramContext = this.webView;
    paramAttributeSet = l.mYb;
    paramContext.loadUrl(l.bhl());
    this.nmo.setOnClickListener(new LiveVisitorGuideView..ExternalSyntheticLambda2(this));
    this.nml.setImageResource(b.d.checkbox_unselected);
    this.nmp.setOnClickListener(new LiveVisitorGuideView..ExternalSyntheticLambda1(this));
    this.nmn.setEnabled(false);
    this.nmn.setOnClickListener(new LiveVisitorGuideView..ExternalSyntheticLambda0(this));
    if (aw.isDarkMode())
    {
      this.maskView.setBackground(getContext().getResources().getDrawable(b.g.live_visitor_guide_mask_dark));
      AppMethodBeat.o(246447);
      return;
    }
    this.maskView.setBackground(getContext().getResources().getDrawable(b.g.live_visitor_guide_mask_normal));
    AppMethodBeat.o(246447);
  }
  
  private static final void a(LiveVisitorGuideView paramLiveVisitorGuideView, View paramView)
  {
    AppMethodBeat.i(246464);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramLiveVisitorGuideView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/ui/dialog/LiveVisitorGuideView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramLiveVisitorGuideView, "this$0");
    paramLiveVisitorGuideView = paramLiveVisitorGuideView.getOnHideListener();
    if (paramLiveVisitorGuideView != null) {
      paramLiveVisitorGuideView.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/ui/dialog/LiveVisitorGuideView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(246464);
  }
  
  private static final void b(LiveVisitorGuideView paramLiveVisitorGuideView, View paramView)
  {
    AppMethodBeat.i(246473);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramLiveVisitorGuideView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/ui/dialog/LiveVisitorGuideView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramLiveVisitorGuideView, "this$0");
    boolean bool;
    if (!paramLiveVisitorGuideView.nmr)
    {
      bool = true;
      paramLiveVisitorGuideView.nmr = bool;
      if (!paramLiveVisitorGuideView.nmr) {
        break label136;
      }
      paramLiveVisitorGuideView.nml.setImageResource(b.g.checkbox_selected);
      paramLiveVisitorGuideView.nmn.setEnabled(true);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/ui/dialog/LiveVisitorGuideView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(246473);
      return;
      bool = false;
      break;
      label136:
      paramLiveVisitorGuideView.nml.setImageResource(b.d.checkbox_unselected);
      paramLiveVisitorGuideView.nmn.setEnabled(false);
    }
  }
  
  private static final void c(LiveVisitorGuideView paramLiveVisitorGuideView, View paramView)
  {
    AppMethodBeat.i(246479);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramLiveVisitorGuideView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/ui/dialog/LiveVisitorGuideView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramLiveVisitorGuideView, "this$0");
    paramLiveVisitorGuideView = paramLiveVisitorGuideView.getOnOkListener();
    if (paramLiveVisitorGuideView != null) {
      paramLiveVisitorGuideView.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/ui/dialog/LiveVisitorGuideView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(246479);
  }
  
  public final kotlin.g.a.a<ah> getOnHideListener()
  {
    return this.nms;
  }
  
  public final kotlin.g.a.a<ah> getOnOkListener()
  {
    return this.nmt;
  }
  
  public final void setOnHideListener(kotlin.g.a.a<ah> parama)
  {
    this.nms = parama;
  }
  
  public final void setOnOkListener(kotlin.g.a.a<ah> parama)
  {
    this.nmt = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.ui.dialog.LiveVisitorGuideView
 * JD-Core Version:    0.7.0.1
 */