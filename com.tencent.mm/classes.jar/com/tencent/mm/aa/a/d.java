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
import com.tencent.mm.protocal.protobuf.brw;
import com.tencent.mm.protocal.protobuf.brx;
import com.tencent.mm.protocal.protobuf.eio;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class d
  extends n
  implements k
{
  private f gCo;
  private a<d> gCs;
  private final b rr;
  
  private d(String paramString1, LinkedList<String> paramLinkedList, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(150100);
    ae.i("MicroMsg.webview.NetSceneJSLoginConfirm", "NetSceneJSLogin doScene appId [%s], login_type [%d], state [%s], versionType [%d], opt [%d], extScene [%d]", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new brw();
    ((b.a)localObject).hQG = new brx();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-login-confirm";
    ((b.a)localObject).funcId = 1117;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (brw)this.rr.hQD.hQJ;
    if (paramInt4 > 0)
    {
      ((brw)localObject).HeS = new eio();
      ((brw)localObject).HeS.scene = paramInt4;
    }
    ((brw)localObject).ikm = paramString1;
    ((brw)localObject).HeP = paramLinkedList;
    ((brw)localObject).Hfa = paramInt1;
    ((brw)localObject).Hfb = paramString2;
    ((brw)localObject).HeR = paramInt2;
    ((brw)localObject).HeQ = paramInt3;
    AppMethodBeat.o(150100);
  }
  
  public d(String paramString1, LinkedList<String> paramLinkedList, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, a<d> parama)
  {
    this(paramString1, paramLinkedList, paramInt1, paramString2, paramInt2, paramInt3, paramInt4);
    this.gCs = parama;
  }
  
  public d(String paramString1, LinkedList<String> paramLinkedList, String paramString2, int paramInt, a<d> parama)
  {
    this(paramString1, paramLinkedList, 0, paramString2, 0, paramInt, -1, parama);
  }
  
  public final brw aix()
  {
    if (this.rr == null) {
      return null;
    }
    return (brw)this.rr.hQD.hQJ;
  }
  
  public final brx aiy()
  {
    return (brx)this.rr.hQE.hQJ;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(150102);
    ae.i("MicroMsg.webview.NetSceneJSLoginConfirm", "doScene");
    this.gCo = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(150102);
    return i;
  }
  
  public final int getType()
  {
    return 1117;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150101);
    ae.i("MicroMsg.webview.NetSceneJSLoginConfirm", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gCo != null) {
      this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.gCs != null) {
      this.gCs.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(150101);
  }
  
  public static abstract interface a<T extends n>
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.aa.a.d
 * JD-Core Version:    0.7.0.1
 */