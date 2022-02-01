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
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;

public class RoomExptDebugUI
  extends MMActivity
{
  private ListView krb;
  private ArrayAdapter sKU;
  private TextView sKV;
  private Button sKW;
  private Button sKX;
  private Button sKY;
  private Button sKZ;
  private Button sLa;
  
  private void cnp()
  {
    AppMethodBeat.i(122438);
    this.sKV.setText(a.cRz().cRE());
    AppMethodBeat.o(122438);
  }
  
  public int getLayoutId()
  {
    return 2131492962;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(122437);
    super.onCreate(paramBundle);
    this.sKW = ((Button)$(2131302120));
    this.sKW.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122428);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        g.aAk().postToWorker(new Runnable()
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
    this.sKX = ((Button)$(2131297948));
    this.sKX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122430);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        g.aAk().postToWorker(new Runnable()
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
    this.sKZ = ((Button)$(2131306998));
    this.sKZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122431);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        a.cRz().cRD();
        RoomExptDebugUI.c(RoomExptDebugUI.this);
        Toast.makeText(RoomExptDebugUI.this, "reset finish", 0).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122431);
      }
    });
    this.sKY = ((Button)$(2131299450));
    this.sKY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122432);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        a.cRz().cRC();
        RoomExptDebugUI.d(RoomExptDebugUI.this).clear();
        Toast.makeText(RoomExptDebugUI.this, "del db finish", 0).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122432);
      }
    });
    this.sLa = ((Button)$(2131307860));
    this.sLa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122433);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        a.cRz().sKK = 3;
        Toast.makeText(RoomExptDebugUI.this, "set show finish", 0).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122433);
      }
    });
    this.sKV = ((TextView)$(2131300245));
    cnp();
    this.krb = ((ListView)$(2131307135));
    this.sKU = new RoomExptDebugUI.6(this, this);
    this.krb.setAdapter(this.sKU);
    AppMethodBeat.o(122437);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(122439);
    if (this.sKU != null)
    {
      this.sKU.setNotifyOnChange(false);
      this.sKU.clear();
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