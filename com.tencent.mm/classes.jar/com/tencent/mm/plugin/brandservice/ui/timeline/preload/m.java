package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bv;

public final class m
{
  public static void eQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(6185);
    if ((ae.getLogLevel() == 0) && (bv.fpT())) {
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(6183);
          Toast.makeText(ak.getContext(), this.ion, 0).show();
          AppMethodBeat.o(6183);
        }
      });
    }
    ae.i(paramString1, paramString2);
    AppMethodBeat.o(6185);
  }
  
  public static void showToast(String paramString)
  {
    AppMethodBeat.i(6184);
    eQ("MicroMsg.PreloadUtil", paramString);
    AppMethodBeat.o(6184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.m
 * JD-Core Version:    0.7.0.1
 */