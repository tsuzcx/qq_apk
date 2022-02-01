package com.tencent.mm.plugin.appbrand.jsapi.video.e.b;

import android.net.Uri;
import android.os.Handler;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.c;

public final class b
  extends f
{
  public b(Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public final void a(final String paramString1, final String paramString2, final c.c paramc)
  {
    AppMethodBeat.i(234965);
    i locali = i.mCD;
    if (i.bKL())
    {
      h.RTc.aX(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(234964);
          b.a(b.this, paramString1, paramString2, paramc);
          AppMethodBeat.o(234964);
        }
      });
      AppMethodBeat.o(234965);
      return;
    }
    super.a(paramString1, paramString2, paramc);
    AppMethodBeat.o(234965);
  }
  
  protected final int q(Uri paramUri)
  {
    AppMethodBeat.i(234966);
    i locali = i.mCD;
    int i = i.r(paramUri);
    AppMethodBeat.o(234966);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.b.b
 * JD-Core Version:    0.7.0.1
 */