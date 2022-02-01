package com.tencent.luggage.k.a.a.b.a.a;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;

public final class a
  implements f
{
  an ckS;
  
  public a()
  {
    AppMethodBeat.i(177186);
    this.ckS = new an("bizplaylist", 86400L);
    AppMethodBeat.o(177186);
  }
  
  public final e cw(String paramString)
  {
    AppMethodBeat.i(177187);
    if (!bs.isNullOrNil(paramString))
    {
      String str = Uri.parse(paramString).getLastPathSegment();
      if (!bs.isNullOrNil(str))
      {
        e locale = (e)this.ckS.aKv(str);
        if (locale != null)
        {
          ac.i("PlaylistFileInterceptor", "intercept success, contentId:%s, url:%s", new Object[] { str, paramString });
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
 * Qualified Name:     com.tencent.luggage.k.a.a.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */