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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;

public class NotificationItem
  implements Parcelable
{
  public static final Parcelable.Creator<NotificationItem> CREATOR;
  Notification FW;
  private final String TAG;
  private Bitmap b;
  private PendingIntent foD;
  public String foE;
  public long foF;
  public int foG;
  public boolean foH;
  public int foI;
  public int foJ;
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
    this.foF = 0L;
    this.foG = 0;
    this.foH = true;
    this.foI = 0;
    this.foJ = 0;
    this.id = paramInt;
    this.foE = paramString;
    if (Build.VERSION.SDK_INT >= 11) {
      this.b = paramNotification.largeIcon;
    }
    this.FW = paramNotification;
    this.foH = paramBoolean;
    this.foI = 0;
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
    this.foF = 0L;
    this.foG = 0;
    this.foH = true;
    this.foI = 0;
    this.foJ = 0;
    if (paramParcel == null)
    {
      AppMethodBeat.o(19992);
      return;
    }
    this.id = paramParcel.readInt();
    this.foE = paramParcel.readString();
    this.b = ((Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader()));
    this.FW = ((Notification)paramParcel.readParcelable(Notification.class.getClassLoader()));
    this.foD = ((PendingIntent)paramParcel.readParcelable(PendingIntent.class.getClassLoader()));
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.foH = bool;
      this.foF = paramParcel.readLong();
      this.foG = paramParcel.readInt();
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
          i = b.UX().o(this.foE, this.foH);
          this.id = i;
          localContext = ai.getContext();
          if (localContext == null)
          {
            ac.e("MicroMsg.NotificationItem", "error, show notification but MMApplicationContext.getContext() == null");
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
        if (this.FW == null)
        {
          ac.e("MicroMsg.NotificationItem", "error, show notification but mNotification == null");
          AppMethodBeat.o(19991);
          i = -1;
          continue;
        }
        localObject1 = b.UX();
        localObject3 = this.foE;
        if (bs.isNullOrNil((String)localObject3))
        {
          localObject1 = null;
          if (localObject1 != null)
          {
            localObject3 = b.UX();
            i = ((NotificationItem)localObject1).id;
            ac.d("MicroMsg.Notification.Queue", "mark: %d", new Object[] { Integer.valueOf(i) });
            ((b)localObject3).mark = i;
          }
          if ((localObject1 != null) && (((NotificationItem)localObject1).FW.tickerText != null) && (this.FW.tickerText != null) && (((NotificationItem)localObject1).FW.tickerText.equals(this.FW.tickerText))) {
            this.FW.tickerText += " ";
          }
          localObject3 = b.UX();
          if (this.id == -1)
          {
            ac.e("MicroMsg.Notification.Queue", "notification id = -1(NotificationItem.INVALID_ID) when put");
            localObject1 = localBundle;
            label269:
            if (localObject1 != null) {
              b.UX().cancel(((NotificationItem)localObject1).id);
            }
            this.foJ = d.a(this.FW, paramg);
            if (localContext != null)
            {
              if (this.FW != null) {
                break label538;
              }
              ac.e("MicroMsg.NotificationItem", "error, notify but mNotification == null");
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
          if ((localObject1 != null) && (((NotificationItem)localObject1).foE != null) && (((NotificationItem)localObject1).foE.equals(localObject3)))
          {
            break;
            if (((b)localObject3).mark > 0)
            {
              if (((b)localObject3).mark == this.id)
              {
                ac.d("MicroMsg.Notification.Queue", "remove mark: %d", new Object[] { Integer.valueOf(((b)localObject3).mark) });
                ((b)localObject3).kw(((b)localObject3).mark);
              }
              ((b)localObject3).mark = -1;
            }
            ((b)localObject3).kw(this.id);
            localObject1 = localObject2;
            if (((b)localObject3).foP.size() >= 5) {
              localObject1 = ((b)localObject3).UY();
            }
            ((b)localObject3).foP.e(this);
            ((b)localObject3).foQ.c(this);
            ac.i("MicroMsg.Notification.Queue", "put item: %s, queuesize: %d", new Object[] { toString(), Integer.valueOf(((b)localObject3).foP.size()) });
            break label269;
            label538:
            paramg = ai.getContext();
            if (paramg == null)
            {
              ac.e("MicroMsg.NotificationItem", "error, safeCheck but MMApplicationContext.getContext() == null");
              label554:
              ac.i("MicroMsg.NotificationItem", "notificaiton.defaults: %d, notification.sound: %s, notification.vibrate: %s", new Object[] { Integer.valueOf(this.FW.defaults), this.FW.sound, g.a(this.FW.vibrate) });
            }
            for (;;)
            {
              try
              {
                if ((e.Vh() == 1) && (this.FW.defaults != 2) && (this.FW.vibrate == null))
                {
                  this.FW.defaults = 0;
                  this.FW.sound = null;
                  ac.i("MicroMsg.NotificationItem", "mode == vibrate & wechat shake is close, so notification switch to silent");
                }
                if (com.tencent.mm.compatible.util.d.kZ(26))
                {
                  ac.i("MicroMsg.NotificationItem", "manual add led to notification");
                  this.FW.ledARGB = -16711936;
                  this.FW.ledOnMS = 300;
                  this.FW.ledOffMS = 1000;
                }
                paramg = v.N(ai.getContext());
                j = this.id;
                localObject1 = this.FW;
                localBundle = s.a((Notification)localObject1);
                if ((localBundle == null) || (!localBundle.getBoolean("android.support.useSideChannel"))) {
                  continue;
                }
                i = 1;
                if (i == 0) {
                  continue;
                }
                paramg.a(new v.b(paramg.mContext.getPackageName(), j, (Notification)localObject1));
                paramg.Gu.cancel(null, j);
              }
              catch (Exception paramg)
              {
                int j;
                ac.printErrStackTrace("MicroMsg.NotificationItem", paramg, "Notification Exception?", new Object[0]);
                continue;
              }
              if (this.foF == 0L) {
                break;
              }
              c.oJ(this.foF);
              break;
              if (this.FW == null)
              {
                ac.e("MicroMsg.NotificationItem", "error, safeCheck but mNotification == null");
                break label554;
              }
              i = this.FW.icon;
              if (paramg.getResources().getDrawable(i) != null) {
                break label554;
              }
              this.FW.icon = 2131232660;
              break label554;
              i = 0;
              continue;
              paramg.Gu.notify(null, j, (Notification)localObject1);
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
        ac.i("MicroMsg.NotificationItem", "recycle bitmap:%s", new Object[] { this.b.toString() });
        this.b.recycle();
      }
      this.FW = null;
      this.b = null;
      this.foD = null;
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
    String str = "id: " + this.id + ",msgId: " + this.foF + ",userName: " + this.foE + ",unreadCount: " + this.foG;
    AppMethodBeat.o(19994);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(19993);
    paramParcel.writeInt(this.id);
    String str;
    if (this.foE == null)
    {
      str = "";
      paramParcel.writeString(str);
      paramParcel.writeParcelable(this.b, 0);
      paramParcel.writeParcelable(this.FW, 0);
      paramParcel.writeParcelable(this.foD, 0);
      if (!this.foH) {
        break label103;
      }
    }
    label103:
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.foF);
      paramParcel.writeInt(this.foG);
      AppMethodBeat.o(19993);
      return;
      str = this.foE;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.notification.NotificationItem
 * JD-Core Version:    0.7.0.1
 */