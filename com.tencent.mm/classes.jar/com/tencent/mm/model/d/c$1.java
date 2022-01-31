package com.tencent.mm.model.d;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.ba.k;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;

public final class c$1
  implements Runnable
{
  public c$1(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(16417);
    if (c.a(this.fpP))
    {
      ab.i("MicroMsg.TraceConfigUpdater", "summer update isUpdating and ret");
      AppMethodBeat.o(16417);
      return;
    }
    long l1 = c.b(this.fpP).getLong("trace_config_last_update_time", 0L);
    long l2 = System.currentTimeMillis();
    if ((l2 - l1 > 86400000L) || (l1 > l2))
    {
      c.c(this.fpP);
      c.d(this.fpP);
      aw.Rc().a(159, this.fpP);
      aw.Rc().a(160, this.fpP);
      k localk = new k(21);
      aw.Rc().a(localk, 0);
      AppMethodBeat.o(16417);
      return;
    }
    ab.i("MicroMsg.TraceConfigUpdater", "summer last update time: " + l1 + " current time: " + l2 + " in same day");
    AppMethodBeat.o(16417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.d.c.1
 * JD-Core Version:    0.7.0.1
 */