package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.Log;

public class cl
  extends d<k>
{
  public static final int CTRL_INDEX = 406;
  public static final String NAME = "private_openUrl";
  
  private void a(k paramk, int paramInt, String paramString)
  {
    AppMethodBeat.i(45617);
    Log.e("MicroMsg.JsApiPrivateOpenUrl", "switchCallback msg:%s", new Object[] { paramString });
    if (paramk != null) {
      paramk.i(paramInt, h(paramString, null));
    }
    AppMethodBeat.o(45617);
  }
  
  protected void a(Context paramContext, Intent paramIntent, k paramk, int paramInt)
  {
    AppMethodBeat.i(226682);
    if (paramContext != null)
    {
      c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramIntent);
      a(paramk, paramInt, "ok");
      AppMethodBeat.o(226682);
      return;
    }
    a(paramk, paramInt, "fail");
    AppMethodBeat.o(226682);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.cl
 * JD-Core Version:    0.7.0.1
 */