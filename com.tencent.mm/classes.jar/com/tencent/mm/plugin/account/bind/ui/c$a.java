package com.tencent.mm.plugin.account.bind.ui;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$a
{
  String cqq;
  TextView gpr;
  int gvH;
  TextView gvI;
  View gvJ;
  ProgressBar gvK;
  int status;
  
  public c$a(c paramc, View paramView)
  {
    AppMethodBeat.i(13699);
    this.gvI = ((TextView)paramView.findViewById(2131824136));
    this.gvJ = paramView.findViewById(2131826300);
    this.gpr = ((TextView)paramView.findViewById(2131826301));
    this.gvK = ((ProgressBar)paramView.findViewById(2131826302));
    this.gvJ.setOnClickListener(new c.a.1(this, paramc));
    AppMethodBeat.o(13699);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.c.a
 * JD-Core Version:    0.7.0.1
 */