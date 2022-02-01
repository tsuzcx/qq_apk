package com.tencent.mm.au;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class a
  implements az
{
  private static aq ibI = null;
  
  public static boolean h(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(104523);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(104523);
      return false;
    }
    boolean bool;
    if (ibI == null)
    {
      if (ibI != null)
      {
        bool = true;
        ae.w("MicroMsg.GIF.SubCoreGIF", "check decoder thread available fail, handler[%B] stack[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN() });
        if (ibI != null) {
          ibI.removeCallbacksAndMessages(null);
        }
        aq localaq = new aq("GIF-Decoder");
        ibI = localaq;
        localaq.setLogging(false);
      }
    }
    else
    {
      if (paramLong <= 0L) {
        break label116;
      }
      ibI.postDelayed(paramRunnable, paramLong);
    }
    for (;;)
    {
      AppMethodBeat.o(104523);
      return true;
      bool = false;
      break;
      label116:
      ibI.post(paramRunnable);
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
    if (ibI != null) {
      ibI.removeCallbacksAndMessages(null);
    }
    AppMethodBeat.o(104524);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(104525);
    if (ibI != null) {
      ibI.removeCallbacksAndMessages(null);
    }
    AppMethodBeat.o(104525);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.au.a
 * JD-Core Version:    0.7.0.1
 */