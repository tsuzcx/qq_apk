package com.tencent.mm.plugin.collect.reward.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.fy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.collect.reward.a.a;
import com.tencent.mm.plugin.collect.reward.a.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class QrRewardGrantUI
  extends QrRewardBaseUI
{
  private RadioButton VQ;
  private int cCy;
  private String cnI;
  private String hBM;
  private String kMN;
  private ImageView kOT;
  private TextView kOU;
  private TextView kOV;
  private WalletTextView kOW;
  private LinearLayout kOX;
  private WalletFormView kOY;
  private MMEditText kOZ;
  private Button kPa;
  private int kPb;
  private int kPc;
  private String kPd;
  private String kPe;
  private String kPf;
  private String kPg;
  private String kPh;
  private String kPi;
  private String kPj;
  private String kPk;
  private String kPl;
  private int kPm;
  private c<fy> kPn;
  
  public QrRewardGrantUI()
  {
    AppMethodBeat.i(41072);
    this.kPn = new QrRewardGrantUI.8(this);
    AppMethodBeat.o(41072);
  }
  
  private void dD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(41078);
    ab.i("MicroMsg.QrRewardGrantUI", "do pay check");
    if (bo.isNullOrNil(this.cnI)) {
      this.cnI = paramString1;
    }
    if (bo.isNullOrNil(this.kMN)) {
      this.kMN = paramString2;
    }
    doSceneProgress(new d(this.cnI, this.kPe, this.kMN, this.kPb, this.kPf, this.kPg), false);
    AppMethodBeat.o(41078);
  }
  
  public int getLayoutId()
  {
    return 2130970488;
  }
  
  public void initView()
  {
    AppMethodBeat.i(41074);
    this.kOT = ((ImageView)findViewById(2131826926));
    this.kOU = ((TextView)findViewById(2131826927));
    this.kOW = ((WalletTextView)findViewById(2131826929));
    this.kOX = ((LinearLayout)findViewById(2131826928));
    this.kOY = ((WalletFormView)findViewById(2131826930));
    this.kOZ = ((MMEditText)findViewById(2131826931));
    this.kPa = ((Button)findViewById(2131826934));
    this.kOV = ((TextView)findViewById(2131826935));
    this.VQ = ((RadioButton)findViewById(2131826933));
    this.VQ.setChecked(true);
    this.kOV.setText(getString(2131302229, new Object[] { Math.round(this.kPm / 100.0F) }));
    a.b.a(this.kOT, this.kPh, 0.03F, false);
    String str = com.tencent.mm.wallet_core.ui.e.eZ(com.tencent.mm.wallet_core.ui.e.nE(this.kPh), 10);
    this.kOU.setText(j.b(this, getString(2131302215, new Object[] { str })));
    if (this.kPc == 2)
    {
      ab.i("MicroMsg.QrRewardGrantUI", "edit layout");
      setEditFocusListener(this.kOY, 2, false);
      this.kOY.a(new QrRewardGrantUI.1(this));
      this.kOY.setVisibility(0);
      this.kOX.setVisibility(8);
      this.kOY.dTc();
      this.kPa.setEnabled(false);
    }
    for (;;)
    {
      this.kPa.setOnClickListener(new QrRewardGrantUI.2(this));
      findViewById(2131826932).setOnClickListener(new QrRewardGrantUI.3(this));
      this.VQ.setOnCheckedChangeListener(new QrRewardGrantUI.4(this));
      AppMethodBeat.o(41074);
      return;
      this.kOW.setText(com.tencent.mm.wallet_core.ui.e.E(this.kPb / 100.0D));
      this.kOY.setVisibility(8);
      this.kOX.setVisibility(0);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(41077);
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        setResult(-1);
        if (paramIntent != null) {
          dD(paramIntent.getStringExtra("key_reqKey"), paramIntent.getStringExtra("key_trans_id"));
        }
        finish();
        AppMethodBeat.o(41077);
      }
    }
    else {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(41077);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41073);
    super.onCreate(paramBundle);
    addSceneEndListener(1336);
    this.kPn.alive();
    setMMTitle(2131302214);
    this.kPb = getIntent().getIntExtra("key_money_amt", 20000);
    this.kPc = getIntent().getIntExtra("key_amt_type", 0);
    this.kPd = getIntent().getStringExtra("key_qrcode_desc");
    this.cCy = getIntent().getIntExtra("key_channel", 0);
    this.kPf = getIntent().getStringExtra("key_rcvr_open_id");
    this.kPh = getIntent().getStringExtra("key_rcvr_name");
    this.kPi = getIntent().getStringExtra("key_rcvr_true_name");
    this.kPj = getIntent().getStringExtra("key_scan_id");
    this.hBM = getIntent().getStringExtra("key_web_url");
    this.kPk = getIntent().getStringExtra("key_sxtend_1");
    this.kPl = getIntent().getStringExtra("key_sxtend_2");
    this.kPm = getIntent().getIntExtra("key_max_amt", 20000);
    ab.i("MicroMsg.QrRewardGrantUI", "amtType: %s, channel: %s, maxAmt: %s", new Object[] { Integer.valueOf(this.kPc), Integer.valueOf(this.cCy), Integer.valueOf(this.kPm) });
    initView();
    com.tencent.mm.wallet_core.b.dRI();
    if ((com.tencent.mm.wallet_core.b.dpQ()) && (((com.tencent.mm.pluginsdk.wallet.b)g.E(com.tencent.mm.pluginsdk.wallet.b.class)).kindaCacheServiceGetBool("NEW_CASHIER_REWARD_CODE_PAY_SWTICH_KEY"))) {}
    for (boolean bool = true;; bool = false)
    {
      this.mKindaEnable = bool;
      AppMethodBeat.o(41073);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41076);
    super.onDestroy();
    removeSceneEndListener(1336);
    this.kPn.dead();
    AppMethodBeat.o(41076);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(41075);
    if ((paramm instanceof com.tencent.mm.plugin.collect.reward.a.e))
    {
      paramString = (com.tencent.mm.plugin.collect.reward.a.e)paramm;
      paramString.a(new QrRewardGrantUI.7(this, paramString)).b(new QrRewardGrantUI.6(this, paramString)).c(new QrRewardGrantUI.5(this));
    }
    AppMethodBeat.o(41075);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardGrantUI
 * JD-Core Version:    0.7.0.1
 */