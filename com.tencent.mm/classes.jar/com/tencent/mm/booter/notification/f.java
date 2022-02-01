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
import com.tencent.mm.n.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public final class f
  extends a
{
  private NotificationManager Iw;
  public d goc;
  private Context mContext;
  
  public f()
  {
    AppMethodBeat.i(19983);
    this.mContext = MMApplicationContext.getContext();
    this.Iw = ((NotificationManager)this.mContext.getSystemService("notification"));
    this.goc = new d();
    AppMethodBeat.o(19983);
  }
  
  public static void cancel()
  {
    AppMethodBeat.i(19984);
    v localv = v.P(MMApplicationContext.getContext());
    LinkedList localLinkedList = new LinkedList();
    Object localObject = b.alj().all();
    StringBuilder localStringBuilder = new StringBuilder();
    localObject = ((Queue)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      localStringBuilder.append(localInteger + ";");
      if (!localLinkedList.contains(localInteger))
      {
        b.alj().a(localv, localInteger.intValue());
        localLinkedList.add(localInteger);
      }
    }
    Log.i("MicroMsg.Notification.Handle", "needRemoveNotificationId:%s", new Object[] { localStringBuilder });
    AppMethodBeat.o(19984);
  }
  
  public static void r(int paramInt, String paramString)
  {
    AppMethodBeat.i(19987);
    Log.i("MicroMsg.Notification.AppMsg.Handle", "refreshTotalUnread, %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    int i = paramInt;
    if (paramInt == -1) {
      i = g.aqG();
    }
    d.nT(i);
    ArrayList localArrayList;
    if ((paramString != null) && (paramString.length() > 0))
    {
      localArrayList = d.alf();
      if (localArrayList != null) {
        break label290;
      }
      localArrayList = new ArrayList();
    }
    label290:
    for (;;)
    {
      Object localObject2 = localArrayList.iterator();
      Object localObject1;
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (d.a)((Iterator)localObject2).next();
        if (((d.a)localObject1).userName.equals(paramString)) {
          localArrayList.remove(localObject1);
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new d.a((byte)0);
        }
        ((d.a)localObject2).userName = paramString;
        ((d.a)localObject2).dOS = g.Eo(paramString);
        if ((((d.a)localObject2).dOS == 0) && (localArrayList.isEmpty()))
        {
          d.h(null);
          AppMethodBeat.o(19987);
          return;
        }
        paramString = localArrayList;
        if (((d.a)localObject2).dOS > 0)
        {
          localArrayList.add(localObject2);
          paramString = localArrayList;
        }
        d.h(paramString);
        AppMethodBeat.o(19987);
        return;
        localArrayList = new ArrayList();
        localObject1 = g.oK(-1).iterator();
        for (;;)
        {
          paramString = localArrayList;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          paramString = (String)((Iterator)localObject1).next();
          localObject2 = new d.a((byte)0);
          ((d.a)localObject2).userName = paramString;
          ((d.a)localObject2).dOS = g.Eo(paramString);
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
    paramNotification = this.goc.a(paramNotification, paramInt1, paramInt2, paramPendingIntent, paramString1, paramString2, paramString3, paramBitmap, paramString4);
    AppMethodBeat.o(19986);
    return paramNotification;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.notification.f
 * JD-Core Version:    0.7.0.1
 */