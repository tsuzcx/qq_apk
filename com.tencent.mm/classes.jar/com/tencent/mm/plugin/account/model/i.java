package com.tencent.mm.plugin.account.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;

public class i
  implements f, h.a
{
  public void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(124696);
    ab.e("MicroMsg.RefreshTokenListener", "onError : errType = " + paramInt + ", errMsg = " + paramString);
    AppMethodBeat.o(124696);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(124697);
    if (paramm.getType() != 183)
    {
      AppMethodBeat.o(124697);
      return;
    }
    g.Rc().b(183, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ab.i("MicroMsg.RefreshTokenListener", "update token success");
      AppMethodBeat.o(124697);
      return;
    }
    ab.e("MicroMsg.RefreshTokenListener", "update token fail");
    AppMethodBeat.o(124697);
  }
  
  public void u(Bundle paramBundle)
  {
    AppMethodBeat.i(124695);
    String str = paramBundle.getString("access_token");
    paramBundle = paramBundle.getString("expires");
    ab.i("MicroMsg.RefreshTokenListener", "onComplete : newToken = " + str + ", expires = " + paramBundle);
    if (paramBundle != null) {
      g.RL().Ru().set(65832, paramBundle);
    }
    g.RL().Ru().set(65830, str);
    g.RL().Ru().set(65831, Long.valueOf(System.currentTimeMillis()));
    g.Rc().a(183, this);
    paramBundle = new v(2, str);
    g.Rc().a(paramBundle, 0);
    AppMethodBeat.o(124695);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.i
 * JD-Core Version:    0.7.0.1
 */