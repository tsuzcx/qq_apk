package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.mm.an.c;
import com.tencent.mm.an.c.a;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cw.f;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.dyy;

public abstract class a<Req extends dyl, Resp extends dyy>
{
  private c Etp;
  private Req Etq;
  private Resp Etr;
  
  public final void a(Req paramReq)
  {
    this.Etq = paramReq;
  }
  
  public final <T> f<T> b(com.tencent.mm.vending.c.a<T, c.a<Resp>> parama)
  {
    boolean bool2 = true;
    eNY();
    this.Etr = eNX();
    this.Etp = new c();
    c localc = this.Etp;
    dyl localdyl = this.Etq;
    dyy localdyy = this.Etr;
    if ((localdyl == null) || (localdyy == null))
    {
      parama = new StringBuilder("CgiBase called withoud req or resp req?[");
      if (localdyl == null)
      {
        bool1 = true;
        parama = parama.append(bool1).append("] resp?[");
        if (localdyy != null) {
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
    d.a locala = new d.a();
    locala.funcId = getFuncId();
    locala.uri = getUri();
    locala.lBU = localdyl;
    locala.lBV = localdyy;
    localc.c(locala.bgN());
    this.Etp.bhW().g(new com.tencent.mm.vending.c.a() {}).b(parama);
  }
  
  protected abstract Resp eNX();
  
  protected void eNY() {}
  
  protected void eNZ() {}
  
  protected abstract int getFuncId();
  
  protected abstract String getUri();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.a
 * JD-Core Version:    0.7.0.1
 */