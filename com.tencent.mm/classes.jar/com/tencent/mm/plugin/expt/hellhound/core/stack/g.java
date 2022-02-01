package com.tencent.mm.plugin.expt.hellhound.core.stack;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bj;
import com.tencent.mm.protocal.protobuf.bk;
import com.tencent.mm.protocal.protobuf.dmi;
import com.tencent.mm.protocal.protobuf.dno;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.b;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
{
  public f qRp;
  
  public static com.tencent.mm.vending.j.c<dmi, Integer> a(bk parambk, bj parambj)
  {
    AppMethodBeat.i(121899);
    if ((parambk == null) || (parambk.Fto.isEmpty()))
    {
      AppMethodBeat.o(121899);
      return null;
    }
    int i = parambk.Fto.size() - 1;
    while (i >= 0)
    {
      dmi localdmi = (dmi)parambk.Fto.get(i);
      if ((localdmi != null) && (!localdmi.HAD.isEmpty()))
      {
        int j = localdmi.HAD.size() - 1;
        while (j >= 0)
        {
          bj localbj = (bj)localdmi.HAD.get(j);
          if ((localbj != null) && (h.a(parambj.Fti, localbj.Fti)))
          {
            parambk = a.N(localdmi, Integer.valueOf(i));
            AppMethodBeat.o(121899);
            return parambk;
          }
          j -= 1;
        }
      }
      i -= 1;
    }
    AppMethodBeat.o(121899);
    return null;
  }
  
  static com.tencent.mm.vending.j.c<Integer, Integer> a(bk parambk, String paramString)
  {
    AppMethodBeat.i(210333);
    if (TextUtils.isEmpty(paramString))
    {
      parambk = a.N(Integer.valueOf(-1), Integer.valueOf(-1));
      AppMethodBeat.o(210333);
      return parambk;
    }
    if (parambk == null)
    {
      parambk = com.tencent.mm.vending.j.c.N(Integer.valueOf(-1), Integer.valueOf(-1));
      AppMethodBeat.o(210333);
      return parambk;
    }
    int i = parambk.Fto.size();
    if (i <= 0)
    {
      parambk = com.tencent.mm.vending.j.c.N(Integer.valueOf(-1), Integer.valueOf(-1));
      AppMethodBeat.o(210333);
      return parambk;
    }
    i -= 1;
    int k = -1;
    int j = -1;
    int m;
    if (i >= 0)
    {
      dmi localdmi = (dmi)parambk.Fto.get(i);
      m = localdmi.HAD.size() - 1;
      label123:
      if (m < 0) {
        break label220;
      }
      if (paramString.equals(((bj)localdmi.HAD.get(m)).Fti.activityName))
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
        parambk = com.tencent.mm.vending.j.c.N(Integer.valueOf(-1), Integer.valueOf(-1));
        AppMethodBeat.o(210333);
        return parambk;
      }
      parambk = a.N(Integer.valueOf(j), Integer.valueOf(k));
      AppMethodBeat.o(210333);
      return parambk;
    }
  }
  
  static void a(bk parambk, bj parambj, boolean paramBoolean)
  {
    AppMethodBeat.i(121901);
    dmi localdmi = new dmi();
    localdmi.HAC = paramBoolean;
    localdmi.HAD.addLast(parambj);
    parambj = parambk;
    if (parambk == null) {
      parambj = new bk();
    }
    parambj.Fto.addLast(localdmi);
    AppMethodBeat.o(121901);
  }
  
  private static void a(bk parambk, dmi paramdmi)
  {
    AppMethodBeat.i(121905);
    if ((paramdmi.HAD.isEmpty()) && (!parambk.Fto.isEmpty())) {
      parambk.Fto.removeLast();
    }
    AppMethodBeat.o(121905);
  }
  
  public static bj adS(String paramString)
  {
    AppMethodBeat.i(121911);
    bk localbk = c.cnP();
    paramString = a(localbk, paramString);
    int i = ((Integer)paramString.get(0)).intValue();
    int j = ((Integer)paramString.get(1)).intValue();
    if ((i < 0) || (j < 0))
    {
      AppMethodBeat.o(121911);
      return null;
    }
    paramString = (bj)((dmi)localbk.Fto.get(i)).HAD.get(j);
    AppMethodBeat.o(121911);
    return paramString;
  }
  
  static void b(bk parambk, bj parambj)
  {
    AppMethodBeat.i(121900);
    dmi localdmi1 = null;
    if (!parambk.Fto.isEmpty()) {
      localdmi1 = (dmi)parambk.Fto.getLast();
    }
    dmi localdmi2 = localdmi1;
    if (localdmi1 == null)
    {
      localdmi2 = new dmi();
      parambk.Fto.addLast(localdmi2);
    }
    localdmi2.HAD.addLast(parambj);
    AppMethodBeat.o(121900);
  }
  
  static boolean b(bk parambk)
  {
    AppMethodBeat.i(121902);
    if (parambk == null)
    {
      AppMethodBeat.o(121902);
      return false;
    }
    dmi localdmi = null;
    if (!parambk.Fto.isEmpty()) {
      localdmi = (dmi)parambk.Fto.getLast();
    }
    if ((localdmi != null) && (localdmi.HAC))
    {
      AppMethodBeat.o(121902);
      return true;
    }
    AppMethodBeat.o(121902);
    return false;
  }
  
  static bj c(bk parambk)
  {
    AppMethodBeat.i(121906);
    if (parambk == null)
    {
      AppMethodBeat.o(121906);
      return null;
    }
    if (!parambk.Fto.isEmpty()) {}
    for (parambk = (dmi)parambk.Fto.getLast();; parambk = null)
    {
      if (parambk == null)
      {
        AppMethodBeat.o(121906);
        return null;
      }
      if (parambk.HAD.isEmpty())
      {
        AppMethodBeat.o(121906);
        return null;
      }
      parambk = (bj)parambk.HAD.getLast();
      AppMethodBeat.o(121906);
      return parambk;
    }
  }
  
  static com.tencent.mm.vending.j.c<Integer, Integer> c(bk parambk, bj parambj)
  {
    AppMethodBeat.i(121907);
    parambk = a(parambk, parambj.Fti.activityName);
    AppMethodBeat.o(121907);
    return parambk;
  }
  
  public static com.tencent.mm.vending.j.c<bk, bj> cnX()
  {
    AppMethodBeat.i(121909);
    Object localObject = c.cnP();
    localObject = a.N(localObject, e((bk)localObject));
    AppMethodBeat.o(121909);
    return localObject;
  }
  
  static LinkedList<dmi> d(bk parambk)
  {
    if (parambk == null) {
      return null;
    }
    return parambk.Fto;
  }
  
  public static bj e(bk parambk)
  {
    AppMethodBeat.i(121910);
    if (parambk == null)
    {
      AppMethodBeat.o(121910);
      return null;
    }
    if (!parambk.Fto.isEmpty()) {}
    for (parambk = (dmi)parambk.Fto.getLast();; parambk = null)
    {
      if (parambk == null)
      {
        AppMethodBeat.o(121910);
        return null;
      }
      if (parambk.HAD.isEmpty())
      {
        AppMethodBeat.o(121910);
        return null;
      }
      parambk = (bj)parambk.HAD.getLast();
      AppMethodBeat.o(121910);
      return parambk;
    }
  }
  
  final void a(bk parambk, int paramInt, bj parambj)
  {
    AppMethodBeat.i(121903);
    if (parambk == null)
    {
      AppMethodBeat.o(121903);
      return;
    }
    dmi localdmi = (dmi)parambk.Fto.getLast();
    int i = localdmi.HAD.size();
    if ((paramInt < 0) || (paramInt >= i))
    {
      AppMethodBeat.o(121903);
      return;
    }
    i -= 1;
    while (i >= paramInt)
    {
      bj localbj = (bj)localdmi.HAD.remove(i);
      if (this.qRp != null)
      {
        localbj.Fti.timestamp = parambj.Fti.timestamp;
        this.qRp.c(localbj, parambj);
      }
      i -= 1;
    }
    a(parambk, localdmi);
    AppMethodBeat.o(121903);
  }
  
  final void b(bk parambk, int paramInt, bj parambj)
  {
    AppMethodBeat.i(121904);
    if (parambk == null)
    {
      AppMethodBeat.o(121904);
      return;
    }
    int i = parambk.Fto.size();
    if ((paramInt < 0) || (paramInt >= i))
    {
      AppMethodBeat.o(121904);
      return;
    }
    i -= 1;
    while (i >= paramInt)
    {
      Iterator localIterator = ((dmi)parambk.Fto.remove(i)).HAD.iterator();
      while (localIterator.hasNext())
      {
        bj localbj = (bj)localIterator.next();
        if (this.qRp != null)
        {
          localbj.Fti.timestamp = parambj.Fti.timestamp;
          this.qRp.c(localbj, parambj);
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