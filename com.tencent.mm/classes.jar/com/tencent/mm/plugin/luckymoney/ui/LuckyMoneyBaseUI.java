package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
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
  public u tjY = null;
  protected boolean tjZ = true;
  
  public final void addSceneEndListener(int paramInt)
  {
    this.tjY.addSceneEndListener(paramInt);
  }
  
  public final void cMl()
  {
    if (getSupportActionBar() != null)
    {
      getSupportActionBar().show();
      setActionbarColor(getResources().getColor(2131100568));
    }
  }
  
  protected final void cMm()
  {
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
  }
  
  public final void doSceneProgress(n paramn)
  {
    this.tjY.doSceneProgress(paramn, true);
  }
  
  public final void doSceneProgress(n paramn, boolean paramBoolean)
  {
    this.tjY.doSceneProgress(paramn, paramBoolean);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    paramIntent = ((List)this.callbacks.clone()).iterator();
    while (paramIntent.hasNext()) {
      ((k)paramIntent.next()).fjT();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    fixStatusbar(true);
    super.onCreate(paramBundle);
    this.tjY = new u(this, this);
    this.tjY.addSceneEndListener(1554);
    this.tjY.addSceneEndListener(1575);
    this.tjY.addSceneEndListener(1668);
    this.tjY.addSceneEndListener(1581);
    this.tjY.addSceneEndListener(1685);
    this.tjY.addSceneEndListener(1585);
    this.tjY.addSceneEndListener(1514);
    this.tjY.addSceneEndListener(1682);
    this.tjY.addSceneEndListener(1612);
    this.tjY.addSceneEndListener(1643);
    this.tjY.addSceneEndListener(1558);
    this.tjY.addSceneEndListener(2715);
    setActionbarColor(getResources().getColor(2131100568));
    if (this.tjZ) {
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
    this.tjY.removeSceneEndListener(1554);
    this.tjY.removeSceneEndListener(1575);
    this.tjY.removeSceneEndListener(1668);
    this.tjY.removeSceneEndListener(1581);
    this.tjY.removeSceneEndListener(1685);
    this.tjY.removeSceneEndListener(1585);
    this.tjY.removeSceneEndListener(1514);
    this.tjY.removeSceneEndListener(1682);
    this.tjY.removeSceneEndListener(1612);
    this.tjY.removeSceneEndListener(1643);
    this.tjY.removeSceneEndListener(1558);
    this.tjY.removeSceneEndListener(2715);
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
      if ((this.tjY != null) && (this.tjY.isProcessing())) {
        this.tjY.forceCancel();
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
      h.cf(this, paramString);
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
    this.tjY.removeSceneEndListener(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI
 * JD-Core Version:    0.7.0.1
 */