package com.tencent.mm.plugin.account.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.f;

final class MobileLoginOrForceReg$13
  implements Runnable
{
  MobileLoginOrForceReg$13(MobileLoginOrForceReg paramMobileLoginOrForceReg, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(128386);
    Object localObject = null;
    try
    {
      Bitmap localBitmap = f.decodeStream(b.u(this.val$url, 10000, 20000));
      localObject = localBitmap;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicorMsg.MobileLoginOrForceReg", "download avatar failed");
        ac.printErrStackTrace("MicorMsg.MobileLoginOrForceReg", localException, "", new Object[0]);
      }
    }
    MobileLoginOrForceReg.b(this.iUc).sendMessage(MobileLoginOrForceReg.b(this.iUc).obtainMessage(0, localObject));
    AppMethodBeat.o(128386);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(128387);
    String str = super.toString() + "|loadBitmap";
    AppMethodBeat.o(128387);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.13
 * JD-Core Version:    0.7.0.1
 */