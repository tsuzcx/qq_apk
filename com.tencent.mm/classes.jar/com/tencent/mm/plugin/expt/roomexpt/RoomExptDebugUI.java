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
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.MMActivity;

public class RoomExptDebugUI
  extends MMActivity
{
  private ListView iwH;
  private ArrayAdapter pJn;
  private TextView pJo;
  private Button pJp;
  private Button pJq;
  private Button pJr;
  private Button pJs;
  private Button pJt;
  
  private void bDd()
  {
    AppMethodBeat.i(122438);
    this.pJo.setText(a.cem().cer());
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
    this.pJp = ((Button)$(2131300582));
    this.pJp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122428);
        g.afE().ax(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(122427);
            RoomExptDebugUI.a(RoomExptDebugUI.this);
            AppMethodBeat.o(122427);
          }
        });
        AppMethodBeat.o(122428);
      }
    });
    this.pJq = ((Button)$(2131297677));
    this.pJq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122430);
        g.afE().ax(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(122429);
            RoomExptDebugUI.b(RoomExptDebugUI.this);
            AppMethodBeat.o(122429);
          }
        });
        AppMethodBeat.o(122430);
      }
    });
    this.pJs = ((Button)$(2131304115));
    this.pJs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122431);
        a.cem().ceq();
        RoomExptDebugUI.c(RoomExptDebugUI.this);
        Toast.makeText(RoomExptDebugUI.this, "reset finish", 0).show();
        AppMethodBeat.o(122431);
      }
    });
    this.pJr = ((Button)$(2131298956));
    this.pJr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122432);
        a.cem().cep();
        RoomExptDebugUI.d(RoomExptDebugUI.this).clear();
        Toast.makeText(RoomExptDebugUI.this, "del db finish", 0).show();
        AppMethodBeat.o(122432);
      }
    });
    this.pJt = ((Button)$(2131304778));
    this.pJt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122433);
        a.cem().pJd = 3;
        Toast.makeText(RoomExptDebugUI.this, "set show finish", 0).show();
        AppMethodBeat.o(122433);
      }
    });
    this.pJo = ((TextView)$(2131299611));
    bDd();
    this.iwH = ((ListView)$(2131304217));
    this.pJn = new RoomExptDebugUI.6(this, this);
    this.iwH.setAdapter(this.pJn);
    AppMethodBeat.o(122437);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(122439);
    if (this.pJn != null)
    {
      this.pJn.setNotifyOnChange(false);
      this.pJn.clear();
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