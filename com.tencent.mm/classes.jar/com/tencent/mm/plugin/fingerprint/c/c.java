package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.soter.a.f.e.b;

public final class c
  extends d
  implements k, com.tencent.soter.a.f.e
{
  private com.tencent.mm.ak.g callback;
  private int dxw;
  private String iXf = null;
  public com.tencent.mm.ak.b rr;
  private int slh;
  private com.tencent.soter.a.f.b<e.b> sli = null;
  
  public c(String paramString, int paramInt)
  {
    this.iXf = paramString;
    this.slh = paramInt;
    this.dxw = paramInt;
  }
  
  public final void Fn(int paramInt)
  {
    AppMethodBeat.i(64466);
    ac.i("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "hy: onError: errType: %d, errcode: %d", new Object[] { Integer.valueOf(3), Integer.valueOf(paramInt) });
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    AppMethodBeat.o(64466);
  }
  
  public final void a(com.tencent.soter.a.f.b<e.b> paramb)
  {
    this.sli = paramb;
  }
  
  public final void cHM()
  {
    AppMethodBeat.i(64465);
    ac.i("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "hy: authkey required");
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    if (this.sli != null)
    {
      ac.e("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "alvinluo pay auth key expired when upload pay auth key");
      this.sli.er(new e.b(false));
    }
    AppMethodBeat.o(64465);
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, com.tencent.mm.network.q paramq)
  {
    AppMethodBeat.i(64464);
    ac.d("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "onGYNetEnd errType: %d , errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    com.tencent.mm.plugin.soter.d.m.znO = paramString;
    if (this.sli != null)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.sli.er(new e.b(true));
        AppMethodBeat.o(64464);
        return;
      }
      this.sli.er(new e.b(false));
    }
    AppMethodBeat.o(64464);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
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
    com.tencent.mm.kernel.g.agi().a(this, 0);
    AppMethodBeat.o(64467);
  }
  
  public final int getType()
  {
    return 1665;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.c.c
 * JD-Core Version:    0.7.0.1
 */