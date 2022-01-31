package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.friend.a.n;
import com.tencent.mm.ui.base.h.d;
import java.util.ArrayList;

final class GoogleFriendUI$4
  implements h.d
{
  GoogleFriendUI$4(GoogleFriendUI paramGoogleFriendUI, ArrayList paramArrayList, n paramn) {}
  
  public final void ca(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(13653);
    if (paramInt2 != -1) {
      GoogleFriendUI.a(this.gvr, (n)this.gvs.get(paramInt2), this.gvt);
    }
    AppMethodBeat.o(13653);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.GoogleFriendUI.4
 * JD-Core Version:    0.7.0.1
 */