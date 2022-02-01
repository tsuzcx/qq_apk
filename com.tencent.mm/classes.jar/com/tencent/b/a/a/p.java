package com.tencent.b.a.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public class p
{
  private static volatile p cPB = null;
  private boolean cPC;
  private Context context;
  
  private p(Context paramContext)
  {
    AppMethodBeat.i(87604);
    this.context = null;
    this.cPC = false;
    this.context = paramContext.getApplicationContext();
    this.cPC = s.checkPermission(this.context, "android.permission.WRITE_SETTINGS");
    if (Build.VERSION.SDK_INT >= 23) {
      try
      {
        paramContext = Settings.System.class.getDeclaredMethod("canWrite", new Class[] { Context.class });
        paramContext.setAccessible(true);
        this.cPC = ((Boolean)paramContext.invoke(null, new Object[] { this.context })).booleanValue();
        AppMethodBeat.o(87604);
        return;
      }
      catch (Exception paramContext) {}
    }
    AppMethodBeat.o(87604);
  }
  
  public static p aX(Context paramContext)
  {
    AppMethodBeat.i(87605);
    if (cPB == null) {}
    try
    {
      if (cPB == null) {
        cPB = new p(paramContext);
      }
      paramContext = cPB;
      AppMethodBeat.o(87605);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(87605);
    }
  }
  
  public final boolean K(String paramString1, String paramString2)
  {
    AppMethodBeat.i(87603);
    if (this.cPC) {
      try
      {
        boolean bool = Settings.System.putString(this.context.getContentResolver(), paramString1, paramString2);
        AppMethodBeat.o(87603);
        return bool;
      }
      catch (Exception paramString1) {}
    }
    AppMethodBeat.o(87603);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.b.a.a.p
 * JD-Core Version:    0.7.0.1
 */