package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiErrorUI
  extends MMActivity
{
  private ImageView mNl;
  private TextView mNm;
  private TextView mNn;
  private TextView mNo;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969627;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(20958);
    super.onCreate(paramBundle);
    setMMTitle(2131300181);
    this.mNl = ((ImageView)findViewById(2131824250));
    if (getIntent().getIntExtra("free_wifi_show_detail_error", 0) == 1) {
      this.mNl.setImageResource(2130838887);
    }
    this.mNm = ((TextView)findViewById(2131824251));
    this.mNn = ((TextView)findViewById(2131824252));
    this.mNo = ((TextView)findViewById(2131824253));
    paramBundle = getIntent().getStringExtra("free_wifi_error_ui_error_msg");
    String str1 = getIntent().getStringExtra("free_wifi_error_ui_error_msg_detail1");
    String str2 = getIntent().getStringExtra("free_wifi_error_ui_error_msg_detail12");
    if (!m.isEmpty(paramBundle)) {
      this.mNm.setText(paramBundle);
    }
    if (!m.isEmpty(str1)) {
      this.mNn.setText(str1);
    }
    if (!m.isEmpty(str2)) {
      this.mNo.setText(str2);
    }
    setBackBtn(new FreeWifiErrorUI.1(this));
    AppMethodBeat.o(20958);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiErrorUI
 * JD-Core Version:    0.7.0.1
 */