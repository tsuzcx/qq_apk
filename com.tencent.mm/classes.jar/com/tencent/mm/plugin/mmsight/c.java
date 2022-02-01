package com.tencent.mm.plugin.mmsight;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentSkipListSet;

public final class c
{
  private static ConcurrentSkipListSet<Integer> zsq;
  
  static
  {
    AppMethodBeat.i(148776);
    zsq = new ConcurrentSkipListSet();
    AppMethodBeat.o(148776);
  }
  
  public static void QE(int paramInt)
  {
    try
    {
      AppMethodBeat.i(148773);
      try
      {
        Log.i("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxing: %s", new Object[] { Integer.valueOf(paramInt) });
        zsq.add(Integer.valueOf(paramInt));
        AppMethodBeat.o(148773);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxing error: %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(148773);
        }
      }
      return;
    }
    finally {}
  }
  
  public static void QF(int paramInt)
  {
    try
    {
      AppMethodBeat.i(148774);
      try
      {
        Log.i("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxingFinish: %s", new Object[] { Integer.valueOf(paramInt) });
        zsq.remove(Integer.valueOf(paramInt));
        AppMethodBeat.o(148774);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxingFinish error: %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(148774);
        }
      }
      return;
    }
    finally {}
  }
  
  public static boolean QG(int paramInt)
  {
    try
    {
      AppMethodBeat.i(148775);
      try
      {
        bool = zsq.contains(Integer.valueOf(paramInt));
        Log.d("MicroMsg.MMSightCaptureVideoRemuxStatus", "isMsgRemuxing: %s, %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
        AppMethodBeat.o(148775);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.MMSightCaptureVideoRemuxStatus", "isMsgRemuxing error: %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(148775);
          boolean bool = false;
        }
      }
      return bool;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.c
 * JD-Core Version:    0.7.0.1
 */