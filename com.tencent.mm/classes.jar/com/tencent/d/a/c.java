package com.tencent.d.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class c
{
  private static com.tencent.d.b.a IpQ = null;
  
  public static void a(Context paramContext, c.a parama)
  {
    AppMethodBeat.i(138305);
    if (IpQ == null) {
      IpQ = new com.tencent.d.b.a(paramContext);
    }
    paramContext = IpQ;
    try
    {
      List localList = com.tencent.d.f.a.kw(paramContext.mContext);
      if (localList.size() == 0)
      {
        parama.g(-10, null);
        AppMethodBeat.o(138305);
        return;
      }
      com.tencent.d.c.b.a locala = new com.tencent.d.c.b.a();
      locala.Iqx = com.tencent.d.b.a.fmb();
      locala.Iqv = new com.tencent.d.c.b.c();
      locala.Iqv.IqY = 6;
      locala.Iqv.Iqq = 1;
      locala.Iqv.requestType = 0;
      locala.Iqv.IqZ = 0;
      locala.Iqv.Ira = 0;
      locala.Iqv.Irb = null;
      locala.Iqv.Irc = 0;
      locala.Iqv.Irg = 1;
      locala.Iqw = new ArrayList();
      int i = 0;
      while (i < localList.size())
      {
        com.tencent.d.c.b.b localb = com.tencent.d.b.a.a(paramContext.mContext, (a)localList.get(i), i);
        locala.Iqw.add(localb);
        i += 1;
      }
      paramContext = paramContext.IpT.a(locala);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.d.a.c
 * JD-Core Version:    0.7.0.1
 */