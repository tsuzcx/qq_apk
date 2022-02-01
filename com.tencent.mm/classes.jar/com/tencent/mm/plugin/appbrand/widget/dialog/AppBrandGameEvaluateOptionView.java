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
import com.tencent.mm.protocal.protobuf.chi;
import com.tencent.mm.protocal.protobuf.ekj;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.p;
import d.l;
import d.v;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandGameEvaluateOptionView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "optionChooseCallback", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandGameEvaluateOptionView$OptionChooseCallback;", "optionConfig", "Lcom/tencent/mm/protocal/protobuf/OptionItem;", "view", "onClick", "", "v", "Landroid/view/View;", "setData", "index", "config", "Lcom/tencent/mm/protocal/protobuf/WxagGameOriginalReviewConfig;", "callback", "OptionChooseCallback", "plugin-appbrand-integration_release"})
public final class AppBrandGameEvaluateOptionView
  extends FrameLayout
  implements View.OnClickListener
{
  private final aq handler;
  private chi ngY;
  private a ngZ;
  private final FrameLayout nha;
  
  public AppBrandGameEvaluateOptionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  public AppBrandGameEvaluateOptionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(51444);
    this.handler = new aq(Looper.getMainLooper());
    paramContext = LayoutInflater.from(paramContext).inflate(2131492997, (ViewGroup)this, false);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(51444);
      throw paramContext;
    }
    this.nha = ((FrameLayout)paramContext);
    addView((View)this.nha);
    this.nha.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(51444);
  }
  
  public final void a(int paramInt, ekj paramekj, a parama)
  {
    AppMethodBeat.i(51442);
    p.h(paramekj, "config");
    p.h(parama, "callback");
    this.ngZ = parama;
    paramekj = paramekj.Int.get(paramInt);
    p.g(paramekj, "config.OptionList[index]");
    this.ngY = ((chi)paramekj);
    paramekj = this.nha.findViewById(2131305710);
    p.g(paramekj, "view.findViewById<TextView>(R.id.text)");
    paramekj = (TextView)paramekj;
    parama = this.ngY;
    if (parama == null) {
      p.bdF("optionConfig");
    }
    paramekj.setText((CharSequence)parama.Htf);
    paramekj = com.tencent.mm.av.a.a.aJh();
    parama = this.ngY;
    if (parama == null) {
      p.bdF("optionConfig");
    }
    paramekj.loadImage(parama.IconUrl, (ImageView)this.nha.findViewById(2131300914));
    AppMethodBeat.o(51442);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(51443);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandGameEvaluateOptionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    this.nha.setBackgroundResource(2131099704);
    ((TextView)this.nha.findViewById(2131305710)).setTextColor(com.tencent.mm.cb.a.n(getContext(), 2131099699));
    this.handler.postDelayed((Runnable)new b(this), 100L);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandGameEvaluateOptionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(51443);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandGameEvaluateOptionView$OptionChooseCallback;", "", "onOptionChoose", "", "optionInfo", "Lcom/tencent/mm/protocal/protobuf/OptionItem;", "plugin-appbrand-integration_release"})
  public static abstract interface a
  {
    public abstract void a(chi paramchi);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(AppBrandGameEvaluateOptionView paramAppBrandGameEvaluateOptionView) {}
    
    public final void run()
    {
      AppMethodBeat.i(51441);
      AppBrandGameEvaluateOptionView.a(this.nhb).a(AppBrandGameEvaluateOptionView.b(this.nhb));
      AppMethodBeat.o(51441);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.AppBrandGameEvaluateOptionView
 * JD-Core Version:    0.7.0.1
 */