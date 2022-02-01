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
import com.tencent.mm.plugin.luckymoney.ui.k;
import com.tencent.mm.plugin.luckymoney.ui.k.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public abstract class WxaLuckyMoneyBaseUI
  extends MMActivity
{
  private c yPO = null;
  private int yPP = 4095;
  private final SparseArray<d.a> yPQ = new SparseArray();
  private final Class[][] yPR;
  
  public WxaLuckyMoneyBaseUI()
  {
    Class[] arrayOfClass = { com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.b.class, WxaLuckyMoneyCompleteUI.class };
    this.yPR = new Class[][] { { com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.b.class, WxaLuckyMoneyReceiveUI.class }, { com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.c.class, WxaLuckyMoneyPrepareUI.class }, { com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.b.class, WxaLuckyMoneyDetailUI.class }, arrayOfClass };
  }
  
  private Class<? extends MMActivity> aR(Class paramClass)
  {
    Class<? extends MMActivity> localClass = null;
    Class[][] arrayOfClass = this.yPR;
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
  
  public final void A(Drawable paramDrawable)
  {
    this.yPO.A(paramDrawable);
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
    paramIntent = aR(paramClass);
    if (paramIntent == null) {
      throw new IllegalStateException("proceed to ui = [" + paramClass.getName() + "], but Target is null");
    }
    localIntent.setClass(getContext(), paramIntent);
    if (parama == null)
    {
      paramClass = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramClass.axQ(), "com/tencent/mm/plugin/luckymoney/appbrand/ui/WxaLuckyMoneyBaseUI", "proceed", "(Ljava/lang/Class;Landroid/content/Intent;Lcom/tencent/mm/plugin/luckymoney/appbrand/ui/WxaLuckyMoneyUIRouter$OnBackListener;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramClass.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/WxaLuckyMoneyBaseUI", "proceed", "(Ljava/lang/Class;Landroid/content/Intent;Lcom/tencent/mm/plugin/luckymoney/appbrand/ui/WxaLuckyMoneyUIRouter$OnBackListener;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      return;
    }
    int i = this.yPP;
    this.yPP = (i + 1);
    startActivityForResult(localIntent, i);
    this.yPQ.put(i, parama);
  }
  
  public final void f(int paramInt, Intent paramIntent)
  {
    setResult(paramInt, paramIntent);
    finish();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    d.a locala = (d.a)this.yPQ.get(paramInt1);
    if (locala != null)
    {
      Log.i("MicroMsg.HjLuckyMoneyBaseUI", "damon warns you, requestCode == [%d], I used it, and skip. check your code if needed!!!!", new Object[] { Integer.valueOf(paramInt1) });
      locala.g(paramInt2, paramIntent);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.yPO = new c(this);
    this.yPO.ziK = 1;
    paramBundle = this.yPO;
    Object localObject1 = paramBundle.qdG;
    int i = paramBundle.ziK;
    k.a locala = new k.a();
    localObject1 = ((Context)localObject1).getResources();
    switch (i)
    {
    default: 
      locala.ziM = ((Resources)localObject1).getDrawable(2131233600);
      locala.oAk = -1;
      locala.ziO = ((Resources)localObject1).getColor(2131100769);
    }
    for (locala.olA = ((Resources)localObject1).getColor(2131100729);; locala.olA = ((Resources)localObject1).getColor(2131100751))
    {
      if (paramBundle.qdG.getSupportActionBar() != null)
      {
        if (locala.ziM != null) {
          paramBundle.qdG.getSupportActionBar().setBackgroundDrawable(locala.ziM);
        }
        localObject1 = paramBundle.qdG.getSupportActionBar().getCustomView();
        if (localObject1 != null)
        {
          Object localObject2 = ((View)localObject1).findViewById(2131299682);
          if ((localObject2 != null) && (locala.oAk != 0)) {
            ((View)localObject2).setBackgroundColor(locala.oAk);
          }
          localObject2 = (TextView)((View)localObject1).findViewById(16908308);
          if ((localObject2 != null) && (locala.ziN != 0)) {
            ((TextView)localObject2).setTextColor(locala.ziN);
          }
          localObject2 = (TextView)((View)localObject1).findViewById(16908309);
          if ((localObject2 != null) && (locala.ziO != 0)) {
            ((TextView)localObject2).setTextColor(locala.ziO);
          }
          localObject1 = (ImageView)((View)localObject1).findViewById(2131296449);
          if ((localObject1 != null) && (locala.ziP != 0)) {
            ((ImageView)localObject1).setImageResource(locala.ziP);
          }
        }
        if (locala.olA != 0)
        {
          i = locala.olA;
          if (k.egG())
          {
            paramBundle = paramBundle.qdG.getWindow();
            paramBundle.addFlags(-2147483648);
            paramBundle.setStatusBarColor(i);
          }
        }
      }
      return;
      locala.ziM = new ColorDrawable(((Resources)localObject1).getColor(2131100736));
      locala.oAk = ((Resources)localObject1).getColor(2131100737);
      locala.ziN = ((Resources)localObject1).getColor(2131100744);
      locala.ziO = ((Resources)localObject1).getColor(2131100744);
      locala.ziP = 2131233611;
    }
  }
  
  public void onDestroy()
  {
    this.yPO = null;
    this.yPQ.clear();
    super.onDestroy();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI
 * JD-Core Version:    0.7.0.1
 */