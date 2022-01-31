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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public final class e
  extends a
{
  public c eaV;
  private Context mContext;
  private NotificationManager zb;
  
  public e()
  {
    AppMethodBeat.i(15951);
    this.mContext = ah.getContext();
    this.zb = ((NotificationManager)this.mContext.getSystemService("notification"));
    this.eaV = new c();
    AppMethodBeat.o(15951);
  }
  
  public static void cancel()
  {
    AppMethodBeat.i(15952);
    v localv = v.K(ah.getContext());
    LinkedList localLinkedList = new LinkedList();
    Object localObject = b.IO().IQ();
    StringBuilder localStringBuilder = new StringBuilder();
    localObject = ((Queue)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      localStringBuilder.append(localInteger + ";");
      if (!localLinkedList.contains(localInteger))
      {
        b.IO().a(localv, localInteger.intValue());
        localLinkedList.add(localInteger);
      }
    }
    ab.i("MicroMsg.Notification.Handle", "needRemoveNotificationId:%s", new Object[] { localStringBuilder });
    AppMethodBeat.o(15952);
  }
  
  public static void n(int paramInt, String paramString)
  {
    AppMethodBeat.i(15955);
    ab.i("MicroMsg.Notification.AppMsg.Handle", "refreshTotalUnread, %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    int i = paramInt;
    if (paramInt == -1) {
      i = f.Nm();
    }
    c.ij(i);
    ArrayList localArrayList;
    if ((paramString != null) && (paramString.length() > 0))
    {
      localArrayList = c.IK();
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
        ((c.a)localObject2).eaG = f.ly(paramString);
        if ((((c.a)localObject2).eaG == 0) && (localArrayList.isEmpty()))
        {
          c.e(null);
          AppMethodBeat.o(15955);
          return;
        }
        paramString = localArrayList;
        if (((c.a)localObject2).eaG > 0)
        {
          localArrayList.add(localObject2);
          paramString = localArrayList;
        }
        c.e(paramString);
        AppMethodBeat.o(15955);
        return;
        localArrayList = new ArrayList();
        localObject1 = f.Nl();
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
          ((c.a)localObject2).eaG = f.ly(paramString);
          localArrayList.add(localObject2);
        }
        localObject1 = null;
      }
    }
  }
  
  public final int a(NotificationItem paramNotificationItem)
  {
    AppMethodBeat.i(15953);
    if (paramNotificationItem == null)
    {
      AppMethodBeat.o(15953);
      return -1;
    }
    int i = a(paramNotificationItem, null);
    AppMethodBeat.o(15953);
    return i;
  }
  
  @TargetApi(11)
  public final Notification a(Notification paramNotification, int paramInt1, int paramInt2, PendingIntent paramPendingIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4)
  {
    AppMethodBeat.i(15954);
    paramNotification = this.eaV.a(paramNotification, paramInt1, paramInt2, paramPendingIntent, paramString1, paramString2, paramString3, paramBitmap, paramString4);
    AppMethodBeat.o(15954);
    return paramNotification;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.notification.e
 * JD-Core Version:    0.7.0.1
 */