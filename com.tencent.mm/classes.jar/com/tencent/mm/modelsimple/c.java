package com.tencent.mm.modelsimple;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.m.g;
import com.tencent.mm.model.au;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ho;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.a;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  extends m
  implements k
{
  private f dmL;
  private q edR = new c.a();
  
  private c(boolean paramBoolean)
  {
    l.a locala = (l.a)this.edR.Kv();
    locala.netType = l.getNetType(com.tencent.mm.sdk.platformtools.ae.getContext());
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      locala.spQ = i;
      return;
    }
  }
  
  private static boolean Qe()
  {
    int i;
    if (com.tencent.mm.platformtools.ae.eTv != -1) {
      i = com.tencent.mm.platformtools.ae.eTv;
    }
    boolean bool;
    for (;;)
    {
      bool = b.foreground;
      y.i("MicroMsg.NetSceneBgFg", "somr DynamicConfig checkBit:%d TestMuteRoomEnable:%d muteRoomDisable:%d fg:%b", new Object[] { Integer.valueOf(1), Integer.valueOf(com.tencent.mm.platformtools.ae.eTv), Integer.valueOf(i), Boolean.valueOf(bool) });
      if ((i & 0x1) == 0) {
        break;
      }
      return true;
      try
      {
        i = bk.getInt(g.AA().getValue("MuteRoomDisable"), 0);
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.NetSceneBgFg", localException, "", new Object[0]);
        i = 0;
      }
    }
    return bool;
  }
  
  public static void bZ(boolean paramBoolean)
  {
    y.i("MicroMsg.NetSceneBgFg", "summerbgfg setBgFgForMuteRoom isFg[%s], accHasReady[%s] stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(au.DK()), bk.csb() });
    if (!au.DK()) {
      return;
    }
    if ((au.Dk() == null) || (au.Dk().edx == null) || (au.Dk().edx.KR() == null))
    {
      y.i("MicroMsg.NetSceneBgFg", "summerbgfg setBgFgForMuteRoom push not rready");
      return;
    }
    au.Dk().edx.KR().bN(paramBoolean);
    if (paramBoolean)
    {
      au.Dk().a(new c(true), 0);
      return;
    }
    c localc = new c(Qe());
    au.Dk().a(localc, 0);
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.edR, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneBgFg", " ret[%d]", new Object[] { Integer.valueOf(((l.b)paramq.HF()).spR.iHq) });
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelsimple.c
 * JD-Core Version:    0.7.0.1
 */