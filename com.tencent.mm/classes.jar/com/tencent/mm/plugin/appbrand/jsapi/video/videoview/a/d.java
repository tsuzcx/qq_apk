package com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoTextureView;

public final class d
  extends AbstractVideoTextureView
{
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  public final e bXb()
  {
    AppMethodBeat.i(227079);
    g localg = new g(new Handler(Looper.getMainLooper()));
    AppMethodBeat.o(227079);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.d
 * JD-Core Version:    0.7.0.1
 */