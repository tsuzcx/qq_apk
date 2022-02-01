package com.tencent.mm.ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.g.e;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;

public class c<_Resp extends dpc>
  implements a
{
  public boolean iLA;
  b<_Resp> iLx;
  private f<a<_Resp>> iLy;
  AtomicBoolean iLz;
  protected d rr;
  
  public c()
  {
    AppMethodBeat.i(182916);
    this.iLz = new AtomicBoolean(false);
    this.iLA = false;
    this.iLx = new b(this);
    AppMethodBeat.o(182916);
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString, _Resp param_Resp, q paramq) {}
  
  public final d aYG()
  {
    return this.rr;
  }
  
  public final c<_Resp> aYH()
  {
    this.iLA = true;
    return this;
  }
  
  public f<a<_Resp>> aYI()
  {
    try
    {
      AppMethodBeat.i(182917);
      Assert.assertNotNull("You should set a CommReqResp!", this.rr);
      Assert.assertTrue("RunCgi NetSceneQueue not ready!", aa.aZx());
      f localf = null;
      if (this.iLy == null)
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
        this.iLy = localf;
      }
      AppMethodBeat.o(182917);
      return localf;
    }
    finally {}
  }
  
  public final void c(d paramd)
  {
    this.rr = paramd;
    this.iLx.iLF = paramd;
  }
  
  public void cancel()
  {
    AppMethodBeat.i(182915);
    if (this.iLz.compareAndSet(false, true)) {
      if ((this.iLx == null) || (this.iLx.iLF == null)) {
        break label105;
      }
    }
    label105:
    for (Object localObject = Integer.valueOf(this.iLx.iLF.getType());; localObject = "")
    {
      Log.i("MicroMsg.Cgi", "[cancel] cgi=%s", new Object[] { localObject });
      if (this.iLx != null)
      {
        this.iLx.a(null);
        aa.a(this.iLx);
      }
      localObject = this.iLy;
      if (localObject != null) {
        ((e)localObject).Dv(true);
      }
      AppMethodBeat.o(182915);
      return;
    }
  }
  
  public void dead()
  {
    AppMethodBeat.i(197059);
    b localb = this.iLx;
    if ((localb != null) && (localb.iLF != null))
    {
      localObject = Integer.valueOf(localb.iLF.getType());
      Log.i("MicroMsg.Cgi", "[afterDead] cgi=%s", new Object[] { localObject });
      if (!this.iLA) {
        if ((localb == null) || (localb.iLF == null)) {
          break label112;
        }
      }
    }
    label112:
    for (Object localObject = Integer.valueOf(localb.iLF.getType());; localObject = "")
    {
      Log.i("MicroMsg.Cgi", "[cancelAfterDead] do cancel of cgi=%s", new Object[] { localObject });
      cancel();
      this.iLy = null;
      AppMethodBeat.o(197059);
      return;
      localObject = "";
      break;
    }
  }
  
  public static class a<T extends dpc>
  {
    public q dGJ;
    public int errCode;
    public String errMsg;
    public int errType;
    public T iLC;
    public c iLD;
    
    public static <T extends dpc> a<T> a(int paramInt1, int paramInt2, String paramString, T paramT, q paramq, c paramc)
    {
      AppMethodBeat.i(182910);
      a locala = new a();
      locala.errType = paramInt1;
      locala.errCode = paramInt2;
      locala.errMsg = paramString;
      locala.iLC = paramT;
      locala.dGJ = paramq;
      locala.iLD = paramc;
      if (paramc != null) {
        paramc.a(paramInt1, paramInt2, paramString, paramT, paramq);
      }
      AppMethodBeat.o(182910);
      return locala;
    }
  }
  
  static final class b<_Resp extends dpc>
    extends q
  {
    i heq;
    final q iLE;
    d iLF;
    WeakReference<com.tencent.mm.vending.g.b> iLG;
    c iLH;
    private m iLI;
    final long mStartTime;
    
    public b(c paramc)
    {
      AppMethodBeat.i(182912);
      this.heq = null;
      this.iLE = this;
      this.mStartTime = Util.nowMilliSecond();
      this.iLI = new m()
      {
        public final void onGYNetEnd(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, String paramAnonymousString, s paramAnonymouss, byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(182911);
          if (c.b.this.iLH.iLz.get())
          {
            if ((c.b.this.iLH.iLx != null) && (c.b.this.iLH.iLx.iLF != null)) {}
            for (paramAnonymouss = Integer.valueOf(c.b.this.iLH.iLx.iLF.getType());; paramAnonymouss = "")
            {
              Log.w("MicroMsg.Cgi", "[onGYNetEnd] has cancel. cgi=%s", new Object[] { paramAnonymouss });
              c.b.this.heq.onSceneEnd(paramAnonymousInt2, paramAnonymousInt3, paramAnonymousString, c.b.this.iLE);
              AppMethodBeat.o(182911);
              return;
            }
          }
          com.tencent.mm.vending.g.g.a((com.tencent.mm.vending.g.b)c.b.this.iLG.get(), new Object[] { c.a.a(paramAnonymousInt2, paramAnonymousInt3, paramAnonymousString, (dpc)c.b.this.iLF.iLL.iLR, c.b.this, c.b.this.iLH) });
          c.b.this.heq.onSceneEnd(paramAnonymousInt2, paramAnonymousInt3, paramAnonymousString, c.b.this.iLE);
          Log.i("MicroMsg.Cgi", "onGYNetEnd:%d func:%d time:%d [%d,%d,%s]", new Object[] { Integer.valueOf(c.b.this.iLE.hashCode()), Integer.valueOf(c.b.this.getType()), Long.valueOf(Util.nowMilliSecond() - c.b.this.mStartTime), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), paramAnonymousString });
          AppMethodBeat.o(182911);
        }
      };
      this.iLH = paramc;
      AppMethodBeat.o(182912);
    }
    
    public final void a(com.tencent.mm.vending.g.b paramb)
    {
      AppMethodBeat.i(197058);
      this.iLG = new WeakReference(paramb);
      AppMethodBeat.o(197058);
    }
    
    public final int doScene(com.tencent.mm.network.g paramg, i parami)
    {
      AppMethodBeat.i(182914);
      this.heq = parami;
      int i = dispatch(paramg, this.iLF, this.iLI);
      Log.i("MicroMsg.Cgi", "Start doScene:%d func:%d netid:%d time:%d", new Object[] { Integer.valueOf(this.iLE.hashCode()), Integer.valueOf(getType()), Integer.valueOf(i), Long.valueOf(Util.nowMilliSecond() - this.mStartTime) });
      if (i < 0) {
        com.tencent.mm.vending.g.g.a((com.tencent.mm.vending.g.b)this.iLG.get(), new Object[] { c.a.a(3, -1, "", (dpc)this.iLF.iLL.iLR, this, this.iLH) });
      }
      AppMethodBeat.o(182914);
      return i;
    }
    
    public final int getType()
    {
      AppMethodBeat.i(182913);
      int i = this.iLF.getType();
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
 * Qualified Name:     com.tencent.mm.ak.c
 * JD-Core Version:    0.7.0.1
 */