package com.tencent.mm.plugin.honey_pay.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.honey_pay.a.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.p;

@a(3)
public class HoneyPayProxyUI
  extends HoneyPayBaseUI
{
  private String nHE;
  private boolean nJo;
  
  protected final void bHV() {}
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41929);
    super.onCreate(paramBundle);
    addSceneEndListener(2876);
    addSceneEndListener(2613);
    this.nJo = getIntent().getBooleanExtra("key_is_payer", false);
    this.nHE = getIntent().getStringExtra("key_card_no");
    ab.i(this.TAG, "is payer: %s", new Object[] { Boolean.valueOf(this.nJo) });
    if (this.nJo)
    {
      ab.i(this.TAG, "do qry payer detail");
      paramBundle = new l(this.nHE);
      paramBundle.o(this);
      doSceneProgress(paramBundle, true);
      AppMethodBeat.o(41929);
      return;
    }
    paramBundle = new com.tencent.mm.plugin.honey_pay.a.m(this.nHE);
    paramBundle.o(this);
    doSceneProgress(paramBundle, true);
    AppMethodBeat.o(41929);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41930);
    super.onDestroy();
    removeSceneEndListener(2876);
    removeSceneEndListener(2613);
    AppMethodBeat.o(41930);
  }
  
  public boolean onProgressFinish()
  {
    return true;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(41931);
    if ((paramm instanceof l))
    {
      paramString = (l)paramm;
      paramString.a(new HoneyPayProxyUI.3(this, paramString)).b(new HoneyPayProxyUI.2(this)).c(new HoneyPayProxyUI.1(this));
    }
    for (;;)
    {
      AppMethodBeat.o(41931);
      return true;
      if ((paramm instanceof com.tencent.mm.plugin.honey_pay.a.m))
      {
        paramString = (com.tencent.mm.plugin.honey_pay.a.m)paramm;
        paramString.a(new HoneyPayProxyUI.6(this, paramString)).b(new HoneyPayProxyUI.5(this)).c(new HoneyPayProxyUI.4(this));
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayProxyUI
 * JD-Core Version:    0.7.0.1
 */