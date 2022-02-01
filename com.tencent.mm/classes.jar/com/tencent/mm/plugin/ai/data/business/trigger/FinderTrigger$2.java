package com.tencent.mm.plugin.ai.data.business.trigger;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.eg;
import com.tencent.mm.autogen.a.eg.a;
import com.tencent.mm.autogen.mmdata.rpt.ai;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.ai.d.d;
import com.tencent.mm.plugin.ai.d.e;
import com.tencent.mm.plugin.finder.extension.reddot.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;

class FinderTrigger$2
  extends IListener<eg>
{
  FinderTrigger$2(b paramb, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(267638);
    this.__eventId = eg.class.getName().hashCode();
    AppMethodBeat.o(267638);
  }
  
  private boolean a(eg parameg)
  {
    AppMethodBeat.i(267661);
    for (;;)
    {
      try
      {
        localObject = this.qnh;
        Log.d("MicroMsg.FinderTrigger", "enter notify live sync fromSid [%s] enterControlMap[%s]", new Object[] { parameg.hDZ.hEa, ((b)localObject).qmX });
        if (((b)localObject).qmX.contains(parameg.hDZ.hEa))
        {
          i = Util.getInt(parameg.hDZ.hEa, -1);
          if ((i >= 0) && (i < 255)) {
            continue;
          }
        }
        localObject = this.qnh;
        if (((b)localObject).qna <= 0L) {
          continue;
        }
        com.tencent.mm.plugin.ai.data.business.global.b.bZW();
        l1 = Math.max(com.tencent.mm.plugin.ai.data.business.global.b.caa(), ((b)localObject).qnb);
        l2 = cn.bDw();
        if (l2 - l1 <= ((b)localObject).qna * 3600000L) {
          continue;
        }
        bool = true;
      }
      catch (Exception parameg)
      {
        Object localObject;
        int i;
        long l1;
        long l2;
        p localp;
        Log.printErrStackTrace("MicroMsg.FinderTrigger", parameg, "", new Object[0]);
        continue;
        boolean bool = false;
        continue;
      }
      if (bool)
      {
        ((b)localObject).qnb = l2;
        ((b)localObject).yK(13000);
        h.OAn.p(1559L, 99L, 1L);
      }
      Log.i("MicroMsg.FinderTrigger", "check last get reddot sync[%b] time[%d %d]", new Object[] { Boolean.valueOf(bool), Long.valueOf(l2), Long.valueOf(l1) });
      l1 = Util.currentTicks();
      e.caH();
      localObject = d.TV("calendar_statistics_finder");
      if (localObject != null)
      {
        com.tencent.mm.plugin.ai.data.business.global.b.bZW();
        localp = com.tencent.mm.plugin.ai.data.business.global.b.bZZ();
        if (localp != null)
        {
          if (!Util.isEqual(localp.field_tipsId, ((ai)localObject).iok)) {
            ((ai)localObject).ky(localp.field_tipsId).iol = (((ai)localObject).iol + 1L);
          }
          com.tencent.mm.plugin.ai.data.business.global.b.bZW();
          if (com.tencent.mm.plugin.ai.data.business.global.b.a(localp) != null)
          {
            ((ai)localObject).ioi += 1L;
            if (((ai)localObject).iog == 0L)
            {
              ((ai)localObject).es(Util.nowMilliSecond());
              ((ai)localObject).ioh = localp.field_ctrInfo.type;
            }
          }
        }
        if ((parameg != null) && (parameg.hDZ.hEa.equals("143"))) {
          ((ai)localObject).et(((ai)localObject).ioj + parameg.hDZ.hEb / 1000L);
        }
        e.caH();
        d.a("calendar_statistics_finder", (ai)localObject);
        Log.i("MicroMsg.FinderTrigger", "noteFinderRedDotExposeInfo info[%s] cost[%d]", new Object[] { ((ai)localObject).aIF(), Long.valueOf(Util.ticksToNow(l1)) });
      }
      AppMethodBeat.o(267661);
      return false;
      ((b)localObject).yK(i);
      String.format("finder enter find more friends ui [%d] ", new Object[] { Integer.valueOf(i) });
      h.OAn.p(1559L, 201L, 1L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.trigger.FinderTrigger.2
 * JD-Core Version:    0.7.0.1
 */