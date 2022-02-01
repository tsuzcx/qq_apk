package com.tencent.mm.chatroom.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.c.b;
import com.tencent.mm.plugin.messenger.foundation.a.c.c;
import com.tencent.mm.protocal.protobuf.cwx;
import com.tencent.mm.protocal.protobuf.cwy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e;
import java.util.LinkedList;

final class ManageChatroomUI$6
  implements n.e
{
  ManageChatroomUI$6(ManageChatroomUI paramManageChatroomUI, cwx paramcwx, e parame) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(217219);
    if (paramMenuItem.getItemId() == 1)
    {
      paramMenuItem = new c.b();
      paramMenuItem.appId = this.fRs.ikm;
      paramMenuItem.vVV = ManageChatroomUI.c(this.fRr);
      paramMenuItem.vVX = 1;
      ((c)g.ab(c.class)).a(this.fRr.getContext(), paramMenuItem, new c.c()
      {
        public final void e(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(217218);
          if (!paramAnonymousBoolean)
          {
            AppMethodBeat.o(217218);
            return;
          }
          if ((ManageChatroomUI.d(ManageChatroomUI.6.this.fRr) != null) && (!bu.ht(ManageChatroomUI.d(ManageChatroomUI.6.this.fRr).HHH)))
          {
            paramAnonymousString = ManageChatroomUI.d(ManageChatroomUI.6.this.fRr);
            paramAnonymousString.HHG -= 1;
          }
          try
          {
            ManageChatroomUI.d(ManageChatroomUI.6.this.fRr).HHH.removeFirst();
            ManageChatroomUI.a(ManageChatroomUI.6.this.fRr);
            AppMethodBeat.o(217218);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            for (;;)
            {
              ae.e("MicroMsg.ManageChatroomUI", paramAnonymousString.getMessage());
            }
          }
        }
      });
      this.fRt.bqD();
    }
    AppMethodBeat.o(217219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ManageChatroomUI.6
 * JD-Core Version:    0.7.0.1
 */