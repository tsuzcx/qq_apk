package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.soter.a.f.b;
import com.tencent.soter.a.f.e;
import com.tencent.soter.a.f.e.b;

public final class c
  extends com.tencent.mm.plugin.soter.b.d
  implements e
{
  private int Bzf;
  private b<e.b> Bzg = null;
  private i callback;
  private int fWQ;
  private String njf = null;
  public com.tencent.mm.an.d rr;
  
  public c(String paramString, int paramInt)
  {
    this.njf = paramString;
    this.Bzf = paramInt;
    this.fWQ = paramInt;
  }
  
  public final void Sl(int paramInt)
  {
    AppMethodBeat.i(64466);
    Log.i("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "hy: onError: errType: %d, errcode: %d", new Object[] { Integer.valueOf(3), Integer.valueOf(paramInt) });
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    AppMethodBeat.o(64466);
  }
  
  public final void a(b<e.b> paramb)
  {
    this.Bzg = paramb;
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(64464);
    Log.d("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "onGYNetEnd errType: %d , errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    com.tencent.mm.plugin.soter.d.m.LwI = paramString;
    if (this.Bzg != null)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.Bzg.eH(new e.b(true));
        AppMethodBeat.o(64464);
        return;
      }
      this.Bzg.eH(new e.b(false));
    }
    AppMethodBeat.o(64464);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(64463);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(64463);
    return i;
  }
  
  public final void epa()
  {
    AppMethodBeat.i(64465);
    Log.i("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "hy: authkey required");
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    if (this.Bzg != null)
    {
      Log.e("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "alvinluo pay auth key expired when upload pay auth key");
      this.Bzg.eH(new e.b(false));
    }
    AppMethodBeat.o(64465);
  }
  
  public final void execute()
  {
    AppMethodBeat.i(64467);
    h.aGY().a(this, 0);
    AppMethodBeat.o(64467);
  }
  
  public final int getType()
  {
    return 1665;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.c.c
 * JD-Core Version:    0.7.0.1
 */