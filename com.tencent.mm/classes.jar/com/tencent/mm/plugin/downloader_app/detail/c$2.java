package com.tencent.mm.plugin.downloader_app.detail;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.luggage.d.k;
import com.tencent.luggage.d.n;
import com.tencent.luggage.d.n.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class c$2
  extends n.a
{
  c$2(c paramc) {}
  
  public final void a(n paramn, String paramString) {}
  
  public final void b(n paramn, String paramString)
  {
    AppMethodBeat.i(136045);
    ab.i("MicroMsg.DownloadDetailWebPage", "onUrlLoadingFinished, preload = %b", new Object[] { Boolean.valueOf(this.laj.lag) });
    paramn = this.laj.bzu.getString("rawUrl");
    if (bo.isNullOrNil(paramn))
    {
      AppMethodBeat.o(136045);
      return;
    }
    paramn = Uri.parse(paramn).getQueryParameter("appid");
    this.laj.bzs.a(new c.2.1(this, paramn));
    AppMethodBeat.o(136045);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.c.2
 * JD-Core Version:    0.7.0.1
 */