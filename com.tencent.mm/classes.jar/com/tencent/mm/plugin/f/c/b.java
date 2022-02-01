package com.tencent.mm.plugin.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bv;

public final class b
  implements Runnable
{
  private bv dlw;
  private int opType;
  
  public b(bv parambv, int paramInt)
  {
    AppMethodBeat.i(22750);
    this.dlw = parambv;
    this.opType = paramInt;
    ae.d("MicroMsg.MsgEventTask", "%d msg id[%d %d] optype[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.dlw.field_msgId), Integer.valueOf(this.dlw.getType()), Integer.valueOf(this.opType) });
    AppMethodBeat.o(22750);
  }
  
  public final void run()
  {
    AppMethodBeat.i(22751);
    switch (this.opType)
    {
    default: 
      ae.w("MicroMsg.MsgEventTask", "%d unknow op type [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.opType) });
      AppMethodBeat.o(22751);
      return;
    }
    com.tencent.mm.plugin.f.b.bUj().ac(this.dlw);
    AppMethodBeat.o(22751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.f.c.b
 * JD-Core Version:    0.7.0.1
 */