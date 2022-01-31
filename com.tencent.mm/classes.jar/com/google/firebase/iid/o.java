package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.support.v4.e.m;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

public final class o
{
  private static o bfA;
  @GuardedBy("serviceClassNames")
  private final m<String, String> bfB;
  private Boolean bfC;
  final Queue<Intent> bfD;
  public final Queue<Intent> bfE;
  
  private o()
  {
    AppMethodBeat.i(108745);
    this.bfB = new m();
    this.bfC = null;
    this.bfD = new ArrayDeque();
    this.bfE = new ArrayDeque();
    AppMethodBeat.o(108745);
  }
  
  public static PendingIntent a(Context paramContext, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(108746);
    Intent localIntent = new Intent(paramContext, FirebaseInstanceIdReceiver.class);
    localIntent.setAction("com.google.firebase.MESSAGING_EVENT");
    localIntent.putExtra("wrapped_intent", paramIntent);
    paramContext = PendingIntent.getBroadcast(paramContext, paramInt, localIntent, 1073741824);
    AppMethodBeat.o(108746);
    return paramContext;
  }
  
  private final int c(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(108748);
    synchronized (this.bfB)
    {
      ??? = (String)this.bfB.get(paramIntent.getAction());
      ??? = ???;
      if (??? == null)
      {
        ??? = paramContext.getPackageManager().resolveService(paramIntent, 0);
        if (??? != null) {
          if (((ResolveInfo)???).serviceInfo != null) {
            break label132;
          }
        }
      }
    }
    try
    {
      boolean bool;
      if (this.bfC == null)
      {
        if (paramContext.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0)
        {
          bool = true;
          label84:
          this.bfC = Boolean.valueOf(bool);
        }
      }
      else {
        if (!this.bfC.booleanValue()) {
          break label396;
        }
      }
      label132:
      label396:
      for (paramContext = WakefulBroadcastReceiver.startWakefulService(paramContext, paramIntent);; paramContext = paramContext.startService(paramIntent))
      {
        if (paramContext != null) {
          break label405;
        }
        AppMethodBeat.o(108748);
        return 404;
        paramContext = finally;
        AppMethodBeat.o(108748);
        throw paramContext;
        ??? = ((ResolveInfo)???).serviceInfo;
        if ((!paramContext.getPackageName().equals(((ServiceInfo)???).packageName)) || (((ServiceInfo)???).name == null))
        {
          ??? = ((ServiceInfo)???).packageName;
          ??? = ((ServiceInfo)???).name;
          new StringBuilder(String.valueOf(???).length() + 94 + String.valueOf(???).length()).append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ").append((String)???).append("/").append((String)???);
          break;
        }
        ??? = ((ServiceInfo)???).name;
        ??? = ???;
        if (((String)???).startsWith("."))
        {
          ??? = String.valueOf(paramContext.getPackageName());
          ??? = String.valueOf(???);
          if (((String)???).length() == 0) {
            break label353;
          }
          ??? = ((String)???).concat((String)???);
        }
        for (;;)
        {
          synchronized (this.bfB)
          {
            this.bfB.put(paramIntent.getAction(), ???);
            if (Log.isLoggable("FirebaseInstanceId", 3))
            {
              ??? = String.valueOf(???);
              if (((String)???).length() != 0) {
                "Restricting intent to a specific service: ".concat((String)???);
              }
            }
            else
            {
              paramIntent.setClassName(paramContext.getPackageName(), (String)???);
              break;
              label353:
              ??? = new String((String)???);
            }
          }
          new String("Restricting intent to a specific service: ");
        }
        bool = false;
        break label84;
      }
      label405:
      AppMethodBeat.o(108748);
      return -1;
    }
    catch (SecurityException paramContext)
    {
      AppMethodBeat.o(108748);
      return 401;
    }
    catch (IllegalStateException paramContext)
    {
      paramContext = String.valueOf(paramContext);
      new StringBuilder(String.valueOf(paramContext).length() + 45).append("Failed to start service while in background: ").append(paramContext);
      AppMethodBeat.o(108748);
    }
    return 402;
  }
  
  public static o sa()
  {
    try
    {
      AppMethodBeat.i(108744);
      if (bfA == null) {
        bfA = new o();
      }
      o localo = bfA;
      AppMethodBeat.o(108744);
      return localo;
    }
    finally {}
  }
  
  public final int a(Context paramContext, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(108747);
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        paramContext = String.valueOf(paramString);
        if (paramContext.length() != 0) {
          "Unknown service action: ".concat(paramContext);
        }
        break;
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(108747);
      return 500;
      if (!paramString.equals("com.google.firebase.INSTANCE_ID_EVENT")) {
        break;
      }
      i = 0;
      break;
      if (!paramString.equals("com.google.firebase.MESSAGING_EVENT")) {
        break;
      }
      i = 1;
      break;
      this.bfD.offer(paramIntent);
      for (;;)
      {
        paramString = new Intent(paramString);
        paramString.setPackage(paramContext.getPackageName());
        i = c(paramContext, paramString);
        AppMethodBeat.o(108747);
        return i;
        this.bfE.offer(paramIntent);
      }
      new String("Unknown service action: ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.firebase.iid.o
 * JD-Core Version:    0.7.0.1
 */