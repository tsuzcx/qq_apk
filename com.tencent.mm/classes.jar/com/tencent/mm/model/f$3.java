package com.tencent.mm.model;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;

final class f$3
  implements Runnable
{
  f$3(f paramf, bi parambi) {}
  
  public final void run()
  {
    y.i("MicroMsg.BigBallSysCmdMsgConsumer", "[deleteLocalFile] id:%s type:%s", new Object[] { Long.valueOf(this.dUH.field_msgId), Integer.valueOf(this.dUH.getType()) });
    switch (this.dUH.getType())
    {
    default: 
      return;
    }
    bd.i(this.dUH);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.model.f.3
 * JD-Core Version:    0.7.0.1
 */