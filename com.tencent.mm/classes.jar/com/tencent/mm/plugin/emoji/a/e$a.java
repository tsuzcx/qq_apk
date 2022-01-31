package com.tencent.mm.plugin.emoji.a;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$a
{
  TextView gpL;
  ImageView ivs;
  View lef;
  ImageView leg;
  
  public e$a(e parame, View paramView)
  {
    AppMethodBeat.i(52739);
    this.leg = ((ImageView)paramView.findViewById(2131823620));
    this.ivs = ((ImageView)paramView.findViewById(2131823622));
    this.gpL = ((TextView)paramView.findViewById(2131823623));
    this.lef = paramView.findViewById(2131823621);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.height = e.a(parame);
      paramView.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(52739);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.e.a
 * JD-Core Version:    0.7.0.1
 */