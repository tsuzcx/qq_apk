package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ee;
import com.tencent.mm.g.b.a.ef;
import com.tencent.mm.g.b.a.eg;
import com.tencent.mm.model.w;

public final class z
{
  public static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3)
  {
    AppMethodBeat.i(213410);
    int i = 1;
    if (w.Az(paramString1)) {
      i = 2;
    }
    eg localeg = new eg();
    localeg.nB(paramString1);
    localeg.dSy = i;
    localeg.ehJ = paramInt1;
    localeg.ehm = paramInt2;
    localeg.dPH = paramInt3;
    localeg.ehM = paramInt4;
    localeg.nC(paramString2);
    localeg.nD(paramString3);
    localeg.aLk();
    AppMethodBeat.o(213410);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    AppMethodBeat.i(213412);
    int i = 0;
    if (w.Az(paramString1)) {
      i = 2;
    }
    for (;;)
    {
      ef localef = new ef();
      localef.ny(paramString1);
      localef.dSy = i;
      localef.ehm = paramInt1;
      localef.dPH = paramInt2;
      localef.ehJ = paramInt3;
      localef.nz(paramString2);
      localef.nA(paramString3);
      localef.aLk();
      AppMethodBeat.o(213412);
      return;
      if (w.Ay(paramString1)) {
        i = 1;
      }
    }
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    AppMethodBeat.i(213411);
    int i = 0;
    if (w.Az(paramString1)) {
      i = 2;
    }
    for (;;)
    {
      ee localee = new ee();
      localee.nv(paramString1);
      localee.dSy = i;
      localee.ehm = paramInt1;
      localee.dUW = paramInt2;
      localee.Tj();
      localee.nw(paramString2);
      localee.nx(paramString3);
      localee.aLk();
      AppMethodBeat.o(213411);
      return;
      if (w.Ay(paramString1)) {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.z
 * JD-Core Version:    0.7.0.1
 */