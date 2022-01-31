package com.tencent.mm.booter.notification.queue;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.app.aa;
import android.support.v4.app.aa.a;
import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public final class b
  implements Iterable<NotificationItem>
{
  public NotificationQueue djP = new NotificationQueue();
  public a djQ = new a();
  public int mark = -1;
  
  private b()
  {
    restore();
  }
  
  private Queue<Integer> wC()
  {
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    Object localObject1 = this.djP;
    if (((NotificationQueue)localObject1).djO == null) {
      ((NotificationQueue)localObject1).restore();
    }
    localLinkedList2.addAll(((NotificationQueue)localObject1).djO);
    localObject1 = localLinkedList2.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (NotificationItem)((Iterator)localObject1).next();
      if (((NotificationItem)localObject2).djG)
      {
        localLinkedList1.add(Integer.valueOf(((NotificationItem)localObject2).id));
        y.d("MicroMsg.Notification.Queue", "remove allcustom: %d", new Object[] { Integer.valueOf(((NotificationItem)localObject2).id) });
      }
    }
    localLinkedList2.clear();
    localLinkedList2 = new LinkedList();
    localObject1 = this.djQ;
    if (((a)localObject1).djL == null) {
      ((a)localObject1).restore();
    }
    localLinkedList2.addAll(((a)localObject1).djL);
    localObject1 = localLinkedList2.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a.a)((Iterator)localObject1).next();
      if (((a.a)localObject2).djG)
      {
        localLinkedList1.add(Integer.valueOf(((a.a)localObject2).djM));
        y.d("MicroMsg.Notification.Queue", "remove allcustom: %d", new Object[] { Integer.valueOf(((a.a)localObject2).djM) });
      }
    }
    localLinkedList2.clear();
    return localLinkedList1;
  }
  
  public static final b wz()
  {
    return b.a.wD();
  }
  
  public final void a(aa paramaa, int paramInt)
  {
    paramaa.yz.cancel(null, paramInt);
    if (Build.VERSION.SDK_INT <= 19) {
      paramaa.a(new aa.a(paramaa.mContext.getPackageName(), paramInt));
    }
    remove(paramInt);
  }
  
  public final void cancel(int paramInt)
  {
    a(aa.L(ae.getContext()), paramInt);
  }
  
  public final int ez(String paramString)
  {
    int i = getId(paramString);
    if (i > 0) {
      return i;
    }
    return l(paramString, true);
  }
  
  public final int getId(String paramString)
  {
    if (bk.bl(paramString)) {
      return -1;
    }
    Iterator localIterator = this.djQ.iterator();
    while (localIterator.hasNext())
    {
      a.a locala = (a.a)localIterator.next();
      if (locala.userName.equals(paramString)) {
        return locala.djM;
      }
    }
    return -1;
  }
  
  public final Iterator<NotificationItem> iterator()
  {
    NotificationQueue localNotificationQueue = this.djP;
    if (localNotificationQueue.djO == null) {
      localNotificationQueue.restore();
    }
    return localNotificationQueue.djO.iterator();
  }
  
  public final int l(String paramString, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    Iterator localIterator = this.djQ.iterator();
    a.a locala;
    for (String str = ""; localIterator.hasNext(); str = str + locala.djM + ",") {
      locala = (a.a)localIterator.next();
    }
    if (paramBoolean) {
      i = 4097;
    }
    while (str.contains(String.valueOf(i)))
    {
      i += 1;
      continue;
      i = 4102;
    }
    int j = i;
    if (i >= 4102)
    {
      j = i;
      if (paramBoolean) {
        j = 4097;
      }
    }
    int i = j;
    if (!bk.bl(paramString))
    {
      i = j;
      if (paramBoolean) {
        i = paramString.hashCode();
      }
    }
    y.d("MicroMsg.Notification.Queue", "create id spend: %d, id: %d, isCustomControl: %B", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i), Boolean.valueOf(paramBoolean) });
    return i;
  }
  
  public final void remove(int paramInt)
  {
    this.djQ.bu(paramInt);
    NotificationItem localNotificationItem = this.djP.fY(paramInt);
    if (localNotificationItem != null) {
      localNotificationItem.clear();
    }
  }
  
  public final void restore()
  {
    this.djP.restore();
    this.djQ.restore();
  }
  
  public final int size()
  {
    NotificationQueue localNotificationQueue = this.djP;
    if (localNotificationQueue.djO == null) {
      localNotificationQueue.restore();
    }
    return localNotificationQueue.djO.size();
  }
  
  public final NotificationItem wA()
  {
    int i = 0;
    while (i < size())
    {
      Object localObject = this.djP;
      if (((NotificationQueue)localObject).djO == null) {
        ((NotificationQueue)localObject).restore();
      }
      localObject = (NotificationItem)((NotificationQueue)localObject).djO.get(i);
      if (((NotificationItem)localObject).djG)
      {
        if (this.djQ.bu(((NotificationItem)localObject).id)) {
          y.d("MicroMsg.NotificationAppMsgQueue", "remove: [%s]", new Object[] { ((NotificationItem)localObject).toString() });
        }
        this.djP.c((NotificationItem)localObject);
        return localObject;
      }
      i += 1;
    }
    return null;
  }
  
  public final Queue<Integer> wB()
  {
    LinkedList localLinkedList = new LinkedList();
    int i = 4097;
    while (i < 4102)
    {
      localLinkedList.add(Integer.valueOf(i));
      i += 1;
    }
    localLinkedList.addAll(wC());
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.notification.queue.b
 * JD-Core Version:    0.7.0.1
 */