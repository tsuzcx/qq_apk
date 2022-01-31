package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.at.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

public class RegByMobileVoiceVerifyUI
  extends MMActivity
  implements f
{
  private String bSe;
  private String fcX;
  private com.tencent.mm.modelfriend.a fiS;
  private TextView flb;
  private String fmj;
  private String frp;
  private x frr;
  private int frs = 0;
  
  protected final int getLayoutId()
  {
    return q.g.bindmcontact_voice_verify;
  }
  
  protected final void initView()
  {
    setMMTitle(q.j.bind_mcontact_voice_verify_voice_title);
    setBackBtn(new RegByMobileVoiceVerifyUI.1(this));
    this.flb = ((TextView)findViewById(q.f.languagename));
    Button localButton = (Button)findViewById(q.f.bind_mcontact_voice_verify_btn);
    this.fmj = RegByMobileVoiceVerifySelectUI.qg(this.bSe);
    this.flb.setText(this.fmj);
    this.frp = b.mB(this.bSe);
    findViewById(q.f.ll_current_language).setOnClickListener(new RegByMobileVoiceVerifyUI.2(this));
    localButton.setOnClickListener(new RegByMobileVoiceVerifyUI.3(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 != 10000) || (paramIntent == null)) {
      return;
    }
    this.fmj = paramIntent.getStringExtra("voice_verify_language");
    this.frp = paramIntent.getStringExtra("voice_verify_code");
    this.flb.setText(this.fmj);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.bSe = getIntent().getExtras().getString("bindmcontact_mobile");
    this.frs = getIntent().getExtras().getInt("voice_verify_type");
    if ((this.frs == 0) || (this.frs == 2) || (this.frs == 3)) {
      g.Dk().a(145, this);
    }
    for (;;)
    {
      this.fcX = com.tencent.mm.plugin.b.a.YA();
      initView();
      return;
      if ((this.frs == 4) || (this.frs == 1)) {
        g.Dk().a(132, this);
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    g.Dk().b(132, this);
    g.Dk().b(145, this);
    if ((this.frs == 0) || (this.frs == 2) || (this.frs == 3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      g.DN();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R200_500,");
      g.DN();
      com.tencent.mm.plugin.b.a.d(false, com.tencent.mm.kernel.a.gd("R200_500") + ",2");
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      com.tencent.mm.plugin.b.a.qj(this.fcX);
      XM();
      finish();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onResume()
  {
    super.onResume();
    if ((this.frs == 0) || (this.frs == 2) || (this.frs == 3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      g.DN();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R200_500,");
      g.DN();
      com.tencent.mm.plugin.b.a.d(true, com.tencent.mm.kernel.a.gd("R200_500") + ",1");
      com.tencent.mm.plugin.b.a.qi("R200_500");
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.RegByMobileVoiceVerifyUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileVoiceVerifyUI
 * JD-Core Version:    0.7.0.1
 */