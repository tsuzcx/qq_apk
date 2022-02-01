package com.tencent.mm.au;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class a
  implements aw
{
  private static ao hGj = null;
  
  public static boolean g(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(104523);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(104523);
      return false;
    }
    boolean bool;
    if (hGj == null)
    {
      if (hGj != null)
      {
        bool = true;
        ac.w("MicroMsg.GIF.SubCoreGIF", "check decoder thread available fail, handler[%B] stack[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi() });
        if (hGj != null) {
          hGj.removeCallbacksAndMessages(null);
        }
        ao localao = new ao("GIF-Decoder");
        hGj = localao;
        localao.setLogging(false);
      }
    }
    else
    {
      if (paramLong <= 0L) {
        break label116;
      }
      hGj.postDelayed(paramRunnable, paramLong);
    }
    for (;;)
    {
      AppMethodBeat.o(104523);
      return true;
      bool = false;
      break;
      label116:
      hGj.post(paramRunnable);
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
    if (hGj != null) {
      hGj.removeCallbacksAndMessages(null);
    }
    AppMethodBeat.o(104524);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(104525);
    if (hGj != null) {
      hGj.removeCallbacksAndMessages(null);
    }
    AppMethodBeat.o(104525);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.au.a
 * JD-Core Version:    0.7.0.1
 */