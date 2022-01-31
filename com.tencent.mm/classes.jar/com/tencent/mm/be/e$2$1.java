package com.tencent.mm.be;

import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.sdk.platformtools.av.a;

final class e$2$1
  implements MessageQueue.IdleHandler
{
  e$2$1(e.2 param2) {}
  
  public final boolean queueIdle()
  {
    this.eBx.eBw.b(new av.a()
    {
      public final boolean JS()
      {
        return true;
      }
      
      public final boolean JT()
      {
        e.b(e.2.1.this.eBx.eBw);
        return false;
      }
    });
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.be.e.2.1
 * JD-Core Version:    0.7.0.1
 */