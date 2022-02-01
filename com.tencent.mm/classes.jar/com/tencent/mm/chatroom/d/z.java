package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.eg;
import com.tencent.mm.g.b.a.eh;
import com.tencent.mm.g.b.a.ei;
import com.tencent.mm.model.x;

public final class z
{
  public static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3)
  {
    AppMethodBeat.i(217123);
    int i = 1;
    if (x.Bj(paramString1)) {
      i = 2;
    }
    ei localei = new ei();
    localei.nW(paramString1);
    localei.dTO = i;
    localei.ejt = paramInt1;
    localei.eiW = paramInt2;
    localei.dQX = paramInt3;
    localei.ejw = paramInt4;
    localei.nX(paramString2);
    localei.nY(paramString3);
    localei.aLH();
    AppMethodBeat.o(217123);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    AppMethodBeat.i(217125);
    int i = 0;
    if (x.Bj(paramString1)) {
      i = 2;
    }
    for (;;)
    {
      eh localeh = new eh();
      localeh.nT(paramString1);
      localeh.dTO = i;
      localeh.eiW = paramInt1;
      localeh.dQX = paramInt2;
      localeh.ejt = paramInt3;
      localeh.nU(paramString2);
      localeh.nV(paramString3);
      localeh.aLH();
      AppMethodBeat.o(217125);
      return;
      if (x.Bi(paramString1)) {
        i = 1;
      }
    }
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    AppMethodBeat.i(217124);
    int i = 0;
    if (x.Bj(paramString1)) {
      i = 2;
    }
    for (;;)
    {
      eg localeg = new eg();
      localeg.nQ(paramString1);
      localeg.dTO = i;
      localeg.eiW = paramInt1;
      localeg.dWm = paramInt2;
      localeg.Tp();
      localeg.nR(paramString2);
      localeg.nS(paramString3);
      localeg.aLH();
      AppMethodBeat.o(217124);
      return;
      if (x.Bi(paramString1)) {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.z
 * JD-Core Version:    0.7.0.1
 */