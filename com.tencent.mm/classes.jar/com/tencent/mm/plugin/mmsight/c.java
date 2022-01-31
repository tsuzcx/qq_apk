package com.tencent.mm.plugin.mmsight;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.ConcurrentSkipListSet;

public final class c
{
  private static ConcurrentSkipListSet<Integer> oFy;
  
  static
  {
    AppMethodBeat.i(60270);
    oFy = new ConcurrentSkipListSet();
    AppMethodBeat.o(60270);
  }
  
  public static void zk(int paramInt)
  {
    try
    {
      AppMethodBeat.i(60267);
      try
      {
        ab.i("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxing: %s", new Object[] { Integer.valueOf(paramInt) });
        oFy.add(Integer.valueOf(paramInt));
        AppMethodBeat.o(60267);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.e("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxing error: %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(60267);
        }
      }
      return;
    }
    finally {}
  }
  
  public static void zl(int paramInt)
  {
    try
    {
      AppMethodBeat.i(60268);
      try
      {
        ab.i("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxingFinish: %s", new Object[] { Integer.valueOf(paramInt) });
        oFy.remove(Integer.valueOf(paramInt));
        AppMethodBeat.o(60268);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.e("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxingFinish error: %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(60268);
        }
      }
      return;
    }
    finally {}
  }
  
  public static boolean zm(int paramInt)
  {
    try
    {
      AppMethodBeat.i(60269);
      try
      {
        bool = oFy.contains(Integer.valueOf(paramInt));
        ab.d("MicroMsg.MMSightCaptureVideoRemuxStatus", "isMsgRemuxing: %s, %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
        AppMethodBeat.o(60269);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.e("MicroMsg.MMSightCaptureVideoRemuxStatus", "isMsgRemuxing error: %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(60269);
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