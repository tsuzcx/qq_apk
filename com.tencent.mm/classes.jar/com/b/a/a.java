package com.b.a;

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
  private c bVp;
  private b bVq;
  a bVr;
  private int bVs;
  b bVt;
  int bVu;
  private IBinder.DeathRecipient bVv;
  
  private a(c paramc, Looper paramLooper)
  {
    AppMethodBeat.i(88756);
    this.bVu = -1;
    this.bVv = new IBinder.DeathRecipient()
    {
      public final void binderDied()
      {
        AppMethodBeat.i(88781);
        if (a.this.bVt != null) {
          a.this.bVt.D(2101, -1, a.this.bVu);
        }
        AppMethodBeat.o(88781);
      }
    };
    this.bVp = paramc;
    paramLooper = new a(paramLooper);
    this.bVs = 1;
    this.bVq = new b.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(88780);
        a.this.bVr.sendMessage(a.this.bVr.obtainMessage(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousArrayOfByte));
        AppMethodBeat.o(88780);
      }
    };
    if (!this.bVp.a(this.bVq, 1))
    {
      paramc = new RuntimeException();
      AppMethodBeat.o(88756);
      throw paramc;
    }
    this.bVr = paramLooper;
    paramc.asBinder().linkToDeath(this.bVv, 0);
    AppMethodBeat.o(88756);
  }
  
  public static a zM()
  {
    AppMethodBeat.i(88755);
    Object localObject = zP();
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
  
  public static int[] zO()
  {
    AppMethodBeat.i(88761);
    Object localObject = zP();
    if (localObject == null)
    {
      AppMethodBeat.o(88761);
      return new int[0];
    }
    try
    {
      localObject = ((c)localObject).zQ();
      AppMethodBeat.o(88761);
      return localObject;
    }
    catch (RemoteException localRemoteException)
    {
      AppMethodBeat.o(88761);
    }
    return new int[0];
  }
  
  private static c zP()
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
    this.bVt = paramb;
    this.bVu = 0;
    try
    {
      int i = this.bVp.a(this.bVq, paramArrayOfInt, null);
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
    if (this.bVr != null) {
      this.bVr.removeMessages(8);
    }
    try
    {
      this.bVp.a(this.bVq);
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
    if (this.bVr != null) {
      this.bVr.removeMessages(8);
    }
    try
    {
      this.bVp.b(this.bVq);
      this.bVp.asBinder().unlinkToDeath(this.bVv, 0);
      AppMethodBeat.o(88757);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      AppMethodBeat.o(88757);
    }
  }
  
  public final int[] zN()
  {
    AppMethodBeat.i(88758);
    try
    {
      int[] arrayOfInt = this.bVp.c(this.bVq);
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
    private final int bVA = 2004;
    private final int bVB = 2005;
    private final int bVC = 2006;
    private final int bVx = 2001;
    private final int bVy = 2002;
    private final int bVz = 2003;
    
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
        if (a.this.bVt != null)
        {
          a.this.bVt.bQ(1, a.this.bVu);
          AppMethodBeat.o(88782);
          return;
          if (a.this.bVt != null)
          {
            a.this.bVt.bQ(2, a.this.bVu);
            AppMethodBeat.o(88782);
            return;
            if (a.this.bVt != null)
            {
              a.this.bVt.bQ(3, a.this.bVu);
              AppMethodBeat.o(88782);
              return;
              if (a.this.bVt != null) {
                a.this.bVt.D(0, paramMessage.arg1, a.this.bVu);
              }
              removeMessages(8);
              AppMethodBeat.o(88782);
              return;
              if (a.this.bVt != null) {
                switch (paramMessage.arg1)
                {
                default: 
                  i = 2020;
                }
              }
              for (;;)
              {
                a.this.bVt.D(i, -1, a.this.bVu);
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
              if (a.this.bVt != null) {
                a.this.bVt.D(2001, -1, a.this.bVu);
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
    
    public abstract void bQ(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.b.a.a
 * JD-Core Version:    0.7.0.1
 */