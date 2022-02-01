package com.tencent.luggage.xweb_ext.extendplugin.component.video.a.a;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMFileSlotManager;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;

public final class a
  implements f
{
  MMFileSlotManager cJX;
  
  public a()
  {
    AppMethodBeat.i(177186);
    this.cJX = new MMFileSlotManager("bizplaylist", 86400L);
    AppMethodBeat.o(177186);
  }
  
  public final o dU(String paramString)
  {
    AppMethodBeat.i(177187);
    if (!Util.isNullOrNil(paramString))
    {
      String str = Uri.parse(paramString).getLastPathSegment();
      if (!Util.isNullOrNil(str))
      {
        o localo = (o)this.cJX.findSlot(str);
        if (localo != null)
        {
          Log.i("PlaylistFileInterceptor", "intercept success, contentId:%s, url:%s", new Object[] { str, paramString });
          paramString = new o(String.format("%s/%s", new Object[] { aa.z(localo.mUri), str }));
          AppMethodBeat.o(177187);
          return paramString;
        }
      }
    }
    AppMethodBeat.o(177187);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.a.a.a
 * JD-Core Version:    0.7.0.1
 */