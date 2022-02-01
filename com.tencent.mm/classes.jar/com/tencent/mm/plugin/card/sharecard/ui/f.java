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
  View hIZ;
  private MMActivity nqt;
  b nwI;
  ImageView nwM;
  TextView nwN;
  TextView nwO;
  
  public f(MMActivity paramMMActivity, View paramView)
  {
    this.nqt = paramMMActivity;
    this.hIZ = paramView;
  }
  
  public final void cE()
  {
    AppMethodBeat.i(113091);
    this.nwN.setVisibility(0);
    this.nwM.setImageDrawable(this.nqt.getResources().getDrawable(2131231458));
    this.nwN.setText(2131756970);
    this.nwO.setText(2131756969);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.nwM.getLayoutParams();
    localLayoutParams.topMargin = this.nqt.getResources().getDimensionPixelOffset(2131165993);
    this.nwM.setLayoutParams(localLayoutParams);
    this.nwM.invalidate();
    AppMethodBeat.o(113091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.f
 * JD-Core Version:    0.7.0.1
 */