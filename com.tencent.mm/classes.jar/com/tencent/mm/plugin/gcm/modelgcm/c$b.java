package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.protocal.c.ct;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;

public final class c$b
  extends k.e
  implements k.c
{
  public ct lht = new ct();
  
  public final int A(byte[] paramArrayOfByte)
  {
    this.lht = ((ct)new ct().aH(paramArrayOfByte));
    k.a(this, this.lht.tFx);
    return this.lht.tFx.sze;
  }
  
  public final int getCmdId()
  {
    return 1000000289;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gcm.modelgcm.c.b
 * JD-Core Version:    0.7.0.1
 */