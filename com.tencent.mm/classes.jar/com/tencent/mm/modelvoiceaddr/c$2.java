package com.tencent.mm.modelvoiceaddr;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ah;

final class c$2
  extends ah
{
  c$2(c paramc, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 291) {}
    while (!this.eLz.Tu()) {
      return;
    }
    g.Dk().a(this.eLz, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.c.2
 * JD-Core Version:    0.7.0.1
 */