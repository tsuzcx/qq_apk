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
import com.tencent.mm.ipcinvoker.k;
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
  MMSwitchBtn joh;
  MMSwitchBtn joi;
  MMSwitchBtn joj;
  
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
        Object localObject = c.Fz("jsapi_draw_canvas").toString();
        paramAnonymousView = new StringBuilder();
        if ((localObject != null) && (((String)localObject).length() > 0))
        {
          int i = c.cp("jsapi_draw_canvas", "__invoke_jsapi_data_size");
          paramAnonymousView.append("data size :").append(i).append("\n").append((String)localObject);
        }
        localObject = (IPCString)h.a("com.tencent.mm:support", new IPCString("widget_launch"), PerformancePanel.e.class);
        if (localObject != null) {
          paramAnonymousView.append("\n\n").append(localObject);
        }
        if (f.aTf()) {
          paramAnonymousView.append("\n\n").append(f.aTg());
        }
        this.jol.setText(paramAnonymousView.toString());
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
        this.jol.setText(c.Fz("jsapi_draw_canvas").toString());
        AppMethodBeat.o(121660);
      }
    });
    localObject = (MMSwitchBtn)findViewById(2131303021);
    boolean bool = c.aTe();
    ((MMSwitchBtn)localObject).setCheck(bool);
    ((MMSwitchBtn)localObject).setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121661);
        h.a("com.tencent.mm:support", new IPCBoolean(paramAnonymousBoolean), PerformancePanel.d.class, null);
        c.fx(paramAnonymousBoolean);
        localView.setEnabled(paramAnonymousBoolean);
        PerformancePanel.this.joh.setEnabled(paramAnonymousBoolean);
        PerformancePanel.this.joi.setEnabled(paramAnonymousBoolean);
        PerformancePanel.this.joj.setEnabled(paramAnonymousBoolean);
        AppMethodBeat.o(121661);
      }
    });
    localView.setEnabled(bool);
    this.joh = ((MMSwitchBtn)findViewById(2131298446));
    this.joh.setEnabled(bool);
    this.joh.setCheck(c.FC("jsapi_draw_canvas"));
    this.joh.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121662);
        h.a("com.tencent.mm:support", new IPCBoolean(paramAnonymousBoolean), PerformancePanel.b.class, null);
        if (paramAnonymousBoolean)
        {
          c.FA("jsapi_draw_canvas");
          AppMethodBeat.o(121662);
          return;
        }
        c.FB("jsapi_draw_canvas");
        AppMethodBeat.o(121662);
      }
    });
    this.joi = ((MMSwitchBtn)findViewById(2131298492));
    this.joi.setEnabled(bool);
    this.joi.setCheck(c.FC("widget_launch"));
    this.joi.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121663);
        h.a("com.tencent.mm:support", new IPCBoolean(paramAnonymousBoolean), PerformancePanel.c.class, null);
        if (paramAnonymousBoolean)
        {
          c.FA("widget_launch");
          AppMethodBeat.o(121663);
          return;
        }
        c.FB("widget_launch");
        AppMethodBeat.o(121663);
      }
    });
    this.joj = ((MMSwitchBtn)findViewById(2131298491));
    this.joj.setEnabled(bool);
    this.joj.setCheck(f.aTf());
    this.joj.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121664);
        f.fy(paramAnonymousBoolean);
        AppMethodBeat.o(121664);
      }
    });
    AppMethodBeat.o(121672);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.PerformancePanel
 * JD-Core Version:    0.7.0.1
 */