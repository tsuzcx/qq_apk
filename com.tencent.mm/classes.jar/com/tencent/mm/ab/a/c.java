package com.tencent.mm.ab.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bre;
import com.tencent.mm.protocal.protobuf.brf;
import com.tencent.mm.protocal.protobuf.egx;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class c
  extends n
  implements k
{
  private f gzH;
  private c.a<c> gzK;
  private final b rr;
  
  private c(String paramString1, LinkedList<String> paramLinkedList, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(150097);
    ad.i("MicroMsg.webview.NetSceneJSLogin", "NetSceneJSLogin doScene appId [%s], loginType [%d], url [%s], state [%s], versionType [%d], extScene [%d]", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, paramString3, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bre();
    ((b.a)localObject).hNN = new brf();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-login";
    ((b.a)localObject).funcId = 1029;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (bre)this.rr.hNK.hNQ;
    ((bre)localObject).iht = paramString1;
    ((bre)localObject).GLo = paramLinkedList;
    ((bre)localObject).GLz = paramInt1;
    ((bre)localObject).Url = paramString2;
    ((bre)localObject).GLA = paramString3;
    ((bre)localObject).GLq = paramInt2;
    if (paramInt3 > 0)
    {
      ((bre)localObject).GLr = new egx();
      ((bre)localObject).GLr.scene = paramInt3;
    }
    AppMethodBeat.o(150097);
  }
  
  public c(String paramString1, LinkedList<String> paramLinkedList, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, c.a<c> parama)
  {
    this(paramString1, paramLinkedList, paramInt1, paramString2, paramString3, paramInt2, paramInt3);
    this.gzK = parama;
  }
  
  public c(String paramString1, LinkedList<String> paramLinkedList, String paramString2, String paramString3, c.a<c> parama)
  {
    this(paramString1, paramLinkedList, 0, paramString2, paramString3, 0, -1, parama);
  }
  
  public final bre aig()
  {
    if (this.rr == null) {
      return null;
    }
    return (bre)this.rr.hNK.hNQ;
  }
  
  public final brf aih()
  {
    return (brf)this.rr.hNL.hNQ;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(150099);
    ad.i("MicroMsg.webview.NetSceneJSLogin", "doScene");
    this.gzH = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(150099);
    return i;
  }
  
  public final int getType()
  {
    return 1029;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150098);
    ad.i("MicroMsg.webview.NetSceneJSLogin", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gzH != null) {
      this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.gzK != null) {
      this.gzK.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(150098);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ab.a.c
 * JD-Core Version:    0.7.0.1
 */