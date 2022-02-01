package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.soter.a.f.e.b;

public final class c
  extends d
  implements k, com.tencent.soter.a.f.e
{
  private com.tencent.mm.al.g callback;
  private int dzK;
  private String ixc = null;
  private int rcN;
  private com.tencent.soter.a.f.b<e.b> rcO = null;
  public com.tencent.mm.al.b rr;
  
  public c(String paramString, int paramInt)
  {
    this.ixc = paramString;
    this.rcN = paramInt;
    this.dzK = paramInt;
  }
  
  public final void Dr(int paramInt)
  {
    AppMethodBeat.i(64466);
    ad.i("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "hy: onError: errType: %d, errcode: %d", new Object[] { Integer.valueOf(3), Integer.valueOf(paramInt) });
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    AppMethodBeat.o(64466);
  }
  
  public final void a(com.tencent.soter.a.f.b<e.b> paramb)
  {
    this.rcO = paramb;
  }
  
  public final void cuA()
  {
    AppMethodBeat.i(64465);
    ad.i("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "hy: authkey required");
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    if (this.rcO != null)
    {
      ad.e("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "alvinluo pay auth key expired when upload pay auth key");
      this.rcO.eq(new e.b(false));
    }
    AppMethodBeat.o(64465);
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, com.tencent.mm.network.q paramq)
  {
    AppMethodBeat.i(64464);
    ad.d("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "onGYNetEnd errType: %d , errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    com.tencent.mm.plugin.soter.d.m.yaO = paramString;
    if (this.rcO != null)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.rcO.eq(new e.b(true));
        AppMethodBeat.o(64464);
        return;
      }
      this.rcO.eq(new e.b(false));
    }
    AppMethodBeat.o(64464);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(64463);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(64463);
    return i;
  }
  
  public final void execute()
  {
    AppMethodBeat.i(64467);
    com.tencent.mm.kernel.g.aeS().a(this, 0);
    AppMethodBeat.o(64467);
  }
  
  public final int getType()
  {
    return 1665;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.c.c
 * JD-Core Version:    0.7.0.1
 */