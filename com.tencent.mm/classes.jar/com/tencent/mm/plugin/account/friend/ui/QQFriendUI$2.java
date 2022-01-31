package com.tencent.mm.plugin.account.friend.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.tools.q.b;

final class QQFriendUI$2
  implements q.b
{
  QQFriendUI$2(QQFriendUI paramQQFriendUI) {}
  
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
    AppMethodBeat.i(108614);
    QQFriendUI.a(this.gzZ, bo.wC(paramString));
    QQFriendUI.a(this.gzZ, true);
    paramString = this.gzZ;
    if (paramString.gzW != null) {
      paramString.gzW.wQ(paramString.gvZ);
    }
    AppMethodBeat.o(108614);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.QQFriendUI.2
 * JD-Core Version:    0.7.0.1
 */