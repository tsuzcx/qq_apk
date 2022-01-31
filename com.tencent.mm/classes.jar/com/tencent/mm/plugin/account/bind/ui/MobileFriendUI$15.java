package com.tencent.mm.plugin.account.bind.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MobileFriendUI$15
  implements b.a
{
  MobileFriendUI$15(MobileFriendUI paramMobileFriendUI) {}
  
  public final void mQ(int paramInt)
  {
    AppMethodBeat.i(13733);
    if (paramInt > 0)
    {
      MobileFriendUI.g(this.gwb).setVisibility(8);
      AppMethodBeat.o(13733);
      return;
    }
    MobileFriendUI.g(this.gwb).setVisibility(0);
    AppMethodBeat.o(13733);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.MobileFriendUI.15
 * JD-Core Version:    0.7.0.1
 */