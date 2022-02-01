package com.tencent.mm.plugin.appbrand.keylogger;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.base.d;
import com.tencent.mm.plugin.appbrand.keylogger.base.h;
import com.tencent.mm.plugin.appbrand.keylogger.base.h.a;
import com.tencent.mm.plugin.appbrand.keylogger.base.h.b;
import com.tencent.mm.plugin.appbrand.keylogger.base.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
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
  private static Map<String, String> lfZ;
  private static Map<String, List<j>> lga;
  private static Map<String, h> lgb;
  
  static
  {
    AppMethodBeat.i(201036);
    lfZ = new HashMap();
    lga = new HashMap();
    lgb = new HashMap();
    AppMethodBeat.o(201036);
  }
  
  public static boolean Og(String paramString)
  {
    AppMethodBeat.i(201031);
    paramString = aw.fK("Luggage.KeyStepUtils", 2).getString(String.format("KeyStepLoggerSwitch_%s", new Object[] { paramString }), "");
    try
    {
      paramString = new JSONObject(paramString);
      long l1 = paramString.getLong("keepTime");
      long l2 = paramString.getLong("openTime");
      long l3 = System.currentTimeMillis();
      if ((l2 > 0L) && (l3 - l2 < l1))
      {
        AppMethodBeat.o(201031);
        return true;
      }
      AppMethodBeat.o(201031);
      return false;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(201031);
    }
    return false;
  }
  
  static void a(Class paramClass, h.b paramb)
  {
    AppMethodBeat.i(201035);
    h.a(aA(paramClass), paramb);
    AppMethodBeat.o(201035);
  }
  
  public static h aA(Class paramClass)
  {
    AppMethodBeat.i(201034);
    String str = paramClass.getName();
    if (lgb.containsKey(str))
    {
      paramClass = (h)lgb.get(str);
      AppMethodBeat.o(201034);
      return paramClass;
    }
    List localList;
    h localh1;
    int i;
    d locald;
    h localh2;
    try
    {
      localList = (List)org.a.a.bD(paramClass).get("sStepNodes");
      if (localList == null)
      {
        AppMethodBeat.o(201034);
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
      int j = locald.bmT();
      if (j <= 0)
      {
        j = locald.bmS();
        paramClass = new h(locald, "");
        localh1.b(paramClass);
        localHashMap.put(Integer.valueOf(j), paramClass);
      }
      else
      {
        localh2 = (h)localHashMap.get(Integer.valueOf(j));
        if (localh2 == null)
        {
          ac.e("StepNode", "buildStepTree unexpected branch: myGroup not found yet");
          paramClass = null;
          label232:
          if (paramClass == null)
          {
            AppMethodBeat.o(201034);
            return null;
          }
        }
        else if (!h.a(localh2.lgr))
        {
          ac.e("StepNode", "addChild but not a node group");
          paramClass = null;
          if (!h.a(locald)) {
            break label502;
          }
          localHashMap.put(Integer.valueOf(locald.bmS()), paramClass);
        }
      }
    }
    catch (b paramClass)
    {
      AppMethodBeat.o(201034);
      return null;
    }
    if (localh2.lgs == null) {
      localh2.lgs = new ArrayList();
    }
    if (localh2.lgr.getType() == 3) {}
    for (paramClass = "-";; paramClass = ".")
    {
      if (!bs.isNullOrNil(localh2.lgt)) {}
      for (paramClass = String.format("%s%s%d", new Object[] { localh2.lgt, paramClass, Integer.valueOf(localh2.lgs.size() + 1) });; paramClass = String.format("%d", new Object[] { Integer.valueOf(localh2.lgs.size() + 1) }))
      {
        paramClass = new h(locald, paramClass);
        localh2.lgs.add(paramClass);
        break;
      }
      label446:
      localh1.b(new h((d)localList.get(localList.size() - 1), ""));
      paramClass = localh1;
      break label232;
      lgb.put(str, paramClass);
      AppMethodBeat.o(201034);
      return paramClass;
      label502:
      i += 1;
      break;
    }
  }
  
  static String ay(Class paramClass)
  {
    AppMethodBeat.i(201032);
    String str = paramClass.getName();
    if (lfZ.containsKey(str))
    {
      paramClass = (String)lfZ.get(str);
      AppMethodBeat.o(201032);
      return paramClass;
    }
    try
    {
      paramClass = (String)paramClass.getDeclaredField("NAME").get(null);
      lfZ.put(str, paramClass);
      AppMethodBeat.o(201032);
      return paramClass;
    }
    catch (NoSuchFieldException paramClass)
    {
      AppMethodBeat.o(201032);
      return null;
    }
    catch (IllegalAccessException paramClass)
    {
      AppMethodBeat.o(201032);
    }
    return null;
  }
  
  static List<j> az(Class paramClass)
  {
    AppMethodBeat.i(201033);
    String str = paramClass.getName();
    if (lga.containsKey(str))
    {
      paramClass = (List)lga.get(str);
      AppMethodBeat.o(201033);
      return paramClass;
    }
    ArrayList localArrayList = new ArrayList();
    a(paramClass, new h.b()
    {
      public final void a(h paramAnonymoush)
      {
        AppMethodBeat.i(201029);
        com.tencent.mm.plugin.appbrand.keylogger.base.a locala = paramAnonymoush.bmV();
        if (locala == null)
        {
          AppMethodBeat.o(201029);
          return;
        }
        this.lgc.add(new j(locala, paramAnonymoush.lgt));
        AppMethodBeat.o(201029);
      }
    });
    lga.put(str, localArrayList);
    AppMethodBeat.o(201033);
    return localArrayList;
  }
  
  public static Pattern q(String... paramVarArgs)
  {
    AppMethodBeat.i(201030);
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
    AppMethodBeat.o(201030);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.f
 * JD-Core Version:    0.7.0.1
 */