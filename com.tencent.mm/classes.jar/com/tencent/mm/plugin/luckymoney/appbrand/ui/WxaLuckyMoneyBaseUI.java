package com.tencent.mm.plugin.luckymoney.appbrand.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.ActionBar;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.WxaLuckyMoneyDetailUI;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyCompleteUI;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.WxaLuckyMoneyReceiveUI;
import com.tencent.mm.plugin.luckymoney.ui.j;
import com.tencent.mm.plugin.luckymoney.ui.j.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

public abstract class WxaLuckyMoneyBaseUI
  extends MMActivity
{
  private c lLq = null;
  private int lLr = 4095;
  private final SparseArray<d.a> lLs = new SparseArray();
  private final Class[][] lLt;
  
  public WxaLuckyMoneyBaseUI()
  {
    Class[] arrayOfClass1 = { com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.b.class, WxaLuckyMoneyReceiveUI.class };
    Class[] arrayOfClass2 = { com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.b.class, WxaLuckyMoneyDetailUI.class };
    Class[] arrayOfClass3 = { com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.b.class, WxaLuckyMoneyCompleteUI.class };
    this.lLt = new Class[][] { arrayOfClass1, { com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.c.class, WxaLuckyMoneyPrepareUI.class }, arrayOfClass2, arrayOfClass3 };
  }
  
  private Class<? extends MMActivity> P(Class paramClass)
  {
    Class<? extends MMActivity> localClass = null;
    Class[][] arrayOfClass = this.lLt;
    int j = arrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      Class[] arrayOfClass1 = arrayOfClass[i];
      if (arrayOfClass1[0] == paramClass) {
        localClass = arrayOfClass1[1];
      }
      i += 1;
    }
    return localClass;
  }
  
  public final void a(Class paramClass, Intent paramIntent, d.a parama)
  {
    if (getMainLooper().getThread() != Thread.currentThread())
    {
      runOnUiThread(new WxaLuckyMoneyBaseUI.1(this, paramClass, paramIntent, parama));
      return;
    }
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    paramIntent = P(paramClass);
    if (paramIntent == null) {
      throw new IllegalStateException("proceed to ui = [" + paramClass.getName() + "], but Target is null");
    }
    localIntent.setClass(this.mController.uMN, paramIntent);
    if (parama == null)
    {
      startActivity(localIntent);
      return;
    }
    int i = this.lLr;
    this.lLr = (i + 1);
    startActivityForResult(localIntent, i);
    this.lLs.put(i, parama);
  }
  
  public final void b(int paramInt, Intent paramIntent)
  {
    setResult(paramInt, paramIntent);
    finish();
  }
  
  public final void o(Drawable paramDrawable)
  {
    this.lLq.o(paramDrawable);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    d.a locala = (d.a)this.lLs.get(paramInt1);
    if (locala != null)
    {
      y.i("MicroMsg.HjLuckyMoneyBaseUI", "damon warns you, requestCode == [%d], I used it, and skip. check your code if needed!!!!", new Object[] { Integer.valueOf(paramInt1) });
      locala.c(paramInt2, paramIntent);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.lLq = new c(this);
    this.lLq.lXG = 1;
    paramBundle = this.lLq;
    Object localObject1 = paramBundle.iwz;
    int i = paramBundle.lXG;
    j.a locala = new j.a();
    localObject1 = ((Context)localObject1).getResources();
    switch (i)
    {
    default: 
      locala.lXI = ((Resources)localObject1).getDrawable(a.e.lucky_money_actionbar_bg);
      locala.hAE = -1;
      locala.lXK = ((Resources)localObject1).getColor(a.c.lucky_money_subtitle_color);
    }
    for (locala.lXM = ((Resources)localObject1).getColor(a.c.lucky_money_base_status_bar_color);; locala.lXM = ((Resources)localObject1).getColor(a.c.lucky_money_goldstyle_status_bar_color))
    {
      if (paramBundle.iwz.getSupportActionBar() != null)
      {
        if (locala.lXI != null) {
          paramBundle.iwz.getSupportActionBar().setBackgroundDrawable(locala.lXI);
        }
        localObject1 = paramBundle.iwz.getSupportActionBar().getCustomView();
        if (localObject1 != null)
        {
          Object localObject2 = ((View)localObject1).findViewById(a.f.divider);
          if ((localObject2 != null) && (locala.hAE != 0)) {
            ((View)localObject2).setBackgroundColor(locala.hAE);
          }
          localObject2 = (TextView)((View)localObject1).findViewById(16908308);
          if ((localObject2 != null) && (locala.lXJ != 0)) {
            ((TextView)localObject2).setTextColor(locala.lXJ);
          }
          localObject2 = (TextView)((View)localObject1).findViewById(16908309);
          if ((localObject2 != null) && (locala.lXK != 0)) {
            ((TextView)localObject2).setTextColor(locala.lXK);
          }
          localObject1 = (ImageView)((View)localObject1).findViewById(a.f.actionbar_up_indicator_btn);
          if ((localObject1 != null) && (locala.lXL != 0)) {
            ((ImageView)localObject1).setImageResource(locala.lXL);
          }
        }
        if (locala.lXM != 0)
        {
          i = locala.lXM;
          if (j.bgt())
          {
            paramBundle = paramBundle.iwz.getWindow();
            paramBundle.addFlags(-2147483648);
            paramBundle.setStatusBarColor(i);
          }
        }
      }
      return;
      locala.lXI = new ColorDrawable(((Resources)localObject1).getColor(a.c.lucky_money_goldstyle_actionbar_bg_color));
      locala.hAE = ((Resources)localObject1).getColor(a.c.lucky_money_goldstyle_actionbar_primary_text_color);
      locala.lXJ = ((Resources)localObject1).getColor(a.c.lucky_money_goldstyle_envelop_primary_text_color);
      locala.lXK = ((Resources)localObject1).getColor(a.c.lucky_money_goldstyle_envelop_primary_text_color);
      locala.lXL = a.e.lucky_money_back_btn;
    }
  }
  
  public void onDestroy()
  {
    this.lLq = null;
    this.lLs.clear();
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI
 * JD-Core Version:    0.7.0.1
 */