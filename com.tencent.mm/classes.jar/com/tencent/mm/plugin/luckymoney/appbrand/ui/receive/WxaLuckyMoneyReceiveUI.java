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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.v;

@com.tencent.mm.ui.base.a(3)
public class WxaLuckyMoneyReceiveUI
  extends WxaLuckyMoneyBaseUI
  implements b
{
  private TextView lln;
  private int oTe = -1;
  private int sZQ = -1;
  private a sZR;
  private TextView sZS;
  private Button sZT;
  private View sZU;
  private ImageView sZV;
  private TextView sZW;
  private View sZX;
  private ImageView sZc;
  private TextView swB;
  private p tipDialog = null;
  
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
  
  private void P(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(64997);
    if (paramBoolean1)
    {
      this.sZU.setVisibility(0);
      if (paramBoolean2) {
        this.sZW.setText(2131760846);
      }
      for (;;)
      {
        this.sZV.setVisibility(8);
        this.sZU.setOnClickListener(new View.OnClickListener()
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
        this.sZW.setText(2131760838);
      }
    }
    this.sZU.setVisibility(8);
    this.sZV.setVisibility(0);
    AppMethodBeat.o(64997);
  }
  
  private void cLd()
  {
    AppMethodBeat.i(64994);
    z.a(this.sZX, null);
    getContentView().setVisibility(0);
    AppMethodBeat.o(64994);
  }
  
  private void cLe()
  {
    AppMethodBeat.i(65005);
    if (this.sZT == null)
    {
      AppMethodBeat.o(65005);
      return;
    }
    Object localObject = aj.getContext().getSharedPreferences(aj.eFD(), 0);
    aj.getContext();
    localObject = ac.f((SharedPreferences)localObject);
    if ((localObject != null) && (((String)localObject).length() > 0) && ((((String)localObject).equals("zh_CN")) || (((String)localObject).equals("zh_TW")) || (((String)localObject).equals("zh_HK"))))
    {
      AppMethodBeat.o(65005);
      return;
    }
    this.sZT.setBackgroundResource(2131233134);
    this.sZT.setText(2131760921);
    AppMethodBeat.o(65005);
  }
  
  private void fV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(65002);
    ad.i("MicroMsg.WxaLuckyMoneyReceiveUI", "setBackResult cgiType:[%d],errCode:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
  
  private void hd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(64995);
    z.b(this.sZc, paramString2, null);
    z.a(getContext(), this.sZS, paramString1);
    AppMethodBeat.o(64995);
  }
  
  private void he(String paramString1, String paramString2)
  {
    AppMethodBeat.i(64996);
    if (!bt.isNullOrNil(paramString1))
    {
      this.lln.setText(paramString1);
      this.lln.setVisibility(0);
    }
    for (;;)
    {
      if (!bt.isNullOrNil(paramString2))
      {
        z.a(getContext(), this.swB, paramString2);
        this.swB.setVisibility(0);
      }
      AppMethodBeat.o(64996);
      return;
      this.lln.setVisibility(8);
    }
  }
  
  private void l(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(65004);
    int i = (int)(com.tencent.mm.cd.a.ap(getContext(), paramInt) * com.tencent.mm.cd.a.hG(getContext()));
    paramInt = com.tencent.mm.cd.a.ao(getContext(), paramInt);
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
    this.oTe = paramInt;
    this.sZQ = 1;
    cKX();
    hd(paramString1, paramString2);
    he(null, paramString3);
    this.sZT.setOnClickListener(null);
    this.sZT.setVisibility(8);
    P(paramBoolean1, paramBoolean2);
    cLd();
    AppMethodBeat.o(64993);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(64992);
    cKX();
    hd(paramString1, paramString2);
    he(paramString3, paramString4);
    this.sZT.setOnClickListener(new v()
    {
      public final void bOU()
      {
        AppMethodBeat.i(64986);
        WxaLuckyMoneyReceiveUI.a(WxaLuckyMoneyReceiveUI.this);
        if (WxaLuckyMoneyReceiveUI.b(WxaLuckyMoneyReceiveUI.this) != null) {
          WxaLuckyMoneyReceiveUI.b(WxaLuckyMoneyReceiveUI.this).cLa();
        }
        AppMethodBeat.o(64986);
      }
    });
    this.sZT.setVisibility(0);
    P(paramBoolean1, paramBoolean2);
    cLd();
    AppMethodBeat.o(64992);
  }
  
  public final MMActivity cKW()
  {
    return this;
  }
  
  public final void cKX()
  {
    AppMethodBeat.i(64991);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(64991);
  }
  
  public final void cLc()
  {
    AppMethodBeat.i(64990);
    z.d(this.sZT);
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
    this.sZX = findViewById(2131301918);
    this.sZc = ((ImageView)findViewById(2131301921));
    this.sZS = ((TextView)findViewById(2131301922));
    this.lln = ((TextView)findViewById(2131301924));
    this.swB = ((TextView)findViewById(2131301928));
    this.sZT = ((Button)findViewById(2131301932));
    this.sZW = ((TextView)findViewById(2131301929));
    this.sZU = findViewById(2131301930);
    this.sZV = ((ImageView)findViewById(2131301718));
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
    l(this.sZS, 2131166507);
    l(this.lln, 2131166508);
    l(this.swB, 2131166509);
    getContentView().setVisibility(8);
    this.tipDialog = h.b(getContext(), getString(2131760709), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(64989);
        WxaLuckyMoneyReceiveUI.this.cKX();
        if ((WxaLuckyMoneyReceiveUI.e(WxaLuckyMoneyReceiveUI.this).getVisibility() == 8) || (WxaLuckyMoneyReceiveUI.f(WxaLuckyMoneyReceiveUI.this).getVisibility() == 4))
        {
          ad.i("MicroMsg.WxaLuckyMoneyReceiveUI", "user cancel & finish");
          WxaLuckyMoneyReceiveUI.d(WxaLuckyMoneyReceiveUI.this);
          WxaLuckyMoneyReceiveUI.this.finish();
        }
        AppMethodBeat.o(64989);
      }
    });
    this.tipDialog.show();
    cLe();
    AppMethodBeat.o(65003);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(65001);
    fV(this.sZQ, this.oTe);
    finish();
    AppMethodBeat.o(65001);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64998);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.WxaLuckyMoneyReceiveUI", "WxaLuckyMoneyReceiveUI.onCreate ");
    initView();
    getIntent();
    this.sZR = new c();
    this.sZR.d(this, getIntent());
    AppMethodBeat.o(64998);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65000);
    super.onDestroy();
    ad.i("MicroMsg.WxaLuckyMoneyReceiveUI", "WxaLuckyMoneyReceiveUI.onDestroy ");
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (this.sZR != null)
    {
      this.sZR.onDestroy();
      this.sZR = null;
    }
    AppMethodBeat.o(65000);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(64999);
    super.onResume();
    z.d(this.sZT);
    this.sZT.setBackgroundResource(2131232316);
    cLe();
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