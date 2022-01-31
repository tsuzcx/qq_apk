package com.tencent.mm.plugin.fingerprint.b;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mm.plugin.fingerprint.c.e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class h$1
  implements ah.a
{
  h$1(h paramh) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    if (1 == paramMessage.what)
    {
      String str = paramMessage.getData().getString("rsaKey");
      if (TextUtils.isEmpty(str))
      {
        y.e("MicroMsg.HwFingerprintOpenDelegate", "handleMessage msg.what=" + paramMessage.what + " rsaKey is null");
        ai.d(new Runnable()
        {
          public final void run()
          {
            h.1.this.kln.klj.ai(-1, h.1.this.kln.kll.getString(a.i.fingerprint_open_fail));
          }
        });
      }
      paramMessage = new e(str);
      this.kln.kll.a(paramMessage, false, false);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.h.1
 * JD-Core Version:    0.7.0.1
 */