package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.mm.model.q;
import com.tencent.mm.pluginsdk.model.h;
import com.tencent.mm.pluginsdk.model.h.a;
import com.tencent.mm.pluginsdk.model.n;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.Iterator;

public final class b
{
  public static void a(c paramc, h.a parama)
  {
    if (!q.Gv()) {}
    ArrayList localArrayList;
    do
    {
      do
      {
        return;
      } while ((paramc == null) || (paramc.size() <= 0) || (parama == null));
      localArrayList = new ArrayList();
      Iterator localIterator = paramc.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (f)localIterator.next();
        if ((localObject != null) && (((f)localObject).iVT != f.a.iWc))
        {
          localObject = ((f)localObject).iVU;
          boolean bool1 = e.b((vn)localObject);
          boolean bool2 = e.a((vn)localObject);
          if ((!bool1) && (!bool2))
          {
            localArrayList.add(((vn)localObject).syc);
            localObject = paramc.Ao(((vn)localObject).syc);
            if (localObject != null) {
              ((ar)localObject).uAO = 11;
            }
          }
        }
      }
      paramc = ae.getContext();
    } while (localArrayList.size() <= 0);
    h.a(paramc, (String[])localArrayList.toArray(new String[localArrayList.size()]), parama);
  }
  
  public static void a(ArrayList<n> paramArrayList, c paramc)
  {
    if (!q.Gv()) {}
    while ((paramc == null) || (paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return;
    }
    paramArrayList = paramArrayList.iterator();
    label27:
    label177:
    label180:
    for (;;)
    {
      ar localar;
      if (paramArrayList.hasNext())
      {
        n localn = (n)paramArrayList.next();
        if (localn == null) {
          continue;
        }
        localar = paramc.Ao(localn.bJd);
        if (localar == null) {
          continue;
        }
        if (localn.rTC == 10232)
        {
          localar.uAQ = localn.rTz;
          localar.uAO = 12;
          i = localar.uAM;
          if ((pR(i)) || (pS(i))) {
            continue;
          }
          localar.Fo(4);
          continue;
        }
        localar.uAO = 10;
        localar.uAP = localn.rTC;
        i = localar.uAM;
        if ((pR(i)) || (pS(i))) {
          continue;
        }
        if (i != 3) {
          break label177;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label180;
        }
        localar.Fo(10);
        break label27;
        break;
      }
    }
  }
  
  private static boolean pR(int paramInt)
  {
    return paramInt == 7;
  }
  
  private static boolean pS(int paramInt)
  {
    return paramInt == 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.b
 * JD-Core Version:    0.7.0.1
 */