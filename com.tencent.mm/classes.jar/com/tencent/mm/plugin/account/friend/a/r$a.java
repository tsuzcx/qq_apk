package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.ur;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.bk;

public final class r$a
  extends k.d
  implements k.b
{
  public ur ffZ = new ur();
  
  public final byte[] HG()
  {
    this.spM = y.cpj();
    this.ffZ.sBt = new bmk().bs(bk.crT());
    this.ffZ.tEX = k.a(this);
    return this.ffZ.toByteArray();
  }
  
  public final int HH()
  {
    return 481;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.r.a
 * JD-Core Version:    0.7.0.1
 */