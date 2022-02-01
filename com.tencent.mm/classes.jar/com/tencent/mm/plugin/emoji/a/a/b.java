package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.pluginsdk.model.j.a;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.ax;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

public final class b
{
  private static boolean Bn(int paramInt)
  {
    return paramInt == 7;
  }
  
  private static boolean Bo(int paramInt)
  {
    return paramInt == 6;
  }
  
  public static void a(c paramc, j.a parama)
  {
    AppMethodBeat.i(108350);
    if (!u.axK())
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
      if ((localObject != null) && (((f)localObject).oYk != f.a.oYt))
      {
        localObject = ((f)localObject).oYl;
        boolean bool1 = e.b((EmotionSummary)localObject);
        boolean bool2 = e.a((EmotionSummary)localObject);
        if ((!bool1) && (!bool2))
        {
          localArrayList.add(((EmotionSummary)localObject).ProductID);
          localObject = paramc.XE(((EmotionSummary)localObject).ProductID);
          if (localObject != null) {
            ((ax)localObject).GXJ = 11;
          }
        }
      }
    }
    paramc = ai.getContext();
    if (localArrayList.size() > 0) {
      j.a(paramc, (String[])localArrayList.toArray(new String[localArrayList.size()]), parama);
    }
    AppMethodBeat.o(108350);
  }
  
  public static void a(ArrayList<p> paramArrayList, c paramc)
  {
    AppMethodBeat.i(108351);
    if (!u.axK())
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
        ac.i("MicroMsg.EmojiGoogleMarketTool", "endSeachGoogleMarket: %s", new Object[] { localp });
        ax localax = paramc.XE(localp.dcO);
        if (localax != null)
        {
          int i;
          if (localp.Dhr == 10232)
          {
            localax.GXN = localp.Dho;
            localax.GXL = localp.Dhp;
            localax.GXM = new BigDecimal(localp.Dhq).divide(new BigDecimal(1000000)).toString();
            localax.GXJ = 12;
            i = localax.GXH;
            if ((!Bn(i)) && (!Bo(i))) {
              localax.YK(4);
            }
          }
          else
          {
            localax.GXJ = 10;
            localax.GXK = localp.Dhr;
            i = localax.GXH;
            if ((!Bn(i)) && (!Bo(i)))
            {
              if (i == 3) {}
              for (i = 1;; i = 0)
              {
                if (i != 0) {
                  break label251;
                }
                localax.YK(10);
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