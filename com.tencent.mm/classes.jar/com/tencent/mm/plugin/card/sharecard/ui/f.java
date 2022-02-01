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
  View iCR;
  b oDc;
  ImageView oDg;
  TextView oDh;
  TextView oDi;
  private MMActivity owO;
  
  public f(MMActivity paramMMActivity, View paramView)
  {
    this.owO = paramMMActivity;
    this.iCR = paramView;
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(113091);
    this.oDh.setVisibility(0);
    this.oDg.setImageDrawable(this.owO.getResources().getDrawable(2131231458));
    this.oDh.setText(2131756970);
    this.oDi.setText(2131756969);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.oDg.getLayoutParams();
    localLayoutParams.topMargin = this.owO.getResources().getDimensionPixelOffset(2131165993);
    this.oDg.setLayoutParams(localLayoutParams);
    this.oDg.invalidate();
    AppMethodBeat.o(113091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.f
 * JD-Core Version:    0.7.0.1
 */