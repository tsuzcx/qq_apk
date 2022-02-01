package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.l;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.bc;
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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

public final class f
  extends n
  implements k
{
  private com.tencent.mm.ak.f callback;
  private com.tencent.mm.network.q hRG;
  
  private f(boolean paramBoolean)
  {
    AppMethodBeat.i(20601);
    this.hRG = new a();
    m.a locala = (m.a)this.hRG.getReqObj();
    locala.netType = m.getNetType(ak.getContext());
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      locala.FGv = i;
      AppMethodBeat.o(20601);
      return;
    }
  }
  
  private static boolean aKN()
  {
    AppMethodBeat.i(20600);
    int i;
    boolean bool;
    if (ac.iSp != -1)
    {
      i = ac.iSp;
      bool = b.foreground;
      ae.i("MicroMsg.NetSceneBgFg", "somr DynamicConfig checkBit:%d TestMuteRoomEnable:%d muteRoomDisable:%d fg:%b", new Object[] { Integer.valueOf(1), Integer.valueOf(ac.iSp), Integer.valueOf(i), Boolean.valueOf(bool) });
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
          i = bu.getInt(g.acL().getValue("MuteRoomDisable"), 0);
        }
        catch (Exception localException)
        {
          ae.printErrStackTrace("MicroMsg.NetSceneBgFg", localException, "", new Object[0]);
          i = 0;
        }
      }
      break;
    }
  }
  
  public static void eT(boolean paramBoolean)
  {
    AppMethodBeat.i(20599);
    ae.i("MicroMsg.NetSceneBgFg", "summerbgfg setBgFgForMuteRoom isFg[%s], accHasReady[%s] stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bc.ajM()), bu.fpN() });
    if (!bc.ajM())
    {
      AppMethodBeat.o(20599);
      return;
    }
    if ((bc.ajj() == null) || (bc.ajj().hRo == null) || (bc.ajj().hRo.aFs() == null))
    {
      ae.i("MicroMsg.NetSceneBgFg", "summerbgfg setBgFgForMuteRoom push not rready");
      AppMethodBeat.o(20599);
      return;
    }
    bc.ajj().hRo.aFs().eG(paramBoolean);
    if (paramBoolean)
    {
      bc.ajj().a(new f(true), 0);
      AppMethodBeat.o(20599);
      return;
    }
    f localf = new f(aKN());
    bc.ajj().a(localf, 0);
    AppMethodBeat.o(20599);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(20602);
    this.callback = paramf;
    int i = dispatch(parame, this.hRG, this);
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
    ae.d("MicroMsg.NetSceneBgFg", " ret[%d]", new Object[] { Integer.valueOf(((m.b)paramq.getRespObj()).FGw.dmy) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20603);
  }
  
  public static final class a
    extends l
  {
    private final m.a inS;
    private final m.b inT;
    
    public a()
    {
      AppMethodBeat.i(20598);
      this.inS = new m.a();
      this.inT = new m.b();
      AppMethodBeat.o(20598);
    }
    
    public final l.d getReqObjImp()
    {
      return this.inS;
    }
    
    public final l.e getRespObj()
    {
      return this.inT;
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
 * Qualified Name:     com.tencent.mm.modelsimple.f
 * JD-Core Version:    0.7.0.1
 */