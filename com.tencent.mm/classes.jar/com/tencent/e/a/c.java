package com.tencent.e.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class c
{
  private static com.tencent.e.b.a ahsh = null;
  
  public static void a(Context paramContext, a parama)
  {
    AppMethodBeat.i(138305);
    if (ahsh == null) {
      ahsh = new com.tencent.e.b.a(paramContext);
    }
    paramContext = ahsh;
    try
    {
      List localList = com.tencent.e.f.a.ob(paramContext.mContext);
      if ((localList == null) || (localList.size() == 0))
      {
        parama.g(-10, null);
        AppMethodBeat.o(138305);
        return;
      }
      com.tencent.e.c.b.a locala = new com.tencent.e.c.b.a();
      locala.ahsN = com.tencent.e.b.a.jXd();
      locala.ahsL = new com.tencent.e.c.b.c();
      locala.ahsL.ahto = 6;
      locala.ahsL.ahsG = 1;
      locala.ahsL.requestType = 0;
      locala.ahsL.ahtp = 0;
      locala.ahsL.ahtq = 0;
      locala.ahsL.ahtr = null;
      locala.ahsL.ahts = 0;
      locala.ahsL.ahtw = 1;
      locala.ahsM = new ArrayList();
      int i = 0;
      while (i < localList.size())
      {
        com.tencent.e.c.b.b localb = com.tencent.e.b.a.a(paramContext.mContext, (a)localList.get(i), i);
        locala.ahsM.add(localb);
        i += 1;
      }
      paramContext = paramContext.ahsk.a(locala);
      if (paramContext == null)
      {
        parama.g(-20, null);
        AppMethodBeat.o(138305);
        return;
      }
    }
    finally
    {
      parama.g(-100, null);
      AppMethodBeat.o(138305);
      return;
    }
    parama.g(0, paramContext);
    AppMethodBeat.o(138305);
  }
  
  public static abstract interface a
  {
    public abstract void g(int paramInt, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.a.c
 * JD-Core Version:    0.7.0.1
 */