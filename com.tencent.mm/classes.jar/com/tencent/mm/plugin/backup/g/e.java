package com.tencent.mm.plugin.backup.g;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.protocal.c.aeh;
import com.tencent.mm.protocal.c.aei;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class e
  extends m
  implements k
{
  private final com.tencent.mm.ah.b dmK;
  private f dmL;
  
  public e(String paramString)
  {
    y.i("MicroMsg.NetSceneGetConnectInfo", "summerbak NetSceneGetConnectInfo init, url[%s], stack[%s]", new Object[] { paramString, bk.csb() });
    b.a locala = new b.a();
    locala.ecH = new aeh();
    locala.ecI = new aei();
    locala.uri = "/cgi-bin/micromsg-bin/getconnectinfo";
    locala.ecJ = 0;
    locala.ecK = 0;
    locala.ecG = 595;
    this.dmK = locala.Kt();
    ((aeh)this.dmK.ecE.ecN).URL = paramString;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetConnectInfo", "onGYNetEnd errType[%d], errCode[%d]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = avb();
      d.T(paramq.syK.tFM.oY);
      y.i("MicroMsg.NetSceneGetConnectInfo", "onGYNetEnd id[%s], hello[%s], ok[%s], PCName[%s], PCAcctName[%s], scene[%d], resource[%s]", new Object[] { paramq.ID, paramq.szi, paramq.szj, paramq.sza, paramq.szb, Integer.valueOf(paramq.pyo), paramq.tcs });
      paramq = paramq.syK.tFM;
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final aei avb()
  {
    return (aei)this.dmK.ecF.ecN;
  }
  
  public final int getType()
  {
    return 595;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.e
 * JD-Core Version:    0.7.0.1
 */