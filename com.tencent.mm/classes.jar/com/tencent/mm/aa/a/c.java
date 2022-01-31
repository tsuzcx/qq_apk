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
import com.tencent.mm.protocal.c.arr;
import com.tencent.mm.protocal.c.ars;
import com.tencent.mm.protocal.c.cms;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class c
  extends m
  implements k
{
  private f dIJ;
  private c.a<c> dIM;
  private final b dmK;
  
  private c(String paramString1, LinkedList<String> paramLinkedList, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3)
  {
    y.i("MicroMsg.webview.NetSceneJSLogin", "NetSceneJSLogin doScene appId [%s], loginType [%d], url [%s], state [%s], versionType [%d], extScene [%d]", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, paramString3, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new arr();
    ((b.a)localObject).ecI = new ars();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-login";
    ((b.a)localObject).ecG = 1029;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (arr)this.dmK.ecE.ecN;
    ((arr)localObject).euK = paramString1;
    ((arr)localObject).tmX = paramLinkedList;
    ((arr)localObject).tnc = paramInt1;
    ((arr)localObject).kSC = paramString2;
    ((arr)localObject).tnd = paramString3;
    ((arr)localObject).tmZ = paramInt2;
    if (paramInt3 > 0)
    {
      ((arr)localObject).tna = new cms();
      ((arr)localObject).tna.scene = paramInt3;
    }
  }
  
  public c(String paramString1, LinkedList<String> paramLinkedList, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, c.a<c> parama)
  {
    this(paramString1, paramLinkedList, paramInt1, paramString2, paramString3, paramInt2, paramInt3);
    this.dIM = parama;
  }
  
  public c(String paramString1, LinkedList<String> paramLinkedList, String paramString2, String paramString3, c.a<c> parama)
  {
    this(paramString1, paramLinkedList, 0, paramString2, paramString3, 0, -1, parama);
  }
  
  public final ars CA()
  {
    return (ars)this.dmK.ecF.ecN;
  }
  
  public final arr Cz()
  {
    if (this.dmK == null) {
      return null;
    }
    return (arr)this.dmK.ecE.ecN;
  }
  
  public final int a(e parame, f paramf)
  {
    y.i("MicroMsg.webview.NetSceneJSLogin", "doScene");
    this.dIJ = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.webview.NetSceneJSLogin", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.dIJ != null) {
      this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.dIM != null) {
      this.dIM.a(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1029;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.aa.a.c
 * JD-Core Version:    0.7.0.1
 */