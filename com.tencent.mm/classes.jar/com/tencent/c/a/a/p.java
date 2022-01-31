package com.tencent.c.a.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public class p
{
  private static volatile p bUU = null;
  private boolean bUV;
  private Context context;
  
  private p(Context paramContext)
  {
    AppMethodBeat.i(125722);
    this.context = null;
    this.bUV = false;
    this.context = paramContext.getApplicationContext();
    this.bUV = s.q(this.context, "android.permission.WRITE_SETTINGS");
    if (Build.VERSION.SDK_INT >= 23) {
      try
      {
        paramContext = Settings.System.class.getDeclaredMethod("canWrite", new Class[] { Context.class });
        paramContext.setAccessible(true);
        this.bUV = ((Boolean)paramContext.invoke(null, new Object[] { this.context })).booleanValue();
        AppMethodBeat.o(125722);
        return;
      }
      catch (Exception paramContext) {}
    }
    AppMethodBeat.o(125722);
  }
  
  public static p aM(Context paramContext)
  {
    AppMethodBeat.i(125723);
    if (bUU == null) {}
    try
    {
      if (bUU == null) {
        bUU = new p(paramContext);
      }
      paramContext = bUU;
      AppMethodBeat.o(125723);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(125723);
    }
  }
  
  public final boolean A(String paramString1, String paramString2)
  {
    AppMethodBeat.i(125721);
    if (this.bUV) {
      try
      {
        boolean bool = Settings.System.putString(this.context.getContentResolver(), paramString1, paramString2);
        AppMethodBeat.o(125721);
        return bool;
      }
      catch (Exception paramString1) {}
    }
    AppMethodBeat.o(125721);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.c.a.a.p
 * JD-Core Version:    0.7.0.1
 */