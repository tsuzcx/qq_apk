package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import android.support.v4.e.j;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.auy;
import com.tencent.mm.protocal.protobuf.auz;
import com.tencent.mm.protocal.protobuf.bkh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.c;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class b
{
  private static List<j<String, String>> ML(String paramString)
  {
    AppMethodBeat.i(156444);
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramString = paramString.split(",");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = paramString[i].split("\\|");
        localArrayList.add(new j(arrayOfString[0], arrayOfString[1]));
        i += 1;
      }
      AppMethodBeat.o(156444);
      return localArrayList;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("HellSessionParamUtil", paramString, "HABBYGE-MALI, _getFieldWithClass, crash", new Object[0]);
      AppMethodBeat.o(156444);
    }
    return null;
  }
  
  private static c<String, Integer> MM(String paramString)
  {
    AppMethodBeat.i(156445);
    c localc = MO(paramString);
    if (localc == null)
    {
      AppMethodBeat.o(156445);
      return null;
    }
    paramString = paramString.substring(paramString.indexOf("[") + 1, ((Integer)localc.get(1)).intValue());
    try
    {
      int i = Integer.valueOf((String)localc.get(0)).intValue();
      paramString = a.C(paramString, Integer.valueOf(i));
      AppMethodBeat.o(156445);
      return paramString;
    }
    catch (NumberFormatException paramString)
    {
      ab.printErrStackTrace("HellSessionParamUtil", paramString, "HABBYGE-MALI, HellPageParamsCatcher, getClassNameAndIndexOfArray, crash", new Object[0]);
      AppMethodBeat.o(156445);
    }
    return null;
  }
  
  private static c<String, Integer> MN(String paramString)
  {
    AppMethodBeat.i(156446);
    c localc = MO(paramString);
    if (localc == null)
    {
      AppMethodBeat.o(156446);
      return null;
    }
    paramString = paramString.substring(16, ((Integer)localc.get(1)).intValue());
    try
    {
      int i = Integer.valueOf((String)localc.get(0)).intValue();
      paramString = a.C(paramString, Integer.valueOf(i));
      AppMethodBeat.o(156446);
      return paramString;
    }
    catch (NumberFormatException paramString)
    {
      ab.printErrStackTrace("HellSessionParamUtil", paramString, "HABBYGE-MALI, HellPageParamsCatcher, getClassNameAndIndexOfArray, crash", new Object[0]);
      AppMethodBeat.o(156446);
    }
    return null;
  }
  
  private static c<String, Integer> MO(String paramString)
  {
    AppMethodBeat.i(156447);
    int i = paramString.lastIndexOf("@");
    if ((i <= 0) || (i >= paramString.length() - 1))
    {
      AppMethodBeat.o(156447);
      return null;
    }
    paramString = a.C(paramString.substring(i + 1), Integer.valueOf(i));
    AppMethodBeat.o(156447);
    return paramString;
  }
  
  static void a(Object paramObject, bkh parambkh, auy paramauy, boolean paramBoolean)
  {
    AppMethodBeat.i(156443);
    if ((TextUtils.isEmpty(parambkh.className)) || (TextUtils.isEmpty(parambkh.dataPath)))
    {
      AppMethodBeat.o(156443);
      return;
    }
    ab.i("HellSessionParamUtil", "HABBYGE-MALI, _catchPageParams, pageParam: " + parambkh.className + " | " + parambkh.dataPath + " | " + parambkh.action + " | " + paramBoolean);
    Object localObject2 = ML(parambkh.dataPath);
    if (localObject2 == null)
    {
      AppMethodBeat.o(156443);
      return;
    }
    label558:
    for (;;)
    {
      Object localObject1;
      try
      {
        localObject1 = Class.forName(parambkh.className);
        Iterator localIterator = ((List)localObject2).iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (j)localIterator.next();
          if (localObject2 == null) {
            continue;
          }
          Object localObject3 = (String)((j)localObject2).first;
          localObject2 = (String)((j)localObject2).second;
          if ((localObject3 == null) || (((String)localObject3).isEmpty()) || (localObject2 == null) || (((String)localObject2).isEmpty())) {
            continue;
          }
          localObject3 = ((Class)localObject1).getDeclaredField((String)localObject3);
          ((Field)localObject3).setAccessible(true);
          paramObject = ((Field)localObject3).get(paramObject);
          if (((String)localObject2).startsWith("["))
          {
            localObject2 = MM((String)localObject2);
            if (localObject2 == null) {
              break label558;
            }
            paramObject = ((Object[])(Object[])paramObject)[((Integer)localObject2.get(1)).intValue()];
            localObject1 = Class.forName((String)((com.tencent.mm.vending.j.b)localObject2).get(0));
            continue;
          }
          if (((String)localObject2).startsWith("Ljava/util/List;"))
          {
            localObject2 = MN((String)localObject2);
            if (localObject2 == null) {
              break label558;
            }
            paramObject = ((List)paramObject).get(((Integer)((c)localObject2).get(1)).intValue());
            localObject1 = Class.forName((String)((com.tencent.mm.vending.j.b)localObject2).get(0));
            continue;
          }
          if (((String)localObject2).startsWith("Ljava/util/Map;"))
          {
            localObject3 = MO((String)localObject2);
            if (localObject3 == null)
            {
              localObject2 = null;
              if (localObject2 == null) {
                break label558;
              }
              paramObject = ((Map)paramObject).get(((c)localObject2).get(1));
              localObject1 = Class.forName((String)((com.tencent.mm.vending.j.b)localObject2).get(0));
              continue;
            }
            localObject2 = a.C(((String)localObject2).substring(15, ((Integer)((c)localObject3).get(1)).intValue()), ((com.tencent.mm.vending.j.b)localObject3).get(0));
            continue;
          }
          localObject1 = Class.forName((String)localObject2);
          continue;
        }
        ab.i("HellSessionParamUtil", "HABBYGE-MALI, HellSessionParamUtil, catchPageParams, object: " + paramObject.getClass().getName());
        localObject1 = new auz();
        ((auz)localObject1).value = String.valueOf(paramObject);
        ((auz)localObject1).dataPath = parambkh.dataPath;
        if (paramBoolean)
        {
          paramauy.xkh.add(localObject1);
          AppMethodBeat.o(156443);
          return;
        }
      }
      catch (Exception paramObject)
      {
        ab.printErrStackTrace("HellSessionParamUtil", paramObject, "HABBYGE-MALI, _catchPageParams, crash", new Object[0]);
        AppMethodBeat.o(156443);
        return;
      }
      paramauy.xkg.add(localObject1);
      AppMethodBeat.o(156443);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.b
 * JD-Core Version:    0.7.0.1
 */