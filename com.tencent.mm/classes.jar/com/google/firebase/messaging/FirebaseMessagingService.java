package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.ai;
import com.google.firebase.iid.b;
import com.google.firebase.iid.o;
import com.google.firebase.iid.zzb;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FirebaseMessagingService
  extends zzb
{
  private static final Queue<String> dEf;
  
  static
  {
    AppMethodBeat.i(116785);
    dEf = new ArrayDeque(10);
    AppMethodBeat.o(116785);
  }
  
  static void r(Bundle paramBundle)
  {
    AppMethodBeat.i(116783);
    paramBundle = paramBundle.keySet().iterator();
    while (paramBundle.hasNext())
    {
      String str = (String)paramBundle.next();
      if ((str != null) && (str.startsWith("google.c."))) {
        paramBundle.remove();
      }
    }
    AppMethodBeat.o(116783);
  }
  
  static boolean s(Bundle paramBundle)
  {
    AppMethodBeat.i(116784);
    if (paramBundle == null)
    {
      AppMethodBeat.o(116784);
      return false;
    }
    boolean bool = "1".equals(paramBundle.getString("google.c.a.e"));
    AppMethodBeat.o(116784);
    return bool;
  }
  
  public void a(RemoteMessage paramRemoteMessage) {}
  
  public void a(String paramString, Exception paramException) {}
  
  public final Intent f(Intent paramIntent)
  {
    AppMethodBeat.i(116780);
    paramIntent = (Intent)o.Yw().dDc.poll();
    AppMethodBeat.o(116780);
    return paramIntent;
  }
  
  public final void g(Intent paramIntent)
  {
    int k = -1;
    int j = 0;
    AppMethodBeat.i(116782);
    Object localObject2 = paramIntent.getAction();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    label60:
    int i;
    switch (((String)localObject1).hashCode())
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramIntent = String.valueOf(paramIntent.getAction());
        if (paramIntent.length() == 0) {
          break label806;
        }
        "Unknown intent action: ".concat(paramIntent);
        AppMethodBeat.o(116782);
        return;
        if (!((String)localObject1).equals("com.google.android.c2dm.intent.RECEIVE")) {
          break label60;
        }
        i = 0;
        continue;
        if (!((String)localObject1).equals("com.google.firebase.messaging.NOTIFICATION_DISMISS")) {
          break label60;
        }
        i = 1;
      }
    }
    localObject2 = paramIntent.getStringExtra("google.message_id");
    label174:
    Object localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = Tasks.forResult(null);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label368;
      }
      i = 0;
      if (i == 0)
      {
        localObject3 = paramIntent.getStringExtra("message_type");
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "gcm";
        }
        switch (((String)localObject2).hashCode())
        {
        default: 
          i = k;
          switch (i)
          {
          default: 
            label251:
            paramIntent = String.valueOf(localObject2);
            if (paramIntent.length() != 0) {
              "Received message with unknown type: ".concat(paramIntent);
            }
            break;
          }
          break;
        }
      }
    }
    for (;;)
    {
      try
      {
        Tasks.await((Task)localObject1, 1L, TimeUnit.SECONDS);
        AppMethodBeat.o(116782);
        return;
      }
      catch (InterruptedException paramIntent)
      {
        paramIntent = String.valueOf(paramIntent);
        new StringBuilder(String.valueOf(paramIntent).length() + 20).append("Message ack failed: ").append(paramIntent);
        AppMethodBeat.o(116782);
        return;
        if (!s(paramIntent.getExtras())) {
          continue;
        }
        e.a("_nd", paramIntent);
        AppMethodBeat.o(116782);
        return;
        new String("Unknown intent action: ");
        AppMethodBeat.o(116782);
        return;
      }
      catch (ExecutionException paramIntent)
      {
        continue;
      }
      catch (TimeoutException paramIntent)
      {
        label368:
        continue;
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("google.message_id", (String)localObject2);
      localObject3 = ai.aZ(this);
      localObject1 = ((ai)localObject3).a(new b(((ai)localObject3).YB(), (Bundle)localObject1));
      break;
      if (dEf.contains(localObject2))
      {
        if (Log.isLoggable("FirebaseMessaging", 3))
        {
          localObject2 = String.valueOf(localObject2);
          if (((String)localObject2).length() != 0) {
            "Received duplicate message: ".concat((String)localObject2);
          }
        }
        else
        {
          i = 1;
          break label174;
        }
        new String("Received duplicate message: ");
        continue;
      }
      if (dEf.size() >= 10) {
        dEf.remove();
      }
      dEf.add(localObject2);
      i = 0;
      break label174;
      i = k;
      if (!((String)localObject2).equals("gcm")) {
        break label251;
      }
      i = 0;
      break label251;
      i = k;
      if (!((String)localObject2).equals("deleted_messages")) {
        break label251;
      }
      i = 1;
      break label251;
      i = k;
      if (!((String)localObject2).equals("send_event")) {
        break label251;
      }
      i = 2;
      break label251;
      i = k;
      if (!((String)localObject2).equals("send_error")) {
        break label251;
      }
      i = 3;
      break label251;
      if (s(paramIntent.getExtras())) {
        e.a("_nr", paramIntent);
      }
      localObject3 = paramIntent.getExtras();
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = new Bundle();
      }
      ((Bundle)localObject2).remove("androidx.contentpager.content.wakelockid");
      if (!"1".equals(d.c((Bundle)localObject2, "gcm.n.e")))
      {
        i = j;
        if (d.c((Bundle)localObject2, "gcm.n.icon") == null) {}
      }
      else
      {
        i = 1;
      }
      if (i != 0)
      {
        if (d.ba(this).t((Bundle)localObject2)) {
          continue;
        }
        if (s((Bundle)localObject2)) {
          e.a("_nf", paramIntent);
        }
      }
      a(new RemoteMessage((Bundle)localObject2));
      continue;
      onDeletedMessages();
      continue;
      paramIntent.getStringExtra("google.message_id");
      continue;
      localObject3 = paramIntent.getStringExtra("google.message_id");
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = paramIntent.getStringExtra("message_id");
      }
      a((String)localObject2, new c(paramIntent.getStringExtra("error")));
      continue;
      new String("Received message with unknown type: ");
    }
  }
  
  public final boolean i(Intent paramIntent)
  {
    AppMethodBeat.i(116781);
    Object localObject;
    if ("com.google.firebase.messaging.NOTIFICATION_OPEN".equals(paramIntent.getAction()))
    {
      localObject = (PendingIntent)paramIntent.getParcelableExtra("pending_intent");
      if (localObject == null) {}
    }
    try
    {
      ((PendingIntent)localObject).send();
      label38:
      if (s(paramIntent.getExtras())) {
        if (paramIntent != null)
        {
          if (!"1".equals(paramIntent.getStringExtra("google.c.a.tc"))) {
            break label181;
          }
          localObject = (com.google.firebase.analytics.connector.a)com.google.firebase.a.XX().v(com.google.firebase.analytics.connector.a.class);
          Log.isLoggable("FirebaseMessaging", 3);
          if (localObject != null)
          {
            String str = paramIntent.getStringExtra("google.c.a.c_id");
            ((com.google.firebase.analytics.connector.a)localObject).setUserProperty("fcm", "_ln", str);
            Bundle localBundle = new Bundle();
            localBundle.putString("source", "Firebase");
            localBundle.putString("medium", "notification");
            localBundle.putString("campaign", str);
            ((com.google.firebase.analytics.connector.a)localObject).logEvent("fcm", "_cmp", localBundle);
          }
        }
      }
      for (;;)
      {
        e.a("_no", paramIntent);
        AppMethodBeat.o(116781);
        return true;
        label181:
        Log.isLoggable("FirebaseMessaging", 3);
      }
      AppMethodBeat.o(116781);
      return false;
    }
    catch (PendingIntent.CanceledException localCanceledException)
    {
      break label38;
    }
  }
  
  public void onDeletedMessages() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.firebase.messaging.FirebaseMessagingService
 * JD-Core Version:    0.7.0.1
 */