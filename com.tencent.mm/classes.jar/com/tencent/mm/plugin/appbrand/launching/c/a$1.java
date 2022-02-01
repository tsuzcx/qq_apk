package com.tencent.mm.plugin.appbrand.launching.c;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;

final class a$1
  implements h.a
{
  a$1(a parama, String paramString1, String paramString2, Context paramContext, String paramString3, Uri paramUri, int paramInt, Bundle paramBundle) {}
  
  public final void bhe()
  {
    AppMethodBeat.i(47402);
    ad.i("MicroMsg.AppBrand.AbsLinkOpener", "[banjump] should ban, from appid:%s, to username:%s", new Object[] { this.iHZ, this.fqK });
    new ap(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47401);
        Toast.makeText(aj.getContext(), 2131755352, 1).show();
        AppMethodBeat.o(47401);
      }
    });
    AppMethodBeat.o(47402);
  }
  
  public final void bhf()
  {
    AppMethodBeat.i(47403);
    ad.i("MicroMsg.AppBrand.AbsLinkOpener", "[banjump] not ban, from appid:%s, to username:%s", new Object[] { this.iHZ, this.fqK });
    a.a(this.val$context, this.val$url, this.kNE, this.fpl, this.kNF, this.fqK);
    AppMethodBeat.o(47403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.c.a.1
 * JD-Core Version:    0.7.0.1
 */