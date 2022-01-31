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
  View iCk;
  private MMActivity jpX;
  b krp;
  ImageView krt;
  TextView kru;
  TextView krv;
  
  public f(MMActivity paramMMActivity, View paramView)
  {
    this.jpX = paramMMActivity;
    this.iCk = paramView;
  }
  
  public final void bJ()
  {
    AppMethodBeat.i(88157);
    this.kru.setVisibility(0);
    this.krt.setImageDrawable(this.jpX.getResources().getDrawable(2130838130));
    this.kru.setText(2131298028);
    this.krv.setText(2131298027);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.krt.getLayoutParams();
    localLayoutParams.topMargin = this.jpX.getResources().getDimensionPixelOffset(2131428194);
    this.krt.setLayoutParams(localLayoutParams);
    this.krt.invalidate();
    AppMethodBeat.o(88157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.f
 * JD-Core Version:    0.7.0.1
 */