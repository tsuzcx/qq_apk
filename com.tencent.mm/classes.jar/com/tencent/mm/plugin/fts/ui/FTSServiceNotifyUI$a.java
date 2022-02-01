package com.tencent.mm.plugin.fts.ui;

import android.content.res.Resources;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FTSServiceNotifyUI$a
  extends RecyclerView.a<FTSServiceNotifyUI.b>
{
  String[] HyF;
  
  FTSServiceNotifyUI$a(FTSServiceNotifyUI paramFTSServiceNotifyUI)
  {
    AppMethodBeat.i(265632);
    this.HyF = new String[2];
    this.HyF[0] = paramFTSServiceNotifyUI.getResources().getString(p.g.search_service_notify_username);
    this.HyF[1] = paramFTSServiceNotifyUI.getResources().getString(p.g.search_chatroom_date);
    AppMethodBeat.o(265632);
  }
  
  public final int getItemCount()
  {
    return this.HyF.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSServiceNotifyUI.a
 * JD-Core Version:    0.7.0.1
 */