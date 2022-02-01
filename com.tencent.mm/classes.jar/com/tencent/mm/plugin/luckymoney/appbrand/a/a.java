package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.mm.al.b.a;
import com.tencent.mm.al.c;
import com.tencent.mm.al.c.a;
import com.tencent.mm.co.f;
import com.tencent.mm.protocal.protobuf.ckq;
import com.tencent.mm.protocal.protobuf.cld;

public abstract class a<Req extends ckq, Resp extends cld>
{
  private c sXZ;
  Req sYa;
  private Resp sYb;
  
  public final <T> f<T> b(com.tencent.mm.vending.c.a<T, c.a<Resp>> parama)
  {
    boolean bool2 = true;
    cKU();
    this.sYb = cKT();
    this.sXZ = new c();
    c localc = this.sXZ;
    ckq localckq = this.sYa;
    cld localcld = this.sYb;
    if ((localckq == null) || (localcld == null))
    {
      parama = new StringBuilder("CgiBase called withoud req or resp req?[");
      if (localckq == null)
      {
        bool1 = true;
        parama = parama.append(bool1).append("] resp?[");
        if (localcld != null) {
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
    locala.gUU = localckq;
    locala.gUV = localcld;
    localc.rr = locala.atI();
    this.sXZ.auK().g(new com.tencent.mm.vending.c.a() {}).b(parama);
  }
  
  protected abstract Resp cKT();
  
  protected void cKU() {}
  
  protected void cKV() {}
  
  protected abstract int getFuncId();
  
  protected abstract String getUri();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.a
 * JD-Core Version:    0.7.0.1
 */