package com.tencent.mm.plugin.clean.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.vfs.i;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b
  implements Runnable
{
  private List<String> nND;
  private List<com.tencent.mm.plugin.clean.c.c> nNE;
  private com.tencent.mm.plugin.clean.c.b nNF;
  private long nNG = 0L;
  
  public b(List<String> paramList, List<com.tencent.mm.plugin.clean.c.c> paramList1, com.tencent.mm.plugin.clean.c.b paramb)
  {
    this.nND = paramList;
    this.nNE = paramList1;
    this.nNF = paramb;
  }
  
  private String bel()
  {
    AppMethodBeat.i(22771);
    String str = hashCode();
    AppMethodBeat.o(22771);
    return str;
  }
  
  private void cF(List<com.tencent.mm.plugin.f.b.a> paramList)
  {
    AppMethodBeat.i(22769);
    int j = paramList.size();
    HashSet localHashSet = new HashSet();
    az.arV();
    long l1 = com.tencent.mm.model.c.afg().rb(Thread.currentThread().getId());
    int i = 0;
    while (i < j)
    {
      com.tencent.mm.plugin.f.b.a locala = (com.tencent.mm.plugin.f.b.a)paramList.get(i);
      long l2 = bt.GC();
      if (!localHashSet.contains(Long.valueOf(locala.field_msgId)))
      {
        az.arV();
        bl localbl = com.tencent.mm.model.c.apO().rm(locala.field_msgId);
        if ((localbl.field_msgId != 0L) && (!localbl.eMl()))
        {
          com.tencent.mm.plugin.f.b localb = com.tencent.mm.plugin.f.b.bHc();
          long l3 = locala.field_msgId;
          localb.nph = true;
          localb.npg.add(Long.valueOf(l3));
          ad.d("MicroMsg.CalcWxService", "%d lock msg change [%d] [%s]", new Object[] { Integer.valueOf(localb.hashCode()), Long.valueOf(l3), bt.eGN() });
          localbl.eMm();
          az.arV();
          com.tencent.mm.model.c.apO().a(locala.field_msgId, localbl);
        }
        localHashSet.add(Long.valueOf(locala.field_msgId));
        ad.d("MicroMsg.DeleteFileByWxIndex", "%s deleteByIndex handle msg[%d]", new Object[] { bel(), Long.valueOf(bt.aS(l2)) });
      }
      if ((locala != null) && (!com.tencent.mm.plugin.f.a.yK(locala.field_msgSubType)) && (locala.field_size > 0L))
      {
        this.nNG += locala.field_size;
        i.deleteFile(g.afB().gcV + locala.field_path);
        locala.field_path = "";
        locala.field_size = 0L;
        com.tencent.mm.plugin.f.b.bHc().bHd().update(locala.systemRowid, locala, false);
      }
      ad.d("MicroMsg.DeleteFileByWxIndex", "%s deleteByIndex[%d]", new Object[] { bel(), Long.valueOf(bt.aS(l2)) });
      i += 1;
    }
    az.arV();
    com.tencent.mm.model.c.afg().mX(l1);
    AppMethodBeat.o(22769);
  }
  
  public final void run()
  {
    AppMethodBeat.i(22770);
    int j;
    int i;
    long l1;
    if (this.nND != null)
    {
      long l5 = bt.GC();
      j = this.nND.size();
      Iterator localIterator2 = this.nND.iterator();
      i = 0;
      while (localIterator2.hasNext())
      {
        String str1 = (String)localIterator2.next();
        if (!bt.isNullOrNil(str1))
        {
          long l6 = bt.GC();
          PLong localPLong1 = new PLong();
          PLong localPLong2 = new PLong();
          Object localObject4 = com.tencent.mm.plugin.f.b.bHc().bHd();
          l1 = bt.GC();
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
              ad.printErrStackTrace("MicroMsg.WxFileIndexStorage", localException, " sql [%s]", new Object[] { str2 });
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
          ad.i("MicroMsg.WxFileIndexStorage", "getNoThumbMediaMsgTimeByUsername [%s] cost[%d]", new Object[] { str1, Long.valueOf(bt.aS(l1)) });
          localPLong2.value -= 1L;
          long l3 = localPLong1.value;
          l2 = Math.max(l3 - 2592000000L, localPLong2.value);
          l1 = l2;
          if (l2 == l3) {
            l1 = l2 - 1L;
          }
          localObject1 = com.tencent.mm.plugin.f.b.bHc().bHd().v(str1, l3, l1);
          l3 = ((List)localObject1).size() + 0L;
          cF((List)localObject1);
          for (l2 = l1; l2 > localPLong2.value; l2 = l1)
          {
            long l4 = Math.max(l2 - 2592000000L, localPLong2.value);
            l1 = l4;
            if (l4 == l2) {
              l1 = l4 - 1L;
            }
            localObject1 = com.tencent.mm.plugin.f.b.bHc().bHd().v(str1, l2, l1);
            l3 += ((List)localObject1).size();
            cF((List)localObject1);
          }
          label485:
          ad.i("MicroMsg.DeleteFileByWxIndex", "%s deleteByName [%s] [%d] [%d %d] cost[%d]", new Object[] { bel(), str1, Long.valueOf(l3), Long.valueOf(localPLong2.value), Long.valueOf(localPLong1.value), Long.valueOf(bt.aS(l6)) });
        }
        i += 1;
        if (this.nNF != null) {
          this.nNF.eT(i, j);
        }
      }
      if (this.nNF != null) {
        this.nNF.nX(this.nNG);
      }
      com.tencent.mm.plugin.f.b.bHc().bHh();
      ad.i("MicroMsg.DeleteFileByWxIndex", "%s deleteByUsername cost[%d]", new Object[] { bel(), Long.valueOf(bt.aS(l5)) });
      AppMethodBeat.o(22770);
      return;
    }
    if (this.nNE != null)
    {
      l1 = bt.GC();
      j = this.nNE.size();
      Iterator localIterator1 = this.nNE.iterator();
      i = 0;
      while (localIterator1.hasNext())
      {
        cF(((com.tencent.mm.plugin.clean.c.c)localIterator1.next()).nNL);
        i += 1;
        if (this.nNF != null) {
          this.nNF.eT(i, j);
        }
      }
      if (this.nNF != null) {
        this.nNF.nX(this.nNG);
      }
      com.tencent.mm.plugin.f.b.bHc().bHh();
      ad.i("MicroMsg.DeleteFileByWxIndex", "%s deleteByNewAnalyseItem cost[%d]", new Object[] { bel(), Long.valueOf(bt.aS(l1)) });
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