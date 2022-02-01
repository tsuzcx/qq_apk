package com.tencent.mm.ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.e.b;

public final class aa
{
  public static b iNn = null;
  
  public static d a(d paramd, a parama)
  {
    AppMethodBeat.i(132492);
    a(paramd, parama, false, null);
    AppMethodBeat.o(132492);
    return paramd;
  }
  
  public static q a(d paramd, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(258486);
    paramd = a(paramd, parama, paramBoolean, null);
    AppMethodBeat.o(258486);
    return paramd;
  }
  
  public static q a(d paramd, a parama, boolean paramBoolean, b paramb)
  {
    AppMethodBeat.i(132494);
    c localc = new c(parama);
    if (parama == null) {
      localc = null;
    }
    if ((paramb != null) && (localc != null)) {
      paramb.keep(localc);
    }
    paramd = b(paramd, localc, paramBoolean);
    AppMethodBeat.o(132494);
    return paramd;
  }
  
  public static void a(q paramq)
  {
    AppMethodBeat.i(132490);
    if (iNn == null)
    {
      Log.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
      AppMethodBeat.o(132490);
      return;
    }
    if (iNn.azA() == null)
    {
      Log.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
      AppMethodBeat.o(132490);
      return;
    }
    if (paramq == null)
    {
      Log.e("MicroMsg.RunCgi", "ERROR: Param scene  == null.");
      AppMethodBeat.o(132490);
      return;
    }
    iNn.azA().a(paramq);
    AppMethodBeat.o(132490);
  }
  
  public static boolean aZx()
  {
    AppMethodBeat.i(132489);
    if (iNn == null)
    {
      Log.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
      AppMethodBeat.o(132489);
      return false;
    }
    if (iNn.azA() == null)
    {
      Log.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
      AppMethodBeat.o(132489);
      return false;
    }
    AppMethodBeat.o(132489);
    return true;
  }
  
  private static q b(d paramd, final a parama, final boolean paramBoolean)
  {
    AppMethodBeat.i(197076);
    if (iNn == null)
    {
      Log.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
      AppMethodBeat.o(197076);
      return null;
    }
    if (iNn.azA() == null)
    {
      Log.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
      AppMethodBeat.o(197076);
      return null;
    }
    if (paramd == null)
    {
      Log.e("MicroMsg.RunCgi", "ERROR: Param CommReqResp is null");
      AppMethodBeat.o(197076);
      return null;
    }
    paramd = new q()
    {
      i gNh;
      private m iLI;
      final q iNo;
      int iNp;
      MTimerHandler iNq;
      final long startTime;
      
      public final int doScene(g paramAnonymousg, i paramAnonymousi)
      {
        AppMethodBeat.i(132484);
        this.gNh = paramAnonymousi;
        int i = dispatch(paramAnonymousg, this.iNr, this.iLI);
        Log.i("MicroMsg.RunCgi", "Start doScene:%d func:%d netid:%d time:%d", new Object[] { Integer.valueOf(this.iNo.hashCode()), Integer.valueOf(getType()), Integer.valueOf(i), Long.valueOf(Util.nowMilliSecond() - this.startTime) });
        if (parama != null)
        {
          if (i >= 0) {
            break label121;
          }
          aa.a(paramBoolean, parama, 3, -1, "", this.iNr, this.iNo);
        }
        for (;;)
        {
          AppMethodBeat.o(132484);
          return i;
          label121:
          this.iNq.startTimer(60000L);
        }
      }
      
      public final int getType()
      {
        AppMethodBeat.i(132483);
        int i = this.iNr.getType();
        AppMethodBeat.o(132483);
        return i;
      }
    };
    if (iNn.azA().a(paramd, 0))
    {
      AppMethodBeat.o(197076);
      return paramd;
    }
    AppMethodBeat.o(197076);
    return null;
  }
  
  public static d d(d paramd)
  {
    AppMethodBeat.i(132491);
    a(paramd, null, false, null);
    AppMethodBeat.o(132491);
    return paramd;
  }
  
  public static abstract interface a
  {
    public abstract int a(int paramInt1, int paramInt2, String paramString, d paramd, q paramq);
  }
  
  public static abstract interface b
  {
    public abstract t azA();
  }
  
  static final class c
    implements aa.a, a
  {
    private aa.a iNw;
    
    public c(aa.a parama)
    {
      this.iNw = parama;
    }
    
    public final int a(int paramInt1, int paramInt2, String paramString, d paramd, q paramq)
    {
      AppMethodBeat.i(132488);
      if (this.iNw != null)
      {
        paramInt1 = this.iNw.a(paramInt1, paramInt2, paramString, paramd, paramq);
        AppMethodBeat.o(132488);
        return paramInt1;
      }
      AppMethodBeat.o(132488);
      return -100000;
    }
    
    public final void dead()
    {
      this.iNw = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ak.aa
 * JD-Core Version:    0.7.0.1
 */