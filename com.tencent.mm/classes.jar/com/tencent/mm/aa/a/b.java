package com.tencent.mm.aa.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bmo;
import com.tencent.mm.protocal.protobuf.bmp;
import com.tencent.mm.protocal.protobuf.eat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class b
  extends n
  implements k
{
  private g gfX;
  private a<b> gfZ;
  private final com.tencent.mm.ak.b rr;
  
  private b(String paramString, LinkedList<String> paramLinkedList, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(150094);
    ac.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "NetSceneJSLogin doScene appId [%s], versionType [%d], opt [%d], extScene [%d]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    Object localObject = new com.tencent.mm.ak.b.a();
    ((com.tencent.mm.ak.b.a)localObject).hvt = new bmo();
    ((com.tencent.mm.ak.b.a)localObject).hvu = new bmp();
    ((com.tencent.mm.ak.b.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
    ((com.tencent.mm.ak.b.a)localObject).funcId = 1158;
    ((com.tencent.mm.ak.b.a)localObject).reqCmdId = 0;
    ((com.tencent.mm.ak.b.a)localObject).respCmdId = 0;
    this.rr = ((com.tencent.mm.ak.b.a)localObject).aAz();
    localObject = (bmo)this.rr.hvr.hvw;
    if (paramInt3 > 0)
    {
      ((bmo)localObject).FbS = new eat();
      ((bmo)localObject).FbS.scene = paramInt3;
    }
    ((bmo)localObject).hOf = paramString;
    ((bmo)localObject).FbP = paramLinkedList;
    ((bmo)localObject).FbR = paramInt1;
    ((bmo)localObject).FbQ = paramInt2;
    AppMethodBeat.o(150094);
  }
  
  public b(String paramString, LinkedList<String> paramLinkedList, int paramInt1, int paramInt2, int paramInt3, a<b> parama)
  {
    this(paramString, paramLinkedList, paramInt1, paramInt2, paramInt3);
    this.gfZ = parama;
  }
  
  public b(String paramString, LinkedList<String> paramLinkedList, int paramInt, a<b> parama)
  {
    this(paramString, paramLinkedList, 0, paramInt, -1, parama);
  }
  
  public final bmo afs()
  {
    if (this.rr == null) {
      return null;
    }
    return (bmo)this.rr.hvr.hvw;
  }
  
  public final bmp aft()
  {
    return (bmp)this.rr.hvs.hvw;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(150096);
    ac.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "doScene");
    this.gfX = paramg;
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
    ac.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gfX != null) {
      this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.gfZ != null) {
      this.gfZ.a(paramInt2, paramInt3, paramString, this);
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