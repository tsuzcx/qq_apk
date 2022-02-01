package com.tencent.mm.aa.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bmu;
import com.tencent.mm.protocal.protobuf.bmv;
import com.tencent.mm.protocal.protobuf.eat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class c
  extends n
  implements k
{
  private g gfX;
  private a<c> gga;
  private final b rr;
  
  private c(String paramString1, LinkedList<String> paramLinkedList, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(150097);
    ac.i("MicroMsg.webview.NetSceneJSLogin", "NetSceneJSLogin doScene appId [%s], loginType [%d], url [%s], state [%s], versionType [%d], extScene [%d]", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, paramString3, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bmu();
    ((b.a)localObject).hvu = new bmv();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-login";
    ((b.a)localObject).funcId = 1029;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (bmu)this.rr.hvr.hvw;
    ((bmu)localObject).hOf = paramString1;
    ((bmu)localObject).FbP = paramLinkedList;
    ((bmu)localObject).FbZ = paramInt1;
    ((bmu)localObject).Url = paramString2;
    ((bmu)localObject).Fca = paramString3;
    ((bmu)localObject).FbR = paramInt2;
    if (paramInt3 > 0)
    {
      ((bmu)localObject).FbS = new eat();
      ((bmu)localObject).FbS.scene = paramInt3;
    }
    AppMethodBeat.o(150097);
  }
  
  public c(String paramString1, LinkedList<String> paramLinkedList, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, a<c> parama)
  {
    this(paramString1, paramLinkedList, paramInt1, paramString2, paramString3, paramInt2, paramInt3);
    this.gga = parama;
  }
  
  public c(String paramString1, LinkedList<String> paramLinkedList, String paramString2, String paramString3, a<c> parama)
  {
    this(paramString1, paramLinkedList, 0, paramString2, paramString3, 0, -1, parama);
  }
  
  public final bmu afu()
  {
    if (this.rr == null) {
      return null;
    }
    return (bmu)this.rr.hvr.hvw;
  }
  
  public final bmv afv()
  {
    return (bmv)this.rr.hvs.hvw;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(150099);
    ac.i("MicroMsg.webview.NetSceneJSLogin", "doScene");
    this.gfX = paramg;
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
    ac.i("MicroMsg.webview.NetSceneJSLogin", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gfX != null) {
      this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.gga != null) {
      this.gga.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(150098);
  }
  
  public static abstract interface a<T extends n>
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.aa.a.c
 * JD-Core Version:    0.7.0.1
 */