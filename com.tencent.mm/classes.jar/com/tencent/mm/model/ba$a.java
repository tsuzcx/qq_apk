package com.tencent.mm.model;

import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.cdi;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.bk;

public final class ba$a
  extends k.d
  implements k.b
{
  public cdi dWe = new cdi();
  
  public final byte[] HG()
  {
    this.spM = y.cph();
    this.dWe.sBt = new bmk().bs(bk.crT());
    this.dWe.tEX = k.a(this);
    return this.dWe.toByteArray();
  }
  
  public final int HH()
  {
    return 617;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.model.ba.a
 * JD-Core Version:    0.7.0.1
 */