package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.l;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.az;
import com.tencent.mm.network.c;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.m;
import com.tencent.mm.protocal.m.a;
import com.tencent.mm.protocal.m.b;
import com.tencent.mm.protocal.protobuf.kt;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;

public final class e
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  private com.tencent.mm.network.q hwy;
  
  private e(boolean paramBoolean)
  {
    AppMethodBeat.i(20601);
    this.hwy = new a();
    m.a locala = (m.a)this.hwy.getReqObj();
    locala.netType = m.getNetType(ai.getContext());
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      locala.DIQ = i;
      AppMethodBeat.o(20601);
      return;
    }
  }
  
  private static boolean aHf()
  {
    AppMethodBeat.i(20600);
    int i;
    boolean bool;
    if (ab.iwo != -1)
    {
      i = ab.iwo;
      bool = b.foreground;
      ac.i("MicroMsg.NetSceneBgFg", "somr DynamicConfig checkBit:%d TestMuteRoomEnable:%d muteRoomDisable:%d fg:%b", new Object[] { Integer.valueOf(1), Integer.valueOf(ab.iwo), Integer.valueOf(i), Boolean.valueOf(bool) });
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
          i = bs.getInt(com.tencent.mm.m.g.ZY().getValue("MuteRoomDisable"), 0);
        }
        catch (Exception localException)
        {
          ac.printErrStackTrace("MicroMsg.NetSceneBgFg", localException, "", new Object[0]);
          i = 0;
        }
      }
      break;
    }
  }
  
  public static void eO(boolean paramBoolean)
  {
    AppMethodBeat.i(20599);
    ac.i("MicroMsg.NetSceneBgFg", "summerbgfg setBgFgForMuteRoom isFg[%s], accHasReady[%s] stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(az.agM()), bs.eWi() });
    if (!az.agM())
    {
      AppMethodBeat.o(20599);
      return;
    }
    if ((az.agi() == null) || (az.agi().hwg == null) || (az.agi().hwg.aBZ() == null))
    {
      ac.i("MicroMsg.NetSceneBgFg", "summerbgfg setBgFgForMuteRoom push not rready");
      AppMethodBeat.o(20599);
      return;
    }
    az.agi().hwg.aBZ().eC(paramBoolean);
    if (paramBoolean)
    {
      az.agi().a(new e(true), 0);
      AppMethodBeat.o(20599);
      return;
    }
    e locale = new e(aHf());
    az.agi().a(locale, 0);
    AppMethodBeat.o(20599);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(20602);
    this.callback = paramg;
    int i = dispatch(parame, this.hwy, this);
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
    ac.d("MicroMsg.NetSceneBgFg", " ret[%d]", new Object[] { Integer.valueOf(((m.b)paramq.getRespObj()).DIR.dae) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20603);
  }
  
  public static final class a
    extends l
  {
    private final m.a hRL;
    private final m.b hRM;
    
    public a()
    {
      AppMethodBeat.i(20598);
      this.hRL = new m.a();
      this.hRM = new m.b();
      AppMethodBeat.o(20598);
    }
    
    public final l.d getReqObjImp()
    {
      return this.hRL;
    }
    
    public final l.e getRespObj()
    {
      return this.hRM;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.e
 * JD-Core Version:    0.7.0.1
 */