package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
  int cvs;
  
  public int getLayoutId()
  {
    return 2130971342;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool2 = false;
    AppMethodBeat.i(11033);
    super.onCreate(paramBundle);
    setBackBtn(new WxaWidgetSettingsUI.1(this));
    setMMTitle(2131306068);
    this.appId = getIntent().getStringExtra("app_id");
    this.cvs = getIntent().getIntExtra("pkg_type", 0);
    MMSwitchBtn localMMSwitchBtn = (MMSwitchBtn)findViewById(2131829610);
    paramBundle = b.Bg(this.appId);
    if ((paramBundle != null) && (paramBundle.hoz)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      localMMSwitchBtn.setCheck(bool1);
      localMMSwitchBtn.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(11031);
          DebuggerInfo localDebuggerInfo2 = b.Bg(WxaWidgetSettingsUI.this.appId);
          DebuggerInfo localDebuggerInfo1 = localDebuggerInfo2;
          if (localDebuggerInfo2 == null)
          {
            localDebuggerInfo1 = new DebuggerInfo();
            b.a(WxaWidgetSettingsUI.this.appId, localDebuggerInfo1);
          }
          localDebuggerInfo1.hoz = paramAnonymousBoolean;
          AppMethodBeat.o(11031);
        }
      });
      localMMSwitchBtn = (MMSwitchBtn)findViewById(2131829611);
      if ((paramBundle == null) || (!paramBundle.hox))
      {
        bool1 = bool2;
        if (!j.a.kQ(this.cvs)) {}
      }
      else
      {
        bool1 = true;
      }
      localMMSwitchBtn.setCheck(bool1);
      localMMSwitchBtn.setEnabled(j.a.nk(this.cvs));
      localMMSwitchBtn.setSwitchListener(new WxaWidgetSettingsUI.3(this));
      AppMethodBeat.o(11033);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetSettingsUI
 * JD-Core Version:    0.7.0.1
 */