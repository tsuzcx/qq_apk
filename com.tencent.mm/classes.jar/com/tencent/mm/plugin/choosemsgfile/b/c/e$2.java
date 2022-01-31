package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.choosemsgfile.b.b.i;
import com.tencent.mm.plugin.choosemsgfile.b.b.k;
import com.tencent.mm.plugin.choosemsgfile.b.d.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.gridviewheaders.a;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class e$2
  implements Runnable
{
  e$2(e parame, String paramString, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(54347);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = ((j)g.E(j.class)).bPQ().cE(this.kFx.eaX, -1);
    if (localCursor == null)
    {
      ab.e("MicroMsg.ChooseMsgFileListUIController", "[loadData] cursor is null!");
      AppMethodBeat.o(54347);
      return;
    }
    List localList = b.IX(this.kFB);
    long l1 = 0L;
    label390:
    for (;;)
    {
      try
      {
        if (localCursor.moveToNext())
        {
          bi localbi = new bi();
          localbi.convertFrom(localCursor);
          Object localObject2 = localbi.field_content;
          if (localObject2 == null) {
            break label390;
          }
          localObject2 = j.b.mY((String)localObject2);
          if ((localObject2 == null) || (((j.b)localObject2).type != 6)) {
            break label390;
          }
          localObject2 = new k(this.kFx.kFw, localbi, this.kFx.eaX);
          if (localList.size() == 0)
          {
            i = 1;
            if (i == 0) {
              continue;
            }
            localObject3 = new Date(localbi.field_createTime);
            long l2 = a.dNj().b((Date)localObject3);
            if (l1 != l2) {
              localLinkedList.add(new i(this.kFx.kFw, localbi.field_createTime));
            }
            localLinkedList.add(localObject2);
            l1 = l2;
            break label390;
          }
          Object localObject3 = localList.iterator();
          if (((Iterator)localObject3).hasNext())
          {
            String str = (String)((Iterator)localObject3).next();
            boolean bool = ((k)localObject2).getFileName().endsWith(str);
            if (!bool) {
              continue;
            }
            i = 1;
            continue;
          }
        }
        else
        {
          localCursor.close();
          this.kFx.jfV.addAll(localLinkedList);
          localLinkedList.clear();
          ab.i("MicroMsg.ChooseMsgFileListUIController", "[loadData] data:%s", new Object[] { Integer.valueOf(this.kFx.jfV.size()) });
          al.d(new e.2.1(this));
          AppMethodBeat.o(54347);
          return;
        }
      }
      finally
      {
        localCursor.close();
        AppMethodBeat.o(54347);
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.c.e.2
 * JD-Core Version:    0.7.0.1
 */