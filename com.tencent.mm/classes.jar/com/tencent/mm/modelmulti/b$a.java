package com.tencent.mm.modelmulti;

import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.s.a;
import com.tencent.mm.protocal.s.b;

public final class b$a
  implements com.tencent.mm.network.q
{
  private final s.a ess = new s.a();
  private final s.b est;
  private final boolean esu;
  int uin;
  
  public b$a()
  {
    this.est = new s.b();
    this.esu = false;
  }
  
  public b$a(s.b paramb)
  {
    this.est = paramb;
    this.esu = true;
  }
  
  public final k.e HF()
  {
    return this.est;
  }
  
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
    this.ess.spH = com.tencent.mm.compatible.e.q.zg();
    this.ess.spG = d.dOM;
    this.ess.spF = d.spa;
    this.ess.fn(this.uin);
    return this.ess;
  }
  
  public final boolean Kw()
  {
    return false;
  }
  
  public final int getType()
  {
    return 138;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/micromsg-bin/newsync";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelmulti.b.a
 * JD-Core Version:    0.7.0.1
 */