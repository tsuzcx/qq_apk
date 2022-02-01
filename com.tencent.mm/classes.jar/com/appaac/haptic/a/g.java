package com.appaac.haptic.a;

import com.appaac.haptic.b.a.d;
import com.appaac.haptic.b.a.e;
import com.appaac.haptic.sync.VibrationPattern;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;

public final class g
{
  private static int cri = 0;
  private static int crj = 0;
  private static boolean crk = false;
  private static int crl = 0;
  
  public static boolean Nw()
  {
    return crk;
  }
  
  private static String a(com.appaac.haptic.b.b.a parama)
  {
    AppMethodBeat.i(208472);
    JSONStringer localJSONStringer;
    for (;;)
    {
      try
      {
        localJSONStringer = new JSONStringer();
        localJSONStringer.object();
        localJSONStringer.key("Metadata").object().key("Created").value(parama.crx.crA).key("Description").value(parama.crx.crB).key("Version").value(parama.crx.crz).endObject();
        localJSONStringer.key("Pattern").array();
        parama = parama.cry.iterator();
        if (!parama.hasNext()) {
          break;
        }
        Object localObject = (e)parama.next();
        localJSONStringer.object();
        localJSONStringer.key("Event").object().key("Type").value(((e)localObject).crw.crp).key("RelativeTime").value(((e)localObject).crw.crq);
        if ("continuous".equals(((e)localObject).crw.crp)) {
          localJSONStringer.key("Duration").value(((e)localObject).crw.crr);
        }
        localJSONStringer.key("Parameters").object().key("Frequency").value(((e)localObject).crw.crt.cro).key("Intensity").value(((e)localObject).crw.crt.cru);
        if ("continuous".equals(((e)localObject).crw.crp))
        {
          localJSONStringer.key("Curve").array();
          localObject = ((e)localObject).crw.crt.crv.iterator();
          if (((Iterator)localObject).hasNext())
          {
            com.appaac.haptic.b.a.a locala = (com.appaac.haptic.b.a.a)((Iterator)localObject).next();
            localJSONStringer.object().key("Frequency").value(locala.cro).key("Intensity").value(locala.crn).key("Time").value(locala.crm).endObject();
            continue;
          }
          localJSONStringer.endArray();
        }
      }
      catch (Exception parama)
      {
        AppMethodBeat.o(208472);
        return null;
      }
      localJSONStringer.endObject().endObject().endObject();
    }
    localJSONStringer.endArray().endObject();
    parama = localJSONStringer.toString();
    AppMethodBeat.o(208472);
    return parama;
  }
  
