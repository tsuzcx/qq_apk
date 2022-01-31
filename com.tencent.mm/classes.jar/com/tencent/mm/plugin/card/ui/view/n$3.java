package com.tencent.mm.plugin.card.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;

final class n$3
  implements View.OnClickListener
{
  n$3(n paramn, View paramView1, View paramView2, ImageView paramImageView, Button paramButton, ViewGroup paramViewGroup, b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(88764);
    this.kBu.setVisibility(8);
    this.kBv.setVisibility(8);
    this.kBw.setVisibility(0);
    this.kBx.setVisibility(8);
    this.kBr.kBe.d(c.kCa);
    this.kBr.d(this.kBq, this.kBt);
    AppMethodBeat.o(88764);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.n.3
 * JD-Core Version:    0.7.0.1
 */