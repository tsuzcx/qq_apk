package com.tencent.mm.plugin.expt.hellhound.core.stack;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bj;
import com.tencent.mm.protocal.protobuf.bk;
import com.tencent.mm.protocal.protobuf.dnf;
import com.tencent.mm.protocal.protobuf.dol;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.b;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
{
  public f qZn;
  
  public static com.tencent.mm.vending.j.c<dnf, Integer> a(bk parambk, bj parambj)
  {
    AppMethodBeat.i(121899);
    if ((parambk == null) || (parambk.FLM.isEmpty()))
    {
      AppMethodBeat.o(121899);
      return null;
    }
    int i = parambk.FLM.size() - 1;
    while (i >= 0)
    {
      dnf localdnf = (dnf)parambk.FLM.get(i);
      if ((localdnf != null) && (!localdnf.HUq.isEmpty()))
      {
        int j = localdnf.HUq.size() - 1;
        while (j >= 0)
        {
          bj localbj = (bj)localdnf.HUq.get(j);
          if ((localbj != null) && (h.a(parambj.FLG, localbj.FLG)))
          {
            parambk = a.N(localdnf, Integer.valueOf(i));
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
    AppMethodBeat.i(195993);
    if (TextUtils.isEmpty(paramString))
    {
      parambk = a.N(Integer.valueOf(-1), Integer.valueOf(-1));
      AppMethodBeat.o(195993);
      return parambk;
    }
    if (parambk == null)
    {
      parambk = com.tencent.mm.vending.j.c.N(Integer.valueOf(-1), Integer.valueOf(-1));
      AppMethodBeat.o(195993);
      return parambk;
    }
    int i = parambk.FLM.size();
    if (i <= 0)
    {
      parambk = com.tencent.mm.vending.j.c.N(Integer.valueOf(-1), Integer.valueOf(-1));
      AppMethodBeat.o(195993);
      return parambk;
    }
    i -= 1;
    int k = -1;
    int j = -1;
    int m;
    if (i >= 0)
    {
      dnf localdnf = (dnf)parambk.FLM.get(i);
      m = localdnf.HUq.size() - 1;
      label123:
      if (m < 0) {
        break label220;
      }
      if (paramString.equals(((bj)localdnf.HUq.get(m)).FLG.activityName))
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
        AppMethodBeat.o(195993);
        return parambk;
      }
      parambk = a.N(Integer.valueOf(j), Integer.valueOf(k));
      AppMethodBeat.o(195993);
      return parambk;
    }
  }
  
  static void a(bk parambk, bj parambj, boolean paramBoolean)
  {
    AppMethodBeat.i(121901);
    dnf localdnf = new dnf();
    localdnf.HUp = paramBoolean;
    localdnf.HUq.addLast(parambj);
    parambj = parambk;
    if (parambk == null) {
      parambj = new bk();
    }
    parambj.FLM.addLast(localdnf);
    AppMethodBeat.o(121901);
  }
  
  private static void a(bk parambk, dnf paramdnf)
  {
    AppMethodBeat.i(121905);
    if ((paramdnf.HUq.isEmpty()) && (!parambk.FLM.isEmpty())) {
      parambk.FLM.removeLast();
    }
    AppMethodBeat.o(121905);
  }
  
  public static bj aeM(String paramString)
  {
    AppMethodBeat.i(121911);
    bk localbk = c.cpr();
    paramString = a(localbk, paramString);
    int i = ((Integer)paramString.get(0)).intValue();
    int j = ((Integer)paramString.get(1)).intValue();
    if ((i < 0) || (j < 0))
    {
      AppMethodBeat.o(121911);
      return null;
    }
    paramString = (bj)((dnf)localbk.FLM.get(i)).HUq.get(j);
    AppMethodBeat.o(121911);
    return paramString;
  }
  
  static void b(bk parambk, bj parambj)
  {
    AppMethodBeat.i(121900);
    dnf localdnf1 = null;
    if (!parambk.FLM.isEmpty()) {
      localdnf1 = (dnf)parambk.FLM.getLast();
    }
    dnf localdnf2 = localdnf1;
    if (localdnf1 == null)
    {
      localdnf2 = new dnf();
      parambk.FLM.addLast(localdnf2);
    }
    localdnf2.HUq.addLast(parambj);
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
    dnf localdnf = null;
    if (!parambk.FLM.isEmpty()) {
      localdnf = (dnf)parambk.FLM.getLast();
    }
    if ((localdnf != null) && (localdnf.HUp))
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
    if (!parambk.FLM.isEmpty()) {}
    for (parambk = (dnf)parambk.FLM.getLast();; parambk = null)
    {
      if (parambk == null)
      {
        AppMethodBeat.o(121906);
        return null;
      }
      if (parambk.HUq.isEmpty())
      {
        AppMethodBeat.o(121906);
        return null;
      }
      parambk = (bj)parambk.HUq.getLast();
      AppMethodBeat.o(121906);
      return parambk;
    }
  }
  
  static com.tencent.mm.vending.j.c<Integer, Integer> c(bk parambk, bj parambj)
  {
    AppMethodBeat.i(121907);
    parambk = a(parambk, parambj.FLG.activityName);
    AppMethodBeat.o(121907);
    return parambk;
  }
  
  public static com.tencent.mm.vending.j.c<bk, bj> cpz()
  {
    AppMethodBeat.i(121909);
    Object localObject = c.cpr();
    localObject = a.N(localObject, e((bk)localObject));
    AppMethodBeat.o(121909);
    return localObject;
  }
  
  static LinkedList<dnf> d(bk parambk)
  {
    if (parambk == null) {
      return null;
    }
    return parambk.FLM;
  }
  
  public static bj e(bk parambk)
  {
    AppMethodBeat.i(121910);
    if (parambk == null)
    {
      AppMethodBeat.o(121910);
      return null;
    }
    if (!parambk.FLM.isEmpty()) {}
    for (parambk = (dnf)parambk.FLM.getLast();; parambk = null)
    {
      if (parambk == null)
      {
        AppMethodBeat.o(121910);
        return null;
      }
      if (parambk.HUq.isEmpty())
      {
        AppMethodBeat.o(121910);
        return null;
      }
      parambk = (bj)parambk.HUq.getLast();
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
    dnf localdnf = (dnf)parambk.FLM.getLast();
    int i = localdnf.HUq.size();
    if ((paramInt < 0) || (paramInt >= i))
    {
      AppMethodBeat.o(121903);
      return;
    }
    i -= 1;
    while (i >= paramInt)
    {
      bj localbj = (bj)localdnf.HUq.remove(i);
      if (this.qZn != null)
      {
        localbj.FLG.timestamp = parambj.FLG.timestamp;
        this.qZn.c(localbj, parambj);
      }
      i -= 1;
    }
    a(parambk, localdnf);
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
    int i = parambk.FLM.size();
    if ((paramInt < 0) || (paramInt >= i))
    {
      AppMethodBeat.o(121904);
      return;
    }
    i -= 1;
    while (i >= paramInt)
    {
      Iterator localIterator = ((dnf)parambk.FLM.remove(i)).HUq.iterator();
      while (localIterator.hasNext())
      {
        bj localbj = (bj)localIterator.next();
        if (this.qZn != null)
        {
          localbj.FLG.timestamp = parambj.FLG.timestamp;
          this.qZn.c(localbj, parambj);
        }
      }
      i -= 1;
    }
    AppMethodBeat.o(121904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.stack.g
 * JD-Core Version:    0.7.0.1
 */