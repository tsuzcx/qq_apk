package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FTSChattingConvUI$b
  extends RecyclerView.v
{
  TextView dyR;
  
  public FTSChattingConvUI$b(FTSChattingConvUI paramFTSChattingConvUI, View paramView)
  {
    super(paramView);
    AppMethodBeat.i(111890);
    this.dyR = ((TextView)paramView.findViewById(p.d.title));
    this.dyR.setOnClickListener(paramFTSChattingConvUI);
    AppMethodBeat.o(111890);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSChattingConvUI.b
 * JD-Core Version:    0.7.0.1
 */