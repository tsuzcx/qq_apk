package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.mm.ak.c;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.co.f;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;

public abstract class a<Req extends dop, Resp extends dpc>
{
  private c yPq;
  Req yPr;
  private Resp yPs;
  
  public final <T> f<T> b(com.tencent.mm.vending.c.a<T, c.a<Resp>> parama)
  {
    boolean bool2 = true;
    eeD();
    this.yPs = eeC();
    this.yPq = new c();
    c localc = this.yPq;
    dop localdop = this.yPr;
    dpc localdpc = this.yPs;
    if ((localdop == null) || (localdpc == null))
    {
      parama = new StringBuilder("CgiBase called withoud req or resp req?[");
      if (localdop == null)
      {
        bool1 = true;
        parama = parama.append(bool1).append("] resp?[");
        if (localdpc != null) {
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
    locala.iLN = localdop;
    locala.iLO = localdpc;
    localc.c(locala.aXF());
    this.yPq.aYI().g(new com.tencent.mm.vending.c.a() {}).b(parama);
  }
  
  protected abstract Resp eeC();
  
  protected void eeD() {}
  
  protected void eeE() {}
  
  protected abstract int getFuncId();
  
  protected abstract String getUri();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.a
 * JD-Core Version:    0.7.0.1
 */