package com.tencent.mm.plugin.account.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.w;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;

public class k
  implements f, j.a
{
  public void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(127849);
    ae.e("MicroMsg.RefreshTokenListener", "onError : errType = " + paramInt + ", errMsg = " + paramString);
    AppMethodBeat.o(127849);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(127850);
    if (paramn.getType() != 183)
    {
      AppMethodBeat.o(127850);
      return;
    }
    g.ajj().b(183, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ae.i("MicroMsg.RefreshTokenListener", "update token success");
      AppMethodBeat.o(127850);
      return;
    }
    ae.e("MicroMsg.RefreshTokenListener", "update token fail");
    AppMethodBeat.o(127850);
  }
  
  public void y(Bundle paramBundle)
  {
    AppMethodBeat.i(127848);
    String str = paramBundle.getString("access_token");
    paramBundle = paramBundle.getString("expires");
    ae.i("MicroMsg.RefreshTokenListener", "onComplete : newToken = " + str + ", expires = " + paramBundle);
    if (paramBundle != null) {
      g.ajR().ajA().set(65832, paramBundle);
    }
    g.ajR().ajA().set(65830, str);
    g.ajR().ajA().set(65831, Long.valueOf(System.currentTimeMillis()));
    g.ajj().a(183, this);
    paramBundle = new w(2, str);
    g.ajj().a(paramBundle, 0);
    AppMethodBeat.o(127848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.k
 * JD-Core Version:    0.7.0.1
 */