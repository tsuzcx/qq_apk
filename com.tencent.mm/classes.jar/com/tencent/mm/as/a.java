package com.tencent.mm.as;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.model.at;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public class a
  implements at
{
  private static HandlerThread fDf = null;
  private static ak fDg = null;
  
  public static boolean i(Runnable paramRunnable, long paramLong)
  {
    boolean bool2 = false;
    AppMethodBeat.i(62297);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(62297);
      return false;
    }
    boolean bool1;
    if ((fDg == null) || (fDf == null))
    {
      if (fDg != null)
      {
        bool1 = true;
        if (fDf != null) {
          bool2 = true;
        }
        ab.w("MicroMsg.GIF.SubCoreGIF", "check decoder thread available fail, handler[%B] thread[%B] stack[%s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), bo.dtY() });
        if (fDg != null) {
          fDg.removeCallbacksAndMessages(null);
        }
        if (fDf != null) {
          fDf.quit();
        }
        HandlerThread localHandlerThread = d.aqu("GIF-Decoder");
        fDf = localHandlerThread;
        localHandlerThread.start();
        fDg = new ak(fDf.getLooper());
      }
    }
    else
    {
      if (paramLong <= 0L) {
        break label166;
      }
      fDg.postDelayed(paramRunnable, paramLong);
    }
    for (;;)
    {
      AppMethodBeat.o(62297);
      return true;
      bool1 = false;
      break;
      label166:
      fDg.post(paramRunnable);
    }
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(62298);
    if (fDg != null) {
      fDg.removeCallbacksAndMessages(null);
    }
    AppMethodBeat.o(62298);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(62299);
    if (fDg != null) {
      fDg.removeCallbacksAndMessages(null);
    }
    AppMethodBeat.o(62299);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.as.a
 * JD-Core Version:    0.7.0.1
 */