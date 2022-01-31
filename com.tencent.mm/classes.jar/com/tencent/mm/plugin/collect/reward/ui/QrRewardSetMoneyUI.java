package com.tencent.mm.plugin.collect.reward.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.collect.reward.a.a;
import com.tencent.mm.plugin.collect.reward.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMGridView;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class QrRewardSetMoneyUI
  extends QrRewardBaseUI
{
  private String desc;
  private String fGC;
  private TextView haW;
  private int iIH;
  private ImageView iIS;
  private MMGridView iJD;
  private Button iJE;
  private MMEditText iJF;
  private TextView iJG;
  private TextView iJH;
  private SparseArray<WalletFormView> iJI;
  private List<Integer> iJJ;
  private List<Integer> iJK;
  private boolean iJL = false;
  private Runnable iJM = new QrRewardSetMoneyUI.5(this);
  private TextWatcher iJN = new QrRewardSetMoneyUI.6(this);
  
  private boolean aEQ()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.iJJ.size())
      {
        if (!((Integer)this.iJJ.get(i)).equals(this.iJK.get(i)))
        {
          y.i("MicroMsg.QrRewardSetMoneyUI", "modify money: %s, %s", new Object[] { this.iJJ.get(i), this.iJK.get(i) });
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private void aER()
  {
    int i = 0;
    if (i < this.iJK.size())
    {
      WalletFormView localWalletFormView = (WalletFormView)LayoutInflater.from(this.mController.uMN).inflate(a.g.qr_reward_setting_item, null);
      localWalletFormView.a(this.iJN);
      int j = ((Integer)this.iJK.get(i)).intValue();
      int k = j / 100;
      double d = j / 100.0D;
      if (d > k) {
        localWalletFormView.setText(String.format("%.2f", new Object[] { Double.valueOf(d) }));
      }
      for (;;)
      {
        e(localWalletFormView, 2, false);
        this.iJI.put(i, localWalletFormView);
        i += 1;
        break;
        localWalletFormView.setText(String.format("%d", new Object[] { Integer.valueOf(k) }));
      }
    }
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof com.tencent.mm.plugin.collect.reward.a.g))
    {
      paramString = (com.tencent.mm.plugin.collect.reward.a.g)paramm;
      paramString.a(new QrRewardSetMoneyUI.4(this, paramString)).b(new QrRewardSetMoneyUI.3(this, paramString)).c(new QrRewardSetMoneyUI.2(this));
    }
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.qr_reward_setting_ui;
  }
  
  protected final void initView()
  {
    this.iJD = ((MMGridView)findViewById(a.f.qrsu_money_layout_new));
    this.iJE = ((Button)findViewById(a.f.qrsu_gen_btn));
    this.iJG = ((TextView)findViewById(a.f.qrsu_alert_tv));
    this.iIS = ((ImageView)findViewById(a.f.qrsu_avatar_iv));
    this.iJF = ((MMEditText)findViewById(a.f.qrsu_reward_et));
    this.haW = ((TextView)findViewById(a.f.qrsu_title_tv));
    this.iJH = ((TextView)findViewById(a.f.qrsu_bottom_tips_tv));
    String str = q.Gl();
    Object localObject = str;
    if (bk.bl(str)) {
      localObject = q.Gm();
    }
    this.haW.setText(j.b(this.mController.uMN, (CharSequence)localObject));
    a.b.a(this.iIS, q.Gj(), 0.06F, false);
    localObject = new QrRewardSetMoneyUI.a(this, (byte)0);
    this.iJD.setAdapter((ListAdapter)localObject);
    if (!bk.bl(this.desc)) {
      this.iJF.setText(j.a(this, this.desc, this.iJF.getTextSize()));
    }
    this.iJG.setText(getString(a.i.qr_reward_set_money_exceed_text, new Object[] { Math.round(this.iIH / 100.0F) }));
    if (this.iJL)
    {
      this.iJE.setText(a.i.qr_reward_first_set_money_btn_text);
      this.iJH.setVisibility(8);
    }
    this.iJE.setOnClickListener(new u()
    {
      public final void aEI()
      {
        if (!QrRewardSetMoneyUI.a(QrRewardSetMoneyUI.this)) {
          QrRewardSetMoneyUI.b(QrRewardSetMoneyUI.this);
        }
        for (;;)
        {
          h.nFQ.f(14721, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
          return;
          y.i("MicroMsg.QrRewardSetMoneyUI", "amt error!");
        }
      }
    });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(a.i.qr_reward_set_money_title);
    kh(1562);
    paramBundle = bk.gg((String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uyh, ""), ",");
    this.iJJ = new ArrayList();
    if (paramBundle.isEmpty())
    {
      y.i("MicroMsg.QrRewardSetMoneyUI", "use client hardcode amt list");
      this.iJJ = Arrays.asList(b.iIm);
    }
    for (;;)
    {
      this.iJK = new ArrayList(this.iJJ);
      this.iIH = ((Integer)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uyg, Integer.valueOf(20000))).intValue();
      this.iJL = getIntent().getBooleanExtra("key_first_flag", false);
      this.desc = getIntent().getStringExtra("key_desc_word");
      this.iJI = new SparseArray();
      aER();
      initView();
      return;
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        String str = (String)paramBundle.next();
        this.iJJ.add(Integer.valueOf(bk.getInt(str, 0)));
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ki(1562);
    ai.S(this.iJM);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardSetMoneyUI
 * JD-Core Version:    0.7.0.1
 */