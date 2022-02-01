package com.tencent.mm.plugin.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;

public final class b
  implements Runnable
{
  private ca dCM;
  private int opType;
  
  public b(ca paramca, int paramInt)
  {
    AppMethodBeat.i(22750);
    this.dCM = paramca;
    this.opType = paramInt;
    Log.d("MicroMsg.MsgEventTask", "%d msg id[%d %d] optype[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.dCM.field_msgId), Integer.valueOf(this.dCM.getType()), Integer.valueOf(this.opType) });
    AppMethodBeat.o(22750);
  }
  
  public final void run()
  {
    AppMethodBeat.i(22751);
    switch (this.opType)
    {
    default: 
      Log.w("MicroMsg.MsgEventTask", "%d unknow op type [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.opType) });
      AppMethodBeat.o(22751);
      return;
    }
    com.tencent.mm.plugin.f.b.crW().an(this.dCM);
    AppMethodBeat.o(22751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.f.c.b
 * JD-Core Version:    0.7.0.1
 */