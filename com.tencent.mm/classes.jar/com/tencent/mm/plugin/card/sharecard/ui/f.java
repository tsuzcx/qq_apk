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
  View iFK;
  private MMActivity oDq;
  b oJE;
  ImageView oJI;
  TextView oJJ;
  TextView oJK;
  
  public f(MMActivity paramMMActivity, View paramView)
  {
    this.oDq = paramMMActivity;
    this.iFK = paramView;
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(113091);
    this.oJJ.setVisibility(0);
    this.oJI.setImageDrawable(this.oDq.getResources().getDrawable(2131231458));
    this.oJJ.setText(2131756970);
    this.oJK.setText(2131756969);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.oJI.getLayoutParams();
    localLayoutParams.topMargin = this.oDq.getResources().getDimensionPixelOffset(2131165993);
    this.oJI.setLayoutParams(localLayoutParams);
    this.oJI.invalidate();
    AppMethodBeat.o(113091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.f
 * JD-Core Version:    0.7.0.1
 */