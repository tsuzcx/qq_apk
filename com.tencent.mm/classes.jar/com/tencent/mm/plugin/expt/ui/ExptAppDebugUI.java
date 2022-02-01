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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.picker.c;
import com.tencent.mm.ui.widget.picker.c.a;
import java.util.ArrayList;
import java.util.List;

public class ExptAppDebugUI
  extends MMActivity
{
  private Button gXc;
  private Button jll;
  private TextView rjQ;
  private Button rjR;
  private Button rjS;
  private Button rjT;
  private TextView rjU;
  private TextView rjV;
  private TextView rjW;
  private TextView rjX;
  private TextView rjY;
  private EditText rjZ;
  private Button rka;
  private Button rkb;
  private int rkc = 0;
  
  public int getLayoutId()
  {
    return 2131496375;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(196216);
    super.onCreate(paramBundle);
    setMMTitle("Expt App debug ui");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(196209);
        ExptAppDebugUI.this.finish();
        AppMethodBeat.o(196209);
        return true;
      }
    });
    this.rjQ = ((TextView)$(2131301027));
    this.gXc = ((Button)$(2131298556));
    this.gXc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196210);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = ExptAppDebugUI.a(ExptAppDebugUI.this).getText().toString().trim();
        ExptAppDebugUI.a(ExptAppDebugUI.this, bu.getInt(paramAnonymousView, 0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196210);
      }
    });
    this.rjZ = ((EditText)$(2131299615));
    this.rjZ.setVisibility(8);
    this.rka = ((Button)$(2131299616));
    this.rka.setVisibility(8);
    this.rjR = ((Button)$(2131299612));
    this.rjR.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(196212);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        com.tencent.mm.plugin.expt.f.a.csB();
        localObject = com.tencent.mm.plugin.expt.f.a.csG();
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
          ((c)localObject).agm(0);
          ((c)localObject).Lxq = new c.a()
          {
            public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
            {
              AppMethodBeat.i(196211);
              this.nwh.hide();
              int i = this.nwh.fRg();
              paramAnonymous2Object1 = paramAnonymousView[i];
              ExptAppDebugUI.a(ExptAppDebugUI.this, bu.getInt(paramAnonymous2Object1, 0));
              AppMethodBeat.o(196211);
            }
          };
          ((c)localObject).show();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196212);
      }
    });
    this.rjS = ((Button)$(2131308186));
    this.rjS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196213);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.plugin.expt.a.a.com();
        com.tencent.mm.plugin.expt.a.a.con();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196213);
      }
    });
    this.rjT = ((Button)$(2131304094));
    this.rjT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196214);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.plugin.expt.f.a.csB().DK(1);
        Toast.makeText(ExptAppDebugUI.this.getContext(), "start req expt", 0).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196214);
      }
    });
    this.jll = ((Button)$(2131299608));
    this.jll.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196215);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = new ArrayList();
        paramAnonymousView.add(Integer.valueOf(ExptAppDebugUI.b(ExptAppDebugUI.this)));
        com.tencent.mm.plugin.expt.f.a.csB();
        com.tencent.mm.plugin.expt.f.a.c(0, paramAnonymousView, null);
        com.tencent.mm.plugin.expt.f.a.csB();
        com.tencent.mm.plugin.expt.f.a.li(true);
        ExptAppDebugUI.c(ExptAppDebugUI.this).setText(" del :" + ExptAppDebugUI.b(ExptAppDebugUI.this) + " true");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196215);
      }
    });
    this.rkb = ((Button)$(2131299609));
    this.rkb.setVisibility(8);
    this.rjU = ((TextView)$(2131299610));
    this.rjV = ((TextView)$(2131300635));
    this.rjW = ((TextView)$(2131299613));
    this.rjX = ((TextView)$(2131299614));
    this.rjY = ((TextView)$(2131299607));
    AppMethodBeat.o(196216);
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