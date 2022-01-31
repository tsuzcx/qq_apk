package com.tencent.mm.plugin.luckymoney.appbrand.ui.receive;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

@com.tencent.mm.ui.base.a(3)
public class WxaLuckyMoneyReceiveUI
  extends WxaLuckyMoneyBaseUI
  implements b
{
  private TextView kRB;
  private int lCs = -1;
  private TextView nIU;
  private ImageView ojp;
  private int okd = -1;
  private a oke;
  private TextView okf;
  private Button okg;
  private View okh;
  private ImageView oki;
  private TextView okj;
  private View okk;
  private p tipDialog = null;
  
  static
  {
    AppMethodBeat.i(42122);
    if (!WxaLuckyMoneyReceiveUI.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(42122);
      return;
    }
  }
  
  private void C(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(42110);
    if (paramBoolean1)
    {
      this.okh.setVisibility(0);
      if (paramBoolean2) {
        this.okj.setText(2131301211);
      }
      for (;;)
      {
        this.oki.setVisibility(8);
        this.okh.setOnClickListener(new WxaLuckyMoneyReceiveUI.2(this));
        AppMethodBeat.o(42110);
        return;
        this.okj.setText(2131301204);
      }
    }
    this.okh.setVisibility(8);
    this.oki.setVisibility(0);
    AppMethodBeat.o(42110);
  }
  
  private void bMU()
  {
    AppMethodBeat.i(42107);
    x.a(this.okk, null);
    getContentView().setVisibility(0);
    AppMethodBeat.o(42107);
  }
  
  private void bMV()
  {
    AppMethodBeat.i(42118);
    if (this.okg == null)
    {
      AppMethodBeat.o(42118);
      return;
    }
    Object localObject = ah.getContext().getSharedPreferences(ah.dsP(), 0);
    ah.getContext();
    localObject = aa.f((SharedPreferences)localObject);
    if ((localObject != null) && (((String)localObject).length() > 0) && ((((String)localObject).equals("zh_CN")) || (((String)localObject).equals("zh_TW")) || (((String)localObject).equals("zh_HK"))))
    {
      AppMethodBeat.o(42118);
      return;
    }
    this.okg.setBackgroundResource(2130839518);
    this.okg.setText(2131301279);
    AppMethodBeat.o(42118);
  }
  
  private void ez(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(42115);
    ab.i("MicroMsg.WxaLuckyMoneyReceiveUI", "setBackResult cgiType:[%d],errCode:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1)
    {
      setResult(0, new Intent().putExtra("result_error_code", 10001).putExtra("result_error_msg", "fail:no permission to receive the red packet"));
      AppMethodBeat.o(42115);
      return;
    }
    if (paramInt1 == 4) {
      setResult(0, new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{user cancel}}"));
    }
    AppMethodBeat.o(42115);
  }
  
  private void fb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(42108);
    x.b(this.ojp, paramString2, null);
    x.a(getContext(), this.okf, paramString1);
    AppMethodBeat.o(42108);
  }
  
  private void fc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(42109);
    if (!bo.isNullOrNil(paramString1))
    {
      this.kRB.setText(paramString1);
      this.kRB.setVisibility(0);
    }
    for (;;)
    {
      if (!bo.isNullOrNil(paramString2))
      {
        x.a(getContext(), this.nIU, paramString2);
        this.nIU.setVisibility(0);
      }
      AppMethodBeat.o(42109);
      return;
      this.kRB.setVisibility(8);
    }
  }
  
  private void i(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(42117);
    int i = (int)(com.tencent.mm.cb.a.ap(getContext(), paramInt) * com.tencent.mm.cb.a.gh(getContext()));
    paramInt = com.tencent.mm.cb.a.ao(getContext(), paramInt);
    if (paramInt > i) {
      paramInt = i;
    }
    for (;;)
    {
      paramTextView.setTextSize(0, paramInt);
      AppMethodBeat.o(42117);
      return;
    }
  }
  
  public final void Sp(String paramString) {}
  
  public final void a(String paramString1, String paramString2, int paramInt, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(42106);
    this.lCs = paramInt;
    this.okd = 1;
    bMO();
    fb(paramString1, paramString2);
    fc(null, paramString3);
    this.okg.setOnClickListener(null);
    this.okg.setVisibility(8);
    C(paramBoolean1, paramBoolean2);
    bMU();
    AppMethodBeat.o(42106);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(42105);
    bMO();
    fb(paramString1, paramString2);
    fc(paramString3, paramString4);
    this.okg.setOnClickListener(new WxaLuckyMoneyReceiveUI.1(this));
    this.okg.setVisibility(0);
    C(paramBoolean1, paramBoolean2);
    bMU();
    AppMethodBeat.o(42105);
  }
  
  public final MMActivity bMN()
  {
    return this;
  }
  
  public final void bMO()
  {
    AppMethodBeat.i(42104);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(42104);
  }
  
  public final void bMT()
  {
    AppMethodBeat.i(42103);
    x.d(this.okg);
    AppMethodBeat.o(42103);
  }
  
  public int getLayoutId()
  {
    return 2130971337;
  }
  
  public void initView()
  {
    AppMethodBeat.i(42116);
    this.okk = findViewById(2131825684);
    this.ojp = ((ImageView)findViewById(2131825680));
    this.okf = ((TextView)findViewById(2131825681));
    this.kRB = ((TextView)findViewById(2131825686));
    this.nIU = ((TextView)findViewById(2131825818));
    this.okg = ((Button)findViewById(2131825819));
    this.okj = ((TextView)findViewById(2131825821));
    this.okh = findViewById(2131825820);
    this.oki = ((ImageView)findViewById(2131825687));
    Object localObject = (ImageView)findViewById(2131825688);
    if ((!$assertionsDisabled) && (localObject == null))
    {
      localObject = new AssertionError();
      AppMethodBeat.o(42116);
      throw ((Throwable)localObject);
    }
    ((ImageView)localObject).setOnClickListener(new WxaLuckyMoneyReceiveUI.3(this));
    i(this.okf, 2131428518);
    i(this.kRB, 2131428519);
    i(this.nIU, 2131428520);
    getContentView().setVisibility(8);
    this.tipDialog = h.b(getContext(), getString(2131301086), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(42102);
        WxaLuckyMoneyReceiveUI.this.bMO();
        if ((WxaLuckyMoneyReceiveUI.e(WxaLuckyMoneyReceiveUI.this).getVisibility() == 8) || (WxaLuckyMoneyReceiveUI.f(WxaLuckyMoneyReceiveUI.this).getVisibility() == 4))
        {
          ab.i("MicroMsg.WxaLuckyMoneyReceiveUI", "user cancel & finish");
          WxaLuckyMoneyReceiveUI.d(WxaLuckyMoneyReceiveUI.this);
          WxaLuckyMoneyReceiveUI.this.finish();
        }
        AppMethodBeat.o(42102);
      }
    });
    this.tipDialog.show();
    bMV();
    AppMethodBeat.o(42116);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(42114);
    ez(this.okd, this.lCs);
    finish();
    AppMethodBeat.o(42114);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42111);
    super.onCreate(paramBundle);
    ab.i("MicroMsg.WxaLuckyMoneyReceiveUI", "WxaLuckyMoneyReceiveUI.onCreate ");
    initView();
    getIntent();
    this.oke = new c();
    this.oke.a(this, getIntent());
    AppMethodBeat.o(42111);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42113);
    super.onDestroy();
    ab.i("MicroMsg.WxaLuckyMoneyReceiveUI", "WxaLuckyMoneyReceiveUI.onDestroy ");
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (this.oke != null)
    {
      this.oke.onDestroy();
      this.oke = null;
    }
    AppMethodBeat.o(42113);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(42112);
    super.onResume();
    x.d(this.okg);
    this.okg.setBackgroundResource(2130838860);
    bMV();
    AppMethodBeat.o(42112);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.WxaLuckyMoneyReceiveUI
 * JD-Core Version:    0.7.0.1
 */