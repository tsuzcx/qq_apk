package com.tencent.mm.plugin.appbrand.keylogger;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.base.d;
import com.tencent.mm.plugin.appbrand.keylogger.base.h;
import com.tencent.mm.plugin.appbrand.keylogger.base.h.a;
import com.tencent.mm.plugin.appbrand.keylogger.base.h.b;
import com.tencent.mm.plugin.appbrand.keylogger.base.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
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
  private static Map<String, String> lHw;
  private static Map<String, List<j>> lHx;
  private static Map<String, h> lHy;
  
  static
  {
    AppMethodBeat.i(201275);
    lHw = new HashMap();
    lHx = new HashMap();
    lHy = new HashMap();
    AppMethodBeat.o(201275);
  }
  
  public static boolean Sn(String paramString)
  {
    AppMethodBeat.i(201270);
    paramString = ay.gq("Luggage.KeyStepUtils", 2).getString(String.format("KeyStepLoggerSwitch_%s", new Object[] { paramString }), "");
    try
    {
      paramString = new JSONObject(paramString);
      long l1 = paramString.getLong("keepTime");
      long l2 = paramString.getLong("openTime");
      long l3 = System.currentTimeMillis();
      if ((l2 > 0L) && (l3 - l2 < l1))
      {
        AppMethodBeat.o(201270);
        return true;
      }
      AppMethodBeat.o(201270);
      return false;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(201270);
    }
    return false;
  }
  
  static void a(Class paramClass, h.b paramb)
  {
    AppMethodBeat.i(201274);
    h.a(aA(paramClass), paramb);
    AppMethodBeat.o(201274);
  }
  
  public static h aA(Class paramClass)
  {
    AppMethodBeat.i(201273);
    String str = paramClass.getName();
    if (lHy.containsKey(str))
    {
      paramClass = (h)lHy.get(str);
      AppMethodBeat.o(201273);
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
        AppMethodBeat.o(201273);
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
      int j = locald.bro();
      if (j <= 0)
      {
        j = locald.brn();
        paramClass = new h(locald, "");
        localh1.b(paramClass);
        localHashMap.put(Integer.valueOf(j), paramClass);
      }
      else
      {
        localh2 = (h)localHashMap.get(Integer.valueOf(j));
        if (localh2 == null)
        {
          ae.e("StepNode", "buildStepTree unexpected branch: myGroup not found yet");
          paramClass = null;
          label232:
          if (paramClass == null)
          {
            AppMethodBeat.o(201273);
            return null;
          }
        }
        else if (!h.a(localh2.lHO))
        {
          ae.e("StepNode", "addChild but not a node group");
          paramClass = null;
          if (!h.a(locald)) {
            break label502;
          }
          localHashMap.put(Integer.valueOf(locald.brn()), paramClass);
        }
      }
    }
    catch (b paramClass)
    {
      AppMethodBeat.o(201273);
      return null;
    }
    if (localh2.lHP == null) {
      localh2.lHP = new ArrayList();
    }
    if (localh2.lHO.getType() == 3) {}
    for (paramClass = "-";; paramClass = ".")
    {
      if (!bu.isNullOrNil(localh2.lHQ)) {}
      for (paramClass = String.format("%s%s%d", new Object[] { localh2.lHQ, paramClass, Integer.valueOf(localh2.lHP.size() + 1) });; paramClass = String.format("%d", new Object[] { Integer.valueOf(localh2.lHP.size() + 1) }))
      {
        paramClass = new h(locald, paramClass);
        localh2.lHP.add(paramClass);
        break;
      }
      label446:
      localh1.b(new h((d)localList.get(localList.size() - 1), ""));
      paramClass = localh1;
      break label232;
      lHy.put(str, paramClass);
      AppMethodBeat.o(201273);
      return paramClass;
      label502:
      i += 1;
      break;
    }
  }
  
  static String ay(Class paramClass)
  {
    AppMethodBeat.i(201271);
    String str = paramClass.getName();
    if (lHw.containsKey(str))
    {
      paramClass = (String)lHw.get(str);
      AppMethodBeat.o(201271);
      return paramClass;
    }
    try
    {
      paramClass = (String)paramClass.getDeclaredField("NAME").get(null);
      lHw.put(str, paramClass);
      AppMethodBeat.o(201271);
      return paramClass;
    }
    catch (NoSuchFieldException paramClass)
    {
      AppMethodBeat.o(201271);
      return null;
    }
    catch (IllegalAccessException paramClass)
    {
      AppMethodBeat.o(201271);
    }
    return null;
  }
  
  static List<j> az(Class paramClass)
  {
    AppMethodBeat.i(201272);
    String str = paramClass.getName();
    if (lHx.containsKey(str))
    {
      paramClass = (List)lHx.get(str);
      AppMethodBeat.o(201272);
      return paramClass;
    }
    ArrayList localArrayList = new ArrayList();
    a(paramClass, new h.b()
    {
      public final void a(h paramAnonymoush)
      {
        AppMethodBeat.i(201268);
        com.tencent.mm.plugin.appbrand.keylogger.base.a locala = paramAnonymoush.brq();
        if (locala == null)
        {
          AppMethodBeat.o(201268);
          return;
        }
        this.lHz.add(new j(locala, paramAnonymoush.lHQ));
        AppMethodBeat.o(201268);
      }
    });
    lHx.put(str, localArrayList);
    AppMethodBeat.o(201272);
    return localArrayList;
  }
  
  public static Pattern q(String... paramVarArgs)
  {
    AppMethodBeat.i(201269);
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
    AppMethodBeat.o(201269);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.f
 * JD-Core Version:    0.7.0.1
 */