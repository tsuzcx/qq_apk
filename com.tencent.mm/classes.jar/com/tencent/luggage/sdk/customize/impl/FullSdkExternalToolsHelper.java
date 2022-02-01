package com.tencent.luggage.sdk.customize.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.protocal.protobuf.dyq;
import com.tencent.mm.sdk.platformtools.Log;

public final class FullSdkExternalToolsHelper
  implements ag
{
  public final void a(Context paramContext, String paramString, dyq paramdyq)
  {
    AppMethodBeat.i(146713);
    Log.d("Luggage.FullSdkExternalToolsHelper", "open webview activity url: %s", new Object[] { paramString });
    paramdyq = new Intent(paramContext, FullSdkExternalToolsHelper.SimpleWebViewActivity.class);
    paramdyq.putExtra("_url_", paramString);
    if (!(paramContext instanceof Activity)) {
      paramdyq.addFlags(268435456);
    }
    paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramdyq);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.axQ(), "com/tencent/luggage/sdk/customize/impl/FullSdkExternalToolsHelper", "openWebViewActivity", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/SimpleWebViewLaunchParams;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/luggage/sdk/customize/impl/FullSdkExternalToolsHelper", "openWebViewActivity", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/SimpleWebViewLaunchParams;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(146713);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.customize.impl.FullSdkExternalToolsHelper
 * JD-Core Version:    0.7.0.1
 */