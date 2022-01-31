package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity.a;

final class b$1
  implements MMActivity.a
{
  b$1(b paramb, c paramc, int paramInt) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    b localb = null;
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramInt1 == 1000)
    {
      if (paramInt2 == -1)
      {
        y.i("MicroMsg.JsApiStartSoterAuthentication", "hy: soter auth ok");
        localb = this.glt;
        localObject2 = this.ggH;
        paramInt1 = this.dIS;
        if (paramIntent != null) {
          localObject1 = paramIntent.getExtras();
        }
        b.a(localb, (c)localObject2, paramInt1, (Bundle)localObject1, "ok");
      }
    }
    else {
      return;
    }
    if (paramInt2 == 1)
    {
      y.w("MicroMsg.JsApiStartSoterAuthentication", "hy: soter auth failed");
      localObject2 = this.glt;
      localc = this.ggH;
      paramInt1 = this.dIS;
      localObject1 = localb;
      if (paramIntent != null) {
        localObject1 = paramIntent.getExtras();
      }
      b.a((b)localObject2, localc, paramInt1, (Bundle)localObject1, "fail");
      return;
    }
    y.e("MicroMsg.JsApiStartSoterAuthentication", "hy: soter user cancelled");
    localb = this.glt;
    c localc = this.ggH;
    paramInt1 = this.dIS;
    localObject1 = localObject2;
    if (paramIntent != null) {
      localObject1 = paramIntent.getExtras();
    }
    b.a(localb, localc, paramInt1, (Bundle)localObject1, "cancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.b.1
 * JD-Core Version:    0.7.0.1
 */