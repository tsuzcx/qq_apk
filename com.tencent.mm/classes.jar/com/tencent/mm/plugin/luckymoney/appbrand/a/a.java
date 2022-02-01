package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.mm.am.b;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.c.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.esc;

public abstract class a<Req extends erp, Resp extends esc>
{
  private b KlW;
  private Req KlX;
  private Resp KlY;
  
  public final void a(Req paramReq)
  {
    this.KlX = paramReq;
  }
  
  public final <T> f<T> b(com.tencent.mm.vending.c.a<T, b.a<Resp>> parama)
  {
    boolean bool2 = true;
    fWr();
    this.KlY = fWq();
    this.KlW = new b();
    b localb = this.KlW;
    erp localerp = this.KlX;
    esc localesc = this.KlY;
    if ((localerp == null) || (localesc == null))
    {
      parama = new StringBuilder("CgiBase called withoud req or resp req?[");
      if (localerp == null)
      {
        bool1 = true;
        parama = parama.append(bool1).append("] resp?[");
        if (localesc != null) {
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
    c.a locala = new c.a();
    locala.funcId = getFuncId();
    locala.uri = getUri();
    locala.otE = localerp;
    locala.otF = localesc;
    localb.c(locala.bEF());
    this.KlW.bFJ().g(new com.tencent.mm.vending.c.a() {}).b(parama);
  }
  
  protected abstract Resp fWq();
  
  protected void fWr() {}
  
  protected void fWs() {}
  
  protected abstract int getFuncId();
  
  protected abstract String getUri();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.a
 * JD-Core Version:    0.7.0.1
 */