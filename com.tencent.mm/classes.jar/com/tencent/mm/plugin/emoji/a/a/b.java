package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.pluginsdk.model.j.a;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.bb;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

public final class b
{
  private static boolean BV(int paramInt)
  {
    return paramInt == 7;
  }
  
  private static boolean BW(int paramInt)
  {
    return paramInt == 6;
  }
  
  public static void a(c paramc, j.a parama)
  {
    AppMethodBeat.i(108350);
    if (!u.aAA())
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
      if ((localObject != null) && (((f)localObject).pBU != f.a.pCd))
      {
        localObject = ((f)localObject).pBV;
        boolean bool1 = e.b((EmotionSummary)localObject);
        boolean bool2 = e.a((EmotionSummary)localObject);
        if ((!bool1) && (!bool2))
        {
          localArrayList.add(((EmotionSummary)localObject).ProductID);
          localObject = paramc.abl(((EmotionSummary)localObject).ProductID);
          if (localObject != null) {
            ((bb)localObject).IKX = 11;
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
    if (!u.aAA())
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
        bb localbb = paramc.abl(localp.dok);
        if (localbb != null)
        {
          int i;
          if (localp.EMb == 10232)
          {
            localbb.ILb = localp.ELY;
            localbb.IKZ = localp.ELZ;
            localbb.ILa = new BigDecimal(localp.EMa).divide(new BigDecimal(1000000)).toString();
            localbb.IKX = 12;
            i = localbb.IKV;
            if ((!BV(i)) && (!BW(i))) {
              localbb.aaT(4);
            }
          }
          else
          {
            localbb.IKX = 10;
            localbb.IKY = localp.EMb;
            i = localbb.IKV;
            if ((!BV(i)) && (!BW(i)))
            {
              if (i == 3) {}
              for (i = 1;; i = 0)
              {
                if (i != 0) {
                  break label251;
                }
                localbb.aaT(10);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.b
 * JD-Core Version:    0.7.0.1
 */