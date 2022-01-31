package com.tencent.mm.model;

import com.tencent.mm.protocal.c.ame;
import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;

public final class ay$b
  extends k.e
  implements k.c
{
  public ame dWb = new ame();
  
  public final int A(byte[] paramArrayOfByte)
  {
    this.dWb = ((ame)new ame().aH(paramArrayOfByte));
    k.a(this, this.dWb.tFx);
    return this.dWb.tFx.sze;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.ay.b
 * JD-Core Version:    0.7.0.1
 */