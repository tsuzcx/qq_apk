package com.tencent.mm.bd;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ato;
import com.tencent.mm.protocal.c.bpu;
import com.tencent.mm.protocal.c.bpv;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  String exJ;
  
  public a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4, String paramString3)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bpu();
    ((b.a)localObject).ecI = new bpv();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sensewhere";
    ((b.a)localObject).ecG = 752;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = new ato();
    ((ato)localObject).sUp = paramString2;
    ((ato)localObject).sUq = paramInt2;
    ((ato)localObject).sGK = paramFloat2;
    ((ato)localObject).sGJ = paramFloat1;
    ((ato)localObject).sUo = paramString1;
    ((ato)localObject).sUn = paramInt1;
    paramString1 = (bpu)this.dmK.ecE.ecN;
    paramString1.sQj = ((ato)localObject);
    paramString1.tHv = paramInt3;
    paramString1.pyo = paramInt4;
    paramString1.kVs = paramString3;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneUploadSenseWhere", "upload sense where info. errType[%d] errCode[%d] errMsg[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.exJ = ((bpv)((b)paramq).ecF.ecN).kVs;
    }
    for (;;)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      y.w("MicroMsg.NetSceneUploadSenseWhere", "upload sense where error");
    }
  }
  
  public final int getType()
  {
    return 752;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bd.a
 * JD-Core Version:    0.7.0.1
 */