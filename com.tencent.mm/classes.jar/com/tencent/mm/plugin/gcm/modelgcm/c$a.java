package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.protocal.c.cs;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;

public final class c$a
  extends k.d
  implements k.b
{
  public cs lhs = new cs();
  
  public final byte[] HG()
  {
    this.lhs.tEX = k.a(this);
    return this.lhs.toByteArray();
  }
  
  public final int HH()
  {
    return 623;
  }
  
  public final int getCmdId()
  {
    return 289;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gcm.modelgcm.c.a
 * JD-Core Version:    0.7.0.1
 */