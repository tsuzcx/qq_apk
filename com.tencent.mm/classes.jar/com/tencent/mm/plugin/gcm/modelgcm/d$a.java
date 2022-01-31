package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.protocal.c.cu;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;

public final class d$a
  extends k.d
  implements k.b
{
  public cu lhu = new cu();
  
  public final byte[] HG()
  {
    this.lhu.tEX = k.a(this);
    return this.lhu.toByteArray();
  }
  
  public final int HH()
  {
    return 624;
  }
  
  public final int getCmdId()
  {
    return 241;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gcm.modelgcm.d.a
 * JD-Core Version:    0.7.0.1
 */