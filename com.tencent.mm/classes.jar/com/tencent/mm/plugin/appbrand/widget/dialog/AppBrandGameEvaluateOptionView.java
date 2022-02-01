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
import com.tencent.mm.protocal.protobuf.cxp;
import com.tencent.mm.protocal.protobuf.ffc;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandGameEvaluateOptionView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "optionChooseCallback", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandGameEvaluateOptionView$OptionChooseCallback;", "optionConfig", "Lcom/tencent/mm/protocal/protobuf/OptionItem;", "view", "onClick", "", "v", "Landroid/view/View;", "setData", "index", "config", "Lcom/tencent/mm/protocal/protobuf/WxagGameOriginalReviewConfig;", "callback", "OptionChooseCallback", "plugin-appbrand-integration_release"})
public final class AppBrandGameEvaluateOptionView
  extends FrameLayout
  implements View.OnClickListener
{
  private final MMHandler handler;
  private cxp oqK;
  private a oqL;
  private final FrameLayout oqM;
  
  public AppBrandGameEvaluateOptionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  public AppBrandGameEvaluateOptionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(51444);
    this.handler = new MMHandler(Looper.getMainLooper());
    paramContext = LayoutInflater.from(paramContext).inflate(2131493035, (ViewGroup)this, false);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(51444);
      throw paramContext;
    }
    this.oqM = ((FrameLayout)paramContext);
    addView((View)this.oqM);
    this.oqM.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(51444);
  }
  
  public final void a(int paramInt, ffc paramffc, a parama)
  {
    AppMethodBeat.i(51442);
    p.h(paramffc, "config");
    p.h(parama, "callback");
    this.oqL = parama;
    paramffc = paramffc.NAv.get(paramInt);
    p.g(paramffc, "config.OptionList[index]");
    this.oqK = ((cxp)paramffc);
    paramffc = this.oqM.findViewById(2131308977);
    p.g(paramffc, "view.findViewById<TextView>(R.id.text)");
    paramffc = (TextView)paramffc;
    parama = this.oqK;
    if (parama == null) {
      p.btv("optionConfig");
    }
    paramffc.setText((CharSequence)parama.MCb);
    paramffc = com.tencent.mm.av.a.a.bdb();
    parama = this.oqK;
    if (parama == null) {
      p.btv("optionConfig");
    }
    paramffc.loadImage(parama.IconUrl, (ImageView)this.oqM.findViewById(2131302526));
    AppMethodBeat.o(51442);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(51443);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandGameEvaluateOptionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.oqM.setBackgroundResource(2131099716);
    ((TextView)this.oqM.findViewById(2131308977)).setTextColor(com.tencent.mm.cb.a.n(getContext(), 2131099710));
    this.handler.postDelayed((Runnable)new b(this), 100L);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandGameEvaluateOptionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(51443);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandGameEvaluateOptionView$OptionChooseCallback;", "", "onOptionChoose", "", "optionInfo", "Lcom/tencent/mm/protocal/protobuf/OptionItem;", "plugin-appbrand-integration_release"})
  public static abstract interface a
  {
    public abstract void a(cxp paramcxp);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(AppBrandGameEvaluateOptionView paramAppBrandGameEvaluateOptionView) {}
    
    public final void run()
    {
      AppMethodBeat.i(51441);
      AppBrandGameEvaluateOptionView.a(this.oqN).a(AppBrandGameEvaluateOptionView.b(this.oqN));
      AppMethodBeat.o(51441);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.AppBrandGameEvaluateOptionView
 * JD-Core Version:    0.7.0.1
 */