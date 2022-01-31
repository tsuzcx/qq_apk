package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.honey_pay.a.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.c.n.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(3)
public class HoneyPayProxyUI
  extends HoneyPayBaseUI
{
  private String lki;
  private boolean llS;
  
  protected final boolean aSl()
  {
    return true;
  }
  
  protected final void baU() {}
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((paramm instanceof l))
    {
      paramString = (l)paramm;
      paramString.a(new HoneyPayProxyUI.3(this, paramString)).b(new HoneyPayProxyUI.2(this)).c(new n.a()
      {
        public final void f(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ah.m paramAnonymousm) {}
      });
    }
    for (;;)
    {
      return true;
      if ((paramm instanceof com.tencent.mm.plugin.honey_pay.a.m))
      {
        paramString = (com.tencent.mm.plugin.honey_pay.a.m)paramm;
        paramString.a(new HoneyPayProxyUI.6(this, paramString)).b(new HoneyPayProxyUI.5(this)).c(new HoneyPayProxyUI.4(this));
      }
    }
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    kh(2876);
    kh(2613);
    this.llS = getIntent().getBooleanExtra("key_is_payer", false);
    this.lki = getIntent().getStringExtra("key_card_no");
    y.i(this.TAG, "is payer: %s", new Object[] { Boolean.valueOf(this.llS) });
    if (this.llS)
    {
      y.i(this.TAG, "do qry payer detail");
      paramBundle = new l(this.lki);
      paramBundle.m(this);
      a(paramBundle, true, false);
      return;
    }
    paramBundle = new com.tencent.mm.plugin.honey_pay.a.m(this.lki);
    paramBundle.m(this);
    a(paramBundle, true, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ki(2876);
    ki(2613);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayProxyUI
 * JD-Core Version:    0.7.0.1
 */