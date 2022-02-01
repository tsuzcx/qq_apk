package com.tencent.mm.plugin.account.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;

public class l
  implements i, k.a
{
  public void E(Bundle paramBundle)
  {
    AppMethodBeat.i(127848);
    String str = paramBundle.getString("access_token");
    paramBundle = paramBundle.getString("expires");
    Log.i("MicroMsg.RefreshTokenListener", "onComplete : newToken = " + str + ", expires = " + paramBundle);
    if (paramBundle != null) {
      g.aAh().azQ().set(65832, paramBundle);
    }
    g.aAh().azQ().set(65830, str);
    g.aAh().azQ().set(65831, Long.valueOf(System.currentTimeMillis()));
    g.azz().a(183, this);
    paramBundle = new w(2, str);
    g.azz().a(paramBundle, 0);
    AppMethodBeat.o(127848);
  }
  
  public void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(127849);
    Log.e("MicroMsg.RefreshTokenListener", "onError : errType = " + paramInt + ", errMsg = " + paramString);
    AppMethodBeat.o(127849);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(127850);
    if (paramq.getType() != 183)
    {
      AppMethodBeat.o(127850);
      return;
    }
    g.azz().b(183, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.l
 * JD-Core Version:    0.7.0.1
 */