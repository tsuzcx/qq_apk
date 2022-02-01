package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ae;

public final class ab
{
  public static void b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(184787);
    if (com.tencent.mm.model.ab.JO(paramString)) {}
    for (int i = 2;; i = 1)
    {
      ae localae = new ae();
      localae.enK = localae.x("roomusrname", paramString, true);
      localae.enL = paramInt1;
      localae.enM = i;
      localae.enN = paramInt2;
      localae.enO = paramInt3;
      localae.bfK();
      AppMethodBeat.o(184787);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.ab
 * JD-Core Version:    0.7.0.1
 */