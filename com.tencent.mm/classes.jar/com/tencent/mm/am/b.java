package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cp.f;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.g.c.a;
import com.tencent.mm.vending.g.e;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;

public class b<_Resp extends esc>
  implements a
{
  private b<_Resp> oto;
  private f<a<_Resp>> otp;
  private AtomicBoolean otq;
  public boolean otr;
  public c rr;
  
  public b()
  {
    AppMethodBeat.i(182916);
    this.otq = new AtomicBoolean(false);
    this.otr = false;
    this.oto = new b(this);
    AppMethodBeat.o(182916);
  }
  
  protected static int securityLimitCount()
  {
    return 1;
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString, _Resp param_Resp, p paramp) {}
  
  public f<a<_Resp>> bFJ()
  {
    try
    {
      AppMethodBeat.i(182917);
      Assert.assertNotNull("You should set a CommReqResp!", this.rr);
      Assert.assertTrue("RunCgi NetSceneQueue not ready!", z.bGx());
      f localf = null;
      if (this.otp == null)
      {
        localf = new f()new c.a
        {
          public final f a(com.tencent.mm.vending.e.b paramAnonymousb)
          {
            AppMethodBeat.i(182907);
            paramAnonymousb.keep(b.this);
            paramAnonymousb = super.a(paramAnonymousb);
            AppMethodBeat.o(182907);
            return paramAnonymousb;
          }
        }.b(new c.a() {});
        this.otp = localf;
      }
      AppMethodBeat.o(182917);
      return localf;
    }
    finally {}
  }
  
  public final void c(c paramc)
  {
    this.rr = paramc;
    this.oto.otw = paramc;
  }
  
  public void cancel()
  {
    AppMethodBeat.i(182915);
    if (this.otq.compareAndSet(false, true)) {
      if ((this.oto == null) || (b.a(this.oto) == null)) {
        break label105;
      }
    }
    label105:
    for (Object localObject = Integer.valueOf(b.a(this.oto).getType());; localObject = "")
    {
      Log.i("MicroMsg.Cgi", "[cancel] cgi=%s", new Object[] { localObject });
      if (this.oto != null)
      {
        this.oto.a(null);
        z.a(this.oto);
      }
      localObject = this.otp;
      if (localObject != null) {
        ((e)localObject).NN(true);
      }
      AppMethodBeat.o(182915);
      return;
    }
  }
  
  public void dead()
  {
    AppMethodBeat.i(236780);
    b localb = this.oto;
    if ((localb != null) && (b.a(localb) != null))
    {
      localObject = Integer.valueOf(b.a(localb).getType());
      Log.i("MicroMsg.Cgi", "[afterDead] cgi=%s", new Object[] { localObject });
      if (!this.otr) {
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
      this.otp = null;
      AppMethodBeat.o(236780);
      return;
      localObject = "";
      break;
    }
  }
  
  public static class a<T extends esc>
  {
    public int errCode;
    public String errMsg;
    public int errType;
    public p hEi;
    public T ott;
    public b otu;
    
    public static <T extends esc> a<T> a(int paramInt1, int paramInt2, String paramString, T paramT, p paramp, b paramb)
    {
      AppMethodBeat.i(182910);
      a locala = new a();
      locala.errType = paramInt1;
      locala.errCode = paramInt2;
      locala.errMsg = paramString;
      locala.ott = paramT;
      locala.hEi = paramp;
      locala.otu = paramb;
      if (paramb != null) {
        paramb.a(paramInt1, paramInt2, paramString, paramT, paramp);
      }
      AppMethodBeat.o(182910);
      return locala;
    }
  }
  
  static final class b<_Resp extends esc>
    extends p
  {
    private h mAY;
    private final long mStartTime;
    private final p otv;
    c otw;
    private WeakReference<com.tencent.mm.vending.g.b> otx;
    private b oty;
    private m otz;
    
    public b(b paramb)
    {
      AppMethodBeat.i(182912);
      this.mAY = null;
      this.otv = this;
      this.mStartTime = Util.nowMilliSecond();
      this.otz = new m()
      {
        public final void onGYNetEnd(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, String paramAnonymousString, s paramAnonymouss, byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(182911);
          if (b.a(b.this).get())
          {
            if ((b.b(b.this) != null) && (b.b.a(b.b(b.this)) != null)) {}
            for (paramAnonymouss = Integer.valueOf(b.b.a(b.b(b.this)).getType());; paramAnonymouss = "")
            {
              Log.w("MicroMsg.Cgi", "[onGYNetEnd] has cancel. cgi=%s", new Object[] { paramAnonymouss });
              b.b.d(b.b.this).onSceneEnd(paramAnonymousInt2, paramAnonymousInt3, paramAnonymousString, b.b.c(b.b.this));
              AppMethodBeat.o(182911);
              return;
            }
          }
          com.tencent.mm.vending.g.g.a((com.tencent.mm.vending.g.b)b.b.e(b.b.this).get(), new Object[] { b.a.a(paramAnonymousInt2, paramAnonymousInt3, paramAnonymousString, (esc)c.c.b(b.b.a(b.b.this).otC), b.b.this, b.this) });
          b.b.d(b.b.this).onSceneEnd(paramAnonymousInt2, paramAnonymousInt3, paramAnonymousString, b.b.c(b.b.this));
          Log.i("MicroMsg.Cgi", "onGYNetEnd:%d func:%d time:%d [%d,%d,%s]", new Object[] { Integer.valueOf(b.b.c(b.b.this).hashCode()), Integer.valueOf(b.b.this.getType()), Long.valueOf(Util.nowMilliSecond() - b.b.f(b.b.this)), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), paramAnonymousString });
          AppMethodBeat.o(182911);
        }
      };
      this.oty = paramb;
      AppMethodBeat.o(182912);
    }
    
    public final void a(com.tencent.mm.vending.g.b paramb)
    {
      AppMethodBeat.i(236770);
      this.otx = new WeakReference(paramb);
      AppMethodBeat.o(236770);
    }
    
    public final int doScene(com.tencent.mm.network.g paramg, h paramh)
    {
      AppMethodBeat.i(182914);
      this.mAY = paramh;
      int i = dispatch(paramg, this.otw, this.otz);
      Log.i("MicroMsg.Cgi", "Start doScene:%d func:%d netid:%d time:%d", new Object[] { Integer.valueOf(this.otv.hashCode()), Integer.valueOf(getType()), Integer.valueOf(i), Long.valueOf(Util.nowMilliSecond() - this.mStartTime) });
      if (i < 0) {
        com.tencent.mm.vending.g.g.a((com.tencent.mm.vending.g.b)this.otx.get(), new Object[] { b.a.a(3, -1, "", (esc)c.c.b(this.otw.otC), this, this.oty) });
      }
      AppMethodBeat.o(182914);
      return i;
    }
    
    public final int getType()
    {
      AppMethodBeat.i(182913);
      int i = this.otw.getType();
      AppMethodBeat.o(182913);
      return i;
    }
    
    protected final int securityLimitCount()
    {
      AppMethodBeat.i(236772);
      int i = b.securityLimitCount();
      AppMethodBeat.o(236772);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.am.b
 * JD-Core Version:    0.7.0.1
 */