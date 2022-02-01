package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.luckymoney.model.aa;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.c.k;
import com.tencent.mm.wallet_core.d.f;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class LuckyMoneyBaseUI
  extends MMActivity
  implements i, f
{
  public aa EGu = null;
  protected boolean EGv = true;
  private LinkedList<k> callbacks = new LinkedList();
  
  public final void addSceneEndListener(int paramInt)
  {
    this.EGu.addSceneEndListener(paramInt);
  }
  
  public final void doSceneProgress(q paramq)
  {
    this.EGu.doSceneProgress(paramq, true);
  }
  
  public final void doSceneProgress(q paramq, boolean paramBoolean)
  {
    this.EGu.doSceneProgress(paramq, paramBoolean);
  }
  
  public final void ePA()
  {
    if (getSupportActionBar() != null)
    {
      getSupportActionBar().show();
      setActionbarColor(getResources().getColor(a.c.lucky_money_goldstyle_actionbar_bg_color));
    }
  }
  
  protected final void ePB()
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
      ((k)paramIntent.next()).iiN();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    fixStatusbar(true);
    super.onCreate(paramBundle);
    this.EGu = new aa(this, this);
    this.EGu.addSceneEndListener(1554);
    this.EGu.addSceneEndListener(1575);
    this.EGu.addSceneEndListener(1668);
    this.EGu.addSceneEndListener(1581);
    this.EGu.addSceneEndListener(1685);
    this.EGu.addSceneEndListener(1585);
    this.EGu.addSceneEndListener(1514);
    this.EGu.addSceneEndListener(1682);
    this.EGu.addSceneEndListener(1612);
    this.EGu.addSceneEndListener(1643);
    this.EGu.addSceneEndListener(1558);
    this.EGu.addSceneEndListener(2715);
    this.EGu.addSceneEndListener(4605);
    this.EGu.addSceneEndListener(4915);
    this.EGu.addSceneEndListener(4536);
    this.EGu.addSceneEndListener(5148);
    this.EGu.addSceneEndListener(4395);
    this.EGu.addSceneEndListener(4373);
    this.EGu.addSceneEndListener(4595);
    this.EGu.addSceneEndListener(4339);
    this.EGu.addSceneEndListener(4717);
    this.EGu.addSceneEndListener(4878);
    setActionbarColor(getResources().getColor(a.c.lucky_money_goldstyle_actionbar_bg_color));
    if (this.EGv) {
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
    this.EGu.removeSceneEndListener(1554);
    this.EGu.removeSceneEndListener(1575);
    this.EGu.removeSceneEndListener(1668);
    this.EGu.removeSceneEndListener(1581);
    this.EGu.removeSceneEndListener(1685);
    this.EGu.removeSceneEndListener(1585);
    this.EGu.removeSceneEndListener(1514);
    this.EGu.removeSceneEndListener(1682);
    this.EGu.removeSceneEndListener(1612);
    this.EGu.removeSceneEndListener(1643);
    this.EGu.removeSceneEndListener(1558);
    this.EGu.removeSceneEndListener(2715);
    this.EGu.removeSceneEndListener(4605);
    this.EGu.removeSceneEndListener(4915);
    this.EGu.removeSceneEndListener(4536);
    this.EGu.removeSceneEndListener(5148);
    this.EGu.removeSceneEndListener(4395);
    this.EGu.removeSceneEndListener(4373);
    this.EGu.removeSceneEndListener(4595);
    this.EGu.removeSceneEndListener(4339);
    this.EGu.removeSceneEndListener(4717);
    this.EGu.removeSceneEndListener(4878);
    Iterator localIterator = ((List)this.callbacks.clone()).iterator();
    while (localIterator.hasNext()) {
      ((k)localIterator.next()).onDestroy();
    }
    this.callbacks.clear();
    super.onDestroy();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if ((this.EGu != null) && (this.EGu.isProcessing())) {
        this.EGu.forceCancel();
      }
      if ((getContentView().getVisibility() == 8) || (getContentView().getVisibility() == 4)) {
        finish();
      }
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq, boolean paramBoolean)
  {
    if ((!onSceneEnd(paramInt1, paramInt2, paramString, paramq)) && ((paramInt1 != 0) || (paramInt2 != 0)))
    {
      h.cO(this, paramString);
      finish();
    }
  }
  
  public abstract boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq);
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void register(k paramk)
  {
    if (!this.callbacks.contains(paramk)) {
      this.callbacks.add(paramk);
    }
  }
  
  public final void removeSceneEndListener(int paramInt)
  {
    this.EGu.removeSceneEndListener(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI
 * JD-Core Version:    0.7.0.1
 */