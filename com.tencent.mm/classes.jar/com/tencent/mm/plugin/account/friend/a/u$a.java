package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.protocal.c.ama;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.bk;

public final class u$a
  extends k.d
  implements k.b
{
  public ama fge = new ama();
  
  public final byte[] HG()
  {
    this.spM = y.cpj();
    this.fge.sBt = new bmk().bs(bk.crT());
    this.fge.tEX = k.a(this);
    return this.fge.toByteArray();
  }
  
  public final int HH()
  {
    return 107;
  }
  
  public final int getCmdId()
  {
    return 48;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.u.a
 * JD-Core Version:    0.7.0.1
 */