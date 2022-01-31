package com.tencent.mm.plugin.collect.reward.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.collect.reward.a.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMGridView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(2)
public class QrRewardSelectMoneyUI
  extends QrRewardBaseUI
{
  private int bUR;
  private String gis;
  private String iIA;
  private String iIC;
  private String iID;
  private String iIE;
  private String iIF;
  private String iIG;
  private int iIH;
  private String iIy;
  private List<Integer> iJo = new ArrayList();
  private ImageView iJp;
  private TextView iJq;
  private TextView iJr;
  private TextView iJs;
  private TextView iJt;
  private MMGridView iJu;
  private TextView iJv;
  private QrRewardSelectMoneyUI.a iJw;
  private String iJx;
  private String iJy;
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof f))
    {
      paramString = (f)paramm;
      paramString.a(new QrRewardSelectMoneyUI.5(this, paramString)).b(new QrRewardSelectMoneyUI.4(this, paramString)).c(new QrRewardSelectMoneyUI.3(this, paramString));
      vN(0);
    }
    return true;
  }
  
  protected boolean convertActivityFromTranslucent()
  {
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.qr_reward_select_money_ui;
  }
  
  protected final void initView()
  {
    this.iJp = ((ImageView)findViewById(a.f.qrsm_avatar_iv));
    this.iJq = ((TextView)findViewById(a.f.qrsm_reward_amt_tv));
    this.iJr = ((TextView)findViewById(a.f.qrsm_name_tv));
    this.iJs = ((TextView)findViewById(a.f.qrsm_desc_tv));
    this.iJt = ((TextView)findViewById(a.f.qrsm_reward_money_title_tv));
    this.iJu = ((MMGridView)findViewById(a.f.qrsm_money_layout));
    this.iJv = ((TextView)findViewById(a.f.qrsm_other_reward_money_tv));
    this.iJw = new QrRewardSelectMoneyUI.a(this, (byte)0);
    this.iJu.setAdapter(this.iJw);
    this.iJu.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        paramAnonymousInt = ((Integer)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt)).intValue();
        QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, paramAnonymousInt, 1);
      }
    });
    this.iJv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, 0, 2);
      }
    });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        y.i("MicroMsg.QrRewardSelectMoneyUI", "pay succ");
        finish();
      }
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    kh(1516);
    setMMTitle(a.i.qr_reward_main_title);
    vN(4);
    this.iJx = getIntent().getStringExtra("key_qrcode_url");
    this.bUR = getIntent().getIntExtra("key_channel", 0);
    this.gis = getIntent().getStringExtra("key_web_url");
    y.i("MicroMsg.QrRewardSelectMoneyUI", "do scan code");
    a(new f(this.iJx, this.bUR, this.gis), true, true);
    initView();
    int i = getIntent().getIntExtra("key_scene", 0);
    y.d("MicroMsg.QrRewardSelectMoneyUI", "scene: %s", new Object[] { Integer.valueOf(i) });
    h.nFQ.f(14721, new Object[] { Integer.valueOf(2), Integer.valueOf(i) });
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ki(1516);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardSelectMoneyUI
 * JD-Core Version:    0.7.0.1
 */