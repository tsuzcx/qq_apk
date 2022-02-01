package com.google.android.gms.iid;

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

final class zzt
  implements ServiceConnection
{
  int state;
  final Messenger zzcc;
  zzy zzcd;
  final Queue<zzz<?>> zzce;
  final SparseArray<zzz<?>> zzcf;
  
  private zzt(zzr paramzzr)
  {
    AppMethodBeat.i(2557);
    this.state = 0;
    this.zzcc = new Messenger(new Handler(Looper.getMainLooper(), new zzu(this)));
    this.zzce = new ArrayDeque();
    this.zzcf = new SparseArray();
    AppMethodBeat.o(2557);
  }
  
  private final void zzr()
  {
    AppMethodBeat.i(2561);
    zzr.zze(this.zzcg).execute(new zzw(this));
    AppMethodBeat.o(2561);
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(2560);
        Log.isLoggable("MessengerIpcClient", 2);
        if (paramIBinder != null) {
          continue;
        }
        zzd(0, "Null service connection");
        AppMethodBeat.o(2560);
      }
      finally
      {
        try
        {
          this.zzcd = new zzy(paramIBinder);
          this.state = 2;
          zzr();
          AppMethodBeat.o(2560);
        }
        catch (RemoteException paramComponentName)
        {
          zzd(0, paramComponentName.getMessage());
          AppMethodBeat.o(2560);
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
      AppMethodBeat.i(2562);
      Log.isLoggable("MessengerIpcClient", 2);
      zzd(2, "Service disconnected");
      AppMethodBeat.o(2562);
      return;
    }
    finally
    {
      paramComponentName = finally;
      throw paramComponentName;
    }
  }
  
  final void zzd(int paramInt, String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(2563);
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
            AppMethodBeat.o(2563);
            throw paramString;
          }
        }
      }
      finally {}
      new String("Disconnected: ");
      continue;
      paramString = new IllegalStateException();
      AppMethodBeat.o(2563);
      throw paramString;
      Log.isLoggable("MessengerIpcClient", 2);
      this.state = 4;
      ConnectionTracker.getInstance().unbindService(zzr.zzd(this.zzcg), this);
      paramString = new zzaa(paramInt, paramString);
      Object localObject = this.zzce.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((zzz)((Iterator)localObject).next()).zzd(paramString);
      }
      this.zzce.clear();
      paramInt = 0;
      while (paramInt < this.zzcf.size())
      {
        ((zzz)this.zzcf.valueAt(paramInt)).zzd(paramString);
        paramInt += 1;
      }
      this.zzcf.clear();
      AppMethodBeat.o(2563);
      for (;;)
      {
        return;
        this.state = 4;
        AppMethodBeat.o(2563);
        continue;
        AppMethodBeat.o(2563);
      }
    }
  }
  
  final boolean zzd(Message paramMessage)
  {
    AppMethodBeat.i(2559);
    int i = paramMessage.arg1;
    if (Log.isLoggable("MessengerIpcClient", 3)) {
      new StringBuilder(41).append("Received response to request: ").append(i);
    }
    for (;;)
    {
      zzz localzzz;
      try
      {
        localzzz = (zzz)this.zzcf.get(i);
        if (localzzz == null)
        {
          new StringBuilder(50).append("Received response for unknown request: ").append(i);
          return true;
        }
        this.zzcf.remove(i);
        zzs();
        paramMessage = paramMessage.getData();
        if (paramMessage.getBoolean("unsupported", false))
        {
          localzzz.zzd(new zzaa(4, "Not supported by GmsCore"));
          AppMethodBeat.o(2559);
          return true;
        }
      }
      finally
      {
        AppMethodBeat.o(2559);
      }
      localzzz.zzh(paramMessage);
    }
  }
  
  final boolean zze(zzz paramzzz)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(2558);
        switch (this.state)
        {
        case 0: 
          int i = this.state;
          paramzzz = new IllegalStateException(26 + "Unknown state: " + i);
          AppMethodBeat.o(2558);
          throw paramzzz;
        }
      }
      finally {}
      this.zzce.add(paramzzz);
      if (this.state == 0) {
        bool1 = true;
      }
      Preconditions.checkState(bool1);
      Log.isLoggable("MessengerIpcClient", 2);
      this.state = 1;
      paramzzz = new Intent("com.google.android.c2dm.intent.REGISTER");
      paramzzz.setPackage("com.google.android.gms");
      if (!ConnectionTracker.getInstance().bindService(zzr.zzd(this.zzcg), paramzzz, this, 1))
      {
        zzd(0, "Unable to bind to service");
        AppMethodBeat.o(2558);
        bool1 = bool2;
      }
      for (;;)
      {
        return bool1;
        zzr.zze(this.zzcg).schedule(new zzv(this), 30L, TimeUnit.SECONDS);
        break;
        this.zzce.add(paramzzz);
        AppMethodBeat.o(2558);
        bool1 = bool2;
        continue;
        this.zzce.add(paramzzz);
        zzr();
        AppMethodBeat.o(2558);
        bool1 = bool2;
        continue;
        AppMethodBeat.o(2558);
        bool1 = false;
      }
    }
  }
  
  final void zzg(int paramInt)
  {
    try
    {
      AppMethodBeat.i(2566);
      zzz localzzz = (zzz)this.zzcf.get(paramInt);
      if (localzzz != null)
      {
        new StringBuilder(31).append("Timing out request: ").append(paramInt);
        this.zzcf.remove(paramInt);
        localzzz.zzd(new zzaa(3, "Timed out waiting for response"));
        zzs();
      }
      AppMethodBeat.o(2566);
      return;
    }
    finally {}
  }
  
  final void zzs()
  {
    try
    {
      AppMethodBeat.i(2564);
      if ((this.state == 2) && (this.zzce.isEmpty()) && (this.zzcf.size() == 0))
      {
        Log.isLoggable("MessengerIpcClient", 2);
        this.state = 3;
        ConnectionTracker.getInstance().unbindService(zzr.zzd(this.zzcg), this);
      }
      AppMethodBeat.o(2564);
      return;
    }
    finally {}
  }
  
  final void zzt()
  {
    try
    {
      AppMethodBeat.i(2565);
      if (this.state == 1) {
        zzd(1, "Timed out while binding");
      }
      AppMethodBeat.o(2565);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.iid.zzt
 * JD-Core Version:    0.7.0.1
 */