package com.tencent.mm.plugin.expt.hellhound.a.f.e;

import android.annotation.SuppressLint;
import android.support.v4.e.k;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.f.l;
import com.tencent.mm.protocal.protobuf.bga;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cbn;
import com.tencent.mm.protocal.protobuf.cft;
import com.tencent.mm.protocal.protobuf.cyk;
import com.tencent.mm.protocal.protobuf.erd;
import com.tencent.mm.protocal.protobuf.pd;
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
  private static cbn a(Object paramObject, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(220577);
    paramString2 = aqR(paramString2);
    if (paramString2 == null)
    {
      AppMethodBeat.o(220577);
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
                localObject1 = aqS((String)localObject1);
                if (localObject1 != null)
                {
                  i = ((Integer)((c)localObject1).get(1)).intValue();
                  paramObject = (Object[])paramObject;
                  if ((paramObject == null) || (paramObject.length <= 0) || (i >= paramObject.length))
                  {
                    Log.e("HABBYGE-MALI.HellSessionParamUtil", "array == null || array.length <= 0");
                    AppMethodBeat.o(220577);
                    return null;
                  }
                  paramObject = paramObject[i];
                  paramString1 = Class.forName((String)((com.tencent.mm.vending.j.b)localObject1).get(0));
                }
              }
              else if (((String)localObject1).startsWith("Ljava/util/List;"))
              {
                localObject1 = gx((String)localObject1, "Ljava/util/List;");
                if (localObject1 != null)
                {
                  paramObject = (List)paramObject;
                  try
                  {
                    i = Integer.parseInt((String)((c)localObject1).get(1));
                    if ((paramObject == null) || (paramObject.isEmpty()) || (i >= paramObject.size()))
                    {
                      Log.e("HABBYGE-MALI.HellSessionParamUtil", "list.isEmpty");
                      AppMethodBeat.o(220577);
                      return null;
                    }
                  }
                  catch (NumberFormatException paramObject)
                  {
                    Log.printErrStackTrace("HABBYGE-MALI.HellSessionParamUtil", paramObject, "SessionParam, Ljava/util/List;, crash", new Object[0]);
                    AppMethodBeat.o(220577);
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
                  localObject1 = gx((String)localObject1, "Ljava/util/ArrayList;");
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
                        AppMethodBeat.o(220577);
                        return null;
                      }
                    }
                    catch (NumberFormatException paramObject)
                    {
                      Log.printErrStackTrace("HABBYGE-MALI.HellSessionParamUtil", paramObject, "SessionParam, Ljava/util/ArrayList;, crash", new Object[0]);
                      AppMethodBeat.o(220577);
                      return null;
                    }
                    paramObject = paramObject.get(i);
                    paramString1 = Class.forName((String)((com.tencent.mm.vending.j.b)localObject1).get(0));
                  }
                }
                else if (((String)localObject1).startsWith("Ljava/util/LinkedList;"))
                {
                  localObject1 = gx((String)localObject1, "Ljava/util/LinkedList;");
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
                        AppMethodBeat.o(220577);
                        return null;
                      }
                    }
                    catch (NumberFormatException paramObject)
                    {
                      Log.printErrStackTrace("HABBYGE-MALI.HellSessionParamUtil", paramObject, "_doParse, Ljava/util/LinkedList;, crash", new Object[0]);
                      AppMethodBeat.o(220577);
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
                    localObject1 = gx((String)localObject1, "Ljava/util/Map;");
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
                        AppMethodBeat.o(220577);
                        return null;
                      }
                      paramObject = paramObject.get(((c)localObject1).get(1));
                      if (paramObject == null)
                      {
                        AppMethodBeat.o(220577);
                        return null;
                      }
                      paramString1 = Class.forName((String)((com.tencent.mm.vending.j.b)localObject1).get(0));
                    }
                  }
                  else if (((String)localObject1).startsWith("Ljava/util/HashMap;"))
                  {
                    localObject1 = gx((String)localObject1, "Ljava/util/HashMap;");
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
                        AppMethodBeat.o(220577);
                        return null;
                      }
                      paramObject = paramObject.get(((c)localObject1).get(1));
                      if (paramObject == null)
                      {
                        AppMethodBeat.o(220577);
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
            AppMethodBeat.o(220577);
            return null;
          }
          localObject1 = new cbn();
          paramString2 = String.valueOf(paramObject);
          paramString1 = paramString2;
          if ((paramObject instanceof Long)) {
            paramString1 = com.tencent.mm.plugin.expt.hellhound.core.b.zs(Util.getLong(paramString2, 0L));
          }
          Log.i("HABBYGE-MALI.HellSessionParamUtil", "SessionParams, value: %s, %s", new Object[] { paramString1, paramString3 });
          ((cbn)localObject1).value = paramString1;
          ((cbn)localObject1).dataPath = paramString3;
          AppMethodBeat.o(220577);
          return localObject1;
        }
      }
      catch (Exception paramObject)
      {
        AppMethodBeat.o(220577);
        return null;
      }
    }
  }
  
  private static void a(cbn paramcbn, bga parambga)
  {
    AppMethodBeat.i(220575);
    int j = parambga.LPG.size();
    int i = 0;
    while (i < j)
    {
      cbn localcbn = (cbn)parambga.LPG.get(i);
      if ((localcbn.dataPath != null) && (localcbn.dataPath.equals(paramcbn.dataPath))) {
        break;
      }
      i += 1;
    }
    if (i < j)
    {
      parambga.LPG.set(i, paramcbn);
      AppMethodBeat.o(220575);
      return;
    }
    parambga.LPG.add(paramcbn);
    AppMethodBeat.o(220575);
  }
  
  @SuppressLint({"NewApi"})
  static void a(Object paramObject, cyk paramcyk, long paramLong, erd paramerd)
  {
    AppMethodBeat.i(220576);
    if ((paramObject == null) || (TextUtils.isEmpty(paramcyk.className)) || (TextUtils.isEmpty(paramcyk.dataPath)) || (paramerd == null))
    {
      AppMethodBeat.o(220576);
      return;
    }
    if (paramcyk.MDk == null) {}
    for (Object localObject = paramcyk.dataPath;; localObject = paramcyk.MDk.iFF)
    {
      cbn localcbn = a(paramObject, paramcyk.MDj, (String)localObject, paramcyk.dataPath);
      localObject = localcbn;
      if (localcbn != null) {
        break;
      }
      l.Bt(129L);
      paramObject = a(paramObject, paramcyk.className, paramcyk.dataPath, paramcyk.dataPath);
      localObject = paramObject;
      if (paramObject != null) {
        break;
      }
      l.Bt(133L);
      AppMethodBeat.o(220576);
      return;
    }
    l.Bt(132L);
    paramObject = paramerd.KVY.iterator();
    while (paramObject.hasNext())
    {
      paramcyk = (pd)paramObject.next();
      if (paramLong == paramcyk.KVX) {
        paramcyk.KVY.add(localObject);
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramObject = new pd();
        paramObject.KVX = paramLong;
        paramObject.KVY.add(localObject);
        paramerd.KVY.add(paramObject);
        Log.i("HABBYGE-MALI.HellSessionParamUtil", "catchParamsWhenViewOp, add pathId=%s, dataPath=%s, value=%s", new Object[] { Long.valueOf(paramLong), ((cbn)localObject).dataPath, ((cbn)localObject).value });
      }
      AppMethodBeat.o(220576);
      return;
    }
  }
  
  static void a(Object paramObject, cyk paramcyk, bgb parambgb, boolean paramBoolean)
  {
    AppMethodBeat.i(169357);
    if ((paramObject == null) || (TextUtils.isEmpty(paramcyk.className)) || (TextUtils.isEmpty(paramcyk.dataPath)))
    {
      AppMethodBeat.o(169357);
      return;
    }
    if ("0".equals(paramcyk.action))
    {
      if (!paramBoolean) {
        AppMethodBeat.o(169357);
      }
    }
    else if (("2".equals(paramcyk.action)) && (paramBoolean))
    {
      AppMethodBeat.o(169357);
      return;
    }
    String str = paramObject.getClass().getSimpleName();
    if (paramcyk.MDk == null) {}
    for (Object localObject = paramcyk.dataPath;; localObject = paramcyk.MDk.iFF)
    {
      cbn localcbn = a(paramObject, paramcyk.MDj, (String)localObject, paramcyk.dataPath);
      localObject = localcbn;
      if (localcbn != null) {
        break;
      }
      if ((paramcyk.MDk != null) && (!TextUtils.isEmpty(paramcyk.MDk.iFF))) {
        l.Bt(158L);
      }
      paramObject = a(paramObject, paramcyk.className, paramcyk.dataPath, paramcyk.dataPath);
      localObject = paramObject;
      if (paramObject != null) {
        break;
      }
      AppMethodBeat.o(169357);
      return;
    }
    l.Bt(135L);
    int i = parambgb.LPK.size() - 1;
    while (i >= 0)
    {
      paramObject = (bga)parambgb.LPK.get(i);
      paramcyk = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(paramObject.name);
      if ((paramcyk != null) && (paramcyk.equals(str)))
      {
        a((cbn)localObject, paramObject);
        AppMethodBeat.o(169357);
        return;
      }
      i -= 1;
    }
    AppMethodBeat.o(169357);
  }
  
  @SuppressLint({"NewApi"})
  static void a(Object paramObject, cyk paramcyk, cbm paramcbm, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(122195);
    if ((paramObject == null) || (TextUtils.isEmpty(paramcyk.className)) || (TextUtils.isEmpty(paramcyk.dataPath)))
    {
      AppMethodBeat.o(122195);
      return;
    }
    if ("0".equals(paramcyk.action))
    {
      if (!paramBoolean2) {
        AppMethodBeat.o(122195);
      }
    }
    else if (("2".equals(paramcyk.action)) && (paramBoolean2))
    {
      AppMethodBeat.o(122195);
      return;
    }
    if (paramcyk.MDk == null) {}
    for (Object localObject = paramcyk.dataPath;; localObject = paramcyk.MDk.iFF)
    {
      cbn localcbn = a(paramObject, paramcyk.MDj, (String)localObject, paramcyk.dataPath);
      localObject = localcbn;
      if (localcbn != null) {
        break;
      }
      if ((!paramBoolean1) && (paramcyk.MDk != null) && (!TextUtils.isEmpty(paramcyk.MDk.iFF))) {
        l.Bt(158L);
      }
      paramObject = a(paramObject, paramcyk.className, paramcyk.dataPath, paramcyk.dataPath);
      localObject = paramObject;
      if (paramObject != null) {
        break;
      }
      AppMethodBeat.o(122195);
      return;
    }
    if (paramBoolean1)
    {
      paramcbm.Mho.add(localObject);
      AppMethodBeat.o(122195);
      return;
    }
    paramcbm.LPG.add(localObject);
    l.Bt(135L);
    AppMethodBeat.o(122195);
  }
  
  private static List<k<String, String>> aqR(String paramString)
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
  
  private static c<String, Integer> aqS(String paramString)
  {
    AppMethodBeat.i(122198);
    c localc = aqT(paramString);
    if (localc == null)
    {
      AppMethodBeat.o(122198);
      return null;
    }
    paramString = paramString.substring(paramString.indexOf("[") + 1, ((Integer)localc.get(1)).intValue());
    try
    {
      int i = Integer.parseInt((String)localc.get(0));
      paramString = a.Q(paramString, Integer.valueOf(i));
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
  
  private static c<String, Integer> aqT(String paramString)
  {
    AppMethodBeat.i(122200);
    int i = paramString.lastIndexOf("@");
    if ((i <= 0) || (i >= paramString.length() - 1))
    {
      AppMethodBeat.o(122200);
      return null;
    }
    paramString = a.Q(paramString.substring(i + 1), Integer.valueOf(i));
    AppMethodBeat.o(122200);
    return paramString;
  }
  
  private static c<String, String> gx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122199);
    c localc = aqT(paramString1);
    if (localc == null)
    {
      AppMethodBeat.o(122199);
      return null;
    }
    paramString1 = a.Q(paramString1.substring(paramString2.length(), ((Integer)localc.get(1)).intValue()), localc.get(0));
    AppMethodBeat.o(122199);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.e.b
 * JD-Core Version:    0.7.0.1
 */