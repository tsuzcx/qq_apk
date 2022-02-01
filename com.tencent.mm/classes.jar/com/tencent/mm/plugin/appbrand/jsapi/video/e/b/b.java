package com.tencent.mm.plugin.appbrand.jsapi.video.e.b;

import android.net.Uri;
import android.os.Handler;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.f;

public final class b
  extends g
{
  public b(Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public final void a(final String paramString1, final String paramString2, final e.c paramc)
  {
    AppMethodBeat.i(230612);
    com.tencent.mm.plugin.appbrand.jsapi.video.e.g localg = com.tencent.mm.plugin.appbrand.jsapi.video.e.g.pzQ;
    if (com.tencent.mm.plugin.appbrand.jsapi.video.e.g.bWm())
    {
      h.ZvG.be(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(228806);
          b.a(b.this, paramString1, paramString2, paramc);
          AppMethodBeat.o(228806);
        }
      });
      AppMethodBeat.o(230612);
      return;
    }
    super.a(paramString1, paramString2, paramc);
    AppMethodBeat.o(230612);
  }
  
  protected final f bWq()
  {
    return a.pBH;
  }
  
  protected final int h(Uri paramUri)
  {
    AppMethodBeat.i(230615);
    com.tencent.mm.plugin.appbrand.jsapi.video.e.g localg = com.tencent.mm.plugin.appbrand.jsapi.video.e.g.pzQ;
    int i = com.tencent.mm.plugin.appbrand.jsapi.video.e.g.a(a.pBH, paramUri);
    AppMethodBeat.o(230615);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.b.b
 * JD-Core Version:    0.7.0.1
 */