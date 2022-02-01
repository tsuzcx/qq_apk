package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vending.g.c.a;
import com.tencent.mm.vending.g.g;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;

public class a<_Resp extends cvp>
{
  b<_Resp> hNw;
  com.tencent.mm.cn.f<a.a<_Resp>> hNx;
  AtomicBoolean hNy;
  public boolean hNz;
  private b rr;
  
  public a()
  {
    AppMethodBeat.i(182916);
    this.hNy = new AtomicBoolean(false);
    this.hNz = false;
    this.hNw = new b(this);
    AppMethodBeat.o(182916);
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString, _Resp param_Resp, n paramn) {}
  
  public final a<_Resp> aEC()
  {
    this.hNz = true;
    return this;
  }
  
  public com.tencent.mm.cn.f<a.a<_Resp>> aED()
  {
    try
    {
      AppMethodBeat.i(182917);
      Assert.assertNotNull("You should set a CommReqResp!", this.rr);
      Assert.assertTrue("RunCgi NetSceneQueue not ready!", x.aFq());
      com.tencent.mm.cn.f localf = null;
      if (this.hNx == null)
      {
        localf = new com.tencent.mm.cn.f()new c.a
        {
          public final com.tencent.mm.cn.f a(com.tencent.mm.vending.e.b paramAnonymousb)
          {
            AppMethodBeat.i(182907);
            paramAnonymousb.keep(new com.tencent.mm.vending.e.a()
            {
              public final void dead()
              {
                AppMethodBeat.i(182906);
                a locala = a.this;
                a.b localb = locala.hNw;
                if ((localb != null) && (localb.hNF != null))
                {
                  localObject = Integer.valueOf(localb.hNF.getType());
                  ad.i("MicroMsg.Cgi", "[afterDead] cgi=%s", new Object[] { localObject });
                  if (!locala.hNz) {
                    if ((localb == null) || (localb.hNF == null)) {
                      break label120;
                    }
                  }
                }
                label120:
                for (Object localObject = Integer.valueOf(localb.hNF.getType());; localObject = "")
                {
                  ad.i("MicroMsg.Cgi", "[cancelAfterDead] do cancel of cgi=%s", new Object[] { localObject });
                  locala.cancel();
                  locala.hNx = null;
                  AppMethodBeat.o(182906);
                  return;
                  localObject = "";
                  break;
                }
              }
            });
            paramAnonymousb = super.a(paramAnonymousb);
            AppMethodBeat.o(182907);
            return paramAnonymousb;
          }
        }.b(new c.a() {});
        this.hNx = localf;
      }
      AppMethodBeat.o(182917);
      return localf;
    }
    finally {}
  }
  
  public final void c(b paramb)
  {
    this.rr = paramb;
    this.hNw.hNF = paramb;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(182915);
    if (this.hNy.compareAndSet(false, true)) {
      if ((this.hNw == null) || (this.hNw.hNF == null)) {
        break label105;
      }
    }
    label105:
    for (Object localObject = Integer.valueOf(this.hNw.hNF.getType());; localObject = "")
    {
      ad.i("MicroMsg.Cgi", "[cancel] cgi=%s", new Object[] { localObject });
      if (this.hNw != null)
      {
        this.hNw.a(null);
        x.a(this.hNw);
      }
      localObject = this.hNx;
      if (localObject != null) {
        ((com.tencent.mm.vending.g.e)localObject).yY(true);
      }
      AppMethodBeat.o(182915);
      return;
    }
  }
  
  static final class b<_Resp extends cvp>
    extends n
  {
    f gzH;
    final n hNE;
    b hNF;
    WeakReference<com.tencent.mm.vending.g.b> hNG;
    a hNH;
    private k hNI;
    final long mStartTime;
    
    public b(a parama)
    {
      AppMethodBeat.i(182912);
      this.gzH = null;
      this.hNE = this;
      this.mStartTime = bt.flT();
      this.hNI = new k()
      {
        public final void onGYNetEnd(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, String paramAnonymousString, q paramAnonymousq, byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(182911);
          if (a.b.this.hNH.hNy.get())
          {
            if ((a.b.this.hNH.hNw != null) && (a.b.this.hNH.hNw.hNF != null)) {}
            for (paramAnonymousq = Integer.valueOf(a.b.this.hNH.hNw.hNF.getType());; paramAnonymousq = "")
            {
              ad.w("MicroMsg.Cgi", "[onGYNetEnd] has cancel. cgi=%s", new Object[] { paramAnonymousq });
              a.b.this.gzH.onSceneEnd(paramAnonymousInt2, paramAnonymousInt3, paramAnonymousString, a.b.this.hNE);
              AppMethodBeat.o(182911);
              return;
            }
          }
          g.a((com.tencent.mm.vending.g.b)a.b.this.hNG.get(), new Object[] { a.a.a(paramAnonymousInt2, paramAnonymousInt3, paramAnonymousString, (cvp)a.b.this.hNF.hNL.hNQ, a.b.this, a.b.this.hNH) });
          a.b.this.gzH.onSceneEnd(paramAnonymousInt2, paramAnonymousInt3, paramAnonymousString, a.b.this.hNE);
          ad.i("MicroMsg.Cgi", "onGYNetEnd:%d func:%d time:%d [%d,%d,%s]", new Object[] { Integer.valueOf(a.b.this.hNE.hashCode()), Integer.valueOf(a.b.this.getType()), Long.valueOf(bt.flT() - a.b.this.mStartTime), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), paramAnonymousString });
          AppMethodBeat.o(182911);
        }
      };
      this.hNH = parama;
      AppMethodBeat.o(182912);
    }
    
    public final void a(com.tencent.mm.vending.g.b paramb)
    {
      AppMethodBeat.i(189832);
      this.hNG = new WeakReference(paramb);
      AppMethodBeat.o(189832);
    }
    
    public final int doScene(com.tencent.mm.network.e parame, f paramf)
    {
      AppMethodBeat.i(182914);
      this.gzH = paramf;
      int i = dispatch(parame, this.hNF, this.hNI);
      ad.i("MicroMsg.Cgi", "Start doScene:%d func:%d netid:%d time:%d", new Object[] { Integer.valueOf(this.hNE.hashCode()), Integer.valueOf(getType()), Integer.valueOf(i), Long.valueOf(bt.flT() - this.mStartTime) });
      if (i < 0) {
        g.a((com.tencent.mm.vending.g.b)this.hNG.get(), new Object[] { a.a.a(3, -1, "", (cvp)this.hNF.hNL.hNQ, this, this.hNH) });
      }
      AppMethodBeat.o(182914);
      return i;
    }
    
    public final int getType()
    {
      AppMethodBeat.i(182913);
      int i = this.hNF.getType();
      AppMethodBeat.o(182913);
      return i;
    }
    
    protected final int securityLimitCount()
    {
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.al.a
 * JD-Core Version:    0.7.0.1
 */