package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.tools.q.b;

final class GoogleFriendUI$2
  implements q.b
{
  GoogleFriendUI$2(GoogleFriendUI paramGoogleFriendUI) {}
  
  public final void apN() {}
  
  public final void apO() {}
  
  public final void apP() {}
  
  public final void apQ() {}
  
  public final boolean wR(String paramString)
  {
    return false;
  }
  
  public final void wS(String paramString)
  {
    AppMethodBeat.i(13651);
    GoogleFriendUI.a(this.gvr, bo.wC(paramString));
    if (GoogleFriendUI.a(this.gvr) != null) {
      GoogleFriendUI.a(this.gvr).wQ(GoogleFriendUI.b(this.gvr));
    }
    AppMethodBeat.o(13651);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.GoogleFriendUI.2
 * JD-Core Version:    0.7.0.1
 */