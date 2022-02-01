package com.appaac.haptic.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  int crb;
  int crd;
  private int cre = 255;
  int crf;
  a crg;
  Handler handler;
  private HandlerThread handlerThread;
  
  public final int Nu()
  {
    try
    {
      int i = this.cre;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(int paramInt, a parama)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(208382);
        if (paramInt >= 0) {
          continue;
        }
        AppMethodBeat.o(208382);
      }
      finally
      {
        try
        {
          this.crd = 1;
          this.crb = 0;
          this.crf = paramInt;
          this.crg = parama;
          this.handlerThread = new HandlerThread("RepeatExecutor");
          this.handlerThread.start();
          this.handler = new Handler(this.handlerThread.getLooper())
          {
            public final void handleMessage(Message paramAnonymousMessage)
            {
              AppMethodBeat.i(208365);
              for (;;)
              {
                try
                {
                  i = paramAnonymousMessage.what;
                  switch (i)
                  {
                  }
                }
                finally
                {
                  AppMethodBeat.o(208365);
                  return;
                }
                f.this.crg.Nv();
                f.this.handler.sendEmptyMessageDelayed(102, f.this.crf);
                AppMethodBeat.o(208365);
                return;
                paramAnonymousMessage = f.this;
                int i = paramAnonymousMessage.crd - 1;
                paramAnonymousMessage.crd = i;
                if (i > 0) {
                  f.this.handler.sendEmptyMessageDelayed(101, f.this.crb);
                }
              }
            }
          };
          this.handler.sendEmptyMessage(101);
          AppMethodBeat.o(208382);
          continue;
        }
        finally {}
        parama = finally;
      }
      return;
    }
  }
  
  public final void gT(int paramInt)
  {
    try
    {
      this.crb = 0;
      if ((paramInt >= 0) && (paramInt <= 255)) {
        this.cre = paramInt;
      }
      return;
    }
    finally {}
  }
  
  public final void quit()
  {
    try
    {
      AppMethodBeat.i(208399);
      try
      {
        if (this.handlerThread != null)
        {
          this.handlerThread.quit();
          this.handlerThread = null;
        }
        this.handler = null;
        AppMethodBeat.o(208399);
      }
      finally
      {
        for (;;)
        {
          AppMethodBeat.o(208399);
        }
      }
      return;
    }
    finally {}
  }
  
  public static abstract class a
  {
    protected abstract void Nv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.appaac.haptic.a.f
 * JD-Core Version:    0.7.0.1
 */