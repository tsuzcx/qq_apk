package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.mm.ak.a.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.cm.f;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.cwj;

public abstract class a<Req extends cvw, Resp extends cwj>
{
  private com.tencent.mm.ak.a vvc;
  Req vvd;
  private Resp vve;
  
  public final <T> f<T> b(com.tencent.mm.vending.c.a<T, a.a<Resp>> parama)
  {
    boolean bool2 = true;
    dkL();
    this.vve = dkK();
    this.vvc = new com.tencent.mm.ak.a();
    com.tencent.mm.ak.a locala = this.vvc;
    cvw localcvw = this.vvd;
    cwj localcwj = this.vve;
    if ((localcvw == null) || (localcwj == null))
    {
      parama = new StringBuilder("CgiBase called withoud req or resp req?[");
      if (localcvw == null)
      {
        bool1 = true;
        parama = parama.append(bool1).append("] resp?[");
        if (localcwj != null) {
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
    b.a locala1 = new b.a();
    locala1.funcId = getFuncId();
    locala1.uri = getUri();
    locala1.hQF = localcvw;
    locala1.hQG = localcwj;
    locala.c(locala1.aDS());
    this.vvc.aET().g(new com.tencent.mm.vending.c.a() {}).b(parama);
  }
  
  protected abstract Resp dkK();
  
  protected void dkL() {}
  
  protected void dkM() {}
  
  protected abstract int getFuncId();
  
  protected abstract String getUri();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.a
 * JD-Core Version:    0.7.0.1
 */