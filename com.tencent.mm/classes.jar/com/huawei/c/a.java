package com.huawei.c;

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
  private c dYa;
  private b dYb;
  a dYc;
  private int dYd;
  b dYe;
  int dYf;
  private IBinder.DeathRecipient dYg;
  
  private a(c paramc, Looper paramLooper)
  {
    AppMethodBeat.i(88756);
    this.dYf = -1;
    this.dYg = new IBinder.DeathRecipient()
    {
      public final void binderDied()
      {
        AppMethodBeat.i(88781);
        if (a.this.dYe != null) {
          a.this.dYe.V(2101, -1, a.this.dYf);
        }
        AppMethodBeat.o(88781);
      }
    };
    this.dYa = paramc;
    paramLooper = new a(paramLooper);
    this.dYd = 1;
    this.dYb = new b.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(88780);
        a.this.dYc.sendMessage(a.this.dYc.obtainMessage(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousArrayOfByte));
        AppMethodBeat.o(88780);
      }
    };
    if (!this.dYa.a(this.dYb, 1))
    {
      paramc = new RuntimeException();
      AppMethodBeat.o(88756);
      throw paramc;
    }
    this.dYc = paramLooper;
    paramc.asBinder().linkToDeath(this.dYg, 0);
    AppMethodBeat.o(88756);
  }
  
  public static a aki()
  {
    AppMethodBeat.i(88755);
    Object localObject = akl();
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
  
  public static int[] akk()
  {
    AppMethodBeat.i(88761);
    Object localObject = akl();
    if (localObject == null)
    {
      AppMethodBeat.o(88761);
      return new int[0];
    }
    try
    {
      localObject = ((c)localObject).akm();
      AppMethodBeat.o(88761);
      return localObject;
    }
    catch (RemoteException localRemoteException)
    {
      AppMethodBeat.o(88761);
    }
    return new int[0];
  }
  
  private static c akl()
  {
    AppMethodBeat.i(88762);
    c localc = c.a.m(ServiceManager.getService("authentication_service"));
    AppMethodBeat.o(88762);
    return localc;
  }
  
  public final void Fw()
  {
    AppMethodBeat.i(88760);
    if (this.dYc != null) {
      this.dYc.removeMessages(8);
    }
    try
    {
      this.dYa.a(this.dYb);
      AppMethodBeat.o(88760);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      AppMethodBeat.o(88760);
    }
  }
  
  public final int a(b paramb, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(88759);
    if (paramArrayOfInt == null)
    {
      AppMethodBeat.o(88759);
      return -1;
    }
    this.dYe = paramb;
    this.dYf = 0;
    try
    {
      int i = this.dYa.a(this.dYb, paramArrayOfInt, null);
      AppMethodBeat.o(88759);
      return i;
    }
    catch (RemoteException paramb)
    {
      AppMethodBeat.o(88759);
    }
    return -1;
  }
  
  public final int[] akj()
  {
    AppMethodBeat.i(88758);
    try
    {
      int[] arrayOfInt = this.dYa.c(this.dYb);
      AppMethodBeat.o(88758);
      return arrayOfInt;
    }
    catch (RemoteException localRemoteException)
    {
      AppMethodBeat.o(88758);
    }
    return new int[0];
  }
  
  public final void release()
  {
    AppMethodBeat.i(88757);
    if (this.dYc != null) {
      this.dYc.removeMessages(8);
    }
    try
    {
      this.dYa.b(this.dYb);
      this.dYa.asBinder().unlinkToDeath(this.dYg, 0);
      AppMethodBeat.o(88757);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      AppMethodBeat.o(88757);
    }
  }
  
  final class a
    extends Handler
  {
    private final int dYi = 2001;
    private final int dYj = 2002;
    private final int dYk = 2003;
    private final int dYl = 2004;
    private final int dYm = 2005;
    private final int dYn = 2006;
    
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
        if (a.this.dYe != null)
        {
          a.this.dYe.cV(1, a.this.dYf);
          AppMethodBeat.o(88782);
          return;
          if (a.this.dYe != null)
          {
            a.this.dYe.cV(2, a.this.dYf);
            AppMethodBeat.o(88782);
            return;
            if (a.this.dYe != null)
            {
              a.this.dYe.cV(3, a.this.dYf);
              AppMethodBeat.o(88782);
              return;
              if (a.this.dYe != null) {
                a.this.dYe.V(0, paramMessage.arg1, a.this.dYf);
              }
              removeMessages(8);
              AppMethodBeat.o(88782);
              return;
              if (a.this.dYe != null) {
                switch (paramMessage.arg1)
                {
                default: 
                  i = 2020;
                }
              }
              for (;;)
              {
                a.this.dYe.V(i, -1, a.this.dYf);
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
              if (a.this.dYe != null) {
                a.this.dYe.V(2001, -1, a.this.dYf);
              }
              removeMessages(8);
              a.this.Fw();
            }
          }
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void V(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void cV(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.huawei.c.a
 * JD-Core Version:    0.7.0.1
 */