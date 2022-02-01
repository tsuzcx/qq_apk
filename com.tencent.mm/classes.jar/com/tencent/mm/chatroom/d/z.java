package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bw;
import com.tencent.mm.g.b.a.bx;
import com.tencent.mm.g.b.a.by;
import com.tencent.mm.model.w;

public final class z
{
  public static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3)
  {
    AppMethodBeat.i(196572);
    int i = 1;
    if (w.ty(paramString1)) {
      i = 2;
    }
    by localby = new by();
    localby.iE(paramString1);
    localby.dHG = i;
    localby.dQo = paramInt1;
    localby.dPY = paramInt2;
    localby.dFf = paramInt3;
    localby.dQs = paramInt4;
    localby.iF(paramString2);
    localby.iG(paramString3);
    localby.aBj();
    AppMethodBeat.o(196572);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    AppMethodBeat.i(196574);
    int i = 0;
    if (w.ty(paramString1)) {
      i = 2;
    }
    for (;;)
    {
      bx localbx = new bx();
      localbx.iB(paramString1);
      localbx.dHG = i;
      localbx.dPY = paramInt1;
      localbx.dFf = paramInt2;
      localbx.dQo = paramInt3;
      localbx.iC(paramString2);
      localbx.iD(paramString3);
      localbx.aBj();
      AppMethodBeat.o(196574);
      return;
      if (w.tx(paramString1)) {
        i = 1;
      }
    }
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    AppMethodBeat.i(196573);
    int i = 0;
    if (w.ty(paramString1)) {
      i = 2;
    }
    for (;;)
    {
      bw localbw = new bw();
      localbw.iy(paramString1);
      localbw.dHG = i;
      localbw.dPY = paramInt1;
      localbw.dKc = paramInt2;
      localbw.QA();
      localbw.iz(paramString2);
      localbw.iA(paramString3);
      localbw.aBj();
      AppMethodBeat.o(196573);
      return;
      if (w.tx(paramString1)) {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.z
 * JD-Core Version:    0.7.0.1
 */