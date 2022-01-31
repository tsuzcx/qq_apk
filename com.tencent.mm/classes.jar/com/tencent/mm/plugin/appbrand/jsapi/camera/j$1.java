package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e.c;
import java.util.HashMap;

final class j$1
  extends e.c
{
  j$1(j paramj, com.tencent.mm.plugin.appbrand.jsapi.e parame, e parame1, int paramInt) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(126241);
    this.hEL.b(this.hJf);
    this.hEL.b(this.hJf);
    this.hEL.b(this.hJf);
    a locala = a.a.aCy();
    Integer localInteger = Integer.valueOf(this.hEO);
    if (locala.hIm.containsKey(localInteger)) {
      ((e)locala.hIm.remove(localInteger)).release();
    }
    com.tencent.mm.plugin.appbrand.e.b(this.hEL.getAppId(), this);
    AppMethodBeat.o(126241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.j.1
 * JD-Core Version:    0.7.0.1
 */