package com.tencent.mm.plugin.expt.hellhound.core.stack;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bj;
import com.tencent.mm.protocal.protobuf.bk;
import com.tencent.mm.protocal.protobuf.dgv;
import com.tencent.mm.protocal.protobuf.dhz;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.b;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
{
  public f qjp;
  
  public static com.tencent.mm.vending.j.c<dgv, Integer> a(bk parambk, bj parambj)
  {
    AppMethodBeat.i(121899);
    if ((parambk == null) || (parambk.DOh.isEmpty()))
    {
      AppMethodBeat.o(121899);
      return null;
    }
    int i = parambk.DOh.size() - 1;
    while (i >= 0)
    {
      dgv localdgv = (dgv)parambk.DOh.get(i);
      if ((localdgv != null) && (!localdgv.FPY.isEmpty()))
      {
        int j = localdgv.FPY.size() - 1;
        while (j >= 0)
        {
          bj localbj = (bj)localdgv.FPY.get(j);
          if ((localbj != null) && (h.a(parambj.DOc, localbj.DOc)))
          {
            parambk = a.L(localdgv, Integer.valueOf(i));
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
    AppMethodBeat.i(121908);
    if (TextUtils.isEmpty(paramString))
    {
      parambk = a.L(Integer.valueOf(-1), Integer.valueOf(-1));
      AppMethodBeat.o(121908);
      return parambk;
    }
    if (parambk == null)
    {
      parambk = com.tencent.mm.vending.j.c.L(Integer.valueOf(-1), Integer.valueOf(-1));
      AppMethodBeat.o(121908);
      return parambk;
    }
    int i = parambk.DOh.size();
    if (i <= 0)
    {
      parambk = com.tencent.mm.vending.j.c.L(Integer.valueOf(-1), Integer.valueOf(-1));
      AppMethodBeat.o(121908);
      return parambk;
    }
    i -= 1;
    int k = -1;
    int j = -1;
    int m;
    if (i >= 0)
    {
      dgv localdgv = (dgv)parambk.DOh.get(i);
      m = localdgv.FPY.size() - 1;
      label123:
      if (m < 0) {
        break label220;
      }
      if (paramString.equals(((bj)localdgv.FPY.get(m)).DOc.activityName))
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
        parambk = com.tencent.mm.vending.j.c.L(Integer.valueOf(-1), Integer.valueOf(-1));
        AppMethodBeat.o(121908);
        return parambk;
      }
      parambk = a.L(Integer.valueOf(j), Integer.valueOf(k));
      AppMethodBeat.o(121908);
      return parambk;
    }
  }
  
  static void a(bk parambk, bj parambj, boolean paramBoolean)
  {
    AppMethodBeat.i(121901);
    dgv localdgv = new dgv();
    localdgv.FPX = paramBoolean;
    localdgv.FPY.addLast(parambj);
    parambj = parambk;
    if (parambk == null) {
      parambj = new bk();
    }
    parambj.DOh.addLast(localdgv);
    AppMethodBeat.o(121901);
  }
  
  private static void a(bk parambk, dgv paramdgv)
  {
    AppMethodBeat.i(121905);
    if ((paramdgv.FPY.isEmpty()) && (!parambk.DOh.isEmpty())) {
      parambk.DOh.removeLast();
    }
    AppMethodBeat.o(121905);
  }
  
  public static bj aaf(String paramString)
  {
    AppMethodBeat.i(121911);
    bk localbk = c.ciP();
    paramString = a(localbk, paramString);
    int i = ((Integer)paramString.get(0)).intValue();
    int j = ((Integer)paramString.get(1)).intValue();
    if ((i < 0) || (j < 0))
    {
      AppMethodBeat.o(121911);
      return null;
    }
    paramString = (bj)((dgv)localbk.DOh.get(i)).FPY.get(j);
    AppMethodBeat.o(121911);
    return paramString;
  }
  
  static void b(bk parambk, bj parambj)
  {
    AppMethodBeat.i(121900);
    dgv localdgv1 = null;
    if (!parambk.DOh.isEmpty()) {
      localdgv1 = (dgv)parambk.DOh.getLast();
    }
    dgv localdgv2 = localdgv1;
    if (localdgv1 == null)
    {
      localdgv2 = new dgv();
      parambk.DOh.addLast(localdgv2);
    }
    localdgv2.FPY.addLast(parambj);
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
    dgv localdgv = null;
    if (!parambk.DOh.isEmpty()) {
      localdgv = (dgv)parambk.DOh.getLast();
    }
    if ((localdgv != null) && (localdgv.FPX))
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
    if (!parambk.DOh.isEmpty()) {}
    for (parambk = (dgv)parambk.DOh.getLast();; parambk = null)
    {
      if (parambk == null)
      {
        AppMethodBeat.o(121906);
        return null;
      }
      if (parambk.FPY.isEmpty())
      {
        AppMethodBeat.o(121906);
        return null;
      }
      parambk = (bj)parambk.FPY.getLast();
      AppMethodBeat.o(121906);
      return parambk;
    }
  }
  
  static com.tencent.mm.vending.j.c<Integer, Integer> c(bk parambk, bj parambj)
  {
    AppMethodBeat.i(121907);
    parambk = a(parambk, parambj.DOc.activityName);
    AppMethodBeat.o(121907);
    return parambk;
  }
  
  public static com.tencent.mm.vending.j.c<bk, bj> ciX()
  {
    AppMethodBeat.i(121909);
    Object localObject = c.ciP();
    localObject = a.L(localObject, e((bk)localObject));
    AppMethodBeat.o(121909);
    return localObject;
  }
  
  static LinkedList<dgv> d(bk parambk)
  {
    if (parambk == null) {
      return null;
    }
    return parambk.DOh;
  }
  
  public static bj e(bk parambk)
  {
    AppMethodBeat.i(121910);
    if (parambk == null)
    {
      AppMethodBeat.o(121910);
      return null;
    }
    if (!parambk.DOh.isEmpty()) {}
    for (parambk = (dgv)parambk.DOh.getLast();; parambk = null)
    {
      if (parambk == null)
      {
        AppMethodBeat.o(121910);
        return null;
      }
      if (parambk.FPY.isEmpty())
      {
        AppMethodBeat.o(121910);
        return null;
      }
      parambk = (bj)parambk.FPY.getLast();
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
    dgv localdgv = (dgv)parambk.DOh.getLast();
    int i = localdgv.FPY.size();
    if ((paramInt < 0) || (paramInt >= i))
    {
      AppMethodBeat.o(121903);
      return;
    }
    i -= 1;
    while (i >= paramInt)
    {
      bj localbj = (bj)localdgv.FPY.remove(i);
      if (this.qjp != null)
      {
        localbj.DOc.timestamp = parambj.DOc.timestamp;
        this.qjp.c(localbj, parambj);
      }
      i -= 1;
    }
    a(parambk, localdgv);
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
    int i = parambk.DOh.size();
    if ((paramInt < 0) || (paramInt >= i))
    {
      AppMethodBeat.o(121904);
      return;
    }
    i -= 1;
    while (i >= paramInt)
    {
      Iterator localIterator = ((dgv)parambk.DOh.remove(i)).FPY.iterator();
      while (localIterator.hasNext())
      {
        bj localbj = (bj)localIterator.next();
        if (this.qjp != null)
        {
          localbj.DOc.timestamp = parambj.DOc.timestamp;
          this.qjp.c(localbj, parambj);
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