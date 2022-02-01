package com.tencent.mm.plugin.appbrand.keylogger;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.base.d;
import com.tencent.mm.plugin.appbrand.keylogger.base.h;
import com.tencent.mm.plugin.appbrand.keylogger.base.h.a;
import com.tencent.mm.plugin.appbrand.keylogger.base.h.b;
import com.tencent.mm.plugin.appbrand.keylogger.base.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
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
  private static Map<String, String> lCX;
  private static Map<String, List<j>> lCY;
  private static Map<String, h> lCZ;
  
  static
  {
    AppMethodBeat.i(187708);
    lCX = new HashMap();
    lCY = new HashMap();
    lCZ = new HashMap();
    AppMethodBeat.o(187708);
  }
  
  public static boolean RE(String paramString)
  {
    AppMethodBeat.i(187703);
    paramString = ax.gh("Luggage.KeyStepUtils", 2).getString(String.format("KeyStepLoggerSwitch_%s", new Object[] { paramString }), "");
    try
    {
      paramString = new JSONObject(paramString);
      long l1 = paramString.getLong("keepTime");
      long l2 = paramString.getLong("openTime");
      long l3 = System.currentTimeMillis();
      if ((l2 > 0L) && (l3 - l2 < l1))
      {
        AppMethodBeat.o(187703);
        return true;
      }
      AppMethodBeat.o(187703);
      return false;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(187703);
    }
    return false;
  }
  
  static void a(Class paramClass, h.b paramb)
  {
    AppMethodBeat.i(187707);
    h.a(aA(paramClass), paramb);
    AppMethodBeat.o(187707);
  }
  
  public static h aA(Class paramClass)
  {
    AppMethodBeat.i(187706);
    String str = paramClass.getName();
    if (lCZ.containsKey(str))
    {
      paramClass = (h)lCZ.get(str);
      AppMethodBeat.o(187706);
      return paramClass;
    }
    List localList;
    h localh1;
    int i;
    d locald;
    h localh2;
    try
    {
      localList = (List)org.a.a.bF(paramClass).get("sStepNodes");
      if (localList == null)
      {
        AppMethodBeat.o(187706);
        return null;
      }
      localh1 = new h(new h.a(), "");
      localh1.b(new h((d)localList.get(0), ""));
      HashMap localHashMap = new HashMap();
      i = 1;
      if (i >= localList.size() - 1) {
        break label446;
      }
      locald = (d)localList.get(i);
      int j = locald.bqE();
      if (j <= 0)
      {
        j = locald.bqD();
        paramClass = new h(locald, "");
        localh1.b(paramClass);
        localHashMap.put(Integer.valueOf(j), paramClass);
      }
      else
      {
        localh2 = (h)localHashMap.get(Integer.valueOf(j));
        if (localh2 == null)
        {
          ad.e("StepNode", "buildStepTree unexpected branch: myGroup not found yet");
          paramClass = null;
          label232:
          if (paramClass == null)
          {
            AppMethodBeat.o(187706);
            return null;
          }
        }
        else if (!h.a(localh2.lDp))
        {
          ad.e("StepNode", "addChild but not a node group");
          paramClass = null;
          if (!h.a(locald)) {
            break label502;
          }
          localHashMap.put(Integer.valueOf(locald.bqD()), paramClass);
        }
      }
    }
    catch (b paramClass)
    {
      AppMethodBeat.o(187706);
      return null;
    }
    if (localh2.lDq == null) {
      localh2.lDq = new ArrayList();
    }
    if (localh2.lDp.getType() == 3) {}
    for (paramClass = "-";; paramClass = ".")
    {
      if (!bt.isNullOrNil(localh2.lDr)) {}
      for (paramClass = String.format("%s%s%d", new Object[] { localh2.lDr, paramClass, Integer.valueOf(localh2.lDq.size() + 1) });; paramClass = String.format("%d", new Object[] { Integer.valueOf(localh2.lDq.size() + 1) }))
      {
        paramClass = new h(locald, paramClass);
        localh2.lDq.add(paramClass);
        break;
      }
      label446:
      localh1.b(new h((d)localList.get(localList.size() - 1), ""));
      paramClass = localh1;
      break label232;
      lCZ.put(str, paramClass);
      AppMethodBeat.o(187706);
      return paramClass;
      label502:
      i += 1;
      break;
    }
  }
  
  static String ay(Class paramClass)
  {
    AppMethodBeat.i(187704);
    String str = paramClass.getName();
    if (lCX.containsKey(str))
    {
      paramClass = (String)lCX.get(str);
      AppMethodBeat.o(187704);
      return paramClass;
    }
    try
    {
      paramClass = (String)paramClass.getDeclaredField("NAME").get(null);
      lCX.put(str, paramClass);
      AppMethodBeat.o(187704);
      return paramClass;
    }
    catch (NoSuchFieldException paramClass)
    {
      AppMethodBeat.o(187704);
      return null;
    }
    catch (IllegalAccessException paramClass)
    {
      AppMethodBeat.o(187704);
    }
    return null;
  }
  
  static List<j> az(Class paramClass)
  {
    AppMethodBeat.i(187705);
    String str = paramClass.getName();
    if (lCY.containsKey(str))
    {
      paramClass = (List)lCY.get(str);
      AppMethodBeat.o(187705);
      return paramClass;
    }
    ArrayList localArrayList = new ArrayList();
    a(paramClass, new h.b()
    {
      public final void a(h paramAnonymoush)
      {
        AppMethodBeat.i(187701);
        com.tencent.mm.plugin.appbrand.keylogger.base.a locala = paramAnonymoush.bqG();
        if (locala == null)
        {
          AppMethodBeat.o(187701);
          return;
        }
        this.lDa.add(new j(locala, paramAnonymoush.lDr));
        AppMethodBeat.o(187701);
      }
    });
    lCY.put(str, localArrayList);
    AppMethodBeat.o(187705);
    return localArrayList;
  }
  
  public static Pattern q(String... paramVarArgs)
  {
    AppMethodBeat.i(187702);
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
    AppMethodBeat.o(187702);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.f
 * JD-Core Version:    0.7.0.1
 */