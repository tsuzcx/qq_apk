package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.h.c.cc;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.sdk.platformtools.am.a;
import java.util.List;

final class g$7
  implements am.a
{
  g$7(g paramg) {}
  
  public final boolean tC()
  {
    int j = this.jvq.jvb.size();
    int i = 0;
    while (i < j)
    {
      if ((((b)this.jvq.jvb.get(i)).cMZ.contains("internet_to_device")) && (((b)this.jvq.jvb.get(i)).cMZ.contains("wechat_to_device")) && (!this.jvq.jvc.contains(this.jvq.jvb.get(i))))
      {
        this.jvq.jvc.add(this.jvq.jvb.get(i));
        g.bd(this.jvq.jvc);
      }
      i += 1;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.g.7
 * JD-Core Version:    0.7.0.1
 */