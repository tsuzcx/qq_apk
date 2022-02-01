package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.cn.f;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.protocal.protobuf.cqk;

public abstract class a<Req extends cpx, Resp extends cqk>
{
  private c ugn;
  Req ugo;
  private Resp ugp;
  
  public final <T> f<T> b(com.tencent.mm.vending.c.a<T, c.a<Resp>> parama)
  {
    boolean bool2 = true;
    cYA();
    this.ugp = cYz();
    this.ugn = new c();
    c localc = this.ugn;
    cpx localcpx = this.ugo;
    cqk localcqk = this.ugp;
    if ((localcpx == null) || (localcqk == null))
    {
      parama = new StringBuilder("CgiBase called withoud req or resp req?[");
      if (localcpx == null)
      {
        bool1 = true;
        parama = parama.append(bool1).append("] resp?[");
        if (localcqk != null) {
          break label114;
        }
      }
      label114:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        throw new IllegalStateException(bool1 + "]");
        bool1 = false;
        break;
      }
    }
    b.a locala = new b.a();
    locala.funcId = getFuncId();
    locala.uri = getUri();
    locala.hvt = localcpx;
    locala.hvu = localcqk;
    localc.rr = locala.aAz();
    this.ugn.aBB().g(new com.tencent.mm.vending.c.a() {}).b(parama);
  }
  
  protected void cYA() {}
  
  protected void cYB() {}
  
  protected abstract Resp cYz();
  
  protected abstract int getFuncId();
  
  protected abstract String getUri();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.a
 * JD-Core Version:    0.7.0.1
 */