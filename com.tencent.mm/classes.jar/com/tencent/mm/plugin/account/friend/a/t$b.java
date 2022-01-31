package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.protocal.c.akv;
import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;

public final class t$b
  extends k.e
  implements k.c
{
  public akv fgd = new akv();
  
  public final int A(byte[] paramArrayOfByte)
  {
    this.fgd = ((akv)new akv().aH(paramArrayOfByte));
    k.a(this, this.fgd.tFx);
    return this.fgd.tFx.sze;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.t.b
 * JD-Core Version:    0.7.0.1
 */