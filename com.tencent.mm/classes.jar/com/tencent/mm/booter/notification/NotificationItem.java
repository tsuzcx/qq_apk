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
import androidx.core.app.h;
import androidx.core.app.h.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
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
  Notification IV;
  private final String TAG;
  private Bitmap b;
  private PendingIntent iSm;
  public String iSn;
  public long iSo;
  public int iSp;
  public boolean iSq;
  public int iSr;
  public int iSs;
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
    this.iSo = 0L;
    this.iSp = 0;
    this.iSq = true;
    this.iSr = 0;
    this.iSs = 0;
    this.id = paramInt;
    this.iSn = paramString;
    if (Build.VERSION.SDK_INT >= 11) {
      this.b = paramNotification.largeIcon;
    }
    this.IV = paramNotification;
    this.iSq = paramBoolean;
    this.iSr = 0;
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
    this.iSo = 0L;
    this.iSp = 0;
    this.iSq = true;
    this.iSr = 0;
    this.iSs = 0;
    if (paramParcel == null)
    {
      AppMethodBeat.o(19992);
      return;
    }
    this.id = paramParcel.readInt();
    this.iSn = paramParcel.readString();
    this.b = ((Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader()));
    this.IV = ((Notification)paramParcel.readParcelable(Notification.class.getClassLoader()));
    this.iSm = ((PendingIntent)paramParcel.readParcelable(PendingIntent.class.getClassLoader()));
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.iSq = bool;
      this.iSo = paramParcel.readLong();
      this.iSp = paramParcel.readInt();
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
          i = b.arh().r(this.iSn, this.iSq);
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
        if (this.IV == null)
        {
          Log.e("MicroMsg.NotificationItem", "error, show notification but mNotification == null");
          AppMethodBeat.o(19991);
          i = -1;
          continue;
        }
        localObject1 = b.arh();
        localObject3 = this.iSn;
        if (Util.isNullOrNil((String)localObject3))
        {
          localObject1 = null;
          if (localObject1 != null)
          {
            localObject3 = b.arh();
            i = ((NotificationItem)localObject1).id;
            Log.d("MicroMsg.Notification.Queue", "mark: %d", new Object[] { Integer.valueOf(i) });
            ((b)localObject3).iSy = i;
          }
          if ((localObject1 != null) && (((NotificationItem)localObject1).IV.tickerText != null) && (this.IV.tickerText != null) && (((NotificationItem)localObject1).IV.tickerText.equals(this.IV.tickerText))) {
            this.IV.tickerText += " ";
          }
          localObject3 = b.arh();
          if (this.id == -1)
          {
            Log.e("MicroMsg.Notification.Queue", "notification id = -1(NotificationItem.INVALID_ID) when put");
            localObject1 = localBundle;
            label269:
            if (localObject1 != null) {
              b.arh().cancel(((NotificationItem)localObject1).id);
            }
            this.iSs = e.a(this.IV, paramg);
            if (localContext != null)
            {
              if (this.IV != null) {
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
          if ((localObject1 != null) && (((NotificationItem)localObject1).iSn != null) && (((NotificationItem)localObject1).iSn.equals(localObject3)))
          {
            break;
            if (((b)localObject3).iSy > 0)
            {
              if (((b)localObject3).iSy == this.id)
              {
                Log.d("MicroMsg.Notification.Queue", "remove mark: %d", new Object[] { Integer.valueOf(((b)localObject3).iSy) });
                ((b)localObject3).qm(((b)localObject3).iSy);
              }
              ((b)localObject3).iSy = -1;
            }
            ((b)localObject3).qm(this.id);
            localObject1 = localObject2;
            if (((b)localObject3).iSz.size() >= 5) {
              localObject1 = ((b)localObject3).ari();
            }
            ((b)localObject3).iSz.e(this);
            ((b)localObject3).iSA.c(this);
            Log.i("MicroMsg.Notification.Queue", "put item: %s, queuesize: %d", new Object[] { toString(), Integer.valueOf(((b)localObject3).iSz.size()) });
            break label269;
            label538:
            paramg = MMApplicationContext.getContext();
            if (paramg == null)
            {
              Log.e("MicroMsg.NotificationItem", "error, safeCheck but MMApplicationContext.getContext() == null");
              label554:
              Log.i("MicroMsg.NotificationItem", "notificaiton.defaults: %d, notification.sound: %s, notification.vibrate: %s", new Object[] { Integer.valueOf(this.IV.defaults), this.IV.sound, g.a(this.IV.vibrate) });
            }
            for (;;)
            {
              try
              {
                if ((com.tencent.mm.booter.notification.a.e.arr() == 1) && (this.IV.defaults != 2) && (this.IV.vibrate == null))
                {
                  this.IV.defaults = 0;
                  this.IV.sound = null;
                  Log.i("MicroMsg.NotificationItem", "mode == vibrate & wechat shake is close, so notification switch to silent");
                }
                if (com.tencent.mm.compatible.util.d.qV(26))
                {
                  Log.i("MicroMsg.NotificationItem", "manual add led to notification");
                  this.IV.ledARGB = -16711936;
                  this.IV.ledOnMS = 300;
                  this.IV.ledOffMS = 1000;
                }
                paramg = h.M(MMApplicationContext.getContext());
                j = this.id;
                localObject1 = this.IV;
                localBundle = androidx.core.app.e.a((Notification)localObject1);
                if ((localBundle == null) || (!localBundle.getBoolean("android.support.useSideChannel"))) {
                  continue;
                }
                i = 1;
                if (i == 0) {
                  continue;
                }
                paramg.a(new h.b(paramg.mContext.getPackageName(), j, (Notification)localObject1));
                paramg.Jv.cancel(null, j);
              }
              catch (Exception paramg)
              {
                int j;
                Log.printErrStackTrace("MicroMsg.NotificationItem", paramg, "Notification Exception?", new Object[0]);
                continue;
              }
              if (this.iSo == 0L) {
                break;
              }
              d.EP(this.iSo);
              break;
              if (this.IV == null)
              {
                Log.e("MicroMsg.NotificationItem", "error, safeCheck but mNotification == null");
                break label554;
              }
              i = this.IV.icon;
              if (paramg.getResources().getDrawable(i) != null) {
                break label554;
              }
              this.IV.icon = R.g.icon;
              break label554;
              i = 0;
              continue;
              paramg.Jv.notify(null, j, (Notification)localObject1);
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
      this.IV = null;
      this.b = null;
      this.iSm = null;
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
    String str = "id: " + this.id + ",msgId: " + this.iSo + ",userName: " + this.iSn + ",unreadCount: " + this.iSp;
    AppMethodBeat.o(19994);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(19993);
    paramParcel.writeInt(this.id);
    String str;
    if (this.iSn == null)
    {
      str = "";
      paramParcel.writeString(str);
      paramParcel.writeParcelable(this.b, 0);
      paramParcel.writeParcelable(this.IV, 0);
      paramParcel.writeParcelable(this.iSm, 0);
      if (!this.iSq) {
        break label103;
      }
    }
    label103:
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.iSo);
      paramParcel.writeInt(this.iSp);
      AppMethodBeat.o(19993);
      return;
      str = this.iSn;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.notification.NotificationItem
 * JD-Core Version:    0.7.0.1
 */