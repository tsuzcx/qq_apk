package com.tencent.mm.plugin.collect.reward.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.gg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.d;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.tk;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class QrRewardGrantUI
  extends QrRewardBaseUI
{
  private RadioButton adP;
  private int channel;
  private String dac;
  private String kbL;
  private String owt;
  private CdnImageView oyB;
  private TextView oyC;
  private TextView oyD;
  private WalletTextView oyE;
  private LinearLayout oyF;
  private WalletFormView oyG;
  private MMEditText oyH;
  private Button oyI;
  private int oyJ;
  private int oyK;
  private String oyL;
  private String oyM;
  private String oyN;
  private String oyO;
  private String oyP;
  private String oyQ;
  private String oyR;
  private String oyS;
  private String oyT;
  private int oyU;
  private String oyV;
  private String oyW;
  private c<gg> oyX;
  
  public QrRewardGrantUI()
  {
    AppMethodBeat.i(63931);
    this.oyX = new c() {};
    AppMethodBeat.o(63931);
  }
  
  private void fa(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63937);
    ac.i("MicroMsg.QrRewardGrantUI", "do pay check");
    if (bs.isNullOrNil(this.dac)) {
      this.dac = paramString1;
    }
    if (bs.isNullOrNil(this.owt)) {
      this.owt = paramString2;
    }
    doSceneProgress(new d(this.dac, this.oyM, this.owt, this.oyJ, this.oyN, this.oyO), false);
    AppMethodBeat.o(63937);
  }
  
  public int getLayoutId()
  {
    return 2131495161;
  }
  
  public void initView()
  {
    AppMethodBeat.i(63933);
    this.oyB = ((CdnImageView)findViewById(2131303629));
    this.oyC = ((TextView)findViewById(2131303630));
    this.oyE = ((WalletTextView)findViewById(2131303634));
    this.oyF = ((LinearLayout)findViewById(2131303633));
    this.oyG = ((WalletFormView)findViewById(2131303631));
    this.oyH = ((MMEditText)findViewById(2131303632));
    this.oyI = ((Button)findViewById(2131303635));
    this.oyD = ((TextView)findViewById(2131303628));
    this.adP = ((RadioButton)findViewById(2131303705));
    this.adP.setChecked(true);
    this.oyD.setText(getString(2131762108, new Object[] { Math.round(this.oyU / 100.0F) }));
    String str;
    if (bs.isNullOrNil(this.oyW))
    {
      a.b.a(this.oyB, this.oyP, 0.03F, false);
      if (!bs.isNullOrNil(this.oyV)) {
        break label423;
      }
      str = com.tencent.mm.wallet_core.ui.e.gr(com.tencent.mm.wallet_core.ui.e.wk(this.oyP), 10);
      label234:
      this.oyC.setText(k.c(this, getString(2131762094, new Object[] { str })));
      if (this.oyK != 2) {
        break label431;
      }
      ac.i("MicroMsg.QrRewardGrantUI", "edit layout");
      setEditFocusListener(this.oyG, 2, false);
      this.oyG.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(63923);
          if (paramAnonymousEditable.toString().startsWith(".")) {
            paramAnonymousEditable.insert(0, "0");
          }
          String str = paramAnonymousEditable.toString();
          int i = str.indexOf(".");
          int j = str.length();
          if ((i >= 0) && (j - i > 3)) {
            paramAnonymousEditable.delete(i + 3, j);
          }
          for (;;)
          {
            i = (int)Math.round(bs.getDouble(paramAnonymousEditable.toString(), 0.0D) * 100.0D);
            QrRewardGrantUI.a(QrRewardGrantUI.this, i);
            QrRewardGrantUI.b(QrRewardGrantUI.this, i);
            AppMethodBeat.o(63923);
            return;
            if (i > 6) {
              paramAnonymousEditable.delete(6, i);
            } else if ((i == -1) && (j > 6)) {
              paramAnonymousEditable.delete(6, j);
            }
          }
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.oyG.setVisibility(0);
      this.oyF.setVisibility(8);
      this.oyG.fAY();
      this.oyI.setEnabled(false);
    }
    for (;;)
    {
      this.oyI.setOnClickListener(new w()
      {
        public final void bWk()
        {
          AppMethodBeat.i(63924);
          int i = (int)Math.round(bs.getDouble(QrRewardGrantUI.a(QrRewardGrantUI.this).getText(), 0.0D) * 100.0D);
          if (QrRewardGrantUI.a(QrRewardGrantUI.this, i)) {
            QrRewardGrantUI.b(QrRewardGrantUI.this);
          }
          AppMethodBeat.o(63924);
        }
      });
      findViewById(2131303706).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(63925);
          boolean bool = QrRewardGrantUI.c(QrRewardGrantUI.this).isChecked();
          paramAnonymousView = QrRewardGrantUI.c(QrRewardGrantUI.this);
          if (!bool) {}
          for (bool = true;; bool = false)
          {
            paramAnonymousView.setChecked(bool);
            AppMethodBeat.o(63925);
            return;
          }
        }
      });
      this.adP.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean) {}
      });
      AppMethodBeat.o(63933);
      return;
      int i = BackwardSupportUtil.b.g(this, 50.0F);
      this.oyB.setRoundCorner(true);
      this.oyB.r(this.oyW, i, i, 2131231875);
      break;
      label423:
      str = this.oyV;
      break label234;
      label431:
      this.oyE.setText(com.tencent.mm.wallet_core.ui.e.C(this.oyJ / 100.0D));
      this.oyG.setVisibility(8);
      this.oyF.setVisibility(0);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(63936);
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        setResult(-1);
        if (paramIntent != null) {
          fa(paramIntent.getStringExtra("key_reqKey"), paramIntent.getStringExtra("key_trans_id"));
        }
        finish();
        AppMethodBeat.o(63936);
      }
    }
    else {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(63936);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(63932);
    super.onCreate(paramBundle);
    addSceneEndListener(1336);
    this.oyX.alive();
    setMMTitle(2131762093);
    this.oyJ = getIntent().getIntExtra("key_money_amt", 20000);
    this.oyK = getIntent().getIntExtra("key_amt_type", 0);
    this.oyL = getIntent().getStringExtra("key_qrcode_desc");
    this.channel = getIntent().getIntExtra("key_channel", 0);
    this.oyN = getIntent().getStringExtra("key_rcvr_open_id");
    this.oyP = getIntent().getStringExtra("key_rcvr_name");
    this.oyQ = getIntent().getStringExtra("key_rcvr_true_name");
    this.oyR = getIntent().getStringExtra("key_scan_id");
    this.kbL = getIntent().getStringExtra("key_web_url");
    this.oyS = getIntent().getStringExtra("key_sxtend_1");
    this.oyT = getIntent().getStringExtra("key_sxtend_2");
    this.oyU = getIntent().getIntExtra("key_max_amt", 20000);
    this.oyV = getIntent().getStringExtra("key_receiver_nickname");
    this.oyW = getIntent().getStringExtra("key_photo_url");
    ac.i("MicroMsg.QrRewardGrantUI", "amtType: %s, channel: %s, maxAmt: %s", new Object[] { Integer.valueOf(this.oyK), Integer.valueOf(this.channel), Integer.valueOf(this.oyU) });
    initView();
    b.fzz();
    if ((b.b(b.a.pRO, true)) && (((com.tencent.mm.pluginsdk.wallet.a)g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_REWARD_CODE_PAY_SWTICH_KEY"))) {}
    for (boolean bool = true;; bool = false)
    {
      this.mKindaEnable = bool;
      AppMethodBeat.o(63932);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(63935);
    super.onDestroy();
    removeSceneEndListener(1336);
    this.oyX.dead();
    AppMethodBeat.o(63935);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(63934);
    if ((paramn instanceof com.tencent.mm.plugin.collect.reward.a.e))
    {
      paramString = (com.tencent.mm.plugin.collect.reward.a.e)paramn;
      paramString.a(new a.a()
      {
        public final void g(n paramAnonymousn)
        {
          AppMethodBeat.i(63929);
          QrRewardGrantUI.a(QrRewardGrantUI.this, paramString.oys.djr);
          QrRewardGrantUI.b(QrRewardGrantUI.this, paramString.oys.Enp);
          QrRewardGrantUI.c(QrRewardGrantUI.this, paramString.oys.DQt);
          QrRewardGrantUI.d(QrRewardGrantUI.this, paramString.oys.Enn);
          QrRewardGrantUI.e(QrRewardGrantUI.this, paramString.oys.Enm);
          ac.i("MicroMsg.QrRewardGrantUI", "remind str: %s", new Object[] { paramString.oys.EnB });
          if (!bs.isNullOrNil(paramString.oys.EnB))
          {
            h.d(QrRewardGrantUI.this.getContext(), paramString.oys.EnB, "", QrRewardGrantUI.this.getString(2131762444), QrRewardGrantUI.this.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(63928);
                QrRewardGrantUI.f(QrRewardGrantUI.this);
                AppMethodBeat.o(63928);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
            });
            AppMethodBeat.o(63929);
            return;
          }
          QrRewardGrantUI.f(QrRewardGrantUI.this);
          AppMethodBeat.o(63929);
        }
      }).b(new a.a()
      {
        public final void g(n paramAnonymousn)
        {
          AppMethodBeat.i(63927);
          ac.e("MicroMsg.QrRewardGrantUI", "place order error: %s, %s", new Object[] { Integer.valueOf(paramString.oys.dae), paramString.oys.oxf });
          if (!bs.isNullOrNil(paramString.oys.oxf)) {
            Toast.makeText(QrRewardGrantUI.this, paramString.oys.oxf, 0).show();
          }
          if (QrRewardGrantUI.e(QrRewardGrantUI.this)) {
            QrRewardGrantUI.this.hideLoading();
          }
          AppMethodBeat.o(63927);
        }
      }).c(new a.a()
      {
        public final void g(n paramAnonymousn)
        {
          AppMethodBeat.i(63926);
          ac.e("MicroMsg.QrRewardGrantUI", "net error: %s", new Object[] { paramAnonymousn });
          if (QrRewardGrantUI.d(QrRewardGrantUI.this)) {
            QrRewardGrantUI.this.hideLoading();
          }
          AppMethodBeat.o(63926);
        }
      });
    }
    AppMethodBeat.o(63934);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardGrantUI
 * JD-Core Version:    0.7.0.1
 */