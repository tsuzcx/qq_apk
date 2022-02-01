package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.pluginsdk.model.j.a;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.bc;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

public final class b
{
  private static boolean Ch(int paramInt)
  {
    return paramInt == 7;
  }
  
  private static boolean Ci(int paramInt)
  {
    return paramInt == 6;
  }
  
  public static void a(c paramc, j.a parama)
  {
    AppMethodBeat.i(108350);
    if (!v.aAQ())
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
      if ((localObject != null) && (((f)localObject).pIy != f.a.pIH))
      {
        localObject = ((f)localObject).pIz;
        boolean bool1 = e.b((EmotionSummary)localObject);
        boolean bool2 = e.a((EmotionSummary)localObject);
        if ((!bool1) && (!bool2))
        {
          localArrayList.add(((EmotionSummary)localObject).ProductID);
          localObject = paramc.acc(((EmotionSummary)localObject).ProductID);
          if (localObject != null) {
            ((bc)localObject).JfE = 11;
          }
        }
      }
    }
    paramc = ak.getContext();
    if (localArrayList.size() > 0) {
      j.a(paramc, (String[])localArrayList.toArray(new String[localArrayList.size()]), parama);
    }
    AppMethodBeat.o(108350);
  }
  
  public static void a(ArrayList<p> paramArrayList, c paramc)
  {
    AppMethodBeat.i(108351);
    if (!v.aAQ())
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
        ae.i("MicroMsg.EmojiGoogleMarketTool", "endSeachGoogleMarket: %s", new Object[] { localp });
        bc localbc = paramc.acc(localp.dpp);
        if (localbc != null)
        {
          int i;
          if (localp.Fez == 10232)
          {
            localbc.JfI = localp.Few;
            localbc.JfG = localp.Fex;
            localbc.JfH = new BigDecimal(localp.Fey).divide(new BigDecimal(1000000)).toString();
            localbc.JfE = 12;
            i = localbc.JfC;
            if ((!Ch(i)) && (!Ci(i))) {
              localbc.abB(4);
            }
          }
          else
          {
            localbc.JfE = 10;
            localbc.JfF = localp.Fez;
            i = localbc.JfC;
            if ((!Ch(i)) && (!Ci(i)))
            {
              if (i == 3) {}
              for (i = 1;; i = 0)
              {
                if (i != 0) {
                  break label251;
                }
                localbc.abB(10);
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