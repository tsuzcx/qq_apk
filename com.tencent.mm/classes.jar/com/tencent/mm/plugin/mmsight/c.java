package com.tencent.mm.plugin.mmsight;

import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.ConcurrentSkipListSet;

public final class c
{
  private static ConcurrentSkipListSet<Integer> meZ = new ConcurrentSkipListSet();
  
  public static void tR(int paramInt)
  {
    try
    {
      y.i("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxing: %s", new Object[] { Integer.valueOf(paramInt) });
      meZ.add(Integer.valueOf(paramInt));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxing error: %s", new Object[] { localException.getMessage() });
      }
    }
    finally {}
  }
  
  public static void tS(int paramInt)
  {
    try
    {
      y.i("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxingFinish: %s", new Object[] { Integer.valueOf(paramInt) });
      meZ.remove(Integer.valueOf(paramInt));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxingFinish error: %s", new Object[] { localException.getMessage() });
      }
    }
    finally {}
  }
  
  public static boolean tT(int paramInt)
  {
    try
    {
      bool = meZ.contains(Integer.valueOf(paramInt));
      y.d("MicroMsg.MMSightCaptureVideoRemuxStatus", "isMsgRemuxing: %s, %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.MMSightCaptureVideoRemuxStatus", "isMsgRemuxing error: %s", new Object[] { localException.getMessage() });
        boolean bool = false;
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.c
 * JD-Core Version:    0.7.0.1
 */