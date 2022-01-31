package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.atb;
import com.tencent.mm.protocal.c.bfr;
import com.tencent.mm.protocal.c.xj;
import com.tencent.mm.protocal.c.xk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class l
  extends m
  implements k
{
  private b dmK;
  private f dmL;
  private LinkedList<atb> jMM = null;
  public bfr jMN = null;
  public String jMO = null;
  public String jMP = null;
  public String jMQ = null;
  public float jMR;
  public int jMS;
  
  public l(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new xj();
    ((b.a)localObject).ecI = new xk();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/faceidentifyprepage";
    ((b.a)localObject).ecG = 1147;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (xj)this.dmK.ecE.ecN;
    ((xj)localObject).bOL = paramString1;
    ((xj)localObject).sTW = paramString2;
    ((xj)localObject).jMS = paramInt;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneFaceGetConfirmPageInfo", "alvinluo errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (xk)((b)paramq).ecF.ecN;
    if (paramq != null)
    {
      this.jMM = paramq.sKO;
      this.jMN = paramq.sTX;
      this.jMO = paramq.sTZ;
      this.jMP = paramq.sUa;
      this.jMQ = paramq.sUb;
      this.jMR = paramq.sUc;
      this.jMS = paramq.jMS;
      y.d("MicroMsg.NetSceneFaceGetConfirmPageInfo", "Light threshold is A : " + this.jMR);
      y.d("MicroMsg.NetSceneFaceGetConfirmPageInfo", "check_alive_type is  : " + this.jMS);
      if (this.dmL != null) {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
    }
  }
  
  public final int getType()
  {
    return 1147;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.l
 * JD-Core Version:    0.7.0.1
 */