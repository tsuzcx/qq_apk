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
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.booter.notification.queue.NotificationQueue;
import com.tencent.mm.booter.notification.queue.a;
import com.tencent.mm.booter.notification.queue.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;

public class NotificationItem
  implements Parcelable
{
  public static final Parcelable.Creator<NotificationItem> CREATOR;
  Notification HX;
  private final String TAG;
  private Bitmap b;
  private PendingIntent god;
  public String goe;
  public long gof;
  public int gog;
  public boolean goh;
  public int goi;
  public int goj;
  public int id;
  
  static
  {
    AppMethodBeat.i(19995);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(19995);
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
    AppMethodBeat.i(19989);
    this.TAG = "MicroMsg.NotificationItem";
    this.id = -1;
    this.gof = 0L;
    this.gog = 0;
    this.goh = true;
    this.goi = 0;
    this.goj = 0;
    this.id = paramInt;
    this.goe = paramString;
    if (Build.VERSION.SDK_INT >= 11) {
      this.b = paramNotification.largeIcon;
    }
    this.HX = paramNotification;
    this.goh = paramBoolean;
    this.goi = 0;
    AppMethodBeat.o(19989);
  }
  
  public NotificationItem(Notification paramNotification, boolean paramBoolean)
  {
    this(-1, paramNotification, paramBoolean);
  }
  
  private NotificationItem(Parcel paramParcel)
  {
    AppMethodBeat.i(19992);
    this.TAG = "MicroMsg.NotificationItem";
    this.id = -1;
    this.gof = 0L;
    this.gog = 0;
    this.goh = true;
    this.goi = 0;
    this.goj = 0;
    if (paramParcel == null)
    {
      AppMethodBeat.o(19992);
      return;
    }
    this.id = paramParcel.readInt();
    this.goe = paramParcel.readString();
    this.b = ((Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader()));
    this.HX = ((Notification)paramParcel.readParcelable(Notification.class.getClassLoader()));
    this.god = ((PendingIntent)paramParcel.readParcelable(PendingIntent.class.getClassLoader()));
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.goh = bool;
      this.gof = paramParcel.readLong();
      this.gog = paramParcel.readInt();
      AppMethodBeat.o(19992);
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
        AppMethodBeat.i(19991);
        Context localContext;
        if (this.id == -1)
        {
          i = b.alj().o(this.goe, this.goh);
          this.id = i;
          localContext = MMApplicationContext.getContext();
          if (localContext == null)
          {
            Log.e("MicroMsg.NotificationItem", "error, show notification but MMApplicationContext.getContext() == null");
            AppMethodBeat.o(19991);
            i = -1;
            return i;
          }
        }
        else
        {
          i = this.id;
          continue;
        }
        if (this.HX == null)
        {
          Log.e("MicroMsg.NotificationItem", "error, show notification but mNotification == null");
          AppMethodBeat.o(19991);
          i = -1;
          continue;
        }
        localObject1 = b.alj();
        localObject3 = this.goe;
        if (Util.isNullOrNil((String)localObject3))
        {
          localObject1 = null;
          if (localObject1 != null)
          {
            localObject3 = b.alj();
            i = ((NotificationItem)localObject1).id;
            Log.d("MicroMsg.Notification.Queue", "mark: %d", new Object[] { Integer.valueOf(i) });
            ((b)localObject3).mark = i;
          }
          if ((localObject1 != null) && (((NotificationItem)localObject1).HX.tickerText != null) && (this.HX.tickerText != null) && (((NotificationItem)localObject1).HX.tickerText.equals(this.HX.tickerText))) {
            this.HX.tickerText += " ";
          }
          localObject3 = b.alj();
          if (this.id == -1)
          {
            Log.e("MicroMsg.Notification.Queue", "notification id = -1(NotificationItem.INVALID_ID) when put");
            localObject1 = localBundle;
            label269:
            if (localObject1 != null) {
              b.alj().cancel(((NotificationItem)localObject1).id);
            }
            this.goj = e.a(this.HX, paramg);
            if (localContext != null)
            {
              if (this.HX != null) {
                break label538;
              }
              Log.e("MicroMsg.NotificationItem", "error, notify but mNotification == null");
            }
            i = this.id;
            AppMethodBeat.o(19991);
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
          if ((localObject1 != null) && (((NotificationItem)localObject1).goe != null) && (((NotificationItem)localObject1).goe.equals(localObject3)))
          {
            break;
            if (((b)localObject3).mark > 0)
            {
              if (((b)localObject3).mark == this.id)
              {
                Log.d("MicroMsg.Notification.Queue", "remove mark: %d", new Object[] { Integer.valueOf(((b)localObject3).mark) });
                ((b)localObject3).nX(((b)localObject3).mark);
              }
              ((b)localObject3).mark = -1;
            }
            ((b)localObject3).nX(this.id);
            localObject1 = localObject2;
            if (((b)localObject3).goq.size() >= 5) {
              localObject1 = ((b)localObject3).alk();
            }
            ((b)localObject3).goq.e(this);
            ((b)localObject3).gor.c(this);
            Log.i("MicroMsg.Notification.Queue", "put item: %s, queuesize: %d", new Object[] { toString(), Integer.valueOf(((b)localObject3).goq.size()) });
            break label269;
            label538:
            paramg = MMApplicationContext.getContext();
            if (paramg == null)
            {
              Log.e("MicroMsg.NotificationItem", "error, safeCheck but MMApplicationContext.getContext() == null");
              label554:
              Log.i("MicroMsg.NotificationItem", "notificaiton.defaults: %d, notification.sound: %s, notification.vibrate: %s", new Object[] { Integer.valueOf(this.HX.defaults), this.HX.sound, g.a(this.HX.vibrate) });
            }
            for (;;)
            {
              try
              {
                if ((com.tencent.mm.booter.notification.a.e.alt() == 1) && (this.HX.defaults != 2) && (this.HX.vibrate == null))
                {
                  this.HX.defaults = 0;
                  this.HX.sound = null;
                  Log.i("MicroMsg.NotificationItem", "mode == vibrate & wechat shake is close, so notification switch to silent");
                }
                if (com.tencent.mm.compatible.util.d.oD(26))
                {
                  Log.i("MicroMsg.NotificationItem", "manual add led to notification");
                  this.HX.ledARGB = -16711936;
                  this.HX.ledOnMS = 300;
                  this.HX.ledOffMS = 1000;
                }
                paramg = v.P(MMApplicationContext.getContext());
                j = this.id;
                localObject1 = this.HX;
                localBundle = s.a((Notification)localObject1);
                if ((localBundle == null) || (!localBundle.getBoolean("android.support.useSideChannel"))) {
                  continue;
                }
                i = 1;
                if (i == 0) {
                  continue;
                }
                paramg.a(new v.b(paramg.mContext.getPackageName(), j, (Notification)localObject1));
                paramg.Iw.cancel(null, j);
              }
              catch (Exception paramg)
              {
                int j;
                Log.printErrStackTrace("MicroMsg.NotificationItem", paramg, "Notification Exception?", new Object[0]);
                continue;
              }
              if (this.gof == 0L) {
                break;
              }
              d.yO(this.gof);
              break;
              if (this.HX == null)
              {
                Log.e("MicroMsg.NotificationItem", "error, safeCheck but mNotification == null");
                break label554;
              }
              i = this.HX.icon;
              if (paramg.getResources().getDrawable(i) != null) {
                break label554;
              }
              this.HX.icon = 2131233070;
              break label554;
              i = 0;
              continue;
              paramg.Iw.notify(null, j, (Notification)localObject1);
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
      AppMethodBeat.i(19990);
      if ((this.b != null) && (!this.b.isRecycled()))
      {
        Log.i("MicroMsg.NotificationItem", "recycle bitmap:%s", new Object[] { this.b.toString() });
        this.b.recycle();
      }
      this.HX = null;
      this.b = null;
      this.god = null;
      AppMethodBeat.o(19990);
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
    AppMethodBeat.i(19994);
    String str = "id: " + this.id + ",msgId: " + this.gof + ",userName: " + this.goe + ",unreadCount: " + this.gog;
    AppMethodBeat.o(19994);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(19993);
    paramParcel.writeInt(this.id);
    String str;
    if (this.goe == null)
    {
      str = "";
      paramParcel.writeString(str);
      paramParcel.writeParcelable(this.b, 0);
      paramParcel.writeParcelable(this.HX, 0);
      paramParcel.writeParcelable(this.god, 0);
      if (!this.goh) {
        break label103;
      }
    }
    label103:
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.gof);
      paramParcel.writeInt(this.gog);
      AppMethodBeat.o(19993);
      return;
      str = this.goe;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.notification.NotificationItem
 * JD-Core Version:    0.7.0.1
 */