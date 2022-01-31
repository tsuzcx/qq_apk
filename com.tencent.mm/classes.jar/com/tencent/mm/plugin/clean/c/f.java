package com.tencent.mm.plugin.clean.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public final class f
  extends Thread
{
  private boolean isStop = false;
  private int kGF = 0;
  private int kGG = 0;
  private h kGV;
  private HashSet<String> kHa;
  
  public f(HashSet<String> paramHashSet, h paramh)
  {
    this.kHa = paramHashSet;
    this.kGV = paramh;
  }
  
  private int a(b paramb, PInt paramPInt, PLong paramPLong)
  {
    AppMethodBeat.i(18714);
    int i = paramPInt.value;
    if (paramb != null) {}
    for (Object localObject = j.p(paramb.dQJ());; localObject = "null")
    {
      ab.d("MicroMsg.DeleteOtherAccController", "delete [%d] [%s]", new Object[] { Integer.valueOf(i), localObject });
      if (paramPInt.value < 10) {
        break label85;
      }
      if (!this.isStop) {
        break;
      }
      AppMethodBeat.o(18714);
      return -1;
    }
    paramPInt.value = 0;
    label85:
    if ((paramb == null) || (!paramb.exists()))
    {
      AppMethodBeat.o(18714);
      return 0;
    }
    if (paramb.isDirectory())
    {
      localObject = paramb.dQL();
      if (localObject != null)
      {
        i = 0;
        while (i < localObject.length)
        {
          if (a(localObject[i], paramPInt, paramPLong) == -1)
          {
            AppMethodBeat.o(18714);
            return -1;
          }
          i += 1;
        }
      }
      paramb.delete();
    }
    for (;;)
    {
      AppMethodBeat.o(18714);
      return 1;
      paramPLong.value += paramb.length();
      paramb.delete();
      paramPInt.value += 1;
    }
  }
  
  private void bha()
  {
    AppMethodBeat.i(18712);
    if (this.isStop)
    {
      AppMethodBeat.o(18712);
      return;
    }
    al.d(new f.1(this));
    AppMethodBeat.o(18712);
  }
  
  private static void e(String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(18711);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(18711);
      return;
    }
    ab.i("MicroMsg.DeleteOtherAccController", "check paths [%s]", new Object[] { paramString });
    Object localObject = new b(paramString);
    if ((((b)localObject).exists()) && (((b)localObject).isDirectory()))
    {
      localObject = ((b)localObject).list();
      if ((localObject != null) && (localObject.length > 0))
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          String str = localObject[i];
          str = paramString + "/" + str;
          ab.d("MicroMsg.DeleteOtherAccController", "check add path[%s]", new Object[] { str });
          paramArrayList.add(str);
          i += 1;
        }
      }
    }
    AppMethodBeat.o(18711);
  }
  
  private void iu(long paramLong)
  {
    AppMethodBeat.i(18713);
    if (this.isStop)
    {
      AppMethodBeat.o(18713);
      return;
    }
    al.d(new f.2(this, paramLong));
    AppMethodBeat.o(18713);
  }
  
  public final void run()
  {
    AppMethodBeat.i(18710);
    if ((this.kHa == null) || (this.kHa.isEmpty()))
    {
      ab.w("MicroMsg.DeleteOtherAccController", "delete paths is null.");
      iu(0L);
      AppMethodBeat.o(18710);
      return;
    }
    Object localObject1 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = new StringBuilder("mm");
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RJ();
    localObject2 = com.tencent.mm.a.g.w(a.getUin().getBytes());
    Object localObject3 = this.kHa.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (String)((Iterator)localObject3).next();
      ab.i("MicroMsg.DeleteOtherAccController", "uinPath[%s] path[%s]", new Object[] { localObject2, localObject4 });
      if (!bo.isEqual((String)localObject2, (String)localObject4))
      {
        e(com.tencent.mm.kernel.g.RL().eHQ + (String)localObject4, (ArrayList)localObject1);
        e(ac.eQv + (String)localObject4, localArrayList);
      }
    }
    this.kGF = (((ArrayList)localObject1).size() + localArrayList.size());
    this.kGG = 0;
    localObject2 = new PLong();
    localObject3 = new PLong();
    int j = ((ArrayList)localObject1).size();
    Object localObject4 = new PInt();
    int i = 0;
    while ((!this.isStop) && (i < j))
    {
      ((PInt)localObject4).value = 0;
      String str = (String)((ArrayList)localObject1).get(i);
      i += 1;
      ab.i("MicroMsg.DeleteOtherAccController", "ready to delete index[%d] path[%s] pDelete[%d]", new Object[] { Integer.valueOf(i), str, Integer.valueOf(((PInt)localObject4).value) });
      if (a(new b(str), (PInt)localObject4, (PLong)localObject2) == -1) {
        break;
      }
      this.kGG += 1;
      bha();
    }
    j = localArrayList.size();
    localObject1 = new PInt();
    i = 0;
    while ((!this.isStop) && (i < j))
    {
      ((PInt)localObject1).value = 0;
      localObject4 = (String)localArrayList.get(i);
      i += 1;
      ab.i("MicroMsg.DeleteOtherAccController", "ready to delete index[%d] path[%s] pDelete[%d]", new Object[] { Integer.valueOf(i), localObject4, Integer.valueOf(((PInt)localObject1).value) });
      if (a(new b((String)localObject4), (PInt)localObject1, (PLong)localObject3) == -1) {
        break;
      }
      this.kGG += 1;
      bha();
    }
    ab.i("MicroMsg.DeleteOtherAccController", "delete finish sd[%d] data[%d]", new Object[] { Long.valueOf(((PLong)localObject2).value), Long.valueOf(((PLong)localObject3).value) });
    iu(((PLong)localObject2).value);
    AppMethodBeat.o(18710);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.f
 * JD-Core Version:    0.7.0.1
 */