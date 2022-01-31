package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.n;

public final class OpenBusinessViewUtil$2
  extends e.c
{
  public OpenBusinessViewUtil$2(String paramString) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(143404);
    n.yd(this.val$appId).gRe = null;
    e.b(this.val$appId, this);
    AppMethodBeat.o(143404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil.2
 * JD-Core Version:    0.7.0.1
 */