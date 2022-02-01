package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import junit.framework.Assert;

@Deprecated
public class c<_Resp extends cld>
{
  private f<a<_Resp>> gUG;
  b<_Resp> gUY;
  public b rr;
  
  public c()
  {
    AppMethodBeat.i(182916);
    this.gUY = new b(this);
    AppMethodBeat.o(182916);
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString, _Resp param_Resp, n paramn) {}
  
  public f<a<_Resp>> auK()
  {
    try
    {
      AppMethodBeat.i(182917);
      Assert.assertNotNull("You should set a CommReqResp!", this.rr);
      Assert.assertTrue("RunCgi NetSceneQueue not ready!", x.avu());
      if (this.gUG == null) {
        this.gUG = com.tencent.mm.co.g.c(new com.tencent.mm.vending.g.c.a() {});
      }
      f localf = this.gUG;
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
    if (this.gUY != null) {
      x.a(this.gUY);
    }
    if (this.gUG != null) {
      this.gUG.xd(true);
    }
    AppMethodBeat.o(182915);
  }
  
  public static class a<T extends cld>
  {
    public n dfA;
    public int errCode;
    public String errMsg;
    public int errType;
    public T gUK;
    public c gVa;
    
    public static <T extends cld> a<T> a(int paramInt1, int paramInt2, String paramString, T paramT, n paramn, c paramc)
    {
      AppMethodBeat.i(182910);
      a locala = new a();
      locala.errType = paramInt1;
      locala.errCode = paramInt2;
      locala.errMsg = paramString;
      locala.gUK = paramT;
      locala.dfA = paramn;
      locala.gVa = paramc;
      if (paramc != null) {
        paramc.a(paramInt1, paramInt2, paramString, paramT, paramn);
      }
      AppMethodBeat.o(182910);
      return locala;
    }
  }
  
  static final class b<_Resp extends cld>
    extends n
  {
    final n gUM;
    b gUN;
    com.tencent.mm.vending.g.b gUO;
    private k gUQ;
    c gVb;
    g gbr;
    final long mStartTime;
    
    public b(c paramc)
    {
      AppMethodBeat.i(182912);
      this.gbr = null;
      this.gUM = this;
      this.mStartTime = bt.eGO();
      this.gUQ = new k()
      {
        public final void onGYNetEnd(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, String paramAnonymousString, q paramAnonymousq, byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(182911);
          com.tencent.mm.vending.g.g.a(c.b.this.gUO, new Object[] { c.a.a(paramAnonymousInt2, paramAnonymousInt3, paramAnonymousString, (cld)c.b.this.gUN.gUT.gUX, c.b.this, c.b.this.gVb) });
          c.b.this.gbr.onSceneEnd(paramAnonymousInt2, paramAnonymousInt3, paramAnonymousString, c.b.this.gUM);
          ad.i("MicroMsg.Cgi", "onGYNetEnd:%d func:%d time:%d [%d,%d,%s]", new Object[] { Integer.valueOf(c.b.this.gUM.hashCode()), Integer.valueOf(c.b.this.getType()), Long.valueOf(bt.eGO() - c.b.this.mStartTime), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), paramAnonymousString });
          AppMethodBeat.o(182911);
        }
      };
      this.gVb = paramc;
      AppMethodBeat.o(182912);
    }
    
    public final int doScene(com.tencent.mm.network.e parame, g paramg)
    {
      AppMethodBeat.i(182914);
      this.gbr = paramg;
      int i = dispatch(parame, this.gUN, this.gUQ);
      ad.i("MicroMsg.Cgi", "Start doScene:%d func:%d netid:%d time:%d", new Object[] { Integer.valueOf(this.gUM.hashCode()), Integer.valueOf(getType()), Integer.valueOf(i), Long.valueOf(bt.eGO() - this.mStartTime) });
      if (i < 0) {
        com.tencent.mm.vending.g.g.a(this.gUO, new Object[] { c.a.a(3, -1, "", (cld)this.gUN.gUT.gUX, this, this.gVb) });
      }
      AppMethodBeat.o(182914);
      return i;
    }
    
    public final int getType()
    {
      AppMethodBeat.i(182913);
      int i = this.gUN.getType();
      AppMethodBeat.o(182913);
      return i;
    }
    
    protected final int securityLimitCount()
    {
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.c
 * JD-Core Version:    0.7.0.1
 */