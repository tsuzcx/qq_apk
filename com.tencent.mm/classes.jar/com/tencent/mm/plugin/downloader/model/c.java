package com.tencent.mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.Vector;

public final class c
{
  private static Vector<m> xnq;
  private static m xnr;
  
  static
  {
    AppMethodBeat.i(88950);
    xnq = new Vector();
    AppMethodBeat.o(88950);
  }
  
  public static void a(m paramm)
  {
    AppMethodBeat.i(88939);
    if ((paramm != null) && (!xnq.contains(paramm))) {
      xnq.add(paramm);
    }
    AppMethodBeat.o(88939);
  }
  
  public static void b(m paramm)
  {
    AppMethodBeat.i(88940);
    if (paramm != null) {
      xnq.remove(paramm);
    }
    AppMethodBeat.o(88940);
  }
  
  public final void b(final long paramLong1, String paramString, final long paramLong2, final long paramLong3)
  {
    AppMethodBeat.i(267133);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88937);
        m[] arrayOfm = c.duq();
        int j = arrayOfm.length;
        int i = 0;
        while (i < j)
        {
          arrayOfm[i].a(paramLong1, paramLong2, paramLong3, this.xnv);
          i += 1;
        }
        AppMethodBeat.o(88937);
      }
    });
    AppMethodBeat.o(267133);
  }
  
  public final void c(final long paramLong, String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(88944);
    Log.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskFinished: %d", new Object[] { Long.valueOf(paramLong) });
    e.ld(paramLong);
    a locala = d.la(paramLong);
    if (locala != null) {
      com.tencent.mm.plugin.downloader.a.c.w(new String[] { locala.field_downloadUrl, locala.field_secondaryUrl });
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88934);
        m[] arrayOfm = c.duq();
        int j = arrayOfm.length;
        int i = 0;
        while (i < j)
        {
          arrayOfm[i].b(paramLong, paramBoolean, this.xnt);
          i += 1;
        }
        if (c.dur() != null) {
          c.dur().b(paramLong, paramBoolean, this.xnt);
        }
        AppMethodBeat.o(88934);
      }
    });
    AppMethodBeat.o(88944);
  }
  
  public final void d(final long paramLong, int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(88945);
    Log.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskFailed: %d, errCode : %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    e.ld(paramLong);
    a locala = d.la(paramLong);
    if (locala != null) {
      com.tencent.mm.plugin.downloader.a.c.w(new String[] { locala.field_downloadUrl, locala.field_secondaryUrl });
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88935);
        m[] arrayOfm = c.duq();
        int j = arrayOfm.length;
        int i = 0;
        while (i < j)
        {
          arrayOfm[i].c(paramLong, paramBoolean, this.xnt);
          i += 1;
        }
        if (c.dur() != null) {
          c.dur().c(paramLong, paramBoolean, this.xnt);
        }
        AppMethodBeat.o(88935);
      }
    });
    AppMethodBeat.o(88945);
  }
  
  public final void kX(final long paramLong)
  {
    AppMethodBeat.i(88943);
    Log.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskRemoved: %d", new Object[] { Long.valueOf(paramLong) });
    a locala = d.la(paramLong);
    if (locala != null) {
      com.tencent.mm.plugin.downloader.a.c.w(new String[] { locala.field_downloadUrl, locala.field_secondaryUrl });
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88933);
        m[] arrayOfm = c.duq();
        int j = arrayOfm.length;
        int i = 0;
        while (i < j)
        {
          arrayOfm[i].jF(paramLong);
          i += 1;
        }
        if (c.dur() != null) {
          c.dur().jF(paramLong);
        }
        AppMethodBeat.o(88933);
      }
    });
    AppMethodBeat.o(88943);
  }
  
  public final void kY(final long paramLong)
  {
    AppMethodBeat.i(88946);
    Log.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskPaused: %d", new Object[] { Long.valueOf(paramLong) });
    a locala = d.la(paramLong);
    if (locala != null) {
      com.tencent.mm.plugin.downloader.a.c.w(new String[] { locala.field_downloadUrl, locala.field_secondaryUrl });
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88936);
        m[] arrayOfm = c.duq();
        int j = arrayOfm.length;
        int i = 0;
        while (i < j)
        {
          arrayOfm[i].jG(paramLong);
          i += 1;
        }
        if (c.dur() != null) {
          c.dur().jG(paramLong);
        }
        AppMethodBeat.o(88936);
      }
    });
    AppMethodBeat.o(88946);
  }
  
  public final void kZ(final long paramLong)
  {
    AppMethodBeat.i(88948);
    Log.i("MicroMsg.FileDownloaderCallbackManager", "notifyMd5Checking: %d", new Object[] { Long.valueOf(paramLong) });
    e.lc(paramLong);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88938);
        m[] arrayOfm = c.duq();
        int j = arrayOfm.length;
        int i = 0;
        while (i < j)
        {
          arrayOfm[i].jH(paramLong);
          i += 1;
        }
        AppMethodBeat.o(88938);
      }
    });
    AppMethodBeat.o(88948);
  }
  
  public final void x(final long paramLong, String paramString)
  {
    AppMethodBeat.i(88941);
    Log.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskStarted: %d, %s", new Object[] { Long.valueOf(paramLong), paramString });
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88931);
        m[] arrayOfm = c.duq();
        int j = arrayOfm.length;
        int i = 0;
        while (i < j)
        {
          arrayOfm[i].v(paramLong, this.val$path);
          i += 1;
        }
        if (c.dur() != null) {
          c.dur().v(paramLong, this.val$path);
        }
        AppMethodBeat.o(88931);
      }
    });
    AppMethodBeat.o(88941);
  }
  
  public final void y(final long paramLong, String paramString)
  {
    AppMethodBeat.i(88942);
    Log.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskResumed: %d, %s", new Object[] { Long.valueOf(paramLong), paramString });
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88932);
        m[] arrayOfm = c.duq();
        int j = arrayOfm.length;
        int i = 0;
        while (i < j)
        {
          arrayOfm[i].w(paramLong, this.val$path);
          i += 1;
        }
        if (c.dur() != null) {
          c.dur().w(paramLong, this.val$path);
        }
        AppMethodBeat.o(88932);
      }
    });
    AppMethodBeat.o(88942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.c
 * JD-Core Version:    0.7.0.1
 */