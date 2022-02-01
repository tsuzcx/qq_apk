package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.model.cf;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bhg;
import com.tencent.mm.protocal.protobuf.bhh;
import com.tencent.mm.sdk.platformtools.ad;

public final class aa
  extends n
  implements k
{
  private f callback;
  private bhh hQP;
  private a<aa> hQQ;
  private final b rr;
  
  public aa()
  {
    AppMethodBeat.i(207191);
    ad.i("MicroMsg.NetSceneGetReceiptAssisPluginMenu", "NetSceneGetReceiptAssisPluginMenu begin");
    b.a locala = new b.a();
    locala.funcId = 1769;
    locala.uri = "/cgi-bin/mmpay-bin/getreceiptassismenu";
    bhg localbhg = new bhg();
    localbhg.timestamp = cf.aCL();
    locala.hNM = localbhg;
    locala.hNN = new bhh();
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    AppMethodBeat.o(207191);
  }
  
  public aa(a<aa> parama)
  {
    this();
    this.hQQ = parama;
  }
  
  public final bhh aFT()
  {
    AppMethodBeat.i(207194);
    if (this.hQP == null)
    {
      localbhh = new bhh();
      AppMethodBeat.o(207194);
      return localbhh;
    }
    bhh localbhh = this.hQP;
    AppMethodBeat.o(207194);
    return localbhh;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(207192);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(207192);
    return i;
  }
  
  public final int getType()
  {
    return 1769;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(207193);
    ad.w("MicroMsg.NetSceneGetReceiptAssisPluginMenu", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.hQP = ((bhh)((b)paramq).hNL.hNQ);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.hQQ != null) {
      this.hQQ.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(207193);
  }
  
  public static abstract interface a<T extends n>
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.aa
 * JD-Core Version:    0.7.0.1
 */