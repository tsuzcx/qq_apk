package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.l;
import com.tencent.mm.al.n;
import com.tencent.mm.model.ba;
import com.tencent.mm.n.g;
import com.tencent.mm.network.c;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.m;
import com.tencent.mm.protocal.m.a;
import com.tencent.mm.protocal.m.b;
import com.tencent.mm.protocal.protobuf.lc;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class e
  extends n
  implements k
{
  private f callback;
  private com.tencent.mm.network.q hON;
  
  private e(boolean paramBoolean)
  {
    AppMethodBeat.i(20601);
    this.hON = new a();
    m.a locala = (m.a)this.hON.getReqObj();
    locala.netType = m.getNetType(aj.getContext());
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      locala.FnX = i;
      AppMethodBeat.o(20601);
      return;
    }
  }
  
  private static boolean aKq()
  {
    AppMethodBeat.i(20600);
    int i;
    boolean bool;
    if (ac.iPw != -1)
    {
      i = ac.iPw;
      bool = b.foreground;
      ad.i("MicroMsg.NetSceneBgFg", "somr DynamicConfig checkBit:%d TestMuteRoomEnable:%d muteRoomDisable:%d fg:%b", new Object[] { Integer.valueOf(1), Integer.valueOf(ac.iPw), Integer.valueOf(i), Boolean.valueOf(bool) });
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
          i = bt.getInt(g.acA().getValue("MuteRoomDisable"), 0);
        }
        catch (Exception localException)
        {
          ad.printErrStackTrace("MicroMsg.NetSceneBgFg", localException, "", new Object[0]);
          i = 0;
        }
      }
      break;
    }
  }
  
  public static void eQ(boolean paramBoolean)
  {
    AppMethodBeat.i(20599);
    ad.i("MicroMsg.NetSceneBgFg", "summerbgfg setBgFgForMuteRoom isFg[%s], accHasReady[%s] stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(ba.ajx()), bt.flS() });
    if (!ba.ajx())
    {
      AppMethodBeat.o(20599);
      return;
    }
    if ((ba.aiU() == null) || (ba.aiU().hOv == null) || (ba.aiU().hOv.aFc() == null))
    {
      ad.i("MicroMsg.NetSceneBgFg", "summerbgfg setBgFgForMuteRoom push not rready");
      AppMethodBeat.o(20599);
      return;
    }
    ba.aiU().hOv.aFc().eE(paramBoolean);
    if (paramBoolean)
    {
      ba.aiU().a(new e(true), 0);
      AppMethodBeat.o(20599);
      return;
    }
    e locale = new e(aKq());
    ba.aiU().a(locale, 0);
    AppMethodBeat.o(20599);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(20602);
    this.callback = paramf;
    int i = dispatch(parame, this.hON, this);
    AppMethodBeat.o(20602);
    return i;
  }
  
  public final int getType()
  {
    return 0;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20603);
    ad.d("MicroMsg.NetSceneBgFg", " ret[%d]", new Object[] { Integer.valueOf(((m.b)paramq.getRespObj()).FnY.dlw) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20603);
  }
  
  public static final class a
    extends l
  {
    private final m.a ikZ;
    private final m.b ila;
    
    public a()
    {
      AppMethodBeat.i(20598);
      this.ikZ = new m.a();
      this.ila = new m.b();
      AppMethodBeat.o(20598);
    }
    
    public final l.d getReqObjImp()
    {
      return this.ikZ;
    }
    
    public final l.e getRespObj()
    {
      return this.ila;
    }
    
    public final int getType()
    {
      return 0;
    }
    
    public final String getUri()
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.e
 * JD-Core Version:    0.7.0.1
 */