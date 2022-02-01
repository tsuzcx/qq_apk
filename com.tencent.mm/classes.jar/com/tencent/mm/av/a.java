package com.tencent.mm.av;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ax;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class a
  implements ax
{
  private static ap hYQ = null;
  
  public static boolean h(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(104523);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(104523);
      return false;
    }
    boolean bool;
    if (hYQ == null)
    {
      if (hYQ != null)
      {
        bool = true;
        ad.w("MicroMsg.GIF.SubCoreGIF", "check decoder thread available fail, handler[%B] stack[%s]", new Object[] { Boolean.valueOf(bool), bt.flS() });
        if (hYQ != null) {
          hYQ.removeCallbacksAndMessages(null);
        }
        ap localap = new ap("GIF-Decoder");
        hYQ = localap;
        localap.setLogging(false);
      }
    }
    else
    {
      if (paramLong <= 0L) {
        break label116;
      }
      hYQ.postDelayed(paramRunnable, paramLong);
    }
    for (;;)
    {
      AppMethodBeat.o(104523);
      return true;
      bool = false;
      break;
      label116:
      hYQ.post(paramRunnable);
    }
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(104524);
    if (hYQ != null) {
      hYQ.removeCallbacksAndMessages(null);
    }
    AppMethodBeat.o(104524);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(104525);
    if (hYQ != null) {
      hYQ.removeCallbacksAndMessages(null);
    }
    AppMethodBeat.o(104525);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.av.a
 * JD-Core Version:    0.7.0.1
 */