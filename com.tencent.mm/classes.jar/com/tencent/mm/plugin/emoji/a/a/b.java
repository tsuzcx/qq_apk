package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.model.o.a;
import com.tencent.mm.pluginsdk.model.w;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.bj;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

public final class b
{
  private static boolean Kg(int paramInt)
  {
    return paramInt == 7;
  }
  
  private static boolean Kh(int paramInt)
  {
    return paramInt == 6;
  }
  
  public static void a(c paramc, o.a parama)
  {
    AppMethodBeat.i(108350);
    if (!z.bBh())
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
      if ((localObject != null) && (((f)localObject).xHD != f.a.xHN))
      {
        localObject = ((f)localObject).xHE;
        boolean bool1 = e.b((cjb)localObject);
        boolean bool2 = e.a((cjb)localObject);
        if ((!bool1) && (!bool2))
        {
          localArrayList.add(((cjb)localObject).ProductID);
          localObject = paramc.anQ(((cjb)localObject).ProductID);
          if (localObject != null) {
            ((bj)localObject).adjd = 11;
          }
        }
      }
    }
    paramc = MMApplicationContext.getContext();
    if (localArrayList.size() > 0) {
      o.a(paramc, (String[])localArrayList.toArray(new String[localArrayList.size()]), parama);
    }
    AppMethodBeat.o(108350);
  }
  
  public static void a(ArrayList<w> paramArrayList, c paramc)
  {
    AppMethodBeat.i(108351);
    if (!z.bBh())
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
      w localw = (w)paramArrayList.next();
      if (localw != null)
      {
        Log.i("MicroMsg.EmojiGoogleMarketTool", "endSeachGoogleMarket: %s", new Object[] { localw });
        bj localbj = paramc.anQ(localw.productId);
        if (localbj != null)
        {
          int i;
          if (localw.XRy == 10232)
          {
            localbj.adjh = localw.XRv;
            localbj.adjf = localw.XRw;
            localbj.adjg = new BigDecimal(localw.XRx).divide(new BigDecimal(1000000)).toString();
            localbj.adjd = 12;
            i = localbj.adjb;
            if ((!Kg(i)) && (!Kh(i))) {
              localbj.ayW(4);
            }
          }
          else
          {
            localbj.adjd = 10;
            localbj.adje = localw.XRy;
            i = localbj.adjb;
            if ((!Kg(i)) && (!Kh(i)))
            {
              if (i == 3) {}
              for (i = 1;; i = 0)
              {
                if (i != 0) {
                  break label251;
                }
                localbj.ayW(10);
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