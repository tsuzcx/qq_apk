package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.tools.q.b;

final class MobileFriendUI$11
  implements q.b
{
  MobileFriendUI$11(MobileFriendUI paramMobileFriendUI) {}
  
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
    AppMethodBeat.i(13729);
    MobileFriendUI.a(this.gwb, bo.wC(paramString));
    paramString = this.gwb;
    if (paramString.gvW != null) {
      paramString.gvW.wQ(paramString.gvZ);
    }
    AppMethodBeat.o(13729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.MobileFriendUI.11
 * JD-Core Version:    0.7.0.1
 */