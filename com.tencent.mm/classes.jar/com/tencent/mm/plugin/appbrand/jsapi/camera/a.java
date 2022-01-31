package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class a
{
  boolean hIk;
  boolean hIl;
  HashMap<Integer, e> hIm;
  
  private a()
  {
    AppMethodBeat.i(126239);
    this.hIk = true;
    this.hIl = true;
    this.hIm = new HashMap();
    AppMethodBeat.o(126239);
  }
  
  public final boolean aCx()
  {
    AppMethodBeat.i(126240);
    if (!this.hIk) {
      ab.i("MicroMsg.AppBrandCameraMrg", "no camera permission");
    }
    boolean bool = this.hIk;
    AppMethodBeat.o(126240);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.a
 * JD-Core Version:    0.7.0.1
 */