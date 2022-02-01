package com.tencent.mm.plugin.ai.data.business.finder;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.jq;
import com.tencent.mm.autogen.a.jq.a;
import com.tencent.mm.autogen.mmdata.rpt.fz;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.ai.b.a;
import com.tencent.mm.plugin.ai.d.c;
import com.tencent.mm.plugin.ai.d.c.1;
import com.tencent.mm.plugin.ai.d.d;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class AiFinderLogic$3
  extends IListener<jq>
{
  AiFinderLogic$3(e parame, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(267500);
    this.__eventId = jq.class.getName().hashCode();
    AppMethodBeat.o(267500);
  }
  
  private boolean a(jq paramjq)
  {
    AppMethodBeat.i(267519);
    for (;;)
    {
      long l2;
      ArrayList localArrayList;
      Object localObject1;
      Object localObject2;
      try
      {
        l2 = Util.currentTicks();
        if ((paramjq == null) || (paramjq.hLk == null))
        {
          i = paramjq.hLk.scene;
          if (i >= 10000) {
            break label502;
          }
          AppMethodBeat.o(267519);
          return false;
        }
        if ((paramjq.hLk.hLl != 113) || (Util.isNullOrNil(paramjq.hLk.hLm))) {
          continue;
        }
        localArrayList = new ArrayList();
        localObject1 = paramjq.hLk.hLm.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label434;
        }
        Object localObject3 = ((Iterator)localObject1).next();
        if (!(localObject3 instanceof fz)) {
          continue;
        }
        localObject2 = new com.tencent.mm.plugin.ai.d.b();
        localObject3 = (fz)localObject3;
        if (localObject3 == null) {
          break label342;
        }
        ((com.tencent.mm.plugin.ai.d.b)localObject2).field_tipsId = ((fz)localObject3).ikf;
        ((com.tencent.mm.plugin.ai.d.b)localObject2).field_ctrlType = ((fz)localObject3).iyT;
        ((com.tencent.mm.plugin.ai.d.b)localObject2).field_showType = ((fz)localObject3).iJL;
        ((com.tencent.mm.plugin.ai.d.b)localObject2).field_path = ((fz)localObject3).ikk;
        ((com.tencent.mm.plugin.ai.d.b)localObject2).field_scene = ((fz)localObject3).ijZ;
        ((com.tencent.mm.plugin.ai.d.b)localObject2).field_receTimeMs = Util.nowMilliSecond();
        long l1;
        if (!Util.isNullOrNil(((fz)localObject3).imE))
        {
          l1 = ((fz)localObject3).imE.hashCode();
          ((com.tencent.mm.plugin.ai.d.b)localObject2).field_urlHash = l1;
          ((com.tencent.mm.plugin.ai.d.b)localObject2).field_ds = Util.getInt(a.cav().format(Long.valueOf(((com.tencent.mm.plugin.ai.d.b)localObject2).field_receTimeMs)), -1);
          i = 1;
          if (i == 0) {
            continue;
          }
          localArrayList.add(localObject2);
          localObject2 = ((com.tencent.mm.plugin.ai.d.b)localObject2).field_path;
        }
        switch (((String)localObject2).hashCode())
        {
        case -58348260: 
          com.tencent.mm.plugin.ai.data.business.global.b.bZW();
          com.tencent.mm.plugin.ai.d.e.caH().qpt.Q("rece_finder_reddot_ms", cn.bDw());
          continue;
          l1 = 0L;
        }
      }
      catch (Exception paramjq)
      {
        AppMethodBeat.o(267519);
        return false;
      }
      continue;
      label342:
      int i = 0;
      continue;
      if (((String)localObject2).equals("FinderEntrance"))
      {
        i = 0;
        break label620;
        if (((String)localObject2).equals("NearbyEntrance"))
        {
          i = 1;
          break label620;
          if (((String)localObject2).equals("FinderLiveEntrance"))
          {
            i = 2;
            break label620;
            com.tencent.mm.plugin.ai.data.business.global.b.bZW();
            com.tencent.mm.plugin.ai.d.e.caH().qpt.Q("rece_near_reddot_ms", cn.bDw());
            continue;
            com.tencent.mm.plugin.ai.data.business.global.b.bZW();
            com.tencent.mm.plugin.ai.d.e.caH().qpt.Q("rece_finder_live_reddot_ms", cn.bDw());
            continue;
            label434:
            localObject1 = com.tencent.mm.plugin.ai.d.e.caH().qps;
            h.ahAA.g(new c.1((c)localObject1, localArrayList), "Ai_thread");
            Log.i("MicroMsg.AiFinderLogic", "check receive finder Entrance RedDot cost[%d] size[%d]", new Object[] { Long.valueOf(Util.ticksToNow(l2)), Integer.valueOf(localArrayList.size()) });
            continue;
            label502:
            if ((paramjq.hLk.hLl == 113) && (!Util.isNullOrNil(paramjq.hLk.hLm)))
            {
              e.a(this.qmd, paramjq);
              this.qmd.qlZ.removeMessages(2457);
              AppMethodBeat.o(267519);
              return false;
            }
            if (this.qmd.qlO <= 0L) {
              continue;
            }
            this.qmd.qlZ.removeMessages(2457);
            this.qmd.qlZ.sendMessageDelayed(this.qmd.qlZ.obtainMessage(2457, paramjq.hLk.scene, 0), 100L);
            continue;
          }
        }
      }
      i = -1;
      label620:
      switch (i)
      {
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.finder.AiFinderLogic.3
 * JD-Core Version:    0.7.0.1
 */