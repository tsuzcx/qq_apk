package com.tencent.mm.plugin.groupsolitaire.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.plugin.groupsolitaire.c.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;

final class GroupSolitatireEditUI$26
  implements Runnable
{
  GroupSolitatireEditUI$26(GroupSolitatireEditUI paramGroupSolitatireEditUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(110459);
    Bitmap localBitmap = c.a(GroupSolitatireEditUI.c(this.srR).field_creator, false, -1, null);
    if (localBitmap == null)
    {
      GroupSolitatireEditUI.n(this.srR).setImageResource(2131231875);
      AppMethodBeat.o(110459);
      return;
    }
    GroupSolitatireEditUI.n(this.srR).setImageBitmap(localBitmap);
    AppMethodBeat.o(110459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.26
 * JD-Core Version:    0.7.0.1
 */