package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.e.b;

public final class z
{
  public static z.b ovg = null;
  
  public static c a(c paramc, z.a parama)
  {
    AppMethodBeat.i(132492);
    a(paramc, parama, false, null);
    AppMethodBeat.o(132492);
    return paramc;
  }
  
  public static p a(c paramc, z.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(369564);
    paramc = a(paramc, parama, paramBoolean, null);
    AppMethodBeat.o(369564);
    return paramc;
  }
  
  public static p a(c paramc, z.a parama, boolean paramBoolean, b paramb)
  {
    AppMethodBeat.i(132494);
    z.c localc = new z.c(parama);
    if (parama == null) {
      localc = null;
    }
    if ((paramb != null) && (localc != null)) {
      paramb.keep(localc);
    }
    paramc = b(paramc, localc, paramBoolean);
    AppMethodBeat.o(132494);
    return paramc;
  }
  
  public static void a(p paramp)
  {
    AppMethodBeat.i(132490);
    if (ovg == null)
    {
      Log.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
      AppMethodBeat.o(132490);
      return;
    }
    if (ovg.aZX() == null)
    {
      Log.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
      AppMethodBeat.o(132490);
      return;
    }
    if (paramp == null)
    {
      Log.e("MicroMsg.RunCgi", "ERROR: Param scene  == null.");
      AppMethodBeat.o(132490);
      return;
    }
    ovg.aZX().a(paramp);
    AppMethodBeat.o(132490);
  }
  
  private static p b(c paramc, final z.a parama, final boolean paramBoolean)
  {
    AppMethodBeat.i(236781);
    if (ovg == null)
    {
      Log.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
      AppMethodBeat.o(236781);
      return null;
    }
    if (ovg.aZX() == null)
    {
      Log.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
      AppMethodBeat.o(236781);
      return null;
    }
    if (paramc == null)
    {
      Log.e("MicroMsg.RunCgi", "ERROR: Param CommReqResp is null");
      AppMethodBeat.o(236781);
      return null;
    }
    paramc = new p()
    {
      private h maV;
      private m otz;
      private final p ovh;
      int ovi;
      MTimerHandler ovj;
      private final long startTime;
      
      public final int doScene(g paramAnonymousg, h paramAnonymoush)
      {
        AppMethodBeat.i(132484);
        this.maV = paramAnonymoush;
        int i = dispatch(paramAnonymousg, z.this, this.otz);
        Log.i("MicroMsg.RunCgi", "Start doScene:%d func:%d netid:%d time:%d", new Object[] { Integer.valueOf(this.ovh.hashCode()), Integer.valueOf(getType()), Integer.valueOf(i), Long.valueOf(Util.nowMilliSecond() - this.startTime) });
        if (parama != null)
        {
          if (i >= 0) {
            break label121;
          }
          z.a(paramBoolean, parama, 3, -1, "", z.this, this.ovh);
        }
        for (;;)
        {
          AppMethodBeat.o(132484);
          return i;
          label121:
          this.ovj.startTimer(60000L);
        }
      }
      
      public final int getType()
      {
        AppMethodBeat.i(132483);
        int i = z.this.getType();
        AppMethodBeat.o(132483);
        return i;
      }
    };
    if (ovg.aZX().a(paramc, 0))
    {
      AppMethodBeat.o(236781);
      return paramc;
    }
    AppMethodBeat.o(236781);
    return null;
  }
  
  public static boolean bGx()
  {
    AppMethodBeat.i(132489);
    if (ovg == null)
    {
      Log.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
      AppMethodBeat.o(132489);
      return false;
    }
    if (ovg.aZX() == null)
    {
      Log.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
      AppMethodBeat.o(132489);
      return false;
    }
    AppMethodBeat.o(132489);
    return true;
  }
  
  public static c d(c paramc)
  {
    AppMethodBeat.i(132491);
    a(paramc, null, false, null);
    AppMethodBeat.o(132491);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.am.z
 * JD-Core Version:    0.7.0.1
 */