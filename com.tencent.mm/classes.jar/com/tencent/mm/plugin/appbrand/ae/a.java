package com.tencent.mm.plugin.appbrand.ae;

import android.content.Context;
import android.net.Uri;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/video/AppBrandThumbMediaPlayer;", "Lcom/tencent/mm/plugin/appbrand/video/player/thumb/ThumbMediaPlayer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "setDataSource", "", "path", "", "referrer", "setDataSourceAsync", "onDataSourceSetListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer$OnDataSourceSetListener;", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends com.tencent.mm.plugin.appbrand.ae.a.a.a
{
  public static final a.a rjS;
  
  static
  {
    AppMethodBeat.i(282325);
    rjS = new a.a((byte)0);
    AppMethodBeat.o(282325);
  }
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(282323);
    AppMethodBeat.o(282323);
  }
  
  public final void a(final String paramString1, final String paramString2, final e.c paramc)
  {
    AppMethodBeat.i(282322);
    g localg = g.pzQ;
    if (g.bWm())
    {
      h.ZvG.be((Runnable)new b(this, paramString1, paramString2, paramc));
      AppMethodBeat.o(282322);
      return;
    }
    super.a(paramString1, paramString2, paramc);
    AppMethodBeat.o(282322);
  }
  
  public final void ef(String paramString1, String paramString2)
  {
    AppMethodBeat.i(282321);
    p.k(paramString1, "path");
    g localg = g.pzQ;
    int i = g.a((f)e.K(f.class), Uri.parse(paramString1));
    Log.i("MicroMsg.AppBrandThumbMediaPlayer", "setDataSource, path: " + paramString1 + ", type: " + i);
    if (2 == i)
    {
      m(paramString1, paramString2, false);
      AppMethodBeat.o(282321);
      return;
    }
    super.m(paramString1, paramString2, true);
    AppMethodBeat.o(282321);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama, String paramString1, String paramString2, e.c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(279340);
      a.a(this.rjT, paramString1, paramString2, paramc);
      AppMethodBeat.o(279340);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ae.a
 * JD-Core Version:    0.7.0.1
 */