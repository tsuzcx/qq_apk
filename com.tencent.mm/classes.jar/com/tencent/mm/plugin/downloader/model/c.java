package com.tencent.mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.Vector;

public final class c
{
  private static Vector<m> kYk;
  private static m kYl;
  
  static
  {
    AppMethodBeat.i(2395);
    kYk = new Vector();
    AppMethodBeat.o(2395);
  }
  
  public static void a(m paramm)
  {
    AppMethodBeat.i(2384);
    if ((paramm != null) && (!kYk.contains(paramm))) {
      kYk.add(paramm);
    }
    AppMethodBeat.o(2384);
  }
  
  public static void b(m paramm)
  {
    AppMethodBeat.i(2385);
    if (paramm != null) {
      kYk.remove(paramm);
    }
    AppMethodBeat.o(2385);
  }
  
  public static void bjh()
  {
    kYl = null;
  }
  
  public static void c(m paramm)
  {
    kYl = paramm;
  }
  
  public final void c(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(2389);
    ab.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskFinished: %d", new Object[] { Long.valueOf(paramLong) });
    e.iM(paramLong);
    a locala = d.iJ(paramLong);
    if (locala != null) {
      com.tencent.mm.plugin.downloader.a.c.m(new String[] { locala.field_downloadUrl, locala.field_secondaryUrl });
    }
    al.d(new c.4(this, paramLong, paramString, paramBoolean));
    AppMethodBeat.o(2389);
  }
  
  public final void d(final long paramLong, int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(2390);
    ab.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskFailed: %d, errCode : %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    e.iM(paramLong);
    a locala = d.iJ(paramLong);
    if (locala != null) {
      com.tencent.mm.plugin.downloader.a.c.m(new String[] { locala.field_downloadUrl, locala.field_secondaryUrl });
    }
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(2380);
        m[] arrayOfm = c.bji();
        int j = arrayOfm.length;
        int i = 0;
        while (i < j)
        {
          arrayOfm[i].b(paramLong, paramBoolean, this.kYn);
          i += 1;
        }
        if (c.bjj() != null) {
          c.bjj().b(paramLong, paramBoolean, this.kYn);
        }
        AppMethodBeat.o(2380);
      }
    });
    AppMethodBeat.o(2390);
  }
  
  public final void iF(final long paramLong)
  {
    AppMethodBeat.i(2388);
    ab.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskRemoved: %d", new Object[] { Long.valueOf(paramLong) });
    a locala = d.iJ(paramLong);
    if (locala != null) {
      com.tencent.mm.plugin.downloader.a.c.m(new String[] { locala.field_downloadUrl, locala.field_secondaryUrl });
    }
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(2378);
        m[] arrayOfm = c.bji();
        int j = arrayOfm.length;
        int i = 0;
        while (i < j)
        {
          arrayOfm[i].onTaskRemoved(paramLong);
          i += 1;
        }
        if (c.bjj() != null) {
          c.bjj().onTaskRemoved(paramLong);
        }
        AppMethodBeat.o(2378);
      }
    });
    AppMethodBeat.o(2388);
  }
  
  public final void iG(long paramLong)
  {
    AppMethodBeat.i(2391);
    ab.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskPaused: %d", new Object[] { Long.valueOf(paramLong) });
    a locala = d.iJ(paramLong);
    if (locala != null) {
      com.tencent.mm.plugin.downloader.a.c.m(new String[] { locala.field_downloadUrl, locala.field_secondaryUrl });
    }
    al.d(new c.6(this, paramLong));
    AppMethodBeat.o(2391);
  }
  
  public final void iH(long paramLong)
  {
    AppMethodBeat.i(2392);
    al.d(new c.7(this, paramLong));
    AppMethodBeat.o(2392);
  }
  
  public final void iI(long paramLong)
  {
    AppMethodBeat.i(2393);
    ab.i("MicroMsg.FileDownloaderCallbackManager", "notifyMd5Checking: %d", new Object[] { Long.valueOf(paramLong) });
    e.iL(paramLong);
    al.d(new c.8(this, paramLong));
    AppMethodBeat.o(2393);
  }
  
  public final void j(long paramLong, String paramString)
  {
    AppMethodBeat.i(2386);
    ab.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskStarted: %d, %s", new Object[] { Long.valueOf(paramLong), paramString });
    al.d(new c.1(this, paramLong, paramString));
    AppMethodBeat.o(2386);
  }
  
  public final void k(long paramLong, String paramString)
  {
    AppMethodBeat.i(2387);
    ab.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskResumed: %d, %s", new Object[] { Long.valueOf(paramLong), paramString });
    al.d(new c.2(this, paramLong, paramString));
    AppMethodBeat.o(2387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.c
 * JD-Core Version:    0.7.0.1
 */