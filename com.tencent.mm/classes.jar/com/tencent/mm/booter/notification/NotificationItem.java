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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;

public class NotificationItem
  implements Parcelable
{
  public static final Parcelable.Creator<NotificationItem> CREATOR;
  Notification HN;
  private final String TAG;
  private Bitmap b;
  private PendingIntent fIP;
  public String fIQ;
  public long fIR;
  public int fIS;
  public boolean fIT;
  public int fIU;
  public int fIV;
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
    this.fIR = 0L;
    this.fIS = 0;
    this.fIT = true;
    this.fIU = 0;
    this.fIV = 0;
    this.id = paramInt;
    this.fIQ = paramString;
    if (Build.VERSION.SDK_INT >= 11) {
      this.b = paramNotification.largeIcon;
    }
    this.HN = paramNotification;
    this.fIT = paramBoolean;
    this.fIU = 0;
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
    this.fIR = 0L;
    this.fIS = 0;
    this.fIT = true;
    this.fIU = 0;
    this.fIV = 0;
    if (paramParcel == null)
    {
      AppMethodBeat.o(19992);
      return;
    }
    this.id = paramParcel.readInt();
    this.fIQ = paramParcel.readString();
    this.b = ((Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader()));
    this.HN = ((Notification)paramParcel.readParcelable(Notification.class.getClassLoader()));
    this.fIP = ((PendingIntent)paramParcel.readParcelable(PendingIntent.class.getClassLoader()));
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.fIT = bool;
      this.fIR = paramParcel.readLong();
      this.fIS = paramParcel.readInt();
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
          i = b.Xw().o(this.fIQ, this.fIT);
          this.id = i;
          localContext = ak.getContext();
          if (localContext == null)
          {
            ae.e("MicroMsg.NotificationItem", "error, show notification but MMApplicationContext.getContext() == null");
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
        if (this.HN == null)
        {
          ae.e("MicroMsg.NotificationItem", "error, show notification but mNotification == null");
          AppMethodBeat.o(19991);
          i = -1;
          continue;
        }
        localObject1 = b.Xw();
        localObject3 = this.fIQ;
        if (bu.isNullOrNil((String)localObject3))
        {
          localObject1 = null;
          if (localObject1 != null)
          {
            localObject3 = b.Xw();
            i = ((NotificationItem)localObject1).id;
            ae.d("MicroMsg.Notification.Queue", "mark: %d", new Object[] { Integer.valueOf(i) });
            ((b)localObject3).mark = i;
          }
          if ((localObject1 != null) && (((NotificationItem)localObject1).HN.tickerText != null) && (this.HN.tickerText != null) && (((NotificationItem)localObject1).HN.tickerText.equals(this.HN.tickerText))) {
            this.HN.tickerText += " ";
          }
          localObject3 = b.Xw();
          if (this.id == -1)
          {
            ae.e("MicroMsg.Notification.Queue", "notification id = -1(NotificationItem.INVALID_ID) when put");
            localObject1 = localBundle;
            label269:
            if (localObject1 != null) {
              b.Xw().cancel(((NotificationItem)localObject1).id);
            }
            this.fIV = e.a(this.HN, paramg);
            if (localContext != null)
            {
              if (this.HN != null) {
                break label538;
              }
              ae.e("MicroMsg.NotificationItem", "error, notify but mNotification == null");
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
          if ((localObject1 != null) && (((NotificationItem)localObject1).fIQ != null) && (((NotificationItem)localObject1).fIQ.equals(localObject3)))
          {
            break;
            if (((b)localObject3).mark > 0)
            {
              if (((b)localObject3).mark == this.id)
              {
                ae.d("MicroMsg.Notification.Queue", "remove mark: %d", new Object[] { Integer.valueOf(((b)localObject3).mark) });
                ((b)localObject3).kV(((b)localObject3).mark);
              }
              ((b)localObject3).mark = -1;
            }
            ((b)localObject3).kV(this.id);
            localObject1 = localObject2;
            if (((b)localObject3).fJb.size() >= 5) {
              localObject1 = ((b)localObject3).Xx();
            }
            ((b)localObject3).fJb.e(this);
            ((b)localObject3).fJc.c(this);
            ae.i("MicroMsg.Notification.Queue", "put item: %s, queuesize: %d", new Object[] { toString(), Integer.valueOf(((b)localObject3).fJb.size()) });
            break label269;
            label538:
            paramg = ak.getContext();
            if (paramg == null)
            {
              ae.e("MicroMsg.NotificationItem", "error, safeCheck but MMApplicationContext.getContext() == null");
              label554:
              ae.i("MicroMsg.NotificationItem", "notificaiton.defaults: %d, notification.sound: %s, notification.vibrate: %s", new Object[] { Integer.valueOf(this.HN.defaults), this.HN.sound, g.a(this.HN.vibrate) });
            }
            for (;;)
            {
              try
              {
                if ((com.tencent.mm.booter.notification.a.e.XG() == 1) && (this.HN.defaults != 2) && (this.HN.vibrate == null))
                {
                  this.HN.defaults = 0;
                  this.HN.sound = null;
                  ae.i("MicroMsg.NotificationItem", "mode == vibrate & wechat shake is close, so notification switch to silent");
                }
                if (com.tencent.mm.compatible.util.d.lA(26))
                {
                  ae.i("MicroMsg.NotificationItem", "manual add led to notification");
                  this.HN.ledARGB = -16711936;
                  this.HN.ledOnMS = 300;
                  this.HN.ledOffMS = 1000;
                }
                paramg = v.O(ak.getContext());
                j = this.id;
                localObject1 = this.HN;
                localBundle = s.a((Notification)localObject1);
                if ((localBundle == null) || (!localBundle.getBoolean("android.support.useSideChannel"))) {
                  continue;
                }
                i = 1;
                if (i == 0) {
                  continue;
                }
                paramg.a(new v.b(paramg.mContext.getPackageName(), j, (Notification)localObject1));
                paramg.Im.cancel(null, j);
              }
              catch (Exception paramg)
              {
                int j;
                ae.printErrStackTrace("MicroMsg.NotificationItem", paramg, "Notification Exception?", new Object[0]);
                continue;
              }
              if (this.fIR == 0L) {
                break;
              }
              d.qW(this.fIR);
              break;
              if (this.HN == null)
              {
                ae.e("MicroMsg.NotificationItem", "error, safeCheck but mNotification == null");
                break label554;
              }
              i = this.HN.icon;
              if (paramg.getResources().getDrawable(i) != null) {
                break label554;
              }
              this.HN.icon = 2131232660;
              break label554;
              i = 0;
              continue;
              paramg.Im.notify(null, j, (Notification)localObject1);
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
        ae.i("MicroMsg.NotificationItem", "recycle bitmap:%s", new Object[] { this.b.toString() });
        this.b.recycle();
      }
      this.HN = null;
      this.b = null;
      this.fIP = null;
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
    String str = "id: " + this.id + ",msgId: " + this.fIR + ",userName: " + this.fIQ + ",unreadCount: " + this.fIS;
    AppMethodBeat.o(19994);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(19993);
    paramParcel.writeInt(this.id);
    String str;
    if (this.fIQ == null)
    {
      str = "";
      paramParcel.writeString(str);
      paramParcel.writeParcelable(this.b, 0);
      paramParcel.writeParcelable(this.HN, 0);
      paramParcel.writeParcelable(this.fIP, 0);
      if (!this.fIT) {
        break label103;
      }
    }
    label103:
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.fIR);
      paramParcel.writeInt(this.fIS);
      AppMethodBeat.o(19993);
      return;
      str = this.fIQ;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.notification.NotificationItem
 * JD-Core Version:    0.7.0.1
 */