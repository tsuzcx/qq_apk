package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.l;
import com.tencent.mm.modelappbrand.l.a;
import com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel;
import com.tencent.mm.plugin.appbrand.wxawidget.console.d;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public class WidgetConsoleUI
  extends MMActivity
  implements l.a
{
  String appId;
  int cvs;
  int gXf;
  ConsolePanel hqR;
  String id;
  
  private boolean aAj()
  {
    AppMethodBeat.i(11006);
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("id");
    this.appId = localIntent.getStringExtra("app_id");
    this.cvs = localIntent.getIntExtra("pkg_type", 0);
    this.gXf = localIntent.getIntExtra("pkg_version", 0);
    setMMSubTitle(String.format("(%s)", new Object[] { str }));
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(11006);
      return false;
    }
    if (str.equals(this.id))
    {
      AppMethodBeat.o(11006);
      return true;
    }
    ((e)g.E(e.class)).acl().b(this.id, this);
    ((e)g.E(e.class)).acl().a(str, this);
    this.id = str;
    d.a(this.hqR);
    AppMethodBeat.o(11006);
    return true;
  }
  
  public void finish()
  {
    AppMethodBeat.i(11009);
    if ((isFinishing()) || (activityHasDestroyed()))
    {
      AppMethodBeat.o(11009);
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
      AppMethodBeat.o(11009);
      return;
      super.finish();
    }
  }
  
  public int getLayoutId()
  {
    return 2130971324;
  }
  
  public final void kR(int paramInt)
  {
    AppMethodBeat.i(11007);
    String str;
    switch (paramInt)
    {
    default: 
      str = "";
    }
    for (;;)
    {
      al.d(new WidgetConsoleUI.2(this, str));
      AppMethodBeat.o(11007);
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
    AppMethodBeat.i(11004);
    super.onCreate(paramBundle);
    setBackBtn(new WidgetConsoleUI.1(this));
    setMMTitle(2131306259);
    this.hqR = ((ConsolePanel)findViewById(2131829591));
    if (!aAj())
    {
      finish();
      AppMethodBeat.o(11004);
      return;
    }
    AppMethodBeat.o(11004);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(11008);
    super.onDestroy();
    ((e)g.E(e.class)).acl().b(this.id, this);
    d.b(this.hqR);
    AppMethodBeat.o(11008);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(11005);
    super.onNewIntent(paramIntent);
    if (!aAj())
    {
      finish();
      AppMethodBeat.o(11005);
      return;
    }
    AppMethodBeat.o(11005);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WidgetConsoleUI
 * JD-Core Version:    0.7.0.1
 */