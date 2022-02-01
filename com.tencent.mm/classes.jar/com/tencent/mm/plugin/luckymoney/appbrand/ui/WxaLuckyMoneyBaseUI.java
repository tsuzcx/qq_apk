package com.tencent.mm.plugin.luckymoney.appbrand.ui;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.WxaLuckyMoneyDetailUI;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyCompleteUI;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.WxaLuckyMoneyReceiveUI;
import com.tencent.mm.plugin.luckymoney.ui.j;
import com.tencent.mm.plugin.luckymoney.ui.j.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;

public abstract class WxaLuckyMoneyBaseUI
  extends MMActivity
{
  private c vjv = null;
  private int vjw = 4095;
  private final SparseArray<d.a> vjx = new SparseArray();
  private final Class[][] vjy;
  
  public WxaLuckyMoneyBaseUI()
  {
    Class[] arrayOfClass = { com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.b.class, WxaLuckyMoneyCompleteUI.class };
    this.vjy = new Class[][] { { com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.b.class, WxaLuckyMoneyReceiveUI.class }, { com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.c.class, WxaLuckyMoneyPrepareUI.class }, { com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.b.class, WxaLuckyMoneyDetailUI.class }, arrayOfClass };
  }
  
  private Class<? extends MMActivity> aP(Class paramClass)
  {
    Class<? extends MMActivity> localClass = null;
    Class[][] arrayOfClass = this.vjy;
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
    paramIntent = aP(paramClass);
    if (paramIntent == null) {
      throw new IllegalStateException("proceed to ui = [" + paramClass.getName() + "], but Target is null");
    }
    localIntent.setClass(getContext(), paramIntent);
    if (parama == null)
    {
      paramClass = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramClass.ahp(), "com/tencent/mm/plugin/luckymoney/appbrand/ui/WxaLuckyMoneyBaseUI", "proceed", "(Ljava/lang/Class;Landroid/content/Intent;Lcom/tencent/mm/plugin/luckymoney/appbrand/ui/WxaLuckyMoneyUIRouter$OnBackListener;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramClass.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/WxaLuckyMoneyBaseUI", "proceed", "(Ljava/lang/Class;Landroid/content/Intent;Lcom/tencent/mm/plugin/luckymoney/appbrand/ui/WxaLuckyMoneyUIRouter$OnBackListener;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      return;
    }
    int i = this.vjw;
    this.vjw = (i + 1);
    startActivityForResult(localIntent, i);
    this.vjx.put(i, parama);
  }
  
  public final void f(int paramInt, Intent paramIntent)
  {
    setResult(paramInt, paramIntent);
    finish();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    d.a locala = (d.a)this.vjx.get(paramInt1);
    if (locala != null)
    {
      ad.i("MicroMsg.HjLuckyMoneyBaseUI", "damon warns you, requestCode == [%d], I used it, and skip. check your code if needed!!!!", new Object[] { Integer.valueOf(paramInt1) });
      locala.g(paramInt2, paramIntent);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.vjv = new c(this);
    this.vjv.vBj = 1;
    paramBundle = this.vjv;
    Object localObject1 = paramBundle.oJq;
    int i = paramBundle.vBj;
    j.a locala = new j.a();
    localObject1 = ((Context)localObject1).getResources();
    switch (i)
    {
    default: 
      locala.vBl = ((Resources)localObject1).getDrawable(2131232950);
      locala.nlt = -1;
      locala.vBm = ((Resources)localObject1).getColor(2131100601);
    }
    for (locala.mTn = ((Resources)localObject1).getColor(2131100561);; locala.mTn = ((Resources)localObject1).getColor(2131100583))
    {
      if (paramBundle.oJq.getSupportActionBar() != null)
      {
        if (locala.vBl != null) {
          paramBundle.oJq.getSupportActionBar().setBackgroundDrawable(locala.vBl);
        }
        localObject1 = paramBundle.oJq.getSupportActionBar().getCustomView();
        if (localObject1 != null)
        {
          Object localObject2 = ((View)localObject1).findViewById(2131299154);
          if ((localObject2 != null) && (locala.nlt != 0)) {
            ((View)localObject2).setBackgroundColor(locala.nlt);
          }
          localObject2 = (TextView)((View)localObject1).findViewById(16908308);
          if ((localObject2 != null) && (locala.uZf != 0)) {
            ((TextView)localObject2).setTextColor(locala.uZf);
          }
          localObject2 = (TextView)((View)localObject1).findViewById(16908309);
          if ((localObject2 != null) && (locala.vBm != 0)) {
            ((TextView)localObject2).setTextColor(locala.vBm);
          }
          localObject1 = (ImageView)((View)localObject1).findViewById(2131296417);
          if ((localObject1 != null) && (locala.vBn != 0)) {
            ((ImageView)localObject1).setImageResource(locala.vBn);
          }
        }
        if (locala.mTn != 0)
        {
          i = locala.mTn;
          if (j.djH())
          {
            paramBundle = paramBundle.oJq.getWindow();
            paramBundle.addFlags(-2147483648);
            paramBundle.setStatusBarColor(i);
          }
        }
      }
      return;
      locala.vBl = new ColorDrawable(((Resources)localObject1).getColor(2131100568));
      locala.nlt = ((Resources)localObject1).getColor(2131100569);
      locala.uZf = ((Resources)localObject1).getColor(2131100576);
      locala.vBm = ((Resources)localObject1).getColor(2131100576);
      locala.vBn = 2131232961;
    }
  }
  
  public void onDestroy()
  {
    this.vjv = null;
    this.vjx.clear();
    super.onDestroy();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void z(Drawable paramDrawable)
  {
    this.vjv.z(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI
 * JD-Core Version:    0.7.0.1
 */