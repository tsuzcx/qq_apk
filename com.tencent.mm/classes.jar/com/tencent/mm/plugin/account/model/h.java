package com.tencent.mm.plugin.account.model;

import android.os.Bundle;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.v;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

public class h
  implements f, g.a
{
  public void l(Bundle paramBundle)
  {
    String str = paramBundle.getString("access_token");
    paramBundle = paramBundle.getString("expires");
    y.i("MicroMsg.RefreshTokenListener", "onComplete : newToken = " + str + ", expires = " + paramBundle);
    if (paramBundle != null) {
      g.DP().Dz().o(65832, paramBundle);
    }
    g.DP().Dz().o(65830, str);
    g.DP().Dz().o(65831, Long.valueOf(System.currentTimeMillis()));
    g.Dk().a(183, this);
    paramBundle = new v(2, str);
    g.Dk().a(paramBundle, 0);
  }
  
  public void onError(int paramInt, String paramString)
  {
    y.e("MicroMsg.RefreshTokenListener", "onError : errType = " + paramInt + ", errMsg = " + paramString);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (paramm.getType() != 183) {
      return;
    }
    g.Dk().b(183, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      y.i("MicroMsg.RefreshTokenListener", "update token success");
      return;
    }
    y.e("MicroMsg.RefreshTokenListener", "update token fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.h
 * JD-Core Version:    0.7.0.1
 */