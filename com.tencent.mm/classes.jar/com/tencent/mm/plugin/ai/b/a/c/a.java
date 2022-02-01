package com.tencent.mm.plugin.ai.b.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.rf;
import com.tencent.mm.f.a.rf.a;
import com.tencent.mm.f.b.a.bm;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.ag;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class a
  implements c
{
  private IListener<rf> npg;
  
  protected a()
  {
    AppMethodBeat.i(239724);
    this.npg = new IListener()
    {
      private static boolean a(rf paramAnonymousrf)
      {
        AppMethodBeat.i(240435);
        long l;
        Object localObject1;
        try
        {
          l = Util.currentTicks();
          localObject2 = com.tencent.mm.plugin.ai.b.a.b.a.bBa();
          localObject1 = new int[13];
          i = 0;
        }
        catch (Exception paramAnonymousrf) {}
        Iterator localIterator = ((com.tencent.mm.plugin.ai.b.a.b.a)localObject2).noQ.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (com.tencent.mm.plugin.ai.b.a.b.a.noP.containsKey(str))
          {
            localObject1[((Integer)com.tencent.mm.plugin.ai.b.a.b.a.noP.get(str)).intValue()] = ((Integer)((com.tencent.mm.plugin.ai.b.a.b.a)localObject2).noQ.get(str)).intValue();
            continue;
            label110:
            AppMethodBeat.o(240435);
            return false;
          }
        }
        Log.d("MicroMsg.AiRedDotData", "copyRedDotInfo [%s]", new Object[] { Arrays.toString((int[])localObject1) });
        Object localObject2 = new StringBuffer();
        ((StringBuffer)localObject2).append(paramAnonymousrf.fQj.fzr).append(",");
        ((StringBuffer)localObject2).append("2,");
        ((StringBuffer)localObject2).append(paramAnonymousrf.fQj.fQk).append(",");
        ((StringBuffer)localObject2).append(paramAnonymousrf.fQj.fQl).append(",");
        ((StringBuffer)localObject2).append(paramAnonymousrf.fQj.fQm).append(",");
        ((StringBuffer)localObject2).append(paramAnonymousrf.fQj.fQm - paramAnonymousrf.fQj.fQl).append(",");
        int i = 0;
        break label457;
        label256:
        ((StringBuffer)localObject2).append(j).append(",");
        break label484;
        label271:
        if (((ak)h.ag(ak.class)).getFinderUtilApi().eeH()) {
          if (localObject1[i] == 0) {
            break label496;
          }
        }
        label457:
        label484:
        label489:
        label491:
        label496:
        for (int j = localObject1[i];; j = 2)
        {
          ((StringBuffer)localObject2).append(j).append(",");
          break label484;
          ((StringBuffer)localObject2).append(-1).append(",");
          for (;;)
          {
            localObject1 = new bm(((StringBuffer)localObject2).toString());
            ((bm)localObject1).bpa();
            Log.d("MicroMsg.FindMoreFriendsUIReporter", "report find friend cost[%d] [%s]", new Object[] { Long.valueOf(Util.ticksToNow(l)), ((bm)localObject1).agI() });
            i = Util.getInt(paramAnonymousrf.fQj.fQk, -1);
            if ((i < 0) || (i >= 255))
            {
              f.Iyx.idkeyStat(1437L, 255L, 1L, false);
              break label110;
            }
            f.Iyx.idkeyStat(1437L, i, 1L, false);
            break label110;
            while (i < 13)
            {
              localObject1[i] = 0;
              i += 1;
            }
            break;
            for (;;)
            {
              if (i >= 13) {
                break label489;
              }
              if (i == 12) {
                break label271;
              }
              if (localObject1[i] == 0) {
                break label491;
              }
              j = localObject1[i];
              break;
              i += 1;
            }
          }
          j = 2;
          break label256;
        }
      }
    };
    AppMethodBeat.o(239724);
  }
  
  public final void OO()
  {
    AppMethodBeat.i(239728);
    EventCenter.instance.add(this.npg);
    AppMethodBeat.o(239728);
  }
  
  public final void unRegister()
  {
    AppMethodBeat.i(239731);
    EventCenter.instance.removeListener(this.npg);
    AppMethodBeat.o(239731);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.b.a.c.a
 * JD-Core Version:    0.7.0.1
 */