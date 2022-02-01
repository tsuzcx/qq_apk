package com.tencent.mm.chatroom.g;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "arg0", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "arg1", "", "onClick"})
final class a$f
  implements DialogInterface.OnClickListener
{
  public static final f fOf;
  
  static
  {
    AppMethodBeat.i(217319);
    fOf = new f();
    AppMethodBeat.o(217319);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(217318);
    ((v)g.ab(v.class)).Kk(4);
    AppMethodBeat.o(217318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.g.a.f
 * JD-Core Version:    0.7.0.1
 */