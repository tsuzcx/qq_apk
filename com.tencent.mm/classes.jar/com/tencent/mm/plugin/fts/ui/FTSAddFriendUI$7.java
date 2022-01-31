package com.tencent.mm.plugin.fts.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aj;
import com.tencent.mm.g.a.aj.b;

final class FTSAddFriendUI$7
  implements Runnable
{
  FTSAddFriendUI$7(FTSAddFriendUI paramFTSAddFriendUI, aj paramaj) {}
  
  public final void run()
  {
    AppMethodBeat.i(61731);
    FTSAddFriendUI.d(this.mWA);
    if (!this.mWC.cnu.cnz) {
      FTSAddFriendUI.b(this.mWA, -1);
    }
    for (;;)
    {
      FTSAddFriendUI.h(this.mWA);
      AppMethodBeat.o(61731);
      return;
      FTSAddFriendUI.b(this.mWA, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddFriendUI.7
 * JD-Core Version:    0.7.0.1
 */