package com.tencent.mm.booter.notification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.aa;
import android.support.v4.app.aa.b;
import android.support.v4.app.x;
import com.tencent.mm.R.g;
import com.tencent.mm.booter.notification.a.e;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.booter.notification.queue.NotificationQueue;
import com.tencent.mm.booter.notification.queue.a;
import com.tencent.mm.booter.notification.queue.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;

public class NotificationItem
  implements Parcelable
{
  public static final Parcelable.Creator<NotificationItem> CREATOR = new Parcelable.Creator() {};
  private final String TAG = "MicroMsg.NotificationItem";
  private Bitmap b;
  PendingIntent djC;
  public String djD;
  public long djE = 0L;
  public int djF = 0;
  public boolean djG = true;
  public int djH = 0;
  public int djI = 0;
  public int id = -1;
  Notification yb;
  
  public NotificationItem(int paramInt, Notification paramNotification, boolean paramBoolean)
  {
    this(paramInt, null, paramNotification, paramBoolean);
  }
  
  public NotificationItem(int paramInt, String paramString, Notification paramNotification)
  {
    this(paramInt, paramString, paramNotification, true);
  }
  
  @TargetApi(11)
  private NotificationItem(int paramInt, String paramString, Notification paramNotification, boolean paramBoolean)
  {
    this.id = paramInt;
    this.djD = paramString;
    if (Build.VERSION.SDK_INT >= 11) {
      this.b = paramNotification.largeIcon;
    }
    this.yb = paramNotification;
    this.djG = paramBoolean;
    this.djH = 0;
  }
  
  public NotificationItem(Notification paramNotification, boolean paramBoolean)
  {
    this(-1, paramNotification, paramBoolean);
  }
  
  private NotificationItem(Parcel paramParcel)
  {
    if (paramParcel == null) {
      return;
    }
    this.id = paramParcel.readInt();
    this.djD = paramParcel.readString();
    this.b = ((Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader()));
    this.yb = ((Notification)paramParcel.readParcelable(Notification.class.getClassLoader()));
    this.djC = ((PendingIntent)paramParcel.readParcelable(PendingIntent.class.getClassLoader()));
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.djG = bool;
      this.djE = paramParcel.readLong();
      this.djF = paramParcel.readInt();
      return;
    }
  }
  
  public final int a(g paramg)
  {
    Object localObject2 = null;
    Bundle localBundle = null;
    for (;;)
    {
      int i;
      Object localObject3;
      try
      {
        Context localContext;
        if (this.id == -1)
        {
          i = b.wz().l(this.djD, this.djG);
          this.id = i;
          localContext = ae.getContext();
          if (localContext == null)
          {
            y.e("MicroMsg.NotificationItem", "error, show notification but MMApplicationContext.getContext() == null");
            i = -1;
            return i;
          }
        }
        else
        {
          i = this.id;
          continue;
        }
        if (this.yb == null)
        {
          y.e("MicroMsg.NotificationItem", "error, show notification but mNotification == null");
          i = -1;
          continue;
        }
        localObject1 = b.wz();
        localObject3 = this.djD;
        if (bk.bl((String)localObject3))
        {
          localObject1 = null;
          if (localObject1 != null)
          {
            localObject3 = b.wz();
            i = ((NotificationItem)localObject1).id;
            y.d("MicroMsg.Notification.Queue", "mark: %d", new Object[] { Integer.valueOf(i) });
            ((b)localObject3).mark = i;
          }
          if ((localObject1 != null) && (((NotificationItem)localObject1).yb.tickerText != null) && (this.yb.tickerText != null) && (((NotificationItem)localObject1).yb.tickerText.equals(this.yb.tickerText))) {
            this.yb.tickerText += " ";
          }
          localObject3 = b.wz();
          if (this == null)
          {
            y.e("MicroMsg.Notification.Queue", "notification item null when put");
            localObject1 = localBundle;
            if (localObject1 != null) {
              b.wz().cancel(((NotificationItem)localObject1).id);
            }
            this.djI = d.a(this.yb, paramg);
            if (localContext != null)
            {
              if (this.yb != null) {
                break label529;
              }
              y.e("MicroMsg.NotificationItem", "error, notify but mNotification == null");
            }
            i = this.id;
          }
        }
        else
        {
          Iterator localIterator = ((b)localObject1).iterator();
          if (!localIterator.hasNext()) {
            break label827;
          }
          localObject1 = (NotificationItem)localIterator.next();
          if ((localObject1 == null) || (((NotificationItem)localObject1).djD == null) || (!((NotificationItem)localObject1).djD.equals(localObject3))) {
            continue;
          }
          continue;
        }
        if (this.id == -1)
        {
          y.e("MicroMsg.Notification.Queue", "notification id = -1(NotificationItem.INVALID_ID) when put");
          localObject1 = localBundle;
          continue;
        }
        if (((b)localObject3).mark <= 0) {
          break label445;
        }
      }
      finally {}
      if (((b)localObject3).mark == this.id)
      {
        y.d("MicroMsg.Notification.Queue", "remove mark: %d", new Object[] { Integer.valueOf(((b)localObject3).mark) });
        ((b)localObject3).remove(((b)localObject3).mark);
      }
      ((b)localObject3).mark = -1;
      label445:
      ((b)localObject3).remove(this.id);
      Object localObject1 = localObject2;
      if (((b)localObject3).size() >= 5) {
        localObject1 = ((b)localObject3).wA();
      }
      ((b)localObject3).djP.d(this);
      ((b)localObject3).djQ.b(this);
      y.i("MicroMsg.Notification.Queue", "put item: %d, queuesize: %d", new Object[] { Integer.valueOf(this.id), Integer.valueOf(((b)localObject3).size()) });
      continue;
      label529:
      paramg = ae.getContext();
      if (paramg == null)
      {
        y.e("MicroMsg.NotificationItem", "error, safeCheck but MMApplicationContext.getContext() == null");
        label545:
        y.i("MicroMsg.NotificationItem", "notificaiton.defaults: %d, notification.sound: %s, notification.vibrate: %s", new Object[] { Integer.valueOf(this.yb.defaults), this.yb.sound, g.c(this.yb.vibrate) });
      }
      for (;;)
      {
        try
        {
          if ((e.wI() == 1) && (this.yb.defaults != 2) && (this.yb.vibrate == null))
          {
            this.yb.defaults = 0;
            this.yb.sound = null;
            y.i("MicroMsg.NotificationItem", "mode == vibrate & wechat shake is close, so notification switch to silent");
          }
          paramg = aa.L(ae.getContext());
          j = this.id;
          localObject1 = this.yb;
          localBundle = x.a((Notification)localObject1);
          if ((localBundle == null) || (!localBundle.getBoolean("android.support.useSideChannel"))) {
            continue;
          }
          i = 1;
          if (i == 0) {
            continue;
          }
          paramg.a(new aa.b(paramg.mContext.getPackageName(), j, (Notification)localObject1));
          paramg.yz.cancel(null, j);
        }
        catch (Exception paramg)
        {
          int j;
          y.printErrStackTrace("MicroMsg.NotificationItem", paramg, "Notification Exception?", new Object[0]);
          continue;
        }
        if (this.djE == 0L) {
          break;
        }
        c.bo(this.djE);
        break;
        if (this.yb == null)
        {
          y.e("MicroMsg.NotificationItem", "error, safeCheck but mNotification == null");
          break label545;
        }
        i = this.yb.icon;
        if (paramg.getResources().getDrawable(i) != null) {
          break label545;
        }
        this.yb.icon = R.g.icon;
        break label545;
        i = 0;
        continue;
        paramg.yz.notify(null, j, (Notification)localObject1);
      }
      label827:
      localObject1 = null;
    }
  }
  
  public final void clear()
  {
    try
    {
      if ((this.b != null) && (!this.b.isRecycled()))
      {
        y.i("MicroMsg.NotificationItem", "recycle bitmap:%s", new Object[] { this.b.toString() });
        this.b.recycle();
      }
      this.yb = null;
      this.b = null;
      this.djC = null;
      return;
    }
    finally {}
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "id: " + this.id + ",msgId: " + this.djE + ",userName: " + this.djD + ",unreadCount: " + this.djF;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.id);
    String str;
    if (this.djD == null)
    {
      str = "";
      paramParcel.writeString(str);
      paramParcel.writeParcelable(this.b, 0);
      paramParcel.writeParcelable(this.yb, 0);
      paramParcel.writeParcelable(this.djC, 0);
      if (!this.djG) {
        break label91;
      }
    }
    label91:
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.djE);
      paramParcel.writeInt(this.djF);
      return;
      str = this.djD;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.notification.NotificationItem
 * JD-Core Version:    0.7.0.1
 */