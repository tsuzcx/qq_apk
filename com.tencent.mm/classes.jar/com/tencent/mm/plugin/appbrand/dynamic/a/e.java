package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.n;
import com.tencent.mm.modelappbrand.n.a;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer;
import com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetDebugUI;

public final class e
  implements n
{
  boolean kfN;
  
  public final boolean a(String paramString, n.a parama)
  {
    AppMethodBeat.i(121246);
    boolean bool = com.tencent.mm.plugin.appbrand.dynamic.debugger.b.c(paramString, parama);
    AppMethodBeat.o(121246);
    return bool;
  }
  
  public final boolean aDL()
  {
    return this.kfN;
  }
  
  public final boolean aDM()
  {
    AppMethodBeat.i(121248);
    boolean bool = com.tencent.mm.sdk.a.b.fjN();
    AppMethodBeat.o(121248);
    return bool;
  }
  
  public final boolean b(String paramString, n.a parama)
  {
    AppMethodBeat.i(121247);
    boolean bool = com.tencent.mm.plugin.appbrand.dynamic.debugger.b.d(paramString, parama);
    AppMethodBeat.o(121247);
    return bool;
  }
  
  public final void cx(Context paramContext)
  {
    AppMethodBeat.i(121244);
    com.tencent.mm.plugin.appbrand.wxawidget.console.e.eg(paramContext);
    AppMethodBeat.o(121244);
  }
  
  public final void d(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(121243);
    Intent localIntent = new Intent(paramContext, WxaWidgetDebugUI.class);
    String str = WxaWidgetInitializer.cJ(paramBundle.getString("app_id"), paramBundle.getString("msg_id"));
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("id", str);
    paramBundle = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramBundle.ahp(), "com/tencent/mm/plugin/appbrand/dynamic/api/WxaWidgetDebugger", "openDebugUI", "(Landroid/content/Context;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramBundle.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/appbrand/dynamic/api/WxaWidgetDebugger", "openDebugUI", "(Landroid/content/Context;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(121243);
  }
  
  public final void eA(boolean paramBoolean)
  {
    this.kfN = paramBoolean;
  }
  
  public final boolean oN(int paramInt)
  {
    AppMethodBeat.i(121245);
    boolean bool = j.a.oN(paramInt);
    AppMethodBeat.o(121245);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.a.e
 * JD-Core Version:    0.7.0.1
 */