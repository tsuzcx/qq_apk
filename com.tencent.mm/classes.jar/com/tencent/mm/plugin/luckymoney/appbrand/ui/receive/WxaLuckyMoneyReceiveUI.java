package com.tencent.mm.plugin.luckymoney.appbrand.ui.receive;

import android.app.Activity;
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
import com.tencent.mm.plugin.luckymoney.model.ag;
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
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;

@com.tencent.mm.ui.base.a(3)
public class WxaLuckyMoneyReceiveUI
  extends WxaLuckyMoneyBaseUI
  implements b
{
  private TextView DLp;
  private ImageView Eus;
  private int Evg = -1;
  private a Evh;
  private TextView Evi;
  private Button Evj;
  private View Evk;
  private ImageView Evl;
  private TextView Evm;
  private View Evn;
  private TextView qCM;
  private s tipDialog = null;
  private int vdb = -1;
  
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
  
  private void ah(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(64997);
    if (paramBoolean1)
    {
      this.Evk.setVisibility(0);
      if (paramBoolean2) {
        this.Evm.setText(a.i.lucky_money_detail_luck);
      }
      for (;;)
      {
        this.Evl.setVisibility(8);
        this.Evk.setOnClickListener(new WxaLuckyMoneyReceiveUI.2(this));
        AppMethodBeat.o(64997);
        return;
        this.Evm.setText(a.i.lucky_money_check_detail);
      }
    }
    this.Evk.setVisibility(8);
    this.Evl.setVisibility(0);
    AppMethodBeat.o(64997);
  }
  
  private void eOh()
  {
    AppMethodBeat.i(64994);
    ag.a(this.Evn, null);
    getContentView().setVisibility(0);
    AppMethodBeat.o(64994);
  }
  
  private void eOi()
  {
    AppMethodBeat.i(65005);
    if (this.Evj == null)
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
    this.Evj.setBackgroundResource(a.e.lucky_money_send_btn);
    this.Evj.setText(a.i.lucky_money_open_title);
    AppMethodBeat.o(65005);
  }
  
  private void hV(int paramInt1, int paramInt2)
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
  
  private void iL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(64995);
    ag.a(this.Eus, paramString2, null);
    ag.a(getContext(), this.Evi, paramString1);
    AppMethodBeat.o(64995);
  }
  
  private void iM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(64996);
    if (!Util.isNullOrNil(paramString1))
    {
      this.qCM.setText(paramString1);
      this.qCM.setVisibility(0);
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramString2))
      {
        ag.a(getContext(), this.DLp, paramString2);
        this.DLp.setVisibility(0);
      }
      AppMethodBeat.o(64996);
      return;
      this.qCM.setVisibility(8);
    }
  }
  
  private void m(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(65004);
    int i = (int)(com.tencent.mm.ci.a.aZ(getContext(), paramInt) * com.tencent.mm.ci.a.kc(getContext()));
    paramInt = com.tencent.mm.ci.a.aY(getContext(), paramInt);
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
    this.vdb = paramInt;
    this.Evg = 1;
    eOb();
    iL(paramString1, paramString2);
    iM(null, paramString3);
    this.Evj.setOnClickListener(null);
    this.Evj.setVisibility(8);
    ah(paramBoolean1, paramBoolean2);
    eOh();
    AppMethodBeat.o(64993);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(64992);
    eOb();
    iL(paramString1, paramString2);
    iM(paramString3, paramString4);
    this.Evj.setOnClickListener(new aa()
    {
      public final void cOw()
      {
        AppMethodBeat.i(64986);
        WxaLuckyMoneyReceiveUI.a(WxaLuckyMoneyReceiveUI.this);
        if (WxaLuckyMoneyReceiveUI.b(WxaLuckyMoneyReceiveUI.this) != null) {
          WxaLuckyMoneyReceiveUI.b(WxaLuckyMoneyReceiveUI.this).eOe();
        }
        AppMethodBeat.o(64986);
      }
    });
    this.Evj.setVisibility(0);
    ah(paramBoolean1, paramBoolean2);
    eOh();
    AppMethodBeat.o(64992);
  }
  
  public final MMActivity eOa()
  {
    return this;
  }
  
  public final void eOb()
  {
    AppMethodBeat.i(64991);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(64991);
  }
  
  public final void eOg()
  {
    AppMethodBeat.i(64990);
    ag.d(this.Evj);
    AppMethodBeat.o(64990);
  }
  
  public final void error(String paramString) {}
  
  public int getLayoutId()
  {
    return a.g.wxa_lucky_money_receive_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65003);
    this.Evn = findViewById(a.f.lucky_money_receive_ll_1);
    this.Eus = ((ImageView)findViewById(a.f.lucky_money_receive_sender_avatar));
    this.Evi = ((TextView)findViewById(a.f.lucky_money_receive_sender_nickname));
    this.qCM = ((TextView)findViewById(a.f.lucky_money_receive_tips));
    this.DLp = ((TextView)findViewById(a.f.lucky_money_receive_wishing));
    this.Evj = ((Button)findViewById(a.f.lucky_money_recieve_open));
    this.Evm = ((TextView)findViewById(a.f.lucky_money_recieve_check_detail));
    this.Evk = findViewById(a.f.lucky_money_recieve_check_detail_ll);
    this.Evl = ((ImageView)findViewById(a.f.lucky_money_bottom_decoration));
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
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/appbrand/ui/receive/WxaLuckyMoneyReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        WxaLuckyMoneyReceiveUI.d(WxaLuckyMoneyReceiveUI.this);
        WxaLuckyMoneyReceiveUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/receive/WxaLuckyMoneyReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64988);
      }
    });
    m(this.Evi, a.d.lucky_money_goldstyle_envelop_nickname_textsize);
    m(this.qCM, a.d.lucky_money_goldstyle_envelop_tips_textsize);
    m(this.DLp, a.d.lucky_money_goldstyle_envelop_wishing_textsize);
    getContentView().setVisibility(8);
    this.tipDialog = h.a(getContext(), getString(a.i.loading_tips), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(64989);
        WxaLuckyMoneyReceiveUI.this.eOb();
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
    eOi();
    AppMethodBeat.o(65003);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(65001);
    hV(this.Evg, this.vdb);
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
    this.Evh = new c();
    this.Evh.d(this, getIntent());
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
    if (this.Evh != null)
    {
      this.Evh.onDestroy();
      this.Evh = null;
    }
    AppMethodBeat.o(65000);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(64999);
    super.onResume();
    ag.d(this.Evj);
    this.Evj.setBackgroundResource(a.e.festival_lucky_money_open_btn_normal);
    eOi();
    AppMethodBeat.o(64999);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.WxaLuckyMoneyReceiveUI
 * JD-Core Version:    0.7.0.1
 */