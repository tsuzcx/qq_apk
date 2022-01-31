package com.tencent.mm.plugin.collect.reward.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.fv;
import com.tencent.mm.plugin.collect.reward.a.a;
import com.tencent.mm.plugin.collect.reward.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class QrRewardGrantUI
  extends QrRewardBaseUI
{
  private RadioButton Vd;
  private String bMX;
  private int bUR;
  private String gis;
  private String iGK;
  private String iIA;
  private String iIB;
  private String iIC;
  private String iID;
  private String iIE;
  private String iIF;
  private String iIG;
  private int iIH;
  private c<fv> iII = new QrRewardGrantUI.8(this);
  private ImageView iIo;
  private TextView iIp;
  private TextView iIq;
  private WalletTextView iIr;
  private LinearLayout iIs;
  private WalletFormView iIt;
  private MMEditText iIu;
  private Button iIv;
  private int iIw;
  private int iIx;
  private String iIy;
  private String iIz;
  
  private void cE(String paramString1, String paramString2)
  {
    y.i("MicroMsg.QrRewardGrantUI", "do pay check");
    if (bk.bl(this.bMX)) {
      this.bMX = paramString1;
    }
    if (bk.bl(this.iGK)) {
      this.iGK = paramString2;
    }
    a(new d(this.bMX, this.iIz, this.iGK, this.iIw, this.iIA, this.iIB), false, false);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof com.tencent.mm.plugin.collect.reward.a.e))
    {
      paramString = (com.tencent.mm.plugin.collect.reward.a.e)paramm;
      paramString.a(new QrRewardGrantUI.7(this, paramString)).b(new QrRewardGrantUI.6(this, paramString)).c(new QrRewardGrantUI.5(this));
    }
    return true;
  }
  
  protected final int getLayoutId()
  {
    return a.g.qr_reward_grant_ui;
  }
  
  public final void initView()
  {
    this.iIo = ((ImageView)findViewById(a.f.qrgu_avatar_iv));
    this.iIp = ((TextView)findViewById(a.f.qrgu_desc_tv));
    this.iIr = ((WalletTextView)findViewById(a.f.qrgu_fixed_money_tv));
    this.iIs = ((LinearLayout)findViewById(a.f.qrgu_fixed_layout));
    this.iIt = ((WalletFormView)findViewById(a.f.qrgu_edit_money_et));
    this.iIu = ((MMEditText)findViewById(a.f.qrgu_edit_word_et));
    this.iIv = ((Button)findViewById(a.f.qrgu_grant_btn));
    this.iIq = ((TextView)findViewById(a.f.qrgu_alert_tv));
    this.Vd = ((RadioButton)findViewById(a.f.radio_check));
    this.Vd.setChecked(true);
    this.iIq.setText(getString(a.i.qr_reward_set_money_exceed_text, new Object[] { Math.round(this.iIH / 100.0F) }));
    a.b.a(this.iIo, this.iIC, 0.03F, false);
    String str = com.tencent.mm.wallet_core.ui.e.dP(com.tencent.mm.wallet_core.ui.e.gV(this.iIC), 10);
    this.iIp.setText(j.b(this, getString(a.i.qr_reward_grant_username_wrap_text, new Object[] { str })));
    if (this.iIx == 2)
    {
      y.i("MicroMsg.QrRewardGrantUI", "edit layout");
      e(this.iIt, 2, false);
      this.iIt.a(new QrRewardGrantUI.1(this));
      this.iIt.setVisibility(0);
      this.iIs.setVisibility(8);
      this.iIt.cNx();
      this.iIv.setEnabled(false);
    }
    for (;;)
    {
      this.iIv.setOnClickListener(new QrRewardGrantUI.2(this));
      findViewById(a.f.radio_check_ll).setOnClickListener(new QrRewardGrantUI.3(this));
      this.Vd.setOnCheckedChangeListener(new QrRewardGrantUI.4(this));
      return;
      this.iIr.setText(com.tencent.mm.wallet_core.ui.e.A(this.iIw / 100.0D));
      this.iIt.setVisibility(8);
      this.iIs.setVisibility(0);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        setResult(-1);
        if (paramIntent != null) {
          cE(paramIntent.getStringExtra("key_reqKey"), paramIntent.getStringExtra("key_trans_id"));
        }
        finish();
      }
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    kh(1336);
    this.iII.cqo();
    setMMTitle(a.i.qr_reward_grant_title);
    this.iIw = getIntent().getIntExtra("key_money_amt", 20000);
    this.iIx = getIntent().getIntExtra("key_amt_type", 0);
    this.iIy = getIntent().getStringExtra("key_qrcode_desc");
    this.bUR = getIntent().getIntExtra("key_channel", 0);
    this.iIA = getIntent().getStringExtra("key_rcvr_open_id");
    this.iIC = getIntent().getStringExtra("key_rcvr_name");
    this.iID = getIntent().getStringExtra("key_rcvr_true_name");
    this.iIE = getIntent().getStringExtra("key_scan_id");
    this.gis = getIntent().getStringExtra("key_web_url");
    this.iIF = getIntent().getStringExtra("key_sxtend_1");
    this.iIG = getIntent().getStringExtra("key_sxtend_2");
    this.iIH = getIntent().getIntExtra("key_max_amt", 20000);
    y.i("MicroMsg.QrRewardGrantUI", "amtType: %s, channel: %s, maxAmt: %s", new Object[] { Integer.valueOf(this.iIx), Integer.valueOf(this.bUR), Integer.valueOf(this.iIH) });
    initView();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ki(1336);
    this.iII.dead();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardGrantUI
 * JD-Core Version:    0.7.0.1
 */