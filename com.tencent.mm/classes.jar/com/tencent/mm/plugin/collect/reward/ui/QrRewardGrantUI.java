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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.gn;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.d;
import com.tencent.mm.plugin.collect.reward.a.e;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.wp;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.x;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class QrRewardGrantUI
  extends QrRewardBaseUI
{
  private RadioButton afT;
  private int channel;
  private String dDL;
  private String lDS;
  private String qvD;
  private CdnImageView qxN;
  private TextView qxO;
  private TextView qxP;
  private WalletTextView qxQ;
  private LinearLayout qxR;
  private WalletFormView qxS;
  private MMEditText qxT;
  private Button qxU;
  private int qxV;
  private int qxW;
  private String qxX;
  private String qxY;
  private String qxZ;
  private String qya;
  private String qyb;
  private String qyc;
  private String qyd;
  private String qye;
  private String qyf;
  private int qyg;
  private String qyh;
  private String qyi;
  private IListener<gn> qyj;
  
  public QrRewardGrantUI()
  {
    AppMethodBeat.i(63931);
    this.qyj = new IListener() {};
    AppMethodBeat.o(63931);
  }
  
  private void fF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63937);
    Log.i("MicroMsg.QrRewardGrantUI", "do pay check");
    if (Util.isNullOrNil(this.dDL)) {
      this.dDL = paramString1;
    }
    if (Util.isNullOrNil(this.qvD)) {
      this.qvD = paramString2;
    }
    doSceneProgress(new d(this.dDL, this.qxY, this.qvD, this.qxV, this.qxZ, this.qya), false);
    AppMethodBeat.o(63937);
  }
  
  public int getLayoutId()
  {
    return 2131496004;
  }
  
  public void initView()
  {
    AppMethodBeat.i(63933);
    this.qxN = ((CdnImageView)findViewById(2131306408));
    this.qxO = ((TextView)findViewById(2131306409));
    this.qxQ = ((WalletTextView)findViewById(2131306413));
    this.qxR = ((LinearLayout)findViewById(2131306412));
    this.qxS = ((WalletFormView)findViewById(2131306410));
    this.qxT = ((MMEditText)findViewById(2131306411));
    this.qxU = ((Button)findViewById(2131306414));
    this.qxP = ((TextView)findViewById(2131306407));
    this.afT = ((RadioButton)findViewById(2131306491));
    this.afT.setChecked(true);
    this.qxP.setText(getString(2131764129, new Object[] { Math.round(this.qyg / 100.0F) }));
    String str;
    if (Util.isNullOrNil(this.qyi))
    {
      a.b.a(this.qxN, this.qyb, 0.03F, false);
      if (!Util.isNullOrNil(this.qyh)) {
        break label423;
      }
      str = f.hs(f.getDisplayName(this.qyb), 10);
      label234:
      this.qxO.setText(l.c(this, getString(2131764115, new Object[] { str })));
      if (this.qxW != 2) {
        break label431;
      }
      Log.i("MicroMsg.QrRewardGrantUI", "edit layout");
      setEditFocusListener(this.qxS, 2, false);
      this.qxS.a(new TextWatcher()
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
      this.qxS.setVisibility(0);
      this.qxR.setVisibility(8);
      this.qxS.hic();
      this.qxU.setEnabled(false);
    }
    for (;;)
    {
      this.qxU.setOnClickListener(new x()
      {
        public final void czW()
        {
          AppMethodBeat.i(63924);
          int i = (int)Math.round(Util.getDouble(QrRewardGrantUI.a(QrRewardGrantUI.this).getText(), 0.0D) * 100.0D);
          if (QrRewardGrantUI.a(QrRewardGrantUI.this, i)) {
            QrRewardGrantUI.b(QrRewardGrantUI.this);
          }
          AppMethodBeat.o(63924);
        }
      });
      findViewById(2131306492).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(63925);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/reward/ui/QrRewardGrantUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
      this.afT.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean) {}
      });
      AppMethodBeat.o(63933);
      return;
      int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 50.0F);
      this.qxN.setRoundCorner(true);
      this.qxN.s(this.qyi, i, i, 2131231957);
      break;
      label423:
      str = this.qyh;
      break label234;
      label431:
      this.qxQ.setText(f.formatMoney2f(this.qxV / 100.0D));
      this.qxS.setVisibility(8);
      this.qxR.setVisibility(0);
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
          fF(paramIntent.getStringExtra("key_reqKey"), paramIntent.getStringExtra("key_trans_id"));
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
    this.qyj.alive();
    setMMTitle(2131764114);
    this.qxV = getIntent().getIntExtra("key_money_amt", 20000);
    this.qxW = getIntent().getIntExtra("key_amt_type", 0);
    this.qxX = getIntent().getStringExtra("key_qrcode_desc");
    this.channel = getIntent().getIntExtra("key_channel", 0);
    this.qxZ = getIntent().getStringExtra("key_rcvr_open_id");
    this.qyb = getIntent().getStringExtra("key_rcvr_name");
    this.qyc = getIntent().getStringExtra("key_rcvr_true_name");
    this.qyd = getIntent().getStringExtra("key_scan_id");
    this.lDS = getIntent().getStringExtra("key_web_url");
    this.qye = getIntent().getStringExtra("key_sxtend_1");
    this.qyf = getIntent().getStringExtra("key_sxtend_2");
    this.qyg = getIntent().getIntExtra("key_max_amt", 20000);
    this.qyh = getIntent().getStringExtra("key_receiver_nickname");
    this.qyi = getIntent().getStringExtra("key_photo_url");
    Log.i("MicroMsg.QrRewardGrantUI", "amtType: %s, channel: %s, maxAmt: %s", new Object[] { Integer.valueOf(this.qxW), Integer.valueOf(this.channel), Integer.valueOf(this.qyg) });
    initView();
    com.tencent.mm.wallet_core.b.hgC();
    this.mKindaEnable = com.tencent.mm.wallet_core.b.b(b.a.rWd, true);
    AppMethodBeat.o(63932);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(63935);
    super.onDestroy();
    removeSceneEndListener(1336);
    this.qyj.dead();
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
          QrRewardGrantUI.a(QrRewardGrantUI.this, paramString.qxE.dNQ);
          QrRewardGrantUI.b(QrRewardGrantUI.this, paramString.qxE.LhB);
          QrRewardGrantUI.c(QrRewardGrantUI.this, paramString.qxE.KHN);
          QrRewardGrantUI.d(QrRewardGrantUI.this, paramString.qxE.Lhz);
          QrRewardGrantUI.e(QrRewardGrantUI.this, paramString.qxE.Lhy);
          Log.i("MicroMsg.QrRewardGrantUI", "remind str: %s", new Object[] { paramString.qxE.LhN });
          if (!Util.isNullOrNil(paramString.qxE.LhN))
          {
            h.c(QrRewardGrantUI.this.getContext(), paramString.qxE.LhN, "", QrRewardGrantUI.this.getString(2131764510), QrRewardGrantUI.this.getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
                AppMethodBeat.i(213158);
                if (QrRewardGrantUI.g(QrRewardGrantUI.this)) {
                  QrRewardGrantUI.this.hideLoading();
                }
                AppMethodBeat.o(213158);
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
          Log.e("MicroMsg.QrRewardGrantUI", "place order error: %s, %s", new Object[] { Integer.valueOf(paramString.qxE.dDN), paramString.qxE.qwn });
          if (!Util.isNullOrNil(paramString.qxE.qwn)) {
            Toast.makeText(QrRewardGrantUI.this, paramString.qxE.qwn, 0).show();
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