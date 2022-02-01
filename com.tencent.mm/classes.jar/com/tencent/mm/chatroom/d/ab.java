package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.p;
import com.tencent.mm.model.w;

public final class ab
{
  public static void b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(184787);
    if (w.Az(paramString)) {}
    for (int i = 2;; i = 1)
    {
      p localp = new p();
      localp.dSw = localp.t("roomusrname", paramString, true);
      localp.dSx = paramInt1;
      localp.dSy = i;
      localp.dSz = paramInt2;
      localp.dSA = paramInt3;
      localp.aLk();
      AppMethodBeat.o(184787);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.ab
 * JD-Core Version:    0.7.0.1
 */