package com.tencent.mm.model.d;

import android.content.SharedPreferences;
import com.tencent.mm.ah.p;
import com.tencent.mm.az.k;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.y;

public final class c$1
  implements Runnable
{
  public c$1(c paramc) {}
  
  public final void run()
  {
    if (c.a(this.dZK))
    {
      y.i("MicroMsg.TraceConfigUpdater", "summer update isUpdating and ret");
      return;
    }
    long l1 = c.b(this.dZK).getLong("trace_config_last_update_time", 0L);
    long l2 = System.currentTimeMillis();
    if ((l2 - l1 > 86400000L) || (l1 > l2))
    {
      c.c(this.dZK);
      c.d(this.dZK);
      au.Dk().a(159, this.dZK);
      au.Dk().a(160, this.dZK);
      k localk = new k(21);
      au.Dk().a(localk, 0);
      return;
    }
    y.i("MicroMsg.TraceConfigUpdater", "summer last update time: " + l1 + " current time: " + l2 + " in same day");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.d.c.1
 * JD-Core Version:    0.7.0.1
 */