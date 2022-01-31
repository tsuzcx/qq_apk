package com.tencent.mm.plugin.account.ui;

import android.graphics.Bitmap;
import com.tencent.mm.network.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;

final class MobileLoginOrForceReg$13
  implements Runnable
{
  MobileLoginOrForceReg$13(MobileLoginOrForceReg paramMobileLoginOrForceReg, String paramString) {}
  
  public final void run()
  {
    Object localObject = null;
    try
    {
      Bitmap localBitmap = c.decodeStream(b.n(this.val$url, 10000, 20000));
      localObject = localBitmap;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicorMsg.MobileLoginOrForceReg", "download avatar failed");
        y.printErrStackTrace("MicorMsg.MobileLoginOrForceReg", localException, "", new Object[0]);
      }
    }
    MobileLoginOrForceReg.b(this.fpa).sendMessage(MobileLoginOrForceReg.b(this.fpa).obtainMessage(0, localObject));
  }
  
  public final String toString()
  {
    return super.toString() + "|loadBitmap";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.13
 * JD-Core Version:    0.7.0.1
 */