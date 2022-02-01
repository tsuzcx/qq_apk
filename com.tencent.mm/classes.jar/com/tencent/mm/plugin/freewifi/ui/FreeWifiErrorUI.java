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
  private TextView tpA;
  private TextView tpB;
  private ImageView tpy;
  private TextView tpz;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494169;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25017);
    super.onCreate(paramBundle);
    setMMTitle(2131759653);
    this.tpy = ((ImageView)findViewById(2131300262));
    if (getIntent().getIntExtra("free_wifi_show_detail_error", 0) == 1) {
      this.tpy.setImageResource(2131232426);
    }
    this.tpz = ((TextView)findViewById(2131300261));
    this.tpA = ((TextView)findViewById(2131300259));
    this.tpB = ((TextView)findViewById(2131300260));
    paramBundle = getIntent().getStringExtra("free_wifi_error_ui_error_msg");
    String str1 = getIntent().getStringExtra("free_wifi_error_ui_error_msg_detail1");
    String str2 = getIntent().getStringExtra("free_wifi_error_ui_error_msg_detail12");
    if (!m.ea(paramBundle)) {
      this.tpz.setText(paramBundle);
    }
    if (!m.ea(str1)) {
      this.tpA.setText(str1);
    }
    if (!m.ea(str2)) {
      this.tpB.setText(str2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiErrorUI
 * JD-Core Version:    0.7.0.1
 */