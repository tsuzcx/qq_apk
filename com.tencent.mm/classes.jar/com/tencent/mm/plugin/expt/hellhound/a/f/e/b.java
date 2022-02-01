package com.tencent.mm.plugin.expt.hellhound.a.f.e;

import android.annotation.SuppressLint;
import android.support.v4.e.k;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.f.l;
import com.tencent.mm.protocal.protobuf.aur;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.protocal.protobuf.bou;
import com.tencent.mm.protocal.protobuf.bov;
import com.tencent.mm.protocal.protobuf.bta;
import com.tencent.mm.protocal.protobuf.cid;
import com.tencent.mm.protocal.protobuf.dwx;
import com.tencent.mm.protocal.protobuf.oh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.c;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class b
{
  private static bov a(Object paramObject, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(196146);
    paramString2 = agg(paramString2);
    if (paramString2 == null)
    {
      AppMethodBeat.o(196146);
      return null;
    }
    for (;;)
    {
      try
      {
        paramString1 = Class.forName(paramString1);
        paramString2 = paramString2.iterator();
        Object localObject1;
        if (paramString2.hasNext())
        {
          localObject1 = (k)paramString2.next();
          if (localObject1 != null)
          {
            Object localObject2 = (String)((k)localObject1).first;
            localObject1 = (String)((k)localObject1).second;
            if ((localObject2 != null) && (!((String)localObject2).isEmpty()) && (localObject1 != null) && (!((String)localObject1).isEmpty()))
            {
              localObject2 = paramString1.getDeclaredField((String)localObject2);
              ((Field)localObject2).setAccessible(true);
              paramObject = ((Field)localObject2).get(paramObject);
              int i;
              if (((String)localObject1).startsWith("["))
              {
                localObject1 = agh((String)localObject1);
                if (localObject1 != null)
                {
                  i = ((Integer)((c)localObject1).get(1)).intValue();
                  paramObject = (Object[])paramObject;
                  if ((paramObject == null) || (paramObject.length <= 0) || (i >= paramObject.length))
                  {
                    ae.e("HABBYGE-MALI.HellSessionParamUtil", "array == null || array.length <= 0");
                    AppMethodBeat.o(196146);
                    return null;
                  }
                  paramObject = paramObject[i];
                  paramString1 = Class.forName((String)((com.tencent.mm.vending.j.b)localObject1).get(0));
                }
              }
              else if (((String)localObject1).startsWith("Ljava/util/List;"))
              {
                localObject1 = gd((String)localObject1, "Ljava/util/List;");
                if (localObject1 != null)
                {
                  paramObject = (List)paramObject;
                  try
                  {
                    i = Integer.parseInt((String)((c)localObject1).get(1));
                    if ((paramObject == null) || (paramObject.isEmpty()) || (i >= paramObject.size()))
                    {
                      ae.e("HABBYGE-MALI.HellSessionParamUtil", "list.isEmpty");
                      AppMethodBeat.o(196146);
                      return null;
                    }
                  }
                  catch (NumberFormatException paramObject)
                  {
                    ae.printErrStackTrace("HABBYGE-MALI.HellSessionParamUtil", paramObject, "SessionParam, Ljava/util/List;, crash", new Object[0]);
                    AppMethodBeat.o(196146);
                    return null;
                  }
                  paramObject = paramObject.get(i);
                  paramString1 = Class.forName((String)((com.tencent.mm.vending.j.b)localObject1).get(0));
                }
              }
              else
              {
                int j;
                if (((String)localObject1).startsWith("Ljava/util/ArrayList;"))
                {
                  localObject1 = gd((String)localObject1, "Ljava/util/ArrayList;");
                  if (localObject1 != null)
                  {
                    paramObject = (ArrayList)paramObject;
                    try
                    {
                      i = Integer.parseInt((String)((c)localObject1).get(1));
                      if ((paramObject != null) && (!paramObject.isEmpty()))
                      {
                        j = paramObject.size();
                        if (i < j) {}
                      }
                      else
                      {
                        AppMethodBeat.o(196146);
                        return null;
                      }
                    }
                    catch (NumberFormatException paramObject)
                    {
                      ae.printErrStackTrace("HABBYGE-MALI.HellSessionParamUtil", paramObject, "SessionParam, Ljava/util/ArrayList;, crash", new Object[0]);
                      AppMethodBeat.o(196146);
                      return null;
                    }
                    paramObject = paramObject.get(i);
                    paramString1 = Class.forName((String)((com.tencent.mm.vending.j.b)localObject1).get(0));
                  }
                }
                else if (((String)localObject1).startsWith("Ljava/util/LinkedList;"))
                {
                  localObject1 = gd((String)localObject1, "Ljava/util/LinkedList;");
                  if (localObject1 != null)
                  {
                    paramObject = (LinkedList)paramObject;
                    try
                    {
                      i = Integer.parseInt((String)((c)localObject1).get(1));
                      if ((paramObject != null) && (!paramObject.isEmpty()))
                      {
                        j = paramObject.size();
                        if (i < j) {}
                      }
                      else
                      {
                        AppMethodBeat.o(196146);
                        return null;
                      }
                    }
                    catch (NumberFormatException paramObject)
                    {
                      ae.printErrStackTrace("HABBYGE-MALI.HellSessionParamUtil", paramObject, "_doParse, Ljava/util/LinkedList;, crash", new Object[0]);
                      AppMethodBeat.o(196146);
                      return null;
                    }
                    paramObject = paramObject.get(i);
                    paramString1 = Class.forName((String)((com.tencent.mm.vending.j.b)localObject1).get(0));
                  }
                }
                else
                {
                  boolean bool;
                  if (((String)localObject1).startsWith("Ljava/util/Map;"))
                  {
                    localObject1 = gd((String)localObject1, "Ljava/util/Map;");
                    if (localObject1 != null)
                    {
                      paramObject = (Map)paramObject;
                      if (paramObject != null)
                      {
                        bool = paramObject.isEmpty();
                        if (!bool) {}
                      }
                      else
                      {
                        AppMethodBeat.o(196146);
                        return null;
                      }
                      paramObject = paramObject.get(((c)localObject1).get(1));
                      if (paramObject == null)
                      {
                        AppMethodBeat.o(196146);
                        return null;
                      }
                      paramString1 = Class.forName((String)((com.tencent.mm.vending.j.b)localObject1).get(0));
                    }
                  }
                  else if (((String)localObject1).startsWith("Ljava/util/HashMap;"))
                  {
                    localObject1 = gd((String)localObject1, "Ljava/util/HashMap;");
                    if (localObject1 != null)
                    {
                      paramObject = (HashMap)paramObject;
                      if (paramObject != null)
                      {
                        bool = paramObject.isEmpty();
                        if (!bool) {}
                      }
                      else
                      {
                        AppMethodBeat.o(196146);
                        return null;
                      }
                      paramObject = paramObject.get(((c)localObject1).get(1));
                      if (paramObject == null)
                      {
                        AppMethodBeat.o(196146);
                        return null;
                      }
                      paramString1 = Class.forName((String)((com.tencent.mm.vending.j.b)localObject1).get(0));
                    }
                  }
                  else
                  {
                    paramString1 = Class.forName((String)localObject1);
                  }
                }
              }
            }
          }
        }
        else
        {
          if (paramObject == null)
          {
            ae.e("HABBYGE-MALI.HellSessionParamUtil", "SessionParams, object == NULL !!");
            AppMethodBeat.o(196146);
            return null;
          }
          localObject1 = new bov();
          paramString2 = String.valueOf(paramObject);
          paramString1 = paramString2;
          if ((paramObject instanceof Long)) {
            paramString1 = com.tencent.mm.plugin.expt.hellhound.core.b.rp(bu.getLong(paramString2, 0L));
          }
          ae.i("HABBYGE-MALI.HellSessionParamUtil", "SessionParams, value: %s, %s", new Object[] { paramString1, paramString3 });
          ((bov)localObject1).value = paramString1;
          ((bov)localObject1).dGe = paramString3;
          AppMethodBeat.o(196146);
          return localObject1;
        }
      }
      catch (Exception paramObject)
      {
        AppMethodBeat.o(196146);
        return null;
      }
    }
  }
  
  private static void a(bov parambov, aur paramaur)
  {
    AppMethodBeat.i(196144);
    int j = paramaur.GLC.size();
    int i = 0;
    while (i < j)
    {
      bov localbov = (bov)paramaur.GLC.get(i);
      if ((localbov.dGe != null) && (localbov.dGe.equals(parambov.dGe))) {
        break;
      }
      i += 1;
    }
    if (i < j)
    {
      paramaur.GLC.set(i, parambov);
      AppMethodBeat.o(196144);
      return;
    }
    paramaur.GLC.add(parambov);
    AppMethodBeat.o(196144);
  }
  
  @SuppressLint({"NewApi"})
  static void a(Object paramObject, cid paramcid, long paramLong, dwx paramdwx)
  {
    AppMethodBeat.i(196145);
    if ((paramObject == null) || (TextUtils.isEmpty(paramcid.className)) || (TextUtils.isEmpty(paramcid.dGe)) || (paramdwx == null))
    {
      AppMethodBeat.o(196145);
      return;
    }
    if (paramcid.Hum == null) {}
    for (Object localObject = paramcid.dGe;; localObject = paramcid.Hum.hKR)
    {
      bov localbov = a(paramObject, paramcid.Hul, (String)localObject, paramcid.dGe);
      localObject = localbov;
      if (localbov != null) {
        break;
      }
      l.tn(129L);
      paramObject = a(paramObject, paramcid.className, paramcid.dGe, paramcid.dGe);
      localObject = paramObject;
      if (paramObject != null) {
        break;
      }
      l.tn(133L);
      AppMethodBeat.o(196145);
      return;
    }
    l.tn(132L);
    paramObject = paramdwx.GbV.iterator();
    while (paramObject.hasNext())
    {
      paramcid = (oh)paramObject.next();
      if (paramLong == paramcid.GbU) {
        paramcid.GbV.add(localObject);
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramObject = new oh();
        paramObject.GbU = paramLong;
        paramObject.GbV.add(localObject);
        paramdwx.GbV.add(paramObject);
        ae.i("HABBYGE-MALI.HellSessionParamUtil", "catchParamsWhenViewOp, add pathId=%s, dataPath=%s, value=%s", new Object[] { Long.valueOf(paramLong), ((bov)localObject).dGe, ((bov)localObject).value });
      }
      AppMethodBeat.o(196145);
      return;
    }
  }
  
  static void a(Object paramObject, cid paramcid, aus paramaus, boolean paramBoolean)
  {
    AppMethodBeat.i(169357);
    if ((paramObject == null) || (TextUtils.isEmpty(paramcid.className)) || (TextUtils.isEmpty(paramcid.dGe)))
    {
      AppMethodBeat.o(169357);
      return;
    }
    if ("0".equals(paramcid.action))
    {
      if (!paramBoolean) {
        AppMethodBeat.o(169357);
      }
    }
    else if (("2".equals(paramcid.action)) && (paramBoolean))
    {
      AppMethodBeat.o(169357);
      return;
    }
    String str = paramObject.getClass().getSimpleName();
    if (paramcid.Hum == null) {}
    for (Object localObject = paramcid.dGe;; localObject = paramcid.Hum.hKR)
    {
      bov localbov = a(paramObject, paramcid.Hul, (String)localObject, paramcid.dGe);
      localObject = localbov;
      if (localbov != null) {
        break;
      }
      if ((paramcid.Hum != null) && (!TextUtils.isEmpty(paramcid.Hum.hKR))) {
        l.tn(158L);
      }
      paramObject = a(paramObject, paramcid.className, paramcid.dGe, paramcid.dGe);
      localObject = paramObject;
      if (paramObject != null) {
        break;
      }
      AppMethodBeat.o(169357);
      return;
    }
    l.tn(135L);
    int i = paramaus.GLG.size() - 1;
    while (i >= 0)
    {
      paramObject = (aur)paramaus.GLG.get(i);
      paramcid = com.tencent.mm.plugin.expt.hellhound.core.b.aer(paramObject.name);
      if ((paramcid != null) && (paramcid.equals(str)))
      {
        a((bov)localObject, paramObject);
        AppMethodBeat.o(169357);
        return;
      }
      i -= 1;
    }
    AppMethodBeat.o(169357);
  }
  
  @SuppressLint({"NewApi"})
  static void a(Object paramObject, cid paramcid, bou parambou, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(122195);
    if ((paramObject == null) || (TextUtils.isEmpty(paramcid.className)) || (TextUtils.isEmpty(paramcid.dGe)))
    {
      AppMethodBeat.o(122195);
      return;
    }
    if ("0".equals(paramcid.action))
    {
      if (!paramBoolean2) {
        AppMethodBeat.o(122195);
      }
    }
    else if (("2".equals(paramcid.action)) && (paramBoolean2))
    {
      AppMethodBeat.o(122195);
      return;
    }
    if (paramcid.Hum == null) {}
    for (Object localObject = paramcid.dGe;; localObject = paramcid.Hum.hKR)
    {
      bov localbov = a(paramObject, paramcid.Hul, (String)localObject, paramcid.dGe);
      localObject = localbov;
      if (localbov != null) {
        break;
      }
      if ((!paramBoolean1) && (paramcid.Hum != null) && (!TextUtils.isEmpty(paramcid.Hum.hKR))) {
        l.tn(158L);
      }
      paramObject = a(paramObject, paramcid.className, paramcid.dGe, paramcid.dGe);
      localObject = paramObject;
      if (paramObject != null) {
        break;
      }
      AppMethodBeat.o(122195);
      return;
    }
    if (paramBoolean1)
    {
      parambou.Hcl.add(localObject);
      AppMethodBeat.o(122195);
      return;
    }
    parambou.GLC.add(localObject);
    l.tn(135L);
    AppMethodBeat.o(122195);
  }
  
  private static List<k<String, String>> agg(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(122197);
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramString = paramString.split(",");
      int j = paramString.length;
      while (i < j)
      {
        String[] arrayOfString = paramString[i].split("\\|");
        localArrayList.add(new k(arrayOfString[0], arrayOfString[1]));
        i += 1;
      }
      AppMethodBeat.o(122197);
      return localArrayList;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(122197);
    }
    return null;
  }
  
  private static c<String, Integer> agh(String paramString)
  {
    AppMethodBeat.i(122198);
    c localc = agi(paramString);
    if (localc == null)
    {
      AppMethodBeat.o(122198);
      return null;
    }
    paramString = paramString.substring(paramString.indexOf("[") + 1, ((Integer)localc.get(1)).intValue());
    try
    {
      int i = Integer.parseInt((String)localc.get(0));
      paramString = a.N(paramString, Integer.valueOf(i));
      AppMethodBeat.o(122198);
      return paramString;
    }
    catch (NumberFormatException paramString)
    {
      ae.printErrStackTrace("HABBYGE-MALI.HellSessionParamUtil", paramString, "HellPageParamsCatcher, getClassNameAndIndexOfArray", new Object[0]);
      AppMethodBeat.o(122198);
    }
    return null;
  }
  
  private static c<String, Integer> agi(String paramString)
  {
    AppMethodBeat.i(122200);
    int i = paramString.lastIndexOf("@");
    if ((i <= 0) || (i >= paramString.length() - 1))
    {
      AppMethodBeat.o(122200);
      return null;
    }
    paramString = a.N(paramString.substring(i + 1), Integer.valueOf(i));
    AppMethodBeat.o(122200);
    return paramString;
  }
  
  private static c<String, String> gd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122199);
    c localc = agi(paramString1);
    if (localc == null)
    {
      AppMethodBeat.o(122199);
      return null;
    }
    paramString1 = a.N(paramString1.substring(paramString2.length(), ((Integer)localc.get(1)).intValue()), localc.get(0));
    AppMethodBeat.o(122199);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.e.b
 * JD-Core Version:    0.7.0.1
 */