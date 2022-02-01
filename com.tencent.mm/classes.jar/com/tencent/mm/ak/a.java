package com.tencent.mm.ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vending.g.c.a;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;

public class a<_Resp extends cqk>
{
  b<_Resp> hve;
  private f<a<_Resp>> hvf;
  AtomicBoolean hvg;
  protected b rr;
  
  public a()
  {
    AppMethodBeat.i(132299);
    this.hvg = new AtomicBoolean(false);
    this.hve = new b(this);
    AppMethodBeat.o(132299);
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString, _Resp param_Resp, n paramn) {}
  
  public f<a<_Resp>> aBB()
  {
    try
    {
      AppMethodBeat.i(132300);
      Assert.assertNotNull("You should set a CommReqResp!", this.rr);
      Assert.assertTrue("RunCgi NetSceneQueue not ready!", x.aCn());
      if (this.hvf == null) {
        this.hvf = new f()new c.a
        {
          public final f a(com.tencent.mm.vending.e.b paramAnonymousb)
          {
            AppMethodBeat.i(182907);
            paramAnonymousb.keep(new com.tencent.mm.vending.e.a()
            {
              public final void dead()
              {
                AppMethodBeat.i(182906);
                if ((a.this.hve != null) && (a.this.hve.hvm != null)) {}
                for (Object localObject = Integer.valueOf(a.this.hve.hvm.getType());; localObject = "")
                {
                  ac.i("MicroMsg.Cgi", "[dead] cgi=%s", new Object[] { localObject });
                  a.this.cancel();
                  AppMethodBeat.o(182906);
                  return;
                }
              }
            });
            paramAnonymousb = super.a(paramAnonymousb);
            AppMethodBeat.o(182907);
            return paramAnonymousb;
          }
        }.b(new c.a() {});
      }
      f localf = this.hvf;
      AppMethodBeat.o(132300);
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
    AppMethodBeat.i(132298);
    if (this.hvg.compareAndSet(false, true)) {
      if ((this.hve == null) || (this.hve.hvm == null)) {
        break label118;
      }
    }
    label118:
    for (Object localObject = Integer.valueOf(this.hve.hvm.getType());; localObject = "")
    {
      ac.i("MicroMsg.Cgi", "[cancel] cgi=%s", new Object[] { localObject });
      if (this.hve != null)
      {
        this.hve.hvn.resume();
        this.hve.hvn = null;
        x.a(this.hve);
      }
      if (this.hvf != null) {
        this.hvf.ym(true);
      }
      AppMethodBeat.o(132298);
      return;
    }
  }
  
  public static final class a<T extends cqk>
  {
    public n dcV;
    public int errCode;
    public String errMsg;
    public int errType;
    public T hvj;
    public a hvk;
    
    public static <T extends cqk> a<T> a(int paramInt1, int paramInt2, String paramString, T paramT, n paramn, a parama)
    {
      AppMethodBeat.i(132293);
      a locala = new a();
      locala.errType = paramInt1;
      locala.errCode = paramInt2;
      locala.errMsg = paramString;
      locala.hvj = paramT;
      locala.dcV = paramn;
      locala.hvk = parama;
      if (parama != null) {
        parama.a(paramInt1, paramInt2, paramString, paramT, paramn);
      }
      AppMethodBeat.o(132293);
      return locala;
    }
  }
  
  static final class b<_Resp extends cqk>
    extends n
  {
    g gfX;
    final n hvl;
    b hvm;
    com.tencent.mm.vending.g.b hvn;
    a hvo;
    private k hvp;
    final long mStartTime;
    
    public b(a parama)
    {
      AppMethodBeat.i(132295);
      this.gfX = null;
      this.hvl = this;
      this.mStartTime = bs.eWj();
      this.hvp = new k()
      {
        public final void onGYNetEnd(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, String paramAnonymousString, q paramAnonymousq, byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(132294);
          if (a.b.this.hvo.hvg.get())
          {
            if ((a.b.this.hvo.hve != null) && (a.b.this.hvo.hve.hvm != null)) {}
            for (paramAnonymousq = Integer.valueOf(a.b.this.hvo.hve.hvm.getType());; paramAnonymousq = "")
            {
              ac.w("MicroMsg.Cgi", "[onGYNetEnd] has cancel. cgi=%s", new Object[] { paramAnonymousq });
              a.b.this.gfX.onSceneEnd(paramAnonymousInt2, paramAnonymousInt3, paramAnonymousString, a.b.this.hvl);
              com.tencent.mm.vending.g.g.a(a.b.this.hvn);
              AppMethodBeat.o(132294);
              return;
            }
          }
          com.tencent.mm.vending.g.g.a(a.b.this.hvn, new Object[] { a.a.a(paramAnonymousInt2, paramAnonymousInt3, paramAnonymousString, (cqk)a.b.this.hvm.hvs.hvw, a.b.this, a.b.this.hvo) });
          a.b.this.gfX.onSceneEnd(paramAnonymousInt2, paramAnonymousInt3, paramAnonymousString, a.b.this.hvl);
          ac.i("MicroMsg.Cgi", "onGYNetEnd:%d func:%d time:%d [%d,%d,%s]", new Object[] { Integer.valueOf(a.b.this.hvl.hashCode()), Integer.valueOf(a.b.this.getType()), Long.valueOf(bs.eWj() - a.b.this.mStartTime), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), paramAnonymousString });
          AppMethodBeat.o(132294);
        }
      };
      this.hvo = parama;
      AppMethodBeat.o(132295);
    }
    
    public final int doScene(com.tencent.mm.network.e parame, g paramg)
    {
      AppMethodBeat.i(132297);
      this.gfX = paramg;
      int i = dispatch(parame, this.hvm, this.hvp);
      ac.i("MicroMsg.Cgi", "Start doScene:%d func:%d netid:%d time:%d", new Object[] { Integer.valueOf(this.hvl.hashCode()), Integer.valueOf(getType()), Integer.valueOf(i), Long.valueOf(bs.eWj() - this.mStartTime) });
      if (i < 0) {
        com.tencent.mm.vending.g.g.a(this.hvn, new Object[] { a.a.a(3, -1, "", (cqk)this.hvm.hvs.hvw, this, this.hvo) });
      }
      AppMethodBeat.o(132297);
      return i;
    }
    
    public final int getType()
    {
      AppMethodBeat.i(132296);
      int i = this.hvm.getType();
      AppMethodBeat.o(132296);
      return i;
    }
    
    protected final int securityLimitCount()
    {
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ak.a
 * JD-Core Version:    0.7.0.1
 */