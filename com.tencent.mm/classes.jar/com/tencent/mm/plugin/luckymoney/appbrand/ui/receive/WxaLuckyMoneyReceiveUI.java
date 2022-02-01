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
import com.tencent.mm.ui.w;

@com.tencent.mm.ui.base.a(3)
public class WxaLuckyMoneyReceiveUI
  extends WxaLuckyMoneyBaseUI
  implements b
{
  private TextView mkS;
  private int pZU = -1;
  private p tipDialog = null;
  private TextView uGZ;
  private int vkO = -1;
  private a vkP;
  private TextView vkQ;
  private Button vkR;
  private View vkS;
  private ImageView vkT;
  private TextView vkU;
  private View vkV;
  private ImageView vka;
  
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
  
  private void V(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(64997);
    if (paramBoolean1)
    {
      this.vkS.setVisibility(0);
      if (paramBoolean2) {
        this.vkU.setText(2131760846);
      }
      for (;;)
      {
        this.vkT.setVisibility(8);
        this.vkS.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(64987);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/appbrand/ui/receive/WxaLuckyMoneyReceiveUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            WxaLuckyMoneyReceiveUI.c(WxaLuckyMoneyReceiveUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/receive/WxaLuckyMoneyReceiveUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(64987);
          }
        });
        AppMethodBeat.o(64997);
        return;
        this.vkU.setText(2131760838);
      }
    }
    this.vkS.setVisibility(8);
    this.vkT.setVisibility(0);
    AppMethodBeat.o(64997);
  }
  
  private void dhV()
  {
    AppMethodBeat.i(64994);
    z.a(this.vkV, null);
    getContentView().setVisibility(0);
    AppMethodBeat.o(64994);
  }
  
  private void dhW()
  {
    AppMethodBeat.i(65005);
    if (this.vkR == null)
    {
      AppMethodBeat.o(65005);
      return;
    }
    Object localObject = aj.getContext().getSharedPreferences(aj.fkC(), 0);
    aj.getContext();
    localObject = ac.f((SharedPreferences)localObject);
    if ((localObject != null) && (((String)localObject).length() > 0) && ((((String)localObject).equals("zh_CN")) || (((String)localObject).equals("zh_TW")) || (((String)localObject).equals("zh_HK"))))
    {
      AppMethodBeat.o(65005);
      return;
    }
    this.vkR.setBackgroundResource(2131233134);
    this.vkR.setText(2131760921);
    AppMethodBeat.o(65005);
  }
  
  private void gt(int paramInt1, int paramInt2)
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
  
  private void hI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(64995);
    z.b(this.vka, paramString2, null);
    z.a(getContext(), this.vkQ, paramString1);
    AppMethodBeat.o(64995);
  }
  
  private void hJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(64996);
    if (!bt.isNullOrNil(paramString1))
    {
      this.mkS.setText(paramString1);
      this.mkS.setVisibility(0);
    }
    for (;;)
    {
      if (!bt.isNullOrNil(paramString2))
      {
        z.a(getContext(), this.uGZ, paramString2);
        this.uGZ.setVisibility(0);
      }
      AppMethodBeat.o(64996);
      return;
      this.mkS.setVisibility(8);
    }
  }
  
  private void l(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(65004);
    int i = (int)(com.tencent.mm.cc.a.ay(getContext(), paramInt) * com.tencent.mm.cc.a.ia(getContext()));
    paramInt = com.tencent.mm.cc.a.ax(getContext(), paramInt);
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
    this.pZU = paramInt;
    this.vkO = 1;
    dhP();
    hI(paramString1, paramString2);
    hJ(null, paramString3);
    this.vkR.setOnClickListener(null);
    this.vkR.setVisibility(8);
    V(paramBoolean1, paramBoolean2);
    dhV();
    AppMethodBeat.o(64993);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(64992);
    dhP();
    hI(paramString1, paramString2);
    hJ(paramString3, paramString4);
    this.vkR.setOnClickListener(new w()
    {
      public final void caN()
      {
        AppMethodBeat.i(64986);
        WxaLuckyMoneyReceiveUI.a(WxaLuckyMoneyReceiveUI.this);
        if (WxaLuckyMoneyReceiveUI.b(WxaLuckyMoneyReceiveUI.this) != null) {
          WxaLuckyMoneyReceiveUI.b(WxaLuckyMoneyReceiveUI.this).dhS();
        }
        AppMethodBeat.o(64986);
      }
    });
    this.vkR.setVisibility(0);
    V(paramBoolean1, paramBoolean2);
    dhV();
    AppMethodBeat.o(64992);
  }
  
  public final MMActivity dhO()
  {
    return this;
  }
  
  public final void dhP()
  {
    AppMethodBeat.i(64991);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(64991);
  }
  
  public final void dhU()
  {
    AppMethodBeat.i(64990);
    z.d(this.vkR);
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
    this.vkV = findViewById(2131301918);
    this.vka = ((ImageView)findViewById(2131301921));
    this.vkQ = ((TextView)findViewById(2131301922));
    this.mkS = ((TextView)findViewById(2131301924));
    this.uGZ = ((TextView)findViewById(2131301928));
    this.vkR = ((Button)findViewById(2131301932));
    this.vkU = ((TextView)findViewById(2131301929));
    this.vkS = findViewById(2131301930);
    this.vkT = ((ImageView)findViewById(2131301718));
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/appbrand/ui/receive/WxaLuckyMoneyReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        WxaLuckyMoneyReceiveUI.d(WxaLuckyMoneyReceiveUI.this);
        WxaLuckyMoneyReceiveUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/receive/WxaLuckyMoneyReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64988);
      }
    });
    l(this.vkQ, 2131166507);
    l(this.mkS, 2131166508);
    l(this.uGZ, 2131166509);
    getContentView().setVisibility(8);
    this.tipDialog = h.b(getContext(), getString(2131760709), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(64989);
        WxaLuckyMoneyReceiveUI.this.dhP();
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
    dhW();
    AppMethodBeat.o(65003);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(65001);
    gt(this.vkO, this.pZU);
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
    this.vkP = new c();
    this.vkP.d(this, getIntent());
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
    if (this.vkP != null)
    {
      this.vkP.onDestroy();
      this.vkP = null;
    }
    AppMethodBeat.o(65000);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(64999);
    super.onResume();
    z.d(this.vkR);
    this.vkR.setBackgroundResource(2131232316);
    dhW();
    AppMethodBeat.o(64999);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.WxaLuckyMoneyReceiveUI
 * JD-Core Version:    0.7.0.1
 */