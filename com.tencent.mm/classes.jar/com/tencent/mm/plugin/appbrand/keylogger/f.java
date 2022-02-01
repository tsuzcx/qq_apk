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
  private static Map<String, String> pQe;
  private static Map<String, List<j>> pQf;
  private static Map<String, h> pQg;
  
  static
  {
    AppMethodBeat.i(208536);
    pQe = new HashMap();
    pQf = new HashMap();
    pQg = new HashMap();
    AppMethodBeat.o(208536);
  }
  
  static void a(Class paramClass, h.b paramb, String paramString)
  {
    AppMethodBeat.i(208535);
    h.a(g(paramClass, paramString), paramb);
    AppMethodBeat.o(208535);
  }
  
  static String aB(Class paramClass)
  {
    AppMethodBeat.i(208531);
    String str = paramClass.getName();
    if (pQe.containsKey(str))
    {
      paramClass = (String)pQe.get(str);
      AppMethodBeat.o(208531);
      return paramClass;
    }
    try
    {
      paramClass = (String)paramClass.getDeclaredField("NAME").get(null);
      pQe.put(str, paramClass);
      AppMethodBeat.o(208531);
      return paramClass;
    }
    catch (NoSuchFieldException paramClass)
    {
      AppMethodBeat.o(208531);
      return null;
    }
    catch (IllegalAccessException paramClass)
    {
      AppMethodBeat.o(208531);
    }
    return null;
  }
  
  public static boolean ajO(String paramString)
  {
    AppMethodBeat.i(208528);
    paramString = MultiProcessMMKV.getMMKV("Luggage.KeyStepUtils", 2).getString(String.format("KeyStepLoggerSwitch_%s", new Object[] { paramString }), "");
    try
    {
      paramString = new JSONObject(paramString);
      long l1 = paramString.getLong("keepTime");
      long l2 = paramString.getLong("openTime");
      long l3 = System.currentTimeMillis();
      if ((l2 > 0L) && (l3 - l2 < l1))
      {
        AppMethodBeat.o(208528);
        return true;
      }
      AppMethodBeat.o(208528);
      return false;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(208528);
    }
    return false;
  }
  
  static List<j> f(Class paramClass, String paramString)
  {
    AppMethodBeat.i(208532);
    String str = paramClass.getName();
    str = str + "_" + paramString;
    if (pQf.containsKey(str))
    {
      paramClass = (List)pQf.get(str);
      AppMethodBeat.o(208532);
      return paramClass;
    }
    ArrayList localArrayList = new ArrayList();
    a(paramClass, new h.b()
    {
      public final void a(h paramAnonymoush)
      {
        AppMethodBeat.i(208288);
        com.tencent.mm.plugin.appbrand.keylogger.base.a locala = paramAnonymoush.bZt();
        if (locala == null)
        {
          AppMethodBeat.o(208288);
          return;
        }
        this.pQh.add(new j(locala, paramAnonymoush.pQy));
        AppMethodBeat.o(208288);
      }
    }, paramString);
    pQf.put(str, localArrayList);
    AppMethodBeat.o(208532);
    return localArrayList;
  }
  
  public static h g(Class paramClass, String paramString)
  {
    AppMethodBeat.i(208534);
    String str = paramClass.getName() + "—" + paramString;
    if (pQg.containsKey(str))
    {
      paramClass = (h)pQg.get(str);
      AppMethodBeat.o(208534);
      return paramClass;
    }
    try
    {
      paramClass = (List)org.a.a.ce(paramClass).get("sStepNodes");
      if (paramClass == null)
      {
        AppMethodBeat.o(208534);
        return null;
      }
      paramClass = h.f(paramClass, paramString);
      pQg.put(str, paramClass);
      AppMethodBeat.o(208534);
      return paramClass;
    }
    catch (b paramClass)
    {
      AppMethodBeat.o(208534);
    }
    return null;
  }
  
  public static Pattern r(String... paramVarArgs)
  {
    AppMethodBeat.i(208526);
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
    AppMethodBeat.o(208526);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.f
 * JD-Core Version:    0.7.0.1
 */