package com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoTextureView;

public final class d
  extends AbstractVideoTextureView
{
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  public final c bLb()
  {
    AppMethodBeat.i(235190);
    f localf = new f(new Handler(Looper.getMainLooper()));
    AppMethodBeat.o(235190);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.d
 * JD-Core Version:    0.7.0.1
 */