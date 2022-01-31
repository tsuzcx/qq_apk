package com.tencent.mm.plugin.address.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.tu;
import com.tencent.mm.protocal.c.tv;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends m
  implements k
{
  private b dmK;
  private f dmL;
  
  public a(int paramInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new tu();
    ((b.a)localObject).ecI = new tv();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/deleteinfo";
    ((b.a)localObject).ecG = 1194;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (tu)this.dmK.ecE.ecN;
    ((tu)localObject).sQH = "invoice_info";
    ((tu)localObject).group_id = paramInt;
    ((tu)localObject).source = 2;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneDeleteUserAutoFillInfo", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      y.i("MicroMsg.NetSceneDeleteUserAutoFillInfo", "");
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1194;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.a
 * JD-Core Version:    0.7.0.1
 */