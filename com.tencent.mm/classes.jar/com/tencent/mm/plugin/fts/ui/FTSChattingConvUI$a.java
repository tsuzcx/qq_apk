package com.tencent.mm.plugin.fts.ui;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import com.tencent.mm.model.s;

final class FTSChattingConvUI$a
  extends RecyclerView.a<FTSChattingConvUI.b>
{
  String[] kBh;
  
  FTSChattingConvUI$a(FTSChattingConvUI paramFTSChattingConvUI)
  {
    if (!s.gZ(FTSChattingConvUI.b(paramFTSChattingConvUI)))
    {
      if (FTSChattingConvUI.a(paramFTSChattingConvUI))
      {
        this.kBh = new String[2];
        this.kBh[0] = paramFTSChattingConvUI.getResources().getString(n.g.search_chatroom_date);
        this.kBh[1] = paramFTSChattingConvUI.getResources().getString(n.g.search_chatroom_image_or_video);
        return;
      }
      this.kBh = new String[6];
      this.kBh[0] = paramFTSChattingConvUI.getResources().getString(n.g.search_chatroom_date);
      this.kBh[1] = paramFTSChattingConvUI.getResources().getString(n.g.search_chatroom_image_or_video);
      this.kBh[2] = paramFTSChattingConvUI.getResources().getString(n.g.search_chatroom_file);
      this.kBh[3] = paramFTSChattingConvUI.getResources().getString(n.g.search_chatroom_url);
      this.kBh[4] = paramFTSChattingConvUI.getResources().getString(n.g.search_chatroom_music);
      this.kBh[5] = paramFTSChattingConvUI.getResources().getString(n.g.search_chatroom_pay);
      return;
    }
    this.kBh = new String[7];
    this.kBh[0] = paramFTSChattingConvUI.getResources().getString(n.g.search_chatroom_member);
    this.kBh[1] = paramFTSChattingConvUI.getResources().getString(n.g.search_chatroom_date);
    this.kBh[2] = paramFTSChattingConvUI.getResources().getString(n.g.search_chatroom_image_or_video);
    this.kBh[3] = paramFTSChattingConvUI.getResources().getString(n.g.search_chatroom_file);
    this.kBh[4] = paramFTSChattingConvUI.getResources().getString(n.g.search_chatroom_url);
    this.kBh[5] = paramFTSChattingConvUI.getResources().getString(n.g.search_chatroom_music);
    this.kBh[6] = paramFTSChattingConvUI.getResources().getString(n.g.search_chatroom_pay);
  }
  
  public final int getItemCount()
  {
    return this.kBh.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSChattingConvUI.a
 * JD-Core Version:    0.7.0.1
 */