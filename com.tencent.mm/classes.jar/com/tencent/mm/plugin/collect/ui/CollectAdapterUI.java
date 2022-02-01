package com.tencent.mm.plugin.collect.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class CollectAdapterUI
  extends WalletBaseUI
{
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64028);
    super.onCreate(paramBundle);
    setContentViewVisibility(8);
    g.agS();
    int i = ((Integer)g.agR().agA().get(ah.a.GIP, Integer.valueOf(0))).intValue();
    ac.i("MicroMsg.CollectAdapterUI", "walletRegion: %s", new Object[] { Integer.valueOf(i) });
    if (i == 8) {
      d.b(this, "collect", ".ui.CollectHKMainUI", getIntent());
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(64028);
      return;
      d.b(this, "collect", ".ui.CollectMainUI", getIntent());
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectAdapterUI
 * JD-Core Version:    0.7.0.1
 */