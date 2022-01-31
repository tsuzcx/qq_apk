package com.tencent.mm.plugin.h.c;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.plugin.h.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;

public final class a
  implements Runnable
{
  private bi bFH;
  private int opType;
  
  public a(bi parambi, int paramInt)
  {
    this.bFH = parambi;
    this.opType = paramInt;
    y.d("MicroMsg.MsgEventTask", "%d msg id[%d %d] optype[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.bFH.field_msgId), Integer.valueOf(this.bFH.getType()), Integer.valueOf(this.opType) });
  }
  
  public final void run()
  {
    switch (this.opType)
    {
    default: 
      y.w("MicroMsg.MsgEventTask", "%d unknow op type [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.opType) });
      return;
    }
    b.ayE().K(this.bFH);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.h.c.a
 * JD-Core Version:    0.7.0.1
 */