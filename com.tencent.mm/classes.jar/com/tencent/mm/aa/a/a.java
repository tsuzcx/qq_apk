package com.tencent.mm.aa.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ceo;
import com.tencent.mm.protocal.protobuf.cep;
import com.tencent.mm.protocal.protobuf.fdg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class a
  extends q
  implements m
{
  private i heq;
  private a<a> hpd;
  private final d rr;
  
  private a(String paramString, LinkedList<String> paramLinkedList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150091);
    Log.i("MicroMsg.webview.NetSceneJSAuthorize", "NetSceneJSLogin doScene appId [%s], versionType [%d], extScene[%d]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ceo();
    ((d.a)localObject).iLO = new cep();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-authorize";
    ((d.a)localObject).funcId = 1157;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (ceo)this.rr.iLK.iLR;
    if (paramInt2 > 0)
    {
      ((ceo)localObject).Mka = new fdg();
      ((ceo)localObject).Mka.scene = paramInt2;
    }
    ((ceo)localObject).jfi = paramString;
    ((ceo)localObject).MjX = paramLinkedList;
    ((ceo)localObject).MjZ = paramInt1;
    AppMethodBeat.o(150091);
  }
  
  public a(String paramString, LinkedList<String> paramLinkedList, int paramInt1, int paramInt2, a<a> parama)
  {
    this(paramString, paramLinkedList, paramInt1, paramInt2);
    this.hpd = parama;
  }
  
  public a(String paramString, LinkedList<String> paramLinkedList, a<a> parama)
  {
    this(paramString, paramLinkedList, 0, -1, parama);
  }
  
  public final ceo ayH()
  {
    if (this.rr == null) {
      return null;
    }
    return (ceo)this.rr.iLK.iLR;
  }
  
  public final cep ayI()
  {
    return (cep)this.rr.iLL.iLR;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(150093);
    Log.i("MicroMsg.webview.NetSceneJSAuthorize", "doScene");
    this.heq = parami;
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
    if (this.heq != null) {
      this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.hpd != null) {
      this.hpd.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(150092);
  }
  
  public static abstract interface a<T extends q>
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.aa.a.a
 * JD-Core Version:    0.7.0.1
 */