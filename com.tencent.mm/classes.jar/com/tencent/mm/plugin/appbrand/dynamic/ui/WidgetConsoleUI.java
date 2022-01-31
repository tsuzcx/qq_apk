package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mm.cg.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.l;
import com.tencent.mm.modelappbrand.l.a;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import com.tencent.mm.plugin.appbrand.wxawidget.b.c;
import com.tencent.mm.plugin.appbrand.wxawidget.b.e;
import com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel;
import com.tencent.mm.plugin.appbrand.wxawidget.console.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;

public class WidgetConsoleUI
  extends MMActivity
  implements l.a
{
  String appId;
  int bOa;
  int fEN;
  ConsolePanel fXr;
  String id;
  
  private boolean afF()
  {
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("id");
    this.appId = localIntent.getStringExtra("app_id");
    this.bOa = localIntent.getIntExtra("pkg_type", 0);
    this.fEN = localIntent.getIntExtra("pkg_version", 0);
    setMMSubTitle(String.format("(%s)", new Object[] { str }));
    if (bk.bl(str)) {
      return false;
    }
    if (str.equals(this.id)) {
      return true;
    }
    ((e)g.r(e.class)).Jn().b(this.id, this);
    ((e)g.r(e.class)).Jn().a(str, this);
    this.id = str;
    d.a(this.fXr);
    return true;
  }
  
  public void finish()
  {
    if ((isFinishing()) || (this.uMr)) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 21) {
      finishAndRemoveTask();
    }
    for (;;)
    {
      TypedArray localTypedArray = obtainStyledAttributes(16973825, new int[] { 16842938, 16842939 });
      int i = localTypedArray.getResourceId(0, 0);
      int j = localTypedArray.getResourceId(1, 0);
      localTypedArray.recycle();
      overridePendingTransition(i, j);
      return;
      super.finish();
    }
  }
  
  protected final int getLayoutId()
  {
    return b.c.widget_console_ui;
  }
  
  public final void ie(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "";
    }
    for (;;)
    {
      a.m(new WidgetConsoleUI.2(this, str));
      return;
      str = "(PAUSE)";
      continue;
      str = "(RESUME)";
      continue;
      str = "(START)";
      continue;
      str = "(STOP)";
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setBackBtn(new WidgetConsoleUI.1(this));
    setMMTitle(b.e.wxa_widget_console);
    this.fXr = ((ConsolePanel)findViewById(b.b.console_widget));
    if (!afF()) {
      finish();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    ((e)g.r(e.class)).Jn().b(this.id, this);
    d.b(this.fXr);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (!afF()) {
      finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WidgetConsoleUI
 * JD-Core Version:    0.7.0.1
 */