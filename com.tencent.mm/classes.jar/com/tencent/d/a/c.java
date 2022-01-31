package com.tencent.d.a;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public final class c
{
  private static com.tencent.d.b.a wLo = null;
  
  public static void a(Context paramContext, c.a parama)
  {
    if (wLo == null) {
      wLo = new com.tencent.d.b.a(paramContext);
    }
    paramContext = wLo;
    try
    {
      List localList = com.tencent.d.f.a.hz(paramContext.mContext);
      if (localList.size() == 0)
      {
        parama.f(-10, null);
        return;
      }
      com.tencent.d.c.b.a locala = new com.tencent.d.c.b.a();
      locala.wLW = com.tencent.d.b.a.cOG();
      locala.wLU = new com.tencent.d.c.b.c();
      locala.wLU.wMx = 6;
      locala.wLU.wLO = 1;
      locala.wLU.requestType = 0;
      locala.wLU.wMy = 0;
      locala.wLU.wMz = 0;
      locala.wLU.wMA = null;
      locala.wLU.wMB = 0;
      locala.wLU.wMF = 1;
      locala.wLV = new ArrayList();
      int i = 0;
      while (i < localList.size())
      {
        com.tencent.d.c.b.b localb = com.tencent.d.b.a.a(paramContext.mContext, (a)localList.get(i), i);
        locala.wLV.add(localb);
        i += 1;
      }
      paramContext = paramContext.wLr.a(locala);
      if (paramContext == null)
      {
        parama.f(-20, null);
        return;
      }
    }
    catch (Throwable paramContext)
    {
      parama.f(-100, null);
      return;
    }
    parama.f(0, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.d.a.c
 * JD-Core Version:    0.7.0.1
 */