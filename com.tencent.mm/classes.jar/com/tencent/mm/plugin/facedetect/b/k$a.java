package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.bv.b;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.cco;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.bk;

public final class k$a
  extends k.d
  implements k.b
{
  public cco jMK = new cco();
  
  public final byte[] HG()
  {
    this.spM = y.cph();
    this.jMK.sBt = new bmk().bs(bk.crT());
    this.jMK.tEX = k.a(this);
    this.spL = this.jMK.sBt.tFM.toByteArray();
    return this.jMK.toByteArray();
  }
  
  public final int HH()
  {
    return 930;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.k.a
 * JD-Core Version:    0.7.0.1
 */