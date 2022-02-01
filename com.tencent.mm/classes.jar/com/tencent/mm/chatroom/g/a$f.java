package com.tencent.mm.chatroom.g;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "arg0", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "arg1", "", "onClick"})
final class a$f
  implements DialogInterface.OnClickListener
{
  public static final f fMb;
  
  static
  {
    AppMethodBeat.i(213601);
    fMb = new f();
    AppMethodBeat.o(213601);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(221606);
    ((u)g.ab(u.class)).JL(4);
    AppMethodBeat.o(221606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.g.a.f
 * JD-Core Version:    0.7.0.1
 */