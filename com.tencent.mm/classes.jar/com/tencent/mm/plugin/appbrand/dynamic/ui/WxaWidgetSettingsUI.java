package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.appcache.d.a;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.b;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import com.tencent.mm.plugin.appbrand.wxawidget.b.c;
import com.tencent.mm.plugin.appbrand.wxawidget.b.e;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class WxaWidgetSettingsUI
  extends MMActivity
{
  String appId;
  int bOa;
  
  protected final int getLayoutId()
  {
    return b.c.wxa_widget_settings_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool2 = false;
    super.onCreate(paramBundle);
    setBackBtn(new WxaWidgetSettingsUI.1(this));
    setMMTitle(b.e.wxa_widget_settings);
    this.appId = getIntent().getStringExtra("app_id");
    this.bOa = getIntent().getIntExtra("pkg_type", 0);
    MMSwitchBtn localMMSwitchBtn = (MMSwitchBtn)findViewById(b.b.open_ban_btn);
    paramBundle = b.te(this.appId);
    if ((paramBundle != null) && (paramBundle.fUX)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      localMMSwitchBtn.setCheck(bool1);
      localMMSwitchBtn.setSwitchListener(new WxaWidgetSettingsUI.2(this));
      localMMSwitchBtn = (MMSwitchBtn)findViewById(b.b.inject_debug_btn);
      if ((paramBundle == null) || (!paramBundle.fUV))
      {
        bool1 = bool2;
        if (!d.a.id(this.bOa)) {}
      }
      else
      {
        bool1 = true;
      }
      localMMSwitchBtn.setCheck(bool1);
      localMMSwitchBtn.setEnabled(d.a.kq(this.bOa));
      localMMSwitchBtn.setSwitchListener(new WxaWidgetSettingsUI.3(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetSettingsUI
 * JD-Core Version:    0.7.0.1
 */