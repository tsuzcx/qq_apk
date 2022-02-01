package com.tencent.mm.au;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class a
  implements bd
{
  private static MMHandler iWG = null;
  
  public static boolean f(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(104523);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(104523);
      return false;
    }
    boolean bool;
    if (iWG == null)
    {
      if (iWG != null)
      {
        bool = true;
        Log.w("MicroMsg.GIF.SubCoreGIF", "check decoder thread available fail, handler[%B] stack[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack() });
        if (iWG != null) {
          iWG.removeCallbacksAndMessages(null);
        }
        MMHandler localMMHandler = new MMHandler("GIF-Decoder");
        iWG = localMMHandler;
        localMMHandler.setLogging(false);
      }
    }
    else
    {
      if (paramLong <= 0L) {
        break label116;
      }
      iWG.postDelayed(paramRunnable, paramLong);
    }
    for (;;)
    {
      AppMethodBeat.o(104523);
      return true;
      bool = false;
      break;
      label116:
      iWG.post(paramRunnable);
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
    if (iWG != null) {
      iWG.removeCallbacksAndMessages(null);
    }
    AppMethodBeat.o(104524);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(104525);
    if (iWG != null) {
      iWG.removeCallbacksAndMessages(null);
    }
    AppMethodBeat.o(104525);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.au.a
 * JD-Core Version:    0.7.0.1
 */