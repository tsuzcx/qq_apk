package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.sdk.platformtools.ad;

public class bx
  extends a<h>
{
  public static final int CTRL_INDEX = 406;
  public static final String NAME = "private_openUrl";
  
  private void a(h paramh, int paramInt, String paramString)
  {
    AppMethodBeat.i(45617);
    ad.e("MicroMsg.JsApiPrivateOpenUrl", "switchCallback msg:%s", new Object[] { paramString });
    if (paramh != null) {
      paramh.h(paramInt, e(paramString, null));
    }
    AppMethodBeat.o(45617);
  }
  
  protected void a(Context paramContext, Intent paramIntent, h paramh, int paramInt)
  {
    AppMethodBeat.i(188273);
    if (paramContext != null)
    {
      d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramIntent);
      a(paramh, paramInt, "ok");
      AppMethodBeat.o(188273);
      return;
    }
    a(paramh, paramInt, "fail");
    AppMethodBeat.o(188273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bx
 * JD-Core Version:    0.7.0.1
 */