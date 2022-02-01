package com.tencent.mapsdk.internal;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class qi
{
  private static final int a = 0;
  private static int b = 0;
  
  public static int a()
  {
    try
    {
      int i = b;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(Context paramContext)
  {
    AppMethodBeat.i(225982);
    try
    {
      b = me.a(paramContext).b("handDrawMapVer");
      return;
    }
    finally
    {
      AppMethodBeat.o(225982);
    }
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(225997);
    try
    {
      b = paramInt;
      me.a(paramContext).a("handDrawMapVer", paramInt);
      return;
    }
    finally
    {
      AppMethodBeat.o(225997);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.qi
 * JD-Core Version:    0.7.0.1
 */