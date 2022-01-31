package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.luckymoney.model.s;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.d.f;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class LuckyMoneyBaseUI
  extends MMActivity
  implements com.tencent.mm.wallet_core.c.h, f
{
  private LinkedList<j> callbacks = new LinkedList();
  public s orz = null;
  
  public final void addSceneEndListener(int paramInt)
  {
    this.orz.addSceneEndListener(paramInt);
  }
  
  public final void bNP()
  {
    if (getSupportActionBar() != null)
    {
      getSupportActionBar().show();
      setActionbarColor(getResources().getColor(2131690229));
    }
  }
  
  protected final void bNQ()
  {
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
  }
  
  public final void doSceneProgress(m paramm)
  {
    this.orz.doSceneProgress(paramm, true);
  }
  
  public final void doSceneProgress(m paramm, boolean paramBoolean)
  {
    this.orz.doSceneProgress(paramm, paramBoolean);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    paramIntent = ((List)this.callbacks.clone()).iterator();
    while (paramIntent.hasNext()) {
      ((j)paramIntent.next()).dSk();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    fixStatusbar(true);
    super.onCreate(paramBundle);
    this.orz = new s(this, this);
    this.orz.addSceneEndListener(1554);
    this.orz.addSceneEndListener(1575);
    this.orz.addSceneEndListener(1668);
    this.orz.addSceneEndListener(1581);
    this.orz.addSceneEndListener(1685);
    this.orz.addSceneEndListener(1585);
    this.orz.addSceneEndListener(1514);
    this.orz.addSceneEndListener(1682);
    this.orz.addSceneEndListener(1612);
    this.orz.addSceneEndListener(1643);
    this.orz.addSceneEndListener(1558);
    this.orz.addSceneEndListener(2715);
    setActionbarColor(getResources().getColor(2131690229));
    setActionbarElementColor(getResources().getColor(2131690237));
    getLayoutId();
    paramBundle = ((List)this.callbacks.clone()).iterator();
    while (paramBundle.hasNext()) {
      paramBundle.next();
    }
  }
  
  public void onDestroy()
  {
    this.orz.removeSceneEndListener(1554);
    this.orz.removeSceneEndListener(1575);
    this.orz.removeSceneEndListener(1668);
    this.orz.removeSceneEndListener(1581);
    this.orz.removeSceneEndListener(1685);
    this.orz.removeSceneEndListener(1585);
    this.orz.removeSceneEndListener(1514);
    this.orz.removeSceneEndListener(1682);
    this.orz.removeSceneEndListener(1612);
    this.orz.removeSceneEndListener(1643);
    this.orz.removeSceneEndListener(1558);
    this.orz.removeSceneEndListener(2715);
    Iterator localIterator = ((List)this.callbacks.clone()).iterator();
    while (localIterator.hasNext()) {
      ((j)localIterator.next()).onDestroy();
    }
    this.callbacks.clear();
    super.onDestroy();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if ((this.orz != null) && (this.orz.isProcessing())) {
        this.orz.forceCancel();
      }
      if ((getContentView().getVisibility() == 8) || (getContentView().getVisibility() == 4)) {
        finish();
      }
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm, boolean paramBoolean)
  {
    if ((!onSceneEnd(paramInt1, paramInt2, paramString, paramm)) && ((paramInt1 != 0) || (paramInt2 != 0)))
    {
      com.tencent.mm.ui.base.h.bO(this, paramString);
      finish();
    }
  }
  
  public abstract boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm);
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void register(j paramj)
  {
    if (!this.callbacks.contains(paramj)) {
      this.callbacks.add(paramj);
    }
  }
  
  public final void removeSceneEndListener(int paramInt)
  {
    this.orz.removeSceneEndListener(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI
 * JD-Core Version:    0.7.0.1
 */