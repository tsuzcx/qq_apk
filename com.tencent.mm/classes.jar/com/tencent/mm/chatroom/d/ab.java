package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.m;
import com.tencent.mm.model.w;

public final class ab
{
  public static void b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(184787);
    if (w.ty(paramString)) {}
    for (int i = 2;; i = 1)
    {
      m localm = new m();
      localm.dHE = localm.t("roomusrname", paramString, true);
      localm.dHF = paramInt1;
      localm.dHG = i;
      localm.dHH = paramInt2;
      localm.dHI = paramInt3;
      localm.aBj();
      AppMethodBeat.o(184787);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.ab
 * JD-Core Version:    0.7.0.1
 */