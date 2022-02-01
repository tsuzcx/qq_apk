package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.luckymoney.model.z;
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
  private LinkedList<k> callbacks = new LinkedList();
  public z zbX = null;
  protected boolean zbY = true;
  
  public final void addSceneEndListener(int paramInt)
  {
    this.zbX.addSceneEndListener(paramInt);
  }
  
  public final void doSceneProgress(q paramq)
  {
    this.zbX.doSceneProgress(paramq, true);
  }
  
  public final void doSceneProgress(q paramq, boolean paramBoolean)
  {
    this.zbX.doSceneProgress(paramq, paramBoolean);
  }
  
  public final void efZ()
  {
    if (getSupportActionBar() != null)
    {
      getSupportActionBar().show();
      setActionbarColor(getResources().getColor(2131100736));
    }
  }
  
  protected final void ega()
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
      ((k)paramIntent.next()).hhl();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    fixStatusbar(true);
    super.onCreate(paramBundle);
    this.zbX = new z(this, this);
    this.zbX.addSceneEndListener(1554);
    this.zbX.addSceneEndListener(1575);
    this.zbX.addSceneEndListener(1668);
    this.zbX.addSceneEndListener(1581);
    this.zbX.addSceneEndListener(1685);
    this.zbX.addSceneEndListener(1585);
    this.zbX.addSceneEndListener(1514);
    this.zbX.addSceneEndListener(1682);
    this.zbX.addSceneEndListener(1612);
    this.zbX.addSceneEndListener(1643);
    this.zbX.addSceneEndListener(1558);
    this.zbX.addSceneEndListener(2715);
    this.zbX.addSceneEndListener(4605);
    this.zbX.addSceneEndListener(4915);
    this.zbX.addSceneEndListener(4536);
    this.zbX.addSceneEndListener(5148);
    this.zbX.addSceneEndListener(4395);
    setActionbarColor(getResources().getColor(2131100736));
    if (this.zbY) {
      setActionbarElementColor(getResources().getColor(2131100744));
    }
    getLayoutId();
    paramBundle = ((List)this.callbacks.clone()).iterator();
    while (paramBundle.hasNext()) {
      paramBundle.next();
    }
  }
  
  public void onDestroy()
  {
    this.zbX.removeSceneEndListener(1554);
    this.zbX.removeSceneEndListener(1575);
    this.zbX.removeSceneEndListener(1668);
    this.zbX.removeSceneEndListener(1581);
    this.zbX.removeSceneEndListener(1685);
    this.zbX.removeSceneEndListener(1585);
    this.zbX.removeSceneEndListener(1514);
    this.zbX.removeSceneEndListener(1682);
    this.zbX.removeSceneEndListener(1612);
    this.zbX.removeSceneEndListener(1643);
    this.zbX.removeSceneEndListener(1558);
    this.zbX.removeSceneEndListener(2715);
    this.zbX.removeSceneEndListener(4605);
    this.zbX.removeSceneEndListener(4915);
    this.zbX.removeSceneEndListener(4536);
    this.zbX.removeSceneEndListener(5148);
    this.zbX.removeSceneEndListener(4395);
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
      if ((this.zbX != null) && (this.zbX.isProcessing())) {
        this.zbX.forceCancel();
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
      h.cD(this, paramString);
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
    this.zbX.removeSceneEndListener(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI
 * JD-Core Version:    0.7.0.1
 */