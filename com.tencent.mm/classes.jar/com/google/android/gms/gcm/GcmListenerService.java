package com.google.android.gms.gcm;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import com.google.android.gms.iid.zze;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Deprecated
public class GcmListenerService
  extends zze
{
  static void zzd(Bundle paramBundle)
  {
    AppMethodBeat.i(3610);
    paramBundle = paramBundle.keySet().iterator();
    while (paramBundle.hasNext())
    {
      String str = (String)paramBundle.next();
      if ((str != null) && (str.startsWith("google.c."))) {
        paramBundle.remove();
      }
    }
    AppMethodBeat.o(3610);
  }
  
  public void handleIntent(Intent paramIntent)
  {
    AppMethodBeat.i(3609);
    if (!"com.google.android.c2dm.intent.RECEIVE".equals(paramIntent.getAction()))
    {
      paramIntent = String.valueOf(paramIntent.getAction());
      if (paramIntent.length() != 0)
      {
        "Unknown intent action: ".concat(paramIntent);
        AppMethodBeat.o(3609);
        return;
      }
      new String("Unknown intent action: ");
      AppMethodBeat.o(3609);
      return;
    }
    Object localObject2 = paramIntent.getStringExtra("message_type");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "gcm";
    }
    int i = -1;
    switch (((String)localObject1).hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramIntent = String.valueOf(localObject1);
        if (paramIntent.length() == 0) {
          break label672;
        }
        "Received message with unknown type: ".concat(paramIntent);
        AppMethodBeat.o(3609);
        return;
        if (((String)localObject1).equals("gcm"))
        {
          i = 0;
          continue;
          if (((String)localObject1).equals("deleted_messages"))
          {
            i = 1;
            continue;
            if (((String)localObject1).equals("send_event"))
            {
              i = 2;
              continue;
              if (((String)localObject1).equals("send_error")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    localObject2 = paramIntent.getExtras();
    ((Bundle)localObject2).remove("message_type");
    ((Bundle)localObject2).remove("android.support.content.wakelockid");
    if (("1".equals(zzd.zzd((Bundle)localObject2, "gcm.n.e"))) || (zzd.zzd((Bundle)localObject2, "gcm.n.icon") != null))
    {
      i = 1;
      if (i == 0) {
        break label569;
      }
      if (((KeyguardManager)getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
        break label409;
      }
      i = Process.myPid();
      paramIntent = ((ActivityManager)getSystemService("activity")).getRunningAppProcesses();
      if (paramIntent == null) {
        break label409;
      }
      paramIntent = paramIntent.iterator();
      for (;;)
      {
        if (paramIntent.hasNext())
        {
          localObject1 = (ActivityManager.RunningAppProcessInfo)paramIntent.next();
          if (((ActivityManager.RunningAppProcessInfo)localObject1).pid == i) {
            if (((ActivityManager.RunningAppProcessInfo)localObject1).importance == 100) {
              i = 1;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i != 0) {
        break label414;
      }
      zzd.zzd(this).zze((Bundle)localObject2);
      AppMethodBeat.o(3609);
      return;
      i = 0;
      break;
      i = 0;
      continue;
      label409:
      i = 0;
    }
    label414:
    Bundle localBundle = new Bundle();
    Iterator localIterator = ((Bundle)localObject2).keySet().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (String)localIterator.next();
      String str = ((Bundle)localObject2).getString((String)localObject1);
      paramIntent = (Intent)localObject1;
      if (((String)localObject1).startsWith("gcm.notification.")) {
        paramIntent = ((String)localObject1).replace("gcm.notification.", "gcm.n.");
      }
      if (paramIntent.startsWith("gcm.n."))
      {
        if (!"gcm.n.e".equals(paramIntent)) {
          localBundle.putString(paramIntent.substring(6), str);
        }
        localIterator.remove();
      }
    }
    paramIntent = localBundle.getString("sound2");
    if (paramIntent != null)
    {
      localBundle.remove("sound2");
      localBundle.putString("sound", paramIntent);
    }
    if (!localBundle.isEmpty()) {
      ((Bundle)localObject2).putBundle("notification", localBundle);
    }
    label569:
    paramIntent = ((Bundle)localObject2).getString("from");
    ((Bundle)localObject2).remove("from");
    zzd((Bundle)localObject2);
    onMessageReceived(paramIntent, (Bundle)localObject2);
    AppMethodBeat.o(3609);
    return;
    onDeletedMessages();
    AppMethodBeat.o(3609);
    return;
    onMessageSent(paramIntent.getStringExtra("google.message_id"));
    AppMethodBeat.o(3609);
    return;
    localObject2 = paramIntent.getStringExtra("google.message_id");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramIntent.getStringExtra("message_id");
    }
    onSendError((String)localObject1, paramIntent.getStringExtra("error"));
    AppMethodBeat.o(3609);
    return;
    label672:
    new String("Received message with unknown type: ");
    AppMethodBeat.o(3609);
  }
  
  public void onDeletedMessages() {}
  
  public void onMessageReceived(String paramString, Bundle paramBundle) {}
  
  public void onMessageSent(String paramString) {}
  
  public void onSendError(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.gcm.GcmListenerService
 * JD-Core Version:    0.7.0.1
 */