package com.tencent.h.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class n
{
  private static l ZSn;
  
  public static void a(Context paramContext, m paramm)
  {
    AppMethodBeat.i(207509);
    if (ZSn == null) {
      try
      {
        if (ZSn == null)
        {
          paramContext = new l(paramContext, paramm);
          paramContext.itW();
          ZSn = paramContext;
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(207509);
      }
    }
    AppMethodBeat.o(207509);
  }
  
  public static boolean a(h.a parama, e parame)
  {
    AppMethodBeat.i(207510);
    if ((TextUtils.isEmpty(parama.ELa)) || (itH() == null))
    {
      AppMethodBeat.o(207510);
      return false;
    }
    boolean bool = itH().a(parama, parame);
    AppMethodBeat.o(207510);
    return bool;
  }
  
  public static boolean a(i.a parama)
  {
    AppMethodBeat.i(207511);
    if (itH() == null)
    {
      AppMethodBeat.o(207511);
      return false;
    }
    boolean bool = itH().a(parama);
    AppMethodBeat.o(207511);
    return bool;
  }
  
  private static l itH()
  {
    try
    {
      l locall = ZSn;
      return locall;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.n
 * JD-Core Version:    0.7.0.1
 */