package com.tencent.mm.plugin.appbrand.keylogger;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.base.h;
import com.tencent.mm.plugin.appbrand.keylogger.base.h.b;
import com.tencent.mm.plugin.appbrand.keylogger.base.j;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.a.b;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  private static Map<String, String> sUE;
  private static Map<String, List<j>> sUF;
  private static Map<String, h> sUG;
  
  static
  {
    AppMethodBeat.i(319521);
    sUE = new HashMap();
    sUF = new HashMap();
    sUG = new HashMap();
    AppMethodBeat.o(319521);
  }
  
  static void a(Class paramClass, h.b paramb, String paramString)
  {
    AppMethodBeat.i(319518);
    h.a(g(paramClass, paramString), paramb);
    AppMethodBeat.o(319518);
  }
  
  static String aV(Class paramClass)
  {
    AppMethodBeat.i(319501);
    String str = paramClass.getName();
    if (sUE.containsKey(str))
    {
      paramClass = (String)sUE.get(str);
      AppMethodBeat.o(319501);
      return paramClass;
    }
    try
    {
      paramClass = (String)paramClass.getDeclaredField("NAME").get(null);
      sUE.put(str, paramClass);
      AppMethodBeat.o(319501);
      return paramClass;
    }
    catch (NoSuchFieldException paramClass)
    {
      AppMethodBeat.o(319501);
      return null;
    }
    catch (IllegalAccessException paramClass)
    {
      AppMethodBeat.o(319501);
    }
    return null;
  }
  
  public static boolean acO(String paramString)
  {
    AppMethodBeat.i(319492);
    paramString = MultiProcessMMKV.getMMKV("Luggage.KeyStepUtils", 2).getString(String.format("KeyStepLoggerSwitch_%s", new Object[] { paramString }), "");
    try
    {
      paramString = new JSONObject(paramString);
      long l1 = paramString.getLong("keepTime");
      long l2 = paramString.getLong("openTime");
      long l3 = System.currentTimeMillis();
      if ((l2 > 0L) && (l3 - l2 < l1))
      {
        AppMethodBeat.o(319492);
        return true;
      }
      AppMethodBeat.o(319492);
      return false;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(319492);
    }
    return false;
  }
  
  static List<j> f(Class paramClass, String paramString)
  {
    AppMethodBeat.i(319508);
    String str = paramClass.getName();
    str = str + "_" + paramString;
    if (sUF.containsKey(str))
    {
      paramClass = (List)sUF.get(str);
      AppMethodBeat.o(319508);
      return paramClass;
    }
    ArrayList localArrayList = new ArrayList();
    a(paramClass, new h.b()
    {
      public final void a(h paramAnonymoush)
      {
        AppMethodBeat.i(319458);
        com.tencent.mm.plugin.appbrand.keylogger.base.a locala = paramAnonymoush.czE();
        if (locala == null)
        {
          AppMethodBeat.o(319458);
          return;
        }
        f.this.add(new j(locala, paramAnonymoush.sUY));
        AppMethodBeat.o(319458);
      }
    }, paramString);
    sUF.put(str, localArrayList);
    AppMethodBeat.o(319508);
    return localArrayList;
  }
  
  public static h g(Class paramClass, String paramString)
  {
    AppMethodBeat.i(319513);
    String str = paramClass.getName() + "—" + paramString;
    if (sUG.containsKey(str))
    {
      paramClass = (h)sUG.get(str);
      AppMethodBeat.o(319513);
      return paramClass;
    }
    try
    {
      paramClass = (List)org.a.a.cQ(paramClass).get("sStepNodes");
      if (paramClass == null)
      {
        AppMethodBeat.o(319513);
        return null;
      }
      paramClass = h.h(paramClass, paramString);
      if (paramClass == null)
      {
        AppMethodBeat.o(319513);
        return null;
      }
      sUG.put(str, paramClass);
      AppMethodBeat.o(319513);
      return paramClass;
    }
    catch (b paramClass)
    {
      AppMethodBeat.o(319513);
    }
    return null;
  }
  
  public static Pattern r(String... paramVarArgs)
  {
    AppMethodBeat.i(319481);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < 2)
    {
      localStringBuilder.append(paramVarArgs[i]);
      if (i != 1) {
        localStringBuilder.append("|");
      }
      i += 1;
    }
    localStringBuilder.append(".*");
    paramVarArgs = Pattern.compile(localStringBuilder.toString());
    AppMethodBeat.o(319481);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.f
 * JD-Core Version:    0.7.0.1
 */