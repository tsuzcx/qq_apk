package com.tencent.mm.network;

import com.tencent.mars.mm.MMLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class x
{
  public static void co(List<String> paramList)
  {
    int k = 1;
    AppMethodBeat.i(132848);
    Log.i("MicroMsg.MMDisasterInfoHandle", "compareDisasterHost");
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(132848);
      return;
    }
    Object localObject1 = ag.bRx();
    if (localObject1 == null)
    {
      Log.w("MicroMsg.MMDisasterInfoHandle", "autoAuth is null");
      AppMethodBeat.o(132848);
      return;
    }
    localObject1 = ((w)localObject1).poh;
    if (localObject1 == null)
    {
      Log.w("MicroMsg.MMDisasterInfoHandle", "accinfo is null");
      AppMethodBeat.o(132848);
      return;
    }
    Object localObject2;
    int i;
    if (!((a)localObject1).Rq("main"))
    {
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        if (((a)localObject1).aJ(((String)((Iterator)localObject2).next()).getBytes())) {
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
        ((a)localObject1).bQC();
        try
        {
          ag.getHandler().post(new x.1());
          Log.w("MicroMsg.MMDisasterInfoHandle", "main disaster disasterOccur ");
          f.Ozc.idkeyStat(148L, 124L, 1L, false);
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
            Log.e("MicroMsg.MMDisasterInfoHandle", "exception:%s", new Object[] { Util.stackTraceToString(paramList) });
          }
        }
      }
      else
      {
        if (!((a)localObject1).Rq("axhost"))
        {
          paramList = paramList.iterator();
          while (paramList.hasNext()) {
            if (((a)localObject1).Ma((String)paramList.next())) {
              i = k;
            }
          }
        }
        for (;;)
        {
          if (i != 0)
          {
            ((a)localObject1).bQC();
            ag.bRx().Rw("");
            f.Ozc.idkeyStat(148L, 125L, 1L, false);
            Log.w("MicroMsg.MMDisasterInfoHandle", "ax disaster disasterOccur ");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.network.x
 * JD-Core Version:    0.7.0.1
 */