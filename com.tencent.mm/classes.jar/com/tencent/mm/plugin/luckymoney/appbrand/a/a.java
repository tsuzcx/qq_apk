package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.mm.ai.a.a;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.cm.f;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.protocal.protobuf.bvk;

public abstract class a<Req extends buy, Resp extends bvk>
{
  private com.tencent.mm.ai.a oim;
  Req oin;
  private Resp oio;
  
  public final <T> f<T> b(com.tencent.mm.vending.c.a<T, a.a<Resp>> parama)
  {
    boolean bool2 = true;
    bML();
    this.oio = bMK();
    this.oim = new com.tencent.mm.ai.a();
    com.tencent.mm.ai.a locala = this.oim;
    buy localbuy = this.oin;
    bvk localbvk = this.oio;
    if ((localbuy == null) || (localbvk == null))
    {
      parama = new StringBuilder("CgiBase called withoud req or resp req?[");
      if (localbuy == null)
      {
        bool1 = true;
        parama = parama.append(bool1).append("] resp?[");
        if (localbvk != null) {
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
    locala1.fsX = localbuy;
    locala1.fsY = localbvk;
    locala.rr = locala1.ado();
    return this.oim.adl().g(new a.1(this)).b(parama);
  }
  
  protected abstract Resp bMK();
  
  protected void bML() {}
  
  protected void bMM() {}
  
  protected abstract int getFuncId();
  
  protected abstract String getUri();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.a
 * JD-Core Version:    0.7.0.1
 */