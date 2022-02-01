package com.tencent.mm.plugin.clean.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.vfs.i;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b
  implements Runnable
{
  private List<String> oqF;
  private List<com.tencent.mm.plugin.clean.c.c> oqG;
  private com.tencent.mm.plugin.clean.c.b oqH;
  private long oqI = 0L;
  
  public b(List<String> paramList, List<com.tencent.mm.plugin.clean.c.c> paramList1, com.tencent.mm.plugin.clean.c.b paramb)
  {
    this.oqF = paramList;
    this.oqG = paramList1;
    this.oqH = paramb;
  }
  
  private String blf()
  {
    AppMethodBeat.i(22771);
    String str = hashCode();
    AppMethodBeat.o(22771);
    return str;
  }
  
  private void cH(List<com.tencent.mm.plugin.f.b.a> paramList)
  {
    AppMethodBeat.i(22769);
    int j = paramList.size();
    HashSet localHashSet = new HashSet();
    az.ayM();
    long l1 = com.tencent.mm.model.c.agw().vE(Thread.currentThread().getId());
    int i = 0;
    while (i < j)
    {
      com.tencent.mm.plugin.f.b.a locala = (com.tencent.mm.plugin.f.b.a)paramList.get(i);
      long l2 = bs.Gn();
      if (!localHashSet.contains(Long.valueOf(locala.field_msgId)))
      {
        az.ayM();
        bo localbo = com.tencent.mm.model.c.awD().vP(locala.field_msgId);
        if ((localbo.field_msgId != 0L) && (!localbo.fbQ()))
        {
          com.tencent.mm.plugin.f.b localb = com.tencent.mm.plugin.f.b.bOp();
          long l3 = locala.field_msgId;
          localb.nSh = true;
          localb.nSg.add(Long.valueOf(l3));
          ac.d("MicroMsg.CalcWxService", "%d lock msg change [%d] [%s]", new Object[] { Integer.valueOf(localb.hashCode()), Long.valueOf(l3), bs.eWi() });
          localbo.fbR();
          az.ayM();
          com.tencent.mm.model.c.awD().a(locala.field_msgId, localbo);
        }
        localHashSet.add(Long.valueOf(locala.field_msgId));
        ac.d("MicroMsg.DeleteFileByWxIndex", "%s deleteByIndex handle msg[%d]", new Object[] { blf(), Long.valueOf(bs.aO(l2)) });
      }
      if ((locala != null) && (!com.tencent.mm.plugin.f.a.zA(locala.field_msgSubType)) && (locala.field_size > 0L))
      {
        this.oqI += locala.field_size;
        i.deleteFile(g.agR().ghB + locala.field_path);
        locala.field_path = "";
        locala.field_size = 0L;
        com.tencent.mm.plugin.f.b.bOp().bOq().update(locala.systemRowid, locala, false);
      }
      ac.d("MicroMsg.DeleteFileByWxIndex", "%s deleteByIndex[%d]", new Object[] { blf(), Long.valueOf(bs.aO(l2)) });
      i += 1;
    }
    az.ayM();
    com.tencent.mm.model.c.agw().qL(l1);
    AppMethodBeat.o(22769);
  }
  
  public final void run()
  {
    AppMethodBeat.i(22770);
    int j;
    int i;
    long l1;
    if (this.oqF != null)
    {
      long l5 = bs.Gn();
      j = this.oqF.size();
      Iterator localIterator2 = this.oqF.iterator();
      i = 0;
      while (localIterator2.hasNext())
      {
        String str1 = (String)localIterator2.next();
        if (!bs.isNullOrNil(str1))
        {
          long l6 = bs.Gn();
          PLong localPLong1 = new PLong();
          PLong localPLong2 = new PLong();
          Object localObject4 = com.tencent.mm.plugin.f.b.bOp().bOq();
          l1 = bs.Gn();
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
              ac.printErrStackTrace("MicroMsg.WxFileIndexStorage", localException, " sql [%s]", new Object[] { str2 });
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
          ac.i("MicroMsg.WxFileIndexStorage", "getNoThumbMediaMsgTimeByUsername [%s] cost[%d]", new Object[] { str1, Long.valueOf(bs.aO(l1)) });
          localPLong2.value -= 1L;
          long l3 = localPLong1.value;
          l2 = Math.max(l3 - 2592000000L, localPLong2.value);
          l1 = l2;
          if (l2 == l3) {
            l1 = l2 - 1L;
          }
          localObject1 = com.tencent.mm.plugin.f.b.bOp().bOq().s(str1, l3, l1);
          l3 = ((List)localObject1).size() + 0L;
          cH((List)localObject1);
          for (l2 = l1; l2 > localPLong2.value; l2 = l1)
          {
            long l4 = Math.max(l2 - 2592000000L, localPLong2.value);
            l1 = l4;
            if (l4 == l2) {
              l1 = l4 - 1L;
            }
            localObject1 = com.tencent.mm.plugin.f.b.bOp().bOq().s(str1, l2, l1);
            l3 += ((List)localObject1).size();
            cH((List)localObject1);
          }
          label485:
          ac.i("MicroMsg.DeleteFileByWxIndex", "%s deleteByName [%s] [%d] [%d %d] cost[%d]", new Object[] { blf(), str1, Long.valueOf(l3), Long.valueOf(localPLong2.value), Long.valueOf(localPLong1.value), Long.valueOf(bs.aO(l6)) });
        }
        i += 1;
        if (this.oqH != null) {
          this.oqH.eW(i, j);
        }
      }
      if (this.oqH != null) {
        this.oqH.rJ(this.oqI);
      }
      com.tencent.mm.plugin.f.b.bOp().bOu();
      ac.i("MicroMsg.DeleteFileByWxIndex", "%s deleteByUsername cost[%d]", new Object[] { blf(), Long.valueOf(bs.aO(l5)) });
      AppMethodBeat.o(22770);
      return;
    }
    if (this.oqG != null)
    {
      l1 = bs.Gn();
      j = this.oqG.size();
      Iterator localIterator1 = this.oqG.iterator();
      i = 0;
      while (localIterator1.hasNext())
      {
        cH(((com.tencent.mm.plugin.clean.c.c)localIterator1.next()).oqN);
        i += 1;
        if (this.oqH != null) {
          this.oqH.eW(i, j);
        }
      }
      if (this.oqH != null) {
        this.oqH.rJ(this.oqI);
      }
      com.tencent.mm.plugin.f.b.bOp().bOu();
      ac.i("MicroMsg.DeleteFileByWxIndex", "%s deleteByNewAnalyseItem cost[%d]", new Object[] { blf(), Long.valueOf(bs.aO(l1)) });
      AppMethodBeat.o(22770);
      return;
    }
    AppMethodBeat.o(22770);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.b.b
 * JD-Core Version:    0.7.0.1
 */