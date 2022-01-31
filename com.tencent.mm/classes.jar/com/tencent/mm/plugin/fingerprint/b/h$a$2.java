package com.tencent.mm.plugin.fingerprint.b;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class h$a$2
  implements Runnable
{
  h$a$2(h.a parama, String paramString) {}
  
  public final void run()
  {
    y.i("MicroMsg.HwFingerprintOpenDelegate", "GenRsaKeySync.callback running");
    Message localMessage = this.klp.kln.klf.obtainMessage();
    localMessage.what = 1;
    Bundle localBundle = new Bundle();
    localBundle.putString("rsaKey", this.klh);
    localMessage.setData(localBundle);
    localMessage.sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.h.a.2
 * JD-Core Version:    0.7.0.1
 */