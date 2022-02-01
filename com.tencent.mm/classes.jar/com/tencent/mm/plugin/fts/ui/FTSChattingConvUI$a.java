package com.tencent.mm.plugin.fts.ui;

import android.content.res.Resources;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.au;

final class FTSChattingConvUI$a
  extends RecyclerView.a<FTSChattingConvUI.b>
{
  String[] HyF;
  
  FTSChattingConvUI$a(FTSChattingConvUI paramFTSChattingConvUI)
  {
    AppMethodBeat.i(111887);
    if (!au.bwE(FTSChattingConvUI.a(paramFTSChattingConvUI)))
    {
      this.HyF = new String[7];
      this.HyF[0] = paramFTSChattingConvUI.getResources().getString(p.g.search_chatroom_date);
      this.HyF[1] = paramFTSChattingConvUI.getResources().getString(p.g.search_chatroom_image_or_video);
      this.HyF[2] = paramFTSChattingConvUI.getResources().getString(p.g.search_chatroom_file);
      this.HyF[3] = paramFTSChattingConvUI.getResources().getString(p.g.search_chatroom_url);
      this.HyF[4] = paramFTSChattingConvUI.getResources().getString(p.g.search_chatroom_music);
      this.HyF[5] = paramFTSChattingConvUI.getResources().getString(p.g.search_chatroom_pay);
      this.HyF[6] = paramFTSChattingConvUI.getResources().getString(p.g.search_chatroom_appbrand);
      AppMethodBeat.o(111887);
      return;
    }
    this.HyF = new String[8];
    this.HyF[0] = paramFTSChattingConvUI.getResources().getString(p.g.search_chatroom_member);
    this.HyF[1] = paramFTSChattingConvUI.getResources().getString(p.g.search_chatroom_date);
    this.HyF[2] = paramFTSChattingConvUI.getResources().getString(p.g.search_chatroom_image_or_video);
    this.HyF[3] = paramFTSChattingConvUI.getResources().getString(p.g.search_chatroom_file);
    this.HyF[4] = paramFTSChattingConvUI.getResources().getString(p.g.search_chatroom_url);
    this.HyF[5] = paramFTSChattingConvUI.getResources().getString(p.g.search_chatroom_music);
    this.HyF[6] = paramFTSChattingConvUI.getResources().getString(p.g.search_chatroom_pay);
    this.HyF[7] = paramFTSChattingConvUI.getResources().getString(p.g.search_chatroom_appbrand);
    AppMethodBeat.o(111887);
  }
  
  public final int getItemCount()
  {
    return this.HyF.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSChattingConvUI.a
 * JD-Core Version:    0.7.0.1
 */