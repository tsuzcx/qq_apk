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
  private static Map<String, String> mPl;
  private static Map<String, List<j>> mPm;
  private static Map<String, h> mPn;
  
  static
  {
    AppMethodBeat.i(221319);
    mPl = new HashMap();
    mPm = new HashMap();
    mPn = new HashMap();
    AppMethodBeat.o(221319);
  }
  
  static void a(Class paramClass, h.b paramb, String paramString)
  {
    AppMethodBeat.i(221318);
    h.a(h(paramClass, paramString), paramb);
    AppMethodBeat.o(221318);
  }
  
  static String aC(Class paramClass)
  {
    AppMethodBeat.i(221315);
    String str = paramClass.getName();
    if (mPl.containsKey(str))
    {
      paramClass = (String)mPl.get(str);
      AppMethodBeat.o(221315);
      return paramClass;
    }
    try
    {
      paramClass = (String)paramClass.getDeclaredField("NAME").get(null);
      mPl.put(str, paramClass);
      AppMethodBeat.o(221315);
      return paramClass;
    }
    catch (NoSuchFieldException paramClass)
    {
      AppMethodBeat.o(221315);
      return null;
    }
    catch (IllegalAccessException paramClass)
    {
      AppMethodBeat.o(221315);
    }
    return null;
  }
  
  public static boolean abT(String paramString)
  {
    AppMethodBeat.i(221314);
    paramString = MultiProcessMMKV.getMMKV("Luggage.KeyStepUtils", 2).getString(String.format("KeyStepLoggerSwitch_%s", new Object[] { paramString }), "");
    try
    {
      paramString = new JSONObject(paramString);
      long l1 = paramString.getLong("keepTime");
      long l2 = paramString.getLong("openTime");
      long l3 = System.currentTimeMillis();
      if ((l2 > 0L) && (l3 - l2 < l1))
      {
        AppMethodBeat.o(221314);
        return true;
      }
      AppMethodBeat.o(221314);
      return false;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(221314);
    }
    return false;
  }
  
  static List<j> g(Class paramClass, String paramString)
  {
    AppMethodBeat.i(221316);
    String str = paramClass.getName();
    str = str + "_" + paramString;
    if (mPm.containsKey(str))
    {
      paramClass = (List)mPm.get(str);
      AppMethodBeat.o(221316);
      return paramClass;
    }
    ArrayList localArrayList = new ArrayList();
    a(paramClass, new h.b()
    {
      public final void a(h paramAnonymoush)
      {
        AppMethodBeat.i(221312);
        com.tencent.mm.plugin.appbrand.keylogger.base.a locala = paramAnonymoush.bNb();
        if (locala == null)
        {
          AppMethodBeat.o(221312);
          return;
        }
        this.mPo.add(new j(locala, paramAnonymoush.mPF));
        AppMethodBeat.o(221312);
      }
    }, paramString);
    mPm.put(str, localArrayList);
    AppMethodBeat.o(221316);
    return localArrayList;
  }
  
  public static h h(Class paramClass, String paramString)
  {
    AppMethodBeat.i(221317);
    String str = paramClass.getName() + "—" + paramString;
    if (mPn.containsKey(str))
    {
      paramClass = (h)mPn.get(str);
      AppMethodBeat.o(221317);
      return paramClass;
    }
    try
    {
      paramClass = (List)org.a.a.bF(paramClass).get("sStepNodes");
      if (paramClass == null)
      {
        AppMethodBeat.o(221317);
        return null;
      }
      paramClass = h.f(paramClass, paramString);
      mPn.put(str, paramClass);
      AppMethodBeat.o(221317);
      return paramClass;
    }
    catch (b paramClass)
    {
      AppMethodBeat.o(221317);
    }
    return null;
  }
  
  public static Pattern s(String... paramVarArgs)
  {
    AppMethodBeat.i(221313);
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
    AppMethodBeat.o(221313);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.f
 * JD-Core Version:    0.7.0.1
 */