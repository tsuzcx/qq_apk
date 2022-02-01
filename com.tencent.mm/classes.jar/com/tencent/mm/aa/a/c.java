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
import com.tencent.mm.protocal.protobuf.ces;
import com.tencent.mm.protocal.protobuf.cet;
import com.tencent.mm.protocal.protobuf.fdg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class c
  extends q
  implements m
{
  private i heq;
  private c.a<c> hpf;
  private final d rr;
  
  private c(String paramString1, LinkedList<String> paramLinkedList, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(150097);
    Log.i("MicroMsg.webview.NetSceneJSLogin", "NetSceneJSLogin doScene appId [%s], loginType [%d], url [%s], state [%s], versionType [%d], extScene [%d]", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, paramString3, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ces();
    ((d.a)localObject).iLO = new cet();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-login";
    ((d.a)localObject).funcId = 1029;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (ces)this.rr.iLK.iLR;
    ((ces)localObject).jfi = paramString1;
    ((ces)localObject).MjX = paramLinkedList;
    ((ces)localObject).Mkk = paramInt1;
    ((ces)localObject).Url = paramString2;
    ((ces)localObject).Mkl = paramString3;
    ((ces)localObject).MjZ = paramInt2;
    if (paramInt3 > 0)
    {
      ((ces)localObject).Mka = new fdg();
      ((ces)localObject).Mka.scene = paramInt3;
    }
    AppMethodBeat.o(150097);
  }
  
  public c(String paramString1, LinkedList<String> paramLinkedList, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, c.a<c> parama)
  {
    this(paramString1, paramLinkedList, paramInt1, paramString2, paramString3, paramInt2, paramInt3);
    this.hpf = parama;
  }
  
  public c(String paramString1, LinkedList<String> paramLinkedList, String paramString2, String paramString3, c.a<c> parama)
  {
    this(paramString1, paramLinkedList, 0, paramString2, paramString3, 0, -1, parama);
  }
  
  public final ces ayL()
  {
    if (this.rr == null) {
      return null;
    }
    return (ces)this.rr.iLK.iLR;
  }
  
  public final cet ayM()
  {
    return (cet)this.rr.iLL.iLR;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(150099);
    Log.i("MicroMsg.webview.NetSceneJSLogin", "doScene");
    this.heq = parami;
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
    if (this.heq != null) {
      this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.hpf != null) {
      this.hpf.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(150098);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.aa.a.c
 * JD-Core Version:    0.7.0.1
 */