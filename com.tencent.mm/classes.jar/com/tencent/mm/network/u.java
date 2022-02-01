package com.tencent.mm.network;

import com.tencent.mars.mm.MMLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class u
{
  public static void aD(List<String> paramList)
  {
    int k = 1;
    AppMethodBeat.i(132848);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MMDisasterInfoHandle", "compareDisasterHost");
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(132848);
      return;
    }
    Object localObject1 = ad.aPm();
    if (localObject1 == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.MMDisasterInfoHandle", "autoAuth is null");
      AppMethodBeat.o(132848);
      return;
    }
    localObject1 = ((t)localObject1).iEM;
    if (localObject1 == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.MMDisasterInfoHandle", "accinfo is null");
      AppMethodBeat.o(132848);
      return;
    }
    Object localObject2;
    int i;
    if (!((a)localObject1).Io("main"))
    {
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        if (((a)localObject1).aj(((String)((Iterator)localObject2).next()).getBytes())) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      Object localObject3;
      int j;
      if (i != 0)
      {
        ((a)localObject1).aOG();
        try
        {
          ad.aPk().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(132847);
              ad.aPo().j(3941, null);
              AppMethodBeat.o(132847);
            }
          });
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.MMDisasterInfoHandle", "main disaster disasterOccur ");
          e.ygI.idkeyStat(148L, 124L, 1L, false);
          AppMethodBeat.o(132848);
          return;
          i = 0;
          continue;
          localObject2 = new String[20];
          MMLogic.getLocalHostList((String[])localObject2, "main");
          localObject2 = new ArrayList(Arrays.asList((Object[])localObject2));
          if (((ArrayList)localObject2).size() <= 0) {
            break label537;
          }
          int m = ((ArrayList)localObject2).size();
          localObject3 = paramList.iterator();
          i = 0;
          label302:
          while (((Iterator)localObject3).hasNext())
          {
            String str = (String)((Iterator)localObject3).next();
            j = 0;
            for (;;)
            {
              if (j >= m) {
                break label302;
              }
              if ((((ArrayList)localObject2).get(j) != null) && (((String)((ArrayList)localObject2).get(j)).equals(str)))
              {
                i = 1;
                break;
              }
              j += 1;
            }
          }
        }
        catch (Exception paramList)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.MMDisasterInfoHandle", "exception:%s", new Object[] { bt.n(paramList) });
          }
        }
      }
      else
      {
        if (!((a)localObject1).Io("axhost"))
        {
          paramList = paramList.iterator();
          while (paramList.hasNext()) {
            if (((a)localObject1).Dq((String)paramList.next())) {
              i = k;
            }
          }
        }
        for (;;)
        {
          if (i != 0)
          {
            ((a)localObject1).aOG();
            ad.aPm().Iu("");
            e.ygI.idkeyStat(148L, 125L, 1L, false);
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.MMDisasterInfoHandle", "ax disaster disasterOccur ");
            AppMethodBeat.o(132848);
            return;
            continue;
            localObject2 = new String[20];
            MMLogic.getLocalHostList((String[])localObject2, "axhost");
            localObject2 = new ArrayList(Arrays.asList((Object[])localObject2));
            k = ((ArrayList)localObject2).size();
            paramList = paramList.iterator();
            label523:
            while (paramList.hasNext())
            {
              localObject3 = (String)paramList.next();
              j = 0;
              for (;;)
              {
                if (j >= k) {
                  break label523;
                }
                if ((((ArrayList)localObject2).get(j) != null) && (((String)((ArrayList)localObject2).get(j)).equals(localObject3)))
                {
                  i = 1;
                  break;
                }
                j += 1;
              }
            }
          }
          else
          {
            AppMethodBeat.o(132848);
            return;
          }
        }
        continue;
        label537:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.u
 * JD-Core Version:    0.7.0.1
 */