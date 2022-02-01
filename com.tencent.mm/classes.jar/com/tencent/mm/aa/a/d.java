package com.tencent.mm.aa.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ceq;
import com.tencent.mm.protocal.protobuf.cer;
import com.tencent.mm.protocal.protobuf.fdg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class d
  extends q
  implements m
{
  private i heq;
  private a<d> hpg;
  private final com.tencent.mm.ak.d rr;
  
  private d(String paramString1, LinkedList<String> paramLinkedList, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(150100);
    Log.i("MicroMsg.webview.NetSceneJSLoginConfirm", "NetSceneJSLogin doScene appId [%s], login_type [%d], state [%s], versionType [%d], opt [%d], extScene [%d]", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    Object localObject = new com.tencent.mm.ak.d.a();
    ((com.tencent.mm.ak.d.a)localObject).iLN = new ceq();
    ((com.tencent.mm.ak.d.a)localObject).iLO = new cer();
    ((com.tencent.mm.ak.d.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-login-confirm";
    ((com.tencent.mm.ak.d.a)localObject).funcId = 1117;
    ((com.tencent.mm.ak.d.a)localObject).iLP = 0;
    ((com.tencent.mm.ak.d.a)localObject).respCmdId = 0;
    this.rr = ((com.tencent.mm.ak.d.a)localObject).aXF();
    localObject = (ceq)this.rr.iLK.iLR;
    if (paramInt4 > 0)
    {
      ((ceq)localObject).Mka = new fdg();
      ((ceq)localObject).Mka.scene = paramInt4;
    }
    ((ceq)localObject).jfi = paramString1;
    ((ceq)localObject).MjX = paramLinkedList;
    ((ceq)localObject).Mkk = paramInt1;
    ((ceq)localObject).Mkl = paramString2;
    ((ceq)localObject).MjZ = paramInt2;
    ((ceq)localObject).MjY = paramInt3;
    AppMethodBeat.o(150100);
  }
  
  public d(String paramString1, LinkedList<String> paramLinkedList, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, a<d> parama)
  {
    this(paramString1, paramLinkedList, paramInt1, paramString2, paramInt2, paramInt3, paramInt4);
    this.hpg = parama;
  }
  
  public d(String paramString1, LinkedList<String> paramLinkedList, String paramString2, int paramInt, a<d> parama)
  {
    this(paramString1, paramLinkedList, 0, paramString2, 0, paramInt, -1, parama);
  }
  
  public final ceq ayN()
  {
    if (this.rr == null) {
      return null;
    }
    return (ceq)this.rr.iLK.iLR;
  }
  
  public final cer ayO()
  {
    return (cer)this.rr.iLL.iLR;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(150102);
    Log.i("MicroMsg.webview.NetSceneJSLoginConfirm", "doScene");
    this.heq = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(150102);
    return i;
  }
  
  public final int getType()
  {
    return 1117;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150101);
    Log.i("MicroMsg.webview.NetSceneJSLoginConfirm", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.heq != null) {
      this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.hpg != null) {
      this.hpg.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(150101);
  }
  
  public static abstract interface a<T extends q>
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.aa.a.d
 * JD-Core Version:    0.7.0.1
 */