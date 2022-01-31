package com.tencent.mm.ar;

import android.os.HandlerThread;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public class a
  implements ar
{
  private static HandlerThread emI = null;
  private static ah emJ = null;
  
  public static boolean f(Runnable paramRunnable, long paramLong)
  {
    boolean bool2 = false;
    if (paramRunnable == null) {
      return false;
    }
    boolean bool1;
    if ((emJ == null) || (emI == null))
    {
      if (emJ != null)
      {
        bool1 = true;
        if (emI != null) {
          bool2 = true;
        }
        y.w("MicroMsg.GIF.SubCoreGIF", "check decoder thread available fail, handler[%B] thread[%B] stack[%s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), bk.csb() });
        if (emJ != null) {
          emJ.removeCallbacksAndMessages(null);
        }
        if (emI != null) {
          emI.quit();
        }
        HandlerThread localHandlerThread = e.aap("GIF-Decoder");
        emI = localHandlerThread;
        localHandlerThread.start();
        emJ = new ah(emI.getLooper());
      }
    }
    else
    {
      if (paramLong <= 0L) {
        break label151;
      }
      emJ.postDelayed(paramRunnable, paramLong);
    }
    for (;;)
    {
      return true;
      bool1 = false;
      break;
      label151:
      emJ.post(paramRunnable);
    }
  }
  
  public final void bh(boolean paramBoolean)
  {
    if (emJ != null) {
      emJ.removeCallbacksAndMessages(null);
    }
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    if (emJ != null) {
      emJ.removeCallbacksAndMessages(null);
    }
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ar.a
 * JD-Core Version:    0.7.0.1
 */