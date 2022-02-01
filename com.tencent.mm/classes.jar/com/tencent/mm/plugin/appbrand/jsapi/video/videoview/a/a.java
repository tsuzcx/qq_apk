package com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoTextureView;

public final class a
  extends AbstractVideoTextureView
{
  public a(Context paramContext)
  {
    super(paramContext);
  }
  
  public final b beg()
  {
    AppMethodBeat.i(194322);
    c localc = new c(new Handler(Looper.getMainLooper()));
    AppMethodBeat.o(194322);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.a
 * JD-Core Version:    0.7.0.1
 */