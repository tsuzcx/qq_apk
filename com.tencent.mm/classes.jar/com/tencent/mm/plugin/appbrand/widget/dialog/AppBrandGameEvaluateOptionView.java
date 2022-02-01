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
import com.tencent.mm.protocal.protobuf.bxd;
import com.tencent.mm.protocal.protobuf.dwv;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.k;
import d.l;
import d.v;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandGameEvaluateOptionView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "optionChooseCallback", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandGameEvaluateOptionView$OptionChooseCallback;", "optionConfig", "Lcom/tencent/mm/protocal/protobuf/OptionItem;", "view", "onClick", "", "v", "Landroid/view/View;", "setData", "index", "config", "Lcom/tencent/mm/protocal/protobuf/WxagGameOriginalReviewConfig;", "callback", "OptionChooseCallback", "plugin-appbrand-integration_release"})
public final class AppBrandGameEvaluateOptionView
  extends FrameLayout
  implements View.OnClickListener
{
  private final ap handler;
  private bxd lZf;
  private a lZg;
  private final FrameLayout lZh;
  
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
    this.lZh = ((FrameLayout)paramContext);
    addView((View)this.lZh);
    this.lZh.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(51444);
  }
  
  public final void a(int paramInt, dwv paramdwv, a parama)
  {
    AppMethodBeat.i(51442);
    k.h(paramdwv, "config");
    k.h(parama, "callback");
    this.lZg = parama;
    paramdwv = paramdwv.EKM.get(paramInt);
    k.g(paramdwv, "config.OptionList[index]");
    this.lZf = ((bxd)paramdwv);
    paramdwv = this.lZh.findViewById(2131305710);
    k.g(paramdwv, "view.findViewById<TextView>(R.id.text)");
    paramdwv = (TextView)paramdwv;
    parama = this.lZf;
    if (parama == null) {
      k.aPZ("optionConfig");
    }
    paramdwv.setText((CharSequence)parama.DTy);
    paramdwv = com.tencent.mm.aw.a.a.ayO();
    parama = this.lZf;
    if (parama == null) {
      k.aPZ("optionConfig");
    }
    paramdwv.loadImage(parama.IconUrl, (ImageView)this.lZh.findViewById(2131300914));
    AppMethodBeat.o(51442);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(51443);
    this.lZh.setBackgroundResource(2131099704);
    ((TextView)this.lZh.findViewById(2131305710)).setTextColor(com.tencent.mm.cd.a.n(getContext(), 2131099699));
    this.handler.postDelayed((Runnable)new b(this), 100L);
    AppMethodBeat.o(51443);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandGameEvaluateOptionView$OptionChooseCallback;", "", "onOptionChoose", "", "optionInfo", "Lcom/tencent/mm/protocal/protobuf/OptionItem;", "plugin-appbrand-integration_release"})
  public static abstract interface a
  {
    public abstract void a(bxd parambxd);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(AppBrandGameEvaluateOptionView paramAppBrandGameEvaluateOptionView) {}
    
    public final void run()
    {
      AppMethodBeat.i(51441);
      AppBrandGameEvaluateOptionView.a(this.lZi).a(AppBrandGameEvaluateOptionView.b(this.lZi));
      AppMethodBeat.o(51441);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.AppBrandGameEvaluateOptionView
 * JD-Core Version:    0.7.0.1
 */