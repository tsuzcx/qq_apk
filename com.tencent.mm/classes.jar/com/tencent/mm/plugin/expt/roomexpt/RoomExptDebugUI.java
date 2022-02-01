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
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.ui.MMActivity;

public class RoomExptDebugUI
  extends MMActivity
{
  private ListView jsM;
  private ArrayAdapter rjt;
  private TextView rju;
  private Button rjv;
  private Button rjw;
  private Button rjx;
  private Button rjy;
  private Button rjz;
  
  private void bPO()
  {
    AppMethodBeat.i(122438);
    this.rju.setText(a.csS().csX());
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
    this.rjv = ((Button)$(2131300582));
    this.rjv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122428);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        g.ajU().aw(new Runnable()
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
    this.rjw = ((Button)$(2131297677));
    this.rjw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122430);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        g.ajU().aw(new Runnable()
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
    this.rjy = ((Button)$(2131304115));
    this.rjy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122431);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        a.csS().csW();
        RoomExptDebugUI.c(RoomExptDebugUI.this);
        Toast.makeText(RoomExptDebugUI.this, "reset finish", 0).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122431);
      }
    });
    this.rjx = ((Button)$(2131298956));
    this.rjx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122432);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        a.csS().csV();
        RoomExptDebugUI.d(RoomExptDebugUI.this).clear();
        Toast.makeText(RoomExptDebugUI.this, "del db finish", 0).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122432);
      }
    });
    this.rjz = ((Button)$(2131304778));
    this.rjz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122433);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        a.csS().rjj = 3;
        Toast.makeText(RoomExptDebugUI.this, "set show finish", 0).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122433);
      }
    });
    this.rju = ((TextView)$(2131299611));
    bPO();
    this.jsM = ((ListView)$(2131304217));
    this.rjt = new RoomExptDebugUI.6(this, this);
    this.jsM.setAdapter(this.rjt);
    AppMethodBeat.o(122437);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(122439);
    if (this.rjt != null)
    {
      this.rjt.setNotifyOnChange(false);
      this.rjt.clear();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI
 * JD-Core Version:    0.7.0.1
 */