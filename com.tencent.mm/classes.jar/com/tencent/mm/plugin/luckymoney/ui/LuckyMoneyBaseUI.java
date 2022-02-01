package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.f;
import com.tencent.mm.wallet_core.model.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class LuckyMoneyBaseUI
  extends MMActivity
  implements f, i
{
  public z KzD = null;
  protected boolean KzE = true;
  private LinkedList<com.tencent.mm.wallet_core.model.k> callbacks = new LinkedList();
  
  public final void addSceneEndListener(int paramInt)
  {
    this.KzD.addSceneEndListener(paramInt);
  }
  
  public final void doSceneProgress(p paramp)
  {
    this.KzD.doSceneProgress(paramp, true);
  }
  
  public final void doSceneProgress(p paramp, boolean paramBoolean)
  {
    this.KzD.doSceneProgress(paramp, paramBoolean);
  }
  
  protected final void hideActionBar()
  {
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    paramIntent = ((List)this.callbacks.clone()).iterator();
    while (paramIntent.hasNext()) {
      ((com.tencent.mm.wallet_core.model.k)paramIntent.next()).jOI();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    fixStatusbar(true);
    super.onCreate(paramBundle);
    this.KzD = new z(this, this);
    this.KzD.addSceneEndListener(1554);
    this.KzD.addSceneEndListener(1575);
    this.KzD.addSceneEndListener(1668);
    this.KzD.addSceneEndListener(1581);
    this.KzD.addSceneEndListener(1685);
    this.KzD.addSceneEndListener(1585);
    this.KzD.addSceneEndListener(1514);
    this.KzD.addSceneEndListener(1682);
    this.KzD.addSceneEndListener(1612);
    this.KzD.addSceneEndListener(1643);
    this.KzD.addSceneEndListener(1558);
    this.KzD.addSceneEndListener(2715);
    this.KzD.addSceneEndListener(4605);
    this.KzD.addSceneEndListener(4915);
    this.KzD.addSceneEndListener(4536);
    this.KzD.addSceneEndListener(5148);
    this.KzD.addSceneEndListener(4395);
    this.KzD.addSceneEndListener(2832);
    this.KzD.addSceneEndListener(1647);
    this.KzD.addSceneEndListener(4373);
    this.KzD.addSceneEndListener(4595);
    this.KzD.addSceneEndListener(4339);
    this.KzD.addSceneEndListener(4717);
    this.KzD.addSceneEndListener(4878);
    setActionbarColor(getResources().getColor(a.c.lucky_money_goldstyle_actionbar_bg_color));
    if (this.KzE) {
      setActionbarElementColor(getResources().getColor(a.c.lucky_money_goldstyle_envelop_primary_text_color));
    }
    getLayoutId();
    paramBundle = ((List)this.callbacks.clone()).iterator();
    while (paramBundle.hasNext()) {
      paramBundle.next();
    }
  }
  
  public void onDestroy()
  {
    this.KzD.removeSceneEndListener(1554);
    this.KzD.removeSceneEndListener(1575);
    this.KzD.removeSceneEndListener(1668);
    this.KzD.removeSceneEndListener(1581);
    this.KzD.removeSceneEndListener(1685);
    this.KzD.removeSceneEndListener(1585);
    this.KzD.removeSceneEndListener(1514);
    this.KzD.removeSceneEndListener(1682);
    this.KzD.removeSceneEndListener(1612);
    this.KzD.removeSceneEndListener(1643);
    this.KzD.removeSceneEndListener(1558);
    this.KzD.removeSceneEndListener(2715);
    this.KzD.removeSceneEndListener(4605);
    this.KzD.removeSceneEndListener(4915);
    this.KzD.removeSceneEndListener(4536);
    this.KzD.removeSceneEndListener(5148);
    this.KzD.removeSceneEndListener(4395);
    this.KzD.removeSceneEndListener(2832);
    this.KzD.removeSceneEndListener(1647);
    this.KzD.removeSceneEndListener(4373);
    this.KzD.removeSceneEndListener(4595);
    this.KzD.removeSceneEndListener(4339);
    this.KzD.removeSceneEndListener(4717);
    this.KzD.removeSceneEndListener(4878);
    Iterator localIterator = ((List)this.callbacks.clone()).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.wallet_core.model.k)localIterator.next()).onDestroy();
    }
    this.callbacks.clear();
    super.onDestroy();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if ((this.KzD != null) && (this.KzD.isProcessing())) {
        this.KzD.forceCancel();
      }
      if ((getContentView().getVisibility() == 8) || (getContentView().getVisibility() == 4)) {
        finish();
      }
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp, boolean paramBoolean)
  {
    if ((!onSceneEnd(paramInt1, paramInt2, paramString, paramp)) && ((paramInt1 != 0) || (paramInt2 != 0)))
    {
      com.tencent.mm.ui.base.k.cZ(this, paramString);
      finish();
    }
  }
  
  public abstract boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp);
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void register(com.tencent.mm.wallet_core.model.k paramk)
  {
    if (!this.callbacks.contains(paramk)) {
      this.callbacks.add(paramk);
    }
  }
  
  public final void removeSceneEndListener(int paramInt)
  {
    this.KzD.removeSceneEndListener(paramInt);
  }
  
  public final void showActionBar()
  {
    if (getSupportActionBar() != null)
    {
      getSupportActionBar().show();
      setActionbarColor(getResources().getColor(a.c.lucky_money_goldstyle_actionbar_bg_color));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI
 * JD-Core Version:    0.7.0.1
 */