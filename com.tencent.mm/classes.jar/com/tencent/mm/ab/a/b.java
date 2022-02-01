package com.tencent.mm.ab.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.biw;
import com.tencent.mm.protocal.protobuf.bix;
import com.tencent.mm.protocal.protobuf.dvc;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class b
  extends n
  implements k
{
  private g gbr;
  private a<b> gbt;
  private final com.tencent.mm.al.b rr;
  
  private b(String paramString, LinkedList<String> paramLinkedList, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(150094);
    ad.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "NetSceneJSLogin doScene appId [%s], versionType [%d], opt [%d], extScene [%d]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    Object localObject = new com.tencent.mm.al.b.a();
    ((com.tencent.mm.al.b.a)localObject).gUU = new biw();
    ((com.tencent.mm.al.b.a)localObject).gUV = new bix();
    ((com.tencent.mm.al.b.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
    ((com.tencent.mm.al.b.a)localObject).funcId = 1158;
    ((com.tencent.mm.al.b.a)localObject).reqCmdId = 0;
    ((com.tencent.mm.al.b.a)localObject).respCmdId = 0;
    this.rr = ((com.tencent.mm.al.b.a)localObject).atI();
    localObject = (biw)this.rr.gUS.gUX;
    if (paramInt3 > 0)
    {
      ((biw)localObject).DGy = new dvc();
      ((biw)localObject).DGy.scene = paramInt3;
    }
    ((biw)localObject).hnC = paramString;
    ((biw)localObject).DGv = paramLinkedList;
    ((biw)localObject).DGx = paramInt1;
    ((biw)localObject).DGw = paramInt2;
    AppMethodBeat.o(150094);
  }
  
  public b(String paramString, LinkedList<String> paramLinkedList, int paramInt1, int paramInt2, int paramInt3, a<b> parama)
  {
    this(paramString, paramLinkedList, paramInt1, paramInt2, paramInt3);
    this.gbt = parama;
  }
  
  public b(String paramString, LinkedList<String> paramLinkedList, int paramInt, a<b> parama)
  {
    this(paramString, paramLinkedList, 0, paramInt, -1, parama);
  }
  
  public final biw aec()
  {
    if (this.rr == null) {
      return null;
    }
    return (biw)this.rr.gUS.gUX;
  }
  
  public final bix aed()
  {
    return (bix)this.rr.gUT.gUX;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(150096);
    ad.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "doScene");
    this.gbr = paramg;
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
    if (this.gbr != null) {
      this.gbr.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.gbt != null) {
      this.gbt.a(paramInt2, paramInt3, paramString, this);
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