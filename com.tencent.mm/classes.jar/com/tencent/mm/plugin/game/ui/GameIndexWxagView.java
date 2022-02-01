package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.game.d.ds;
import com.tencent.mm.sdk.platformtools.ac;

public class GameIndexWxagView
  extends LinearLayout
  implements View.OnClickListener
{
  ViewGroup mContainer;
  LayoutInflater mInflater;
  int tfA;
  
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
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof a)))
    {
      AppMethodBeat.o(42176);
      return;
    }
    paramView = (a)paramView.getTag();
    if (paramView.trn == null)
    {
      AppMethodBeat.o(42176);
      return;
    }
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = 1079;
    ((n)g.ab(n.class)).a(getContext(), paramView.trn.ncR, paramView.trn.hOf, paramView.trn.tlU, 0, paramView.trn.tlT, localAppBrandStatObject);
    e.a(getContext(), 10, 1025, paramView.tgt, 30, paramView.trn.hOf, this.tfA, null);
    AppMethodBeat.o(42176);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42175);
    super.onFinishInflate();
    ac.i("MicroMsg.GameIndexWxagView", "initView finished");
    AppMethodBeat.o(42175);
  }
  
  static final class a
  {
    public int tgt;
    public ds trn;
    
    public a(int paramInt, ds paramds)
    {
      this.tgt = paramInt;
      this.trn = paramds;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameIndexWxagView
 * JD-Core Version:    0.7.0.1
 */