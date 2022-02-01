package com.tencent.mm.plugin.expt.hellhound.a.f.e;

import android.annotation.SuppressLint;
import android.support.v4.e.k;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.f.l;
import com.tencent.mm.protocal.protobuf.aub;
import com.tencent.mm.protocal.protobuf.auc;
import com.tencent.mm.protocal.protobuf.boc;
import com.tencent.mm.protocal.protobuf.bod;
import com.tencent.mm.protocal.protobuf.bsg;
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.protocal.protobuf.dwc;
import com.tencent.mm.protocal.protobuf.of;
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
  private static bod a(Object paramObject, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(210479);
    paramString2 = afk(paramString2);
    if (paramString2 == null)
    {
      AppMethodBeat.o(210479);
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
                localObject1 = afl((String)localObject1);
                if (localObject1 != null)
                {
                  i = ((Integer)((c)localObject1).get(1)).intValue();
                  paramObject = (Object[])paramObject;
                  if ((paramObject == null) || (paramObject.length <= 0) || (i >= paramObject.length))
                  {
                    ad.e("HABBYGE-MALI.HellSessionParamUtil", "array == null || array.length <= 0");
                    AppMethodBeat.o(210479);
                    return null;
                  }
                  paramObject = paramObject[i];
                  paramString1 = Class.forName((String)((com.tencent.mm.vending.j.b)localObject1).get(0));
                }
              }
              else if (((String)localObject1).startsWith("Ljava/util/List;"))
              {
                localObject1 = fY((String)localObject1, "Ljava/util/List;");
                if (localObject1 != null)
                {
                  paramObject = (List)paramObject;
                  try
                  {
                    i = Integer.parseInt((String)((c)localObject1).get(1));
                    if ((paramObject == null) || (paramObject.isEmpty()) || (i >= paramObject.size()))
                    {
                      ad.e("HABBYGE-MALI.HellSessionParamUtil", "list.isEmpty");
                      AppMethodBeat.o(210479);
                      return null;
                    }
                  }
                  catch (NumberFormatException paramObject)
                  {
                    ad.printErrStackTrace("HABBYGE-MALI.HellSessionParamUtil", paramObject, "SessionParam, Ljava/util/List;, crash", new Object[0]);
                    AppMethodBeat.o(210479);
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
                  localObject1 = fY((String)localObject1, "Ljava/util/ArrayList;");
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
                        AppMethodBeat.o(210479);
                        return null;
                      }
                    }
                    catch (NumberFormatException paramObject)
                    {
                      ad.printErrStackTrace("HABBYGE-MALI.HellSessionParamUtil", paramObject, "SessionParam, Ljava/util/ArrayList;, crash", new Object[0]);
                      AppMethodBeat.o(210479);
                      return null;
                    }
                    paramObject = paramObject.get(i);
                    paramString1 = Class.forName((String)((com.tencent.mm.vending.j.b)localObject1).get(0));
                  }
                }
                else if (((String)localObject1).startsWith("Ljava/util/LinkedList;"))
                {
                  localObject1 = fY((String)localObject1, "Ljava/util/LinkedList;");
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
                        AppMethodBeat.o(210479);
                        return null;
                      }
                    }
                    catch (NumberFormatException paramObject)
                    {
                      ad.printErrStackTrace("HABBYGE-MALI.HellSessionParamUtil", paramObject, "_doParse, Ljava/util/LinkedList;, crash", new Object[0]);
                      AppMethodBeat.o(210479);
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
                    localObject1 = fY((String)localObject1, "Ljava/util/Map;");
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
                        AppMethodBeat.o(210479);
                        return null;
                      }
                      paramObject = paramObject.get(((c)localObject1).get(1));
                      if (paramObject == null)
                      {
                        AppMethodBeat.o(210479);
                        return null;
                      }
                      paramString1 = Class.forName((String)((com.tencent.mm.vending.j.b)localObject1).get(0));
                    }
                  }
                  else if (((String)localObject1).startsWith("Ljava/util/HashMap;"))
                  {
                    localObject1 = fY((String)localObject1, "Ljava/util/HashMap;");
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
                        AppMethodBeat.o(210479);
                        return null;
                      }
                      paramObject = paramObject.get(((c)localObject1).get(1));
                      if (paramObject == null)
                      {
                        AppMethodBeat.o(210479);
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
            ad.e("HABBYGE-MALI.HellSessionParamUtil", "SessionParams, object == NULL !!");
            AppMethodBeat.o(210479);
            return null;
          }
          localObject1 = new bod();
          paramString2 = String.valueOf(paramObject);
          paramString1 = paramString2;
          if ((paramObject instanceof Long)) {
            paramString1 = com.tencent.mm.plugin.expt.hellhound.core.b.rc(bt.getLong(paramString2, 0L));
          }
          ad.i("HABBYGE-MALI.HellSessionParamUtil", "SessionParams, value: %s, %s", new Object[] { paramString1, paramString3 });
          ((bod)localObject1).value = paramString1;
          ((bod)localObject1).dEZ = paramString3;
          AppMethodBeat.o(210479);
          return localObject1;
        }
      }
      catch (Exception paramObject)
      {
        AppMethodBeat.o(210479);
        return null;
      }
    }
  }
  
  private static void a(bod parambod, aub paramaub)
  {
    AppMethodBeat.i(210477);
    int j = paramaub.Gse.size();
    int i = 0;
    while (i < j)
    {
      bod localbod = (bod)paramaub.Gse.get(i);
      if ((localbod.dEZ != null) && (localbod.dEZ.equals(parambod.dEZ))) {
        break;
      }
      i += 1;
    }
    if (i < j)
    {
      paramaub.Gse.set(i, parambod);
      AppMethodBeat.o(210477);
      return;
    }
    paramaub.Gse.add(parambod);
    AppMethodBeat.o(210477);
  }
  
  @SuppressLint({"NewApi"})
  static void a(Object paramObject, chj paramchj, long paramLong, dwc paramdwc)
  {
    AppMethodBeat.i(210478);
    if ((paramObject == null) || (TextUtils.isEmpty(paramchj.className)) || (TextUtils.isEmpty(paramchj.dEZ)) || (paramdwc == null))
    {
      AppMethodBeat.o(210478);
      return;
    }
    if (paramchj.HaM == null) {}
    for (Object localObject = paramchj.dEZ;; localObject = paramchj.HaM.hHZ)
    {
      bod localbod = a(paramObject, paramchj.HaL, (String)localObject, paramchj.dEZ);
      localObject = localbod;
      if (localbod != null) {
        break;
      }
      l.vc(129L);
      paramObject = a(paramObject, paramchj.className, paramchj.dEZ, paramchj.dEZ);
      localObject = paramObject;
      if (paramObject != null) {
        break;
      }
      l.vc(133L);
      AppMethodBeat.o(210478);
      return;
    }
    l.vc(132L);
    paramObject = paramdwc.FJw.iterator();
    while (paramObject.hasNext())
    {
      paramchj = (of)paramObject.next();
      if (paramLong == paramchj.FJv) {
        paramchj.FJw.add(localObject);
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramObject = new of();
        paramObject.FJv = paramLong;
        paramObject.FJw.add(localObject);
        paramdwc.FJw.add(paramObject);
        ad.i("HABBYGE-MALI.HellSessionParamUtil", "catchParamsWhenViewOp, add pathId=%s, dataPath=%s, value=%s", new Object[] { Long.valueOf(paramLong), ((bod)localObject).dEZ, ((bod)localObject).value });
      }
      AppMethodBeat.o(210478);
      return;
    }
  }
  
  static void a(Object paramObject, chj paramchj, auc paramauc, boolean paramBoolean)
  {
    AppMethodBeat.i(169357);
    if ((paramObject == null) || (TextUtils.isEmpty(paramchj.className)) || (TextUtils.isEmpty(paramchj.dEZ)))
    {
      AppMethodBeat.o(169357);
      return;
    }
    if ("0".equals(paramchj.action))
    {
      if (!paramBoolean) {
        AppMethodBeat.o(169357);
      }
    }
    else if (("2".equals(paramchj.action)) && (paramBoolean))
    {
      AppMethodBeat.o(169357);
      return;
    }
    String str = paramObject.getClass().getSimpleName();
    if (paramchj.HaM == null) {}
    for (Object localObject = paramchj.dEZ;; localObject = paramchj.HaM.hHZ)
    {
      bod localbod = a(paramObject, paramchj.HaL, (String)localObject, paramchj.dEZ);
      localObject = localbod;
      if (localbod != null) {
        break;
      }
      if ((paramchj.HaM != null) && (!TextUtils.isEmpty(paramchj.HaM.hHZ))) {
        l.vc(158L);
      }
      paramObject = a(paramObject, paramchj.className, paramchj.dEZ, paramchj.dEZ);
      localObject = paramObject;
      if (paramObject != null) {
        break;
      }
      AppMethodBeat.o(169357);
      return;
    }
    l.vc(135L);
    int i = paramauc.Gsi.size() - 1;
    while (i >= 0)
    {
      paramObject = (aub)paramauc.Gsi.get(i);
      paramchj = com.tencent.mm.plugin.expt.hellhound.core.b.adx(paramObject.name);
      if ((paramchj != null) && (paramchj.equals(str)))
      {
        a((bod)localObject, paramObject);
        AppMethodBeat.o(169357);
        return;
      }
      i -= 1;
    }
    AppMethodBeat.o(169357);
  }
  
  @SuppressLint({"NewApi"})
  static void a(Object paramObject, chj paramchj, boc paramboc, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(122195);
    if ((paramObject == null) || (TextUtils.isEmpty(paramchj.className)) || (TextUtils.isEmpty(paramchj.dEZ)))
    {
      AppMethodBeat.o(122195);
      return;
    }
    if ("0".equals(paramchj.action))
    {
      if (!paramBoolean2) {
        AppMethodBeat.o(122195);
      }
    }
    else if (("2".equals(paramchj.action)) && (paramBoolean2))
    {
      AppMethodBeat.o(122195);
      return;
    }
    if (paramchj.HaM == null) {}
    for (Object localObject = paramchj.dEZ;; localObject = paramchj.HaM.hHZ)
    {
      bod localbod = a(paramObject, paramchj.HaL, (String)localObject, paramchj.dEZ);
      localObject = localbod;
      if (localbod != null) {
        break;
      }
      if ((!paramBoolean1) && (paramchj.HaM != null) && (!TextUtils.isEmpty(paramchj.HaM.hHZ))) {
        l.vc(158L);
      }
      paramObject = a(paramObject, paramchj.className, paramchj.dEZ, paramchj.dEZ);
      localObject = paramObject;
      if (paramObject != null) {
        break;
      }
      AppMethodBeat.o(122195);
      return;
    }
    if (paramBoolean1)
    {
      paramboc.GIJ.add(localObject);
      AppMethodBeat.o(122195);
      return;
    }
    paramboc.Gse.add(localObject);
    l.vc(135L);
    AppMethodBeat.o(122195);
  }
  
  private static List<k<String, String>> afk(String paramString)
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
  
  private static c<String, Integer> afl(String paramString)
  {
    AppMethodBeat.i(122198);
    c localc = afm(paramString);
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
      ad.printErrStackTrace("HABBYGE-MALI.HellSessionParamUtil", paramString, "HellPageParamsCatcher, getClassNameAndIndexOfArray", new Object[0]);
      AppMethodBeat.o(122198);
    }
    return null;
  }
  
  private static c<String, Integer> afm(String paramString)
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
  
  private static c<String, String> fY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122199);
    c localc = afm(paramString1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.e.b
 * JD-Core Version:    0.7.0.1
 */