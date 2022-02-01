package com.tencent.mm.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
{
  public static int ct(Context paramContext)
  {
    AppMethodBeat.i(125019);
    if (paramContext == null)
    {
      AppMethodBeat.o(125019);
      return 0;
    }
    try
    {
      int i = paramContext.getSharedPreferences("crash_status_file", 4).getInt("channel", -1);
      return i;
    }
    finally
    {
      AppMethodBeat.o(125019);
    }
    return 0;
  }
  
  public static int cu(Context paramContext)
  {
    AppMethodBeat.i(125020);
    if (paramContext == null)
    {
      AppMethodBeat.o(125020);
      return 0;
    }
    try
    {
      int i = paramContext.getSharedPreferences("crash_status_file", 4).getInt("googleplaysizelimit", 8192);
      return i;
    }
    finally
    {
      AppMethodBeat.o(125020);
    }
    return 0;
  }
  
  public static void f(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(125021);
    try
    {
      Object localObject = paramContext.getSharedPreferences("crash_status_file", 4);
      paramContext = ((SharedPreferences)localObject).getString("crashlist", "");
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString("crashlist", paramContext + ";" + paramString1 + "," + paramString2);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    finally
    {
      AppMethodBeat.o(125021);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.j
 * JD-Core Version:    0.7.0.1
 */