package com.tencent.mm.plugin.expt.roomexpt;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public class RoomExptDebugUI
  extends MMActivity
{
  private ListView gJa;
  private ArrayAdapter mcR;
  private TextView mcS;
  private Button mcT;
  private Button mcU;
  private Button mcV;
  private Button mcW;
  private Button mcX;
  
  private void aXa()
  {
    AppMethodBeat.i(73600);
    this.mcS.setText(a.bsU().bsZ());
    AppMethodBeat.o(73600);
  }
  
  public int getLayoutId()
  {
    return 2130968627;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73599);
    super.onCreate(paramBundle);
    this.mcT = ((Button)$(2131821027));
    this.mcT.setOnClickListener(new RoomExptDebugUI.1(this));
    this.mcU = ((Button)$(2131821028));
    this.mcU.setOnClickListener(new RoomExptDebugUI.2(this));
    this.mcW = ((Button)$(2131821030));
    this.mcW.setOnClickListener(new RoomExptDebugUI.3(this));
    this.mcV = ((Button)$(2131821029));
    this.mcV.setOnClickListener(new RoomExptDebugUI.4(this));
    this.mcX = ((Button)$(2131821031));
    this.mcX.setOnClickListener(new RoomExptDebugUI.5(this));
    this.mcS = ((TextView)$(2131821032));
    aXa();
    this.gJa = ((ListView)$(2131821033));
    this.mcR = new RoomExptDebugUI.6(this, this);
    this.gJa.setAdapter(this.mcR);
    AppMethodBeat.o(73599);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(73601);
    if (this.mcR != null)
    {
      this.mcR.setNotifyOnChange(false);
      this.mcR.clear();
    }
    super.onDestroy();
    AppMethodBeat.o(73601);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI
 * JD-Core Version:    0.7.0.1
 */