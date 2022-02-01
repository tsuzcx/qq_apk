package com.tencent.mm.plugin.expt.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.picker.c;
import com.tencent.mm.ui.widget.picker.c.b;
import java.util.ArrayList;
import java.util.List;

public class ExptAppDebugUI
  extends MMActivity
{
  private Button hPX;
  private Button kjo;
  private TextView sLA;
  private TextView sLB;
  private TextView sLC;
  private TextView sLD;
  private TextView sLE;
  private EditText sLF;
  private Button sLG;
  private Button sLH;
  private int sLI = 0;
  private TextView sLw;
  private Button sLx;
  private Button sLy;
  private Button sLz;
  
  public int getLayoutId()
  {
    return 2131492955;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(220657);
    super.onCreate(paramBundle);
    setMMTitle("Expt App debug ui");
    setBackBtn(new ExptAppDebugUI.1(this));
    this.sLw = ((TextView)$(2131302675));
    this.hPX = ((Button)$(2131298990));
    this.hPX.setOnClickListener(new ExptAppDebugUI.2(this));
    this.sLF = ((EditText)$(2131300249));
    this.sLF.setVisibility(8);
    this.sLG = ((Button)$(2131300250));
    this.sLG.setVisibility(8);
    this.sLx = ((Button)$(2131300246));
    this.sLx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(220653);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        com.tencent.mm.plugin.expt.f.a.cRk();
        localObject = com.tencent.mm.plugin.expt.f.a.cRo();
        if (((ArrayList)localObject).size() > 0)
        {
          paramAnonymousView = new String[((ArrayList)localObject).size()];
          int i = 0;
          while (i < paramAnonymousView.length)
          {
            paramAnonymousView[i] = ((ArrayList)localObject).get(i);
            i += 1;
          }
          localObject = new c(ExptAppDebugUI.this.getContext(), paramAnonymousView);
          ((c)localObject).app(0);
          ((c)localObject).QTc = new c.b()
          {
            public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
            {
              AppMethodBeat.i(220652);
              this.oGj.hide();
              int i = this.oGj.hci();
              paramAnonymous2Object1 = paramAnonymousView[i];
              ExptAppDebugUI.a(ExptAppDebugUI.this, Util.getInt(paramAnonymous2Object1, 0));
              AppMethodBeat.o(220652);
            }
          };
          ((c)localObject).show();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(220653);
      }
    });
    this.sLy = ((Button)$(2131306951));
    this.sLy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(220654);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        com.tencent.mm.plugin.expt.a.a.cMx();
        com.tencent.mm.plugin.expt.a.a.cMy();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(220654);
      }
    });
    this.sLz = ((Button)$(2131306960));
    this.sLz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(220655);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        com.tencent.mm.plugin.expt.f.a.cRk().Hx(1);
        Toast.makeText(ExptAppDebugUI.this.getContext(), "start req expt", 0).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(220655);
      }
    });
    this.kjo = ((Button)$(2131300242));
    this.kjo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(220656);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = new ArrayList();
        paramAnonymousView.add(Integer.valueOf(ExptAppDebugUI.b(ExptAppDebugUI.this)));
        com.tencent.mm.plugin.expt.f.a.cRk();
        com.tencent.mm.plugin.expt.f.a.b(0, paramAnonymousView, null);
        com.tencent.mm.plugin.expt.f.a.cRk();
        com.tencent.mm.plugin.expt.f.a.mq(true);
        ExptAppDebugUI.c(ExptAppDebugUI.this).setText(" del :" + ExptAppDebugUI.b(ExptAppDebugUI.this) + " true");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(220656);
      }
    });
    this.sLH = ((Button)$(2131300243));
    this.sLH.setVisibility(8);
    this.sLA = ((TextView)$(2131300244));
    this.sLB = ((TextView)$(2131302192));
    this.sLC = ((TextView)$(2131300247));
    this.sLD = ((TextView)$(2131300248));
    this.sLE = ((TextView)$(2131300241));
    AppMethodBeat.o(220657);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.ui.ExptAppDebugUI
 * JD-Core Version:    0.7.0.1
 */