package com.a.a;

import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private c bLc;
  private b bLd;
  a bLe;
  private int bLf;
  b bLg;
  int bLh;
  private IBinder.DeathRecipient bLi;
  
  private a(c paramc, Looper paramLooper)
  {
    AppMethodBeat.i(88756);
    this.bLh = -1;
    this.bLi = new IBinder.DeathRecipient()
    {
      public final void binderDied()
      {
        AppMethodBeat.i(88781);
        if (a.this.bLg != null) {
          a.this.bLg.D(2101, -1, a.this.bLh);
        }
        AppMethodBeat.o(88781);
      }
    };
    this.bLc = paramc;
    paramLooper = new a(paramLooper);
    this.bLf = 1;
    this.bLd = new b.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(88780);
        a.this.bLe.sendMessage(a.this.bLe.obtainMessage(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousArrayOfByte));
        AppMethodBeat.o(88780);
      }
    };
    if (!this.bLc.a(this.bLd, 1))
    {
      paramc = new RuntimeException();
      AppMethodBeat.o(88756);
      throw paramc;
    }
    this.bLe = paramLooper;
    paramc.asBinder().linkToDeath(this.bLi, 0);
    AppMethodBeat.o(88756);
  }
  
  public static a yp()
  {
    AppMethodBeat.i(88755);
    Object localObject = ys();
    if (localObject == null)
    {
      AppMethodBeat.o(88755);
      return null;
    }
    Looper localLooper = Looper.getMainLooper();
    try
    {
      localObject = new a((c)localObject, localLooper);
      AppMethodBeat.o(88755);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(88755);
    }
    return null;
  }
  
  public static int[] yr()
  {
    AppMethodBeat.i(88761);
    Object localObject = ys();
    if (localObject == null)
    {
      AppMethodBeat.o(88761);
      return new int[0];
    }
    try
    {
      localObject = ((c)localObject).yt();
      AppMethodBeat.o(88761);
      return localObject;
    }
    catch (RemoteException localRemoteException)
    {
      AppMethodBeat.o(88761);
    }
    return new int[0];
  }
  
  private static c ys()
  {
    AppMethodBeat.i(88762);
    c localc = c.a.i(ServiceManager.getService("authentication_service"));
    AppMethodBeat.o(88762);
    return localc;
  }
  
  public final int a(b paramb, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(88759);
    if (paramArrayOfInt == null)
    {
      AppMethodBeat.o(88759);
      return -1;
    }
    this.bLg = paramb;
    this.bLh = 0;
    try
    {
      int i = this.bLc.a(this.bLd, paramArrayOfInt, null);
      AppMethodBeat.o(88759);
      return i;
    }
    catch (RemoteException paramb)
    {
      AppMethodBeat.o(88759);
    }
    return -1;
  }
  
  public final void abort()
  {
    AppMethodBeat.i(88760);
    if (this.bLe != null) {
      this.bLe.removeMessages(8);
    }
    try
    {
      this.bLc.a(this.bLd);
      AppMethodBeat.o(88760);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      AppMethodBeat.o(88760);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(88757);
    if (this.bLe != null) {
      this.bLe.removeMessages(8);
    }
    try
    {
      this.bLc.b(this.bLd);
      this.bLc.asBinder().unlinkToDeath(this.bLi, 0);
      AppMethodBeat.o(88757);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      AppMethodBeat.o(88757);
    }
  }
  
  public final int[] yq()
  {
    AppMethodBeat.i(88758);
    try
    {
      int[] arrayOfInt = this.bLc.c(this.bLd);
      AppMethodBeat.o(88758);
      return arrayOfInt;
    }
    catch (RemoteException localRemoteException)
    {
      AppMethodBeat.o(88758);
    }
    return new int[0];
  }
  
  final class a
    extends Handler
  {
    private final int bLk = 2001;
    private final int bLl = 2002;
    private final int bLm = 2003;
    private final int bLn = 2004;
    private final int bLo = 2005;
    private final int bLp = 2006;
    
    public a(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      int i = 2005;
      AppMethodBeat.i(88782);
      new StringBuilder("what = ").append(paramMessage.what);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(88782);
        return;
        if (a.this.bLg != null)
        {
          a.this.bLg.bO(1, a.this.bLh);
          AppMethodBeat.o(88782);
          return;
          if (a.this.bLg != null)
          {
            a.this.bLg.bO(2, a.this.bLh);
            AppMethodBeat.o(88782);
            return;
            if (a.this.bLg != null)
            {
              a.this.bLg.bO(3, a.this.bLh);
              AppMethodBeat.o(88782);
              return;
              if (a.this.bLg != null) {
                a.this.bLg.D(0, paramMessage.arg1, a.this.bLh);
              }
              removeMessages(8);
              AppMethodBeat.o(88782);
              return;
              if (a.this.bLg != null) {
                switch (paramMessage.arg1)
                {
                default: 
                  i = 2020;
                }
              }
              for (;;)
              {
                a.this.bLg.D(i, -1, a.this.bLh);
                removeMessages(8);
                AppMethodBeat.o(88782);
                return;
                i = 2002;
                continue;
                i = 2003;
                continue;
                i = 2000;
                continue;
                i = 2006;
              }
              if (a.this.bLg != null) {
                a.this.bLg.D(2001, -1, a.this.bLh);
              }
              removeMessages(8);
              a.this.abort();
            }
          }
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void D(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void bO(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.a.a.a
 * JD-Core Version:    0.7.0.1
 */