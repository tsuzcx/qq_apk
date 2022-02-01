package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.ak;

public final class ab
{
  public static void c(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(184787);
    if (com.tencent.mm.model.ab.Rh(paramString)) {}
    for (int i = 2;; i = 1)
    {
      ak localak = new ak();
      localak.giM = localak.z("roomusrname", paramString, true);
      localak.giN = paramInt1;
      localak.giO = i;
      localak.giP = paramInt2;
      localak.giQ = paramInt3;
      localak.bpa();
      AppMethodBeat.o(184787);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.ab
 * JD-Core Version:    0.7.0.1
 */