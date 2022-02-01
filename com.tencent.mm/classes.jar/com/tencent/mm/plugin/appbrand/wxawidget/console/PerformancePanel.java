package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.collector.f;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class PerformancePanel
  extends FrameLayout
{
  MMSwitchBtn jOt;
  MMSwitchBtn jOu;
  MMSwitchBtn jOv;
  
  public PerformancePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(121670);
    init();
    AppMethodBeat.o(121670);
  }
  
  public PerformancePanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(121671);
    init();
    AppMethodBeat.o(121671);
  }
  
  private void init()
  {
    AppMethodBeat.i(121672);
    LayoutInflater.from(getContext()).inflate(2131495080, this, true);
    Object localObject = (TextView)findViewById(2131302536);
    final View localView = findViewById(2131303925);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121659);
        Object localObject = c.JD("jsapi_draw_canvas").toString();
        paramAnonymousView = new StringBuilder();
        if ((localObject != null) && (((String)localObject).length() > 0))
        {
          int i = c.cz("jsapi_draw_canvas", "__invoke_jsapi_data_size");
          paramAnonymousView.append("data size :").append(i).append("\n").append((String)localObject);
        }
        localObject = (IPCString)h.a("com.tencent.mm:support", new IPCString("widget_launch"), PerformancePanel.e.class);
        if (localObject != null) {
          paramAnonymousView.append("\n\n").append(localObject);
        }
        if (f.bae()) {
          paramAnonymousView.append("\n\n").append(f.baf());
        }
        this.jOx.setText(paramAnonymousView.toString());
        AppMethodBeat.o(121659);
      }
    });
    findViewById(2131298348).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121660);
        h.a("com.tencent.mm:support", null, PerformancePanel.a.class, null);
        c.clear();
        f.reset();
        this.jOx.setText(c.JD("jsapi_draw_canvas").toString());
        AppMethodBeat.o(121660);
      }
    });
    localObject = (MMSwitchBtn)findViewById(2131303021);
    boolean bool = c.bad();
    ((MMSwitchBtn)localObject).setCheck(bool);
    ((MMSwitchBtn)localObject).setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121661);
        h.a("com.tencent.mm:support", new IPCBoolean(paramAnonymousBoolean), PerformancePanel.d.class, null);
        c.fT(paramAnonymousBoolean);
        localView.setEnabled(paramAnonymousBoolean);
        PerformancePanel.this.jOt.setEnabled(paramAnonymousBoolean);
        PerformancePanel.this.jOu.setEnabled(paramAnonymousBoolean);
        PerformancePanel.this.jOv.setEnabled(paramAnonymousBoolean);
        AppMethodBeat.o(121661);
      }
    });
    localView.setEnabled(bool);
    this.jOt = ((MMSwitchBtn)findViewById(2131298446));
    this.jOt.setEnabled(bool);
    this.jOt.setCheck(c.JG("jsapi_draw_canvas"));
    this.jOt.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121662);
        h.a("com.tencent.mm:support", new IPCBoolean(paramAnonymousBoolean), PerformancePanel.b.class, null);
        if (paramAnonymousBoolean)
        {
          c.JE("jsapi_draw_canvas");
          AppMethodBeat.o(121662);
          return;
        }
        c.JF("jsapi_draw_canvas");
        AppMethodBeat.o(121662);
      }
    });
    this.jOu = ((MMSwitchBtn)findViewById(2131298492));
    this.jOu.setEnabled(bool);
    this.jOu.setCheck(c.JG("widget_launch"));
    this.jOu.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121663);
        h.a("com.tencent.mm:support", new IPCBoolean(paramAnonymousBoolean), PerformancePanel.c.class, null);
        if (paramAnonymousBoolean)
        {
          c.JE("widget_launch");
          AppMethodBeat.o(121663);
          return;
        }
        c.JF("widget_launch");
        AppMethodBeat.o(121663);
      }
    });
    this.jOv = ((MMSwitchBtn)findViewById(2131298491));
    this.jOv.setEnabled(bool);
    this.jOv.setCheck(f.bae());
    this.jOv.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121664);
        f.fU(paramAnonymousBoolean);
        AppMethodBeat.o(121664);
      }
    });
    AppMethodBeat.o(121672);
  }
  
  static class b
    implements b<IPCBoolean, IPCVoid>
  {}
  
  static class c
    implements b<IPCBoolean, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.PerformancePanel
 * JD-Core Version:    0.7.0.1
 */