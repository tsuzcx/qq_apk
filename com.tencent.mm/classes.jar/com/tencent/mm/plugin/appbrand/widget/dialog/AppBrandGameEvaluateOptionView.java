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
import com.tencent.mm.protocal.protobuf.cbx;
import com.tencent.mm.protocal.protobuf.ecm;
import com.tencent.mm.sdk.platformtools.ao;
import d.g.b.k;
import d.l;
import d.v;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandGameEvaluateOptionView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "optionChooseCallback", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandGameEvaluateOptionView$OptionChooseCallback;", "optionConfig", "Lcom/tencent/mm/protocal/protobuf/OptionItem;", "view", "onClick", "", "v", "Landroid/view/View;", "setData", "index", "config", "Lcom/tencent/mm/protocal/protobuf/WxagGameOriginalReviewConfig;", "callback", "OptionChooseCallback", "plugin-appbrand-integration_release"})
public final class AppBrandGameEvaluateOptionView
  extends FrameLayout
  implements View.OnClickListener
{
  private final ao handler;
  private cbx mBh;
  private a mBi;
  private final FrameLayout mBj;
  
  public AppBrandGameEvaluateOptionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  public AppBrandGameEvaluateOptionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(51444);
    this.handler = new ao(Looper.getMainLooper());
    paramContext = LayoutInflater.from(paramContext).inflate(2131492997, (ViewGroup)this, false);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(51444);
      throw paramContext;
    }
    this.mBj = ((FrameLayout)paramContext);
    addView((View)this.mBj);
    this.mBj.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(51444);
  }
  
  public final void a(int paramInt, ecm paramecm, a parama)
  {
    AppMethodBeat.i(51442);
    k.h(paramecm, "config");
    k.h(parama, "callback");
    this.mBi = parama;
    paramecm = paramecm.GhY.get(paramInt);
    k.g(paramecm, "config.OptionList[index]");
    this.mBh = ((cbx)paramecm);
    paramecm = this.mBj.findViewById(2131305710);
    k.g(paramecm, "view.findViewById<TextView>(R.id.text)");
    paramecm = (TextView)paramecm;
    parama = this.mBh;
    if (parama == null) {
      k.aVY("optionConfig");
    }
    paramecm.setText((CharSequence)parama.FpU);
    paramecm = com.tencent.mm.av.a.a.aFG();
    parama = this.mBh;
    if (parama == null) {
      k.aVY("optionConfig");
    }
    paramecm.loadImage(parama.IconUrl, (ImageView)this.mBj.findViewById(2131300914));
    AppMethodBeat.o(51442);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(51443);
    this.mBj.setBackgroundResource(2131099704);
    ((TextView)this.mBj.findViewById(2131305710)).setTextColor(com.tencent.mm.cc.a.n(getContext(), 2131099699));
    this.handler.postDelayed((Runnable)new b(this), 100L);
    AppMethodBeat.o(51443);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandGameEvaluateOptionView$OptionChooseCallback;", "", "onOptionChoose", "", "optionInfo", "Lcom/tencent/mm/protocal/protobuf/OptionItem;", "plugin-appbrand-integration_release"})
  public static abstract interface a
  {
    public abstract void a(cbx paramcbx);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(AppBrandGameEvaluateOptionView paramAppBrandGameEvaluateOptionView) {}
    
    public final void run()
    {
      AppMethodBeat.i(51441);
      AppBrandGameEvaluateOptionView.a(this.mBk).a(AppBrandGameEvaluateOptionView.b(this.mBk));
      AppMethodBeat.o(51441);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.AppBrandGameEvaluateOptionView
 * JD-Core Version:    0.7.0.1
 */