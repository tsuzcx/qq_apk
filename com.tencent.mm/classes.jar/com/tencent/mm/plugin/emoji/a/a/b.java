package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.pluginsdk.model.m.a;
import com.tencent.mm.pluginsdk.model.u;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.bh;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

public final class b
{
  private static boolean Jy(int paramInt)
  {
    return paramInt == 7;
  }
  
  private static boolean Jz(int paramInt)
  {
    return paramInt == 6;
  }
  
  public static void a(c paramc, m.a parama)
  {
    AppMethodBeat.i(108350);
    if (!z.bdp())
    {
      AppMethodBeat.o(108350);
      return;
    }
    if ((paramc == null) || (paramc.size() <= 0))
    {
      AppMethodBeat.o(108350);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramc.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (f)localIterator.next();
      if ((localObject != null) && (((f)localObject).uAZ != f.a.uBi))
      {
        localObject = ((f)localObject).uBa;
        boolean bool1 = e.b((akh)localObject);
        boolean bool2 = e.a((akh)localObject);
        if ((!bool1) && (!bool2))
        {
          localArrayList.add(((akh)localObject).ProductID);
          localObject = paramc.atY(((akh)localObject).ProductID);
          if (localObject != null) {
            ((bh)localObject).VFq = 11;
          }
        }
      }
    }
    paramc = MMApplicationContext.getContext();
    if (localArrayList.size() > 0) {
      m.a(paramc, (String[])localArrayList.toArray(new String[localArrayList.size()]), parama);
    }
    AppMethodBeat.o(108350);
  }
  
  public static void a(ArrayList<u> paramArrayList, c paramc)
  {
    AppMethodBeat.i(108351);
    if (!z.bdp())
    {
      AppMethodBeat.o(108351);
      return;
    }
    if ((paramc == null) || (paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      AppMethodBeat.o(108351);
      return;
    }
    paramArrayList = paramArrayList.iterator();
    label251:
    while (paramArrayList.hasNext())
    {
      u localu = (u)paramArrayList.next();
      if (localu != null)
      {
        Log.i("MicroMsg.EmojiGoogleMarketTool", "endSeachGoogleMarket: %s", new Object[] { localu });
        bh localbh = paramc.atY(localu.productId);
        if (localbh != null)
        {
          int i;
          if (localu.QVB == 10232)
          {
            localbh.VFu = localu.QVy;
            localbh.VFs = localu.QVz;
            localbh.VFt = new BigDecimal(localu.QVA).divide(new BigDecimal(1000000)).toString();
            localbh.VFq = 12;
            i = localbh.VFo;
            if ((!Jy(i)) && (!Jz(i))) {
              localbh.asG(4);
            }
          }
          else
          {
            localbh.VFq = 10;
            localbh.VFr = localu.QVB;
            i = localbh.VFo;
            if ((!Jy(i)) && (!Jz(i)))
            {
              if (i == 3) {}
              for (i = 1;; i = 0)
              {
                if (i != 0) {
                  break label251;
                }
                localbh.asG(10);
                break;
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(108351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.b
 * JD-Core Version:    0.7.0.1
 */