package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public final class bu
  extends a<h>
{
  public static final int CTRL_INDEX = 406;
  public static final String NAME = "private_openUrl";
  
  private void a(h paramh, int paramInt, String paramString)
  {
    AppMethodBeat.i(45617);
    ac.e("MicroMsg.JsApiPrivateOpenUrl", "switchCallback msg:%s", new Object[] { paramString });
    if (paramh != null) {
      paramh.h(paramInt, e(paramString, null));
    }
    AppMethodBeat.o(45617);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bu
 * JD-Core Version:    0.7.0.1
 */