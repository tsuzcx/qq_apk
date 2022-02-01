package com.tencent.mm.booter.notification.queue;

import androidx.core.app.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public final class b
  implements Iterable<NotificationItem>
{
  public a iSA;
  public int iSy;
  public NotificationQueue iSz;
  
  private b()
  {
    AppMethodBeat.i(20022);
    this.iSy = -1;
    this.iSz = new NotificationQueue();
    this.iSA = new a();
    restore();
    AppMethodBeat.o(20022);
  }
  
  public static final b arh()
  {
    AppMethodBeat.i(20021);
    b localb = a.arl();
    AppMethodBeat.o(20021);
    return localb;
  }
  
  private Queue<Integer> ark()
  {
    AppMethodBeat.i(20027);
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    Object localObject1 = this.iSz;
    if (((NotificationQueue)localObject1).iSx == null) {
      ((NotificationQueue)localObject1).restore();
    }
    localLinkedList2.addAll(((NotificationQueue)localObject1).iSx);
    localObject1 = localLinkedList2.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (NotificationItem)((Iterator)localObject1).next();
      if (((NotificationItem)localObject2).iSq)
      {
        localLinkedList1.add(Integer.valueOf(((NotificationItem)localObject2).id));
        Log.d("MicroMsg.Notification.Queue", "remove allcustom: %d", new Object[] { Integer.valueOf(((NotificationItem)localObject2).id) });
      }
    }
    localLinkedList2.clear();
    localLinkedList2 = new LinkedList();
    localObject1 = this.iSA;
    if (((a)localObject1).iSv == null) {
      ((a)localObject1).restore();
    }
    localLinkedList2.addAll(((a)localObject1).iSv);
    localObject1 = localLinkedList2.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a.a)((Iterator)localObject1).next();
      if (((a.a)localObject2).iSq)
      {
        localLinkedList1.add(Integer.valueOf(((a.a)localObject2).notificationId));
        Log.d("MicroMsg.Notification.Queue", "remove allcustom: %d", new Object[] { Integer.valueOf(((a.a)localObject2).notificationId) });
      }
    }
    localLinkedList2.clear();
    AppMethodBeat.o(20027);
    return localLinkedList1;
  }
  
  public final int JR(String paramString)
  {
    AppMethodBeat.i(20031);
    int i = getId(paramString);
    if (i > 0)
    {
      AppMethodBeat.o(20031);
      return i;
    }
    i = r(paramString, true);
    AppMethodBeat.o(20031);
    return i;
  }
  
  public final void a(h paramh, int paramInt)
  {
    AppMethodBeat.i(199068);
    if (paramh == null)
    {
      Log.e("MicroMsg.Notification.Queue", "manager is null???");
      AppMethodBeat.o(199068);
      return;
    }
    paramh.cancel(paramInt);
    qm(paramInt);
    AppMethodBeat.o(199068);
  }
  
  public final NotificationItem ari()
  {
    AppMethodBeat.i(20025);
    int i = 0;
    Object localObject;
    if (i < this.iSz.size())
    {
      localObject = this.iSz;
      if (((NotificationQueue)localObject).iSx == null) {
        ((NotificationQueue)localObject).restore();
      }
      localObject = (NotificationItem)((NotificationQueue)localObject).iSx.get(i);
      if (((NotificationItem)localObject).iSq)
      {
        if (this.iSA.remove(((NotificationItem)localObject).id)) {
          Log.d("MicroMsg.NotificationAppMsgQueue", "remove: [%s]", new Object[] { ((NotificationItem)localObject).toString() });
        }
        this.iSz.d((NotificationItem)localObject);
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
  
  public final Queue<Integer> arj()
  {
    AppMethodBeat.i(20026);
    LinkedList localLinkedList = new LinkedList();
    int i = 4097;
    while (i < 4102)
    {
      localLinkedList.add(Integer.valueOf(i));
      i += 1;
    }
    localLinkedList.addAll(ark());
    AppMethodBeat.o(20026);
    return localLinkedList;
  }
  
  public final void cancel(int paramInt)
  {
    AppMethodBeat.i(20029);
    a(h.M(MMApplicationContext.getContext()), paramInt);
    AppMethodBeat.o(20029);
  }
  
  public final int getId(String paramString)
  {
    AppMethodBeat.i(20028);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(20028);
      return -1;
    }
    Iterator localIterator = this.iSA.iterator();
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
    Object localObject = this.iSz;
    if (((NotificationQueue)localObject).iSx == null) {
      ((NotificationQueue)localObject).restore();
    }
    localObject = ((NotificationQueue)localObject).iSx.iterator();
    AppMethodBeat.o(20033);
    return localObject;
  }
  
  public final void qm(int paramInt)
  {
    AppMethodBeat.i(20024);
    this.iSA.remove(paramInt);
    NotificationItem localNotificationItem = this.iSz.ql(paramInt);
    if (localNotificationItem != null) {
      localNotificationItem.clear();
    }
    AppMethodBeat.o(20024);
  }
  
  public final int r(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(20032);
    long l = System.currentTimeMillis();
    Iterator localIterator = this.iSA.iterator();
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
    if (!Util.isNullOrNil(paramString))
    {
      i = j;
      if (paramBoolean) {
        i = paramString.hashCode();
      }
    }
    Log.d("MicroMsg.Notification.Queue", "create id spend: %d, id: %d, isCustomControl: %B", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i), Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(20032);
    return i;
  }
  
  public final void restore()
  {
    AppMethodBeat.i(20023);
    this.iSz.restore();
    this.iSA.restore();
    AppMethodBeat.o(20023);
  }
  
  static final class a
  {
    private static final b iSB;
    
    static
    {
      AppMethodBeat.i(20020);
      iSB = new b((byte)0);
      AppMethodBeat.o(20020);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.notification.queue.b
 * JD-Core Version:    0.7.0.1
 */