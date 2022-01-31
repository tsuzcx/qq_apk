package com.tencent.mm.plugin.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.plugin.f.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;

public final class a
  implements Runnable
{
  private bi cmQ;
  private int opType;
  
  public a(bi parambi, int paramInt)
  {
    AppMethodBeat.i(18641);
    this.cmQ = parambi;
    this.opType = paramInt;
    ab.d("MicroMsg.MsgEventTask", "%d msg id[%d %d] optype[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.cmQ.field_msgId), Integer.valueOf(this.cmQ.getType()), Integer.valueOf(this.opType) });
    AppMethodBeat.o(18641);
  }
  
  public final void run()
  {
    AppMethodBeat.i(18642);
    switch (this.opType)
    {
    default: 
      ab.w("MicroMsg.MsgEventTask", "%d unknow op type [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.opType) });
      AppMethodBeat.o(18642);
      return;
    }
    b.bak().O(this.cmQ);
    AppMethodBeat.o(18642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.f.c.a
 * JD-Core Version:    0.7.0.1
 */