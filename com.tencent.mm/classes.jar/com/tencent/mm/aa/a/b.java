package com.tencent.mm.aa.a;

import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.arl;
import com.tencent.mm.protocal.c.arm;
import com.tencent.mm.protocal.c.cms;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class b
  extends m
  implements k
{
  private f dIJ;
  private b.a<b> dIL;
  private final com.tencent.mm.ah.b dmK;
  
  private b(String paramString, LinkedList<String> paramLinkedList, int paramInt1, int paramInt2, int paramInt3)
  {
    y.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "NetSceneJSLogin doScene appId [%s], versionType [%d], opt [%d], extScene [%d]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    Object localObject = new com.tencent.mm.ah.b.a();
    ((com.tencent.mm.ah.b.a)localObject).ecH = new arl();
    ((com.tencent.mm.ah.b.a)localObject).ecI = new arm();
    ((com.tencent.mm.ah.b.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
    ((com.tencent.mm.ah.b.a)localObject).ecG = 1158;
    ((com.tencent.mm.ah.b.a)localObject).ecJ = 0;
    ((com.tencent.mm.ah.b.a)localObject).ecK = 0;
    this.dmK = ((com.tencent.mm.ah.b.a)localObject).Kt();
    localObject = (arl)this.dmK.ecE.ecN;
    if (paramInt3 > 0)
    {
      ((arl)localObject).tna = new cms();
      ((arl)localObject).tna.scene = paramInt3;
    }
    ((arl)localObject).euK = paramString;
    ((arl)localObject).tmX = paramLinkedList;
    ((arl)localObject).tmZ = paramInt1;
    ((arl)localObject).tmY = paramInt2;
  }
  
  public b(String paramString, LinkedList<String> paramLinkedList, int paramInt1, int paramInt2, int paramInt3, b.a<b> parama)
  {
    this(paramString, paramLinkedList, paramInt1, paramInt2, paramInt3);
    this.dIL = parama;
  }
  
  public b(String paramString, LinkedList<String> paramLinkedList, int paramInt, b.a<b> parama)
  {
    this(paramString, paramLinkedList, 0, paramInt, -1, parama);
  }
  
  public final arl Cx()
  {
    if (this.dmK == null) {
      return null;
    }
    return (arl)this.dmK.ecE.ecN;
  }
  
  public final arm Cy()
  {
    return (arm)this.dmK.ecF.ecN;
  }
  
  public final int a(e parame, f paramf)
  {
    y.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "doScene");
    this.dIJ = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.dIJ != null) {
      this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.dIL != null) {
      this.dIL.a(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1158;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.aa.a.b
 * JD-Core Version:    0.7.0.1
 */