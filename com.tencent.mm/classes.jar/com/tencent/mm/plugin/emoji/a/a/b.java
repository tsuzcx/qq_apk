package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.model.h;
import com.tencent.mm.pluginsdk.model.h.a;
import com.tencent.mm.pluginsdk.model.n;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ar;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

public final class b
{
  public static void a(c paramc, h.a parama)
  {
    AppMethodBeat.i(52774);
    if (!r.ZA())
    {
      AppMethodBeat.o(52774);
      return;
    }
    if ((paramc == null) || (paramc.size() <= 0))
    {
      AppMethodBeat.o(52774);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramc.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (f)localIterator.next();
      if ((localObject != null) && (((f)localObject).leZ != f.a.lfi))
      {
        localObject = ((f)localObject).lfa;
        boolean bool1 = e.b((EmotionSummary)localObject);
        boolean bool2 = e.a((EmotionSummary)localObject);
        if ((!bool1) && (!bool2))
        {
          localArrayList.add(((EmotionSummary)localObject).ProductID);
          localObject = paramc.Km(((EmotionSummary)localObject).ProductID);
          if (localObject != null) {
            ((ar)localObject).yMX = 11;
          }
        }
      }
    }
    paramc = ah.getContext();
    if (localArrayList.size() > 0) {
      h.a(paramc, (String[])localArrayList.toArray(new String[localArrayList.size()]), parama);
    }
    AppMethodBeat.o(52774);
  }
  
  public static void a(ArrayList<n> paramArrayList, c paramc)
  {
    AppMethodBeat.i(52775);
    if (!r.ZA())
    {
      AppMethodBeat.o(52775);
      return;
    }
    if ((paramc == null) || (paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      AppMethodBeat.o(52775);
      return;
    }
    paramArrayList = paramArrayList.iterator();
    label251:
    while (paramArrayList.hasNext())
    {
      n localn = (n)paramArrayList.next();
      if (localn != null)
      {
        ab.i("MicroMsg.EmojiGoogleMarketTool", "endSeachGoogleMarket: %s", new Object[] { localn });
        ar localar = paramc.Km(localn.cqx);
        if (localar != null)
        {
          int i;
          if (localn.vKz == 10232)
          {
            localar.yNb = localn.vKw;
            localar.yMZ = localn.vKx;
            localar.yNa = new BigDecimal(localn.vKy).divide(new BigDecimal(1000000)).toString();
            localar.yMX = 12;
            i = localar.yMV;
            if ((!ul(i)) && (!um(i))) {
              localar.Nu(4);
            }
          }
          else
          {
            localar.yMX = 10;
            localar.yMY = localn.vKz;
            i = localar.yMV;
            if ((!ul(i)) && (!um(i)))
            {
              if (i == 3) {}
              for (i = 1;; i = 0)
              {
                if (i != 0) {
                  break label251;
                }
                localar.Nu(10);
                break;
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(52775);
  }
  
  private static boolean ul(int paramInt)
  {
    return paramInt == 7;
  }
  
  private static boolean um(int paramInt)
  {
    return paramInt == 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.b
 * JD-Core Version:    0.7.0.1
 */