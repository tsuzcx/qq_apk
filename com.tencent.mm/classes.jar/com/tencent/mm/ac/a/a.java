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
import com.tencent.mm.protocal.protobuf.cni;
import com.tencent.mm.protocal.protobuf.cnj;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class a
  extends q
  implements m
{
  private i jQg;
  private a<a> kaU;
  private final d rr;
  
  private a(String paramString, LinkedList<String> paramLinkedList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150091);
    Log.i("MicroMsg.webview.NetSceneJSAuthorize", "NetSceneJSLogin doScene appId [%s], versionType [%d], extScene[%d]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new cni();
    ((d.a)localObject).lBV = new cnj();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-authorize";
    ((d.a)localObject).funcId = 1157;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (cni)d.b.b(this.rr.lBR);
    if (paramInt2 > 0)
    {
      ((cni)localObject).TuQ = new foh();
      ((cni)localObject).TuQ.scene = paramInt2;
    }
    ((cni)localObject).lVG = paramString;
    ((cni)localObject).TuN = paramLinkedList;
    ((cni)localObject).TuP = paramInt1;
    AppMethodBeat.o(150091);
  }
  
  public a(String paramString, LinkedList<String> paramLinkedList, int paramInt1, int paramInt2, a<a> parama)
  {
    this(paramString, paramLinkedList, paramInt1, paramInt2);
    this.kaU = parama;
  }
  
  public a(String paramString, LinkedList<String> paramLinkedList, a<a> parama)
  {
    this(paramString, paramLinkedList, 0, -1, parama);
  }
  
  public final cni aGa()
  {
    AppMethodBeat.i(192984);
    if (this.rr == null)
    {
      AppMethodBeat.o(192984);
      return null;
    }
    cni localcni = (cni)d.b.b(this.rr.lBR);
    AppMethodBeat.o(192984);
    return localcni;
  }
  
  public final cnj aGb()
  {
    AppMethodBeat.i(192987);
    cnj localcnj = (cnj)d.c.b(this.rr.lBS);
    AppMethodBeat.o(192987);
    return localcnj;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(150093);
    Log.i("MicroMsg.webview.NetSceneJSAuthorize", "doScene");
    this.jQg = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(150093);
    return i;
  }
  
  public final int getType()
  {
    return 1157;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150092);
    Log.i("MicroMsg.webview.NetSceneJSAuthorize", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.jQg != null) {
      this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.kaU != null) {
      this.kaU.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(150092);
  }
  
  public static abstract interface a<T extends q>
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ac.a.a
 * JD-Core Version:    0.7.0.1
 */