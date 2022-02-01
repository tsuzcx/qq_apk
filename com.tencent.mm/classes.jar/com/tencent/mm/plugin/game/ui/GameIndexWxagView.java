package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.plugin.game.d.eq;
import com.tencent.mm.sdk.platformtools.ae;

public class GameIndexWxagView
  extends LinearLayout
  implements View.OnClickListener
{
  ViewGroup mContainer;
  LayoutInflater mInflater;
  int uoy;
  
  public GameIndexWxagView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42174);
    setOrientation(1);
    this.mInflater = ((LayoutInflater)getContext().getSystemService("layout_inflater"));
    this.mContainer = this;
    AppMethodBeat.o(42174);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42176);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/game/ui/GameIndexWxagView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof a)))
    {
      a.a(this, "com/tencent/mm/plugin/game/ui/GameIndexWxagView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42176);
      return;
    }
    paramView = (a)paramView.getTag();
    if (paramView.uBg == null)
    {
      a.a(this, "com/tencent/mm/plugin/game/ui/GameIndexWxagView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42176);
      return;
    }
    localObject = new AppBrandStatObject();
    ((AppBrandStatObject)localObject).scene = 1079;
    ((p)g.ab(p.class)).a(getContext(), paramView.uBg.nIJ, paramView.uBg.ikm, paramView.uBg.uvQ, 0, paramView.uBg.uuA, (AppBrandStatObject)localObject);
    f.a(getContext(), 10, 1025, paramView.upr, 30, paramView.uBg.ikm, this.uoy, null);
    a.a(this, "com/tencent/mm/plugin/game/ui/GameIndexWxagView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42176);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42175);
    super.onFinishInflate();
    ae.i("MicroMsg.GameIndexWxagView", "initView finished");
    AppMethodBeat.o(42175);
  }
  
  static final class a
  {
    public eq uBg;
    public int upr;
    
    public a(int paramInt, eq parameq)
    {
      this.upr = paramInt;
      this.uBg = parameq;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameIndexWxagView
 * JD-Core Version:    0.7.0.1
 */