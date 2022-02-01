package com.tencent.mm.plugin.fts.ui;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;

final class FTSChattingConvUI$a
  extends RecyclerView.a<FTSChattingConvUI.b>
{
  String[] rtO;
  
  FTSChattingConvUI$a(FTSChattingConvUI paramFTSChattingConvUI)
  {
    AppMethodBeat.i(111887);
    if (!w.sl(FTSChattingConvUI.a(paramFTSChattingConvUI)))
    {
      this.rtO = new String[7];
      this.rtO[0] = paramFTSChattingConvUI.getResources().getString(2131762907);
      this.rtO[1] = paramFTSChattingConvUI.getResources().getString(2131762909);
      this.rtO[2] = paramFTSChattingConvUI.getResources().getString(2131762908);
      this.rtO[3] = paramFTSChattingConvUI.getResources().getString(2131762913);
      this.rtO[4] = paramFTSChattingConvUI.getResources().getString(2131762911);
      this.rtO[5] = paramFTSChattingConvUI.getResources().getString(2131762912);
      this.rtO[6] = paramFTSChattingConvUI.getResources().getString(2131762906);
      AppMethodBeat.o(111887);
      return;
    }
    this.rtO = new String[8];
    this.rtO[0] = paramFTSChattingConvUI.getResources().getString(2131762910);
    this.rtO[1] = paramFTSChattingConvUI.getResources().getString(2131762907);
    this.rtO[2] = paramFTSChattingConvUI.getResources().getString(2131762909);
    this.rtO[3] = paramFTSChattingConvUI.getResources().getString(2131762908);
    this.rtO[4] = paramFTSChattingConvUI.getResources().getString(2131762913);
    this.rtO[5] = paramFTSChattingConvUI.getResources().getString(2131762911);
    this.rtO[6] = paramFTSChattingConvUI.getResources().getString(2131762912);
    this.rtO[7] = paramFTSChattingConvUI.getResources().getString(2131762906);
    AppMethodBeat.o(111887);
  }
  
  public final int getItemCount()
  {
    return this.rtO.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSChattingConvUI.a
 * JD-Core Version:    0.7.0.1
 */