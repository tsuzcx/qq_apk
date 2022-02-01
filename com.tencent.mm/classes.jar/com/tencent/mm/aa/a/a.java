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
import com.tencent.mm.protocal.protobuf.bmq;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.protocal.protobuf.eat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class a
  extends n
  implements k
{
  private g gfX;
  private a<a> gfY;
  private final b rr;
  
  private a(String paramString, LinkedList<String> paramLinkedList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150091);
    ac.i("MicroMsg.webview.NetSceneJSAuthorize", "NetSceneJSLogin doScene appId [%s], versionType [%d], extScene[%d]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bmq();
    ((b.a)localObject).hvu = new bmr();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-authorize";
    ((b.a)localObject).funcId = 1157;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (bmq)this.rr.hvr.hvw;
    if (paramInt2 > 0)
    {
      ((bmq)localObject).FbS = new eat();
      ((bmq)localObject).FbS.scene = paramInt2;
    }
    ((bmq)localObject).hOf = paramString;
    ((bmq)localObject).FbP = paramLinkedList;
    ((bmq)localObject).FbR = paramInt1;
    AppMethodBeat.o(150091);
  }
  
  public a(String paramString, LinkedList<String> paramLinkedList, int paramInt1, int paramInt2, a<a> parama)
  {
    this(paramString, paramLinkedList, paramInt1, paramInt2);
    this.gfY = parama;
  }
  
  public a(String paramString, LinkedList<String> paramLinkedList, a<a> parama)
  {
    this(paramString, paramLinkedList, 0, -1, parama);
  }
  
  public final bmq afq()
  {
    if (this.rr == null) {
      return null;
    }
    return (bmq)this.rr.hvr.hvw;
  }
  
  public final bmr afr()
  {
    return (bmr)this.rr.hvs.hvw;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(150093);
    ac.i("MicroMsg.webview.NetSceneJSAuthorize", "doScene");
    this.gfX = paramg;
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
    ac.i("MicroMsg.webview.NetSceneJSAuthorize", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gfX != null) {
      this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.gfY != null) {
      this.gfY.a(paramInt2, paramInt3, paramString, this);
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