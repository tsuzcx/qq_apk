package com.tencent.mm.plugin.account.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

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
      Bitmap localBitmap = BackwardSupportUtil.BitmapFactory.decodeStream(d.x(this.val$url, 10000, 20000));
      localObject = localBitmap;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicorMsg.MobileLoginOrForceReg", "download avatar failed");
        Log.printErrStackTrace("MicorMsg.MobileLoginOrForceReg", localException, "", new Object[0]);
      }
    }
    MobileLoginOrForceReg.b(this.ngi).sendMessage(MobileLoginOrForceReg.b(this.ngi).obtainMessage(0, localObject));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.13
 * JD-Core Version:    0.7.0.1
 */