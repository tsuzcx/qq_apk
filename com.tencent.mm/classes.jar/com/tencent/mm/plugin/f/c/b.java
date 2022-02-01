package com.tencent.mm.plugin.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bo;

public final class b
  implements Runnable
{
  private bo cZc;
  private int opType;
  
  public b(bo parambo, int paramInt)
  {
    AppMethodBeat.i(22750);
    this.cZc = parambo;
    this.opType = paramInt;
    ac.d("MicroMsg.MsgEventTask", "%d msg id[%d %d] optype[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.cZc.field_msgId), Integer.valueOf(this.cZc.getType()), Integer.valueOf(this.opType) });
    AppMethodBeat.o(22750);
  }
  
  public final void run()
  {
    AppMethodBeat.i(22751);
    switch (this.opType)
    {
    default: 
      ac.w("MicroMsg.MsgEventTask", "%d unknow op type [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.opType) });
      AppMethodBeat.o(22751);
      return;
    }
    com.tencent.mm.plugin.f.b.bOp().aa(this.cZc);
    AppMethodBeat.o(22751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.f.c.b
 * JD-Core Version:    0.7.0.1
 */