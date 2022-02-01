package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.ae;

public class bx
  extends a<h>
{
  public static final int CTRL_INDEX = 406;
  public static final String NAME = "private_openUrl";
  
  private void a(h paramh, int paramInt, String paramString)
  {
    AppMethodBeat.i(45617);
    ae.e("MicroMsg.JsApiPrivateOpenUrl", "switchCallback msg:%s", new Object[] { paramString });
    if (paramh != null) {
      paramh.h(paramInt, e(paramString, null));
    }
    AppMethodBeat.o(45617);
  }
  
  protected void a(Context paramContext, Intent paramIntent, h paramh, int paramInt)
  {
    AppMethodBeat.i(222399);
    if (paramContext != null)
    {
      d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramIntent);
      a(paramh, paramInt, "ok");
      AppMethodBeat.o(222399);
      return;
    }
    a(paramh, paramInt, "fail");
    AppMethodBeat.o(222399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bx
 * JD-Core Version:    0.7.0.1
 */