package com.tencent.mm.plugin.mmsight;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.concurrent.ConcurrentSkipListSet;

public final class c
{
  private static ConcurrentSkipListSet<Integer> vMk;
  
  static
  {
    AppMethodBeat.i(148776);
    vMk = new ConcurrentSkipListSet();
    AppMethodBeat.o(148776);
  }
  
  public static void Kd(int paramInt)
  {
    try
    {
      AppMethodBeat.i(148773);
      try
      {
        ad.i("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxing: %s", new Object[] { Integer.valueOf(paramInt) });
        vMk.add(Integer.valueOf(paramInt));
        AppMethodBeat.o(148773);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.e("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxing error: %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(148773);
        }
      }
      return;
    }
    finally {}
  }
  
  public static void Ke(int paramInt)
  {
    try
    {
      AppMethodBeat.i(148774);
      try
      {
        ad.i("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxingFinish: %s", new Object[] { Integer.valueOf(paramInt) });
        vMk.remove(Integer.valueOf(paramInt));
        AppMethodBeat.o(148774);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.e("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxingFinish error: %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(148774);
        }
      }
      return;
    }
    finally {}
  }
  
  public static boolean Kf(int paramInt)
  {
    try
    {
      AppMethodBeat.i(148775);
      try
      {
        bool = vMk.contains(Integer.valueOf(paramInt));
        ad.d("MicroMsg.MMSightCaptureVideoRemuxStatus", "isMsgRemuxing: %s, %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
        AppMethodBeat.o(148775);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.e("MicroMsg.MMSightCaptureVideoRemuxStatus", "isMsgRemuxing error: %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(148775);
          boolean bool = false;
        }
      }
      return bool;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.c
 * JD-Core Version:    0.7.0.1
 */