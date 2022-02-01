package com.tencent.i.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class n
{
  private static l SqK;
  
  public static void a(Context paramContext, m paramm)
  {
    AppMethodBeat.i(214679);
    if (SqK == null) {
      try
      {
        if (SqK == null)
        {
          paramContext = new l(paramContext, paramm);
          paramContext.hqo();
          SqK = paramContext;
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(214679);
      }
    }
    AppMethodBeat.o(214679);
  }
  
  public static boolean a(h.a parama, e parame)
  {
    AppMethodBeat.i(214680);
    if ((TextUtils.isEmpty(parama.zfX)) || (hqc() == null))
    {
      AppMethodBeat.o(214680);
      return false;
    }
    boolean bool = hqc().a(parama, parame);
    AppMethodBeat.o(214680);
    return bool;
  }
  
  public static boolean a(i.a parama)
  {
    AppMethodBeat.i(214681);
    if (hqc() == null)
    {
      AppMethodBeat.o(214681);
      return false;
    }
    boolean bool = hqc().a(parama);
    AppMethodBeat.o(214681);
    return bool;
  }
  
  private static l hqc()
  {
    try
    {
      l locall = SqK;
      return locall;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.n
 * JD-Core Version:    0.7.0.1
 */