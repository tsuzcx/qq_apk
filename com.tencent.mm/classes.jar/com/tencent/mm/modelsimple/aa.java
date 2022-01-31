package com.tencent.mm.modelsimple;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.byx;
import com.tencent.mm.protocal.c.byy;
import com.tencent.mm.protocal.c.cw;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class aa
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  
  public aa(String paramString, int paramInt, LinkedList<cw> paramLinkedList)
  {
    y.i("MicroMsg.NetSceneTranslateLink", "ticket link = " + paramString + "; scene = " + paramInt);
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new byx();
    ((b.a)localObject).ecI = new byy();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/translatelink";
    ((b.a)localObject).ecG = 1200;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (byx)this.dmK.ecE.ecN;
    ((byx)localObject).eAl = paramString;
    ((byx)localObject).scene = paramInt;
    ((byx)localObject).tOW = paramLinkedList;
  }
  
  public final String QQ()
  {
    byy localbyy = (byy)this.dmK.ecF.ecN;
    if (localbyy == null) {
      return null;
    }
    return localbyy.tOX;
  }
  
  public final byy QR()
  {
    if ((this.dmK != null) && (this.dmK.ecF.ecN != null)) {
      return (byy)this.dmK.ecF.ecN;
    }
    return null;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneTranslateLink", "swap deep link with ticket onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1200;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.aa
 * JD-Core Version:    0.7.0.1
 */