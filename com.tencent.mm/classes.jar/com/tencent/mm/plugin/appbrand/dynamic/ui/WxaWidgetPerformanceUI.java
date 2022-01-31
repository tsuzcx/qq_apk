package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class WxaWidgetPerformanceUI
  extends MMActivity
{
  MMSwitchBtn hqY;
  MMSwitchBtn hqZ;
  MMSwitchBtn hra;
  
  public void finish()
  {
    AppMethodBeat.i(11029);
    if ((isFinishing()) || (activityHasDestroyed()))
    {
      AppMethodBeat.o(11029);
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
      AppMethodBeat.o(11029);
      return;
      super.finish();
    }
  }
  
  public int getLayoutId()
  {
    return 2130971341;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(11028);
    super.onCreate(paramBundle);
    setBackBtn(new WxaWidgetPerformanceUI.1(this));
    setMMTitle(2131306065);
    Object localObject = (TextView)findViewById(2131826716);
    paramBundle = findViewById(2131826715);
    paramBundle.setOnClickListener(new WxaWidgetPerformanceUI.2(this, (TextView)localObject));
    findViewById(2131820991).setOnClickListener(new WxaWidgetPerformanceUI.3(this, (TextView)localObject));
    localObject = (MMSwitchBtn)findViewById(2131826711);
    boolean bool = c.ayk();
    ((MMSwitchBtn)localObject).setCheck(bool);
    ((MMSwitchBtn)localObject).setSwitchListener(new WxaWidgetPerformanceUI.4(this, paramBundle));
    paramBundle.setEnabled(bool);
    this.hqY = ((MMSwitchBtn)findViewById(2131826712));
    this.hqY.setEnabled(bool);
    this.hqY.setCheck(c.zO("jsapi_draw_canvas"));
    this.hqY.setSwitchListener(new WxaWidgetPerformanceUI.5(this));
    this.hqZ = ((MMSwitchBtn)findViewById(2131826713));
    this.hqZ.setEnabled(bool);
    this.hqZ.setCheck(c.zO("widget_launch"));
    this.hqZ.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(11021);
        com.tencent.mm.ipcinvoker.f.a("com.tencent.mm:support", new IPCBoolean(paramAnonymousBoolean), WxaWidgetPerformanceUI.c.class, null);
        if (paramAnonymousBoolean)
        {
          c.zM("widget_launch");
          AppMethodBeat.o(11021);
          return;
        }
        c.zN("widget_launch");
        AppMethodBeat.o(11021);
      }
    });
    this.hra = ((MMSwitchBtn)findViewById(2131826714));
    this.hra.setEnabled(bool);
    this.hra.setCheck(com.tencent.mm.plugin.appbrand.collector.f.ayl());
    this.hra.setSwitchListener(new WxaWidgetPerformanceUI.7(this));
    AppMethodBeat.o(11028);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static class a
    implements a<IPCVoid, IPCVoid>
  {}
  
  static class b
    implements a<IPCBoolean, IPCVoid>
  {}
  
  static class c
    implements a<IPCBoolean, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI
 * JD-Core Version:    0.7.0.1
 */