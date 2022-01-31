package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.network.c;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.protocal.m.a;
import com.tencent.mm.protocal.m.b;
import com.tencent.mm.protocal.protobuf.jf;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class e
  extends com.tencent.mm.ai.m
  implements k
{
  private f callback;
  private q ftU;
  
  private e(boolean paramBoolean)
  {
    AppMethodBeat.i(16556);
    this.ftU = new e.a();
    m.a locala = (m.a)this.ftU.getReqObj();
    locala.netType = com.tencent.mm.protocal.m.getNetType(ah.getContext());
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      locala.wiu = i;
      AppMethodBeat.o(16556);
      return;
    }
  }
  
  private static boolean ajk()
  {
    AppMethodBeat.i(16555);
    int i;
    boolean bool;
    if (ae.glq != -1)
    {
      i = ae.glq;
      bool = b.foreground;
      ab.i("MicroMsg.NetSceneBgFg", "somr DynamicConfig checkBit:%d TestMuteRoomEnable:%d muteRoomDisable:%d fg:%b", new Object[] { Integer.valueOf(1), Integer.valueOf(ae.glq), Integer.valueOf(i), Boolean.valueOf(bool) });
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
        AppMethodBeat.o(16555);
        return bool;
        try
        {
          i = bo.getInt(g.Nq().getValue("MuteRoomDisable"), 0);
        }
        catch (Exception localException)
        {
          ab.printErrStackTrace("MicroMsg.NetSceneBgFg", localException, "", new Object[0]);
          i = 0;
        }
      }
      break;
    }
  }
  
  public static void dc(boolean paramBoolean)
  {
    AppMethodBeat.i(16554);
    ab.i("MicroMsg.NetSceneBgFg", "summerbgfg setBgFgForMuteRoom isFg[%s], accHasReady[%s] stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(aw.RG()), bo.dtY() });
    if (!aw.RG())
    {
      AppMethodBeat.o(16554);
      return;
    }
    if ((aw.Rc() == null) || (aw.Rc().ftA == null) || (aw.Rc().ftA.adI() == null))
    {
      ab.i("MicroMsg.NetSceneBgFg", "summerbgfg setBgFgForMuteRoom push not rready");
      AppMethodBeat.o(16554);
      return;
    }
    aw.Rc().ftA.adI().cP(paramBoolean);
    if (paramBoolean)
    {
      aw.Rc().a(new e(true), 0);
      AppMethodBeat.o(16554);
      return;
    }
    e locale = new e(ajk());
    aw.Rc().a(locale, 0);
    AppMethodBeat.o(16554);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(16557);
    this.callback = paramf;
    int i = dispatch(parame, this.ftU, this);
    AppMethodBeat.o(16557);
    return i;
  }
  
  public final int getType()
  {
    return 0;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(16558);
    ab.d("MicroMsg.NetSceneBgFg", " ret[%d]", new Object[] { Integer.valueOf(((m.b)paramq.getRespObj()).wiv.cnK) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(16558);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelsimple.e
 * JD-Core Version:    0.7.0.1
 */