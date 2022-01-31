package com.tencent.mm.model;

import com.tencent.mm.protocal.c.ami;
import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;

public final class az$b
  extends k.e
  implements k.c
{
  public ami dWd = new ami();
  
  public final int A(byte[] paramArrayOfByte)
  {
    this.dWd = ((ami)new ami().aH(paramArrayOfByte));
    k.a(this, this.dWd.tFx);
    return this.dWd.tFx.sze;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.az.b
 * JD-Core Version:    0.7.0.1
 */