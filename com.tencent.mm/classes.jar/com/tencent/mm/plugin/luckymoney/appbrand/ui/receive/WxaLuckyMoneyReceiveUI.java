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
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.x;

@com.tencent.mm.ui.base.a(3)
public class WxaLuckyMoneyReceiveUI
  extends WxaLuckyMoneyBaseUI
  implements b
{
  private TextView nAB;
  private int rxv = -1;
  private q tipDialog = null;
  private ImageView yQt;
  private int yRi = -1;
  private a yRj;
  private TextView yRk;
  private Button yRl;
  private View yRm;
  private ImageView yRn;
  private TextView yRo;
  private View yRp;
  private TextView yln;
  
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
  
  private void X(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(64997);
    if (paramBoolean1)
    {
      this.yRm.setVisibility(0);
      if (paramBoolean2) {
        this.yRo.setText(2131762603);
      }
      for (;;)
      {
        this.yRn.setVisibility(8);
        this.yRm.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(64987);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/appbrand/ui/receive/WxaLuckyMoneyReceiveUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            WxaLuckyMoneyReceiveUI.c(WxaLuckyMoneyReceiveUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/receive/WxaLuckyMoneyReceiveUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(64987);
          }
        });
        AppMethodBeat.o(64997);
        return;
        this.yRo.setText(2131762595);
      }
    }
    this.yRm.setVisibility(8);
    this.yRn.setVisibility(0);
    AppMethodBeat.o(64997);
  }
  
  private void eeM()
  {
    AppMethodBeat.i(64994);
    af.a(this.yRp, null);
    getContentView().setVisibility(0);
    AppMethodBeat.o(64994);
  }
  
  private void eeN()
  {
    AppMethodBeat.i(65005);
    if (this.yRl == null)
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
    this.yRl.setBackgroundResource(2131233788);
    this.yRl.setText(2131762695);
    AppMethodBeat.o(65005);
  }
  
  private void gR(int paramInt1, int paramInt2)
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
  
  private void iA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(64996);
    if (!Util.isNullOrNil(paramString1))
    {
      this.nAB.setText(paramString1);
      this.nAB.setVisibility(0);
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramString2))
      {
        af.a(getContext(), this.yln, paramString2);
        this.yln.setVisibility(0);
      }
      AppMethodBeat.o(64996);
      return;
      this.nAB.setVisibility(8);
    }
  }
  
  private void iz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(64995);
    af.a(this.yQt, paramString2, null);
    af.a(getContext(), this.yRk, paramString1);
    AppMethodBeat.o(64995);
  }
  
  private void m(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(65004);
    int i = (int)(com.tencent.mm.cb.a.aH(getContext(), paramInt) * com.tencent.mm.cb.a.iY(getContext()));
    paramInt = com.tencent.mm.cb.a.aG(getContext(), paramInt);
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
    this.rxv = paramInt;
    this.yRi = 1;
    eeG();
    iz(paramString1, paramString2);
    iA(null, paramString3);
    this.yRl.setOnClickListener(null);
    this.yRl.setVisibility(8);
    X(paramBoolean1, paramBoolean2);
    eeM();
    AppMethodBeat.o(64993);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(64992);
    eeG();
    iz(paramString1, paramString2);
    iA(paramString3, paramString4);
    this.yRl.setOnClickListener(new x()
    {
      public final void czW()
      {
        AppMethodBeat.i(64986);
        WxaLuckyMoneyReceiveUI.a(WxaLuckyMoneyReceiveUI.this);
        if (WxaLuckyMoneyReceiveUI.b(WxaLuckyMoneyReceiveUI.this) != null) {
          WxaLuckyMoneyReceiveUI.b(WxaLuckyMoneyReceiveUI.this).eeJ();
        }
        AppMethodBeat.o(64986);
      }
    });
    this.yRl.setVisibility(0);
    X(paramBoolean1, paramBoolean2);
    eeM();
    AppMethodBeat.o(64992);
  }
  
  public final MMActivity eeF()
  {
    return this;
  }
  
  public final void eeG()
  {
    AppMethodBeat.i(64991);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(64991);
  }
  
  public final void eeL()
  {
    AppMethodBeat.i(64990);
    af.d(this.yRl);
    AppMethodBeat.o(64990);
  }
  
  public final void error(String paramString) {}
  
  public int getLayoutId()
  {
    return 2131497114;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65003);
    this.yRp = findViewById(2131304240);
    this.yQt = ((ImageView)findViewById(2131304244));
    this.yRk = ((TextView)findViewById(2131304245));
    this.nAB = ((TextView)findViewById(2131304247));
    this.yln = ((TextView)findViewById(2131304251));
    this.yRl = ((Button)findViewById(2131304255));
    this.yRo = ((TextView)findViewById(2131304252));
    this.yRm = findViewById(2131304253);
    this.yRn = ((ImageView)findViewById(2131304018));
    Object localObject = (ImageView)findViewById(2131304254);
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
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/appbrand/ui/receive/WxaLuckyMoneyReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        WxaLuckyMoneyReceiveUI.d(WxaLuckyMoneyReceiveUI.this);
        WxaLuckyMoneyReceiveUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/receive/WxaLuckyMoneyReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64988);
      }
    });
    m(this.yRk, 2131166622);
    m(this.nAB, 2131166623);
    m(this.yln, 2131166624);
    getContentView().setVisibility(8);
    this.tipDialog = h.a(getContext(), getString(2131762446), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(64989);
        WxaLuckyMoneyReceiveUI.this.eeG();
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
    eeN();
    AppMethodBeat.o(65003);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(65001);
    gR(this.yRi, this.rxv);
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
    this.yRj = new c();
    this.yRj.d(this, getIntent());
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
    if (this.yRj != null)
    {
      this.yRj.onDestroy();
      this.yRj = null;
    }
    AppMethodBeat.o(65000);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(64999);
    super.onResume();
    af.d(this.yRl);
    this.yRl.setBackgroundResource(2131232445);
    eeN();
    AppMethodBeat.o(64999);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.WxaLuckyMoneyReceiveUI
 * JD-Core Version:    0.7.0.1
 */