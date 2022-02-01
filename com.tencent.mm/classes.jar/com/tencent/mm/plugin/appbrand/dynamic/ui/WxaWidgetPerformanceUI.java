package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.collector.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class WxaWidgetPerformanceUI
  extends MMActivity
{
  MMSwitchBtn kiE;
  MMSwitchBtn kiF;
  MMSwitchBtn kiG;
  
  public void finish()
  {
    AppMethodBeat.i(121511);
    if ((isFinishing()) || (activityHasDestroyed()))
    {
      AppMethodBeat.o(121511);
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
      AppMethodBeat.o(121511);
      return;
      super.finish();
    }
  }
  
  public int getLayoutId()
  {
    return 2131496124;
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(121510);
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(121498);
        WxaWidgetPerformanceUI.this.finish();
        AppMethodBeat.o(121498);
        return false;
      }
    });
    setMMTitle(2131766325);
    Object localObject = (TextView)findViewById(2131302536);
    paramBundle = findViewById(2131303925);
    paramBundle.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121499);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/dynamic/ui/WxaWidgetPerformanceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        localObject = c.MW("jsapi_draw_canvas").toString();
        paramAnonymousView = new StringBuilder();
        if ((localObject != null) && (((String)localObject).length() > 0))
        {
          int i = c.cB("jsapi_draw_canvas", "__invoke_jsapi_data_size");
          paramAnonymousView.append("data size :").append(i).append("\n").append((String)localObject);
        }
        localObject = (IPCString)h.a("com.tencent.mm:support", new IPCString("widget_launch"), WxaWidgetPerformanceUI.e.class);
        if (localObject != null) {
          paramAnonymousView.append("\n\n").append(localObject);
        }
        if (f.bdD()) {
          paramAnonymousView.append("\n\n").append(f.bdE());
        }
        this.kiI.setText(paramAnonymousView.toString());
        a.a(this, "com/tencent/mm/plugin/appbrand/dynamic/ui/WxaWidgetPerformanceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(121499);
      }
    });
    findViewById(2131298348).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121500);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/dynamic/ui/WxaWidgetPerformanceUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        h.a("com.tencent.mm:support", null, WxaWidgetPerformanceUI.a.class, null);
        c.clear();
        f.reset();
        this.kiI.setText(c.MW("jsapi_draw_canvas").toString());
        a.a(this, "com/tencent/mm/plugin/appbrand/dynamic/ui/WxaWidgetPerformanceUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(121500);
      }
    });
    localObject = (MMSwitchBtn)findViewById(2131303021);
    boolean bool = c.bdC();
    ((MMSwitchBtn)localObject).setCheck(bool);
    ((MMSwitchBtn)localObject).setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121501);
        h.a("com.tencent.mm:support", new IPCBoolean(paramAnonymousBoolean), WxaWidgetPerformanceUI.d.class, null);
        c.fX(paramAnonymousBoolean);
        paramBundle.setEnabled(paramAnonymousBoolean);
        WxaWidgetPerformanceUI.this.kiE.setEnabled(paramAnonymousBoolean);
        WxaWidgetPerformanceUI.this.kiF.setEnabled(paramAnonymousBoolean);
        WxaWidgetPerformanceUI.this.kiG.setEnabled(paramAnonymousBoolean);
        AppMethodBeat.o(121501);
      }
    });
    paramBundle.setEnabled(bool);
    this.kiE = ((MMSwitchBtn)findViewById(2131298446));
    this.kiE.setEnabled(bool);
    this.kiE.setCheck(c.MZ("jsapi_draw_canvas"));
    this.kiE.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121502);
        h.a("com.tencent.mm:support", new IPCBoolean(paramAnonymousBoolean), WxaWidgetPerformanceUI.b.class, null);
        if (paramAnonymousBoolean)
        {
          c.MX("jsapi_draw_canvas");
          AppMethodBeat.o(121502);
          return;
        }
        c.MY("jsapi_draw_canvas");
        AppMethodBeat.o(121502);
      }
    });
    this.kiF = ((MMSwitchBtn)findViewById(2131298492));
    this.kiF.setEnabled(bool);
    this.kiF.setCheck(c.MZ("widget_launch"));
    this.kiF.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121503);
        h.a("com.tencent.mm:support", new IPCBoolean(paramAnonymousBoolean), WxaWidgetPerformanceUI.c.class, null);
        if (paramAnonymousBoolean)
        {
          c.MX("widget_launch");
          AppMethodBeat.o(121503);
          return;
        }
        c.MY("widget_launch");
        AppMethodBeat.o(121503);
      }
    });
    this.kiG = ((MMSwitchBtn)findViewById(2131298491));
    this.kiG.setEnabled(bool);
    this.kiG.setCheck(f.bdD());
    this.kiG.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121504);
        f.fY(paramAnonymousBoolean);
        AppMethodBeat.o(121504);
      }
    });
    AppMethodBeat.o(121510);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<IPCVoid, IPCVoid>
  {}
  
  static class b
    implements com.tencent.mm.ipcinvoker.b<IPCBoolean, IPCVoid>
  {}
  
  static class c
    implements com.tencent.mm.ipcinvoker.b<IPCBoolean, IPCVoid>
  {}
  
  static class d
    implements com.tencent.mm.ipcinvoker.b<IPCBoolean, IPCVoid>
  {}
  
  static class e
    implements k<IPCString, IPCString>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI
 * JD-Core Version:    0.7.0.1
 */