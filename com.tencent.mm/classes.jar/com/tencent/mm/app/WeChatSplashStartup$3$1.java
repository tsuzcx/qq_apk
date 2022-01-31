package com.tencent.mm.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WeChatSplashStartup$3$1
  implements DialogInterface.OnClickListener
{
  WeChatSplashStartup$3$1(WeChatSplashStartup.3 param3, Runnable paramRunnable) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(137986);
    this.bZt.run();
    AppMethodBeat.o(137986);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.WeChatSplashStartup.3.1
 * JD-Core Version:    0.7.0.1
 */