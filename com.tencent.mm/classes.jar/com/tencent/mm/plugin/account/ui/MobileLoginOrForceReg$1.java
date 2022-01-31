package com.tencent.mm.plugin.account.ui;

import android.graphics.Bitmap;
import android.os.Message;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ah;

final class MobileLoginOrForceReg$1
  extends ah
{
  MobileLoginOrForceReg$1(MobileLoginOrForceReg paramMobileLoginOrForceReg) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if (paramMessage.obj != null)
    {
      paramMessage = (Bitmap)paramMessage.obj;
      MobileLoginOrForceReg.a(this.fpa).setImageBitmap(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.1
 * JD-Core Version:    0.7.0.1
 */