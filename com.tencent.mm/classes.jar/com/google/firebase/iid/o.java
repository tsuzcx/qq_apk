package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import androidx.b.g;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Queue;

public final class o
{
  private static o dCY;
  private final g<String, String> dCZ;
  private Boolean dDa;
  final Queue<Intent> dDb;
  public final Queue<Intent> dDc;
  
  private o()
  {
    AppMethodBeat.i(4181);
    this.dCZ = new g();
    this.dDa = null;
    this.dDb = new ArrayDeque();
    this.dDc = new ArrayDeque();
    AppMethodBeat.o(4181);
  }
  
  public static o Yw()
  {
    try
    {
      AppMethodBeat.i(4180);
      if (dCY == null) {
        dCY = new o();
      }
      o localo = dCY;
      AppMethodBeat.o(4180);
      return localo;
    }
    finally {}
  }
  
  public static PendingIntent a(Context paramContext, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(4182);
    Intent localIntent = new Intent(paramContext, FirebaseInstanceIdReceiver.class);
    localIntent.setAction("com.google.firebase.MESSAGING_EVENT");
    localIntent.putExtra("wrapped_intent", paramIntent);
    paramContext = PendingIntent.getBroadcast(paramContext, paramInt, localIntent, 1073741824);
    AppMethodBeat.o(4182);
    return paramContext;
  }
  
  private final int b(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(4184);
    synchronized (this.dCZ)
    {
      ??? = (String)this.dCZ.get(paramIntent.getAction());
      ??? = ???;
      if (??? == null)
      {
        ??? = paramContext.getPackageManager().resolveService(paramIntent, 0);
        if (??? != null) {
          if (((ResolveInfo)???).serviceInfo != null) {
            break label135;
          }
        }
      }
    }
    try
    {
      boolean bool;
      if (this.dDa == null)
      {
        if (paramContext.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0)
        {
          bool = true;
          label85:
          this.dDa = Boolean.valueOf(bool);
        }
      }
      else {
        if (!this.dDa.booleanValue()) {
          break label400;
        }
      }
      label135:
      label400:
      for (paramContext = WakefulBroadcastReceiver.startWakefulService(paramContext, paramIntent);; paramContext = paramContext.startService(paramIntent))
      {
        for (;;)
        {
          if (paramContext != null) {
            break label409;
          }
          AppMethodBeat.o(4184);
          return 404;
          paramContext = finally;
          AppMethodBeat.o(4184);
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
              break label356;
            }
            ??? = ((String)???).concat((String)???);
          }
          synchronized (this.dCZ)
          {
            this.dCZ.put(paramIntent.getAction(), ???);
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
              label356:
              ??? = new String((String)???);
            }
          }
        }
        bool = false;
        break label85;
      }
      label409:
      AppMethodBeat.o(4184);
      return -1;
    }
    catch (SecurityException paramContext)
    {
      AppMethodBeat.o(4184);
      return 401;
    }
    catch (IllegalStateException paramContext)
    {
      paramContext = String.valueOf(paramContext);
      new StringBuilder(String.valueOf(paramContext).length() + 45).append("Failed to start service while in background: ").append(paramContext);
      AppMethodBeat.o(4184);
    }
    return 402;
  }
  
  public final int a(Context paramContext, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(4183);
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
      AppMethodBeat.o(4183);
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
      this.dDb.offer(paramIntent);
      for (;;)
      {
        paramString = new Intent(paramString);
        paramString.setPackage(paramContext.getPackageName());
        i = b(paramContext, paramString);
        AppMethodBeat.o(4183);
        return i;
        this.dDc.offer(paramIntent);
      }
      new String("Unknown service action: ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.firebase.iid.o
 * JD-Core Version:    0.7.0.1
 */