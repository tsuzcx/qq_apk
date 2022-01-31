package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.luckymoney.b.j;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class LuckyMoneyBaseUI
  extends MMActivity
  implements com.tencent.mm.wallet_core.c.f, com.tencent.mm.wallet_core.d.f
{
  public j lUq = null;
  private LinkedList<com.tencent.mm.wallet_core.c.h> lUr = new LinkedList();
  
  public static void bgb() {}
  
  public final void a(com.tencent.mm.wallet_core.c.h paramh)
  {
    if (!this.lUr.contains(paramh)) {
      this.lUr.add(paramh);
    }
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, m paramm, boolean paramBoolean)
  {
    if ((!c(paramInt1, paramInt2, paramString, paramm)) && ((paramInt1 != 0) || (paramInt2 != 0)))
    {
      com.tencent.mm.ui.base.h.bC(this, paramString);
      finish();
    }
  }
  
  public final void b(m paramm, boolean paramBoolean)
  {
    this.lUq.b(paramm, paramBoolean);
  }
  
  public final void bgc()
  {
    if (getSupportActionBar() != null)
    {
      getSupportActionBar().show();
      ta(getResources().getColor(a.c.lucky_money_goldstyle_actionbar_bg_color));
    }
  }
  
  public final void bgd()
  {
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
  }
  
  public abstract boolean c(int paramInt1, int paramInt2, String paramString, m paramm);
  
  public final void kh(int paramInt)
  {
    this.lUq.kh(paramInt);
  }
  
  public final void ki(int paramInt)
  {
    this.lUq.ki(paramInt);
  }
  
  public final void l(m paramm)
  {
    this.lUq.b(paramm, true);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    paramIntent = ((List)this.lUr.clone()).iterator();
    while (paramIntent.hasNext()) {
      ((com.tencent.mm.wallet_core.c.h)paramIntent.next()).cMt();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.uMp = true;
    super.onCreate(paramBundle);
    this.lUq = new j(this, this);
    this.lUq.kh(1554);
    this.lUq.kh(1575);
    this.lUq.kh(1668);
    this.lUq.kh(1581);
    this.lUq.kh(1685);
    this.lUq.kh(1585);
    this.lUq.kh(1514);
    this.lUq.kh(1682);
    this.lUq.kh(1612);
    this.lUq.kh(1643);
    this.lUq.kh(1558);
    ta(getResources().getColor(a.c.lucky_money_goldstyle_actionbar_bg_color));
    FR(getResources().getColor(a.c.lucky_money_goldstyle_envelop_primary_text_color));
    getLayoutId();
    paramBundle = ((List)this.lUr.clone()).iterator();
    while (paramBundle.hasNext()) {
      paramBundle.next();
    }
  }
  
  public void onDestroy()
  {
    this.lUq.ki(1554);
    this.lUq.ki(1575);
    this.lUq.ki(1668);
    this.lUq.ki(1581);
    this.lUq.ki(1685);
    this.lUq.ki(1585);
    this.lUq.ki(1514);
    this.lUq.ki(1682);
    this.lUq.ki(1612);
    this.lUq.ki(1643);
    this.lUq.ki(1558);
    Iterator localIterator = ((List)this.lUr.clone()).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.wallet_core.c.h)localIterator.next()).onDestroy();
    }
    this.lUr.clear();
    super.onDestroy();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.lUq.bfI()) {
        this.lUq.bfH();
      }
      if ((this.mController.contentView.getVisibility() == 8) || (this.mController.contentView.getVisibility() == 4)) {
        finish();
      }
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI
 * JD-Core Version:    0.7.0.1
 */