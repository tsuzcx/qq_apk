package com.tencent.mm.plugin.clean.c;

import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public final class f
  extends Thread
{
  private h iBO;
  private HashSet<String> iBT;
  private int iBy = 0;
  private int iBz = 0;
  private boolean isStop = false;
  
  public f(HashSet<String> paramHashSet, h paramh)
  {
    this.iBT = paramHashSet;
    this.iBO = paramh;
  }
  
  private int a(b paramb, PInt paramPInt, PLong paramPLong)
  {
    int j = 0;
    int i = paramPInt.value;
    Object localObject;
    if (paramb != null)
    {
      localObject = j.n(paramb.cLr());
      y.d("MicroMsg.DeleteOtherAccController", "delete [%d] [%s]", new Object[] { Integer.valueOf(i), localObject });
      if (paramPInt.value < 10) {
        break label80;
      }
      if (!this.isStop) {
        break label75;
      }
      i = -1;
    }
    label75:
    label80:
    do
    {
      do
      {
        return i;
        localObject = "null";
        break;
        paramPInt.value = 0;
        i = j;
      } while (paramb == null);
      i = j;
    } while (!paramb.exists());
    if (paramb.isDirectory())
    {
      localObject = paramb.cLt();
      if (localObject != null)
      {
        i = 0;
        while (i < localObject.length)
        {
          if (a(localObject[i], paramPInt, paramPLong) == -1) {
            return -1;
          }
          i += 1;
        }
      }
      paramb.delete();
    }
    for (;;)
    {
      return 1;
      paramPLong.value += paramb.length();
      paramb.delete();
      paramPInt.value += 1;
    }
  }
  
  private void aEa()
  {
    if (this.isStop) {
      return;
    }
    ai.d(new f.1(this));
  }
  
  private static void c(String paramString, ArrayList<String> paramArrayList)
  {
    if (bk.bl(paramString)) {}
    for (;;)
    {
      return;
      y.i("MicroMsg.DeleteOtherAccController", "check paths [%s]", new Object[] { paramString });
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
            y.d("MicroMsg.DeleteOtherAccController", "check add path[%s]", new Object[] { str });
            paramArrayList.add(str);
            i += 1;
          }
        }
      }
    }
  }
  
  private void cY(long paramLong)
  {
    if (this.isStop) {
      return;
    }
    ai.d(new f.2(this, paramLong));
  }
  
  public final void run()
  {
    if ((this.iBT == null) || (this.iBT.isEmpty()))
    {
      y.w("MicroMsg.DeleteOtherAccController", "delete paths is null.");
      cY(0L);
      return;
    }
    Object localObject1 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = new StringBuilder("mm");
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DN();
    localObject2 = com.tencent.mm.a.g.o(a.CK().getBytes());
    Object localObject3 = this.iBT.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (String)((Iterator)localObject3).next();
      y.i("MicroMsg.DeleteOtherAccController", "uinPath[%s] path[%s]", new Object[] { localObject2, localObject4 });
      if (!bk.isEqual((String)localObject2, (String)localObject4))
      {
        c(com.tencent.mm.kernel.g.DP().dKs + (String)localObject4, (ArrayList)localObject1);
        c(ac.dOP + (String)localObject4, localArrayList);
      }
    }
    this.iBy = (((ArrayList)localObject1).size() + localArrayList.size());
    this.iBz = 0;
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
      y.i("MicroMsg.DeleteOtherAccController", "ready to delete index[%d] path[%s] pDelete[%d]", new Object[] { Integer.valueOf(i), str, Integer.valueOf(((PInt)localObject4).value) });
      if (a(new b(str), (PInt)localObject4, (PLong)localObject2) == -1) {
        break;
      }
      this.iBz += 1;
      aEa();
    }
    j = localArrayList.size();
    localObject1 = new PInt();
    i = 0;
    while ((!this.isStop) && (i < j))
    {
      ((PInt)localObject1).value = 0;
      localObject4 = (String)localArrayList.get(i);
      i += 1;
      y.i("MicroMsg.DeleteOtherAccController", "ready to delete index[%d] path[%s] pDelete[%d]", new Object[] { Integer.valueOf(i), localObject4, Integer.valueOf(((PInt)localObject1).value) });
      if (a(new b((String)localObject4), (PInt)localObject1, (PLong)localObject3) == -1) {
        break;
      }
      this.iBz += 1;
      aEa();
    }
    y.i("MicroMsg.DeleteOtherAccController", "delete finish sd[%d] data[%d]", new Object[] { Long.valueOf(((PLong)localObject2).value), Long.valueOf(((PLong)localObject3).value) });
    cY(((PLong)localObject2).value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.f
 * JD-Core Version:    0.7.0.1
 */