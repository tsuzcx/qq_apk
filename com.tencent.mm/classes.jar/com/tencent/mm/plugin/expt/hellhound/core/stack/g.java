package com.tencent.mm.plugin.expt.hellhound.core.stack;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bn;
import com.tencent.mm.protocal.protobuf.bo;
import com.tencent.mm.protocal.protobuf.egw;
import com.tencent.mm.protocal.protobuf.eih;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.b;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
{
  public f szE;
  
  public static com.tencent.mm.vending.j.c<egw, Integer> a(bo parambo, bn parambn)
  {
    AppMethodBeat.i(121899);
    if ((parambo == null) || (parambo.KFn.isEmpty()))
    {
      AppMethodBeat.o(121899);
      return null;
    }
    int i = parambo.KFn.size() - 1;
    while (i >= 0)
    {
      egw localegw = (egw)parambo.KFn.get(i);
      if ((localegw != null) && (!localegw.NgI.isEmpty()))
      {
        int j = localegw.NgI.size() - 1;
        while (j >= 0)
        {
          bn localbn = (bn)localegw.NgI.get(j);
          if ((localbn != null) && (h.a(parambn.KFh, localbn.KFh)))
          {
            parambo = a.Q(localegw, Integer.valueOf(i));
            AppMethodBeat.o(121899);
            return parambo;
          }
          j -= 1;
        }
      }
      i -= 1;
    }
    AppMethodBeat.o(121899);
    return null;
  }
  
  static com.tencent.mm.vending.j.c<Integer, Integer> a(bo parambo, String paramString)
  {
    AppMethodBeat.i(220423);
    if (TextUtils.isEmpty(paramString))
    {
      parambo = a.Q(Integer.valueOf(-1), Integer.valueOf(-1));
      AppMethodBeat.o(220423);
      return parambo;
    }
    if (parambo == null)
    {
      parambo = com.tencent.mm.vending.j.c.Q(Integer.valueOf(-1), Integer.valueOf(-1));
      AppMethodBeat.o(220423);
      return parambo;
    }
    int i = parambo.KFn.size();
    if (i <= 0)
    {
      parambo = com.tencent.mm.vending.j.c.Q(Integer.valueOf(-1), Integer.valueOf(-1));
      AppMethodBeat.o(220423);
      return parambo;
    }
    i -= 1;
    int k = -1;
    int j = -1;
    int m;
    if (i >= 0)
    {
      egw localegw = (egw)parambo.KFn.get(i);
      m = localegw.NgI.size() - 1;
      label123:
      if (m < 0) {
        break label220;
      }
      if (paramString.equals(((bn)localegw.NgI.get(m)).KFh.activityName))
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
        parambo = com.tencent.mm.vending.j.c.Q(Integer.valueOf(-1), Integer.valueOf(-1));
        AppMethodBeat.o(220423);
        return parambo;
      }
      parambo = a.Q(Integer.valueOf(j), Integer.valueOf(k));
      AppMethodBeat.o(220423);
      return parambo;
    }
  }
  
  static void a(bo parambo, bn parambn, boolean paramBoolean)
  {
    AppMethodBeat.i(121901);
    egw localegw = new egw();
    localegw.NgH = paramBoolean;
    localegw.NgI.addLast(parambn);
    parambn = parambo;
    if (parambo == null) {
      parambn = new bo();
    }
    parambn.KFn.addLast(localegw);
    AppMethodBeat.o(121901);
  }
  
  private static void a(bo parambo, egw paramegw)
  {
    AppMethodBeat.i(121905);
    if ((paramegw.NgI.isEmpty()) && (!parambo.KFn.isEmpty())) {
      parambo.KFn.removeLast();
    }
    AppMethodBeat.o(121905);
  }
  
  public static bn apc(String paramString)
  {
    AppMethodBeat.i(121911);
    bo localbo = c.cNK();
    paramString = a(localbo, paramString);
    int i = ((Integer)paramString.get(0)).intValue();
    int j = ((Integer)paramString.get(1)).intValue();
    if ((i < 0) || (j < 0))
    {
      AppMethodBeat.o(121911);
      return null;
    }
    paramString = (bn)((egw)localbo.KFn.get(i)).NgI.get(j);
    AppMethodBeat.o(121911);
    return paramString;
  }
  
  static void b(bo parambo, bn parambn)
  {
    AppMethodBeat.i(121900);
    egw localegw1 = null;
    if (!parambo.KFn.isEmpty()) {
      localegw1 = (egw)parambo.KFn.getLast();
    }
    egw localegw2 = localegw1;
    if (localegw1 == null)
    {
      localegw2 = new egw();
      parambo.KFn.addLast(localegw2);
    }
    localegw2.NgI.addLast(parambn);
    AppMethodBeat.o(121900);
  }
  
  static boolean b(bo parambo)
  {
    AppMethodBeat.i(121902);
    if (parambo == null)
    {
      AppMethodBeat.o(121902);
      return false;
    }
    egw localegw = null;
    if (!parambo.KFn.isEmpty()) {
      localegw = (egw)parambo.KFn.getLast();
    }
    if ((localegw != null) && (localegw.NgH))
    {
      AppMethodBeat.o(121902);
      return true;
    }
    AppMethodBeat.o(121902);
    return false;
  }
  
  static bn c(bo parambo)
  {
    AppMethodBeat.i(121906);
    if (parambo == null)
    {
      AppMethodBeat.o(121906);
      return null;
    }
    if (!parambo.KFn.isEmpty()) {}
    for (parambo = (egw)parambo.KFn.getLast();; parambo = null)
    {
      if (parambo == null)
      {
        AppMethodBeat.o(121906);
        return null;
      }
      if (parambo.NgI.isEmpty())
      {
        AppMethodBeat.o(121906);
        return null;
      }
      parambo = (bn)parambo.NgI.getLast();
      AppMethodBeat.o(121906);
      return parambo;
    }
  }
  
  static com.tencent.mm.vending.j.c<Integer, Integer> c(bo parambo, bn parambn)
  {
    AppMethodBeat.i(121907);
    parambo = a(parambo, parambn.KFh.activityName);
    AppMethodBeat.o(121907);
    return parambo;
  }
  
  public static com.tencent.mm.vending.j.c<bo, bn> cNS()
  {
    AppMethodBeat.i(121909);
    Object localObject = c.cNK();
    localObject = a.Q(localObject, e((bo)localObject));
    AppMethodBeat.o(121909);
    return localObject;
  }
  
  static LinkedList<egw> d(bo parambo)
  {
    if (parambo == null) {
      return null;
    }
    return parambo.KFn;
  }
  
  public static bn e(bo parambo)
  {
    AppMethodBeat.i(121910);
    if (parambo == null)
    {
      AppMethodBeat.o(121910);
      return null;
    }
    if (!parambo.KFn.isEmpty()) {}
    for (parambo = (egw)parambo.KFn.getLast();; parambo = null)
    {
      if (parambo == null)
      {
        AppMethodBeat.o(121910);
        return null;
      }
      if (parambo.NgI.isEmpty())
      {
        AppMethodBeat.o(121910);
        return null;
      }
      parambo = (bn)parambo.NgI.getLast();
      AppMethodBeat.o(121910);
      return parambo;
    }
  }
  
  final void a(bo parambo, int paramInt, bn parambn)
  {
    AppMethodBeat.i(121903);
    if (parambo == null)
    {
      AppMethodBeat.o(121903);
      return;
    }
    egw localegw = (egw)parambo.KFn.getLast();
    int i = localegw.NgI.size();
    if ((paramInt < 0) || (paramInt >= i))
    {
      AppMethodBeat.o(121903);
      return;
    }
    i -= 1;
    while (i >= paramInt)
    {
      bn localbn = (bn)localegw.NgI.remove(i);
      if (this.szE != null)
      {
        localbn.KFh.timestamp = parambn.KFh.timestamp;
        this.szE.c(localbn, parambn);
      }
      i -= 1;
    }
    a(parambo, localegw);
    AppMethodBeat.o(121903);
  }
  
  final void b(bo parambo, int paramInt, bn parambn)
  {
    AppMethodBeat.i(121904);
    if (parambo == null)
    {
      AppMethodBeat.o(121904);
      return;
    }
    int i = parambo.KFn.size();
    if ((paramInt < 0) || (paramInt >= i))
    {
      AppMethodBeat.o(121904);
      return;
    }
    i -= 1;
    while (i >= paramInt)
    {
      Iterator localIterator = ((egw)parambo.KFn.remove(i)).NgI.iterator();
      while (localIterator.hasNext())
      {
        bn localbn = (bn)localIterator.next();
        if (this.szE != null)
        {
          localbn.KFh.timestamp = parambn.KFh.timestamp;
          this.szE.c(localbn, parambn);
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