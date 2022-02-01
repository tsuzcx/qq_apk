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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;

public class NotificationItem
  implements Parcelable
{
  public static final Parcelable.Creator<NotificationItem> CREATOR;
  Notification EY;
  private final String TAG;
  private Bitmap b;
  private PendingIntent flj;
  public String flk;
  public long fll;
  public int flm;
  public boolean fln;
  public int flo;
  public int flp;
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
    this.fll = 0L;
    this.flm = 0;
    this.fln = true;
    this.flo = 0;
    this.flp = 0;
    this.id = paramInt;
    this.flk = paramString;
    if (Build.VERSION.SDK_INT >= 11) {
      this.b = paramNotification.largeIcon;
    }
    this.EY = paramNotification;
    this.fln = paramBoolean;
    this.flo = 0;
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
    this.fll = 0L;
    this.flm = 0;
    this.fln = true;
    this.flo = 0;
    this.flp = 0;
    if (paramParcel == null)
    {
      AppMethodBeat.o(19992);
      return;
    }
    this.id = paramParcel.readInt();
    this.flk = paramParcel.readString();
    this.b = ((Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader()));
    this.EY = ((Notification)paramParcel.readParcelable(Notification.class.getClassLoader()));
    this.flj = ((PendingIntent)paramParcel.readParcelable(PendingIntent.class.getClassLoader()));
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.fln = bool;
      this.fll = paramParcel.readLong();
      this.flm = paramParcel.readInt();
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
          i = b.Uc().o(this.flk, this.fln);
          this.id = i;
          localContext = aj.getContext();
          if (localContext == null)
          {
            ad.e("MicroMsg.NotificationItem", "error, show notification but MMApplicationContext.getContext() == null");
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
        if (this.EY == null)
        {
          ad.e("MicroMsg.NotificationItem", "error, show notification but mNotification == null");
          AppMethodBeat.o(19991);
          i = -1;
          continue;
        }
        localObject1 = b.Uc();
        localObject3 = this.flk;
        if (bt.isNullOrNil((String)localObject3))
        {
          localObject1 = null;
          if (localObject1 != null)
          {
            localObject3 = b.Uc();
            i = ((NotificationItem)localObject1).id;
            ad.d("MicroMsg.Notification.Queue", "mark: %d", new Object[] { Integer.valueOf(i) });
            ((b)localObject3).mark = i;
          }
          if ((localObject1 != null) && (((NotificationItem)localObject1).EY.tickerText != null) && (this.EY.tickerText != null) && (((NotificationItem)localObject1).EY.tickerText.equals(this.EY.tickerText))) {
            this.EY.tickerText += " ";
          }
          localObject3 = b.Uc();
          if (this.id == -1)
          {
            ad.e("MicroMsg.Notification.Queue", "notification id = -1(NotificationItem.INVALID_ID) when put");
            localObject1 = localBundle;
            label269:
            if (localObject1 != null) {
              b.Uc().cancel(((NotificationItem)localObject1).id);
            }
            this.flp = d.a(this.EY, paramg);
            if (localContext != null)
            {
              if (this.EY != null) {
                break label538;
              }
              ad.e("MicroMsg.NotificationItem", "error, notify but mNotification == null");
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
          if ((localObject1 != null) && (((NotificationItem)localObject1).flk != null) && (((NotificationItem)localObject1).flk.equals(localObject3)))
          {
            break;
            if (((b)localObject3).mark > 0)
            {
              if (((b)localObject3).mark == this.id)
              {
                ad.d("MicroMsg.Notification.Queue", "remove mark: %d", new Object[] { Integer.valueOf(((b)localObject3).mark) });
                ((b)localObject3).kz(((b)localObject3).mark);
              }
              ((b)localObject3).mark = -1;
            }
            ((b)localObject3).kz(this.id);
            localObject1 = localObject2;
            if (((b)localObject3).flv.size() >= 5) {
              localObject1 = ((b)localObject3).Ud();
            }
            ((b)localObject3).flv.e(this);
            ((b)localObject3).flw.c(this);
            ad.i("MicroMsg.Notification.Queue", "put item: %s, queuesize: %d", new Object[] { toString(), Integer.valueOf(((b)localObject3).flv.size()) });
            break label269;
            label538:
            paramg = aj.getContext();
            if (paramg == null)
            {
              ad.e("MicroMsg.NotificationItem", "error, safeCheck but MMApplicationContext.getContext() == null");
              label554:
              ad.i("MicroMsg.NotificationItem", "notificaiton.defaults: %d, notification.sound: %s, notification.vibrate: %s", new Object[] { Integer.valueOf(this.EY.defaults), this.EY.sound, g.a(this.EY.vibrate) });
            }
            for (;;)
            {
              try
              {
                if ((e.Um() == 1) && (this.EY.defaults != 2) && (this.EY.vibrate == null))
                {
                  this.EY.defaults = 0;
                  this.EY.sound = null;
                  ad.i("MicroMsg.NotificationItem", "mode == vibrate & wechat shake is close, so notification switch to silent");
                }
                if (com.tencent.mm.compatible.util.d.lf(26))
                {
                  ad.i("MicroMsg.NotificationItem", "manual add led to notification");
                  this.EY.ledARGB = -16711936;
                  this.EY.ledOnMS = 300;
                  this.EY.ledOffMS = 1000;
                }
                paramg = v.M(aj.getContext());
                j = this.id;
                localObject1 = this.EY;
                localBundle = s.a((Notification)localObject1);
                if ((localBundle == null) || (!localBundle.getBoolean("android.support.useSideChannel"))) {
                  continue;
                }
                i = 1;
                if (i == 0) {
                  continue;
                }
                paramg.a(new v.b(paramg.mContext.getPackageName(), j, (Notification)localObject1));
                paramg.Fw.cancel(null, j);
              }
              catch (Exception paramg)
              {
                int j;
                ad.printErrStackTrace("MicroMsg.NotificationItem", paramg, "Notification Exception?", new Object[0]);
                continue;
              }
              if (this.fll == 0L) {
                break;
              }
              c.lh(this.fll);
              break;
              if (this.EY == null)
              {
                ad.e("MicroMsg.NotificationItem", "error, safeCheck but mNotification == null");
                break label554;
              }
              i = this.EY.icon;
              if (paramg.getResources().getDrawable(i) != null) {
                break label554;
              }
              this.EY.icon = 2131232660;
              break label554;
              i = 0;
              continue;
              paramg.Fw.notify(null, j, (Notification)localObject1);
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
        ad.i("MicroMsg.NotificationItem", "recycle bitmap:%s", new Object[] { this.b.toString() });
        this.b.recycle();
      }
      this.EY = null;
      this.b = null;
      this.flj = null;
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
    String str = "id: " + this.id + ",msgId: " + this.fll + ",userName: " + this.flk + ",unreadCount: " + this.flm;
    AppMethodBeat.o(19994);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(19993);
    paramParcel.writeInt(this.id);
    String str;
    if (this.flk == null)
    {
      str = "";
      paramParcel.writeString(str);
      paramParcel.writeParcelable(this.b, 0);
      paramParcel.writeParcelable(this.EY, 0);
      paramParcel.writeParcelable(this.flj, 0);
      if (!this.fln) {
        break label103;
      }
    }
    label103:
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.fll);
      paramParcel.writeInt(this.flm);
      AppMethodBeat.o(19993);
      return;
      str = this.flk;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.notification.NotificationItem
 * JD-Core Version:    0.7.0.1
 */