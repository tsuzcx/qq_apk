package com.tencent.mm.ai.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aqj;
import com.tencent.mm.protocal.c.aqk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class t
  extends m
  implements k
{
  Object data;
  public b dmK;
  private f dmL;
  public String eia;
  
  public t(String paramString1, String paramString2, LinkedList<String> paramLinkedList, Object paramObject)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new aqj();
    ((b.a)localObject).ecI = new aqk();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/initiatebizchat";
    ((b.a)localObject).ecG = 1389;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (aqj)this.dmK.ecE.ecN;
    ((aqj)localObject).sPM = paramString1;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    ((aqj)localObject).tmq = paramString1;
    ((aqj)localObject).tmr = paramLinkedList;
    this.data = paramObject;
  }
  
  public final aqk MV()
  {
    if ((this.dmK != null) && (this.dmK.ecF.ecN != null)) {
      return (aqk)this.dmK.ecF.ecN;
    }
    return null;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    y.i("MicroMsg.NetSceneInitiateBizChat", "do scene");
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneInitiateBizChat", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1389;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ai.a.t
 * JD-Core Version:    0.7.0.1
 */