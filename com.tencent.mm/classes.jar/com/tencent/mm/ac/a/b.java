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
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cnh;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class b
  extends q
  implements m
{
  private i jQg;
  private a<b> kaV;
  private final d rr;
  
  private b(String paramString, LinkedList<String> paramLinkedList, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(150094);
    Log.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "NetSceneJSLogin doScene appId [%s], versionType [%d], opt [%d], extScene [%d]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new cng();
    ((d.a)localObject).lBV = new cnh();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
    ((d.a)localObject).funcId = 1158;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (cng)d.b.b(this.rr.lBR);
    if (paramInt3 > 0)
    {
      ((cng)localObject).TuQ = new foh();
      ((cng)localObject).TuQ.scene = paramInt3;
    }
    ((cng)localObject).lVG = paramString;
    ((cng)localObject).TuN = paramLinkedList;
    ((cng)localObject).TuP = paramInt1;
    ((cng)localObject).TuO = paramInt2;
    AppMethodBeat.o(150094);
  }
  
  public b(String paramString, LinkedList<String> paramLinkedList, int paramInt1, int paramInt2, int paramInt3, a<b> parama)
  {
    this(paramString, paramLinkedList, paramInt1, paramInt2, paramInt3);
    this.kaV = parama;
  }
  
  public b(String paramString, LinkedList<String> paramLinkedList, int paramInt, a<b> parama)
  {
    this(paramString, paramLinkedList, 0, paramInt, -1, parama);
  }
  
  public final cng aGc()
  {
    AppMethodBeat.i(225489);
    if (this.rr == null)
    {
      AppMethodBeat.o(225489);
      return null;
    }
    cng localcng = (cng)d.b.b(this.rr.lBR);
    AppMethodBeat.o(225489);
    return localcng;
  }
  
  public final cnh aGd()
  {
    AppMethodBeat.i(225490);
    cnh localcnh = (cnh)d.c.b(this.rr.lBS);
    AppMethodBeat.o(225490);
    return localcnh;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(150096);
    Log.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "doScene");
    this.jQg = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(150096);
    return i;
  }
  
  public final int getType()
  {
    return 1158;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150095);
    Log.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.jQg != null) {
      this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.kaV != null) {
      this.kaV.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(150095);
  }
  
  public static abstract interface a<T extends q>
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ac.a.b
 * JD-Core Version:    0.7.0.1
 */