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
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.gu;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.d;
import com.tencent.mm.plugin.collect.reward.a.e;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.wt;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.g;

public class QrRewardGrantUI
  extends QrRewardBaseUI
{
  private int channel;
  private String fwv;
  private RadioButton md;
  private String ozt;
  private String tUC;
  private CdnImageView tWN;
  private TextView tWO;
  private TextView tWP;
  private WalletTextView tWQ;
  private LinearLayout tWR;
  private WalletFormView tWS;
  private MMEditText tWT;
  private Button tWU;
  private int tWV;
  private int tWW;
  private String tWX;
  private String tWY;
  private String tWZ;
  private String tXa;
  private String tXb;
  private String tXc;
  private String tXd;
  private String tXe;
  private String tXf;
  private int tXg;
  private String tXh;
  private String tXi;
  private IListener<gu> tXj;
  
  public QrRewardGrantUI()
  {
    AppMethodBeat.i(63931);
    this.tXj = new IListener() {};
    AppMethodBeat.o(63931);
  }
  
  private void fT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63937);
    Log.i("MicroMsg.QrRewardGrantUI", "do pay check");
    if (Util.isNullOrNil(this.fwv)) {
      this.fwv = paramString1;
    }
    if (Util.isNullOrNil(this.tUC)) {
      this.tUC = paramString2;
    }
    doSceneProgress(new d(this.fwv, this.tWY, this.tUC, this.tWV, this.tWZ, this.tXa), false);
    AppMethodBeat.o(63937);
  }
  
  public int getLayoutId()
  {
    return a.g.qr_reward_grant_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(63933);
    this.tWN = ((CdnImageView)findViewById(a.f.qrgu_avatar_iv));
    this.tWO = ((TextView)findViewById(a.f.qrgu_desc_tv));
    this.tWQ = ((WalletTextView)findViewById(a.f.qrgu_fixed_money_tv));
    this.tWR = ((LinearLayout)findViewById(a.f.qrgu_fixed_layout));
    this.tWS = ((WalletFormView)findViewById(a.f.qrgu_edit_money_et));
    this.tWT = ((MMEditText)findViewById(a.f.qrgu_edit_word_et));
    this.tWU = ((Button)findViewById(a.f.qrgu_grant_btn));
    this.tWP = ((TextView)findViewById(a.f.qrgu_alert_tv));
    this.md = ((RadioButton)findViewById(a.f.radio_check));
    this.md.setChecked(true);
    this.tWP.setText(getString(a.i.qr_reward_set_money_exceed_text, new Object[] { Math.round(this.tXg / 100.0F) }));
    String str;
    if (Util.isNullOrNil(this.tXi))
    {
      a.b.a(this.tWN, this.tXb, 0.03F, false);
      if (!Util.isNullOrNil(this.tXh)) {
        break label423;
      }
      str = g.ic(g.PJ(this.tXb), 10);
      label234:
      this.tWO.setText(l.c(this, getString(a.i.qr_reward_grant_username_wrap_text, new Object[] { str })));
      if (this.tWW != 2) {
        break label431;
      }
      Log.i("MicroMsg.QrRewardGrantUI", "edit layout");
      setEditFocusListener(this.tWS, 2, false);
      this.tWS.a(new TextWatcher()
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
            i = (int)Math.round(Util.getDouble(paramAnonymousEditable.toString(), 0.0D) * 100.0D);
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
      this.tWS.setVisibility(0);
      this.tWR.setVisibility(8);
      this.tWS.ijE();
      this.tWU.setEnabled(false);
    }
    for (;;)
    {
      this.tWU.setOnClickListener(new aa()
      {
        public final void cOw()
        {
          AppMethodBeat.i(63924);
          int i = (int)Math.round(Util.getDouble(QrRewardGrantUI.a(QrRewardGrantUI.this).getText(), 0.0D) * 100.0D);
          if (QrRewardGrantUI.a(QrRewardGrantUI.this, i)) {
            QrRewardGrantUI.b(QrRewardGrantUI.this);
          }
          AppMethodBeat.o(63924);
        }
      });
      findViewById(a.f.radio_check_ll).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(63925);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/collect/reward/ui/QrRewardGrantUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          boolean bool = QrRewardGrantUI.c(QrRewardGrantUI.this).isChecked();
          paramAnonymousView = QrRewardGrantUI.c(QrRewardGrantUI.this);
          if (!bool) {}
          for (bool = true;; bool = false)
          {
            paramAnonymousView.setChecked(bool);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/reward/ui/QrRewardGrantUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(63925);
            return;
          }
        }
      });
      this.md.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean) {}
      });
      AppMethodBeat.o(63933);
      return;
      int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 50.0F);
      this.tWN.setRoundCorner(true);
      this.tWN.w(this.tXi, i, i, a.e.default_avatar);
      break;
      label423:
      str = this.tXh;
      break label234;
      label431:
      this.tWQ.setText(g.formatMoney2f(this.tWV / 100.0D));
      this.tWS.setVisibility(8);
      this.tWR.setVisibility(0);
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
          fT(paramIntent.getStringExtra("key_reqKey"), paramIntent.getStringExtra("key_trans_id"));
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
    this.tXj.alive();
    setMMTitle(a.i.qr_reward_grant_title);
    this.tWV = getIntent().getIntExtra("key_money_amt", 20000);
    this.tWW = getIntent().getIntExtra("key_amt_type", 0);
    this.tWX = getIntent().getStringExtra("key_qrcode_desc");
    this.channel = getIntent().getIntExtra("key_channel", 0);
    this.tWZ = getIntent().getStringExtra("key_rcvr_open_id");
    this.tXb = getIntent().getStringExtra("key_rcvr_name");
    this.tXc = getIntent().getStringExtra("key_rcvr_true_name");
    this.tXd = getIntent().getStringExtra("key_scan_id");
    this.ozt = getIntent().getStringExtra("key_web_url");
    this.tXe = getIntent().getStringExtra("key_sxtend_1");
    this.tXf = getIntent().getStringExtra("key_sxtend_2");
    this.tXg = getIntent().getIntExtra("key_max_amt", 20000);
    this.tXh = getIntent().getStringExtra("key_receiver_nickname");
    this.tXi = getIntent().getStringExtra("key_photo_url");
    Log.i("MicroMsg.QrRewardGrantUI", "amtType: %s, channel: %s, maxAmt: %s", new Object[] { Integer.valueOf(this.tWW), Integer.valueOf(this.channel), Integer.valueOf(this.tXg) });
    initView();
    com.tencent.mm.wallet_core.b.iie();
    this.mKindaEnable = com.tencent.mm.wallet_core.b.b(b.a.vCG, true);
    AppMethodBeat.o(63932);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(63935);
    super.onDestroy();
    removeSceneEndListener(1336);
    this.tXj.dead();
    AppMethodBeat.o(63935);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(63934);
    if ((paramq instanceof e))
    {
      paramString = (e)paramq;
      paramString.a(new a.a()
      {
        public final void g(q paramAnonymousq)
        {
          AppMethodBeat.i(63929);
          QrRewardGrantUI.a(QrRewardGrantUI.this, paramString.tWE.fHb);
          QrRewardGrantUI.b(QrRewardGrantUI.this, paramString.tWE.SiO);
          QrRewardGrantUI.c(QrRewardGrantUI.this, paramString.tWE.InV);
          QrRewardGrantUI.d(QrRewardGrantUI.this, paramString.tWE.SiN);
          QrRewardGrantUI.e(QrRewardGrantUI.this, paramString.tWE.SiM);
          Log.i("MicroMsg.QrRewardGrantUI", "remind str: %s", new Object[] { paramString.tWE.Sjb });
          if (!Util.isNullOrNil(paramString.tWE.Sjb))
          {
            h.c(QrRewardGrantUI.this.getContext(), paramString.tWE.Sjb, "", QrRewardGrantUI.this.getString(a.i.remittance_continue), QrRewardGrantUI.this.getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(63928);
                QrRewardGrantUI.f(QrRewardGrantUI.this);
                AppMethodBeat.o(63928);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(272881);
                if (QrRewardGrantUI.g(QrRewardGrantUI.this)) {
                  QrRewardGrantUI.this.hideLoading();
                }
                AppMethodBeat.o(272881);
              }
            });
            AppMethodBeat.o(63929);
            return;
          }
          QrRewardGrantUI.f(QrRewardGrantUI.this);
          AppMethodBeat.o(63929);
        }
      }).b(new a.a()
      {
        public final void g(q paramAnonymousq)
        {
          AppMethodBeat.i(63927);
          Log.e("MicroMsg.QrRewardGrantUI", "place order error: %s, %s", new Object[] { Integer.valueOf(paramString.tWE.fwx), paramString.tWE.tVo });
          if (!Util.isNullOrNil(paramString.tWE.tVo)) {
            Toast.makeText(QrRewardGrantUI.this, paramString.tWE.tVo, 0).show();
          }
          if (QrRewardGrantUI.e(QrRewardGrantUI.this)) {
            QrRewardGrantUI.this.hideLoading();
          }
          AppMethodBeat.o(63927);
        }
      }).c(new a.a()
      {
        public final void g(q paramAnonymousq)
        {
          AppMethodBeat.i(63926);
          Log.e("MicroMsg.QrRewardGrantUI", "net error: %s", new Object[] { paramAnonymousq });
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