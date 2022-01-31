package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.k.d;

public final class e$a
  implements com.tencent.mm.network.q
{
  private final c.a lhx = new c.a();
  private final c.b lhy = new c.b();
  int uin;
  
  public final int Kp()
  {
    return 0;
  }
  
  public final int Kq()
  {
    return 0;
  }
  
  public final k.d Kv()
  {
    this.lhx.spH = com.tencent.mm.compatible.e.q.zg();
    this.lhx.spG = d.dOM;
    this.lhx.spF = d.spa;
    this.lhx.fn(this.uin);
    return this.lhx;
  }
  
  public final boolean Kw()
  {
    return false;
  }
  
  public final int getType()
  {
    return 623;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/micromsg-bin/androidgcmreg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gcm.modelgcm.e.a
 * JD-Core Version:    0.7.0.1
 */