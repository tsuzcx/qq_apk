package com.tencent.mm.plugin.appbrand.launching.b;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class a$1
  implements h.a
{
  a$1(a parama, String paramString1, String paramString2, Context paramContext, String paramString3, Uri paramUri, int paramInt, Bundle paramBundle) {}
  
  public final void alU()
  {
    y.i("MicroMsg.AppBrand.AbsLinkOpener", "[banjump] should ban, from appid:%s, to username:%s", new Object[] { this.gge, this.dol });
    new ah(Looper.getMainLooper()).post(new a.1.1(this));
  }
  
  public final void alV()
  {
    y.i("MicroMsg.AppBrand.AbsLinkOpener", "[banjump] not ban, from appid:%s, to username:%s", new Object[] { this.gge, this.dol });
    a.a(this.val$context, this.val$url, this.gLS, this.egz, this.gLT, this.dol);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.b.a.1
 * JD-Core Version:    0.7.0.1
 */