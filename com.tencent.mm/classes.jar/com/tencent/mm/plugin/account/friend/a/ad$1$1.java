package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;

final class ad$1$1
  implements f
{
  ad$1$1(ad.1 param1) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(108454);
    ab.d("MicroMsg.NetSceneGetSuggestAlias", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.gyf.gye.callback.onSceneEnd(paramInt1, paramInt2, "", this.gyf.gye);
      AppMethodBeat.o(108454);
      return;
    }
    this.gyf.gye.doScene(this.gyf.gye.dispatcher(), this.gyf.gye.callback);
    AppMethodBeat.o(108454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ad.1.1
 * JD-Core Version:    0.7.0.1
 */