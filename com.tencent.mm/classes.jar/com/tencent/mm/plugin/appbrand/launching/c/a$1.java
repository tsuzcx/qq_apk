package com.tencent.mm.plugin.appbrand.launching.c;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;

final class a$1
  implements h.a
{
  a$1(a parama, String paramString1, String paramString2, Context paramContext, String paramString3, Uri paramUri, int paramInt, Bundle paramBundle1, Bundle paramBundle2) {}
  
  public final void bNY()
  {
    AppMethodBeat.i(47402);
    Log.i("MicroMsg.AppBrand.AbsLinkOpener", "[banjump] should ban, from appid:%s, to username:%s", new Object[] { this.kFU, this.gtu });
    new MMHandler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47401);
        Toast.makeText(MMApplicationContext.getContext(), 2131755389, 1).show();
        AppMethodBeat.o(47401);
      }
    });
    AppMethodBeat.o(47402);
  }
  
  public final void bNZ()
  {
    AppMethodBeat.i(47403);
    Log.i("MicroMsg.AppBrand.AbsLinkOpener", "[banjump] not ban, from appid:%s, to username:%s", new Object[] { this.kFU, this.gtu });
    a.a(this.val$context, this.val$url, this.val$uri, this.gsA, this.mYf, this.gtu, this.mYg);
    AppMethodBeat.o(47403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.c.a.1
 * JD-Core Version:    0.7.0.1
 */