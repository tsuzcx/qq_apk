package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cy;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.sdk.platformtools.au.a;
import java.util.List;

final class g$7
  implements au.a
{
  g$7(g paramg) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(23325);
    int j = this.pyM.pyx.size();
    int i = 0;
    while (i < j)
    {
      if ((((b)this.pyM.pyx.get(i)).eNl.contains("internet_to_device")) && (((b)this.pyM.pyx.get(i)).eNl.contains("wechat_to_device")) && (!this.pyM.pyy.contains(this.pyM.pyx.get(i))))
      {
        this.pyM.pyy.add(this.pyM.pyx.get(i));
        g.cU(this.pyM.pyy);
      }
      i += 1;
    }
    AppMethodBeat.o(23325);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.g.7
 * JD-Core Version:    0.7.0.1
 */