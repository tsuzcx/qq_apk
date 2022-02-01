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
  private static Map<String, String> kEG;
  private static Map<String, List<j>> kEH;
  private static Map<String, h> kEI;
  
  static
  {
    AppMethodBeat.i(194881);
    kEG = new HashMap();
    kEH = new HashMap();
    kEI = new HashMap();
    AppMethodBeat.o(194881);
  }
  
  public static boolean JZ(String paramString)
  {
    AppMethodBeat.i(194876);
    paramString = ax.fF("Luggage.KeyStepUtils", 2).getString(String.format("KeyStepLoggerSwitch_%s", new Object[] { paramString }), "");
    try
    {
      paramString = new JSONObject(paramString);
      long l1 = paramString.getLong("keepTime");
      long l2 = paramString.getLong("openTime");
      long l3 = System.currentTimeMillis();
      if ((l2 > 0L) && (l3 - l2 < l1))
      {
        AppMethodBeat.o(194876);
        return true;
      }
      AppMethodBeat.o(194876);
      return false;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(194876);
    }
    return false;
  }
  
  static void a(Class paramClass, h.b paramb)
  {
    AppMethodBeat.i(194880);
    h.a(aA(paramClass), paramb);
    AppMethodBeat.o(194880);
  }
  
  public static h aA(Class paramClass)
  {
    AppMethodBeat.i(194879);
    String str = paramClass.getName();
    if (kEI.containsKey(str))
    {
      paramClass = (h)kEI.get(str);
      AppMethodBeat.o(194879);
      return paramClass;
    }
    List localList;
    h localh1;
    int i;
    d locald;
    h localh2;
    try
    {
      localList = (List)org.a.a.bA(paramClass).get("sStepNodes");
      if (localList == null)
      {
        AppMethodBeat.o(194879);
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
      int j = locald.bfZ();
      if (j <= 0)
      {
        j = locald.bfY();
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
            AppMethodBeat.o(194879);
            return null;
          }
        }
        else if (!h.a(localh2.kEY))
        {
          ad.e("StepNode", "addChild but not a node group");
          paramClass = null;
          if (!h.a(locald)) {
            break label502;
          }
          localHashMap.put(Integer.valueOf(locald.bfY()), paramClass);
        }
      }
    }
    catch (b paramClass)
    {
      AppMethodBeat.o(194879);
      return null;
    }
    if (localh2.kEZ == null) {
      localh2.kEZ = new ArrayList();
    }
    if (localh2.kEY.getType() == 3) {}
    for (paramClass = "-";; paramClass = ".")
    {
      if (!bt.isNullOrNil(localh2.kFa)) {}
      for (paramClass = String.format("%s%s%d", new Object[] { localh2.kFa, paramClass, Integer.valueOf(localh2.kEZ.size() + 1) });; paramClass = String.format("%d", new Object[] { Integer.valueOf(localh2.kEZ.size() + 1) }))
      {
        paramClass = new h(locald, paramClass);
        localh2.kEZ.add(paramClass);
        break;
      }
      label446:
      localh1.b(new h((d)localList.get(localList.size() - 1), ""));
      paramClass = localh1;
      break label232;
      kEI.put(str, paramClass);
      AppMethodBeat.o(194879);
      return paramClass;
      label502:
      i += 1;
      break;
    }
  }
  
  static String ay(Class paramClass)
  {
    AppMethodBeat.i(194877);
    String str = paramClass.getName();
    if (kEG.containsKey(str))
    {
      paramClass = (String)kEG.get(str);
      AppMethodBeat.o(194877);
      return paramClass;
    }
    try
    {
      paramClass = (String)paramClass.getDeclaredField("NAME").get(null);
      kEG.put(str, paramClass);
      AppMethodBeat.o(194877);
      return paramClass;
    }
    catch (NoSuchFieldException paramClass)
    {
      AppMethodBeat.o(194877);
      return null;
    }
    catch (IllegalAccessException paramClass)
    {
      AppMethodBeat.o(194877);
    }
    return null;
  }
  
  static List<j> az(Class paramClass)
  {
    AppMethodBeat.i(194878);
    String str = paramClass.getName();
    if (kEH.containsKey(str))
    {
      paramClass = (List)kEH.get(str);
      AppMethodBeat.o(194878);
      return paramClass;
    }
    ArrayList localArrayList = new ArrayList();
    a(paramClass, new h.b()
    {
      public final void a(h paramAnonymoush)
      {
        AppMethodBeat.i(194874);
        com.tencent.mm.plugin.appbrand.keylogger.base.a locala = paramAnonymoush.bgb();
        if (locala == null)
        {
          AppMethodBeat.o(194874);
          return;
        }
        this.kEJ.add(new j(locala, paramAnonymoush.kFa));
        AppMethodBeat.o(194874);
      }
    });
    kEH.put(str, localArrayList);
    AppMethodBeat.o(194878);
    return localArrayList;
  }
  
  public static Pattern q(String... paramVarArgs)
  {
    AppMethodBeat.i(194875);
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
    AppMethodBeat.o(194875);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.f
 * JD-Core Version:    0.7.0.1
 */