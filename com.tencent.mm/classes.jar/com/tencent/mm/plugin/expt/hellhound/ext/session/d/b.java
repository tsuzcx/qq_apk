package com.tencent.mm.plugin.expt.hellhound.ext.session.d;

import android.text.TextUtils;
import androidx.core.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.ext.session.e.l;
import com.tencent.mm.protocal.protobuf.cav;
import com.tencent.mm.protocal.protobuf.caw;
import com.tencent.mm.protocal.protobuf.czu;
import com.tencent.mm.protocal.protobuf.czv;
import com.tencent.mm.protocal.protobuf.dfj;
import com.tencent.mm.protocal.protobuf.eag;
import com.tencent.mm.protocal.protobuf.fxz;
import com.tencent.mm.protocal.protobuf.qi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
  private static void a(czv paramczv, cav paramcav)
  {
    AppMethodBeat.i(300199);
    int j = paramcav.aajQ.size();
    int i = 0;
    while (i < j)
    {
      czv localczv = (czv)paramcav.aajQ.get(i);
      if ((localczv.dataPath != null) && (localczv.dataPath.equals(paramczv.dataPath))) {
        break;
      }
      i += 1;
    }
    if (i < j)
    {
      paramcav.aajQ.set(i, paramczv);
      AppMethodBeat.o(300199);
      return;
    }
    paramcav.aajQ.add(paramczv);
    AppMethodBeat.o(300199);
  }
  
  static void a(Object paramObject, eag parameag, long paramLong, fxz paramfxz)
  {
    AppMethodBeat.i(300201);
    if ((paramObject == null) || (TextUtils.isEmpty(parameag.className)) || (TextUtils.isEmpty(parameag.dataPath)) || (paramfxz == null))
    {
      AppMethodBeat.o(300201);
      return;
    }
    if (parameag.abfp == null) {}
    for (Object localObject = parameag.dataPath;; localObject = parameag.abfp.onf)
    {
      czv localczv = b(paramObject, parameag.abfo, (String)localObject, parameag.dataPath);
      localObject = localczv;
      if (localczv != null) {
        break;
      }
      l.jX(129L);
      paramObject = b(paramObject, parameag.className, parameag.dataPath, parameag.dataPath);
      localObject = paramObject;
      if (paramObject != null) {
        break;
      }
      l.jX(133L);
      AppMethodBeat.o(300201);
      return;
    }
    l.jX(132L);
    paramObject = paramfxz.YVe.iterator();
    while (paramObject.hasNext())
    {
      parameag = (qi)paramObject.next();
      if (paramLong == parameag.YVd) {
        parameag.YVe.add(localObject);
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramObject = new qi();
        paramObject.YVd = paramLong;
        paramObject.YVe.add(localObject);
        paramfxz.YVe.add(paramObject);
        Log.i("HABBYGE-MALI.HellSessionParamUtil", "catchParamsWhenViewOp, add pathId=%s, dataPath=%s, value=%s", new Object[] { Long.valueOf(paramLong), ((czv)localObject).dataPath, ((czv)localObject).value });
      }
      AppMethodBeat.o(300201);
      return;
    }
  }
  
  static void a(Object paramObject, eag parameag, caw paramcaw, boolean paramBoolean)
  {
    AppMethodBeat.i(169357);
    if ((paramObject == null) || (TextUtils.isEmpty(parameag.className)) || (TextUtils.isEmpty(parameag.dataPath)))
    {
      AppMethodBeat.o(169357);
      return;
    }
    if ("0".equals(parameag.action))
    {
      if (!paramBoolean) {
        AppMethodBeat.o(169357);
      }
    }
    else if (("2".equals(parameag.action)) && (paramBoolean))
    {
      AppMethodBeat.o(169357);
      return;
    }
    String str = paramObject.getClass().getSimpleName();
    if (parameag.abfp == null) {}
    for (Object localObject = parameag.dataPath;; localObject = parameag.abfp.onf)
    {
      czv localczv = b(paramObject, parameag.abfo, (String)localObject, parameag.dataPath);
      localObject = localczv;
      if (localczv != null) {
        break;
      }
      if ((parameag.abfp != null) && (!TextUtils.isEmpty(parameag.abfp.onf))) {
        l.jX(158L);
      }
      paramObject = b(paramObject, parameag.className, parameag.dataPath, parameag.dataPath);
      localObject = paramObject;
      if (paramObject != null) {
        break;
      }
      AppMethodBeat.o(169357);
      return;
    }
    l.jX(135L);
    int i = paramcaw.aajU.size() - 1;
    while (i >= 0)
    {
      paramObject = (cav)paramcaw.aajU.get(i);
      parameag = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(paramObject.name);
      if ((parameag != null) && (parameag.equals(str)))
      {
        a((czv)localObject, paramObject);
        AppMethodBeat.o(169357);
        return;
      }
      i -= 1;
    }
    AppMethodBeat.o(169357);
  }
  
  static void a(Object paramObject, eag parameag, czu paramczu, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(122195);
    if ((paramObject == null) || (TextUtils.isEmpty(parameag.className)) || (TextUtils.isEmpty(parameag.dataPath)))
    {
      AppMethodBeat.o(122195);
      return;
    }
    if ("0".equals(parameag.action))
    {
      if (!paramBoolean2) {
        AppMethodBeat.o(122195);
      }
    }
    else if (("2".equals(parameag.action)) && (paramBoolean2))
    {
      AppMethodBeat.o(122195);
      return;
    }
    if (parameag.abfp == null) {}
    for (Object localObject = parameag.dataPath;; localObject = parameag.abfp.onf)
    {
      czv localczv = b(paramObject, parameag.abfo, (String)localObject, parameag.dataPath);
      localObject = localczv;
      if (localczv != null) {
        break;
      }
      if ((!paramBoolean1) && (parameag.abfp != null) && (!TextUtils.isEmpty(parameag.abfp.onf))) {
        l.jX(158L);
      }
      paramObject = b(paramObject, parameag.className, parameag.dataPath, parameag.dataPath);
      localObject = paramObject;
      if (paramObject != null) {
        break;
      }
      AppMethodBeat.o(122195);
      return;
    }
    if (paramBoolean1)
    {
      paramczu.aaFk.add(localObject);
      AppMethodBeat.o(122195);
      return;
    }
    paramczu.aajQ.add(localObject);
    l.jX(135L);
    AppMethodBeat.o(122195);
  }
  
  private static List<d<String, String>> asX(String paramString)
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
        localArrayList.add(new d(arrayOfString[0], arrayOfString[1]));
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
  
  private static c<String, Integer> asY(String paramString)
  {
    AppMethodBeat.i(122198);
    c localc = asZ(paramString);
    if (localc == null)
    {
      AppMethodBeat.o(122198);
      return null;
    }
    paramString = paramString.substring(paramString.indexOf("[") + 1, ((Integer)localc.get(1)).intValue());
    try
    {
      int i = Integer.parseInt((String)localc.get(0));
      paramString = a.U(paramString, Integer.valueOf(i));
      AppMethodBeat.o(122198);
      return paramString;
    }
    catch (NumberFormatException paramString)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellSessionParamUtil", paramString, "HellPageParamsCatcher, getClassNameAndIndexOfArray", new Object[0]);
      AppMethodBeat.o(122198);
    }
    return null;
  }
  
  private static c<String, Integer> asZ(String paramString)
  {
    AppMethodBeat.i(122200);
    int i = paramString.lastIndexOf("@");
    if ((i <= 0) || (i >= paramString.length() - 1))
    {
      AppMethodBeat.o(122200);
      return null;
    }
    paramString = a.U(paramString.substring(i + 1), Integer.valueOf(i));
    AppMethodBeat.o(122200);
    return paramString;
  }
  
  private static czv b(Object paramObject, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(300210);
    paramString2 = asX(paramString2);
    if (paramString2 == null)
    {
      AppMethodBeat.o(300210);
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
          localObject1 = (d)paramString2.next();
          if (localObject1 != null)
          {
            Object localObject2 = (String)((d)localObject1).bsC;
            localObject1 = (String)((d)localObject1).bsD;
            if ((localObject2 != null) && (!((String)localObject2).isEmpty()) && (localObject1 != null) && (!((String)localObject1).isEmpty()))
            {
              localObject2 = paramString1.getDeclaredField((String)localObject2);
              ((Field)localObject2).setAccessible(true);
              paramObject = ((Field)localObject2).get(paramObject);
              int i;
              if (((String)localObject1).startsWith("["))
              {
                localObject1 = asY((String)localObject1);
                if (localObject1 != null)
                {
                  i = ((Integer)((c)localObject1).get(1)).intValue();
                  paramObject = (Object[])paramObject;
                  if ((paramObject == null) || (paramObject.length <= 0) || (i >= paramObject.length))
                  {
                    Log.e("HABBYGE-MALI.HellSessionParamUtil", "array == null || array.length <= 0");
                    AppMethodBeat.o(300210);
                    return null;
                  }
                  paramObject = paramObject[i];
                  paramString1 = Class.forName((String)((com.tencent.mm.vending.j.b)localObject1).get(0));
                }
              }
              else if (((String)localObject1).startsWith("Ljava/util/List;"))
              {
                localObject1 = ht((String)localObject1, "Ljava/util/List;");
                if (localObject1 != null)
                {
                  paramObject = (List)paramObject;
                  try
                  {
                    i = Integer.parseInt((String)((c)localObject1).get(1));
                    if ((paramObject == null) || (paramObject.isEmpty()) || (i >= paramObject.size()))
                    {
                      Log.e("HABBYGE-MALI.HellSessionParamUtil", "list.isEmpty");
                      AppMethodBeat.o(300210);
                      return null;
                    }
                  }
                  catch (NumberFormatException paramObject)
                  {
                    Log.printErrStackTrace("HABBYGE-MALI.HellSessionParamUtil", paramObject, "SessionParam, Ljava/util/List;, crash", new Object[0]);
                    AppMethodBeat.o(300210);
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
                  localObject1 = ht((String)localObject1, "Ljava/util/ArrayList;");
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
                        AppMethodBeat.o(300210);
                        return null;
                      }
                    }
                    catch (NumberFormatException paramObject)
                    {
                      Log.printErrStackTrace("HABBYGE-MALI.HellSessionParamUtil", paramObject, "SessionParam, Ljava/util/ArrayList;, crash", new Object[0]);
                      AppMethodBeat.o(300210);
                      return null;
                    }
                    paramObject = paramObject.get(i);
                    paramString1 = Class.forName((String)((com.tencent.mm.vending.j.b)localObject1).get(0));
                  }
                }
                else if (((String)localObject1).startsWith("Ljava/util/LinkedList;"))
                {
                  localObject1 = ht((String)localObject1, "Ljava/util/LinkedList;");
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
                        AppMethodBeat.o(300210);
                        return null;
                      }
                    }
                    catch (NumberFormatException paramObject)
                    {
                      Log.printErrStackTrace("HABBYGE-MALI.HellSessionParamUtil", paramObject, "_doParse, Ljava/util/LinkedList;, crash", new Object[0]);
                      AppMethodBeat.o(300210);
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
                    localObject1 = ht((String)localObject1, "Ljava/util/Map;");
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
                        AppMethodBeat.o(300210);
                        return null;
                      }
                      paramObject = paramObject.get(((c)localObject1).get(1));
                      if (paramObject == null)
                      {
                        AppMethodBeat.o(300210);
                        return null;
                      }
                      paramString1 = Class.forName((String)((com.tencent.mm.vending.j.b)localObject1).get(0));
                    }
                  }
                  else if (((String)localObject1).startsWith("Ljava/util/HashMap;"))
                  {
                    localObject1 = ht((String)localObject1, "Ljava/util/HashMap;");
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
                        AppMethodBeat.o(300210);
                        return null;
                      }
                      paramObject = paramObject.get(((c)localObject1).get(1));
                      if (paramObject == null)
                      {
                        AppMethodBeat.o(300210);
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
            Log.e("HABBYGE-MALI.HellSessionParamUtil", "SessionParams, object == NULL !!");
            AppMethodBeat.o(300210);
            return null;
          }
          localObject1 = new czv();
          paramString2 = String.valueOf(paramObject);
          paramString1 = paramString2;
          if ((paramObject instanceof Long)) {
            paramString1 = com.tencent.mm.plugin.expt.hellhound.core.b.hF(Util.getLong(paramString2, 0L));
          }
          Log.i("HABBYGE-MALI.HellSessionParamUtil", "SessionParams, value: %s, %s", new Object[] { paramString1, paramString3 });
          ((czv)localObject1).value = paramString1;
          ((czv)localObject1).dataPath = paramString3;
          AppMethodBeat.o(300210);
          return localObject1;
        }
      }
      catch (Exception paramObject)
      {
        AppMethodBeat.o(300210);
        return null;
      }
    }
  }
  
  private static c<String, String> ht(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122199);
    c localc = asZ(paramString1);
    if (localc == null)
    {
      AppMethodBeat.o(122199);
      return null;
    }
    paramString1 = a.U(paramString1.substring(paramString2.length(), ((Integer)localc.get(1)).intValue()), (String)localc.get(0));
    AppMethodBeat.o(122199);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.d.b
 * JD-Core Version:    0.7.0.1
 */