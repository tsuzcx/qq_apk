package com.tencent.mm.plugin.account.ui;

import android.graphics.Bitmap;
import android.os.Message;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class MobileLoginOrForceReg$1
  extends ak
{
  MobileLoginOrForceReg$1(MobileLoginOrForceReg paramMobileLoginOrForceReg) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(125203);
    if (paramMessage.obj != null)
    {
      paramMessage = (Bitmap)paramMessage.obj;
      MobileLoginOrForceReg.a(this.gGw).setImageBitmap(paramMessage);
    }
    AppMethodBeat.o(125203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.1
 * JD-Core Version:    0.7.0.1
 */