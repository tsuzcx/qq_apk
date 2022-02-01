package com.tencent.h.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class n
{
  private static l ahWK;
  
  public static void a(Context paramContext, m paramm)
  {
    AppMethodBeat.i(212076);
    if (ahWK == null) {
      try
      {
        if (ahWK == null)
        {
          paramContext = new l(paramContext, paramm);
          paramContext.kds();
          ahWK = paramContext;
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(212076);
      }
    }
    AppMethodBeat.o(212076);
  }
  
  public static boolean a(h.a parama, e parame)
  {
    AppMethodBeat.i(212082);
    if ((TextUtils.isEmpty(parama.KFd)) || (kdc() == null))
    {
      AppMethodBeat.o(212082);
      return false;
    }
    boolean bool = kdc().a(parama, parame);
    AppMethodBeat.o(212082);
    return bool;
  }
  
  public static boolean a(i.a parama)
  {
    AppMethodBeat.i(212088);
    if (kdc() == null)
    {
      AppMethodBeat.o(212088);
      return false;
    }
    boolean bool = kdc().a(parama);
    AppMethodBeat.o(212088);
    return bool;
  }
  
  private static l kdc()
  {
    try
    {
      l locall = ahWK;
      return locall;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.n
 * JD-Core Version:    0.7.0.1
 */