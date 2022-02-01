package com.tencent.luggage.xweb_ext.extendplugin.component.video.a.a;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMFileSlotManager;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;

public final class a
  implements f
{
  MMFileSlotManager eEl;
  
  public a()
  {
    AppMethodBeat.i(177186);
    this.eEl = new MMFileSlotManager("bizplaylist", 86400L);
    AppMethodBeat.o(177186);
  }
  
  public final u fS(String paramString)
  {
    AppMethodBeat.i(177187);
    if (!Util.isNullOrNil(paramString))
    {
      String str = Uri.parse(paramString).getLastPathSegment();
      if (!Util.isNullOrNil(str))
      {
        u localu = (u)this.eEl.findSlot(str);
        if (localu != null)
        {
          Log.i("PlaylistFileInterceptor", "intercept success, contentId:%s, url:%s", new Object[] { str, paramString });
          paramString = new u(String.format("%s/%s", new Object[] { ah.v(localu.mUri), str }));
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