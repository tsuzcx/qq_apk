package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

final class aj
  implements ServiceConnection
{
  final Messenger dDV;
  ao dDW;
  final Queue<c<?>> dDX;
  final SparseArray<c<?>> dDY;
  int state;
  
  private aj(ai paramai)
  {
    AppMethodBeat.i(4256);
    this.state = 0;
    this.dDV = new Messenger(new Handler(Looper.getMainLooper(), new ak(this)));
    this.dDX = new ArrayDeque();
    this.dDY = new SparseArray();
    AppMethodBeat.o(4256);
  }
  
  private final void zzt()
  {
    AppMethodBeat.i(4260);
    this.dDZ.dDS.execute(new am(this));
    AppMethodBeat.o(4260);
  }
  
  final boolean b(c paramc)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(4257);
        switch (this.state)
        {
        case 0: 
          int i = this.state;
          paramc = new IllegalStateException(26 + "Unknown state: " + i);
          AppMethodBeat.o(4257);
          throw paramc;
        }
      }
      finally {}
      this.dDX.add(paramc);
      if (this.state == 0) {
        bool1 = true;
      }
      Preconditions.checkState(bool1);
      Log.isLoggable("MessengerIpcClient", 2);
      this.state = 1;
      paramc = new Intent("com.google.android.c2dm.intent.REGISTER");
      paramc.setPackage("com.google.android.gms");
      if (!ConnectionTracker.getInstance().bindService(this.dDZ.dCI, paramc, this, 1))
      {
        zza(0, "Unable to bind to service");
        AppMethodBeat.o(4257);
        bool1 = bool2;
      }
      for (;;)
      {
        return bool1;
        this.dDZ.dDS.schedule(new al(this), 30L, TimeUnit.SECONDS);
        break;
        this.dDX.add(paramc);
        AppMethodBeat.o(4257);
        bool1 = bool2;
        continue;
        this.dDX.add(paramc);
        zzt();
        AppMethodBeat.o(4257);
        bool1 = bool2;
        continue;
        AppMethodBeat.o(4257);
        bool1 = false;
      }
    }
  }
  
  final boolean f(Message paramMessage)
  {
    AppMethodBeat.i(4258);
    int i = paramMessage.arg1;
    if (Log.isLoggable("MessengerIpcClient", 3)) {
      new StringBuilder(41).append("Received response to request: ").append(i);
    }
    for (;;)
    {
      c localc;
      try
      {
        localc = (c)this.dDY.get(i);
        if (localc == null)
        {
          new StringBuilder(50).append("Received response for unknown request: ").append(i);
          return true;
        }
        this.dDY.remove(i);
        zzu();
        paramMessage = paramMessage.getData();
        if (paramMessage.getBoolean("unsupported", false))
        {
          localc.a(new d(4, "Not supported by GmsCore"));
          AppMethodBeat.o(4258);
          return true;
        }
      }
      finally
      {
        AppMethodBeat.o(4258);
      }
      localc.zzb(paramMessage);
    }
  }
  
  final void jB(int paramInt)
  {
    try
    {
      AppMethodBeat.i(4265);
      c localc = (c)this.dDY.get(paramInt);
      if (localc != null)
      {
        new StringBuilder(31).append("Timing out request: ").append(paramInt);
        this.dDY.remove(paramInt);
        localc.a(new d(3, "Timed out waiting for response"));
        zzu();
      }
      AppMethodBeat.o(4265);
      return;
    }
    finally {}
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(4259);
        Log.isLoggable("MessengerIpcClient", 2);
        if (paramIBinder != null) {
          continue;
        }
        zza(0, "Null service connection");
        AppMethodBeat.o(4259);
      }
      finally
      {
        try
        {
          this.dDW = new ao(paramIBinder);
          this.state = 2;
          zzt();
          AppMethodBeat.o(4259);
        }
        catch (RemoteException paramComponentName)
        {
          zza(0, paramComponentName.getMessage());
          AppMethodBeat.o(4259);
        }
        paramComponentName = finally;
      }
      return;
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    try
    {
      AppMethodBeat.i(4261);
      Log.isLoggable("MessengerIpcClient", 2);
      zza(2, "Service disconnected");
      AppMethodBeat.o(4261);
      return;
    }
    finally
    {
      paramComponentName = finally;
      throw paramComponentName;
    }
  }
  
  final void zza(int paramInt, String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(4262);
        if (Log.isLoggable("MessengerIpcClient", 3))
        {
          localObject = String.valueOf(paramString);
          if (((String)localObject).length() != 0) {
            "Disconnected: ".concat((String)localObject);
          }
        }
        else
        {
          switch (this.state)
          {
          case 0: 
            paramInt = this.state;
            paramString = new IllegalStateException(26 + "Unknown state: " + paramInt);
            AppMethodBeat.o(4262);
            throw paramString;
          }
        }
      }
      finally {}
      new String("Disconnected: ");
      continue;
      paramString = new IllegalStateException();
      AppMethodBeat.o(4262);
      throw paramString;
      Log.isLoggable("MessengerIpcClient", 2);
      this.state = 4;
      ConnectionTracker.getInstance().unbindService(this.dDZ.dCI, this);
      paramString = new d(paramInt, paramString);
      Object localObject = this.dDX.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((c)((Iterator)localObject).next()).a(paramString);
      }
      this.dDX.clear();
      paramInt = 0;
      while (paramInt < this.dDY.size())
      {
        ((c)this.dDY.valueAt(paramInt)).a(paramString);
        paramInt += 1;
      }
      this.dDY.clear();
      AppMethodBeat.o(4262);
      for (;;)
      {
        return;
        this.state = 4;
        AppMethodBeat.o(4262);
        continue;
        AppMethodBeat.o(4262);
      }
    }
  }
  
  final void zzu()
  {
    try
    {
      AppMethodBeat.i(4263);
      if ((this.state == 2) && (this.dDX.isEmpty()) && (this.dDY.size() == 0))
      {
        Log.isLoggable("MessengerIpcClient", 2);
        this.state = 3;
        ConnectionTracker.getInstance().unbindService(this.dDZ.dCI, this);
      }
      AppMethodBeat.o(4263);
      return;
    }
    finally {}
  }
  
  final void zzv()
  {
    try
    {
      AppMethodBeat.i(4264);
      if (this.state == 1) {
        zza(1, "Timed out while binding");
      }
      AppMethodBeat.o(4264);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.firebase.iid.aj
 * JD-Core Version:    0.7.0.1
 */