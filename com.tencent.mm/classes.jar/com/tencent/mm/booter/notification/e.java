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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public final class e
  extends a
{
  private NotificationManager Gu;
  public c foC;
  private Context mContext;
  
  public e()
  {
    AppMethodBeat.i(19983);
    this.mContext = ai.getContext();
    this.Gu = ((NotificationManager)this.mContext.getSystemService("notification"));
    this.foC = new c();
    AppMethodBeat.o(19983);
  }
  
  public static void cancel()
  {
    AppMethodBeat.i(19984);
    v localv = v.N(ai.getContext());
    LinkedList localLinkedList = new LinkedList();
    Object localObject = b.UX().UZ();
    StringBuilder localStringBuilder = new StringBuilder();
    localObject = ((Queue)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      localStringBuilder.append(localInteger + ";");
      if (!localLinkedList.contains(localInteger))
      {
        b.UX().a(localv, localInteger.intValue());
        localLinkedList.add(localInteger);
      }
    }
    ac.i("MicroMsg.Notification.Handle", "needRemoveNotificationId:%s", new Object[] { localStringBuilder });
    AppMethodBeat.o(19984);
  }
  
  public static void p(int paramInt, String paramString)
  {
    AppMethodBeat.i(19987);
    ac.i("MicroMsg.Notification.AppMsg.Handle", "refreshTotalUnread, %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    int i = paramInt;
    if (paramInt == -1) {
      i = f.ZV();
    }
    c.ks(i);
    ArrayList localArrayList;
    if ((paramString != null) && (paramString.length() > 0))
    {
      localArrayList = c.UT();
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
        ((c.a)localObject2).dkt = f.sO(paramString);
        if ((((c.a)localObject2).dkt == 0) && (localArrayList.isEmpty()))
        {
          c.f(null);
          AppMethodBeat.o(19987);
          return;
        }
        paramString = localArrayList;
        if (((c.a)localObject2).dkt > 0)
        {
          localArrayList.add(localObject2);
          paramString = localArrayList;
        }
        c.f(paramString);
        AppMethodBeat.o(19987);
        return;
        localArrayList = new ArrayList();
        localObject1 = f.lg(-1).iterator();
        for (;;)
        {
          paramString = localArrayList;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          paramString = (String)((Iterator)localObject1).next();
          localObject2 = new c.a((byte)0);
          ((c.a)localObject2).userName = paramString;
          ((c.a)localObject2).dkt = f.sO(paramString);
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
    paramNotification = this.foC.a(paramNotification, paramInt1, paramInt2, paramPendingIntent, paramString1, paramString2, paramString3, paramBitmap, paramString4);
    AppMethodBeat.o(19986);
    return paramNotification;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.notification.e
 * JD-Core Version:    0.7.0.1
 */