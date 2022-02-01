package com.tencent.mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.Vector;

public final class c
{
  private static Vector<m> pmb;
  private static m pmc;
  
  static
  {
    AppMethodBeat.i(88950);
    pmb = new Vector();
    AppMethodBeat.o(88950);
  }
  
  public static void a(m paramm)
  {
    AppMethodBeat.i(88939);
    if ((paramm != null) && (!pmb.contains(paramm))) {
      pmb.add(paramm);
    }
    AppMethodBeat.o(88939);
  }
  
  public static void b(m paramm)
  {
    AppMethodBeat.i(88940);
    if (paramm != null) {
      pmb.remove(paramm);
    }
    AppMethodBeat.o(88940);
  }
  
  public final void b(final long paramLong1, String paramString, final long paramLong2, final long paramLong3)
  {
    AppMethodBeat.i(213699);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88937);
        m[] arrayOfm = c.ccg();
        int j = arrayOfm.length;
        int i = 0;
        while (i < j)
        {
          arrayOfm[i].a(paramLong1, paramLong2, paramLong3, this.pmg);
          i += 1;
        }
        AppMethodBeat.o(88937);
      }
    });
    AppMethodBeat.o(213699);
  }
  
  public final void c(final long paramLong, int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(88945);
    ad.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskFailed: %d, errCode : %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    e.ud(paramLong);
    a locala = d.ua(paramLong);
    if (locala != null) {
      com.tencent.mm.plugin.downloader.a.c.u(new String[] { locala.field_downloadUrl, locala.field_secondaryUrl });
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88935);
        m[] arrayOfm = c.ccg();
        int j = arrayOfm.length;
        int i = 0;
        while (i < j)
        {
          arrayOfm[i].a(paramLong, paramBoolean, this.pme);
          i += 1;
        }
        if (c.cch() != null) {
          c.cch().a(paramLong, paramBoolean, this.pme);
        }
        AppMethodBeat.o(88935);
      }
    });
    AppMethodBeat.o(88945);
  }
  
  public final void c(final long paramLong, String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(88944);
    ad.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskFinished: %d", new Object[] { Long.valueOf(paramLong) });
    e.ud(paramLong);
    a locala = d.ua(paramLong);
    if (locala != null) {
      com.tencent.mm.plugin.downloader.a.c.u(new String[] { locala.field_downloadUrl, locala.field_secondaryUrl });
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88934);
        m[] arrayOfm = c.ccg();
        int j = arrayOfm.length;
        int i = 0;
        while (i < j)
        {
          arrayOfm[i].b(paramLong, paramBoolean, this.pme);
          i += 1;
        }
        if (c.cch() != null) {
          c.cch().b(paramLong, paramBoolean, this.pme);
        }
        AppMethodBeat.o(88934);
      }
    });
    AppMethodBeat.o(88944);
  }
  
  public final void l(final long paramLong, String paramString)
  {
    AppMethodBeat.i(88941);
    ad.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskStarted: %d, %s", new Object[] { Long.valueOf(paramLong), paramString });
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88931);
        m[] arrayOfm = c.ccg();
        int j = arrayOfm.length;
        int i = 0;
        while (i < j)
        {
          arrayOfm[i].j(paramLong, this.val$path);
          i += 1;
        }
        if (c.cch() != null) {
          c.cch().j(paramLong, this.val$path);
        }
        AppMethodBeat.o(88931);
      }
    });
    AppMethodBeat.o(88941);
  }
  
  public final void m(final long paramLong, String paramString)
  {
    AppMethodBeat.i(88942);
    ad.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskResumed: %d, %s", new Object[] { Long.valueOf(paramLong), paramString });
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88932);
        m[] arrayOfm = c.ccg();
        int j = arrayOfm.length;
        int i = 0;
        while (i < j)
        {
          arrayOfm[i].k(paramLong, this.val$path);
          i += 1;
        }
        if (c.cch() != null) {
          c.cch().k(paramLong, this.val$path);
        }
        AppMethodBeat.o(88932);
      }
    });
    AppMethodBeat.o(88942);
  }
  
  public final void tX(final long paramLong)
  {
    AppMethodBeat.i(88943);
    ad.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskRemoved: %d", new Object[] { Long.valueOf(paramLong) });
    a locala = d.ua(paramLong);
    if (locala != null) {
      com.tencent.mm.plugin.downloader.a.c.u(new String[] { locala.field_downloadUrl, locala.field_secondaryUrl });
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88933);
        m[] arrayOfm = c.ccg();
        int j = arrayOfm.length;
        int i = 0;
        while (i < j)
        {
          arrayOfm[i].sL(paramLong);
          i += 1;
        }
        if (c.cch() != null) {
          c.cch().sL(paramLong);
        }
        AppMethodBeat.o(88933);
      }
    });
    AppMethodBeat.o(88943);
  }
  
  public final void tY(final long paramLong)
  {
    AppMethodBeat.i(88946);
    ad.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskPaused: %d", new Object[] { Long.valueOf(paramLong) });
    a locala = d.ua(paramLong);
    if (locala != null) {
      com.tencent.mm.plugin.downloader.a.c.u(new String[] { locala.field_downloadUrl, locala.field_secondaryUrl });
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88936);
        m[] arrayOfm = c.ccg();
        int j = arrayOfm.length;
        int i = 0;
        while (i < j)
        {
          arrayOfm[i].sM(paramLong);
          i += 1;
        }
        if (c.cch() != null) {
          c.cch().sM(paramLong);
        }
        AppMethodBeat.o(88936);
      }
    });
    AppMethodBeat.o(88946);
  }
  
  public final void tZ(final long paramLong)
  {
    AppMethodBeat.i(88948);
    ad.i("MicroMsg.FileDownloaderCallbackManager", "notifyMd5Checking: %d", new Object[] { Long.valueOf(paramLong) });
    e.uc(paramLong);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88938);
        m[] arrayOfm = c.ccg();
        int j = arrayOfm.length;
        int i = 0;
        while (i < j)
        {
          arrayOfm[i].sN(paramLong);
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