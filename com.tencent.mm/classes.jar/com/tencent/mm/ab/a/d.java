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
import com.tencent.mm.protocal.protobuf.brc;
import com.tencent.mm.protocal.protobuf.brd;
import com.tencent.mm.protocal.protobuf.egx;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class d
  extends n
  implements k
{
  private f gzH;
  private a<d> gzL;
  private final b rr;
  
  private d(String paramString1, LinkedList<String> paramLinkedList, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(150100);
    ad.i("MicroMsg.webview.NetSceneJSLoginConfirm", "NetSceneJSLogin doScene appId [%s], login_type [%d], state [%s], versionType [%d], opt [%d], extScene [%d]", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new brc();
    ((b.a)localObject).hNN = new brd();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-login-confirm";
    ((b.a)localObject).funcId = 1117;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (brc)this.rr.hNK.hNQ;
    if (paramInt4 > 0)
    {
      ((brc)localObject).GLr = new egx();
      ((brc)localObject).GLr.scene = paramInt4;
    }
    ((brc)localObject).iht = paramString1;
    ((brc)localObject).GLo = paramLinkedList;
    ((brc)localObject).GLz = paramInt1;
    ((brc)localObject).GLA = paramString2;
    ((brc)localObject).GLq = paramInt2;
    ((brc)localObject).GLp = paramInt3;
    AppMethodBeat.o(150100);
  }
  
  public d(String paramString1, LinkedList<String> paramLinkedList, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, a<d> parama)
  {
    this(paramString1, paramLinkedList, paramInt1, paramString2, paramInt2, paramInt3, paramInt4);
    this.gzL = parama;
  }
  
  public d(String paramString1, LinkedList<String> paramLinkedList, String paramString2, int paramInt, a<d> parama)
  {
    this(paramString1, paramLinkedList, 0, paramString2, 0, paramInt, -1, parama);
  }
  
  public final brc aii()
  {
    if (this.rr == null) {
      return null;
    }
    return (brc)this.rr.hNK.hNQ;
  }
  
  public final brd aij()
  {
    return (brd)this.rr.hNL.hNQ;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(150102);
    ad.i("MicroMsg.webview.NetSceneJSLoginConfirm", "doScene");
    this.gzH = paramf;
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
    ad.i("MicroMsg.webview.NetSceneJSLoginConfirm", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gzH != null) {
      this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.gzL != null) {
      this.gzL.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(150101);
  }
  
  public static abstract interface a<T extends n>
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ab.a.d
 * JD-Core Version:    0.7.0.1
 */