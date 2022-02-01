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
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.gf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.d;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.ta;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class QrRewardGrantUI
  extends QrRewardBaseUI
{
  private RadioButton acV;
  private int channel;
  private String dcE;
  private String jBp;
  private String nSY;
  private String nVA;
  private String nVB;
  private c<gf> nVC;
  private CdnImageView nVg;
  private TextView nVh;
  private TextView nVi;
  private WalletTextView nVj;
  private LinearLayout nVk;
  private WalletFormView nVl;
  private MMEditText nVm;
  private Button nVn;
  private int nVo;
  private int nVp;
  private String nVq;
  private String nVr;
  private String nVs;
  private String nVt;
  private String nVu;
  private String nVv;
  private String nVw;
  private String nVx;
  private String nVy;
  private int nVz;
  
  public QrRewardGrantUI()
  {
    AppMethodBeat.i(63931);
    this.nVC = new c() {};
    AppMethodBeat.o(63931);
  }
  
  private void eN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63937);
    ad.i("MicroMsg.QrRewardGrantUI", "do pay check");
    if (bt.isNullOrNil(this.dcE)) {
      this.dcE = paramString1;
    }
    if (bt.isNullOrNil(this.nSY)) {
      this.nSY = paramString2;
    }
    doSceneProgress(new d(this.dcE, this.nVr, this.nSY, this.nVo, this.nVs, this.nVt), false);
    AppMethodBeat.o(63937);
  }
  
  public int getLayoutId()
  {
    return 2131495161;
  }
  
  public void initView()
  {
    AppMethodBeat.i(63933);
    this.nVg = ((CdnImageView)findViewById(2131303629));
    this.nVh = ((TextView)findViewById(2131303630));
    this.nVj = ((WalletTextView)findViewById(2131303634));
    this.nVk = ((LinearLayout)findViewById(2131303633));
    this.nVl = ((WalletFormView)findViewById(2131303631));
    this.nVm = ((MMEditText)findViewById(2131303632));
    this.nVn = ((Button)findViewById(2131303635));
    this.nVi = ((TextView)findViewById(2131303628));
    this.acV = ((RadioButton)findViewById(2131303705));
    this.acV.setChecked(true);
    this.nVi.setText(getString(2131762108, new Object[] { Math.round(this.nVz / 100.0F) }));
    String str;
    if (bt.isNullOrNil(this.nVB))
    {
      a.b.a(this.nVg, this.nVu, 0.03F, false);
      if (!bt.isNullOrNil(this.nVA)) {
        break label423;
      }
      str = com.tencent.mm.wallet_core.ui.e.gn(com.tencent.mm.wallet_core.ui.e.sh(this.nVu), 10);
      label234:
      this.nVh.setText(k.c(this, getString(2131762094, new Object[] { str })));
      if (this.nVp != 2) {
        break label431;
      }
      ad.i("MicroMsg.QrRewardGrantUI", "edit layout");
      setEditFocusListener(this.nVl, 2, false);
      this.nVl.a(new TextWatcher()
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
            i = (int)Math.round(bt.getDouble(paramAnonymousEditable.toString(), 0.0D) * 100.0D);
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
      this.nVl.setVisibility(0);
      this.nVk.setVisibility(8);
      this.nVl.fkI();
      this.nVn.setEnabled(false);
    }
    for (;;)
    {
      this.nVn.setOnClickListener(new v()
      {
        public final void bOU()
        {
          AppMethodBeat.i(63924);
          int i = (int)Math.round(bt.getDouble(QrRewardGrantUI.a(QrRewardGrantUI.this).getText(), 0.0D) * 100.0D);
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
      this.acV.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean) {}
      });
      AppMethodBeat.o(63933);
      return;
      int i = BackwardSupportUtil.b.g(this, 50.0F);
      this.nVg.setRoundCorner(true);
      this.nVg.r(this.nVB, i, i, 2131231875);
      break;
      label423:
      str = this.nVA;
      break label234;
      label431:
      this.nVj.setText(com.tencent.mm.wallet_core.ui.e.D(this.nVo / 100.0D));
      this.nVl.setVisibility(8);
      this.nVk.setVisibility(0);
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
          eN(paramIntent.getStringExtra("key_reqKey"), paramIntent.getStringExtra("key_trans_id"));
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
    this.nVC.alive();
    setMMTitle(2131762093);
    this.nVo = getIntent().getIntExtra("key_money_amt", 20000);
    this.nVp = getIntent().getIntExtra("key_amt_type", 0);
    this.nVq = getIntent().getStringExtra("key_qrcode_desc");
    this.channel = getIntent().getIntExtra("key_channel", 0);
    this.nVs = getIntent().getStringExtra("key_rcvr_open_id");
    this.nVu = getIntent().getStringExtra("key_rcvr_name");
    this.nVv = getIntent().getStringExtra("key_rcvr_true_name");
    this.nVw = getIntent().getStringExtra("key_scan_id");
    this.jBp = getIntent().getStringExtra("key_web_url");
    this.nVx = getIntent().getStringExtra("key_sxtend_1");
    this.nVy = getIntent().getStringExtra("key_sxtend_2");
    this.nVz = getIntent().getIntExtra("key_max_amt", 20000);
    this.nVA = getIntent().getStringExtra("key_receiver_nickname");
    this.nVB = getIntent().getStringExtra("key_photo_url");
    ad.i("MicroMsg.QrRewardGrantUI", "amtType: %s, channel: %s, maxAmt: %s", new Object[] { Integer.valueOf(this.nVp), Integer.valueOf(this.channel), Integer.valueOf(this.nVz) });
    initView();
    b.fjk();
    if ((b.b(b.a.pom, true)) && (((com.tencent.mm.pluginsdk.wallet.a)g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_REWARD_CODE_PAY_SWTICH_KEY"))) {}
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
    this.nVC.dead();
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
        public final void h(n paramAnonymousn)
        {
          AppMethodBeat.i(63929);
          QrRewardGrantUI.a(QrRewardGrantUI.this, paramString.nUX.dlJ);
          QrRewardGrantUI.b(QrRewardGrantUI.this, paramString.nUX.CUF);
          QrRewardGrantUI.c(QrRewardGrantUI.this, paramString.nUX.CxX);
          QrRewardGrantUI.d(QrRewardGrantUI.this, paramString.nUX.CUD);
          QrRewardGrantUI.e(QrRewardGrantUI.this, paramString.nUX.CUC);
          ad.i("MicroMsg.QrRewardGrantUI", "remind str: %s", new Object[] { paramString.nUX.CUR });
          if (!bt.isNullOrNil(paramString.nUX.CUR))
          {
            h.d(QrRewardGrantUI.this.getContext(), paramString.nUX.CUR, "", QrRewardGrantUI.this.getString(2131762444), QrRewardGrantUI.this.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
        public final void h(n paramAnonymousn)
        {
          AppMethodBeat.i(63927);
          ad.e("MicroMsg.QrRewardGrantUI", "place order error: %s, %s", new Object[] { Integer.valueOf(paramString.nUX.dcG), paramString.nUX.nTK });
          if (!bt.isNullOrNil(paramString.nUX.nTK)) {
            Toast.makeText(QrRewardGrantUI.this, paramString.nUX.nTK, 0).show();
          }
          if (QrRewardGrantUI.e(QrRewardGrantUI.this)) {
            QrRewardGrantUI.this.hideLoading();
          }
          AppMethodBeat.o(63927);
        }
      }).c(new a.a()
      {
        public final void h(n paramAnonymousn)
        {
          AppMethodBeat.i(63926);
          ad.e("MicroMsg.QrRewardGrantUI", "net error: %s", new Object[] { paramAnonymousn });
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