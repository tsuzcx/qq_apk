package com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoTextureView;

public final class d
  extends AbstractVideoTextureView
{
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  public final g cxm()
  {
    AppMethodBeat.i(328908);
    j localj = new j(new Handler(Looper.getMainLooper()));
    AppMethodBeat.o(328908);
    return localj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.d
 * JD-Core Version:    0.7.0.1
 */