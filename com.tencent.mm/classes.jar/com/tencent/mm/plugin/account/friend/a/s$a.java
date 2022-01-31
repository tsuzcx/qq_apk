package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.protocal.c.aju;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.bk;

public final class s$a
  extends k.d
  implements k.b
{
  public aju fgb = new aju();
  
  public final byte[] HG()
  {
    this.spM = y.cpj();
    this.fgb.sBt = new bmk().bs(bk.crT());
    this.fgb.tEX = k.a(this);
    return this.fgb.toByteArray();
  }
  
  public final int HH()
  {
    return 572;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.s.a
 * JD-Core Version:    0.7.0.1
 */