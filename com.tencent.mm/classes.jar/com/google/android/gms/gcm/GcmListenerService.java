package com.google.android.gms.gcm;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.content.WakefulBroadcastReceiver;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

public abstract class GcmListenerService
  extends Service
{
  private int zzbgm;
  private int zzbgn = 0;
  private final Object zzrJ = new Object();
  
  static void zzD(Bundle paramBundle)
  {
    paramBundle = paramBundle.keySet().iterator();
    while (paramBundle.hasNext())
    {
      String str = (String)paramBundle.next();
      if ((str != null) && (str.startsWith("google.c."))) {
        paramBundle.remove();
      }
    }
  }
  
  private void zzGN()
  {
    synchronized (this.zzrJ)
    {
      this.zzbgn -= 1;
      if (this.zzbgn == 0) {
        zzjA(this.zzbgm);
      }
      return;
    }
  }
  
  @TargetApi(11)
  private void zzl(Intent paramIntent)
  {
    int i = Build.VERSION.SDK_INT;
    AsyncTask.THREAD_POOL_EXECUTOR.execute(new GcmListenerService.1(this, paramIntent));
  }
  
  private void zzm(Intent paramIntent)
  {
    for (;;)
    {
      int i;
      try
      {
        str = paramIntent.getAction();
        i = -1;
        switch (str.hashCode())
        {
        case 366519424: 
          str = String.valueOf(paramIntent.getAction());
          if (str.length() == 0) {
            break label90;
          }
          "Unknown intent action: ".concat(str);
          zzGN();
          return;
        }
      }
      finally
      {
        String str;
        WakefulBroadcastReceiver.completeWakefulIntent(paramIntent);
      }
      if (str.equals("com.google.android.c2dm.intent.RECEIVE"))
      {
        i = 0;
        break label103;
        zzn(paramIntent);
        continue;
        label90:
        new String("Unknown intent action: ");
        continue;
      }
      label103:
      switch (i)
      {
      }
    }
  }
  
  private void zzn(Intent paramIntent)
  {
    String str2 = paramIntent.getStringExtra("message_type");
    String str1 = str2;
    if (str2 == null) {
      str1 = "gcm";
    }
    int i = -1;
    switch (str1.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramIntent = String.valueOf(str1);
        if (paramIntent.length() == 0) {
          break label214;
        }
        "Received message with unknown type: ".concat(paramIntent);
        return;
        if (str1.equals("gcm"))
        {
          i = 0;
          continue;
          if (str1.equals("deleted_messages"))
          {
            i = 1;
            continue;
            if (str1.equals("send_event"))
            {
              i = 2;
              continue;
              if (str1.equals("send_error")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    zzo(paramIntent);
    return;
    onDeletedMessages();
    return;
    onMessageSent(paramIntent.getStringExtra("google.message_id"));
    return;
    onSendError(zzp(paramIntent), paramIntent.getStringExtra("error"));
    return;
    label214:
    new String("Received message with unknown type: ");
  }
  
  private void zzo(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    paramIntent.remove("message_type");
    paramIntent.remove("android.support.content.wakelockid");
    if (zza.zzE(paramIntent))
    {
      if (!zza.zzbu(this))
      {
        zza.zzbt(this).zzG(paramIntent);
        return;
      }
      zza.zzF(paramIntent);
    }
    String str = paramIntent.getString("from");
    paramIntent.remove("from");
    zzD(paramIntent);
    onMessageReceived(str, paramIntent);
  }
  
  private String zzp(Intent paramIntent)
  {
    String str2 = paramIntent.getStringExtra("google.message_id");
    String str1 = str2;
    if (str2 == null) {
      str1 = paramIntent.getStringExtra("message_id");
    }
    return str1;
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onDeletedMessages() {}
  
  public void onMessageReceived(String paramString, Bundle paramBundle) {}
  
  public void onMessageSent(String paramString) {}
  
  public void onSendError(String paramString1, String paramString2) {}
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    synchronized (this.zzrJ)
    {
      this.zzbgm = paramInt2;
      this.zzbgn += 1;
      if (paramIntent == null)
      {
        zzGN();
        return 2;
      }
    }
    zzl(paramIntent);
    return 3;
  }
  
  boolean zzjA(int paramInt)
  {
    return stopSelfResult(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.gcm.GcmListenerService
 * JD-Core Version:    0.7.0.1
 */