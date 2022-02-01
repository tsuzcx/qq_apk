package com.tencent.mm.plugin.groupsolitaire.ui;

import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMEditText;

final class GroupSolitatireEditUI$17
  implements Runnable
{
  GroupSolitatireEditUI$17(GroupSolitatireEditUI paramGroupSolitatireEditUI, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(262657);
    if (this.Jkf > 0)
    {
      Log.d("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "Scroll");
      ScrollView localScrollView = GroupSolitatireEditUI.i(this.Jkd);
      int i = this.Jkf;
      localScrollView.smoothScrollBy(0, ((MMEditText)GroupSolitatireEditUI.b(this.Jkd)).getLineHeight() + i);
    }
    AppMethodBeat.o(262657);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.17
 * JD-Core Version:    0.7.0.1
 */