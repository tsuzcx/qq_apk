package com.tencent.mm.plugin.gwallet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gwallet.a.b.2;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;

final class GWalletUI$3
  extends BroadcastReceiver
{
  GWalletUI$3(GWalletUI paramGWalletUI) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(41677);
    if ("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST".equals(paramIntent.getAction()))
    {
      paramContext = paramIntent.getStringArrayListExtra("tokens");
      boolean bool = paramIntent.getBooleanExtra("IS_FAILED_CONSUME", false);
      if ((paramContext == null) || (paramContext.size() == 0))
      {
        GWalletUI.a(this.nGi, 0, null);
        AppMethodBeat.o(41677);
        return;
      }
      d.post(new b.2(GWalletUI.b(this.nGi), paramContext, new GWalletUI.3.1(this, bool), new ak()), "IabHelper_consumeAsync");
    }
    AppMethodBeat.o(41677);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gwallet.GWalletUI.3
 * JD-Core Version:    0.7.0.1
 */