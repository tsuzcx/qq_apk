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
  View ijA;
  private MMActivity nTt;
  b nZI;
  ImageView nZM;
  TextView nZN;
  TextView nZO;
  
  public f(MMActivity paramMMActivity, View paramView)
  {
    this.nTt = paramMMActivity;
    this.ijA = paramView;
  }
  
  public final void cL()
  {
    AppMethodBeat.i(113091);
    this.nZN.setVisibility(0);
    this.nZM.setImageDrawable(this.nTt.getResources().getDrawable(2131231458));
    this.nZN.setText(2131756970);
    this.nZO.setText(2131756969);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.nZM.getLayoutParams();
    localLayoutParams.topMargin = this.nTt.getResources().getDimensionPixelOffset(2131165993);
    this.nZM.setLayoutParams(localLayoutParams);
    this.nZM.invalidate();
    AppMethodBeat.o(113091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.f
 * JD-Core Version:    0.7.0.1
 */