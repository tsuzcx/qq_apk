package com.tencent.mm.plugin.account.friend.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class QQFriendUI$3
  implements d.a
{
  QQFriendUI$3(QQFriendUI paramQQFriendUI) {}
  
  public final void mQ(int paramInt)
  {
    AppMethodBeat.i(108615);
    if (QQFriendUI.a(this.gzZ))
    {
      if (paramInt <= 0) {
        break label46;
      }
      QQFriendUI.b(this.gzZ).setVisibility(8);
    }
    for (;;)
    {
      QQFriendUI.a(this.gzZ, false);
      AppMethodBeat.o(108615);
      return;
      label46:
      QQFriendUI.b(this.gzZ).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.QQFriendUI.3
 * JD-Core Version:    0.7.0.1
 */