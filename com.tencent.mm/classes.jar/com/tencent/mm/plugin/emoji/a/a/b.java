package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.model.k;
import com.tencent.mm.pluginsdk.model.k.a;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.bh;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

public final class b
{
  private static boolean FQ(int paramInt)
  {
    return paramInt == 7;
  }
  
  private static boolean FR(int paramInt)
  {
    return paramInt == 6;
  }
  
  public static void a(c paramc, k.a parama)
  {
    AppMethodBeat.i(108350);
    if (!z.aUn())
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
      if ((localObject != null) && (((f)localObject).qYk != f.a.qYt))
      {
        localObject = ((f)localObject).qYl;
        boolean bool1 = e.b((EmotionSummary)localObject);
        boolean bool2 = e.a((EmotionSummary)localObject);
        if ((!bool1) && (!bool2))
        {
          localArrayList.add(((EmotionSummary)localObject).ProductID);
          localObject = paramc.ame(((EmotionSummary)localObject).ProductID);
          if (localObject != null) {
            ((bh)localObject).Opx = 11;
          }
        }
      }
    }
    paramc = MMApplicationContext.getContext();
    if (localArrayList.size() > 0) {
      k.a(paramc, (String[])localArrayList.toArray(new String[localArrayList.size()]), parama);
    }
    AppMethodBeat.o(108350);
  }
  
  public static void a(ArrayList<q> paramArrayList, c paramc)
  {
    AppMethodBeat.i(108351);
    if (!z.aUn())
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
      q localq = (q)paramArrayList.next();
      if (localq != null)
      {
        Log.i("MicroMsg.EmojiGoogleMarketTool", "endSeachGoogleMarket: %s", new Object[] { localq });
        bh localbh = paramc.ame(localq.productId);
        if (localbh != null)
        {
          int i;
          if (localq.JVq == 10232)
          {
            localbh.OpB = localq.JVn;
            localbh.Opz = localq.JVo;
            localbh.OpA = new BigDecimal(localq.JVp).divide(new BigDecimal(1000000)).toString();
            localbh.Opx = 12;
            i = localbh.Opv;
            if ((!FQ(i)) && (!FR(i))) {
              localbh.akj(4);
            }
          }
          else
          {
            localbh.Opx = 10;
            localbh.Opy = localq.JVq;
            i = localbh.Opv;
            if ((!FQ(i)) && (!FR(i)))
            {
              if (i == 3) {}
              for (i = 1;; i = 0)
              {
                if (i != 0) {
                  break label251;
                }
                localbh.akj(10);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.b
 * JD-Core Version:    0.7.0.1
 */