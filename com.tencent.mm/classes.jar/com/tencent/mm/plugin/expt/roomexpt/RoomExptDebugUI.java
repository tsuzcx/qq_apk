package com.tencent.mm.plugin.expt.roomexpt;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.MMActivity;

public class RoomExptDebugUI
  extends MMActivity
{
  private ListView jpT;
  private ArrayAdapter rbn;
  private TextView rbo;
  private Button rbp;
  private Button rbq;
  private Button rbr;
  private Button rbs;
  private Button rbt;
  
  private void bOQ()
  {
    AppMethodBeat.i(122438);
    this.rbo.setText(a.crq().crv());
    AppMethodBeat.o(122438);
  }
  
  public int getLayoutId()
  {
    return 2131492935;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(122437);
    super.onCreate(paramBundle);
    this.rbp = ((Button)$(2131300582));
    this.rbp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122428);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        g.ajF().ay(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(122427);
            RoomExptDebugUI.a(RoomExptDebugUI.this);
            AppMethodBeat.o(122427);
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122428);
      }
    });
    this.rbq = ((Button)$(2131297677));
    this.rbq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122430);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        g.ajF().ay(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(122429);
            RoomExptDebugUI.b(RoomExptDebugUI.this);
            AppMethodBeat.o(122429);
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122430);
      }
    });
    this.rbs = ((Button)$(2131304115));
    this.rbs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122431);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        a.crq().cru();
        RoomExptDebugUI.c(RoomExptDebugUI.this);
        Toast.makeText(RoomExptDebugUI.this, "reset finish", 0).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122431);
      }
    });
    this.rbr = ((Button)$(2131298956));
    this.rbr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122432);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        a.crq().crt();
        RoomExptDebugUI.d(RoomExptDebugUI.this).clear();
        Toast.makeText(RoomExptDebugUI.this, "del db finish", 0).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122432);
      }
    });
    this.rbt = ((Button)$(2131304778));
    this.rbt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122433);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        a.crq().rbd = 3;
        Toast.makeText(RoomExptDebugUI.this, "set show finish", 0).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122433);
      }
    });
    this.rbo = ((TextView)$(2131299611));
    bOQ();
    this.jpT = ((ListView)$(2131304217));
    this.rbn = new RoomExptDebugUI.6(this, this);
    this.jpT.setAdapter(this.rbn);
    AppMethodBeat.o(122437);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(122439);
    if (this.rbn != null)
    {
      this.rbn.setNotifyOnChange(false);
      this.rbn.clear();
    }
    super.onDestroy();
    AppMethodBeat.o(122439);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI
 * JD-Core Version:    0.7.0.1
 */