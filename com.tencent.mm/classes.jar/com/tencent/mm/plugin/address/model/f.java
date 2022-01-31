package com.tencent.mm.plugin.address.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.protocal.c.biw;
import com.tencent.mm.protocal.c.bja;
import com.tencent.mm.protocal.c.bjb;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class f
  extends m
  implements k
{
  private b dmK;
  private com.tencent.mm.ah.f dmL;
  public int ftm = 0;
  
  public f(int paramInt)
  {
    b.a locala = new b.a();
    locala.ecH = new bja();
    locala.ecI = new bjb();
    locala.uri = "/cgi-bin/micromsg-bin/rcptinforemove";
    locala.ecG = 416;
    locala.ecJ = 201;
    locala.ecK = 1000000201;
    this.dmK = locala.Kt();
    this.ftm = paramInt;
    y.d("MicroMsg.NetSceneRcptInfoRemove", "remove Id " + paramInt);
    ((bja)this.dmK.ecE.ecN).id = paramInt;
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneRcptInfoRemove", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bjb)((b)paramq).ecF.ecN;
      if (paramq.tCP.tCS != null)
      {
        y.d("MicroMsg.NetSceneRcptInfoRemove", "resp.rImpl.rcptinfolist.rcptinfolist " + paramq.tCP.tCS.size());
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
    return 416;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.f
 * JD-Core Version:    0.7.0.1
 */