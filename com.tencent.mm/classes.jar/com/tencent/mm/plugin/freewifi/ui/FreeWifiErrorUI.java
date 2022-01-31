package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiErrorUI
  extends MMActivity
{
  private ImageView krw;
  private TextView krx;
  private TextView kry;
  private TextView krz;
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return R.i.free_wifi_error;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(R.l.free_wifi_title);
    this.krw = ((ImageView)findViewById(R.h.free_wifi_error));
    if (getIntent().getIntExtra("free_wifi_show_detail_error", 0) == 1) {
      this.krw.setImageResource(R.g.free_wifi_detail_error);
    }
    this.krx = ((TextView)findViewById(R.h.free_wifi_errmsg));
    this.kry = ((TextView)findViewById(R.h.free_wifi_detail_errmsg1));
    this.krz = ((TextView)findViewById(R.h.free_wifi_detail_errmsg2));
    paramBundle = getIntent().getStringExtra("free_wifi_error_ui_error_msg");
    String str1 = getIntent().getStringExtra("free_wifi_error_ui_error_msg_detail1");
    String str2 = getIntent().getStringExtra("free_wifi_error_ui_error_msg_detail12");
    if (!m.isEmpty(paramBundle)) {
      this.krx.setText(paramBundle);
    }
    if (!m.isEmpty(str1)) {
      this.kry.setText(str1);
    }
    if (!m.isEmpty(str2)) {
      this.krz.setText(str2);
    }
    setBackBtn(new FreeWifiErrorUI.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiErrorUI
 * JD-Core Version:    0.7.0.1
 */