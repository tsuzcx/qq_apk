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
import com.tencent.mm.protocal.protobuf.bru;
import com.tencent.mm.protocal.protobuf.brv;
import com.tencent.mm.protocal.protobuf.eio;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class a
  extends n
  implements k
{
  private f gCo;
  private a<a> gCp;
  private final b rr;
  
  private a(String paramString, LinkedList<String> paramLinkedList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150091);
    ae.i("MicroMsg.webview.NetSceneJSAuthorize", "NetSceneJSLogin doScene appId [%s], versionType [%d], extScene[%d]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bru();
    ((b.a)localObject).hQG = new brv();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-authorize";
    ((b.a)localObject).funcId = 1157;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bru)this.rr.hQD.hQJ;
    if (paramInt2 > 0)
    {
      ((bru)localObject).HeS = new eio();
      ((bru)localObject).HeS.scene = paramInt2;
    }
    ((bru)localObject).ikm = paramString;
    ((bru)localObject).HeP = paramLinkedList;
    ((bru)localObject).HeR = paramInt1;
    AppMethodBeat.o(150091);
  }
  
  public a(String paramString, LinkedList<String> paramLinkedList, int paramInt1, int paramInt2, a<a> parama)
  {
    this(paramString, paramLinkedList, paramInt1, paramInt2);
    this.gCp = parama;
  }
  
  public a(String paramString, LinkedList<String> paramLinkedList, a<a> parama)
  {
    this(paramString, paramLinkedList, 0, -1, parama);
  }
  
  public final bru air()
  {
    if (this.rr == null) {
      return null;
    }
    return (bru)this.rr.hQD.hQJ;
  }
  
  public final brv ais()
  {
    return (brv)this.rr.hQE.hQJ;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(150093);
    ae.i("MicroMsg.webview.NetSceneJSAuthorize", "doScene");
    this.gCo = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(150093);
    return i;
  }
  
  public final int getType()
  {
    return 1157;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150092);
    ae.i("MicroMsg.webview.NetSceneJSAuthorize", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gCo != null) {
      this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.gCp != null) {
      this.gCp.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(150092);
  }
  
  public static abstract interface a<T extends n>
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.aa.a.a
 * JD-Core Version:    0.7.0.1
 */