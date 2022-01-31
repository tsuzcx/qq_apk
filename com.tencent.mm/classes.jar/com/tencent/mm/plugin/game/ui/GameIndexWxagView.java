package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.plugin.game.d.dr;
import com.tencent.mm.sdk.platformtools.ab;

public class GameIndexWxagView
  extends LinearLayout
  implements View.OnClickListener
{
  ViewGroup mContainer;
  LayoutInflater mInflater;
  int nok;
  
  public GameIndexWxagView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111989);
    setOrientation(1);
    this.mInflater = ((LayoutInflater)getContext().getSystemService("layout_inflater"));
    this.mContainer = this;
    AppMethodBeat.o(111989);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(111991);
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof GameIndexWxagView.a)))
    {
      AppMethodBeat.o(111991);
      return;
    }
    paramView = (GameIndexWxagView.a)paramView.getTag();
    if (paramView.nzU == null)
    {
      AppMethodBeat.o(111991);
      return;
    }
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = 1079;
    ((j)g.E(j.class)).a(getContext(), paramView.nzU.jJA, paramView.nzU.fKw, paramView.nzU.nuw, 0, paramView.nzU.nuv, localAppBrandStatObject);
    c.a(getContext(), 10, 1025, paramView.npg, 30, paramView.nzU.fKw, this.nok, null);
    AppMethodBeat.o(111991);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(111990);
    super.onFinishInflate();
    ab.i("MicroMsg.GameIndexWxagView", "initView finished");
    AppMethodBeat.o(111990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameIndexWxagView
 * JD-Core Version:    0.7.0.1
 */