package com.tencent.mm.ai;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.e.a;

public final class w
{
  public static b fuq = null;
  
  public static b a(b paramb, a parama)
  {
    AppMethodBeat.i(58308);
    a(paramb, parama, false, null);
    AppMethodBeat.o(58308);
    return paramb;
  }
  
  public static m a(b paramb, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(156841);
    paramb = a(paramb, parama, paramBoolean, null);
    AppMethodBeat.o(156841);
    return paramb;
  }
  
  public static m a(b paramb, a parama, boolean paramBoolean, com.tencent.mm.vending.e.b paramb1)
  {
    AppMethodBeat.i(58310);
    c localc = new c(parama);
    if (parama == null) {
      localc = null;
    }
    if ((paramb1 != null) && (localc != null)) {
      paramb1.keep(localc);
    }
    paramb = b(paramb, localc, paramBoolean);
    AppMethodBeat.o(58310);
    return paramb;
  }
  
  public static void a(m paramm)
  {
    AppMethodBeat.i(58306);
    if (fuq == null)
    {
      ab.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
      AppMethodBeat.o(58306);
      return;
    }
    if (fuq.Rd() == null)
    {
      ab.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
      AppMethodBeat.o(58306);
      return;
    }
    if (paramm == null)
    {
      ab.e("MicroMsg.RunCgi", "ERROR: Param scene  == null.");
      AppMethodBeat.o(58306);
      return;
    }
    fuq.Rd().a(paramm);
    AppMethodBeat.o(58306);
  }
  
  public static boolean adW()
  {
    AppMethodBeat.i(58305);
    if (fuq == null)
    {
      ab.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
      AppMethodBeat.o(58305);
      return false;
    }
    if (fuq.Rd() == null)
    {
      ab.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
      AppMethodBeat.o(58305);
      return false;
    }
    AppMethodBeat.o(58305);
    return true;
  }
  
  public static b b(b paramb)
  {
    AppMethodBeat.i(58307);
    a(paramb, null, false, null);
    AppMethodBeat.o(58307);
    return paramb;
  }
  
  private static m b(b paramb, final a parama, final boolean paramBoolean)
  {
    AppMethodBeat.i(156565);
    if (fuq == null)
    {
      ab.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
      AppMethodBeat.o(156565);
      return null;
    }
    if (fuq.Rd() == null)
    {
      ab.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
      AppMethodBeat.o(156565);
      return null;
    }
    if (paramb == null)
    {
      ab.e("MicroMsg.RunCgi", "ERROR: Param CommReqResp is null");
      AppMethodBeat.o(156565);
      return null;
    }
    paramb = new m()
    {
      private k fsT;
      f fur;
      final m fus;
      int fut;
      ap fuu;
      final long startTime;
      
      public final int doScene(e paramAnonymouse, f paramAnonymousf)
      {
        AppMethodBeat.i(58300);
        this.fur = paramAnonymousf;
        int i = dispatch(paramAnonymouse, this.fuv, this.fsT);
        ab.i("MicroMsg.RunCgi", "Start doScene:%d func:%d netid:%d time:%d", new Object[] { Integer.valueOf(this.fus.hashCode()), Integer.valueOf(getType()), Integer.valueOf(i), Long.valueOf(bo.aoy() - this.startTime) });
        if (parama != null)
        {
          if (i >= 0) {
            break label121;
          }
          w.a(paramBoolean, parama, 3, -1, "", this.fuv, this.fus);
        }
        for (;;)
        {
          AppMethodBeat.o(58300);
          return i;
          label121:
          this.fuu.ag(60000L, 60000L);
        }
      }
      
      public final int getType()
      {
        AppMethodBeat.i(146141);
        int i = this.fuv.getType();
        AppMethodBeat.o(146141);
        return i;
      }
    };
    if (fuq.Rd().a(paramb, 0))
    {
      AppMethodBeat.o(156565);
      return paramb;
    }
    AppMethodBeat.o(156565);
    return null;
  }
  
  public static abstract interface a
  {
    public abstract int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm);
  }
  
  public static abstract interface b
  {
    public abstract p Rd();
  }
  
  static final class c
    implements w.a, a
  {
    private w.a fuA;
    
    public c(w.a parama)
    {
      this.fuA = parama;
    }
    
    public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
    {
      AppMethodBeat.i(58304);
      if (this.fuA != null)
      {
        paramInt1 = this.fuA.a(paramInt1, paramInt2, paramString, paramb, paramm);
        AppMethodBeat.o(58304);
        return paramInt1;
      }
      AppMethodBeat.o(58304);
      return -100000;
    }
    
    public final void dead()
    {
      this.fuA = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ai.w
 * JD-Core Version:    0.7.0.1
 */