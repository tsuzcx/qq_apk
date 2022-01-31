package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.soter.a.f.e.b;

public final class c
  extends d
  implements k, com.tencent.soter.a.f.e
{
  private int cIT;
  private f callback;
  private String gJv = null;
  private int mGE;
  private com.tencent.soter.a.f.b<e.b> mGF = null;
  public com.tencent.mm.ai.b rr;
  
  public c(String paramString, int paramInt)
  {
    this.gJv = paramString;
    this.mGE = paramInt;
    this.cIT = paramInt;
  }
  
  public final void a(com.tencent.soter.a.f.b<e.b> paramb)
  {
    this.mGF = paramb;
  }
  
  public final void bzB()
  {
    AppMethodBeat.i(41580);
    ab.i("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "hy: authkey required");
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    if (this.mGF != null)
    {
      ab.e("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "alvinluo pay auth key expired when upload pay auth key");
      this.mGF.cW(new e.b(false));
    }
    AppMethodBeat.o(41580);
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(41579);
    ab.d("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "onGYNetEnd errType: %d , errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    if (this.mGF != null)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.mGF.cW(new e.b(true));
        AppMethodBeat.o(41579);
        return;
      }
      this.mGF.cW(new e.b(false));
    }
    AppMethodBeat.o(41579);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(41578);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(41578);
    return i;
  }
  
  public final void execute()
  {
    AppMethodBeat.i(41582);
    g.Rc().a(this, 0);
    AppMethodBeat.o(41582);
  }
  
  public final int getType()
  {
    return 1665;
  }
  
  public final void wf(int paramInt)
  {
    AppMethodBeat.i(41581);
    ab.i("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "hy: onError: errType: %d, errcode: %d", new Object[] { Integer.valueOf(3), Integer.valueOf(paramInt) });
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    AppMethodBeat.o(41581);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.c.c
 * JD-Core Version:    0.7.0.1
 */