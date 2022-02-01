package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FTSServiceNotifyUI$b
  extends RecyclerView.v
{
  TextView dyR;
  
  public FTSServiceNotifyUI$b(FTSServiceNotifyUI paramFTSServiceNotifyUI, View paramView)
  {
    super(paramView);
    AppMethodBeat.i(265636);
    this.dyR = ((TextView)paramView.findViewById(p.d.title));
    this.dyR.setTextSize(17.0F);
    this.dyR.setOnClickListener(paramFTSServiceNotifyUI);
    AppMethodBeat.o(265636);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSServiceNotifyUI.b
 * JD-Core Version:    0.7.0.1
 */