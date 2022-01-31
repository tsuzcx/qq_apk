package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.qw;
import com.tencent.mm.protocal.c.yq;
import com.tencent.mm.protocal.c.yr;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class aj
  extends m
  implements k
{
  final com.tencent.mm.ah.b dmK;
  f dmL = null;
  private aj.a jZR = new aj.a(this);
  long jZS = -1L;
  public boolean jZT = false;
  private int selector = 1;
  
  public aj()
  {
    y.i("MicroMsg.Fav.NetSceneFavSync", "NetSceneFavSync");
    b.a locala = new b.a();
    locala.ecH = new yq();
    locala.ecI = new yr();
    locala.uri = "/cgi-bin/micromsg-bin/favsync";
    locala.ecG = 400;
    locala.ecJ = 195;
    locala.ecK = 1000000195;
    locala.ecL = false;
    this.dmK = locala.Kt();
  }
  
  public aj(int paramInt)
  {
    y.i("MicroMsg.Fav.NetSceneFavSync", "NetSceneFavSync %d", new Object[] { Integer.valueOf(paramInt) });
    b.a locala = new b.a();
    locala.ecH = new yq();
    locala.ecI = new yr();
    locala.uri = "/cgi-bin/micromsg-bin/favsync";
    locala.ecG = 400;
    locala.ecJ = 195;
    locala.ecK = 1000000195;
    locala.ecL = false;
    this.dmK = locala.Kt();
    this.selector = paramInt;
  }
  
  protected final int Ka()
  {
    return 50;
  }
  
  public final boolean Kx()
  {
    return true;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    yq localyq = (yq)this.dmK.ecE.ecN;
    localyq.sIh = this.selector;
    paramf = ((ae)g.t(ae.class)).getFavConfigStorage().aQr();
    if (this.selector == 2) {
      paramf = new byte[0];
    }
    localyq.sIi = aa.I(paramf);
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.Fav.NetSceneFavSync", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if (((ae)g.t(ae.class)).getSendService().Tk())
    {
      y.w("MicroMsg.Fav.NetSceneFavSync", "sending item, skip sync onGYNetEnd");
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    yr localyr = (yr)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    paramArrayOfByte = localyr.sIl.hPT;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
    {
      y.i("MicroMsg.Fav.NetSceneFavSync", "cmdList size:" + paramArrayOfByte.size());
      if (this.selector != 2)
      {
        paramString = this.jZR;
        paramString.jZU = paramArrayOfByte;
        if ((paramString.jZU != null) && (paramString.jZU.size() > 0))
        {
          paramq = new ak();
          g.Dk().a(paramq, 0);
        }
        paramString.jZV.sendEmptyMessage(0);
        return;
      }
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if (localyr.sIi.tFM != null)
    {
      paramArrayOfByte = localyr.sIi.tFM.toByteArray();
      paramq = com.tencent.mm.protocal.z.g(((yq)((com.tencent.mm.ah.b)paramq).ecE.ecN).sIi.tFM.toByteArray(), paramArrayOfByte);
      if ((paramq != null) && (paramq.length > 0)) {
        ((ae)g.t(ae.class)).getFavConfigStorage().ay(paramq);
      }
    }
    for (;;)
    {
      g.DP().Dz().o(8217, Integer.valueOf(1));
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      y.e("MicroMsg.Fav.NetSceneFavSync", "merge key should not be null");
    }
  }
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 400;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.aj
 * JD-Core Version:    0.7.0.1
 */