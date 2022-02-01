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
import com.tencent.mm.g.a.gj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.d;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.vf;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class QrRewardGrantUI
  extends QrRewardBaseUI
{
  private RadioButton afG;
  private int channel;
  private String dlu;
  private String kwk;
  private String oZO;
  private CdnImageView pbW;
  private TextView pbX;
  private TextView pbY;
  private WalletTextView pbZ;
  private LinearLayout pca;
  private WalletFormView pcb;
  private MMEditText pcc;
  private Button pcd;
  private int pce;
  private int pcf;
  private String pcg;
  private String pch;
  private String pci;
  private String pcj;
  private String pck;
  private String pcl;
  private String pcm;
  private String pcn;
  private String pco;
  private int pcp;
  private String pcq;
  private String pcr;
  private c<gj> pcs;
  
  public QrRewardGrantUI()
  {
    AppMethodBeat.i(63931);
    this.pcs = new c() {};
    AppMethodBeat.o(63931);
  }
  
  private void fk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63937);
    ad.i("MicroMsg.QrRewardGrantUI", "do pay check");
    if (bt.isNullOrNil(this.dlu)) {
      this.dlu = paramString1;
    }
    if (bt.isNullOrNil(this.oZO)) {
      this.oZO = paramString2;
    }
    doSceneProgress(new d(this.dlu, this.pch, this.oZO, this.pce, this.pci, this.pcj), false);
    AppMethodBeat.o(63937);
  }
  
  public int getLayoutId()
  {
    return 2131495161;
  }
  
  public void initView()
  {
    AppMethodBeat.i(63933);
    this.pbW = ((CdnImageView)findViewById(2131303629));
    this.pbX = ((TextView)findViewById(2131303630));
    this.pbZ = ((WalletTextView)findViewById(2131303634));
    this.pca = ((LinearLayout)findViewById(2131303633));
    this.pcb = ((WalletFormView)findViewById(2131303631));
    this.pcc = ((MMEditText)findViewById(2131303632));
    this.pcd = ((Button)findViewById(2131303635));
    this.pbY = ((TextView)findViewById(2131303628));
    this.afG = ((RadioButton)findViewById(2131303705));
    this.afG.setChecked(true);
    this.pbY.setText(getString(2131762108, new Object[] { Math.round(this.pcp / 100.0F) }));
    String str;
    if (bt.isNullOrNil(this.pcr))
    {
      a.b.a(this.pbW, this.pck, 0.03F, false);
      if (!bt.isNullOrNil(this.pcq)) {
        break label423;
      }
      str = com.tencent.mm.wallet_core.ui.e.gO(com.tencent.mm.wallet_core.ui.e.zf(this.pck), 10);
      label234:
      this.pbX.setText(k.c(this, getString(2131762094, new Object[] { str })));
      if (this.pcf != 2) {
        break label431;
      }
      ad.i("MicroMsg.QrRewardGrantUI", "edit layout");
      setEditFocusListener(this.pcb, 2, false);
      this.pcb.a(new TextWatcher()
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
      this.pcb.setVisibility(0);
      this.pca.setVisibility(8);
      this.pcb.fSi();
      this.pcd.setEnabled(false);
    }
    for (;;)
    {
      this.pcd.setOnClickListener(new w()
      {
        public final void caN()
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
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/reward/ui/QrRewardGrantUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
      int i = BackwardSupportUtil.b.g(this, 50.0F);
      this.pbW.setRoundCorner(true);
      this.pbW.r(this.pcr, i, i, 2131231875);
      break;
      label423:
      str = this.pcq;
      break label234;
      label431:
      this.pbZ.setText(com.tencent.mm.wallet_core.ui.e.C(this.pce / 100.0D));
      this.pcb.setVisibility(8);
      this.pca.setVisibility(0);
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
          fk(paramIntent.getStringExtra("key_reqKey"), paramIntent.getStringExtra("key_trans_id"));
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
    this.pcs.alive();
    setMMTitle(2131762093);
    this.pce = getIntent().getIntExtra("key_money_amt", 20000);
    this.pcf = getIntent().getIntExtra("key_amt_type", 0);
    this.pcg = getIntent().getStringExtra("key_qrcode_desc");
    this.channel = getIntent().getIntExtra("key_channel", 0);
    this.pci = getIntent().getStringExtra("key_rcvr_open_id");
    this.pck = getIntent().getStringExtra("key_rcvr_name");
    this.pcl = getIntent().getStringExtra("key_rcvr_true_name");
    this.pcm = getIntent().getStringExtra("key_scan_id");
    this.kwk = getIntent().getStringExtra("key_web_url");
    this.pcn = getIntent().getStringExtra("key_sxtend_1");
    this.pco = getIntent().getStringExtra("key_sxtend_2");
    this.pcp = getIntent().getIntExtra("key_max_amt", 20000);
    this.pcq = getIntent().getStringExtra("key_receiver_nickname");
    this.pcr = getIntent().getStringExtra("key_photo_url");
    ad.i("MicroMsg.QrRewardGrantUI", "amtType: %s, channel: %s, maxAmt: %s", new Object[] { Integer.valueOf(this.pcf), Integer.valueOf(this.channel), Integer.valueOf(this.pcp) });
    initView();
    com.tencent.mm.wallet_core.b.fQJ();
    if ((com.tencent.mm.wallet_core.b.b(b.a.qwl, true)) && (((com.tencent.mm.pluginsdk.wallet.a)g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_REWARD_CODE_PAY_SWTICH_KEY"))) {}
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
    this.pcs.dead();
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
          QrRewardGrantUI.a(QrRewardGrantUI.this, paramString.pbN.dve);
          QrRewardGrantUI.b(QrRewardGrantUI.this, paramString.pbN.FUy);
          QrRewardGrantUI.c(QrRewardGrantUI.this, paramString.pbN.FvI);
          QrRewardGrantUI.d(QrRewardGrantUI.this, paramString.pbN.FUw);
          QrRewardGrantUI.e(QrRewardGrantUI.this, paramString.pbN.FUv);
          ad.i("MicroMsg.QrRewardGrantUI", "remind str: %s", new Object[] { paramString.pbN.FUK });
          if (!bt.isNullOrNil(paramString.pbN.FUK))
          {
            h.e(QrRewardGrantUI.this.getContext(), paramString.pbN.FUK, "", QrRewardGrantUI.this.getString(2131762444), QrRewardGrantUI.this.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
          ad.e("MicroMsg.QrRewardGrantUI", "place order error: %s, %s", new Object[] { Integer.valueOf(paramString.pbN.dlw), paramString.pbN.paA });
          if (!bt.isNullOrNil(paramString.pbN.paA)) {
            Toast.makeText(QrRewardGrantUI.this, paramString.pbN.paA, 0).show();
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