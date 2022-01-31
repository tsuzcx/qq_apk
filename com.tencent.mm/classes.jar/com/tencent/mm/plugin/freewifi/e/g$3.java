package com.tencent.mm.plugin.freewifi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.model.c;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.gm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class g$3
  implements f
{
  g$3(g paramg) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(20815);
    ab.i("MicroMsg.FreeWifi.ProtocolOne", "errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramm = (a)paramm;
      paramString = paramm.bAS();
      ab.i("MicroMsg.FreeWifi.ProtocolOne", "authUrl : %s", new Object[] { paramString });
      paramm = paramm.bAW();
      if (paramm != null)
      {
        ab.i("MicroMsg.FreeWifi.ProtocolOne", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[] { paramm.woB, paramm.jKG, paramm.jJA, Integer.valueOf(paramm.wsQ), paramm.wsR, paramm.gwS });
        g localg = this.mLn;
        j.bAN().bAw().post(new g.4(localg, paramString, paramm));
        AppMethodBeat.o(20815);
        return;
      }
      g.c(this.mLn);
      AppMethodBeat.o(20815);
      return;
    }
    g.c(this.mLn);
    AppMethodBeat.o(20815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.g.3
 * JD-Core Version:    0.7.0.1
 */