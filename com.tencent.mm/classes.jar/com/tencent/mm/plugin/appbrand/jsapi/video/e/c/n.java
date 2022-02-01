package com.tencent.mm.plugin.appbrand.jsapi.video.e.c;

import android.net.Uri;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g.c;
import com.tencent.threadpool.i;

public final class n
  extends j
{
  public n(Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public final void a(final String paramString1, final String paramString2, final g.c paramc)
  {
    AppMethodBeat.i(328695);
    if (com.tencent.mm.plugin.appbrand.jsapi.video.e.f.cwx())
    {
      com.tencent.threadpool.h.ahAA.bm(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(328670);
          n.a(n.this, paramString1, paramString2, paramc);
          AppMethodBeat.o(328670);
        }
      });
      AppMethodBeat.o(328695);
      return;
    }
    super.a(paramString1, paramString2, paramc);
    AppMethodBeat.o(328695);
  }
  
  protected final com.tencent.mm.plugin.appbrand.jsapi.video.f cwO()
  {
    return a.sGW;
  }
  
  protected final int j(Uri paramUri)
  {
    AppMethodBeat.i(328700);
    h localh = h.sFX;
    int i = h.a(a.sGW, paramUri);
    AppMethodBeat.o(328700);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.c.n
 * JD-Core Version:    0.7.0.1
 */