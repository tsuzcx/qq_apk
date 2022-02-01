package com.tencent.mm.plugin.ai.data.business.trigger;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.eg;
import com.tencent.mm.autogen.a.eg.a;
import com.tencent.mm.autogen.mmdata.rpt.ai;
import com.tencent.mm.plugin.ai.d.d;
import com.tencent.mm.plugin.ai.data.business.global.b;
import com.tencent.mm.plugin.finder.extension.reddot.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;

class NearLiveTrigger$2
  extends IListener<eg>
{
  NearLiveTrigger$2(e parame, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(267572);
    this.__eventId = eg.class.getName().hashCode();
    AppMethodBeat.o(267572);
  }
  
  private boolean a(eg parameg)
  {
    AppMethodBeat.i(267588);
    for (;;)
    {
      try
      {
        localObject = this.qnn;
        Log.d("MicroMsg.NearLiveTrigger", "enter notify live sync fromSid [%s] enterControlMap[%s]", new Object[] { parameg.hDZ.hEa, ((e)localObject).qmW });
        if (((e)localObject).qmX.contains(parameg.hDZ.hEa))
        {
          i = Util.getInt(parameg.hDZ.hEa, -1);
          if ((i >= 0) && (i < 255)) {
            continue;
          }
        }
        long l = Util.currentTicks();
        com.tencent.mm.plugin.ai.d.e.caH();
        localObject = d.TV("calendar_statistics_live");
        if (localObject != null)
        {
          b.bZW();
          p localp = b.cag();
          if (localp != null)
          {
            if (!Util.isEqual(localp.field_tipsId, ((ai)localObject).iok)) {
              ((ai)localObject).ky(localp.field_tipsId).iol = (((ai)localObject).iol + 1L);
            }
            b.bZW();
            if (b.b(localp) != null)
            {
              ((ai)localObject).ioi += 1L;
              if (((ai)localObject).iog == 0L)
              {
                ((ai)localObject).es(Util.nowMilliSecond());
                ((ai)localObject).ioh = localp.field_ctrInfo.type;
              }
            }
          }
          if ((parameg != null) && ((parameg.hDZ.hEa.equals("152")) || (parameg.hDZ.hEa.equals("150")))) {
            ((ai)localObject).et(((ai)localObject).ioj + parameg.hDZ.hEb / 1000L);
          }
          com.tencent.mm.plugin.ai.d.e.caH();
          d.a("calendar_statistics_live", (ai)localObject);
          Log.i("MicroMsg.NearLiveTrigger", "noteLiveRedDotExposeInfo info[%s] cost[%d]", new Object[] { ((ai)localObject).aIF(), Long.valueOf(Util.ticksToNow(l)) });
        }
      }
      catch (Exception parameg)
      {
        Object localObject;
        int i;
        Log.printErrStackTrace("MicroMsg.NearLiveTrigger", parameg, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(267588);
      return false;
      ((e)localObject).yL(i);
      String.format("live enter find more friends ui [%d] ", new Object[] { Integer.valueOf(i) });
      h.OAn.p(1559L, 211L, 1L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.trigger.NearLiveTrigger.2
 * JD-Core Version:    0.7.0.1
 */