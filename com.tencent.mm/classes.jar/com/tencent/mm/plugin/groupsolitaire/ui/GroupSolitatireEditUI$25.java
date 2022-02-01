package com.tencent.mm.plugin.groupsolitaire.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.groupsolitaire.b.g;
import com.tencent.mm.plugin.groupsolitaire.b.b;
import com.tencent.mm.plugin.groupsolitaire.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.k;

final class GroupSolitatireEditUI$25
  implements MenuItem.OnMenuItemClickListener
{
  GroupSolitatireEditUI$25(GroupSolitatireEditUI paramGroupSolitatireEditUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(110458);
    Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "send group solitaire(sending:%s)", new Object[] { Boolean.valueOf(GroupSolitatireEditUI.k(this.Jkd)) });
    if (GroupSolitatireEditUI.k(this.Jkd))
    {
      AppMethodBeat.o(110458);
      return true;
    }
    b.a(GroupSolitatireEditUI.l(this.Jkd), z.bAM(), GroupSolitatireEditUI.c(this.Jkd));
    if (GroupSolitatireEditUI.c(this.Jkd).Jjp) {
      k.b(this.Jkd.getContext(), this.Jkd.getString(b.g.JiC), "", this.Jkd.getString(b.g.JiB), this.Jkd.getString(b.g.JiA), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(110456);
          Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "group solitatire repeat dialog ok");
          GroupSolitatireEditUI.m(GroupSolitatireEditUI.25.this.Jkd);
          AppMethodBeat.o(110456);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(110457);
          Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "group solitatire repeat dialog cancel");
          AppMethodBeat.o(110457);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(110458);
      return true;
      GroupSolitatireEditUI.m(this.Jkd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.25
 * JD-Core Version:    0.7.0.1
 */