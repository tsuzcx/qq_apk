package com.tencent.mm.booter.notification.queue;

import android.support.v4.app.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public final class b
  implements Iterable<NotificationItem>
{
  public NotificationQueue ebj;
  public a ebk;
  public int mark;
  
  private b()
  {
    AppMethodBeat.i(15990);
    this.mark = -1;
    this.ebj = new NotificationQueue();
    this.ebk = new a();
    restore();
    AppMethodBeat.o(15990);
  }
  
  public static final b IO()
  {
    AppMethodBeat.i(15989);
    b localb = a.IS();
    AppMethodBeat.o(15989);
    return localb;
  }
  
  private Queue<Integer> IR()
  {
    AppMethodBeat.i(15995);
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    Object localObject1 = this.ebj;
    if (((NotificationQueue)localObject1).ebi == null) {
      ((NotificationQueue)localObject1).restore();
    }
    localLinkedList2.addAll(((NotificationQueue)localObject1).ebi);
    localObject1 = localLinkedList2.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (NotificationItem)((Iterator)localObject1).next();
      if (((NotificationItem)localObject2).eba)
      {
        localLinkedList1.add(Integer.valueOf(((NotificationItem)localObject2).id));
        ab.d("MicroMsg.Notification.Queue", "remove allcustom: %d", new Object[] { Integer.valueOf(((NotificationItem)localObject2).id) });
      }
    }
    localLinkedList2.clear();
    localLinkedList2 = new LinkedList();
    localObject1 = this.ebk;
    if (((a)localObject1).ebf == null) {
      ((a)localObject1).restore();
    }
    localLinkedList2.addAll(((a)localObject1).ebf);
    localObject1 = localLinkedList2.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a.a)((Iterator)localObject1).next();
      if (((a.a)localObject2).eba)
      {
        localLinkedList1.add(Integer.valueOf(((a.a)localObject2).ebg));
        ab.d("MicroMsg.Notification.Queue", "remove allcustom: %d", new Object[] { Integer.valueOf(((a.a)localObject2).ebg) });
      }
    }
    localLinkedList2.clear();
    AppMethodBeat.o(15995);
    return localLinkedList1;
  }
  
  public final NotificationItem IP()
  {
    AppMethodBeat.i(15993);
    int i = 0;
    Object localObject;
    if (i < this.ebj.size())
    {
      localObject = this.ebj;
      if (((NotificationQueue)localObject).ebi == null) {
        ((NotificationQueue)localObject).restore();
      }
      localObject = (NotificationItem)((NotificationQueue)localObject).ebi.get(i);
      if (((NotificationItem)localObject).eba)
      {
        if (this.ebk.bu(((NotificationItem)localObject).id)) {
          ab.d("MicroMsg.NotificationAppMsgQueue", "remove: [%s]", new Object[] { ((NotificationItem)localObject).toString() });
        }
        this.ebj.d((NotificationItem)localObject);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(15993);
      return localObject;
      i += 1;
      break;
      localObject = null;
    }
  }
  
  public final Queue<Integer> IQ()
  {
    AppMethodBeat.i(15994);
    LinkedList localLinkedList = new LinkedList();
    int i = 4097;
    while (i < 4102)
    {
      localLinkedList.add(Integer.valueOf(i));
      i += 1;
    }
    localLinkedList.addAll(IR());
    AppMethodBeat.o(15994);
    return localLinkedList;
  }
  
  public final void a(v paramv, int paramInt)
  {
    AppMethodBeat.i(15998);
    paramv.cancel(paramInt);
    in(paramInt);
    AppMethodBeat.o(15998);
  }
  
  public final void cancel(int paramInt)
  {
    AppMethodBeat.i(15997);
    a(v.K(ah.getContext()), paramInt);
    AppMethodBeat.o(15997);
  }
  
  public final int getId(String paramString)
  {
    AppMethodBeat.i(15996);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(15996);
      return -1;
    }
    Iterator localIterator = this.ebk.iterator();
    while (localIterator.hasNext())
    {
      a.a locala = (a.a)localIterator.next();
      if (locala.userName.equals(paramString))
      {
        int i = locala.ebg;
        AppMethodBeat.o(15996);
        return i;
      }
    }
    AppMethodBeat.o(15996);
    return -1;
  }
  
  public final void in(int paramInt)
  {
    AppMethodBeat.i(15992);
    this.ebk.bu(paramInt);
    NotificationItem localNotificationItem = this.ebj.im(paramInt);
    if (localNotificationItem != null) {
      localNotificationItem.clear();
    }
    AppMethodBeat.o(15992);
  }
  
  public final Iterator<NotificationItem> iterator()
  {
    AppMethodBeat.i(16001);
    Object localObject = this.ebj;
    if (((NotificationQueue)localObject).ebi == null) {
      ((NotificationQueue)localObject).restore();
    }
    localObject = ((NotificationQueue)localObject).ebi.iterator();
    AppMethodBeat.o(16001);
    return localObject;
  }
  
  public final int kE(String paramString)
  {
    AppMethodBeat.i(15999);
    int i = getId(paramString);
    if (i > 0)
    {
      AppMethodBeat.o(15999);
      return i;
    }
    i = o(paramString, true);
    AppMethodBeat.o(15999);
    return i;
  }
  
  public final int o(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(16000);
    long l = System.currentTimeMillis();
    Iterator localIterator = this.ebk.iterator();
    a.a locala;
    for (String str = ""; localIterator.hasNext(); str = str + locala.ebg + ",") {
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
    if (!bo.isNullOrNil(paramString))
    {
      i = j;
      if (paramBoolean) {
        i = paramString.hashCode();
      }
    }
    ab.d("MicroMsg.Notification.Queue", "create id spend: %d, id: %d, isCustomControl: %B", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i), Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(16000);
    return i;
  }
  
  public final void restore()
  {
    AppMethodBeat.i(15991);
    this.ebj.restore();
    this.ebk.restore();
    AppMethodBeat.o(15991);
  }
  
  static final class a
  {
    private static final b ebl;
    
    static
    {
      AppMethodBeat.i(15988);
      ebl = new b((byte)0);
      AppMethodBeat.o(15988);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.notification.queue.b
 * JD-Core Version:    0.7.0.1
 */