package com.tencent.mm.plugin.expt.hellhound.a.f.e;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.core.f.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.f.l;
import com.tencent.mm.protocal.protobuf.bnb;
import com.tencent.mm.protocal.protobuf.bnc;
import com.tencent.mm.protocal.protobuf.cjp;
import com.tencent.mm.protocal.protobuf.cjq;
import com.tencent.mm.protocal.protobuf.cop;
import com.tencent.mm.protocal.protobuf.dhw;
import com.tencent.mm.protocal.protobuf.fbo;
import com.tencent.mm.protocal.protobuf.oz;
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
  private static cjq a(Object paramObject, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(250771);
    paramString2 = ayS(paramString2);
    if (paramString2 == null)
    {
      AppMethodBeat.o(250771);
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
          localObject1 = (e)paramString2.next();
          if (localObject1 != null)
          {
            Object localObject2 = (String)((e)localObject1).Mx;
            localObject1 = (String)((e)localObject1).My;
            if ((localObject2 != null) && (!((String)localObject2).isEmpty()) && (localObject1 != null) && (!((String)localObject1).isEmpty()))
            {
              localObject2 = paramString1.getDeclaredField((String)localObject2);
              ((Field)localObject2).setAccessible(true);
              paramObject = ((Field)localObject2).get(paramObject);
              int i;
              if (((String)localObject1).startsWith("["))
              {
                localObject1 = ayT((String)localObject1);
                if (localObject1 != null)
                {
                  i = ((Integer)((c)localObject1).get(1)).intValue();
                  paramObject = (Object[])paramObject;
                  if ((paramObject == null) || (paramObject.length <= 0) || (i >= paramObject.length))
                  {
                    Log.e("HABBYGE-MALI.HellSessionParamUtil", "array == null || array.length <= 0");
                    AppMethodBeat.o(250771);
                    return null;
                  }
                  paramObject = paramObject[i];
                  paramString1 = Class.forName((String)((com.tencent.mm.vending.j.b)localObject1).get(0));
                }
              }
              else if (((String)localObject1).startsWith("Ljava/util/List;"))
              {
                localObject1 = gL((String)localObject1, "Ljava/util/List;");
                if (localObject1 != null)
                {
                  paramObject = (List)paramObject;
                  try
                  {
                    i = Integer.parseInt((String)((c)localObject1).get(1));
                    if ((paramObject == null) || (paramObject.isEmpty()) || (i >= paramObject.size()))
                    {
                      Log.e("HABBYGE-MALI.HellSessionParamUtil", "list.isEmpty");
                      AppMethodBeat.o(250771);
                      return null;
                    }
                  }
                  catch (NumberFormatException paramObject)
                  {
                    Log.printErrStackTrace("HABBYGE-MALI.HellSessionParamUtil", paramObject, "SessionParam, Ljava/util/List;, crash", new Object[0]);
                    AppMethodBeat.o(250771);
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
                  localObject1 = gL((String)localObject1, "Ljava/util/ArrayList;");
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
                        AppMethodBeat.o(250771);
                        return null;
                      }
                    }
                    catch (NumberFormatException paramObject)
                    {
                      Log.printErrStackTrace("HABBYGE-MALI.HellSessionParamUtil", paramObject, "SessionParam, Ljava/util/ArrayList;, crash", new Object[0]);
                      AppMethodBeat.o(250771);
                      return null;
                    }
                    paramObject = paramObject.get(i);
                    paramString1 = Class.forName((String)((com.tencent.mm.vending.j.b)localObject1).get(0));
                  }
                }
                else if (((String)localObject1).startsWith("Ljava/util/LinkedList;"))
                {
                  localObject1 = gL((String)localObject1, "Ljava/util/LinkedList;");
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
                        AppMethodBeat.o(250771);
                        return null;
                      }
                    }
                    catch (NumberFormatException paramObject)
                    {
                      Log.printErrStackTrace("HABBYGE-MALI.HellSessionParamUtil", paramObject, "_doParse, Ljava/util/LinkedList;, crash", new Object[0]);
                      AppMethodBeat.o(250771);
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
                    localObject1 = gL((String)localObject1, "Ljava/util/Map;");
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
                        AppMethodBeat.o(250771);
                        return null;
                      }
                      paramObject = paramObject.get(((c)localObject1).get(1));
                      if (paramObject == null)
                      {
                        AppMethodBeat.o(250771);
                        return null;
                      }
                      paramString1 = Class.forName((String)((com.tencent.mm.vending.j.b)localObject1).get(0));
                    }
                  }
                  else if (((String)localObject1).startsWith("Ljava/util/HashMap;"))
                  {
                    localObject1 = gL((String)localObject1, "Ljava/util/HashMap;");
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
                        AppMethodBeat.o(250771);
                        return null;
                      }
                      paramObject = paramObject.get(((c)localObject1).get(1));
                      if (paramObject == null)
                      {
                        AppMethodBeat.o(250771);
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
            AppMethodBeat.o(250771);
            return null;
          }
          localObject1 = new cjq();
          paramString2 = String.valueOf(paramObject);
          paramString1 = paramString2;
          if ((paramObject instanceof Long)) {
            paramString1 = com.tencent.mm.plugin.expt.hellhound.core.b.Fw(Util.getLong(paramString2, 0L));
          }
          Log.i("HABBYGE-MALI.HellSessionParamUtil", "SessionParams, value: %s, %s", new Object[] { paramString1, paramString3 });
          ((cjq)localObject1).value = paramString1;
          ((cjq)localObject1).dataPath = paramString3;
          AppMethodBeat.o(250771);
          return localObject1;
        }
      }
      catch (Exception paramObject)
      {
        AppMethodBeat.o(250771);
        return null;
      }
    }
  }
  
  private static void a(cjq paramcjq, bnb parambnb)
  {
    AppMethodBeat.i(250765);
    int j = parambnb.SXU.size();
    int i = 0;
    while (i < j)
    {
      cjq localcjq = (cjq)parambnb.SXU.get(i);
      if ((localcjq.dataPath != null) && (localcjq.dataPath.equals(paramcjq.dataPath))) {
        break;
      }
      i += 1;
    }
    if (i < j)
    {
      parambnb.SXU.set(i, paramcjq);
      AppMethodBeat.o(250765);
      return;
    }
    parambnb.SXU.add(paramcjq);
    AppMethodBeat.o(250765);
  }
  
  @SuppressLint({"NewApi"})
  static void a(Object paramObject, dhw paramdhw, long paramLong, fbo paramfbo)
  {
    AppMethodBeat.i(250766);
    if ((paramObject == null) || (TextUtils.isEmpty(paramdhw.className)) || (TextUtils.isEmpty(paramdhw.dataPath)) || (paramfbo == null))
    {
      AppMethodBeat.o(250766);
      return;
    }
    if (paramdhw.TOT == null) {}
    for (Object localObject = paramdhw.dataPath;; localObject = paramdhw.TOT.lvH)
    {
      cjq localcjq = a(paramObject, paramdhw.TOS, (String)localObject, paramdhw.dataPath);
      localObject = localcjq;
      if (localcjq != null) {
        break;
      }
      l.HG(129L);
      paramObject = a(paramObject, paramdhw.className, paramdhw.dataPath, paramdhw.dataPath);
      localObject = paramObject;
      if (paramObject != null) {
        break;
      }
      l.HG(133L);
      AppMethodBeat.o(250766);
      return;
    }
    l.HG(132L);
    paramObject = paramfbo.RXm.iterator();
    while (paramObject.hasNext())
    {
      paramdhw = (oz)paramObject.next();
      if (paramLong == paramdhw.RXl) {
        paramdhw.RXm.add(localObject);
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramObject = new oz();
        paramObject.RXl = paramLong;
        paramObject.RXm.add(localObject);
        paramfbo.RXm.add(paramObject);
        Log.i("HABBYGE-MALI.HellSessionParamUtil", "catchParamsWhenViewOp, add pathId=%s, dataPath=%s, value=%s", new Object[] { Long.valueOf(paramLong), ((cjq)localObject).dataPath, ((cjq)localObject).value });
      }
      AppMethodBeat.o(250766);
      return;
    }
  }
  
  static void a(Object paramObject, dhw paramdhw, bnc parambnc, boolean paramBoolean)
  {
    AppMethodBeat.i(169357);
    if ((paramObject == null) || (TextUtils.isEmpty(paramdhw.className)) || (TextUtils.isEmpty(paramdhw.dataPath)))
    {
      AppMethodBeat.o(169357);
      return;
    }
    if ("0".equals(paramdhw.action))
    {
      if (!paramBoolean) {
        AppMethodBeat.o(169357);
      }
    }
    else if (("2".equals(paramdhw.action)) && (paramBoolean))
    {
      AppMethodBeat.o(169357);
      return;
    }
    String str = paramObject.getClass().getSimpleName();
    if (paramdhw.TOT == null) {}
    for (Object localObject = paramdhw.dataPath;; localObject = paramdhw.TOT.lvH)
    {
      cjq localcjq = a(paramObject, paramdhw.TOS, (String)localObject, paramdhw.dataPath);
      localObject = localcjq;
      if (localcjq != null) {
        break;
      }
      if ((paramdhw.TOT != null) && (!TextUtils.isEmpty(paramdhw.TOT.lvH))) {
        l.HG(158L);
      }
      paramObject = a(paramObject, paramdhw.className, paramdhw.dataPath, paramdhw.dataPath);
      localObject = paramObject;
      if (paramObject != null) {
        break;
      }
      AppMethodBeat.o(169357);
      return;
    }
    l.HG(135L);
    int i = parambnc.SXY.size() - 1;
    while (i >= 0)
    {
      paramObject = (bnb)parambnc.SXY.get(i);
      paramdhw = com.tencent.mm.plugin.expt.hellhound.core.b.awD(paramObject.name);
      if ((paramdhw != null) && (paramdhw.equals(str)))
      {
        a((cjq)localObject, paramObject);
        AppMethodBeat.o(169357);
        return;
      }
      i -= 1;
    }
    AppMethodBeat.o(169357);
  }
  
  @SuppressLint({"NewApi"})
  static void a(Object paramObject, dhw paramdhw, cjp paramcjp, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(122195);
    if ((paramObject == null) || (TextUtils.isEmpty(paramdhw.className)) || (TextUtils.isEmpty(paramdhw.dataPath)))
    {
      AppMethodBeat.o(122195);
      return;
    }
    if ("0".equals(paramdhw.action))
    {
      if (!paramBoolean2) {
        AppMethodBeat.o(122195);
      }
    }
    else if (("2".equals(paramdhw.action)) && (paramBoolean2))
    {
      AppMethodBeat.o(122195);
      return;
    }
    if (paramdhw.TOT == null) {}
    for (Object localObject = paramdhw.dataPath;; localObject = paramdhw.TOT.lvH)
    {
      cjq localcjq = a(paramObject, paramdhw.TOS, (String)localObject, paramdhw.dataPath);
      localObject = localcjq;
      if (localcjq != null) {
        break;
      }
      if ((!paramBoolean1) && (paramdhw.TOT != null) && (!TextUtils.isEmpty(paramdhw.TOT.lvH))) {
        l.HG(158L);
      }
      paramObject = a(paramObject, paramdhw.className, paramdhw.dataPath, paramdhw.dataPath);
      localObject = paramObject;
      if (paramObject != null) {
        break;
      }
      AppMethodBeat.o(122195);
      return;
    }
    if (paramBoolean1)
    {
      paramcjp.Trc.add(localObject);
      AppMethodBeat.o(122195);
      return;
    }
    paramcjp.SXU.add(localObject);
    l.HG(135L);
    AppMethodBeat.o(122195);
  }
  
  private static List<e<String, String>> ayS(String paramString)
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
        localArrayList.add(new e(arrayOfString[0], arrayOfString[1]));
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
  
  private static c<String, Integer> ayT(String paramString)
  {
    AppMethodBeat.i(122198);
    c localc = ayU(paramString);
    if (localc == null)
    {
      AppMethodBeat.o(122198);
      return null;
    }
    paramString = paramString.substring(paramString.indexOf("[") + 1, ((Integer)localc.get(1)).intValue());
    try
    {
      int i = Integer.parseInt((String)localc.get(0));
      paramString = a.J(paramString, Integer.valueOf(i));
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
  
  private static c<String, Integer> ayU(String paramString)
  {
    AppMethodBeat.i(122200);
    int i = paramString.lastIndexOf("@");
    if ((i <= 0) || (i >= paramString.length() - 1))
    {
      AppMethodBeat.o(122200);
      return null;
    }
    paramString = a.J(paramString.substring(i + 1), Integer.valueOf(i));
    AppMethodBeat.o(122200);
    return paramString;
  }
  
  private static c<String, String> gL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122199);
    c localc = ayU(paramString1);
    if (localc == null)
    {
      AppMethodBeat.o(122199);
      return null;
    }
    paramString1 = a.J(paramString1.substring(paramString2.length(), ((Integer)localc.get(1)).intValue()), localc.get(0));
    AppMethodBeat.o(122199);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.e.b
 * JD-Core Version:    0.7.0.1
 */