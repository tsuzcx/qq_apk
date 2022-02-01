package com.tencent.mm.plugin.groupsolitaire.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelavatar.d;
import com.tencent.mm.plugin.groupsolitaire.b.d;
import com.tencent.mm.plugin.groupsolitaire.c.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;

final class GroupSolitatireEditUI$26
  implements Runnable
{
  GroupSolitatireEditUI$26(GroupSolitatireEditUI paramGroupSolitatireEditUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(110459);
    Bitmap localBitmap = d.a(GroupSolitatireEditUI.c(this.Jkd).field_creator, false, -1, null);
    if (localBitmap == null)
    {
      GroupSolitatireEditUI.n(this.Jkd).setImageResource(b.d.default_avatar);
      AppMethodBeat.o(110459);
      return;
    }
    GroupSolitatireEditUI.n(this.Jkd).setImageBitmap(localBitmap);
    AppMethodBeat.o(110459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.26
 * JD-Core Version:    0.7.0.1
 */