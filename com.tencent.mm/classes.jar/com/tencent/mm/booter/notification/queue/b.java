package com.tencent.mm.booter.notification.queue;

import android.support.v4.app.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public final class b
  implements Iterable<NotificationItem>
{
  public NotificationQueue fGX;
  public a fGY;
  public int mark;
  
  private b()
  {
    AppMethodBeat.i(20022);
    this.mark = -1;
    this.fGX = new NotificationQueue();
    this.fGY = new a();
    restore();
    AppMethodBeat.o(20022);
  }
  
  public static final b Xo()
  {
    AppMethodBeat.i(20021);
    b localb = a.Xs();
    AppMethodBeat.o(20021);
    return localb;
  }
  
  private Queue<Integer> Xr()
  {
    AppMethodBeat.i(20027);
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    Object localObject1 = this.fGX;
    if (((NotificationQueue)localObject1).fGW == null) {
      ((NotificationQueue)localObject1).restore();
    }
    localLinkedList2.addAll(((NotificationQueue)localObject1).fGW);
    localObject1 = localLinkedList2.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (NotificationItem)((Iterator)localObject1).next();
      if (((NotificationItem)localObject2).fGP)
      {
        localLinkedList1.add(Integer.valueOf(((NotificationItem)localObject2).id));
        ad.d("MicroMsg.Notification.Queue", "remove allcustom: %d", new Object[] { Integer.valueOf(((NotificationItem)localObject2).id) });
      }
    }
    localLinkedList2.clear();
    localLinkedList2 = new LinkedList();
    localObject1 = this.fGY;
    if (((a)localObject1).fGU == null) {
      ((a)localObject1).restore();
    }
    localLinkedList2.addAll(((a)localObject1).fGU);
    localObject1 = localLinkedList2.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a.a)((Iterator)localObject1).next();
      if (((a.a)localObject2).fGP)
      {
        localLinkedList1.add(Integer.valueOf(((a.a)localObject2).notificationId));
        ad.d("MicroMsg.Notification.Queue", "remove allcustom: %d", new Object[] { Integer.valueOf(((a.a)localObject2).notificationId) });
      }
    }
    localLinkedList2.clear();
    AppMethodBeat.o(20027);
    return localLinkedList1;
  }
  
  public final NotificationItem Xp()
  {
    AppMethodBeat.i(20025);
    int i = 0;
    Object localObject;
    if (i < this.fGX.size())
    {
      localObject = this.fGX;
      if (((NotificationQueue)localObject).fGW == null) {
        ((NotificationQueue)localObject).restore();
      }
      localObject = (NotificationItem)((NotificationQueue)localObject).fGW.get(i);
      if (((NotificationItem)localObject).fGP)
      {
        if (this.fGY.remove(((NotificationItem)localObject).id)) {
          ad.d("MicroMsg.NotificationAppMsgQueue", "remove: [%s]", new Object[] { ((NotificationItem)localObject).toString() });
        }
        this.fGX.d((NotificationItem)localObject);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(20025);
      return localObject;
      i += 1;
      break;
      localObject = null;
    }
  }
  
  public final Queue<Integer> Xq()
  {
    AppMethodBeat.i(20026);
    LinkedList localLinkedList = new LinkedList();
    int i = 4097;
    while (i < 4102)
    {
      localLinkedList.add(Integer.valueOf(i));
      i += 1;
    }
    localLinkedList.addAll(Xr());
    AppMethodBeat.o(20026);
    return localLinkedList;
  }
  
  public final void a(v paramv, int paramInt)
  {
    AppMethodBeat.i(20030);
    if (paramv == null)
    {
      ad.e("MicroMsg.Notification.Queue", "manager is null???");
      AppMethodBeat.o(20030);
      return;
    }
    paramv.cancel(paramInt);
    kT(paramInt);
    AppMethodBeat.o(20030);
  }
  
  public final void cancel(int paramInt)
  {
    AppMethodBeat.i(20029);
    a(v.N(aj.getContext()), paramInt);
    AppMethodBeat.o(20029);
  }
  
  public final int getId(String paramString)
  {
    AppMethodBeat.i(20028);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(20028);
      return -1;
    }
    Iterator localIterator = this.fGY.iterator();
    while (localIterator.hasNext())
    {
      a.a locala = (a.a)localIterator.next();
      if (locala.userName.equals(paramString))
      {
        int i = locala.notificationId;
        AppMethodBeat.o(20028);
        return i;
      }
    }
    AppMethodBeat.o(20028);
    return -1;
  }
  
  public final Iterator<NotificationItem> iterator()
  {
    AppMethodBeat.i(20033);
    Object localObject = this.fGX;
    if (((NotificationQueue)localObject).fGW == null) {
      ((NotificationQueue)localObject).restore();
    }
    localObject = ((NotificationQueue)localObject).fGW.iterator();
    AppMethodBeat.o(20033);
    return localObject;
  }
  
  public final void kT(int paramInt)
  {
    AppMethodBeat.i(20024);
    this.fGY.remove(paramInt);
    NotificationItem localNotificationItem = this.fGX.kS(paramInt);
    if (localNotificationItem != null) {
      localNotificationItem.clear();
    }
    AppMethodBeat.o(20024);
  }
  
  public final int o(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(20032);
    long l = System.currentTimeMillis();
    Iterator localIterator = this.fGY.iterator();
    a.a locala;
    for (String str = ""; localIterator.hasNext(); str = str + locala.notificationId + ",") {
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
    if (!bt.isNullOrNil(paramString))
    {
      i = j;
      if (paramBoolean) {
        i = paramString.hashCode();
      }
    }
    ad.d("MicroMsg.Notification.Queue", "create id spend: %d, id: %d, isCustomControl: %B", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i), Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(20032);
    return i;
  }
  
  public final void restore()
  {
    AppMethodBeat.i(20023);
    this.fGX.restore();
    this.fGY.restore();
    AppMethodBeat.o(20023);
  }
  
  public final int up(String paramString)
  {
    AppMethodBeat.i(20031);
    int i = getId(paramString);
    if (i > 0)
    {
      AppMethodBeat.o(20031);
      return i;
    }
    i = o(paramString, true);
    AppMethodBeat.o(20031);
    return i;
  }
  
  static final class a
  {
    private static final b fGZ;
    
    static
    {
      AppMethodBeat.i(20020);
      fGZ = new b((byte)0);
      AppMethodBeat.o(20020);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.notification.queue.b
 * JD-Core Version:    0.7.0.1
 */