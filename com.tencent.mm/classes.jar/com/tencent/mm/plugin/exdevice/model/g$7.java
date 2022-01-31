package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.sdk.platformtools.ap.a;
import java.util.List;

final class g$7
  implements ap.a
{
  g$7(g paramg) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(19257);
    int j = this.lEP.lEA.size();
    int i = 0;
    while (i < j)
    {
      if ((((b)this.lEP.lEA.get(i)).dCP.contains("internet_to_device")) && (((b)this.lEP.lEA.get(i)).dCP.contains("wechat_to_device")) && (!this.lEP.lEB.contains(this.lEP.lEA.get(i))))
      {
        this.lEP.lEB.add(this.lEP.lEA.get(i));
        g.bu(this.lEP.lEB);
      }
      i += 1;
    }
    AppMethodBeat.o(19257);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.g.7
 * JD-Core Version:    0.7.0.1
 */