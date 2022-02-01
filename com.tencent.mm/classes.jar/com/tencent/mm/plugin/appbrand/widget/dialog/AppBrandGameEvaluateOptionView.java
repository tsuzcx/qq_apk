package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.protocal.protobuf.dzg;
import com.tencent.mm.protocal.protobuf.gnm;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandGameEvaluateOptionView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "optionChooseCallback", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandGameEvaluateOptionView$OptionChooseCallback;", "optionConfig", "Lcom/tencent/mm/protocal/protobuf/OptionItem;", "view", "onClick", "", "v", "Landroid/view/View;", "setData", "index", "config", "Lcom/tencent/mm/protocal/protobuf/WxagGameOriginalReviewConfig;", "callback", "OptionChooseCallback", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandGameEvaluateOptionView
  extends FrameLayout
  implements View.OnClickListener
{
  private final MMHandler handler;
  private dzg uCO;
  private a uCP;
  private final FrameLayout uCQ;
  
  public AppBrandGameEvaluateOptionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
    AppMethodBeat.i(324681);
    AppMethodBeat.o(324681);
  }
  
  public AppBrandGameEvaluateOptionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(51444);
    this.handler = new MMHandler(Looper.getMainLooper());
    paramContext = LayoutInflater.from(paramContext).inflate(ba.g.app_brand_game_evaluate_option, (ViewGroup)this, false);
    if (paramContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(51444);
      throw paramContext;
    }
    this.uCQ = ((FrameLayout)paramContext);
    addView((View)this.uCQ);
    this.uCQ.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(51444);
  }
  
  private static final void a(AppBrandGameEvaluateOptionView paramAppBrandGameEvaluateOptionView)
  {
    Object localObject = null;
    AppMethodBeat.i(324685);
    s.u(paramAppBrandGameEvaluateOptionView, "this$0");
    a locala2 = paramAppBrandGameEvaluateOptionView.uCP;
    a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("optionChooseCallback");
      locala1 = null;
    }
    paramAppBrandGameEvaluateOptionView = paramAppBrandGameEvaluateOptionView.uCO;
    if (paramAppBrandGameEvaluateOptionView == null)
    {
      s.bIx("optionConfig");
      paramAppBrandGameEvaluateOptionView = localObject;
    }
    for (;;)
    {
      locala1.a(paramAppBrandGameEvaluateOptionView);
      AppMethodBeat.o(324685);
      return;
    }
  }
  
  public final void a(int paramInt, gnm paramgnm, a parama)
  {
    Object localObject = null;
    AppMethodBeat.i(51442);
    s.u(paramgnm, "config");
    s.u(parama, "callback");
    this.uCP = parama;
    paramgnm = paramgnm.aciz.get(paramInt);
    s.s(paramgnm, "config.OptionList[index]");
    this.uCO = ((dzg)paramgnm);
    TextView localTextView = (TextView)this.uCQ.findViewById(ba.f.text);
    parama = this.uCO;
    paramgnm = parama;
    if (parama == null)
    {
      s.bIx("optionConfig");
      paramgnm = null;
    }
    localTextView.setText((CharSequence)paramgnm.abea);
    parama = com.tencent.mm.modelimage.loader.a.bKl();
    paramgnm = this.uCO;
    if (paramgnm == null)
    {
      s.bIx("optionConfig");
      paramgnm = localObject;
    }
    for (;;)
    {
      parama.loadImage(paramgnm.IHo, (ImageView)this.uCQ.findViewById(ba.f.image));
      AppMethodBeat.o(51442);
      return;
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(51443);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandGameEvaluateOptionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    this.uCQ.setBackgroundResource(ba.c.Brand_Alpha_0_1);
    ((TextView)this.uCQ.findViewById(ba.f.text)).setTextColor(com.tencent.mm.cd.a.w(getContext(), ba.c.Brand));
    this.handler.postDelayed(new AppBrandGameEvaluateOptionView..ExternalSyntheticLambda0(this), 100L);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandGameEvaluateOptionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(51443);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandGameEvaluateOptionView$OptionChooseCallback;", "", "onOptionChoose", "", "optionInfo", "Lcom/tencent/mm/protocal/protobuf/OptionItem;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(dzg paramdzg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.AppBrandGameEvaluateOptionView
 * JD-Core Version:    0.7.0.1
 */