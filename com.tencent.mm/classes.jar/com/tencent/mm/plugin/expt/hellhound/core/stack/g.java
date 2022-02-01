package com.tencent.mm.plugin.expt.hellhound.core.stack;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bt;
import com.tencent.mm.protocal.protobuf.bu;
import com.tencent.mm.protocal.protobuf.fme;
import com.tencent.mm.protocal.protobuf.fns;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.b;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
{
  public f zBy;
  
  public static com.tencent.mm.vending.j.c<fme, Integer> a(bu parambu, bt parambt)
  {
    AppMethodBeat.i(121899);
    if ((parambu == null) || (parambu.YDy.isEmpty()))
    {
      AppMethodBeat.o(121899);
      return null;
    }
    int i = parambu.YDy.size() - 1;
    while (i >= 0)
    {
      fme localfme = (fme)parambu.YDy.get(i);
      if ((localfme != null) && (!localfme.abMA.isEmpty()))
      {
        int j = localfme.abMA.size() - 1;
        while (j >= 0)
        {
          bt localbt = (bt)localfme.abMA.get(j);
          if ((localbt != null) && (h.a(parambt.YDs, localbt.YDs)))
          {
            parambu = a.U(localfme, Integer.valueOf(i));
            AppMethodBeat.o(121899);
            return parambu;
          }
          j -= 1;
        }
      }
      i -= 1;
    }
    AppMethodBeat.o(121899);
    return null;
  }
  
  static com.tencent.mm.vending.j.c<Integer, Integer> a(bu parambu, String paramString)
  {
    AppMethodBeat.i(299993);
    if (TextUtils.isEmpty(paramString))
    {
      parambu = a.U(Integer.valueOf(-1), Integer.valueOf(-1));
      AppMethodBeat.o(299993);
      return parambu;
    }
    if (parambu == null)
    {
      parambu = com.tencent.mm.vending.j.c.U(Integer.valueOf(-1), Integer.valueOf(-1));
      AppMethodBeat.o(299993);
      return parambu;
    }
    int i = parambu.YDy.size();
    if (i <= 0)
    {
      parambu = com.tencent.mm.vending.j.c.U(Integer.valueOf(-1), Integer.valueOf(-1));
      AppMethodBeat.o(299993);
      return parambu;
    }
    i -= 1;
    int k = -1;
    int j = -1;
    int m;
    if (i >= 0)
    {
      fme localfme = (fme)parambu.YDy.get(i);
      m = localfme.abMA.size() - 1;
      label123:
      if (m < 0) {
        break label220;
      }
      if (paramString.equals(((bt)localfme.abMA.get(m)).YDs.AtM))
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
        parambu = com.tencent.mm.vending.j.c.U(Integer.valueOf(-1), Integer.valueOf(-1));
        AppMethodBeat.o(299993);
        return parambu;
      }
      parambu = a.U(Integer.valueOf(j), Integer.valueOf(k));
      AppMethodBeat.o(299993);
      return parambu;
    }
  }
  
  static void a(bu parambu, bt parambt, boolean paramBoolean)
  {
    AppMethodBeat.i(121901);
    fme localfme = new fme();
    localfme.abMz = paramBoolean;
    localfme.abMA.addLast(parambt);
    parambt = parambu;
    if (parambu == null) {
      parambt = new bu();
    }
    parambt.YDy.addLast(localfme);
    AppMethodBeat.o(121901);
  }
  
  private static void a(bu parambu, fme paramfme)
  {
    AppMethodBeat.i(121905);
    if ((paramfme.abMA.isEmpty()) && (!parambu.YDy.isEmpty())) {
      parambu.YDy.removeLast();
    }
    AppMethodBeat.o(121905);
  }
  
  public static bt arg(String paramString)
  {
    AppMethodBeat.i(121911);
    bu localbu = c.dJe();
    paramString = a(localbu, paramString);
    int i = ((Integer)paramString.get(0)).intValue();
    int j = ((Integer)paramString.get(1)).intValue();
    if ((i < 0) || (j < 0))
    {
      AppMethodBeat.o(121911);
      return null;
    }
    paramString = (bt)((fme)localbu.YDy.get(i)).abMA.get(j);
    AppMethodBeat.o(121911);
    return paramString;
  }
  
  static void b(bu parambu, bt parambt)
  {
    AppMethodBeat.i(121900);
    fme localfme1 = null;
    if (!parambu.YDy.isEmpty()) {
      localfme1 = (fme)parambu.YDy.getLast();
    }
    fme localfme2 = localfme1;
    if (localfme1 == null)
    {
      localfme2 = new fme();
      parambu.YDy.addLast(localfme2);
    }
    localfme2.abMA.addLast(parambt);
    AppMethodBeat.o(121900);
  }
  
  static boolean b(bu parambu)
  {
    AppMethodBeat.i(121902);
    if (parambu == null)
    {
      AppMethodBeat.o(121902);
      return false;
    }
    fme localfme = null;
    if (!parambu.YDy.isEmpty()) {
      localfme = (fme)parambu.YDy.getLast();
    }
    if ((localfme != null) && (localfme.abMz))
    {
      AppMethodBeat.o(121902);
      return true;
    }
    AppMethodBeat.o(121902);
    return false;
  }
  
  static bt c(bu parambu)
  {
    AppMethodBeat.i(121906);
    if (parambu == null)
    {
      AppMethodBeat.o(121906);
      return null;
    }
    if (!parambu.YDy.isEmpty()) {}
    for (parambu = (fme)parambu.YDy.getLast();; parambu = null)
    {
      if (parambu == null)
      {
        AppMethodBeat.o(121906);
        return null;
      }
      if (parambu.abMA.isEmpty())
      {
        AppMethodBeat.o(121906);
        return null;
      }
      parambu = (bt)parambu.abMA.getLast();
      AppMethodBeat.o(121906);
      return parambu;
    }
  }
  
  static com.tencent.mm.vending.j.c<Integer, Integer> c(bu parambu, bt parambt)
  {
    AppMethodBeat.i(121907);
    parambu = a(parambu, parambt.YDs.AtM);
    AppMethodBeat.o(121907);
    return parambu;
  }
  
  static LinkedList<fme> d(bu parambu)
  {
    if (parambu == null) {
      return null;
    }
    return parambu.YDy;
  }
  
  public static com.tencent.mm.vending.j.c<bu, bt> dJm()
  {
    AppMethodBeat.i(121909);
    Object localObject = c.dJe();
    localObject = a.U(localObject, e((bu)localObject));
    AppMethodBeat.o(121909);
    return localObject;
  }
  
  public static bt e(bu parambu)
  {
    AppMethodBeat.i(121910);
    if (parambu == null)
    {
      AppMethodBeat.o(121910);
      return null;
    }
    if (!parambu.YDy.isEmpty()) {}
    for (parambu = (fme)parambu.YDy.getLast();; parambu = null)
    {
      if (parambu == null)
      {
        AppMethodBeat.o(121910);
        return null;
      }
      if (parambu.abMA.isEmpty())
      {
        AppMethodBeat.o(121910);
        return null;
      }
      parambu = (bt)parambu.abMA.getLast();
      AppMethodBeat.o(121910);
      return parambu;
    }
  }
  
  final void a(bu parambu, int paramInt, bt parambt)
  {
    AppMethodBeat.i(121903);
    if (parambu == null)
    {
      AppMethodBeat.o(121903);
      return;
    }
    fme localfme = (fme)parambu.YDy.getLast();
    int i = localfme.abMA.size();
    if ((paramInt < 0) || (paramInt >= i))
    {
      AppMethodBeat.o(121903);
      return;
    }
    i -= 1;
    while (i >= paramInt)
    {
      bt localbt = (bt)localfme.abMA.remove(i);
      if (this.zBy != null)
      {
        localbt.YDs.timestamp = parambt.YDs.timestamp;
        this.zBy.c(localbt, parambt);
      }
      i -= 1;
    }
    a(parambu, localfme);
    AppMethodBeat.o(121903);
  }
  
  final void b(bu parambu, int paramInt, bt parambt)
  {
    AppMethodBeat.i(121904);
    if (parambu == null)
    {
      AppMethodBeat.o(121904);
      return;
    }
    int i = parambu.YDy.size();
    if ((paramInt < 0) || (paramInt >= i))
    {
      AppMethodBeat.o(121904);
      return;
    }
    i -= 1;
    while (i >= paramInt)
    {
      Iterator localIterator = ((fme)parambu.YDy.remove(i)).abMA.iterator();
      while (localIterator.hasNext())
      {
        bt localbt = (bt)localIterator.next();
        if (this.zBy != null)
        {
          localbt.YDs.timestamp = parambt.YDs.timestamp;
          this.zBy.c(localbt, parambt);
        }
      }
      i -= 1;
    }
    AppMethodBeat.o(121904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.stack.g
 * JD-Core Version:    0.7.0.1
 */