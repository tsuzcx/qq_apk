package com.tencent.mm.plugin.collect.ui;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class CollectAdapterUI
  extends WalletBaseUI
{
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    vN(8);
    g.DQ();
    int i = ((Integer)g.DP().Dz().get(ac.a.usE, Integer.valueOf(0))).intValue();
    y.i("MicroMsg.CollectAdapterUI", "walletRegion: %s", new Object[] { Integer.valueOf(i) });
    if (i == 8) {
      d.b(this, "collect", ".ui.CollectHKMainUI", getIntent());
    }
    for (;;)
    {
      finish();
      return;
      d.b(this, "collect", ".ui.CollectMainUI", getIntent());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectAdapterUI
 * JD-Core Version:    0.7.0.1
 */