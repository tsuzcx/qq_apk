package com.tencent.mm.plugin.luckymoney.appbrand.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.WxaLuckyMoneyDetailUI;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyCompleteUI;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.WxaLuckyMoneyReceiveUI;
import com.tencent.mm.plugin.luckymoney.ui.k;
import com.tencent.mm.plugin.luckymoney.ui.k.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public abstract class WxaLuckyMoneyBaseUI
  extends MMActivity
{
  private c Kmu = null;
  private int Kmv = 4095;
  private final SparseArray<d.a> Kmw = new SparseArray();
  private final Class[][] Kmx;
  
  public WxaLuckyMoneyBaseUI()
  {
    Class[] arrayOfClass1 = { com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.b.class, WxaLuckyMoneyReceiveUI.class };
    Class[] arrayOfClass2 = { com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.b.class, WxaLuckyMoneyDetailUI.class };
    this.Kmx = new Class[][] { arrayOfClass1, { com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.c.class, WxaLuckyMoneyPrepareUI.class }, arrayOfClass2, { com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.b.class, WxaLuckyMoneyCompleteUI.class } };
  }
  
  private Class<? extends MMActivity> bT(Class paramClass)
  {
    Class<? extends MMActivity> localClass = null;
    Class[][] arrayOfClass = this.Kmx;
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
  
  public final void Q(Drawable paramDrawable)
  {
    this.Kmu.Q(paramDrawable);
  }
  
  public final void a(final Class paramClass, final Intent paramIntent, final d.a parama)
  {
    if (getMainLooper().getThread() != Thread.currentThread())
    {
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(64890);
          WxaLuckyMoneyBaseUI.this.a(paramClass, paramIntent, parama);
          AppMethodBeat.o(64890);
        }
      });
      return;
    }
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    paramIntent = bT(paramClass);
    if (paramIntent == null) {
      throw new IllegalStateException("proceed to ui = [" + paramClass.getName() + "], but Target is null");
    }
    localIntent.setClass(getContext(), paramIntent);
    if (parama == null)
    {
      paramClass = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramClass.aYi(), "com/tencent/mm/plugin/luckymoney/appbrand/ui/WxaLuckyMoneyBaseUI", "proceed", "(Ljava/lang/Class;Landroid/content/Intent;Lcom/tencent/mm/plugin/luckymoney/appbrand/ui/WxaLuckyMoneyUIRouter$OnBackListener;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramClass.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/WxaLuckyMoneyBaseUI", "proceed", "(Ljava/lang/Class;Landroid/content/Intent;Lcom/tencent/mm/plugin/luckymoney/appbrand/ui/WxaLuckyMoneyUIRouter$OnBackListener;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      return;
    }
    int i = this.Kmv;
    this.Kmv = (i + 1);
    startActivityForResult(localIntent, i);
    this.Kmw.put(i, parama);
  }
  
  public final void i(int paramInt, Intent paramIntent)
  {
    setResult(paramInt, paramIntent);
    finish();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    d.a locala = (d.a)this.Kmw.get(paramInt1);
    if (locala != null)
    {
      Log.i("MicroMsg.HjLuckyMoneyBaseUI", "damon warns you, requestCode == [%d], I used it, and skip. check your code if needed!!!!", new Object[] { Integer.valueOf(paramInt1) });
      locala.j(paramInt2, paramIntent);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.Kmu = new c(this);
    this.Kmu.KIz = 1;
    paramBundle = this.Kmu;
    Object localObject1 = paramBundle.pVV;
    int i = paramBundle.KIz;
    k.a locala = new k.a();
    localObject1 = ((Context)localObject1).getResources();
    switch (i)
    {
    default: 
      locala.KIB = ((Resources)localObject1).getDrawable(a.e.lucky_money_actionbar_bg);
      locala.uOk = -1;
      locala.KID = ((Resources)localObject1).getColor(a.c.lucky_money_subtitle_color);
    }
    for (locala.uxS = ((Resources)localObject1).getColor(a.c.lucky_money_base_status_bar_color);; locala.uxS = ((Resources)localObject1).getColor(a.c.lucky_money_goldstyle_status_bar_color))
    {
      if (paramBundle.pVV.getSupportActionBar() != null)
      {
        if (locala.KIB != null) {
          paramBundle.pVV.getSupportActionBar().setBackgroundDrawable(locala.KIB);
        }
        localObject1 = paramBundle.pVV.getSupportActionBar().getCustomView();
        if (localObject1 != null)
        {
          Object localObject2 = ((View)localObject1).findViewById(a.f.divider);
          if ((localObject2 != null) && (locala.uOk != 0)) {
            ((View)localObject2).setBackgroundColor(locala.uOk);
          }
          localObject2 = (TextView)((View)localObject1).findViewById(16908308);
          if ((localObject2 != null) && (locala.KIC != 0)) {
            ((TextView)localObject2).setTextColor(locala.KIC);
          }
          localObject2 = (TextView)((View)localObject1).findViewById(16908309);
          if ((localObject2 != null) && (locala.KID != 0)) {
            ((TextView)localObject2).setTextColor(locala.KID);
          }
          localObject1 = (ImageView)((View)localObject1).findViewById(a.f.actionbar_up_indicator_btn);
          if ((localObject1 != null) && (locala.KIE != 0)) {
            ((ImageView)localObject1).setImageResource(locala.KIE);
          }
        }
        if (locala.uxS != 0)
        {
          i = locala.uxS;
          if (k.fYW())
          {
            paramBundle = paramBundle.pVV.getWindow();
            paramBundle.addFlags(-2147483648);
            paramBundle.setStatusBarColor(i);
          }
        }
      }
      return;
      locala.KIB = new ColorDrawable(((Resources)localObject1).getColor(a.c.lucky_money_goldstyle_actionbar_bg_color));
      locala.uOk = ((Resources)localObject1).getColor(a.c.lucky_money_goldstyle_actionbar_primary_text_color);
      locala.KIC = ((Resources)localObject1).getColor(a.c.lucky_money_goldstyle_envelop_primary_text_color);
      locala.KID = ((Resources)localObject1).getColor(a.c.lucky_money_goldstyle_envelop_primary_text_color);
      locala.KIE = a.e.lucky_money_back_btn;
    }
  }
  
  public void onDestroy()
  {
    this.Kmu = null;
    this.Kmw.clear();
    super.onDestroy();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI
 * JD-Core Version:    0.7.0.1
 */