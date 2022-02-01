package com.tencent.mm.ac.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cnm;
import com.tencent.mm.protocal.protobuf.cnn;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class c
  extends q
  implements m
{
  private i jQg;
  private a<c> kaW;
  private final d rr;
  
  private c(String paramString1, LinkedList<String> paramLinkedList, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(150097);
    Log.i("MicroMsg.webview.NetSceneJSLogin", "NetSceneJSLogin doScene appId [%s], loginType [%d], url [%s], state [%s], versionType [%d], extScene [%d]", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, paramString3, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new cnm();
    ((d.a)localObject).lBV = new cnn();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-login";
    ((d.a)localObject).funcId = 1029;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (cnm)d.b.b(this.rr.lBR);
    ((cnm)localObject).lVG = paramString1;
    ((cnm)localObject).TuN = paramLinkedList;
    ((cnm)localObject).Tva = paramInt1;
    ((cnm)localObject).Url = paramString2;
    ((cnm)localObject).Tvb = paramString3;
    ((cnm)localObject).TuP = paramInt2;
    if (paramInt3 > 0)
    {
      ((cnm)localObject).TuQ = new foh();
      ((cnm)localObject).TuQ.scene = paramInt3;
    }
    AppMethodBeat.o(150097);
  }
  
  public c(String paramString1, LinkedList<String> paramLinkedList, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, a<c> parama)
  {
    this(paramString1, paramLinkedList, paramInt1, paramString2, paramString3, paramInt2, paramInt3);
    this.kaW = parama;
  }
  
  public c(String paramString1, LinkedList<String> paramLinkedList, String paramString2, String paramString3, a<c> parama)
  {
    this(paramString1, paramLinkedList, 0, paramString2, paramString3, 0, -1, parama);
  }
  
  public final cnm aGe()
  {
    AppMethodBeat.i(235720);
    if (this.rr == null)
    {
      AppMethodBeat.o(235720);
      return null;
    }
    cnm localcnm = (cnm)d.b.b(this.rr.lBR);
    AppMethodBeat.o(235720);
    return localcnm;
  }
  
  public final cnn aGf()
  {
    AppMethodBeat.i(235722);
    cnn localcnn = (cnn)d.c.b(this.rr.lBS);
    AppMethodBeat.o(235722);
    return localcnn;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(150099);
    Log.i("MicroMsg.webview.NetSceneJSLogin", "doScene");
    this.jQg = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(150099);
    return i;
  }
  
  public final int getType()
  {
    return 1029;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150098);
    Log.i("MicroMsg.webview.NetSceneJSLogin", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.jQg != null) {
      this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.kaW != null) {
      this.kaW.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(150098);
  }
  
  public static abstract interface a<T extends q>
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ac.a.c
 * JD-Core Version:    0.7.0.1
 */