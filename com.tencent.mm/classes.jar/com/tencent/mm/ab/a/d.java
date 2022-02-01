package com.tencent.mm.ab.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bja;
import com.tencent.mm.protocal.protobuf.bjb;
import com.tencent.mm.protocal.protobuf.dvc;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class d
  extends n
  implements k
{
  private g gbr;
  private a<d> gbv;
  private final b rr;
  
  private d(String paramString1, LinkedList<String> paramLinkedList, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(150100);
    ad.i("MicroMsg.webview.NetSceneJSLoginConfirm", "NetSceneJSLogin doScene appId [%s], login_type [%d], state [%s], versionType [%d], opt [%d], extScene [%d]", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new bja();
    ((b.a)localObject).gUV = new bjb();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-login-confirm";
    ((b.a)localObject).funcId = 1117;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (bja)this.rr.gUS.gUX;
    if (paramInt4 > 0)
    {
      ((bja)localObject).DGy = new dvc();
      ((bja)localObject).DGy.scene = paramInt4;
    }
    ((bja)localObject).hnC = paramString1;
    ((bja)localObject).DGv = paramLinkedList;
    ((bja)localObject).DGF = paramInt1;
    ((bja)localObject).DGG = paramString2;
    ((bja)localObject).DGx = paramInt2;
    ((bja)localObject).DGw = paramInt3;
    AppMethodBeat.o(150100);
  }
  
  public d(String paramString1, LinkedList<String> paramLinkedList, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, a<d> parama)
  {
    this(paramString1, paramLinkedList, paramInt1, paramString2, paramInt2, paramInt3, paramInt4);
    this.gbv = parama;
  }
  
  public d(String paramString1, LinkedList<String> paramLinkedList, String paramString2, int paramInt, a<d> parama)
  {
    this(paramString1, paramLinkedList, 0, paramString2, 0, paramInt, -1, parama);
  }
  
  public final bja aeg()
  {
    if (this.rr == null) {
      return null;
    }
    return (bja)this.rr.gUS.gUX;
  }
  
  public final bjb aeh()
  {
    return (bjb)this.rr.gUT.gUX;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(150102);
    ad.i("MicroMsg.webview.NetSceneJSLoginConfirm", "doScene");
    this.gbr = paramg;
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
    ad.i("MicroMsg.webview.NetSceneJSLoginConfirm", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gbr != null) {
      this.gbr.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.gbv != null) {
      this.gbv.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(150101);
  }
  
  public static abstract interface a<T extends n>
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ab.a.d
 * JD-Core Version:    0.7.0.1
 */