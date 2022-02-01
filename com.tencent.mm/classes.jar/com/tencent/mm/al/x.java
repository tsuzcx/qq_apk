package com.tencent.mm.al;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vending.e.a;

public final class x
{
  public static b gWv = null;
  
  public static b a(b paramb, a parama)
  {
    AppMethodBeat.i(132492);
    a(paramb, parama, false, null);
    AppMethodBeat.o(132492);
    return paramb;
  }
  
  public static n a(b paramb, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(202267);
    paramb = a(paramb, parama, paramBoolean, null);
    AppMethodBeat.o(202267);
    return paramb;
  }
  
  public static n a(b paramb, a parama, boolean paramBoolean, com.tencent.mm.vending.e.b paramb1)
  {
    AppMethodBeat.i(132494);
    c localc = new c(parama);
    if (parama == null) {
      localc = null;
    }
    if ((paramb1 != null) && (localc != null)) {
      paramb1.keep(localc);
    }
    paramb = b(paramb, localc, paramBoolean);
    AppMethodBeat.o(132494);
    return paramb;
  }
  
  public static void a(n paramn)
  {
    AppMethodBeat.i(132490);
    if (gWv == null)
    {
      ad.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
      AppMethodBeat.o(132490);
      return;
    }
    if (gWv.aeT() == null)
    {
      ad.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
      AppMethodBeat.o(132490);
      return;
    }
    if (paramn == null)
    {
      ad.e("MicroMsg.RunCgi", "ERROR: Param scene  == null.");
      AppMethodBeat.o(132490);
      return;
    }
    gWv.aeT().a(paramn);
    AppMethodBeat.o(132490);
  }
  
  public static boolean avu()
  {
    AppMethodBeat.i(132489);
    if (gWv == null)
    {
      ad.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
      AppMethodBeat.o(132489);
      return false;
    }
    if (gWv.aeT() == null)
    {
      ad.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
      AppMethodBeat.o(132489);
      return false;
    }
    AppMethodBeat.o(132489);
    return true;
  }
  
  private static n b(b paramb, final a parama, final boolean paramBoolean)
  {
    AppMethodBeat.i(192876);
    if (gWv == null)
    {
      ad.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
      AppMethodBeat.o(192876);
      return null;
    }
    if (gWv.aeT() == null)
    {
      ad.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
      AppMethodBeat.o(192876);
      return null;
    }
    if (paramb == null)
    {
      ad.e("MicroMsg.RunCgi", "ERROR: Param CommReqResp is null");
      AppMethodBeat.o(192876);
      return null;
    }
    paramb = new n()
    {
      private k gUQ;
      g gWw;
      final n gWx;
      int gWy;
      av gWz;
      final long startTime;
      
      public final int doScene(e paramAnonymouse, g paramAnonymousg)
      {
        AppMethodBeat.i(132484);
        this.gWw = paramAnonymousg;
        int i = dispatch(paramAnonymouse, this.gWA, this.gUQ);
        ad.i("MicroMsg.RunCgi", "Start doScene:%d func:%d netid:%d time:%d", new Object[] { Integer.valueOf(this.gWx.hashCode()), Integer.valueOf(getType()), Integer.valueOf(i), Long.valueOf(bt.eGO() - this.startTime) });
        if (parama != null)
        {
          if (i >= 0) {
            break label121;
          }
          x.a(paramBoolean, parama, 3, -1, "", this.gWA, this.gWx);
        }
        for (;;)
        {
          AppMethodBeat.o(132484);
          return i;
          label121:
          this.gWz.av(60000L, 60000L);
        }
      }
      
      public final int getType()
      {
        AppMethodBeat.i(132483);
        int i = this.gWA.getType();
        AppMethodBeat.o(132483);
        return i;
      }
    };
    if (gWv.aeT().a(paramb, 0))
    {
      AppMethodBeat.o(192876);
      return paramb;
    }
    AppMethodBeat.o(192876);
    return null;
  }
  
  public static b d(b paramb)
  {
    AppMethodBeat.i(132491);
    a(paramb, null, false, null);
    AppMethodBeat.o(132491);
    return paramb;
  }
  
  public static abstract interface a
  {
    public abstract int a(int paramInt1, int paramInt2, String paramString, b paramb, n paramn);
  }
  
  public static abstract interface b
  {
    public abstract q aeT();
  }
  
  static final class c
    implements x.a, a
  {
    private x.a gWF;
    
    public c(x.a parama)
    {
      this.gWF = parama;
    }
    
    public final int a(int paramInt1, int paramInt2, String paramString, b paramb, n paramn)
    {
      AppMethodBeat.i(132488);
      if (this.gWF != null)
      {
        paramInt1 = this.gWF.a(paramInt1, paramInt2, paramString, paramb, paramn);
        AppMethodBeat.o(132488);
        return paramInt1;
      }
      AppMethodBeat.o(132488);
      return -100000;
    }
    
    public final void dead()
    {
      this.gWF = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.al.x
 * JD-Core Version:    0.7.0.1
 */