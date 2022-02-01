package com.tencent.matrix.a.a.a;

import android.app.Notification;
import android.app.NotificationChannel;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.matrix.a.a.d;
import com.tencent.matrix.a.b.b;
import com.tencent.matrix.a.b.f;
import com.tencent.matrix.a.b.f.a;

public final class k
  extends a
{
  f.a cWv;
  String cWw;
  long cWx = -1L;
  
  final void N(final String paramString1, final String paramString2)
  {
    final long l = 0L;
    if (this.cWx > 0L) {
      l = SystemClock.uptimeMillis() - this.cWx;
    }
    if (this.cSI.cUb.cTS) {}
    for (final String str = b.stackTraceToString(new Throwable().getStackTrace());; str = "")
    {
      this.cSI.mHandler.post(new Runnable()
      {
        public final void run()
        {
          k.a locala = new k.a();
          locala.title = paramString1;
          locala.content = paramString2;
          locala.stack = str;
          locala.cWC = l;
          k.this.cSI.a(locala);
        }
      });
      return;
    }
  }
  
  public final void VZ()
  {
    super.VZ();
    Object localObject = Resources.getSystem();
    int i;
    if (localObject != null)
    {
      i = ((Resources)localObject).getIdentifier("app_running_notification_text", "string", "android");
      if (i <= 0) {}
    }
    for (localObject = ((Resources)localObject).getString(i);; localObject = null)
    {
      this.cWw = ((String)localObject);
      if (!TextUtils.isEmpty(this.cWw)) {
        break;
      }
      com.tencent.matrix.e.c.w("Matrix.battery.NotificationMonitorFeature", "can not get app_running_notification_text, abort notification monitor", new Object[0]);
      return;
    }
    com.tencent.matrix.e.c.i("Matrix.battery.NotificationMonitorFeature", "get app_running_notification_text: " + this.cWw, new Object[0]);
    this.cWv = new f.a()
    {
      public final void a(int paramAnonymousInt, Notification paramAnonymousNotification)
      {
        String str;
        if (paramAnonymousNotification != null)
        {
          str = paramAnonymousNotification.extras.getString("android.title", null);
          paramAnonymousNotification = paramAnonymousNotification.extras.getString("android.text", null);
          com.tencent.matrix.e.c.i("Matrix.battery.NotificationMonitorFeature", "#onCreateNotification, id = " + paramAnonymousInt + ", title = " + str + ", text = " + paramAnonymousNotification, new Object[0]);
          if (!TextUtils.isEmpty(paramAnonymousNotification)) {
            break label98;
          }
          com.tencent.matrix.e.c.w("Matrix.battery.NotificationMonitorFeature", "notify with empty text!", new Object[0]);
          k.this.N(str, "");
        }
        label98:
        while (!paramAnonymousNotification.equals(k.this.cWw)) {
          return;
        }
        com.tencent.matrix.e.c.w("Matrix.battery.NotificationMonitorFeature", "notify with appRunningText: ".concat(String.valueOf(paramAnonymousNotification)), new Object[0]);
        k.this.N(str, paramAnonymousNotification);
      }
      
      public final void aN(Object paramAnonymousObject)
      {
        if ((Build.VERSION.SDK_INT >= 26) && ((paramAnonymousObject instanceof NotificationChannel))) {
          com.tencent.matrix.e.c.i("Matrix.battery.NotificationMonitorFeature", "#onCreateNotificationChannel, id = " + ((NotificationChannel)paramAnonymousObject).getId() + ", name = " + ((NotificationChannel)paramAnonymousObject).getName(), new Object[0]);
        }
      }
    };
    f.a(this.cWv);
  }
  
  public final void Wa()
  {
    super.Wa();
    f.b(this.cWv);
  }
  
  public final int Wh()
  {
    return -2147483648;
  }
  
  protected final String getTag()
  {
    return "Matrix.battery.NotificationMonitorFeature";
  }
  
  public final void onForeground(boolean paramBoolean)
  {
    super.onForeground(paramBoolean);
    if (paramBoolean) {}
    for (long l = -1L;; l = SystemClock.uptimeMillis())
    {
      this.cWx = l;
      return;
    }
  }
  
  public static final class a
  {
    public long cWC;
    public String content;
    public String stack;
    public String title;
    
    public final String toString()
    {
      return "BadNotification{title='" + this.title + '\'' + ", content='" + this.content + '\'' + ", stack='" + this.stack + '\'' + ", bgMillis=" + this.cWC + '}';
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(k.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.a.a.k
 * JD-Core Version:    0.7.0.1
 */