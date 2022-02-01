package com.tencent.mapsdk.internal;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class md
  extends mb
{
  private static final String b = "Tencent_MapSDK_SUB_CONFIG";
  private static Map<String, mb> c;
  
  static
  {
    AppMethodBeat.i(223077);
    c = new HashMap();
    AppMethodBeat.o(223077);
  }
  
  private md(Context paramContext, String paramString)
  {
    AppMethodBeat.i(223049);
    this.a = paramContext.getSharedPreferences("Tencent_MapSDK_SUB_CONFIG_".concat(String.valueOf(paramString)), 0);
    AppMethodBeat.o(223049);
  }
  
  public static mb a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(223042);
    if (gz.a(paramString))
    {
      paramContext = me.a(paramContext);
      AppMethodBeat.o(223042);
      return paramContext;
    }
    if (c.get(paramString) == null) {}
    try
    {
      if (c.get(paramString) == null)
      {
        paramContext = new md(paramContext, paramString);
        c.put(paramString, paramContext);
        return paramContext;
      }
      paramContext = (mb)c.get(paramString);
      AppMethodBeat.o(223042);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(223042);
    }
  }
  
  public static void a(Context paramContext)
  {
    AppMethodBeat.i(223065);
    try
    {
      paramContext = new File(paramContext.getFilesDir().getParent() + File.separator + "shared_prefs").listFiles();
      if (paramContext == null)
      {
        AppMethodBeat.o(223065);
        return;
      }
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramContext[i];
        if (localObject.getName().startsWith("Tencent_MapSDK_SUB_CONFIG")) {
          localObject.delete();
        }
        i += 1;
      }
      AppMethodBeat.o(223065);
      return;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(223065);
    }
  }
  
  public static void b()
  {
    AppMethodBeat.i(223071);
    if (c != null) {
      c.clear();
    }
    AppMethodBeat.o(223071);
  }
  
  private static boolean b(Context paramContext, String paramString)
  {
    AppMethodBeat.i(223058);
    if (gz.a(paramString))
    {
      AppMethodBeat.o(223058);
      return false;
    }
    try
    {
      paramContext = new File(paramContext.getFilesDir().getParent() + File.separator + "shared_prefs" + File.separator + "Tencent_MapSDK_SUB_CONFIG_" + paramString);
      if (paramContext.exists())
      {
        boolean bool = paramContext.delete();
        AppMethodBeat.o(223058);
        return bool;
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(223058);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.md
 * JD-Core Version:    0.7.0.1
 */