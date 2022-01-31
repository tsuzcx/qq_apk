package com.tencent.mm.aa.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.arn;
import com.tencent.mm.protocal.c.aro;
import com.tencent.mm.protocal.c.cms;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class a
  extends m
  implements k
{
  private f dIJ;
  private a.a<a> dIK;
  private final b dmK;
  
  private a(String paramString, LinkedList<String> paramLinkedList, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.webview.NetSceneJSAuthorize", "NetSceneJSLogin doScene appId [%s], versionType [%d], extScene[%d]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new arn();
    ((b.a)localObject).ecI = new aro();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-authorize";
    ((b.a)localObject).ecG = 1157;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (arn)this.dmK.ecE.ecN;
    if (paramInt2 > 0)
    {
      ((arn)localObject).tna = new cms();
      ((arn)localObject).tna.scene = paramInt2;
    }
    ((arn)localObject).euK = paramString;
    ((arn)localObject).tmX = paramLinkedList;
    ((arn)localObject).tmZ = paramInt1;
  }
  
  public a(String paramString, LinkedList<String> paramLinkedList, int paramInt1, int paramInt2, a.a<a> parama)
  {
    this(paramString, paramLinkedList, paramInt1, paramInt2);
    this.dIK = parama;
  }
  
  public a(String paramString, LinkedList<String> paramLinkedList, a.a<a> parama)
  {
    this(paramString, paramLinkedList, 0, -1, parama);
  }
  
  public final arn Cv()
  {
    if (this.dmK == null) {
      return null;
    }
    return (arn)this.dmK.ecE.ecN;
  }
  
  public final aro Cw()
  {
    return (aro)this.dmK.ecF.ecN;
  }
  
  public final int a(e parame, f paramf)
  {
    y.i("MicroMsg.webview.NetSceneJSAuthorize", "doScene");
    this.dIJ = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.webview.NetSceneJSAuthorize", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.dIJ != null) {
      this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.dIK != null) {
      this.dIK.a(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1157;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aa.a.a
 * JD-Core Version:    0.7.0.1
 */