package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;

public final class m
{
  public static void eD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(6185);
    if ((ac.getLogLevel() == 0) && (bt.eWo())) {
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(6183);
          Toast.makeText(ai.getContext(), this.hSd, 0).show();
          AppMethodBeat.o(6183);
        }
      });
    }
    ac.i(paramString1, paramString2);
    AppMethodBeat.o(6185);
  }
  
  public static void showToast(String paramString)
  {
    AppMethodBeat.i(6184);
    eD("MicroMsg.PreloadUtil", paramString);
    AppMethodBeat.o(6184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.m
 * JD-Core Version:    0.7.0.1
 */