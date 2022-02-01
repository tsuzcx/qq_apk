package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.ui.MMActivity;

public final class f
{
  View jBN;
  private MMActivity pQZ;
  b pXs;
  ImageView pXw;
  TextView pXx;
  TextView pXy;
  
  public f(MMActivity paramMMActivity, View paramView)
  {
    this.pQZ = paramMMActivity;
    this.jBN = paramView;
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(113091);
    this.pXx.setVisibility(0);
    this.pXw.setImageDrawable(this.pQZ.getResources().getDrawable(2131231522));
    this.pXx.setText(2131757140);
    this.pXy.setText(2131757139);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.pXw.getLayoutParams();
    localLayoutParams.topMargin = this.pQZ.getResources().getDimensionPixelOffset(2131166025);
    this.pXw.setLayoutParams(localLayoutParams);
    this.pXw.invalidate();
    AppMethodBeat.o(113091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.f
 * JD-Core Version:    0.7.0.1
 */