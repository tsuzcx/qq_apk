package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.n;
import com.tencent.mm.modelappbrand.n.a;
import com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel;
import com.tencent.mm.plugin.appbrand.wxawidget.console.d;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;

public class WidgetConsoleUI
  extends MMActivity
  implements n.a
{
  String appId;
  int duK;
  String id;
  ConsolePanel klN;
  int pkgVersion;
  
  private boolean bha()
  {
    AppMethodBeat.i(121487);
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("id");
    this.appId = localIntent.getStringExtra("app_id");
    this.duK = localIntent.getIntExtra("pkg_type", 0);
    this.pkgVersion = localIntent.getIntExtra("pkg_version", 0);
    setMMSubTitle(String.format("(%s)", new Object[] { str }));
    if (bu.isNullOrNil(str))
    {
      AppMethodBeat.o(121487);
      return false;
    }
    if (str.equals(this.id))
    {
      AppMethodBeat.o(121487);
      return true;
    }
    ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aDV().b(this.id, this);
    ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aDV().a(str, this);
    this.id = str;
    d.a(this.klN);
    AppMethodBeat.o(121487);
    return true;
  }
  
  public void finish()
  {
    AppMethodBeat.i(121490);
    if ((isFinishing()) || (activityHasDestroyed()))
    {
      AppMethodBeat.o(121490);
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
      AppMethodBeat.o(121490);
      return;
      super.finish();
    }
  }
  
  public int getLayoutId()
  {
    return 2131496107;
  }
  
  public final void oR(int paramInt)
  {
    AppMethodBeat.i(121488);
    final String str;
    switch (paramInt)
    {
    default: 
      str = "";
    }
    for (;;)
    {
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(121484);
          WidgetConsoleUI.this.setMMTitle(String.format("%s%s", new Object[] { WidgetConsoleUI.this.getString(2131766307), str }));
          Toast.makeText(WidgetConsoleUI.this.getContext(), String.format("%s%s", new Object[] { WidgetConsoleUI.this.id, str }), 1).show();
          AppMethodBeat.o(121484);
        }
      });
      AppMethodBeat.o(121488);
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
    AppMethodBeat.i(121485);
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(121483);
        WidgetConsoleUI.this.finish();
        AppMethodBeat.o(121483);
        return false;
      }
    });
    setMMTitle(2131766307);
    this.klN = ((ConsolePanel)findViewById(2131298582));
    if (!bha())
    {
      finish();
      AppMethodBeat.o(121485);
      return;
    }
    AppMethodBeat.o(121485);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(121489);
    super.onDestroy();
    ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aDV().b(this.id, this);
    d.b(this.klN);
    AppMethodBeat.o(121489);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(121486);
    super.onNewIntent(paramIntent);
    if (!bha())
    {
      finish();
      AppMethodBeat.o(121486);
      return;
    }
    AppMethodBeat.o(121486);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WidgetConsoleUI
 * JD-Core Version:    0.7.0.1
 */