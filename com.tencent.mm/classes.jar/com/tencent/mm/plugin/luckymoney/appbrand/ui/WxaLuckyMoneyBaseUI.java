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
  private final Class[][] sYA;
  private c sYx = null;
  private int sYy = 4095;
  private final SparseArray<d.a> sYz = new SparseArray();
  
  public WxaLuckyMoneyBaseUI()
  {
    Class[] arrayOfClass1 = { com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.c.class, WxaLuckyMoneyPrepareUI.class };
    Class[] arrayOfClass2 = { com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.b.class, WxaLuckyMoneyDetailUI.class };
    this.sYA = new Class[][] { { com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.b.class, WxaLuckyMoneyReceiveUI.class }, arrayOfClass1, arrayOfClass2, { com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.b.class, WxaLuckyMoneyCompleteUI.class } };
  }
  
  private Class<? extends MMActivity> aO(Class paramClass)
  {
    Class<? extends MMActivity> localClass = null;
    Class[][] arrayOfClass = this.sYA;
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
    paramIntent = aO(paramClass);
    if (paramIntent == null) {
      throw new IllegalStateException("proceed to ui = [" + paramClass.getName() + "], but Target is null");
    }
    localIntent.setClass(getContext(), paramIntent);
    if (parama == null)
    {
      paramClass = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramClass.adn(), "com/tencent/mm/plugin/luckymoney/appbrand/ui/WxaLuckyMoneyBaseUI", "proceed", "(Ljava/lang/Class;Landroid/content/Intent;Lcom/tencent/mm/plugin/luckymoney/appbrand/ui/WxaLuckyMoneyUIRouter$OnBackListener;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramClass.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/WxaLuckyMoneyBaseUI", "proceed", "(Ljava/lang/Class;Landroid/content/Intent;Lcom/tencent/mm/plugin/luckymoney/appbrand/ui/WxaLuckyMoneyUIRouter$OnBackListener;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      return;
    }
    int i = this.sYy;
    this.sYy = (i + 1);
    startActivityForResult(localIntent, i);
    this.sYz.put(i, parama);
  }
  
  public final void e(int paramInt, Intent paramIntent)
  {
    setResult(paramInt, paramIntent);
    finish();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    d.a locala = (d.a)this.sYz.get(paramInt1);
    if (locala != null)
    {
      ad.i("MicroMsg.HjLuckyMoneyBaseUI", "damon warns you, requestCode == [%d], I used it, and skip. check your code if needed!!!!", new Object[] { Integer.valueOf(paramInt1) });
      locala.f(paramInt2, paramIntent);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.sYx = new c(this);
    this.sYx.tqo = 1;
    paramBundle = this.sYx;
    Object localObject1 = paramBundle.nCW;
    int i = paramBundle.tqo;
    j.a locala = new j.a();
    localObject1 = ((Context)localObject1).getResources();
    switch (i)
    {
    default: 
      locala.tqq = ((Resources)localObject1).getDrawable(2131232950);
      locala.miX = -1;
      locala.tqs = ((Resources)localObject1).getColor(2131100601);
    }
    for (locala.lQE = ((Resources)localObject1).getColor(2131100561);; locala.lQE = ((Resources)localObject1).getColor(2131100583))
    {
      if (paramBundle.nCW.getSupportActionBar() != null)
      {
        if (locala.tqq != null) {
          paramBundle.nCW.getSupportActionBar().setBackgroundDrawable(locala.tqq);
        }
        localObject1 = paramBundle.nCW.getSupportActionBar().getCustomView();
        if (localObject1 != null)
        {
          Object localObject2 = ((View)localObject1).findViewById(2131299154);
          if ((localObject2 != null) && (locala.miX != 0)) {
            ((View)localObject2).setBackgroundColor(locala.miX);
          }
          localObject2 = (TextView)((View)localObject1).findViewById(16908308);
          if ((localObject2 != null) && (locala.tqr != 0)) {
            ((TextView)localObject2).setTextColor(locala.tqr);
          }
          localObject2 = (TextView)((View)localObject1).findViewById(16908309);
          if ((localObject2 != null) && (locala.tqs != 0)) {
            ((TextView)localObject2).setTextColor(locala.tqs);
          }
          localObject1 = (ImageView)((View)localObject1).findViewById(2131296417);
          if ((localObject1 != null) && (locala.tqt != 0)) {
            ((ImageView)localObject1).setImageResource(locala.tqt);
          }
        }
        if (locala.lQE != 0)
        {
          i = locala.lQE;
          if (j.cMO())
          {
            paramBundle = paramBundle.nCW.getWindow();
            paramBundle.addFlags(-2147483648);
            paramBundle.setStatusBarColor(i);
          }
        }
      }
      return;
      locala.tqq = new ColorDrawable(((Resources)localObject1).getColor(2131100568));
      locala.miX = ((Resources)localObject1).getColor(2131100569);
      locala.tqr = ((Resources)localObject1).getColor(2131100576);
      locala.tqs = ((Resources)localObject1).getColor(2131100576);
      locala.tqt = 2131232961;
    }
  }
  
  public void onDestroy()
  {
    this.sYx = null;
    this.sYz.clear();
    super.onDestroy();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void z(Drawable paramDrawable)
  {
    this.sYx.z(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI
 * JD-Core Version:    0.7.0.1
 */