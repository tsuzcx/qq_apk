package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class WxaWidgetSettingsUI
  extends MMActivity
{
  String appId;
  int dib;
  
  public int getLayoutId()
  {
    return 2131496125;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool2 = false;
    AppMethodBeat.i(121515);
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(121512);
        WxaWidgetSettingsUI.this.finish();
        AppMethodBeat.o(121512);
        return false;
      }
    });
    setMMTitle(2131766328);
    this.appId = getIntent().getStringExtra("app_id");
    this.dib = getIntent().getIntExtra("pkg_type", 0);
    MMSwitchBtn localMMSwitchBtn = (MMSwitchBtn)findViewById(2131303018);
    paramBundle = b.Li(this.appId);
    if ((paramBundle != null) && (paramBundle.jLU)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      localMMSwitchBtn.setCheck(bool1);
      localMMSwitchBtn.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(121513);
          DebuggerInfo localDebuggerInfo2 = b.Li(WxaWidgetSettingsUI.this.appId);
          DebuggerInfo localDebuggerInfo1 = localDebuggerInfo2;
          if (localDebuggerInfo2 == null)
          {
            localDebuggerInfo1 = new DebuggerInfo();
            b.a(WxaWidgetSettingsUI.this.appId, localDebuggerInfo1);
          }
          localDebuggerInfo1.jLU = paramAnonymousBoolean;
          AppMethodBeat.o(121513);
        }
      });
      localMMSwitchBtn = (MMSwitchBtn)findViewById(2131301019);
      if ((paramBundle == null) || (!paramBundle.jLS))
      {
        bool1 = bool2;
        if (!j.a.on(this.dib)) {}
      }
      else
      {
        bool1 = true;
      }
      localMMSwitchBtn.setCheck(bool1);
      localMMSwitchBtn.setEnabled(j.a.rq(this.dib));
      localMMSwitchBtn.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(121514);
          DebuggerInfo localDebuggerInfo2 = b.Li(WxaWidgetSettingsUI.this.appId);
          DebuggerInfo localDebuggerInfo1 = localDebuggerInfo2;
          if (localDebuggerInfo2 == null)
          {
            localDebuggerInfo1 = new DebuggerInfo();
            b.a(WxaWidgetSettingsUI.this.appId, localDebuggerInfo1);
          }
          localDebuggerInfo1.jLS = paramAnonymousBoolean;
          AppMethodBeat.o(121514);
        }
      });
      AppMethodBeat.o(121515);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetSettingsUI
 * JD-Core Version:    0.7.0.1
 */