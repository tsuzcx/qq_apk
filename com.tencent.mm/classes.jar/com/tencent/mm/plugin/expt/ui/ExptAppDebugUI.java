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
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.List;

public class ExptAppDebugUI
  extends MMActivity
{
  private Button gUt;
  private Button jis;
  private TextView rbK;
  private Button rbL;
  private Button rbM;
  private Button rbN;
  private TextView rbO;
  private TextView rbP;
  private TextView rbQ;
  private TextView rbR;
  private TextView rbS;
  private EditText rbT;
  private Button rbU;
  private Button rbV;
  private int rbW = 0;
  
  public int getLayoutId()
  {
    return 2131496375;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(210549);
    super.onCreate(paramBundle);
    setMMTitle("Expt App debug ui");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(210542);
        ExptAppDebugUI.this.finish();
        AppMethodBeat.o(210542);
        return true;
      }
    });
    this.rbK = ((TextView)$(2131301027));
    this.gUt = ((Button)$(2131298556));
    this.gUt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(210543);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = ExptAppDebugUI.a(ExptAppDebugUI.this).getText().toString().trim();
        ExptAppDebugUI.a(ExptAppDebugUI.this, bt.getInt(paramAnonymousView, 0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(210543);
      }
    });
    this.rbT = ((EditText)$(2131299615));
    this.rbT.setVisibility(8);
    this.rbU = ((Button)$(2131299616));
    this.rbU.setVisibility(8);
    this.rbL = ((Button)$(2131299612));
    this.rbL.setOnClickListener(new ExptAppDebugUI.3(this));
    this.rbM = ((Button)$(2131308186));
    this.rbM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(210546);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        com.tencent.mm.plugin.expt.a.a.cmW();
        com.tencent.mm.plugin.expt.a.a.cmX();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(210546);
      }
    });
    this.rbN = ((Button)$(2131304094));
    this.rbN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(210547);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        com.tencent.mm.plugin.expt.f.a.cqZ().Dx(1);
        Toast.makeText(ExptAppDebugUI.this.getContext(), "start req expt", 0).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(210547);
      }
    });
    this.jis = ((Button)$(2131299608));
    this.jis.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(210548);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = new ArrayList();
        paramAnonymousView.add(Integer.valueOf(ExptAppDebugUI.b(ExptAppDebugUI.this)));
        com.tencent.mm.plugin.expt.f.a.cqZ();
        com.tencent.mm.plugin.expt.f.a.c(0, paramAnonymousView, null);
        com.tencent.mm.plugin.expt.f.a.cqZ();
        com.tencent.mm.plugin.expt.f.a.li(true);
        ExptAppDebugUI.c(ExptAppDebugUI.this).setText(" del :" + ExptAppDebugUI.b(ExptAppDebugUI.this) + " true");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(210548);
      }
    });
    this.rbV = ((Button)$(2131299609));
    this.rbV.setVisibility(8);
    this.rbO = ((TextView)$(2131299610));
    this.rbP = ((TextView)$(2131300635));
    this.rbQ = ((TextView)$(2131299613));
    this.rbR = ((TextView)$(2131299614));
    this.rbS = ((TextView)$(2131299607));
    AppMethodBeat.o(210549);
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