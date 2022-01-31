package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public class IPCallAllRecordUI
  extends MMActivity
{
  private String cHB;
  private String cJk;
  private ListView nRU;
  private boolean nRV = false;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969922;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22070);
    super.onCreate(paramBundle);
    this.cHB = getIntent().getStringExtra("IPCallAllRecordUI_phoneNumber");
    this.cJk = getIntent().getStringExtra("IPCallAllRecordUI_contactId");
    this.nRV = getIntent().getBooleanExtra("IPCallAllRecordUI_isSinglePhoneNumber", false);
    setMMTitle(2131300882);
    setBackBtn(new IPCallAllRecordUI.1(this));
    this.nRU = ((ListView)findViewById(2131825171));
    this.nRU.setAdapter(new IPCallAllRecordUI.a(this, this));
    AppMethodBeat.o(22070);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallAllRecordUI
 * JD-Core Version:    0.7.0.1
 */