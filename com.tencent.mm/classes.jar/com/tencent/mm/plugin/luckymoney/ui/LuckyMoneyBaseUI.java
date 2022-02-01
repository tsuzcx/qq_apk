package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.luckymoney.model.u;
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
  public u usr = null;
  protected boolean uss = true;
  
  public final void addSceneEndListener(int paramInt)
  {
    this.usr.addSceneEndListener(paramInt);
  }
  
  public final void cZR()
  {
    if (getSupportActionBar() != null)
    {
      getSupportActionBar().show();
      setActionbarColor(getResources().getColor(2131100568));
    }
  }
  
  protected final void cZS()
  {
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
  }
  
  public final void doSceneProgress(n paramn)
  {
    this.usr.doSceneProgress(paramn, true);
  }
  
  public final void doSceneProgress(n paramn, boolean paramBoolean)
  {
    this.usr.doSceneProgress(paramn, paramBoolean);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    paramIntent = ((List)this.callbacks.clone()).iterator();
    while (paramIntent.hasNext()) {
      ((k)paramIntent.next()).fAi();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    fixStatusbar(true);
    super.onCreate(paramBundle);
    this.usr = new u(this, this);
    this.usr.addSceneEndListener(1554);
    this.usr.addSceneEndListener(1575);
    this.usr.addSceneEndListener(1668);
    this.usr.addSceneEndListener(1581);
    this.usr.addSceneEndListener(1685);
    this.usr.addSceneEndListener(1585);
    this.usr.addSceneEndListener(1514);
    this.usr.addSceneEndListener(1682);
    this.usr.addSceneEndListener(1612);
    this.usr.addSceneEndListener(1643);
    this.usr.addSceneEndListener(1558);
    this.usr.addSceneEndListener(2715);
    setActionbarColor(getResources().getColor(2131100568));
    if (this.uss) {
      setActionbarElementColor(getResources().getColor(2131100576));
    }
    getLayoutId();
    paramBundle = ((List)this.callbacks.clone()).iterator();
    while (paramBundle.hasNext()) {
      paramBundle.next();
    }
  }
  
  public void onDestroy()
  {
    this.usr.removeSceneEndListener(1554);
    this.usr.removeSceneEndListener(1575);
    this.usr.removeSceneEndListener(1668);
    this.usr.removeSceneEndListener(1581);
    this.usr.removeSceneEndListener(1685);
    this.usr.removeSceneEndListener(1585);
    this.usr.removeSceneEndListener(1514);
    this.usr.removeSceneEndListener(1682);
    this.usr.removeSceneEndListener(1612);
    this.usr.removeSceneEndListener(1643);
    this.usr.removeSceneEndListener(1558);
    this.usr.removeSceneEndListener(2715);
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
      if ((this.usr != null) && (this.usr.isProcessing())) {
        this.usr.forceCancel();
      }
      if ((getContentView().getVisibility() == 8) || (getContentView().getVisibility() == 4)) {
        finish();
      }
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn, boolean paramBoolean)
  {
    if ((!onSceneEnd(paramInt1, paramInt2, paramString, paramn)) && ((paramInt1 != 0) || (paramInt2 != 0)))
    {
      h.cg(this, paramString);
      finish();
    }
  }
  
  public abstract boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn);
  
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
    this.usr.removeSceneEndListener(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI
 * JD-Core Version:    0.7.0.1
 */