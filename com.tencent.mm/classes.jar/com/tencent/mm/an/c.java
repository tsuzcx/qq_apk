package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cw.f;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.g.e;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;

public class c<_Resp extends dyy>
  implements a
{
  private b<_Resp> lBE;
  private f<c.a<_Resp>> lBF;
  private AtomicBoolean lBG;
  public boolean lBH;
  public d rr;
  
  public c()
  {
    AppMethodBeat.i(182916);
    this.lBG = new AtomicBoolean(false);
    this.lBH = false;
    this.lBE = new b(this);
    AppMethodBeat.o(182916);
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString, _Resp param_Resp, q paramq) {}
  
  public final d bhU()
  {
    return this.rr;
  }
  
  public final c<_Resp> bhV()
  {
    this.lBH = true;
    return this;
  }
  
  public f<c.a<_Resp>> bhW()
  {
    try
    {
      AppMethodBeat.i(182917);
      Assert.assertNotNull("You should set a CommReqResp!", this.rr);
      Assert.assertTrue("RunCgi NetSceneQueue not ready!", aa.biN());
      f localf = null;
      if (this.lBF == null)
      {
        localf = new f()new com.tencent.mm.vending.g.c.a
        {
          public final f a(com.tencent.mm.vending.e.b paramAnonymousb)
          {
            AppMethodBeat.i(182907);
            paramAnonymousb.keep(c.this);
            paramAnonymousb = super.a(paramAnonymousb);
            AppMethodBeat.o(182907);
            return paramAnonymousb;
          }
        }.b(new com.tencent.mm.vending.g.c.a() {});
        this.lBF = localf;
      }
      AppMethodBeat.o(182917);
      return localf;
    }
    finally {}
  }
  
  public final void c(d paramd)
  {
    this.rr = paramd;
    this.lBE.lBM = paramd;
  }
  
  public void cancel()
  {
    AppMethodBeat.i(182915);
    if (this.lBG.compareAndSet(false, true)) {
      if ((this.lBE == null) || (b.a(this.lBE) == null)) {
        break label105;
      }
    }
    label105:
    for (Object localObject = Integer.valueOf(b.a(this.lBE).getType());; localObject = "")
    {
      Log.i("MicroMsg.Cgi", "[cancel] cgi=%s", new Object[] { localObject });
      if (this.lBE != null)
      {
        this.lBE.a(null);
        aa.a(this.lBE);
      }
      localObject = this.lBF;
      if (localObject != null) {
        ((e)localObject).HS(true);
      }
      AppMethodBeat.o(182915);
      return;
    }
  }
  
  public void dead()
  {
    AppMethodBeat.i(201902);
    b localb = this.lBE;
    if ((localb != null) && (b.a(localb) != null))
    {
      localObject = Integer.valueOf(b.a(localb).getType());
      Log.i("MicroMsg.Cgi", "[afterDead] cgi=%s", new Object[] { localObject });
      if (!this.lBH) {
        if ((localb == null) || (b.a(localb) == null)) {
          break label112;
        }
      }
    }
    label112:
    for (Object localObject = Integer.valueOf(b.a(localb).getType());; localObject = "")
    {
      Log.i("MicroMsg.Cgi", "[cancelAfterDead] do cancel of cgi=%s", new Object[] { localObject });
      cancel();
      this.lBF = null;
      AppMethodBeat.o(201902);
      return;
      localObject = "";
      break;
    }
  }
  
  static final class b<_Resp extends dyy>
    extends q
  {
    private i jQg;
    private final q lBL;
    d lBM;
    private WeakReference<com.tencent.mm.vending.g.b> lBN;
    private c lBO;
    private m lBP;
    private final long mStartTime;
    
    public b(c paramc)
    {
      AppMethodBeat.i(182912);
      this.jQg = null;
      this.lBL = this;
      this.mStartTime = Util.nowMilliSecond();
      this.lBP = new m()
      {
        public final void onGYNetEnd(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, String paramAnonymousString, s paramAnonymouss, byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(182911);
          if (c.a(c.this).get())
          {
            if ((c.b(c.this) != null) && (c.b.a(c.b(c.this)) != null)) {}
            for (paramAnonymouss = Integer.valueOf(c.b.a(c.b(c.this)).getType());; paramAnonymouss = "")
            {
              Log.w("MicroMsg.Cgi", "[onGYNetEnd] has cancel. cgi=%s", new Object[] { paramAnonymouss });
              c.b.d(c.b.this).onSceneEnd(paramAnonymousInt2, paramAnonymousInt3, paramAnonymousString, c.b.c(c.b.this));
              AppMethodBeat.o(182911);
              return;
            }
          }
          com.tencent.mm.vending.g.g.a((com.tencent.mm.vending.g.b)c.b.e(c.b.this).get(), new Object[] { c.a.a(paramAnonymousInt2, paramAnonymousInt3, paramAnonymousString, (dyy)d.c.b(c.b.a(c.b.this).lBS), c.b.this, c.this) });
          c.b.d(c.b.this).onSceneEnd(paramAnonymousInt2, paramAnonymousInt3, paramAnonymousString, c.b.c(c.b.this));
          Log.i("MicroMsg.Cgi", "onGYNetEnd:%d func:%d time:%d [%d,%d,%s]", new Object[] { Integer.valueOf(c.b.c(c.b.this).hashCode()), Integer.valueOf(c.b.this.getType()), Long.valueOf(Util.nowMilliSecond() - c.b.f(c.b.this)), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), paramAnonymousString });
          AppMethodBeat.o(182911);
        }
      };
      this.lBO = paramc;
      AppMethodBeat.o(182912);
    }
    
    public final void a(com.tencent.mm.vending.g.b paramb)
    {
      AppMethodBeat.i(202159);
      this.lBN = new WeakReference(paramb);
      AppMethodBeat.o(202159);
    }
    
    public final int doScene(com.tencent.mm.network.g paramg, i parami)
    {
      AppMethodBeat.i(182914);
      this.jQg = parami;
      int i = dispatch(paramg, this.lBM, this.lBP);
      Log.i("MicroMsg.Cgi", "Start doScene:%d func:%d netid:%d time:%d", new Object[] { Integer.valueOf(this.lBL.hashCode()), Integer.valueOf(getType()), Integer.valueOf(i), Long.valueOf(Util.nowMilliSecond() - this.mStartTime) });
      if (i < 0) {
        com.tencent.mm.vending.g.g.a((com.tencent.mm.vending.g.b)this.lBN.get(), new Object[] { c.a.a(3, -1, "", (dyy)d.c.b(this.lBM.lBS), this, this.lBO) });
      }
      AppMethodBeat.o(182914);
      return i;
    }
    
    public final int getType()
    {
      AppMethodBeat.i(182913);
      int i = this.lBM.getType();
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
 * Qualified Name:     com.tencent.mm.an.c
 * JD-Core Version:    0.7.0.1
 */