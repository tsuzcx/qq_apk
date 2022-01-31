package com.tencent.mm.plugin.clean.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.clean.c.i;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b
  implements Runnable
{
  private com.tencent.mm.plugin.clean.c.h kGA;
  private long kGu = 0L;
  private List<String> kGy;
  private List<i> kGz;
  
  public b(List<String> paramList, List<i> paramList1, com.tencent.mm.plugin.clean.c.h paramh)
  {
    this.kGy = paramList;
    this.kGz = paramList1;
    this.kGA = paramh;
  }
  
  private String bas()
  {
    AppMethodBeat.i(18662);
    String str = hashCode();
    AppMethodBeat.o(18662);
    return str;
  }
  
  private void bj(List<com.tencent.mm.plugin.f.b.a> paramList)
  {
    AppMethodBeat.i(18660);
    int j = paramList.size();
    HashSet localHashSet = new HashSet();
    aw.aaz();
    long l1 = c.Rq().kr(Thread.currentThread().getId());
    int i = 0;
    while (i < j)
    {
      com.tencent.mm.plugin.f.b.a locala = (com.tencent.mm.plugin.f.b.a)paramList.get(i);
      long l2 = bo.yB();
      if (!localHashSet.contains(Long.valueOf(locala.field_msgId)))
      {
        aw.aaz();
        bi localbi = c.YC().kB(locala.field_msgId);
        if ((localbi.field_msgId != 0L) && (!localbi.dyc()))
        {
          com.tencent.mm.plugin.f.b localb = com.tencent.mm.plugin.f.b.bak();
          long l3 = locala.field_msgId;
          localb.kke = true;
          localb.kkd.add(Long.valueOf(l3));
          ab.d("MicroMsg.CalcWxService", "%d lock msg change [%d] [%s]", new Object[] { Integer.valueOf(localb.hashCode()), Long.valueOf(l3), bo.dtY() });
          localbi.dyd();
          aw.aaz();
          c.YC().a(locala.field_msgId, localbi);
        }
        localHashSet.add(Long.valueOf(locala.field_msgId));
        ab.d("MicroMsg.DeleteFileByWxIndex", "%s deleteByIndex handle msg[%d]", new Object[] { bas(), Long.valueOf(bo.av(l2)) });
      }
      if ((locala != null) && (!com.tencent.mm.plugin.f.a.sR(locala.field_msgSubType)) && (locala.field_size > 0L))
      {
        this.kGu += locala.field_size;
        com.tencent.mm.vfs.e.deleteFile(g.RL().eHQ + locala.field_path);
        locala.field_path = "";
        locala.field_size = 0L;
        com.tencent.mm.plugin.f.b.bak().bal().update(locala.systemRowid, locala, false);
      }
      ab.d("MicroMsg.DeleteFileByWxIndex", "%s deleteByIndex[%d]", new Object[] { bas(), Long.valueOf(bo.av(l2)) });
      i += 1;
    }
    aw.aaz();
    c.Rq().nY(l1);
    AppMethodBeat.o(18660);
  }
  
  public final void run()
  {
    AppMethodBeat.i(18661);
    int j;
    int i;
    long l1;
    if (this.kGy != null)
    {
      long l5 = bo.yB();
      j = this.kGy.size();
      Iterator localIterator2 = this.kGy.iterator();
      i = 0;
      while (localIterator2.hasNext())
      {
        String str1 = (String)localIterator2.next();
        if (!bo.isNullOrNil(str1))
        {
          long l6 = bo.yB();
          PLong localPLong1 = new PLong();
          PLong localPLong2 = new PLong();
          Object localObject4 = com.tencent.mm.plugin.f.b.bak().bal();
          l1 = bo.yB();
          String str2 = "select max(msgtime), min(msgtime) from WxFileIndex2 where username='" + str1 + "' and msgSubType in (1,20,23,30,32,34 ) and size > 0 ";
          Object localObject3 = null;
          Object localObject1 = null;
          try
          {
            localObject4 = ((com.tencent.mm.plugin.f.b.b)localObject4).db.rawQuery(str2, null);
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
              ab.printErrStackTrace("MicroMsg.WxFileIndexStorage", localException, " sql [%s]", new Object[] { str2 });
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
            AppMethodBeat.o(18661);
          }
          ab.i("MicroMsg.WxFileIndexStorage", "getNoThumbMediaMsgTimeByUsername [%s] cost[%d]", new Object[] { str1, Long.valueOf(bo.av(l1)) });
          localPLong2.value -= 1L;
          long l3 = localPLong1.value;
          l2 = Math.max(l3 - 2592000000L, localPLong2.value);
          l1 = l2;
          if (l2 == l3) {
            l1 = l2 - 1L;
          }
          localObject1 = com.tencent.mm.plugin.f.b.bak().bal().q(str1, l3, l1);
          l3 = ((List)localObject1).size() + 0L;
          bj((List)localObject1);
          for (l2 = l1; l2 > localPLong2.value; l2 = l1)
          {
            long l4 = Math.max(l2 - 2592000000L, localPLong2.value);
            l1 = l4;
            if (l4 == l2) {
              l1 = l4 - 1L;
            }
            localObject1 = com.tencent.mm.plugin.f.b.bak().bal().q(str1, l2, l1);
            l3 += ((List)localObject1).size();
            bj((List)localObject1);
          }
          label485:
          ab.i("MicroMsg.DeleteFileByWxIndex", "%s deleteByName [%s] [%d] [%d %d] cost[%d]", new Object[] { bas(), str1, Long.valueOf(l3), Long.valueOf(localPLong2.value), Long.valueOf(localPLong1.value), Long.valueOf(bo.av(l6)) });
        }
        i += 1;
        if (this.kGA != null) {
          this.kGA.dY(i, j);
        }
      }
      if (this.kGA != null) {
        this.kGA.iv(this.kGu);
      }
      com.tencent.mm.plugin.f.b.bak().bap();
      ab.i("MicroMsg.DeleteFileByWxIndex", "%s deleteByUsername cost[%d]", new Object[] { bas(), Long.valueOf(bo.av(l5)) });
      AppMethodBeat.o(18661);
      return;
    }
    if (this.kGz != null)
    {
      l1 = bo.yB();
      j = this.kGz.size();
      Iterator localIterator1 = this.kGz.iterator();
      i = 0;
      while (localIterator1.hasNext())
      {
        bj(((i)localIterator1.next()).kHd);
        i += 1;
        if (this.kGA != null) {
          this.kGA.dY(i, j);
        }
      }
      if (this.kGA != null) {
        this.kGA.iv(this.kGu);
      }
      com.tencent.mm.plugin.f.b.bak().bap();
      ab.i("MicroMsg.DeleteFileByWxIndex", "%s deleteByNewAnalyseItem cost[%d]", new Object[] { bas(), Long.valueOf(bo.av(l1)) });
      AppMethodBeat.o(18661);
      return;
    }
    AppMethodBeat.o(18661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.b.b
 * JD-Core Version:    0.7.0.1
 */