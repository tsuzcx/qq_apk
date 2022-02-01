package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cw;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.sdk.platformtools.av.a;
import java.util.List;

final class g$7
  implements av.a
{
  g$7(g paramg) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(23325);
    int j = this.oVB.oVm.size();
    int i = 0;
    while (i < j)
    {
      if ((((b)this.oVB.oVm.get(i)).eKt.contains("internet_to_device")) && (((b)this.oVB.oVm.get(i)).eKt.contains("wechat_to_device")) && (!this.oVB.oVn.contains(this.oVB.oVm.get(i))))
      {
        this.oVB.oVn.add(this.oVB.oVm.get(i));
        g.cS(this.oVB.oVn);
      }
      i += 1;
    }
    AppMethodBeat.o(23325);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.g.7
 * JD-Core Version:    0.7.0.1
 */