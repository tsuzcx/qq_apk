package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.MMActivity;

public class IPCallAllRecordUI
  extends MMActivity
{
  private String caK;
  private String caM;
  private ListView luC;
  private boolean luD = false;
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return R.i.ip_call_allrecord_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.caM = getIntent().getStringExtra("IPCallAllRecordUI_phoneNumber");
    this.caK = getIntent().getStringExtra("IPCallAllRecordUI_contactId");
    this.luD = getIntent().getBooleanExtra("IPCallAllRecordUI_isSinglePhoneNumber", false);
    setMMTitle(R.l.ip_call_record_list_title);
    setBackBtn(new IPCallAllRecordUI.1(this));
    this.luC = ((ListView)findViewById(R.h.all_record_list));
    this.luC.setAdapter(new IPCallAllRecordUI.a(this, this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallAllRecordUI
 * JD-Core Version:    0.7.0.1
 */