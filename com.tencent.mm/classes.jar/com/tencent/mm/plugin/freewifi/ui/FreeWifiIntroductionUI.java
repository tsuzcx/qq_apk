package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiIntroductionUI
  extends MMActivity
{
  private int cpt;
  private Button mMv;
  private Button mNS;
  private Button mNT;
  private CheckBox mNU;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969629;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21004);
    this.mNS = ((Button)findViewById(2131824267));
    this.mNU = ((CheckBox)findViewById(2131824265));
    this.mMv = ((Button)findViewById(2131824268));
    this.mNT = ((Button)findViewById(2131824266));
    this.cpt = getIntent().getIntExtra("free_wifi_source", 1);
    if (this.cpt == 3)
    {
      setMMTitle(2131301562);
      ((TextView)findViewById(2131824264)).setText(2131301560);
      ((TextView)findViewById(2131824263)).setText(2131301559);
      this.mMv.setVisibility(8);
    }
    for (;;)
    {
      setBackBtn(new FreeWifiIntroductionUI.1(this));
      this.mNS.setOnClickListener(new FreeWifiIntroductionUI.2(this));
      this.mNU.setOnCheckedChangeListener(new FreeWifiIntroductionUI.3(this));
      this.mNT.setOnClickListener(new FreeWifiIntroductionUI.4(this));
      this.mMv.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21002);
          paramAnonymousView = FreeWifiIntroductionUI.this.getString(2131300158);
          Intent localIntent = new Intent();
          localIntent.putExtra("rawUrl", paramAnonymousView);
          localIntent.putExtra("showShare", false);
          localIntent.putExtra("show_bottom", false);
          d.b(FreeWifiIntroductionUI.this, "webview", ".ui.tools.WebViewUI", localIntent);
          AppMethodBeat.o(21002);
        }
      });
      AppMethodBeat.o(21004);
      return;
      setMMTitle(2131300181);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21003);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(21003);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiIntroductionUI
 * JD-Core Version:    0.7.0.1
 */