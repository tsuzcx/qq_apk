package com.tencent.mm.plugin.groupsolitaire.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

final class GroupSolitatireEditUI$4
  implements DialogInterface.OnClickListener
{
  GroupSolitatireEditUI$4(GroupSolitatireEditUI paramGroupSolitatireEditUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(110430);
    ac.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "back_dialot cancel");
    AppMethodBeat.o(110430);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.4
 * JD-Core Version:    0.7.0.1
 */