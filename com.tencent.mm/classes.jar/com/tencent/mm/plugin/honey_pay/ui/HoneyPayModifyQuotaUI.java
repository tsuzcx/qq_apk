package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class HoneyPayModifyQuotaUI
  extends HoneyPayBaseUI
{
  private long lkW;
  private long lkX;
  private String lki;
  private WalletFormView llP;
  private Button llQ;
  private TextView llv;
  
  private void gH(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.llv.isShown()))
    {
      str = ab.cML() + e.b(new StringBuilder().append(this.lkX).toString(), "100", RoundingMode.HALF_UP).toString();
      this.llv.setText(getString(a.i.honey_pay_min_quota_alert_text, new Object[] { str }));
      this.llv.startAnimation(AnimationUtils.loadAnimation(this, a.a.in_from_up));
      this.llv.setVisibility(0);
    }
    while ((paramBoolean) || (!this.llv.isShown()))
    {
      String str;
      return;
    }
    this.llv.startAnimation(AnimationUtils.loadAnimation(this, a.a.out_to_up));
    this.llv.setVisibility(8);
  }
  
  private void gI(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.llv.isShown()))
    {
      str = ab.cML() + e.b(new StringBuilder().append(this.lkW).toString(), "100", RoundingMode.HALF_UP);
      this.llv.setText(getString(a.i.honey_pay_max_quota_alert_text, new Object[] { str }));
      this.llv.startAnimation(AnimationUtils.loadAnimation(this, a.a.in_from_up));
      this.llv.setVisibility(0);
    }
    while ((paramBoolean) || (!this.llv.isShown()))
    {
      String str;
      return;
    }
    this.llv.startAnimation(AnimationUtils.loadAnimation(this, a.a.out_to_up));
    this.llv.setVisibility(8);
  }
  
  private void gJ(boolean paramBoolean)
  {
    this.llQ.setEnabled(paramBoolean);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.honey_pay_modify_quota_ui;
  }
  
  protected final void initView()
  {
    this.llP = ((WalletFormView)findViewById(a.f.hpmq_quota_et));
    this.llQ = ((Button)findViewById(a.f.hpmq_finish_btn));
    this.llv = ((TextView)findViewById(a.f.hpmq_top_alert_tv));
    this.llP.cNu();
    this.llP.getTitleTv().setText(ab.cML());
    e(this.llP, 2, false);
    this.llP.a(new HoneyPayModifyQuotaUI.1(this));
    this.llQ.setOnClickListener(new HoneyPayModifyQuotaUI.2(this));
    this.llP.postDelayed(new HoneyPayModifyQuotaUI.3(this), 100L);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1) && (paramIntent.getBooleanExtra("key_modify_create_line_succ", false)))
    {
      setResult(-1, paramIntent);
      finish();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.lkW = getIntent().getLongExtra("key_max_credit_line", 0L);
    this.lkX = getIntent().getLongExtra("key_min_credit_line", 0L);
    this.lki = getIntent().getStringExtra("key_card_no");
    initView();
    setMMTitle(a.i.honey_pay_modify_quota_title);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayModifyQuotaUI
 * JD-Core Version:    0.7.0.1
 */