package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.l;
import com.tencent.mm.modelappbrand.l.a;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer;
import com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetDebugUI;

public final class e
  implements l
{
  boolean hoh;
  
  public final boolean a(String paramString, l.a parama)
  {
    AppMethodBeat.i(10764);
    boolean bool = com.tencent.mm.plugin.appbrand.dynamic.debugger.b.c(paramString, parama);
    AppMethodBeat.o(10764);
    return bool;
  }
  
  public final boolean acq()
  {
    return this.hoh;
  }
  
  public final boolean acr()
  {
    AppMethodBeat.i(10766);
    boolean bool = com.tencent.mm.sdk.a.b.dsf();
    AppMethodBeat.o(10766);
    return bool;
  }
  
  public final boolean b(String paramString, l.a parama)
  {
    AppMethodBeat.i(10765);
    boolean bool = com.tencent.mm.plugin.appbrand.dynamic.debugger.b.d(paramString, parama);
    AppMethodBeat.o(10765);
    return bool;
  }
  
  public final void bY(Context paramContext)
  {
    AppMethodBeat.i(10762);
    com.tencent.mm.plugin.appbrand.wxawidget.console.e.dw(paramContext);
    AppMethodBeat.o(10762);
  }
  
  public final void cL(boolean paramBoolean)
  {
    this.hoh = paramBoolean;
  }
  
  public final void f(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(10761);
    Intent localIntent = new Intent(paramContext, WxaWidgetDebugUI.class);
    String str = WxaWidgetInitializer.bO(paramBundle.getString("app_id"), paramBundle.getString("msg_id"));
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("id", str);
    paramContext.startActivity(localIntent);
    AppMethodBeat.o(10761);
  }
  
  public final boolean kQ(int paramInt)
  {
    AppMethodBeat.i(10763);
    boolean bool = j.a.kQ(paramInt);
    AppMethodBeat.o(10763);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.a.e
 * JD-Core Version:    0.7.0.1
 */