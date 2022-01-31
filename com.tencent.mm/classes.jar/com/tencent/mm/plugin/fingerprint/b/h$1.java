package com.tencent.mm.plugin.fingerprint.b;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fingerprint.c.e;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class h$1
  implements ak.a
{
  h$1(h paramh) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(41481);
    if (1 == paramMessage.what)
    {
      String str = paramMessage.getData().getString("rsaKey");
      if (TextUtils.isEmpty(str))
      {
        ab.e("MicroMsg.HwFingerprintOpenDelegate", "handleMessage msg.what=" + paramMessage.what + " rsaKey is null");
        al.d(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(41480);
            h.1.this.mGb.mFX.aC(-1, h.1.this.mGb.mFZ.getString(2131299968));
            AppMethodBeat.o(41480);
          }
        });
      }
      paramMessage = new e(str);
      this.mGb.mFZ.doSceneProgress(paramMessage, false);
      AppMethodBeat.o(41481);
      return true;
    }
    AppMethodBeat.o(41481);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.h.1
 * JD-Core Version:    0.7.0.1
 */