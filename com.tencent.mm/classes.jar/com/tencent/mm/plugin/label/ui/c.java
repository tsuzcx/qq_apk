package com.tencent.mm.plugin.label.ui;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMTextView;

public final class c
{
  MMTextView sNB;
  TextView sNC;
  LinearLayout sND;
  
  public c(View paramView)
  {
    AppMethodBeat.i(26323);
    this.sNB = ((MMTextView)paramView.findViewById(2131301287));
    this.sNC = ((TextView)paramView.findViewById(2131301286));
    this.sND = ((LinearLayout)paramView.findViewById(2131301285));
    AppMethodBeat.o(26323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.c
 * JD-Core Version:    0.7.0.1
 */