package com.tencent.mm.plugin.fts.ui;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FTSChattingConvUI$b
  extends RecyclerView.v
{
  TextView euY;
  
  public FTSChattingConvUI$b(FTSChattingConvUI paramFTSChattingConvUI, View paramView)
  {
    super(paramView);
    AppMethodBeat.i(61796);
    this.euY = ((TextView)paramView.findViewById(2131820680));
    this.euY.setOnClickListener(paramFTSChattingConvUI);
    AppMethodBeat.o(61796);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSChattingConvUI.b
 * JD-Core Version:    0.7.0.1
 */