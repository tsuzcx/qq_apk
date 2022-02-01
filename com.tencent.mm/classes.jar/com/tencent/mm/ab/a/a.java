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
import com.tencent.mm.protocal.protobuf.bra;
import com.tencent.mm.protocal.protobuf.brb;
import com.tencent.mm.protocal.protobuf.egx;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class a
  extends n
  implements k
{
  private f gzH;
  private a<a> gzI;
  private final b rr;
  
  private a(String paramString, LinkedList<String> paramLinkedList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150091);
    ad.i("MicroMsg.webview.NetSceneJSAuthorize", "NetSceneJSLogin doScene appId [%s], versionType [%d], extScene[%d]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bra();
    ((b.a)localObject).hNN = new brb();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-authorize";
    ((b.a)localObject).funcId = 1157;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (bra)this.rr.hNK.hNQ;
    if (paramInt2 > 0)
    {
      ((bra)localObject).GLr = new egx();
      ((bra)localObject).GLr.scene = paramInt2;
    }
    ((bra)localObject).iht = paramString;
    ((bra)localObject).GLo = paramLinkedList;
    ((bra)localObject).GLq = paramInt1;
    AppMethodBeat.o(150091);
  }
  
  public a(String paramString, LinkedList<String> paramLinkedList, int paramInt1, int paramInt2, a<a> parama)
  {
    this(paramString, paramLinkedList, paramInt1, paramInt2);
    this.gzI = parama;
  }
  
  public a(String paramString, LinkedList<String> paramLinkedList, a<a> parama)
  {
    this(paramString, paramLinkedList, 0, -1, parama);
  }
  
  public final bra aic()
  {
    if (this.rr == null) {
      return null;
    }
    return (bra)this.rr.hNK.hNQ;
  }
  
  public final brb aid()
  {
    return (brb)this.rr.hNL.hNQ;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(150093);
    ad.i("MicroMsg.webview.NetSceneJSAuthorize", "doScene");
    this.gzH = paramf;
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
    ad.i("MicroMsg.webview.NetSceneJSAuthorize", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gzH != null) {
      this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.gzI != null) {
      this.gzI.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(150092);
  }
  
  public static abstract interface a<T extends n>
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ab.a.a
 * JD-Core Version:    0.7.0.1
 */