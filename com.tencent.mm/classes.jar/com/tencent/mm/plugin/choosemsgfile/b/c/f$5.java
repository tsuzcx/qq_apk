package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.choosemsgfile.b.b.c;
import com.tencent.mm.plugin.choosemsgfile.b.d.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

final class f$5
  implements Runnable
{
  f$5(f paramf, String paramString1, String paramString2, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(54367);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = ((j)g.E(j.class)).bPQ().cG(this.kFK.eaX, this.kFK.Fb);
    if (localCursor == null)
    {
      ab.e("MicroMsg.ChooseMsgFileUIController", "[loadData] NULL == cursor ");
      AppMethodBeat.o(54367);
      return;
    }
    long l1 = 0L;
    label723:
    for (;;)
    {
      Object localObject2;
      long l2;
      try
      {
        Object localObject4;
        if (localCursor.moveToNext())
        {
          f.b(this.kFK);
          localObject2 = new bi();
          ((bi)localObject2).convertFrom(localCursor);
          localObject3 = b.a(this.kFK.kFG, (bi)localObject2, this.kFK.eaX, this.iaF, this.kFB);
          if (localObject3 == null) {
            break label723;
          }
          localObject4 = new Date(((dd)localObject2).field_createTime);
          l2 = com.tencent.mm.ui.gridviewheaders.a.dNj().b((Date)localObject4);
          if (l1 != l2)
          {
            localLinkedList.add(new c(this.kFK.kFG, ((dd)localObject2).field_createTime));
            f.c(this.kFK);
          }
          localLinkedList.add(localObject3);
          l1 = l2;
          continue;
        }
        localCursor.close();
        localObject2 = new LinkedList();
        if (localLinkedList.size() - this.kFK.kFJ != 200) {
          break label614;
        }
        l1 = ((com.tencent.mm.plugin.choosemsgfile.b.b.a)localLinkedList.get(0)).getTimeStamp();
        com.tencent.mm.ui.gridviewheaders.a.dNj();
        l2 = com.tencent.mm.ui.gridviewheaders.a.oS(l1);
        ab.i("MicroMsg.ChooseMsgFileUIController", "[loadData] list size:%s start:%s end:%s", new Object[] { Integer.valueOf(localLinkedList.size()), Long.valueOf(l2), Long.valueOf(l1) });
        localCursor = ((j)g.E(j.class)).bPQ().x(this.kFK.eaX, l2, l1);
        Object localObject3 = new Date(l1);
        l1 = com.tencent.mm.ui.gridviewheaders.a.dNj().b((Date)localObject3);
        if (localCursor == null) {
          break label602;
        }
        try
        {
          if (!localCursor.moveToNext()) {
            break label602;
          }
          f.b(this.kFK);
          localObject4 = new bi();
          ((bi)localObject4).convertFrom(localCursor);
          com.tencent.mm.plugin.choosemsgfile.b.b.a locala = b.a(this.kFK.kFG, (bi)localObject4, this.kFK.eaX, this.iaF, this.kFB);
          if (locala == null) {
            continue;
          }
          Date localDate = new Date(((dd)localObject4).field_createTime);
          l2 = com.tencent.mm.ui.gridviewheaders.a.dNj().b(localDate);
          if ((l1 != l2) && (com.tencent.mm.ui.gridviewheaders.a.dNj().b((Date)localObject3) != l2))
          {
            ((LinkedList)localObject2).add(new c(this.kFK.kFG, ((dd)localObject4).field_createTime));
            f.c(this.kFK);
            ((LinkedList)localObject2).add(locala);
            l1 = l2;
            continue;
          }
        }
        finally
        {
          if (localCursor == null) {}
        }
        l2 = l1;
      }
      finally
      {
        localCursor.close();
        AppMethodBeat.o(54367);
      }
      if (localCollection.size() > 0)
      {
        l2 = l1;
        if (((LinkedList)localObject2).size() == 0)
        {
          ((LinkedList)localObject2).add(0, localCollection.remove(0));
          l2 = l1;
          continue;
          label602:
          if (localCursor != null) {
            localCursor.close();
          }
          label614:
          int i = localCollection.size();
          int j = ((LinkedList)localObject2).size();
          this.kFK.iVH.addAll(0, (Collection)localObject2);
          this.kFK.iVH.addAll(((LinkedList)localObject2).size(), localCollection);
          localCollection.clear();
          ((LinkedList)localObject2).clear();
          this.kFK.kFJ = 0;
          ab.i("MicroMsg.ChooseMsgFileUIController", "[loadData] %s", new Object[] { Integer.valueOf(this.kFK.iVH.size()) });
          al.d(new f.5.1(this, i + j));
          AppMethodBeat.o(54367);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.c.f.5
 * JD-Core Version:    0.7.0.1
 */