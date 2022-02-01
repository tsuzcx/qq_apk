package com.tencent.mm.plugin.groupsolitaire.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.groupsolitaire.b.b;
import com.tencent.mm.plugin.groupsolitaire.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h;

final class GroupSolitatireEditUI$25
  implements MenuItem.OnMenuItemClickListener
{
  GroupSolitatireEditUI$25(GroupSolitatireEditUI paramGroupSolitatireEditUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(110458);
    ad.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "send group solitaire(sending:%s)", new Object[] { Boolean.valueOf(GroupSolitatireEditUI.k(this.srR)) });
    if (GroupSolitatireEditUI.k(this.srR))
    {
      AppMethodBeat.o(110458);
      return true;
    }
    b.a(GroupSolitatireEditUI.l(this.srR), u.aqG(), GroupSolitatireEditUI.c(this.srR));
    if (GroupSolitatireEditUI.c(this.srR).srb) {
      h.d(this.srR.getContext(), this.srR.getString(2131760105), "", this.srR.getString(2131760104), this.srR.getString(2131760103), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(110456);
          ad.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "group solitatire repeat dialog ok");
          GroupSolitatireEditUI.m(GroupSolitatireEditUI.25.this.srR);
          AppMethodBeat.o(110456);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(110457);
          ad.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "group solitatire repeat dialog cancel");
          AppMethodBeat.o(110457);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(110458);
      return true;
      GroupSolitatireEditUI.m(this.srR);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.25
 * JD-Core Version:    0.7.0.1
 */