package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.o;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.n.h;
import com.tencent.mm.network.e;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.m.a;
import com.tencent.mm.protocal.m.b;
import com.tencent.mm.protocal.protobuf.lt;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class f
  extends q
  implements com.tencent.mm.network.m
{
  private i callback;
  private s iMO;
  
  private f(boolean paramBoolean)
  {
    AppMethodBeat.i(20601);
    this.iMO = new a();
    m.a locala = (m.a)this.iMO.getReqObj();
    locala.netType = com.tencent.mm.protocal.m.getNetType(MMApplicationContext.getContext());
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      locala.KzG = i;
      AppMethodBeat.o(20601);
      return;
    }
  }
  
  private static boolean beP()
  {
    AppMethodBeat.i(20600);
    int i;
    boolean bool;
    if (ac.jPk != -1)
    {
      i = ac.jPk;
      bool = CrashReportFactory.foreground;
      Log.i("MicroMsg.NetSceneBgFg", "somr DynamicConfig checkBit:%d TestMuteRoomEnable:%d muteRoomDisable:%d fg:%b", new Object[] { Integer.valueOf(1), Integer.valueOf(ac.jPk), Integer.valueOf(i), Boolean.valueOf(bool) });
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
          i = Util.getInt(h.aqJ().getValue("MuteRoomDisable"), 0);
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
  
  public static void fJ(boolean paramBoolean)
  {
    AppMethodBeat.i(20599);
    Log.i("MicroMsg.NetSceneBgFg", "summerbgfg setBgFgForMuteRoom isFg[%s], accHasReady[%s] stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bg.aAc()), Util.getStack() });
    if (!bg.aAc())
    {
      AppMethodBeat.o(20599);
      return;
    }
    if ((bg.azz() == null) || (bg.azz().iMw == null) || (bg.azz().iMw.aZh() == null))
    {
      Log.i("MicroMsg.NetSceneBgFg", "summerbgfg setBgFgForMuteRoom push not rready");
      AppMethodBeat.o(20599);
      return;
    }
    bg.azz().iMw.aZh().setForeground(paramBoolean);
    if (paramBoolean)
    {
      bg.azz().a(new f(true), 0);
      AppMethodBeat.o(20599);
      return;
    }
    f localf = new f(beP());
    bg.azz().a(localf, 0);
    AppMethodBeat.o(20599);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(20602);
    this.callback = parami;
    int i = dispatch(paramg, this.iMO, this);
    AppMethodBeat.o(20602);
    return i;
  }
  
  public final int getType()
  {
    return 0;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20603);
    Log.d("MicroMsg.NetSceneBgFg", " ret[%d]", new Object[] { Integer.valueOf(((m.b)params.getRespObj()).KzH.dDN) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20603);
  }
  
  public static final class a
    extends o
  {
    private final m.a jja;
    private final m.b jjb;
    
    public a()
    {
      AppMethodBeat.i(20598);
      this.jja = new m.a();
      this.jjb = new m.b();
      AppMethodBeat.o(20598);
    }
    
    public final l.d getReqObjImp()
    {
      return this.jja;
    }
    
    public final l.e getRespObj()
    {
      return this.jjb;
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
 * Qualified Name:     com.tencent.mm.modelsimple.f
 * JD-Core Version:    0.7.0.1
 */