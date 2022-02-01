package com.tencent.mm.ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vending.g.c.a;
import com.tencent.mm.vending.g.g;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;

public class a<_Resp extends cwj>
{
  b<_Resp> hQp;
  com.tencent.mm.cm.f<a.a<_Resp>> hQq;
  AtomicBoolean hQr;
  public boolean hQs;
  private b rr;
  
  public a()
  {
    AppMethodBeat.i(182916);
    this.hQr = new AtomicBoolean(false);
    this.hQs = false;
    this.hQp = new b(this);
    AppMethodBeat.o(182916);
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString, _Resp param_Resp, n paramn) {}
  
  public final a<_Resp> aES()
  {
    this.hQs = true;
    return this;
  }
  
  public com.tencent.mm.cm.f<a.a<_Resp>> aET()
  {
    try
    {
      AppMethodBeat.i(182917);
      Assert.assertNotNull("You should set a CommReqResp!", this.rr);
      Assert.assertTrue("RunCgi NetSceneQueue not ready!", x.aFG());
      com.tencent.mm.cm.f localf = null;
      if (this.hQq == null)
      {
        localf = new com.tencent.mm.cm.f()new c.a
        {
          public final com.tencent.mm.cm.f a(com.tencent.mm.vending.e.b paramAnonymousb)
          {
            AppMethodBeat.i(182907);
            paramAnonymousb.keep(new com.tencent.mm.vending.e.a()
            {
              public final void dead()
              {
                AppMethodBeat.i(182906);
                a locala = a.this;
                a.b localb = locala.hQp;
                if ((localb != null) && (localb.hQy != null))
                {
                  localObject = Integer.valueOf(localb.hQy.getType());
                  ae.i("MicroMsg.Cgi", "[afterDead] cgi=%s", new Object[] { localObject });
                  if (!locala.hQs) {
                    if ((localb == null) || (localb.hQy == null)) {
                      break label120;
                    }
                  }
                }
                label120:
                for (Object localObject = Integer.valueOf(localb.hQy.getType());; localObject = "")
                {
                  ae.i("MicroMsg.Cgi", "[cancelAfterDead] do cancel of cgi=%s", new Object[] { localObject });
                  locala.cancel();
                  locala.hQq = null;
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
        this.hQq = localf;
      }
      AppMethodBeat.o(182917);
      return localf;
    }
    finally {}
  }
  
  public final void c(b paramb)
  {
    this.rr = paramb;
    this.hQp.hQy = paramb;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(182915);
    if (this.hQr.compareAndSet(false, true)) {
      if ((this.hQp == null) || (this.hQp.hQy == null)) {
        break label105;
      }
    }
    label105:
    for (Object localObject = Integer.valueOf(this.hQp.hQy.getType());; localObject = "")
    {
      ae.i("MicroMsg.Cgi", "[cancel] cgi=%s", new Object[] { localObject });
      if (this.hQp != null)
      {
        this.hQp.a(null);
        x.a(this.hQp);
      }
      localObject = this.hQq;
      if (localObject != null) {
        ((com.tencent.mm.vending.g.e)localObject).zm(true);
      }
      AppMethodBeat.o(182915);
      return;
    }
  }
  
  static final class b<_Resp extends cwj>
    extends n
  {
    f gCo;
    a hQA;
    private k hQB;
    final n hQx;
    b hQy;
    WeakReference<com.tencent.mm.vending.g.b> hQz;
    final long mStartTime;
    
    public b(a parama)
    {
      AppMethodBeat.i(182912);
      this.gCo = null;
      this.hQx = this;
      this.mStartTime = bu.fpO();
      this.hQB = new k()
      {
        public final void onGYNetEnd(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, String paramAnonymousString, q paramAnonymousq, byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(182911);
          if (a.b.this.hQA.hQr.get())
          {
            if ((a.b.this.hQA.hQp != null) && (a.b.this.hQA.hQp.hQy != null)) {}
            for (paramAnonymousq = Integer.valueOf(a.b.this.hQA.hQp.hQy.getType());; paramAnonymousq = "")
            {
              ae.w("MicroMsg.Cgi", "[onGYNetEnd] has cancel. cgi=%s", new Object[] { paramAnonymousq });
              a.b.this.gCo.onSceneEnd(paramAnonymousInt2, paramAnonymousInt3, paramAnonymousString, a.b.this.hQx);
              AppMethodBeat.o(182911);
              return;
            }
          }
          g.a((com.tencent.mm.vending.g.b)a.b.this.hQz.get(), new Object[] { a.a.a(paramAnonymousInt2, paramAnonymousInt3, paramAnonymousString, (cwj)a.b.this.hQy.hQE.hQJ, a.b.this, a.b.this.hQA) });
          a.b.this.gCo.onSceneEnd(paramAnonymousInt2, paramAnonymousInt3, paramAnonymousString, a.b.this.hQx);
          ae.i("MicroMsg.Cgi", "onGYNetEnd:%d func:%d time:%d [%d,%d,%s]", new Object[] { Integer.valueOf(a.b.this.hQx.hashCode()), Integer.valueOf(a.b.this.getType()), Long.valueOf(bu.fpO() - a.b.this.mStartTime), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), paramAnonymousString });
          AppMethodBeat.o(182911);
        }
      };
      this.hQA = parama;
      AppMethodBeat.o(182912);
    }
    
    public final void a(com.tencent.mm.vending.g.b paramb)
    {
      AppMethodBeat.i(193550);
      this.hQz = new WeakReference(paramb);
      AppMethodBeat.o(193550);
    }
    
    public final int doScene(com.tencent.mm.network.e parame, f paramf)
    {
      AppMethodBeat.i(182914);
      this.gCo = paramf;
      int i = dispatch(parame, this.hQy, this.hQB);
      ae.i("MicroMsg.Cgi", "Start doScene:%d func:%d netid:%d time:%d", new Object[] { Integer.valueOf(this.hQx.hashCode()), Integer.valueOf(getType()), Integer.valueOf(i), Long.valueOf(bu.fpO() - this.mStartTime) });
      if (i < 0) {
        g.a((com.tencent.mm.vending.g.b)this.hQz.get(), new Object[] { a.a.a(3, -1, "", (cwj)this.hQy.hQE.hQJ, this, this.hQA) });
      }
      AppMethodBeat.o(182914);
      return i;
    }
    
    public final int getType()
    {
      AppMethodBeat.i(182913);
      int i = this.hQy.getType();
      AppMethodBeat.o(182913);
      return i;
    }
    
    protected final int securityLimitCount()
    {
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ak.a
 * JD-Core Version:    0.7.0.1
 */