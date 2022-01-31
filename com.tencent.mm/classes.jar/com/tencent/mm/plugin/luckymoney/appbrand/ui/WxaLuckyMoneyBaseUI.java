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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

public abstract class WxaLuckyMoneyBaseUI
  extends MMActivity
{
  private c oiK = null;
  private int oiL = 4095;
  private final SparseArray<d.a> oiM = new SparseArray();
  private final Class[][] oiN = { { com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.b.class, WxaLuckyMoneyReceiveUI.class }, { com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.c.class, WxaLuckyMoneyPrepareUI.class }, { com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.b.class, WxaLuckyMoneyDetailUI.class }, { com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.b.class, WxaLuckyMoneyCompleteUI.class } };
  
  private Class<? extends MMActivity> al(Class paramClass)
  {
    Class<? extends MMActivity> localClass = null;
    Class[][] arrayOfClass = this.oiN;
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
    paramIntent = al(paramClass);
    if (paramIntent == null) {
      throw new IllegalStateException("proceed to ui = [" + paramClass.getName() + "], but Target is null");
    }
    localIntent.setClass(getContext(), paramIntent);
    if (parama == null)
    {
      startActivity(localIntent);
      return;
    }
    int i = this.oiL;
    this.oiL = (i + 1);
    startActivityForResult(localIntent, i);
    this.oiM.put(i, parama);
  }
  
  public final void e(int paramInt, Intent paramIntent)
  {
    setResult(paramInt, paramIntent);
    finish();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    d.a locala = (d.a)this.oiM.get(paramInt1);
    if (locala != null)
    {
      ab.i("MicroMsg.HjLuckyMoneyBaseUI", "damon warns you, requestCode == [%d], I used it, and skip. check your code if needed!!!!", new Object[] { Integer.valueOf(paramInt1) });
      locala.f(paramInt2, paramIntent);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.oiK = new c(this);
    this.oiK.oxg = 1;
    paramBundle = this.oiK;
    Object localObject1 = paramBundle.kxD;
    int i = paramBundle.oxg;
    j.a locala = new j.a();
    localObject1 = ((Context)localObject1).getResources();
    switch (i)
    {
    default: 
      locala.oxi = ((Resources)localObject1).getDrawable(2130839340);
      locala.jsT = -1;
      locala.oxk = ((Resources)localObject1).getColor(2131690261);
    }
    for (locala.jaJ = ((Resources)localObject1).getColor(2131690225);; locala.jaJ = ((Resources)localObject1).getColor(2131690244))
    {
      if (paramBundle.kxD.getSupportActionBar() != null)
      {
        if (locala.oxi != null) {
          paramBundle.kxD.getSupportActionBar().setBackgroundDrawable(locala.oxi);
        }
        localObject1 = paramBundle.kxD.getSupportActionBar().getCustomView();
        if (localObject1 != null)
        {
          Object localObject2 = ((View)localObject1).findViewById(2131821148);
          if ((localObject2 != null) && (locala.jsT != 0)) {
            ((View)localObject2).setBackgroundColor(locala.jsT);
          }
          localObject2 = (TextView)((View)localObject1).findViewById(16908308);
          if ((localObject2 != null) && (locala.oxj != 0)) {
            ((TextView)localObject2).setTextColor(locala.oxj);
          }
          localObject2 = (TextView)((View)localObject1).findViewById(16908309);
          if ((localObject2 != null) && (locala.oxk != 0)) {
            ((TextView)localObject2).setTextColor(locala.oxk);
          }
          localObject1 = (ImageView)((View)localObject1).findViewById(2131820989);
          if ((localObject1 != null) && (locala.oxl != 0)) {
            ((ImageView)localObject1).setImageResource(locala.oxl);
          }
        }
        if (locala.jaJ != 0)
        {
          i = locala.jaJ;
          if (j.bOm())
          {
            paramBundle = paramBundle.kxD.getWindow();
            paramBundle.addFlags(-2147483648);
            paramBundle.setStatusBarColor(i);
          }
        }
      }
      return;
      locala.oxi = new ColorDrawable(((Resources)localObject1).getColor(2131690229));
      locala.jsT = ((Resources)localObject1).getColor(2131690230);
      locala.oxj = ((Resources)localObject1).getColor(2131690237);
      locala.oxk = ((Resources)localObject1).getColor(2131690237);
      locala.oxl = 2130839351;
    }
  }
  
  public void onDestroy()
  {
    this.oiK = null;
    this.oiM.clear();
    super.onDestroy();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void s(Drawable paramDrawable)
  {
    this.oiK.s(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI
 * JD-Core Version:    0.7.0.1
 */