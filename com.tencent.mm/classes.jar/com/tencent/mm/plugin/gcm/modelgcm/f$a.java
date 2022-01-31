package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.k.d;

public final class f$a
  implements com.tencent.mm.network.q
{
  private final d.b lhA = new d.b();
  private final d.a lhz = new d.a();
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
    this.lhz.spH = com.tencent.mm.compatible.e.q.zg();
    this.lhz.spG = d.dOM;
    this.lhz.spF = d.spa;
    this.lhz.fn(this.uin);
    return this.lhz;
  }
  
  public final boolean Kw()
  {
    return false;
  }
  
  public final int getType()
  {
    return 624;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/micromsg-bin/androidgcmunreg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gcm.modelgcm.f.a
 * JD-Core Version:    0.7.0.1
 */