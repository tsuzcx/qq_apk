package com.tencent.mm.aa.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.brs;
import com.tencent.mm.protocal.protobuf.brt;
import com.tencent.mm.protocal.protobuf.eio;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class b
  extends n
  implements k
{
  private f gCo;
  private a<b> gCq;
  private final com.tencent.mm.ak.b rr;
  
  private b(String paramString, LinkedList<String> paramLinkedList, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(150094);
    ae.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "NetSceneJSLogin doScene appId [%s], versionType [%d], opt [%d], extScene [%d]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    Object localObject = new com.tencent.mm.ak.b.a();
    ((com.tencent.mm.ak.b.a)localObject).hQF = new brs();
    ((com.tencent.mm.ak.b.a)localObject).hQG = new brt();
    ((com.tencent.mm.ak.b.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
    ((com.tencent.mm.ak.b.a)localObject).funcId = 1158;
    ((com.tencent.mm.ak.b.a)localObject).hQH = 0;
    ((com.tencent.mm.ak.b.a)localObject).respCmdId = 0;
    this.rr = ((com.tencent.mm.ak.b.a)localObject).aDS();
    localObject = (brs)this.rr.hQD.hQJ;
    if (paramInt3 > 0)
    {
      ((brs)localObject).HeS = new eio();
      ((brs)localObject).HeS.scene = paramInt3;
    }
    ((brs)localObject).ikm = paramString;
    ((brs)localObject).HeP = paramLinkedList;
    ((brs)localObject).HeR = paramInt1;
    ((brs)localObject).HeQ = paramInt2;
    AppMethodBeat.o(150094);
  }
  
  public b(String paramString, LinkedList<String> paramLinkedList, int paramInt1, int paramInt2, int paramInt3, a<b> parama)
  {
    this(paramString, paramLinkedList, paramInt1, paramInt2, paramInt3);
    this.gCq = parama;
  }
  
  public b(String paramString, LinkedList<String> paramLinkedList, int paramInt, a<b> parama)
  {
    this(paramString, paramLinkedList, 0, paramInt, -1, parama);
  }
  
  public final brs ait()
  {
    if (this.rr == null) {
      return null;
    }
    return (brs)this.rr.hQD.hQJ;
  }
  
  public final brt aiu()
  {
    return (brt)this.rr.hQE.hQJ;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(150096);
    ae.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "doScene");
    this.gCo = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(150096);
    return i;
  }
  
  public final int getType()
  {
    return 1158;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150095);
    ae.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gCo != null) {
      this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.gCq != null) {
      this.gCq.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(150095);
  }
  
  public static abstract interface a<T extends n>
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.aa.a.b
 * JD-Core Version:    0.7.0.1
 */