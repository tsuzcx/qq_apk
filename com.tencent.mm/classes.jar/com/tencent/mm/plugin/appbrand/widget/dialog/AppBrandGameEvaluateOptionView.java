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
import com.tencent.mm.protocal.protobuf.cgo;
import com.tencent.mm.protocal.protobuf.eis;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.p;
import d.l;
import d.v;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandGameEvaluateOptionView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "optionChooseCallback", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandGameEvaluateOptionView$OptionChooseCallback;", "optionConfig", "Lcom/tencent/mm/protocal/protobuf/OptionItem;", "view", "onClick", "", "v", "Landroid/view/View;", "setData", "index", "config", "Lcom/tencent/mm/protocal/protobuf/WxagGameOriginalReviewConfig;", "callback", "OptionChooseCallback", "plugin-appbrand-integration_release"})
public final class AppBrandGameEvaluateOptionView
  extends FrameLayout
  implements View.OnClickListener
{
  private final ap handler;
  private cgo nbP;
  private a nbQ;
  private final FrameLayout nbR;
  
  public AppBrandGameEvaluateOptionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  public AppBrandGameEvaluateOptionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(51444);
    this.handler = new ap(Looper.getMainLooper());
    paramContext = LayoutInflater.from(paramContext).inflate(2131492997, (ViewGroup)this, false);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(51444);
      throw paramContext;
    }
    this.nbR = ((FrameLayout)paramContext);
    addView((View)this.nbR);
    this.nbR.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(51444);
  }
  
  public final void a(int paramInt, eis parameis, a parama)
  {
    AppMethodBeat.i(51442);
    p.h(parameis, "config");
    p.h(parama, "callback");
    this.nbQ = parama;
    parameis = parameis.HTm.get(paramInt);
    p.g(parameis, "config.OptionList[index]");
    this.nbP = ((cgo)parameis);
    parameis = this.nbR.findViewById(2131305710);
    p.g(parameis, "view.findViewById<TextView>(R.id.text)");
    parameis = (TextView)parameis;
    parama = this.nbP;
    if (parama == null) {
      p.bcb("optionConfig");
    }
    parameis.setText((CharSequence)parama.GZE);
    parameis = com.tencent.mm.aw.a.a.aIP();
    parama = this.nbP;
    if (parama == null) {
      p.bcb("optionConfig");
    }
    parameis.loadImage(parama.IconUrl, (ImageView)this.nbR.findViewById(2131300914));
    AppMethodBeat.o(51442);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(51443);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandGameEvaluateOptionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    this.nbR.setBackgroundResource(2131099704);
    ((TextView)this.nbR.findViewById(2131305710)).setTextColor(com.tencent.mm.cc.a.n(getContext(), 2131099699));
    this.handler.postDelayed((Runnable)new b(this), 100L);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandGameEvaluateOptionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(51443);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandGameEvaluateOptionView$OptionChooseCallback;", "", "onOptionChoose", "", "optionInfo", "Lcom/tencent/mm/protocal/protobuf/OptionItem;", "plugin-appbrand-integration_release"})
  public static abstract interface a
  {
    public abstract void a(cgo paramcgo);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(AppBrandGameEvaluateOptionView paramAppBrandGameEvaluateOptionView) {}
    
    public final void run()
    {
      AppMethodBeat.i(51441);
      AppBrandGameEvaluateOptionView.a(this.nbS).a(AppBrandGameEvaluateOptionView.b(this.nbS));
      AppMethodBeat.o(51441);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.AppBrandGameEvaluateOptionView
 * JD-Core Version:    0.7.0.1
 */