package com.tencent.mm.booter.notification.queue;

import android.support.v4.app.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public final class b
  implements Iterable<NotificationItem>
{
  public NotificationQueue foP;
  public a foQ;
  public int mark;
  
  private b()
  {
    AppMethodBeat.i(20022);
    this.mark = -1;
    this.foP = new NotificationQueue();
    this.foQ = new a();
    restore();
    AppMethodBeat.o(20022);
  }
  
  public static final b UX()
  {
    AppMethodBeat.i(20021);
    b localb = a.Vb();
    AppMethodBeat.o(20021);
    return localb;
  }
  
  private Queue<Integer> Va()
  {
    AppMethodBeat.i(20027);
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    Object localObject1 = this.foP;
    if (((NotificationQueue)localObject1).foO == null) {
      ((NotificationQueue)localObject1).restore();
    }
    localLinkedList2.addAll(((NotificationQueue)localObject1).foO);
    localObject1 = localLinkedList2.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (NotificationItem)((Iterator)localObject1).next();
      if (((NotificationItem)localObject2).foH)
      {
        localLinkedList1.add(Integer.valueOf(((NotificationItem)localObject2).id));
        ac.d("MicroMsg.Notification.Queue", "remove allcustom: %d", new Object[] { Integer.valueOf(((NotificationItem)localObject2).id) });
      }
    }
    localLinkedList2.clear();
    localLinkedList2 = new LinkedList();
    localObject1 = this.foQ;
    if (((a)localObject1).foM == null) {
      ((a)localObject1).restore();
    }
    localLinkedList2.addAll(((a)localObject1).foM);
    localObject1 = localLinkedList2.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a.a)((Iterator)localObject1).next();
      if (((a.a)localObject2).foH)
      {
        localLinkedList1.add(Integer.valueOf(((a.a)localObject2).notificationId));
        ac.d("MicroMsg.Notification.Queue", "remove allcustom: %d", new Object[] { Integer.valueOf(((a.a)localObject2).notificationId) });
      }
    }
    localLinkedList2.clear();
    AppMethodBeat.o(20027);
    return localLinkedList1;
  }
  
  public final NotificationItem UY()
  {
    AppMethodBeat.i(20025);
    int i = 0;
    Object localObject;
    if (i < this.foP.size())
    {
      localObject = this.foP;
      if (((NotificationQueue)localObject).foO == null) {
        ((NotificationQueue)localObject).restore();
      }
      localObject = (NotificationItem)((NotificationQueue)localObject).foO.get(i);
      if (((NotificationItem)localObject).foH)
      {
        if (this.foQ.remove(((NotificationItem)localObject).id)) {
          ac.d("MicroMsg.NotificationAppMsgQueue", "remove: [%s]", new Object[] { ((NotificationItem)localObject).toString() });
        }
        this.foP.d((NotificationItem)localObject);
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
  
  public final Queue<Integer> UZ()
  {
    AppMethodBeat.i(20026);
    LinkedList localLinkedList = new LinkedList();
    int i = 4097;
    while (i < 4102)
    {
      localLinkedList.add(Integer.valueOf(i));
      i += 1;
    }
    localLinkedList.addAll(Va());
    AppMethodBeat.o(20026);
    return localLinkedList;
  }
  
  public final void a(v paramv, int paramInt)
  {
    AppMethodBeat.i(20030);
    if (paramv == null)
    {
      ac.e("MicroMsg.Notification.Queue", "manager is null???");
      AppMethodBeat.o(20030);
      return;
    }
    paramv.cancel(paramInt);
    kw(paramInt);
    AppMethodBeat.o(20030);
  }
  
  public final void cancel(int paramInt)
  {
    AppMethodBeat.i(20029);
    a(v.N(ai.getContext()), paramInt);
    AppMethodBeat.o(20029);
  }
  
  public final int getId(String paramString)
  {
    AppMethodBeat.i(20028);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(20028);
      return -1;
    }
    Iterator localIterator = this.foQ.iterator();
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
    Object localObject = this.foP;
    if (((NotificationQueue)localObject).foO == null) {
      ((NotificationQueue)localObject).restore();
    }
    localObject = ((NotificationQueue)localObject).foO.iterator();
    AppMethodBeat.o(20033);
    return localObject;
  }
  
  public final void kw(int paramInt)
  {
    AppMethodBeat.i(20024);
    this.foQ.remove(paramInt);
    NotificationItem localNotificationItem = this.foP.kv(paramInt);
    if (localNotificationItem != null) {
      localNotificationItem.clear();
    }
    AppMethodBeat.o(20024);
  }
  
  public final int o(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(20032);
    long l = System.currentTimeMillis();
    Iterator localIterator = this.foQ.iterator();
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
    if (!bs.isNullOrNil(paramString))
    {
      i = j;
      if (paramBoolean) {
        i = paramString.hashCode();
      }
    }
    ac.d("MicroMsg.Notification.Queue", "create id spend: %d, id: %d, isCustomControl: %B", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i), Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(20032);
    return i;
  }
  
  public final int rC(String paramString)
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
  
  public final void restore()
  {
    AppMethodBeat.i(20023);
    this.foP.restore();
    this.foQ.restore();
    AppMethodBeat.o(20023);
  }
  
  static final class a
  {
    private static final b foR;
    
    static
    {
      AppMethodBeat.i(20020);
      foR = new b((byte)0);
      AppMethodBeat.o(20020);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.notification.queue.b
 * JD-Core Version:    0.7.0.1
 */