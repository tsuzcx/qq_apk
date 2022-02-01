package com.tencent.luggage.xweb_ext.extendplugin.component.video.a.a;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;

public final class a
  implements f
{
  ao cvu;
  
  public a()
  {
    AppMethodBeat.i(177186);
    this.cvu = new ao("bizplaylist", 86400L);
    AppMethodBeat.o(177186);
  }
  
  public final e dy(String paramString)
  {
    AppMethodBeat.i(177187);
    if (!bt.isNullOrNil(paramString))
    {
      String str = Uri.parse(paramString).getLastPathSegment();
      if (!bt.isNullOrNil(str))
      {
        e locale = (e)this.cvu.aQb(str);
        if (locale != null)
        {
          ad.i("PlaylistFileInterceptor", "intercept success, contentId:%s, url:%s", new Object[] { str, paramString });
          paramString = new e(String.format("%s/%s", new Object[] { q.B(locale.mUri), str }));
          AppMethodBeat.o(177187);
          return paramString;
        }
      }
    }
    AppMethodBeat.o(177187);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.a.a.a
 * JD-Core Version:    0.7.0.1
 */