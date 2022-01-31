package com.tencent.mm.plugin.ipcall.a;

import android.database.Cursor;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.ipcall.a.g.d;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class a$1
  extends ah
{
  a$1(a parama, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    long l1 = System.currentTimeMillis();
    Object localObject1 = i.bcm();
    Object localObject2 = (ArrayList)paramMessage.obj;
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      long l2 = ((d)localObject1).eV(Thread.currentThread().getId());
      y.i("MicroMsg.IPCallAddressStorage", "getContactIdMap start");
      Object localObject3 = ((d)localObject1).dXw.a("IPCallAddressItem", new String[] { "contactId" }, null, null, null, null, null, 2);
      paramMessage = new HashMap();
      if ((localObject3 != null) && (((Cursor)localObject3).moveToFirst())) {
        do
        {
          String str = ((Cursor)localObject3).getString(0);
          if (!paramMessage.containsKey(str)) {
            paramMessage.put(str, Boolean.valueOf(true));
          }
        } while (((Cursor)localObject3).moveToNext());
      }
      if (localObject3 != null) {
        ((Cursor)localObject3).close();
      }
      y.i("MicroMsg.IPCallAddressStorage", "getContactIdMap end");
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (com.tencent.mm.plugin.ipcall.a.g.c)((Iterator)localObject2).next();
        if (!paramMessage.containsKey(((com.tencent.mm.plugin.ipcall.a.g.c)localObject3).field_contactId)) {
          ((d)localObject1).b((com.tencent.mm.sdk.e.c)localObject3);
        }
      }
      ((d)localObject1).eW(l2);
    }
    y.d("MicroMsg.IPCallAddressBookLoader", "batchInsert, used %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    a.a(this.lov, System.currentTimeMillis());
    y.d("MicroMsg.IPCallAddressBookLoader", "loadAllAddressItem, used: %dms", new Object[] { Long.valueOf(a.a(this.lov) - a.b(this.lov)) });
    a.c(this.lov);
    a.a(this.lov, -1L);
    a.d(this.lov);
    paramMessage = this.lov.lot.iterator();
    while (paramMessage.hasNext())
    {
      localObject1 = (a.a)paramMessage.next();
      if (localObject1 != null) {
        ((a.a)localObject1).aog();
      }
    }
    this.lov.lot.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.a.1
 * JD-Core Version:    0.7.0.1
 */