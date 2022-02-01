package com.tencent.mm.plugin.luckymoney.appbrand.ui.receive;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.w;

@com.tencent.mm.ui.base.a(3)
public class WxaLuckyMoneyReceiveUI
  extends WxaLuckyMoneyBaseUI
  implements b
{
  private TextView lLe;
  private int pwp = -1;
  private TextView tEq;
  private p tipDialog = null;
  private ImageView uhq;
  private int uif = -1;
  private a uig;
  private TextView uih;
  private Button uii;
  private View uij;
  private ImageView uik;
  private TextView uil;
  private View uim;
  
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
  
  private void S(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(64997);
    if (paramBoolean1)
    {
      this.uij.setVisibility(0);
      if (paramBoolean2) {
        this.uil.setText(2131760846);
      }
      for (;;)
      {
        this.uik.setVisibility(8);
        this.uij.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(64987);
            WxaLuckyMoneyReceiveUI.c(WxaLuckyMoneyReceiveUI.this);
            AppMethodBeat.o(64987);
          }
        });
        AppMethodBeat.o(64997);
        return;
        this.uil.setText(2131760838);
      }
    }
    this.uij.setVisibility(8);
    this.uik.setVisibility(0);
    AppMethodBeat.o(64997);
  }
  
  private void cYJ()
  {
    AppMethodBeat.i(64994);
    z.a(this.uim, null);
    getContentView().setVisibility(0);
    AppMethodBeat.o(64994);
  }
  
  private void cYK()
  {
    AppMethodBeat.i(65005);
    if (this.uii == null)
    {
      AppMethodBeat.o(65005);
      return;
    }
    Object localObject = ai.getContext().getSharedPreferences(ai.eUX(), 0);
    ai.getContext();
    localObject = ab.f((SharedPreferences)localObject);
    if ((localObject != null) && (((String)localObject).length() > 0) && ((((String)localObject).equals("zh_CN")) || (((String)localObject).equals("zh_TW")) || (((String)localObject).equals("zh_HK"))))
    {
      AppMethodBeat.o(65005);
      return;
    }
    this.uii.setBackgroundResource(2131233134);
    this.uii.setText(2131760921);
    AppMethodBeat.o(65005);
  }
  
  private void gc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(65002);
    ac.i("MicroMsg.WxaLuckyMoneyReceiveUI", "setBackResult cgiType:[%d],errCode:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
  
  private void hw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(64995);
    z.b(this.uhq, paramString2, null);
    z.a(getContext(), this.uih, paramString1);
    AppMethodBeat.o(64995);
  }
  
  private void hx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(64996);
    if (!bs.isNullOrNil(paramString1))
    {
      this.lLe.setText(paramString1);
      this.lLe.setVisibility(0);
    }
    for (;;)
    {
      if (!bs.isNullOrNil(paramString2))
      {
        z.a(getContext(), this.tEq, paramString2);
        this.tEq.setVisibility(0);
      }
      AppMethodBeat.o(64996);
      return;
      this.lLe.setVisibility(8);
    }
  }
  
  private void l(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(65004);
    int i = (int)(com.tencent.mm.cc.a.av(getContext(), paramInt) * com.tencent.mm.cc.a.hR(getContext()));
    paramInt = com.tencent.mm.cc.a.au(getContext(), paramInt);
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
    this.pwp = paramInt;
    this.uif = 1;
    cYD();
    hw(paramString1, paramString2);
    hx(null, paramString3);
    this.uii.setOnClickListener(null);
    this.uii.setVisibility(8);
    S(paramBoolean1, paramBoolean2);
    cYJ();
    AppMethodBeat.o(64993);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(64992);
    cYD();
    hw(paramString1, paramString2);
    hx(paramString3, paramString4);
    this.uii.setOnClickListener(new w()
    {
      public final void bWk()
      {
        AppMethodBeat.i(64986);
        WxaLuckyMoneyReceiveUI.a(WxaLuckyMoneyReceiveUI.this);
        if (WxaLuckyMoneyReceiveUI.b(WxaLuckyMoneyReceiveUI.this) != null) {
          WxaLuckyMoneyReceiveUI.b(WxaLuckyMoneyReceiveUI.this).cYG();
        }
        AppMethodBeat.o(64986);
      }
    });
    this.uii.setVisibility(0);
    S(paramBoolean1, paramBoolean2);
    cYJ();
    AppMethodBeat.o(64992);
  }
  
  public final MMActivity cYC()
  {
    return this;
  }
  
  public final void cYD()
  {
    AppMethodBeat.i(64991);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(64991);
  }
  
  public final void cYI()
  {
    AppMethodBeat.i(64990);
    z.d(this.uii);
    AppMethodBeat.o(64990);
  }
  
  public final void error(String paramString) {}
  
  public int getLayoutId()
  {
    return 2131496120;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65003);
    this.uim = findViewById(2131301918);
    this.uhq = ((ImageView)findViewById(2131301921));
    this.uih = ((TextView)findViewById(2131301922));
    this.lLe = ((TextView)findViewById(2131301924));
    this.tEq = ((TextView)findViewById(2131301928));
    this.uii = ((Button)findViewById(2131301932));
    this.uil = ((TextView)findViewById(2131301929));
    this.uij = findViewById(2131301930);
    this.uik = ((ImageView)findViewById(2131301718));
    Object localObject = (ImageView)findViewById(2131301931);
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
        WxaLuckyMoneyReceiveUI.d(WxaLuckyMoneyReceiveUI.this);
        WxaLuckyMoneyReceiveUI.this.finish();
        AppMethodBeat.o(64988);
      }
    });
    l(this.uih, 2131166507);
    l(this.lLe, 2131166508);
    l(this.tEq, 2131166509);
    getContentView().setVisibility(8);
    this.tipDialog = h.b(getContext(), getString(2131760709), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(64989);
        WxaLuckyMoneyReceiveUI.this.cYD();
        if ((WxaLuckyMoneyReceiveUI.e(WxaLuckyMoneyReceiveUI.this).getVisibility() == 8) || (WxaLuckyMoneyReceiveUI.f(WxaLuckyMoneyReceiveUI.this).getVisibility() == 4))
        {
          ac.i("MicroMsg.WxaLuckyMoneyReceiveUI", "user cancel & finish");
          WxaLuckyMoneyReceiveUI.d(WxaLuckyMoneyReceiveUI.this);
          WxaLuckyMoneyReceiveUI.this.finish();
        }
        AppMethodBeat.o(64989);
      }
    });
    this.tipDialog.show();
    cYK();
    AppMethodBeat.o(65003);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(65001);
    gc(this.uif, this.pwp);
    finish();
    AppMethodBeat.o(65001);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64998);
    super.onCreate(paramBundle);
    ac.i("MicroMsg.WxaLuckyMoneyReceiveUI", "WxaLuckyMoneyReceiveUI.onCreate ");
    initView();
    getIntent();
    this.uig = new c();
    this.uig.d(this, getIntent());
    AppMethodBeat.o(64998);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65000);
    super.onDestroy();
    ac.i("MicroMsg.WxaLuckyMoneyReceiveUI", "WxaLuckyMoneyReceiveUI.onDestroy ");
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (this.uig != null)
    {
      this.uig.onDestroy();
      this.uig = null;
    }
    AppMethodBeat.o(65000);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(64999);
    super.onResume();
    z.d(this.uii);
    this.uii.setBackgroundResource(2131232316);
    cYK();
    AppMethodBeat.o(64999);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.WxaLuckyMoneyReceiveUI
 * JD-Core Version:    0.7.0.1
 */