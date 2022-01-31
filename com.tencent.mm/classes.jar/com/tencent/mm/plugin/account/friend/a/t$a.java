package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.protocal.c.aku;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.bk;

public final class t$a
  extends k.d
  implements k.b
{
  public aku fgc = new aku();
  
  public final byte[] HG()
  {
    this.spM = y.cph();
    this.fgc.sBt = new bmk().bs(bk.crT());
    this.fgc.tEX = k.a(this);
    return this.fgc.toByteArray();
  }
  
  public final int HH()
  {
    return 429;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.t.a
 * JD-Core Version:    0.7.0.1
 */