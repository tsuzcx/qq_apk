package com.tencent.mm.plugin.expt.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.d;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.picker.b.b;
import java.util.ArrayList;
import java.util.List;

public class ExptAppDebugUI
  extends MMActivity
{
  private Button kEt;
  private Button nbe;
  private EditText wrA;
  private Button wrB;
  private Button wrC;
  private int wrD = 0;
  private TextView wrr;
  private Button wrs;
  private Button wrt;
  private Button wru;
  private TextView wrv;
  private TextView wrw;
  private TextView wrx;
  private TextView wry;
  private TextView wrz;
  
  public int getLayoutId()
  {
    return b.d.activity_expt_app_debug;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(256634);
    super.onCreate(paramBundle);
    setMMTitle("Expt App debug ui");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(256301);
        ExptAppDebugUI.this.finish();
        AppMethodBeat.o(256301);
        return true;
      }
    });
    this.wrr = ((TextView)$(b.c.input_exptId));
    this.kEt = ((Button)$(b.c.confirm_btn));
    this.kEt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(257032);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = ExptAppDebugUI.a(ExptAppDebugUI.this).getText().toString().trim();
        ExptAppDebugUI.a(ExptAppDebugUI.this, Util.getInt(paramAnonymousView, 0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(257032);
      }
    });
    this.wrA = ((EditText)$(b.c.expt_xml));
    this.wrA.setVisibility(8);
    this.wrB = ((Button)$(b.c.expt_xml_confirm));
    this.wrB.setVisibility(8);
    this.wrs = ((Button)$(b.c.expt_picker));
    this.wrs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(257215);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        com.tencent.mm.plugin.expt.f.a.dgf();
        localObject = com.tencent.mm.plugin.expt.f.a.dgj();
        if (((ArrayList)localObject).size() > 0)
        {
          paramAnonymousView = new String[((ArrayList)localObject).size()];
          int i = 0;
          while (i < paramAnonymousView.length)
          {
            paramAnonymousView[i] = ((ArrayList)localObject).get(i);
            i += 1;
          }
          localObject = new com.tencent.mm.ui.widget.picker.b(ExptAppDebugUI.this.getContext(), paramAnonymousView);
          ((com.tencent.mm.ui.widget.picker.b)localObject).ayK(0);
          ((com.tencent.mm.ui.widget.picker.b)localObject).YrN = new b.b()
          {
            public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
            {
              AppMethodBeat.i(251935);
              this.rHY.hide();
              int i = this.rHY.idp();
              paramAnonymous2Object1 = paramAnonymousView[i];
              ExptAppDebugUI.a(ExptAppDebugUI.this, Util.getInt(paramAnonymous2Object1, 0));
              AppMethodBeat.o(251935);
            }
          };
          ((com.tencent.mm.ui.widget.picker.b)localObject).show();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(257215);
      }
    });
    this.wrt = ((Button)$(b.c.report_msg));
    this.wrt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(254071);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        com.tencent.mm.plugin.expt.a.a.dbl();
        com.tencent.mm.plugin.expt.a.a.dbm();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(254071);
      }
    });
    this.wru = ((Button)$(b.c.req_expt));
    this.wru.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(256928);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        com.tencent.mm.plugin.expt.f.a.dgf().Lh(1);
        Toast.makeText(ExptAppDebugUI.this.getContext(), "start req expt", 0).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(256928);
      }
    });
    this.nbe = ((Button)$(b.c.expt_del));
    this.nbe.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(256876);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = new ArrayList();
        paramAnonymousView.add(Integer.valueOf(ExptAppDebugUI.b(ExptAppDebugUI.this)));
        com.tencent.mm.plugin.expt.f.a.dgf();
        com.tencent.mm.plugin.expt.f.a.b(0, paramAnonymousView, null);
        com.tencent.mm.plugin.expt.f.a.dgf();
        com.tencent.mm.plugin.expt.f.a.nD(true);
        ExptAppDebugUI.c(ExptAppDebugUI.this).setText(" del :" + ExptAppDebugUI.b(ExptAppDebugUI.this) + " true");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(256876);
      }
    });
    this.wrC = ((Button)$(b.c.expt_export));
    this.wrC.setVisibility(8);
    this.wrv = ((TextView)$(b.c.expt_id));
    this.wrw = ((TextView)$(b.c.group_id));
    this.wrx = ((TextView)$(b.c.expt_seq));
    this.wry = ((TextView)$(b.c.expt_time));
    this.wrz = ((TextView)$(b.c.expt_args));
    AppMethodBeat.o(256634);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.ui.ExptAppDebugUI
 * JD-Core Version:    0.7.0.1
 */