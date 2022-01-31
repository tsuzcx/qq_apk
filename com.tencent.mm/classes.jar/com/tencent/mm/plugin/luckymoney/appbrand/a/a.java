package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.mm.ah.a.a;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ck.f;
import com.tencent.mm.protocal.c.blm;
import com.tencent.mm.protocal.c.bly;

public abstract class a<Req extends blm, Resp extends bly>
{
  private com.tencent.mm.ah.a lKS;
  Req lKT;
  private Resp lKU;
  
  protected abstract int HH();
  
  public final <T> f<T> b(com.tencent.mm.vending.c.a<T, a.a<Resp>> parama)
  {
    boolean bool2 = true;
    bfl();
    this.lKU = bfk();
    this.lKS = new com.tencent.mm.ah.a();
    com.tencent.mm.ah.a locala = this.lKS;
    blm localblm = this.lKT;
    bly localbly = this.lKU;
    if ((localblm == null) || (localbly == null))
    {
      parama = new StringBuilder("CgiBase called withoud req or resp req?[");
      if (localblm == null)
      {
        bool1 = true;
        parama = parama.append(bool1).append("] resp?[");
        if (localbly != null) {
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
    locala1.ecG = HH();
    locala1.uri = getUri();
    locala1.ecH = localblm;
    locala1.ecI = localbly;
    locala.dmK = locala1.Kt();
    return this.lKS.Km().g(new a.1(this)).b(parama);
  }
  
  protected abstract Resp bfk();
  
  protected void bfl() {}
  
  protected void bfm() {}
  
  protected abstract String getUri();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.a
 * JD-Core Version:    0.7.0.1
 */