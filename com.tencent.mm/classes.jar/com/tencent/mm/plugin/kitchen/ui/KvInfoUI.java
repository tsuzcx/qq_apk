package com.tencent.mm.plugin.kitchen.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.kitchen.b.b;
import com.tencent.mm.plugin.kitchen.b.c;
import com.tencent.mm.plugin.report.service.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.picker.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KvInfoUI
  extends MMActivity
{
  private Button fbO;
  private c fvH;
  private ArrayAdapter jIP;
  private EditText lAu;
  private Button lAv;
  private ListView lAw;
  private TextView lAx;
  private MMSwitchBtn lAy;
  private String lAz;
  
  private void Gj(String paramString)
  {
    y.i("MicroMsg.KvInfoUI", "updateData new[%s] old[%s]", new Object[] { paramString, this.lAz });
    this.lAz = paramString;
    paramString = (List)j.bxa().nGi.get(this.lAz);
    if (paramString != null)
    {
      this.lAx.setText(this.lAz + ":" + paramString.size());
      this.jIP.setNotifyOnChange(false);
      this.jIP.clear();
      this.jIP.addAll(paramString);
      this.jIP.notifyDataSetChanged();
      return;
    }
    this.lAx.setText(this.lAz + ":0");
    this.jIP.clear();
  }
  
  protected final int getLayoutId()
  {
    return b.c.kv_info_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle("Debug show kv log");
    setBackBtn(new KvInfoUI.1(this));
    this.lAu = ((EditText)findViewById(b.b.input_log));
    this.lAx = ((TextView)findViewById(b.b.select_id_info));
    this.lAv = ((Button)findViewById(b.b.log_picker));
    this.lAv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = j.bxa().nGi;
        if ((paramAnonymousView != null) && (paramAnonymousView.size() > 0))
        {
          paramAnonymousView = new ArrayList(paramAnonymousView.keySet());
          b localb = new b(KvInfoUI.this.mController.uMN, paramAnonymousView);
          localb.IC(0);
          localb.wov = new KvInfoUI.2.1(this, localb, paramAnonymousView);
          localb.IB(a.fromDPToPix(KvInfoUI.this.mController.uMN, 288));
          localb.show();
        }
      }
    });
    this.lAy = ((MMSwitchBtn)findViewById(b.b.debug_flag));
    this.lAy.setCheck(j.bxa().nEB);
    this.lAy.setSwitchListener(new KvInfoUI.3(this));
    this.fbO = ((Button)findViewById(b.b.confirm_btn));
    this.fbO.setOnClickListener(new KvInfoUI.4(this));
    this.lAw = ((ListView)findViewById(b.b.kv_log_list));
    this.jIP = new KvInfoUI.5(this, this, b.c.kv_info_ui_item, b.b.kv_info_ui_tv);
    this.lAw.setAdapter(this.jIP);
    this.lAw.setOnItemClickListener(new KvInfoUI.6(this));
  }
  
  protected void onDestroy()
  {
    if (this.jIP != null)
    {
      this.jIP.setNotifyOnChange(false);
      this.jIP.clear();
    }
    if (this.fvH != null) {
      this.fvH.dismiss();
    }
    XM();
    super.onDestroy();
  }
  
  protected void onResume()
  {
    if (!bk.bl(this.lAz)) {
      Gj(this.lAz);
    }
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.kitchen.ui.KvInfoUI
 * JD-Core Version:    0.7.0.1
 */