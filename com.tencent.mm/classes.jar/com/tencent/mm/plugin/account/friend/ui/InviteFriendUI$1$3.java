package com.tencent.mm.plugin.account.friend.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

final class InviteFriendUI$1$3
  implements n.c
{
  InviteFriendUI$1$3(InviteFriendUI.1 param1, HashMap paramHashMap) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(108573);
    Iterator localIterator = this.gzB.keySet().iterator();
    while (localIterator.hasNext()) {
      paraml.add((String)localIterator.next());
    }
    AppMethodBeat.o(108573);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.InviteFriendUI.1.3
 * JD-Core Version:    0.7.0.1
 */