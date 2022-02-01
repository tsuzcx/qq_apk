package com.tencent.mm.plugin.expt.hellhound.a.f.e;

import android.annotation.SuppressLint;
import android.support.v4.e.k;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anc;
import com.tencent.mm.protocal.protobuf.bgc;
import com.tencent.mm.protocal.protobuf.bgd;
import com.tencent.mm.protocal.protobuf.bxw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  private static List<k<String, String>> Xa(String paramString)
  {
    AppMethodBeat.i(122197);
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramString = paramString.split(",");
      int j = paramString.length;
      int i = 0;
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
      ad.m("HABBYGE-MALI.HellSessionParamUtil", "HellSessionParamUtil, _getFieldWithClass, crash: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(122197);
    }
    return null;
  }
  
  private static c<String, Integer> Xb(String paramString)
  {
    AppMethodBeat.i(122198);
    c localc = Xc(paramString);
    if (localc == null)
    {
      AppMethodBeat.o(122198);
      return null;
    }
    paramString = paramString.substring(paramString.indexOf("[") + 1, ((Integer)localc.get(1)).intValue());
    try
    {
      int i = Integer.parseInt((String)localc.get(0));
      paramString = a.L(paramString, Integer.valueOf(i));
      AppMethodBeat.o(122198);
      return paramString;
    }
    catch (NumberFormatException paramString)
    {
      ad.printErrStackTrace("HABBYGE-MALI.HellSessionParamUtil", paramString, "HellPageParamsCatcher, getClassNameAndIndexOfArray", new Object[0]);
      AppMethodBeat.o(122198);
    }
    return null;
  }
  
  private static c<String, Integer> Xc(String paramString)
  {
    AppMethodBeat.i(122200);
    int i = paramString.lastIndexOf("@");
    if ((i <= 0) || (i >= paramString.length() - 1))
    {
      AppMethodBeat.o(122200);
      return null;
    }
    paramString = a.L(paramString.substring(i + 1), Integer.valueOf(i));
    AppMethodBeat.o(122200);
    return paramString;
  }
  
  private static bgd a(Object paramObject, bxw parambxw)
  {
    AppMethodBeat.i(122196);
    Object localObject2 = Xa(parambxw.dvm);
    if (localObject2 == null)
    {
      AppMethodBeat.o(122196);
      return null;
    }
    for (;;)
    {
      try
      {
        Object localObject1 = Class.forName(parambxw.className);
        localObject2 = ((List)localObject2).iterator();
        Object localObject3;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (k)((Iterator)localObject2).next();
          if (localObject3 != null)
          {
            Object localObject4 = (String)((k)localObject3).first;
            localObject3 = (String)((k)localObject3).second;
            if ((localObject4 != null) && (!((String)localObject4).isEmpty()) && (localObject3 != null) && (!((String)localObject3).isEmpty()))
            {
              ad.i("HABBYGE-MALI.HellSessionParamUtil", "fieldName/fieldClassName: %s, %s", new Object[] { localObject4, localObject3 });
              localObject4 = ((Class)localObject1).getDeclaredField((String)localObject4);
              ((Field)localObject4).setAccessible(true);
              paramObject = ((Field)localObject4).get(paramObject);
              ad.i("HABBYGE-MALI.HellSessionParamUtil", "_doParse, object: %s", new Object[] { String.valueOf(paramObject) });
              int i;
              if (((String)localObject3).startsWith("["))
              {
                localObject3 = Xb((String)localObject3);
                if (localObject3 != null)
                {
                  i = ((Integer)((c)localObject3).get(1)).intValue();
                  paramObject = (Object[])paramObject;
                  if ((paramObject == null) || (paramObject.length <= 0) || (i >= paramObject.length))
                  {
                    ad.e("HABBYGE-MALI.HellSessionParamUtil", "array == null || array.length <= 0");
                    AppMethodBeat.o(122196);
                    return null;
                  }
                  paramObject = paramObject[i];
                  localObject1 = Class.forName((String)((com.tencent.mm.vending.j.b)localObject3).get(0));
                }
              }
              else if (((String)localObject3).startsWith("Ljava/util/List;"))
              {
                localObject3 = fD((String)localObject3, "Ljava/util/List;");
                if (localObject3 != null)
                {
                  paramObject = (List)paramObject;
                  try
                  {
                    i = Integer.parseInt((String)((c)localObject3).get(1));
                    ad.i("HABBYGE-MALI.HellSessionParamUtil", "_doParse, indexOfField: %d", new Object[] { Integer.valueOf(i) });
                    if ((paramObject == null) || (paramObject.isEmpty()) || (i >= paramObject.size()))
                    {
                      ad.e("HABBYGE-MALI.HellSessionParamUtil", "list.isEmpty");
                      AppMethodBeat.o(122196);
                      return null;
                    }
                  }
                  catch (NumberFormatException paramObject)
                  {
                    ad.printErrStackTrace("HABBYGE-MALI.HellSessionParamUtil", paramObject, "SessionParam, Ljava/util/List;, crash", new Object[0]);
                    AppMethodBeat.o(122196);
                    return null;
                  }
                  paramObject = paramObject.get(i);
                  localObject1 = Class.forName((String)((com.tencent.mm.vending.j.b)localObject3).get(0));
                }
              }
              else
              {
                int j;
                if (((String)localObject3).startsWith("Ljava/util/ArrayList;"))
                {
                  localObject3 = fD((String)localObject3, "Ljava/util/ArrayList;");
                  if (localObject3 != null)
                  {
                    paramObject = (ArrayList)paramObject;
                    try
                    {
                      i = Integer.parseInt((String)((c)localObject3).get(1));
                      if ((paramObject != null) && (!paramObject.isEmpty()))
                      {
                        j = paramObject.size();
                        if (i < j) {}
                      }
                      else
                      {
                        AppMethodBeat.o(122196);
                        return null;
                      }
                    }
                    catch (NumberFormatException paramObject)
                    {
                      ad.printErrStackTrace("HABBYGE-MALI.HellSessionParamUtil", paramObject, "SessionParam, Ljava/util/ArrayList;, crash", new Object[0]);
                      AppMethodBeat.o(122196);
                      return null;
                    }
                    paramObject = paramObject.get(i);
                    localObject1 = Class.forName((String)((com.tencent.mm.vending.j.b)localObject3).get(0));
                  }
                }
                else if (((String)localObject3).startsWith("Ljava/util/LinkedList;"))
                {
                  localObject3 = fD((String)localObject3, "Ljava/util/LinkedList;");
                  if (localObject3 != null)
                  {
                    paramObject = (LinkedList)paramObject;
                    try
                    {
                      i = Integer.parseInt((String)((c)localObject3).get(1));
                      if ((paramObject != null) && (!paramObject.isEmpty()))
                      {
                        j = paramObject.size();
                        if (i < j) {}
                      }
                      else
                      {
                        AppMethodBeat.o(122196);
                        return null;
                      }
                    }
                    catch (NumberFormatException paramObject)
                    {
                      ad.printErrStackTrace("HABBYGE-MALI.HellSessionParamUtil", paramObject, "_doParse, Ljava/util/LinkedList;, crash", new Object[0]);
                      AppMethodBeat.o(122196);
                      return null;
                    }
                    paramObject = paramObject.get(i);
                    localObject1 = Class.forName((String)((com.tencent.mm.vending.j.b)localObject3).get(0));
                  }
                }
                else
                {
                  boolean bool;
                  if (((String)localObject3).startsWith("Ljava/util/Map;"))
                  {
                    localObject3 = fD((String)localObject3, "Ljava/util/Map;");
                    if (localObject3 != null)
                    {
                      paramObject = (Map)paramObject;
                      if (paramObject != null)
                      {
                        bool = paramObject.isEmpty();
                        if (!bool) {}
                      }
                      else
                      {
                        AppMethodBeat.o(122196);
                        return null;
                      }
                      paramObject = paramObject.get(((c)localObject3).get(1));
                      if (paramObject == null)
                      {
                        AppMethodBeat.o(122196);
                        return null;
                      }
                      localObject1 = Class.forName((String)((com.tencent.mm.vending.j.b)localObject3).get(0));
                    }
                  }
                  else if (((String)localObject3).startsWith("Ljava/util/HashMap;"))
                  {
                    localObject3 = fD((String)localObject3, "Ljava/util/HashMap;");
                    if (localObject3 != null)
                    {
                      paramObject = (HashMap)paramObject;
                      if (paramObject != null)
                      {
                        bool = paramObject.isEmpty();
                        if (!bool) {}
                      }
                      else
                      {
                        AppMethodBeat.o(122196);
                        return null;
                      }
                      paramObject = paramObject.get(((c)localObject3).get(1));
                      if (paramObject == null)
                      {
                        AppMethodBeat.o(122196);
                        return null;
                      }
                      localObject1 = Class.forName((String)((com.tencent.mm.vending.j.b)localObject3).get(0));
                    }
                  }
                  else
                  {
                    localObject1 = Class.forName((String)localObject3);
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
            ad.e("HABBYGE-MALI.HellSessionParamUtil", "SessionParams, object == NULL !!");
            AppMethodBeat.o(122196);
            return null;
          }
          localObject3 = new bgd();
          localObject2 = String.valueOf(paramObject);
          localObject1 = localObject2;
          if ((paramObject instanceof Long)) {
            localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.ly(bt.getLong((String)localObject2, 0L));
          }
          ad.i("HABBYGE-MALI.HellSessionParamUtil", "SessionParams, value: %s", new Object[] { localObject1 });
          ((bgd)localObject3).value = ((String)localObject1);
          ((bgd)localObject3).dvm = parambxw.dvm;
          AppMethodBeat.o(122196);
          return localObject3;
        }
      }
      catch (Exception paramObject)
      {
        ad.m("HABBYGE-MALI.HellSessionParamUtil", "HellSessionParamUtil, _doParse, crash: %s", new Object[] { paramObject.getMessage() });
        AppMethodBeat.o(122196);
        return null;
      }
    }
  }
  
  private static void a(bgd parambgd, anb paramanb, String paramString)
  {
    AppMethodBeat.i(169358);
    int j = paramanb.Dod.size();
    int i = 0;
    while (i < j)
    {
      bgd localbgd = (bgd)paramanb.Dod.get(i);
      if ((localbgd.dvm != null) && (localbgd.dvm.equals(parambgd.dvm))) {
        break;
      }
      i += 1;
    }
    if (i < j)
    {
      ad.i("HABBYGE-MALI.HellSessionParamUtil", "catchPageParams, putParamIn, update: %s, %s, %s, %s", new Object[] { paramString, parambgd.jOx, parambgd.dvm, parambgd.value });
      paramanb.Dod.set(i, parambgd);
      AppMethodBeat.o(169358);
      return;
    }
    ad.i("HABBYGE-MALI.HellSessionParamUtil", "catchPageParams, putParamIn, add: %s, %s, %s, %s", new Object[] { paramString, parambgd.jOx, parambgd.dvm, parambgd.value });
    paramanb.Dod.add(parambgd);
    AppMethodBeat.o(169358);
  }
  
  static void a(Object paramObject, bxw parambxw, anc paramanc, boolean paramBoolean)
  {
    AppMethodBeat.i(169357);
    if ((paramObject == null) || (TextUtils.isEmpty(parambxw.className)) || (TextUtils.isEmpty(parambxw.dvm)))
    {
      AppMethodBeat.o(169357);
      return;
    }
    if ("0".equals(parambxw.action))
    {
      if (!paramBoolean) {
        AppMethodBeat.o(169357);
      }
    }
    else if (("2".equals(parambxw.action)) && (paramBoolean))
    {
      AppMethodBeat.o(169357);
      return;
    }
    String str1 = paramObject.getClass().getSimpleName();
    ad.i("HABBYGE-MALI.HellSessionParamUtil", "catchPageParams, %s, %s", new Object[] { str1, Long.valueOf(paramanc.Doj) });
    paramObject = a(paramObject, parambxw);
    if (paramObject == null)
    {
      AppMethodBeat.o(169357);
      return;
    }
    ad.i("HABBYGE-MALI.HellSessionParamUtil", "catchPageParams, paramItem: %s", new Object[] { paramObject.value });
    int i = paramanc.Dog.size() - 1;
    while (i >= 0)
    {
      parambxw = (anb)paramanc.Dog.get(i);
      String str2 = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(parambxw.name);
      if ((str2 != null) && (str2.equals(str1)))
      {
        a(paramObject, parambxw, str2);
        AppMethodBeat.o(169357);
        return;
      }
      i -= 1;
    }
    AppMethodBeat.o(169357);
  }
  
  @SuppressLint({"NewApi"})
  static void a(Object paramObject, bxw parambxw, bgc parambgc, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(122195);
    if ((paramObject == null) || (TextUtils.isEmpty(parambxw.className)) || (TextUtils.isEmpty(parambxw.dvm)))
    {
      AppMethodBeat.o(122195);
      return;
    }
    if ("0".equals(parambxw.action))
    {
      if (!paramBoolean2) {
        AppMethodBeat.o(122195);
      }
    }
    else if (("2".equals(parambxw.action)) && (paramBoolean2))
    {
      AppMethodBeat.o(122195);
      return;
    }
    ad.i("HABBYGE-MALI.HellSessionParamUtil", "catchPageParams, pageParamConfig: %s, %s, %s, %s, %b, %b", new Object[] { paramObject.getClass().getSimpleName(), parambxw.className, parambxw.dvm, parambxw.action, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    paramObject = a(paramObject, parambxw);
    if (paramObject == null)
    {
      AppMethodBeat.o(122195);
      return;
    }
    if (paramBoolean1)
    {
      parambgc.DDQ.add(paramObject);
      AppMethodBeat.o(122195);
      return;
    }
    parambgc.Dod.add(paramObject);
    AppMethodBeat.o(122195);
  }
  
  private static c<String, String> fD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122199);
    c localc = Xc(paramString1);
    if (localc == null)
    {
      AppMethodBeat.o(122199);
      return null;
    }
    paramString1 = a.L(paramString1.substring(paramString2.length(), ((Integer)localc.get(1)).intValue()), localc.get(0));
    AppMethodBeat.o(122199);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.e.b
 * JD-Core Version:    0.7.0.1
 */