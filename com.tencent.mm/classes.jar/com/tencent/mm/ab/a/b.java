package com.tencent.mm.ab.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bqy;
import com.tencent.mm.protocal.protobuf.bqz;
import com.tencent.mm.protocal.protobuf.egx;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class b
  extends n
  implements k
{
  private f gzH;
  private a<b> gzJ;
  private final com.tencent.mm.al.b rr;
  
  private b(String paramString, LinkedList<String> paramLinkedList, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(150094);
    ad.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "NetSceneJSLogin doScene appId [%s], versionType [%d], opt [%d], extScene [%d]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    Object localObject = new com.tencent.mm.al.b.a();
    ((com.tencent.mm.al.b.a)localObject).hNM = new bqy();
    ((com.tencent.mm.al.b.a)localObject).hNN = new bqz();
    ((com.tencent.mm.al.b.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
    ((com.tencent.mm.al.b.a)localObject).funcId = 1158;
    ((com.tencent.mm.al.b.a)localObject).hNO = 0;
    ((com.tencent.mm.al.b.a)localObject).respCmdId = 0;
    this.rr = ((com.tencent.mm.al.b.a)localObject).aDC();
    localObject = (bqy)this.rr.hNK.hNQ;
    if (paramInt3 > 0)
    {
      ((bqy)localObject).GLr = new egx();
      ((bqy)localObject).GLr.scene = paramInt3;
    }
    ((bqy)localObject).iht = paramString;
    ((bqy)localObject).GLo = paramLinkedList;
    ((bqy)localObject).GLq = paramInt1;
    ((bqy)localObject).GLp = paramInt2;
    AppMethodBeat.o(150094);
  }
  
  public b(String paramString, LinkedList<String> paramLinkedList, int paramInt1, int paramInt2, int paramInt3, a<b> parama)
  {
    this(paramString, paramLinkedList, paramInt1, paramInt2, paramInt3);
    this.gzJ = parama;
  }
  
  public b(String paramString, LinkedList<String> paramLinkedList, int paramInt, a<b> parama)
  {
    this(paramString, paramLinkedList, 0, paramInt, -1, parama);
  }
  
  public final bqy aie()
  {
    if (this.rr == null) {
      return null;
    }
    return (bqy)this.rr.hNK.hNQ;
  }
  
  public final bqz aif()
  {
    return (bqz)this.rr.hNL.hNQ;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(150096);
    ad.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "doScene");
    this.gzH = paramf;
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
    ad.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gzH != null) {
      this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.gzJ != null) {
      this.gzJ.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(150095);
  }
  
  public static abstract interface a<T extends n>
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ab.a.b
 * JD-Core Version:    0.7.0.1
 */