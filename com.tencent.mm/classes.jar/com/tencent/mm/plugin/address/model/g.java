package com.tencent.mm.plugin.address.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.protocal.c.biw;
import com.tencent.mm.protocal.c.bjc;
import com.tencent.mm.protocal.c.bjd;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class g
  extends m
  implements k
{
  private b dmK;
  private f dmL;
  
  public g(int paramInt)
  {
    b.a locala = new b.a();
    locala.ecH = new bjc();
    locala.ecI = new bjd();
    locala.uri = "/cgi-bin/micromsg-bin/rcptinfotouch";
    locala.ecG = 419;
    locala.ecJ = 204;
    locala.ecK = 1000000204;
    this.dmK = locala.Kt();
    ((bjc)this.dmK.ecE.ecN).id = paramInt;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneRcptInfoTouch", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bjd)((b)paramq).ecF.ecN;
      if (paramq.tCP.tCS != null)
      {
        y.d("MicroMsg.NetSceneRcptInfoTouch", "resp.rImpl.rcptinfolist.rcptinfolist " + paramq.tCP.tCS.size());
        a.YB();
        a.YD().s(paramq.tCP.tCS);
        a.YB();
        a.YD().YF();
      }
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 419;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.g
 * JD-Core Version:    0.7.0.1
 */