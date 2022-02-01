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
import com.tencent.mm.sdk.platformtools.ad;

public class GameIndexWxagView
  extends LinearLayout
  implements View.OnClickListener
{
  ViewGroup mContainer;
  LayoutInflater mInflater;
  int rXI;
  
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
    if (paramView.sju == null)
    {
      AppMethodBeat.o(42176);
      return;
    }
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = 1079;
    ((n)g.ab(n.class)).a(getContext(), paramView.sju.mAQ, paramView.sju.hnC, paramView.sju.sea, 0, paramView.sju.sdZ, localAppBrandStatObject);
    e.a(getContext(), 10, 1025, paramView.rYB, 30, paramView.sju.hnC, this.rXI, null);
    AppMethodBeat.o(42176);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42175);
    super.onFinishInflate();
    ad.i("MicroMsg.GameIndexWxagView", "initView finished");
    AppMethodBeat.o(42175);
  }
  
  static final class a
  {
    public int rYB;
    public ds sju;
    
    public a(int paramInt, ds paramds)
    {
      this.rYB = paramInt;
      this.sju = paramds;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameIndexWxagView
 * JD-Core Version:    0.7.0.1
 */