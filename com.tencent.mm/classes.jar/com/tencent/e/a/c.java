package com.tencent.e.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class c
{
  private static com.tencent.e.b.a RKS = null;
  
  public static void a(Context paramContext, a parama)
  {
    AppMethodBeat.i(138305);
    if (RKS == null) {
      RKS = new com.tencent.e.b.a(paramContext);
    }
    paramContext = RKS;
    try
    {
      List localList = com.tencent.e.f.a.md(paramContext.mContext);
      if (localList.size() == 0)
      {
        parama.g(-10, null);
        AppMethodBeat.o(138305);
        return;
      }
      com.tencent.e.c.b.a locala = new com.tencent.e.c.b.a();
      locala.RLy = com.tencent.e.b.a.hku();
      locala.RLw = new com.tencent.e.c.b.c();
      locala.RLw.RLZ = 6;
      locala.RLw.RLr = 1;
      locala.RLw.requestType = 0;
      locala.RLw.RMa = 0;
      locala.RLw.RMb = 0;
      locala.RLw.RMc = null;
      locala.RLw.RMd = 0;
      locala.RLw.RMh = 1;
      locala.RLx = new ArrayList();
      int i = 0;
      while (i < localList.size())
      {
        com.tencent.e.c.b.b localb = com.tencent.e.b.a.a(paramContext.mContext, (a)localList.get(i), i);
        locala.RLx.add(localb);
        i += 1;
      }
      paramContext = paramContext.RKV.a(locala);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.e.a.c
 * JD-Core Version:    0.7.0.1
 */