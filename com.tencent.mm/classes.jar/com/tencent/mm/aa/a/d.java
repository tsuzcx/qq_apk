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
import com.tencent.mm.protocal.protobuf.bms;
import com.tencent.mm.protocal.protobuf.bmt;
import com.tencent.mm.protocal.protobuf.eat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class d
  extends n
  implements k
{
  private g gfX;
  private a<d> ggb;
  private final b rr;
  
  private d(String paramString1, LinkedList<String> paramLinkedList, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(150100);
    ac.i("MicroMsg.webview.NetSceneJSLoginConfirm", "NetSceneJSLogin doScene appId [%s], login_type [%d], state [%s], versionType [%d], opt [%d], extScene [%d]", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bms();
    ((b.a)localObject).hvu = new bmt();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-login-confirm";
    ((b.a)localObject).funcId = 1117;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (bms)this.rr.hvr.hvw;
    if (paramInt4 > 0)
    {
      ((bms)localObject).FbS = new eat();
      ((bms)localObject).FbS.scene = paramInt4;
    }
    ((bms)localObject).hOf = paramString1;
    ((bms)localObject).FbP = paramLinkedList;
    ((bms)localObject).FbZ = paramInt1;
    ((bms)localObject).Fca = paramString2;
    ((bms)localObject).FbR = paramInt2;
    ((bms)localObject).FbQ = paramInt3;
    AppMethodBeat.o(150100);
  }
  
  public d(String paramString1, LinkedList<String> paramLinkedList, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, a<d> parama)
  {
    this(paramString1, paramLinkedList, paramInt1, paramString2, paramInt2, paramInt3, paramInt4);
    this.ggb = parama;
  }
  
  public d(String paramString1, LinkedList<String> paramLinkedList, String paramString2, int paramInt, a<d> parama)
  {
    this(paramString1, paramLinkedList, 0, paramString2, 0, paramInt, -1, parama);
  }
  
  public final bms afw()
  {
    if (this.rr == null) {
      return null;
    }
    return (bms)this.rr.hvr.hvw;
  }
  
  public final bmt afx()
  {
    return (bmt)this.rr.hvs.hvw;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(150102);
    ac.i("MicroMsg.webview.NetSceneJSLoginConfirm", "doScene");
    this.gfX = paramg;
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
    ac.i("MicroMsg.webview.NetSceneJSLoginConfirm", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gfX != null) {
      this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.ggb != null) {
      this.ggb.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(150101);
  }
  
  public static abstract interface a<T extends n>
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.aa.a.d
 * JD-Core Version:    0.7.0.1
 */