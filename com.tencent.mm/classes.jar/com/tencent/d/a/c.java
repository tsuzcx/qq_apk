package com.tencent.d.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class c
{
  private static com.tencent.d.b.a Mir = null;
  
  public static void a(Context paramContext, a parama)
  {
    AppMethodBeat.i(138305);
    if (Mir == null) {
      Mir = new com.tencent.d.b.a(paramContext);
    }
    paramContext = Mir;
    try
    {
      List localList = com.tencent.d.f.a.lc(paramContext.mContext);
      if (localList.size() == 0)
      {
        parama.g(-10, null);
        AppMethodBeat.o(138305);
        return;
      }
      com.tencent.d.c.b.a locala = new com.tencent.d.c.b.a();
      locala.MiX = com.tencent.d.b.a.fYi();
      locala.MiV = new com.tencent.d.c.b.c();
      locala.MiV.Mjy = 6;
      locala.MiV.MiQ = 1;
      locala.MiV.requestType = 0;
      locala.MiV.Mjz = 0;
      locala.MiV.MjA = 0;
      locala.MiV.MjB = null;
      locala.MiV.MjC = 0;
      locala.MiV.MjG = 1;
      locala.MiW = new ArrayList();
      int i = 0;
      while (i < localList.size())
      {
        com.tencent.d.c.b.b localb = com.tencent.d.b.a.a(paramContext.mContext, (a)localList.get(i), i);
        locala.MiW.add(localb);
        i += 1;
      }
      paramContext = paramContext.Miu.a(locala);
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