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
import com.tencent.mm.g.a.gk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.d;
import com.tencent.mm.plugin.collect.reward.a.e;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.vh;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class QrRewardGrantUI
  extends QrRewardBaseUI
{
  private RadioButton afG;
  private int channel;
  private String dmw;
  private String kzz;
  private String pgs;
  private CdnImageView piC;
  private TextView piD;
  private TextView piE;
  private WalletTextView piF;
  private LinearLayout piG;
  private WalletFormView piH;
  private MMEditText piI;
  private Button piJ;
  private int piK;
  private int piL;
  private String piM;
  private String piN;
  private String piO;
  private String piP;
  private String piQ;
  private String piR;
  private String piS;
  private String piT;
  private String piU;
  private int piV;
  private String piW;
  private String piX;
  private c<gk> piY;
  
  public QrRewardGrantUI()
  {
    AppMethodBeat.i(63931);
    this.piY = new c() {};
    AppMethodBeat.o(63931);
  }
  
  private void fo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63937);
    ae.i("MicroMsg.QrRewardGrantUI", "do pay check");
    if (bu.isNullOrNil(this.dmw)) {
      this.dmw = paramString1;
    }
    if (bu.isNullOrNil(this.pgs)) {
      this.pgs = paramString2;
    }
    doSceneProgress(new d(this.dmw, this.piN, this.pgs, this.piK, this.piO, this.piP), false);
    AppMethodBeat.o(63937);
  }
  
  public int getLayoutId()
  {
    return 2131495161;
  }
  
  public void initView()
  {
    AppMethodBeat.i(63933);
    this.piC = ((CdnImageView)findViewById(2131303629));
    this.piD = ((TextView)findViewById(2131303630));
    this.piF = ((WalletTextView)findViewById(2131303634));
    this.piG = ((LinearLayout)findViewById(2131303633));
    this.piH = ((WalletFormView)findViewById(2131303631));
    this.piI = ((MMEditText)findViewById(2131303632));
    this.piJ = ((Button)findViewById(2131303635));
    this.piE = ((TextView)findViewById(2131303628));
    this.afG = ((RadioButton)findViewById(2131303705));
    this.afG.setChecked(true);
    this.piE.setText(getString(2131762108, new Object[] { Math.round(this.piV / 100.0F) }));
    String str;
    if (bu.isNullOrNil(this.piX))
    {
      a.b.a(this.piC, this.piQ, 0.03F, false);
      if (!bu.isNullOrNil(this.piW)) {
        break label423;
      }
      str = f.gX(f.zP(this.piQ), 10);
      label234:
      this.piD.setText(k.c(this, getString(2131762094, new Object[] { str })));
      if (this.piL != 2) {
        break label431;
      }
      ae.i("MicroMsg.QrRewardGrantUI", "edit layout");
      setEditFocusListener(this.piH, 2, false);
      this.piH.a(new TextWatcher()
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
            i = (int)Math.round(bu.getDouble(paramAnonymousEditable.toString(), 0.0D) * 100.0D);
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
      this.piH.setVisibility(0);
      this.piG.setVisibility(8);
      this.piH.fWE();
      this.piJ.setEnabled(false);
    }
    for (;;)
    {
      this.piJ.setOnClickListener(new w()
      {
        public final void ccc()
        {
          AppMethodBeat.i(63924);
          int i = (int)Math.round(bu.getDouble(QrRewardGrantUI.a(QrRewardGrantUI.this).getText(), 0.0D) * 100.0D);
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
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/reward/ui/QrRewardGrantUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
      this.afG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean) {}
      });
      AppMethodBeat.o(63933);
      return;
      int i = BackwardSupportUtil.b.h(this, 50.0F);
      this.piC.setRoundCorner(true);
      this.piC.r(this.piX, i, i, 2131231875);
      break;
      label423:
      str = this.piW;
      break label234;
      label431:
      this.piF.setText(f.C(this.piK / 100.0D));
      this.piH.setVisibility(8);
      this.piG.setVisibility(0);
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
          fo(paramIntent.getStringExtra("key_reqKey"), paramIntent.getStringExtra("key_trans_id"));
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
    this.piY.alive();
    setMMTitle(2131762093);
    this.piK = getIntent().getIntExtra("key_money_amt", 20000);
    this.piL = getIntent().getIntExtra("key_amt_type", 0);
    this.piM = getIntent().getStringExtra("key_qrcode_desc");
    this.channel = getIntent().getIntExtra("key_channel", 0);
    this.piO = getIntent().getStringExtra("key_rcvr_open_id");
    this.piQ = getIntent().getStringExtra("key_rcvr_name");
    this.piR = getIntent().getStringExtra("key_rcvr_true_name");
    this.piS = getIntent().getStringExtra("key_scan_id");
    this.kzz = getIntent().getStringExtra("key_web_url");
    this.piT = getIntent().getStringExtra("key_sxtend_1");
    this.piU = getIntent().getStringExtra("key_sxtend_2");
    this.piV = getIntent().getIntExtra("key_max_amt", 20000);
    this.piW = getIntent().getStringExtra("key_receiver_nickname");
    this.piX = getIntent().getStringExtra("key_photo_url");
    ae.i("MicroMsg.QrRewardGrantUI", "amtType: %s, channel: %s, maxAmt: %s", new Object[] { Integer.valueOf(this.piL), Integer.valueOf(this.channel), Integer.valueOf(this.piV) });
    initView();
    com.tencent.mm.wallet_core.b.fVf();
    if ((com.tencent.mm.wallet_core.b.b(b.a.qDk, true)) && (((com.tencent.mm.pluginsdk.wallet.a)g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_REWARD_CODE_PAY_SWTICH_KEY"))) {}
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
    this.piY.dead();
    AppMethodBeat.o(63935);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(63934);
    if ((paramn instanceof e))
    {
      paramString = (e)paramn;
      paramString.a(new a.a()
      {
        public final void g(n paramAnonymousn)
        {
          AppMethodBeat.i(63929);
          QrRewardGrantUI.a(QrRewardGrantUI.this, paramString.pit.dwj);
          QrRewardGrantUI.b(QrRewardGrantUI.this, paramString.pit.GmX);
          QrRewardGrantUI.c(QrRewardGrantUI.this, paramString.pit.FOg);
          QrRewardGrantUI.d(QrRewardGrantUI.this, paramString.pit.GmV);
          QrRewardGrantUI.e(QrRewardGrantUI.this, paramString.pit.GmU);
          ae.i("MicroMsg.QrRewardGrantUI", "remind str: %s", new Object[] { paramString.pit.Gnj });
          if (!bu.isNullOrNil(paramString.pit.Gnj))
          {
            h.e(QrRewardGrantUI.this.getContext(), paramString.pit.Gnj, "", QrRewardGrantUI.this.getString(2131762444), QrRewardGrantUI.this.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
          ae.e("MicroMsg.QrRewardGrantUI", "place order error: %s, %s", new Object[] { Integer.valueOf(paramString.pit.dmy), paramString.pit.phe });
          if (!bu.isNullOrNil(paramString.pit.phe)) {
            Toast.makeText(QrRewardGrantUI.this, paramString.pit.phe, 0).show();
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
          ae.e("MicroMsg.QrRewardGrantUI", "net error: %s", new Object[] { paramAnonymousn });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardGrantUI
 * JD-Core Version:    0.7.0.1
 */