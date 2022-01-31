package com.tencent.mm.modelmulti;

import com.tencent.mm.ah.k;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.s.a;
import com.tencent.mm.protocal.s.b;

public final class j$a
  extends k
{
  private final s.a ess = new s.a();
  private final s.b est;
  private final boolean esu;
  
  public j$a()
  {
    this.est = new s.b();
    this.esu = false;
  }
  
  public j$a(s.b paramb)
  {
    this.est = paramb;
    this.esu = true;
  }
  
  public final k.d HE()
  {
    return this.ess;
  }
  
  public final k.e HF()
  {
    return this.est;
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
 * Qualified Name:     com.tencent.mm.modelmulti.j.a
 * JD-Core Version:    0.7.0.1
 */