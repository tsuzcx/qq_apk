package com.tencent.mm.ah;

import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.i.c;
import com.tencent.mm.protocal.i.c.a;
import com.tencent.mm.protocal.k.d;

public abstract class k
  implements com.tencent.mm.network.q
{
  private k.d ecY;
  public boolean ecZ = false;
  
  public abstract k.d HE();
  
  public int Kp()
  {
    return 0;
  }
  
  public int Kq()
  {
    return 0;
  }
  
  public final k.d Kv()
  {
    if (this.ecY == null)
    {
      this.ecY = HE();
      k.d locald = this.ecY;
      locald.spH = com.tencent.mm.compatible.e.q.zg();
      locald.spG = d.dOM;
      locald.spF = d.spa;
      locald.fn(i.c.a.spv.HC());
    }
    return this.ecY;
  }
  
  public final boolean Kw()
  {
    return this.ecZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ah.k
 * JD-Core Version:    0.7.0.1
 */