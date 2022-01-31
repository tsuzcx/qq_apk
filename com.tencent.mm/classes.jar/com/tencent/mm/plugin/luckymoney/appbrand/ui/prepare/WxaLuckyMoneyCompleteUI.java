package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.os.Bundle;
import android.widget.Button;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.MMActivity;

public class WxaLuckyMoneyCompleteUI
  extends WxaLuckyMoneyBaseUI
  implements b
{
  private Button llQ;
  
  public final MMActivity bfn()
  {
    return this;
  }
  
  public final void bfo() {}
  
  public final void error(String paramString) {}
  
  protected final int getLayoutId()
  {
    return a.g.wxa_lucky_money_complete_ui;
  }
  
  protected final void initView()
  {
    this.llQ = ((Button)findViewById(a.f.wxa_lucky_money_complete_finish_btn));
    this.llQ.setOnClickListener(new WxaLuckyMoneyCompleteUI.1(this));
  }
  
  public void onBackPressed()
  {
    setResult(0, null);
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyCompleteUI
 * JD-Core Version:    0.7.0.1
 */