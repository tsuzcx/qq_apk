package com.tencent.mm.plugin.account.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.account.friend.model.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;

public class k
  implements com.tencent.mm.am.h, j.a
{
  public void T(Bundle paramBundle)
  {
    AppMethodBeat.i(127848);
    String str = paramBundle.getString("access_token");
    paramBundle = paramBundle.getString("expires");
    Log.i("MicroMsg.RefreshTokenListener", "onComplete : newToken = " + str + ", expires = " + paramBundle);
    if (paramBundle != null) {
      com.tencent.mm.kernel.h.baE().ban().B(65832, paramBundle);
    }
    com.tencent.mm.kernel.h.baE().ban().B(65830, str);
    com.tencent.mm.kernel.h.baE().ban().B(65831, Long.valueOf(System.currentTimeMillis()));
    com.tencent.mm.kernel.h.aZW().a(183, this);
    paramBundle = new t(2, str);
    com.tencent.mm.kernel.h.aZW().a(paramBundle, 0);
    AppMethodBeat.o(127848);
  }
  
  public void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(127849);
    Log.e("MicroMsg.RefreshTokenListener", "onError : errType = " + paramInt + ", errMsg = " + paramString);
    AppMethodBeat.o(127849);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(127850);
    if (paramp.getType() != 183)
    {
      AppMethodBeat.o(127850);
      return;
    }
    com.tencent.mm.kernel.h.aZW().b(183, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.i("MicroMsg.RefreshTokenListener", "update token success");
      AppMethodBeat.o(127850);
      return;
    }
    Log.e("MicroMsg.RefreshTokenListener", "update token fail");
    AppMethodBeat.o(127850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.k
 * JD-Core Version:    0.7.0.1
 */