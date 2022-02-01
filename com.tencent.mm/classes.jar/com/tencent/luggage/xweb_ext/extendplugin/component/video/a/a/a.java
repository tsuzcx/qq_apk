package com.tencent.luggage.xweb_ext.extendplugin.component.video.a.a;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;

public final class a
  implements f
{
  ap cvY;
  
  public a()
  {
    AppMethodBeat.i(177186);
    this.cvY = new ap("bizplaylist", 86400L);
    AppMethodBeat.o(177186);
  }
  
  public final k dB(String paramString)
  {
    AppMethodBeat.i(177187);
    if (!bu.isNullOrNil(paramString))
    {
      String str = Uri.parse(paramString).getLastPathSegment();
      if (!bu.isNullOrNil(str))
      {
        k localk = (k)this.cvY.aRy(str);
        if (localk != null)
        {
          ae.i("PlaylistFileInterceptor", "intercept success, contentId:%s, url:%s", new Object[] { str, paramString });
          paramString = new k(String.format("%s/%s", new Object[] { w.B(localk.mUri), str }));
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