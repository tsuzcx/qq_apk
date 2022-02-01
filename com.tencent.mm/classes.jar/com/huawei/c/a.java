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
  private c chS;
  private b chT;
  a chU;
  private int chV;
  b chW;
  int chX;
  private IBinder.DeathRecipient chY;
  
  private a(c paramc, Looper paramLooper)
  {
    AppMethodBeat.i(88756);
    this.chX = -1;
    this.chY = new IBinder.DeathRecipient()
    {
      public final void binderDied()
      {
        AppMethodBeat.i(88781);
        if (a.this.chW != null) {
          a.this.chW.G(2101, -1, a.this.chX);
        }
        AppMethodBeat.o(88781);
      }
    };
    this.chS = paramc;
    paramLooper = new a(paramLooper);
    this.chV = 1;
    this.chT = new b.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(88780);
        a.this.chU.sendMessage(a.this.chU.obtainMessage(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousArrayOfByte));
        AppMethodBeat.o(88780);
      }
    };
    if (!this.chS.a(this.chT, 1))
    {
      paramc = new RuntimeException();
      AppMethodBeat.o(88756);
      throw paramc;
    }
    this.chU = paramLooper;
    paramc.asBinder().linkToDeath(this.chY, 0);
    AppMethodBeat.o(88756);
  }
  
  public static a Kh()
  {
    AppMethodBeat.i(88755);
    Object localObject = Kk();
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
  
  public static int[] Kj()
  {
    AppMethodBeat.i(88761);
    Object localObject = Kk();
    if (localObject == null)
    {
      AppMethodBeat.o(88761);
      return new int[0];
    }
    try
    {
      localObject = ((c)localObject).Kl();
      AppMethodBeat.o(88761);
      return localObject;
    }
    catch (RemoteException localRemoteException)
    {
      AppMethodBeat.o(88761);
    }
    return new int[0];
  }
  
  private static c Kk()
  {
    AppMethodBeat.i(88762);
    c localc = c.a.l(ServiceManager.getService("authentication_service"));
    AppMethodBeat.o(88762);
    return localc;
  }
  
  public final int[] Ki()
  {
    AppMethodBeat.i(88758);
    try
    {
      int[] arrayOfInt = this.chS.c(this.chT);
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
    this.chW = paramb;
    this.chX = 0;
    try
    {
      int i = this.chS.a(this.chT, paramArrayOfInt, null);
      AppMethodBeat.o(88759);
      return i;
    }
    catch (RemoteException paramb)
    {
      AppMethodBeat.o(88759);
    }
    return -1;
  }
  
  public final void hL()
  {
    AppMethodBeat.i(88760);
    if (this.chU != null) {
      this.chU.removeMessages(8);
    }
    try
    {
      this.chS.a(this.chT);
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
    if (this.chU != null) {
      this.chU.removeMessages(8);
    }
    try
    {
      this.chS.b(this.chT);
      this.chS.asBinder().unlinkToDeath(this.chY, 0);
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
    private final int cia = 2001;
    private final int cib = 2002;
    private final int cic = 2003;
    private final int cid = 2004;
    private final int cie = 2005;
    private final int cif = 2006;
    
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
        if (a.this.chW != null)
        {
          a.this.chW.ci(1, a.this.chX);
          AppMethodBeat.o(88782);
          return;
          if (a.this.chW != null)
          {
            a.this.chW.ci(2, a.this.chX);
            AppMethodBeat.o(88782);
            return;
            if (a.this.chW != null)
            {
              a.this.chW.ci(3, a.this.chX);
              AppMethodBeat.o(88782);
              return;
              if (a.this.chW != null) {
                a.this.chW.G(0, paramMessage.arg1, a.this.chX);
              }
              removeMessages(8);
              AppMethodBeat.o(88782);
              return;
              if (a.this.chW != null) {
                switch (paramMessage.arg1)
                {
                default: 
                  i = 2020;
                }
              }
              for (;;)
              {
                a.this.chW.G(i, -1, a.this.chX);
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
              if (a.this.chW != null) {
                a.this.chW.G(2001, -1, a.this.chX);
              }
              removeMessages(8);
              a.this.hL();
            }
          }
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void G(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void ci(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.huawei.c.a
 * JD-Core Version:    0.7.0.1
 */