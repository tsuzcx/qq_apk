package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Vector;

public final class b
{
  private static Vector<k> iPc = new Vector();
  private static k iPd;
  
  public static void a(k paramk)
  {
    if ((paramk != null) && (!iPc.contains(paramk))) {
      iPc.add(paramk);
    }
  }
  
  public static void aFK()
  {
    iPd = null;
  }
  
  public static void b(k paramk)
  {
    if (paramk != null) {
      iPc.remove(paramk);
    }
  }
  
  public static void c(k paramk)
  {
    iPd = paramk;
  }
  
  public final void c(long paramLong, int paramInt, boolean paramBoolean)
  {
    y.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskFailed: %d, errCode : %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    ai.d(new b.5(this, paramLong, paramInt, paramBoolean));
  }
  
  public final void c(long paramLong, String paramString, boolean paramBoolean)
  {
    y.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskFinished: %d", new Object[] { Long.valueOf(paramLong) });
    ai.d(new b.4(this, paramLong, paramString, paramBoolean));
  }
  
  public final void dg(long paramLong)
  {
    y.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskRemoved: %d", new Object[] { Long.valueOf(paramLong) });
    ai.d(new b.3(this, paramLong));
  }
  
  public final void dh(long paramLong)
  {
    y.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskPaused: %d", new Object[] { Long.valueOf(paramLong) });
    ai.d(new b.6(this, paramLong));
  }
  
  public final void di(long paramLong)
  {
    ai.d(new b.7(this, paramLong));
  }
  
  public final void dj(long paramLong)
  {
    y.i("MicroMsg.FileDownloaderCallbackManager", "notifyMd5Checking: %d", new Object[] { Long.valueOf(paramLong) });
    ai.d(new b.8(this, paramLong));
  }
  
  public final void l(long paramLong, String paramString)
  {
    y.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskStarted: %d, %s", new Object[] { Long.valueOf(paramLong), paramString });
    ai.d(new b.1(this, paramLong, paramString));
  }
  
  public final void m(long paramLong, String paramString)
  {
    y.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskResumed: %d, %s", new Object[] { Long.valueOf(paramLong), paramString });
    ai.d(new b.2(this, paramLong, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.b
 * JD-Core Version:    0.7.0.1
 */