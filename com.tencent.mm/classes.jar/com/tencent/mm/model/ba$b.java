package com.tencent.mm.model;

import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.protocal.c.cdj;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;

public final class ba$b
  extends k.e
  implements k.c
{
  public cdj dWf = new cdj();
  
  public final int A(byte[] paramArrayOfByte)
  {
    this.dWf = ((cdj)new cdj().aH(paramArrayOfByte));
    k.a(this, this.dWf.tFx);
    return this.dWf.tFx.sze;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.model.ba.b
 * JD-Core Version:    0.7.0.1
 */