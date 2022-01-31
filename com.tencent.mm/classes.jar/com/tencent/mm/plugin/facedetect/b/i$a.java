package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.bv.b;
import com.tencent.mm.protocal.c.acg;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.bk;

public final class i$a
  extends k.d
  implements k.b
{
  public acg jMG = new acg();
  
  public final byte[] HG()
  {
    this.spM = y.cph();
    this.jMG.sBt = new bmk().bs(bk.crT());
    this.jMG.tEX = k.a(this);
    this.spL = this.jMG.sBt.tFM.toByteArray();
    return this.jMG.toByteArray();
  }
  
  public final int HH()
  {
    return 733;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.i.a
 * JD-Core Version:    0.7.0.1
 */