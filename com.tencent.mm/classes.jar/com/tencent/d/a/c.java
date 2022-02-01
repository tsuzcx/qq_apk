package com.tencent.d.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class c
{
  private static com.tencent.d.b.a JRA = null;
  
  public static void a(Context paramContext, c.a parama)
  {
    AppMethodBeat.i(138305);
    if (JRA == null) {
      JRA = new com.tencent.d.b.a(paramContext);
    }
    paramContext = JRA;
    try
    {
      List localList = com.tencent.d.f.a.kI(paramContext.mContext);
      if (localList.size() == 0)
      {
        parama.g(-10, null);
        AppMethodBeat.o(138305);
        return;
      }
      com.tencent.d.c.b.a locala = new com.tencent.d.c.b.a();
      locala.JSh = com.tencent.d.b.a.fCs();
      locala.JSf = new com.tencent.d.c.b.c();
      locala.JSf.JSI = 6;
      locala.JSf.JSa = 1;
      locala.JSf.requestType = 0;
      locala.JSf.JSJ = 0;
      locala.JSf.JSK = 0;
      locala.JSf.JSL = null;
      locala.JSf.JSM = 0;
      locala.JSf.JSQ = 1;
      locala.JSg = new ArrayList();
      int i = 0;
      while (i < localList.size())
      {
        com.tencent.d.c.b.b localb = com.tencent.d.b.a.a(paramContext.mContext, (a)localList.get(i), i);
        locala.JSg.add(localb);
        i += 1;
      }
      paramContext = paramContext.JRD.a(locala);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.a.c
 * JD-Core Version:    0.7.0.1
 */