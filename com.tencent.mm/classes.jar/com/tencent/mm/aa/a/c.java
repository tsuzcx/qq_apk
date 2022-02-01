package com.tencent.mm.aa.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bry;
import com.tencent.mm.protocal.protobuf.brz;
import com.tencent.mm.protocal.protobuf.eio;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class c
  extends n
  implements k
{
  private f gCo;
  private c.a<c> gCr;
  private final b rr;
  
  private c(String paramString1, LinkedList<String> paramLinkedList, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(150097);
    ae.i("MicroMsg.webview.NetSceneJSLogin", "NetSceneJSLogin doScene appId [%s], loginType [%d], url [%s], state [%s], versionType [%d], extScene [%d]", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, paramString3, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bry();
    ((b.a)localObject).hQG = new brz();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-login";
    ((b.a)localObject).funcId = 1029;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bry)this.rr.hQD.hQJ;
    ((bry)localObject).ikm = paramString1;
    ((bry)localObject).HeP = paramLinkedList;
    ((bry)localObject).Hfa = paramInt1;
    ((bry)localObject).Url = paramString2;
    ((bry)localObject).Hfb = paramString3;
    ((bry)localObject).HeR = paramInt2;
    if (paramInt3 > 0)
    {
      ((bry)localObject).HeS = new eio();
      ((bry)localObject).HeS.scene = paramInt3;
    }
    AppMethodBeat.o(150097);
  }
  
  public c(String paramString1, LinkedList<String> paramLinkedList, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, c.a<c> parama)
  {
    this(paramString1, paramLinkedList, paramInt1, paramString2, paramString3, paramInt2, paramInt3);
    this.gCr = parama;
  }
  
  public c(String paramString1, LinkedList<String> paramLinkedList, String paramString2, String paramString3, c.a<c> parama)
  {
    this(paramString1, paramLinkedList, 0, paramString2, paramString3, 0, -1, parama);
  }
  
  public final bry aiv()
  {
    if (this.rr == null) {
      return null;
    }
    return (bry)this.rr.hQD.hQJ;
  }
  
  public final brz aiw()
  {
    return (brz)this.rr.hQE.hQJ;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(150099);
    ae.i("MicroMsg.webview.NetSceneJSLogin", "doScene");
    this.gCo = paramf;
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
    ae.i("MicroMsg.webview.NetSceneJSLogin", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gCo != null) {
      this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.gCr != null) {
      this.gCr.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(150098);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.aa.a.c
 * JD-Core Version:    0.7.0.1
 */