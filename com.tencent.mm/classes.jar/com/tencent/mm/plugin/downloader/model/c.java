package com.tencent.mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.Vector;

public final class c
{
  private static Vector<m> oIx;
  private static m oIy;
  
  static
  {
    AppMethodBeat.i(88950);
    oIx = new Vector();
    AppMethodBeat.o(88950);
  }
  
  public static void a(m paramm)
  {
    AppMethodBeat.i(88939);
    if ((paramm != null) && (!oIx.contains(paramm))) {
      oIx.add(paramm);
    }
    AppMethodBeat.o(88939);
  }
  
  public static void b(m paramm)
  {
    AppMethodBeat.i(88940);
    if (paramm != null) {
      oIx.remove(paramm);
    }
    AppMethodBeat.o(88940);
  }
  
  public static void bXD()
  {
    oIy = null;
  }
  
  public static void c(m paramm)
  {
    oIy = paramm;
  }
  
  public final void c(final long paramLong, int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(88945);
    ac.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskFailed: %d, errCode : %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    e.sf(paramLong);
    a locala = d.sc(paramLong);
    if (locala != null) {
      com.tencent.mm.plugin.downloader.a.c.t(new String[] { locala.field_downloadUrl, locala.field_secondaryUrl });
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88935);
        m[] arrayOfm = c.bXE();
        int j = arrayOfm.length;
        int i = 0;
        while (i < j)
        {
          arrayOfm[i].a(paramLong, paramBoolean, this.oIA);
          i += 1;
        }
        if (c.bXF() != null) {
          c.bXF().a(paramLong, paramBoolean, this.oIA);
        }
        AppMethodBeat.o(88935);
      }
    });
    AppMethodBeat.o(88945);
  }
  
  public final void c(final long paramLong, String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(88944);
    ac.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskFinished: %d", new Object[] { Long.valueOf(paramLong) });
    e.sf(paramLong);
    a locala = d.sc(paramLong);
    if (locala != null) {
      com.tencent.mm.plugin.downloader.a.c.t(new String[] { locala.field_downloadUrl, locala.field_secondaryUrl });
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88934);
        m[] arrayOfm = c.bXE();
        int j = arrayOfm.length;
        int i = 0;
        while (i < j)
        {
          arrayOfm[i].b(paramLong, paramBoolean, this.oIA);
          i += 1;
        }
        if (c.bXF() != null) {
          c.bXF().b(paramLong, paramBoolean, this.oIA);
        }
        AppMethodBeat.o(88934);
      }
    });
    AppMethodBeat.o(88944);
  }
  
  public final void k(final long paramLong, String paramString)
  {
    AppMethodBeat.i(88941);
    ac.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskStarted: %d, %s", new Object[] { Long.valueOf(paramLong), paramString });
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88931);
        m[] arrayOfm = c.bXE();
        int j = arrayOfm.length;
        int i = 0;
        while (i < j)
        {
          arrayOfm[i].onTaskStarted(paramLong, this.val$path);
          i += 1;
        }
        if (c.bXF() != null) {
          c.bXF().onTaskStarted(paramLong, this.val$path);
        }
        AppMethodBeat.o(88931);
      }
    });
    AppMethodBeat.o(88941);
  }
  
  public final void l(final long paramLong, String paramString)
  {
    AppMethodBeat.i(88942);
    ac.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskResumed: %d, %s", new Object[] { Long.valueOf(paramLong), paramString });
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88932);
        m[] arrayOfm = c.bXE();
        int j = arrayOfm.length;
        int i = 0;
        while (i < j)
        {
          arrayOfm[i].j(paramLong, this.val$path);
          i += 1;
        }
        if (c.bXF() != null) {
          c.bXF().j(paramLong, this.val$path);
        }
        AppMethodBeat.o(88932);
      }
    });
    AppMethodBeat.o(88942);
  }
  
  public final void rY(final long paramLong)
  {
    AppMethodBeat.i(88943);
    ac.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskRemoved: %d", new Object[] { Long.valueOf(paramLong) });
    a locala = d.sc(paramLong);
    if (locala != null) {
      com.tencent.mm.plugin.downloader.a.c.t(new String[] { locala.field_downloadUrl, locala.field_secondaryUrl });
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88933);
        m[] arrayOfm = c.bXE();
        int j = arrayOfm.length;
        int i = 0;
        while (i < j)
        {
          arrayOfm[i].onTaskRemoved(paramLong);
          i += 1;
        }
        if (c.bXF() != null) {
          c.bXF().onTaskRemoved(paramLong);
        }
        AppMethodBeat.o(88933);
      }
    });
    AppMethodBeat.o(88943);
  }
  
  public final void rZ(final long paramLong)
  {
    AppMethodBeat.i(88946);
    ac.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskPaused: %d", new Object[] { Long.valueOf(paramLong) });
    a locala = d.sc(paramLong);
    if (locala != null) {
      com.tencent.mm.plugin.downloader.a.c.t(new String[] { locala.field_downloadUrl, locala.field_secondaryUrl });
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88936);
        m[] arrayOfm = c.bXE();
        int j = arrayOfm.length;
        int i = 0;
        while (i < j)
        {
          arrayOfm[i].onTaskPaused(paramLong);
          i += 1;
        }
        if (c.bXF() != null) {
          c.bXF().onTaskPaused(paramLong);
        }
        AppMethodBeat.o(88936);
      }
    });
    AppMethodBeat.o(88946);
  }
  
  public final void sa(final long paramLong)
  {
    AppMethodBeat.i(88947);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88937);
        m[] arrayOfm = c.bXE();
        int j = arrayOfm.length;
        int i = 0;
        while (i < j)
        {
          arrayOfm[i].qN(paramLong);
          i += 1;
        }
        AppMethodBeat.o(88937);
      }
    });
    AppMethodBeat.o(88947);
  }
  
  public final void sb(final long paramLong)
  {
    AppMethodBeat.i(88948);
    ac.i("MicroMsg.FileDownloaderCallbackManager", "notifyMd5Checking: %d", new Object[] { Long.valueOf(paramLong) });
    e.se(paramLong);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88938);
        m[] arrayOfm = c.bXE();
        int j = arrayOfm.length;
        int i = 0;
        while (i < j)
        {
          arrayOfm[i].qO(paramLong);
          i += 1;
        }
        AppMethodBeat.o(88938);
      }
    });
    AppMethodBeat.o(88948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.c
 * JD-Core Version:    0.7.0.1
 */