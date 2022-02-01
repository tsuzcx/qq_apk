package com.tencent.mm.plugin.expt.roomexpt;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.a;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.d;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;

public class RoomExptDebugUI
  extends MMActivity
{
  private ListView qgc;
  private ArrayAdapter zMT;
  private TextView zMU;
  private Button zMV;
  private Button zMW;
  private Button zMX;
  private Button zMY;
  private Button zMZ;
  
  private void dNn()
  {
    AppMethodBeat.i(122438);
    this.zMU.setText(a.dNf().dNk());
    AppMethodBeat.o(122438);
  }
  
  public int getLayoutId()
  {
    return b.d.activity_room_expt_debug;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(122437);
    super.onCreate(paramBundle);
    this.zMV = ((Button)$(b.c.get_db_btn));
    this.zMV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122428);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        h.baH().postToWorker(new Runnable()
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
    this.zMW = ((Button)$(b.c.calc));
    this.zMW.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122430);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        h.baH().postToWorker(new Runnable()
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
    this.zMY = ((Button)$(b.c.reset_btn));
    this.zMY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122431);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        a.dNf().dNj();
        RoomExptDebugUI.c(RoomExptDebugUI.this);
        Toast.makeText(RoomExptDebugUI.this, "reset finish", 0).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122431);
      }
    });
    this.zMX = ((Button)$(b.c.del_db));
    this.zMX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122432);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        a.dNf().dNi();
        RoomExptDebugUI.d(RoomExptDebugUI.this).clear();
        Toast.makeText(RoomExptDebugUI.this, "del db finish", 0).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122432);
      }
    });
    this.zMZ = ((Button)$(b.c.show_btn));
    this.zMZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122433);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        a.dNf().zMK = 3;
        Toast.makeText(RoomExptDebugUI.this, "set show finish", 0).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122433);
      }
    });
    this.zMU = ((TextView)$(b.c.expt_info));
    dNn();
    this.qgc = ((ListView)$(b.c.room_list));
    this.zMT = new ArrayAdapter(this, b.d.room_expt_ui_item, b.c.room_expt_ui_tv)
    {
      public final View getView(int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
      {
        AppMethodBeat.i(122434);
        paramAnonymousView = super.getView(paramAnonymousInt, paramAnonymousView, paramAnonymousViewGroup);
        paramAnonymousViewGroup = (TextView)paramAnonymousView.findViewById(b.c.room_expt_ui_tv);
        if (paramAnonymousInt % 2 == 0) {
          paramAnonymousViewGroup.setBackgroundResource(b.a.wechat_green);
        }
        for (;;)
        {
          AppMethodBeat.o(122434);
          return paramAnonymousView;
          paramAnonymousViewGroup.setBackgroundResource(b.a.transparent);
        }
      }
    };
    this.qgc.setAdapter(this.zMT);
    AppMethodBeat.o(122437);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(122439);
    if (this.zMT != null)
    {
      this.zMT.setNotifyOnChange(false);
      this.zMT.clear();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI
 * JD-Core Version:    0.7.0.1
 */