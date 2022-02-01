package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.modelappbrand.n;
import com.tencent.mm.plugin.appbrand.dynamic.widget.b;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.ui.widget.picker.c;
import com.tencent.mm.ui.widget.picker.c.a;
import java.util.ArrayList;

public class SettingsPanel
  extends FrameLayout
{
  private Button moi;
  private Button moj;
  private View.OnClickListener mok;
  private Runnable mol;
  
  public SettingsPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(121683);
    init();
    AppMethodBeat.o(121683);
  }
  
  public SettingsPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(121684);
    init();
    AppMethodBeat.o(121684);
  }
  
  private void init()
  {
    AppMethodBeat.i(121685);
    LayoutInflater.from(getContext()).inflate(2131495401, this, true);
    findViewById(2131304137).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121675);
        ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).atK().restart();
        aq.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(121674);
            Toast.makeText(SettingsPanel.this.getContext(), 2131766327, 1).show();
            if (SettingsPanel.a(SettingsPanel.this) != null) {
              SettingsPanel.a(SettingsPanel.this).run();
            }
            AppMethodBeat.o(121674);
          }
        }, 2000L);
        AppMethodBeat.o(121675);
      }
    });
    MMSwitchBtn localMMSwitchBtn = (MMSwitchBtn)findViewById(2131299484);
    localMMSwitchBtn.setCheck(((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).atL().atR());
    localMMSwitchBtn.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121676);
        ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).atL().ed(paramAnonymousBoolean);
        AppMethodBeat.o(121676);
      }
    });
    this.moi = ((Button)findViewById(2131299235));
    vC(b.aVR());
    this.moi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(121678);
        paramAnonymousView = new ArrayList();
        paramAnonymousView.add("MHADrawableView");
        paramAnonymousView.add("MTextureView");
        paramAnonymousView.add("MSurfaceView");
        paramAnonymousView.add("MCanvasView");
        paramAnonymousView.add("MDrawableView");
        paramAnonymousView = new c(SettingsPanel.this.getContext(), paramAnonymousView);
        paramAnonymousView.aaR(((Integer)SettingsPanel.b(SettingsPanel.this).getTag()).intValue());
        paramAnonymousView.HIW = new c.a()
        {
          public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
          {
            AppMethodBeat.i(121677);
            paramAnonymousView.hide();
            if (paramAnonymous2Boolean) {
              SettingsPanel.b(SettingsPanel.this).setText((CharSequence)paramAnonymous2Object1);
            }
            SettingsPanel.a(SettingsPanel.this, paramAnonymousView.ffZ());
            AppMethodBeat.o(121677);
          }
        };
        paramAnonymousView.show();
        AppMethodBeat.o(121678);
      }
    });
    this.moj = ((Button)findViewById(2131301232));
    vD(com.tencent.mm.ac.h.aen());
    this.moj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(121680);
        paramAnonymousView = new ArrayList();
        paramAnonymousView.add("Normal");
        paramAnonymousView.add("Minimal-json");
        paramAnonymousView = new c(SettingsPanel.this.getContext(), paramAnonymousView);
        paramAnonymousView.aaR(((Integer)SettingsPanel.c(SettingsPanel.this).getTag()).intValue());
        paramAnonymousView.HIW = new c.a()
        {
          public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
          {
            AppMethodBeat.i(121679);
            paramAnonymousView.hide();
            if (paramAnonymous2Boolean) {
              SettingsPanel.c(SettingsPanel.this).setText((CharSequence)paramAnonymous2Object1);
            }
            SettingsPanel.b(SettingsPanel.this, paramAnonymousView.ffZ());
            AppMethodBeat.o(121679);
          }
        };
        paramAnonymousView.show();
        AppMethodBeat.o(121680);
      }
    });
    findViewById(2131298367).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121681);
        if (SettingsPanel.d(SettingsPanel.this) != null) {
          SettingsPanel.d(SettingsPanel.this).onClick(paramAnonymousView);
        }
        AppMethodBeat.o(121681);
      }
    });
    if (((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).atL().atS())
    {
      findViewById(2131299485).setVisibility(0);
      findViewById(2131299236).setVisibility(0);
      findViewById(2131301233).setVisibility(0);
    }
    AppMethodBeat.o(121685);
  }
  
  private void vC(int paramInt)
  {
    AppMethodBeat.i(121686);
    this.moi.setTag(Integer.valueOf(paramInt));
    switch (paramInt)
    {
    default: 
      this.moi.setText("MHADrawableView");
      b.rf(0);
      AppMethodBeat.o(121686);
      return;
    case 1: 
      this.moi.setText("MTextureView");
      b.rf(1);
      AppMethodBeat.o(121686);
      return;
    case 2: 
      this.moi.setText("MSurfaceView");
      b.rf(2);
      AppMethodBeat.o(121686);
      return;
    case 3: 
      this.moi.setText("MCanvasView");
      b.rf(3);
      AppMethodBeat.o(121686);
      return;
    }
    this.moi.setText("MDrawableView");
    b.rf(4);
    AppMethodBeat.o(121686);
  }
  
  private void vD(int paramInt)
  {
    AppMethodBeat.i(121687);
    this.moj.setTag(Integer.valueOf(paramInt));
    String str;
    switch (paramInt)
    {
    default: 
      str = "Normal";
    }
    for (paramInt = 0;; paramInt = 1)
    {
      this.moj.setText(str);
      com.tencent.mm.ac.h.mm(paramInt);
      com.tencent.mm.ipcinvoker.h.a("com.tencent.mm:support", new IPCInteger(paramInt), SettingsPanel.a.class, null);
      AppMethodBeat.o(121687);
      return;
      str = "Minimal-json";
    }
  }
  
  public void setOnCloseDebuggerClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mok = paramOnClickListener;
  }
  
  public void setOnResetDebuggerRunnable(Runnable paramRunnable)
  {
    this.mol = paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel
 * JD-Core Version:    0.7.0.1
 */