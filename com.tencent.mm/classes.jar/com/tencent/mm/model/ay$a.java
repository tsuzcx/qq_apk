package com.tencent.mm.model;

import com.tencent.mm.protocal.c.amd;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.bk;

public final class ay$a
  extends k.d
  implements k.b
{
  public amd dWa = new amd();
  
  public final byte[] HG()
  {
    this.spM = y.cph();
    this.dWa.sBt = new bmk().bs(bk.crT());
    this.dWa.tEX = k.a(this);
    return this.dWa.toByteArray();
  }
  
  public final int HH()
  {
    return 616;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.ay.a
 * JD-Core Version:    0.7.0.1
 */