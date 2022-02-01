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
import com.tencent.mm.protocal.protobuf.cem;
import com.tencent.mm.protocal.protobuf.cen;
import com.tencent.mm.protocal.protobuf.fdg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class b
  extends q
  implements m
{
  private i heq;
  private a<b> hpe;
  private final d rr;
  
  private b(String paramString, LinkedList<String> paramLinkedList, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(150094);
    Log.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "NetSceneJSLogin doScene appId [%s], versionType [%d], opt [%d], extScene [%d]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new cem();
    ((d.a)localObject).iLO = new cen();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
    ((d.a)localObject).funcId = 1158;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (cem)this.rr.iLK.iLR;
    if (paramInt3 > 0)
    {
      ((cem)localObject).Mka = new fdg();
      ((cem)localObject).Mka.scene = paramInt3;
    }
    ((cem)localObject).jfi = paramString;
    ((cem)localObject).MjX = paramLinkedList;
    ((cem)localObject).MjZ = paramInt1;
    ((cem)localObject).MjY = paramInt2;
    AppMethodBeat.o(150094);
  }
  
  public b(String paramString, LinkedList<String> paramLinkedList, int paramInt1, int paramInt2, int paramInt3, a<b> parama)
  {
    this(paramString, paramLinkedList, paramInt1, paramInt2, paramInt3);
    this.hpe = parama;
  }
  
  public b(String paramString, LinkedList<String> paramLinkedList, int paramInt, a<b> parama)
  {
    this(paramString, paramLinkedList, 0, paramInt, -1, parama);
  }
  
  public final cem ayJ()
  {
    if (this.rr == null) {
      return null;
    }
    return (cem)this.rr.iLK.iLR;
  }
  
  public final cen ayK()
  {
    return (cen)this.rr.iLL.iLR;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(150096);
    Log.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "doScene");
    this.heq = parami;
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
    if (this.heq != null) {
      this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.hpe != null) {
      this.hpe.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(150095);
  }
  
  public static abstract interface a<T extends q>
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.aa.a.b
 * JD-Core Version:    0.7.0.1
 */