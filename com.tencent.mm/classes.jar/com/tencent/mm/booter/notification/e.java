package com.tencent.mm.booter.notification;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.aa;
import com.tencent.mm.booter.notification.queue.b;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public final class e
  extends a
{
  public c djB = new c();
  private Context mContext = ae.getContext();
  private NotificationManager yz = (NotificationManager)this.mContext.getSystemService("notification");
  
  public static void cancel()
  {
    aa localaa = aa.L(ae.getContext());
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = b.wz().wB().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if (!localLinkedList.contains(localInteger))
      {
        b.wz().a(localaa, localInteger.intValue());
        localLinkedList.add(localInteger);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.notification.e
 * JD-Core Version:    0.7.0.1
 */