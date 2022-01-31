package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.ad;
import com.tencent.mm.plugin.game.d.as;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bo;

public class GameBestSellingMore
  extends LinearLayout
  implements View.OnClickListener
{
  private d nvA;
  private TextView nvB;
  private ImageView nvC;
  
  public GameBestSellingMore(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(111734);
    if ((this.nvA == null) || (this.nvA.nmr == null) || (this.nvA.nmr.nro == null) || (bo.isNullOrNil(this.nvA.nmr.nro.nrQ)))
    {
      AppMethodBeat.o(111734);
      return;
    }
    int i = com.tencent.mm.plugin.game.f.c.ax(getContext(), this.nvA.nmr.nro.nrQ);
    com.tencent.mm.game.report.c.a(getContext(), 10, 1022, 999, i, null, GameIndexListView.getSourceScene(), a.lR(this.nvA.nmr.nqt));
    AppMethodBeat.o(111734);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(111732);
    super.onFinishInflate();
    this.nvB = ((TextView)findViewById(2131824428));
    this.nvC = ((ImageView)findViewById(2131824429));
    setOnClickListener(this);
    AppMethodBeat.o(111732);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(111733);
    this.nvA = paramd;
    if ((paramd == null) || (paramd.nmr == null) || (paramd.nmr.nro == null) || (bo.isNullOrNil(paramd.nmr.nro.nrx)))
    {
      this.nvB.setVisibility(8);
      this.nvC.setVisibility(8);
      setPadding(0, 0, 0, 0);
      AppMethodBeat.o(111733);
      return;
    }
    setPadding(getResources().getDimensionPixelSize(2131427724), 0, getResources().getDimensionPixelSize(2131427724), getResources().getDimensionPixelSize(2131427724));
    this.nvB.setVisibility(0);
    this.nvC.setVisibility(0);
    this.nvB.setText(paramd.nmr.nro.nrx);
    AppMethodBeat.o(111733);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameBestSellingMore
 * JD-Core Version:    0.7.0.1
 */