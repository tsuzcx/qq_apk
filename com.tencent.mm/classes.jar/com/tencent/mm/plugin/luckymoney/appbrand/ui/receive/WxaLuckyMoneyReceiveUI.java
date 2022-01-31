package com.tencent.mm.plugin.luckymoney.appbrand.ui.receive;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s;

@com.tencent.mm.ui.base.a(3)
public class WxaLuckyMoneyReceiveUI
  extends WxaLuckyMoneyBaseUI
  implements b
{
  private TextView iKV;
  private int jsT = -1;
  private ImageView lLV;
  private int lMK = -1;
  private a lML;
  private TextView lMM;
  private Button lMN;
  private View lMO;
  private ImageView lMP;
  private TextView lMQ;
  private View lMR;
  private TextView lly;
  private p tipDialog = null;
  
  static
  {
    if (!WxaLuckyMoneyReceiveUI.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private void bfu()
  {
    o.a(this.lMR, null);
    this.mController.contentView.setVisibility(0);
  }
  
  private void bfv()
  {
    if (this.lMN == null) {}
    String str;
    do
    {
      return;
      str = x.d(ae.getContext().getSharedPreferences(ae.cqR(), 0));
    } while ((str != null) && (str.length() > 0) && ((str.equals("zh_CN")) || (str.equals("zh_TW")) || (str.equals("zh_HK"))));
    this.lMN.setBackgroundResource(a.e.lucky_money_send_btn);
    this.lMN.setText(a.i.lucky_money_open_title);
  }
  
  private void dJ(String paramString1, String paramString2)
  {
    o.a(this.lLV, paramString2, null);
    o.a(this.mController.uMN, this.lMM, paramString1);
  }
  
  private void dK(String paramString1, String paramString2)
  {
    if (!bk.bl(paramString1))
    {
      this.iKV.setText(paramString1);
      this.iKV.setVisibility(0);
    }
    for (;;)
    {
      if (!bk.bl(paramString2))
      {
        o.a(this.mController.uMN, this.lly, paramString2);
        this.lly.setVisibility(0);
      }
      return;
      this.iKV.setVisibility(8);
    }
  }
  
  private void db(int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.WxaLuckyMoneyReceiveUI", "setBackResult cgiType:[%d],errCode:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1) {
      setResult(0, new Intent().putExtra("result_error_code", 10001).putExtra("result_error_msg", "fail:no permission to receive the red packet"));
    }
    while (paramInt1 != 4) {
      return;
    }
    setResult(0, new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{user cancel}}"));
  }
  
  private void f(TextView paramTextView, int paramInt)
  {
    int i = (int)(com.tencent.mm.cb.a.ab(this.mController.uMN, paramInt) * 1.125F);
    paramInt = com.tencent.mm.cb.a.aa(this.mController.uMN, paramInt);
    if (paramInt > i) {
      paramInt = i;
    }
    for (;;)
    {
      paramTextView.setTextSize(0, paramInt);
      return;
    }
  }
  
  private void z(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.lMO.setVisibility(0);
      if (paramBoolean2) {
        this.lMQ.setText(a.i.lucky_money_detail_luck);
      }
      for (;;)
      {
        this.lMP.setVisibility(8);
        this.lMO.setOnClickListener(new WxaLuckyMoneyReceiveUI.2(this));
        return;
        this.lMQ.setText(a.i.lucky_money_check_detail);
      }
    }
    this.lMO.setVisibility(8);
    this.lMP.setVisibility(0);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jsT = paramInt;
    this.lMK = 1;
    bfo();
    dJ(paramString1, paramString2);
    dK(null, paramString3);
    this.lMN.setOnClickListener(null);
    this.lMN.setVisibility(8);
    z(paramBoolean1, paramBoolean2);
    bfu();
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    bfo();
    dJ(paramString1, paramString2);
    dK(paramString3, paramString4);
    this.lMN.setOnClickListener(new WxaLuckyMoneyReceiveUI.1(this));
    this.lMN.setVisibility(0);
    z(paramBoolean1, paramBoolean2);
    bfu();
  }
  
  public final MMActivity bfn()
  {
    return this;
  }
  
  public final void bfo()
  {
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
  }
  
  public final void bft()
  {
    o.d(this.lMN);
  }
  
  public final void error(String paramString) {}
  
  protected final int getLayoutId()
  {
    return a.g.wxa_lucky_money_receive_ui;
  }
  
  protected final void initView()
  {
    this.lMR = findViewById(a.f.lucky_money_receive_ll);
    this.lLV = ((ImageView)findViewById(a.f.lucky_money_receive_sender_avatar));
    this.lMM = ((TextView)findViewById(a.f.lucky_money_receive_sender_nickname));
    this.iKV = ((TextView)findViewById(a.f.lucky_money_receive_tips));
    this.lly = ((TextView)findViewById(a.f.lucky_money_receive_wishing));
    this.lMN = ((Button)findViewById(a.f.lucky_money_recieve_open));
    this.lMQ = ((TextView)findViewById(a.f.lucky_money_recieve_check_detail));
    this.lMO = findViewById(a.f.lucky_money_recieve_check_detail_ll);
    this.lMP = ((ImageView)findViewById(a.f.lucky_money_bottom_decoration));
    ImageView localImageView = (ImageView)findViewById(a.f.lucky_money_recieve_close_btn);
    assert (localImageView != null);
    localImageView.setOnClickListener(new WxaLuckyMoneyReceiveUI.3(this));
    f(this.lMM, a.d.lucky_money_goldstyle_envelop_nickname_textsize);
    f(this.iKV, a.d.lucky_money_goldstyle_envelop_tips_textsize);
    f(this.lly, a.d.lucky_money_goldstyle_envelop_wishing_textsize);
    this.mController.contentView.setVisibility(8);
    this.tipDialog = h.b(this.mController.uMN, getString(a.i.loading_tips), true, new WxaLuckyMoneyReceiveUI.4(this));
    this.tipDialog.show();
    bfv();
  }
  
  public void onBackPressed()
  {
    db(this.lMK, this.jsT);
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.WxaLuckyMoneyReceiveUI", "WxaLuckyMoneyReceiveUI.onCreate ");
    initView();
    getIntent();
    this.lML = new c();
    this.lML.a(this, getIntent());
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    y.i("MicroMsg.WxaLuckyMoneyReceiveUI", "WxaLuckyMoneyReceiveUI.onDestroy ");
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (this.lML != null)
    {
      this.lML.onDestroy();
      this.lML = null;
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    o.d(this.lMN);
    this.lMN.setBackgroundResource(a.e.festival_lucky_money_open_btn);
    bfv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.WxaLuckyMoneyReceiveUI
 * JD-Core Version:    0.7.0.1
 */