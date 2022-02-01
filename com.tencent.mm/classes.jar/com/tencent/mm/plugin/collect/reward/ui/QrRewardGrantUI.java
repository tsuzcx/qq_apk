package com.tencent.mm.plugin.collect.reward.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.hf;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.d;
import com.tencent.mm.plugin.collect.reward.a.e;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.dus;
import com.tencent.mm.protocal.protobuf.yl;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ac;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.WcPayBannerView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.i;

public class QrRewardGrantUI
  extends QrRewardBaseUI
{
  private int channel;
  private String hAT;
  private RadioButton nc;
  private WcPayBannerView pLM;
  private String rDm;
  private String wXY;
  private String xaA;
  private dus xaB;
  private IListener<hf> xaC;
  private CdnImageView xaf;
  private TextView xag;
  private TextView xah;
  private WalletTextView xai;
  private LinearLayout xaj;
  private WalletFormView xak;
  private MMEditText xal;
  private Button xam;
  private int xan;
  private int xao;
  private String xap;
  private String xaq;
  private String xar;
  private String xas;
  private String xat;
  private String xau;
  private String xav;
  private String xaw;
  private String xax;
  private int xay;
  private String xaz;
  
  public QrRewardGrantUI()
  {
    AppMethodBeat.i(63931);
    this.xaC = new IListener(f.hfK) {};
    AppMethodBeat.o(63931);
  }
  
  private void gs(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63937);
    Log.i("MicroMsg.QrRewardGrantUI", "do pay check");
    if (Util.isNullOrNil(this.hAT)) {
      this.hAT = paramString1;
    }
    if (Util.isNullOrNil(this.wXY)) {
      this.wXY = paramString2;
    }
    doSceneProgress(new d(this.hAT, this.xaq, this.wXY, this.xan, this.xar, this.xas), false);
    AppMethodBeat.o(63937);
  }
  
  public int getLayoutId()
  {
    return a.g.qr_reward_grant_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(63933);
    this.xaf = ((CdnImageView)findViewById(a.f.qrgu_avatar_iv));
    this.xag = ((TextView)findViewById(a.f.qrgu_desc_tv));
    this.xai = ((WalletTextView)findViewById(a.f.qrgu_fixed_money_tv));
    this.xaj = ((LinearLayout)findViewById(a.f.qrgu_fixed_layout));
    this.xak = ((WalletFormView)findViewById(a.f.qrgu_edit_money_et));
    this.xal = ((MMEditText)findViewById(a.f.qrgu_edit_word_et));
    this.xam = ((Button)findViewById(a.f.qrgu_grant_btn));
    this.xah = ((TextView)findViewById(a.f.qrgu_alert_tv));
    this.pLM = ((WcPayBannerView)findViewById(a.f.wc_pay_banner_layout));
    this.pLM.jPz();
    this.nc = ((RadioButton)findViewById(a.f.radio_check));
    this.nc.setChecked(true);
    this.xah.setText(getString(a.i.qr_reward_set_money_exceed_text, new Object[] { Math.round(this.xay / 100.0F) }));
    String str;
    if (Util.isNullOrNil(this.xaA))
    {
      a.b.a(this.xaf, this.xat, 0.03F, false);
      if (!Util.isNullOrNil(this.xaz)) {
        break label444;
      }
      str = i.jo(i.getDisplayName(this.xat), 10);
      label255:
      this.xag.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, getString(a.i.qr_reward_grant_username_wrap_text, new Object[] { str })));
      if (this.xao != 2) {
        break label452;
      }
      Log.i("MicroMsg.QrRewardGrantUI", "edit layout");
      setEditFocusListener(this.xak, 2, false);
      this.xak.a(new TextWatcher()
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
      this.xak.setVisibility(0);
      this.xaj.setVisibility(8);
      this.xak.jPE();
      this.xam.setEnabled(false);
    }
    for (;;)
    {
      this.xam.setOnClickListener(new ac()
      {
        public final void dsb()
        {
          AppMethodBeat.i(63924);
          int i = (int)Math.round(Util.getDouble(QrRewardGrantUI.a(QrRewardGrantUI.this).getText(), 0.0D) * 100.0D);
          if (QrRewardGrantUI.a(QrRewardGrantUI.this, i)) {
            QrRewardGrantUI.b(QrRewardGrantUI.this);
          }
          AppMethodBeat.o(63924);
        }
      });
      findViewById(a.f.radio_check_ll).setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(293684);
          boolean bool = QrRewardGrantUI.c(QrRewardGrantUI.this).isChecked();
          paramAnonymousView = QrRewardGrantUI.c(QrRewardGrantUI.this);
          if (!bool) {}
          for (bool = true;; bool = false)
          {
            paramAnonymousView.setChecked(bool);
            AppMethodBeat.o(293684);
            return;
          }
        }
      });
      this.nc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean) {}
      });
      AppMethodBeat.o(63933);
      return;
      int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 50.0F);
      this.xaf.setRoundCorner(true);
      this.xaf.w(this.xaA, i, i, a.e.default_avatar);
      break;
      label444:
      str = this.xaz;
      break label255;
      label452:
      this.xai.setText(i.formatMoney2f(this.xan / 100.0D));
      this.xak.setVisibility(8);
      this.xaj.setVisibility(0);
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
          gs(paramIntent.getStringExtra("key_reqKey"), paramIntent.getStringExtra("key_trans_id"));
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
    this.xaC.alive();
    setMMTitle(a.i.qr_reward_grant_title);
    this.xan = getIntent().getIntExtra("key_money_amt", 20000);
    this.xao = getIntent().getIntExtra("key_amt_type", 0);
    this.xap = getIntent().getStringExtra("key_qrcode_desc");
    this.channel = getIntent().getIntExtra("key_channel", 0);
    this.xar = getIntent().getStringExtra("key_rcvr_open_id");
    this.xat = getIntent().getStringExtra("key_rcvr_name");
    this.xau = getIntent().getStringExtra("key_rcvr_true_name");
    this.xav = getIntent().getStringExtra("key_scan_id");
    this.rDm = getIntent().getStringExtra("key_web_url");
    this.xaw = getIntent().getStringExtra("key_sxtend_1");
    this.xax = getIntent().getStringExtra("key_sxtend_2");
    this.xay = getIntent().getIntExtra("key_max_amt", 20000);
    this.xaz = getIntent().getStringExtra("key_receiver_nickname");
    this.xaA = getIntent().getStringExtra("key_photo_url");
    paramBundle = getIntent().getStringExtra("key_notice_item");
    dus localdus;
    if (!Util.isNullOrNil(paramBundle)) {
      localdus = new dus();
    }
    try
    {
      localdus.parseFrom(com.tencent.mm.plugin.wallet_index.b.a.a.decode(paramBundle));
      this.xaB = localdus;
      Log.i("MicroMsg.QrRewardGrantUI", "amtType: %s, channel: %s, maxAmt: %s", new Object[] { Integer.valueOf(this.xao), Integer.valueOf(this.channel), Integer.valueOf(this.xay) });
      initView();
      this.pLM.setBannerData(this.xaB);
      b.jNX();
      this.mKindaEnable = b.b(c.a.yRc, true);
      AppMethodBeat.o(63932);
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.QrRewardGrantUI", paramBundle, "", new Object[0]);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(63935);
    super.onDestroy();
    removeSceneEndListener(1336);
    this.xaC.dead();
    AppMethodBeat.o(63935);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(63934);
    if ((paramp instanceof e))
    {
      paramString = (e)paramp;
      paramString.a(new a.a()
      {
        public final void g(com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(63929);
          QrRewardGrantUI.a(QrRewardGrantUI.this, paramString.wZW.hMy);
          QrRewardGrantUI.b(QrRewardGrantUI.this, paramString.wZW.ZgU);
          QrRewardGrantUI.c(QrRewardGrantUI.this, paramString.wZW.Oln);
          QrRewardGrantUI.d(QrRewardGrantUI.this, paramString.wZW.ZgT);
          QrRewardGrantUI.e(QrRewardGrantUI.this, paramString.wZW.ZgS);
          Log.i("MicroMsg.QrRewardGrantUI", "remind str: %s", new Object[] { paramString.wZW.Zhh });
          if (!Util.isNullOrNil(paramString.wZW.Zhh))
          {
            com.tencent.mm.ui.base.k.b(QrRewardGrantUI.this.getContext(), paramString.wZW.Zhh, "", QrRewardGrantUI.this.getString(a.i.remittance_continue), QrRewardGrantUI.this.getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
                AppMethodBeat.i(293681);
                if (QrRewardGrantUI.g(QrRewardGrantUI.this)) {
                  QrRewardGrantUI.this.hideLoading();
                }
                AppMethodBeat.o(293681);
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
        public final void g(com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(63927);
          Log.e("MicroMsg.QrRewardGrantUI", "place order error: %s, %s", new Object[] { Integer.valueOf(paramString.wZW.hAV), paramString.wZW.wYI });
          if (!Util.isNullOrNil(paramString.wZW.wYI)) {
            Toast.makeText(QrRewardGrantUI.this, paramString.wZW.wYI, 0).show();
          }
          if (QrRewardGrantUI.e(QrRewardGrantUI.this)) {
            QrRewardGrantUI.this.hideLoading();
          }
          AppMethodBeat.o(63927);
        }
      }).c(new a.a()
      {
        public final void g(com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(63926);
          Log.e("MicroMsg.QrRewardGrantUI", "net error: %s", new Object[] { paramAnonymousp });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardGrantUI
 * JD-Core Version:    0.7.0.1
 */