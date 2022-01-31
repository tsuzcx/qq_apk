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
import com.tencent.mm.protocal.c.arp;
import com.tencent.mm.protocal.c.arq;
import com.tencent.mm.protocal.c.cms;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class d
  extends m
  implements k
{
  private f dIJ;
  private d.a<d> dIN;
  private final b dmK;
  
  private d(String paramString1, LinkedList<String> paramLinkedList, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4)
  {
    y.i("MicroMsg.webview.NetSceneJSLoginConfirm", "NetSceneJSLogin doScene appId [%s], login_type [%d], state [%s], versionType [%d], opt [%d], extScene [%d]", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new arp();
    ((b.a)localObject).ecI = new arq();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-login-confirm";
    ((b.a)localObject).ecG = 1117;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (arp)this.dmK.ecE.ecN;
    if (paramInt4 > 0)
    {
      ((arp)localObject).tna = new cms();
      ((arp)localObject).tna.scene = paramInt4;
    }
    ((arp)localObject).euK = paramString1;
    ((arp)localObject).tmX = paramLinkedList;
    ((arp)localObject).tnc = paramInt1;
    ((arp)localObject).tnd = paramString2;
    ((arp)localObject).tmZ = paramInt2;
    ((arp)localObject).tmY = paramInt3;
  }
  
  public d(String paramString1, LinkedList<String> paramLinkedList, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, d.a<d> parama)
  {
    this(paramString1, paramLinkedList, paramInt1, paramString2, paramInt2, paramInt3, paramInt4);
    this.dIN = parama;
  }
  
  public d(String paramString1, LinkedList<String> paramLinkedList, String paramString2, int paramInt, d.a<d> parama)
  {
    this(paramString1, paramLinkedList, 0, paramString2, 0, paramInt, -1, parama);
  }
  
  public final arp CB()
  {
    if (this.dmK == null) {
      return null;
    }
    return (arp)this.dmK.ecE.ecN;
  }
  
  public final arq CC()
  {
    return (arq)this.dmK.ecF.ecN;
  }
  
  public final int a(e parame, f paramf)
  {
    y.i("MicroMsg.webview.NetSceneJSLoginConfirm", "doScene");
    this.dIJ = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.webview.NetSceneJSLoginConfirm", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.dIJ != null) {
      this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.dIN != null) {
      this.dIN.a(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1117;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.aa.a.d
 * JD-Core Version:    0.7.0.1
 */