package com.tencent.mm.booter.notification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.app.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.queue.b;
import com.tencent.mm.m.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public final class e
  extends a
{
  private NotificationManager Fw;
  public c fli;
  private Context mContext;
  
  public e()
  {
    AppMethodBeat.i(19983);
    this.mContext = aj.getContext();
    this.Fw = ((NotificationManager)this.mContext.getSystemService("notification"));
    this.fli = new c();
    AppMethodBeat.o(19983);
  }
  
  public static void cancel()
  {
    AppMethodBeat.i(19984);
    v localv = v.M(aj.getContext());
    LinkedList localLinkedList = new LinkedList();
    Object localObject = b.Uc().Ue();
    StringBuilder localStringBuilder = new StringBuilder();
    localObject = ((Queue)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      localStringBuilder.append(localInteger + ";");
      if (!localLinkedList.contains(localInteger))
      {
        b.Uc().a(localv, localInteger.intValue());
        localLinkedList.add(localInteger);
      }
    }
    ad.i("MicroMsg.Notification.Handle", "needRemoveNotificationId:%s", new Object[] { localStringBuilder });
    AppMethodBeat.o(19984);
  }
  
  public static void p(int paramInt, String paramString)
  {
    AppMethodBeat.i(19987);
    ad.i("MicroMsg.Notification.AppMsg.Handle", "refreshTotalUnread, %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    int i = paramInt;
    if (paramInt == -1) {
      i = f.YZ();
    }
    c.kv(i);
    ArrayList localArrayList;
    if ((paramString != null) && (paramString.length() > 0))
    {
      localArrayList = c.TY();
      if (localArrayList != null) {
        break label308;
      }
      localArrayList = new ArrayList();
    }
    label308:
    for (;;)
    {
      Object localObject2 = localArrayList.iterator();
      Object localObject1;
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (c.a)((Iterator)localObject2).next();
        if (((c.a)localObject1).userName.equals(paramString)) {
          localArrayList.remove(localObject1);
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new c.a((byte)0);
        }
        ((c.a)localObject2).userName = paramString;
        ((c.a)localObject2).dmL = f.pD(paramString);
        if ((((c.a)localObject2).dmL == 0) && (localArrayList.isEmpty()))
        {
          c.e(null);
          AppMethodBeat.o(19987);
          return;
        }
        paramString = localArrayList;
        if (((c.a)localObject2).dmL > 0)
        {
          localArrayList.add(localObject2);
          paramString = localArrayList;
        }
        c.e(paramString);
        AppMethodBeat.o(19987);
        return;
        localArrayList = new ArrayList();
        localObject1 = f.YY();
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = new ArrayList();
        }
        localObject1 = paramString.iterator();
        for (;;)
        {
          paramString = localArrayList;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          paramString = (String)((Iterator)localObject1).next();
          localObject2 = new c.a((byte)0);
          ((c.a)localObject2).userName = paramString;
          ((c.a)localObject2).dmL = f.pD(paramString);
          localArrayList.add(localObject2);
        }
        localObject1 = null;
      }
    }
  }
  
  public final int a(NotificationItem paramNotificationItem)
  {
    AppMethodBeat.i(19985);
    if (paramNotificationItem == null)
    {
      AppMethodBeat.o(19985);
      return -1;
    }
    int i = a(paramNotificationItem, null);
    AppMethodBeat.o(19985);
    return i;
  }
  
  @TargetApi(11)
  public final Notification a(Notification paramNotification, int paramInt1, int paramInt2, PendingIntent paramPendingIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4)
  {
    AppMethodBeat.i(19986);
    paramNotification = this.fli.a(paramNotification, paramInt1, paramInt2, paramPendingIntent, paramString1, paramString2, paramString3, paramBitmap, paramString4);
    AppMethodBeat.o(19986);
    return paramNotification;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.notification.e
 * JD-Core Version:    0.7.0.1
 */