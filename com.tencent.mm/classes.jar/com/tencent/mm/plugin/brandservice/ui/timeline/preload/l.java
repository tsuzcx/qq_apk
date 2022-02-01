package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;

public final class l
{
  public static void er(String paramString1, String paramString2)
  {
    AppMethodBeat.i(6185);
    if ((ad.getLogLevel() == 0) && (bu.eGT())) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(6183);
          Toast.makeText(aj.getContext(), this.hrB, 0).show();
          AppMethodBeat.o(6183);
        }
      });
    }
    ad.i(paramString1, paramString2);
    AppMethodBeat.o(6185);
  }
  
  public static void showToast(String paramString)
  {
    AppMethodBeat.i(6184);
    er("MicroMsg.PreloadUtil", paramString);
    AppMethodBeat.o(6184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.l
 * JD-Core Version:    0.7.0.1
 */