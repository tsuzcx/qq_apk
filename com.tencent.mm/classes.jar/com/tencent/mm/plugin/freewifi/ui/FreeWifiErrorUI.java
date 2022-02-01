package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiErrorUI
  extends MMActivity
{
  private ImageView wRq;
  private TextView wRr;
  private TextView wRs;
  private TextView wRt;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494723;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25017);
    super.onCreate(paramBundle);
    setMMTitle(2131760974);
    this.wRq = ((ImageView)findViewById(2131301741));
    if (getIntent().getIntExtra("free_wifi_show_detail_error", 0) == 1) {
      this.wRq.setImageResource(2131232807);
    }
    this.wRr = ((TextView)findViewById(2131301740));
    this.wRs = ((TextView)findViewById(2131301738));
    this.wRt = ((TextView)findViewById(2131301739));
    paramBundle = getIntent().getStringExtra("free_wifi_error_ui_error_msg");
    String str1 = getIntent().getStringExtra("free_wifi_error_ui_error_msg_detail1");
    String str2 = getIntent().getStringExtra("free_wifi_error_ui_error_msg_detail12");
    if (!m.eP(paramBundle)) {
      this.wRr.setText(paramBundle);
    }
    if (!m.eP(str1)) {
      this.wRs.setText(str1);
    }
    if (!m.eP(str2)) {
      this.wRt.setText(str2);
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25016);
        FreeWifiErrorUI.this.finish();
        AppMethodBeat.o(25016);
        return true;
      }
    });
    AppMethodBeat.o(25017);
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