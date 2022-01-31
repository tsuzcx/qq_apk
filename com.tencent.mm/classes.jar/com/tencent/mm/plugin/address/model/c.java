package com.tencent.mm.plugin.address.model;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.protocal.c.bis;
import com.tencent.mm.protocal.c.bit;
import com.tencent.mm.protocal.c.biw;
import com.tencent.mm.protocal.c.bix;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class c
  extends m
  implements k
{
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  
  public c(com.tencent.mm.plugin.address.d.b paramb)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bis();
    ((b.a)localObject).ecI = new bit();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/rcptinfoadd";
    ((b.a)localObject).ecG = 415;
    ((b.a)localObject).ecJ = 200;
    ((b.a)localObject).ecK = 1000000200;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bis)this.dmK.ecE.ecN;
    ((bis)localObject).tCO = new bix();
    ((bis)localObject).tCO.tCV = new bml().YI(bk.aM(paramb.ftD, ""));
    ((bis)localObject).tCO.tCT = new bml().YI(bk.aM(paramb.ftB, ""));
    ((bis)localObject).tCO.tCY = new bml().YI(bk.aM(paramb.ftG, ""));
    ((bis)localObject).tCO.tCW = new bml().YI(bk.aM(paramb.ftE, ""));
    ((bis)localObject).tCO.tCZ = new bml().YI(bk.aM(paramb.ftH, ""));
    ((bis)localObject).tCO.tDa = new bml().YI(bk.aM(paramb.ftI, ""));
    ((bis)localObject).tCO.tCU = new bml().YI(bk.aM(paramb.ftC, ""));
    ((bis)localObject).tCO.tCX = new bml().YI(bk.aM(paramb.ftF, ""));
    ((bis)localObject).tCO.tDb = new bml().YI(bk.aM(paramb.ftJ, ""));
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneRcptInfoAdd", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bit)((com.tencent.mm.ah.b)paramq).ecF.ecN;
      if (paramq.tCP.tCS != null)
      {
        y.d("MicroMsg.NetSceneRcptInfoAdd", "resp.rImpl.rcptinfolist.rcptinfolist " + paramq.tCP.tCS.size());
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
    return 415;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.c
 * JD-Core Version:    0.7.0.1
 */