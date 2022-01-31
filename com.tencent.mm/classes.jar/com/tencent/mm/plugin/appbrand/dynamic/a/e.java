package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.modelappbrand.l;
import com.tencent.mm.modelappbrand.l.a;
import com.tencent.mm.plugin.appbrand.appcache.d.a;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer;
import com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetDebugUI;

public final class e
  implements l
{
  boolean fUF;
  
  public final boolean Js()
  {
    return this.fUF;
  }
  
  public final boolean Jt()
  {
    return com.tencent.mm.sdk.a.b.cqk();
  }
  
  public final boolean a(String paramString, l.a parama)
  {
    return com.tencent.mm.plugin.appbrand.dynamic.debugger.b.c(paramString, parama);
  }
  
  public final boolean b(String paramString, l.a parama)
  {
    return com.tencent.mm.plugin.appbrand.dynamic.debugger.b.d(paramString, parama);
  }
  
  public final void bJ(boolean paramBoolean)
  {
    this.fUF = paramBoolean;
  }
  
  public final void bu(Context paramContext)
  {
    com.tencent.mm.plugin.appbrand.wxawidget.console.e.cL(paramContext);
  }
  
  public final void d(Context paramContext, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramContext, WxaWidgetDebugUI.class);
    String str = WxaWidgetInitializer.bn(paramBundle.getString("app_id"), paramBundle.getString("msg_id"));
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("id", str);
    paramContext.startActivity(localIntent);
  }
  
  public final boolean id(int paramInt)
  {
    return d.a.id(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.a.e
 * JD-Core Version:    0.7.0.1
 */