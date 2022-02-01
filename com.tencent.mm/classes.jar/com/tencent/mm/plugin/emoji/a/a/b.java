package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.pluginsdk.model.j.a;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.au;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

public final class b
{
  private static boolean Av(int paramInt)
  {
    return paramInt == 7;
  }
  
  private static boolean Aw(int paramInt)
  {
    return paramInt == 6;
  }
  
  public static void a(c paramc, j.a parama)
  {
    AppMethodBeat.i(108350);
    if (!u.aqU())
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
      if ((localObject != null) && (((f)localObject).ouK != f.a.ouT))
      {
        localObject = ((f)localObject).ouL;
        boolean bool1 = e.b((EmotionSummary)localObject);
        boolean bool2 = e.a((EmotionSummary)localObject);
        if ((!bool1) && (!bool2))
        {
          localArrayList.add(((EmotionSummary)localObject).ProductID);
          localObject = paramc.Ts(((EmotionSummary)localObject).ProductID);
          if (localObject != null) {
            ((au)localObject).FyI = 11;
          }
        }
      }
    }
    paramc = aj.getContext();
    if (localArrayList.size() > 0) {
      j.a(paramc, (String[])localArrayList.toArray(new String[localArrayList.size()]), parama);
    }
    AppMethodBeat.o(108350);
  }
  
  public static void a(ArrayList<p> paramArrayList, c paramc)
  {
    AppMethodBeat.i(108351);
    if (!u.aqU())
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
      p localp = (p)paramArrayList.next();
      if (localp != null)
      {
        ad.i("MicroMsg.EmojiGoogleMarketTool", "endSeachGoogleMarket: %s", new Object[] { localp });
        au localau = paramc.Ts(localp.dft);
        if (localau != null)
        {
          int i;
          if (localp.BPd == 10232)
          {
            localau.FyM = localp.BPa;
            localau.FyK = localp.BPb;
            localau.FyL = new BigDecimal(localp.BPc).divide(new BigDecimal(1000000)).toString();
            localau.FyI = 12;
            i = localau.FyG;
            if ((!Av(i)) && (!Aw(i))) {
              localau.WA(4);
            }
          }
          else
          {
            localau.FyI = 10;
            localau.FyJ = localp.BPd;
            i = localau.FyG;
            if ((!Av(i)) && (!Aw(i)))
            {
              if (i == 3) {}
              for (i = 1;; i = 0)
              {
                if (i != 0) {
                  break label251;
                }
                localau.WA(10);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.b
 * JD-Core Version:    0.7.0.1
 */