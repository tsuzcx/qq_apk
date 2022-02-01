package com.tencent.mm.openim.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/oplog/OpenIMKefuOpLogLogic;", "Lcom/tencent/mm/openim/api/IOpenIMKefuOpLogLogic;", "()V", "setMute", "", "username", "", "unSetMute", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements com.tencent.mm.openim.api.b
{
  public static final a pty;
  
  static
  {
    AppMethodBeat.i(235782);
    pty = new a((byte)0);
    AppMethodBeat.o(235782);
  }
  
  public final void Ee(String paramString)
  {
    AppMethodBeat.i(235783);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(235783);
      return;
    }
    ((n)h.ax(n.class)).bzz().d((k.b)new b(paramString, 1));
    AppMethodBeat.o(235783);
  }
  
  public final void Ef(String paramString)
  {
    AppMethodBeat.i(235784);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(235784);
      return;
    }
    ((n)h.ax(n.class)).bzz().d((k.b)new b(paramString, 2));
    AppMethodBeat.o(235784);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/oplog/OpenIMKefuOpLogLogic$Companion;", "", "()V", "TAG", "", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.c.d
 * JD-Core Version:    0.7.0.1
 */