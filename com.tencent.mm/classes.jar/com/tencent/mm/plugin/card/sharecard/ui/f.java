package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.ui.MMActivity;

public final class f
{
  View mrI;
  private MMActivity tmY;
  b ttp;
  ImageView ttt;
  TextView ttu;
  TextView ttv;
  
  public f(MMActivity paramMMActivity, View paramView)
  {
    this.tmY = paramMMActivity;
    this.mrI = paramView;
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(113091);
    this.ttu.setVisibility(0);
    this.ttt.setImageDrawable(this.tmY.getResources().getDrawable(a.c.taf));
    this.ttu.setText(a.g.tlt);
    this.ttv.setText(a.g.tls);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.ttt.getLayoutParams();
    localLayoutParams.topMargin = this.tmY.getResources().getDimensionPixelOffset(a.b.sZW);
    this.ttt.setLayoutParams(localLayoutParams);
    this.ttt.invalidate();
    AppMethodBeat.o(113091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.f
 * JD-Core Version:    0.7.0.1
 */