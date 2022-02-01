package com.tencent.d.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class c
{
  private static com.tencent.d.b.a Znz = null;
  
  public static void a(Context paramContext, a parama)
  {
    AppMethodBeat.i(138305);
    if (Znz == null) {
      Znz = new com.tencent.d.b.a(paramContext);
    }
    paramContext = Znz;
    try
    {
      List localList = com.tencent.d.f.a.lV(paramContext.mContext);
      if (localList.size() == 0)
      {
        parama.g(-10, null);
        AppMethodBeat.o(138305);
        return;
      }
      com.tencent.d.c.b.a locala = new com.tencent.d.c.b.a();
      locala.Zof = com.tencent.d.b.a.inS();
      locala.Zod = new com.tencent.d.c.b.c();
      locala.Zod.ZoG = 6;
      locala.Zod.ZnY = 1;
      locala.Zod.requestType = 0;
      locala.Zod.ZoH = 0;
      locala.Zod.ZoI = 0;
      locala.Zod.ZoJ = null;
      locala.Zod.ZoK = 0;
      locala.Zod.ZoO = 1;
      locala.Zoe = new ArrayList();
      int i = 0;
      while (i < localList.size())
      {
        com.tencent.d.c.b.b localb = com.tencent.d.b.a.a(paramContext.mContext, (a)localList.get(i), i);
        locala.Zoe.add(localb);
        i += 1;
      }
      paramContext = paramContext.ZnC.a(locala);
      if (paramContext == null)
      {
        parama.g(-20, null);
        AppMethodBeat.o(138305);
        return;
      }
    }
    catch (Throwable paramContext)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.a.c
 * JD-Core Version:    0.7.0.1
 */