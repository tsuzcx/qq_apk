package com.tencent.mm.plugin.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bl;

public final class b
  implements Runnable
{
  private bl dbD;
  private int opType;
  
  public b(bl parambl, int paramInt)
  {
    AppMethodBeat.i(22750);
    this.dbD = parambl;
    this.opType = paramInt;
    ad.d("MicroMsg.MsgEventTask", "%d msg id[%d %d] optype[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.dbD.field_msgId), Integer.valueOf(this.dbD.getType()), Integer.valueOf(this.opType) });
    AppMethodBeat.o(22750);
  }
  
  public final void run()
  {
    AppMethodBeat.i(22751);
    switch (this.opType)
    {
    default: 
      ad.w("MicroMsg.MsgEventTask", "%d unknow op type [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.opType) });
      AppMethodBeat.o(22751);
      return;
    }
    com.tencent.mm.plugin.f.b.bHc().aa(this.dbD);
    AppMethodBeat.o(22751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.f.c.b
 * JD-Core Version:    0.7.0.1
 */