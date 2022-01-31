package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.sdk.platformtools.bo;

final class FTSAddFriendUI$4
  implements View.OnClickListener
{
  FTSAddFriendUI$4(FTSAddFriendUI paramFTSAddFriendUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(61728);
    if (!bo.isNullOrNil(this.mWA.query))
    {
      this.mWA.mWs = true;
      an.m(this.mWA.query, FTSAddFriendUI.b(this.mWA), 1, 16);
    }
    FTSAddFriendUI.c(this.mWA);
    AppMethodBeat.o(61728);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddFriendUI.4
 * JD-Core Version:    0.7.0.1
 */