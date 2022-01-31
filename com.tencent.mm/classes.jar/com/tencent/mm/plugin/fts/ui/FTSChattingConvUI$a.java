package com.tencent.mm.plugin.fts.ui;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;

final class FTSChattingConvUI$a
  extends RecyclerView.a<FTSChattingConvUI.b>
{
  String[] mWZ;
  
  FTSChattingConvUI$a(FTSChattingConvUI paramFTSChattingConvUI)
  {
    AppMethodBeat.i(61793);
    if (!t.nI(FTSChattingConvUI.a(paramFTSChattingConvUI)))
    {
      this.mWZ = new String[7];
      this.mWZ[0] = paramFTSChattingConvUI.getResources().getString(2131302969);
      this.mWZ[1] = paramFTSChattingConvUI.getResources().getString(2131302971);
      this.mWZ[2] = paramFTSChattingConvUI.getResources().getString(2131302970);
      this.mWZ[3] = paramFTSChattingConvUI.getResources().getString(2131302975);
      this.mWZ[4] = paramFTSChattingConvUI.getResources().getString(2131302973);
      this.mWZ[5] = paramFTSChattingConvUI.getResources().getString(2131302974);
      this.mWZ[6] = paramFTSChattingConvUI.getResources().getString(2131302968);
      AppMethodBeat.o(61793);
      return;
    }
    this.mWZ = new String[8];
    this.mWZ[0] = paramFTSChattingConvUI.getResources().getString(2131302972);
    this.mWZ[1] = paramFTSChattingConvUI.getResources().getString(2131302969);
    this.mWZ[2] = paramFTSChattingConvUI.getResources().getString(2131302971);
    this.mWZ[3] = paramFTSChattingConvUI.getResources().getString(2131302970);
    this.mWZ[4] = paramFTSChattingConvUI.getResources().getString(2131302975);
    this.mWZ[5] = paramFTSChattingConvUI.getResources().getString(2131302973);
    this.mWZ[6] = paramFTSChattingConvUI.getResources().getString(2131302974);
    this.mWZ[7] = paramFTSChattingConvUI.getResources().getString(2131302968);
    AppMethodBeat.o(61793);
  }
  
  public final int getItemCount()
  {
    return this.mWZ.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSChattingConvUI.a
 * JD-Core Version:    0.7.0.1
 */