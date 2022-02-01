package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.mm.al.a.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.cn.f;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.cvp;

public abstract class a<Req extends cvc, Resp extends cvp>
{
  private com.tencent.mm.al.a viX;
  Req viY;
  private Resp viZ;
  
  public final <T> f<T> b(com.tencent.mm.vending.c.a<T, a.a<Resp>> parama)
  {
    boolean bool2 = true;
    dhM();
    this.viZ = dhL();
    this.viX = new com.tencent.mm.al.a();
    com.tencent.mm.al.a locala = this.viX;
    cvc localcvc = this.viY;
    cvp localcvp = this.viZ;
    if ((localcvc == null) || (localcvp == null))
    {
      parama = new StringBuilder("CgiBase called withoud req or resp req?[");
      if (localcvc == null)
      {
        bool1 = true;
        parama = parama.append(bool1).append("] resp?[");
        if (localcvp != null) {
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
    locala1.hNM = localcvc;
    locala1.hNN = localcvp;
    locala.c(locala1.aDC());
    this.viX.aED().g(new com.tencent.mm.vending.c.a() {}).b(parama);
  }
  
  protected abstract Resp dhL();
  
  protected void dhM() {}
  
  protected void dhN() {}
  
  protected abstract int getFuncId();
  
  protected abstract String getUri();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.a
 * JD-Core Version:    0.7.0.1
 */