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
  private IBinder.DeathRecipient bNA;
  private c bNu;
  private b bNv;
  a bNw;
  private int bNx;
  b bNy;
  int bNz;
  
  private a(c paramc, Looper paramLooper)
  {
    AppMethodBeat.i(88756);
    this.bNz = -1;
    this.bNA = new IBinder.DeathRecipient()
    {
      public final void binderDied()
      {
        AppMethodBeat.i(88781);
        if (a.this.bNy != null) {
          a.this.bNy.D(2101, -1, a.this.bNz);
        }
        AppMethodBeat.o(88781);
      }
    };
    this.bNu = paramc;
    paramLooper = new a(paramLooper);
    this.bNx = 1;
    this.bNv = new b.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(88780);
        a.this.bNw.sendMessage(a.this.bNw.obtainMessage(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousArrayOfByte));
        AppMethodBeat.o(88780);
      }
    };
    if (!this.bNu.a(this.bNv, 1))
    {
      paramc = new RuntimeException();
      AppMethodBeat.o(88756);
      throw paramc;
    }
    this.bNw = paramLooper;
    paramc.asBinder().linkToDeath(this.bNA, 0);
    AppMethodBeat.o(88756);
  }
  
  public static a yC()
  {
    AppMethodBeat.i(88755);
    Object localObject = yF();
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
  
  public static int[] yE()
  {
    AppMethodBeat.i(88761);
    Object localObject = yF();
    if (localObject == null)
    {
      AppMethodBeat.o(88761);
      return new int[0];
    }
    try
    {
      localObject = ((c)localObject).yG();
      AppMethodBeat.o(88761);
      return localObject;
    }
    catch (RemoteException localRemoteException)
    {
      AppMethodBeat.o(88761);
    }
    return new int[0];
  }
  
  private static c yF()
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
    this.bNy = paramb;
    this.bNz = 0;
    try
    {
      int i = this.bNu.a(this.bNv, paramArrayOfInt, null);
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
    if (this.bNw != null) {
      this.bNw.removeMessages(8);
    }
    try
    {
      this.bNu.a(this.bNv);
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
    if (this.bNw != null) {
      this.bNw.removeMessages(8);
    }
    try
    {
      this.bNu.b(this.bNv);
      this.bNu.asBinder().unlinkToDeath(this.bNA, 0);
      AppMethodBeat.o(88757);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      AppMethodBeat.o(88757);
    }
  }
  
  public final int[] yD()
  {
    AppMethodBeat.i(88758);
    try
    {
      int[] arrayOfInt = this.bNu.c(this.bNv);
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
    private final int bNC = 2001;
    private final int bND = 2002;
    private final int bNE = 2003;
    private final int bNF = 2004;
    private final int bNG = 2005;
    private final int bNH = 2006;
    
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
        if (a.this.bNy != null)
        {
          a.this.bNy.bR(1, a.this.bNz);
          AppMethodBeat.o(88782);
          return;
          if (a.this.bNy != null)
          {
            a.this.bNy.bR(2, a.this.bNz);
            AppMethodBeat.o(88782);
            return;
            if (a.this.bNy != null)
            {
              a.this.bNy.bR(3, a.this.bNz);
              AppMethodBeat.o(88782);
              return;
              if (a.this.bNy != null) {
                a.this.bNy.D(0, paramMessage.arg1, a.this.bNz);
              }
              removeMessages(8);
              AppMethodBeat.o(88782);
              return;
              if (a.this.bNy != null) {
                switch (paramMessage.arg1)
                {
                default: 
                  i = 2020;
                }
              }
              for (;;)
              {
                a.this.bNy.D(i, -1, a.this.bNz);
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
              if (a.this.bNy != null) {
                a.this.bNy.D(2001, -1, a.this.bNz);
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
    
    public abstract void bR(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.a.a.a
 * JD-Core Version:    0.7.0.1
 */