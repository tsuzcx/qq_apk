package com.tencent.mm.be;

import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.sdk.platformtools.y;

final class c$1$1
  implements MessageQueue.IdleHandler
{
  c$1$1(c.1 param1) {}
  
  public final boolean queueIdle()
  {
    y.d("MicroMsg.SpeexEncoderWorker", "queueIdle  ");
    e.Rk().b(this.eBf.eBe);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.be.c.1.1
 * JD-Core Version:    0.7.0.1
 */