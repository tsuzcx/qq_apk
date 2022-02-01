package com.tencent.mm.plugin.clean.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b
  implements Runnable
{
  private List<String> wRA;
  private List<com.tencent.mm.plugin.clean.c.c> wRB;
  private com.tencent.mm.plugin.clean.c.b wRC;
  private long wRD = 0L;
  
  public b(List<String> paramList, List<com.tencent.mm.plugin.clean.c.c> paramList1, com.tencent.mm.plugin.clean.c.b paramb)
  {
    this.wRA = paramList;
    this.wRB = paramList1;
    this.wRC = paramb;
  }
  
  private String bNL()
  {
    AppMethodBeat.i(22771);
    String str = hashCode();
    AppMethodBeat.o(22771);
    return str;
  }
  
  private void eU(List<com.tencent.mm.plugin.calcwx.b.a> paramList)
  {
    AppMethodBeat.i(22769);
    int k = paramList.size();
    HashSet localHashSet = new HashSet();
    bh.bCz();
    long l1 = com.tencent.mm.model.c.getDataDB().beginTransaction(Thread.currentThread().getId());
    int i = 0;
    if (i < k)
    {
      com.tencent.mm.plugin.calcwx.b.a locala = (com.tencent.mm.plugin.calcwx.b.a)paramList.get(i);
      long l2 = Util.currentTicks();
      if (!localHashSet.contains(Long.valueOf(locala.field_msgId)))
      {
        bh.bCz();
        cc localcc = com.tencent.mm.model.c.bzD().sl(locala.field_msgId);
        if ((localcc != null) && (localcc.field_msgId != 0L) && (!localcc.isClean()))
        {
          com.tencent.mm.plugin.calcwx.a locala1 = com.tencent.mm.plugin.calcwx.a.diz();
          long l3 = locala.field_msgId;
          locala1.wbg = true;
          locala1.wbf.add(Long.valueOf(l3));
          Log.d("MicroMsg.CalcWxService", "%d lock msg change [%d] [%s]", new Object[] { Integer.valueOf(locala1.hashCode()), Long.valueOf(l3), Util.getStack() });
          localcc.kLj |= 0x1;
          localcc.jTR = true;
          bh.bCz();
          com.tencent.mm.model.c.bzD().a(locala.field_msgId, localcc);
        }
        localHashSet.add(Long.valueOf(locala.field_msgId));
        Log.d("MicroMsg.DeleteFileByWxIndex", "%s deleteByIndex handle msg[%d]", new Object[] { bNL(), Long.valueOf(Util.ticksToNow(l2)) });
      }
      if (locala != null)
      {
        j = locala.field_msgSubType;
        if ((j != 2) && (j != 21) && (j != 22) && (j != 4) && (j != 24) && (j != 25) && (j != 31) && (j != 33) && (j != 35) && (j != 37) && (j != 38)) {
          break label475;
        }
      }
      label475:
      for (int j = 1;; j = 0)
      {
        if ((j == 0) && (locala.field_size > 0L))
        {
          this.wRD += locala.field_size;
          y.deleteFile(com.tencent.mm.kernel.h.baE().mCI + locala.field_path);
          locala.field_path = "";
          locala.field_size = 0L;
          com.tencent.mm.plugin.calcwx.a.diz().diA().update(locala.systemRowid, locala, false);
        }
        Log.d("MicroMsg.DeleteFileByWxIndex", "%s deleteByIndex[%d]", new Object[] { bNL(), Long.valueOf(Util.ticksToNow(l2)) });
        i += 1;
        break;
      }
    }
    bh.bCz();
    com.tencent.mm.model.c.getDataDB().endTransaction(l1);
    AppMethodBeat.o(22769);
  }
  
  public final void run()
  {
    AppMethodBeat.i(22770);
    int j;
    int i;
    long l1;
    if (this.wRA != null)
    {
      long l5 = Util.currentTicks();
      j = this.wRA.size();
      Iterator localIterator2 = this.wRA.iterator();
      i = 0;
      while (localIterator2.hasNext())
      {
        String str1 = (String)localIterator2.next();
        if (!Util.isNullOrNil(str1))
        {
          long l6 = Util.currentTicks();
          PLong localPLong1 = new PLong();
          PLong localPLong2 = new PLong();
          Object localObject4 = com.tencent.mm.plugin.calcwx.a.diz().diA();
          l1 = Util.currentTicks();
          String str2 = "select max(msgtime), min(msgtime) from WxFileIndex2 where username='" + str1 + "' and msgSubType in (1,20,23,3,30,32,34,36 ) and size > 0 ";
          Object localObject3 = null;
          Object localObject1 = null;
          try
          {
            localObject4 = ((com.tencent.mm.plugin.calcwx.b.b)localObject4).db.rawQuery(str2, null);
            if (localObject4 != null)
            {
              localObject1 = localObject4;
              localObject3 = localObject4;
              if (((Cursor)localObject4).moveToFirst())
              {
                localObject1 = localObject4;
                localObject3 = localObject4;
                localPLong1.value = ((Cursor)localObject4).getLong(0);
                localObject1 = localObject4;
                localObject3 = localObject4;
                localPLong2.value = ((Cursor)localObject4).getLong(1);
              }
            }
            if (localObject4 != null) {
              ((Cursor)localObject4).close();
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              long l2;
              localObject3 = localObject1;
              Log.printErrStackTrace("MicroMsg.WxFileIndexStorage", localException, " sql [%s]", new Object[] { str2 });
              if (localObject1 != null) {
                ((Cursor)localObject1).close();
              }
            }
          }
          finally
          {
            if (localObject3 == null) {
              break label485;
            }
            localObject3.close();
            AppMethodBeat.o(22770);
          }
          Log.i("MicroMsg.WxFileIndexStorage", "getNoThumbMediaMsgTimeByUsername [%s] cost[%d]", new Object[] { str1, Long.valueOf(Util.ticksToNow(l1)) });
          localPLong2.value -= 1L;
          long l3 = localPLong1.value;
          l2 = Math.max(l3 - 2592000000L, localPLong2.value);
          l1 = l2;
          if (l2 == l3) {
            l1 = l2 - 1L;
          }
          localObject1 = com.tencent.mm.plugin.calcwx.a.diz().diA().x(str1, l3, l1);
          l3 = ((List)localObject1).size() + 0L;
          eU((List)localObject1);
          for (l2 = l1; l2 > localPLong2.value; l2 = l1)
          {
            long l4 = Math.max(l2 - 2592000000L, localPLong2.value);
            l1 = l4;
            if (l4 == l2) {
              l1 = l4 - 1L;
            }
            localObject1 = com.tencent.mm.plugin.calcwx.a.diz().diA().x(str1, l2, l1);
            l3 += ((List)localObject1).size();
            eU((List)localObject1);
          }
          label485:
          Log.i("MicroMsg.DeleteFileByWxIndex", "%s deleteByName [%s] [%d] [%d %d] cost[%d]", new Object[] { bNL(), str1, Long.valueOf(l3), Long.valueOf(localPLong2.value), Long.valueOf(localPLong1.value), Long.valueOf(Util.ticksToNow(l6)) });
        }
        i += 1;
        if (this.wRC != null) {
          this.wRC.gC(i, j);
        }
      }
      if (this.wRC != null) {
        this.wRC.kF(this.wRD);
      }
      com.tencent.mm.plugin.calcwx.a.diz().diF();
      Log.i("MicroMsg.DeleteFileByWxIndex", "%s deleteByUsername cost[%d]", new Object[] { bNL(), Long.valueOf(Util.ticksToNow(l5)) });
      AppMethodBeat.o(22770);
      return;
    }
    if (this.wRB != null)
    {
      l1 = Util.currentTicks();
      j = this.wRB.size();
      Iterator localIterator1 = this.wRB.iterator();
      i = 0;
      while (localIterator1.hasNext())
      {
        eU(((com.tencent.mm.plugin.clean.c.c)localIterator1.next()).wRI);
        i += 1;
        if (this.wRC != null) {
          this.wRC.gC(i, j);
        }
      }
      if (this.wRC != null) {
        this.wRC.kF(this.wRD);
      }
      com.tencent.mm.plugin.calcwx.a.diz().diF();
      Log.i("MicroMsg.DeleteFileByWxIndex", "%s deleteByNewAnalyseItem cost[%d]", new Object[] { bNL(), Long.valueOf(Util.ticksToNow(l1)) });
      AppMethodBeat.o(22770);
      return;
    }
    AppMethodBeat.o(22770);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.b.b
 * JD-Core Version:    0.7.0.1
 */