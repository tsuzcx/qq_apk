package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiIntroductionUI
  extends MMActivity
{
  private Button kqJ;
  private Button kse;
  private Button ksf;
  private CheckBox ksg;
  private int source;
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return R.i.free_wifi_intro;
  }
  
  protected final void initView()
  {
    this.kse = ((Button)findViewById(R.h.continue_btn));
    this.ksg = ((CheckBox)findViewById(R.h.agree_user_agree_cb));
    this.kqJ = ((Button)findViewById(R.h.help_btn));
    this.ksf = ((Button)findViewById(R.h.user_agreemen_btn));
    this.source = getIntent().getIntExtra("free_wifi_source", 1);
    if (this.source == 3)
    {
      setMMTitle(R.l.mig_free_wifi_tile);
      ((TextView)findViewById(R.h.free_wifi_intro_tv)).setText(R.l.mig_free_wifi_intro_tips);
      ((TextView)findViewById(R.h.free_wifi_desc_tv)).setText(R.l.mig_free_wifi_desc);
      this.kqJ.setVisibility(8);
    }
    for (;;)
    {
      setBackBtn(new FreeWifiIntroductionUI.1(this));
      this.kse.setOnClickListener(new FreeWifiIntroductionUI.2(this));
      this.ksg.setOnCheckedChangeListener(new FreeWifiIntroductionUI.3(this));
      this.ksf.setOnClickListener(new FreeWifiIntroductionUI.4(this));
      this.kqJ.setOnClickListener(new FreeWifiIntroductionUI.5(this));
      return;
      setMMTitle(R.l.free_wifi_title);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiIntroductionUI
 * JD-Core Version:    0.7.0.1
 */