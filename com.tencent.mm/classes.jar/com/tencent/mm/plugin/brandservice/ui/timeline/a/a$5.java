package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import com.tencent.mm.ai.z;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.r;

final class a$5
  implements Runnable
{
  a$5(a parama) {}
  
  public final void run()
  {
    if ((a.a(this.ihX) == null) || (a.a(this.ihX).isFinishing())) {}
    q localq;
    do
    {
      return;
      localq = this.ihX.ayj();
    } while (localq == null);
    ai.d(new a.5.1(this, z.ME().W(10, localq.field_orderFlag)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.a.5
 * JD-Core Version:    0.7.0.1
 */