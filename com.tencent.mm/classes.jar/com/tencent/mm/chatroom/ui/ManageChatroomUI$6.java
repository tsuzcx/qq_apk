package com.tencent.mm.chatroom.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.e.b;
import com.tencent.mm.plugin.messenger.foundation.a.e.c;
import com.tencent.mm.protocal.protobuf.dzn;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.q.g;
import java.util.LinkedList;

final class ManageChatroomUI$6
  implements q.g
{
  ManageChatroomUI$6(ManageChatroomUI paramManageChatroomUI, dzn paramdzn, com.tencent.mm.ui.widget.a.e parame) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(193660);
    if (paramMenuItem.getItemId() == 1)
    {
      paramMenuItem = new e.b();
      paramMenuItem.appId = this.jaO.lVG;
      paramMenuItem.EVz = ManageChatroomUI.c(this.jaN);
      paramMenuItem.EVB = 1;
      ((com.tencent.mm.plugin.messenger.foundation.a.e)h.ae(com.tencent.mm.plugin.messenger.foundation.a.e.class)).a(this.jaN.getContext(), paramMenuItem, new e.c()
      {
        public final void h(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(186842);
          if (!paramAnonymousBoolean)
          {
            AppMethodBeat.o(186842);
            return;
          }
          if ((ManageChatroomUI.d(ManageChatroomUI.6.this.jaN) != null) && (!Util.isNullOrNil(ManageChatroomUI.d(ManageChatroomUI.6.this.jaN).Ufa)))
          {
            paramAnonymousString = ManageChatroomUI.d(ManageChatroomUI.6.this.jaN);
            paramAnonymousString.UeZ -= 1;
          }
          try
          {
            ManageChatroomUI.d(ManageChatroomUI.6.this.jaN).Ufa.removeFirst();
            ManageChatroomUI.a(ManageChatroomUI.6.this.jaN);
            AppMethodBeat.o(186842);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            for (;;)
            {
              Log.e("MicroMsg.ManageChatroomUI", paramAnonymousString.getMessage());
            }
          }
        }
      });
      this.jaP.bYF();
    }
    AppMethodBeat.o(193660);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ManageChatroomUI.6
 * JD-Core Version:    0.7.0.1
 */