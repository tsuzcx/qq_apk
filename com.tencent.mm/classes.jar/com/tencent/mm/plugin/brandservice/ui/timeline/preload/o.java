package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;

public final class o
{
  public static void fv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(6185);
    if ((Log.getLogLevel() == 0) && (WeChatEnvironment.hasDebugger())) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(6183);
          Toast.makeText(MMApplicationContext.getContext(), this.val$content, 0).show();
          AppMethodBeat.o(6183);
        }
      });
    }
    Log.i(paramString1, paramString2);
    AppMethodBeat.o(6185);
  }
  
  public static void showToast(String paramString)
  {
    AppMethodBeat.i(6184);
    fv("MicroMsg.PreloadUtil", paramString);
    AppMethodBeat.o(6184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.o
 * JD-Core Version:    0.7.0.1
 */