package com.tencent.mm.plugin.expt.roomexpt;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.h.b.a.q;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.ui.MMActivity;

public class RoomExptDebugUI
  extends MMActivity
{
  private ListView fry;
  private ArrayAdapter jIP;
  private TextView jIQ;
  private Button jIR;
  private Button jIS;
  private Button jIT;
  private Button jIU;
  private Button jIV;
  
  private void ayf()
  {
    TextView localTextView = this.jIQ;
    Object localObject = a.aNc();
    if (((a)localObject).jIE != null) {}
    for (localObject = ((a)localObject).jIE.uJ();; localObject = "")
    {
      localTextView.setText((CharSequence)localObject);
      return;
    }
  }
  
  protected final int getLayoutId()
  {
    return b.c.activity_room_expt_debug;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jIR = ((Button)findViewById(b.b.get_db_btn));
    this.jIR.setOnClickListener(new RoomExptDebugUI.1(this));
    this.jIS = ((Button)findViewById(b.b.calc));
    this.jIS.setOnClickListener(new RoomExptDebugUI.2(this));
    this.jIU = ((Button)findViewById(b.b.reset_btn));
    this.jIU.setOnClickListener(new RoomExptDebugUI.3(this));
    this.jIT = ((Button)findViewById(b.b.del_db));
    this.jIT.setOnClickListener(new RoomExptDebugUI.4(this));
    this.jIV = ((Button)findViewById(b.b.show_btn));
    this.jIV.setOnClickListener(new RoomExptDebugUI.5(this));
    this.jIQ = ((TextView)findViewById(b.b.expt_info));
    ayf();
    this.fry = ((ListView)findViewById(b.b.room_list));
    this.jIP = new RoomExptDebugUI.6(this, this, b.c.room_expt_ui_item, b.b.room_expt_ui_tv);
    this.fry.setAdapter(this.jIP);
  }
  
  protected void onDestroy()
  {
    if (this.jIP != null)
    {
      this.jIP.setNotifyOnChange(false);
      this.jIP.clear();
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI
 * JD-Core Version:    0.7.0.1
 */