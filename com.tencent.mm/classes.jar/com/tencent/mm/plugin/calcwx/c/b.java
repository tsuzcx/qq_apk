package com.tencent.mm.plugin.calcwx.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.plugin.calcwx.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;

public final class b
  implements Runnable
{
  private cc hzO;
  private int opType;
  
  public b(cc paramcc, int paramInt)
  {
    AppMethodBeat.i(22750);
    this.hzO = paramcc;
    this.opType = paramInt;
    Log.d("MicroMsg.MsgEventTask", "%d msg id[%d %d] optype[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.hzO.field_msgId), Integer.valueOf(this.hzO.getType()), Integer.valueOf(this.opType) });
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
    a.diz().aE(this.hzO);
    AppMethodBeat.o(22751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.calcwx.c.b
 * JD-Core Version:    0.7.0.1
 */