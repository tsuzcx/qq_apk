package com.huawei.b;

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
  private c cfQ;
  private b cfR;
  a cfS;
  private int cfT;
  b cfU;
  int cfV;
  private IBinder.DeathRecipient cfW;
  
  private a(c paramc, Looper paramLooper)
  {
    AppMethodBeat.i(88756);
    this.cfV = -1;
    this.cfW = new IBinder.DeathRecipient()
    {
      public final void binderDied()
      {
        AppMethodBeat.i(88781);
        if (a.this.cfU != null) {
          a.this.cfU.D(2101, -1, a.this.cfV);
        }
        AppMethodBeat.o(88781);
      }
    };
    this.cfQ = paramc;
    paramLooper = new a(paramLooper);
    this.cfT = 1;
    this.cfR = new b.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(88780);
        a.this.cfS.sendMessage(a.this.cfS.obtainMessage(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousArrayOfByte));
        AppMethodBeat.o(88780);
      }
    };
    if (!this.cfQ.a(this.cfR, 1))
    {
      paramc = new RuntimeException();
      AppMethodBeat.o(88756);
      throw paramc;
    }
    this.cfS = paramLooper;
    paramc.asBinder().linkToDeath(this.cfW, 0);
    AppMethodBeat.o(88756);
  }
  
  public static a IE()
  {
    AppMethodBeat.i(88755);
    Object localObject = IH();
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
  
  public static int[] IG()
  {
    AppMethodBeat.i(88761);
    Object localObject = IH();
    if (localObject == null)
    {
      AppMethodBeat.o(88761);
      return new int[0];
    }
    try
    {
      localObject = ((c)localObject).II();
      AppMethodBeat.o(88761);
      return localObject;
    }
    catch (RemoteException localRemoteException)
    {
      AppMethodBeat.o(88761);
    }
    return new int[0];
  }
  
  private static c IH()
  {
    AppMethodBeat.i(88762);
    c localc = c.a.j(ServiceManager.getService("authentication_service"));
    AppMethodBeat.o(88762);
    return localc;
  }
  
  public final int[] IF()
  {
    AppMethodBeat.i(88758);
    try
    {
      int[] arrayOfInt = this.cfQ.c(this.cfR);
      AppMethodBeat.o(88758);
      return arrayOfInt;
    }
    catch (RemoteException localRemoteException)
    {
      AppMethodBeat.o(88758);
    }
    return new int[0];
  }
  
  public final int a(b paramb, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(88759);
    if (paramArrayOfInt == null)
    {
      AppMethodBeat.o(88759);
      return -1;
    }
    this.cfU = paramb;
    this.cfV = 0;
    try
    {
      int i = this.cfQ.a(this.cfR, paramArrayOfInt, null);
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
    if (this.cfS != null) {
      this.cfS.removeMessages(8);
    }
    try
    {
      this.cfQ.a(this.cfR);
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
    if (this.cfS != null) {
      this.cfS.removeMessages(8);
    }
    try
    {
      this.cfQ.b(this.cfR);
      this.cfQ.asBinder().unlinkToDeath(this.cfW, 0);
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
    private final int cfY = 2001;
    private final int cfZ = 2002;
    private final int cga = 2003;
    private final int cgb = 2004;
    private final int cgc = 2005;
    private final int cgd = 2006;
    
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
        if (a.this.cfU != null)
        {
          a.this.cfU.bQ(1, a.this.cfV);
          AppMethodBeat.o(88782);
          return;
          if (a.this.cfU != null)
          {
            a.this.cfU.bQ(2, a.this.cfV);
            AppMethodBeat.o(88782);
            return;
            if (a.this.cfU != null)
            {
              a.this.cfU.bQ(3, a.this.cfV);
              AppMethodBeat.o(88782);
              return;
              if (a.this.cfU != null) {
                a.this.cfU.D(0, paramMessage.arg1, a.this.cfV);
              }
              removeMessages(8);
              AppMethodBeat.o(88782);
              return;
              if (a.this.cfU != null) {
                switch (paramMessage.arg1)
                {
                default: 
                  i = 2020;
                }
              }
              for (;;)
              {
                a.this.cfU.D(i, -1, a.this.cfV);
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
              if (a.this.cfU != null) {
                a.this.cfU.D(2001, -1, a.this.cfV);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.huawei.b.a
 * JD-Core Version:    0.7.0.1
 */