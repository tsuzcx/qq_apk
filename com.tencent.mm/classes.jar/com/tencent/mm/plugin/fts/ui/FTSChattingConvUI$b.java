package com.tencent.mm.plugin.fts.ui;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.TextView;

final class FTSChattingConvUI$b
  extends RecyclerView.v
{
  TextView flb;
  
  public FTSChattingConvUI$b(FTSChattingConvUI paramFTSChattingConvUI, View paramView)
  {
    super(paramView);
    this.flb = ((TextView)paramView.findViewById(n.d.title));
    this.flb.setOnClickListener(paramFTSChattingConvUI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSChattingConvUI.b
 * JD-Core Version:    0.7.0.1
 */