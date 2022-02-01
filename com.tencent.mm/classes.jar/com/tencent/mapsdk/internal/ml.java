package com.tencent.mapsdk.internal;

import android.util.Log;
import com.tencent.mapsdk.engine.jni.JNI;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ml
  extends Thread
{
  private static final int c = 80;
  public volatile boolean a;
  public volatile boolean b;
  private mk d;
  private volatile boolean e;
  
  public ml(mk parammk)
  {
    AppMethodBeat.i(222982);
    this.e = false;
    this.a = false;
    this.b = false;
    setName("tms-texture");
    this.d = parammk;
    AppMethodBeat.o(222982);
  }
  
  private void b()
  {
    this.a = true;
  }
  
  private void c()
  {
    AppMethodBeat.i(222996);
    this.a = false;
    try
    {
      notifyAll();
      return;
    }
    finally
    {
      AppMethodBeat.o(222996);
    }
  }
  
  private boolean d()
  {
    AppMethodBeat.i(223004);
    if (this.d != null)
    {
      Object localObject = this.d;
      if (((mk)localObject).g == null)
      {
        AppMethodBeat.o(223004);
        return false;
      }
      localObject = ((mk)localObject).g;
      if (((sc)localObject).e == 0L)
      {
        AppMethodBeat.o(223004);
        return false;
      }
      if (System.currentTimeMillis() - ((sc)localObject).k > 560L)
      {
        ((sc)localObject).d.nativeClearDownloadURLCache(((sc)localObject).e);
        ((sc)localObject).k = System.currentTimeMillis();
      }
      boolean bool = ((sc)localObject).d.nativeGenerateTextures(((sc)localObject).e);
      AppMethodBeat.o(223004);
      return bool;
    }
    AppMethodBeat.o(223004);
    return false;
  }
  
  private boolean e()
  {
    return this.b;
  }
  
  public final void a()
  {
    AppMethodBeat.i(223024);
    this.a = false;
    this.e = true;
    try
    {
      notifyAll();
      return;
    }
    finally
    {
      AppMethodBeat.o(223024);
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(223017);
    label158:
    label161:
    for (;;)
    {
      boolean bool;
      if (!this.e)
      {
        if (this.a) {
          break label158;
        }
        if (this.d != null)
        {
          Object localObject1 = this.d;
          if (((mk)localObject1).g != null)
          {
            localObject1 = ((mk)localObject1).g;
            if (((sc)localObject1).e != 0L)
            {
              if (System.currentTimeMillis() - ((sc)localObject1).k > 560L)
              {
                ((sc)localObject1).d.nativeClearDownloadURLCache(((sc)localObject1).e);
                ((sc)localObject1).k = System.currentTimeMillis();
              }
              bool = ((sc)localObject1).d.nativeGenerateTextures(((sc)localObject1).e);
            }
          }
        }
      }
      for (;;)
      {
        for (;;)
        {
          if (bool) {
            break label161;
          }
          try
          {
            for (;;)
            {
              try
              {
                wait(80L);
                break;
              }
              finally
              {
                localObject2 = finally;
                AppMethodBeat.o(223017);
                throw localObject2;
              }
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            kh.a(Log.getStackTraceString(localInterruptedException));
            Thread.currentThread().interrupt();
          }
        }
        bool = false;
        continue;
        this.b = true;
        AppMethodBeat.o(223017);
        return;
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ml
 * JD-Core Version:    0.7.0.1
 */