package com.tencent.mm.booter.notification;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f
{
  public e djJ = new e();
  
  public static boolean a(String paramString, bi parambi, int paramInt, boolean paramBoolean)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    return c.a(paramString, parambi, paramInt, paramBoolean);
  }
  
  public static void k(int paramInt, String paramString)
  {
    y.i("MicroMsg.Notification.AppMsg.Handle", "refreshTotalUnread, %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    int i = paramInt;
    if (paramInt == -1) {
      i = com.tencent.mm.m.f.Ax();
    }
    c.fV(i);
    ArrayList localArrayList;
    if ((paramString != null) && (paramString.length() > 0))
    {
      localArrayList = c.wv();
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
        ((c.a)localObject2).djo = com.tencent.mm.m.f.fl(paramString);
        if ((((c.a)localObject2).djo == 0) && (localArrayList.isEmpty()))
        {
          c.e(null);
          return;
        }
        paramString = localArrayList;
        if (((c.a)localObject2).djo > 0)
        {
          localArrayList.add(localObject2);
          paramString = localArrayList;
        }
        c.e(paramString);
        return;
        localArrayList = new ArrayList();
        localObject1 = com.tencent.mm.m.f.Aw();
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
          ((c.a)localObject2).djo = com.tencent.mm.m.f.fl(paramString);
          localArrayList.add(localObject2);
        }
        localObject1 = null;
      }
    }
  }
  
  public final int a(NotificationItem paramNotificationItem)
  {
    return this.djJ.a(paramNotificationItem, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.notification.f
 * JD-Core Version:    0.7.0.1
 */