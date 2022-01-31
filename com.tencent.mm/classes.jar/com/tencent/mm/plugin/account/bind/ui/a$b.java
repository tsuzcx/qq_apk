package com.tencent.mm.plugin.account.bind.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$b
{
  ImageView ehv;
  TextView gpr;
  String gvd;
  TextView gve;
  TextView gvf;
  View gvg;
  ProgressBar gvh;
  int position;
  
  public a$b(a parama, View paramView)
  {
    AppMethodBeat.i(13643);
    this.ehv = ((ImageView)paramView.findViewById(2131824794));
    this.gve = ((TextView)paramView.findViewById(2131824795));
    this.gvg = paramView.findViewById(2131824797);
    this.gpr = ((TextView)paramView.findViewById(2131824798));
    this.gvh = ((ProgressBar)paramView.findViewById(2131824799));
    this.gvf = ((TextView)paramView.findViewById(2131824796));
    this.gvg.setOnClickListener(new a.b.1(this, parama));
    AppMethodBeat.o(13643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.a.b
 * JD-Core Version:    0.7.0.1
 */