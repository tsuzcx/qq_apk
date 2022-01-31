package com.tencent.mm.plugin.downloader_app.detail;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.luggage.e.k;
import com.tencent.luggage.e.n;
import com.tencent.luggage.e.n.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class c$3
  extends n.a
{
  c$3(c paramc) {}
  
  public final void a(n paramn, String paramString) {}
  
  public final void b(n paramn, String paramString)
  {
    y.i("MicroMsg.DownloadDetailWebPage", "onUrlLoadingFinished, preload = %b", new Object[] { Boolean.valueOf(this.iRz.iRx) });
    paramn = this.iRz.biV.getString("rawUrl");
    if (bk.bl(paramn)) {
      return;
    }
    paramn = Uri.parse(paramn).getQueryParameter("appid");
    this.iRz.biT.a(new c.3.1(this, paramn));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.c.3
 * JD-Core Version:    0.7.0.1
 */