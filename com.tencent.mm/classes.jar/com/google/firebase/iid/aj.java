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
import javax.annotation.concurrent.GuardedBy;

final class aj
  implements ServiceConnection
{
  @GuardedBy("this")
  final SparseArray<c<?>> bgA;
  final Messenger bgx;
  ao bgy;
  @GuardedBy("this")
  final Queue<c<?>> bgz;
  @GuardedBy("this")
  int state;
  
  private aj(ai paramai)
  {
    AppMethodBeat.i(108820);
    this.state = 0;
    this.bgx = new Messenger(new Handler(Looper.getMainLooper(), new ak(this)));
    this.bgz = new ArrayDeque();
    this.bgA = new SparseArray();
    AppMethodBeat.o(108820);
  }
  
  private final void zzt()
  {
    AppMethodBeat.i(108824);
    this.bgB.bgu.execute(new am(this));
    AppMethodBeat.o(108824);
  }
  
  final boolean b(c paramc)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(108821);
        switch (this.state)
        {
        case 0: 
          int i = this.state;
          paramc = new IllegalStateException(26 + "Unknown state: " + i);
          AppMethodBeat.o(108821);
          throw paramc;
        }
      }
      finally {}
      this.bgz.add(paramc);
      if (this.state == 0) {
        bool1 = true;
      }
      Preconditions.checkState(bool1);
      Log.isLoggable("MessengerIpcClient", 2);
      this.state = 1;
      paramc = new Intent("com.google.android.c2dm.intent.REGISTER");
      paramc.setPackage("com.google.android.gms");
      if (!ConnectionTracker.getInstance().bindService(this.bgB.bfj, paramc, this, 1))
      {
        zza(0, "Unable to bind to service");
        AppMethodBeat.o(108821);
        bool1 = bool2;
      }
      for (;;)
      {
        return bool1;
        this.bgB.bgu.schedule(new al(this), 30L, TimeUnit.SECONDS);
        break;
        this.bgz.add(paramc);
        AppMethodBeat.o(108821);
        bool1 = bool2;
        continue;
        this.bgz.add(paramc);
        zzt();
        AppMethodBeat.o(108821);
        bool1 = bool2;
        continue;
        AppMethodBeat.o(108821);
        bool1 = false;
      }
    }
  }
  
  final void eL(int paramInt)
  {
    try
    {
      AppMethodBeat.i(108829);
      c localc = (c)this.bgA.get(paramInt);
      if (localc != null)
      {
        new StringBuilder(31).append("Timing out request: ").append(paramInt);
        this.bgA.remove(paramInt);
        localc.a(new d(3, "Timed out waiting for response"));
        zzu();
      }
      AppMethodBeat.o(108829);
      return;
    }
    finally {}
  }
  
  final boolean f(Message paramMessage)
  {
    AppMethodBeat.i(108822);
    int i = paramMessage.arg1;
    if (Log.isLoggable("MessengerIpcClient", 3)) {
      new StringBuilder(41).append("Received response to request: ").append(i);
    }
    for (;;)
    {
      c localc;
      try
      {
        localc = (c)this.bgA.get(i);
        if (localc == null)
        {
          new StringBuilder(50).append("Received response for unknown request: ").append(i);
          return true;
        }
        this.bgA.remove(i);
        zzu();
        paramMessage = paramMessage.getData();
        if (paramMessage.getBoolean("unsupported", false))
        {
          localc.a(new d(4, "Not supported by GmsCore"));
          AppMethodBeat.o(108822);
          return true;
        }
      }
      finally
      {
        AppMethodBeat.o(108822);
      }
      localc.zzb(paramMessage);
    }
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(108823);
        Log.isLoggable("MessengerIpcClient", 2);
        if (paramIBinder != null) {
          continue;
        }
        zza(0, "Null service connection");
        AppMethodBeat.o(108823);
      }
      finally
      {
        try
        {
          this.bgy = new ao(paramIBinder);
          this.state = 2;
          zzt();
          AppMethodBeat.o(108823);
        }
        catch (RemoteException paramComponentName)
        {
          zza(0, paramComponentName.getMessage());
          AppMethodBeat.o(108823);
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
      AppMethodBeat.i(108825);
      Log.isLoggable("MessengerIpcClient", 2);
      zza(2, "Service disconnected");
      AppMethodBeat.o(108825);
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
        AppMethodBeat.i(108826);
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
            AppMethodBeat.o(108826);
            throw paramString;
          }
        }
      }
      finally {}
      new String("Disconnected: ");
      continue;
      paramString = new IllegalStateException();
      AppMethodBeat.o(108826);
      throw paramString;
      Log.isLoggable("MessengerIpcClient", 2);
      this.state = 4;
      ConnectionTracker.getInstance().unbindService(this.bgB.bfj, this);
      paramString = new d(paramInt, paramString);
      Object localObject = this.bgz.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((c)((Iterator)localObject).next()).a(paramString);
      }
      this.bgz.clear();
      paramInt = 0;
      while (paramInt < this.bgA.size())
      {
        ((c)this.bgA.valueAt(paramInt)).a(paramString);
        paramInt += 1;
      }
      this.bgA.clear();
      AppMethodBeat.o(108826);
      for (;;)
      {
        return;
        this.state = 4;
        AppMethodBeat.o(108826);
        continue;
        AppMethodBeat.o(108826);
      }
    }
  }
  
  final void zzu()
  {
    try
    {
      AppMethodBeat.i(108827);
      if ((this.state == 2) && (this.bgz.isEmpty()) && (this.bgA.size() == 0))
      {
        Log.isLoggable("MessengerIpcClient", 2);
        this.state = 3;
        ConnectionTracker.getInstance().unbindService(this.bgB.bfj, this);
      }
      AppMethodBeat.o(108827);
      return;
    }
    finally {}
  }
  
  final void zzv()
  {
    try
    {
      AppMethodBeat.i(108828);
      if (this.state == 1) {
        zza(1, "Timed out while binding");
      }
      AppMethodBeat.o(108828);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.firebase.iid.aj
 * JD-Core Version:    0.7.0.1
 */