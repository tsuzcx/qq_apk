package com.tencent.mm.plugin.expt.hellhound.core.stack;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bl;
import com.tencent.mm.protocal.protobuf.bm;
import com.tencent.mm.protocal.protobuf.eqy;
import com.tencent.mm.protocal.protobuf.esj;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.b;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
{
  public f wfy;
  
  public static com.tencent.mm.vending.j.c<eqy, Integer> a(bm parambm, bl parambl)
  {
    AppMethodBeat.i(121899);
    if ((parambm == null) || (parambm.RGE.isEmpty()))
    {
      AppMethodBeat.o(121899);
      return null;
    }
    int i = parambm.RGE.size() - 1;
    while (i >= 0)
    {
      eqy localeqy = (eqy)parambm.RGE.get(i);
      if ((localeqy != null) && (!localeqy.Utm.isEmpty()))
      {
        int j = localeqy.Utm.size() - 1;
        while (j >= 0)
        {
          bl localbl = (bl)localeqy.Utm.get(j);
          if ((localbl != null) && (h.a(parambl.RGy, localbl.RGy)))
          {
            parambm = a.J(localeqy, Integer.valueOf(i));
            AppMethodBeat.o(121899);
            return parambm;
          }
          j -= 1;
        }
      }
      i -= 1;
    }
    AppMethodBeat.o(121899);
    return null;
  }
  
  static com.tencent.mm.vending.j.c<Integer, Integer> a(bm parambm, String paramString)
  {
    AppMethodBeat.i(251846);
    if (TextUtils.isEmpty(paramString))
    {
      parambm = a.J(Integer.valueOf(-1), Integer.valueOf(-1));
      AppMethodBeat.o(251846);
      return parambm;
    }
    if (parambm == null)
    {
      parambm = com.tencent.mm.vending.j.c.J(Integer.valueOf(-1), Integer.valueOf(-1));
      AppMethodBeat.o(251846);
      return parambm;
    }
    int i = parambm.RGE.size();
    if (i <= 0)
    {
      parambm = com.tencent.mm.vending.j.c.J(Integer.valueOf(-1), Integer.valueOf(-1));
      AppMethodBeat.o(251846);
      return parambm;
    }
    i -= 1;
    int k = -1;
    int j = -1;
    int m;
    if (i >= 0)
    {
      eqy localeqy = (eqy)parambm.RGE.get(i);
      m = localeqy.Utm.size() - 1;
      label123:
      if (m < 0) {
        break label220;
      }
      if (paramString.equals(((bl)localeqy.Utm.get(m)).RGy.activityName))
      {
        k = m;
        j = i;
      }
    }
    label220:
    for (;;)
    {
      i -= 1;
      break;
      m -= 1;
      break label123;
      if (j == -1)
      {
        parambm = com.tencent.mm.vending.j.c.J(Integer.valueOf(-1), Integer.valueOf(-1));
        AppMethodBeat.o(251846);
        return parambm;
      }
      parambm = a.J(Integer.valueOf(j), Integer.valueOf(k));
      AppMethodBeat.o(251846);
      return parambm;
    }
  }
  
  static void a(bm parambm, bl parambl, boolean paramBoolean)
  {
    AppMethodBeat.i(121901);
    eqy localeqy = new eqy();
    localeqy.Utl = paramBoolean;
    localeqy.Utm.addLast(parambl);
    parambl = parambm;
    if (parambm == null) {
      parambl = new bm();
    }
    parambl.RGE.addLast(localeqy);
    AppMethodBeat.o(121901);
  }
  
  private static void a(bm parambm, eqy parameqy)
  {
    AppMethodBeat.i(121905);
    if ((parameqy.Utm.isEmpty()) && (!parambm.RGE.isEmpty())) {
      parambm.RGE.removeLast();
    }
    AppMethodBeat.o(121905);
  }
  
  public static bl axc(String paramString)
  {
    AppMethodBeat.i(121911);
    bm localbm = c.dcC();
    paramString = a(localbm, paramString);
    int i = ((Integer)paramString.get(0)).intValue();
    int j = ((Integer)paramString.get(1)).intValue();
    if ((i < 0) || (j < 0))
    {
      AppMethodBeat.o(121911);
      return null;
    }
    paramString = (bl)((eqy)localbm.RGE.get(i)).Utm.get(j);
    AppMethodBeat.o(121911);
    return paramString;
  }
  
  static void b(bm parambm, bl parambl)
  {
    AppMethodBeat.i(121900);
    eqy localeqy1 = null;
    if (!parambm.RGE.isEmpty()) {
      localeqy1 = (eqy)parambm.RGE.getLast();
    }
    eqy localeqy2 = localeqy1;
    if (localeqy1 == null)
    {
      localeqy2 = new eqy();
      parambm.RGE.addLast(localeqy2);
    }
    localeqy2.Utm.addLast(parambl);
    AppMethodBeat.o(121900);
  }
  
  static boolean b(bm parambm)
  {
    AppMethodBeat.i(121902);
    if (parambm == null)
    {
      AppMethodBeat.o(121902);
      return false;
    }
    eqy localeqy = null;
    if (!parambm.RGE.isEmpty()) {
      localeqy = (eqy)parambm.RGE.getLast();
    }
    if ((localeqy != null) && (localeqy.Utl))
    {
      AppMethodBeat.o(121902);
      return true;
    }
    AppMethodBeat.o(121902);
    return false;
  }
  
  static bl c(bm parambm)
  {
    AppMethodBeat.i(121906);
    if (parambm == null)
    {
      AppMethodBeat.o(121906);
      return null;
    }
    if (!parambm.RGE.isEmpty()) {}
    for (parambm = (eqy)parambm.RGE.getLast();; parambm = null)
    {
      if (parambm == null)
      {
        AppMethodBeat.o(121906);
        return null;
      }
      if (parambm.Utm.isEmpty())
      {
        AppMethodBeat.o(121906);
        return null;
      }
      parambm = (bl)parambm.Utm.getLast();
      AppMethodBeat.o(121906);
      return parambm;
    }
  }
  
  static com.tencent.mm.vending.j.c<Integer, Integer> c(bm parambm, bl parambl)
  {
    AppMethodBeat.i(121907);
    parambm = a(parambm, parambl.RGy.activityName);
    AppMethodBeat.o(121907);
    return parambm;
  }
  
  static LinkedList<eqy> d(bm parambm)
  {
    if (parambm == null) {
      return null;
    }
    return parambm.RGE;
  }
  
  public static com.tencent.mm.vending.j.c<bm, bl> dcK()
  {
    AppMethodBeat.i(121909);
    Object localObject = c.dcC();
    localObject = a.J(localObject, e((bm)localObject));
    AppMethodBeat.o(121909);
    return localObject;
  }
  
  public static bl e(bm parambm)
  {
    AppMethodBeat.i(121910);
    if (parambm == null)
    {
      AppMethodBeat.o(121910);
      return null;
    }
    if (!parambm.RGE.isEmpty()) {}
    for (parambm = (eqy)parambm.RGE.getLast();; parambm = null)
    {
      if (parambm == null)
      {
        AppMethodBeat.o(121910);
        return null;
      }
      if (parambm.Utm.isEmpty())
      {
        AppMethodBeat.o(121910);
        return null;
      }
      parambm = (bl)parambm.Utm.getLast();
      AppMethodBeat.o(121910);
      return parambm;
    }
  }
  
  final void a(bm parambm, int paramInt, bl parambl)
  {
    AppMethodBeat.i(121903);
    if (parambm == null)
    {
      AppMethodBeat.o(121903);
      return;
    }
    eqy localeqy = (eqy)parambm.RGE.getLast();
    int i = localeqy.Utm.size();
    if ((paramInt < 0) || (paramInt >= i))
    {
      AppMethodBeat.o(121903);
      return;
    }
    i -= 1;
    while (i >= paramInt)
    {
      bl localbl = (bl)localeqy.Utm.remove(i);
      if (this.wfy != null)
      {
        localbl.RGy.timestamp = parambl.RGy.timestamp;
        this.wfy.c(localbl, parambl);
      }
      i -= 1;
    }
    a(parambm, localeqy);
    AppMethodBeat.o(121903);
  }
  
  final void b(bm parambm, int paramInt, bl parambl)
  {
    AppMethodBeat.i(121904);
    if (parambm == null)
    {
      AppMethodBeat.o(121904);
      return;
    }
    int i = parambm.RGE.size();
    if ((paramInt < 0) || (paramInt >= i))
    {
      AppMethodBeat.o(121904);
      return;
    }
    i -= 1;
    while (i >= paramInt)
    {
      Iterator localIterator = ((eqy)parambm.RGE.remove(i)).Utm.iterator();
      while (localIterator.hasNext())
      {
        bl localbl = (bl)localIterator.next();
        if (this.wfy != null)
        {
          localbl.RGy.timestamp = parambl.RGy.timestamp;
          this.wfy.c(localbl, parambl);
        }
      }
      i -= 1;
    }
    AppMethodBeat.o(121904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.stack.g
 * JD-Core Version:    0.7.0.1
 */