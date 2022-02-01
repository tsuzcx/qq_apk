package com.tencent.mm.plugin.mmsight;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.concurrent.ConcurrentSkipListSet;

public final class c
{
  private static ConcurrentSkipListSet<Integer> uJe;
  
  static
  {
    AppMethodBeat.i(148776);
    uJe = new ConcurrentSkipListSet();
    AppMethodBeat.o(148776);
  }
  
  public static void IG(int paramInt)
  {
    try
    {
      AppMethodBeat.i(148773);
      try
      {
        ac.i("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxing: %s", new Object[] { Integer.valueOf(paramInt) });
        uJe.add(Integer.valueOf(paramInt));
        AppMethodBeat.o(148773);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.e("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxing error: %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(148773);
        }
      }
      return;
    }
    finally {}
  }
  
  public static void IH(int paramInt)
  {
    try
    {
      AppMethodBeat.i(148774);
      try
      {
        ac.i("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxingFinish: %s", new Object[] { Integer.valueOf(paramInt) });
        uJe.remove(Integer.valueOf(paramInt));
        AppMethodBeat.o(148774);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.e("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxingFinish error: %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(148774);
        }
      }
      return;
    }
    finally {}
  }
  
  public static boolean II(int paramInt)
  {
    try
    {
      AppMethodBeat.i(148775);
      try
      {
        bool = uJe.contains(Integer.valueOf(paramInt));
        ac.d("MicroMsg.MMSightCaptureVideoRemuxStatus", "isMsgRemuxing: %s, %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
        AppMethodBeat.o(148775);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.e("MicroMsg.MMSightCaptureVideoRemuxStatus", "isMsgRemuxing error: %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(148775);
          boolean bool = false;
        }
      }
      return bool;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.c
 * JD-Core Version:    0.7.0.1
 */