package com.tencent.luggage.sdk.customize.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.aj;
import com.tencent.mm.protocal.protobuf.fcw;
import com.tencent.mm.sdk.platformtools.Log;

public final class FullSdkExternalToolsHelper
  implements aj
{
  public final void a(Context paramContext, String paramString1, String paramString2, fcw paramfcw)
  {
    AppMethodBeat.i(220394);
    Log.d("Luggage.FullSdkExternalToolsHelper", "open webview activity url: %s", new Object[] { paramString1 });
    paramString2 = new Intent(paramContext, FullSdkExternalToolsHelper.SimpleWebViewActivity.class);
    paramString2.putExtra("_url_", paramString1);
    if (!(paramContext instanceof Activity)) {
      paramString2.addFlags(268435456);
    }
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().cG(paramString2);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString1.aYi(), "com/tencent/luggage/sdk/customize/impl/FullSdkExternalToolsHelper", "openWebViewActivity", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/SimpleWebViewLaunchParams;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString1.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/luggage/sdk/customize/impl/FullSdkExternalToolsHelper", "openWebViewActivity", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/SimpleWebViewLaunchParams;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(220394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.customize.impl.FullSdkExternalToolsHelper
 * JD-Core Version:    0.7.0.1
 */