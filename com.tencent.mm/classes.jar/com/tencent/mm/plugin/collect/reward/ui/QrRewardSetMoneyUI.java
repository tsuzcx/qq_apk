package com.tencent.mm.plugin.collect.reward.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.collect.reward.a.a;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.g;
import com.tencent.mm.plugin.collect.reward.b.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.dus;
import com.tencent.mm.protocal.protobuf.yr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.ac;
import com.tencent.mm.ui.base.MMGridView;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.ui.WcPayBannerView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class QrRewardSetMoneyUI
  extends QrRewardBaseUI
{
  private String desc;
  private dus pGr;
  private WcPayBannerView pLM;
  private String rRV;
  private TextView sUt;
  private ImageView xaN;
  private int xay;
  private MMEditText xbA;
  private TextView xbB;
  private TextView xbC;
  private SparseArray<WalletFormView> xbD;
  private List<Integer> xbE;
  private List<Integer> xbF;
  private boolean xbG;
  private Runnable xbH;
  private TextWatcher xbI;
  private MMGridView xby;
  private Button xbz;
  
  public QrRewardSetMoneyUI()
  {
    AppMethodBeat.i(64019);
    this.xbG = false;
    this.xbH = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64014);
        QrRewardSetMoneyUI.a(QrRewardSetMoneyUI.this);
        AppMethodBeat.o(64014);
      }
    };
    this.xbI = new QrRewardSetMoneyUI.6(this);
    AppMethodBeat.o(64019);
  }
  
  private boolean dsk()
  {
    AppMethodBeat.i(64024);
    int i = 0;
    while (i < this.xbE.size())
    {
      if (!((Integer)this.xbE.get(i)).equals(this.xbF.get(i)))
      {
        Log.i("MicroMsg.QrRewardSetMoneyUI", "modify money: %s, %s", new Object[] { this.xbE.get(i), this.xbF.get(i) });
        AppMethodBeat.o(64024);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(64024);
    return false;
  }
  
  private void dsl()
  {
    AppMethodBeat.i(64025);
    int i = 0;
    if (i < this.xbF.size())
    {
      WalletFormView localWalletFormView = (WalletFormView)LayoutInflater.from(getContext()).inflate(a.g.qr_reward_setting_item, null);
      localWalletFormView.a(this.xbI);
      int j = ((Integer)this.xbF.get(i)).intValue();
      int k = j / 100;
      double d = j / 100.0D;
      if (d > k) {
        localWalletFormView.setText(String.format("%.2f", new Object[] { Double.valueOf(d) }));
      }
      for (;;)
      {
        setEditFocusListener(localWalletFormView, 2, false);
        this.xbD.put(i, localWalletFormView);
        i += 1;
        break;
        localWalletFormView.setText(String.format("%d", new Object[] { Integer.valueOf(k) }));
      }
    }
    AppMethodBeat.o(64025);
  }
  
  public int getLayoutId()
  {
    return a.g.qr_reward_setting_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64021);
    this.xby = ((MMGridView)findViewById(a.f.qrsu_money_layout_new));
    this.pLM = ((WcPayBannerView)findViewById(a.f.wc_pay_banner_layout));
    this.pLM.jPz();
    this.pLM.setBannerData(this.pGr);
    this.xbz = ((Button)findViewById(a.f.qrsu_gen_btn));
    this.xbB = ((TextView)findViewById(a.f.qrsu_alert_tv));
    this.xaN = ((ImageView)findViewById(a.f.qrsu_avatar_iv));
    this.xbA = ((MMEditText)findViewById(a.f.qrsu_reward_et));
    this.sUt = ((TextView)findViewById(a.f.qrsu_title_tv));
    this.xbC = ((TextView)findViewById(a.f.qrsu_bottom_tips_tv));
    String str = z.bAO();
    Object localObject = str;
    if (Util.isNullOrNil(str)) {
      localObject = z.bAP();
    }
    this.sUt.setText(com.tencent.mm.pluginsdk.ui.span.p.b(getContext(), (CharSequence)localObject));
    a.b.a(this.xaN, z.bAM(), 0.06F, false);
    localObject = new QrRewardSetMoneyUI.a(this, (byte)0);
    this.xby.setAdapter((ListAdapter)localObject);
    if (!Util.isNullOrNil(this.desc)) {
      this.xbA.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, this.desc, this.xbA.getTextSize()));
    }
    this.xbB.setText(getString(a.i.qr_reward_set_money_exceed_text, new Object[] { Math.round(this.xay / 100.0F) }));
    if (this.xbG)
    {
      this.xbz.setText(a.i.qr_reward_first_set_money_btn_text);
      this.xbC.setVisibility(8);
    }
    this.xbz.setOnClickListener(new ac()
    {
      public final void dsb()
      {
        AppMethodBeat.i(64010);
        if (!QrRewardSetMoneyUI.a(QrRewardSetMoneyUI.this)) {
          QrRewardSetMoneyUI.b(QrRewardSetMoneyUI.this);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(14721, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
          AppMethodBeat.o(64010);
          return;
          Log.i("MicroMsg.QrRewardSetMoneyUI", "amt error!");
        }
      }
    });
    AppMethodBeat.o(64021);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64020);
    super.onCreate(paramBundle);
    setMMTitle(a.i.qr_reward_set_money_title);
    addSceneEndListener(1562);
    paramBundle = Util.stringToList((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acUf, ""), ",");
    this.xbE = new ArrayList();
    if (paramBundle.isEmpty())
    {
      Log.i("MicroMsg.QrRewardSetMoneyUI", "use client hardcode amt list");
      this.xbE = Arrays.asList(b.xad);
    }
    for (;;)
    {
      this.xbF = new ArrayList(this.xbE);
      this.xay = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acUe, Integer.valueOf(20000))).intValue();
      this.xbG = getIntent().getBooleanExtra("key_first_flag", false);
      this.desc = getIntent().getStringExtra("key_desc_word");
      paramBundle = getIntent().getStringExtra("key_notice_item");
      if (!Util.isNullOrNil(paramBundle)) {}
      try
      {
        Object localObject = new dus();
        ((dus)localObject).parseFrom(Base64.decode(paramBundle, 2));
        this.pGr = ((dus)localObject);
        this.xbD = new SparseArray();
        dsl();
        initView();
        AppMethodBeat.o(64020);
        return;
        paramBundle = paramBundle.iterator();
        while (paramBundle.hasNext())
        {
          localObject = (String)paramBundle.next();
          this.xbE.add(Integer.valueOf(Util.getInt((String)localObject, 0)));
        }
      }
      catch (IOException paramBundle)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.QrRewardSetMoneyUI", paramBundle, "", new Object[0]);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64022);
    super.onDestroy();
    removeSceneEndListener(1562);
    MMHandlerThread.removeRunnable(this.xbH);
    AppMethodBeat.o(64022);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(64023);
    if ((paramp instanceof g))
    {
      paramString = (g)paramp;
      paramString.a(new a.a()
      {
        public final void g(com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(64013);
          QrRewardSetMoneyUI.a(QrRewardSetMoneyUI.this, paramString.wZY.OhN);
          QrRewardSetMoneyUI.b(QrRewardSetMoneyUI.this, paramString.wZY.desc);
          paramAnonymousp = new Intent();
          paramAnonymousp.putExtra("key_desc", paramString.wZY.desc);
          paramAnonymousp.putExtra("key_photo_url", paramString.wZY.OhN);
          paramAnonymousp.putExtra("key_photo_aeskey", paramString.wZY.ZgF);
          paramAnonymousp.putExtra("key_photo_width", paramString.wZY.ZgK);
          paramAnonymousp.putExtra("key_icon_width", paramString.wZY.ZgG);
          paramAnonymousp.putExtra("key_return_from_first", QrRewardSetMoneyUI.c(QrRewardSetMoneyUI.this));
          QrRewardSetMoneyUI.this.setResult(-1, paramAnonymousp);
          QrRewardSetMoneyUI.this.finish();
          AppMethodBeat.o(64013);
        }
      }).b(new a.a()
      {
        public final void g(com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(64012);
          Log.e("MicroMsg.QrRewardSetMoneyUI", "set code error: %s, %s", new Object[] { Integer.valueOf(paramString.wZY.hAV), paramString.wZY.wYI });
          if (!Util.isNullOrNil(paramString.wZY.wYI))
          {
            Toast.makeText(QrRewardSetMoneyUI.this, paramString.wZY.wYI, 1).show();
            AppMethodBeat.o(64012);
            return;
          }
          Toast.makeText(QrRewardSetMoneyUI.this, a.i.qr_reward_set_code_failure_text, 1).show();
          AppMethodBeat.o(64012);
        }
      }).c(new a.a()
      {
        public final void g(com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(64011);
          Log.e("MicroMsg.QrRewardSetMoneyUI", "net error: %s", new Object[] { paramAnonymousp });
          AppMethodBeat.o(64011);
        }
      });
    }
    AppMethodBeat.o(64023);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardSetMoneyUI
 * JD-Core Version:    0.7.0.1
 */