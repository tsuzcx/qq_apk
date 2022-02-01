package com.tencent.mm.booter.notification;

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
import androidx.core.app.i;
import androidx.core.app.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.booter.notification.queue.NotificationQueue;
import com.tencent.mm.booter.notification.queue.a;
import com.tencent.mm.booter.notification.queue.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;

public class NotificationItem
  implements Parcelable
{
  public static final Parcelable.Creator<NotificationItem> CREATOR;
  private final String TAG;
  private Bitmap b;
  Notification boX;
  public int id;
  private PendingIntent luj;
  public String luk;
  public long lul;
  public int lum;
  public boolean lun;
  public int luo;
  public int lup;
  
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
  
  private NotificationItem(int paramInt, String paramString, Notification paramNotification, boolean paramBoolean)
  {
    AppMethodBeat.i(19989);
    this.TAG = "MicroMsg.NotificationItem";
    this.id = -1;
    this.lul = 0L;
    this.lum = 0;
    this.lun = true;
    this.luo = 0;
    this.lup = 0;
    this.id = paramInt;
    this.luk = paramString;
    if (Build.VERSION.SDK_INT >= 11) {
      this.b = paramNotification.largeIcon;
    }
    this.boX = paramNotification;
    this.lun = paramBoolean;
    this.luo = 0;
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
    this.lul = 0L;
    this.lum = 0;
    this.lun = true;
    this.luo = 0;
    this.lup = 0;
    if (paramParcel == null)
    {
      AppMethodBeat.o(19992);
      return;
    }
    this.id = paramParcel.readInt();
    this.luk = paramParcel.readString();
    this.b = ((Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader()));
    this.boX = ((Notification)paramParcel.readParcelable(Notification.class.getClassLoader()));
    this.luj = ((PendingIntent)paramParcel.readParcelable(PendingIntent.class.getClassLoader()));
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.lun = bool;
      this.lul = paramParcel.readLong();
      this.lum = paramParcel.readInt();
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
          i = b.aLd().r(this.luk, this.lun);
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
        if (this.boX == null)
        {
          Log.e("MicroMsg.NotificationItem", "error, show notification but mNotification == null");
          AppMethodBeat.o(19991);
          i = -1;
          continue;
        }
        localObject1 = b.aLd();
        localObject3 = this.luk;
        if (Util.isNullOrNil((String)localObject3))
        {
          localObject1 = null;
          if (localObject1 != null)
          {
            localObject3 = b.aLd();
            i = ((NotificationItem)localObject1).id;
            Log.d("MicroMsg.Notification.Queue", "mark: %d", new Object[] { Integer.valueOf(i) });
            ((b)localObject3).dUY = i;
          }
          if ((localObject1 != null) && (((NotificationItem)localObject1).boX.tickerText != null) && (this.boX.tickerText != null) && (((NotificationItem)localObject1).boX.tickerText.equals(this.boX.tickerText))) {
            this.boX.tickerText += " ";
          }
          localObject3 = b.aLd();
          if (this.id == -1)
          {
            Log.e("MicroMsg.Notification.Queue", "notification id = -1(NotificationItem.INVALID_ID) when put");
            localObject1 = localBundle;
            label269:
            if (localObject1 != null) {
              b.aLd().cancel(((NotificationItem)localObject1).id);
            }
            this.lup = f.a(this.boX, paramg);
            if (localContext != null)
            {
              if (this.boX != null) {
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
          if ((localObject1 != null) && (((NotificationItem)localObject1).luk != null) && (((NotificationItem)localObject1).luk.equals(localObject3)))
          {
            break;
            if (((b)localObject3).dUY > 0)
            {
              if (((b)localObject3).dUY == this.id)
              {
                Log.d("MicroMsg.Notification.Queue", "remove mark: %d", new Object[] { Integer.valueOf(((b)localObject3).dUY) });
                ((b)localObject3).qm(((b)localObject3).dUY);
              }
              ((b)localObject3).dUY = -1;
            }
            ((b)localObject3).qm(this.id);
            localObject1 = localObject2;
            if (((b)localObject3).luv.size() >= 5) {
              localObject1 = ((b)localObject3).aLe();
            }
            ((b)localObject3).luv.e(this);
            ((b)localObject3).luw.c(this);
            Log.i("MicroMsg.Notification.Queue", "put item: %s, queuesize: %d", new Object[] { toString(), Integer.valueOf(((b)localObject3).luv.size()) });
            break label269;
            label538:
            paramg = MMApplicationContext.getContext();
            if (paramg == null)
            {
              Log.e("MicroMsg.NotificationItem", "error, safeCheck but MMApplicationContext.getContext() == null");
              label554:
              Log.i("MicroMsg.NotificationItem", "notificaiton.defaults: %d, notification.sound: %s, notification.vibrate: %s", new Object[] { Integer.valueOf(this.boX.defaults), this.boX.sound, g.c(this.boX.vibrate) });
            }
            for (;;)
            {
              try
              {
                if ((com.tencent.mm.booter.notification.a.e.aLn() == 1) && (this.boX.defaults != 2) && (this.boX.vibrate == null))
                {
                  this.boX.defaults = 0;
                  this.boX.sound = null;
                  Log.i("MicroMsg.NotificationItem", "mode == vibrate & wechat shake is close, so notification switch to silent");
                }
                if (d.rb(26))
                {
                  Log.i("MicroMsg.NotificationItem", "manual add led to notification");
                  this.boX.ledARGB = -16711936;
                  this.boX.ledOnMS = 300;
                  this.boX.ledOffMS = 1000;
                }
                paramg = i.X(MMApplicationContext.getContext());
                j = this.id;
                localObject1 = this.boX;
                localBundle = androidx.core.app.f.a((Notification)localObject1);
                if ((localBundle == null) || (!localBundle.getBoolean("android.support.useSideChannel"))) {
                  continue;
                }
                i = 1;
                if (i == 0) {
                  continue;
                }
                paramg.a(new i.b(paramg.mContext.getPackageName(), j, (Notification)localObject1));
                paramg.bpy.cancel(null, j);
              }
              catch (Exception paramg)
              {
                int j;
                Log.printErrStackTrace("MicroMsg.NotificationItem", paramg, "Notification Exception?", new Object[0]);
                continue;
              }
              if (this.lul == 0L) {
                break;
              }
              e.hg(this.lul);
              break;
              if (this.boX == null)
              {
                Log.e("MicroMsg.NotificationItem", "error, safeCheck but mNotification == null");
                break label554;
              }
              i = this.boX.icon;
              if (paramg.getResources().getDrawable(i) != null) {
                break label554;
              }
              this.boX.icon = R.g.icon;
              break label554;
              i = 0;
              continue;
              paramg.bpy.notify(null, j, (Notification)localObject1);
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
      this.boX = null;
      this.b = null;
      this.luj = null;
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
    String str = "id: " + this.id + ",msgId: " + this.lul + ",userName: " + this.luk + ",unreadCount: " + this.lum;
    AppMethodBeat.o(19994);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(19993);
    paramParcel.writeInt(this.id);
    String str;
    if (this.luk == null)
    {
      str = "";
      paramParcel.writeString(str);
      paramParcel.writeParcelable(this.b, 0);
      paramParcel.writeParcelable(this.boX, 0);
      paramParcel.writeParcelable(this.luj, 0);
      if (!this.lun) {
        break label103;
      }
    }
    label103:
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.lul);
      paramParcel.writeInt(this.lum);
      AppMethodBeat.o(19993);
      return;
      str = this.luk;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.notification.NotificationItem
 * JD-Core Version:    0.7.0.1
 */