package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class bk
  extends a<h>
{
  public static final int CTRL_INDEX = 406;
  public static final String NAME = "private_openUrl";
  
  private void a(h paramh, int paramInt, String paramString)
  {
    AppMethodBeat.i(73170);
    ab.e("MicroMsg.JsApiPrivateOpenUrl", "switchCallback msg:%s", new Object[] { paramString });
    if (paramh != null) {
      paramh.h(paramInt, j(paramString, null));
    }
    AppMethodBeat.o(73170);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bk
 * JD-Core Version:    0.7.0.1
 */