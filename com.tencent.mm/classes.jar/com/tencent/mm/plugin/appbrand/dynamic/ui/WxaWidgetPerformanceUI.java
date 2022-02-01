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
import com.tencent.mm.ipcinvoker.b;
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
  MMSwitchBtn joh;
  MMSwitchBtn joi;
  MMSwitchBtn joj;
  
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
        Object localObject = c.Fz("jsapi_draw_canvas").toString();
        paramAnonymousView = new StringBuilder();
        if ((localObject != null) && (((String)localObject).length() > 0))
        {
          int i = c.cp("jsapi_draw_canvas", "__invoke_jsapi_data_size");
          paramAnonymousView.append("data size :").append(i).append("\n").append((String)localObject);
        }
        localObject = (IPCString)h.a("com.tencent.mm:support", new IPCString("widget_launch"), WxaWidgetPerformanceUI.e.class);
        if (localObject != null) {
          paramAnonymousView.append("\n\n").append(localObject);
        }
        if (f.aTf()) {
          paramAnonymousView.append("\n\n").append(f.aTg());
        }
        this.jol.setText(paramAnonymousView.toString());
        AppMethodBeat.o(121499);
      }
    });
    findViewById(2131298348).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121500);
        h.a("com.tencent.mm:support", null, WxaWidgetPerformanceUI.a.class, null);
        c.clear();
        f.reset();
        this.jol.setText(c.Fz("jsapi_draw_canvas").toString());
        AppMethodBeat.o(121500);
      }
    });
    localObject = (MMSwitchBtn)findViewById(2131303021);
    boolean bool = c.aTe();
    ((MMSwitchBtn)localObject).setCheck(bool);
    ((MMSwitchBtn)localObject).setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121501);
        h.a("com.tencent.mm:support", new IPCBoolean(paramAnonymousBoolean), WxaWidgetPerformanceUI.d.class, null);
        c.fx(paramAnonymousBoolean);
        paramBundle.setEnabled(paramAnonymousBoolean);
        WxaWidgetPerformanceUI.this.joh.setEnabled(paramAnonymousBoolean);
        WxaWidgetPerformanceUI.this.joi.setEnabled(paramAnonymousBoolean);
        WxaWidgetPerformanceUI.this.joj.setEnabled(paramAnonymousBoolean);
        AppMethodBeat.o(121501);
      }
    });
    paramBundle.setEnabled(bool);
    this.joh = ((MMSwitchBtn)findViewById(2131298446));
    this.joh.setEnabled(bool);
    this.joh.setCheck(c.FC("jsapi_draw_canvas"));
    this.joh.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121502);
        h.a("com.tencent.mm:support", new IPCBoolean(paramAnonymousBoolean), WxaWidgetPerformanceUI.b.class, null);
        if (paramAnonymousBoolean)
        {
          c.FA("jsapi_draw_canvas");
          AppMethodBeat.o(121502);
          return;
        }
        c.FB("jsapi_draw_canvas");
        AppMethodBeat.o(121502);
      }
    });
    this.joi = ((MMSwitchBtn)findViewById(2131298492));
    this.joi.setEnabled(bool);
    this.joi.setCheck(c.FC("widget_launch"));
    this.joi.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121503);
        h.a("com.tencent.mm:support", new IPCBoolean(paramAnonymousBoolean), WxaWidgetPerformanceUI.c.class, null);
        if (paramAnonymousBoolean)
        {
          c.FA("widget_launch");
          AppMethodBeat.o(121503);
          return;
        }
        c.FB("widget_launch");
        AppMethodBeat.o(121503);
      }
    });
    this.joj = ((MMSwitchBtn)findViewById(2131298491));
    this.joj.setEnabled(bool);
    this.joj.setCheck(f.aTf());
    this.joj.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121504);
        f.fy(paramAnonymousBoolean);
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
    implements b<IPCVoid, IPCVoid>
  {}
  
  static class b
    implements b<IPCBoolean, IPCVoid>
  {}
  
  static class c
    implements b<IPCBoolean, IPCVoid>
  {}
  
  static class d
    implements b<IPCBoolean, IPCVoid>
  {}
  
  static class e
    implements k<IPCString, IPCString>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI
 * JD-Core Version:    0.7.0.1
 */