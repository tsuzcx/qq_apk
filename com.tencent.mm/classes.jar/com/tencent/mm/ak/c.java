package com.tencent.mm.ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import junit.framework.Assert;

@Deprecated
public class c<_Resp extends cqk>
{
  private f<a<_Resp>> hvf;
  b<_Resp> hvx;
  public b rr;
  
  public c()
  {
    AppMethodBeat.i(182916);
    this.hvx = new b(this);
    AppMethodBeat.o(182916);
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString, _Resp param_Resp, n paramn) {}
  
  public f<a<_Resp>> aBB()
  {
    try
    {
      AppMethodBeat.i(182917);
      Assert.assertNotNull("You should set a CommReqResp!", this.rr);
      Assert.assertTrue("RunCgi NetSceneQueue not ready!", x.aCn());
      if (this.hvf == null) {
        this.hvf = com.tencent.mm.cn.g.c(new com.tencent.mm.vending.g.c.a() {});
      }
      f localf = this.hvf;
      AppMethodBeat.o(182917);
      return localf;
    }
    finally {}
  }
  
  public final void c(b paramb)
  {
    this.rr = paramb;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(182915);
    if (this.hvx != null) {
      x.a(this.hvx);
    }
    if (this.hvf != null) {
      this.hvf.ym(true);
    }
    AppMethodBeat.o(182915);
  }
  
  public static class a<T extends cqk>
  {
    public n dcV;
    public int errCode;
    public String errMsg;
    public int errType;
    public T hvj;
    public c hvz;
    
    public static <T extends cqk> a<T> a(int paramInt1, int paramInt2, String paramString, T paramT, n paramn, c paramc)
    {
      AppMethodBeat.i(182910);
      a locala = new a();
      locala.errType = paramInt1;
      locala.errCode = paramInt2;
      locala.errMsg = paramString;
      locala.hvj = paramT;
      locala.dcV = paramn;
      locala.hvz = paramc;
      if (paramc != null) {
        paramc.a(paramInt1, paramInt2, paramString, paramT, paramn);
      }
      AppMethodBeat.o(182910);
      return locala;
    }
  }
  
  static final class b<_Resp extends cqk>
    extends n
  {
    g gfX;
    c hvA;
    final n hvl;
    b hvm;
    com.tencent.mm.vending.g.b hvn;
    private k hvp;
    final long mStartTime;
    
    public b(c paramc)
    {
      AppMethodBeat.i(182912);
      this.gfX = null;
      this.hvl = this;
      this.mStartTime = bs.eWj();
      this.hvp = new k()
      {
        public final void onGYNetEnd(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, String paramAnonymousString, q paramAnonymousq, byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(182911);
          com.tencent.mm.vending.g.g.a(c.b.this.hvn, new Object[] { c.a.a(paramAnonymousInt2, paramAnonymousInt3, paramAnonymousString, (cqk)c.b.this.hvm.hvs.hvw, c.b.this, c.b.this.hvA) });
          c.b.this.gfX.onSceneEnd(paramAnonymousInt2, paramAnonymousInt3, paramAnonymousString, c.b.this.hvl);
          ac.i("MicroMsg.Cgi", "onGYNetEnd:%d func:%d time:%d [%d,%d,%s]", new Object[] { Integer.valueOf(c.b.this.hvl.hashCode()), Integer.valueOf(c.b.this.getType()), Long.valueOf(bs.eWj() - c.b.this.mStartTime), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), paramAnonymousString });
          AppMethodBeat.o(182911);
        }
      };
      this.hvA = paramc;
      AppMethodBeat.o(182912);
    }
    
    public final int doScene(com.tencent.mm.network.e parame, g paramg)
    {
      AppMethodBeat.i(182914);
      this.gfX = paramg;
      int i = dispatch(parame, this.hvm, this.hvp);
      ac.i("MicroMsg.Cgi", "Start doScene:%d func:%d netid:%d time:%d", new Object[] { Integer.valueOf(this.hvl.hashCode()), Integer.valueOf(getType()), Integer.valueOf(i), Long.valueOf(bs.eWj() - this.mStartTime) });
      if (i < 0) {
        com.tencent.mm.vending.g.g.a(this.hvn, new Object[] { c.a.a(3, -1, "", (cqk)this.hvm.hvs.hvw, this, this.hvA) });
      }
      AppMethodBeat.o(182914);
      return i;
    }
    
    public final int getType()
    {
      AppMethodBeat.i(182913);
      int i = this.hvm.getType();
      AppMethodBeat.o(182913);
      return i;
    }
    
    protected final int securityLimitCount()
    {
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ak.c
 * JD-Core Version:    0.7.0.1
 */