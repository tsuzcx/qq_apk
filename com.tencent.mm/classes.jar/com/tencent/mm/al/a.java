package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vending.g.c.a;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;

public class a<_Resp extends cld>
{
  b<_Resp> gUF;
  private f<a<_Resp>> gUG;
  AtomicBoolean gUH;
  protected b rr;
  
  public a()
  {
    AppMethodBeat.i(132299);
    this.gUH = new AtomicBoolean(false);
    this.gUF = new b(this);
    AppMethodBeat.o(132299);
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString, _Resp param_Resp, n paramn) {}
  
  public f<a<_Resp>> auK()
  {
    try
    {
      AppMethodBeat.i(132300);
      Assert.assertNotNull("You should set a CommReqResp!", this.rr);
      Assert.assertTrue("RunCgi NetSceneQueue not ready!", x.avu());
      if (this.gUG == null) {
        this.gUG = new f()new c.a
        {
          public final f a(com.tencent.mm.vending.e.b paramAnonymousb)
          {
            AppMethodBeat.i(182907);
            paramAnonymousb.keep(new com.tencent.mm.vending.e.a()
            {
              public final void dead()
              {
                AppMethodBeat.i(182906);
                if ((a.this.gUF != null) && (a.this.gUF.gUN != null)) {}
                for (Object localObject = Integer.valueOf(a.this.gUF.gUN.getType());; localObject = "")
                {
                  ad.i("MicroMsg.Cgi", "[dead] cgi=%s", new Object[] { localObject });
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
      f localf = this.gUG;
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
    if (this.gUH.compareAndSet(false, true)) {
      if ((this.gUF == null) || (this.gUF.gUN == null)) {
        break label118;
      }
    }
    label118:
    for (Object localObject = Integer.valueOf(this.gUF.gUN.getType());; localObject = "")
    {
      ad.i("MicroMsg.Cgi", "[cancel] cgi=%s", new Object[] { localObject });
      if (this.gUF != null)
      {
        this.gUF.gUO.resume();
        this.gUF.gUO = null;
        x.a(this.gUF);
      }
      if (this.gUG != null) {
        this.gUG.xd(true);
      }
      AppMethodBeat.o(132298);
      return;
    }
  }
  
  public static final class a<T extends cld>
  {
    public n dfA;
    public int errCode;
    public String errMsg;
    public int errType;
    public T gUK;
    public a gUL;
    
    public static <T extends cld> a<T> a(int paramInt1, int paramInt2, String paramString, T paramT, n paramn, a parama)
    {
      AppMethodBeat.i(132293);
      a locala = new a();
      locala.errType = paramInt1;
      locala.errCode = paramInt2;
      locala.errMsg = paramString;
      locala.gUK = paramT;
      locala.dfA = paramn;
      locala.gUL = parama;
      if (parama != null) {
        parama.a(paramInt1, paramInt2, paramString, paramT, paramn);
      }
      AppMethodBeat.o(132293);
      return locala;
    }
  }
  
  static final class b<_Resp extends cld>
    extends n
  {
    final n gUM;
    b gUN;
    com.tencent.mm.vending.g.b gUO;
    a gUP;
    private k gUQ;
    g gbr;
    final long mStartTime;
    
    public b(a parama)
    {
      AppMethodBeat.i(132295);
      this.gbr = null;
      this.gUM = this;
      this.mStartTime = bt.eGO();
      this.gUQ = new k()
      {
        public final void onGYNetEnd(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, String paramAnonymousString, q paramAnonymousq, byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(132294);
          if (a.b.this.gUP.gUH.get())
          {
            if ((a.b.this.gUP.gUF != null) && (a.b.this.gUP.gUF.gUN != null)) {}
            for (paramAnonymousq = Integer.valueOf(a.b.this.gUP.gUF.gUN.getType());; paramAnonymousq = "")
            {
              ad.w("MicroMsg.Cgi", "[onGYNetEnd] has cancel. cgi=%s", new Object[] { paramAnonymousq });
              a.b.this.gbr.onSceneEnd(paramAnonymousInt2, paramAnonymousInt3, paramAnonymousString, a.b.this.gUM);
              com.tencent.mm.vending.g.g.a(a.b.this.gUO);
              AppMethodBeat.o(132294);
              return;
            }
          }
          com.tencent.mm.vending.g.g.a(a.b.this.gUO, new Object[] { a.a.a(paramAnonymousInt2, paramAnonymousInt3, paramAnonymousString, (cld)a.b.this.gUN.gUT.gUX, a.b.this, a.b.this.gUP) });
          a.b.this.gbr.onSceneEnd(paramAnonymousInt2, paramAnonymousInt3, paramAnonymousString, a.b.this.gUM);
          ad.i("MicroMsg.Cgi", "onGYNetEnd:%d func:%d time:%d [%d,%d,%s]", new Object[] { Integer.valueOf(a.b.this.gUM.hashCode()), Integer.valueOf(a.b.this.getType()), Long.valueOf(bt.eGO() - a.b.this.mStartTime), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), paramAnonymousString });
          AppMethodBeat.o(132294);
        }
      };
      this.gUP = parama;
      AppMethodBeat.o(132295);
    }
    
    public final int doScene(com.tencent.mm.network.e parame, g paramg)
    {
      AppMethodBeat.i(132297);
      this.gbr = paramg;
      int i = dispatch(parame, this.gUN, this.gUQ);
      ad.i("MicroMsg.Cgi", "Start doScene:%d func:%d netid:%d time:%d", new Object[] { Integer.valueOf(this.gUM.hashCode()), Integer.valueOf(getType()), Integer.valueOf(i), Long.valueOf(bt.eGO() - this.mStartTime) });
      if (i < 0) {
        com.tencent.mm.vending.g.g.a(this.gUO, new Object[] { a.a.a(3, -1, "", (cld)this.gUN.gUT.gUX, this, this.gUP) });
      }
      AppMethodBeat.o(132297);
      return i;
    }
    
    public final int getType()
    {
      AppMethodBeat.i(132296);
      int i = this.gUN.getType();
      AppMethodBeat.o(132296);
      return i;
    }
    
    protected final int securityLimitCount()
    {
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.a
 * JD-Core Version:    0.7.0.1
 */