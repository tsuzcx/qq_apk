package com.tencent.mm.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  public static int ba(Context paramContext)
  {
    AppMethodBeat.i(115028);
    if (paramContext == null)
    {
      AppMethodBeat.o(115028);
      return 0;
    }
    try
    {
      int i = paramContext.getSharedPreferences("crash_status_file", 4).getInt("channel", -1);
      AppMethodBeat.o(115028);
      return i;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(115028);
    }
    return 0;
  }
  
  public static int bb(Context paramContext)
  {
    AppMethodBeat.i(115029);
    if (paramContext == null)
    {
      AppMethodBeat.o(115029);
      return 0;
    }
    try
    {
      int i = paramContext.getSharedPreferences("crash_status_file", 4).getInt("googleplaysizelimit", 3072);
      AppMethodBeat.o(115029);
      return i;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(115029);
    }
    return 0;
  }
  
  public static void e(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(115030);
    try
    {
      Object localObject = paramContext.getSharedPreferences("crash_status_file", 4);
      paramContext = ((SharedPreferences)localObject).getString("crashlist", "");
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString("crashlist", paramContext + ";" + paramString1 + "," + paramString2);
      ((SharedPreferences.Editor)localObject).commit();
      AppMethodBeat.o(115030);
      return;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(115030);
    }
  }
  
  public static abstract interface a
  {
    public abstract void ge(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.f
 * JD-Core Version:    0.7.0.1
 */