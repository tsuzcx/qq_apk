package com.tencent.mm.plugin.expt.hellhound.core.stack;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bh;
import com.tencent.mm.protocal.protobuf.bi;
import com.tencent.mm.protocal.protobuf.dbj;
import com.tencent.mm.protocal.protobuf.dcm;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.b;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
{
  public f pEC;
  
  public static bh VQ(String paramString)
  {
    AppMethodBeat.i(121911);
    bi localbi = c.cbE();
    paramString = a(localbi, paramString);
    int i = ((Integer)paramString.get(0)).intValue();
    int j = ((Integer)paramString.get(1)).intValue();
    if ((i < 0) || (j < 0))
    {
      AppMethodBeat.o(121911);
      return null;
    }
    paramString = (bh)((dbj)localbi.CvM.get(i)).EsW.get(j);
    AppMethodBeat.o(121911);
    return paramString;
  }
  
  public static com.tencent.mm.vending.j.c<dbj, Integer> a(bi parambi, bh parambh)
  {
    AppMethodBeat.i(121899);
    if ((parambi == null) || (parambi.CvM.isEmpty()))
    {
      AppMethodBeat.o(121899);
      return null;
    }
    int i = parambi.CvM.size() - 1;
    while (i >= 0)
    {
      dbj localdbj = (dbj)parambi.CvM.get(i);
      if ((localdbj != null) && (!localdbj.EsW.isEmpty()))
      {
        int j = localdbj.EsW.size() - 1;
        while (j >= 0)
        {
          bh localbh = (bh)localdbj.EsW.get(j);
          if ((localbh != null) && (h.a(parambh.CvH, localbh.CvH)))
          {
            parambi = a.L(localdbj, Integer.valueOf(i));
            AppMethodBeat.o(121899);
            return parambi;
          }
          j -= 1;
        }
      }
      i -= 1;
    }
    AppMethodBeat.o(121899);
    return null;
  }
  
  static com.tencent.mm.vending.j.c<Integer, Integer> a(bi parambi, String paramString)
  {
    AppMethodBeat.i(121908);
    if (TextUtils.isEmpty(paramString))
    {
      parambi = a.L(Integer.valueOf(-1), Integer.valueOf(-1));
      AppMethodBeat.o(121908);
      return parambi;
    }
    if (parambi == null)
    {
      parambi = com.tencent.mm.vending.j.c.L(Integer.valueOf(-1), Integer.valueOf(-1));
      AppMethodBeat.o(121908);
      return parambi;
    }
    int i = parambi.CvM.size();
    if (i <= 0)
    {
      parambi = com.tencent.mm.vending.j.c.L(Integer.valueOf(-1), Integer.valueOf(-1));
      AppMethodBeat.o(121908);
      return parambi;
    }
    i -= 1;
    int k = -1;
    int j = -1;
    int m;
    if (i >= 0)
    {
      dbj localdbj = (dbj)parambi.CvM.get(i);
      m = localdbj.EsW.size() - 1;
      label123:
      if (m < 0) {
        break label220;
      }
      if (paramString.equals(((bh)localdbj.EsW.get(m)).CvH.activityName))
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
        parambi = com.tencent.mm.vending.j.c.L(Integer.valueOf(-1), Integer.valueOf(-1));
        AppMethodBeat.o(121908);
        return parambi;
      }
      parambi = a.L(Integer.valueOf(j), Integer.valueOf(k));
      AppMethodBeat.o(121908);
      return parambi;
    }
  }
  
  static void a(bi parambi, bh parambh, boolean paramBoolean)
  {
    AppMethodBeat.i(121901);
    dbj localdbj = new dbj();
    localdbj.EsV = paramBoolean;
    localdbj.EsW.addLast(parambh);
    parambh = parambi;
    if (parambi == null) {
      parambh = new bi();
    }
    parambh.CvM.addLast(localdbj);
    AppMethodBeat.o(121901);
  }
  
  private static void a(bi parambi, dbj paramdbj)
  {
    AppMethodBeat.i(121905);
    if ((paramdbj.EsW.isEmpty()) && (!parambi.CvM.isEmpty())) {
      parambi.CvM.removeLast();
    }
    AppMethodBeat.o(121905);
  }
  
  static void b(bi parambi, bh parambh)
  {
    AppMethodBeat.i(121900);
    dbj localdbj1 = null;
    if (!parambi.CvM.isEmpty()) {
      localdbj1 = (dbj)parambi.CvM.getLast();
    }
    dbj localdbj2 = localdbj1;
    if (localdbj1 == null)
    {
      localdbj2 = new dbj();
      parambi.CvM.addLast(localdbj2);
    }
    localdbj2.EsW.addLast(parambh);
    AppMethodBeat.o(121900);
  }
  
  static boolean b(bi parambi)
  {
    AppMethodBeat.i(121902);
    if (parambi == null)
    {
      AppMethodBeat.o(121902);
      return false;
    }
    dbj localdbj = null;
    if (!parambi.CvM.isEmpty()) {
      localdbj = (dbj)parambi.CvM.getLast();
    }
    if ((localdbj != null) && (localdbj.EsV))
    {
      AppMethodBeat.o(121902);
      return true;
    }
    AppMethodBeat.o(121902);
    return false;
  }
  
  static bh c(bi parambi)
  {
    AppMethodBeat.i(121906);
    if (parambi == null)
    {
      AppMethodBeat.o(121906);
      return null;
    }
    if (!parambi.CvM.isEmpty()) {}
    for (parambi = (dbj)parambi.CvM.getLast();; parambi = null)
    {
      if (parambi == null)
      {
        AppMethodBeat.o(121906);
        return null;
      }
      if (parambi.EsW.isEmpty())
      {
        AppMethodBeat.o(121906);
        return null;
      }
      parambi = (bh)parambi.EsW.getLast();
      AppMethodBeat.o(121906);
      return parambi;
    }
  }
  
  static com.tencent.mm.vending.j.c<Integer, Integer> c(bi parambi, bh parambh)
  {
    AppMethodBeat.i(121907);
    parambi = a(parambi, parambh.CvH.activityName);
    AppMethodBeat.o(121907);
    return parambi;
  }
  
  public static com.tencent.mm.vending.j.c<bi, bh> cbM()
  {
    AppMethodBeat.i(121909);
    Object localObject = c.cbE();
    localObject = a.L(localObject, e((bi)localObject));
    AppMethodBeat.o(121909);
    return localObject;
  }
  
  static LinkedList<dbj> d(bi parambi)
  {
    if (parambi == null) {
      return null;
    }
    return parambi.CvM;
  }
  
  public static bh e(bi parambi)
  {
    AppMethodBeat.i(121910);
    if (parambi == null)
    {
      AppMethodBeat.o(121910);
      return null;
    }
    if (!parambi.CvM.isEmpty()) {}
    for (parambi = (dbj)parambi.CvM.getLast();; parambi = null)
    {
      if (parambi == null)
      {
        AppMethodBeat.o(121910);
        return null;
      }
      if (parambi.EsW.isEmpty())
      {
        AppMethodBeat.o(121910);
        return null;
      }
      parambi = (bh)parambi.EsW.getLast();
      AppMethodBeat.o(121910);
      return parambi;
    }
  }
  
  final void a(bi parambi, int paramInt, bh parambh)
  {
    AppMethodBeat.i(121903);
    if (parambi == null)
    {
      AppMethodBeat.o(121903);
      return;
    }
    dbj localdbj = (dbj)parambi.CvM.getLast();
    int i = localdbj.EsW.size();
    if ((paramInt < 0) || (paramInt >= i))
    {
      AppMethodBeat.o(121903);
      return;
    }
    i -= 1;
    while (i >= paramInt)
    {
      bh localbh = (bh)localdbj.EsW.remove(i);
      if (this.pEC != null)
      {
        localbh.CvH.timestamp = parambh.CvH.timestamp;
        this.pEC.c(localbh, parambh);
      }
      i -= 1;
    }
    a(parambi, localdbj);
    AppMethodBeat.o(121903);
  }
  
  final void b(bi parambi, int paramInt, bh parambh)
  {
    AppMethodBeat.i(121904);
    if (parambi == null)
    {
      AppMethodBeat.o(121904);
      return;
    }
    int i = parambi.CvM.size();
    if ((paramInt < 0) || (paramInt >= i))
    {
      AppMethodBeat.o(121904);
      return;
    }
    i -= 1;
    while (i >= paramInt)
    {
      Iterator localIterator = ((dbj)parambi.CvM.remove(i)).EsW.iterator();
      while (localIterator.hasNext())
      {
        bh localbh = (bh)localIterator.next();
        if (this.pEC != null)
        {
          localbh.CvH.timestamp = parambh.CvH.timestamp;
          this.pEC.c(localbh, parambh);
        }
      }
      i -= 1;
    }
    AppMethodBeat.o(121904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.stack.g
 * JD-Core Version:    0.7.0.1
 */