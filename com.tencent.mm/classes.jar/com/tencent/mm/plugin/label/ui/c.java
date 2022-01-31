package com.tencent.mm.plugin.label.ui;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.widget.MMTextView;

public final class c
{
  MMTextView lCq;
  TextView lCr;
  LinearLayout lCs;
  
  public c(View paramView)
  {
    this.lCq = ((MMTextView)paramView.findViewById(R.h.label_item_title));
    this.lCr = ((TextView)paramView.findViewById(R.h.label_item_count));
    this.lCs = ((LinearLayout)paramView.findViewById(R.h.label_item_container));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.c
 * JD-Core Version:    0.7.0.1
 */