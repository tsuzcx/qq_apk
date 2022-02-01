package com.tencent.mm.ak;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vending.e.a;

public final class x
{
  public static b hwU = null;
  
  public static b a(b paramb, a parama)
  {
    AppMethodBeat.i(132492);
    a(paramb, parama, false, null);
    AppMethodBeat.o(132492);
    return paramb;
  }
  
  public static n a(b paramb, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(210305);
    paramb = a(paramb, parama, paramBoolean, null);
    AppMethodBeat.o(210305);
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
    if (hwU == null)
    {
      ac.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
      AppMethodBeat.o(132490);
      return;
    }
    if (hwU.agj() == null)
    {
      ac.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
      AppMethodBeat.o(132490);
      return;
    }
    if (paramn == null)
    {
      ac.e("MicroMsg.RunCgi", "ERROR: Param scene  == null.");
      AppMethodBeat.o(132490);
      return;
    }
    hwU.agj().a(paramn);
    AppMethodBeat.o(132490);
  }
  
  public static boolean aCn()
  {
    AppMethodBeat.i(132489);
    if (hwU == null)
    {
      ac.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
      AppMethodBeat.o(132489);
      return false;
    }
    if (hwU.agj() == null)
    {
      ac.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
      AppMethodBeat.o(132489);
      return false;
    }
    AppMethodBeat.o(132489);
    return true;
  }
  
  private static n b(b paramb, final a parama, final boolean paramBoolean)
  {
    AppMethodBeat.i(206887);
    if (hwU == null)
    {
      ac.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
      AppMethodBeat.o(206887);
      return null;
    }
    if (hwU.agj() == null)
    {
      ac.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
      AppMethodBeat.o(206887);
      return null;
    }
    if (paramb == null)
    {
      ac.e("MicroMsg.RunCgi", "ERROR: Param CommReqResp is null");
      AppMethodBeat.o(206887);
      return null;
    }
    paramb = new n()
    {
      private k hvp;
      g hwV;
      final n hwW;
      int hwX;
      au hwY;
      final long startTime;
      
      public final int doScene(e paramAnonymouse, g paramAnonymousg)
      {
        AppMethodBeat.i(132484);
        this.hwV = paramAnonymousg;
        int i = dispatch(paramAnonymouse, this.hwZ, this.hvp);
        ac.i("MicroMsg.RunCgi", "Start doScene:%d func:%d netid:%d time:%d", new Object[] { Integer.valueOf(this.hwW.hashCode()), Integer.valueOf(getType()), Integer.valueOf(i), Long.valueOf(bs.eWj() - this.startTime) });
        if (parama != null)
        {
          if (i >= 0) {
            break label121;
          }
          x.a(paramBoolean, parama, 3, -1, "", this.hwZ, this.hwW);
        }
        for (;;)
        {
          AppMethodBeat.o(132484);
          return i;
          label121:
          this.hwY.au(60000L, 60000L);
        }
      }
      
      public final int getType()
      {
        AppMethodBeat.i(132483);
        int i = this.hwZ.getType();
        AppMethodBeat.o(132483);
        return i;
      }
    };
    if (hwU.agj().a(paramb, 0))
    {
      AppMethodBeat.o(206887);
      return paramb;
    }
    AppMethodBeat.o(206887);
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
    public abstract q agj();
  }
  
  static final class c
    implements x.a, a
  {
    private x.a hxe;
    
    public c(x.a parama)
    {
      this.hxe = parama;
    }
    
    public final int a(int paramInt1, int paramInt2, String paramString, b paramb, n paramn)
    {
      AppMethodBeat.i(132488);
      if (this.hxe != null)
      {
        paramInt1 = this.hxe.a(paramInt1, paramInt2, paramString, paramb, paramn);
        AppMethodBeat.o(132488);
        return paramInt1;
      }
      AppMethodBeat.o(132488);
      return -100000;
    }
    
    public final void dead()
    {
      this.hxe = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ak.x
 * JD-Core Version:    0.7.0.1
 */