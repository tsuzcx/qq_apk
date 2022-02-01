package com.tencent.mm.plugin.label.ui;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.widget.MMTextView;

public final class c
{
  MMTextView Efc;
  TextView Efd;
  LinearLayout Efe;
  CheckBox Eff;
  ImageView Efg;
  
  public c(View paramView)
  {
    AppMethodBeat.i(26323);
    this.Efc = ((MMTextView)paramView.findViewById(R.h.dKC));
    this.Efd = ((TextView)paramView.findViewById(R.h.dKB));
    this.Efe = ((LinearLayout)paramView.findViewById(R.h.dKA));
    this.Eff = ((CheckBox)paramView.findViewById(R.h.dAy));
    this.Efg = ((ImageView)paramView.findViewById(R.h.dAx));
    AppMethodBeat.o(26323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.c
 * JD-Core Version:    0.7.0.1
 */