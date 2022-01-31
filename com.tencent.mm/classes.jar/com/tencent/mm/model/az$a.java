package com.tencent.mm.model;

import com.tencent.mm.protocal.c.amh;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.bk;

public final class az$a
  extends k.d
  implements k.b
{
  public amh dWc = new amh();
  
  public final byte[] HG()
  {
    this.spM = y.cph();
    this.dWc.sBt = new bmk().bs(bk.crT());
    this.dWc.tEX = k.a(this);
    return this.dWc.toByteArray();
  }
  
  public final int HH()
  {
    return 618;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.az.a
 * JD-Core Version:    0.7.0.1
 */