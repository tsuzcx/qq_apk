package com.tencent.e.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class c
{
  private static com.tencent.e.b.a BiN = null;
  
  public static void a(Context paramContext, a parama)
  {
    AppMethodBeat.i(114464);
    if (BiN == null) {
      BiN = new com.tencent.e.b.a(paramContext);
    }
    paramContext = BiN;
    try
    {
      List localList = com.tencent.e.f.a.ja(paramContext.mContext);
      if (localList.size() == 0)
      {
        parama.f(-10, null);
        AppMethodBeat.o(114464);
        return;
      }
      com.tencent.e.c.b.a locala = new com.tencent.e.c.b.a();
      locala.Bju = com.tencent.e.b.a.dUv();
      locala.Bjs = new com.tencent.e.c.b.c();
      locala.Bjs.BjV = 6;
      locala.Bjs.Bjn = 1;
      locala.Bjs.requestType = 0;
      locala.Bjs.BjW = 0;
      locala.Bjs.BjX = 0;
      locala.Bjs.BjY = null;
      locala.Bjs.BjZ = 0;
      locala.Bjs.Bkd = 1;
      locala.Bjt = new ArrayList();
      int i = 0;
      while (i < localList.size())
      {
        com.tencent.e.c.b.b localb = com.tencent.e.b.a.a(paramContext.mContext, (a)localList.get(i), i);
        locala.Bjt.add(localb);
        i += 1;
      }
      paramContext = paramContext.BiQ.a(locala);
      if (paramContext == null)
      {
        parama.f(-20, null);
        AppMethodBeat.o(114464);
        return;
      }
    }
    catch (Throwable paramContext)
    {
      parama.f(-100, null);
      AppMethodBeat.o(114464);
      return;
    }
    parama.f(0, paramContext);
    AppMethodBeat.o(114464);
  }
  
  public static abstract interface a
  {
    public abstract void f(int paramInt, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.e.a.c
 * JD-Core Version:    0.7.0.1
 */