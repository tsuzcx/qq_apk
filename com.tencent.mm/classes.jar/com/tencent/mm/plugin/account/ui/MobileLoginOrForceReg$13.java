package com.tencent.mm.plugin.account.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.d;

final class MobileLoginOrForceReg$13
  implements Runnable
{
  MobileLoginOrForceReg$13(MobileLoginOrForceReg paramMobileLoginOrForceReg, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(125213);
    Object localObject = null;
    try
    {
      Bitmap localBitmap = d.decodeStream(b.x(this.val$url, 10000, 20000));
      localObject = localBitmap;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicorMsg.MobileLoginOrForceReg", "download avatar failed");
        ab.printErrStackTrace("MicorMsg.MobileLoginOrForceReg", localException, "", new Object[0]);
      }
    }
    MobileLoginOrForceReg.b(this.gGw).sendMessage(MobileLoginOrForceReg.b(this.gGw).obtainMessage(0, localObject));
    AppMethodBeat.o(125213);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(125214);
    String str = super.toString() + "|loadBitmap";
    AppMethodBeat.o(125214);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.13
 * JD-Core Version:    0.7.0.1
 */