  public static String a(com.appaac.haptic.b.c.a parama)
  {
    AppMethodBeat.i(208479);
    JSONStringer localJSONStringer;
    for (;;)
    {
      try
      {
        localJSONStringer = new JSONStringer();
        localJSONStringer.object();
        localJSONStringer.key("Metadata").object().key("Created").value(parama.crC.crA).key("Description").value(parama.crC.crB).key("Version").value(parama.crC.crz).endObject();
        localJSONStringer.key("PatternList").array();
        parama = parama.crD.iterator();
        if (!parama.hasNext()) {
          break;
        }
        Object localObject1 = (com.appaac.haptic.b.c.c)parama.next();
        localJSONStringer.object().key("AbsoluteTime").value(((com.appaac.haptic.b.c.c)localObject1).crE).key("Pattern").array();
        localObject1 = ((com.appaac.haptic.b.c.c)localObject1).cry.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label448;
        }
        Object localObject2 = (e)((Iterator)localObject1).next();
        localJSONStringer.object();
        localJSONStringer.key("Event").object().key("Index").value(((e)localObject2).crw.crs).key("RelativeTime").value(((e)localObject2).crw.crq).key("Type").value(((e)localObject2).crw.crp);
        if ("continuous".equals(((e)localObject2).crw.crp)) {
          localJSONStringer.key("Duration").value(((e)localObject2).crw.crr);
        }
        localJSONStringer.key("Parameters").object().key("Frequency").value(((e)localObject2).crw.crt.cro).key("Intensity").value(((e)localObject2).crw.crt.cru);
        if ("continuous".equals(((e)localObject2).crw.crp))
        {
          localJSONStringer.key("Curve").array();
          localObject2 = ((e)localObject2).crw.crt.crv.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            com.appaac.haptic.b.a.a locala = (com.appaac.haptic.b.a.a)((Iterator)localObject2).next();
            localJSONStringer.object().key("Frequency").value(locala.cro).key("Intensity").value(locala.crn).key("Time").value(locala.crm).endObject();
            continue;
          }
          localJSONStringer.endArray();
        }
      }
      catch (Exception parama)
      {
        AppMethodBeat.o(208479);
        return null;
      }
      localJSONStringer.endObject().endObject().endObject();
      continue;
      label448:
      localJSONStringer.endArray().endObject();
    }
    localJSONStringer.endArray().endObject();
    parama = localJSONStringer.toString();
    AppMethodBeat.o(208479);
    return parama;
  }
  
  public static VibrationPattern b(com.appaac.haptic.b.c.a parama)
  {
    AppMethodBeat.i(208492);
    if (!com.appaac.haptic.c.a.a(parama))
    {
      AppMethodBeat.o(208492);
      return null;
    }
    com.appaac.haptic.b.c.a locala = new com.appaac.haptic.b.c.a();
    locala.crC = new com.appaac.haptic.b.c.b();
    locala.crD = new ArrayList();
    locala.crD.add(parama.crD.get(0));
    parama = new StringBuilder(a(locala));
    parama = new VibrationPattern(parama.substring(parama.indexOf("\"Pattern\""), parama.lastIndexOf("}", parama.lastIndexOf("}"))));
    AppMethodBeat.o(208492);
    return parama;
  }
  
  public static com.appaac.haptic.b.a.c ba(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(208438);
    switch (bd(paramString))
    {
    default: 
      AppMethodBeat.o(208438);
      return null;
    }
    try
    {
      paramString = be(paramString);
      AppMethodBeat.o(208438);
      return paramString;
    }
    catch (Exception paramString)
    {
      try
      {
        paramString = bf(paramString);
        AppMethodBeat.o(208438);
        return paramString;
        paramString = paramString;
        paramString = localObject1;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString = localObject2;
        }
      }
    }
  }
  
  public static String bb(String paramString)
  {
    AppMethodBeat.i(208453);
    com.appaac.haptic.b.c.a locala = null;
    try
    {
      paramString = be(paramString);
      if ((paramString == null) || (paramString.cry == null) || (paramString.cry.size() == 0))
      {
        AppMethodBeat.o(208453);
        return "";
      }
      locala = new com.appaac.haptic.b.c.a();
      locala.crC = new com.appaac.haptic.b.c.b();
      locala.crD = new ArrayList();
      com.appaac.haptic.b.c.c localc = new com.appaac.haptic.b.c.c();
      localc.cry = paramString.cry;
      localc.crE = 0;
      locala.crD.add(localc);
      paramString = a(locala);
      AppMethodBeat.o(208453);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = locala;
      }
    }
  }
  
  public static String bc(String paramString)
  {
    AppMethodBeat.i(208461);
    try
    {
      locala = bf(paramString);
      if (!com.appaac.haptic.c.a.a(locala))
      {
        AppMethodBeat.o(208461);
        return "";
      }
    }
    catch (Exception paramString)
    {
      com.appaac.haptic.b.c.a locala;
      for (;;)
      {
        locala = null;
      }
      Iterator localIterator1 = locala.crD.iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((com.appaac.haptic.b.c.c)localIterator1.next()).cry.iterator();
        while (localIterator2.hasNext())
        {
          e locale = (e)localIterator2.next();
          d locald = locale.crw.crt;
          paramString = locale.crw.crt.crv;
          if ((paramString == null) || (paramString.size() == 0)) {
            paramString = null;
          }
          for (;;)
          {
            locald.crv = paramString;
            if (!locale.crw.crp.equals("transient")) {
              break;
            }
            if (locale.crw.crt.cro >= 0) {
              break label566;
            }
            locale.crw.crt.cro = 0;
            break;
            int j = paramString.size();
            if ((j <= 0) || (j > 4))
            {
              com.appaac.haptic.b.a.a locala1 = new com.appaac.haptic.b.a.a();
              int k = (j - 2) / 2;
              int m = j - 2;
              int i = 1;
              int n;
              while (i <= k)
              {
                n = locala1.crm;
                locala1.crm = (((com.appaac.haptic.b.a.a)paramString.get(i)).crm + n);
                locala1.crn += ((com.appaac.haptic.b.a.a)paramString.get(i)).crn;
                n = locala1.cro;
                locala1.cro = (((com.appaac.haptic.b.a.a)paramString.get(i)).cro + n);
                i += 1;
              }
              locala1.crm /= k;
              locala1.crn /= k;
              locala1.crn = (Math.round(locala1.crn * 10.0D) / 10.0D);
              locala1.cro /= k;
              com.appaac.haptic.b.a.a locala2 = new com.appaac.haptic.b.a.a();
              i = k + 1;
              while (i <= m)
              {
                n = locala2.crm;
                locala2.crm = (((com.appaac.haptic.b.a.a)paramString.get(i)).crm + n);
                locala2.crn += ((com.appaac.haptic.b.a.a)paramString.get(i)).crn;
                n = locala2.cro;
                locala2.cro = (((com.appaac.haptic.b.a.a)paramString.get(i)).cro + n);
                i += 1;
              }
              locala2.crm /= (m - k);
              locala2.crn /= (m - k);
              locala2.crn = (Math.round(locala2.crn * 10.0D) / 10.0D);
              locala2.cro /= (m - k);
              paramString.subList(1, j - 1).clear();
              paramString.add(1, locala1);
              paramString.add(2, locala2);
            }
          }
          label566:
          if (locale.crw.crt.cro > 100) {
            locale.crw.crt.cro = 100;
          }
        }
      }
      paramString = a(locala);
      AppMethodBeat.o(208461);
    }
    return paramString;
  }
  
  public static int bd(String paramString)
  {
    AppMethodBeat.i(208464);
    int i = 0;
    try
    {
      int j = new JSONObject(paramString).getJSONObject("Metadata").getInt("Version");
      i = j;
    }
    catch (Exception paramString)
    {
      label29:
      break label29;
    }
    AppMethodBeat.o(208464);
    return i;
  }
  
  public static com.appaac.haptic.b.b.a be(String paramString)
  {
    AppMethodBeat.i(208468);
    if (1 != bd(paramString))
    {
      AppMethodBeat.o(208468);
      return null;
    }
    try
    {
      Object localObject1 = new JSONObject(paramString);
      paramString = new com.appaac.haptic.b.b.a();
      paramString.crx = new com.appaac.haptic.b.b.b();
      paramString.cry = new ArrayList();
      localObject1 = ((JSONObject)localObject1).getJSONArray("Pattern");
      int i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        Object localObject2 = (JSONObject)((JSONArray)localObject1).get(i);
        e locale = new e();
        locale.crw = new com.appaac.haptic.b.a.b();
        localObject2 = ((JSONObject)localObject2).getJSONObject("Event");
        locale.crw.crp = ((JSONObject)localObject2).getString("Type");
        if ("continuous".equals(locale.crw.crp)) {
          locale.crw.crr = ((JSONObject)localObject2).getInt("Duration");
        }
        locale.crw.crq = ((JSONObject)localObject2).getInt("RelativeTime");
        localObject2 = ((JSONObject)localObject2).getJSONObject("Parameters");
        locale.crw.crt = new d();
        locale.crw.crt.cro = ((JSONObject)localObject2).getInt("Frequency");
        locale.crw.crt.cru = ((JSONObject)localObject2).getInt("Intensity");
        locale.crw.crt.crv = new ArrayList();
        if ("continuous".equals(locale.crw.crp))
        {
          localObject2 = ((JSONObject)localObject2).getJSONArray("Curve");
          int j = 0;
          while (j < ((JSONArray)localObject2).length())
          {
            JSONObject localJSONObject = (JSONObject)((JSONArray)localObject2).get(j);
            com.appaac.haptic.b.a.a locala = new com.appaac.haptic.b.a.a();
            locala.cro = localJSONObject.getInt("Frequency");
            locala.crn = localJSONObject.getDouble("Intensity");
            locala.crm = localJSONObject.getInt("Time");
            locale.crw.crt.crv.add(locala);
            j += 1;
          }
        }
        paramString.cry.add(locale);
        i += 1;
      }
      AppMethodBeat.o(208468);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(208468);
    }
    return null;
  }
  
  public static com.appaac.haptic.b.c.a bf(String paramString)
  {
    AppMethodBeat.i(208477);
    if (2 != bd(paramString))
    {
      AppMethodBeat.o(208477);
      return null;
    }
    try
    {
      Object localObject1 = new JSONObject(paramString);
      paramString = new com.appaac.haptic.b.c.a();
      paramString.crC = new com.appaac.haptic.b.c.b();
      paramString.crD = new ArrayList();
      localObject1 = ((JSONObject)localObject1).getJSONArray("PatternList");
      int i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        Object localObject2 = (JSONObject)((JSONArray)localObject1).get(i);
        com.appaac.haptic.b.c.c localc = new com.appaac.haptic.b.c.c();
        localc.crE = ((JSONObject)localObject2).getInt("AbsoluteTime");
        localc.cry = new ArrayList();
        localObject2 = ((JSONObject)localObject2).getJSONArray("Pattern");
        int j = 0;
        while (j < ((JSONArray)localObject2).length())
        {
          Object localObject3 = (JSONObject)((JSONArray)localObject2).get(j);
          e locale = new e();
          locale.crw = new com.appaac.haptic.b.a.b();
          localObject3 = ((JSONObject)localObject3).getJSONObject("Event");
          locale.crw.crp = ((JSONObject)localObject3).getString("Type");
          if ("continuous".equals(locale.crw.crp)) {
            locale.crw.crr = ((JSONObject)localObject3).getInt("Duration");
          }
          locale.crw.crq = ((JSONObject)localObject3).getInt("RelativeTime");
          locale.crw.crs = ((JSONObject)localObject3).getInt("Index");
          localObject3 = ((JSONObject)localObject3).getJSONObject("Parameters");
          locale.crw.crt = new d();
          locale.crw.crt.cro = ((JSONObject)localObject3).getInt("Frequency");
          locale.crw.crt.cru = ((JSONObject)localObject3).getInt("Intensity");
          locale.crw.crt.crv = new ArrayList();
          if ("continuous".equals(locale.crw.crp))
          {
            localObject3 = ((JSONObject)localObject3).getJSONArray("Curve");
            int k = 0;
            while (k < ((JSONArray)localObject3).length())
            {
              JSONObject localJSONObject = (JSONObject)((JSONArray)localObject3).get(k);
              com.appaac.haptic.b.a.a locala = new com.appaac.haptic.b.a.a();
              locala.cro = localJSONObject.getInt("Frequency");
              locala.crn = localJSONObject.getDouble("Intensity");
              locala.crm = localJSONObject.getInt("Time");
              locale.crw.crt.crv.add(locala);
              k += 1;
            }
          }
          localc.cry.add(locale);
          j += 1;
        }
        paramString.crD.add(localc);
        i += 1;
      }
      AppMethodBeat.o(208477);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(208477);
    }
    return null;
  }
  
  public static String bg(String paramString)
  {
    AppMethodBeat.i(208486);
    if (2 != bd(paramString))
    {
      AppMethodBeat.o(208486);
      return null;
    }
    paramString = bf(paramString);
    if (!com.appaac.haptic.c.a.a(paramString))
    {
      AppMethodBeat.o(208486);
      return null;
    }
    int j = 0;
    Iterator localIterator;
    Object localObject;
    int k;
    int m;
    com.appaac.haptic.b.a.b localb;
    int i;
    int n;
    while (j <= 2)
    {
      localIterator = paramString.crD.iterator();
      while (localIterator.hasNext())
      {
        localObject = (com.appaac.haptic.b.c.c)localIterator.next();
        if (((com.appaac.haptic.b.c.c)localObject).cry.size() > 1)
        {
          k = 0;
          m = 0;
          if (k < ((com.appaac.haptic.b.c.c)localObject).cry.size())
          {
            localb = ((e)((com.appaac.haptic.b.c.c)localObject).cry.get(k)).crw;
            i = m;
            if (localb != null)
            {
              i = m;
              if (localb.crs == j)
              {
                n = localb.crq;
                if (!localb.crp.equals("continuous")) {
                  break label214;
                }
                i = localb.crr + n;
                label175:
                if (n >= m) {
                  break label223;
                }
                ((e)((com.appaac.haptic.b.c.c)localObject).cry.get(k)).crw.crq = -1;
                i = m;
              }
            }
            label214:
            label223:
            for (;;)
            {
              k += 1;
              m = i;
              break;
              i = n + 22;
              break label175;
            }
          }
          localObject = ((com.appaac.haptic.b.c.c)localObject).cry.iterator();
          while (((Iterator)localObject).hasNext()) {
            if (((e)((Iterator)localObject).next()).crw.crq < 0) {
              ((Iterator)localObject).remove();
            }
          }
        }
      }
      j += 1;
    }
    j = 1;
    while (j <= 2)
    {
      localIterator = paramString.crD.iterator();
      while (localIterator.hasNext())
      {
        localObject = (com.appaac.haptic.b.c.c)localIterator.next();
        if (((com.appaac.haptic.b.c.c)localObject).cry.size() > 1)
        {
          k = 0;
          m = 0;
          if (k < ((com.appaac.haptic.b.c.c)localObject).cry.size())
          {
            localb = ((e)((com.appaac.haptic.b.c.c)localObject).cry.get(k)).crw;
            i = m;
            if (localb != null) {
              if (localb.crs != j)
              {
                i = m;
                if (localb.crs != 0) {}
              }
              else
              {
                n = localb.crq;
                if (!localb.crp.equals("continuous")) {
                  break label462;
                }
                i = localb.crr + n;
                label423:
                if (n >= m) {
                  break label471;
                }
                ((e)((com.appaac.haptic.b.c.c)localObject).cry.get(k)).crw.crq = -1;
                i = m;
              }
            }
            label462:
            label471:
            for (;;)
            {
              k += 1;
              m = i;
              break;
              i = n + 22;
              break label423;
            }
          }
          localObject = ((com.appaac.haptic.b.c.c)localObject).cry.iterator();
          while (((Iterator)localObject).hasNext()) {
            if (((e)((Iterator)localObject).next()).crw.crq < 0) {
              ((Iterator)localObject).remove();
            }
          }
        }
      }
      j += 1;
    }
    paramString = a(paramString);
    AppMethodBeat.o(208486);
    return paramString;
  }
  
  public static int bh(String paramString)
  {
    AppMethodBeat.i(208501);
    paramString = bf(paramString);
    if (paramString != null)
    {
      int i = paramString.getDuration();
      AppMethodBeat.o(208501);
      return i;
    }
    AppMethodBeat.o(208501);
    return 0;
  }
  
  public static int bi(String paramString)
  {
    AppMethodBeat.i(208504);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(208504);
      return 0;
    }
    paramString = ba(paramString);
    if (!com.appaac.haptic.c.a.a(paramString))
    {
      AppMethodBeat.o(208504);
      return 0;
    }
    int i = paramString.getDuration();
    AppMethodBeat.o(208504);
    return i;
  }
  
  public static void bq(boolean paramBoolean)
  {
    crk = paramBoolean;
  }
  
  public static int c(com.appaac.haptic.b.c.a parama)
  {
    AppMethodBeat.i(208497);
    if (com.appaac.haptic.c.a.a(parama))
    {
      int i = parama.crD.size();
      AppMethodBeat.o(208497);
      return i;
    }
    AppMethodBeat.o(208497);
    return -1;
  }
  
  public static int gU(int paramInt)
  {
    cri = paramInt;
    return paramInt;
  }
  
  public static int gV(int paramInt)
  {
    crj = paramInt;
    return paramInt;
  }
  
  public static int getMajorVersion()
  {
    return cri;
  }
  
  public static int getMinorVersion()
  {
    return crj;
  }
  
  public static String n(String paramString, int paramInt)
  {
    AppMethodBeat.i(208412);
    switch (bd(paramString))
    {
    default: 
      AppMethodBeat.o(208412);
      return "";
    case 1: 
      paramString = o(paramString, paramInt);
      AppMethodBeat.o(208412);
      return paramString;
    }
    paramString = p(paramString, paramInt);
    AppMethodBeat.o(208412);
    return paramString;
  }
  
  private static String o(String paramString, int paramInt)
  {
    AppMethodBeat.i(208419);
    Iterator localIterator;
    Object localObject;
    do
    {
      try
      {
        paramString = be(paramString);
        if ((paramString == null) || (paramString.cry == null) || (paramString.cry.size() == 0))
        {
          AppMethodBeat.o(208419);
          return "";
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString = null;
        }
        localIterator = paramString.cry.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
      }
      localObject = (e)localIterator.next();
    } while ((((e)localObject).crw == null) || (((e)localObject).crw.crq < paramInt));
    for (int i = paramString.cry.indexOf(localObject);; i = -1)
    {
      if (i < 0)
      {
        AppMethodBeat.o(208419);
        return "";
      }
      paramString.cry.subList(0, i).clear();
      localIterator = paramString.cry.iterator();
      while (localIterator.hasNext())
      {
        localObject = (e)localIterator.next();
        if (((e)localObject).crw != null)
        {
          localObject = ((e)localObject).crw;
          ((com.appaac.haptic.b.a.b)localObject).crq -= paramInt;
        }
      }
      paramString = a(paramString);
      AppMethodBeat.o(208419);
      return paramString;
    }
  }
  
  private static String p(String paramString, int paramInt)
  {
    AppMethodBeat.i(208429);
    Iterator localIterator1;
    com.appaac.haptic.b.c.c localc;
    Iterator localIterator2;
    e locale;
    do
    {
      while (!localIterator2.hasNext())
      {
        do
        {
          try
          {
            paramString = bf(paramString);
            if ((paramString == null) || (paramString.crD == null) || (paramString.crD.size() == 0))
            {
              AppMethodBeat.o(208429);
              return "";
            }
          }
          catch (Exception paramString)
          {
            paramString = null;
            break;
            localIterator1 = paramString.crD.iterator();
            if (!localIterator1.hasNext()) {
              break label374;
            }
          }
          localc = (com.appaac.haptic.b.c.c)localIterator1.next();
        } while (localc.cry == null);
        localIterator2 = localc.cry.iterator();
      }
      locale = (e)localIterator2.next();
    } while ((locale.crw == null) || (locale.crw.crq + localc.crE < paramInt));
    int j = localc.cry.indexOf(locale);
    for (int i = paramString.crD.indexOf(localc);; i = -1)
    {
      if ((i < 0) || (j < 0))
      {
        AppMethodBeat.o(208429);
        return "";
      }
      paramString.crD.subList(0, i).clear();
      ((com.appaac.haptic.b.c.c)paramString.crD.get(0)).cry.subList(0, j).clear();
      localIterator1 = paramString.crD.iterator();
      while (localIterator1.hasNext())
      {
        localc = (com.appaac.haptic.b.c.c)localIterator1.next();
        if (localc.cry != null) {
          if (localc.crE < paramInt)
          {
            localIterator2 = localc.cry.iterator();
            while (localIterator2.hasNext())
            {
              locale = (e)localIterator2.next();
              if (locale.crw != null) {
                locale.crw.crq = (locale.crw.crq + localc.crE - paramInt);
              }
            }
            localc.crE = 0;
          }
          else
          {
            localc.crE -= paramInt;
          }
        }
      }
      paramString = a(paramString);
      AppMethodBeat.o(208429);
      return paramString;
      label374:
      j = -1;
    }
  }
  
  /* Error */
  public static String r(java.io.File paramFile)
  {
    // Byte code:
    //   0: ldc_w 395
    //   3: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnull +10 -> 17
    //   10: aload_0
    //   11: invokevirtual 400	java/io/File:exists	()Z
    //   14: ifne +13 -> 27
    //   17: ldc_w 395
    //   20: invokestatic 181	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: ldc_w 288
    //   26: areturn
    //   27: new 239	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 401	java/lang/StringBuilder:<init>	()V
    //   34: astore_1
    //   35: new 403	java/io/BufferedReader
    //   38: dup
    //   39: new 405	java/io/InputStreamReader
    //   42: dup
    //   43: new 407	java/io/FileInputStream
    //   46: dup
    //   47: aload_0
    //   48: invokespecial 410	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   51: invokespecial 413	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   54: invokespecial 416	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   57: astore_0
    //   58: aload_0
    //   59: invokevirtual 419	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   62: astore_2
    //   63: aload_2
    //   64: ifnull +30 -> 94
    //   67: aload_1
    //   68: aload_2
    //   69: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: goto -15 -> 58
    //   76: astore_2
    //   77: aload_0
    //   78: invokevirtual 426	java/io/BufferedReader:close	()V
    //   81: aload_1
    //   82: invokevirtual 427	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: astore_0
    //   86: ldc_w 395
    //   89: invokestatic 181	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aload_0
    //   93: areturn
    //   94: aload_0
    //   95: invokevirtual 426	java/io/BufferedReader:close	()V
    //   98: goto -17 -> 81
    //   101: astore_0
    //   102: goto -21 -> 81
    //   105: astore_0
    //   106: aconst_null
    //   107: astore_1
    //   108: aload_1
    //   109: invokevirtual 426	java/io/BufferedReader:close	()V
    //   112: ldc_w 395
    //   115: invokestatic 181	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aload_0
    //   119: athrow
    //   120: astore_0
    //   121: goto -40 -> 81
    //   124: astore_1
    //   125: goto -13 -> 112
    //   128: astore_1
    //   129: aload_0
    //   130: astore_2
    //   131: aload_1
    //   132: astore_0
    //   133: aload_2
    //   134: astore_1
    //   135: goto -27 -> 108
    //   138: astore_0
    //   139: aconst_null
    //   140: astore_0
    //   141: goto -64 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	paramFile	java.io.File
    //   34	75	1	localStringBuilder	StringBuilder
    //   124	1	1	localException1	Exception
    //   128	4	1	localObject1	Object
    //   134	1	1	localObject2	Object
    //   62	7	2	str	String
    //   76	1	2	localException2	Exception
    //   130	4	2	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   58	63	76	java/lang/Exception
    //   67	73	76	java/lang/Exception
    //   94	98	101	java/lang/Exception
    //   35	58	105	finally
    //   77	81	120	java/lang/Exception
    //   108	112	124	java/lang/Exception
    //   58	63	128	finally
    //   67	73	128	finally
    //   35	58	138	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.appaac.haptic.a.g
 * JD-Core Version:    0.7.0.1
 */