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
import com.tencent.matrix.a.b.h;
import com.tencent.matrix.a.b.h.a;

public final class n
  extends a
{
  h.a eSC;
  String eSD;
  long eSE = -1L;
  
  final void Q(final String paramString1, final String paramString2)
  {
    final long l = 0L;
    if (this.eSE > 0L) {
      l = SystemClock.uptimeMillis() - this.eSE;
    }
    if (this.eNY.ePD.ePu) {}
    for (final String str = b.stackTraceToString(new Throwable().getStackTrace());; str = "")
    {
      this.eNY.mHandler.post(new Runnable()
      {
        public final void run()
        {
          n.a locala = new n.a();
          locala.title = paramString1;
          locala.content = paramString2;
          locala.stack = str;
          locala.eSJ = l;
          n.this.eNY.a(locala);
        }
      });
      return;
    }
  }
  
  public final void awI()
  {
    super.awI();
    Object localObject = Resources.getSystem();
    int i;
    if (localObject != null)
    {
      i = ((Resources)localObject).getIdentifier("app_running_notification_text", "string", "android");
      if (i <= 0) {}
    }
    for (localObject = ((Resources)localObject).getString(i);; localObject = null)
    {
      this.eSD = ((String)localObject);
      if (!TextUtils.isEmpty(this.eSD)) {
        break;
      }
      com.tencent.matrix.e.c.w("Matrix.battery.NotificationMonitorFeature", "can not get app_running_notification_text, abort notification monitor", new Object[0]);
      return;
    }
    com.tencent.matrix.e.c.i("Matrix.battery.NotificationMonitorFeature", "get app_running_notification_text: " + this.eSD, new Object[0]);
    this.eSC = new h.a()
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
          n.this.Q(str, "");
        }
        label98:
        while (!paramAnonymousNotification.equals(n.this.eSD)) {
          return;
        }
        com.tencent.matrix.e.c.w("Matrix.battery.NotificationMonitorFeature", "notify with appRunningText: ".concat(String.valueOf(paramAnonymousNotification)), new Object[0]);
        n.this.Q(str, paramAnonymousNotification);
      }
      
      public final void cj(Object paramAnonymousObject)
      {
        if ((Build.VERSION.SDK_INT >= 26) && ((paramAnonymousObject instanceof NotificationChannel))) {
          com.tencent.matrix.e.c.i("Matrix.battery.NotificationMonitorFeature", "#onCreateNotificationChannel, id = " + ((NotificationChannel)paramAnonymousObject).getId() + ", name = " + ((NotificationChannel)paramAnonymousObject).getName(), new Object[0]);
        }
      }
    };
    h.a(this.eSC);
  }
  
  public final void awJ()
  {
    super.awJ();
    h.b(this.eSC);
  }
  
  public final int awQ()
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
      this.eSE = l;
      return;
    }
  }
  
  public static final class a
  {
    public String content;
    public long eSJ;
    public String stack;
    public String title;
    
    public final String toString()
    {
      return "BadNotification{title='" + this.title + '\'' + ", content='" + this.content + '\'' + ", stack='" + this.stack + '\'' + ", bgMillis=" + this.eSJ + '}';
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(n.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.a.a.a.n
 * JD-Core Version:    0.7.0.1
 */