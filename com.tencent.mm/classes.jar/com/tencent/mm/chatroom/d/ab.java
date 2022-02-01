package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.p;
import com.tencent.mm.model.x;

public final class ab
{
  public static void b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(184787);
    if (x.Bj(paramString)) {}
    for (int i = 2;; i = 1)
    {
      p localp = new p();
      localp.dTM = localp.t("roomusrname", paramString, true);
      localp.dTN = paramInt1;
      localp.dTO = i;
      localp.dTP = paramInt2;
      localp.dTQ = paramInt3;
      localp.aLH();
      AppMethodBeat.o(184787);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.ab
 * JD-Core Version:    0.7.0.1
 */