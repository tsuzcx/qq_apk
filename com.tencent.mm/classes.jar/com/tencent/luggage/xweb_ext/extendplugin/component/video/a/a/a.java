package com.tencent.luggage.xweb_ext.extendplugin.component.video.a.a;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMFileSlotManager;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;

public final class a
  implements f
{
  MMFileSlotManager cKA;
  
  public a()
  {
    AppMethodBeat.i(177186);
    this.cKA = new MMFileSlotManager("bizplaylist", 86400L);
    AppMethodBeat.o(177186);
  }
  
  public final q ev(String paramString)
  {
    AppMethodBeat.i(177187);
    if (!Util.isNullOrNil(paramString))
    {
      String str = Uri.parse(paramString).getLastPathSegment();
      if (!Util.isNullOrNil(str))
      {
        q localq = (q)this.cKA.findSlot(str);
        if (localq != null)
        {
          Log.i("PlaylistFileInterceptor", "intercept success, contentId:%s, url:%s", new Object[] { str, paramString });
          paramString = new q(String.format("%s/%s", new Object[] { localq.getPath(), str }));
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