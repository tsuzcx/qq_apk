package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class ck
  extends c<j>
{
  public static final int CTRL_INDEX = 406;
  public static final String NAME = "private_openUrl";
  
  private void a(j paramj, int paramInt, String paramString)
  {
    AppMethodBeat.i(45617);
    Log.e("MicroMsg.JsApiPrivateOpenUrl", "switchCallback msg:%s", new Object[] { paramString });
    if (paramj != null) {
      paramj.j(paramInt, h(paramString, null));
    }
    AppMethodBeat.o(45617);
  }
  
  protected void a(Context paramContext, Intent paramIntent, j paramj, int paramInt)
  {
    AppMethodBeat.i(244362);
    if (paramContext != null)
    {
      com.tencent.mm.by.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramIntent);
      a(paramj, paramInt, "ok");
      AppMethodBeat.o(244362);
      return;
    }
    a(paramj, paramInt, "fail");
    AppMethodBeat.o(244362);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ck
 * JD-Core Version:    0.7.0.1
 */