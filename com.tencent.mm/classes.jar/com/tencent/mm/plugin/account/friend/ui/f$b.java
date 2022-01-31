package com.tencent.mm.plugin.account.friend.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f$b
{
  String account;
  ImageView ehv;
  TextView gpr;
  int gvH;
  View gvJ;
  TextView gvP;
  TextView gvQ;
  TextView gvR;
  ProgressBar gvS;
  int status;
  
  public f$b(f paramf, View paramView)
  {
    AppMethodBeat.i(108605);
    this.gvP = ((TextView)paramView.findViewById(2131824297));
    this.ehv = ((ImageView)paramView.findViewById(2131824298));
    this.gvQ = ((TextView)paramView.findViewById(2131824299));
    this.gvR = ((TextView)paramView.findViewById(2131824300));
    this.gvJ = paramView.findViewById(2131824301);
    this.gpr = ((TextView)paramView.findViewById(2131824302));
    this.gvS = ((ProgressBar)paramView.findViewById(2131824303));
    this.gvJ.setOnClickListener(new f.b.1(this, paramf));
    AppMethodBeat.o(108605);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.f.b
 * JD-Core Version:    0.7.0.1
 */