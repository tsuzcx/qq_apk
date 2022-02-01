package com.tencent.mm.plugin.luckymoney.appbrand.ui.receive;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ac;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;

@com.tencent.mm.ui.base.a(3)
public class WxaLuckyMoneyReceiveUI
  extends WxaLuckyMoneyBaseUI
  implements b
{
  private TextView JCr;
  private ImageView KmZ;
  private int KnN = -1;
  private a KnO;
  private TextView KnP;
  private Button KnQ;
  private ImageView KnR;
  private View KnS;
  private ImageView KnT;
  private TextView KnU;
  private View KnV;
  private TextView tHK;
  private w tipDialog = null;
  private int yoO = -1;
  
  static
  {
    AppMethodBeat.i(65011);
    if (!WxaLuckyMoneyReceiveUI.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(65011);
      return;
    }
  }
  
  private void az(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(64997);
    if (paramBoolean1)
    {
      this.KnS.setVisibility(0);
      if (paramBoolean2) {
        this.KnU.setText(a.i.lucky_money_detail_luck);
      }
      for (;;)
      {
        this.KnT.setVisibility(8);
        this.KnS.setOnClickListener(new WxaLuckyMoneyReceiveUI.2(this));
        AppMethodBeat.o(64997);
        return;
        this.KnU.setText(a.i.lucky_money_check_detail);
      }
    }
    this.KnS.setVisibility(8);
    this.KnT.setVisibility(0);
    AppMethodBeat.o(64997);
  }
  
  private void fWB()
  {
    AppMethodBeat.i(64994);
    ah.a(this.KnV, null);
    getContentView().setVisibility(0);
    AppMethodBeat.o(64994);
  }
  
  private void fWC()
  {
    AppMethodBeat.i(65005);
    if (this.KnQ == null)
    {
      AppMethodBeat.o(65005);
      return;
    }
    String str = LocaleUtil.loadApplicationLanguage(MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), MMApplicationContext.getContext());
    if ((str != null) && (str.length() > 0) && ((str.equals("zh_CN")) || (str.equals("zh_TW")) || (str.equals("zh_HK"))))
    {
      AppMethodBeat.o(65005);
      return;
    }
    this.KnQ.setBackgroundResource(a.e.lucky_money_send_btn);
    this.KnQ.setText(a.i.lucky_money_open_title);
    AppMethodBeat.o(65005);
  }
  
  private void fWD()
  {
    AppMethodBeat.i(284056);
    this.KnQ.setVisibility(0);
    ah.o(this.KnR);
    AppMethodBeat.o(284056);
  }
  
  private void jA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(65002);
    Log.i("MicroMsg.WxaLuckyMoneyReceiveUI", "setBackResult cgiType:[%d],errCode:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1)
    {
      setResult(0, new Intent().putExtra("result_error_code", 10001).putExtra("result_error_msg", "fail:no permission to receive the red packet"));
      AppMethodBeat.o(65002);
      return;
    }
    if (paramInt1 == 4) {
      setResult(0, new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{user cancel}}"));
    }
    AppMethodBeat.o(65002);
  }
  
  private void jV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(64995);
    ah.a(this.KmZ, paramString2, null);
    ah.a(getContext(), this.KnP, paramString1);
    AppMethodBeat.o(64995);
  }
  
  private void jW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(64996);
    if (!Util.isNullOrNil(paramString1))
    {
      this.tHK.setText(paramString1);
      this.tHK.setVisibility(0);
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramString2))
      {
        ah.a(getContext(), this.JCr, paramString2);
        this.JCr.setVisibility(0);
      }
      AppMethodBeat.o(64996);
      return;
      this.tHK.setVisibility(8);
    }
  }
  
  private void o(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(65004);
    int i = (int)(com.tencent.mm.cd.a.bs(getContext(), paramInt) * com.tencent.mm.cd.a.me(getContext()));
    paramInt = com.tencent.mm.cd.a.br(getContext(), paramInt);
    if (paramInt > i) {
      paramInt = i;
    }
    for (;;)
    {
      paramTextView.setTextSize(0, paramInt);
      AppMethodBeat.o(65004);
      return;
    }
  }
  
  public final void a(String paramString1, String paramString2, int paramInt, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(64993);
    this.yoO = paramInt;
    this.KnN = 1;
    fWu();
    jV(paramString1, paramString2);
    jW(null, paramString3);
    this.KnQ.setOnClickListener(null);
    this.KnQ.setVisibility(8);
    this.KnR.setVisibility(8);
    az(paramBoolean1, paramBoolean2);
    fWB();
    AppMethodBeat.o(64993);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(64992);
    fWu();
    jV(paramString1, paramString2);
    jW(paramString3, paramString4);
    this.KnQ.setOnClickListener(new ac()
    {
      public final void dsb()
      {
        AppMethodBeat.i(64986);
        WxaLuckyMoneyReceiveUI.a(WxaLuckyMoneyReceiveUI.this);
        if (WxaLuckyMoneyReceiveUI.b(WxaLuckyMoneyReceiveUI.this) != null) {
          WxaLuckyMoneyReceiveUI.b(WxaLuckyMoneyReceiveUI.this).fWy();
        }
        AppMethodBeat.o(64986);
      }
    });
    this.KnQ.setVisibility(0);
    az(paramBoolean1, paramBoolean2);
    fWB();
    AppMethodBeat.o(64992);
  }
  
  public final void error(String paramString) {}
  
  public final void fWA()
  {
    AppMethodBeat.i(64990);
    fWD();
    AppMethodBeat.o(64990);
  }
  
  public final MMActivity fWt()
  {
    return this;
  }
  
  public final void fWu()
  {
    AppMethodBeat.i(64991);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(64991);
  }
  
  public int getLayoutId()
  {
    return a.g.wxa_lucky_money_receive_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65003);
    this.KnV = findViewById(a.f.lucky_money_receive_ll_1);
    this.KmZ = ((ImageView)findViewById(a.f.lucky_money_receive_sender_avatar));
    this.KnP = ((TextView)findViewById(a.f.lucky_money_receive_sender_nickname));
    this.tHK = ((TextView)findViewById(a.f.lucky_money_receive_tips));
    this.JCr = ((TextView)findViewById(a.f.lucky_money_receive_wishing));
    this.KnQ = ((Button)findViewById(a.f.lucky_money_recieve_open));
    this.KnR = ((ImageView)findViewById(a.f.lucky_money_recieve_open_animateview));
    this.KnU = ((TextView)findViewById(a.f.lucky_money_recieve_check_detail));
    this.KnS = findViewById(a.f.lucky_money_recieve_check_detail_ll);
    this.KnT = ((ImageView)findViewById(a.f.lucky_money_bottom_decoration));
    Object localObject = (ImageView)findViewById(a.f.lucky_money_recieve_close_btn);
    if ((!$assertionsDisabled) && (localObject == null))
    {
      localObject = new AssertionError();
      AppMethodBeat.o(65003);
      throw ((Throwable)localObject);
    }
    ((ImageView)localObject).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64988);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/appbrand/ui/receive/WxaLuckyMoneyReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        WxaLuckyMoneyReceiveUI.d(WxaLuckyMoneyReceiveUI.this);
        WxaLuckyMoneyReceiveUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/receive/WxaLuckyMoneyReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64988);
      }
    });
    o(this.KnP, a.d.lucky_money_goldstyle_envelop_nickname_textsize);
    o(this.tHK, a.d.lucky_money_goldstyle_envelop_tips_textsize);
    o(this.JCr, a.d.lucky_money_goldstyle_envelop_wishing_textsize);
    getContentView().setVisibility(8);
    this.tipDialog = k.a(getContext(), getString(a.i.loading_tips), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(64989);
        WxaLuckyMoneyReceiveUI.this.fWu();
        if ((WxaLuckyMoneyReceiveUI.e(WxaLuckyMoneyReceiveUI.this).getVisibility() == 8) || (WxaLuckyMoneyReceiveUI.f(WxaLuckyMoneyReceiveUI.this).getVisibility() == 4))
        {
          Log.i("MicroMsg.WxaLuckyMoneyReceiveUI", "user cancel & finish");
          WxaLuckyMoneyReceiveUI.d(WxaLuckyMoneyReceiveUI.this);
          WxaLuckyMoneyReceiveUI.this.finish();
        }
        AppMethodBeat.o(64989);
      }
    });
    this.tipDialog.show();
    fWC();
    AppMethodBeat.o(65003);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(65001);
    jA(this.KnN, this.yoO);
    finish();
    AppMethodBeat.o(65001);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64998);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.WxaLuckyMoneyReceiveUI", "WxaLuckyMoneyReceiveUI.onCreate ");
    initView();
    getIntent();
    this.KnO = new c();
    this.KnO.d(this, getIntent());
    AppMethodBeat.o(64998);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65000);
    super.onDestroy();
    Log.i("MicroMsg.WxaLuckyMoneyReceiveUI", "WxaLuckyMoneyReceiveUI.onDestroy ");
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (this.KnO != null)
    {
      this.KnO.onDestroy();
      this.KnO = null;
    }
    AppMethodBeat.o(65000);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(64999);
    super.onResume();
    fWD();
    this.KnQ.setBackgroundResource(a.e.festival_lucky_money_open_btn_normal);
    fWC();
    AppMethodBeat.o(64999);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.WxaLuckyMoneyReceiveUI
 * JD-Core Version:    0.7.0.1
 */