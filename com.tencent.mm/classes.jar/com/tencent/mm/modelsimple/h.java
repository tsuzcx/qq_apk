package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.model.bh;
import com.tencent.mm.network.e;
import com.tencent.mm.network.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.m.a;
import com.tencent.mm.protocal.m.b;
import com.tencent.mm.protocal.protobuf.mk;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.systemservicecache.NetworkCache;

public final class h
  extends p
  implements com.tencent.mm.network.m
{
  private com.tencent.mm.am.h callback;
  private com.tencent.mm.network.s ouH;
  
  private h(boolean paramBoolean)
  {
    AppMethodBeat.i(20601);
    this.ouH = new h.a();
    m.a locala = (m.a)this.ouH.getReqObj();
    locala.netType = com.tencent.mm.protocal.m.getNetType(NetworkCache.INSTANCE.getActiveNetworkInfoFromCache(MMApplicationContext.getContext()));
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      locala.YxZ = i;
      AppMethodBeat.o(20601);
      return;
    }
  }
  
  private static boolean bLS()
  {
    AppMethodBeat.i(20600);
    int i;
    boolean bool;
    if (z.pCU != -1)
    {
      i = z.pCU;
      bool = CrashReportFactory.foreground;
      Log.i("MicroMsg.NetSceneBgFg", "somr DynamicConfig checkBit:%d TestMuteRoomEnable:%d muteRoomDisable:%d fg:%b", new Object[] { Integer.valueOf(1), Integer.valueOf(z.pCU), Integer.valueOf(i), Boolean.valueOf(bool) });
      if ((i & 0x1) == 0) {
        break label112;
      }
      bool = true;
    }
    label112:
    for (;;)
    {
      for (;;)
      {
        AppMethodBeat.o(20600);
        return bool;
        try
        {
          i = Util.getInt(i.aRC().getValue("MuteRoomDisable"), 0);
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.NetSceneBgFg", localException, "", new Object[0]);
          i = 0;
        }
      }
      break;
    }
  }
  
  public static void hl(boolean paramBoolean)
  {
    AppMethodBeat.i(20599);
    Log.i("MicroMsg.NetSceneBgFg", "summerbgfg setBgFgForMuteRoom isFg[%s], accHasReady[%s] stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bh.baz()), Util.getStack() });
    if (!bh.baz())
    {
      AppMethodBeat.o(20599);
      return;
    }
    if ((bh.aZW() == null) || (bh.aZW().oun == null) || (bh.aZW().oun.bGg() == null))
    {
      Log.i("MicroMsg.NetSceneBgFg", "summerbgfg setBgFgForMuteRoom push not rready");
      AppMethodBeat.o(20599);
      return;
    }
    bh.aZW().oun.bGg().setForeground(paramBoolean);
    if (paramBoolean)
    {
      bh.aZW().a(new h(true), 0);
      AppMethodBeat.o(20599);
      return;
    }
    h localh = new h(bLS());
    bh.aZW().a(localh, 0);
    AppMethodBeat.o(20599);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(20602);
    this.callback = paramh;
    int i = dispatch(paramg, this.ouH, this);
    AppMethodBeat.o(20602);
    return i;
  }
  
  public final int getType()
  {
    return 0;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20603);
    Log.d("MicroMsg.NetSceneBgFg", " ret[%d]", new Object[] { Integer.valueOf(((m.b)params.getRespObj()).Yya.hAV) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20603);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsimple.h
 * JD-Core Version:    0.7.0.1
 */