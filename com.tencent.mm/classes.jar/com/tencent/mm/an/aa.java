package com.tencent.mm.an;

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
  public static aa.b lDv = null;
  
  public static d a(d paramd, a parama)
  {
    AppMethodBeat.i(132492);
    a(paramd, parama, false, null);
    AppMethodBeat.o(132492);
    return paramd;
  }
  
  public static q a(d paramd, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(292884);
    paramd = a(paramd, parama, paramBoolean, null);
    AppMethodBeat.o(292884);
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
    if (lDv == null)
    {
      Log.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
      AppMethodBeat.o(132490);
      return;
    }
    if (lDv.aGZ() == null)
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
    lDv.aGZ().a(paramq);
    AppMethodBeat.o(132490);
  }
  
  private static q b(d paramd, final a parama, final boolean paramBoolean)
  {
    AppMethodBeat.i(201287);
    if (lDv == null)
    {
      Log.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
      AppMethodBeat.o(201287);
      return null;
    }
    if (lDv.aGZ() == null)
    {
      Log.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
      AppMethodBeat.o(201287);
      return null;
    }
    if (paramd == null)
    {
      Log.e("MicroMsg.RunCgi", "ERROR: Param CommReqResp is null");
      AppMethodBeat.o(201287);
      return null;
    }
    paramd = new q()
    {
      private i jxB;
      private m lBP;
      private final q lDw;
      int lDx;
      MTimerHandler lDy;
      private final long startTime;
      
      public final int doScene(g paramAnonymousg, i paramAnonymousi)
      {
        AppMethodBeat.i(132484);
        this.jxB = paramAnonymousi;
        int i = dispatch(paramAnonymousg, this.lDz, this.lBP);
        Log.i("MicroMsg.RunCgi", "Start doScene:%d func:%d netid:%d time:%d", new Object[] { Integer.valueOf(this.lDw.hashCode()), Integer.valueOf(getType()), Integer.valueOf(i), Long.valueOf(Util.nowMilliSecond() - this.startTime) });
        if (parama != null)
        {
          if (i >= 0) {
            break label121;
          }
          aa.a(paramBoolean, parama, 3, -1, "", this.lDz, this.lDw);
        }
        for (;;)
        {
          AppMethodBeat.o(132484);
          return i;
          label121:
          this.lDy.startTimer(60000L);
        }
      }
      
      public final int getType()
      {
        AppMethodBeat.i(132483);
        int i = this.lDz.getType();
        AppMethodBeat.o(132483);
        return i;
      }
    };
    if (lDv.aGZ().a(paramd, 0))
    {
      AppMethodBeat.o(201287);
      return paramd;
    }
    AppMethodBeat.o(201287);
    return null;
  }
  
  public static boolean biN()
  {
    AppMethodBeat.i(132489);
    if (lDv == null)
    {
      Log.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
      AppMethodBeat.o(132489);
      return false;
    }
    if (lDv.aGZ() == null)
    {
      Log.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
      AppMethodBeat.o(132489);
      return false;
    }
    AppMethodBeat.o(132489);
    return true;
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
  
  static final class c
    implements aa.a, a
  {
    private aa.a lDE;
    
    public c(aa.a parama)
    {
      this.lDE = parama;
    }
    
    public final int a(int paramInt1, int paramInt2, String paramString, d paramd, q paramq)
    {
      AppMethodBeat.i(132488);
      if (this.lDE != null)
      {
        paramInt1 = this.lDE.a(paramInt1, paramInt2, paramString, paramd, paramq);
        AppMethodBeat.o(132488);
        return paramInt1;
      }
      AppMethodBeat.o(132488);
      return -100000;
    }
    
    public final void dead()
    {
      this.lDE = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.an.aa
 * JD-Core Version:    0.7.0.1
 */