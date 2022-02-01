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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.w;

@com.tencent.mm.ui.base.a(3)
public class WxaLuckyMoneyReceiveUI
  extends WxaLuckyMoneyBaseUI
  implements b
{
  private TextView mpP;
  private int qgz = -1;
  private p tipDialog = null;
  private TextView uSM;
  private int vwT = -1;
  private a vwU;
  private TextView vwV;
  private Button vwW;
  private View vwX;
  private ImageView vwY;
  private TextView vwZ;
  private ImageView vwf;
  private View vxa;
  
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
  
  private void U(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(64997);
    if (paramBoolean1)
    {
      this.vwX.setVisibility(0);
      if (paramBoolean2) {
        this.vwZ.setText(2131760846);
      }
      for (;;)
      {
        this.vwY.setVisibility(8);
        this.vwX.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(64987);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/appbrand/ui/receive/WxaLuckyMoneyReceiveUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            WxaLuckyMoneyReceiveUI.c(WxaLuckyMoneyReceiveUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/receive/WxaLuckyMoneyReceiveUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(64987);
          }
        });
        AppMethodBeat.o(64997);
        return;
        this.vwZ.setText(2131760838);
      }
    }
    this.vwX.setVisibility(8);
    this.vwY.setVisibility(0);
    AppMethodBeat.o(64997);
  }
  
  private void dkU()
  {
    AppMethodBeat.i(64994);
    z.a(this.vxa, null);
    getContentView().setVisibility(0);
    AppMethodBeat.o(64994);
  }
  
  private void dkV()
  {
    AppMethodBeat.i(65005);
    if (this.vwW == null)
    {
      AppMethodBeat.o(65005);
      return;
    }
    Object localObject = ak.getContext().getSharedPreferences(ak.fow(), 0);
    ak.getContext();
    localObject = ad.f((SharedPreferences)localObject);
    if ((localObject != null) && (((String)localObject).length() > 0) && ((((String)localObject).equals("zh_CN")) || (((String)localObject).equals("zh_TW")) || (((String)localObject).equals("zh_HK"))))
    {
      AppMethodBeat.o(65005);
      return;
    }
    this.vwW.setBackgroundResource(2131233134);
    this.vwW.setText(2131760921);
    AppMethodBeat.o(65005);
  }
  
  private void gt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(65002);
    ae.i("MicroMsg.WxaLuckyMoneyReceiveUI", "setBackResult cgiType:[%d],errCode:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
  
  private void hP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(64995);
    z.b(this.vwf, paramString2, null);
    z.a(getContext(), this.vwV, paramString1);
    AppMethodBeat.o(64995);
  }
  
  private void hQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(64996);
    if (!bu.isNullOrNil(paramString1))
    {
      this.mpP.setText(paramString1);
      this.mpP.setVisibility(0);
    }
    for (;;)
    {
      if (!bu.isNullOrNil(paramString2))
      {
        z.a(getContext(), this.uSM, paramString2);
        this.uSM.setVisibility(0);
      }
      AppMethodBeat.o(64996);
      return;
      this.mpP.setVisibility(8);
    }
  }
  
  private void m(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(65004);
    int i = (int)(com.tencent.mm.cb.a.ay(getContext(), paramInt) * com.tencent.mm.cb.a.jdMethod_if(getContext()));
    paramInt = com.tencent.mm.cb.a.ax(getContext(), paramInt);
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
    this.qgz = paramInt;
    this.vwT = 1;
    dkO();
    hP(paramString1, paramString2);
    hQ(null, paramString3);
    this.vwW.setOnClickListener(null);
    this.vwW.setVisibility(8);
    U(paramBoolean1, paramBoolean2);
    dkU();
    AppMethodBeat.o(64993);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(64992);
    dkO();
    hP(paramString1, paramString2);
    hQ(paramString3, paramString4);
    this.vwW.setOnClickListener(new w()
    {
      public final void ccc()
      {
        AppMethodBeat.i(64986);
        WxaLuckyMoneyReceiveUI.a(WxaLuckyMoneyReceiveUI.this);
        if (WxaLuckyMoneyReceiveUI.b(WxaLuckyMoneyReceiveUI.this) != null) {
          WxaLuckyMoneyReceiveUI.b(WxaLuckyMoneyReceiveUI.this).dkR();
        }
        AppMethodBeat.o(64986);
      }
    });
    this.vwW.setVisibility(0);
    U(paramBoolean1, paramBoolean2);
    dkU();
    AppMethodBeat.o(64992);
  }
  
  public final MMActivity dkN()
  {
    return this;
  }
  
  public final void dkO()
  {
    AppMethodBeat.i(64991);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(64991);
  }
  
  public final void dkT()
  {
    AppMethodBeat.i(64990);
    z.d(this.vwW);
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
    this.vxa = findViewById(2131301918);
    this.vwf = ((ImageView)findViewById(2131301921));
    this.vwV = ((TextView)findViewById(2131301922));
    this.mpP = ((TextView)findViewById(2131301924));
    this.uSM = ((TextView)findViewById(2131301928));
    this.vwW = ((Button)findViewById(2131301932));
    this.vwZ = ((TextView)findViewById(2131301929));
    this.vwX = findViewById(2131301930);
    this.vwY = ((ImageView)findViewById(2131301718));
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
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/appbrand/ui/receive/WxaLuckyMoneyReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        WxaLuckyMoneyReceiveUI.d(WxaLuckyMoneyReceiveUI.this);
        WxaLuckyMoneyReceiveUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/receive/WxaLuckyMoneyReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64988);
      }
    });
    m(this.vwV, 2131166507);
    m(this.mpP, 2131166508);
    m(this.uSM, 2131166509);
    getContentView().setVisibility(8);
    this.tipDialog = h.b(getContext(), getString(2131760709), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(64989);
        WxaLuckyMoneyReceiveUI.this.dkO();
        if ((WxaLuckyMoneyReceiveUI.e(WxaLuckyMoneyReceiveUI.this).getVisibility() == 8) || (WxaLuckyMoneyReceiveUI.f(WxaLuckyMoneyReceiveUI.this).getVisibility() == 4))
        {
          ae.i("MicroMsg.WxaLuckyMoneyReceiveUI", "user cancel & finish");
          WxaLuckyMoneyReceiveUI.d(WxaLuckyMoneyReceiveUI.this);
          WxaLuckyMoneyReceiveUI.this.finish();
        }
        AppMethodBeat.o(64989);
      }
    });
    this.tipDialog.show();
    dkV();
    AppMethodBeat.o(65003);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(65001);
    gt(this.vwT, this.qgz);
    finish();
    AppMethodBeat.o(65001);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64998);
    super.onCreate(paramBundle);
    ae.i("MicroMsg.WxaLuckyMoneyReceiveUI", "WxaLuckyMoneyReceiveUI.onCreate ");
    initView();
    getIntent();
    this.vwU = new c();
    this.vwU.d(this, getIntent());
    AppMethodBeat.o(64998);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65000);
    super.onDestroy();
    ae.i("MicroMsg.WxaLuckyMoneyReceiveUI", "WxaLuckyMoneyReceiveUI.onDestroy ");
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (this.vwU != null)
    {
      this.vwU.onDestroy();
      this.vwU = null;
    }
    AppMethodBeat.o(65000);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(64999);
    super.onResume();
    z.d(this.vwW);
    this.vwW.setBackgroundResource(2131232316);
    dkV();
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