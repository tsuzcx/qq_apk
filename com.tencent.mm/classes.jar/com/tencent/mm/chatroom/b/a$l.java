package com.tencent.mm.chatroom.b;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.e.a;
import com.tencent.mm.ui.MMFragmentActivity.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "requestBindCode", "", "bindResultCode", "bindData", "Landroid/content/Intent;", "mmOnActivityResult"})
final class a$l
  implements MMFragmentActivity.b
{
  a$l(e.a parama) {}
  
  public final void d(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(190642);
    p.k(paramIntent, "bindData");
    if ((paramInt1 == 15002) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("key_chat_room_open_id");
      e.a locala = this.iVJ;
      if (locala != null)
      {
        locala.a(true, null, paramIntent);
        AppMethodBeat.o(190642);
        return;
      }
    }
    AppMethodBeat.o(190642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.b.a.l
 * JD-Core Version:    0.7.0.1
 */