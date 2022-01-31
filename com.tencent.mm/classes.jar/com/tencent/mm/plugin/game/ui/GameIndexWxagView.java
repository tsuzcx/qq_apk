package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.r.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.game.d.do;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.sdk.platformtools.y;

public class GameIndexWxagView
  extends LinearLayout
  implements View.OnClickListener
{
  LayoutInflater Lu;
  int kQh;
  ViewGroup mContainer;
  
  public GameIndexWxagView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(1);
    this.Lu = ((LayoutInflater)getContext().getSystemService("layout_inflater"));
    this.mContainer = this;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof GameIndexWxagView.a))) {}
    do
    {
      return;
      paramView = (GameIndexWxagView.a)paramView.getTag();
    } while (paramView.lbZ == null);
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = 1079;
    ((d)g.r(d.class)).a(getContext(), paramView.lbZ.hPY, paramView.lbZ.euK, paramView.lbZ.kWu, 0, paramView.lbZ.kWt, localAppBrandStatObject);
    b.a(getContext(), 10, 1025, paramView.kRc, 30, paramView.lbZ.euK, this.kQh, null);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    y.i("MicroMsg.GameIndexWxagView", "initView finished");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameIndexWxagView
 * JD-Core Version:    0.7.0.1
 */