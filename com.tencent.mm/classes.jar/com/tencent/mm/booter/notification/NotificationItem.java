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
import android.support.v4.app.s;
import android.support.v4.app.v;
import android.support.v4.app.v.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.a.e;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.booter.notification.queue.NotificationQueue;
import com.tencent.mm.booter.notification.queue.a;
import com.tencent.mm.booter.notification.queue.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;

public class NotificationItem
  implements Parcelable
{
  public static final Parcelable.Creator<NotificationItem> CREATOR;
  private final String TAG;
  private Bitmap b;
  private PendingIntent eaW;
  public String eaX;
  public long eaY;
  public int eaZ;
  public boolean eba;
  public int ebb;
  public int ebc;
  public int id;
  Notification yC;
  
  static
  {
    AppMethodBeat.i(15963);
    CREATOR = new NotificationItem.1();
    AppMethodBeat.o(15963);
  }
  
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
    AppMethodBeat.i(15957);
    this.TAG = "MicroMsg.NotificationItem";
    this.id = -1;
    this.eaY = 0L;
    this.eaZ = 0;
    this.eba = true;
    this.ebb = 0;
    this.ebc = 0;
    this.id = paramInt;
    this.eaX = paramString;
    if (Build.VERSION.SDK_INT >= 11) {
      this.b = paramNotification.largeIcon;
    }
    this.yC = paramNotification;
    this.eba = paramBoolean;
    this.ebb = 0;
    AppMethodBeat.o(15957);
  }
  
  public NotificationItem(Notification paramNotification, boolean paramBoolean)
  {
    this(-1, paramNotification, paramBoolean);
  }
  
  private NotificationItem(Parcel paramParcel)
  {
    AppMethodBeat.i(15960);
    this.TAG = "MicroMsg.NotificationItem";
    this.id = -1;
    this.eaY = 0L;
    this.eaZ = 0;
    this.eba = true;
    this.ebb = 0;
    this.ebc = 0;
    if (paramParcel == null)
    {
      AppMethodBeat.o(15960);
      return;
    }
    this.id = paramParcel.readInt();
    this.eaX = paramParcel.readString();
    this.b = ((Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader()));
    this.yC = ((Notification)paramParcel.readParcelable(Notification.class.getClassLoader()));
    this.eaW = ((PendingIntent)paramParcel.readParcelable(PendingIntent.class.getClassLoader()));
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.eba = bool;
      this.eaY = paramParcel.readLong();
      this.eaZ = paramParcel.readInt();
      AppMethodBeat.o(15960);
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
        AppMethodBeat.i(15959);
        Context localContext;
        if (this.id == -1)
        {
          i = b.IO().o(this.eaX, this.eba);
          this.id = i;
          localContext = ah.getContext();
          if (localContext == null)
          {
            ab.e("MicroMsg.NotificationItem", "error, show notification but MMApplicationContext.getContext() == null");
            AppMethodBeat.o(15959);
            i = -1;
            return i;
          }
        }
        else
        {
          i = this.id;
          continue;
        }
        if (this.yC == null)
        {
          ab.e("MicroMsg.NotificationItem", "error, show notification but mNotification == null");
          AppMethodBeat.o(15959);
          i = -1;
          continue;
        }
        localObject1 = b.IO();
        localObject3 = this.eaX;
        if (bo.isNullOrNil((String)localObject3))
        {
          localObject1 = null;
          if (localObject1 != null)
          {
            localObject3 = b.IO();
            i = ((NotificationItem)localObject1).id;
            ab.d("MicroMsg.Notification.Queue", "mark: %d", new Object[] { Integer.valueOf(i) });
            ((b)localObject3).mark = i;
          }
          if ((localObject1 != null) && (((NotificationItem)localObject1).yC.tickerText != null) && (this.yC.tickerText != null) && (((NotificationItem)localObject1).yC.tickerText.equals(this.yC.tickerText))) {
            this.yC.tickerText += " ";
          }
          localObject3 = b.IO();
          if (this.id == -1)
          {
            ab.e("MicroMsg.Notification.Queue", "notification id = -1(NotificationItem.INVALID_ID) when put");
            localObject1 = localBundle;
            label269:
            if (localObject1 != null) {
              b.IO().cancel(((NotificationItem)localObject1).id);
            }
            this.ebc = d.a(this.yC, paramg);
            if (localContext != null)
            {
              if (this.yC != null) {
                break label538;
              }
              ab.e("MicroMsg.NotificationItem", "error, notify but mNotification == null");
            }
            i = this.id;
            AppMethodBeat.o(15959);
          }
        }
        else
        {
          localIterator = ((b)localObject1).iterator();
        }
      }
      finally {}
      for (;;)
      {
        Iterator localIterator;
        if (localIterator.hasNext())
        {
          localObject1 = (NotificationItem)localIterator.next();
          if ((localObject1 != null) && (((NotificationItem)localObject1).eaX != null) && (((NotificationItem)localObject1).eaX.equals(localObject3)))
          {
            break;
            if (((b)localObject3).mark > 0)
            {
              if (((b)localObject3).mark == this.id)
              {
                ab.d("MicroMsg.Notification.Queue", "remove mark: %d", new Object[] { Integer.valueOf(((b)localObject3).mark) });
                ((b)localObject3).in(((b)localObject3).mark);
              }
              ((b)localObject3).mark = -1;
            }
            ((b)localObject3).in(this.id);
            localObject1 = localObject2;
            if (((b)localObject3).ebj.size() >= 5) {
              localObject1 = ((b)localObject3).IP();
            }
            ((b)localObject3).ebj.e(this);
            ((b)localObject3).ebk.c(this);
            ab.i("MicroMsg.Notification.Queue", "put item: %s, queuesize: %d", new Object[] { toString(), Integer.valueOf(((b)localObject3).ebj.size()) });
            break label269;
            label538:
            paramg = ah.getContext();
            if (paramg == null)
            {
              ab.e("MicroMsg.NotificationItem", "error, safeCheck but MMApplicationContext.getContext() == null");
              label554:
              ab.i("MicroMsg.NotificationItem", "notificaiton.defaults: %d, notification.sound: %s, notification.vibrate: %s", new Object[] { Integer.valueOf(this.yC.defaults), this.yC.sound, g.b(this.yC.vibrate) });
            }
            for (;;)
            {
              try
              {
                if ((e.IX() == 1) && (this.yC.defaults != 2) && (this.yC.vibrate == null))
                {
                  this.yC.defaults = 0;
                  this.yC.sound = null;
                  ab.i("MicroMsg.NotificationItem", "mode == vibrate & wechat shake is close, so notification switch to silent");
                }
                if (com.tencent.mm.compatible.util.d.fv(26))
                {
                  ab.i("MicroMsg.NotificationItem", "manual add led to notification");
                  this.yC.ledARGB = -16711936;
                  this.yC.ledOnMS = 300;
                  this.yC.ledOffMS = 1000;
                }
                paramg = v.K(ah.getContext());
                j = this.id;
                localObject1 = this.yC;
                localBundle = s.a((Notification)localObject1);
                if ((localBundle == null) || (!localBundle.getBoolean("android.support.useSideChannel"))) {
                  continue;
                }
                i = 1;
                if (i == 0) {
                  continue;
                }
                paramg.a(new v.b(paramg.mContext.getPackageName(), j, (Notification)localObject1));
                paramg.zb.cancel(null, j);
              }
              catch (Exception paramg)
              {
                int j;
                ab.printErrStackTrace("MicroMsg.NotificationItem", paramg, "Notification Exception?", new Object[0]);
                continue;
              }
              if (this.eaY == 0L) {
                break;
              }
              c.fY(this.eaY);
              break;
              if (this.yC == null)
              {
                ab.e("MicroMsg.NotificationItem", "error, safeCheck but mNotification == null");
                break label554;
              }
              i = this.yC.icon;
              if (paramg.getResources().getDrawable(i) != null) {
                break label554;
              }
              this.yC.icon = 2130839103;
              break label554;
              i = 0;
              continue;
              paramg.zb.notify(null, j, (Notification)localObject1);
            }
          }
        }
      }
      Object localObject1 = null;
    }
  }
  
  public final void clear()
  {
    try
    {
      AppMethodBeat.i(15958);
      if ((this.b != null) && (!this.b.isRecycled()))
      {
        ab.i("MicroMsg.NotificationItem", "recycle bitmap:%s", new Object[] { this.b.toString() });
        this.b.recycle();
      }
      this.yC = null;
      this.b = null;
      this.eaW = null;
      AppMethodBeat.o(15958);
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
    AppMethodBeat.i(15962);
    String str = "id: " + this.id + ",msgId: " + this.eaY + ",userName: " + this.eaX + ",unreadCount: " + this.eaZ;
    AppMethodBeat.o(15962);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(15961);
    paramParcel.writeInt(this.id);
    String str;
    if (this.eaX == null)
    {
      str = "";
      paramParcel.writeString(str);
      paramParcel.writeParcelable(this.b, 0);
      paramParcel.writeParcelable(this.yC, 0);
      paramParcel.writeParcelable(this.eaW, 0);
      if (!this.eba) {
        break label103;
      }
    }
    label103:
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.eaY);
      paramParcel.writeInt(this.eaZ);
      AppMethodBeat.o(15961);
      return;
      str = this.eaX;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.booter.notification.NotificationItem
 * JD-Core Version:    0.7.0.1
 */